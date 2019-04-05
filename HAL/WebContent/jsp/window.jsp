<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * window.jsp  
 * Purpose of the JSP -  This is for Window.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>


<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script>
	var brandList=new Array();
   function setVar(){
  
   var rowVal=window.opener.document.getElementById('currentRow').value
   window.opener.document.getElementById('unitRate'+rowVal).value = document.getElementById('f1').value;
   window.opener.document.getElementById('brandId'+rowVal).value = document.getElementById('f2').value;
   window.opener.document.getElementById('markBy'+rowVal).value = document.getElementById('f4').value;
   window.opener.document.getElementById('totalCost'+rowVal).value = document.getElementById('f6').value;
   window.opener.document.getElementById('lastRecpQty'+rowVal).value = document.getElementById('f7').value;
   window.opener.document.getElementById('lastRecpDate'+rowVal).value = document.getElementById('f8').value;

   
   
 
     close();
   }
   
   function resetForm(){
   document.getElementById('f1').value="";
   document.getElementById('f3').value="";
   document.getElementById('f4').value="";
   document.getElementById('f5').value="";
   document.getElementById('f6').value="";
   document.getElementById('f7').value="";
   document.getElementById('f8').value="";
   
   }
   function cancelForm(){
   close();
   }
   
   function getManufacturer(id){
    for(i=0;i<brandList.length;i++){	
		if(brandList[i][0]==id){
			document.getElementById('f3').value=brandList[i][1];	
		}
    
   }
   }
   
   
   function validateInteger( strValue ) {
  //alert("in validate integer")
   var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
   return objRegExp.test(strValue);
 }
</script>
<%
	Map<String,Object>  map=new HashMap<String,Object>();
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasManufacturer> masManufacturerList= new ArrayList<MasManufacturer>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("masStoreBrandList") != null){
		masStoreBrandList = (List)map.get("masStoreBrandList");
	}
	
	if(map.get("masManufacturerList") != null){
		masManufacturerList = (List)map.get("masManufacturerList");
	}
	System.out.println("masStoreBrandList  "+masStoreBrandList.size());
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<div id="contentspace">
<form name="windowForm" method="post" action=""><input
	type="hidden" name="aa" value="1" id="tblSample" /> <br>
<br>
<br>
<br>
<label class="bodytextB_blue"><font id="error"></font>Unit Rate</label>
<input type="text" name="<%=RequestConstants.UNIT_RATE %>" value=""
	id="f1" class="textbox_size20" MAXLENGTH="8"
	/  validate="Unit Rate,num,yes"> <br />
<br />


<label class="bodytextB_blue"><font id="error"></font>Brand Name</label>
<select onchange="getManufacturer(this.value)" id="f2">
	<option value="">Select</option>
	<%int k=0;
for(MasStoreBrand storeBrand : masStoreBrandList){ 
%>
	<script type="text/javascript">
				brandList[<%=k%>]= new Array();
         		brandList[<%=k%>][0] = "<%=storeBrand.getId()%>";
         		<%
         		if(storeBrand.getManufacturer()!=null){
         		%>
				brandList[<%=k%>][1] = "<%=storeBrand.getManufacturer().getManufacturerName()%>";
				<%}else{%>
						brandList[<%=k%>][1] = "";
	</script>
	<%}%>

	<option value="<%=storeBrand.getId() %>"><%=storeBrand.getBrandName() %></option>
	<%k++;} %>
</select> <br />
<br />

<label class="bodytextB_blue"><font id="error"></font>Manufactured
By</label> <select name="<%= RequestConstants.MANUFACTORED_BY%>" id="f3"
	validate="Manufactured By,String,yes">
	<option value="0">Select</option>
	<%
					for (MasManufacturer manufacturer :masManufacturerList ) {
				%>

	<option value=<%=manufacturer.getId()%>><%=manufacturer.getManufacturerName()%></option>

	<%
					}
				%>
</select> <br />
<br />

<label class="bodytextB_blue"><font id="error"></font>Marketed
By</label> <input type="text" name="<%=RequestConstants.MARKETED_BY%>" value=""
	id="f4" class="textbox_size20" MAXLENGTH="8"
	/  validate="Marketed By,String,yes"> <br />
<br />
<label class="bodytextB_blue"><font id="error"></font>Total Cost</label>
<input type="text" name="<%=RequestConstants.TOTAL_COST%>" value=""
	id="f6" class="textbox_size20" MAXLENGTH="8"
	/ validate="Total Cost,num,yes"> <br />
<br />
<label class="bodytextB_blue"><font id="error"></font>Last
Receipt Qty</label> <input type="text"
	name="<%=RequestConstants.LAST_RECP_QTY%>" value="" id="f7"
	class="textbox_size20" MAXLENGTH="8"
	/ validate="Last Receipt Qty,num,yes"> <br />
<br />
<label class="bodytextB_blue"><font id="error"></font>Last
Receipt Date</label> <input type="text"
	name="<%= RequestConstants.LAST_RECP_DATE %>" id="f8"
	class="textbox_date" MAXLENGTH="30" / tabindex=1
	validate="Last Receipt Date,date,yes" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.windowForm.<%= RequestConstants.LAST_RECP_DATE%>,event);"
	class="calender" /> <br />
<br />
<br />

<input type="button" name="add" id="addbutton" value="Submit"
	class="button" onClick="if(submitFormSOC('windowForm','')){setVar();}"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="button" onClick="resetForm();"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="cancelForm();"
	accesskey="a" tabindex=1 /> <input type="hidden"
	name="<%=RequestConstants.STATUS %>" value="" /> <input type="hidden"
	name="" value="" /></form>
</div>
