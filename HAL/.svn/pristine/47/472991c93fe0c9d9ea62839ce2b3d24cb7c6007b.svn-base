<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>

<%

String deptName="&nbsp;";

Date manu  = null;
Date expiry = null;




	Map<String, Object> map = new HashMap<String, Object>();


	String message = "";
	String manufacturer = "";
	String url = "";



	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	List objectList = new ArrayList();
	if (map.get("objectList2") != null) {
		objectList = (List)map.get("objectList2");

	}

	if(map.get("expiryDate") !=null){
		 expiry = (Date)map.get("expiryDate");
		}
		if(map.get("manufacturingDate") !=null){
			manu = (Date) map.get("manufacturingDate");
			}
		if(map.get("manufacturer") !=null){
			manufacturer =""+ map.get("manufacturer");
			}




%>
<div id="testDiv">
<div class="clear"></div>
			<label>DOM</label>
			<% if(manu == null){ %>
			<input type="text" value="" id="manufactureDate" name="manufactureDate"/>
			<%}else{ %>
			<input type="text" value="<%=HMSUtil.changeDateToddMMyyyy((Date)manu )%>" id="manufactureDate" name="manufactureDate"/>
			<%}%>
			<label>DOE</label>
			
			<input type="text" value="<%=HMSUtil.changeDateToddMMyyyy((Date)expiry) %>" id="expiryDate" name="expiryDate"/>
			<label>Manufacturer</label>
			<input type="text" value="<%=manufacturer %>" id="manuf" name="manuf"/>

			<div class="clear"></div>
		
<table id="main">
	<thead>
		<tr>
			<th>Date</th>
			<!--<th>Voucher No.</th>
			--><th>Opening Balance</th>
			<th>Receipt</th>
			<th>Issue</th>
			<th>Balance</th>

		</tr>
	</thead>

	<% if(objectList.size()>0){int r=0;
		for(int i=0; i<objectList.size() ; i++){
			Object[]	ob=(Object[])objectList.get(i);

			r= r+((BigDecimal)ob[2]).intValue()+((BigDecimal)ob[5]).intValue();
			 int closing=r-((BigDecimal)ob[3]).intValue();
			 r=closing;
			 if(((BigDecimal)ob[5]).compareTo(new BigDecimal(0))>0 || ((BigDecimal)ob[2]).compareTo(new BigDecimal(0))>0  || ((BigDecimal)ob[3]).compareTo(new BigDecimal(0))>0 ){
			%>


<tr>
<td><input type="text" value="<%= HMSUtil.changeDateToddMMyyyy((Date)ob[0])%>" name="dt" id="dt" readonly="readonly"/></td>
<!--<td><input type="text" value="<%=ob[1]%>" name="doc" id="doc" readonly="readonly"/></td>
--><td><input type="text" value="<%=ob[5]%>" name="opening" id="opening" readonly="readonly"/></td>
<td><input type="text" value="<%=ob[2]%>" name="rcpt" id="rcpt" readonly="readonly"/></td>
<td><input type="text" value="<%=ob[3]%>" name="issue" id="issue" readonly="readonly"/></td>
<td><input type="text" value="<%=r%>" name="bal" id="bal" readonly="readonly"/></td> 
<!-- <td><input type="text" value="<%=ob[4]%>" name="bal" id="bal" readonly="readonly"/></td>-->
</tr>
<%}
		}} %>

</table>
</div>