package c01_jsp_jstl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import data.Item;
import data.enums.FifthType;

/**
 * [將 html 獨立出來]
 * 
 * @author cano.su
 * @since 2022/03/07
 */
@WebServlet(urlPatterns = "/servlet/fifth")
public class FifthServlet extends GenericServlet {

    private static final long serialVersionUID = 3312751897906554194L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 取得 type
        FifthType type = FifthType.of(req.getParameter("type"));

        if (type == null) {
            // 1 返回內容
            res.setContentType("text/html;charset=UTF-8");
            String msg = "無對應 type !! [type=" + type + "]";
            PrintWriter jsp = res.getWriter();
            jsp.println(msg);
            jsp.close();

            // 2 拋出 exception
            throw new ServletException("無對應 type !! [type=" + type + "]");
        }

        /* 確認所帶參數沒問題, 再往下走邏輯 */

        // 計算商業邏輯
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            itemList.add(new Item(i + 1, "項目" + (i + 1)));

        // 回傳頁面
        RequestDispatcher rd;

        if (type.isHTML()) {
            // 傳導到指定目的，使用分派器分派物件給 html -> 無法傳值
            rd = req.getRequestDispatcher("/WEB-INF/views/fifth_servlet_page.html");
            rd.forward(req, res);
        }

        if (type.isJSP()) {
            // 傳導到指定目的，使用分派器分派物件給 JSP
            req.setAttribute("itemList", itemList);
            rd = req.getRequestDispatcher("/WEB-INF/views/fifth_servlet_page2.jsp");
            // PrintWriter 與 RequestDispatcher 物件不可並存,
            // 會出現 Cannot forward after response has been committed 異常
            rd.forward(req, res);
        }
    }

}
