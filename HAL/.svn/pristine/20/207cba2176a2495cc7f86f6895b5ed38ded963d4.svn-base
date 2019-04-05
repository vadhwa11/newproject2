<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCareEntry.jsp  
 * Purpose of the JSP -  This is for Nursing Care Entry.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<%

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] temp = null;
	temp = time.split(":");
	for (int i = 0 ; i < temp.length-1 ; i++) {
		
		timeInHHmm=timeInHHmm+(String)temp[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
    	 
	}
	List nursingCareList = new ArrayList();
	try {
		if(map.get("nursingCareList") != null)
		{
		    nursingCareList=(List)map.get("nursingCareList");
		    session.setAttribute("nursingCareList",nursingCareList);
		}
		else{
			nursingCareList=(List) session.getAttribute("nursingCareList");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	
	int nursingId=0;
	int nursingCareSetupId=0;
	if(map.get("nursingId") != null)
	{
		
		nursingId=(Integer)map.get("nursingId");
		nursingCareSetupId=(Integer)map.get("nursingCareSetupId");
	}
	

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>



<div class="titleBg"><h2>Nursing Entry</h2></div>
<div class="clear"></div>
<!--<h4><%=deptName%></h4>
--><div class="Clear"></div>
<form name="nursingCareEntry" action="">
<div class="Block">
<label>Select Care</label>
<select	name="cares" onchange="submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailJsp')">
<option value="0">Select</option>
	<%
			
				Iterator itr=nursingCareList.iterator();
			    while(itr.hasNext()){
			    	MasNursingCare masNursingCare= (MasNursingCare) itr.next();
			    	int masNursingId=masNursingCare.getId();
			    	if(nursingId==masNursingId){
					
			%>
	<option value=<%=masNursingCare.getId()%> selected><%=masNursingCare.getNursingName()%></option>

	<% } else {  %>
	<option value=<%=masNursingCare.getId()%>><%=masNursingCare.getNursingName()%></option>
	<% } %>

	<%	
			  }	
			%>
</select>
<label>Date</label>
<label id="time" class="value"> <%=date%></label>


<label class="auto">Time of Care</label><label class="small">(hh:mm)</label>
<input type="text"	id="caretime" name="caretime" class="calDate" value="<%=timeInHHmm %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	MAXLENGTH="5" />
 <!-- <div id="time" style="
		float: left; font-size: 13px; background-image:url(/hms/jsp/images/tablehead.gif);
		height: 25px; font-weight: bold;  text-align:center; color: #000000; 
		width:80px; font-size: 13px; ">
	    <input type="text" name="caretime" value="<%=timeInHHmm %>"   MAXLENGTH="5"/>
        </div>
         --> <!-- <input type="hidden" name="caretime" value="<%=timeInHHmm %>"  onblur="if(checkTimeFormat()){submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailJsp');}" MAXLENGTH="5"/> -->
<input type="hidden" name="deptName" id="deptName"	value="<%=deptName %>" />
<div class="Clear"></div>
</div>
</form>
<div class="Clear"></div>
<div id="testDiv"></div>
<script>
		<% if (nursingId !=0 ) { %>
				//alert("calling ajax div grid");
				submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailForPatientJsp&nursingId=<%=nursingCareSetupId%>');			
		<% } %>
		</script>
<div class="Clear"></div>


<script type="text/javascript">

function checkTimeFormat(){
	
	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					return false						
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
					
	
		 //var indx = chtime.indexOf(':');
		 
		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }
				 
		 if (pairs2.length!=2) { 
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}
		 
		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}
		 
		 		 val2=eval(pairs2[0]);
		 			
						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}
					 		 
					 		 val3=eval(pairs2[1]);
		 		
							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}
			 			
		return true;	  
	}
	}

	

	function validate(ref)
	{
	 if (this.focus)
	 {
	  this.focus();
	 }
	 alert('test');
	 return false;
	}
function validateInteger( strValue ) {
  var objRegExp  =/^((\+|-)\d)?\d*(\:\d{2})?$/;
 	return objRegExp.test(strValue);
}

/*
 method for validating remarks field in nursingEntry Detail screen.
 not developed yet
*/
function validateRemarksForNursing(){
			
		//alert("haloooo")
		var counter=document.getElementById("counter").value;
		for(var i = 0; i < counter; i++)
		{
		 
		var careRemarks=document.getElementById('careremarks'+i).value
		var careRemarksFromDB=document.getElementById('careRemarksFromDB'+i).value
		if(!(careRemarksFromDB == "empty"))
		{
			if(!(careRemarks == careRemarksFromDB))
			{
					var bool="false"
					for(var j=0;j<document.getElementsByName('care'+i).length;j++)
					{
					  
						var care=document.getElementsByName('care'+i)[j].checked
						if(care == true)
						{
						 bool="true"
						}
						else
						{
						  bool="false"
						}
						if(bool== "false")
						{
							alert("Please select the Frequency For remarks to be submitted. ")
							return false;
						}
						
					}	
		    }
  		 }
	   }
	   return false;
		}

function validateCheckbox(){
	var count = document.getElementById('counter').value;
	var flag = "";
	for(var i=0;i<count;i++){
		if(document.getElementById('once'+i)){
			if(document.getElementById('once'+i).disabled== false && document.getElementById('once'+i).checked){
				flag = "checked";
			}
		}
		if(document.getElementById('twice'+i)){
			if(document.getElementById('twice'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('thrice'+i)){
			if(document.getElementById('thrice'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('4 times'+i)){
			if(document.getElementById('4 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('5 times'+i)){
			if(document.getElementById('5 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('6 times'+i)){
			if(document.getElementById('6 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('7 times'+i)){
			if(document.getElementById('7 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('8 times'+i)){
			if(document.getElementById('8 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('9 times'+i)){
			if(document.getElementById('9 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('10 times'+i)){
			if(document.getElementById('10 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('11 times'+i)){
			if(document.getElementById('11 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(document.getElementById('12 times'+i)){
			if(document.getElementById('12 times'+i).checked){
				flag = "checked";
				
			}
		}
		if(flag=='checked'){
			break;
		}
	}

	if(flag==''){
		alert("Please select atleast one checkbox");
		return false;
	}
	return true;
}
</script>


