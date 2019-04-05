
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
	//List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
	
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
	/*  if(map.get("departmentList") != null)
	 {
		 departmentList =  (List<MasDepartment>)map.get("departmentList");	  		 
		   
	  } */
	
	 
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
		
	int departmentId = 0;
	if (session.getAttribute("deptId") != null) {
		departmentId =  (Integer)session.getAttribute("deptId");
	}
	
	
	
	
%>
<form name="PatientList" method="post" action="">

 <div class="titleBg">
<h2>Patient Appointment List</h2>
</div>

<div class="Block">
 <div class="clear" style="padding-top: 5px;"></div> 

<label> Appointment Date </label>
<input  type="text" class="calDate"  id="appointmentDate" name="appointmentDate" placeholder="DD/MM/YYYY"  onchange ="GetPatientList('FILTER');" validate="MR Date,string,yes" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10"/>


<label>Session:</label>

<select id="sessId" name="sessId"  onchange ="GetPatientList('FILTER');">
			<option value="0">Select</option>
			<option value="1">Morning</option>
			<option value="2">Evening</option>
			
		</select>

<!-- <div class="clear" style="padding-top: 10px;"></div> -->


 <input type="button" name="reset" id="resetbutton" value="Show All" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
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
				
				<th id="th1">Employee No</th>
				<th id="th2">Patient Name</th>
				<th id="th2">Relation</th>
				<th id="th2">Gender</th>
				<th id="th3">Department</th>
				<th id="th4">AppointmentDate</th>				
				<th id="th5">Session</th>
				<th id="th5">Token No</th>
				<!-- <th id="th6">FromTime</th> -->
				
			</tr>
			<tbody id="tblListOfPatient">		
			
			</tbody>
			</table>
			

</div>
 <div id="pageNavPosition"></div>
 
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			GetPatientList('ALL');
	
		});
		
function GetPatientList(MODE)
{
	
	
	var appointmentDate = $j("#appointmentDate").val();
	if(appointmentDate =="")
		{
			var appDate = "NA";
		}
	else
		{
		var appDate = appointmentDate;
		}
	var sessId = $j("#sessId").val();
	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&sessId=0&appointmentDate="+appDate
		}
	else
		{
			var data = "PN="+nPageNo+"&sessId="+sessId+"&appointmentDate="+appDate;
		}
	var url = "registration?method=getPatientAppointmentList";
	var bClickable = false;
	GetJsonData('tblListOfVisit',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			if(jsonData[i].Status == 'c')
				{
					var Status='Complete'
				}
			else
				{
					var Status='Pending'
				}
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].EmployeeNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].PatientName+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Relation+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Gender+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Department+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].AppointmentDate+"</td>";			
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Session+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Token+"</td>";		
			/* htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].FromTime+"</td>"; */
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='9'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfPatient").html(htmlTable);	
	
	
}




function showResultPage(pageNo)
{
	
	nPageNo = pageNo;	
	GetPatientList('FILTER');
	
}

function ShowAllList(pageNo)
{	

	$j("#sessId option[value='0']").prop("selected","selected");	
	$j("#appointmentDate").val("");
	
	nPageNo = pageNo;
	GetPatientList('ALL');
}



</script>



