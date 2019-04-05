
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

<%@page import="jkt.hms.masters.business.MasStorePoDeliveryTerms"%>
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
	List<MasStorePoDeliveryTerms> deliveryDetailsList = new ArrayList<MasStorePoDeliveryTerms>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("deliveryDetailsList")!=null){
		deliveryDetailsList =(List<MasStorePoDeliveryTerms>) map.get("deliveryDetailsList");
	}
	
%>
<div id="contentspace">
<form name="deliveryForm" method="post" action=""><br />
<div style="padding-left: 15px;">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">SO Delivery Terms</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 60%; height: 350px; BORDER: #202020 1px solid;">
<br />

<%
int counter = 0;
	for(MasStorePoDeliveryTerms obj : deliveryDetailsList){
%>

<div style="float: left"><input type="checkbox"
	name="id<%=counter%>" value="<%=obj.getId()%>"></div>

<div style="float: left"><input type="hidden"
	id="<%=PO_DELIVERY_TERMS_DESC%>" name="<%=PO_DELIVERY_TERMS_DESC %>"
	value="<%=obj.getPoDeliveryTermsDescription() %>" readonly id="f1"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB"
	style="width: 500px; text-align: left;"><%=obj.getPoDeliveryTermsDescription() %></label>
</div>

<br />

<%
	counter++;
	} 
%> <input type="hidden" name="counter" value="<%=counter %>"> <br />
<input type="button" name="add" id="addbutton" value="OK" class="button"
	onClick="submitForm('deliveryForm','purchaseOrder?method=displayDeliveryTerms','check')"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="window.close();"
	accesskey="a" tabindex=1 />
</form>
<script>
	function check(){
		var count = 0;
		inps = document.getElementsByTagName('input')
		for(i=0;i<inps.length;i++)
		{
			if(inps[i].type == 'checkbox'){
				if(inps[i].checked){
					count++;
				}
			}
		}
		if(count > 1){
			alert("Select Only One Option.")
			return false;
		}else if(count == 1){
			window.opener.document.getElementById('<%=DELIVERY_TERMS %>').value =document.getElementById('<%=PO_DELIVERY_TERMS_DESC%>').value;
			window.close();
			return true;
		}
	}
	
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