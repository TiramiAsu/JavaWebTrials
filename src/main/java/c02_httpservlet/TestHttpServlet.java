package c02_httpservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [使用 HttpServlet]
 * 
 * @author cano.su
 * @since 2022/03/01
 */
@WebServlet(urlPatterns = { "/httpservlet" })
public class TestHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 5430331765705942818L;

    private static final String GET = "get";
    private static final String POST = "post";
    
    

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 使用 HttpServlet 時, 盡量不覆寫父類別 servet() 方法, 此為演示
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    /**
     * [若 GET 與 POST 做同一件事, 可以這樣寫] -這裡僅演示進入 HttpServlet 後, 會使用 doGet 或 doPost 方法
     * 
     * @author cano.su
     * @since 2022/03/07
     */
    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 以前端取得 url 參數, 模擬 post 從前端傳參數測試(post 傳參數有其他方式發送請求)
        String method = req.getParameter("method");

        // 預設為 GET 資料(假設除了 post 其他都為 get)
        String uri = "/WEB-INF/views/httpservlet_" + GET + "_page.jsp";
        String msg = "取得 " + GET + " 請求!!";

        if (method == null) {
            msg = "method 為 null, 使用預設 GET 方法!!";
            req.setAttribute("msg", msg);
            RequestDispatcher rd = req.getRequestDispatcher(uri);
            rd.forward(req, resp);
            System.err.println(msg);
            return;
        }

        // 若為 POST 則覆蓋所有相關資訊
        if (POST.equals(method.toLowerCase())) {
            uri = "/WEB-INF/views/httpservlet_" + POST + "_page.jsp";
            msg = "模擬取得 " + POST + " 請求!!";
        }

        req.setAttribute("msg", msg);
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
        System.out.println(msg);
    }
}
