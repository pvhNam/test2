package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.ForumService;
import beans.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Xử lý Đăng nhập
		String u = req.getParameter("username");
		String p = req.getParameter("password");

		User user = ForumService.getInstance().checkUser(u, p);

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", user);
			resp.sendRedirect("listTopics.jsp");
		} else {
			req.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Xử lý Đăng xuất (Khi click link Thoát)
		String action = req.getServletPath();
		if (action.equals("/logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("login.jsp");
		}
	}
}
