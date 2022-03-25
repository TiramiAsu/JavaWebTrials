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
 * [Session B頁]
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/session/login")
public class TestSessionLogin extends HttpServlet {

    private static final long serialVersionUID = 7056898153605495324L;

    /** 登入驗證 */
    private TestSessionLoginValid loginValid = new TestSessionLoginValid();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogin = loginValid.isSessionLogin(session);
        if (isLogin) {
            session.removeAttribute(TestSessionLoginValid.KEY_MSG);
            req.getRequestDispatcher("/WEB-INF/views/session_b_page.jsp").forward(req, resp);
        } else {
            System.out.println("請先登入");
            // message 設定
            session.setAttribute(TestSessionLoginValid.KEY_MSG, Message.L001);
            // 重導向至 登入頁
            resp.sendRedirect("../session");
        }
    }
}
