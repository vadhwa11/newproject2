
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Properties"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.KitIssueMasterTemplateM"%>
<%@page import="static jkt.hms.util.RequestConstants.HIN_ID" %>
<%@page import="static jkt.hms.util.RequestConstants.INPATIENT_ID" %>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_BY" %>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_DATE" %>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_TIME" %>

<%@page import="jkt.hms.masters.business.IpdKitIssueHeader"%>
<%@page import="jkt.hms.masters.business.KitIssueMasterTemplateT"%>
<%@page import="jkt.hms.masters.business.IpdKitIssueDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>



<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%
       Properties properties = new Properties();
       URL resourcePathADT = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
       try {
       	properties.load(resourcePathADT.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       String itemClassCode = properties.getProperty("itemClassCodeForLinenManagement");

       %>
<%
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	Map<String, Object> map = new HashMap<String, Object>();

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList")!=null){
		inpatientList = (List<Inpatient>) map.get("inpatientList");
	}
	List<KitIssueMasterTemplateM> templateList = new ArrayList<KitIssueMasterTemplateM>();
	if(map.get("templateList")!=null){
		templateList = (List<KitIssueMasterTemplateM>) map.get("templateList");
	}
	List<IpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
	if(map.get("ipdKitIssueList")!=null){
		ipdKitIssueList = (List<IpdKitIssueHeader>) map.get("ipdKitIssueList");
	}
	IpdKitIssueHeader ipdKitIssueHeader = new IpdKitIssueHeader();
	if(ipdKitIssueList.size() > 0){
		ipdKitIssueHeader = ipdKitIssueList.get(0);
	}
	
	Inpatient inpatient = new Inpatient();
	Patient patient = new Patient();
	String patientName ="";
	String servPersonName ="";
	String consultantName = "";
	String currentAge = "";
	
	if(inpatientList.size() > 0){
		inpatient = inpatientList.get(0);
		patient = inpatient.getHin();
		
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
		servPersonName =(patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"");
		consultantName=inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"");	
		String age = "";

	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
%>

<form name="patientKitIssue" method="post">
<div class="titleBg"><h2>Linen Management</h2></div>
<input type="hidden" name="hinNo" value="<%=patient.getHinNo()%>" />
<input type="hidden" name="adNo" value="<%=inpatient.getAdNo()%>" />
<input type="hidden" name="serviceNo" value="<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>" />
<input type="hidden" name=<%=HIN_ID %> value="<%=patient.getId()%>" />
<input type="hidden" name=<%=INPATIENT_ID %> value="<%=inpatient.getId()%>" />
<input	type="hidden" id="classCode" name="classCode" value="<%=itemClassCode%>" />
<h4>Patient Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>A&D No.</label> <%if(inpatient.getAdNo() != null){ %>
<label class="value"><%=inpatient.getAdNo() %></label> <%}else{ %>
<label class="value">-</label>
<%} %>
<label>Employee No.</label> 
<label class="value"> <%=patient.getServiceNo()!=null?patient.getServiceNo():"" %></label>

<label>Ward </label> <%if(inpatient.getDepartment() != null){ %>
<label class="value"> <%=inpatient.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
<label>Patient Name</label>
<label	class="value"> <%= patientName %></label>

<label>Relation</label> <%
	if(patient.getRelation() != null){
	%> 
<label class="value"><%= patient.getRelation().getRelationName()%></label>
<%} else{ %> <label
	class="value">-</label> 
	<% }%> 

<label>Designation</label>
<label class="value"><%=patient.getRank()!=null?patient.getRank().getRankName():"" %></label>
<div class="Clear"></div>
<label>Employee Name</label> <%
		String sMiddleName = "";
		String sLastName = "";
		if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
		
			if(patient.getSMiddleName() != null){
				sMiddleName = patient.getSMiddleName();
			}
			if(patient.getSLastName() != null){
				sLastName = patient.getSLastName();
			}
	 %> 
<label class="value"><%= patient.getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
<%}else{ %> 
<label class="value">-</label> 
<% }%>

<%-- <label>Branch/Trade</label>
<%
if(patient.getTrade() != null){
%> 
<label class="value"><%=  patient.getTrade().getTradeName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>

<%-- 
<label>Unit</label> <%
if(patient.getUnit() != null){
%> <label class="value"><%= patient.getUnit().getUnitName()%></label>
<%} else{ %> 
<label class="value">-</label> 
<% }%> --%>
<!-- <div class="Clear"></div> -->
<label>Age</label> <%if(!currentAge.equals("")){ %>
<label class="value"> <%=currentAge %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Gender</label> <%if(patient.getSex() != null){ %>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<%-- 
<label>Med Cat</label>
<label class="value"><%=patient.getCategory()!=null?patient.getCategory().getCategories():"-" %></label>
 --%>
<div class="Clear"></div>

<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>
<%-- 
<label>Allergies</label>
<%
String allergies = "";
	if(patient.getDrugAllergies()!=null){
/*	for(AllergyDetail allergyDetail : patient.getAllergyDetails()){
		if(!allergies.equals("")){
			allergies += ",";
		}
		allergies += allergyDetail.getDescription();
	}*/
		allergies = patient.getDrugAllergies();
}%>
<%
	if(!allergies.equals("")){
%>
<label class="valueAuto"><%=allergies %></label>
<%}else{ %>
<label class="value"></label>
<%} %> --%>
<!-- <div class="Clear"></div> -->

<label> Diagnosis</label> 
<%
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		if(map.get("diagnosisList")!=null){
			diagnosisList = (List<DischargeIcdCode>)map.get("diagnosisList");
			
		}
		if(diagnosisList != null && diagnosisList.size() > 0 && diagnosisList.get(0).getIcd()!=null)
		{
		%> <label class="valueFixedWidth"><%=diagnosisList.get(0).getIcd().getIcdName() %></label>
<%
		}else{
		%> <label class="value"></label> <%	
		}
		%> 
<%-- 		
<label>Disability</label>
<%
	List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("disabilityList")!=null){
		disabilityList = (List<MasMedicalExaminationDetail>)map.get("disabilityList");
	}
	
	if(disabilityList != null && disabilityList.size() > 0)
	{
	%> <label class="valueFixedWidth"><%=disabilityList.get(0).getMasIcd()!=null?disabilityList.get(0).getMasIcd().getIcdName():"" %></label>
<%
	}else{
	%> <label class="value"></label> <%	
	}
%>  --%>

<!--<label>Date</label>
<label class="value"><%=currentDate%></label>
<div class="Clear"></div>
<label>Time</label>
-->
<input type="hidden"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" /> <!--  <input type="button" class="button" value="Go" onClick="" />-->




<div class="Clear"></div>
</div>
<div class="Clear"></div>
<h4>Linen Issue Details</h4>
<div class="Clear"></div>
<%-- <div class="Block">
<label>Template <span>*</span></label>
<%
	if(ipdKitIssueList.size() > 0){
%>
<input type="text" name="template"  readonly="readonly" value="<%= ipdKitIssueHeader.getTemplate()!=null? ipdKitIssueHeader.getTemplate().getTemplateName():""%>">
<%}else{ %>
<select name="kitIssueMasterId" id="" onchange="submitProtoAjax('patientKitIssue','/hms/hms/ipd?method=getTemplateDetails')" validate="Template,string,yes">


<option value="0">Select</option>
<%
	if(templateList.size() > 0){
		for(KitIssueMasterTemplateM kitIssueMasterTemplateM : templateList){

%>
<option value="<%=kitIssueMasterTemplateM.getId() %>"><%=kitIssueMasterTemplateM.getTemplateName() %></option>

<%}
		}%>

</select>
<%} %>
<input type="button" name="createTemplate" value="Create Template" class="buttonBig" onclick="submitFormForButton('patientKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp&flag=kitIssue')">
<div class="clear"></div>
</div> --%>

<div class="clear"></div>
<div id="testDiv">

<input type="hidden" name="ipdKitIssueHeaderId" value="<%= ipdKitIssueHeader.getId()%>"/>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<table border="0" cellpadding="0" cellspacing="0" id="grid" class="center">
	<tr>
		<th width="15%">Nomenclature</th>
		<th width="3%">Qty Issued</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<%

	if(ipdKitIssueHeader!=null && ipdKitIssueHeader.getIpdKitIssueDetails() !=null){
	int j=1;
		for(IpdKitIssueDetails ipdKitIssueDetails :ipdKitIssueHeader.getIpdKitIssueDetails() ){
	%>
	<tr>
		
		<td>
		<%-- <input type="text" value="<%=ipdKitIssueDetails.getItemName() %>" tabindex="1" id="itemName<%=j %>" 
			size="35" name="itemName<%=j %>"
			onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" /> --%>
	    <input type="text" value="<%=ipdKitIssueDetails.getItem().getNomenclature()%>[<%=ipdKitIssueDetails.getItem().getPvmsNo()%>]" tabindex="1" id="itemName<%=j %>" 
			size="70" name="itemName<%=j %>" disabled= "true"
			onblur="if(this.value!=''){checkForIndentToDepot(this.value, 'itemName','<%=j %>')}" />
	    <input type="hidden" name="kitIssueDetailsId<%=j %>"  value="<%=ipdKitIssueDetails.getId() %>"/>

		<div id="ac2update1<%=j%>" style="display: none;" class="autocomplete"></div>		
			
			<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('itemName<%=j %>','ac2update1<%=j%>','stores?method=getItemListForLoanoutByAutocompleteBalance',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&itemName=' + document.getElementById('itemName<%=j%>').value+'&classCode='+document.getElementById('classCode').value;
				        },parameters:'requiredField=itemName<%=j%>'});
				</script>
			
				
		
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId<%=j %>" name="itemId<%=j %>" value="">
		</td>	
		<td>
		  <input type="text" value="<%=ipdKitIssueDetails.getQuantity()!=null?ipdKitIssueDetails.getQuantity():"" %>" tabindex="1" readonly="readonly" id="issueQuantity<%=j %>" size="25"
			name="issueQuantity<%=j %>"></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);" tabindex="1" disabled="disabled"/></td>
	</tr>
	<%j++;
	
			}
%>
		
		<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />
		<%}
		else
		{
			int j=1;
			%>
			
			<tr>
			
			<td>
			<%-- <input type="text" value="<%=ipdKitIssueDetails.getItemName() %>" tabindex="1" id="itemName<%=j %>" 
				size="35" name="itemName<%=j %>"
				onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" /> --%>
		    <input type="text"  tabindex="1" id="itemName<%=j %>" 
				size="70" name="itemName<%=j %>" 
				onblur="if(this.value!=''){checkForIndentToDepot(this.value, 'itemName','<%=j %>')}" />
		    <input type="hidden" name="kitIssueDetailsId<%=j %>"  />

			<div id="ac2update1<%=j%>" style="display: none;" class="autocomplete"></div>		
				
				<script type="text/javascript" language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('itemName<%=j %>','ac2update1<%=j%>','stores?method=getItemListForLoanoutByAutocompleteBalance',{minChars:1,
						  callback: function(element, entry) {
					            return entry + '&itemName=' + document.getElementById('itemName<%=j%>').value+'&classCode='+document.getElementById('classCode').value;
					        },parameters:'requiredField=itemName<%=j%>'});
					</script>
				
					
			
				
				</td>
				<td id="batchDiv1" style="display: none;">
			<input type="hidden" id="itemId<%=j %>" name="itemId<%=j %>" value="">
			</td>	
			<td>
			  <input type="text"  tabindex="1" id="issueQuantity<%=j %>" size="25"
				name="issueQuantity<%=j %>"></td>
			<td><input name="Button" type="button" class="buttonAdd" value=""
				onclick="addRow();" tabindex="1" /></td>
			<td><input type="button" name="delete" value="" class="buttonDel"
				onclick="removeRow('grid','hdb',this);" tabindex="1" disabled="disabled"/></td>
		</tr>
		<%	
		j++;
		%>
		
		<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />
		<%
		}%>
</table>



</div>


<div class="clear"></div>
<div class="division"></div>
<%
	if(ipdKitIssueList.size() > 0){
%>
<input type="button" name="Submit1" value="Submit" class="button"	tabindex="1" onclick="submitForm('patientKitIssue','/hms/hms/ipd?method=submitPatientKitIssue')" />
<%}else{ %>
<input type="button" name="Submit1" value="Submit" class="button"	tabindex="1" onclick="submitForm('patientKitIssue','/hms/hms/ipd?method=submitPatientKitIssue')" />

<%} %>
<input type="button" class="button" value="Back" align="left"	onClick="submitFormForButton('patientKitIssue','ipd?method=showPatientListJsp');" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

	
</form>
<script type="text/javascript">


function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

      
	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'radio';
	  e1.tabIndex="1";
	  e1.name='radio'+iteration;
	  e1.id='radio'+iteration
	  e1.onblur=function(){getRadioId(this.value,iteration)};
	  cell1.style.display = 'none';
	  cell1.appendChild(e1);
	 
	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '70';
	  e2.tabIndex="1";
	  e2.name='itemName'+iteration;
	  e2.id='itemName'+iteration
	  e2.onblur=function(){if(this.value!=''){checkForIndentToDepot(this.value,'itemName',iteration);}}
	  cell2.appendChild(e2);
	//  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature'+iteration});
       var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update1'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  
	
		cell2.appendChild(newdiv1);
	  
	  new Ajax.Autocompleter('itemName'+iteration,'ac2update1'+iteration,'stores?method=getItemListForLoanoutByAutocompleteBalance',{minChars:1,
		  callback: function(element, entry) {
	            return entry + '&itemName=' + document.getElementById('itemName'+iteration).value+'&classCode='+document.getElementById('classCode').value;
	        },parameters:'requiredField=itemName'+iteration});	 
       
	  /*   var e6 = document.createElement('input');
	    e6.name = 'itemId' + iteration;
		e6.id = 'itemId' + iteration;
		
		
		cell2.appendChild(e6); */
		
	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '25';
	  e3.tabIndex="1";
	  e3.name='issueQuantity'+iteration;
	  e3.id='issueQuantity'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var e31 = document.createElement('input');
	  e31.type = 'hidden';
	  e31.name='kitIssueDetailsId'+iteration;
	  e31.id='kitIssueDetailsId'+iteration
	  cell3.appendChild(e31);
	  
	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button'+iteration;
	  e4.setAttribute('onClick', 'addRow();'); 
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete'+iteration;
	  e5.setAttribute('onClick', 'removeRow("grid","hdb",this);'); 
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cell6 = row.insertCell(5);
	  cell6.id='batchDiv'+(iteration);
	  cell6.style.display="none"
	  var e51 = document.createElement('input');
	  e51.type = 'hidden';
	  e51.name='itemId'+iteration;
	  e51.id='itemId'+iteration;
	  cell6.appendChild(e51);
}

function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
	 	   
	 // 	tbl.deleteRow(lastRow - 1);
   var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}

function checkForIndentToDepot(val,a,inc){
/* 	var pageNo =parseInt(document.getElementById('pageNo').value)
	var start=((pageNo-1)*8)+1;
	var end=((pageNo-1)*8)+8; */

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
    
   // for(i=1;i<=8;i++){
    //if(pvms !="")
    //if(document.getElementById('codeItem'+i).value==pvms){
    //if(document.getElementById('codeItem'+inc).value!=pvms){
    	//alert("Item already selected...!")
    	//document.getElementById('nameItem'+inc).value=""

    	//return false;
    	//}
    //}}
    if(pvms !=""){    	
		ajaxFunctionForAutoAA('patientKitIssue','stores?method=fillItemsForIndentToSOC&pvmsNo=' +  encodeURIComponent(pvms) , inc);
		checkForNomenclature(val, inc);
		}else{
			document.getElementById("itemName"+inc).value = "";
			//document.getElementById("mrp"+inc).value = "";
			//document.getElementById("dispensingPrice"+inc).value = "";
			document.getElementById("issueQuantity"+inc).value = "";
/* 			document.getElementById("expDateVarTemp"+inc).value = "";
			document.getElementById("qtyVarTemp"+inc).value = "";
			document.getElementById("unitRateVarTemp"+inc).value = "";
			document.getElementById("codeItem"+inc).value = "";
			document.getElementById("manuId"+inc).value = "";
			document.getElementById("idAu"+inc).value = "";
			document.getElementById("noOfRows").value = parseInt(document.getElementById("noOfRows").value)-1; */

		}
}

function ajaxFunctionForAutoAA(formName,action,rowVal) {
	  var xmlHttp;
	  try {
		  
		  console.log("rowval="+rowVal)
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	   //   	var brandId="brandId"+rowVal;
		//	obj =document.getElementById(brandId); 
		//	obj.length = 1;
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        console.log("id="+id)
		        document.getElementById('itemId'+rowVal).value= id.childNodes[0].nodeValue;
		        document.getElementById('issueQuantity'+rowVal).setAttribute("validate", "Issue Quantity,int,yes");
		        
		   
	      	} 
	      }
	    }
	   // var url=action+"&"+getNameAndData(formName)
	    var url=action;
	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 	url = url;
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
	  
function checkForNomenclature(val, inc) {

	if (val != "") {

		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1, index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0, indexForChargeCode);

	/* 	if (chargeId == "") {
			if (document.getElementById('nomenclature' + inc)) {
				document.getElementById('nomenclature' + inc).value = "";
				document.getElementById('pvmsNo' + inc).value = "";
				document.getElementById('dosage' + inc).value = "";
				document.getElementById('frequency' + inc).value = "";
				document.getElementById('noOfDays' + inc).value = "";
				document.getElementById('route' + inc).value = "";
				document.getElementById('total' + inc).value = "";
				if (document.getElementById('treatRemarks' + inc))
					document.getElementById('treatRemarks' + inc).value = "";
			}
			// document.getElementById('clinicalNotes'+inc).value="";
			// document.getElementById('qty'+inc).value="";
			return;
		} */

		for (i = 1; i <= inc; i++) {

			if (inc != i) {
				if (document.getElementById('itemName' + i)
						&& document.getElementById('itemName' + i).value == val) {
					alert("Nomenclature already selected...!")
					document.getElementById('itemName' + inc).value = ""					
					var e = eval(document.getElementById('itemName' + inc));
					e.focus();
					return false;
				}
			}
		}

	} else {

		if (document.getElementById('nomenclature' + inc)) {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			document.getElementById('dosage' + inc).value = "";
			document.getElementById('frequency' + inc).value = "0";
			document.getElementById('noOfDays' + inc).value = "";
			document.getElementById('route' + inc).value = "";
			document.getElementById('total' + inc).value = "";
			if (document.getElementById('treatRemarks' + inc))
				document.getElementById('treatRemarks' + inc).value = "";
		}
	}
}

</script>
