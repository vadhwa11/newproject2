<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * foodTasting.jsp  
 * Purpose of the JSP -  This is for Food Tasting.
 * @author  Vikas
 * @author  Deepali
 * Create Date 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.NursingfoodTest"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<%	
	
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
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
		Set empSet = new HashSet();
		if(map.get("empSet")!= null)
		{
		  empSet=(Set)map.get("empSet");
		}
		Iterator itr=empSet.iterator();
		List<NursingfoodTest> nursingFoodTestList=new ArrayList<NursingfoodTest>();
		List<MasEmployee> empList=new ArrayList<MasEmployee>();
		if(map.get("foodDetailList")!= null)
		{
			nursingFoodTestList=(List)map.get("foodDetailList");
		}
		if(map.get("empList")!= null)
		{
			empList=(List)map.get("empList");
		}
	%>
<div id="contentHolder">
<h6>Food Tasting</h6>
<div class="Clear"></div>
<h4><%=deptName%></h4>
<div class="Clear"></div>
<form name="foodTasting" method="post">

<div class="blockTitle">Tasting Observation</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHholderCmn">
<table>
	<tr>
		<th>Meals</th>
		<th>Status</th>
		<th>Time</th>
		<th>Checked By</th>
		<th>Remarks</th>
	</tr>

	<%
			       if(nursingFoodTestList.size()>0)
			       {
			    	   
			    	   Iterator iterator=nursingFoodTestList.iterator();
			    	   String bool="false";
			    	   while(iterator.hasNext())
			    	   {
			    		  
			    		   NursingfoodTest nursingfoodTest=(NursingfoodTest)iterator.next();
			    		   if(nursingfoodTest.getFoodname().equals("BreakFast"))
			    		   {
			    			   bool="true";
			    			   
			    	%>
	<tr>
		<th class="rowcolor">BreakFast</th>
		<td class="rowcolor"><select name="breakFastStatus"
			id="breakFastStatus" validate="breakFastStatus,string,no">
			<option value="">Select</option>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Good")){
					%>
			<option value="Good" selected="selected">Good</option>
			<%}else{ %>
			<option value="Good">Good</option>
			<%} %>
			<%
					if(nursingfoodTest.getFoodstatus().equals("Average")){
					%>
			<option value="Average" selected="selected">Average</option>
			<%}else{ %>
			<option value="Average">Average</option>
			<%} %>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Poor")){
					%>
			<option value="Poor" selected="selected">Poor</option>
			<%}else{ %>
			<option value="Poor">Poor</option>
			<%} %>
		</select></td>
		<td class="rowcolor"><input type="text" name="breakFastTime"
			value="<%=nursingfoodTest.getFoodtime() %>" class="medcaption"
			validate="breakFastTime,string,yes">
		<td class="rowcolor"><select name="breakFastCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr1=empList.iterator();
			    while(itr1.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr1.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName=empName+" "+emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName=empName+" "+emp.getLastName();
			    	}
			    	String nameFromDB=nursingfoodTest.getTestedby();
			    	//System.out.println("nameFromDB " + nameFromDB+"===empName in jsp=="+empName );
					if (empName.equalsIgnoreCase(nameFromDB)) { %>
			<option value=<%=emp.getId()%> selected><%=empName%></option>
			<% } else {  %>
			<option value=<%=emp.getId()%>><%=empName%></option>
			<% } %>

			<%
				
			  }	
			%>
		</select></td>
		</td>
		<td class="rowcolor"><input type="text" name="breakFastRemarks"
			value="<%=nursingfoodTest.getRemarks() %>" class="bigcaption"
			validate="breakFastRemarks,string,no" maxlength="250"> <input
			type="hidden" name="breakFastDetails" value="done" /></td>
	</tr>
	<%}
			    	   }
			    	   if(bool.equals("false"))
			    	   {
			    %>
	<tr>
		<th class="rowcolor">BreakFast</th>
		<td class="rowcolor"><select name="breakFastStatus"
			id="breakFastStatus" validate="breakFastStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="breakFastTime"
			value="<%=timeInHHmm %>" MAXLENGTH="5" class="medcaption"
			validate="breakFastTime,string,yes"></td>

		<td class="rowcolor"><select name="breakFastCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName=empName+" "+emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName=empName+" "+emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="breakFastRemarks"
			class="bigcaption" validate="breakFastRemarks,string,no"
			maxlength="250"> <input type="hidden"
			name="breakFastDetails" value="unDone" /></td>
	</tr>
	<%	   
			    	   }
			       }
			      else{
					%>
	<tr>
		<th class="rowcolor">BreakFast</th>
		<td class="rowcolor"><select name="breakFastStatus"
			id="breakFastStatus" validate="breakFastStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="breakFastTime"
			value="<%=timeInHHmm %>" MAXLENGTH="5" class="medcaption"
			validate="breakFastTime,string,yes"></td>

		<td class="rowcolor"><select name="breakFastCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName=empName+" "+emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName=empName+" "+emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="breakFastRemarks"
			class="bigcaption" validate="breakFastRemarks,string,no"
			maxlength="250"> <input type="hidden"
			name="breakFastDetails" value="unDone" /></td>
	</tr>
	<%} %>


	<%
			       if(nursingFoodTestList.size()>0)
			       {
			    	   
			    	   Iterator iterator=nursingFoodTestList.iterator();
			    	   String bool="false";
			    	   while(iterator.hasNext())
			    	   {
			    		  
			    		   NursingfoodTest nursingfoodTest=(NursingfoodTest)iterator.next();
			    		   if(nursingfoodTest.getFoodname().equals("Lunch"))
			    		   {
			    			   bool="true";
			    			   
			    	%>
	<tr>
		<th class="rowcolor">Lunch</th>
		<td class="rowcolor"><select name="lunchStatus" id="lunchStatus"
			validate="lunchStatus,string,no">
			<option value="">Select</option>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Good")){
					%>
			<option value="Good" selected="selected">Good</option>
			<%}else{ %>
			<option value="Good">Good</option>
			<%} %>
			<%
					if(nursingfoodTest.getFoodstatus().equals("Average")){
					%>
			<option value="Average" selected="selected">Average</option>
			<%}else{ %>
			<option value="Average">Average</option>
			<%} %>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Poor")){
					%>
			<option value="Poor" selected="selected">Poor</option>
			<%}else{ %>
			<option value="Poor">Poor</option>
			<%} %>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchTime"
			value="<%=nursingfoodTest.getFoodtime() %>" class="medcaption"
			validate="lunchTime,string,yes"></td>

		<td class="rowcolor"><select name="lunchCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr1=empList.iterator();
			    while(itr1.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr1.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName=empName+" "+emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName=empName+" "+emp.getLastName();
			    	}
			    	String nameFromDB=nursingfoodTest.getTestedby();
			    	
					if (empName.equalsIgnoreCase(nameFromDB)) { %>
			<option value=<%=emp.getId()%> selected><%=empName%></option>
			<% } else {  %>
			<option value=<%=emp.getId()%>><%=empName%></option>
			<% } %>

			<%
				
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchRemarks"
			value="<%=nursingfoodTest.getRemarks() %>" class="bigcaption"
			validate="lunchRemarks,string,no" maxlength="250"> <input
			type="hidden" name="lunchDetails" value="done" /></td>
	</tr>
	<%}
			    	   }
			    	   if(bool.equals("false"))
			    	   {
			    %>
	<tr>
		<th class="rowcolor">Lunch</th>
		<td class="rowcolor"><select name="lunchStatus" id="lunchStatus"
			validate="lunchStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchTime"
			value="<%=timeInHHmm %>" MAXLENGTH="5" class="medcaption"
			validate="lunchTime,string,yes"></td>

		<td class="rowcolor"><select name="lunchCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName+=emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName+=emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchRemarks"
			class="bigcaption" validate="lunchRemarks,string,no" maxlength="250">
		<input type="hidden" name="lunchDetails" value="unDone" /></td>
	</tr>
	<%	   
			    	   }
			       }
			      else{
					%>
	<tr>
		<th class="rowcolor">Lunch</th>
		<td class="rowcolor"><select name="lunchStatus" id="lunchStatus"
			validate="lunchStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchTime"
			value="<%=timeInHHmm %>" MAXLENGTH="5" class="medcaption"
			validate="lunchTime,string,yes"></td>

		<td class="rowcolor"><select name="lunchCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName+=emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName+=emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="lunchRemarks"
			class="bigcaption" validate="lunchRemarks,string,no" maxlength="250">
		<input type="hidden" name="lunchDetails" value="unDone" /></td>
	</tr>
	<%} %>



	<%
			       if(nursingFoodTestList.size()>0)
			       {
			    	   
			    	   Iterator iterator=nursingFoodTestList.iterator();
			    	   String bool="false";
			    	   while(iterator.hasNext())
			    	   {
			    		   
			    		   NursingfoodTest nursingfoodTest=(NursingfoodTest)iterator.next();
			    		   if(nursingfoodTest.getFoodname().equals("Dinner"))
			    		   {
			    			   bool="true";
			    			
			    	%>
	<tr>
		<th class="rowcolor">Dinner</th>
		<td class="rowcolor"><select name="dinnerStatus"
			id="dinnerStatus" validate="dinnerStatus,string,no">
			<option value="">Select</option>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Good")){
					%>
			<option value="Good" selected="selected">Good</option>
			<%}else{ %>
			<option value="Good">Good</option>
			<%} %>
			<%
					if(nursingfoodTest.getFoodstatus().equals("Average")){
					%>
			<option value="Average" selected="selected">Average</option>
			<%}else{ %>
			<option value="Average">Average</option>
			<%} %>
			<%
						if(nursingfoodTest.getFoodstatus().equals("Poor")){
					%>
			<option value="Poor" selected="selected">Poor</option>
			<%}else{ %>
			<option value="Poor">Poor</option>
			<%} %>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerTime"
			value="<%=nursingfoodTest.getFoodtime() %>" class="medcaption"
			validate="dinnerTime,string,yes"></td>

		<td class="rowcolor"><select name="dinnerCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr1=empList.iterator();
			    while(itr1.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr1.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName+=emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName+=emp.getLastName();
			    	}
			    	String nameFromDB=nursingfoodTest.getTestedby();
			    	System.out.println("nameFromDB " + nameFromDB );
					if (empName.equalsIgnoreCase(nameFromDB)) { %>
			<option value=<%=emp.getId()%> selected><%=empName%></option>
			<% } else {  %>
			<option value=<%=emp.getId()%>><%=empName%></option>
			<% } %>

			<%
				
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerRemarks"
			value="<%=nursingfoodTest.getRemarks() %>" class="bigcaption"
			validate="dinnerRemarks,string,no" maxlength="250"> <input
			type="hidden" name="dinnerDetails" value="done" /></td>
	</tr>
	<%}
			    	   }
			    	   if(bool.equals("false"))
			    	   {
			    %>
	<tr>
		<th class="rowcolor">Dinner</th>
		<td class="rowcolor"><select name="dinnerStatus"
			id="dinnerStatus" validate="dinnerStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerTime"
			value="<%=timeInHHmm %>" MAXLENGTH="5" class="medcaption"
			validate="dinnerTime,string,yes"></td>

		<td class="rowcolor"><select name="dinnerCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName+=emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName+=emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerRemarks"
			class="bigcaption" validate="dinnerRemarks,string,no" maxlength="250">
		<input type="hidden" name="dinnerDetails" value="unDone" /></td>
	</tr>
	<%	   
			    	   }
			       }
			      else{
					%>
	<tr>
		<th class="rowcolor">Dinner</th>
		<td class="rowcolor"><select name="dinnerStatus"
			id="dinnerStatus" validate="dinnerStatus,string,no">
			<option value="">Select</option>
			<option value="Good">Good</option>
			<option value="Average">Average</option>
			<option value="Poor">Poor</option>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerTime"
			value="<%=timeInHHmm %>" class="medcaption"
			validate="dinnerTime,string,yes" MAXLENGTH="5"></td>

		<td class="rowcolor"><select name="dinnerCheckedBy">
			<option value="0">Select</option>
			<%
				
				Iterator itr2=empList.iterator();
			    while(itr2.hasNext()){
			    	MasEmployee emp= (MasEmployee)itr2.next();
			    	String empName="";
			    	if(emp.getFirstName()!= null)
			    	{
			    		empName=emp.getFirstName();
			    	}if(emp.getMiddleName() != null)
			    	{
			    		empName+=emp.getMiddleName();
			    	}
			    	if(emp.getLastName() != null)
			    	{
			    		empName+=emp.getLastName();
			    	}
			%>
			<option value=<%=empName%>><%=empName%></option>
			<%
			  }	
			%>
		</select></td>
		<td class="rowcolor"><input type="text" name="dinnerRemarks"
			class="bigcaption" validate="dinnerRemarks,string,no" maxlength="250">
		<input type="hidden" name="dinnerDetails" value="unDone" /></td>
	</tr>

	<%} %>
</table>



</div>

<div class="Clear"></div>

<input type="button" class="button" value="Submit" align="left"
	onClick="if( checkTimeForBreakFast()){checkFoodData('foodTasting');}" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('foodTasting','ipd?method=showPatientListJsp');" />
<input type="hidden" name="deptName" value="<%=deptName %>" /></form>
<div class="Clear"></div>
</div>
<script type="text/javascript">
<!--

//-->
function checkTimeForBreakFast(){

	var breakStatus=document.foodTasting.breakFastStatus.value
	var checkBy=document.foodTasting.breakFastCheckedBy.value
	//alert("value of breakfast status-----"+breakStatus+"--and the value of chckby--"+checkBy)
	if(breakStatus != "" && checkBy ==0)
	{
		alert("Please Select the Name Of Person Tasting the BreakFast")
		return false;
	}
	objTime = document.foodTasting.breakFastTime;
  	var chtime=objTime.value;
 	if(checkTimeFormat(chtime))
 	{
 		if(checkTimeForLunch())
	    {
		     if(checkTimeForDinner())	  
		     return true;
		     else
		        return false;
	    }else
	    return false;
 	}else
 	   return false;	

}

function checkTimeForLunch(){

	var lunchStatus=document.foodTasting.lunchStatus.value
	var checkBy=document.foodTasting.lunchCheckedBy.value
	if(lunchStatus != "" && checkBy ==0)
	{
		alert("Please Select the Name Of Person Tasting the Lunch")
		return false;
	}
	objTime = document.foodTasting.lunchTime;
  	var chtime=objTime.value;
 	if(checkTimeFormat(chtime))
 	  return true;
 	  else
 	   return false;
	

}

function checkTimeForDinner(){

	var lunchStatus=document.foodTasting.dinnerStatus.value
	var checkBy=document.foodTasting.dinnerCheckedBy.value
	if(lunchStatus != "" && checkBy ==0)
	{
		alert("Please Select the Name Of Person Tasting the Dinner")
		return false;
	}
	objTime = document.foodTasting.dinnerTime;
  	var chtime=objTime.value;
 	if(checkTimeFormat(chtime))
 	  return true;
 	  else
 	    return false;
}


function checkTimeFormat(chtime){
	
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces)");
					return false						
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
				}	
	try{
		 var indx = chtime.indexOf(':');
		 
		 if (indx != -1) {
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
			 			
			  
	}catch(e2)
	{
		return false;
	}
	
return true;
}

function validateInteger( strValue ) {
  var objRegExp  =/^((\+|-)\d)?\d*(\:\d{2})?$/;
 	return objRegExp.test(strValue);
}
</script>

