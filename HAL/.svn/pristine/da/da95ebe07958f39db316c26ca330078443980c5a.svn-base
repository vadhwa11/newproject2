<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	String age = "";
	if(map.get("age") != null){
		age = (String)map.get("age");
		System.out.println("responce jsp  -----"+age);
%>

<input id="idForAge" type="text" name="ageLabel" value="<%=age %>"
	style="display: block;" readonly="readonly" MAXLENGTH="15" />

<div id="tempId1" style="float: left; display: none;"><select
	id="ageId1" name="<%=AGE%>" validate="Age,string,no"
	style="width: 50px;">
	<option value="">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select></div>
<div id="tempId2" style="float: left; display: none;"><select
	id="ageUnitId" name="<%=AGE_UNIT %>" validate="AgeUnit,string,no"
	style="width: 60px;">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>
</div>
<%}%>