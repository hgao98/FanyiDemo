package translate.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TranslateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取要翻译的单词
        String src = request.getParameter("src");

        //调用百度翻译，结果放入session中
        TranslateAPI.getTransResult(src, request);

        //thymeleaf模板
        super.processTemplate("index",request,response);
    }
}
