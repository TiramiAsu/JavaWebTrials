package c03_param;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [透過 Ajax 傳參數給 JSP 頁面]
 * 
 * @author cano.su
 * @since 2022/02/28
 */
@WebServlet(urlPatterns = "/servlet/to_servlet_ajax")
public class ToServletRequestAjax extends HttpServlet {

    private static final long serialVersionUID = -8592630467711665129L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("GET 收到名字: " + name);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/to_servlet_ajax.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("POST 收到名字: " + name);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/to_servlet_ajax.jsp");
        rd.forward(req, resp);
    }

}
