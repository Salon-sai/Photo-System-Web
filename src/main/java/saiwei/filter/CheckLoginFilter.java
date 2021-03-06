package saiwei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author sai
 *
 */
public class CheckLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		if(url.endsWith("login.jsp") || url.endsWith("register.action")){
			chain.doFilter(request, response);
			return ;
		}else if(url.endsWith("user/")){
			req.getRequestDispatcher("/user/home.jsp").forward(request, response);
			return ;
		}else if(url.endsWith("")){
			
		}
		if(null != session.getAttribute("user")){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect(req.getContextPath());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
