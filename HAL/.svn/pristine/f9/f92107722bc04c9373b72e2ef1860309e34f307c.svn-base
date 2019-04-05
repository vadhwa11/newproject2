<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
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
    int deptId =0;
    String deptName = "";
    
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
 	//(session.getAttribute("deptName") != null){
//			deptName = (String) session.getAttribute("deptName");
//			System.out.println("deptName::"+deptName);
// 	}		
 	
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
	
	try {
	Vector supplier_ids = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("tender_letters_to_be_sent")!=null)
			supplier_ids = (Vector)map.get("tender_letters_to_be_sent");
		
		pagedArray = (PagedArray)map.get("pagedArray");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		masStoreFinancialList = (ArrayList)map.get("masStoreFinancialList");
  }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	}catch (Exception e) {
		e.printStackTrace();
	}
%>
<script>



	function onChange()
	{
	if (TenderCostingForm.<%=FINANCIAL_ID%>.value=="")
	{
	alert('Pl. Check Your Inputs for Financial Year');
	return;
	}
	if (TenderCostingForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value=="")
	{
	alert('Pl. Check Your Inputs for Tender Group');
	return;
	}
	
	
	TenderCostingForm.method="post";
	submitForm('TenderCostingForm','tender?method=showTenderCostingReportJsp&groupId='+TenderCostingForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value + '&financialId='+TenderCostingForm.<%=FINANCIAL_ID%>.value);

	}

	function validateButton()
	{
	
		if (TenderCostingForm.<%=FINANCIAL_ID%>.value=="" || TenderCostingForm.<%=TENDER_NO%>.value=="" || TenderCostingForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="" || TenderCostingForm.deptId.value == "" )
		{
		alert('Pl. Check Your Inputs (Financial Year & Tender No & Group & Store Type)');
		return false;
		}
	
		return true;
	}

	function printTenderDocument()
	{
	   if (validateButton())
		{
		    
			TenderCostingForm.method="post";
			submitForm('TenderCostingForm','tender?method=printTenderCostingReport&tendorNo='+TenderCostingForm.<%=TENDER_NO%>.value); 
		}
	}

 function onChangeTender()
{
    var w = document.getElementById('tender_no').selectedIndex;

	var selectedText = document.getElementById('tender_no').options[w].text;
    document.getElementById('tenderStr').value = selectedText;
} 

 function onChangeDept()
{
    var w = document.getElementById('deptId').selectedIndex;
    var selectedText = document.getElementById('deptId').options[w].text;
    document.getElementById('deptName').value = selectedText;
} 

</script>
<form name="TenderCostingForm">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>"> 
<input 	type="hidden" name="deptName" id="deptName"  value="">
<input 	type="hidden" name="date" size="5" value="<%=date%>">
<div id="contentHolder">

<h6>Tender Costing Report</h6>
<div class="Clear"></div>
<div class="blockTitle">Tender Costing</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<label>Financial Year</label>

<select	name= "<%=FINANCIAL_ID %>"  id="financialId" onChange="onChange();">
	<option value="">--Select Year--</option>
<%
		for (Iterator iterator = masStoreFinancialList.iterator(); iterator.hasNext();) 
		{
			MasStoreFinancial masStoreFinancial = (MasStoreFinancial)iterator.next();
%>
		<option value="<%=masStoreFinancial.getId()%>"<%=HMSUtil.isSelected(masStoreFinancial.getId(),Integer.valueOf(box.getInt(FINANCIAL_ID)))%>><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate())+" - "+HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getEndDate()) %></option>
<%
	}
%>
</select>


<label>Supplier Group</label>
 
<select	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChange();" id="groupId">
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
</select> 



<label>Tender No</label> 
<select name="<%=TENDER_NO%>" id="tender_no" 	onChange="onChangeTender();">
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
<label>Store Type</label> 
<select name="deptId" id="deptId" onChange = "onChangeDept();">
    <option value="">--Select Stores--</option> 
	<option value="24">Expandable Store</option>
	<option value="38">ECHS</option>
</select>

</div>
<div class="Clear"></div>
	<input type = "hidden" name="tenderStr" id="tenderStr" value="">
   <input type="button" name="print" id="print" value="Print" class="button" onClick="printTenderDocument()" accesskey="a" tabindex=1/>
</div>
</form>
