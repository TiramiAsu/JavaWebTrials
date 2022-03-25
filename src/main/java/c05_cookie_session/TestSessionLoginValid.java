package c05_cookie_session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import data.enums.Message;

/**
 * [登入檢查]
 * 
 * @author cano.su
 * @since 2022/03/17
 */
public class TestSessionLoginValid {

    public static final String KEY_ACCT = "acct";
    public static final String KEY_PWD = "pwd";
    public static final String KEY_MSG = "msg";
    private static final Map<String, String> userMap = new HashMap<>();

    static {
        userMap.put("qwer", "123");
        userMap.put("asdf", "123");
        userMap.put("zxcv", "123");
    }

    /**
     * [session 驗證是否可登入]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public boolean isSessionLogin(HttpSession session) {
        String acct = String.valueOf(session.getAttribute(KEY_ACCT));
        String pwd = String.valueOf(session.getAttribute(KEY_PWD));
        return isLogin(acct, pwd);
    }

    /**
     * [帳密 驗證是否可登入]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public boolean isLogin(String acct, String pwd) {
        if (acct == null || "".equals(acct))
            return false;
        if (pwd == null || "".equals(pwd))
            return false;
        String currentPwd = userMap.get(acct);
        return currentPwd != null && currentPwd.equals(pwd);
    }

    /**
     * [帳密 新增至 session]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public void addSessionWithAcctAndPwd(HttpSession session, String acct, String pwd) {
        session.setAttribute(TestSessionLoginValid.KEY_ACCT, acct);
        session.setAttribute(TestSessionLoginValid.KEY_PWD, pwd);
    }

    /**
     * [是否 帳密均為空]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public boolean isAcctAndPwdEmpty(String acct, String pwd) {
        boolean isAcctEmpty = (acct == null || "".equals(acct));
        boolean isPwdEmpty = (pwd == null || "".equals(pwd));
        return (isAcctEmpty && isPwdEmpty);
    }

    /**
     * [取得 session 中 msg]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public String getSessionMsg(HttpSession session) {
        Message message = (Message) session.getAttribute(KEY_MSG);
        if (message != null)
            return message.getMsg();
        return null;
    }
}
