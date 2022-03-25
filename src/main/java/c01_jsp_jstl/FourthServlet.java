package c01_jsp_jstl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import data.Item;

/**
 * [html 頁面顯示參數]
 * 
 * @author cano.su
 * @since 2022/03/07
 */
@WebServlet(name = "FourthServlet", urlPatterns = "/servlet/fourth")
public class FourthServlet extends GenericServlet {

    private static final long serialVersionUID = -5181491293874309258L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 計算商業邏輯
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            itemList.add(new Item(i + 1, "項目" + (i + 1)));

        // 回應設定成 html, 非一般字串
        res.setContentType("text/html;charset=UTF-8");
        // 產生頁面
        PrintWriter jsp = res.getWriter();
        jsp.println("<!DOCTYPE html>");
        jsp.println("<html lang=\"en\">");
        jsp.println("<head>");
        jsp.println("  <meta charset=\"UTF-8\">");
        jsp.println("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        jsp.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        jsp.println("  <style>");
        jsp.println("    td {");
        jsp.println("      border: solid 1px");
        jsp.println("    }");
        jsp.println("  </style>");
        jsp.println("</head>");
        jsp.println("<body>");
        jsp.println("  <h3>Hello Fourth World</h3>");
        jsp.println("  <br>");

        // table
        jsp.println("  <table>");
        jsp.println("    <tr>");
        jsp.println("      <td>編號</td>");
        jsp.println("      <td>名稱</td>");
        jsp.println("    </tr>");
        for (Item item : itemList) {
            jsp.println("  <tr>");
            jsp.println("    <td>" + item.getNo() + "</td>");
            jsp.println("    <td>" + item.getName() + "</td>");
            jsp.println("  </tr>");
        }
        jsp.println("  </table>");

        jsp.println("</body>");
        jsp.println("</html>");
        jsp.close();
    }
}
