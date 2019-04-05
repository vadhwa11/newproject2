
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
<form name="PasswordReset" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">



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
				<th style='width: 20px;'>Select User <input type="checkbox" onclick='checkAll(); getId();' id="chkAll"/></th>	
				<th id="th1">Employee No</th>
				<th id="th2">Name</th>
				<th id="th3">Designation</th>
				<th id="th4">Request Date</th>
				<th id="th5">Reset Count</th>				
				
				
				
			</tr>
			<tbody id="tblListOfPasswordReset">		
			
			</tbody>
			</table>
		<input type="hidden" id="tableRowId" name="tableRowId" />	
		
		<input type="button" name="Submit"  class="button" value="Submit" onclick="submitResetDetails('PasswordReset','user?method=submitResetDetails');"/>

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
			GetPasswordResetList('ALL');
	
		});
		
function GetPasswordResetList(MODE)
{

	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&Status=ALL";
		}
	else
		{
			var data = "PN="+nPageNo+"&Status=ALL";
		}
	var url = "user?method=getListOfPasswordReset";
	var bClickable = false;
	GetJsonData('tblListOfPasswordReset',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			
		htmlTable = htmlTable + "<tr id='"+jsonData[i].Id+"' >";
		htmlTable = htmlTable+ "<td style='width: 20px;'><input type='checkbox' name='chk"+i+"' id='chk'  onclick='getUserId();' style='margin-right:0px;' value='"	+ jsonData[i].Id + "'/></td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].EmployeeNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].Name+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Designation+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Count+"</td>";
			
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfPasswordReset").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	ViewUpdateMR(Id);
}




function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetPasswordResetList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	
	nPageNo = pageNo;
	GetPasswordResetList('ALL');
}


function getUserId()
{		
	 var valCheckBox = new Array();
		$j('[id="chk"]:checked').each(function(j)
				{
					
					valCheckBox[j] = $j(this).val();
				});
		$j("#tableRowId").val(valCheckBox);
		/* if(valCheckBox.length>0)
		checkValidationforSelectedRecords(); */
}


function submitResetDetails(formName,url)
{
	
	getUserId();
	
			
	var tempVal= $j("#tableRowId").val();
	if(true)
		{
				if(tempVal.length>0)
				{
					submitForm(formName,url);
				}
			else
				{
					alert("Please select at least one record");
					return;
				}	
		}

	
	
}


</script>

