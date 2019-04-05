
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
	 if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }
	 if(map.get("mprPriorityList") != null)
	 {
		 mprPriorityList =  (List<Object[]>)map.get("mprPriorityList");	  
		   
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
<form name="searchMPR" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">

<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear"  onchange ="GetMPRList('FILTER');">
<option value="0">Select</option>
	<%
		if(financialYearList.size()>0)
		{
			for(Object[] year : financialYearList)
			{
				%>
					<option value="<%=year[0]%>"><%=year[1]%></option>
				<%
			}
		}
	%>
</select>

<select name ="ddlMPRPriority" id="ddlMPRPriority"  onchange ="GetMPRList('FILTER');">
<option value="0">Select</option>
	<%
		if(mprPriorityList.size()>0)
		{
			for(Object[] pr : mprPriorityList)
			{
				%>
					<option value="<%=pr[0]%>"><%=pr[1]%></option>
				<%
			}
		}
	%>
</select>


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
				
				<th id="th1">MPR No</th>
				<th id="th2">Year</th>
				<th id="th2">MPR Date</th>
				<th id="th3">Type Wise</th>
				<th id="th4">Project Name</th>				
				<th id="th5">Hash Qty</th>
				<th id="th5">Hash Value</th>
				<th id="th6">Prepared By</th>
				<th id="th7">Status</th>
				
			</tr>
			<tbody id="tblListOfMPR">		
			
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
			var data = "PN="+nPageNo+"&ddlRequestYear=0&ddlMPRPriority=0&hospitalId="+hospitalId;
		}
	else
		{
			var data = "PN="+nPageNo+"&ddlRequestYear="+ddlRequestYear+"&ddlMPRPriority="+ddlMPRPriority+"&hospitalId="+hospitalId;
		}
	var url = "stores?method=getListOfMPR";
	var bClickable = true;
	GetJsonData('tblListOfMPR',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			if(jsonData[i].Status == 'u')
				{
					var Status='Saved'
				}
			else
				{
					var Status='Submitted'
				}
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].MPRNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Year+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Priority+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ProjectName+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Qty+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Value+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].PreparedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+Status+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfMPR").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	ViewUpdateMPR(Id);
}

function ViewUpdateMPR(Id)
{

	window.location = "stores?method=ViewUpdateMPRDetails&mprId="+Id+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetMPRList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlRequestYear option[value='0']").prop("selected","selected");
	$j("#ddlMPRPriority option[value='0']").prop("selected","selected");
	
	nPageNo = pageNo;
	GetMPRList('ALL');
}


</script>

