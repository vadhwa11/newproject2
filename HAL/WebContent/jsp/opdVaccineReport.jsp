<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.SESSION_ID"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>


<script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	List<Object[]> stockList = new ArrayList<Object[]>();
	if(map.get("stockList")!=null){
		stockList = (List<Object[]>)map.get("stockList");
	}
	String fromDate=null;
	String toDate =null;
	if(map.get("fromDate")!=null){
		fromDate = (String)map.get("fromDate");
	}
	if(map.get("toDate")!=null){
		toDate = (String)map.get("toDate");
	}
	%>

<div class="titleBg">
<h2>Vaccine Register</h2>
</div>
<div class="clear"></div>
<%

if(map.get("message") != null){
	String message = (String)map.get("message");
	
	%>
<h4><span><%=message %></span></h4>
<%} %>

<form name="myopdPatientList" method="post" action="">
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">


	<label class="">From Date<span>*</span></label> 
	<input type="text" id="fromDate" name="fromDate"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" value="<%=fromDate!=null?fromDate:""%>" validate="From Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />

	<label class="">To Date <span>*</span></label> 
	<input type="text" id="toDate"  name="toDate"   MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" value="<%=toDate!=null?toDate:""%>" validate="To Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />

	<input type="button" name="search" value="Search"
		onClick="submitForm('myopdPatientList','opd?method=showVaccineReport')"
		class="button" />
		<div class="clear"></div>
	<div class="clear"></div>
</div>

</form>
<div class="clear"></div>
<div class="floatRight">

<jsp:include page="searchResultBlockForIPD.jsp"/>
<div class="clear"></div>
<div id="test">
<!-- <div class="cmntable"> -->
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2" class="noBg"></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.HIN_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	statusTd =12;

	</script>
</div>
<!-- </div> -->

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
</div>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "S.No"
	data_header[1][1] = "data";
	data_header[1][2] = "10%";
	data_header[1][3] = "Priority";
	
	data_header[2] = new Array;
	data_header[2][0] = "Vaccine Name"
	data_header[2][1] = "data";
	data_header[2][2] = "8%";
	data_header[2][3] = "<%= RequestConstants.TOKEN_NO%>"

	data_header[3] = new Array;
	data_header[3][0] = "OPD Date"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";
	
	data_header[4] = new Array;
	data_header[4][0] = "Total"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";
	data_header[4][4] = "<%=RequestConstants.VISIT_DATE %>";
	

	data_arr = new Array();

	<%
	int  i=0; int j=0;
	try{
	String st="";
	  for(Object[] obj : stockList)
	{
	%>

	data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] =<%=obj[0]%>

	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= obj[1].toString()%>" id="parent" />'

	<%
	if(obj[1]!=null){
		
		%>
			data_arr[<%= i%>][2] ="<%=++j%>"
				<%
		}else{
				%>
				data_arr[<%= i%>][2] =""
		<%
	}
	if(obj[2]!=null)
	{
	%>
	data_arr[<%= i%>][3] = " <%=obj[2].toString()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = ""
	<%
	}
	if(obj[3]!=null)
	{
	%>
	data_arr[<%= i%>][4] = " <%=HMSUtil.convertDateToStringTypeDateOnly((Date) obj[3])%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][4] = ""
	<%
	}
	
	if(obj[0]!=null)
	{
	//MasVaccineItem ms = (MasVaccineItem) obj[1];
	
	%>
	data_arr[<%= i%>][5] = " <%=obj[0].toString()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][5] = ""
	<%
	}%>
	
	<%	
	i++;

	}
	}catch(Exception e){
	e.printStackTrace();

	}
	%>
	formName = "myopdPatientList"
	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);
	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>


<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>

