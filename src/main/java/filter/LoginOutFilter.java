package filter;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		ServletContext context = getServletContext();
		
		//SSO 移除此帳號
		if(session.getAttribute("user") != null && context.getAttribute("users") != null) {
			User user = (User)session.getAttribute("user");
			Set<User> users = (LinkedHashSet<User>)context.getAttribute("users");
			System.out.println("users 移除前 : " + users);
			users.remove(user); //記得在 User 物件要加入 equals 與 hashCode()
			System.out.println("users 移除後 : " + users);
			context.setAttribute("users", users); //回存
			
		}
		
		session.invalidate();
		/*RequestDispatcher rd = req.getRequestDispatcher("/form/login.jsp");
		rd.forward(req, res);*/
		res.sendRedirect(getServletContext().getContextPath() + "/servlet/cart");
	}
}
