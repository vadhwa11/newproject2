<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.*"%>


<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" language="javascript">
	 var masRelationArray=new Array();
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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}

	List<MasUnit> unitList = new ArrayList<MasUnit>();
	if (map.get("unitList") != null) {
		unitList = (List) map.get("unitList");
	}

	List<MasRelation> relationList = new ArrayList<MasRelation>();
	if (map.get("relationList") != null) {
		relationList = (List) map.get("relationList");
	}
	List<MasDesignation> designationList = new ArrayList<MasDesignation>();
	if (map.get("designationList") != null) {
		designationList = (List) map.get("designationList");
	}
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	if (map.get("religionList") != null) {
		religionList = (List) map.get("religionList");
	}
	List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
	if (map.get("genderList") != null) {
		genderList = (List) map.get("genderList");
	}

	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");

	}
%>
<%
	if (!message.equalsIgnoreCase("")) {
%>
<h2><%=message%></h2>
<%
	}
%>

<div id="contentHolder">
<form name="personnelEntry" method="post">
<h6>Personnel Details </h6>
<div class="Clear"></div>

<div class="blockFrame">

<!-- <label>Personnel Id. </label>
	<input name="personnelId" type="text" class="small" readonly />  -->
<div class="Clear"></div>
<label><span>*</span>Unit</label> 
<select name="unit" validate="Unit Name,num,yes" id="unit" onblur="checkForPersonnel();">
	<option value="0">Select</option>
	<%
	   for(MasUnit masUnit:unitList){
		 int unitId=masUnit.getId();
		 String unitName=masUnit.getUnitName();
	   
	%>
	<option value="<%=unitId %>"><%=unitName %></option>
	<%} %>
</select>  

<label><span>*</span>PA/Pass No.</label> 
<input type="text" name="passNo" id="passNo" maxlength="6" validate="Pass No,num,yes" onblur="checkForPersonnel();" />

<label>Sfx</label> 
<input name="sfx" type="text" maxlength="10" />

<div class="Clear"></div>

<label><span>*</span>Designation</label>
<select name="designationId" id="designationId" validate="Designation,num,yes" onblur="ajaxFunctionForRetire(personnelEntry)"; >
	<option value="0">Select</option>
	<%
	   for(MasDesignation masDesignation:designationList){
		   int designationId=masDesignation.getId();
		   String designation=masDesignation.getDesignationName();
		   
	
	%>
	<option value="<%=designationId %>"><%=designation %></option>
	
	<%} %>
</select>
<input type="hidden" name="retierYear" id="retierYear" value=""/>


<label><span>*</span>Personnel Name</label> 
<input name="personnelName" type="text" maxlength="25" validate="Personnel Name,String,yes" />

<label><span>*</span>Father/Husband Name</label> 
<input 	name="fatherOrHusband" type="text" maxlength="25" 	validate="Father/Husband Name,String,yes" />
<div class="Clear"></div>

<label><span>*</span>Religion</label> <select name="religionId"
	validate="Religion,num,yes">
	<option value="0">Select</option>
	<%
	   for(MasReligion masReligion:religionList){
		   int id=masReligion.getId();
		   String religionName=masReligion.getReligionName();
	   
	%>
	<option value="<%= id%>"><%= religionName%></option>
	<%} %>
</select> 



<label><span>*</span>Sex</label>
<select name="genderId" validate="Sex,num,yes">
	<option value="0">Select</option>
	<%for(MasAdministrativeSex masAdministrativeSex:genderList){
    	 int id=masAdministrativeSex.getId();
    	 String gender=masAdministrativeSex.getAdministrativeSexName();
     
     %>
	<option value="<%=id %>"><%=gender %></option>
	<%} %>
</select> 

<label><span>*</span>Present Address</label> 
<textarea name="presentAddress" maxlength="150" validate="Address,address,yes" onkeyup="return ismaxlength(this)"></textarea> 

<div class="Clear"></div>

<label>Present PIN</label> 
<input name="presentPin" type="text" maxlength="10" /> 

<label>Permanent Address</label> 
<textarea name="permanentAddress" 	maxlength="150" onkeyup="return ismaxlength(this)"></textarea>

<label>Permanent PIN</label> 
<input name="permanentPin" type="text" maxlength="10" /> 

<div class="Clear"></div>

<label>Bank Address</label> 
<textarea name="bankAddress" maxlength="150" onkeyup="return ismaxlength(this)"></textarea> 

<label><span>*</span>BankA/C No. </label> 
<input name="acNo" type="text" maxlength="20" validate="Bank A/C No,num,yes" /> 
	
<label><span>*</span>Pay Scale</label> 
<input name="payScale"	type="text" maxlength="50" validate="Pay Scale,String,yes" />
	
<div class="Clear"></div>

<label>Height</label> <input name="height" type="text" class="small"
	maxlength="3" /> 
	
<label>Identification Mark</label> 
<input style="width: 500" name="identificationMark" type="text" maxlength="80" /> 

</div>

<div class="Clear"></div>

<div class="blockFrame">

    <label><span>*</span>Birth </label> 
    <input type="text" class="calDate" id="birthDate" name="birthDate" validate="Date Of Birth,string,yes" readonly="readonly" onblur="calculateRetierDate();" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.personnelEntry.birthDate,event)" />
	
	 
	<label>Marriage</label>
	<input type="text" class="calDate" id="marriageDate" name="marriageDate"
	readonly="readonly"/> 
	<img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.personnelEntry.marriageDate,event)" />
	
	<label><span>*</span>Appointment</label> 
	<input type="text" class="calDate" id="appointmentDate"	name="appointmentDate" 
	validate="Appointment Date,string,yes" readonly="readonly" 
	onblur="showAppointmentDate(this.value);dateDiffernce1();" /> 
	
	<img  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" 
	validate="Pick a date"  onClick="setdate('',document.personnelEntry.appointmentDate,event)" />




	<label><span>*</span>Posting In</label> <input type="text" class="calDate" 
	id="postingInDate" name="postingInDate"
	validate="Posting In Date,string,yes" readonly="readonly"/>
	
	 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"	onClick="setdate('',document.personnelEntry.postingInDate,event)" /> 
	
	<label>Increment</label> 
	<input type="text" class="calDate" id="incrementDate"
	name="incrementDate" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.personnelEntry.incrementDate,event)" /> 
	
	<label><span>*</span>Retirement</label>
	<input type="text" class="calDate" id="retirementDate"
	name="retirementDate" readonly="readonly"
	validate="Retirement Date,string,yes"  /> 
	<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.personnelEntry.retirementDate,event)" /> 
	
	<label>Posted Out</label> <input type="text" class="calDate" id="postedOutDate"
	name="postedOutDate" readonly="readonly"  /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.personnelEntry.postedOutDate,event)" /></div>
	
	
<div class="blockFrame">
<div class="Height10"></div>
<div class="Clear"></div>
<div class="paddLeft55">

<label class="noWidth">Total Service without deducting EOL</label>
<input style="width: 50" id="serviceYears" name="serviceYears" type="text" class="calDate"
	readonly /> <label class="valueMedium">years</label> <input
	id="serviceMonths" style="width: 50" name="serviceMonths" type="text" class="calDate"
	readonly /> <label class="valueMedium">Months</label> <input
	id="serviceDays" style="width: 50" name="serviceDays" type="text" class="calDate"
	readonly /> <label class="valueMedium">Days</label></div>
</div>
<div class="Clear"></div>
<input type="button" class="cmnButton" value="Add" onclick="addRow();" />
<input type="button" class="cmnButton" value="Remove"
	onclick="removeRow();" />
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="grid">
	<tr>
		<th scope="col">Sr. No.</th>
		<th scope="col">Family Name.</th>
		<th scope="col">Relation</th>
		<th scope="col" colspan="2">DOB</th>
		<th scope="col">Is Nominee</th>
		<th scope="col">Nominee(%)</th>
		<th scope="col">Height</th>
		<th scope="col">Identification Mark</th>
	</tr>
	<tr>
		<td><input type="text" name="srNo" calss="small" value="1"
			readonly /></td>
		<td><input type="text" name="familyName1" tabindex="1"
			id="familyName1" maxlength="25" /></td>
		<td><select name="relation1" id="relation1" tabindex="1">
			<option value="0">Select</option>
			<%
         int i=0;
             for(MasRelation masRelation:relationList){
            	 int relationId=masRelation.getId();
            	 String relation=masRelation.getRelationName();
            
         %>
			<option value="<%=relationId %>"><%=relation %></option>
			<script>
	    	  
	          masRelationArray[<%=i%>]= new Array();
	          masRelationArray[<%=i%>][0] = "<%=relationId%>";
	          masRelationArray[<%=i%>][1] = "<%=relation%>";
            </script>
			<% i++;} %>
		</select></td>
		<td><input name="dateOfBirth1" id="dateOfBirth1" type="text"
			size="8" readonly /></td>
		<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onClick="setdate('',document.personnelEntry.dateOfBirth1,event)" /> <!-- <img id="calId1 %>" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"  validate="Pick a date"
			class="calender" onclick="setdate('',document.getElementById('dateOfBirth1'),event)" />
	 --></td>
		<td><input type="checkbox" name="isNominee1" tabindex="1"
			id="isNominee1" onchange="enabledNomineePercent()"/></td>
		<td><input type="text" name="nomineePercent1" tabindex="1"
			id="nomineePercent1" maxlength="3" disabled = false/></td>
		<td><input type="text" class="small" name="height1" tabindex="1"
			id="height1" maxlength="3" /></td>
		<td><input type="text" name="identificationMark1" tabindex="1"
			id="identificationMark1" maxlength="25" /></td>
		<input type="hidden" name="hdb" value="1" id="hdb" />
	</tr>


</table>
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
	  e.classname='small'
	  e.name = 'srNo' + iteration;
	  e.id = 'srNo' + iteration;
	 
	  e.value = iteration;
	  cellRight.appendChild(e);	
 
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.maxLength = '25';
	  e0.name = 'familyName' + iteration;
	  e0.id = 'familyName' + iteration;
	 
	 
	  cellRight0.appendChild(e0);
	  //new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1','opd?method=getItemList',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
	  	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('Select');
	  sel.classname='smalllabel'
	  sel.name='relation'+iteration;
	  sel.id='relation'+iteration
	  sel.options[0] = new Option('Select', 'value0');
	  for(var i = 0;i<masRelationArray.length;i++ ){
	      sel.options[masRelationArray[i][0]] = new Option(masRelationArray[i][1],masRelationArray[i][0]);
	      }
	  cellRightSel.appendChild(sel);
	  
	 
  
	  var cellRight2 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '8';
	  e2.name='dateOfBirth'+iteration;
	  e2.id='dateOfBirth'+iteration;
	  e2.readOnly = true;
	  cellRight2.appendChild(e2); 
	  
	 /* var eImg = document.createElement('img');
	 
	   eImg.src = '/hms/jsp/images/cal.gif';
	  eImg.class = 'calender';
	 // eImg.style.display ='none';
	 eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('dateOfBirth'+iteration),event) };
	  
	  cellRight2.appendChild(eImg);*/
	  //<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  onClick="setdate('document.personnelEntry.dateOfBirth'"+iteration+",'event')"/>
	  
	  
	   var cellRight3 = row.insertCell(4);
	   var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/cal.gif';
	   eImg.id = 'calId'+iteration;
	  eImg.onclick = function(event){
					setdate('',document.getElementById('dateOfBirth'+iteration),event) };
	     
	  cellRight3.appendChild(eImg); 
	  
	  	  
	  
	  
	  var cellRight4 = row.insertCell(5);
	  var e3 = document.createElement('input');
	  e3.type = 'checkbox';
	  e3.name='isNominee'+iteration;
	  e3.id='isNominee'+iteration;
	  e3.classname='smalllabel';
	  e3.onchange=function(event){enabledNomineePercent()};
	  cellRight4.appendChild(e3); 
	  
	  
	  var cellRight5 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.maxLength = '3';
	  e4.name='nomineePercent'+iteration;
	  e4.id='nomineePercent'+iteration;
      e4.disabled = true;
	  
	  cellRight5.appendChild(e4);
	  
	  var cellRight6 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.maxLength = '3';
	  e5.name='height'+iteration;
	  e5.id='height'+iteration;
	 
	  cellRight6.appendChild(e5);
	  
	  
	  var cellRight7 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.maxLength = '25';
	  e6.name='identificationMark'+iteration;
	  e6.id='identificationMark'+iteration;
	  
	   
	   cellRight7.appendChild(e6); 
	  
	  
	   
	}
	
	function removeRow()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	
	</script>


<div class="bottom"><input id="serviceInDays" name="serviceInDays"
	type="hidden" value="" /> <input type="hidden" name="<%=CHANGED_BY%>"
	value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" id="currentDate" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
	<input name="Submit" type="button" class="button" value="Save" onclick="checkNomineePercent();" />
<input name="Button" type="reset" id="reset" class="button"
	value="Reset" onclick="resetCheck();" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time %></label>
<div class="Clear"></div>


</div>
<br>
<br>
<br>
</form>
</div>
</body>
</html>


<script type="text/javascript">

	function dateDiffernce(){
	    //alert("in date difference method")
		var day1, day2;
		var month1, month2;
		var year1, year2;
		
		value1 = personnelEntry.appointmentDate.value;
		value2 = personnelEntry.retirementDate.value;
		
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
			//alert("value of differnece====="+dbd)
		
		var yearMonthDays=calculateYearMonthDays(value1,value2);
		
		years = yearMonthDays.substring (0, yearMonthDays.indexOf (","));
		months = yearMonthDays.substring (yearMonthDays.indexOf (",")+1, yearMonthDays.lastIndexOf (","));
		days = yearMonthDays.substring (yearMonthDays.lastIndexOf (",")+1, yearMonthDays.length);
		//alert("years==="+years+"==months===="+months+"==days---"+days);
		
		 document.getElementById('serviceYears').value=years;
		 document.getElementById('serviceMonths').value=months
		 document.getElementById('serviceDays').value=days
		 document.getElementById('serviceInDays').value=dbd;
		//alert("No of years===="+year+"==no of months==="+month+"====no of days===="+days)	
  }
  
  function validateFieldsInGrid(){
			
			 for(var i = 1; i <= document.getElementById('hdb').value; i++){
			
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			 if(document.getElementById('relation'+i).value != 0)
              {
                if(document.getElementById('relation'+i).value != 0){
				     //alert("value of relation==="+document.getElementById('relation'+i).value)
				     if(document.getElementById('dateOfBirth'+i).value != ""){
				        
				     }else{
				       alert("Please select the Date Of Birth.")
					   return false;
				     }
				}else{
				    alert("Please select the Relation")
					return false;
				}
				  
				
			  }	
  		   }
  		
		return true;
		
	}
	 function calculateYearMonthDays(value1,value2){
		var ToMonth,FromMonth,MonthDiff; 
		var ToDays,FromDays,DaysDiff;
		
		var TotalService;
		
		
		//value1 = personnelEntry.appointmentDate.value;
		//value2 = personnelEntry.retirementDate.value; 
		
		FromDays = value1.substring (0, value1.indexOf ("/"));
		FromMonth = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
		FromYear = value1.substring (value1.lastIndexOf ("/")+1, value1.length);
		
		ToDays = value2.substring (0, value2.indexOf ("/"));
		ToMonth = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
		ToYear = value2.substring (value2.lastIndexOf ("/")+1, value2.length);
		//alert("Tomonth===="+ToMonth+"===FromMonth===="+FromMonth);
	//	ToYear = Year(Me!Date_of_retirement)
		//FromYear = Year(Me!Date_of_induction)
		var YearDiff = ToYear.valueOf() - FromYear.valueOf();
		//alert("year difference===="+YearDiff)
		//ToMonth = Month(Me!Date_of_retirement)
		//FromMonth = Month(Me!Date_of_induction)
		//var toMonth= parseInt(ToMonth);
		var fromMonth= parseInt(FromMonth);
		//alert("===fromMonth=="+fromMonth);
		
		if(ToMonth.valueOf() < fromMonth){
		    YearDiff = YearDiff - 1
		    //alert("parseInt()==========="+parseInt(ToMonth))
		    var ToMonth = 12 + parseInt(ToMonth);
		   // alert("value of tomonth in if loop==="+ToMonth)
		}
		
		MonthDiff = ToMonth.valueOf() - FromMonth.valueOf()
		//alert("month difference===="+MonthDiff)
		//ToDays = Day(Me!Date_of_retirement)
		//FromDays = Day(Me!Date_of_induction)
		var fromDays=parseInt(FromDays);
		if(ToDays.valueOf() < fromDays){
		    MonthDiff = MonthDiff - 1
		    ToDays =  30+ parseInt(ToDays);
		   // alert("value of ToDays in if loop==="+ToDays)
		}
		
		DaysDiff = ToDays.valueOf()  - FromDays.valueOf() 
		//alert("Days difference===="+DaysDiff)
		//TotalService = YearDiff & " Years " & MonthDiff & " Months " & DaysDiff &" Days "
		//alert("==== Years "+YearDiff+"=== Months==== "+ MonthDiff  +"==== Days "+DaysDiff)
		return YearDiff+","+MonthDiff+","+DaysDiff;
	}
	
	function checkNomineePercent(){
			//alert("in nomineee")
			var nomineePercent;
			for(var i=1;i<=document.getElementById('hdb').value;i++)
		    {
		      if(document.getElementById('isNominee'+i).checked)
		        { 
		          if(isNaN(nomineePercent)){
		           nomPer=parseInt(document.getElementById('nomineePercent'+i).value);
		           if(isNaN(nomPer)){
		               alert("Please Enter Numeric Value for Nominee Percent.")
		               document.getElementById('nomineePercent'+i).value="";
		               return false;
		           }
		           nomineePercent=nomPer;
		           
		           }else{
		             nomPer=parseInt(document.getElementById('nomineePercent'+i).value);
		             if(isNaN(nomPer)){
		               alert("Please Enter Numeric Value for Nominee Percent.")
		               document.getElementById('nomineePercent'+i).value="";
		               return false;
		           }
		           	nomineePercent=nomPer+parseInt(nomineePercent);
		           }
		           //alert("nomineePercent value=="+nomineePercent)
		           if(nomineePercent >100 ||nomineePercent<100){
		              alert("Nominee % should be Equal to 100. ")
		               document.getElementById('nomineePercent'+i).value="";
		              return false;
		             
		           }
		       }else{
		        // alert(document.getElementById('nomineePercent'+i).value);
		         document.getElementById('nomineePercent'+i).value="";
		       }
		    }
		    submitForm('personnelEntry','pension?method=submitPersonnelEntryDetailsJsp');
		    return true;
	    
	}
	
	
	
	
	
	
	
	function validateDateOfBirth(){
  	   
  	   var dateOfBirth=document.getElementById('birthDate').value;
  	   var marriageDate=document.getElementById('marriageDate').value;
  	   var appointmentDate=document.getElementById('appointmentDate').value;
  	   var postingInDate=document.getElementById('postingInDate').value;
  	   var incrementDate=document.getElementById('incrementDate').value;
  	   var retirementDate=document.getElementById('retirementDate').value;
  	   var postedOutDate=document.getElementById('postedOutDate').value;
  	   var currentDate=document.getElementById('currentDate').value;
  	   
  	   
  	   
  	    birthDate = Date.parse(dateOfBirth)
  	    dateOfMarriage = Date.parse(marriageDate)
  	    dateOfAppointment = Date.parse(appointmentDate)
  	    dateOfPostingIn = Date.parse(postingInDate)
  	    dateOfIncrement = Date.parse(incrementDate)
  	    dateOfRetirement = Date.parse(retirementDate)
  	    dateOfPostedOut = Date.parse(postedOutDate)
  	    
		secondDate= Date.parse(currentDate)
  	 
  	    if(birthDate>=secondDate){
  	       alert("Please Enter Correct Date Of Birth")
  	       document.getElementById('birthDate').value="";
  	    }
  	    if(dateOfRetirement<=dateOfAppointment || dateOfRetirement<=birthDate){
  	     alert("Please Enter Correct Retirement Date.")
  	     document.getElementById('retirementDate').value="";
  	    }
  	    if(dateOfMarriage<=birthDate){
  	      alert("Please Enter Correct Marriage Date.")
  	      document.getElementById('marriageDate').value="";
  	    }
  	    if(dateOfAppointment<=birthDate || dateOfAppointment>=dateOfRetirement){
  	      alert("Please Enter Correct Appointment Date.")
  	       document.getElementById('appointmentDate').value="";
  	    }
  	    if(dateOfIncrement<=dateOfAppointment ||dateOfIncrement>=dateOfRetirement){
  	       alert("Please Enter Correct Increment Date.")
  	       document.getElementById('incrementDate').value="";
  	    }
  	    
  	    if(dateOfPostingIn<=dateOfAppointment || dateOfPostingIn>=dateOfRetirement){
  	       alert("Please Enter Correct Posting In Date.");
  	       document.getElementById('postingInDate').value="";
  	    }
  	    if(dateOfPostedOut<=dateOfAppointment ||dateOfPostedOut>=dateOfRetirement){
  	       alert("Please Enter Correct Posted Out Date.");
  	       document.getElementById('postedOutDate').value="";
  	    } 
  	}
  	
	function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
	}
		
	
	
	function showAppointmentDate(value){
		 var a = value;
		 document.getElementById('postingInDate').value=a;
	}
			
			
	function calculateRetirementDate(){
		if (document.getElementById('designationId') != null)
		{
			var value2 = document.getElementById('designationId').value;
			alert(value2);
		}	
	}
			
	function enabledNomineePercent(){
		for(var i=1;i<=document.getElementById('hdb').value;i++){
			
			 if(document.getElementById('isNominee'+i).checked){
				document.getElementById('nomineePercent'+i).disabled  = false;
				
			 }	
			 else{ 
			     document.getElementById('nomineePercent'+i).disabled = true;
			     document.getElementById('nomineePercent'+i).value     = "";
			 }    
		} 		
	}	
				
	function calculateRetierDate(){
	  
		var day1 ;
		var month1;
		var year1 ;
		//var retiredate;
		//var retierAge;
		//var retierYear=0;
			obj1 = document.getElementById('birthDate').value;
			day1 = obj1.substring (0, obj1.indexOf ("/"));
			month1 = obj1.substring (obj1.indexOf ("/")+1, obj1.lastIndexOf ("/"));
			year = obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length);
			year1 = parseInt(obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length));
			if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 )
			{
			day1=31;
			month1=month1;
			year1= year1+60;
			}  
			
			 else 
			 {
			     if(month1==2)
			       {
			        var year2 =year1%4;
			        if(year2==0)
		               {
		              day1=29;
			          month1=month1;
			          year1= year1+60;
		               }else 
		               {
		              day1=28;
			          month1=month1;
			          year1= year1+60;
		               }	
			
			          }
			         else {
			         day1=30;
			         month1=month1;
			        year1= year1+60;
			         }
			     }
			
			//retierAge=parseInt(document.getElementById('retierYear').value);
			//retierYear=year1 + retierAge;
			//var days= 32-new Date(year1,month1-1,32).getDate();
			
			
			date1 = day1+"/"+month1+"/"+year1;
			document.getElementById('retirementDate').value=date1;
		}
		
		
		function dateDiffernce1(){
	       var day1 ;
		   var month1;
		   var year1 ;
		   var day2 ;
		   var month2;
		   var year2 ;
		   var DaysDiff;
		   var MonthDiff;
		   var YearDiff;
		   var monthChk;
		
			obj1 = document.getElementById('retirementDate').value;
			day1 = obj1.substring (0, obj1.indexOf ("/"));
			month1 = obj1.substring (obj1.indexOf ("/")+1, obj1.lastIndexOf ("/"));
			year11 = obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length);
			year1 = parseInt(obj1.substring (obj1.lastIndexOf ("/")+1, obj1.length));

			obj2 = document.getElementById('appointmentDate').value;
			day2 = obj2.substring (0, obj2.indexOf ("/"));
			month2 = obj2.substring (obj2.indexOf ("/")+1, obj2.lastIndexOf ("/"));
			year22 = obj2.substring (obj2.lastIndexOf ("/")+1, obj2.length);
			year2 = parseInt(obj2.substring (obj2.lastIndexOf ("/")+1, obj2.length));
	
	
			if (day1==day2) {
				if (month1==month2) {
					if (year1==year2) {
						DaysDiff=1;
						MonthDiff=0;
						YearDiff=0;						
					}else {
						if (year1>year2) {
							DaysDiff=1;
							MonthDiff=0;
							YearDiff=parseInt(year1)-parseInt(year2);							
						}
						else {
							  alert("Retirement Date should be greater then appointment Date.")
							   return false;
						}
					}
					
				} else {
					if (month1>month2) {
						if (year1==year2) {
							
							DaysDiff=1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							YearDiff=parseInt(year1)-parseInt(year2);
							
						}else {
							if (year1>year2) {
								DaysDiff=1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
							}
							else {
								  alert("Retirement Date should be greater then appointment Date.")
								   return false;
							}
							
						}
						
					}else {
                           if (year1==year2) {
							
                        	   alert("Retirement Date should be greater then appointment Date.")
							   return false;
						}else {
							if (year1>year2) {
								DaysDiff=1;
								month1=parseInt(month1)+12;
								year1=parseInt(year1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
														
							}
							else {
								  alert("Retirement Date should be greater then appointment Date.")
								   return false;
							}
							
						}
						
					}
					
				}
				
			}
			else {
				if (day1>day2) {
				
						if (month1==month2) {
						if (year1==year2) {	
							
							DaysDiff=(parseInt(day1)-parseInt(day2))+1;
							MonthDiff=parseInt(month1)-parseInt(month2);
							//monthChk = (parseInt(month1)-parseInt(month2)) + 1;
							YearDiff= parseInt(year1)-parseInt(year2);
							//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
									
									
								 if(month1==4 || month1==6 || month1==9 || month1==11  ){
									if(DaysDiff >=30 ){
								       DaysDiff = 0;
									   MonthDiff = MonthDiff+1;
									   if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									   }  
									} 
							    }	
							 
						      }			
							}			
						}else {
							if (year1>year2) {
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
								else{ if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
							}else {
								alert("Retirement Date should be greater then appointment Date.")
								   return false;
							}
						}
					}else {
						if (month1>month2) {
							if (year1==year2) {	
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);	
								
								
								
							//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
									
									
									
									
									 
							}else {if (year1>year2) {
							
								DaysDiff=(parseInt(day1)-parseInt(day2))+1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								
																
							}else {
								alert("Retirement Date should be greater then appointment Date.")
								   return false;
							}
								
							}
							
						}else {
							if (year1==year2) {	
								alert("Retirement Date should be greater then appointment Date.")
								   return false;
							}else {
								if (year1>year2) {
									
									month1=parseInt(month1)+12;
									year1=parseInt(year1)-1;
									DaysDiff=(parseInt(day1)-parseInt(day2))+1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									
										//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
									
									
									 
								}else {
									alert("Retirement Date should be greater then appointment Date.")
									return false;
								}
							}
						}
					}
				}else {
			
				    
					if (month1==month2) {
					   	if (year1==year2) {	
							alert("Retirement Date should be greater then appointment Date.")
							return false;
						}else {
							if (year1>year2) {
								day2=31-parseInt(day2);												
								
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)+12;
								MonthDiff=parseInt(month1)-parseInt(month2);
								MonthDiff=parseInt(MonthDiff)-1;
								year1=parseInt(year1)-1;
								YearDiff=parseInt(year1)-parseInt(year2);
								
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								 
							}else {
								alert("Retirement Date should be greater then appointment Date.")
								return false;
							}
						}
					}else {
							if (month1>month2) {
							if (year1==year2) {	
								day2=31-parseInt(day2);
								DaysDiff=parseInt(day1)+parseInt(day2);
								month1=parseInt(month1)-1;
								MonthDiff=parseInt(month1)-parseInt(month2);
								YearDiff=parseInt(year1)-parseInt(year2);
								
								
								
								//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								
								
								
								
							}else {
								if (year1>year2) {	
									day2=31-parseInt(day2);
									DaysDiff = parseInt(day1) +parseInt(day2);
									month1=parseInt(month1)-1;
									MonthDiff=parseInt(month1)-parseInt(month2);
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									
									//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								     
								     
								     
								}else {
									alert("Retirement Date should be greater then appointment Date.")
									return false;
								}
							}
							
						}else {
							if (year1==year2) {	
								alert("Retirement Date should be greater then appointment Date.")
								return false;
							}else {
								if (year1>year2) {	
							
								
									day2=31-parseInt(day2);
									DaysDiff= parseInt(day2)+parseInt(day1);
									month1=parseInt(month1)+12;
								    MonthDiff=parseInt(month1)-parseInt(month2);
									MonthDiff=parseInt(MonthDiff)-1;
									year1=parseInt(year1)-1;
									YearDiff=parseInt(year1)-parseInt(year2);
									
									
									//alert("monthChk -- "+monthChk);
							if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12 ){
									if(DaysDiff >=31 ){
											     DaysDiff = 0;
												 MonthDiff = MonthDiff+1;
												 if(MonthDiff >= 12){
												   DaysDiff = 0;
												   MonthDiff =0;
												   YearDiff = YearDiff + 1;
												 }  
									} 
							}
							
							else{
								   if(month1 == 2){
																	   
								        var yearChk = year1 % 4;
									    if(yearChk==0)
								         {
									         if(DaysDiff >=29 ){
												     DaysDiff = 0;
													 MonthDiff = MonthDiff+1;
													 if(MonthDiff >= 12){
													   DaysDiff = 0;
													   MonthDiff =0;
													   YearDiff = YearDiff + 1;
													 }  
												} 
								              
									      }else{
											if(DaysDiff >=28 ){
													     DaysDiff = 0;
														 MonthDiff = MonthDiff+1;
														 if(MonthDiff >= 12){
														   DaysDiff = 0;
														   MonthDiff =0;
														   YearDiff = YearDiff + 1;
														 }  
											} 
										   }	
									}
									
									
									
									else{
								    if(month1==4 || month1==6 || month1==9 || month1==11  ){
									  if(DaysDiff >=30 ){
								        DaysDiff = 0;
									    MonthDiff = MonthDiff+1;
									    if(MonthDiff >= 12){
										  DaysDiff = 0;
										  MonthDiff =0;
										  YearDiff = YearDiff + 1;
									    }  
									  } 
							       }	
							 
						        }			
							}
								     
								      									
									
								}else {
									alert("Retirement Date should be greater then appointment Date.")
									return false;
								}
								
							}
						}
					}
				}
				
			}

			

           document.getElementById('serviceDays').value=DaysDiff;
	       document.getElementById('serviceMonths').value=MonthDiff;
	       document.getElementById('serviceYears').value=YearDiff;
}
		
		
		
		function test1(){
		
			//var myVar = prompt("Enter a future date: ")
			var mydate= new Date()
			var user_date= new Date()
			var today_date= new Date()
			var date1 = document.getElementById('retirementDate').value;
			user_date = Date.parse(date1);
			alert("retirment date :"+user_date);
			var date2 = document.getElementById('appointmentDate').value;
			today_date = Date.parse(date2);
			alert("appointment date :"+today_date);
			
			var mydate =   (today_date - user_date);
			var y = DateDiff("yyyy",user_date,today_date);
			var m = DateDiff("m",user_date,today_date);
			var d = DateDiff("d",user_date,today_date); 
			alert("Y---M----D"+y+"----"+m+"--------"+d);
			
			alert("My_date "+mydate);
			var num_years = (mydate/31536000000) * -1;
			
			alert("num_years "+Math.floor(num_years));
			var num_months = ((mydate % 31536000000)/2628000000)* -1;
			alert("num_months "+Math.floor(num_months));
			var num_days = (((mydate % 31536000000) % 2628000000)/86400000) * -1;
			alert("num_days "+num_days);
			document.getElementById('serviceDays').value=Math.round(num_days);
		    document.getElementById('serviceMonths').value=Math.round(num_months);
		    document.getElementById('serviceYears').value=Math.round(num_years);
		}
		function checkForPersonnel(){
		var unitId=document.getElementById('unit').value;
		var passNo = document.getElementById('passNo').value;
		if(unitId!=0 && passNo!=''){
		ajaxFunctionForPersonnelEntry(unitId,passNo);		
		}
		}
function ajaxFunctionForPersonnelEntry(unitId , passNo) {

  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
      	var items =xmlHttp.responseXML.getElementsByTagName("items")[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var personnelName  = item.getElementsByTagName("personnelName")[0];
	        var unitName  = item.getElementsByTagName("unitName")[0];
	        var passNo  = item.getElementsByTagName("passNo")[0];
	        if(personnelName.childNodes[0].nodeValue!=""){
        	alert("Person "+personnelName.childNodes[0].nodeValue+"\n with unit "+unitName.childNodes[0].nodeValue+" and passNo. "+passNo.childNodes[0].nodeValue+" Already Exist" );
        	document.getElementById('unit').selectedIndex=0;
        	document.getElementById('passNo').value='';
        	}
      	} 
      }
    }
    var url="pension?method=checkEmployeeFromDB"+"&unitId="+unitId+"&passNo="+passNo ;
     
    xmlHttp.open("GET",url,true);
    
    xmlHttp.send(null);
  }
	</script>
