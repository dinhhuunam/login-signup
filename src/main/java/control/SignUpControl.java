package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.DAO;
import entity.Account;


@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("re_pass");
		String contact = request.getParameter("contact");
		if(!pass.equals(re_pass)) {
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}else {
			DAO dao = new DAO();
			Account a=dao.checkAccountExist(user);
			if (a==null) {
				//được sign up
				dao.signup(user, email, pass, contact);
				response.sendRedirect("login.jsp");
			}else {
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
		}
	}

}