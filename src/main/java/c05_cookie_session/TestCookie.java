package c05_cookie_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.enums.Message;

/**
 * [Cookie 登入頁]
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/cookie")
public class TestCookie extends HttpServlet {

    private static final long serialVersionUID = 7056898153605495324L;

    /** 登入驗證 */
    private TestCookieLoginValid loginValid = new TestCookieLoginValid();

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLogin = loginValid.isCookieLogin(req);
        if (isLogin) {
            System.out.println("cookie 驗證成功, 重導向至 A頁");
            resp.sendRedirect("./cookie/login"); // 重導向至 A頁
            return;
        }

        String acct = req.getParameter(TestCookieLoginValid.KEY_ACCT);
        String pwd = req.getParameter(TestCookieLoginValid.KEY_PWD);
        String msg = "";

        // 帳密為空, 直接轉發 登入頁
        if (loginValid.isAcctAndPwdEmpty(acct, pwd)) {
            System.out.println("帳密為空, 直接轉發 登入頁");
            msg = loginValid.getCookieMsg(req);
            if (msg != null)
                req.setAttribute("msg", msg);
            req.getRequestDispatcher("/WEB-INF/views/cookie_login_page.jsp").forward(req, resp);
            req.getSession().removeAttribute(TestSessionLoginValid.KEY_MSG); // 避免被 Session 練習影響
            return;
        }

        // *驗證輸入帳號密碼 */

        isLogin = loginValid.isLogin(acct, pwd);

        if (isLogin) {
            System.out.println("成功登入!!");
            loginValid.addCookieWithAcctAndPwd(resp, acct, pwd);
            resp.sendRedirect("./cookie/login");
            return;
        }

        // 帳號密碼錯誤
        System.out.println("登入失敗!!");
        msg = Message.E001.getMsg();
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("/WEB-INF/views/cookie_login_page.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("cookie GET");
        handle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("cookie POST");
        handle(req, resp);
    }
}
