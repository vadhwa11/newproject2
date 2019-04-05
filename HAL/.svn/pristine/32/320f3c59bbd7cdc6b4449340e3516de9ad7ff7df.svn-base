<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
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
	</script>


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}


%>



<form name="fwcVisitEntryDirect" method="post">
<div class="titleBg">
</div>
<div class="clear"></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<div id="testDiv">
<div class="Block"><label>Service No. <span>*</span></label> <input
	type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""
	validate="Service No.,metachar,yes"
	onblur="submitProtoAjaxWithDivName('fwcVisitEntryDirect','/hms/hms/fwc?method=getPatientDetailsFordirectVisitEntry','hinDiv');" />
<label>HIN <span>*</span></label>
<div id="hinDiv">
<input type="text" name="<%=HIN_ID %>" id="hinId"	value="" />
</div>
</div>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<script	type="text/javascript">var employeeArray=new Array();</script>

<div class="clear"></div>
<div class="paddingTop15"></div>
<!--  <div id="testDiv">-->


<div class="Clear"></div>
<table width="90%" colspan="7" cellpadding="0" cellspacing="0"	id="tableGrid">
	<thead>
		<tr>
		
			<th>Name of Contraceptive</th>
			<th>Quantity</th>
			<th>Location</th>
			<th>Issue to</th>
			
			
		</tr>
	</thead>


	<tr>
		

		<td><input type="text" name="nameOfContrac" tabindex="1"	validate="Name of Contraceptive,metachar,yes" id="nameOfContrac" value=""  maxlength="20" /></td>
			
		<td><input type="text" name="quantity" tabindex="1" id="quantity" value=""  maxlength="2" validate="Quantity,int,yes"/></td>
			
		<td><input type="text" name="location" tabindex="1" id="location" value="" maxlength="50" validate="Location,metachar,yes"/></td>
		
		<td><select name="employee" id="employee" tabindex="1" validate="Issue To,metachar,yes">
			<option value="0">Select</option>
			<%
			  String fname="";
	    	  String mname="";
	    	  String lname="";
	    	  String name ="";
		      for(MasEmployee masEmployee : employeeList){
		    
		    	  if(masEmployee.getMiddleName()!="" && masEmployee.getMiddleName()!=null)
		    	  {
		    		  mname= masEmployee.getMiddleName();
		    	  }else
		    	  {
		    		  mname="";
		    	  }
		    	 if(masEmployee.getLastName()!="" && masEmployee.getLastName()!=null)
		    	  {
		    		  lname= masEmployee.getLastName();
		    	 }
		    	 else
		    	  {
		    		  lname="";
		    	  }
		    	  if(masEmployee.getFirstName()!="" && masEmployee.getFirstName()!=null)
		    	  {
		    		  fname= masEmployee.getFirstName();
		    	  }
		    	  else
		    	  {
		    		  fname="";
		    	  }
		    
		    	  name =fname+" "+mname+" "+lname;
		    	
          %>
			<option value="<%=masEmployee.getId() %>"><%=name%></option>
			<%} %>
		</select> <%
		MasEmployee  masEmployee = new MasEmployee();

			     for (int j = 0; j < employeeList.size(); j++) {
			    	 masEmployee = (MasEmployee) employeeList.get(j);
     			 %> <script>

     			employeeArray[<%=j%>]= new Array();
     			employeeArray[<%=j%>][0] = "<%=masEmployee.getId()%>";
     			employeeArray[<%=j%>][1] = "<%=masEmployee.getFirstName()%>";
            </script> <% }%>
		</td>
		
		
	</tr>



</table>

<div class="clear"></div>
<div class="division"></div>



<label>Remarks</label> 
<textarea tabindex="1" name="<%=REMARKS %>" onkeyup="chkLength(this,50);"></textarea>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>



<div id="edited"></div>
<input type="button" name="submitForDisable" id="submitForDisable" value="Submit" class="button" onClick="if(validateFwcFields()){submitForm('fwcVisitEntryDirect','/hms/hms/fwc?method=saveRegisterForIUD')};" />
	
<input type="reset" name="Reset" value="Reset" class="button"	accesskey="r" /> 

<input type="button" class="button" value="Back" align="right" onClick="history.back();" />
	

<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>" value="<%=time%>" />
<input type="text" name="deptId" id="deptId" value="<%=deptId %>"/>
</div>

<div id="statusMessage" class="messagelabel">
<div class="clear"></div>
</div>
</form>
<script>

function validateFwcFields(){
	var count = document.getElementById('nameOfContrac').value;	 var msg = "";
	 if(count!=""){
		 return true;
	 }else
	 {
		 msg = "Please select the Name in row ";
	}
	if(msg!=''){
			alert(msg);
			return false;
		}
	return true;	

}

</script>
