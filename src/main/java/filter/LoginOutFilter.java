package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

@WebFilter(value = {"/logout"})
public class LoginOutFilter extends HttpFilter{
	private UserDao userDao = new UserDao();
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//是否有 user 的 session 的物件資料
		HttpSession session = req.getSession(false);
		session.invalidate();
		/*RequestDispatcher rd = req.getRequestDispatcher("/form/login.jsp");
		rd.forward(req, res);*/
		res.sendRedirect(getServletContext().getContextPath() + "/servlet/cart");
	}
}
