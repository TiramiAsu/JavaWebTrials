package c05_cookie_session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.enums.Message;

/**
 * [登入檢查]
 * 
 * @author cano.su
 * @since 2022/03/17
 */
public class TestCookieLoginValid {

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
     * [cookie 驗證是否可登入]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public boolean isCookieLogin(HttpServletRequest req) {
        String acct = "";
        String pwd = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (KEY_ACCT.equals(cookie.getName()))
                acct = cookie.getValue();
            if (KEY_PWD.equals(cookie.getName()))
                pwd = cookie.getValue();
        }
        return isLogin(acct, pwd);
    }

    /**
     * [取得 cookie 資料]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public String getCookie(HttpServletRequest req, String name) {
        if (name == null)
            return null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies)
            if (name.equals(cookie.getName()))
                return cookie.getValue();

        return null;
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
     * [帳密 新增至 cookie]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public void addCookieWithAcctAndPwd(HttpServletResponse resp, String acct, String pwd) {
        Cookie cookieAcct = new Cookie(TestCookieLoginValid.KEY_ACCT, acct);
        Cookie cookiePwd = new Cookie(TestCookieLoginValid.KEY_PWD, pwd);
        cookieAcct.setMaxAge(-1); // 永久
        cookiePwd.setMaxAge(10); // 秒
        resp.addCookie(cookieAcct);
        resp.addCookie(cookiePwd);
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
     * [取得 cookie 中 msg]
     * 
     * @author cano.su
     * @since 2022/03/17
     */
    public String getCookieMsg(HttpServletRequest req) {
        String message = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (KEY_MSG.equals(cookie.getName()))
                message = cookie.getValue();
        }
        Message msg = Message.of(message);
        if (msg == null)
            return null;
        return msg.getMsg();
    }
}
