package c00_generic_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * [#&64;WebServlet 註解配置] -java 中寫 html
 * 
 * @author cano.su
 * @since 2022/02/28
 */
@WebServlet(name = "SecondServlet", urlPatterns = "/servlet/second")
public class SecondServlet extends GenericServlet {

    private static final long serialVersionUID = -8808136467473451698L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 回應設定成 html, 非一般字串
        res.setContentType("text/html");
        // 產生頁面
        PrintWriter jsp = res.getWriter();
        jsp.println("<!DOCTYPE html>");
        jsp.println("<html lang=\"en\">");
        jsp.println("<head>");
        jsp.println("  <meta charset=\"UTF-8\">");
        jsp.println("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        jsp.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        jsp.println("</head>");
        jsp.println("<body>");
        jsp.println("  <h2>Hello Second World</h2>");
        jsp.println("  <br>");
        jsp.println("  <a href=\".\\first\">to First World</a>");
        jsp.println("</body>");
        jsp.println("</html>");
        jsp.close();
    }
}
