
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.HrMasLeaveType"%>
<%@page import="jkt.hms.masters.business.HrMasLeave"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrMasLeaveTypeNew"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>

<!-- <script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script> -->
<!-- <script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script> -->
<!-- <script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script> -->

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">
var $j = jQuery.noConflict();
</script>


<%-- 
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script> --%>


<%
    Map<String,Object> map=(Map)request.getAttribute("map");
	
	List<HrMasLeave> leaveTypeList =new ArrayList<HrMasLeave>();
	List<HrMasLeaveTypeNew> masLeaveTypeList =new ArrayList<HrMasLeaveTypeNew>();
	List<HrMasLeaveTypeNew> leaveTypeForEdit =new ArrayList<HrMasLeaveTypeNew>();
	List<Object[]> minDateList =new ArrayList<Object[]>();
	
	HrMasLeaveTypeNew masLeaveType = new HrMasLeaveTypeNew();
	int leaveId = 0;
	
	String message = "";
	
	//System.out.println("in type master Jsp");

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("leaveTypeList")!= null){
		leaveTypeList = (List)map.get("leaveTypeList");
	}
	if(map.get("masLeaveTypeList")!= null){
		masLeaveTypeList = (List)map.get("masLeaveTypeList");
		//System.out.println("Leave Type Size :"+masLeaveTypeList.size());
		//System.out.println("Leave Type  :"+masLeaveTypeList.get(0).getLeaveType().getDescription());		
	}

//	if(map.get("minDateList")!= null){
//		minDateList = (List)map.get("minDateList");
//		System.out.println("Leave Type Size :"+minDateList.size());
//		Object[] hh= minDateList.get(0);
//		System.out.println("valid date  :"+hh[0]);
		//System.out.println("Leave Type  :"+masLeaveTypeList.get(0).getLeaveType().getDescription());		
//	}

	if(map.get("leaveTypeForEdit")!= null){
		leaveTypeForEdit = (List)map.get("leaveTypeForEdit");
		
		if(leaveTypeForEdit.size()>0){
			masLeaveType = leaveTypeForEdit.get(0);
			leaveId = masLeaveType.getId();
		}
	}

	if(map.get("message")!= null){
		message = (String)map.get("message");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	
%>


<script type="text/javascript">
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

function checkEncashmentDetails(){
	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked){
		if(document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value=="" && document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value=="")
		{
			alert("Either enter Encashable Percentage or Buffer Required ");
			return false;
		}
		else
		{
		 	return true;
		}
		
	//	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value==""){
	//		alert("Encashment Percentage can't be blank ");
	//		return false;
	//	}
	}
	return true;
}

function showLeaveBalance(idvalue){

		if(idvalue == 8 ){
			
			document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0';
			var a= document.getElementById('allowedDaysToHide');	
			a.setAttribute("validate","");
	    	document.getElementById('divLeaveWithoutPay').style.display ='none';
			
		}
		else{
	    	document.getElementById('divLeaveWithoutPay').style.display ='block';
	    	document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '';
			var a= document.getElementById('allowedDaysToHide');	
			a.setAttribute("validate","Allowed Days,num,yes");
	    	
		}
}

function selectEnchashablePerc(){

	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked){
		document.getElementById("divEnchashment").style.display ='block';
	}
	else{
		document.getElementById("divEnchashment").style.display ='none';
	}
	
}
var urlForSubmit = '';

function setUrl(){
	fromDate = document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>.value;
	
	//fromDate = new Date(sdate.substring(6),(sdate.substring(3,5) - 1) ,sdate.substring(0,2));
	currentDate = new Date();
	 if(fromDate<=currentDate){
	 	urlForSubmit = 'leave?method=updateTypeMaster&leaveTypeId=<%=masLeaveType.getId()%>';
	 	
	 	alert("fromdate eq current date :"+urlForSubmit);	 
	 }
	 else{
	 	alert("else");
	 }
}
</script>

<form name="<%=LEAVE_TYPE_FORM%>" method="post" action="">
	<div class="titleBg"><h2>Leave type Master </h2></div>
	<div class="clear"></div>
	<div class="Block">
	<%
		if(message!= null){
	%>
		<h4><%=message %></h4>
	<%} %>
	
	<div class="clear"></div>
	
   	
    	<label> Leave Type <span>*</span></label>
    	   	<select name="<%=TYPE%>" validate="Leave Type,nothing,yes" onkeyup="showLeaveBalance(this.value);" onchange="showLeaveBalance(this.value);">
    	<option value="">Select</option>
    	<%
			for(HrMasLeave hrMasLeave:leaveTypeList)
			{
				
		%>
		<option value="<%= hrMasLeave.getId() %>"><%=hrMasLeave.getDescription()%></option>
		
		<%} %>
    	</select>
    	
    	<script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=TYPE%>.value='<%=masLeaveType.getLeaveType().getId()%>';
          		  document.<%=LEAVE_TYPE_FORM%>.<%=TYPE%>.disabled='disabled';
 			<% } %> 
		</script>
		
    	<!-- opening div for leave without pay -->
 	<label>Half Day Not Allowed</label>
 	<%if(masLeaveType.getHalfDayAllow()!=null && masLeaveType.getHalfDayAllow().equals("y")) {%>
		<input type="checkbox" name="halfDayAllow" value="y" onclick="" class="radioCheck" checked="checked"/>
    	<%}else{ %>
 		<input type="checkbox" name="halfDayAllow" value="y" onclick="" class="radioCheck"/>
    	<%} %>
  	<div id="divLeaveWithoutPay" style="display:block">  	
   	
    	<%--<div>
    		<input type="radio" name="<%=MONTHLY_OR_YEARLY%>" value="yearly" class="radioCheck" /><label class="valueMedium">Yearly</label>
    		<input type="radio" name="<%=MONTHLY_OR_YEARLY%>"  class="radioCheck" /><label class="valueMedium">Monthly</label>
		</div>
		 --%>
		

	<label class="medium">Yearly</label> <input type="radio" name="<%=MONTHLY_OR_YEARLY%>" value="yearly" class="radioAuto" checked="checked" style="margin-right:25px;"/>
	<label class="medium">Monthly</label> <input type="radio" name="<%=MONTHLY_OR_YEARLY%>" value="monthly" class="radioAuto" style="margin-right:25px;"/>

		<%--
		
 		<script type="text/javascript">
 				 document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[0].checked= true;
		</script>--%>
		
	
 	
 		<script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0 && masLeaveType.getMonthlyOrYearly().equals("m")){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[1].checked= true;
 			<% }else { %>
 				  document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[0].checked= true;
 			<% }%> 
		</script>
		<div class="clear"></div>
		
    	<label> Allowed Days <span>*</span></label>
    	<input type="text"  id="allowedDaysToHide" name="<%=ALLOWED_DAYS%>" maxlength="3"   validate="Allowed Days,num,yes" value=""/>

		<script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value='<%=masLeaveType.getAllowedDays()%>';
 			<% } %> 
		</script>
   		<script type="text/javascript">
			<% if((leaveTypeForEdit.size()>0) && (masLeaveType.getLeaveType().getId()== 8) ){ %> 
					
					document.getElementById("divLeaveWithoutPay").style.display ='none'; 
					document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0'; 
					document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0';
					a= document.getElementById('allowedDaysToHide');	
					a.setAttribute("validate","");
      		  		
 			<% }else { %>
 				  document.getElementById("divLeaveWithoutPay").style.display ='block';
 			<% }%> 
		</script>
    	<div class="clear"></div>
    		
    	<label class="a">Encashable Leave</label>
		<input type="checkbox" name="<%=ENCHASHMENT_CHECK %>" value="y" onclick="selectEnchashablePerc();" class="radioCheck" />
    	
    	<div id="divEnchashment" style="display:none;">
			
			<input type="radio" name="leaveEncash" value="per" class="radioAuto" onclick="disableOther(this,'p');" checked="checked" style="margin-right:5px;"/>
			<label class="medium">Percentage<span>*</span></label>
			<input type="text" style="width:25px;" maxlength="3"  name="<%=ENCHASHMENT%>" onkeyup="return chkValue(this);"  value="" />
			<label class="auto" style="margin-right:145px;">%</label>
			<input type="radio" name="leaveEncash" value="buf" class="radioAuto" onclick="disableOther(this,'b');" style="margin-right:5px;"/>
			<label class="medium"> Buffer <span>*</span> </label>
			<input type="text" name="bufferRequired"  style="width:25px;" maxlength="3" disabled="disabled" />
		</div>
	 	
	 	<script type="text/javascript">
	 		<% if(leaveTypeForEdit.size()>0 && (masLeaveType.getEncashable().equals("y"))){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked=true;
          		  document.getElementById("divEnchashment").style.display ='block';
          		  <%if(masLeaveType.getEncashablePercent()!=null && masLeaveType.getEncashablePercent()!=0){%>
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value='<%=masLeaveType.getEncashablePercent()%>';
          		  document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=true;
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=false;
          		  document.<%=LEAVE_TYPE_FORM%>.leaveEncash[0].checked=true;
          		 <% }else if(masLeaveType.getBufferRequired()!=null && masLeaveType.getBufferRequired()!=0){%>
          		 document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value='<%=masLeaveType.getBufferRequired()%>';
          		 document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=true;
          		 document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=false;
          		 document.<%=LEAVE_TYPE_FORM%>.leaveEncash[1].checked=true;
          	<% }} %>
 			
		</script>
	<script type="text/javascript">
	function chkValue(field)
	{
	if(field.value>100)
	{
	alert("Can't more than 100%");
	field.value="";
	return false;
	}
	}
	function disableOther(field,opt)
	{
		if(opt=='p')
		{
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value="";
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=true;
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=false;
		}
		if(opt=='b')
		{
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=true;
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=false;
		}
	}
	function chkPercentage()
	{
		if(document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value=="" && document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value=="")
		{
			alert("Either enter Encashable Percentage or Buffer Required ");
			return false;
		}
		else
		{
		 	return true;
		}
		
	}
	</script>
	
    	
	  <div class="clear"></div>
	    
	    <label>Carry Forward</label>
		<input type="checkbox" name="<%=CARRY_FORWARD%>" value="y" class="radioCheck" />

  		<script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0 && (masLeaveType.getCrFrdable().equals("y"))){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=CARRY_FORWARD%>.checked=true;
  			<% } %>
		</script>
	
 
		<!-- closing div for leave without pay div -->
       </div>
 		
 		
        	 	
      	<div class="clear"></div>
    		      
        <label>Applied From Date <span>*</span></label>
        <input type="text" id="fromDate" name="fromDate"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="From Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" maxlength="10"  />
    	<%-- <input name="<%=FROM_DATE%>" type="text"  validate='From Date,date,yes' value="" class="calDate"  onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" maxlength="10" /> --%>
   		<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" id="calFromDate" onclick="javascript:setdate('',document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>,'event')"  /> --%>
    	<script type="text/javascript">
  		<% if(leaveTypeForEdit.size()>0){   %> 
        	document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>.value='<%=HMSUtil.changeDateToddMMyyyy(masLeaveType.getValidFromDate())%>';
          		  
 		<% } %>
		</script>
  		
 
     	<label>Remarks</label>
     	<% if(leaveTypeForEdit.size()>0 && masLeaveType.getRemarks()!=null){   %> 
<textarea id="remarks" name="<%=REMARKS%>" maxlength="200" onkeydown="refreshLengthWithoutMeter1(this.id,45)" onkeyup="refreshLengthWithoutMeter(this.id,45)" style="height:20px;">
<%=masLeaveType.getRemarks()%>
</textarea>
  		<% }else{ %>
<textarea id="remarks" name="<%=REMARKS%>" maxSize="200" onkeydown="refreshLengthWithoutMeter1(this.id,45)" onkeyup="refreshLengthWithoutMeter(this.id,45)" style="height:20px;">
</textarea> 		
  		<%} %>
   		
    
    <div class="clear"></div> 
	
	<% if(leaveTypeForEdit.size()>0){   %>
		<%if(masLeaveType.getStatus().equalsIgnoreCase("y")) {%>
			<input type="button" name="inactivate" value="InActivate" class="button" onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=activateInActivateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>');"/>
				<input type="button" name="apply" value="Update" class="button" onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=updateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>','checkEncashmentDetails');"/>
		
		<%}else{ %>
			<input type="button" name="activate" value="Activate" class="button" onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=activateInActivateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>');"/>
			
		<%} %>
		
	<%} else { %>	
		<input type="button" name="apply" value="Add" class="button" onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=submitTypeMaster','checkEncashmentDetails');"/>
		
	<%} %>
	
	<input type="button" name="reset" value="Reset" class="button" onclick="location.href='leave?method=showLeaveTypeMaster'"/>
    
    <div class="clear"></div>	

	</div>	

	<div class="division"></div>
   
   
 <h4>Leave Types</h4>
<% 
	if(masLeaveTypeList!=null && masLeaveTypeList.size() > 0)
	{
		
%>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="cmntable">
<table id="leaveTypeList" >
 	 		<tr>
 		    	<th>Leave Type</th>
				<th>Allowed Days</th>
				<th>Applied From Date</th>
				<th>Carry Forward</th>
				<th>Monthly/Yearly</th>
				<th>Status</th>
			</tr>		
		<tbody id = "tableData">
		<%	
			int i=1;
			for(HrMasLeaveTypeNew hrMasLeaveType:masLeaveTypeList)
			{
				if(i%2==0)
				{
		%>
		    <tr class="odd" onclick="submitFormForButton('leaveTypeForm','leave?method=showLeaveTypeMaster&leaveTypeId=<%=hrMasLeaveType.getId()%>')"> 
		<%
		  		}
		  		else
		  		{
		%>
		  		<tr class="even" onclick="submitFormForButton('leaveTypeForm','leave?method=showLeaveTypeMaster&leaveTypeId=<%=hrMasLeaveType.getId()%>')"> 		  		
		<%
		  		}
		%>
					<td><%=hrMasLeaveType.getLeaveType().getDescription() %></td>
					<%
						if(hrMasLeaveType.getLeaveType().getId() == 8){
						%>	
							<td>---------</td>
					<%	}else{	%>
							<td><%=hrMasLeaveType.getAllowedDays() %></td>						
					<% }%>


		    		<td ><%=LeaveManagementUtil.convertDateToStringWithoutTime(hrMasLeaveType.getValidFromDate())%></td>
					
					<%
					if(hrMasLeaveType.getLeaveType().getId()!=8){
						%>
					<%if(hrMasLeaveType.getCrFrdable().equals("y")) {%>
						<td>Carry Forward</td>
					<%}else { %>
						<td>Not Carry Forward</td>
					<%} 
					}else{%>
						<td>---------</td>						
					<%} %>			
					
					<%
					if(hrMasLeaveType.getLeaveType().getId()!=8){
						%>
					<%if(hrMasLeaveType.getMonthlyOrYearly().equals("y")) {%>
						<td>Yearly</td>
					<%}else{ %>
						<td>Monthly</td>
					<%} 
					}else{%>
						<td>---------</td>						
					<%} %>			

					<%if(hrMasLeaveType.getStatus().equals("y")){ %>
						<td>Active</td>
					<%}else { %>
						<td>InActive</td>
					<%} %>
				</tr>
		<%	
			i++;
		   }
		   }
			else
			{  %>
				<h4>No Leave Record for current period</h4>	
		<%	}	%>
		  </tbody>
		</table>
		</div>
		</div>
		<div class="clear"></div>
	
	
<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
	
	<div class="division"></div>
		<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=currentDate%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
		</div>	 
	
</form>