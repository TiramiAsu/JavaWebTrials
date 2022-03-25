package data.enums;

/**
 * [所有 URL]
 * 
 * @author cano.su
 * @since 2022/03/07
 */
public enum URLs {

    FIFTH_SERVLET_PAGE("將 html 獨立出來 - HTML", "/servlet/fifth?type=html"), //
    FIFTH_SERVLET_PAGE2("將 html 獨立出來 - JSP", "/servlet/fifth?type=jsp"), //

    JSP_PAGE("JSP", "/servlet/jsp"), //
    JSP_AND_JSTL("JSP 與 JSTL", "/servlet/jstl"), //

    HTTPSERVLET_GET("HttpServlet- GET", "/httpservlet?method=get"), //
    HTTPSERVLET_POST("HttpServlet- POST", "/httpservlet?method=post"), //
    TO_PAGE_PARAM_NO_JSTL("Java 傳送參數給前端 JSP 頁面 - 無使用 jstl", "/servlet/to_page_param_no_jstl"), //
    TO_PAGE_PATAM_JSTL("Java 傳送參數給前端 JSP 頁面 - 使用 jstl", "/servlet/to_page_param_jstl?name=CANO"), //

    COOKIE_LOGIN("Cookie 登入頁", "/servlet/cookie"), //
    COOKIE_A_PAGE("Cookie A頁", "/servlet/cookie/login"), //
    SESSION_LOGIN("Session 登入頁", "/servlet/session"), //
    SESSION_B_PAGE("Session B頁", "/servlet/session/login") //
    ;

    /** 頁面名稱 */
    private String pageName;
    /** servlet 路徑 */
    private String urlPattern;

    private URLs(String pageName, String urlPattern) {
        this.pageName = pageName;
        this.urlPattern = urlPattern;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

}
