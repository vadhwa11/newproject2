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
span {color: #ffffff;}
select {float: right;}
th{	padding: 3px;}
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
	String ReportTypeId="-1";
	String refreshType = "y";
	if(map.get("refreshType")!=null){refreshType = (String)map.get("refreshType");}
	if(map.get("ReportTypeId")!=null){ReportTypeId = (String)map.get("ReportTypeId");}
	String cr=(String)map.get("cr");
	String ct=(String)map.get("ct");
	String mr=(String)map.get("mr");
	String us=(String)map.get("us");
	String dx=(String)map.get("dx");
	String shortType=(String)map.get("shortType"); 
	if(shortType==null){shortType="desc";}
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
					title : 'Reg No',
					sort :true,
					width : '8%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				patientName : {
					title : 'Patient Name',
					width : '22%',
					edit : true
				},
				gender : {
					title : 'Relation-Gender',
					width : '6%',
					edit : true
				},
				modality : {
					title : 'Modality',
					width : '6%',
					edit : true
				},
				createDate : {
					title : 'Date & Time',
					width : '16%',
					edit : true
				},
				investigation : {
					title : 'Investigation Name',
					width : '18%',
					edit : true
				}, 
				message : {
					title : 'Message',
					width : '6%',
					edit : true
				},
				/* history : {
					title : 'History',
					width : '6%',
					edit : true
				}, */
				reports : {
					title : 'Reports',
					width : '6%',
					edit : true
				}, 
				reportstatus : {
					title : 'Status',
					width : '10%',
					edit : true
				},
				reportedBy : {
					title : 'Reported By',
					width : '16%',
					edit : true
				},
				studyurl : {
					title : 'All',
					width : '6%',
					edit : true
				}, 
				webViewer : {
					title : 'View',
					width : '6%',
					edit : true
				} 
			} 
		});
		$('#StudentTableContainer').jtable('load');
	});

</script>
<div class="titleBg">
<h2>Patient List</h2>
</div>	
	
		<div class="clear"></div>
		<div class="error" id="msg"></div>
		<div class="clear"></div>
		<div class="paddingTop5"></div>
	<form name="patientSearch" id="patientSearch"   method="post">
	<div class="Block">
		<label>From Date</label>
		<input type="text" name="fromDate" id="fromDate" value="<%=fromDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.patientSearch.fromDate,event)" />
		<label>To Date</label>
		<input type="text" name="toDate" id="toDate" value="<%=toDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.patientSearch.toDate,event)" />
		<label>Employee No</label>
		<input type="text" name="patientId" id="patientId" onblur="removeDate()"/>
		<div class="clear"></div>
		<label>Patient Name</label>
		<input type="text" name="patientName" id="patientName" onblur="removeDate()"/>
		
		<%-- <%if(cr!=null){%> <input type="checkbox" id="chk_cr" name="chk_cr" onchange="mycheckbox(this.id);" value="cr" checked="checked" class="checkboxMargin">
		<%}else{%> <input type="checkbox" id="chk_cr" name="chk_cr" onchange="mycheckbox(this.id);"  class="checkboxMargin"> <%}%>
		<label style="text-align: left;width: 30px;">CR</label> --%>
		
		<%if(ct!=null){%> <input type="checkbox" id="chk_ct" name="chk_ct" onchange="mycheckbox(this.id);" value="CT" checked="checked"  value="" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_ct" name="chk_ct" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">CT</label>
		
		
		<%if(us!=null){%><input type="checkbox" id="chk_us" name="chk_us" onchange="mycheckbox(this.id);" value="us" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_us" name="chk_us" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">US</label>
		
		<%if(dx!=null){%><input type="checkbox" id="chk_dx" name="chk_dx" onchange="mycheckbox(this.id);" value="dx" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_dx" name="chk_dx" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%}%>
		<label style="text-align: left;width: 30px;">DX</label>
		
		
		<%if(mr!=null){%> <input type="checkbox" id="chk_mr" name="chk_mr" onchange="mycheckbox(this.id);" value="mr" checked="checked" class="checkboxMargin">
		<%}else{ %><input type="checkbox" id="chk_mr" name="chk_mr" onchange="mycheckbox(this.id);" value="" class="checkboxMargin"><%} %>
		<label style="text-align: left;width: 30px;">MR</label>
		 <div class="clear"></div>
		<label>Report Type</label>
		<select id="reportTypeId"  name="reportTypeId" onchange="setReportType(this.value)" >
			 <option value="-1" selected="selected">-Report Type-</option>
			 <option value="0" >UNREPORTED</option>
			 <option value="1" >DRAFTED</option>
			 <option value="2" >REVIEWED</option>
		</select>
		<label>Auto Refresh</label>
		<%if(refreshType.equals("y")){%>
			<input type="checkbox" id="chk_refresh" name="chk_refresh" onchange="myRefreshbox(this.id);"  checked="checked" style="width: 22px;margin-left: 40px;">
		<%}else{ %>
			<input type="checkbox" id="chk_refresh" name="chk_refresh" onchange="myRefreshbox(this.id);"   style="width: 22px;margin-left: 40px;">
		<%} %>
		<input type="text" id="txt_refresh" name="txt_refresh" value="<%=refreshType%>"  style="display: none;">
		<input type="text" id="txtReportTypeId" name="txtReportTypeId" value="<%=ReportTypeId%>" style="display: none;">
	</div>
	<div class="clear"></div>
	<div class="clear"></div>	
		<a href="/hms/hms/pacs?method=showPacsPendingJsp"><input type="button"   class="button" name="ShowAll" value="Show All" /></a>
		<input type="submit" id="Search"  class="button" name="Search" value="Search" />
		<%if(shortType.equals("asc")){%>
			<input type="button" id="dtashort"  class="button" name="dtashort" onclick="dateShort(this.id)" value="Date Time &#9650;"/>
		<%}else{ %>
			<input type="button" id="dtdshort"  class="button" name="dtdshort" onclick="dateShort(this.id)" value="Date Time &#9660;"/>
		<%} %> 
		<input type="text" id="txtdtdhort" name="txtdtdhort" value="desc" style="display: none;" />
		<!-- <input type="button" tabindex="1" onclick="openPopupForPatientPacsHistory()" class="button" value="History" name="search"> -->
	<!-- input type="button" tabindex="1" onclick="openPopupForPatientPacsReport()" class="button" value="Report" name="search">  -->
	<div class="clear"></div>
	</form>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div style="text-align: center;">
		<div id="StudentTableContainer"></div>
	</div>

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
	
	
	//auto refresh 
	if(document.getElementById("chk_refresh").checked==true){
	var myVar = setInterval(function(){ myTimer() }, 300000);}
	function myTimer() {
		submitForm('patientSearch','/hms/hms/pacs?method=showPacsPendingJsp'); 
	}
	
	function myRefreshbox(myid)
	{  
		if(document.getElementById(myid).checked==true){
			document.getElementById("txt_refresh").value='y';
			myVar=setInterval(myTimer, 300000);
		}else{
			document.getElementById("txt_refresh").value='n';
			clearInterval(myVar);
		} 
	}
	//end of auto refresh 
	
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
	 
function removeDate()
{
	document.getElementById("fromDate").value="";
	document.getElementById("toDate").value="";  
	submitForm('patientSearch','/hms/hms/pacs?method=showPacsPendingJsp');
	return true;	
}
	
function dateShort(id){
	if(id=="dtashort")
	{ 
		document.getElementById("txtdtdhort").value ="desc";   
		submitForm('patientSearch','/hms/hms/pacs?method=showPacsPendingJsp');
		return true;
		
	}else{
		document.getElementById("txtdtdhort").value ="asc";  
		submitForm('patientSearch','/hms/hms/pacs?method=showPacsPendingJsp');
		return true;
		
	}
}	 
	
function setReportType(id)
{
	document.getElementById("txtReportTypeId").value=id;
}
	 
function openPopupForPatientPacsHistory(patientId){ 
	       var url="/hms/hms/pacs?method=getPatientDetailForpacsHistory&patientId="+patientId+"&createHistory=y";
	       newwindow=window.open(url,'History','height=420,width=504,status=1,scrollbars=yes'); 
}

function openPopupForPatientPacsReport(patientId){ 
    var url="/hms/hms/pacs?method=getPatientDetailForpacsReport&patientId="+patientId+"&createReport=y"; 
    newwindow=window.open(url,'ReportsMain','height=800,width=1024,status=1,scrollbars=yes'); 
}  

function openPopupForPatientPacsCommunication(patientId){ 
    var url="/hms/hms/opd?method=showRadiologyResponseJsp&patientId="+patientId; 
    newwindow=window.open(url,'History','height=420,width=625,status=1,scrollbars=yes'); 
}

function DeleteStudy(patientId){  
	var retVal = confirm("Do you want to continue delete study ?");
    if( retVal == true ){ 
		var formName="patientSearch";
		var action="pacs?method=DeletePatientStudy&patientId="+patientId;
		errorMsg="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName); 
		obj.action = action;
		obj.submit(); 
		location.replace(); 
       return true;
    }
    else{ 
       return false;
    }
} 

function AddToAcademicsStudy(patientId){  
 	var retVal = confirm("Do you want to continue study add to academics ?");
     if( retVal == true ){  
     	 var url="/hms/hms/pacs?method=getPatientDetailForAcadmicStudy&patientId="+patientId; 
	     newwindow=window.open(url,'History','height=420,width=504,status=1,scrollbars=yes'); 
        return true;
     }
     else{ 
        return false;
     }
} 

function cngRowColor(id)
{ 
	$('.jtable tr').css('background-color', '#eaecf2'); 
	var $row = $(id).closest("tr");    // Find the row
	$row.css('background-color', '#79bdf8');
}
</script> 