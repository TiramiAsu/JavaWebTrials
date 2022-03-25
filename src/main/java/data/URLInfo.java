package data;

import data.enums.URLs;

/**
 * [URL 資訊]
 * 
 * @author cano.su
 * @since 2022/03/07
 */
public class URLInfo {

    /** 頁面名稱 */
    private String pageName;
    /** servlet 路徑 */
    private String urlPattern;

    public static URLInfo of(URLs url) {
        return new URLInfo() //
                .setPageName(url.getPageName()) //
                .setUrlPattern(url.getUrlPattern());
    }

    public String getPageName() {
        return pageName;
    }

    public URLInfo setPageName(String pageName) {
        this.pageName = pageName;
        return this;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public URLInfo setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
        return this;
    }

    @Override
    public String toString() {
        return "URLInfo [pageName=" + pageName + ", urlPattern=" + urlPattern + "]";
    }

}
