package data.enums;

/**
 * [訊息]
 * 
 * @author cano.su
 * @since 2022/03/16
 */
public enum Message {

    /** 請先登入 */
    L001("請先登入"),
    /** 已登出 */
    L002("已登出"),

    /** 登入帳號或密碼錯誤 */
    E001("登入帳號或密碼錯誤");

    private String msg;

    private Message(String msg) {
        this.msg = msg;
    }

    public static Message of(String label) {
        for (Message msg : Message.values())
            if (msg.name().equals(label))
                return msg;
        return null;
    }

    public String getMsg() {
        return msg;
    }

}
