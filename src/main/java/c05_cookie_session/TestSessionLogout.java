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
 * [Session B頁] -登出
 * 
 * @author cano.su
 * @since 2022/03/10
 */
@WebServlet(urlPatterns = "/servlet/session/logout")
public class TestSessionLogout extends HttpServlet {

    private static final long serialVersionUID = 7056898153605495324L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 移除登入資料
        session.removeAttribute(TestSessionLoginValid.KEY_ACCT);
        session.removeAttribute(TestSessionLoginValid.KEY_PWD);
        // message 設定
        session.setAttribute(TestSessionLoginValid.KEY_MSG, Message.L002);
        // 重導向至 登入頁
        resp.sendRedirect("../session");
    }
}
