
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
<form name="POList" method="post" action="">

 <div class="titleBg">
<h2>Purchase Order List</h2>
</div>

<div class="Block">

<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear"  onchange="GetPOList('FILTER');">
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
<select name ="ddlSupplier" id="ddlSupplier"  onchange ="GetPOList('FILTER');">
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

<!-- <div id="divMPRList">
	<label> PO No </label>
	<select	class="" name="poNo" id="poNo" validate="MPR No,String,yes" tabindex=1>
		<option value="">Select MPR No</option>


</select>
</div> -->


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
				
				<th id="th1">PO No</th>
				<th id="th2">Year</th>
				<th id="th2">PO Date</th>
			
				<th id="th3">Quotation No</th>
				<th id="th3">Reference No</th>
				<th id="th4">Vendor Name</th>				
				<th id="th5">Prepared By</th>
				<th id="th6">Status</th>
				
			</tr>
			<tbody id="tblListOfPO">		
			
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
			GetPOList('ALL');
	
		});
		
function GetPOList(MODE)
{
	
	var ddlRequestYear = $j("#ddlRequestYear").val();
	
	var ddlSupplier = $j("#ddlSupplier").val();
	
	
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&ddlRequestYear=0&ddlSupplier=0";
		}
	else
		{
			var data = "PN="+nPageNo+"&ddlRequestYear="+ddlRequestYear+"&ddlSupplier="+ddlSupplier;
		}
	var url = "stores?method=getListOfPurchaseOrder";
	var bClickable = true;
	GetJsonData('tblListOfPO',data,url,bClickable);
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
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].PONo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Year+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].PODate+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].QNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].RefNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].vendorName+"</td>";			
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].PreparedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+Status+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfPO").html(htmlTable);	
	
	
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
	GetPOList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlRequestYear option[value='0']").prop("selected","selected");
	$j("#ddlSupplier option[value='0']").prop("selected","selected");
	
	nPageNo = pageNo;
	GetPOList('ALL');
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

