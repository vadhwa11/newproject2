<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<div class="titleBg"><h2>Pending List For Receipt Voucher Acceptance</h2></div>
<div class="clear"></div>
<form name="receiptVoucherAcceptance" method="post" action="">
<div class=Block>
<label><span>*</span>From Date:</label>
<input type="text" name="<%=FROM_DATE %>" id="fromDate" value="" class="calDate" tabindex=1 readonly="readonly" validate="From Date ,date,yes" MAXLENGTH="12" />

<label><span>*</span>To Date:</label>
<input type="text" name="<%=TO_DATE %>" id="toDate" value="" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="12" />
<input type="button" name="search" id="search" value="Search" class="button" onClick="showResultPage('1');" accesskey="a" tabindex=1 />
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
 
<div class="clear" style="padding-top: 5px;"></div>

		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td style="height: 25px;">
				<div id=resultnavigation></div>
				</td>
			</tr>
		</table>
	
  <table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<th class="firstColumn" id="th1">Date</th>
				<th id="th2">Voucher No</th>
				<th id="th3">Voucher Type</th>
				<th id="th4">Amout</th>		
				<th id="th5">Narration</th>			
			</tr>
			<tr>
			<tbody id="tblListOfpendingVoucher"></tbody>
			
</table>
</div>
 <div id="pageNavPosition"></div>

</form>


<script language="javascript">

var nPageNo=1;
var $j = jQuery.noConflict();

$j(document).ready(function()
		{
		getpendingListForReceiptVoucherAcceptance('ALL');
	
		});
		
function getpendingListForReceiptVoucherAcceptance(MODE)
{
	var data;
	var fromDate = document.getElementById('fromDate').value;
	var toDate= document.getElementById('toDate').value;
	if(MODE == 'ALL')
	{
		 data = "PN="+nPageNo+"&fromDate=0&toDate=0";
	}
	else{
		 data = "PN="+nPageNo+"&fromDate="+fromDate+"&toDate="+toDate;
	}
	
	var url = "account?method=pendingListForReceiptVoucherAcceptance";
	var bClickable = true;
	GetJsonData("tblListOfpendingVoucher",data,url,bClickable);
}
	
	function makeTable(jsonData)
	{
		
		var htmlTable = "";
		for(var i=0;i<jsonData.length;i++)
			{
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style='width: 80px;'>"+jsonData[i].VoucherNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 80px;'>"+jsonData[i].VoucherType+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Amount+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].Narration+"</td>";
			
			htmlTable = htmlTable+"</tr>";
			}
		if(jsonData.length == 0)
			{
			   htmlTable = htmlTable+"<tr><td colspan='6'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
			}
			htmlTable = htmlTable +"</table>";	
		
		$j("#tblListOfpendingVoucher").html(htmlTable);	
		
	}
	
	function executeClickEvent(Id)
	{
		var locationURL = "account?method=showApprovalJspForForReceiptVoucherAcceptance&headerId="+Id;
		submitFormForButton('receiptVoucherAcceptance',locationURL);
	}

		
function showResultPage(pageNo)
{
	nPageNo = pageNo;	
	getpendingListForReceiptVoucherAcceptance('FILTER');
}



function ShowAllList(pageNo)
{
	
	
	nPageNo = pageNo;
	$j("input[type='text']").val("");
	
	getpendingListForReceiptVoucherAcceptance('ALL');
}



</script>
