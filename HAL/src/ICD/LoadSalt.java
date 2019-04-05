package ICD;


import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;

public class LoadSalt implements Filter {
	
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws IOException, ServletException {
// Assume its HTTP
HttpServletRequest httpReq = (HttpServletRequest) request;
// Check the user session for the salt cache, if none is present we create one

//Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>)
//httpReq.getSession().getAttribute("csrftoken");

System.out.println(httpReq.getRequestURL()+"<<<url");
String ref = httpReq.getHeader("Referer");
System.out.println(ref+"<<<ref");
if(ref==null ){
	chain.doFilter(request, response);
	
}else if(ref.contains("showInstructionJsp") || ref.contains("showLoginJsp")|| ref.toLowerCase().contains("jsp") || ref.contains("logout")){
	chain.doFilter(request, response);}
else{
	String urll = ""+httpReq.getRequestURL();
	if(urll.toLowerCase().contains("jsp") || !urll.contains("jsp")){
		chain.doFilter(request, response);
	}else{
	String csrfToken =(String) httpReq.getSession().getAttribute("csrfToken");
	String ReqcsrfToken =(String) httpReq.getParameter("csrfToken");
	System.out.println("<<<r3ef");
System.out.println(csrfToken+"  "+ReqcsrfToken);
if (csrfToken.equals(ReqcsrfToken)){
	
	chain.doFilter(request, response);
	
}

else{
	throw new IOException();
	//RequestDispatcher rd=httpReq.getRequestDispatcher( httpReq.getSession().getServletContext().getRealPath("error.jsp"));
	//rd.forward(request, response);
	
}
}
	
}



}

@Override
public void init(FilterConfig filterConfig) throws ServletException {
}

@Override
public void destroy() {
}




}
