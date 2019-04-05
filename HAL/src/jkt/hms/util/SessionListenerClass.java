package jkt.hms.util;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SessionListenerClass implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent hse) {
		/*HttpSession session = hse.getSession();
		ServletContext sc = session.getServletContext();
		String UserName = (String)session.getAttribute("userName");
		String UserIp = (String)session.getAttribute("userIp");
		storeUserNameIp(UserName,UserIp,sc);*/
		
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		ServletContext sc = session.getServletContext();
		//System.out.println("::in session distroy ");
		removeUserNameAndIp(session,sc);		
	}
	public void storeUserNameIp(String UserName , String UserIp,ServletContext sc){
		Map<String,String> userlogin = new HashMap<String,String>();
		if(sc.getAttribute("userlogin")!=null)
		{
			userlogin=(Map<String,String>)sc.getAttribute("userlogin");
			//System.out.println("previous userlogin");
		}
		int i=0;
		if(userlogin!=null && userlogin.size()!=0)
		{ i = userlogin.size()/2;
          i++;				
		}else{
			i=1;
		}
		//System.out.println("userlogin.size()::"+userlogin.size()+"::i::"+i);
		userlogin.put("UserName"+i,UserName);
		userlogin.put("UserIp"+i, UserIp);
		sc.setAttribute("userlogin",userlogin);
	}
	public void removeUserNameAndIp(HttpSession session , ServletContext sc ){
		String SessionId = session.getId();
		String previousSessionId =null;
		List<String> UserNameList = null;
		List<String> UserIpList = null;
		List<String> SessionIdList = null;
		List<String> TUserNameList = null;
		List<String> TUserIpList = null;
		List<String> TSessionIdList = null;
		Map<String,String> userlogin = new HashMap<String,String>();
		
		if(sc.getAttribute("UserNameList")!=null && sc.getAttribute("UserIpList")!=null && sc.getAttribute("SessionIdList")!=null){
			UserNameList=(List<String>)sc.getAttribute("UserNameList");
			//TUserNameList=(List<String>)sc.getAttribute("UserNameList");
			UserIpList=(List<String>)sc.getAttribute("UserIpList");
			//TUserIpList=(List<String>)sc.getAttribute("UserIpList");
			SessionIdList=(List<String>)sc.getAttribute("SessionIdList");
			//TSessionIdList=(List<String>)sc.getAttribute("SessionIdList");
			if(UserNameList.size()==UserIpList.size() && SessionIdList.size()==UserIpList.size() && UserNameList.size()==SessionIdList.size()){
			for(int i=0,j=0;i<SessionIdList.size();i++ , j++){
				previousSessionId=(String)SessionIdList.get(i);
				//System.out.println("previousSessionId:::"+i+"::"+previousSessionId);
				//System.out.println("SessionId:::"+i+"::"+SessionId);
				if(previousSessionId.equals(SessionId)){
					//System.out.println("EQUAL");
					UserNameList.remove(i);
					UserIpList.remove(i);
					SessionIdList.remove(i);
					--i;
				}
			}
			//System.out.println("size o ::"+UserNameList.size());
			sc.setAttribute("UserNameList", UserNameList);
			sc.setAttribute("UserIpList", UserIpList);
			sc.setAttribute("SessionIdList", SessionIdList);
			}
			
		}
	}

}
