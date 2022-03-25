package c05_cookie_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.enums.Message;

/**
 * [Session] -會話/令牌
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/session")
public class TestSession extends HttpServlet {

    private static final long serialVersionUID = -5768582657078811078L;

    /** 登入驗證 */
    private TestSessionLoginValid loginValid = new TestSessionLoginValid();

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogin = loginValid.isSessionLogin(session);
        if (isLogin) {
            System.out.println("session 驗證成功, 重導向至 B頁");
            resp.sendRedirect("./session/login"); // 重導向至 B頁
            return;
        }

        String acct = req.getParameter(TestSessionLoginValid.KEY_ACCT);
        String pwd = req.getParameter(TestSessionLoginValid.KEY_PWD);
        String msg = "";

        // 帳密為空, 直接轉發 登入頁
        if (loginValid.isAcctAndPwdEmpty(acct, pwd)) {
            System.out.println("帳密為空, 直接轉發 登入頁");
            msg = loginValid.getSessionMsg(session);
            if (msg != null) {
                req.setAttribute("msg", msg);
                // 用完 session 資料, 要記得移除避免影響後續頁面使用
                req.getSession().removeAttribute(TestSessionLoginValid.KEY_MSG);
            }
            req.getRequestDispatcher("/WEB-INF/views/session_login_page.jsp").forward(req, resp);
            return;
        }

        // *驗證輸入帳號密碼 */

        isLogin = loginValid.isLogin(acct, pwd);

        if (isLogin) {
            System.out.println("成功登入!!");
            loginValid.addSessionWithAcctAndPwd(session, acct, pwd);
            resp.sendRedirect("./session/login");
            return;
        }

        // 帳號密碼錯誤
        System.out.println("登入失敗!!");
        Message message = Message.E001;
        session.setAttribute(TestSessionLoginValid.KEY_MSG, message);
        req.setAttribute("msg", message.getMsg());
        req.getRequestDispatcher("/WEB-INF/views/session_login_page.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("session GET");
        handle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("session POST");
        handle(req, resp);
    }

}
