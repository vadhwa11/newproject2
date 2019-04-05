<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
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

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> map = new HashMap<String,Object>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		if (map.get("masStoreSupplierList")!=null)
			masStoreSupplierList = (List)map.get("masStoreSupplierList");
		
		if (map.get("masEmployeeList")!=null)
			masEmployeeList = (List)map.get("masEmployeeList");
	
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	} %>

<title>HOD's Recommendation</title>


<script>
function jsSubmit()
{
		if (HODRecommendationForm.<%=TENDER_CB_HOD_SUPPLIER_ID%>.value=="" ||
			HODRecommendationForm.<%=TENDER_CB_HOD_SPECIALIST%>.value=="" ||
			HODRecommendationForm.<%=TENDER_CB_HOD_REMARKS%>.value=="")
			{
			alert("Pl. check your input.....");
			return;
			}
		HODRecommendationForm.method="post";
		submitForm('HODRecommendationForm','tender?method=addHODRecommendation');
}


function jsClose()
{
  window.opener.location.href = "tender?method=getTenderCommercialBidGrid&<%=TENDER_NO%>="+HODRecommendationForm.<%=TENDER_NO%>.value + "&<%=TENDER_SUPPLIER_GROUP_ID%>=" + HODRecommendationForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value + "&<%=TENDER_PVMS%>=" + HODRecommendationForm.<%=TENDER_PVMS%>.value; 
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 }
  window.close();
} 

</script>

<div id="contentHolder">
<h6>HOD's Recommendation</h6>
<div class="Clear"></div>

<form name="HODRecommendationForm"><input type="hidden"
	name="<%=TENDER_NO%>" value="<%=box.get(TENDER_NO) %>"> <input
	type="hidden" name="<%=TENDER_SUPPLIER_GROUP_ID%>"
	value="<%=box.get(TENDER_SUPPLIER_GROUP_ID)%>"> <input
	type="hidden" name="<%=TENDER_PVMS%>" value="<%=box.get(TENDER_PVMS)%>">

<div class="blockTitle">HOD's Recommendation</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrameSm"><label>Firm Name :</label> <select
	name="<%=TENDER_CB_HOD_SUPPLIER_ID%>">
	<option value="">Select Firm</option>
	<%
		for (Iterator iterator = masStoreSupplierList.iterator(); iterator.hasNext();) 
		{
			MasStoreSupplier masStoreSupplier = (MasStoreSupplier)iterator.next();
		%>
	<option value="<%=masStoreSupplier.getId()%>"
		<%=HMSUtil.isSelected(masStoreSupplier.getId(),Integer.valueOf(box.getInt(TENDER_CB_HOD_SUPPLIER_ID)))%>><%=masStoreSupplier.getSupplierName()%></option>
	<%
		}
		%>
</select> <label>Specialist :</label> <select
	name="<%=TENDER_CB_HOD_SPECIALIST%>">
	<option value="">Select Specialist</option>
	<%
		for (Iterator iterator = masEmployeeList.iterator(); iterator.hasNext();) 
		{
			MasEmployee masEmployee = (MasEmployee)iterator.next();
		%>
	<option value="<%=masEmployee.getId()%>"
		<%=HMSUtil.isSelected(masEmployee.getId(),Integer.valueOf(box.getInt(TENDER_CB_HOD_SPECIALIST)))%>><%=masEmployee.getFirstName()%></option>
	<%
		}
		%>
</select>
<div class="Clear"></div>
<label>Remarks :</label> <textarea name="<%=TENDER_CB_HOD_REMARKS%>"
	cols="80" rows="2" maxlength="100" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" class="large2"
	onkeyup="finalCheck(this)"></textarea>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<input type="button" name="Update" id="addbutton" value="Submit"
	class="button" onClick="jsSubmit();" /> <input type="button"
	name="Close" value="Close" class="button" onclick="jsClose();" /></form>
</div>
