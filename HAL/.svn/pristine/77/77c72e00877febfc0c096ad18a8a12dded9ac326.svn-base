<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
List<MasItemClass> classList = new ArrayList<MasItemClass>();
if(map.get("categoryList") !=null){
	categoryList=(List<MasItemCategory>)map.get("categoryList");
}
if(map.get("classList") !=null){
	classList=(List<MasItemClass>)map.get("classList");
}
%>

<%@page import="jkt.hms.masters.business.MasStoreSection"%>

<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<div id="categoryDiv">
<label>Item Category</label>
<select name="categoryId" id="categoryId"  >
<%	if(categoryList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = categoryList.iterator(); iterator.hasNext();) {
					 MasItemCategory ds = (MasItemCategory) iterator.next();
				  %>
				  <option value="<%=ds.getId ()%>"><%=ds.getItemCategoryName().trim()%></option>
				  <%
				  	 	}
				   %>
			
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<label>Item Class</label>
<select name="classId" id="classId"   >
<%	if(classList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = classList.iterator(); iterator.hasNext();) {
					 MasItemClass ds = (MasItemClass) iterator.next();
				  %>
				  <option value="<%=ds.getId ()%>"><%=ds.getItemClassName().trim()%></option>
				  <%
				  	 	}
				   %>
			
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


	
<div class="clear"></div>
</div>



