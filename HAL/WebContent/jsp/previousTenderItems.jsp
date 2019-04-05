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

<%
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

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script>

//this function will be called by the Bean (not from JSP)
   function onChange()
	{
	 if (TenderDocumentForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value=="")
	 {
	 alert("Please First select the Tender.");
	 TenderDocumentForm.<%=TENDER_NO %>.value = "";
	 return; 
	 }
	 var groupId=document.getElementById('groupId').value;
	  TenderDocumentForm.method="post";
	  submitForm('TenderDocumentForm','tender?method=showTenderDocumentJsp&jspName=PTI&groupId='+groupId);
	  //submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData&jspName=PTI&currPage=1&tenderId='+tenderNo);
	}

 function onTenderChange()
	{
	 var groupId=document.getElementById('groupId').value;
	  TenderDocumentForm.method="post";
	    //submitForm('TenderDocumentForm','tender?method=showTenderDocumentJsp&jspName=PTI&tenderId='+tenderNo);
	    submitForm('TenderDocumentForm','tender?method=showDocumentForTenderJspWithGridData&jspName=PTI&currPage=1&&groupId='+groupId);
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
	submitForm('TenderDocumentForm','tender?method=printTenderDocumentReportDrugSchedule&supplier_ids='+supplier_ids+'&ReportType=PTI');
	}
	else
	{
	alert('Select Supplier and press Update!... and Go for Printing!.......');
	}
	
}

</script>

<form name="TenderDocumentForm"><input type="hidden"
	name="numOfRows" size="5" value="15"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>">
<div id="contentHolder">
<h6>Previous Tender Items</h6>
<div class="Clear"></div>
<div class="blockTitle">Tender Document</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChange();"
	class="large2" id="groupId">
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
</select> <label>Tender No</label> <select name="<%=TENDER_NO%>" id='TenderNo'
	onChange="onTenderChange();">
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
</select>


<div class="Clear"></div>
</div>
<div class="Clear"></div>

<%
	 	if (pagedArray == null) {
		  } else { %> <%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    {
			    String disable = "";
			    if (gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS)!=null && gridData[i].get(TENDER_VENDOR_DOCUMENT_STATUS).toString().length()>0)
			    	disable = "disabled";
			    %> <input type="hidden" name=<%=TENDER_LETTERS_TO_BE_SENT%>
	value="<%=gridData[i].get(TENDER_VENDOR_SUPPLIER_ID)%>" <%=disable%>>
<% } %>

<div class="Clear"></div>
<input type="button" name="print_report2" onClick="showJasperReport2()"
	value="Drugs Schedule" class="buttonbig"> <%}%>
<div class="Clear"></div>
</div>
</form>
