
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%-- <%@ include file="csrfToken.jsp"%> --%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> accountList = new ArrayList<Object[]>();
	List<Object[]> subledgerList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	List<Object[]> centreList = new ArrayList<Object[]>();	
	
	
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
	 if(map.get("accountList") != null)
	 {
		 accountList =  (List<Object[]>)map.get("accountList");	  
		   
	  }	 
	 if(map.get("subledgerList") != null)
	 {
		 subledgerList =  (List<Object[]>)map.get("subledgerList");		   
	 }	
	 if(map.get("centreList") != null)
	 {
		 centreList =  (List<Object[]>)map.get("centreList");	  
		   
	  }	
	 
	 
	}
	
	int locationId = 0;
	if (session.getAttribute("hospitalId") != null) {
		locationId =  (Integer)session.getAttribute("hospitalId");
	}
	
	int departmentId = 0;
	if (session.getAttribute("departmentId") != null) {
		departmentId =  (Integer)session.getAttribute("departmentId");
	}
	
	
	
	
%>
<form name="accountTransactionDetails" method="post" action="">

<H2>Transaction History</H2>

<div class="Block">
<div class="clear" style="padding-top: 10px;"></div>
<%-- <label>Year</label>

<select name ="ddlYear" id="ddlYear"  onchange ="GetTransactionDetails('FILTER');">
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
</select> --%>

<%

  String unitType="";
  if(session.getAttribute("unitType") != null)
  {
	  unitType = (String)session.getAttribute("unitType");
  }
  
  if(unitType.equalsIgnoreCase("HO"))
  {
	  %>
		<label>Select Centre <span>*</span></label>
		<select name ="ddlLocation" id="ddlLocation" validate="Centre,string,yes"  onchange="GetTransactionDetails('FILTER');">
		<option value="0">Select</option>
		
			<%
			    
				if(centreList.size()>0)
				{
					for(Object[] list : centreList)
					{
						%>
							<option value="<%=list[0]%>"><%=list[1]%></option>
						<%
					}
				}
			%> 
		</select>
		<%
	}
%>

<label>Account Name:</label>
<select name ="ddlAccountList" id="ddlAccountList"  onchange =" loadSubLedgerList(); GetTransactionDetails('FILTER');">
<option value="0">Select</option>
	<%
		if(accountList.size()>0)
		{
			for(Object[] account : accountList)
			{
				%>
					<option value="<%=account[0]%>"><%=account[1]%></option>
				<%
			}
		}
	%>
</select>


<label hidden class="medium7">SubLedger</label>
<select hidden name ="ddlSubledgerList" id="ddlSubledgerList" onchange="GetTransactionDetails('FILTER');" >
</select>
 <div class="clear" style="padding-top: 10px;"></div>
 
 <input hidden type="radio" name="rdTransactionType" id="rdAccount" checked onclick="GetTransactionDetails('FILTER');"/> 
<label hidden>Account</label>

<input hidden type="radio" name="rdTransactionType" id="rdSubledger" onclick="GetTransactionDetails('FILTER');" /> 
<label hidden >Subledger</label> 


<input type="hidden" name="search" id="search" value="Search" class="button" onClick="showResultPage('1');" accesskey="a" tabindex=1 />
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
 
<div class="clear" style="padding-top: 25px;"></div>



<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>			
				</td>			
			</tr>
		</table>
		
<div class="cmntable">
  <table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<th id="th1">Account Name</th>
				<th id="th2">YTD_Account_Dr</th>
				<th id="th3">YTD_Account_Cr</th>
				<th id="th4">Opening_Balance_Dr</th>
				<th id="th5">Opening_Balance_Cr</th>
				<th id="th6">Closing_Balance_Dr</th>
				<th id="th7">Closing_Balance_Cr</th>
				<th id="th8">Last Trans. Date</th>
								
			</tr>
			<tbody id="tblListOfTransactionDetails">		
			
			</tbody>
			
</table>
</div>


</div>
</form>



<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();
var unitType = '<% out.print(unitType);%>';

$j(document).ready(function()
		{
			if(unitType!= 'HO')
			GetTransactionDetails('ALL');
	
		});
		
function GetTransactionDetails(MODE)
{
	
	var ddlYear = $j("#ddlYear").val();
	var ddlAccountList = $j("#ddlAccountList").val();
	var ddlSubledgerList = $j("#ddlSubledgerList").val();	
	
	var TransactionType= "NA";
	
	
	if(unitType == 'HO')
	{
	 var locationId = $j("#ddlLocation").val();
	}
   else
	{
	  var locationId = <%out.print(locationId);%>;
	}
	
	if($j("#rdAccount").prop("checked") == true)
	{
		$j("#th1").html("Account Name");
		TransactionType = "Account";
	}
	if($j("#rdSubledger").prop("checked") == true)
	{
		$j("#th1").html("Subledger Name");
		TransactionType = "Subledger";
	}

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&ddlYear=0&ddlAccountList=0&ddlSubledgerList=0&TransactionType="+TransactionType+"&locationId="+locationId;
		}
	else
		{
			var data = "PN="+nPageNo+"&ddlYear="+ddlYear+"&ddlAccountList="+ddlAccountList+"&ddlSubledgerList="+ddlSubledgerList+"&TransactionType="+TransactionType+"&locationId="+locationId;
		}
	var url = "account?method=getConsolidatedTransactionDetails";
	var bClickable = true;
	GetJsonData('tblListOfTransactionDetails',data,url,bClickable);
}



function makeTable(jsonData)
{
	//console.log(jsonData);
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td>"+jsonData[i].Name+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].ytd_dr+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].ytd_cr+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].opening_dr+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].opening_cr+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].closing_dr+"</td>";			
			htmlTable = htmlTable +"<td>"+jsonData[i].closing_cr+"</td>";
			htmlTable = htmlTable +"<td>"+jsonData[i].LastChangedDate+"</td>";
			
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='9'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}	
		
	$j("#tblListOfTransactionDetails").html(htmlTable);
	
	
}

function executeClickEvent(Id)
{
	
	 var locationId;
	 var TransactionType= "NA";
	
	if($j("#rdAccount").prop("checked") == true)
	{
		TransactionType = "A";
	}
	if($j("#rdSubledger").prop("checked") == true)
	{
		TransactionType = "S";
	}
	//alert("TransactionType="+TransactionType);
	var unitType = '<% out.print(unitType);%>';
	if(unitType == 'HO')
	{
	 locationId = $j("#ddlLocation").val();
	}
   else
	{
	  locationId = <%out.print(locationId);%>;
	}
	
  
  openPopUp("account?method=popUpOfViewTransactionHistory&Id="+Id+"&TransactionType="+TransactionType+"&locationId="+locationId);

		 

	
	
}




function showResultPage(pageNo)
{	
	nPageNo = pageNo;	
	GetTransactionDetails('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlAccountList option[value='0']").prop("selected","selected");
	$j("#ddlSubledgerList option[value='0']").prop("selected","selected");
	var unitType = '<% out.print(unitType);%>';
	if(unitType == 'HO')
	{
		$j("#ddlLocation option[value='0']").prop("selected","selected");
	}
   
	
	nPageNo = pageNo;
	GetTransactionDetails('ALL');
}


function loadSubLedgerList()
{
	var subledger_array = new Array();
	<%	
	
	for(Object[] ob1 : accountList) // create an array for those crop that do not have any variety in data base
	{
		%>
		    	var temp_account_array_Id = '<%out.print(ob1[0]);%>'; // ob[1] stores all account id
		    	
		    	 subledger_array[temp_account_array_Id] = new Array(); 
		    		
		 	
		 
		<%
	}
	
	for(Object[] ob : subledgerList)
	{
		%>
		subledger_array[<%out.print(ob[0]);%>] = new Array(); 
		subledger_array[<%out.print(ob[0]);%>][0] = '<%out.print(ob[1]);%>';
		subledger_array[<%out.print(ob[0]);%>][1] = '<%out.print(ob[2]);%>';	  
		<%
	}
%>
	$j("#ddlSubledgerList").empty();
	var index = $j("#ddlAccountList").val();
	
	if(index > 0)
	{			
		
		if(!(subledger_array[index][0] == null))
			{
					var tempId = String(subledger_array[index][0]).split(",");
					var tempName = String(subledger_array[index][1]).split(",");
					if(tempId.length>0)
						{
							$j("#ddlSubledgerList").append("<option value='0'>Select</option>");
							for(var i=0; i<tempId.length; i++)
							{
								$j("#ddlSubledgerList").append("<option value='"+tempId[i]+"'>"+tempName[i]+"</option>");
							}
						}
					else
						{
							$j("#ddlSubledgerList").append("<option value='0'>No Record Found</option>");
						} 
			}
		else
			{
				$j("#ddlSubledgerList").append("<option value='0'>No Record Found</option>");
			}
		
		
	}
}



</script>

 <form id="popUpForm" name="popUpForm" method="post" target="mywindow">

 </form>

<style>
.tblSearchActions td {border-bottom:0 !important; border-right:0 !important;}
</style>
