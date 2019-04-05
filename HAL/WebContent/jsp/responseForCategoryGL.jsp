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

<label><span>*</span>Class</label>
<select name="<%=ITEM_CLASS_ID %>" id="classId" validate="Item Class,String,yes" onchange="displayBagQuantity(this.value)"  >
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
<label>Category</label>
<select name="<%=ITEM_CATEGORY_ID %>" id="<%=ITEM_CATEGORY_ID %>" validate="Item Category,String,no" >
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
 <div id="bagDiv" style="display: none">
<label><span>*</span>Bag Capacity(In ml)</label>
<input type="text"	id="BagQuantityId" name="BagQuantity" value="" 
validate="Bag Quantity,string,no" MAXLENGTH="50" style="width: 60px;" 	maxlength="3"  tabindex=1 />

</div> 
	
<div class="clear"></div>
</div>

 <!-- <script language="javascript">
function displayBagQuantity(value){
	alert(value);
	alert("hii");
	var calssSelect = document.getElementById("classId");
	var classText = calssSelect.options[calssSelect.selectedIndex].text;
	alert(classText);
}
</script> -->
 
