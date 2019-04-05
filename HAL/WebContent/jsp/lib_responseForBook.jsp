<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List bookList= new ArrayList();
		if(map.get("bookList") != null){
			bookList = (List)map.get("bookList");
		}
%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<ul>
	<%	if(bookList.size() !=0){
	
		for (Iterator iterator = bookList.iterator(); iterator.hasNext();) {
			MasBook masBook = (MasBook)iterator.next();
%>
	<li><%=masBook.getBookName()%>[<%=masBook.getId()%>]</li>

	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



