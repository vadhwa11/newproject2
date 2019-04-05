<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>


<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<div class="popupbg">
<form name="popPresentComp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<PatientFamilyHistory> templatePresentComplaintList = new ArrayList<PatientFamilyHistory>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("patientTemplateHistoryList") != null){
		templatePresentComplaintList=(List<PatientFamilyHistory>)map.get("patientTemplateHistoryList");
	}
	
	String fieldId =null;
	if(map.get("fieldId") != null){
		fieldId = (String)map.get("fieldId");
	}
%> 
<%if(fieldId!=null){%>
<input id="fieldId" name="fieldId" type="hidden" value="<%=fieldId%>"/>
<%} %>

<h2>Treatment Advice Template</h2>

<% if(templatePresentComplaintList.size() == 0){
	%>
<h4><span>No Record Found</span></h4>
<% 							}else{%>
<div class="smallWithHeight">
<table colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col"><input type="checkbox" name="checkall"
			class="radioCheck" value="Collected All" id="addbutton"
			onclick="CheckAll(this);" align="right" /></th>
			<th scope="col">Template Values</th>
		</tr>
	</thead>
	<tbody>
		<%
		int i=0;
	for(PatientFamilyHistory templateHistory :templatePresentComplaintList){
 %>
		<%
		String templateName="";
		if(templateHistory.getPatientPresentComplaintName() !=null ){
			if(!templateHistory.getPatientPresentComplaintName().equals("") && templateHistory.getPatientPresentComplaintName().length()>0){
		 			 templateName=templateHistory.getPatientPresentComplaintName();
	 				
 %>
		<tr>
			<td>    
					<input id="checkId<%=i %>" name="checkedTemp" type="checkbox"  class="radioCheck" value="n"/>
					<input type="hidden" name="rowLength" id="rowLength" value="<%=templatePresentComplaintList.size()%>" readonly="readonly"/>
			</td>
			<td><input type="text" value="<%= templateName%>" name="treatmentAdvice<%=i %>" id="treatmentAdvice<%=i %>" readonly="readonly" size="40"/></td>
		</tr>
		<%i++;
}    %>
		<%
		}
}
		%>

	</tbody>
</table>
</div>

<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal"/>			

<input name="" type="button" class="button" value="OK" onclick="setTreatementAdviceTempalte();window.close();"" /> 
<input name="" type="button" class="button"	value="Close" onclick="cancelForm();" />
	
	
		<%} %> 	
</form>

</div>
<script>
 function cancelForm(){
   	   window.close();
  }
   
   function setTreatementAdviceTempalte(){
	   var preComp = "";
	   var  checkId;
	   var rowVal= document.getElementById('rowVal').value;
	 for(i=0;i<rowVal;i++){
		checkId = document.getElementById('checkId'+i);
	   if(checkId.checked == true){
		   preComp += document.getElementById('treatmentAdvice'+i).value+"\n"
		}
		
	 }
	 var val="";
	 	   val = window.opener.document.getElementById(document.getElementById('fieldId').value).value.trim();
		  window.opener.document.getElementById(document.getElementById('fieldId').value).value= val==""?preComp:val+"\n"+preComp;
		
	

	 window.opener.document.getElementById(document.getElementById('fieldId').value).focus();
		 window.close();
  	}
   function CheckAll(chk){
	   var rowLength=document.getElementById('rowLength').value;
	   for (var i=0;i <document.popPresentComp.elements.length;i++)
	   	{
	   		var e = document.popPresentComp.elements[i];

	   		if (e.type == "checkbox")
	   		{
	   			e.checked = chk.checked;
	   			for(var j=0;j<rowLength;j++)
	   			{
	   				e.value="y";
	   			}
	   		}
	   	}
	   }
	    	
	</script>