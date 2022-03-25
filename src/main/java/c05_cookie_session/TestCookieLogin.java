package c05_cookie_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.enums.Message;

/**
 * [Cookie A頁]
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/cookie/login")
public class TestCookieLogin extends HttpServlet {

    private static final long serialVersionUID = 7056898153605495324L;

    /** 登入驗證 */
    private TestCookieLoginValid loginValid = new TestCookieLoginValid();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLogin = loginValid.isCookieLogin(req);
        if (isLogin) {
            req.getRequestDispatcher("/WEB-INF/views/cookie_a_page.jsp").forward(req, resp);
        } else {
            System.out.println("請先登入");
            // message 設定
            Cookie cookieMsg = new Cookie(TestCookieLoginValid.KEY_MSG, Message.L001.name());
            cookieMsg.setMaxAge(5);
            resp.addCookie(cookieMsg);
            // 重導向至 登入頁
            resp.sendRedirect("../cookie");
        }
    }
}
