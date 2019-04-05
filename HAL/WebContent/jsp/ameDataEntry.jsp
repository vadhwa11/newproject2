

<%@ page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.SERVICE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.FULL_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_AME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESENT_MEDICAL_CATEGORY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Category"%>

<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>

<!-- Script for tab content -->
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
			
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTimeWithoutSc");
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>



<form name="ameDataEntry" method="post" action="">
<div class="titleBg"><h2>AME Data Entry</h2></div>
<div class="clear"></div>
<%	
			Box box  = HMSUtil.getBox(request);
			
		
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
		
			List<Object[]> categoryList= new ArrayList<Object[]>();
			if(map.get("categoryList") != null){
				categoryList=(List<Object[]>)map.get("categoryList");
			}
					

			
			%>  


<h4>Service Details</h4>

<div class="Block">

<label>Service No.<span>*</span></label>
<input	id="serviceNo" class="auto" size="8" type="text"	name="<%=SERVICE_NO %>"  value="" title="Enter Service No" tabindex="1" validate="Service No,metachar,yes" onblur="submitProtoAjaxWithDivName('ameDataEntry','/hms/hms/medicalExam?method=getServiceNo&serviceNo='+this.value,'dispalyDiv');"/>

<div class="clear"></div>

<div id="dispalyDiv">
<label> Rank <span>*</span></label> 
<input id="rank" type="text" value="" tabindex="1"	 validate="Rank,string,yes"	readonly="readonly"/>

<label>Name <span>*</span></label> 
<input id="sFNameId" name="<%=FULL_NAME %>" type="text"  validate="Name,string,yes" value="" tabindex="1"	 readonly="readonly"/> 

<label>Trade/Branch<span>*</span></label> 
<input id="trade" type="text"	 value="" tabindex="1"  validate="Trade,string,yes" readonly="readonly"/>

</div>
<div class="clear"></div>

<label>Place</label> 
<input id="place" name="place" type="text" tabindex="1"	maxlength="100"  validate="Place,string,no" />

<label>Date  </label> 
 <input type="text" name="<%=DATE_OF_AME %>" id="<%=DATE_OF_AME %>" value="" maxlength="10"  class="calDate" onkeyup="mask(this.value,this,'2,5','/');"	validate="Date,frdate,no"	onblur="validateExpDate(this,'<%=DATE_OF_AME %>'); "/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.ameDataEntry.<%=DATE_OF_AME %>,event)" />
	

<label>MED Category  </label> 
 <select 	name="<%=PRESENT_MEDICAL_CATEGORY %>" id="<%=PRESENT_MEDICAL_CATEGORY %>" validate="Present Med Cat,string,no" tabindex=1>
 <option value="0">Select</option>
 <%
 for (Object[] category : categoryList) {
		%>
	<option value="<%=category[0]%>" ><%=category[1]%> </option>
	<%	}
				
 %>
 </select>
 <div class="clear"></div>
 
 <label>Category Type (Duration)</label> 
 <input type="text" name="medCatPeriod" id="medCatPeriod" value="" maxlength="5" class="small" onblur="validateDuration(this.value,'medCatPeriod');"/>
 <select name="medCatDuration" id="medCatDuration" class="small">
 <option value="Months">Months</option>
 <option value="Weeks">Weeks</option>
 <option value="Days">Days</option></select>
 
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>


<input type="button" onclick="submitForm('ameDataEntry','/hms/hms/medicalExam?method=addAmeDataEntry','submitdata');" value="Submit" class="buttonBig" name="Submit11" tabindex="1"> 
<input tabindex="1" class="buttonBig" id=reset onclick=resetCheck(); accessKey=r	type=reset value=Reset name=Reset>


<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> 
<label>Changed Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" /> 
<INPUT type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>

</form>
<script>
function submitdata()
{
	var serviceNo=document.getElementById("serviceNo").value;
	
 if(serviceNo=="")
 {
    alert("Please Service No.");
    return false;
 }
 return true;
}

</script>
