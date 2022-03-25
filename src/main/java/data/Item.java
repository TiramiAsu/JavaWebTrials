package data;

import java.io.Serializable;

/**
 * [項目]
 * 
 * </pre>
 * 
 * @author cano.su
 * @since 2022/03/07
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 6188442667450318068L;

    /** 編號 */
    private Integer no;
    /** 名稱 */
    private String name;

    public Item() {
        super();
    }

    public Item(Integer no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item [no=" + no + ", name=" + name + "]";
    }

}
