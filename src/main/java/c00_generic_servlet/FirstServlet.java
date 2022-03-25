package c00_generic_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * [web.xml 配置的 Servlet]
 * 
 * @author cano.su
 * @since 2022/02/28
 */
public class FirstServlet extends GenericServlet {

    private static final long serialVersionUID = -9157643702877104190L;

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 產生頁面
        PrintWriter jsp = res.getWriter();
        jsp.println("<h1>Hello First World</h1>");
        jsp.close();
    }
}
