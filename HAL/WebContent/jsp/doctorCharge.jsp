<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * doctorCharge.jsp  
 * Purpose of the JSP -  This is for Doctor charge.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 03rd Oct,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="java.util.Map,java.util.HashMap,java.util.List,java.lang.String,java.util.Iterator,java.util.GregorianCalendar,java.util.Calendar,java.util.Date,java.util.ArrayList,com.hms.investigation.business.CostCenter,com.hms.investigation.util.IRequestConstants,com.hms.investigation.util.ICommonConstants"%>
<%@ page
	import="com.hms.registration.business.CodeTypeDetails, java.util.Set"%>
<div id="contentspace">

<h2>Doctor Charges</h2>

<form name="doctorCharge" method="post" action="">
<%
		    Map map = (Map)request.getAttribute("map");
		    String messageTOBeVisibleToTheUser = (String)map.get("messageTOBeVisibleToTheUser");
		     if(messageTOBeVisibleToTheUser!= null){%>

<h4><%= messageTOBeVisibleToTheUser%></h4>

<%}%> <label><font id="error">*</font> Doctor Name:</label> <select
	name="<%= RequestConstants.DOCTOR_ID %>"
	validate="Doctor Name,string,yes">
	<option value="">Select</option>
	<c:forEach items="${map.mapContainingDoctorAndCallList.doctorList}"
		var="employeeMaster">
		<c:if
			test="${not empty map.mapContainingDoctorAndCallList.doctorList}">
			<option value="${employeeMaster.id}" /><c:out
				value="${employeeMaster.firstName}" /></option>
		</c:if>
	</c:forEach>
</select> <label>Patient Type:</label> <select
	name="<%= RequestConstants.PATIENT_TYPE %>"
	validate="Patient Type,string,no">
	<option value="">Select</option>
	<c:forEach items="${map.mapContainingDoctorAndCallList.patientTypeSet}"
		var="codeTypeDetails" varStatus="counter">
		<c:if
			test="${not empty map.mapContainingDoctorAndCallList.patientTypeSet}">
			<option value="<c:out value="${codeTypeDetails.id}"/>"><c:out
				value="${codeTypeDetails.codeTypeDetailsDescription}" /></option>
		</c:if>
	</c:forEach>
</select> <br />
<br />

<label><font id="error">*</font> Time From:</label> <select
	name="<%= RequestConstants.TIME_FROM_HOUR %>"
	validate="Time From,string,yes" style="width: 60px;">
	<c:forEach var="i" begin="0" end="23">
		<c:if test="${i < 10 }">
			<option value="<c:out value="0${i}"/>"><c:out value="0${i}" /></option>
		</c:if>
		<c:if test="${i >= 10 }">
			<option value="<c:out value="${i}"/>"><c:out value="${i}" /></option>
		</c:if>
	</c:forEach>
</select> <select name="<%= RequestConstants.TIME_FROM_MINUTE %>"
	validate="Time From,string,no" style="width: 60px;">
	<c:forEach var="i" begin="0" end="59" step="15">
		<c:if test="${i < 10 }">
			<option value="<c:out value="0${i}"/>"><c:out value="0${i}" /></option>
		</c:if>
		<c:if test="${i >= 10 }">
			<option value="<c:out value="${i}"/>"><c:out value="${i}" /></option>
		</c:if>
	</c:forEach>
</select> <label><font id="error">*</font> Time To:</label> <select
	name="<%= RequestConstants.TIME_TO_HOUR %>"
	validate="Time To,string,yes" style="width: 60px;">
	<c:forEach var="i" begin="0" end="23">
		<c:if test="${i < 10 }">
			<option value="<c:out value="0${i}"/>"><c:out value="0${i}" /></option>
		</c:if>
		<c:if test="${i >= 10 }">
			<option value="<c:out value="${i}"/>"><c:out value="${i}" /></option>
		</c:if>
	</c:forEach>
</select> <select name="<%= RequestConstants.TIME_TO_MINUTE %>"
	validate="Time To,string,no" style="width: 60px;">
	<c:forEach var="i" begin="0" end="59" step="15">
		<c:if test="${i < 10 }">
			<option value="<c:out value="0${i}"/>"><c:out value="0${i}" /></option>
		</c:if>
		<c:if test="${i >= 10 }">
			<option value="<c:out value="${i}"/>"><c:out value="${i}" /></option>
		</c:if>
	</c:forEach>
</select> <br />
<br />

<h4>Doctor Call</h4>
<label><font id="error">*</font> Days:</label> <select
	name="<%= RequestConstants.DAY %>" validate="Days,string,yes" multiple>
	<c:forEach items="${map.mapContainingDoctorAndCallList.weekSet}"
		var="codeTypeDetails" varStatus="counter">
		<c:if test="${not empty map.mapContainingDoctorAndCallList.weekSet}">
			<option value="<c:out value="${codeTypeDetails.id}"/>"><c:out
				value="${codeTypeDetails.codeTypeDetailsDescription}" /></option>
		</c:if>
	</c:forEach>
</select><br />

<%
   		  	 Map mapContainingDoctorAndCallList = (Map)map.get("mapContainingDoctorAndCallList");
			 Set doctorCall = (Set)mapContainingDoctorAndCallList.get("doctorCall");
			 for(Iterator doctorCallIterator = doctorCall.iterator(); doctorCallIterator.hasNext();){
		 		 CodeTypeDetails codeTypeDetails = (CodeTypeDetails)doctorCallIterator.next(); 

				 if(codeTypeDetails.getCodeTypeDetailsDescription().equals("Emergency"))
				 {
			 %> <label> <%= codeTypeDetails.getCodeTypeDetailsDescription()%></label>
<input type="text"
	id='<%= codeTypeDetails.getCodeTypeDetailsDescription()%>'
	name='<%= codeTypeDetails.getCodeTypeDetailsDescription()%>' value=""
	validate="<%= codeTypeDetails.getCodeTypeDetailsDescription()%>,string,no" />
<input type="hidden" name='test'
	value="<%= codeTypeDetails.getCodeTypeDetailsDescription()%>" /> <% }
			 	else{
			 
			 %> <label><font id="error">*</font>&nbsp; <%= codeTypeDetails.getCodeTypeDetailsDescription()%></label>
<input type="text"
	id='<%= codeTypeDetails.getCodeTypeDetailsDescription()%>'
	name='<%= codeTypeDetails.getCodeTypeDetailsDescription()%>' value=""
	validate="<%= codeTypeDetails.getCodeTypeDetailsDescription()%>,string,yes" />
<input type="hidden" name='test'
	value="<%= codeTypeDetails.getCodeTypeDetailsDescription()%>" /> <%}%> <br />
<% } %> <label class="biglabel">&nbsp;</label> <input type="button"
	name="add" id="addbutton" value="Add" class="button"
	onClick="submitForm('doctorCharge','contentspace','addDoctorCharges.action','validateTime(\'doctorCharge\')','checkDoctorCharge()')"
	accesskey="a" /> <a
	href='/hms/hms/doctorCharge/showEditDoctorCharges.action'>clickHere</a>
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" onclick="clearRecords(this)" /></form>
</div>
<script>

	function checkDoctorCharge()
	{
		var first = document.getElementById(document.doctorCharge.test[0].value);
		var followUp = document.getElementById(document.doctorCharge.test[1].value);
		
		if(followUp.value > first.value)
		{
			alert("Follow Up charge cannot be greater than First charge.");
			return false;
		}
		else
			return true;
	}

		
</script>


