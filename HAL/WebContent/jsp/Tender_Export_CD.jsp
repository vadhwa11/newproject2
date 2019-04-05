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
	String message = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		
		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>


<script>

function createSoftCopy()
{

if (ExportCDForm.<%=TENDER_NO%>.value=="" || ExportCDForm.<%=TENDER_SUPPLIER_GROUP_ID %>.value=="")
{
alert('Pl. Check Your Inputs (Tender No & Group)');
return;
}

ExportCDForm.method="post";
submitForm('ExportCDForm','tender?method=createScheduleSoftCopy');
}

function onChangeTender()
{
//ExportCDForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
ExportCDForm.method="post";
submitForm('ExportCDForm','tender?method=showExportCDJsp&groupId='+ExportCDForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value);
}
</script>
<form name="ExportCDForm"><input type="hidden" name="hospitalId"
	size="5" value="<%=hospitalId%>"> <input type="hidden"
	name="date" size="5" value="<%=date%>">
<div id="contentHolder">
<h6>Export Tender Data</h6>
<div class="Clear"></div>
<div class="blockTitle">Export Tender Data</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID %>" onChange="onChangeTender();"
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
</select> <label>Tender No</label> <select name="<%=TENDER_NO%>">
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
<input type="button" name="softcopy" onClick="createSoftCopy()"
	value="Submit" class="button">
<div class="Clear"></div>
</div>
</form>
