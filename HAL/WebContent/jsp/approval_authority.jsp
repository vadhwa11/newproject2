
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * approval_authority.jsp  
 * Purpose of the JSP -  This is for Approval Authority.
 * @author  Deepti Tevatia
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4  
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasAuthorizer> authorityList = new ArrayList<MasAuthorizer>();
	int poId = 0;
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("authorityList")!=null){
		authorityList =(List<MasAuthorizer>) map.get("authorityList");
	}
	if(map.get("poId")!=null){
		poId =(Integer) map.get("poId");
	}
	
%>
<div id="contentspace">
<form name="approve" method="post" action=""><br />

<div style="padding-left: 15px;">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Approved Authorities</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />


<div
	style="overflow: scroll; overflow-x: hidden; width: 35%; height: 250px; BORDER: #202020 1px solid;">
<br />
<%
			int counter = 0;
				for(MasAuthorizer masAuthorizer : authorityList){
					if(masAuthorizer.getStatus().equals("y")){
						System.out.println("Inside If........");
			%>
<div style="float: left"><input type="checkbox"
	name="id<%=counter%>" value="<%=masAuthorizer.getId()%>"
	checked="checked"></div>

<%
					}else{
						System.out.println("Inside Else........");
			%>


<div style="float: left"><input type="checkbox"
	name="id<%=counter%>" value="<%=masAuthorizer.getId()%>"></div>




<%
					}
			%>

<div style="float: left"><input type="hidden"
	name="<%=FREE_QTY %>" value="<%=masAuthorizer.getAuthorizerName() %>"
	readonly id="f1" class="textbox_size20" MAXLENGTH="30" /> <label
	class="bodytextB" style="width: 150px; text-align: left;"><%=masAuthorizer.getAuthorizerName() %></label>
</div>



<br />
<%
					counter++;
					} 
				%>
</div>

<br />

<input type="hidden" name="<%=PO_ID %>" value="<%=poId%>"> <input
	type="hidden" name="counter" value="<%=counter %>"> <input
	type="button" name="add" id="addbutton" value="Save" class="button"
	onClick="submitForm('approve','purchaseOrder?method=submitApprovalAuthority')"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="button" onClick="resetForm();"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="window.close();"
	accesskey="a" tabindex=1 />
</form>
<script>
		function chkCheckBoxes()
		{
		alert("inside")
			inps = document.getElementsByTagName('input')
			alert(inps.length)
			flag=true;
			for(i=0;i<inps.length;i++)
			{
			alert(inps[i].type)
				if(inps[i].type == 'checkbox'){
					if(inps[i].checked){
						alert("checked")
						flag=false;
						break;
					}
				}
			}
			
			return true;
	}


</script></div>
</div>
</div>