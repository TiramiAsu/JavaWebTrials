package c03_param;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * [傳參數給 JSP 頁面 -無 jstl]
 * 
 * @author cano.su
 * @since 2022/02/28
 */
@WebServlet(urlPatterns = "/servlet/to_page_param_no_jstl")
public class ToPageParamNoJSTL extends GenericServlet {

    private static final long serialVersionUID = 3242086313616207625L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 設定參數
        req.setAttribute("name", "CANO");
        // 傳導到指定目的，使用分派器分派物件給 JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/to_page_param_no_jstl.jsp");
        rd.forward(req, res);
    }
}
