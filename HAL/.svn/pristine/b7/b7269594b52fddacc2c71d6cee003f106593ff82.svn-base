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

<script language="javascript">

function jsImport()
{
	if (ImportCDForm.<%=UPLOAD_FILENAME%>.value=="")
	{
	alert('Pl. Select the Zip file to Import!.....');
	return;
	}
	var fname = ImportCDForm.<%=UPLOAD_FILENAME%>.value;
	var st = fname.length;
	st = st-3;
	if (fname.substring(st)!="zip")
	{
	alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	return;
	}
	var ind = fname.lastIndexOf("\\");
	var filename = fname.substring(ind+1);
	
	var changed_by = ImportCDForm.<%=CHANGED_BY%>.value; 
	var changed_date = ImportCDForm.<%=CHANGED_DATE%>.value;
	var changed_time = ImportCDForm.<%=CHANGED_TIME%>.value;
	var hospitalId =  ImportCDForm.hospitalId.value;
	var deptId = ImportCDForm.deptId.value;
	
	ImportCDForm.method="post";
	submitForm('ImportCDForm','tender?method=tenderImportCD&filename='+filename + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId);
}
</script>


<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
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
    }
	
	
	if (map.get("message")!=null)
	{
	%>
<script>
	alert('<%=map.get("message")%>');
	</script>
<%
	}
	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}

%>


<form name="ImportCDForm" method="post" enctype="multipart/form-data">

<div id="contentHolder"><input type="hidden" name="hospitalId"
	size="5" value="<%=hospitalId%>"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>"> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 />
</td>
<h6>Import Tender Data</h6>
<div class="Clear"></div>
<div class="blockTitle">Import Tender Data</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Select File</label> <input
	type="file" name="<%=UPLOAD_FILENAME%>"
	onkeypress="javascript:return false;"
	onkeydown="javascript:return false;" class="browse" /> <input
	type="button" name="impbutton" value="Import" class="button"
	onClick="jsImport()">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label></div>
</div>
</form>




