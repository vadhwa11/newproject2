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
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@ page import="java.util.*"%>

<%@ page import = "static jkt.hms.util.RequestConstants.EMPLOYEE_ID" %>
<%@ page import = "static jkt.hms.util.RequestConstants.SESSION_ID" %>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	
		
 if(map.get("indentList") != null){
	 
	 indentList=(List<StoreIndentM>)map.get("indentList");
 }
 


 
%>

<%
		if(map.get("indentList") != null)
		{
			if(indentList.size()>0)
			{
				%>
					<label> Indent List</label>
						<select	class="" name="indentNo" id="indentNo" validate="Supplier Indent No,String,yes" onchange="getPODetails('I');" tabindex=1 >
							<option value="0">Select Indent No</option>
								<%
									for (StoreIndentM list :indentList ) 
									{
										
										%>		
										<option value=<%=list.getId()%>><%=list.getIndentNo()%></option>
										<%   
									}
								%>
								</select>
				<%
			}
			else
			{
				%>
					<label> Indent is not Created for this PO</label>
					
				<%
			}
		}
		
		
%>

