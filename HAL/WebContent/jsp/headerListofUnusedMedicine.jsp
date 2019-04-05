
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.MasStoreSupplier" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>


<%
    String pageTitle = "";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();	
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	
	
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
	 if(map.get("supplierList") != null)
	 {
		 supplierList =  (List<MasStoreSupplier>)map.get("supplierList");	  
		   
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
<form name="UnusedMedicineList" method="post" action="">

 <div class="titleBg">
<h2>List Of Unsed Medicine</h2>
</div>

<div class="Block">

<%-- <label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear"  onchange="GetUnusedMedicineList('FILTER');">
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

<label>Vendor Name</label>
<select name ="ddlSupplier" id="ddlSupplier"  onchange ="GetUnusedMedicineList('FILTER');">
<option value="0">Select</option>
	<%
		if(supplierList.size()>0)
		{
			for(MasStoreSupplier sp : supplierList)
			{
				%>
					<option value="<%=sp.getId()%>"><%=sp.getSupplierName()%></option>
				<%
			}
		}
	%>
</select>


<label>Indent Status</label>
<select name ="ddlIndentStatus" id="ddlIndentStatus"  onchange ="GetUnusedMedicineList('FILTER');">
<option value="0">Select</option>
	<option value="P">Pending</option>
	<option value="R">Received</option>
</select>
 --%>



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
				
				<th id="th1">Date</th>
				<th id="th2">Receiving No.</th>
				<th id="th3">Total Amt</th>
				
				<th id="th7">Entered By</th>
				
				
				
			</tr>
			<tbody id="tblListOfUnusedMedicine">		
			
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
			GetUnusedMedicineList('ALL');
	
		});
		
function GetUnusedMedicineList(MODE)
{

	
	var departmentId = <%out.print(departmentId);%>;
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&departmentId="+departmentId+"&hospitalId="+hospitalId;
		}
	else
		{
			var data = "PN="+nPageNo+"&departmentId="+departmentId+"&hospitalId="+hospitalId;
		}
	var url = "stores?method=getListOfUnusedMedicine";
	var bClickable = true;
	GetJsonData('tblListOfUnusedMedicine',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{	
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].GRNNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].GRNNo+"</td>";			
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].TotalAmt+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].ReceivedBy+"</td>";
			
					
			
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='4'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfUnusedMedicine").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	ViewUnusedMedicine(Id);
}

function ViewUnusedMedicine(Id)
{

	window.location = "stores?method=ViewUnusedMedicine&headerId="+Id+"&appId=A1644";	
	
}


function showResultPage(pageNo)
{
	
	nPageNo = pageNo;	
	GetUnusedMedicineList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlRequestYear option[value='0']").prop("selected","selected");
	$j("#ddlSupplier option[value='0']").prop("selected","selected");
	
	nPageNo = pageNo;
	GetUnusedMedicineList('ALL');
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

