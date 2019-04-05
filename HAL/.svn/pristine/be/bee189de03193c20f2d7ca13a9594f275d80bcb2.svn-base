<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.FatalDocumentHeader"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
			 function calculateAgeInAjaxFunction()
		     {
			    dob=document.getElementById('dobId').value;
			  		if(dob!= ""){
						if(checkDob('dobId')){
						action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+dob;	
						obj = eval('document.fatalDocumentForm')
						       obj.action = action;
					    	   	 var url=action
						}
			  		}
			  var xmlHttp;
			  try {
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
			      	for (loop = 0; loop < items.childNodes.length; loop++) {
				   	    var item = items.childNodes[loop];
				        var age  = item.getElementsByTagName("age")[0];
				        var period  = item.getElementsByTagName("period")[0];
				       obj=eval(document.getElementById('ageId'))
				       if(age.childNodes[0].nodeValue == "0"){
				       obj.value=0;
				       }else{
					   obj.value=age.childNodes[0].nodeValue}
					    temp = eval("document.fatalDocumentForm.ageUnit");
					   temp.value=period.childNodes[0].nodeValue
			      	} 
			      }
			    }
			    var url=action
			     
			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);
		  }

		function calculateTotalServiceFunction(comDate)
		{
			  if(comDate != "")
			 {
				 var commissionDate = new Date(comDate.substring(6),(comDate.substring(3,5) - 1) ,comDate.substring(0,2));
				 currentDate = new Date();
				 var month = currentDate.getMonth() + 1
				 var day = currentDate.getDate()
				 var year = currentDate.getFullYear()
				 var seperator = "/"
				 currentDate = new Date(month + seperator + day + seperator + year);
				 if(commissionDate > currentDate )
				 {
					 alert("Date of Com/Enrolmt should not be greater than current date.");
					 document.getElementById('commissionDateId').value="";
				 }else{
					action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+comDate;	
					obj = eval('document.fatalDocumentForm')
				    obj.action = action;
				   	var url=action
						
				var xmlHttp;
				try {
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
				    	for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					        var age  = item.getElementsByTagName("age")[0];
					        var period  = item.getElementsByTagName("period")[0];
					       obj=eval(document.getElementById('totalServ'))
					       if(age.childNodes[0].nodeValue == "0"){
					       obj.value=0;
					       }else{
						   obj.value=age.childNodes[0].nodeValue}
						    temp = eval("document.fatalDocumentForm.totalServicePeriod");
						   temp.value=period.childNodes[0].nodeValue
				    	} 
				    }
				  }
				  var url=action
				   
				  xmlHttp.open("GET",url,true);
				  xmlHttp.setRequestHeader("Content-Type", "text/xml");
				  xmlHttp.send(null);  
				 }
			  }else{
				  document.getElementById('totalServ').value = "0";
			  }
		  }
	function checkFormValue()
		 {
			 if(document.getElementById('checkStatus').value!="")
			 {
				 if(document.getElementById('checkStatus').value=="u")
				 {
					 alert("Fatal Document AllReady Created for this Service Person");
					 return false;
				 }
				 if(document.getElementById('checkStatus').value=="r")
				 {
					 alert("Fatal Document AllReady Created for this Service Person");
					 return false;
				 }	 
			 
			 }		
			 return true; 	 
		 } 

	function IsValidTimeWithoutBlank(timeStr,fieldId) {
		// Checks if time is in HH:MM:SS format.
		// The seconds are optional.
		if(timeStr != ''){
			var obj = document.getElementById(fieldId)
			
			var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
			
			var matchArray = timeStr.match(timePat);
			if (matchArray == null) {
				alert("Time should be in HH:MM format.");
				obj.value = "";
				obj.focus();
				return false;
			}
			hour = matchArray[1];
			minute = matchArray[2];
			second = matchArray[4];
			ampm = matchArray[6];
			
			if (second=="") { second = null; }
			if (ampm=="") { ampm = null }
			
			if (hour < 0  || hour > 23) {
				alert("Hour must be between 0 and 23.");
				obj.value = "";
				obj.focus();
				return false;
			}
			if (minute<0 || minute > 59) {
				alert ("Minute must be between 0 and 59.");
				obj.value = "";
				obj.focus();
				return false;
			}
			if (second != null && (second < 0 || second > 59)) {
				alert ("Second must be between 0 and 59.");
				obj.value = "";
				obj.focus();
				return false;
			}
			return false;
		}
	}

	
	</script>



<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box = HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	String serviceNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<MasRank> rankList = null;
			 		
			 	List<MasAdministrativeSex> sexList=null;
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 		
			 	}
			 	List<MasUnit> unitList=null;
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 		
			 	}
			 	String message="";
			 	if (map.get("message") != null) {
			 		message = (String) map.get("message");
			 		
			 	}
			 	List<MasTrade> tradeList=null;
			 	if (map.get("tradeList") != null) {
			 		tradeList = (List<MasTrade>) map.get("tradeList");
			 		
			 	}
			 	List<Patient> patientList=null;
				//int hin_id = 0;
				//System.out.println("patientList----FetalDocumentJsp-->>>"+map.get("patientList"));
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 		
			 	}
			 	//if(patientList.size() > 0)
			 	 //{
			 		//hin_id=patientList.get(0).getId();
			 	 //}
			 	//System.out.println("hin_id in jsp+++++++" +hin_id);
			 	List<FatalDocumentHeader> fatalDocumentHeaderList=null;
			 	if (map.get("fatalDocumentHeader") != null) 
			 	{
			 		fatalDocumentHeaderList = (List<FatalDocumentHeader>) map.get("fatalDocumentHeader");
			 	}
			 	if (map.get("sexList") != null) {
			 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
			 		
			 	}
			 	List<MasMedicalCategory> medicalCategoryList=null;
			 	if (map.get("medicalCategoryList") != null) {
			 		medicalCategoryList = (List<MasMedicalCategory>) map.get("medicalCategoryList");
			 		
			 	}
%>
<h4 class="auto"><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Fatal Document</h2>
</div>
<div class="Clear"></div>
<form name="fatalDocumentForm" method="post" action="">
<div class="Block">

<label>Service No.</label>
<input	type="text" id="serviceNo1" name="serviceNo1"	title="Fill Service No. first." value="" MAXLENGTH="30"	
onblur="if(validateMetaCharacters(this.value)){submitProtoAjaxWithDivName('fatalDocumentForm','/hms/hms/mis?method=getPatientDetails&serviceNo='+this.value,'deficientId')};" />
</div>

<div class="clear"></div>
<div id="deficientId">
<h4>Details</h4>
<div class="Block">
<label>Service No.<span>*</span></label>
 <input	type="text" name="serviceNo" id="serviceNo" tabindex="1"  value="" validate="Service No,string,yes" />
 <label>A&D No.</label>
 <input	type="text" name="adNo" id="adNo" tabindex="1"  value="" />
 
<label> Rank <span>*</span></label> 
<select	name="rank" id="rank" tabindex="1" >
<%for(MasRank masRankList:rankList){ %>
	<option value="<%=masRankList.getId() %>"><%=masRankList.getRankName()%></option>
	<%} %>
</select> 

<div class="Clear"></div>

<label>Name <span>*</span></label> 
<input type="text" name="sPerName" tabindex="1"  id="sPerName" value="" MAXLENGTH="30" validate="Ser Pers Name No,string,yes" />

<label>DOB </label> 
<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""	onblur="calculateAgeInAjaxFunction();" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="30" class="calDate" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.fatalDocumentForm.<%=DATE_OF_BIRTH%>,event)" />

<label> Age</label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,yes" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value=""/>

<div class="Clear"></div>

<label>Gender <span>*</span></label>
<select	name="sex" id="sex" tabindex="1" >
<option value="0">Select</option>
<%for(MasAdministrativeSex masSexList:sexList){ %>
	<option value="<%=masSexList.getId() %>"><%=masSexList.getAdministrativeSexName() %></option>
	<%} %>
</select> 

<label> Unit <span>*</span></label>

<select	name="unit" id="unit" tabindex="1" >
<%for(MasUnit masUnitList:unitList){ %>
	<option value="<%=masUnitList.getId() %>"><%=masUnitList.getUnitName()%></option>
	<%} %>
</select> 
<label>Branch/Trade </label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Branch/Trade,string,no" tabindex="1"  	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	</select>
	
<div class="Clear"></div>


</div>



<div class="Clear"></div>

<label>DOE/ DOC </label> 
<input type="text"	id="commissionDateId" name="commissionDate" tabindex="1" value=""	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="calDate" onblur="calculateTotalServiceFunction(this.value);" /> 
<img  src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentForm.commissionDate,event)" /> 
<input	type="hidden" id="idForComEnrlDate" value=""/> 

<%--<input	type="hidden" id="hin_id" name="hin_id" value="<%=hin_id %>"  />  --%> 



<label>Total Service <span>*</span></label> 
<input id="totalServYrs" type="hidden" name="" value=""	validate="Total Service,float,yes" maxlength="6" tabindex="1" />

<div id="totalService" style="display: block;">
<select	id="totalServ" name="<%=TOTAL_SERVICE%>"	validate="Total Service year,string,yes" tabindex="1" class="small"	onchange="checkAgeAndService();">
	<%
				for(int age1=0;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="totalServUnit" name="<%=TOTAL_SERVICE_PERIOD %>" tabindex="1" class="smallest" >
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select>
</div>



<label>Med. Category <span>*</span></label>
 
<select	name="medicalCategory" id="medicalCategory" tabindex="1"  validate="Med Cate,string,yes" >
<%for(MasMedicalCategory medicalCategory:medicalCategoryList){ %>
	<option value="<%=medicalCategory.getId() %>"><%=medicalCategory.getMedicalCategoryName() %></option>
	<%} %>
</select> 
<div class="Clear"></div>

<label>Prev. Med History </label> 
<input	type="text" id="preMedHistory" name="preMedHistory" value="" tabindex="1" validate="Prev Med History,string,no" />
<label>Diagnosis <span>*</span></label> 
<input	type="text" id="diagnosis" name="diagnosis" value="" tabindex="1" validate="Diagnosis,string,yes"/>
<input type="hidden" name="status" id="status" value="u" />
<input type="hidden" name="checkStatus" id="checkStatus" value="" />

<label>Name of SMC/Unit</label> 
<input	type="text" id="hospitalName" name="hospitalName" value="" tabindex="1" />
<div class="Clear"></div>
<label>Date of Admission</label> 
<input	type="text" id="dateOfAdmission" name="dateOfAdmission"
	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" tabindex="1"  /> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfAdmission,event)" />
<label>Time of Admission</label> 
<!-- <input type="text" id="timeOfAdmission" name="timeOfAdmission" tabindex="1"  onKeyUp="mask(this.value,this,'2,':',event);" value="" onchange="IsValidTime(this.value,this.id)"  /> --> 


<input type="text" name="timeOfAdmission" id="timeOfAdmission"  onKeyUp="mask(this.value,this,'2',':',event);" onblur="IsValidTimeWithoutBlank(this.value,'timeOfAdmission')"onKeyUp="mask(this.value,this,'2',':');"/>

<label>Type of Death <span>*</span></label> 
<input	type="text" id="typeOfDeath" name="typeOfDeath" value="" tabindex="1" validate="Type of Death,string,yes"/>
<div class="Clear"></div>
<label>Date of Death <span>*</span></label> 
<input tabindex="1" type="text" id="dateOfDeath" name="dateOfDeath"	value="<%=currentDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" validate="Date of Death,string,yes"/> <img  src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.fatalDocumentForm.dateOfDeath,event)" />
		
<label>Time of Death <span>*</span></label> 
<!-- <input type="text" tabindex="1"  id="timeOfDeath" name="timeOfDeath" onKeyUp="mask(this.value,this,'2,':',event);" value="" validate="Time of Death,String,yes" onchange="IsValidTime(this.value,this.id)" /> -->
<input type="text" name="timeOfDeath" id="timeOfDeath"  onKeyUp="mask(this.value,this,'2',':',event);" onblur="IsValidTimeWithoutBlank(this.value,'timeOfDeath');" maxlength="5"/> 
<input type="hidden" id="fatalStatus" name="fatalStatus" value="u"/> 


<label>Place of Death <span>*</span></label> 
<input	tabindex="1"  type="text" id="locationOfDeath" name="locationOfDeath" value="" validate="Location of Death,string,yes"/>
<div class="Clear"></div>
<label>Disease or Condition directly leading to Death </label> 
<textarea class="medium" tabindex="1" cols="44" name="diseaseDeath" id="diseaseDeath"	 rows="2" tabindex="1" validate="Disease leading to Death ,string,no"
	></textarea>
	
<label>MLC</label>
<input type="checkbox" name="mlc" value="y" class="radioAuto2" onclick="displayMlcNo(this);">
<div id="mlc" style="display: none;">
<label>MLC No.</label>
<input type="text" name="mlcNo" id="mlcNo" value="" maxlength="20"/>
</div>
<div class="Clear"></div>
<label>Due to or as a consequence of </label> 
<textarea class="medium" tabindex="1"  cols="44" name="consequenceOf" id="consequenceOf"	 rows="2" tabindex="1" validate="Due to consequence,string,no"
	></textarea>


<label>Other Significant Conditions If any</label> 
<textarea class="medium" cols="44" name="otherConditions" id="otherConditions" tabindex="1" 	 rows="2" tabindex="1" ></textarea>
</div>	
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%--<input	type="button" name="save" value="Submit" class="button" tabindex="1" 	onClick="submitForm('fatalDocumentForm','/hms/hms/mis?method=submitFatalDocument')" /> --%>
<input	type="button" name="save" value="Submit" class="button" tabindex="1" 	onClick="if(checkFormValue()){submitForm('fatalDocumentForm','/hms/hms/mis?method=submitFatalDocument')}" />
<input	type="button" name="reset" value="Reset" class="button"	onClick="submitForm('fatalDocumentForm','mis?method=showFatalDocumentJsp');" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	

<div class="Clear"></div>

</form>



<script>
function displayMlcNo(obj){
	if(obj.checked){
		document.getElementById('mlc').style.display = 'block';
	}else{
		document.getElementById('mlc').style.display = 'none';
	}
	
}

</script>


