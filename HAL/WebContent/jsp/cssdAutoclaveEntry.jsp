<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String orderNo = "";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");  
%>

<script language="javascript">

function validateRadio()
{
			
			 for(var i = 0; i < document.getElementsByName('requestId').length; i++)
			 {
				  if(document.getElementsByName('requestId')[i].checked == true)
    	          {
					return true;
				  }		
  			 }
  			alert("Pl Select any Order No to Proceed!...")
			return false;
		
}

function submitPendingRequest()
{
if (validateRadio())
{
autoclavePendingForm.method="post"; 
submitForm('autoclavePendingForm','cssd?method=showAutoclaveEntryDetailJsp')
}
}

</script>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="autoclavePendingForm">
<h6>Autoclave Entry</h6>
<div class="Clear"></div>

<!--Block Two Starts-->
<div id="testDiv">
<div class="division"></div>
<div class="blockTitle">Pending for Autoclave Entry</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Height10"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Select</th>
		<th>Order No</th>
		<th>Order Date</th>
		<th>Department</th>
	</tr>
	<% if (cssdAutoclaveRequestMList!=null && cssdAutoclaveRequestMList.size() > 0 ) 
 { %>
	<% for(CssdAutoclaveRequestM cssdAutoclaveRequestM : cssdAutoclaveRequestMList) { %>
	<tr>
		<td><input type="checkbox" name="requestId"
			value="<%=cssdAutoclaveRequestM.getId()%>" /></td>
		<td><%=cssdAutoclaveRequestM.getOrderNo()%></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(cssdAutoclaveRequestM.getOrderDate())%></td>
		<td><%=cssdAutoclaveRequestM.getDepartment().getDepartmentName()%></td>
	</tr>
	<% } %>
	<% } else {  %>
	<tr>
		<td colspan=4>No Pending Found for Autoclave Entry</td>
	</tr>
	<% } %>

</table>
</div>
</div>
</div>

<!--Bottom labels starts-->
<div class="Division"></div>
<div class="bottom"><input name="Button2" type="button"
	class="button" value="Go" onClick="submitPendingRequest();" /></div>
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
</div>


