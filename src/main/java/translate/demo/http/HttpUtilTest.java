package translate.demo.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.Charset;

public class HttpUtilTest {
    public static void main(String[] args) throws Exception {
        String url = "https://fanyi.baidu.com/sug";
        HttpUtil http = new HttpUtil();

        System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet();

        System.out.println("\nTesting 2 - Send Http POST request");
//        http.sendPost("apple");

        JSONObject json = new JSONObject();
        System.out.println("\u82f9");
        System.out.println(new String("\u82f9".getBytes(), "UTF-8"));
//        json.put("key", "==g43sEvsUcbcunFv3mHkIzlHO4iiUIT R7WwXuSVKTK0yugJnZSlr6qNbxsL8OqCUAFyCDCoRKQ882m6cTTi0q9uCJsq JJvxS+8mZVRP/7lWfEVt8/N9mKplUA68SWJEPSXyz4MDeFam766KEyvqZ99d");
        json.put("kw", "apple");
        String postResult = HttpUtil.doPost(url, json.toJSONString());
        JSONObject resJson = JSON.parseObject(postResult);


        System.out.println("系统默认编码：" + System.getProperty("file.encoding")); //查询结果GBK
        //系统默认字符编码
        System.out.println("系统默认字符编码：" + Charset.defaultCharset()); //查询结果GBK
        //操作系统用户使用的语言
        System.out.println("系统默认语言：" + System.getProperty("user.language")); //查询结果zh

        System.out.println("postResult：" + getEncoding(postResult));
        System.out.println("json转换：" + getEncoding(resJson.toJSONString()));
    }

    public static String getEncoding(String str) {
        String encode;

        encode = "UTF-16";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch (Exception ex) {
        }

        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch (Exception ex) {
        }

        encode = "ASCII";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";
            }
        } catch (Exception ex) {
        }

        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch (Exception ex) {
        }

        encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch (Exception ex) {
        }

        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch (Exception ex) {
        }

        /*
         *......待完善
         */

        return "未识别编码格式";
    }
}
