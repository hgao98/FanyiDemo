package translate.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import translate.demo.http.HttpUtil;
import translate.demo.pojo.TranslateResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class TranslateAPI {
    public static void getTransResult(String query, HttpServletRequest request) {
        String url = "https://fanyi.baidu.com/sug";
        HttpUtil http = new HttpUtil();

        JSONObject json = new JSONObject();
        json.put("kw", query);
        String postResult = HttpUtil.doPost(url, json.toJSONString());
        JSONObject resJson = JSON.parseObject(postResult);

        List<TranslateResult> retList = new ArrayList<>();
        if(resJson.containsKey("data")){
            //有翻译结果
            JSONArray jsonArray = resJson.getJSONArray("data");
            for(int i=0; i<jsonArray.size(); i++){
                JSONObject row = jsonArray.getJSONObject(i);
                String src = (String)row.get("k");
                String ret = (String)row.get("v");
                TranslateResult tr = new TranslateResult(src, ret);
                retList.add(tr);
            }
        }

        //添加到HttpSession
        HttpSession session = request.getSession();
        session.setAttribute("resultList", retList);

//        return resJson.toJSONString();
    }
}
