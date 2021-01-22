package thuongnguyen.it78.api;

import com.google.gson.Gson;
import thuongnguyen.it78.daos.ShoesDAO;
import thuongnguyen.it78.models.Shoes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/pagination")
public class PaginationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // tạo ra một listShoes có id là shoesID
        ArrayList<Shoes> listShoes;



        // filter

        // mặc định của tất cả giá trị
        int category = 0;
        int price = 0;
        int size = 0;
        int gender = 0;
        int page = 1;
        int limit = 12;
        String sort = null;


        // lấy ra các tham số truyền vào
        String categoryParams = req.getParameter("category");
        String priceParams = req.getParameter("price");
        String sizeParams = req.getParameter("size");
        String genderParams = req.getParameter("gender");
        String sortParams = req.getParameter("sort");
        String pageParams = req.getParameter("page");


        if(pageParams != null) page = Integer.parseInt(pageParams);

        // nếu pageParams khác null thì set lại
        if(categoryParams != null) category = Integer.parseInt(categoryParams);

        // nếu pageParams khác null thì set lại
        if(priceParams != null) price = Integer.parseInt(priceParams);

        // nếu pageParams khác null thì set lại
        if(sizeParams != null) size = Integer.parseInt(sizeParams);

        // nếu pageParams khác null thì set lại
        if(genderParams != null) gender = Integer.parseInt(genderParams);

        // nếu pageParams khác null thì set lại
        if(sortParams != null) sort = sortParams;


        int start = (page - 1) * limit;

        listShoes = ShoesDAO.getListShoes(category, price, size, gender, sort, start, limit);



        // set giá trị trả về là json
        res.setContentType("application/json");

        // set return json
        Gson gson = new Gson();
        System.out.println("response");

        // return ra list json
        PrintWriter pw = res.getWriter();
        pw.println(gson.toJson(listShoes));
    }
}
