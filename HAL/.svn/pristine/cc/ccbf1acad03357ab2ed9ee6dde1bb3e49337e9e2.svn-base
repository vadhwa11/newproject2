
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
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
	 if(map.get("deptList") != null)
	 {
		 deptList =  (List<MasDepartment>)map.get("deptList");  		 
		   
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
<form name="actionTakenforDrugs" method="post" action="">

 <div class="titleBg">
<h2><%=pageTitle %></h2>
</div>


<div class="Block">

<label>Department:</label>

<select name ="fromDepartment" id="fromDepartment"  onchange ="GetList('FILTER');">
<option value="0">Select</option>
	<%
		if(deptList.size()>0)
		{
			for(MasDepartment dept : deptList)
			{
				%>
					<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
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
			
				<th id="th0" style="width: 20px">Select</th>				
				<th id="th1">Mat Code</th>
				<th id="th2">Nomenclature</th>
				<th id="th2">Batch No</th>
				<th id="th3">Expiry Date</th>
				<th id="th4">Brand</th>				
				<th id="th5">Received Qty</th>
				<th id="th5">From Department</th>
				<th id="th6">Received By</th>
				<th id="th7">Received Date</th>
				
			</tr>
			<tbody id="tblListOfDrugs">		
			
			</tbody>
			
			
			</table>
			
	</div>
	
			
			

</div>
 <div id="pageNavPosition"></div>
 

<label>Select Decision</label>
<select id="DecisionTaken" name="DecisionTaken" validate="Decision Taken ,String,yes">
<option value='Disposal'>Disposal</option>
<option value='Return to Vendor'>Return to Vendor</option>
</select>
<label>Remarks</label>
	
<textarea  name="DecisionRemarks" validate="Decision Remarks ,String,yes" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/></textarea> 


<input type="button" name="Submit"  class="button" value="Submit" onclick="submitActionTakenForm('actionTakenforDrugs','stores?method=submitActionDetailsofDrugsDisposal');"/>

<input type="hidden" id="tableRowId" name="tableRowId" />
	<input type="hidden" id="txtRequestType" name="txtRequestType" />
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			GetList('ALL');
	
		});
		
function GetList(MODE)
{	
		
	var hospitalId = <%out.print(hospitalId);%>;

	var fromDepartment = $j("#fromDepartment").val();
	
	
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&fromDepartment=0&hospitalId="+hospitalId;
		}
	else
		{
			var data = "PN="+nPageNo+"&fromDepartment="+fromDepartment+"&hospitalId="+hospitalId;
		}
	var url = "stores?method=getPendingListofActionofDrugDisposal";
	var bClickable = false;
	GetJsonData('tblListOfDrugs',data,url,bClickable);
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
			htmlTable = htmlTable +"<td ><input type='checkbox' style='width: 5px; margin-right:5px;' class='small_chk' id='chk' value='"+jsonData[i].Id+"' /></td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].MatCode+"</td>";
			htmlTable = htmlTable +"<td style='width: 250px;'>"+jsonData[i].Item+"</td>";
			
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].BatchNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].ExpiredDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Brand+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ReceivedQty+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].FromDepartment+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].ReceivedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].ReceivedDate+"</td>";
		
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfDrugs").html(htmlTable);	
	
	
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
	GetList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlDepartment option[value='0']").prop("selected","selected");
		
	nPageNo = pageNo;
	GetList('ALL');
}

function submitActionTakenForm(formName,url)
{
	$j("#txtRequestType").val("SUBMIT");
	 
	 var valCheckBox = new Array();
		$j('[id="chk"]:checked').each(function(j)
				{
					
					valCheckBox[j] = $j(this).val();
				});
		$j("#tableRowId").val(valCheckBox);
			
		 submitForm(formName,url);
	
}


</script>

