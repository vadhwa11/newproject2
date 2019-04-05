
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
	List<Object[]> mprPriorityList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
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
<form name="searchMR" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">



<!-- <input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 /> -->
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
				
				<th id="th1">Request No</th>
				<th id="th2">Request Date</th>
				<th id="th2">From Department</th>
				<th id="th3">Requested By</th>
				<th id="th4">Approved By</th>				
				<th id="th5">Status</th>
				
				
			</tr>
			<tbody id="tblListOfMR">		
			
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
			GetMPRList('ALL');
	
		});
		
function GetMPRList(MODE)
{
	
	var ddlRequestYear = $j("#ddlRequestYear").val();
	var ddlMPRPriority = $j("#ddlMPRPriority").val();
	
	
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&Status=Approval";
		}
	else
		{
			var data = "PN="+nPageNo+"&Status=Approval";
		}
	var url = "stores?method=getListOfRC";
	var bClickable = true;
	GetJsonData('tblListOfMR',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			var RequestStatus="";
			if(jsonData[i].Status == 'u')
			{
				RequestStatus = "Saved";
			}
			else if(jsonData[i].Status == 's')
			{
				RequestStatus = "Pending for Appproval";
			}
			else if(jsonData[i].Status == 'o')
			{
				RequestStatus = "Approved";
			}
			else if(jsonData[i].Status == 'r')
			{
				RequestStatus = "Rejected";
			}
			else if(jsonData[i].Status == 'y')
			{
				RequestStatus = "Received";
			}
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].RequestNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].RequestDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].FromDepartment+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].RequestedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ApprovedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+RequestStatus+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfMR").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	approveMR(Id);
}

function approveMR(Id)
{

	window.location = "stores?method=approveRCDetails&requestHeaderId="+Id+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetMRList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	
	nPageNo = pageNo;
	GetMRList('ALL');
}


</script>

