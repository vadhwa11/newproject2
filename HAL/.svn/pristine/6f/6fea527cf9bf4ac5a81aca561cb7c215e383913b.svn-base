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
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
	
	List<Object[]> poListforGRN = new ArrayList<Object[]>();

	
 if(map.get("poList") != null){
	 
	 poList=(List<StorePoHeader>)map.get("poList");
 }
 
if(map.get("poListforGRN") != null){
	 
	poListforGRN=(List<Object[]>)map.get("poListforGRN");
 }
// out.print("enquiryList="+enquiryList.size());
 

 
%>

<%
		if(map.get("poList") != null)
		{
			if(poList.size()>0)
			{
				%>
					<label> Purchase Order No  <span>*</span></label>
						<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 onchange="getPODetails('P'); getSupplierIndentList();" onclick="checkYear();">
							<option value="">Select Purchase Order No</option>
								<%
									for (StorePoHeader list :poList ) 
									{
										
										%>		
										<option value=<%=list.getId()%>><%=list.getPoNumber()%></option>
										<%   
									}
								%>
								</select>
				<%
			}
			else
			{
				%>
					<label> Purchase Order No  <span>*</span></label>
						<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 onchange="getPODetails();" onclick="checkYear();">
							<option value="">Select Purchase Order No</option>
								
								</select>
				<%
			}
		}
		
		
%>

<%
	if(map.get("poListforGRN") != null)
	{
		if(poListforGRN.size()>0)
		{
			%>
				<label> Purchase Order No  <span>*</span></label>
					<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1">
						<option value="">Select Purchase Order No</option>
							<%
								for (Object[] list :poListforGRN ) 
								{
									
									%>		
									<option value=<%=list[1]%>><%=list[1]%></option>
									<%   
								}
							%>
							</select>
			<%
		}
		else
		{
			%>
				<label> Purchase Order No  <span>*</span></label>
					<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 onchange="getPODetails();" onclick="checkYear();">
						<option value="">Select Purchase Order No</option>
							
							</select>
			<%
		}
	}
		
%>
