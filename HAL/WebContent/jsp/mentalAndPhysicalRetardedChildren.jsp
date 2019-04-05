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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<script type="text/javascript">
	function checkAfmsfReceipt(){

	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="First Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("presentUnit").value==0){
			errMsg=errMsg+"Select posted from Unit \n"
		}
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("medicalCategory").value == 0){
		   errMsg=errMsg+"Select medicalCategory \n"
		}
		/*
		if(document.getElementById("Authority").value == ""){
		   errMsg=errMsg+"Authority of posting In should not be Blank \n"
		}
		
		if(document.getElementById("suffix").value == ""){
		  errMsg=errMsg+"Select suffix \n"
		}
		*/
		
		if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank\n"
		}
		/*
		if(document.getElementById("receiptLatterNo").value == "")
		{
		document.getElementById("docStatus").value = 'd';  
		}else{
		 document.getElementById("docStatus").value = 'e';
		}
		
		
		if(document.getElementById("afmsType").value == "OUT"){
		   errMsg=errMsg+"service person cleared this place you can't update the data \n"
		}
		*/
		if(errMsg == ""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
 function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }
 	</script> <script type="text/javascript" language="javascript">
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
			 	String userName = "";
				String remarks="";
				String jspFlag="";
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
					 	
			 	List<MasRank> rankList=null;
				List<MasUnit> unitList=null;
			 		
			 	
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 	}
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 	}
			 	if (map.get("serviceNo") != null) {
			 		serviceNo = (String) map.get("serviceNo");
			 	}
                String screenName="Mental And Physical Retarded Children";
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> 
					<div class="Clear"></div>	
					<label class="noWidth"> <span> <%=message %> </span> </label>
					<div class="Clear"></div>	
					 <% } %>
<!--
jspFlag--- lmc : Low Med Cat Psychiatric Patient Counseling Entry
jspFlag -- cam : Cases of Alcoholism Monitoring Entry
-->
<div class="titleBg">
<h2><%=screenName%></h2>
</div>
<div class="Block">
<div class="Clear"></div>				
<div class="Clear"></div>
<form name="mentalPhysicalRetarded" method="post">

<div class="Clear"></div>

<div id="Block">
<div class="clear"></div>
<div id="srNoDiv">
<label>Service No</label>
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" title="Fill Service No. first." value="" MAXLENGTH="30" onblur="getPatientDetails(this.value);" />
<label>Name</label>
<input type="text"	name="name" id="name" value="" MAXLENGTH="30"	validate="Name,String,Yes" tabindex="5"/>  

<label>Relation</label>
<input type="text" name="relation" id="relation" validate="Relation,String,Yes" value="" MAXLENGTH="30" tabindex="2" /> 
<div class="Clear"></div>

<label>Rank</label>
<input type="text"	name="rank" id="rankId" tabindex="4" />
<label>Age</label>
<input type="text"	name="age" id="age" value="" tabindex="7" maxlength="3"/>
<label>Branch/Trade</label>
 <input type="text" name="branch" id="branch"	value="" MAXLENGTH="30" tabindex="6" />

<div class="Clear"></div>

<label>Unit</label>
<input type="text"	name="unit" id="presentUnit" tabindex="6">
</div>
<label>Hospital Name</label>
<input id="diagnosis" type="text" name="hospitalName"	value="" validate="Hospital Name,string,no" maxlength="30" tabindex="9" />

<label>Diagnosis</label>
<input id="diagnosis" type="text" name="diagnosis"	value="" validate="Diagnosis,string,no" maxlength="30" tabindex="9" />
<div class="Clear"></div>
<label>Mental/Physical Retarted</label>
<input id="diagnosis" type="text" name="mentalRetarted"	value="" validate="Mental/Physical Retarted,string,no" maxlength="30" tabindex="9" />

<label>Children Name</label>
<input type="text"	name="childrenName" id="name" value="" MAXLENGTH="30"	validate="Children Name,String,Yes" tabindex="1"/> 
<label>Children Age </label>
<input type="text" name="ChildrenAge" id="Childrenage" value="" MAXLENGTH="30" tabindex="1" />

<div class="clear"></div>
<label>Remarks</label>
<input	tabindex="1" type="text" name="remarks" class="auto" size="120"	maxlength="50" value="" />
</div>

<div class="Clear"></div>

<div class="Clear"></div>
<input type="hidden" name="<%=ENTRY_FLAG%>" value="<%=jspFlag%>" readonly="readonly" MAXLENGTH="8" /> 
<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly" MAXLENGTH="8" />
	<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly"/> 
	<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly"/> 
	
	<!-- 
	jspFlag--- lmc : Low Med Cat Psychiatric Patient Counseling Entry
	jspFlag -- cam : Cases of Alcoholism Monitoring Entry
	 -->
</form>
</div>

<div class="division"></div>	 
	 
		<input type="button" name="edit" value="Submit" class="button" 
	onClick="submitForm('mentalPhysicalRetarded','/hms/hms/mis?method=submitmentalPhysicalRetarded');"  />
	<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showCaseOfAlcoholismMonitoringEntry');" value="Reset" class="button"/>
	
<div class="Clear"></div>

<div id="edited"></div>


<script type="text/javascript">
function getPatientDetails(val)
{   
	submitProtoAjaxforPatientDetails('mentalPhysicalRetarded','/hms/hms/mis?method=getServiceNoDetailsForMentalPhysical&serviceNo='+val);
}
function submitProtoAjaxforPatientDetails(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('srNoDiv',url,
			   {asynchronous:false, evalScripts:true }); 
	       	return true;
    	}

</script>

