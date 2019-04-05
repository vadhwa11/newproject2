
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<form name="message" method="post">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	int medExamId = 0;
	if(map.get("medExamId")!=null){
		medExamId = (Integer)map.get("medExamId");
	}
	int visitId = 0;
	if(map.get("visitId")!=null){
		visitId = (Integer)map.get("visitId");
	}
	int hinId=0;
	if(map.get("hinId")!=null && map.get("hinId")!=""){
		hinId = (Integer)map.get("hinId");
	}
//	String dgOrderhdOrderNo="";
int dgOrderhdOrderNo=0;
	if(map.get("dgOrderhdOrderNo")!=null && map.get("dgOrderhdOrderNo")!=""){
		dgOrderhdOrderNo=(Integer)map.get("dgOrderhdOrderNo");
	}
	List<String>  investigationReferToMH = new ArrayList<String>();
	
	 if(map.get("investigationReferToMHList")!= null)
	   {
		 investigationReferToMH = (List)map.get("investigationReferToMHList");
	   }
	 int visitNumberForReport=0;
	 if (map.get("visitNumberForReport") != null) {
			visitNumberForReport = (Integer) map.get("visitNumberForReport");
	 }
	 String serviceNoForReport=null;
	 if (map.get("serviceNo") != null) {
			serviceNoForReport = (String) map.get("serviceNo");
	 }
	 String hinNoForreport=null;
	 if (map.get("hinNoForreport") != null) {
			hinNoForreport = (String) map.get("hinNoForreport");
	 }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><%=message %></h4>



<div class="Clear"></div>
<input type="hidden" name="hinNoForreport" value="<%=hinNoForreport %>" id="hinNoForreport"/>
<input type="hidden" name="hinId" value="<%=hinId%>" id="hinId"/>
<input type="hidden" name="dgOrderhdOrderNo" value="<%=dgOrderhdOrderNo %>" id="dgOrderhdOrderNo"/>
<h4>Do you want to print the case sheet ?</h4>
<input type="button" value="Yes" class="button"	onclick="submitForm('message','/hms/hms/medicalBoard?method=printSpecialistOpinionReport&medExamId=<%=medExamId %>&visitId=<%=visitId %>')">
<input type="button" class="buttonBig" value="Print Investigations"	onclick="submitForInvestigationPrintOut();" />

<%
try
{
	boolean flag=false;
	for(int i=0; i<investigationReferToMH.size(); i++ )
	{  
	if(flag==false)
	{
	if(investigationReferToMH.get(i).equals("y"))
   	{
   		flag=true;%>    
<input type="button" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="Print Investigation Requisition"	class="buttonBig2" accesskey="a" />
<% }}}	
 }
catch(Exception e)
 { 
	e.printStackTrace();
} %>
<input type="button" value="NO" class="button"	onclick="">

<%}else{ %>
<script type="text/javascript">
	window.close();
</script>
<%} %>
</form>
<script	type="text/javascript">
function submitFormForPrescriptionReport(){
	  var hinNoForreport12=document.getElementById('hinNoForreport').value;
	  var url='/hms/hms/medicalExam?method=showPatientInvestigationReport&Requestedjsp=MedicalExam&visitNumberForReport='+<%=visitNumberForReport%>+'&hinNoForReport='+hinNoForreport12+'&serviceNoForReport='+<%=serviceNoForReport%>+'&medExamId='+<%=medExamId %>;
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	
	}
function submitForInvestigationPrintOut()
{
	var orderNo=document.getElementById('dgOrderhdOrderNo').value;
	var flag="MO";
	var hinId= document.getElementById('hinId').value;
	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
		submitForm('message','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
		}
}
	</script>