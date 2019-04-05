<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.StoreBoo"%>
<%@page import="jkt.hms.masters.business.StoreBooMember"%>
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
 var numLinesAdded = 1;
  var tt;
  function fillItems(idVal,rowVal){
  		
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
  function fillValues(inc)
  {
  	 	var stockInVar="stockInVar";
    	var mmfVar="mmfVar";
    	var demandVar="demandVar";
    	var stockInVarTemp="stockInVarTemp";
    	var mmfVarTemp="mmfVarTemp";
    	var demandVarTemp="demandVarTemp";
    	document.getElementById(stockInVar+inc).value=document.getElementById(stockInVarTemp+inc).value
    	document.getElementById(mmfVar+inc).value=document.getElementById(mmfVarTemp+inc).value
    	document.getElementById(demandVar+inc).value=document.getElementById(demandVarTemp+inc).value
  }
    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
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
		List<MasRank> rankList = new ArrayList<MasRank>();
		if(map.get("rankList") != null){
			rankList = (ArrayList) map.get("rankList");
			session.setAttribute("rankList",rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (ArrayList)session.getAttribute("rankList");
			
		}
		
		List<StoreBoo> searchBooList= new ArrayList<StoreBoo>();
		if(map.get("searchBooList")!=null)
			searchBooList = (List) map.get("searchBooList");
		System.out.println("searchBooList  in JSP "+searchBooList.size());
		
		List<StoreBooMember> gridBooMList=new ArrayList<StoreBooMember>();
		List<StoreBoo> gridBooList= new ArrayList<StoreBoo>();
		
		if(map.get("gridBooMList")!=null){
			gridBooMList=(List) map.get("gridBooMList");
			System.out.println("333333333333333333333333333333 "+((List)map.get("gridBooMList")).size());
			
		}
		if(map.get("gridBooList")!=null)
			gridBooList=(List) map.get("gridBooList");
		
		int booId=0;
		if(map.get("booId")!=null){
			booId=Integer.parseInt(""+map.get("booId"));
			System.out.print(" booId    "+booId);
		}
		
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
				

			}
			includedJsp = (String) map.get("includedJsp");
			%>
<%
	int k = 0;
	if (employeeList.size() > 0)

		for (MasEmployee masEmployee : employeeList) {
			System.out.print("-----------   ----------------          "
					+ employeeList.size());
%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masEmployee.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masEmployee.getFirstName()%>";
				itemsArray1[<%=k%>][2] = "<%=masEmployee.getRank().getRankName()%>";
				itemsArray1[<%=k%>][4] = "<%=masEmployee.getServiceNo()%>";
         		</script>
<%
	k++;
		}
%>


<script type="text/javascript">
			
		<%--	<%
			int counter=0;
			for (MasRank masRank : rankList) 
			{
				for (MasEmployee masEmployee : employeeList) 
				{
					if(masEmployee.getRank() != null){
						if(masRank.getId().equals(masEmployee.getRank().getId())){
								%>
									rankArr[<%=counter%>] = new Array();
									rankArr[<%=counter%>][0] = <%=masRank.getId()%>;
									rankArr[<%=counter%>][1] = <%=masEmployee.getId()%>;									
									rankArr[<%=counter%>][2] = "<%=masEmployee.getRank().getRankName()%>";
								<%
								counter++;
						}
					}
				}
			}
		%>--%>
			</script>
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
					onClick="submitForm('createBoo','stores?method=showGrnJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('createBoo','stores?method=grnModifyJsp');"></td>
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
					onClick="submitForm('createBoo','stores?method=showBooReportJsp');"></td>
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
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%=FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%=FROM_DATE%>,event)" />


		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%=TO_DATE %>" class="textbox_date" MAXLENGTH="30" / tabindex=1 />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%=TO_DATE%>,event)" />

		<br />

		<label class="bodytextB_blue">Boo No:</label> <select
			name="<%=BOO_NO%>">
			<%
				for (StoreBoo storeBoo : searchBooList) {
			%>

			<option value=<%=storeBoo.getBooNo()%>><%=storeBoo.getBooNo()%></option>

			<%
				}
			%>

		</select> <br />


		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('createBoo','stores?method=searchBoo');" /> <br />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</form>
<form name="booGrid" method="post"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">BOO Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 140px; background-color: #f4f9fe;">
<%
	for (StoreBoo storeBoo : gridBooList) {
%> <input type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB">CRV No.</label> <input name="<%=GRN_NO %>"
	value="<%=storeBoo.getGrnNo()%>" validate="" class="textbox_size20"
	tabindex=1 /> <label class="bodytextB">BOO No.</label> <input
	name="<%=BOO_NO %>" value="<%=storeBoo.getBooNo()%>" validate=""
	class="textbox_size20" tabindex=1 /> <label class="bodytextB">Boo
Date:</label> <input type="text" class="textbox_size20" name="<%=BOO_DATE%>"
	value="<%=storeBoo.getBooDate() %>" readonly="readonly" tabindex=1 />

<label class="bodytextB">HRO Sl No.</label> <%if(storeBoo != null){ %> <input
	name="<%=HRO_SL_NO%>" value="<%=storeBoo.getHroSlNo()%>"
	class="textbox_size20" style="width: 98px;" tabindex=1 maxlength="12"
	validate="HRO Sl No,string,yes" /> <%}else{ %> <input
	name="<%=HRO_SL_NO%>" value="" validate="HRO Sl No,string,yes"
	class="textbox_size20" style="width: 98px;" tabindex=1 /> <%} %> <br />
<label class="bodytextB">HRO Date:</label> <input type="text"
	class="textbox_size20" name="<%=HRO_DATE%>"
	value="<%=storeBoo.getHroDate() %>" readonly="readonly" tabindex=1 />

<label class="bodytextB">Commdt.Name</label> <select
	name="<%=EMPLOYEE_ID%>" validate="Commandant Name,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
				if (storeBoo.getCommand().getId() == masEmployee.getId()) {
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getFirstName()%></option>
	<%
		} else {
	%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%></option>
	<%
		}
			}
	%>
</select> <label class="bodytextB">Commdt. Rank</label> <select id="rankId"
	select name="<%=RANK_ID%>" validate="Commandant Rank,string,no">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {
				if (storeBoo.getCommandRank().getId() == masRank.getId()) {
	%>
	<option value="<%=masRank.getId()%>" selected="selected"><%=masRank.getRankName()%></option>
	<%
		} else {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
			}
	%>
</select> <br />
<label class="bodytextB">Presd. Off.Name</label> <select
	name="<%=PRESIDING_OFFICER_NAME_ID%>"
	validate="PresidingOfficerName,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
			if (storeBoo.getPresidingOff().getId() == masEmployee.getId()) {
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getFirstName()%></option>
	<%
		} else {
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%></option>
	<%
		}
			}
	%>
</select> <label class="bodytextB">Presd. Off.Rank</label> <select
	name="<%=PRESIDING_OFFICER_RANK_ID%>"
	validate="PresidingOfficerRank,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasRank masRank : rankList) {
			if (storeBoo.getPresidingOffRank().getId() == masRank.getId()) {
	%>
	<option value="<%=masRank.getId()%>" selected="selected"><%=masRank.getRankName()%></option>
	<%
		} else {
	%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
		}
		}
	%>
</select> <label class="bodytextB">Presd. Off. No</label> <input id="officerId"
	type="text" name="<%=PRESIDING_OFFICER_NO%>" value=""
	class="textbox_size20" validate="Unit Address,string,no" maxlength="50"
	readonly="readonly"> <br />
<br />
<label class="bodytextB">Officer IC Name</label> <select
	name="<%=OFFICER_IC_NAME_ID%>" validate="OfficerIcName,string,no"
	tabindex=1>
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
			if (storeBoo.getOfficerIc().getId() == masEmployee.getId()) {
	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getFirstName()%></option>
	<%
		} else {
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%></option>
	<%
		}
		}
	%>
</select> <label class="bodytextB">Officer IC Rank</label> <select
	name="<%=OFFICER_IC_RANK_ID%>" validate="OfficerIcRank,string,no"
	tabindex=1>

	<option value="">Select</option>
	<%
		for (MasRank masRank : rankList) {
			if (storeBoo.getOfficerIcRank().getId() == masRank.getId()) {
	%>
	<option value="<%=masRank.getId()%>" selected="selected"><%=masRank.getRankName()%></option>
	<%
		} else {
	%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
		}
		}
	%>
</select> <label class="bodytextB">Off.IC No.</label> <input
	name="<%=OFFICER_IC_NO%>" value="1" validate="" class="textbox_size20"
	tabindex=1 /> <%
 	}
 %>
</div>
<br />

<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('booGrid','stores?method=updateBoo');" /> <br />
<input type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" name="<%=BOO_ID %>" value="<%=booId%>" id="hdb" />
<br />


<fieldset style="width: 99%; padding-left: 9px;"><legend>BOO
Entry</legend>

<div
	style="overflow: auto; width: 100%; height: 230px; padding-left: 9px;">
<table width="100%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="32%"><label valign="left" class="smalllabel">Member
			Name</label></td>
			<td width="32%"><label valign="left" class="smalllabel">Member
			Rank</label></td>

		</tr>
	</thead>
	<tbody>

		<%
			int detailCounter = 8;
			int temp = 0;
			String idEmployee = "idEmployee";

			String idRank = "idRank";
			String nameRank = "nameRank";
			String idService = "idService";
			String incVar = "incVar";
			String idEmployee2 = "idEmployee";
			String codeItem2 = "codeItem";
			String nameItem2 = "nameItem";
			String idRank2 = "idRank";
			String nameRank2 = "nameRank";
			String idService2 = "idService";
			String incVar2 = "incVar2";

			int inc = ((pageNo - 1) * 10) + 1;
			System.out.println("--------------inc -----------   " + inc);
			int incTemp2 = inc + 10;
			for (StoreBooMember storeBooMember : gridBooMList) {

				if (inc <= incTemp2) {
		%>
		<td width="5%">
		<%
					idEmployee = idEmployee2 + ("" + inc);
					idRank = idRank2 + ("" + inc);
					nameRank = nameRank2 + ("" + inc);
					idService = idService2 + ("" + inc);
					incVar = incVar2 + ("" + inc);
		%>

		<tr>
			<input type="hidden" name="<%= DETAIL_ID%>"
				value="<%=storeBooMember.getId()%>" />

			<td width="5%"><input type="text" size="2"
				value="<%=Integer.parseInt(""+storeBooMember.getSrNo())%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
		</td>

		<td width="10%"><select name="<%=FIRST_NAME%>"
			onchange="fillItems(this.value,this.id)" id="<%=inc%>">
			<option value="0">Select</option>
			<%
					for (MasEmployee masEmployee : employeeList) {
								if (storeBooMember.getMember().getId().equals(
										masEmployee.getId())) {
				%>

			<option value=<%=masEmployee.getId()%> selected="selected"><%=masEmployee.getFirstName()%></option>

			<%
					} else {
				%>
			<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()%></option>
			<%
					}
							}
				%>
		</td>
		<input type="hidden" size="2" value="0" class="smcaption"
			name="<%=EMPLOYEE_ID%>" id="<%=idEmployee%>" />
		<td width="10%"><input type="text"
			value="<%=storeBooMember.getMemberRank().getRankName()%>"
			class="medcaption" readonly="readonly" name="<%=RANK%>" id="nameRank" />
		<input type="hidden" value="4" class="medcaption" readonly="readonly"
			name="<%=RANK_ID%>" id="<%=idRank%>" /></td>

		</tr>
		<%
			inc++;
				}
			}
			System.out.println("inc indc " + inc);

			if (inc <= 10) {
				for (; inc < 10; inc++) {
		%>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><select name="<%=FIRST_NAME%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasEmployee masEmployee : employeeList) {
				%>

				<option value=<%=masEmployee.getId()%>
					<%=masEmployee.getFirstName()%></option>

				<%
					}
				%>
			</td>
			<input type="hidden" size="2" value="0" class="smcaption"
				name="<%=EMPLOYEE_ID%>" id="<%=idEmployee%>" />
			<td width="10%"><input type="text" value="" class="medcaption"
				readonly="readonly" name="<%=RANK%>" id="nameRank" /> <input
				type="hidden" value="4" class="medcaption" readonly="readonly"
				name="<%=RANK_ID%>" id="<%=idRank%>" /></td>

		</tr>

		<%
			}
			}
		%>



	</tbody>

</table>
</fieldset>
</div>
<br />
<%
	for (StoreBoo storeBoo : gridBooList) {
%>
<label class="bodytextB">Remarks</label>
<%if(storeBoo != null){ %>
<textarea value="<%=storeBoo.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" style="width: 310px;"
	onkeyup="finalCheck(this)" maxlength="250">
		</textarea>
<script>document.booGrid.<%=REMARKS%>.innerHTML = "<%=storeBoo.getRemarks() %>"</script>
<%}else{ %>
<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="250">
		</textarea>
<script>document.booGrid.<%=REMARKS%>.innerHTML = "<%=storeBoo.getRemarks() %>"</script>
<%} %>
<br />

<label class="bodytextB">Attendant Name</label>
<%if(storeBoo != null){ %>
<textarea value="<%=storeBoo.getAttendentName()%>"
	name="<%=ATTENDANT_NAME %>" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" style="width: 310px;"
	onkeyup="finalCheck(this)" maxlength="250">
		</textarea>
<script>document.booGrid.<%=ATTENDANT_NAME%>.innerHTML = "<%=storeBoo.getAttendentName() %>"</script>
<%}else{ %>
<textarea value="" name="<%=ATTENDANT_NAME %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="250">
		</textarea>
<script>document.booGrid.<%=ATTENDANT_NAME%>.innerHTML = "<%=storeBoo.getAttendentName() %>"</script>
<%} %>
<%} %>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />


</div>
