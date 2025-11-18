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

@WebServlet(urlPatterns = { "/createTopic", "/createReply" })
public class PostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User user = (User) req.getSession().getAttribute("currentUser");

		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}

		String action = req.getServletPath();
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		if (action.equals("/createTopic")) {
			ForumService.getInstance().addTopic(title, content, user);
			resp.sendRedirect("listTopics.jsp");

		} else if (action.equals("/createReply")) {
			long topicId = Long.parseLong(req.getParameter("topicId"));
			ForumService.getInstance().addReply(topicId, title, content, user);
			resp.sendRedirect("showTopic.jsp?id=" + topicId);
		}
	}
}