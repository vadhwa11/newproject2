<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgment.jsp
	 * Purpose of the JSP -  This is for Department Indent.
	 * @author  Ranjesh Prasad
	 * Create Date: 17th March, 2016
	 * Revision Date:
	 * Revision By:
	 * @version 1.5
	--%>
	
	<!-- Include one of jTable styles. -->
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link href="../jsp/pacs/css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="../jsp/pacs/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<!-- Include jTable script file. -->
<script src="../jsp/pacs/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="../jsp/pacs/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="../jsp/pacs/js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<style>
span {
    color: #ffffff;
	}
select {
	float: right;
}
th{
	padding: 3px;
}
</style>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String fromDate=currentDate;
	String toDate=currentDate;
	if(map.get("fromDate")!=null){
		fromDate=(String)map.get("fromDate");
	}
	if(map.get("toDate")!=null){
		toDate=(String)map.get("toDate");
	}
	
	String cr=(String)map.get("cr");
	String ct=(String)map.get("ct");
	String mr=(String)map.get("mr");
	String us=(String)map.get("us");
	String dx=(String)map.get("dx");
	 
	
%>
<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Patient List',
            paging: true, //Enable paging
            pageSize: 10, //Set page size (default: 10)           
            actions: {
                listAction: '/hms/hms/pacs?method=pacsUtil&action=list<%=map.get("gsonURL")%>',
                createAction:'Controller?action=create',
                updateAction: '/hms/hms/pacs?method=pacsUtil&action=search',
                deleteAction: '/hms/hms/pacs?method=pacsUtil&action=search'
            },
			fields : {
				patientId : {
					title : 'Patient Id',
					sort :true,
					width : '10%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				patientName : {
					title : 'Patient Name',
					width : '20%',
					edit : true
				},
				gender : {
					title : 'Gender',
					width : '7%',
					edit : true
				},
				modality : {
					title : 'Modality',
					width : '7%',
					edit : true
				},
				createDate : {
					title : 'Date',
					width : '12%',
					edit : true
				},
				investigation : {
					title : 'Investigation Name',
					width : '30%',
					edit : true
				},
				
				history : {
					title : 'History',
					width : '7%',
					edit : true
				},
				reports : {
					title : 'Reports',
					width : '7%',
					edit : true
				},
				reportstatus : {
					title : 'Status',
					width : '30%',
					edit : true
				},
				webViewer : {
					title : 'View',
					width : '10%',
					edit : true
				}/* ,
				img : {
					title : '',
					width : '10%',
					edit : true
				} */
			}
		});
		$('#StudentTableContainer').jtable('load');
	});

</script>
	
	<h2>Patient List</h2>
		<div class="clear"></div>
		<div class="error" id="msg"></div>
		<div class="clear"></div>
	<form name="patientSearch" id="patientSearch"   method="post">
	<div class="Block">
		<label>From Date</label>
		<input type="text" name="fromDate" id="fromDate" value="<%=fromDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.patientSearch.fromDate,event)" />
		<label>To Date</label>
		<input type="text" name="toDate" id="toDate" value="<%=toDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.patientSearch.toDate,event)" />
		<label>Patient Id</label>
		<input type="text" name="patientId" id="patientId" />
		<div class="clear"></div>
		<label>Patient Name</label>
		<input type="text" name="patientName" id="patientName" />
		
		<%if(cr!=null){%> <input type="checkbox" id="chk_cr" name="chk_cr" onchange="mycheckbox(this.id);" value="cr" checked="checked" class="checkboxMargin">
		<%}else{%> <input type="checkbox" id="chk_cr" name="chk_cr" onchange="mycheckbox(this.id);"  class="checkboxMargin"> <%}%>
		<label style="text-align: left;width: 30px;">CR</label>
		
		<%if(ct!=null){%> <input type="checkbox" id="chk_ct" name="chk_ct" onchange="mycheckbox(this.id);" value="ct" checked="checked"  value="" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_ct" name="chk_ct" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">CT</label>
		
		<%if(mr!=null){%> <input type="checkbox" id="chk_mr" name="chk_mr" onchange="mycheckbox(this.id);" value="mr" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_mr" name="chk_mr" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">MR</label>
		
		<%if(us!=null){%><input type="checkbox" id="chk_us" name="chk_us" onchange="mycheckbox(this.id);" value="us" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_us" name="chk_us" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">US</label>
		
		<%if(dx!=null){%><input type="checkbox" id="chk_dx" name="chk_dx" onchange="mycheckbox(this.id);" value="dx" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_dx" name="chk_dx" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%}%>
		<label style="text-align: left;width: 30px;">DX</label>
		 
	</div>
	<div class="clear"></div>
		<a href="/hms/hms/pacs?method=showPacsPendingJsp"><input type="button"   class="button" name="ShowAll" value="Show All" /></a>
		<input type="submit" id="Search"  class="button" name="Search" value="Search" />
		<!-- <input type="button" tabindex="1" onclick="openPopupForPatientPacsHistory()" class="button" value="History" name="search"> -->
	<!-- input type="button" tabindex="1" onclick="openPopupForPatientPacsReport()" class="button" value="Report" name="search">  -->
	<div class="clear"></div>
	</form>
	
	<div style="text-align: center;">
		<div id="StudentTableContainer"></div>
	</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
	<script>
	
	function mycheckbox(myid)
	{
		var res = myid.split("_");
		if(res[1]=="cr"){ 
			if(document.getElementById(myid).checked==true){
				document.getElementById(myid).value="cr";
			}else{
				document.getElementById(myid).value=""; 
			}
		}
		else if(res[1]=="ct"){ 
			if(document.getElementById(myid).checked==true){
				document.getElementById(myid).value="ct";
			}else{
				document.getElementById(myid).value=""; 
			}
		}
		else if(res[1]=="mr"){
			if(document.getElementById(myid).checked==true){
				document.getElementById(myid).value="mr";
			}else{
				document.getElementById(myid).value=""; 
			}
		}
		else if(res[1]=="us"){
			if(document.getElementById(myid).checked==true){
				document.getElementById(myid).value="us";
			}else{
				document.getElementById(myid).value=""; 
			}
		}
		else if(res[1]=="dx"){ 
			if(document.getElementById(myid).checked==true){
				document.getElementById(myid).value="dx";
			}else{
				document.getElementById(myid).value=""; 
			}
		}
		
	}
	
	 $(document).ready(function(){
	    $("#Search").click(function(){
	    	var msg="";
	    	var search="";
			flag=false;
			var fromDate=$("#fromDate").val();
			var toDate=$("#toDate").val();
			var patientId=$("#patientId").val();
			var patientName=$("#patientName").val();
			$("#msg").css("display", "none");
			if(fromDate=="" && toDate=="" && patientId=="" && patientName==""){
				msg="Select One.";
				flag=true;
			}
			if(fromDate!="" || toDate!=""){
				if(fromDate==""){
					msg="Select From Date.";
					flag=true;
				}
				if(toDate==""){
				msg="Select To Date.";
				flag=true;
				}
			}
			if(flag){
				$("#msg").css("display", "block");
				$("#msg").html(msg);
				return false;
			}else{
				$("#msg").html(msg);
				if(fromDate!="" && toDate!=""){
					search+="&fromDate="+fromDate+"&toDate="+toDate;
				}
				if(patientId!=""){
					search+="&patientId="+patientId;
				}
				if(patientName!=""){
					search+="&patientName="+patientName;
				}
				submitForm('patientSearch','/hms/hms/pacs?method=showPacsPendingJsp');
				return true;
			}
	    });
	}); 
	 
	
function openPopupForPatientPacsHistory(patientId){ 
	       var url="/hms/hms/pacs?method=getPatientDetailForpacsHistory&patientId="+patientId; 
	       newwindow=window.open(url,'History','height=420,width=504,status=1,scrollbars=yes'); 
}

function openPopupForPatientPacsReport(patientId){ 
    var url="/hms/hms/pacs?method=getPatientDetailForpacsReport&patientId="+patientId; 
    newwindow=window.open(url,'ReportsMain','height=800,width=1024,status=1,scrollbars=yes'); 
}  
</script> 