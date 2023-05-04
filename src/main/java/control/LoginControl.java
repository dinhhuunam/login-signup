package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.DAO;
import entity.Account;


@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DAO dao = new DAO();
		Account a = dao.login(username, password);
		if (a==null) {
			request.setAttribute("mess","Wrong user or pass");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
