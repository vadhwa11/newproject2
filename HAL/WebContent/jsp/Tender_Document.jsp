<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%  int c=0;
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("tender_letters_to_be_sent")!=null)
			supplier_ids = (Vector)map.get("tender_letters_to_be_sent");
		
		pagedArray = (PagedArray)map.get("pagedArray");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
  }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>
<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	TenderDocumentForm.currPage.value = pidx;
	TenderDocumentForm.method="post";
	submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData');
}


	function onChange()
	{
	if (TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value=="")
	{
	alert('Pl. Check Your Inputs (Tender No & Group)');
	return;
	}
	
	TenderDocumentForm.method="post";
	submitForm('TenderDocumentForm','tender?method=showTenderDocumentJsp&groupId='+TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
//	submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData&currPage=1');
	}

	function onChangeTender()
	{
	
	if (TenderDocumentForm.<%=TENDER_NO%>.value=="")
	{
	alert('Pl. Check Your Inputs (Tender No & Group)');
	return;
	}
	
	//TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
	TenderDocumentForm.method="post";
	submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData&currPage=1&groupId='+TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
	}

	function validateButton()
	{
	
		if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
		{
		alert('Pl. Check Your Inputs (Tender No & Group)');
		return false;
		}
	
		if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
		{
				 for(var i = 0; i < TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
				 {
				  if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].checked == true)
	             		return true;
				 }
		}
		else
		{
			if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.checked == true)
				return true;
		}
		alert('No Item(s) Selected !....');
		return false;
	}

	function printTenderDocument()
	{
		if (validateButton())
		{
			TenderDocumentForm.method="post";
			submitForm('TenderDocumentForm','tender?method=printTenderDocument');
		}
	}

/* function printReport()
{
TenderDocumentForm.method="post";
submitForm('TenderDocumentForm','tender?method=printTenderDocumentReport');
} */

	function showJasperReport()
	{
	
		if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
		{
		alert('Pl. Check Your Inputs (Tender No & Group)');
		return false;
		}
	
	var supplier_ids = "";
		if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
		{
				 for(var i = 0; i < TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
				 {
				  if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].disabled)
				  {
				  	  if (supplier_ids!="")  
				  	  	supplier_ids = supplier_ids + "," + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value; 
				  	  else
				  	   	supplier_ids = supplier_ids + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
				  }
				    
				 }
		}
		else
		{
			if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.disabled)
				supplier_ids = TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.value;
		}
		
		if (supplier_ids!="")
		{
		var pos = TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.selectedIndex;
		var element = document.getElementById("groupId"); 
		var group = element.options[pos].text;
		TenderDocumentForm.method="post";
		submitForm('TenderDocumentForm','tender?method=printTenderDocumentReport&supplier_ids='+supplier_ids + '&group='+group);
		}
		else
		{
		alert('Select Supplier and press Update!... and Go for Printing!.......');
		}
		
	}

	function showJasperReport1()
	{
	
		if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
		{
		alert('Pl. Check Your Inputs (Tender No & Group)');
		return false;
		}
	
	var supplier_ids = "";
		if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
		{
				 for(var i = 0; i < TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
				 {
				  if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].disabled)
				  {
				  	  if (supplier_ids!="")  
				  	  	supplier_ids = supplier_ids + "," + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value; 
				  	  else
				  	   	supplier_ids = supplier_ids + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
				  }
				    
				 }
		}
		else
		{
			if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.disabled)
				supplier_ids = TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.value;
		}
		
		if (supplier_ids!="")
		{
		TenderDocumentForm.method="post";
		submitForm('TenderDocumentForm','tender?method=printTenderDocumentReport&supplier_ids='+supplier_ids + '&document=yes');
		}
		else
		{
		alert('Select Supplier and press Update!... and Go for Printing!.......');
		}
		
	}



	function showJasperReport2()
	{
	
		if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
		{
		alert('Pl. Check Your Inputs (Tender No & Group)');
		return false;
		}
	
		var supplier_ids = "";
		if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length)
		{
				 for(var i = 0; i < TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.length; i++)
				 {
				  if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].disabled)
				  {
				  	  if (supplier_ids!="")  
				  	  	supplier_ids = supplier_ids + "," + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value; 
				  	  else
				  	   	supplier_ids = supplier_ids + TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>[i].value;
				  }
				    
				 }
		}
		else
		{
			if (TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.disabled)
				supplier_ids = TenderDocumentForm.<%=TENDER_LETTERS_TO_BE_SENT%>.value;
		}
		
		if (supplier_ids!="")
		{
		TenderDocumentForm.method="post";
		submitForm('TenderDocumentForm','tender?method=printTenderDocumentReportDrugSchedule&supplier_ids='+supplier_ids+'&ReportType=document');
		}
		else
		{
		alert('Select Supplier and press Update!... and Go for Printing!.......');
		}
		
	}
	
	function showJasperReport3(){
	if (TenderDocumentForm.<%=TENDER_NO%>.value=="" || TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
		{
		alert('Pl. Check Your Inputs (Tender No & Group)');
		return false;
	}
	
	TenderDocumentForm.method="post";
	submitForm('TenderDocumentForm','tender?method=printReportForVendor');
	}

</script>
<form name="TenderDocumentForm"><input type="hidden"
	name="numOfRows" size="5" value="15"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>">
<div id="contentHolder">
<h6>Tender Document</h6>
<div class="Clear"></div>
<div class="blockTitle">Tender Document</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChange();"
	id="groupId">
	<option value="">--Select Group--</option>
	<%
		for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
		{
			MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
		%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
		}
		%>
</select> <label>Tender No</label> <select name="<%=TENDER_NO%>"
	onChange="onChangeTender();">
	<option value="">--Select Tender No--</option>
	<%
		for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
		{
			StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
		%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
		}
		%>
</select></div>
<div class="Clear"></div>
<%  String t = "false";
		if (pagedArray == null) {
		%>

<div class="blockTitle">Vendor/Supplier</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sr No.</th>
			<th width="10%"><input type="checkbox" class="checkbox"
				onclick="checkAll();" /></th>
			<th width="30%">Vendor Name</th>
			<th width="14%">Address</th>
			<th width="20%">Contact No</th>
			<th width="26%">Invitation Sent On</th>
			<th width="26%">Tender Document Sent On</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>
<div class="blockTitle">Vendor/Supplier</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sr No</th>
			<th width="5%"><input type="checkbox" id="selectBox"
				name="selectBox" class="checkbox" onclick="checkAll();" /></th>
			<th width="30%">Vendor Name</th>
			<th width="14%">Address</th>
			<th width="20%">Contact No</th>
			<th width="26%">Invitation Sent On
			</td>
			<th width="26%">Tender Document Sent On</th>
		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			    String disable = "";
			    if (gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS)!=null && gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS).toString().length()>0)
			    {	disable = "disabled";
			    %>
		<input type="hidden" name="con" id="con" value="<%=disable%>">
		<%}else{
			     t= "true";
			 	 c++;
			    %>
		<input type="hidden" name="con" id="con" value="">
		<%}%>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_VENDOR_SRNO%>" readonly="readonly" size="3" /></td>
			<td width="5%" align="center"><input type="checkbox"
				id="tender_letters_to_be_sent<%=c%>"
				name=<%=TENDER_LETTERS_TO_BE_SENT%>
				value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>" <%=disable%>>
			</td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_VENDOR_NAME)%>"
				name="<%=TENDER_VENDOR_NAME%>" readonly="readonly" size="50" /></td>
			<td width="14%"><textarea name="<%=TENDER_VENDOR_ADDRESS%>"
				cols="50" rows="1" onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onkeydown="return checkMaxLength(this)" class="large"
				onkeyup="finalCheck(this)" readonly><%=gridData[i].get(TENDER_VENDOR_ADDRESS)==null?"":gridData[i].get(TENDER_VENDOR_ADDRESS)%></textarea></td>
			<td width="20%"><input type="text"
				value="<%=gridData[i].get(TENDER_VENDOR_CONTACT_NO)%>"
				name="<%=TENDER_VENDOR_CONTACT_NO%>" readonly="readonly" /></td>
			<td width="26%"><label><%=(gridData[i].get(TENDER_VENDOR_INVITATION_STATUS)==null)?"":gridData[i].get(TENDER_VENDOR_INVITATION_STATUS)%></label></td>
			<td width="26%"><label><%=(gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS)==null)?"":gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS)%></label></td>
			<td><input type="hidden"
				value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>"
				name="<%=TENDER_VENDOR_SUPPLIER_ID%>" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<input type="hidden" id="countVal" value="<%=c%>" /> <input
	type="hidden" id="chkStatus" value="no" /> <input type="button"
	name="print_tender_document" onClick="printTenderDocument()"
	value="Update" class="button"> <!--<input type="button" name="print_report" onClick="showJasperReport()" value="Print Report" class="button">
				--> <input type="button" name="print_report1"
	onClick="showJasperReport1()" value="Print Document" class="buttonbig">
<input type="button" name="print_report2" onClick="showJasperReport2()"
	value="Drugs Schedule" class="buttonbig"> <input type="button"
	name="print_report2" onClick="showJasperReport3()"
	value="Vendor List(in XLS)" class="buttonbig">
<div class="Clear"></div>
<%}%>
</div>
</form>
<script>
function checkAll(){
 var check = document.getElementById('con').value;
 var temp = <%=t%>;
 if(temp)
 {
 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
    for(var i=1;i<=document.getElementById("countVal").value;i++){
      document.getElementById("tender_letters_to_be_sent"+i).checked =true
    }
  } else{
   document.getElementById("chkStatus").value ="no"
     for(var i=1;i<=document.getElementById("countVal").value;i++){
      document.getElementById("tender_letters_to_be_sent"+i).checked =false
      }
  }
 }else{
 alert("All Vendor/Supplier are Invited");
 document.getElementById("selectBox").checked =false
 }
}

</script>
