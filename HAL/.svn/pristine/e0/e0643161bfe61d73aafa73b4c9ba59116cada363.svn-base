
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.StoreBoo"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>

<%
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
</script>
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
<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
var rankArr = new Array();
 var numLinesAdded = 1;
  var tt;
  function fillItemsinBoo(idVal,rowVal){
  		
  		var idEmployee="idEmployee";
  		var codeEmployee="codeEmployee";
    	var idRank="idRank";
    	var nameRank="nameRank";
    	var idService="idService";
    	
    	
    	idEmployee=idEmployee+rowVal;
    	codeEmployee=codeEmployee+rowVal;
    	idRank=idRank+rowVal;
    	nameRank=nameRank+rowVal;
    	idService=idService+rowVal;
    	
    	document.getElementById('noOfRows').value=rowVal
		
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
		document.getElementById(idEmployee).value=itemsArray1[i][0]
		
		document.getElementById(nameRank).value=itemsArray1[i][2]
		document.getElementById(idRank).value=itemsArray1[i][3]
		document.getElementById(idService).value=itemsArray1[i][4]
		
		
		}
		}
	
  }
  
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0) {
  alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
  </script>
</script>
<% 
	Map map= new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	StoreBoo storeBooObj = null;
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList") != null){
			employeeList = (ArrayList) map.get("employeeList");
			session.setAttribute("employeeList",employeeList);
		}else if(session.getAttribute("employeeList") != null){
			employeeList = (ArrayList)session.getAttribute("employeeList");
			
		}
		
		List<MasEmployee> presidingOfficerList = new ArrayList<MasEmployee>();
		if(map.get("presidingOfficerList") != null){
			presidingOfficerList = (ArrayList) map.get("presidingOfficerList");
			session.setAttribute("presidingOfficerList",presidingOfficerList);
		}else if(session.getAttribute("presidingOfficerList") != null){
			presidingOfficerList = (ArrayList)session.getAttribute("presidingOfficerList");
			
		}
		List<MasEmployee> officerIcList = new ArrayList<MasEmployee>();
		if(map.get("officerIcList") != null){
			officerIcList = (ArrayList) map.get("officerIcList");
			session.setAttribute("officerIcList",officerIcList);
		}else if(session.getAttribute("officerIcList") != null){
			officerIcList = (ArrayList)session.getAttribute("officerIcList");
			
		}
		List<MasRank> rankList = new ArrayList<MasRank>();
		if(map.get("rankList") != null){
			rankList = (ArrayList) map.get("rankList");
			session.setAttribute("rankList",rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (ArrayList)session.getAttribute("rankList");
		}
		List<MasRank> presidingOfficerRankList = new ArrayList<MasRank>();
		if(map.get("presidingOfficerRankList") != null){
			presidingOfficerRankList = (ArrayList) map.get("presidingOfficerRankList");
			session.setAttribute("presidingOfficerRankList",presidingOfficerRankList);
		}else if(session.getAttribute("presidingOfficerRankList") != null){
			presidingOfficerRankList = (ArrayList)session.getAttribute("presidingOfficerRankList");
		}
		List<MasRank> officerIcRankList = new ArrayList<MasRank>();
		if(map.get("officerIcRankList") != null){
			officerIcRankList = (ArrayList) map.get("officerIcRankList");
			session.setAttribute("officerIcRankList",officerIcRankList);
		}else if(session.getAttribute("officerIcRankList") != null){
			officerIcRankList = (ArrayList)session.getAttribute("officerIcRankList");
		}
		
		List<StoreBoo> searchBooList= new ArrayList<StoreBoo>();
		if(map.get("searchBooList")!=null)
			searchBooList = (List) map.get("searchBooList");
		System.out.println("== searchBooList == "+searchBooList.size());
		List<StoreBoo> booList= new ArrayList<StoreBoo>();
		if(map.get("booList")!=null)
			booList = (List) map.get("booList");
		
		List<StoreGrnM>crvList= new ArrayList<StoreGrnM>();
		if(map.get("crvList")!=null)
			crvList = (List) map.get("crvList");
		String date="";
		String time="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
			if(map.get("itemList")!=null)
				itemList=(List) map.get("itemList");
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
				
			}
			int booId=0;	
			if(map.get("booId")!=null){
				booId=Integer.parseInt(""+map.get("booId"));
			}	
			String maxNo="";
			if(map.get("maxNo") != null){
				maxNo = (String) map.get("maxNo");
				
			}
			String crvno="";
			if(map.get("crvno") != null){
				crvno = (String) map.get("crvno");
				
			}
			
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
				

			}
			includedJsp = (String) map.get("includedJsp");
			%>
<% 
			int k=0;
  					if(employeeList.size()>0)
  						
 						for (MasEmployee masEmployee:employeeList){
 			%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masEmployee.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
				<%if(masEmployee.getRank()!= null) {
					%>
			
				itemsArray1[<%=k%>][2] = "<%=masEmployee.getRank().getRankName()%>";
				<%}%>
				itemsArray1[<%=k%>][3] = "<%=masEmployee.getRank().getId()%>";
				itemsArray1[<%=k%>][4] = "<%=masEmployee.getServiceNo()%>";
         		</script>
<%
          k++;
 						} %>

<br />


<style>
#contentspace label {
	text-align: right;
	width: 92px;
	float: left;
	height: 9px;
}
</style>

<h2 align="left" class="style1">BOO Entry</h2>

<div id="contentspace">

<form name="createBoo" method="post" action="">

<table class="tborder" width="100%" align="center">

	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('createBoo','stores?method=showBooJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('createBoo','stores?method=modifyBoo');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"
					onClick="submitForm('createBoo','stores?method=showBooReportJsp');">
				</td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>

	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">From Date :</label> <input type="text"
			name="<%=FROM_DATE %>" class="textbox_date"
			style="border: 1px solid #7f9db7;" MAXLENGTH="30" tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%=FROM_DATE%>,event)" />
		<label class="bodytextB">To Date :</label> <input type="text"
			name="<%=TO_DATE %>" class="textbox_date"
			style="border: 1px solid #7f9db7;" MAXLENGTH="30" tabindex=1 /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%=TO_DATE%>,event)" />


		<label class="bodytextB">Boo No:</label> <select name="<%=BOO_NO%>">
			<%
					for (StoreBoo storeBoo :searchBooList ) {
				%>

			<option value=<%=storeBoo.getBooNo()%>><%=storeBoo.getBooNo()%></option>

			<%
					}
				%>

		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('createBoo','stores?method=searchBoo');" /> <br />
		</td>
	</tr>

</table>
</form>
</div>
</div>

<jsp:include page="searchResultBlock.jsp" /></div>

<form name="booGrid" method="post">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">BOO Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">
<br />
<label class="bodytextB"><font id="error">*</font>CRV No.</label> <input
	name="<%=GRN_NO %>" value="<%=crvno %>" validate=""
	class="textbox_size20" tabindex=1 /> <label class="bodytextB"><font
	id="error">*</font>BOO No.</label> <% if(storeBooObj != null){%> <input
	type="text" class="textbox_size20" name="<%= BOO_NO %>"
	value="<%=storeBooObj.getBooNo()%>" readonly="readonly"
	validate="Boo Number ,String,yes" tabindex=1 /> <%}else{ %> <input
	type="text" class="textbox_size20" name="<%= BOO_NO %>"
	value="<%=max%>" readonly="readonly" validate="Boo Number ,String,yes"
	tabindex=1 /> <%} %> <label class="bodytextB"><font id="error">*</font>Boo
Date:</label> <input type="text" name="<%=BOO_DATE%>" value="<%=currentDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.booGrid.<%=BOO_DATE%>,event)" />

<label class="bodytextB"><font id="error">*</font>HRO Sl No.</label> <%if(storeBooObj != null){ %>
<input name="<%=HRO_SL_NO%>" value="<%=storeBooObj.getHroSlNo()%>"
	class="textbox_size20" style="width: 98px;" tabindex=1 maxlength="12"
	validate="HRO Sl No,string,yes" /> <%}else{ %> <input
	name="<%=HRO_SL_NO%>" value="" validate="HRO Sl No,string,yes"
	class="textbox_size20" style="width: 98px;" tabindex=1 /> <%} %> <br />

<label class="bodytextB"><font id="error">*</font>HRO Date:</label> <input
	type="text" name="<%=HRO_DATE%>" value="<%=currentDate %>"
	id="<%=HRO_DATE %>" class="textbox_date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.booGrid.<%=HRO_DATE%>,event)" />

<label class="bodytextB"><font id="error">*</font>Commdt.Name</label> <select
	id="employeeId" name="<%=EMPLOYEE_ID%>"
	validate="Commandant Name,string,yes" onchange="fillRank(this.value)"
	tabindex=1>
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee :employeeList ) {
		%>
	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+ masEmployee.getLastName()%></option>
	<%}
	     %>
</select> <label class="bodytextB"><font id="error">*</font>Commdt. Rank</label>
<input type="text" id="rank1Id" name="<%=RANK_NAME%>" value=""
	class="textbox_size20" validate="Commandant Rank,string,yes"> <input
	type="hidden" id="rankId" name="<%=RANK_ID%>" value=""> <script
	type="text/javascript">
				function fillRank(obj){
				
		<%				for (MasEmployee masEmployee : employeeList) 
								{
										%>
										var empObj =<%= masEmployee.getId()%>
										if(empObj == obj){
 								
 							document.getElementById('rank1Id').value="<%=masEmployee.getRank().getRankName()%>"
 							document.getElementById('rankId').value="<%=masEmployee.getRank().getId()%>"
 							}
 					<%
 						} %>	
 						}
 	</script> <br />

<label class="bodytextB">Presd. Off.Name</label> <select id="employeeId"
	name="<%=PRESIDING_OFFICER_NAME_ID%>"
	onchange="fillRankForPresOff(this.value)"
	validate="PresidingOfficerName,string,no" tabindex=1>
	<option value="">Select</option>
	<%
			for (MasEmployee masEmployee :presidingOfficerList ) {
			%>
	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+ masEmployee.getLastName()%></option>
	<%}
		%>
</select> <label class="bodytextB">Presd. Off.Rank</label> <input type="text"
	id="presidingOfficerRankId" value="" class="textbox_size20"
	validate="PresidingOfficerRank,string,no" tabindex=1> <input
	type="hidden" id="presidingOfficerRank1Id"
	name="<%=PRESIDING_OFFICER_RANK_ID%>" value=""
	validate="PresidingOfficerRank,string,no" tabindex=1> <script
	type="text/javascript">
			function fillRankForPresOff(obj){
			
<%				for (MasEmployee masEmployee : presidingOfficerList) 
 						{
 								%>
 								var emp1Obj =<%= masEmployee.getId()%>
 								if(emp1Obj == obj){
 							document.getElementById('presidingOfficerRankId').value="<%=masEmployee.getRank().getRankName()%>"
 							document.getElementById('presidingOfficerRank1Id').value="<%=masEmployee.getRank().getId()%>"
 							}
 					<%
 						} %>	
 						}
		</script> <br />

<label class="bodytextB">Officer IC Name</label> <select
	name="<%=OFFICER_IC_NAME_ID%>" validate="OfficerIcName,string,no"
	onchange="fillRankForOff(this.value)" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee :officerIcList ) {
		%>
	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+ masEmployee.getLastName()%></option>
	<%}
		%>
</select> <label class="bodytextB">Officer IC Rank</label> <input type="text"
	id="officerIcRankId" value="" class="textbox_size20"
	validate="OfficerIcRank,string,no" tabindex=1> <input
	type="hidden" id="officerIcRank1Id" name=<%=OFFICER_IC_RANK_ID %>
	value="" validate="OfficerIcRank,string,no" tabindex=1> <script
	type="text/javascript">
			function fillRankForOff(obj){
			
<%				for (MasEmployee masEmployee : officerIcList) 
 						{
 								%>
 								var emp1Obj =<%= masEmployee.getId()%>
 								if(emp1Obj == obj){
 							document.getElementById('officerIcRankId').value="<%=masEmployee.getRank().getRankName()%>"
 							document.getElementById('officerIcRank1Id').value="<%=masEmployee.getRank().getId()%>"
 							}
 					<%
 						} %>	
 						}
		</script> <br />


<label class="bodytextB">Presd. Off. No</label> <% if(storeBooObj != null){%>
<input id="officerId" type="text" name="<%=PRESIDING_OFFICER_NO%>"
	value="<%=storeBooObj.getPresidingOff()%>" class="textbox_size20"
	validate="Unit Address,string,no" maxlength="50"> <%}else{ %> <input
	id="officerId" type="text" name="<%=PRESIDING_OFFICER_NO%>" value=""
	class="textbox_size20" validate="Unit Address,string,no" maxlength="50">
<%} %> <label class="bodytextB">Off.IC No.</label> <% if(storeBooObj != null){%>
<input name="<%=OFFICER_IC_NO%>" id="officerIdNo"
	value="<%=storeBooObj.getOfficerIcRank() %>" validate=""
	class="textbox_size20" tabindex=1 /> <%}else{ %> <input
	name="<%=OFFICER_IC_NO%>" value="" validate="" class="textbox_size20"
	tabindex=1 /> <%} %> <br />
<br />
</div>

<br />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(checkForSubmit()){submitForm('booGrid','stores?method=submitBoo');}" />


<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS %>"
	id="<%=NO_OF_ROWS %>" /> <input type="hidden" name="<%=BOO_ID %>"
	value="<%=booId%>" id="hdb" /> <br />
<br />


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">BOO ENTRY</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: auto; width: 100%; height: 305px; border: #2A2A2A 1px solid;">
<table width="99%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>

			<td width="12%"><label valign="left" class="smalllabel">Member
			Name</label></td>
			<td width="18%"><label valign="left" class="smalllabel">Member
			Rank</label></td>
			<td width="65%"><label valign="left" class="smalllabel">Member
			No</label></td>
		</tr>
	</thead>
	<tbody>
		<%
     int detailCounter=10; 
     int temp=0;
     String idEmployee="idEmployee";
     
     String idRank="idRank";
     String nameRank="nameRank";
     String idService="idService";
     String incVar="incVar";
     String idEmployee2="idEmployee";
     String codeItem2="codeItem";
     String nameItem2="nameItem";
     String idRank2="idRank";
     String nameRank2="nameRank";
     String idService2="idService";
     String incVar2="incVar2";
     
     if(pageNo!=1)
     {
      temp=detailCounter*(pageNo-1);
     }
       for(int inc=1;inc<=10;inc++){
       idEmployee=idEmployee2+(""+inc);
       idRank=idRank2+(""+inc);
       nameRank=nameRank2+(""+inc);
       idService=idService2+(""+inc);
       incVar=incVar2+(""+inc);
       %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="12%"><select name="<%=FIRST_NAME%>"
				style="width: 370px;" onchange="fillItemsinBoo(this.value,this.id)"
				id="<%=inc%>">
				<option value="0">Select</option>
				<%
    for (MasEmployee masEmployee :employeeList ) {
   %>
				<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
				<%
    }
   %>
			</select></td>

			<input type="hidden" size="2" value="0" class="bigcaption"
				name="<%=EMPLOYEE_ID%>" id="<%=idEmployee%>" />

			<td width="18%"><input type="text" value="" class="bigcaption"
				readonly="readonly" name="<%=RANK%>" id="<%=nameRank%>" /> <input
				type="hidden" value="0" class="bigcaption" readonly="readonly"
				name="<%=RANK_ID%>" id="<%=idRank%>" /></td>
			<td width="65%"><input type="text" value="" class="bigcaption"
				readonly="readonly" name="<%=SERVICE_NO%>" id="<%=idService%>" /></td>

		</tr>
		<%
       }   %>


	</tbody>
</table>

</div>
<br />
<label class="bodytextB"><font id="error"></font>Remarks</label> <%if(storeBooObj != null){ %>
<textarea value="<%=storeBooObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="256" />
			</textarea> <%}else{ %> <textarea value="" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="256" />
			</textarea> <%} %> <br />
</br>
<label class="bodytextB"><font id="error"></font>Attendant Name</label>
<%if(storeBooObj != null){ %> <textarea
	value="<%=storeBooObj.getAttendentName()%>" name="<%=ATTENDANT_NAME %>"
	validate="Attendant Name,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="256" />
			</textarea> <%}else{ %> <textarea value="" name="<%=ATTENDANT_NAME %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="256" />
			</textarea> <%} %> </br>
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />
<br />
</form>
</div>
</div>