<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : detentionAdviceList.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 23 Sep 2011    Name: Mukesh Narayan Singh
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PatientDetentionRegister"%>
<%@page import="jkt.hms.util.Box"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
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
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
		List<PatientDetentionRegister> patientDetentionRegisterList=new ArrayList<PatientDetentionRegister>();
		if(map.get("patientDetentionRegisterList")!=null){
			patientDetentionRegisterList=(List<PatientDetentionRegister>)map.get("patientDetentionRegisterList");
		}
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		Box box= HMSUtil.getBox(request);
		String flag="";
		flag=box.getString("flag");
		String message  = "";
		if(map.get("message")!=null){
			message = (String)map.get("message");
		}
	%>
<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Detention Details</h2></div>
<div class="clear"></div>
<form name="detentionAdviceList" action="" method="post">
<input type="hidden" name="visitId" id="visitId" value="<%=box.getInt("visitId") %>" />
<input type="hidden" name="hinId" id="hinId" value="<%=box.getInt("hinId")%>" />
<input type="hidden" name="doctorId" id="doctorId" value="<%=box.getInt("doctorId")%>" />

<% if(patientDetentionRegisterList.size()>0){
			for(PatientDetentionRegister patientDetentionRegister:patientDetentionRegisterList){
				String treatment="";
				String fromTime="";
				String toTime="";
				String reviewAt = "";
				if(patientDetentionRegister.getTreatment()!=null){
					treatment=patientDetentionRegister.getTreatment();
				}
				fromTime=patientDetentionRegister.getFromTime();
				toTime=patientDetentionRegister.getToTime();
				if(patientDetentionRegister.getReviewAt() != null){
					reviewAt = patientDetentionRegister.getReviewAt();
				}
				String detentionFromDate="";
				String detentionToDate="";
				if(patientDetentionRegister.getDetainedFrom()!=null){
					detentionFromDate=HMSUtil.convertDateToStringWithoutTime(patientDetentionRegister.getDetainedFrom());
				}
				if(patientDetentionRegister.getDetainedTo()!=null){
					detentionToDate=HMSUtil.convertDateToStringWithoutTime(patientDetentionRegister.getDetainedTo());
				}
				%>
				<div class="Block">
<div class="Clear"></div>
<label>Additional Advice</label> 
<textarea rows="" cols="" name="treatment" validate="Treatment,string,no" ><%=treatment%></textarea>

<div class="Clear"></div>
<label> From Date<span>*</span></label> 
<input	type="text" name="detentionFromDate" id="detentionFromDate" validate="Detained From,string,yes" value="<%=detentionFromDate %>" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.detentionAdviceList.detentionFromDate,event)" /> 
<label>Time<span>*</span></label> 
 <input	type="text" name="fromTime" id="fromTime" validate="From Time,string,yes" value="<%=fromTime %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
<div class="Clear"></div>
<label>To Date<span>*</span></label> 
<input	type="text" name="detentionToDate" id="detentionToDate" validate="To,string,yes" value="<%=detentionToDate %>" MAXLENGTH="8" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.detentionAdviceList.detentionToDate,event)" /> 
<label> Time<span>*</span></label> 
<input	type="text" name="toTime" id="toTime" validate="To Time,string,yes" value="<%=toTime%>" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />
<label> Review at<span>*</span></label> 
<input	type="text" name="reviewAt" id="reviewAtId" validate="Review at,string,no" value="<%=reviewAt%>" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"  	 />
<input type="hidden" name="detentionId" value=""/>
<div class="Clear"></div>
</div>
				<%
			}
		}else{
		%>
		<div class="Block">
<div class="Clear"></div>
<label> Additional Advice</label> 
<textarea rows="" cols="" name="treatment" validate="Treatment,string,no" ></textarea>

<div class="Clear"></div>
<label>From Date<span>*</span></label> 
<input	type="text" name="detentionFromDate" id="detentionFromDate" validate="Detained From,string,yes" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="50"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.detentionAdviceList.detentionFromDate,event)" /> 
<label> Time<span>*</span></label> 
 <input	type="text" name="fromTime" id="fromTime" validate="From Time,string,yes" value="<%=time %>" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 MAXLENGTH="5"  />
<div class="Clear"></div>
<label> To Date<span>*</span></label> 
<input	type="text" name="detentionToDate" id="detentionToDate" validate="To,string,yes" value="<%=currentDate %>" MAXLENGTH="8" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.detentionAdviceList.detentionToDate,event)" /> 
<label> Time<span>*</span></label> 
<input	type="text" name="toTime" id="toTime" validate="To Time,string,yes" value="<%=time%>" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 />
<label> Review at</label> 
<input	type="text" name="reviewAt" id="reviewAtId" validate="Review at,string,no" value="" MAXLENGTH="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"  	 />
<input type="hidden" name="detentionId" value=""/>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<%

if(flag.equalsIgnoreCase("opd") || flag.equalsIgnoreCase("fwc")){
%>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitPopupForm();"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
		<%
}
}
if(!flag.equalsIgnoreCase("opd") || !flag.equalsIgnoreCase("fwc") ){
	%>
	<input type="button" name="Close" id="Close"
	onclick="window.close();"
	value="Close" class="button" accesskey="a" />
	<%
}
		%>


<div class="division"></div>
 
 <div class="bottom">
<%--
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
  --%>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=LAST_CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=LAST_CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>

</form>
<script type="text/javascript">
function submitPopupForm(){
	submitForm('detentionAdviceList','/hms/hms/opd?method=saveDetentionDetails');
	//window.close();
}
</script>
