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
List<MasStoreSection> masStoreSectionList= new ArrayList<MasStoreSection>();
if(map.get("masStoreSectionList") !=null){
	masStoreSectionList=(List<MasStoreSection>)map.get("masStoreSectionList");
}
%>

<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<div id="testDiv">
<label>Section</label> 
<select id="sectionId"	name="<%= SECTION_ID %>" validate="Section Name,string,no" onblur="submitProtoAjaxWithDivName('actualStockReport','/hms/hms/stores?method=getCategoryGList&section='+this.value,'categoryDiv');" 	tabindex=1>
<%	if(masStoreSectionList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masStoreSectionList.iterator(); iterator.hasNext();) {
					 MasStoreSection ds = (MasStoreSection) iterator.next();
				  %>
				  <option value="<%=ds.getId ()%>"><%=ds.getSectionName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<div id= "categoryDiv">
<label>Class</label> 
<select	name="<%= ITEM_CLASS_ID %>" id="<%=ITEM_CLASS_ID %>" validate="Class Name,string,no"	tabindex=1>
	<option value="0">No Data</option>
</select>


<label>Category</label> 
<select	name="<%= ITEM_CATEGORY_ID %>" id="<%=ITEM_CATEGORY_ID %>" validate="Category,string,no"	tabindex=1>
	<option value="0">No Data</option>
</select>


</div>

	
<div class="clear"></div>
</div>



