package c02_httpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [轉發與重定向2]
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/fandr_err")
public class ForwardAndRedirectErr extends HttpServlet {

    private static final long serialVersionUID = -2872367184696557899L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "重定向至錯誤頁");
        req.getRequestDispatcher("/WEB-INF/views/forward_and_redirect_page_error.jsp").forward(req, resp);
    }
}
