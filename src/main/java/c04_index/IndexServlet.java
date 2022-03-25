package c04_index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.URLInfo;
import data.enums.URLs;

/**
 * [導向 JSP 頁面]
 * 
 * @author cano.su
 * @since 2022/02/28
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = -645878020496326397L;

    public void doHandle(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        // 取得所有頁面資料
        List<URLInfo> urlInfoList = new ArrayList<>();
        for (URLs url : URLs.values())
            urlInfoList.add(URLInfo.of(url));
        req.setAttribute("urlInfoList", urlInfoList);

        // 傳導到指定目的，使用分派器分派物件給 JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }
}
