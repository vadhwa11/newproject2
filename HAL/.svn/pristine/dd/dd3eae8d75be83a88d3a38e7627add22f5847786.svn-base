<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasItemType> masItemTypeList= new ArrayList<MasItemType>();
if(map.get("masItemTypeList") !=null){
	masItemTypeList=(List<MasItemType>)map.get("masItemTypeList");
}
%>

<div id="nameDiv">
<label> Item Type</label>
<select id="itemTypeId"	name="itemTypeId"  tabindex=1 onblur="submitProtoAjaxWithDivName(this.form.name,'/hms/hms/stores?method=getSectionList&itemType='+this.value,'testDiv');" tabindex=1>
<%	if(masItemTypeList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masItemTypeList.iterator(); iterator.hasNext();) {
					 MasItemType itemType = (MasItemType) iterator.next();
				  %>
				  <option value="<%=itemType.getId ()%>"><%=itemType.getItemTypeName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


<div id="testDiv">

<label>Item Section</label> 
<select id="sectionId"	name="sectionId" tabindex=1>
<option value="0">No Data</option>
</select>


<label>Item Category</label>
<select name="categoryId" id="categoryId"   >
	<option value="0">Select</option>
</select>
<label>Item Class</label>
<select name="classId" id="classId"  >
	<option value="0">Select</option>
</select>

</div>	
	
<div class="clear"></div>
</div>
 