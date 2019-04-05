<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
<%@page import="jkt.hms.masters.business.MasApprovalStatus"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
	serverdate = '<%=curDate+"/"+month+"/"+year%>';
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherHeader> voucherHeader = new ArrayList<FaVoucherHeader>();
	List<MasApprovalStatus> approvalStatusList = new ArrayList<MasApprovalStatus>();
	
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>)request.getAttribute("map");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	
	 if(map.get("voucherDetailList") != null){
		 voucherDetailList = (List<FaVoucherDetails>)map.get("voucherDetailList");
		}
	 
	
	 int locationId=0;
	 if(map.get("locationId") != null)
	 {
		 locationId =  (Integer)map.get("locationId");	  
		  
	  }
	 

%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4>Receipt Voucher Acceptance</h4>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<form name="receiptVoucherAcceptance" method="post" action="">
<div class="Block">
<div class="clear"></div>

<table id="receiptVouchertbl"  cellspacing="0" cellpadding="0" border="0">
			<tr id="th">
				<th style="width:80px;">Date</th>
				<th style="width:150px;">A/C Name</th>
				<th style="width:150px;">Subledger Name</th>
				<th style="width:100px;">Dr Amount</th>
				<th style="width:200px;">Narration</th>
			</tr>
			
	<tbody>

	<%
	int i = 1;
	if(voucherDetailList.size()>0){
			for(FaVoucherDetails voucherDetail :voucherDetailList){
				int detailId = voucherDetail.getId();
				int headerId = voucherDetail.getVoucherHeader().getId();%>

	<%if(detailId !=0){%>
	<tr id="<%=detailId%>">
	<td><input  readonly type="text" name="date<%=detailId%>" id="date<%=detailId%>" value="<%=HMSUtil.convertDateToStringTypeDateOnly(voucherDetail.getVoucherHeader().getVoucherDate())%>" tabindex="1"  validate="Date,string,no" /></td>
	<td><input  readonly type="text" name="accountName<%=detailId%>" id="accountName<%=detailId%>" value="<%=voucherDetail.getAccount().getAccDesc()%>" tabindex="1"  validate="Date,string,no" /></td>
	<td><input  readonly type="text" id="drSubLed<%=detailId %>" name="drSubLed<%=detailId %>" value="<%=voucherDetail.getSubLed()!=null?voucherDetail.getSubLed().getSubLedDesc():"" %>"/>
	<td><input  readonly type="text" id="amount<%=detailId %>" name="amount<%=detailId %>" value="<%=voucherDetail.getDrAmount() %>"/>
	<td><input  readonly type="text" name="voucherNarrationId<%=detailId%>"  id="voucherNarrationId<%=detailId%>" value="<%=voucherDetail.getVoucherHeader().getNarration() %>" maxlength="100" value=""  class="medium" validate="Narration,string,yes"/></td>
	<%}%>
	</tr>
	<input type="hidden" id="voucherHeaderId" name="voucherHeaderId" value="<%=headerId %>"/>
<%i++;}}%>

</tbody>
</table>
</div>

<div class="clear"></div>
  <input type="hidden" id="tableRowId" name="tableRowId" value="1"/>
  <input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="submitForm('receiptVoucherAcceptance','account?method=submitReceiptVoucherAcceptance')" accesskey="a" tabindex=1 />
  <input type="button" name="backButton" id="backButton"  value="Back" class="button" onclick="window.history.back();" accesskey="r" />

<div class="clear"></div>
<div class="bottom">
	<label>Changed By</label>
	<label class="value"><%=userName %> </label>
	<label>Changed Date</label>
	<label class="value"><%=date%></label>
	<label>Changed Time</label>
 	<label class="value"><%=time%></label>
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
 	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
  	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
<div class="clear"></div>

<script language="javascript">

var nPageNo=1;
var $j = jQuery.noConflict();

$j(document).ready(function(){
	
	var tableId = 'receiptVouchertbl';
	var j= $j("#"+tableId+" tr:last").attr("id");	
	if(j == "th")
	{
		
	}
else
	{
		j=j*1;
		
	}
	  var valRowId = new Array();
		$j("#"+tableId+" tr[id!='th']").each(function(j)
				{				
					valRowId[j] =$j(this).attr("id");
				});
		$j("#tableRowId").val(valRowId);
	
		});
</script>

</form>