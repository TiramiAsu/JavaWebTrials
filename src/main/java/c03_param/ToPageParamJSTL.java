package c03_param;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import data.Item;

/**
 * [透過 url 傳參數給 JSP 頁面]
 * 
 * @author cano.su
 * @since 2022/02/28
 */
@WebServlet(urlPatterns = "/servlet/to_page_param_jstl")
public class ToPageParamJSTL extends GenericServlet {

    private static final long serialVersionUID = -8592630467711665129L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 傳導到指定目的，使用分派器分派物件給 JSP
        req.setAttribute("newSetName", "CANO");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/to_page_param_jstl.jsp");
        rd.forward(req, res);
    }
}
