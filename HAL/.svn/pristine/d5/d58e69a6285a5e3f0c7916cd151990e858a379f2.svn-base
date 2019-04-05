
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
	
	
	MasPersonnelDetails masPersonnelDetails=masPersonnelDetailsList.get(0);	
	
	
	if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>
<div id="contentHolder">
<form name="form8Entry" method="post">
<h6>Form 8 Entry</h6>
<div class="Clear"></div>
<div class="blockTitle">See Rule 61 (1)</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Pass No. </label> <label
	class="value"><%=masPersonnelDetails.getPassNo() %></label> <label>Personnel
Name</label> <label class="value"><%=masPersonnelDetails.getPersonnelName() %></label>

<div class="Clear"></div>
<div class="division"></div>

<label>File No. </label> <input name="fileNo" id="" fileNo"" type="text"
	maxlength="15" /> <label>Date</label> <input type="text" name="date"
	class="calDate" id="date" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.form8Entry.date,event)" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small">2.)</label><label class="large3">The detail
of Govt.dues which will remain outstanding on the date of retirement of
the Govt. servant and which need to be recovered out of the amount of
death-cum-retirement gratuity are indicated below :-</label>

<div class="Clear"></div>
<div class="division"></div>

<label class="small">a.)</label><label class="large3">Balance of
house building or conveyance advance</label> <input type="text" id="balance"
	name="balance" maxlength="5" validate="Balance,num,no"
	onblur="calculateTotalForForm8()" />
<div class="Clear"></div>


<label class="small">b.)</label><label class="large3">Over
payment of pay and allowance including leave salary</label> <input type="text"
	id="overPayment" name="overPayment" maxlength="5"
	validate="Over Payment,num,no" onblur="calculateTotalForForm8()" />

<div class="Clear"></div>
<label class="small">c.)</label><label class="large3">Income Tax
deductible at source under the Income Tax act[1961](43 of 1961)</label> <input
	type="text" id="taxDeductible" name="taxDeductible" maxlength="5"
	validate="Income Tax Deductible,num,no"
	onblur="calculateTotalForForm8()" />
<div class="Clear"></div>

<label class="small">d.)</label><label class="large3">Arrears of
licence fee for occupation of govt.accomodation</label> <input type="text"
	id="arrears" name="arrears" maxlength="5"
	validate="Arrears Of Licence Fee,num,no"
	onblur="calculateTotalForForm8()" />


<div class="Clear"></div>

<label class="small">e.)</label><label class="large3">Amount of
licence fee for the retention of the govt. accomodation for the
permissible period of two month beyond the date of retirement</label> <input
	type="text" id="amountOfLicenceFee" name="amountOfLicenceFee"
	validate="Amount Of Licence Fee,num,no"
	onblur="calculateTotalForForm8()" maxlength="5" />
<div class="Clear"></div>

<label class="small">f.)</label><label class="large3">Any other
assessed dues and the nature there of</label> <input type="text" id="otherDues"
	name="otherDues" validate="Other Assessed Dues,num,no" maxlength="5"
	onblur="calculateTotalForForm8()" />

<div class="Clear"></div>
<label class="small">g.)</label><label class="large3">Amount of
gratuity to be with held for the adjustment of un-assessed dues if any</label> <input
	type="text" id="amountOfGratuityHeld" name="amountOfGratuityHeld"
	maxlength="5" validate="Amount Of Gratuity,num,no"
	onblur="calculateTotalForForm8()" />

<div class="Clear"></div>
<div class="division"></div>

<label class="small"></lablel><label class="large3">Total</label> <input
	type="text" id="total" name="total" readonly /></div>

<div class="bottom">
<div class="division"></div>
<input name="personnelId" type="hidden"
	value="<%=masPersonnelDetails.getId() %>" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input name="Submit"
	type="button" class="button" value="Save"
	onclick="submitForm('form8Entry','pension?method=submitForm8Entry')" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('form8Entry','pension?method=showPersonnelSearchForForm8Jsp')" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>


</div>

</form>
</div>

<script type="text/javascript">
		
		function calculateTotalForForm8(){
		 
		  var total;
		  var balance = parseFloat(document.getElementById('balance').value)
		  
		  var overPayment = parseFloat(document.getElementById('overPayment').value)
		  
		  var taxDeductible = parseFloat(document.getElementById('taxDeductible').value)
		  var arrears = parseFloat(document.getElementById('arrears').value)
		  var amountOfLicenceFee = parseFloat(document.getElementById('amountOfLicenceFee').value)
		  var otherDues = parseFloat(document.getElementById('otherDues').value)
		  var amountOfGratuityHeld = parseFloat(document.getElementById('amountOfGratuityHeld').value)
		 if(isNaN(balance)){
		    balance=0;
		  }
		  if(isNaN(overPayment)){
		    overPayment=0;
		  }
		  if(isNaN(taxDeductible)){
		    taxDeductible=0;
		  }
		  if(isNaN(arrears)){
		    arrears=0;
		  }
		  if(isNaN(amountOfLicenceFee)){
		    amountOfLicenceFee=0;
		  }
		  if(isNaN(otherDues)){
		    otherDues=0;
		  }
		  if(isNaN(amountOfGratuityHeld)){
		    amountOfGratuityHeld=0;
		  }
		
		   total=balance+overPayment+taxDeductible+arrears+amountOfLicenceFee+otherDues+amountOfGratuityHeld;
		  // alert("total value==="+total);
		   document.getElementById('total').value=total;
		  
		}
	</script>

