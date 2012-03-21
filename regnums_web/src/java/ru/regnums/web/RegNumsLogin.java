package ru.regnums.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Servlet implementation class RegNumsLogin
 */
@WebServlet("/RegNumsLogin")
public class RegNumsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String SUCCESS_URL = "";
	private static String ERROR_URL = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegNumsLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
    	SUCCESS_URL = getServletConfig().getInitParameter("SUCCESS_URL");
    	ERROR_URL = getServletConfig().getInitParameter("ERROR_URL");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject currentUser = SecurityUtils.getSubject();
		String user_name = getParameter("username", request);
		String pswd = getParameter("password", request);
		if(!currentUser.isAuthenticated() && user_name.length() > 0 && pswd.length() > 0){
			try
			{
				UsernamePasswordToken token = new UsernamePasswordToken(user_name, pswd);
				currentUser.login(token);
				response.sendRedirect(SUCCESS_URL);
			} catch ( UnknownAccountException uae ) {
				request.getSession().setAttribute("error_message", "Не верно указаны имя пользователя и пароль");
				response.sendRedirect(ERROR_URL);
			} catch ( IncorrectCredentialsException ice ) {
				request.getSession().setAttribute("error_message", "Не верно указаны имя пользователя и пароль");
				response.sendRedirect(ERROR_URL);
			} catch ( LockedAccountException lae ) {
				request.getSession().setAttribute("error_message", "Ваш аккаунт заблокирован.");
				response.sendRedirect(ERROR_URL);
			}
		}
	}
	
	protected String getParameter(String par_name,HttpServletRequest request){
		String res = "";
		if(request.getParameter(par_name) != null){
			res = request.getParameter(par_name);
		}
		return res;
	}
}
