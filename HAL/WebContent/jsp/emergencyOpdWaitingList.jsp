<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@ page import="java.net.URL"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<!-- <script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script> -->

<!-- <script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script> -->

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script> -->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js?n=1"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>


<script>jQuery.noConflict();</script>
<title>Emergency OPD</title>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
 	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
				Map<String, Object> map = new HashMap<String, Object>();
// 				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
				 List<UploadDocuments> uploadDocuments=new ArrayList<UploadDocuments>();
				String message = "";
				int hinId=0;
				int visitId=0;
				int inpatientId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("uploadDocuments")!= null){
					uploadDocuments = (List)map.get("uploadDocuments");
				}
				if(request.getParameter("hinId")!=null){
					hinId=Integer.parseInt((String)request.getParameter("hinId"));
				}
				int bookingId =0;
				if(request.getParameter("bookingId")!=null){
					bookingId=Integer.parseInt((String)request.getParameter("bookingId"));
				}
		/* 		if(request.getParameter("inpatientId")!=null){
					inpatientId=Integer.parseInt((String)request.getParameter("inpatientId"));
				}else if(map.get("inpatientId")!= null){
					inpatientId = (Integer) map.get("inpatientId");
				}
				if(request.getParameter("visitId")!=null){
					visitId=Integer.parseInt((String)request.getParameter("visitId"));
				}else if(map.get("visitId")!= null){
					visitId = (Integer)map.get("visitId");
				}
				 */
				String uploadFrom ="OT";
	
			int RequestId = 0;	
			int employeeId = 0;
			List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
			if(map.get("frequencyList") != null){
			frequencyList=(List)map.get("frequencyList");
			}
			
			
		%>
<script language="javascript">

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

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	var hinId= document.getElementById("hinId").value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.getElementById("flag").value="y";
	document.attachFile.method="post";
	<%-- submitForm('attachFile','ot?method=uploadAndViewDocuments&bookingId='+<%=bookingId%>+'&'+csrfTokenName+'='+csrfTokenValue); --%>
	submitForm('attachFile','ot?method=uploadAndViewDocuments&bookingId='+<%=bookingId%>);
	
}

function fillDiagnosisCombo(val) {

    
	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   
	    if(id ==""){
		  return;
		}else{
		   		obj =document.getElementById('diagnosisId');
				obj.length = document.getElementById('diagnosisId').length;
              var valu=obj.options[obj.length-1].value;
				var b="false";
				for(var i=1;i<obj.length;i++){
						    
	                    	var val1=obj.options[i].value;
	                    	var length=obj.length-1;
                          	
	                    	if(id==val1)
	                    	{
	                        	alert("ICD  Already taken");
	                        	document.getElementById('icd').value =""
	                        	b=true;
	                       	}
	                              	
	                    }
              
	                    if(b=="false")
	                    {
	                    	
	                    	 if(document.getElementById('diagnosisId').options[1]!=null && document.getElementById('diagnosisId').options[1].value ==document.getElementById('NAIcd').value){
	         			    	document.getElementById('NAIcd').checked=false;obj.remove(1);}
	                    	obj.length++;
	    					obj.options[obj.length-1].value=id
	    					obj.options[obj.length-1].text=val
	    					obj.options[obj.length-1].selected=true
	    					document.getElementById('icd').value =""
	    			                    
	                    }
			}
}
var icdArray=new Array();
var itemClassCodeArray = new Array();
var itemClassArray = new Array();
var unitArray = new Array();
var ItemClassIdUOMNotRequired = new Array();
</script>
<%

String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForLiquidForm").trim().split(",");
for(int i=0;i<ItemClassCodeForLiquid.length;i++)
{
%>
<script language="javascript">

itemClassCodeArray[<%=i%>]= new Array();
itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";
</script>
<%}%>
		<%
	String []ItemClassIdUOMNotRequired = HMSUtil.getProperties("adt.properties", "ItemClassIdUOMNotRequired").trim().split(",");
%>
	<%for(int i=0;i<ItemClassIdUOMNotRequired.length;i++)
	{
	%>
	<script>

	ItemClassIdUOMNotRequired[<%=i%>]= new Array();
	ItemClassIdUOMNotRequired[<%=i%>][0] = "<%=ItemClassIdUOMNotRequired[i]%>";

     			
            </script>
<%	}%>
			
 <%	MasFrequency masFrequency = new MasFrequency();

 					for (int i = 0; i < frequencyList.size(); i++) {
 						masFrequency = (MasFrequency) frequencyList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <%
 	}%>

<%-- <%@page import="jkt.hms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hms.masters.business.TempTickattach"%> --%>

<div class="titleBg"> <h2>Empergency OPD </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block">
<form name="visitEmployee">
<label>Employee No.<span>*</span></label> 
<%-- <input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Service No" tabindex="1" validate="Employee No,metachar,yes" maxlength="20"  onKeyPress="return isNumber(event)"
onblur="if(validateMetaCharacters(this.value)){validateServiceNoHAL(this.value,'visitEmployee');submitProtoAjaxWithDivName('visitEmployee','/hms/hms/registration?method=getServiceNoDetailsForRegHAL&serviceNo='+this.value,'depenedentDiv');}" /> --%>
<input	id="serviceNoId" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>" value="" title="Enter Employee No" tabindex="1"  maxlength="20" 
onchange="submitProtoAjaxNew('visitEmployee','/hms/hms/opd?method=getServiceNoDetailsForRegHAL&serviceNo='+this.value,'depenedentDiv');" />

<img src="/hms/jsp/images/or.png" width="21" height="11" border="0" style="margin-top:9px;" />  <input  type="button" value="Other Patient" class="button" onclick="clearFields();submitProtoAjaxWithDivName('visitEmployee','/hms/hms/opd?method=getServiceNoDetailsForRegHAL&otherPatient=y','depenedentDiv');" />

<div id="depenedentDiv"></div>
</form>
</div>

<script type="text/javascript">
<%

String contractCode = "";
String transferedCode = "";
String extentionCode="";
String activeCode="";
String departmentNameToRestrictMalePatient = "";

try {
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	properties.load(resourcePath.openStream());
	contractCode = properties.getProperty("empStatusCodeForContract");			
	extentionCode = properties.getProperty("empStatusCodeForExtention");
	activeCode = properties.getProperty("empStatusCodeForActive");
	departmentNameToRestrictMalePatient = properties.getProperty("departmentNameToRestrictMalePatient");

	
} catch (Exception e) {
	e.printStackTrace();
}

%>
function checkStatusDependent(statusName, status, contractDate, extentionDate)
{
	var contractDate = new Date(contractDate);
	var extentionDate = new Date(extentionDate);
	var date = new Date();
	var returnFlag = false;	
	
	contractDate.setHours(0, 0, 0, 0);	
	extentionDate.setHours(0, 0, 0, 0);	
	date.setHours(0, 0, 0, 0);
	
	
	if(status == <%=activeCode%>)
		{
		
		returnFlag = true;
		}
	else if(status == <%=contractCode%>)
		{
		if(date>contractDate)
			{
			alert("Contract has expired");
			returnFlag = false;
			}
		else{
			returnFlag = true;	
		}
		}
	else if(status == <%=extentionCode%>)
	{
		if(date>extentionDate)
		{
		alert("Extension has expired");
		returnFlag = false;
		}
		else{
			returnFlag = true;	
		}
		
	}
	else
	{
		alert(statusName + " Employee");
	returnFlag = false;
	}
	return returnFlag;
}
	
function checkStatusEmp(statusName, status, contractDate, extentionDate)
{
	var contractDate = new Date(contractDate);
	var extentionDate = new Date(extentionDate);
	var date = new Date();
	var returnFlag = false;
	
	contractDate.setHours(0, 0, 0, 0);	
	extentionDate.setHours(0, 0, 0, 0);	
	date.setHours(0, 0, 0, 0);
	
	
	if(status == <%=activeCode%>)
	{
	
	returnFlag = true;
	}
	else if(status == <%=contractCode%>)
		{
		
		if(date>contractDate)
			{
			alert("Contract has expired");
			returnFlag = false;
			}	
		else
			{
			returnFlag = true;
			}
		}
	else if(status == <%=extentionCode%>)
	{
		
		alert("Employee has been transferred");
		returnFlag = false;
		
		
	}
	else
	{
		alert(statusName + " Employee");
	returnFlag = false;
	}
	return returnFlag;
	
}

function clearFields()
{
	
	document.getElementById('serviceNoId').value == '';
	}
function validateOtherPatient()
{
 if(document.getElementById('pFirstName').value == '')	
	 {
	 alert("Please enter patient Name");
	 return false;
	 }
 else if(document.getElementById('gender').value == '')	
	 {
	 alert("Please select patient gender");
	 return false;
	 }
 
 else if(document.getElementById('dob').value == '')	
	 {
	 alert("Please enter patient DOB");
	 return false;
	 }

 return true;
}
function addRow(){
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);checkForAlreadyIssuedPrescription(this.value,iteration,'0');displayAu(this.value,iteration,'0');checkForPurchase(this.value, iteration);
						   }
	  					  };
	  
	  					var newdiv = document.createElement('div');
	  		     	    newdiv.id='ac2update'+iteration;
	  		     	    newdiv.className='autocomplete';
	  		       	newdiv.style.display = 'none';
	  		          e0.size = '30';
	  			        e0.setAttribute('tabindex','1');

	  				var e01 = document.createElement('input');
	  			  e01.type = 'hidden';
	  			  e01.name = 'itemId' + iteration;
	  			  e01.id = 'itemId' + iteration;
	  			  e0.focus();
	  			  cellRight0.appendChild(e0);
	  			  cellRight0.appendChild(e01);
	  			  cellRight0.appendChild(newdiv);
	  
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=nomenclature'+iteration});
	 
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.readOnly=true;
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11);

	  var cellRight3 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  //added by Babita
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight3.appendChild(e15);
	  
	  var e016 = document.createElement('input');
	  e016.type = 'hidden';
	  e016.name='itemClassCode'+iteration;
	  e016.id='itemClassCode'+iteration
	  e016.size='6';
	  e016.setAttribute('tabindex','1');
	  cellRight3.appendChild(e016);
	  
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dispensingUnit'+iteration;
	  e13.id='dispensingUnit'+iteration
	  e13.readOnly=true;
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);

	 
	  cellRight3.appendChild(e1);
	  
	  var cellRight4 = row.insertCell(3);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(4);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	    for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      } 
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='3';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);

		var cellRight8 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6);

	  var cellRight9 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

	  var cellRight11 = row.insertCell(8);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(9);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);
}

function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency masFrequency1 :frequencyList){
%>
 if(feqValue == '<%=masFrequency1.getId()%>'){
	 feqQty = '<%=masFrequency1.getFeq()%>'
	
  }

<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}

/* function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update'+iteration;
	  newdiv1.className='autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{callback: function(element, entry) { return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;},parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  																																								
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	
	 var cellRight2 = row.insertCell(1);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.value = "";
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation();}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(2);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.value = ""
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	  
	  
	} */
function getBedStatus1(val){
	submitProtoAjaxNew('visitEmployee','opd?method=getBedStatus&deptId='+val,'bedDiv');
}

function toggleAdmission(obj)
{
	if(obj.checked)
	        document.getElementById('admDiv').style.display='block';
	else
		document.getElementById('admDiv').style.display='none';
	}
	
	
function submitOPDMainForm(){
	//	if(validateFieldValuesForMainSubmit()){
	
	//var referedToMH =document.getElementById('referedToMH').value;
	if(confirm("Do You want to submit the Record!?")){
/* 	 if(document.getElementById('referedToMH').checked == true){
			if(validateFrequency() && validateDays()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				
				submitForm('opdMain','opd?method=submitOPDPatientDetails&referedToMH=y&flag=opd');
		}
	 } */
	 
		 if(validateICD()&& validateNip() &&  validateFrequency() && validateAdmission()){
				//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=responseForDoctarsList&referredDepartmentId='+indexes+'','referredDoctarsIdDiv');
				return true;
		}
		 else
			 {
			 return false;
			 }
	
		
	}else{
		return false;
	}
	 
	}

	function toggleAdmission1(){
	
		  //	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		  var templateId = document.getElementById('investigationTemplateId').value;
		  	var totalRow= parseInt(	document.getElementById('hiddenValue').value);
		  
	  		var itemIdArray = "";
	  		document.getElementById('hiddenValue').remove();
	  		var mytb1l = document.getElementById("investigationGrid");
		  	   if(templateId==0)
		  	     {
		  		var rowCount =document.getElementById("investigationGrid").rows.length;
			  		for(var i=1;i<=rowCount;i++) 
					{
			  		//$("#nomenclatureGrid tr:eq("+i+")").remove();
			  			//$("#investigationGrid > tr").remove();
			  			//document.getElementById("investigationGrid").innerHTML = "";
			  			//document.getElementById("investigationGrid").rows.value ="";
			  			
			  			var mytbl = document.getElementById("investigationGrid");
			  			if(mytbl.getElementsByTagName("tbody")[i]!=null)
			  			   mytbl.getElementsByTagName("tbody")[i].innerHTML = "";
			  			
			  			//document.getElementById("investigationGrid").closest("tr").innerHTML = "";
			  			 //$().closest('tr').remove();
					}
			  		totalRow =1;
		  	     }
		  	   else{
		  		  //$("#nomenclaturehdb").remove();
		  		   var val="";
		  		   var id=0;
			  	for(var i=1;i<=totalRow;i++) 
				{
			  	
				   if (document.getElementById("chargeCodeName"+i)!=null && document.getElementById("chargeCodeName"+i).value!=""){
					   //itemIdArray += $('#itemId'+i).val()+",";
					 // b val = $('#chargeCodeName'+i).val();
					  val = document.getElementById("chargeCodeName"+i).value
				   var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
						  index1++;
					 id = val.substring(index1,index2);
					itemIdArray += id+",";
				   }
				}
		  	   
				 document.getElementById("investigationGrid").deleteRow(2); 
		  	
		  	 totalRow = totalRow+1;
		  	   }
		  	  
			new Ajax.Request(
					'opd?method=showGridForInvestigation&hinId=' + document.getElementById('hinId').value+'&investigationTemplateId='+templateId+"&totalRow="+totalRow +"&itemIdArray="+itemIdArray,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								//alert(response.responseText);
								//$('#investigationGrid').append(response.responseText);
								//document.getElementById("investigationGrid").innerHTML= document.getElementById("investigationGrid").value + response.responseText;
								
								var div = document.getElementById('investigationGrid');

								div.innerHTML += response.responseText;
							}
						}
					});
			
		}
	 
	function toggleAdmission2(){
		

		  //	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		  var templateId = document.getElementById('templateId').value;
		  	var totalRow= document.getElementById("nomenclaturehdb").value;
		  		var itemIdArray = "";
		  		var mytbl = document.getElementById("nomenclatureGrid");
		  		document.getElementById("nomenclaturehdb").remove();
		  	   if(templateId==0)
		  	     {
		  		var rowCount =document.getElementById("nomenclatureGrid").rows.length;
			  		for(var i=1;i<=rowCount;i++) 
					{
			  		//$("#nomenclatureGrid tr:eq("+i+")").remove();
			  			//$("#nomenclatureGrid > tr").remove();
			  			if(mytbl.getElementsByTagName("tbody")[i]!=null)
			  			   mytbl.getElementsByTagName("tbody")[i].innerHTML = "";
			  			// document.getElementById("nomenclatureGrid").deleteRow(1); 
					}
			  		totalRow =1;
		  	     }
		  	   else{
		  		  //$("#nomenclaturehdb").remove();
			  	for(var i=1;i<=totalRow;i++) 
				{
			  	
				   if (document.getElementById("itemId"+i)!=null && document.getElementById("itemId"+i).value!="")
					   itemIdArray += document.getElementById("itemId"+i).value+",";
				}
		  	   
			  /* if(totalRow==1)
		  		   {*/
		  		  /*   if(document.getElementById("nomenclature1")!=null&&document.getElementById("nomenclature1").value=="")
		  			   {
		  			   $("#nomenclatureGrid tr:eq(1)").remove();
		  			   }  */
		  			 document.getElementById("nomenclatureGrid").deleteRow(1); 
		  		   //}
		  	
		  	 totalRow = totalRow+1;
		  	   }
			new Ajax.Request(
					'opd?method=showGridInMainJsp&hinId=' + document.getElementById('hinId').value+'&templateId='+document.getElementById('templateId').value+"&totalRow="+totalRow +"&itemIdArray="+itemIdArray,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var div = document.getElementById('nomenclatureGrid');
								div.innerHTML += response.responseText;
							}
						}
					});
			
		
			
		}
	
	</script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>

