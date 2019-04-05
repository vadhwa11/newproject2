<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForHospital.jsp  
 * Purpose of the JSP   This is for Response for Hospital.
 * @author  Ritu
 * Create Date: 29th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.StoreQuotationRequestM"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Object[]> enquiryList = new ArrayList<Object[]>();

	
 if(map.get("enquiryList") != null){
	 
	 enquiryList=(List<Object[]>)map.get("enquiryList");
 }
// out.print("enquiryList="+enquiryList.size());
 

 
%>


<label> Quotation No  <span>*</span></label>
	<select	class="" name="quotationNo" id="quotationNo" validate="Quotation No,String,yes" tabindex=1 onchange="getEnquiryDetails();">
		<option value="">Select Quotation No</option>
<%
	for (Object[] list :enquiryList ) 
	{
		
		%>		
		<option value=<%=list[0]%>><%=list[0]%></option>
		<%   
	}
%>

</select>