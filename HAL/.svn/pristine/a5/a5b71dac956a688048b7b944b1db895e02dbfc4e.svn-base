<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartment.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>



<script language="Javascript">

</script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month1+"/"+year1%>'
	</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else 
	{
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else 
	{
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<%
	Box box = HMSUtil.getBox(request);
	String pvmsNo="";
	String pvmsNo1="";
	pvmsNo=box.getString("pvmsNo");
	Vector mmfTItems = new Vector();
	mmfTItems=box.getVector("mmfTItems");
	box.put("mmfTItems",mmfTItems);
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String userName = "";
	int hospitalId = 0;
	String  docId = "";
	int currentPage=0;
	List<StoreGrnM> storeGrnMList = new ArrayList<StoreGrnM>();
	
	String flagForRefresh="";
	
	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	//System.out.println("deptId IN MMF DEPARTMENT.JSP----------"+deptId);
	if (session.getAttribute("userName") != null)
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	//System.out.println("hospitalId IN JSP " + hospitalId);
	
	
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		
		
		//System.out.println("box values " + box);
		//System.out.println("map values " + map);
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	if(map.get("storeGrnMList") != null)
	{
		storeGrnMList = (ArrayList) map.get("storeGrnMList");
		
	}
	
	
	
	
	
	
	//System.out.println("DocId IN JSPPPPPPPPPP   "+docId);
	int currentYear=0;
	int previousYear=0;
	if(box.getInt(MMF_DEPARTMENT_DATE)!=0 ){
		currentYear=box.getInt(MMF_DEPARTMENT_DATE);
		previousYear=currentYear-1;
	}
	if(map.get("currentYear")!=null)
		currentYear = (Integer) map.get("currentYear");
	if(map.get("previousYear")!=null)
		previousYear = (Integer) map.get("previousYear");
	if(box.get("flag")!=null&&box.get("flag").equals("true")){
		String docNo="";
		docNo=box.get(DOC_NO);
		currentYear=Integer.parseInt(docNo.substring(3));
		previousYear=currentYear-1;
	}
	

	//System.out.println("map in Jsp "+map);
	
%>

<div class="titleBg"><h2>Installation Certificate Form</h2></div>
<div class="Clear"></div>


<div class="Clear"></div>
<form name="installationCertificate" method="post">


<div class="Block">
<label>CRV No.</label> 
 	<select name=<%=GRN_NO %> id="grnNO"  onchange="onChangeForInstallationCertificate(this.value);">
 	<option value="0">Select</option>
 	<%
	for (StoreGrnM storeGrnM : storeGrnMList) {
 	
 	%>
 	<option value="<%=storeGrnM.getId()%>"><%=storeGrnM.getGrnNo()%></option>
 <%} %>
 	</select>
 
 		 
<div id="itemDiv">
 <label>Nomenclature</label> 
 <select name="<%=ITEM_NAME %>"
	 validate="Nomenclature,String,yes" tabindex=1>
	<option value="0">Select</option>

	</select>
	
</div>
	
	
	
</select> 
<label><span>*</span> Installation Date</label> <input type="text"
	name="<%=GRN_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" tabindex=1 id="grnDate" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.installationCertificate.<%=GRN_DATE%>,event)" />
<div class="Clear"></div>




</div>
	<input type="button" name="sss" class="button" value="Submit"
	onclick="submitForm('installationCertificate','neStores?method=updateInstallationDate');" />

	</form>
<div class="Clear"></div>
<div class="division"></div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


<script language="Javascript">
function onChangeForInstallationCertificate(sos)
{
	
	submitProtoAjaxforNomenclature('installationCertificate','/hms/hms/neStores?method=responseNomenclature&grnId='+sos);
}


function submitProtoAjaxforNomenclature(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
    	   	
        	new Ajax.Updater('itemDiv',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}    	
</script>