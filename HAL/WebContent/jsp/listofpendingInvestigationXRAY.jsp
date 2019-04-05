<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>


<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	
	
	
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
<form name="listofRadioInvestigation" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">


<label>Search By Employee No</label>

<input type="text" name ="empNo" id="empNo" value="" onchange="GetInvestigationList1('FILTER');">

 <div class="clear" style="padding-top: 10px;"></div>
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
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
				
				<th id="th1">Date</th>
				<th id="th2">Patient Id</th>
				<th id="th3">Name</th>
				<th id="th3">Age</th>
				<th id="th3">Sex</th>
				<th id="th4">Relation</th>
				<th id="th5">Investigation</th>
				<th id="th6">Department</th>
				<th id="th6">Doctor</th>
				<th id="th7">Action</th>			
				
				
			</tr>
			<tbody id="tblListOfRadioInvestigation">		
			
			</tbody>
			</table>
			

</div>
 <div id="pageNavPosition"></div>
 
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
	var refreshId = setInterval( function(){GetInvestigationList('ALL')} , 50000);
			GetInvestigationList('ALL');
	
		});
		
function GetInvestigationList(MODE)
{	

	var empNo = $j("#empNo").val();			
	
	var flag="DX";

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&flag="+flag;
		}
	else
		{
		var data = "PN="+nPageNo+"&flag="+flag+"&empNo="+empNo;
		}
	var url = "investigation?method=getPendingListforRadiologyInvestigation";
	var bClickable = false;
	GetJsonData('tblListOfRadioInvestigation',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 80px;'>"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style='width: 80px;'><b>"+jsonData[i].PatientId+"</b></td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Name+"</td>";
			htmlTable = htmlTable +"<td style='width: 50px;'>"+jsonData[i].Age+"</td>";
			htmlTable = htmlTable +"<td style='width: 70px;'>"+jsonData[i].Sex+"</td>";
			htmlTable = htmlTable +"<td style='width: 70px;'>"+jsonData[i].Relation+"</td>";
			htmlTable = htmlTable +"<td style='width: 190px;'>"+jsonData[i].Investigation+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Dept+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Doctor+"</td>";
			htmlTable = htmlTable +"<td style='width: 80px;'><input type='button' class='button' value='Complete' onclick='doComplete("+jsonData[i].Id+")'/></td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='10'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfRadioInvestigation").html(htmlTable);	
	
	
}

function doComplete(Id)
{
	if (confirm("Are you sure you have complete this investigation!") == true)
	{ 
		
		var url = "investigation?method=markCompleteRadiologyInvestigation&Id="+Id+"&var=complete";
		
		 jQuery(function ($) {
			  
		    	$.ajax({
					type:"POST",
					url: url,					 							
					cache: false,
					success: function(msg)
					{	
						//alert(msg);
						$j("#"+Id).hide();	
						
					},
					error: function(msg)
					{					
						alert("An error has occurred while contacting the server");
					}
					
					
				});
		    	
		 });
	}
	else {
		  return;
		
		} 
}





function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetInvestigationList('FILTER');
	
}

function ShowAllList(pageNo)
{	
		
	nPageNo = pageNo;
	$j("#empNo").val("");	
	GetInvestigationList('ALL');
}

function GetInvestigationList1(MODE) {

	nPageNo = 1;
	GetInvestigationList(MODE);

}




</script>

