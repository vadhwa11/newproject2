<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.FeedbackOfCounselor"%>
<%@page import="jkt.hms.masters.business.Users"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
</script>
<script	type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<div class="clear"></div>
<%
         Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
     int totalPatient=0;
     int hinId= 0;
    List<FeedbackOfCounselor> patientList = new ArrayList<FeedbackOfCounselor>();   
       System.out.println("patientList====>>>"+map.get("patientList"));
      if (map.get("patientList") != null)
      {
    	  patientList = (List<FeedbackOfCounselor>) map.get("patientList");
    	  
  	 }
      
     
%>

<form name="smoWaitingList1" method="post" action="">
<div class="clear"></div>
<div class="clear"></div>
</form>

<div class="titleBg">

<h2>WAITING LIST</h2>
</div>
<div class="clear paddingTop15"></div>
<div class="floatRight">
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex="2" class="cmntable noBg">
<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1,"<%=RequestConstants.VISIT_DATE%>"], [2,"<%=RequestConstants.SERVICE_NO%>"],[3,"<%= RequestConstants.RANK_NAME%>"],[4,"<%=RequestConstants.PATIENT_NAME%>"],[5,"<%=RequestConstants.STATUS%>"]];
	statusTd =5;

	</script>
	<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
</div>
</div>

	<script type="text/javascript" language="javascript">
 
	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = "Name "
	data_header[0][1] = "data";
	data_header[0][2] = "5%";
	data_header[0][3] = "Name"
	

	data_header[1] = new Array;
	data_header[1][0] = "Date"
	data_header[1][1] = "hide";
	data_header[1][2] = "10%";
	data_header[1][3] = "<%= RequestConstants.VISIT_DATE %>";
	

	data_header[2] = new Array;
	data_header[2][0] = "Place"
	data_header[2][1] = "data";
	data_header[2][2] = "5%";
	data_header[2][3] = "Place";

	data_header[3] = new Array;
	data_header[3][0] = "Forwarded To"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	data_header[3][3] = "Forwarded To";

	data_header[4] = new Array;
	data_header[4][0] = "Status"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";
	data_header[4][3] = "Status";

	<%
	int  counter=0;
	
	try{
	Users user = new Users();
	if(session.getAttribute("users")!=null){
		user = (Users)session.getAttribute("users");
	}
	int empId = user.getEmployee().getId();


	
	//Iterator iterator=patientList.iterator();
	
	for(FeedbackOfCounselor malariaCase:patientList){
		if(malariaCase.getForWardedTo()!=null )
		{  
	%>  
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = '<%=malariaCase.getId()%>'
	data_arr[<%= counter%>][1] ='<%=malariaCase.getNameOfCounselor() %>'
	    data_arr[<%= counter%>][2] = '<%=malariaCase.getEmployedDate() %>'
        data_arr[<%= counter%>][3] = '<%=malariaCase.getPlaceOfCounseling() %>'
      <%if(malariaCase.getForWardedTo()   !=null){%>
           data_arr[<%= counter%>][4] = "<%=malariaCase.getForWardedTo().getFirstName().concat(" ").concat(malariaCase.getForWardedTo().getLastName()) %>"
        	   
	   <%}else{%>
      data_arr[<%= counter%>][4] = ""
      <%}%>
      data_arr[<%= counter%>][5] = '<%=malariaCase.getMoStatus() %>'
          <%
     counter++;
     
     }
		totalPatient++;}}
	     catch(Exception e)
	       {
	    	 e.printStackTrace();
	       }
          %>
          
	formName = "smoWaitingList1"
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);

		intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
	
	<script type="text/javascript">

	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>
	<div class="floatRight"><label class="auto">Total : </label>
		<label	class="valueAuto"><%=totalPatient%></label>
		</div>
		 
    <div class="clear"></div>
    <input type="hidden" name="counter" id="counter" value="<%=counter %>" /> 
	</div>