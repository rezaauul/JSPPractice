package com.home.sevlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.entity.User;
import com.home.service.Authenticate;

public class MainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestParam = req.getParameter("pageName");
		String redirect="";
		if(requestParam!=null&&!requestParam.equals("")&&requestParam.equalsIgnoreCase("second")){
			redirect = "/WEB-INF/second.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(redirect);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User u = new User();
		u.setName(req.getParameter("Name"));
		u.setPass(req.getParameter("pass"));
		String redirect="";
		HttpSession session = req.getSession(true);
		Authenticate au = new Authenticate();
		String auth = au.authenticate(u);
		if(auth!=null&&!auth.equals("")&&!auth.equals("fail")){
			session.setAttribute("userObj", u);
			redirect = "/WEB-INF/success.jsp";
		}
		else if(auth!=null&&!auth.equals("")&&auth.equals("fail")){
			session.setAttribute("name", u.getName());
			redirect = "/WEB-INF/error.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(redirect);
		rd.forward(req, resp);
	}
	

}
