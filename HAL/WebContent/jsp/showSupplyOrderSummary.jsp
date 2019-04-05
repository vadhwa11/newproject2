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
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
int dateOfMonth, month1, year1;
Calendar calendar1 = Calendar.getInstance();
StringBuffer dateOnly = new StringBuffer();
month1 = calendar.get(Calendar.MONTH) + 1;
if(month1 > 0 && month1 < 4){
	year1 = calendar.get(Calendar.YEAR) - 1;	
}else{
	year1 = calendar.get(Calendar.YEAR);	
}


dateOnly.append("01");
dateOnly.append("/");
dateOnly.append("04");
dateOnly.append("/");
dateOnly.append(year1);

  String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
 	if (map.get("masStoreGroupList") != null){
 		System.out.println("in side if loop");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
 	}
   }	
 	System.out.println("in jsp list size::::::::"+masStoreGroupList.size());
 	String message = null;
	
%>


<script>

function showReport()
{
//if (SupplyOrderSummary.<%=FROM_DATE%>.value != "" || SupplyOrderSummary.<%=TO_DATE %>.value == "" )
//{
//alert('Pl. Check Your Inputs ');
//return;
//}
var group;
if(document.getElementById('groupId').value != ""){
        var pos = SupplyOrderSummary.<%=TENDER_SUPPLIER_GROUP_ID %>.selectedIndex;
		var element = document.getElementById("groupId"); 
		group = element.options[pos].text;
}		

SupplyOrderSummary.method="post";
submitForm('SupplyOrderSummary','tender?method=generateSupplyOrderSummaryReport&groupName='+group);
}
</script>

<form name="SupplyOrderSummary"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>">

<div id="contentHolder">
<h6>Supply Order Summary</h6>
<div class="Clear"></div>
<div class="blockTitle">Supply Order Summary</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="large">From Date</label> <input
	type="text" id="FromDateId" name="<%=FROM_DATE %>"
	value="<%=dateOnly %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderSummary.<%=FROM_DATE%>,event)" />

<label class="large">To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderSummary.<%=TO_DATE%>,event)" />

<div class="Clear"></div>
<div class="Height10"></div>

<label class="large">Supply Order No. From </label> <input type="text"
	id="SoNFrom" name=<%=SUPPLYNOFROM%> value="" MAXLENGTH="30" /> <label
	class="large">Supply Order No. To </label> <input type="text"
	id="SoNTo" name=<%=SUPPLYNOTO%> value="" MAXLENGTH="30" />

<div class="Clear"></div>
<label class="large">Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>" id="groupId" onChange=""
	class="large2">
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
<div class="Clear"></div>
<label class="large">Supplier/Vendor</label> <input type="text" value=""
	class="large2" id="<%=TENDER_VENDOR_SUPPLIER_ID%>"
	name="<%=TENDER_VENDOR_SUPPLIER_ID%>" />
<div id="ac2update" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=TENDER_VENDOR_SUPPLIER_ID%>','ac2update','tender?method=getSupplierListByAutocomplete',{parameters:'requiredField=<%=TENDER_VENDOR_SUPPLIER_ID%>'});
		</script>

<div class="Clear"></div>
</div>
<input type="button" name="report" onClick="showReport()" value="Submit"
	class="button">
<div class="Clear"></div>
</div>
</form>
