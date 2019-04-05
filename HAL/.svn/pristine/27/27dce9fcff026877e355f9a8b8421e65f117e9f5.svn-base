<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		List patientDataList = new ArrayList();
		
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}	

	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}

	 System.out.println("hinId"+hinId);
	 
	 List<OpdAntenatalCard> opdAntenatalCardList= new ArrayList<OpdAntenatalCard> ();
		if(map.get("opdAntenatalCardList") != null){
			opdAntenatalCardList=(List)map.get("opdAntenatalCardList");
		}
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
%>
<script type="text/javascript">
function back1()
{
 
 var sURL = "/hms/hms/opd?method=showAntenatalCard&visitId=<%=visit.getId() %>";

    window.location.href = sURL;
 	//window.location.reload(true);
    window.close();

}
function back() {
parentRefesh();
document.forms[0].action = "/hms/hms/opd?method=showAntenatalCard&visitId=<%=visit.getId() %>";
window.close();
return;

}

function parentRefesh()
{
var parentWindow = window.opener;

if(parentWindow)
{
if (!parentWindow.closed)
{
parentWindow.location.reload(true);
}
}
} 
</script>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="antenatalCard" action="" method="post">


<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>

		<th scope="col">FHS/FM</th>
		<th scope="col">Urine</th>
		<th scope="col">Hb% gms</th>
	</tr>
	<%
	
  	if(opdAntenatalCardList.size() > 0){
	
	
  		 OpdAntenatalCard opdAntenatalCard = new OpdAntenatalCard();
  		opdAntenatalCard = opdAntenatalCardList.get(0);
 	
   
%>
	<tr>
		<input type="hidden" name="<%=ANTENATAL_CARD_ID %>"
			value="<%=opdAntenatalCard.getId() %>">
		<%System.out.println("opdAntenatalCard.getId()--------->"+opdAntenatalCard.getId()); %>
		<td><input id="fe1" name="<%=FHS_FM_EDIT %>"
			value="<%=opdAntenatalCard.getFhsFm() %>" type="text" size=10
			maxlength="15" /></td>
		<td><input id="fe2" name="<%=URINE_EDIT %>"
			value="<%=opdAntenatalCard.getUrine() %>" type="text" size=10
			maxlength="15" /></td>
		<td><input id="fe3" name="<%=HB_GMS_EDIT %>"
			value="<%=opdAntenatalCard.getHbGms() %>" type="text" size=10
			maxlength="15" /></td>
	</tr>

	<% }%>
</table>
</div>
<div class="Clear"></div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <%System.out.println("visit.getHin().getId()"+visit.getHin().getId());%>
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"> <input
	name="" type="button" class="cmnButton" value="Edit"
	onclick="submitForm('antenatalCard','opd?method=updateAntenatalCard');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Close" class="cmnButton" onclick="back();"
	align="right" />
</div>
</div>
