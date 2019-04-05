<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="jkt.hms.util.HMSUtil"%>



<%@page import="jkt.hms.masters.business.FamilyPlanning"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<FamilyPlanning> familyPlanningList = new ArrayList<FamilyPlanning>();
	if(map.get("familyPlanningList") != null){
		familyPlanningList = (List<FamilyPlanning>)map.get("familyPlanningList");
	}

%>
<!--main content placeholder starts here-->

<div class="titleBg">
<h2>Waiting List</h2>
</div>

<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />

<div class="Clear"></div>
<form name="waitingListForSterilisation" method="post" 	action="">
<div class="clear"></div>
<div class="clear"></div>
 </form>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class=""></div>
<script type="text/javascript">
	formFields = [ [0,"medExamid","id"],[1,"<%= RequestConstants.VISIT_DATE %>"], [2,"<%= RequestConstants.PATIENT_NAME %>"],[3,"<%=RequestConstants.RANK_NAME%>"],[4,"<%=RequestConstants.AGE%>"],[5,"<%=RequestConstants.VISIT_ID%>"], [6,"<%=STATUS%>"]];
	 statusTd = 6;
	</script>
   </div>



<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Visit Date";
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%=RequestConstants.VISIT_DATE %>";

data_header[1] = new Array;
data_header[1][0] = "Service No. "
data_header[1][1] = "data";
data_header[1][2] = "5%";
data_header[1][3] = "<%=RequestConstants.PATIENT_NAME  %>";


data_header[1] = new Array;
data_header[1][0] = "Name "
data_header[1][1] = "data";
data_header[1][2] = "5%";
data_header[1][3] = "<%=RequestConstants.RANK_NAME  %>";

data_header[2] = new Array;
data_header[2][0] = "Rank";
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=RequestConstants.AGE %>";

data_header[3] = new Array;
data_header[3][0] = "Age"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%=RequestConstants.STATUS %>";

data_header[4] = new Array;
data_header[4][0] = "Age"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "<%=RequestConstants.VISIT_ID %>";




<%
int  counter=0;
if(familyPlanningList.size()>0){
	for(FamilyPlanning familyPlanning: familyPlanningList){
%>
  	 data_arr[<%= counter%>] = new Array();   
  
       data_arr[<%= counter%>][0] = <%=familyPlanning.getVisit().getId()%>;

       data_arr[<%= counter%>][1] = '<%=HMSUtil.convertDateToStringWithoutTime(familyPlanning.getVisit().getVisitDate())%>';
       <%
       String patientName="";
		if(familyPlanning.getHin().getPFirstName()!= null){
			patientName=familyPlanning.getHin().getPFirstName();
		}
		if(familyPlanning.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+familyPlanning.getHin().getPMiddleName();
		}
		if(familyPlanning.getHin().getPLastName()!= null)
		{
			patientName=patientName+" "+familyPlanning.getHin().getPLastName();
		}
       
       %>
       data_arr[<%= counter%>][2] = '<%=patientName%>';
        
	 
       data_arr[<%= counter%>][3] = '<%=familyPlanning.getHin().getRank().getRankName()%>';
	
       data_arr[<%= counter%>][4] = '<%=familyPlanning.getVisit().getAge()%>';

       data_arr[<%= counter%>][5] = '<%=familyPlanning.getVisit().getId()%>';
       
	  <%if(familyPlanning.getStatus().equals("p")){%>
       data_arr[<%= counter%>][6] ='New'
       <%}else{%>
       data_arr[<%= counter%>][6] = 'Old'

       <%}
       
       %>
	
	
       
   	
   	

	
	
	      
<%
counter++;
	}}

%>
formName = "waitingListForSterilisation"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeGridForPatient(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="clear"></div>
<div class="floatRight"><label class="auto">Total Waiting Patient : </label>
		<label	class="valueAuto"><%=counter%></label>
		</div>