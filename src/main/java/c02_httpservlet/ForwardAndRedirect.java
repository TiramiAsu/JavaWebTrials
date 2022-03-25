package c02_httpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * [轉發與重定向]
 * 
 * <pre>
 * -forward: 轉發 -> URL 會變
 * -redirect: 重定向 -> URL 不會變
 * </pre>
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/fandr")
public class ForwardAndRedirect extends HttpServlet {

    private static final long serialVersionUID = 3487245172447008664L;
    private final String KEY = "k";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/forward_and_redirect_page_%s.jsp";
        String msg = "????";
        try {
            if (req.getParameter(KEY) == null)
                throw new IllegalArgumentException();

            // 無異常, 轉發至 success page
            boolean isA = toBoolean(req.getParameter(KEY));
            url = String.format(url, isA ? "successA" : "successB");
            msg = String.format("轉發至成功頁 %s", (isA ? "A" : "B"));
        } catch (IllegalArgumentException iae) {
            // 無參數, 轉發至 index
            url = String.format(url, "index");
            msg = "轉發至首頁";
        } catch (Exception e) {
            // 有異常, 重定向至 error page
            e.printStackTrace();
            resp.sendRedirect("./fandr_err"); // 導向 servlet
//            resp.sendRedirect(req.getServletContext().getContextPath() + "/index.html"); // 導向 "WEB-INF 外" 的指定頁面
            return;
        }
        req.setAttribute("msg", msg);

//        RequestDispatcher rd = req.getRequestDispatcher(url);
//        rd.forward(req, resp);
        req.getRequestDispatcher(url).forward(req, resp);
    }

    /**
     * [轉換 boolean 值] -故意拋出錯誤
     * 
     * @author cano.su
     * @since 2022/03/16
     */
    private boolean toBoolean(String value) throws Exception {
        if (!("TRUE".equals(value.toUpperCase()) || "FALSE".equals(value.toUpperCase())))
            throw new Exception("value 非 boolean 無法轉換 [value=" + value + "]");
        return Boolean.valueOf(value); // 非 boolean 字串會回 false
    }
}
