
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
<form name="QuotationList" method="post" action="">

 <div class="titleBg">
<h2>Vendor Quotation List</h2>
</div>

<div class="Block">

<label>Year:</label>

<select name ="ddlRequestYear" id="ddlRequestYear"  onchange="getMPRList(); GetEnquiryList('FILTER');">
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
<select name ="ddlSupplier" id="ddlSupplier"  onchange ="GetEnquiryList('FILTER');">
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

<div id="divMPRList">
	<label> MPR No  <span>*</span></label>
	<select	class="" name="mprNo" id="mprNo" validate="MPR No,String,no" tabindex=1>
		<option value="">Select MPR No</option>


</select>
</div>
<label> Quotation No  <span>*</span></label>
<input type="text" id="quotationNo" name="quotationNo"  onblur ="GetEnquiryList('FILTER');"/>

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
				
				<th id="th1">Enquiry/Quotation No</th>
				<th id="th2">Year</th>
				<th id="th2">MPR No</th>
				<th id="th2">Quotation Date</th>
				<th id="th3">Due Date</th>
				<th id="th4">Vendor Name</th>				
				<th id="th5">Prepared By</th>
				<th id="th6">Status</th>
				<th id="th6">Report</th>
				
			</tr>
			<tbody id="tblListOfEnquiry">		
			
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
			GetEnquiryList('ALL');
	
		});
		
function GetEnquiryList(MODE)
{
	
	var ddlRequestYear = $j("#ddlRequestYear").val();
	var mprNo = $j("#mprNo").val();
	var ddlSupplier = $j("#ddlSupplier").val();
	var quotationNo = $j("#quotationNo").val();
	
	if(quotationNo =="")
		{
		   quotationNo="NA";
		}
	
	
	var hospitalId = <%out.print(hospitalId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&ddlRequestYear=0&mprNo=0&ddlSupplier=0&quotationNo=NA";
		}
	else
		{
			var data = "PN="+nPageNo+"&ddlRequestYear="+ddlRequestYear+"&mprNo="+mprNo+"&ddlSupplier="+ddlSupplier+"&quotationNo="+quotationNo;
		}
	
	var url = "stores?method=getListOfEnquiry";
	var bClickable = false;
	GetJsonData('tblListOfEnquiry',data,url,bClickable);
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
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"' style='cursor: pointer;'>";
			htmlTable = htmlTable +"<td style='width: 150px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].QuotationNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].Year+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].MPRNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].QuotationDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].DueDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].vendorName+"</td>";			
			htmlTable = htmlTable +"<td style='width: 200px;' onclick='ViewUpdateVendorQuotation("+jsonData[i].Id+")'>"+jsonData[i].PreparedBy+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+Status+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'><input type='button' value='Print' class='button' onclick='generateReport("+jsonData[i].Id+")'</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfEnquiry").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	//alert("execute"+Id);
	ViewUpdateVendorQuotation(Id);
}

function ViewUpdateVendorQuotation(Id)
{

	window.location = "stores?method=ViewUpdateVendorQuotation&headerId="+Id+"&appId=A1523";	
	
}


function showResultPage(pageNo)
{
	
	nPageNo = pageNo;	
	GetEnquiryList('FILTER');
	
}

function ShowAllList(pageNo)
{	
	$j("#ddlRequestYear option[value='0']").prop("selected","selected");
	$j("#ddlSupplier option[value='0']").prop("selected","selected");
	$j("#quotationNo").val("");
	
	nPageNo = pageNo;
	GetEnquiryList('ALL');
}

function getMPRList()
{
	var yearId=$j("#ddlRequestYear").val();
	if(yearId !=0)
		{
			submitProtoAjaxWithDivName('QuotationList','/hms/hms/stores?method=getMPRListListbasedonYear&yearId='+yearId,'divMPRList');
		}
	
}

function generateReport(Id)
{
	//alert("Report"+Id);
	submitForm('QuotationList','/hms/hms/stores?method=generatevendorQuotationReport&headerId='+Id);
	return ;
}


</script>

