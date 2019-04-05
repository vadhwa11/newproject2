
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.MasDepartment" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>


<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		String msg ="";
		
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	
	 if(map.get("msg") != null)
	 {
		 msg =  (String)map.get("msg");	  
		   
	  }	
	 if(map.get("departmentList") != null)
	 {
		 departmentList =  (List<MasDepartment>)map.get("departmentList");	  		 
		   
	  }
	
	 
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
		
	int departmentId = 0;
	if (session.getAttribute("deptId") != null) {
		departmentId =  (Integer)session.getAttribute("deptId");
	}
	
	List<MasSession> masSessionList = new ArrayList<MasSession>();
	 if(map.get("sessionList") != null)
	 {
		 masSessionList =  (List<MasSession>)map.get("sessionList");	  		 
	 }
	
	
	
%>
<form name="VisitList" method="post" action="">

 <div class="titleBg">
<h2>OPD Visit List</h2>
</div>

<div class="Block">

<label>Transferred Department</label>

<select id="deptId" name="<%=DEPARTMENT_ID%>" onchange="submitProtoAjaxWithDivName('VisitList','/hms/hms/appointment?method=getDoctorDetails','doctorNSessionList');">
			<option value="0">Select</option>
			<%
				int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
			%>
	
							<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
		
			<%}
				}
			%>
		</select>

<div id="doctorNSessionList" >
		<label>Transferred Doctor<span>*</span> </label>
		<select id="doctorId" name="doctorList">
		<option value="0"></option>
		</select>
		
		<label>Session<span>*</span> </label>
		<select id="sesId" name="sessionList">
		<option value="0"></option>
		</select>		
		</div>
<div class="clear" style="padding-top: 10px;"></div>

<label>Visit Status </label>
		<select id="visitstatus" name="visitstatus">
		<option value="0">Select Status</option>
		<option value="w">Pending</option>
		<option value="c">Complete</option>
		</select>	

<input type="button" name="reset" id="resetbutton" value="Get List" class="button" onClick="GetVisitList('FILTER');" accesskey="r" tabindex=1 />
   <h4><%=msg%></h4>
 
 <div class="clear" style="padding-top: 10px;"></div>
 
 <div class="clear" style="padding-top: 10px;"></div>

<div id="divSearchResult">

		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>
				
				</td>
				</tr>
		</table>
			
  	<table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
					<th id="th7">Action</th>
				<th id="th1">Employee No</th>
				<th id="th2">Patient Name</th>
				<th id="th2">Relation</th>
				<th id="th2">Gender</th>
				<th id="th3">Department</th>
				<th id="th4">Initial Doctor</th>
				<th id="th4">Submitted By</th>				
				<th id="th5">Session</th>
				<th id="th5">Token No</th>
				<th id="th6">Status</th>
				<th>Token Print</th>
				
			</tr>
			<tbody id="tblListOfVisit">		
			
			</tbody>
			</table>
			<input type="hidden" name="totalPatient" id="totalPatient" value="0">
			

</div>
 <div id="pageNavPosition"></div>
 <div>

 <label>Department:</label>
				<select id="referdepartment" name="referdepartment"
					onchange="fnGetDoctorDepartment(this.value,'refereddoctor','y');">
				<!-- 	<option value="0">Select</option> -->
				<%-- 	<%for(MasDepartment dep:departmentList){
										%>
					<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
					
					<%}%> --%>
				</select>		<label>Doctor List<span>*</span> </label> <select
					id="refereddoctor" name="refereddoctor" onchange="resetTokenDisplay();">
					<option value="0">Select</option>
				</select>
			<label>Session<span>*</span> </label>
		<select id="referredsesId" name="referredsesId" onchange="resetTokenDisplay();">
		<option value="0">Select</option>
	
		<%for(MasSession ses:masSessionList){
										%>
					<option value="<%=ses.getId()%>"><%=ses.getSessionName()%></option>
					
					<%}%> 
		
		</select>	
		
		
			<!-- <input name="Print" type="button" value="Show Setup" target="_blank" class="cmnButton"   onclick="if(validateDatefield()){ getDetails();}" /> -->
<input type="hidden" value="y" name="tokenNoDisplayflag"/> 
			<div id="displayToken"></div>
			<div class="clear" style="padding-top: 10px;"></div>
			<input name="Print" type="button" value="Check Doctor availability" target="_blank"
				style="width: auto" class="button" onClick="validateTokenDiv()">
		
		
		<input type="button" name="reset" id="resetbutton" value="Transfer" class="button" accesskey="r" tabindex=1 onClick="validateTransfer();"/>
 </div>
 
 
 
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			//GetVisitList('ALL');
	
		});
		
function GetVisitList(MODE)
{
	
	var deptId = $j("#deptId").val();
	
	var doctorId = $j("#doctorId").val();
	var sesId = $j("#sesId").val();	
	
	var hospitalId = <%out.print(hospitalId);%>;
	var visitstatus = $j("#visitstatus").val();	

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&ddlRequestYear=0&ddlSupplier=0";
		}
	else
		{
			var data = "PN="+nPageNo+"&deptId="+deptId+"&doctorId="+doctorId+"&sesId="+sesId+"&visitstatus="+visitstatus;
		}
	var url = "registration?method=getOPDVisitList";
	var bClickable = false;
	GetJsonData('tblListOfVisit',data,url,bClickable);
}


function validateTransfer()
{
	
	
	if(document.getElementById("tokenNoId") !=null)
		{
		
		
		var selectedCount=0;
		var totalPatient = document.getElementById("totalPatient").value;
		for(var i=0;i<totalPatient;i++)
			{
			if(document.getElementById("transferRadio"+i)!=null){
			if(document.getElementById("transferRadio"+i).checked)
				{
				selectedCount++;
				}
			}
			}
		if(selectedCount==0)
			{
			alert("Please select at least one patient for transfer");
			return;
			}
		
		
		if(isNaN(document.getElementById("tokenNoId").value))
			{
			 alert(document.getElementById("tokenNoId").value);
			}
		else
			{
			//submitForm('registration','/hms/hms/registration?method=submitPatientInformationOtherPatientVisit&flag='+flag,'checkTargetForNo');
			var referdepartment = $j("#referdepartment").val();
			
			var refereddoctor = $j("#refereddoctor").val();
			var referredsesId = $j("#referredsesId").val();	
			
			var hospitalId = <%out.print(hospitalId);%>;


					var data = '&referdepartment='+referdepartment+'&refereddoctor='+refereddoctor+'&referredsesId='+referredsesId;

			submitForm('VisitList','registration?method=TransferPatientVisitList'+data);
			}
		
		}
 	else{
		alert("Pease check doctor availability");
	} 
	
	
	
	
<%-- 	var referdepartment = $j("#referdepartment").val();
	
	var refereddoctor = $j("#refereddoctor").val();
	var referredsesId = $j("#referredsesId").val();	
	
	var hospitalId = <%out.print(hospitalId);%>;


			var data = '&referdepartment='+referdepartment+'&refereddoctor='+refereddoctor+'&referredsesId='+referredsesId;

	submitForm('VisitList','registration?method=TransferPatientVisitList'+data); --%>
}
 function resetTokenDisplay()
{
	//document.getElementById("displayToken").innerhtml="sdfsdf";
	document.getElementById("displayToken").innerHTML = "";
} 
function validateTokenDiv()
{
	
	var deptId = document.getElementById("referdepartment").value;
	var doctorId = document.getElementById("refereddoctor").value;
	var sesId = document.getElementById("referredsesId").value;
	if(document.getElementById("tokenNoId")!=null)
		document.getElementById("tokenNoId").value ="";
	if(deptId!=0 && doctorId!=0 && sesId!=0)
		{
		submitProtoAjaxWithDivName('VisitList','/hms/hms/registration?method=getTokenNoForTransferPatient','displayToken');
		//alert(document.getElementById("tokenNoId"));
/* 		if(document.getElementById("tokenNoId").value!="")
			{
			alert(document.getElementById("tokenNoId").value);
			return false;
			}
		//else
			//return true; */
			
		}
	else
	{
		alert("Please Select Department, Doctor And Session");
	}
}
function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			if(jsonData[i].Status == 'C')
				{
					var Status='Complete'
				}
			else
				{
					var Status='Pending'
				}
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			if(Status=='Pending')
			htmlTable = htmlTable +"<td style='width: 100px;'><input type='checkbox' id='transferRadio"+i+"' name='transferRadio"+i+"'/><input type='hidden' id='transferVisitId"+i+"' name='transferVisitId"+i+"' value='"+jsonData[i].Id+"'/></td>";
			else
				htmlTable =htmlTable +"<td style='width: 100px; margin-right:5px;'></td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].EmployeeNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].PatientName+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Relation+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Gender+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Department+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].IntDoctor+"</td>";	
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Doctor+"</td>";			
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Session+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Token+"</td>";		
			htmlTable = htmlTable +"<td style='width: 200px;'>"+Status+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'><input name=yes value=Print Token Card class=button onclick=openWindow('/hms/hms/registration?method=printTokenCard&visit_id="+jsonData[i].Id+"&hinNo="+jsonData[i].HinNo+"&priscriptionSlip=o'); type=button></td>";
			htmlTable = htmlTable+"</tr>";
		}
	//document.getElementById("referdepartment").value ='';
	
	var selectobject=document.getElementById("referdepartment")
	  for (var i=0; i<selectobject.length; i++){
	     selectobject.remove(i);
	  }
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='9'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		   fnGetDoctorDepartment(0,'refereddoctor','y');
		}
	else
		{
		  var selectedDept = document.getElementById("deptId").value;
		  var selectedDeptName=document.getElementById("deptId").options[document.getElementById('deptId').selectedIndex].text;
	       var select = document.getElementById("referdepartment");
	       select.options[select.options.length] = new Option(selectedDeptName, selectedDept);
	       fnGetDoctorDepartment(selectedDept,'refereddoctor','y');
		}
	
	$j("#totalPatient").val(jsonData.length);
	$j("#tblListOfVisit").html(htmlTable);	
	
	
}






function executeClickEvent(Id)
{
	ViewUpdatePO(Id);
}

function ViewUpdatePO(Id)
{

	window.location = "stores?method=ViewUpdatePODetails&headerId="+Id+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	nPageNo = pageNo;	
	GetVisitList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	/* $j("#ddlRequestYear option[value='0']").prop("selected","selected");
	$j("#ddlSupplier option[value='0']").prop("selected","selected"); */
	
	nPageNo = pageNo;
	GetVisitList('ALL');
}

function getMPRList()
{
	var yearId=$j("#ddlRequestYear").val();
	if(yearId !=0)
		{
			submitProtoAjaxWithDivName('QuotationList','/hms/hms/stores?method=getMPRListListbasedonYear&yearId='+yearId,'divMPRList');
		}
	
}


</script>

