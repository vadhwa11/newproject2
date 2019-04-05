<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>


<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"	/>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<PatientInvestigationDetails> patientInvestigationdetails= new ArrayList<PatientInvestigationDetails>();	
	if(map.get("patientInvestigationList")!=null){
		patientInvestigationdetails = (List)map.get("patientInvestigationList");
	
	}
	//List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<Object> resultList = new ArrayList<Object>();
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
		}
	System.out.println("jsp resultList----"+resultList.size());
	PatientPrescriptionHeader pph=null;
	if(map.get("pphList") != null){
		pph=(PatientPrescriptionHeader)map.get("pphList");
	
		}
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>

<div class="clear"></div>
<div class="titleBg">

<h2>Patient Investigation</h2>
</div>
<div class="clear"></div>

<form name="patientInvestigation" method="post">


<%if(patientInvestigationdetails.size() > 0){
	PatientInvestigationDetails pInvestigationdetails= patientInvestigationdetails.get(0);
	Visit visit=pInvestigationdetails.getInvestigationHeader().getVisit();%>
<div class="Block">
<label>Service No.</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Patient Name</label>
 <%if(visit.getHin().getPFirstName()!= null){ 
	 String mname="";
	 String lname="";
	 String fname=visit.getHin().getPFirstName();
	 if(visit.getHin().getPMiddleName()!=null)
	  mname=visit.getHin().getPMiddleName();
	 if(visit.getHin().getPLastName()!=null)
	 lname=visit.getHin().getPLastName();%>
<label class="value"><%=fname+mname+lname%></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Relation</label>
 <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>


<div class="clear"></div>
<label >Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="value"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label>Name</label> 
<%if(visit.getHin() != null){
		Patient patient =visit.getHin();
	if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

					String sMiddleName = "";
					String sLastName = "";
					if(patient.getSMiddleName() != null){
						sMiddleName = patient.getSMiddleName();
					}
					if(patient.getSLastName() != null){
						sLastName = patient.getSLastName();
					}%> <label
	class="value"><%=patient.getSFirstName()+" "+sMiddleName+" "+sLastName %></label> <%}}else{ %> <label class="value"></label>
<%} %>
<label>Unit</label>
 <%if(visit.getHin().getUnit() != null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label >Age</label> 
<%if(visit.getAge()!= null){ %>
<label class="value"><%=visit.getAge() %></label> 
<%}else{ %>
<label class="value">&nbsp;</label><%} %>


 <label>Gender</label>
 <%if(visit.getHin().getSex() != null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">&nbsp;</label><%} %>
<label>Medical Officer</label>
 <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label>Visit Date</label>
 <%if(visit.getVisitDate()!= null){ %>
<label class="value"><%=visit.getVisitDate() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Visit No.</label>
 <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo()%></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Prescription No.</label>
 <%if(pph!=null && pph.getPrescriptionNo()!= null){ %>
<label class="value"><%=pph.getPrescriptionNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<%
String diagNo="";
Set<PatientInvestigationHeader> patientInvestigationHeaderSet=new HashSet<PatientInvestigationHeader>();
if(visit.getPatientInvestigationHeaders()!=null){
	patientInvestigationHeaderSet=visit.getPatientInvestigationHeaders();
}
if(patientInvestigationHeaderSet.size()>0){
	for(PatientInvestigationHeader patientInvestigationHeader:patientInvestigationHeaderSet){
		Set<PatientInvestigationDetails> patientInvestigationDetailsSet=new HashSet<PatientInvestigationDetails>();
		if(patientInvestigationHeader.getPatientInvestigationDetails()!=null){
			patientInvestigationDetailsSet=patientInvestigationHeader.getPatientInvestigationDetails();
			diagNo=""+patientInvestigationDetailsSet.size();	
		}
	}
}
%>
<label>Diagnosis</label>
<label class="value"><%=diagNo%></label>
</div>
<div class="clear"></div>
<table width="70%" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
	    <th scope="col">S.No.</th>
		<th scope="col">Test Name</th>
		<th scope="col">Test Result</th>
		<th scope="col">Repeat</th>
       
		</tr>

<%int inc=1;
String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc1=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());    
		    	third.put(investigationName,patientInvestigation.getId());
		    	String val="";
		    	String val1="";
		    	int investigationId=0;
		    	patientInvestigation.getInvestigationHeader().getVisit().getId();
		    	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	{   if(dgre.getSubInvestigation()!=null)
		    		val1=dgre.getSubInvestigation().getSubInvestigationName();
		    	if(!dgre.getResultType().equalsIgnoreCase("t"))
	    		{
		    	    val=val+","+val1+":"+dgre.getResult();
	    		}
		    	    investigationId=dgre.getInvestigation().getId();
		    		//System.out.println("dgre---id---"+dgre.getInvestigation().getId());
		    		if(dgre.getResultType().equalsIgnoreCase("s"))
		    		{
		    		    	val=val.substring(2);
		    				resultid=0;

		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("m"))
		    		{
		    			val=val.substring(1);
		    			resultid=0;
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("t"))
		    		{
		    			
		    			resultid=dgre.getResultEntry().getId();
		    			template="template"+"/"+resultid;
		    			val=template;
		    		}
		    	}
		    	
		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
		    	second.put(investigationId,val);
		    	++inc1;
		    	//
		    }
		    //System.out.println("first---"+first);
		   //System.out.println("second---"+second);
		    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            System.out.printf("key: %s, value: %s\n", key, first.get(key));
            
		    

		    %>
	<tr>
	<td><%=inc %></td>
			
			<td><input type="text" name="ChargeCodeName<%=inc %>" tabindex="1"
			readonly="readonly" size="70" value="<%=key %>" /> 

            </td>
<%

if(second.get(first.get(key))!=null)
	{ 
	//System.out.println("template---"+template);
	//System.out.println("value---"+second.get(first.get(key)));
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	System.out.println("mySplitResult[]---"+mySplitResult[0]);
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{%>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }else{%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>
	
<%}}else{%>
<td>
<input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
	<td><input type="checkbox" name="repeatInvestigation<%=inc %>"
			tabindex="1" value="" /></td>
	
	</tr>
	
	<% inc++;
		    }
		   
} %>
	

</table>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input id="save" property="save" type="button" tabindex="1"
	name="repeat" value="Repeat" class="button"
	onclick="setValuesInParent(patientInvestigation)" /> <input
	type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <input
	type="hidden" name="counter" id="counter" value="<%=inc %>" />
<%}else{ %> 
<div class="division"></div>
<div class="clear"></div>
<h4>No Records Found!!</h4>
<div class="clear"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<%} %>
</form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<script type="text/javascript">

function displayResult(val){
	alert(val);
}
	function setValuesInParent(formname){
		
  		formName=formname.name;
  		alert(formName);
  		var hiddenValue = window.opener.document.getElementById('hiddenValue').value;
  	
  		var chargeCodeNameVal = window.opener.document.getElementById('chargeCodeName'+hiddenValue).value;
  		
 		if(hiddenValue == 1 && chargeCodeNameVal == ''){
			var len = window.opener.document.getElementById("investigationGrid").rows.length;
			var r1 = window.opener.document.getElementById("investigationGrid").deleteRow(len-1);
		}
 	
		for(var index = 1; index < parseInt(document.patientInvestigation.counter.value); index++ ){
			
			var toEval = "document.patientInvestigation.repeatInvestigation" + index;
			var repeatIn = eval(toEval);
			if(repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("investigationGrid").rows.length;
				  var r = window.opener.document.getElementById("investigationGrid").insertRow(len);
			
				  var c1 = r.insertCell(0);
				  var c2 = r.insertCell(1);
				  var c3 = r.insertCell(2);
				  var c4 = r.insertCell(3);
				  var chargeCodeName=eval('document.'+formName+'.ChargeCodeName' + index + '.value')
				
				  window.opener.checkForChargeCode(chargeCodeName,index,'chargeCodeVal','child')
			    
				  var x1 = document.createElement('input');
				  x1.type = 'text';
				  x1.name='chargeCodeName'+len;
				  x1.id='chargeCodeName'+len;
				  x1.size = '100';
	  			  x1.setAttribute('tabindex','1');						  
				  x1.value = chargeCodeName;
			      c1.appendChild(x1);
				 
				  var divElement = document.createElement('div');
				  divElement.id='ac2update2';
				  divElement.style.display = 'none';
				  divElement.style.paddingRight = '10px;';
				  c1.appendChild(divElement);
				  var x10 = document.createElement('input');
				 // x4.type = 'hidden';
				  x10.name='Result'+len;
				  x10.id='Result'+len;
				  x10.setAttribute('tabindex','1');				  
				 // x10.size = '30';
				  x10.setAttribute("readonly","readonly");
				  c2.appendChild(x10);
				  
				  var x5 = window.opener.document.getElementById('hiddenValue');
				  x5.value=len;

				  var x6 = document.createElement('input');
				  x6.type = 'button';
				  x6.className = 'buttonAdd';
	  			  x6.setAttribute('tabindex','1');	
	  			  x6.setAttribute('onClick','addRowForInvestigation();');			  
				  c3.appendChild(x6);

				  var x7 = document.createElement('input');
				  x7.type = 'button';
				  x7.className = 'buttonDel';
	  			  x7.setAttribute('tabindex','1');	
	  			  x7.setAttribute('onClick','removeRowForInvestigation();');			  
				  c4.appendChild(x7);



				  
			}
		}
		
		window.close();
  	}
		
	
		
</script>



