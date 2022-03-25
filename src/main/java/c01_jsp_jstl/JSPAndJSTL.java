package c01_jsp_jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import data.Item;

/**
 * [JSP 與 JSTL] : JavaServer Pages Standard Tag Library
 * </pre>
 * 
 * @author cano.su
 * @since 2022/03/07
 */
@WebServlet(urlPatterns = "/servlet/jstl")
public class JSPAndJSTL extends GenericServlet {

    private static final long serialVersionUID = 4963512191836171901L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 計算商業邏輯
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            itemList.add(new Item(i + 1, "項目" + (i + 1)));

        // 回傳頁面
        // 傳導到指定目的，使用分派器分派物件給 JSP
        req.setAttribute("itemList", itemList);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/jsp_and_jstl_page.jsp");
        rd.forward(req, res);
    }

}
