<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<style>
html,body {
	overflow: auto;
}
</style>
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
	int deptId = 0;
	String manufacturer_lab_practice = "";
	String standing_certificate="";
	String no_conviction_issued="";
	String status="";
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	
  	Map map = new HashMap();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
	List objectList = new ArrayList();

	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("storeTenderMList") != null)
		{
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		System.out.println("inside jsp" + storeTenderMList.size());
		}
	
		if (map.get("masStoreGroupList") != null)
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		
		if (map.get("masStoreSupplierList") != null)
		masStoreSupplierList = (ArrayList)map.get("masStoreSupplierList");
		
		if (map.get("objectList") != null)
			objectList = (List)map.get("objectList");
		
		
		if (map.get("pagedArray") != null)
			pagedArray = (PagedArray)map.get("pagedArray");
  }
	
	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 		
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>



<script>

function onChangeTender()
{
TenderLPOForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
TenderLPOForm.method="post";
submitForm('TenderLPOForm','tender?method=getTenderGroupListForLPO');
}

function onChangeGroup()
{
TenderLPOForm.method="post";
submitForm('TenderLPOForm','tender?method=getTenderSupplierListForLPO');
}

function openPopupWindow(supplierId,amount)
{TenderLPOForm.method="post";

 
 var deptId = TenderLPOForm.deptId.value;
 var noteNo=TenderLPOForm.noteNo.value;
var tenderId=TenderLPOForm.tenderId.value;
 var url="/hms/hms/tender?method=showSupplyOrderSplitUpForLpoNote&noteNo="+noteNo+"&supplierId="+ supplierId + "&deptId=" + deptId+"&tenderId="+tenderId;
 newwindow=window.open(url,'name','top=10, left=10, height=500,width=1000,status=1');
}

</script>

<form name="TenderLPOForm"><input type="hidden" name="numOfRows"
	size="5" value="20"> <input type="hidden" name="pageCount"
	size="5" value="10"> <input type="hidden" name="hospitalId"
	size="5" value="<%=hospitalId%>"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="noteNo" size="5" value="<%=box.get("noteNo")%>">
<input type="hidden" name="tenderId" size="5"
	value="<%=box.get("tenderId")%>"> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div id="contentHolder">
<h6>Tender - SO For L1</h6>
<div class="Clear"></div>
<% if (pagedArray !=null && map.get("status").toString().equalsIgnoreCase("o")) 
		{ %> <input type="button" name="Submit" onClick="onUpdate()"
	value="Update" class="button" accesskey="u" /> <!--  <input type="button" name="Generate LPO" onClick="generateLPO()" value="Generate LPO" class="button" accesskey="o" />  -->
<% } else {%> <!-- <input type="button" name="Print LPO" onClick="printLPO()" value="Print LPO" class="button" accesskey="o" /> -->
<% } %>
<div class="Clear"></div>


<%
		if (objectList == null) {
		%>
<div class="blockTitle">Vendor Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Vendor Name</th>
			<th>No. Of Items</th>
			<th>Total Amount</th>
			<th>Supply Order</th>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<%  } else { %>
<div class="blockTitle">Vendor Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHholderCmnLarge2">
<table width="100%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Vendor Name</th>
			<th>No. Of Items</th>
			<th>Total Amount</th>
			<th>Supply Order</th>
		</tr>
	</thead>
	<tbody>

		<%
			    int slno=0; 
			    for (Iterator iterator = objectList.iterator(); iterator.hasNext();) 
			    {
			    	Object[] obj = (Object[]) iterator.next();
			    %>
		<tr>
			<td><%=++slno%></td>
			<td><%=obj[0]%></td>
			<td><%=obj[1]%></td>
			<td><%=obj[2]%></td>
			<td><input type="button" name="Supply Order"
				onClick="openPopupWindow(<%=obj[3]%>,<%=obj[2]%>)"
				value="Supply Order" class="cmnButton" accesskey="o" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<% } %>
</div>
</form>
