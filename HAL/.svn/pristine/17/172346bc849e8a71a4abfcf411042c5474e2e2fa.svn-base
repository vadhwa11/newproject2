<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
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
	System.out.println("box inside jsp" + box);
	
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
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>(); 
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		storeMmfDepartmentTList = (List)map.get("storeMmfDepartmentTList");
	}
	
%>

<title>MMF Department Wise Split Up</title>


<script>

function jsClose()
{
  window.close();
}
</script>

<br />

<h2 align="left" class="style1">MMF - Department Wise Split Up</h2>
<br />

<%
	String pvmsno = "";
	String nomenclature="";
	try
	{
	pvmsno=storeMmfDepartmentTList.get(0).getItem().getPvmsNo();
	}
	catch(Exception e)
	{
	pvmsno=map.get("pvmsno").toString();
	}

	
	try
	{
	nomenclature=storeMmfDepartmentTList.get(0).getItem().getNomenclature();
	}
	catch(Exception e)
	{
	nomenclature=map.get("nomenclature").toString();
	}

%>
<div id="contentspace"><label class="bodytextB">PVMS No </label> <input
	type="text" value="<%=pvmsno%>" size="10" name="pvmsno"
	readonly="readonly" /> <br />
<label class="bodytextB">Nomenclature</label> <input type="text"
	value="<%=nomenclature%>" size="115" name="nomenclature"
	readonly="readonly" /> <br />
<br />

<form name="mmfForm">

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF - Dept Wise Split Up</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: scroll; overflow-x: scroll; width: 83%; BORDER: #202020 1px solid;">
<table align="left" width="50%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Department</label></td>
			<td width="15%"><label valign="left" class="smalllabel">MMF
			[For the Year <%=map.get("year")%>]</label></td>
		</tr>
	</thead>
	<tbody>

		<%
			  if (storeMmfDepartmentTList!=null && storeMmfDepartmentTList.size() > 0)
			  {
					  StoreMmfDepartmentT storeMmfDepartmentT = new StoreMmfDepartmentT(); 
					  int srno=1;
					    for(int i=0;i<storeMmfDepartmentTList.size();i++)
					    {
					    	storeMmfDepartmentT = storeMmfDepartmentTList.get(i);
				    	%>
		<tr>
			<td width="5%"><label valign="left" class="smcaption"><%=srno++%></label></td>
			<td width="10%"><label valign="left" class="medcaption"><%=storeMmfDepartmentT.getStoreMmfDepartmentM().getStoreWardDept().getDepartmentName()%></label></td>
			<td width="10%"><label valign="left" class="medcaption"><%=storeMmfDepartmentT.getMmfInQty()%></label></td>
		</tr>
		<% } 
			  }
			  %>

	</tbody>
</table>
</div>


<br />
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" />
</div>
</div>

</form>