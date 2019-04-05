<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * grn1.jsp
 * Purpose of the JSP -
 * @author  Abha

 * Revision Date:
 * Revision By:
 * @version 1.8
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script>

   function cancelForm(){
   	   close();
   }

</script> <%

Map<String,Object> map = new HashMap<String,Object>();

int subTestId=0;

	if (request.getAttribute("map") != null)
	{
	map = (Map<String,Object>) request.getAttribute("map");
	}

if(map.get("subTestId")!=null){
	subTestId =Integer.parseInt(""+map.get("subTestId"));
}
	List<DgFixedValue> fixedList=new ArrayList<DgFixedValue>();
	if (map.get("fixedList") != null) {
		fixedList = (List<DgFixedValue>)map.get("fixedList");
	}

	%>


<title>Fixed Value</title>

<form name="fixed" method="post" action="">
<div class="clear"></div>

<%
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

	if(map.get("subTestId")!=null){
		subTestId =Integer.parseInt(""+map.get("subTestId"));
	}
	if(map.get("message") != null)
	{
	 	 String message = (String)map.get("message");
	 	 %>
<h4><span><%=message %></span></h4>
<%} %> <%
		if(fixedList.size()>0){
			for(int i=0;i<fixedList.size();i++){
			DgFixedValue dgFixed = fixedList.get(i);
		%> <input type="hidden" value="<%=subTestId %>" id="<%=SUBTEST_ID %>"
	name="<%=SUBTEST_ID%>" readonly="readonly" /> <label>Fixed
Values</label>
<%if(dgFixed.getFixedValue()!=null){ %>
<input type="text" name="<%=FIXED_VALUE %>"	value="<%=dgFixed.getFixedValue() %>" id="<%=FIXED_VALUE %>"
	class="textbox_size20" maxlength="20" validate="Fixed Value,string,yes"
	tabindex="1" />
	<%-- <%if(dgFixed.getNormalValue() !=null && dgFixed.getNormalValue().equals("y")){ %>
	<input type="radio" name=<%=FIXED_NORMAL_VALUE %> id="normalValueId1" value="1" onclick="disableRadio();" checked="checked"/>
	<%}else{ %>
	<input type="radio" name=<%=FIXED_NORMAL_VALUE %> id="normalValueId1" value="1" onclick="disableRadio();" disabled="disabled"/>
	<%} %> --%>
	<%}else{ %>
	<input type="text" name="<%=FIXED_VALUE %>"	value="" id="<%=FIXED_VALUE %>"
	class="textbox_size20" maxlength="20" validate="Fixed Value,string,no"
	tabindex="1" />
	<input type="radio" name=<%=FIXED_NORMAL_VALUE %> id="normalValueId1" value="1" onclick="disableRadio();" disabled="disabled"/>
	<%}if(dgFixed.getId()!=null){ %>
	<input type="hidden" name="<%=FIXED_ID %>" value="<%=dgFixed.getId() %>" id="<%=FIXED_ID %>" />
	<%}else{%>
	<input type="hidden" name="<%=FIXED_ID %>" value="" id="<%=FIXED_ID %>" />
	<% }%>
<div class="clear"></div>
<%}}%>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit"
	class="button"
	onclick="submitForm('fixed','investigation?method=updateFixedValues');"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onclick="cancelForm();"
	accesskey="a" tabindex=1 />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<script type="text/javascript">
function disableRadio(){
		var normalValueId ;
		for(var i=1;i<=8;i++){
	if(document.getElementById('normalValueId'+i).checked == false){
	document.getElementById('normalValueId'+i).disabled = true;
	}
 
}
}
</script>