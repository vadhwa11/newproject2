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
<label> Section</label> 
<select id="sectionId"	name="sectionId" validate="Section Name,string,no" onblur="submitProtoAjaxWithDivName(this.form.name,'/hms/hms/stores?method=getCategoryList&section='+this.value,'categoryDiv');" 	tabindex=1>
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


	

</div>

<div id="categoryDiv">
<label>Item Category</label>
<select name="categoryId" id="categoryId"  >
	<option value="0">Select</option>
</select>
<label>Item Class</label>
<select name="classId" id="classId"   >
	<option value="0">Select</option>
</select>

</div>	
 