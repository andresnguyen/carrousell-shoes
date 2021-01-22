package thuongnguyen.it78.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import thuongnguyen.it78.configs.JavaMail;
import thuongnguyen.it78.daos.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/forgot")
public class ForgotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // lấy ra email
        String email = req.getParameter("email");

        // kiểm tra email đó có tồn tại trong db không? nếu không thì return
        if(!AccountDAO.checkEmail(email)) {
            String error = " Tên email này không tồn tại trong hệ thống. Hãy thử tên khác.";
            req.setAttribute("error", error);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/views/forget-pw.jsp").forward(req, res);
            return;
        }
        // giá trị password mặc định. set cứng
        final String newPassword = "123456789";

        // kiểm tra xem gửi mail thành công hay chưa
        boolean isSuccess = JavaMail.send(email,"New PassWord", newPassword);

        // nếu không thành công báo lỗi về user và return
        if(!isSuccess) {
            String error = "Thất bại, vui lòng thử lại.";
            req.setAttribute("error", error);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/views/forget-pw.jsp").forward(req, res);
            return;
        }

        // nếu thành công thì update lại password mới và báo thành công và return

        // nhưng lúc update không thành công thì gửi lỗi về cho người dùng và thông báo
        if(!new AccountDAO().updatePassword(email, DigestUtils.md5Hex(newPassword))) {
            String error = "Thất bại, vui lòng thử lại.";
            req.setAttribute("error", error);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/views/forget-pw.jsp").forward(req, res);
            return;
        }

        // trả về thành công cho người dùng
        String success = "Thành công!. Vui lòng kiểm tra mail của bạn.";
        req.setAttribute("success", success);
        req.getRequestDispatcher("/views/forget-pw.jsp").forward(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/views/forget-pw.jsp").forward(req, res);

    }
}

