<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.MasStoreItem"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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

<style type="text/css">
html,body {
	overflow: auto;
}

#contentHolder {
	width: 600px;
}

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
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}

  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;

	String nomenclature = "";
	String pvms_no ="";
	String commonName = "";
	StringBuilder message = new StringBuilder();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}
	pagedArray = (PagedArray) map.get("pagedArray");

	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if(map.get("itemList") != null){
		itemList = (List<MasStoreItem>)map.get("itemList");
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if(map.get("message") != "" && map.get("message") != null){
		message = (StringBuilder)map.get("message");
	}

	if(map.get("nomenclature") != null){
		nomenclature = (String)map.get("nomenclature");
	}
	if(map.get("pvms") != null){
		pvms_no = (String)map.get("pvms");
	}
	if(map.get("commonName") != null){
		commonName = (String)map.get("commonName");
	}
	String hiddenFieldForRecords = "";
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
%>

<title>Item Search</title>

<script>

function addInParent(){
	if (document.mmfApprovalPopup.itemIdCheck.length)
	{
			var url;
			 for(var i = 0; i < document.mmfApprovalPopup.itemIdCheck.length; i++)
			 {
			  if (mmfApprovalPopup.itemIdCheck[i].checked == true){

				if(document.getElementById('pvms'+i).value != ""){
					window.opener.document.getElementById('pvmsNo').value=document.getElementById('pvms'+i).value;
					window.opener.document.getElementById('nomenclature').value=document.getElementById('nomenclature'+i).value;
					window.opener.document.getElementById('pvmsNo').focus();
					break;
				}

			  }
			 }

		  	window.close();
	}
}

 function goPage(pidx) {
		mmfApprovalPopup.currPage.value = pidx;
		mmfApprovalPopup.method="post";

		submitForm('mmfApprovalPopup','stores?method=searchItemForMMFApproval');

	}

</script>
<div id="contentHolder">
<%if(message.length() > 0){ %> <label class="noWidth"> <span>
<%=message%> </span> </label> <%} %>
<h6>Item Search</h6>

<form name="mmfApprovalPopup" method="post">
<div style="padding-left: 15px;">
<div class="blockTitle">Store Item(s) Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrameSm">
<label>Nomenclature:</label>
<input type="text" class="large" name="nomenclature" value="<%=nomenclature %>"	MAXLENGTH="30"
	onkeypress="submitenter(this,event,'stores?method=searchItemForMMFApproval&numOfRows=15&currPage=1')" />
<div class="Clear"></div>
<label>Common Name:</label>
<input type="text" name="<%=COMMON_NAME %>" value="<%=commonName%>" class="large" MAXLENGTH="30"
onkeypress="submitenter(this,event,'stores?method=searchItemForMMFApproval&numOfRows=15&currPage=1')"/>
<div class="Clear"></div>
<label>PVMS No:</label>
<input type="text" name="pvms"	value="<%=pvms_no %>" class="textbox_size20" MAXLENGTH="10"
onkeypress="submitenter(this,event,'stores?method=searchItemForMMFApproval&numOfRows=15&currPage=1')" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('mmfApprovalPopup','stores?method=searchItemForMMFApproval&numOfRows=15&currPage=1');" style="text-align: center; vertical-align: middle;" value="Search"	class="button" />

</div>

<div class="Clear"></div>
<%
		if (pagedArray == null) {
		%>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHholderCmnLarge2">
<table align="center" width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="30%">Common Name</th>
			<th width="30%">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found </td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>
<div class="blockTitle">Item Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHholderCmnLarge2">

<table align="center" width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="30%">Common Name</th>
			<th width="30%">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<%


		 gridData = (HashMap[])pagedArray.getPagedArray();
			int iFirstRow = pagedArray.getFirstRowIdx();

	   	 for(int i=0;i<gridData.length;i++)
	    	{
			    %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++ %>" size="2"
				name="srno" readonly="readonly" /></td>
			<td><input type="text" id="pvms<%=i %>" value="<%=gridData[i].get("pvmsNo" )%>"
				size="10" name="pvms" readonly="readonly" /></td>
			<td><input type="text" id="nomenclature<%=i %>"
				value="<%=gridData[i].get("nomenclature")%>" size="50"
				name="nomenclature" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("commonName")==null?"":gridData[i].get("commonName")%>" size="50"
				name="commonName" readonly="readonly" /></td>
			<td><input type="radio"
				value="<%=gridData[i].get("itemId")%>" size="50"
				name="itemIdCheck" /></td>

		</tr>


		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %>
<input type="button" name="Add" onClick="addInParent()" value="Add"
	class="button" /> </div>

<%}%> <script type="text/javascript">

			</script></form>
			</div>