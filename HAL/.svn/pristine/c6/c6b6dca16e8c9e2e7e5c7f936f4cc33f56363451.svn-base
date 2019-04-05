
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
	
	<%
	Date d=new Date();
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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	List<MasPersonnelDetails> masPersonnelDetailsList= new ArrayList<MasPersonnelDetails>();
	if(map.get("masPersonnelDetailsList") != null){
		masPersonnelDetailsList=(List)map.get("masPersonnelDetailsList");
	}
	List<PensionEmoluments> pensionEmolList= new ArrayList<PensionEmoluments>();
	if(map.get("pensionEmolList") != null){
		pensionEmolList=(List)map.get("pensionEmolList");
		System.out.println("pensioneol list-----"+pensionEmolList.size());
	}
	List<PensionEol> pensionEolList= new ArrayList<PensionEol>();
	if(map.get("pensionEolList") != null){
		
		pensionEolList=(List)map.get("pensionEolList");
		System.out.println("pensioneol list-----"+pensionEolList.size());
	}
	List<PensionForm7Details> pensionForm7List= new ArrayList<PensionForm7Details>();
	if(map.get("pensionForm7List") != null){
		pensionForm7List=(List)map.get("pensionForm7List");
	}
	List<PensionForm7EmolumentsDetail> pensionForm7EmolList= new ArrayList<PensionForm7EmolumentsDetail>();
	if(map.get("pensionForm7EmolList") != null){
		pensionForm7EmolList=(List)map.get("pensionForm7EmolList");
	}
	
	PensionForm7Details pensionForm7Details=(PensionForm7Details)pensionForm7List.get(0);
	MasPersonnelDetails masPersonnelDetails=(MasPersonnelDetails)masPersonnelDetailsList.get(0);	
	

	%>
<div id="contentHolder">
<form name="updateForm7Entry" method="post">
<h6>Update Form 7 Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">Form 7 (Page 1)</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Pass No. </label> <label
	class="value"><%=masPersonnelDetails.getPassNo() %></label> <label>Personnel
Name</label> <label class="value"><%=masPersonnelDetails.getPersonnelName() %></label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">9.i)</label><label class="large3">Total
Period of military service for which gratuity was sanctioned </label> <input
	name="gratuityPeriod" id="gratuityPeriod"
	value="<%=pensionForm7Details.getGratuityPeriod() %>" type="text"
	maxlength="15" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">9.ii)</label><label class="large3">Amount
and nature of any pension/gratuity recieved for the military services</label> <input
	type="text" name="recievedGratuityForMilitaryService"
	id="recievedGratuityForMilitaryService"
	value="<%=pensionForm7Details.getGratuityRecievedMilitary() %>"
	maxlength="15" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">10)</label><label class="large3"> Amount
and nature of any pension/gratuity recieved for the previous civil
services</label> <input name="recievedGratuityForCivilService"
	name="recievedGratuityForCivilService"
	value="<%=pensionForm7Details.getGratuityRecievedMilitary() %>"
	type="text" maxlength="15" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">11.)</label><label class="large3">Govt
under which service has been rendered in order of employment</label>
<h5>years</h5>
<label class="noWidth"></label><label class="valueNoWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolYears() %></label>
<h5>months</h5>
<label class="noWidth"></label><label class="valueNoWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolMonths() %></label>
<h5>Days</h5>
<label class="noWidth"></label><label class="valueNoWidth"><%=masPersonnelDetails.getTotalServiceWithoutEolDays() %></label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">12.)</label><label class="large3"> Class of
pension Applicable</label> <%
	   if(pensionEmolList!= null && pensionEmolList.size()>0){
		   PensionEmoluments pensionEmoluments=pensionEmolList.get(0);
    %> <label class="value">-</label> <%}else{ %> <label class="value">-</label>
<%} %>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">13.)</label>
<h5>The date of which action initiated to</h5>
<div class="Clear"></div>

<label class="small">i.)</label><label class="large3">Obtain the
"No Demand Certificate" directorate Of Escate(BSO)as provided in the
rule 57</label> <%if(pensionForm7Details.getNoDemandCertificate()!= null && !pensionForm7Details.getNoDemandCertificate().equals("")){ %>
<input type="text" class="calDate" id="noDemandCertificate"
	name="noDemandCertificate"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7Details.getNoDemandCertificate()) %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="calDate"
	id="noDemandCertificate" name="noDemandCertificate" value=""
	readonly="readonly" /> <%} %> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.updateForm7Entry.noDemandCertificate,event)" />

<div class="Clear"></div>

<label class="small">ii.)</label><label class="large3">Assess
the service and emoluments qualifying the pension as provided in the
rule 59</label> <%if(pensionForm7Details.getQualifyingPension()!= null && !pensionForm7Details.getQualifyingPension().equals("")){ %>
<input type="text" class="calDate" id="pensionQualifyingDate"
	name="pensionQualifyingDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7Details.getQualifyingPension()) %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="calDate"
	id="pensionQualifyingDate" name="pensionQualifyingDate"
	readonly="readonly" /> <%} %> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.updateForm7Entry.pensionQualifyingDate,event)" />
<div class="Clear"></div>

<label class="small">iii.)</label><label class="large3">Assess
the govt.dues other then the dues relating to the allotment of the
govt.accomodation as provided in rule 73</label> <%if(pensionForm7Details.getDuesAssessment()!= null && !pensionForm7Details.getDuesAssessment().equals("")){ %>
<input type="text" class="calDate" id="duesAssessingDate"
	name="duesAssessingDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7Details.getDuesAssessment()) %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="calDate"
	id="duesAssessingDate" name="duesAssessingDate" readonly="readonly" />
<%} %> <img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('',document.updateForm7Entry.duesAssessingDate,event)" />
<div class="Clear"></div>




</div>
<div class="Clear"></div>
<div class="blockTitle">Form 7 (Page 2)</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">14.)</label><label
	class="large3"> Details of ommission imperfections and
deficiencies in the service book which has been ignored under rule
59(i)(b)(ii) </label> <input type="text" id="deficiency"
	value="<%=pensionForm7Details.getDeficiencies() %>" name="deficiency"
	maxlength="20" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">16.)</label>
<h5>Period of non qualifying service</h5>
<div class="Clear"></div>


<label class="small">i.)</label><label class="large3">
Interuption in service condoned under rule 28 </label> <input type="text"
	id="interruptionInService"
	value="<%=pensionForm7Details.getInterruptionInService() %>"
	name="interruptionInService" maxlength="20" />
<div class="Clear"></div>

<label class="small">ii.)</label><label class="large3">Extraordinary
leave not qualifying under pension</label> <%! int totalEol=0; %> <%
	  if(pensionEolList!= null && pensionEolList.size()>0){
		  System.out.println("total Eol====");
	  for(PensionEol pensionEol: pensionEolList){
		  
		  int eolDays=pensionEol.getTotalDays();
		   totalEol=totalEol+eolDays;
	   }
	  }
	%> <label class="value"><%=totalEol %></label>

<div class="Clear"></div>



<label class="small">iii.)</label><label class="large3"> Period
of suspension not treating as qualifying</label> <input type="text"
	id="suspensionPeriod"
	value="<%=pensionForm7Details.getSuspensionPeriod() %>"
	name="suspensionPeriod" maxlength="30" />
<div class="Clear"></div>

<label class="small">iv.)</label><label class="large3"> Any
other service not treating as qualifying</label> <input type="text"
	id="otherService" name="otherService"
	value="<%=pensionForm7Details.getOtherService() %>" maxlength="30" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">&nbsp;</label> <label class="large3">Total</label>
<input type="text" id="total"
	value="<%=pensionForm7Details.getTotal() %>" name="total"
	maxlength="30" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">17.)</label><label class="large3">
Emoluments reckoning for gratuity</label> <input type="text" id="emolGratuity"
	name="emolGratuity" value="" maxlength="50" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">18.)</label>
<h5>Form7 Sub Question</h5>
<div class="Clear"></div>
<input type="button" class="cmnButton" value="Add" onclick="addRow();" />
<input type="button" class="cmnButton" value="Remove"
	onclick="removeRow();" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="grid">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Designation</th>
		<th scope="col" colspan="2">From Date</th>
		<th scope="col" colspan="2">To date</th>
		<th scope="col">Pay</th>
		<th scope="col">No. of Months</th>
		<th scope="col">Personel Pay</th>
		<th scope="col">Average emoluments</th>

	</tr>
	<%  int i=0;
	       for(PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail:pensionForm7EmolList){
	    	   i++;
	  %>
	<tr>
		<td><input type="text" name="srNo<%=i%>" size="2" value="<%=i%>"
			readonly /></td>
		<td><input type="text" name="designation<%=i%>"
			id="designation<%=i%>"
			value="<%=masPersonnelDetails.getDesignation().getDesignationName() %>"
			readonly /></td>
		<td><input type="text" size="8" name="fromDate<%=i%>"
			id="fromDate<%=i%>"
			value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7EmolumentsDetail.getFromDate()) %>"
			readonly /></td>
		<td><img src="/hms/jsp/images/cal.gif" id="calId1" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.updateForm7Entry.fromDate<%=i%>,event)" /></td>
		<td><input type="text" name="toDDate<%=i%>" size="8"
			id="toDDate<%=i%>"
			value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7EmolumentsDetail.getToDate()) %>"
			onblur="dateDiffernce()" /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.updateForm7Entry.toDDate<%=i%>,event)" /></td>
		<td><input type="text" size="5" name="pay<%=i%>"
			value="<%=pensionForm7EmolumentsDetail.getPay()%>" id="pay<%=i%>"
			onblur="calculateEmolument()" validate="Pay,num,no" maxlength="4" />
		</td>
		<td><input type="text" size="5" name="noOfMonths<%=i%>"
			value="<%=pensionForm7EmolumentsDetail.getNoOfMonths() %>"
			id="noOfMonths<%=i%>" readonly /></td>
		<td><input type="text" size="5" name="personelPay<%=i%>"
			value="<%=pensionForm7EmolumentsDetail.getPersonelPay() %>"
			id="personelPay<%=i%>" maxlength="4" /></td>
		<td><input type="text" size="5" name="averageEmol<%=i%>"
			value="<%=pensionForm7EmolumentsDetail.getAverageEmoluments() %>"
			id="averageEmol<%=i%>" readonly /></td>
	</tr>
	<%} %>
	<input type="hidden" name="hdb" value="<%=i%>" id="hdb" />

</table>
</div>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">19.)</label><label class="large3"> Date on
which form 5 has been obtained from the govt.servant[To be obtained 8
months before the date of retirement of govt.servant]</label> <%if(pensionForm7Details.getForm5Date()!= null && !pensionForm7Details.getForm5Date().equals("")){ %>
<input type="text" class="calDate" id="form5Date"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7Details.getForm5Date()) %>"
	name="form5Date" readonly /> <%}else{ %> <input type="text"
	class="calDate" id="form5Date" name="form5Date" readonly /> <%} %> <img
	src="/hms/jsp/images/cal.gif" id="calId1" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('',document.updateForm7Entry.form5Date,event)" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">21.)</label><label class="large3"> Proposed
death cum retirement gratuity</label> <input type="text" id="proposedGratuity"
	name="proposedGratuity"
	value="<%=pensionForm7Details.getProposedGratuity() %>" maxlength="7"
	validate="proposed Gratuity,num,no" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">22.)</label><label class="large3"> Date
from which pension to commence</label> <%if(pensionForm7Details.getPensionDate()!= null && !pensionForm7Details.getPensionDate().equals("")){ %>
<input type="text" class="calDate" id="pensionDate" name="pensionDate"
	value="<%=HMSUtil.changeDateToddMMyyyy(pensionForm7Details.getPensionDate()) %>"
	readonly /> <%}else{ %> <input type="text" class="calDate"
	id="pensionDate" name="pensionDate" readonly /> <%} %> <img
	src="/hms/jsp/images/cal.gif" id="calId1" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('',document.updateForm7Entry.pensionDate,event)" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">23.)</label><label class="large3"> Proposed
amount of prvisional pension if department or judiciary proceeding is
intituted against the govt. servant before the retirement</label> <input
	type="text" id="proposedAmount"
	value="<%=pensionForm7Details.getProposedAmount() %>"
	name="proposedAmount" maxlength="7" validate="Proposed Amount,num,no" />
<div class="Clear"></div>

</div>

<div class="blockTitle">Form 7 (Page 3)</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<div class="Clear"></div>
<label class="small">24.)</label>
<h5>Details of govt.dues recoverable out of gratuity</h5>
<div class="Clear"></div>

<label class="small">i.)</label><label class="large3"> Licence
fee for the allotment of the govt.accomodation(see sub rules of 2,3,4 of
rule 72)</label> <input id="licenceFee" name="licenceFee" type="text"
	value="<%=pensionForm7Details.getLicenceFee()%>" maxlength="7"
	validate="Licence Fee,num,no" />
<div class="Clear"></div>
<label class="small">ii.)</label><label class="large3">Dues
referred in rule 73</label> <input id="duesReferred" name="duesReferred"
	value="<%=pensionForm7Details.getDuesReferred() %>" type="text"
	maxlength="7" validate="Dues Referred,num,no" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">25.)</label>
<h5>Weather nomination made for</h5>

<div class="Clear"></div>

<label class="small">i.)</label><label class="large3">Death cum
retirement gratuity</label> <select name="deathRetirementGruatuity" />
	<option value="0">Select</option>
	<%if(pensionForm7Details.getNominationForGratuity().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionForm7Details.getNominationForGratuity().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%} %>
</select>
<div class="Clear"></div>

<label class="small">ii.)</label><label class="large3"> Family
pension 1950 if applicable</label> <select name="familyPension" />
	<option value="0">Select</option>
	<%if(pensionForm7Details.getFamilyPension().equals("y")){ %>
	<option value="y" selected>Yes</option>
	<%}else{ %>
	<option value="y">Yes</option>
	<%}if(pensionForm7Details.getFamilyPension().equals("n")){ %>
	<option value="n" selected>No</option>
	<%}else{ %>
	<option value="n">No</option>
	<%} %>
</select>

<div class="Clear"></div>
<div class="division"></div>


<label class="small">27.)</label><label class="large3"> Height</label> <label
	class="value"><%=masPersonnelDetails.getHeight() %></label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">28.)</label><label class="large3">
Identification Mark</label> <label class="value"><%=masPersonnelDetails.getIdentificationMark() %></label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">29.)</label><label class="large3"> Place of
payment of pension(Treasury,subtreasury or branch of public sector bank
or the pay account office)</label> <input id="placeOfPayment"
	name="placeOfPayment"
	value="<%=pensionForm7Details.getPlaceOfPayment() %>" type="text"
	maxlength="50" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">30.)</label><label class="large3"> Head of
account to which pension and gratuity are debitable</label> <input
	id="accountHead" name="accountHead"
	value="<%=pensionForm7Details.getAccountHeadPensionGratutityDebit() %>"
	type="text" maxlength="30" />
<div class="Clear"></div>


</div>


<script type="text/javascript">
	
	function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
 
 	 var cellRight = row.insertCell(0);
	  var e = document.createElement('input');
	  e.type = 'text';
	  e.readOnly = true;
	  e.size='2'
	  e.name = 'srNo' + iteration;
	  e.id = 'srNo' + iteration;
	 
	  e.value = iteration;
	  cellRight.appendChild(e);	
 
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.maxLength = '15';
	  e0.name = 'designation' + iteration;
	  e0.id = 'designation' + iteration;
	  e0.value="<%=masPersonnelDetails.getDesignation().getDesignationName()%>";
	  e0.readOnly = true;
	  cellRight0.appendChild(e0);
	  //new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemList',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
	  	  
	 
	  
	 
  
	  var cellRight1 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '8';
	  e2.name='fromDate'+iteration;
	  e2.id='fromDate'+iteration;
	  e2.readOnly = true;
	  cellRight1.appendChild(e2); 
	  
	  
	  var cellRight2 = row.insertCell(3);
	  var eImg = document.createElement('img');
	 
	  eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
	  setdate('',document.getElementById('fromDate'+iteration),event) };
	  
	  cellRight2.appendChild(eImg);
	 
	 
	  var cellRight3 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '8';
	  e1.name='toDDate'+iteration;
	  e1.id='toDDate'+iteration;
	  e1.readOnly = true;
	  e1.onblur= function(){
	  dateDiffernce();}
	  cellRight3.appendChild(e1); 
	  
	  
	  var cellRight4 = row.insertCell(5);
	  var eImg = document.createElement('img');
	 
	   eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('toDDate'+iteration),event) };
	  
	  cellRight4.appendChild(eImg);
	  
	  var cellRight5 = row.insertCell(6);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size='5';
	  e3.name='pay'+iteration;
	  e3.id='pay'+iteration;
	  e3.onblur= function(){
					calculateEmolument();}
	  
	  cellRight5.appendChild(e3); 
	  
	  
	  var cellRight6 = row.insertCell(7);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.maxLength = '3';
	  e4.size='5';
	  e4.name='noOfMonths'+iteration;
	  e4.id='noOfMonths'+iteration;
	  
	  
	  cellRight6.appendChild(e4);
	  
	  var cellRight7 = row.insertCell(8);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	   e5.size = '5';
	 e5.maxLength = '3';
	  e5.name='personelPay'+iteration;
	  e5.id='personelPay'+iteration;
	 
	  cellRight7.appendChild(e5);
	  
	  
	  var cellRight8 = row.insertCell(9);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	   e6.size = '5';
	  e6.maxLength = '25';
	  e6.name='averageEmol'+iteration;
	  e6.id='averageEmol'+iteration;
	  
	   
	   cellRight8.appendChild(e6); 
	  
	  
	   
	}
	
	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	
	</script>


<div class="bottom">
<div class="division"></div>
<input name="personnelId" type="hidden"
	value="<%=masPersonnelDetails.getId() %>" /> <input
	name="pensionForm7Id" type="hidden"
	value="<%=pensionForm7Details.getId() %>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input name="Submit"
	type="button" class="button" value="Update"
	onclick="submitForm('updateForm7Entry','pension?method=updateForm7Entry')" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('updateForm7Entry','pension?method=showUpdatePersonnelSearchForForm7Jsp')" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>
</form>
</div>

<script type="text/javascript">
	function dateDiffernce(){
	    //alert("in date difference method")
		var day1, day2;
		var month1, month2;
		var year1, year2;
	for(var i=1;i<=document.getElementById('hdb').value;i++){
	 
		value1 = document.getElementById('fromDate'+i).value;
		value2 =document.getElementById('toDDate'+i).value;
		
		
		if(value1 != "" && value2!= ""){
		day1 = value1.substring (0, value1.indexOf ("/"));
		month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
		
		day2 = value2.substring (0, value2.indexOf ("/"));
		month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
		
		date1 = year1+"/"+month1+"/"+day1;
		date2 = year2+"/"+month2+"/"+day2;
		
		firstDate = Date.parse(date1)
		secondDate= Date.parse(date2)
		
		msPerDay = 24 * 60 * 60 * 1000
		dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
			
		
		  var month=Math.floor(dbd/30)
	
		 document.getElementById('noOfMonths'+i).value=month
	 }
	 if(value1==""){
	    alert("please Enter from Date!!")
	    return;
	 }
	}	 
			
  }
  	function calculateEmolument(){
  	  for(var i=1;i<=document.getElementById('hdb').value;i++){
  	   
  	  	var pay=document.getElementById('pay'+i).value;
  	  	var noOfMonths=document.getElementById('noOfMonths'+i).value;
  	  	var averageEmol=pay*noOfMonths;
  	   document.getElementById('averageEmol'+i).value=averageEmol;	
  	  
  	  }
  	}
  
</script>

