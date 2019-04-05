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
<form name="PendingForApprovalOfStockTaking" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">





<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
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
				
				<th id="th1">StockTaking Date</th>
				<th id="th2">StockTaking No</th>
				<th id="th2">Department</th>
				<th id="th3">Submitted By</th>
				<th id="th3">Approved By</th>
				<th id="th4">Reason</th>				
				
				
			</tr>
			<tbody id="tblListOfPendingForApprovalofStockTaking">		
			
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
			GetPendingApprovalList('ALL');
	
		});
		
function GetPendingApprovalList(MODE)
{
	
	var fromdept = $j("#fromdept").val();
			
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&fromdept=0&hospitalId="+hospitalId;
		}
	else
		{
		var data = "PN="+nPageNo+"&fromdept="+fromdept+"&hospitalId="+hospitalId;
		}
	var url = "stores?method=getListofStockTacking";
	var bClickable = true;
	GetJsonData('tblListOfPendingForApprovalofStockTaking',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			
			var Reason = jsonData[i].Reason;
			Reason = Reason.split('$').join("\r");
			Reason = Reason.split('^').join("\n");
		
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].No+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].FromDepartment+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].SubmittedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ApprovedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+Reason+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='5'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfPendingForApprovalofStockTaking").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	ViewDetails(Id);
}

function ViewDetails(Id)
{

	window.location = "stores?method=viewStockingDetails&stockHeaderId="+Id+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetPendingApprovalList('FILTER');
	
}

function ShowAllList(pageNo)
{	
		
	nPageNo = pageNo;
	GetPendingApprovalList('ALL');
}


</script>
