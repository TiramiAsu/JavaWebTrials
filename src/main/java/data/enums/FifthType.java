package data.enums;

/**
 * [選擇頁面種類]
 * 
 * @author cano.su
 * @since 2022/03/07
 */
public enum FifthType {
    HTML, JSP;

    public static FifthType of(String type) {
        if (type == null)
            return null;
        if (JSP.name().equals(type.toUpperCase()))
            return JSP;
        if (HTML.name().equals(type.toUpperCase()))
            return HTML;
        return null;
//        // 以下寫法較佳, 預設為 HTML(除了 JSP 外, 其餘為 HTML)
//        if (type == null)
//            return null;
//        if (JSP.name().equals(type.toUpperCase()))
//            return JSP;
//        return HTML;
    }

    public boolean isHTML() {
        return (this == FifthType.HTML);
    }

    public boolean isJSP() {
        return (this == FifthType.JSP);
    }
}
