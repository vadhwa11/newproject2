<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasServiceType"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasComplaint"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.Users"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>

<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.FeedbackOfCounselor"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<form name="FeedbackOfCounselor" method="post" action="">


 <%


 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<MasEmployee> doctorList = null;
     int counselingId = 0;
	 String nameOfCounsellor="";
	 String qualification = "";
	 String noOfVisit ="";
	 String placeOfCounselling = "";
	 String typeOfCases = "";
	 String remarks = "";
	 String relation = "";
	 String ServicePersonName ="";
	 String gender ="";
	 String age= "";
	 String address ="";
	 String contact ="";
	 String dateOfOnset = "";
	 Date dateOfAdmission = null;
	 String Species = "";
	 String type = "";
	 String transmission ="";
     List<FeedbackOfCounselor> patientList = new ArrayList<FeedbackOfCounselor>();  

     System.out.println("patientList====>>>"+map.get("patientList"));
    if (map.get("patientList") != null)
    {
  	   patientList = (List<FeedbackOfCounselor>) map.get("patientList");
  	  
	 }
	for(FeedbackOfCounselor feedbackOfCounselor : patientList)
	   {
		if(feedbackOfCounselor.getId()!=null){
			counselingId=feedbackOfCounselor.getId();
		}
		
		if(feedbackOfCounselor.getNameOfCounselor()!= null)
		{
			nameOfCounsellor = feedbackOfCounselor.getNameOfCounselor();
		}
		if(feedbackOfCounselor.getQualification()!= null)
		{
			qualification = feedbackOfCounselor.getQualification();
		}
		if(feedbackOfCounselor.getNoOfVisitPerWeek()!= null)
		{
			noOfVisit = feedbackOfCounselor.getNoOfVisitPerWeek();
		}
		if(feedbackOfCounselor.getPlaceOfCounseling()!= null)
		{
			placeOfCounselling = feedbackOfCounselor.getPlaceOfCounseling(); 
		}
		if(feedbackOfCounselor.getTypeCasesCounseled()!= null)
		{
			typeOfCases = feedbackOfCounselor.getTypeCasesCounseled();
		}
		if(feedbackOfCounselor.getEmployedDate()!=null){
		dateOfOnset=HMSUtil.changeDateToddMMyyyy(feedbackOfCounselor.getEmployedDate());
		}
		if(feedbackOfCounselor.getREMARKS()!= null)
		{
			remarks = feedbackOfCounselor.getREMARKS();
		}
	
    
 	
 %>

<div class="titleBg">
<h2>Feedback on Performance of Counselor (SMO)</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Name Of Counselor</label>
<input type="text" name="name"  value="<%=nameOfCounsellor%>" MAXLENGTH="30" />

<label >Qualification</label>
 <input	type="text" name="qualification" value="<%=qualification %>" class="textbox_date"
	MAXLENGTH="30" />
<label>No. of Visits (per month)</label>
<input type="text" name="noofVisit"   id="noofVisit" value="<%=noOfVisit %>" />
<div class="clear"></div>
<label>Place Of Counseling</label>
<input type="text" name="place" id="nameId"   value="<%=placeOfCounselling %>" />
<label>Type Of Cases </label>
<input type="text" name="cases" id="cases" value="<%=typeOfCases %>" />
<label>Remarks</label>
<textarea name="remarks" id="remarks" rows="" cols="" value="<%=remarks %>"></textarea>
<div class="clear"></div>
<label>Date</label>
<input type="text" name="date" id="relation" value="<%=dateOfOnset%>" />
<label>Remarks By SMO</label>
<textarea name="rem1" id="rem1" rows="" cols=""></textarea>
</div>
<div class="clear paddingTop10"></div>
<div class="division"></div>
<input type="hidden" name="counselingId" value="<%=counselingId%>" />
<%} %>
<div class="clear paddingTop10"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('FeedbackOfCounselor','/hms/hms/mis?method=validateSmoCounseling');"
	value="Validate" class="button" accesskey="a" />
<!--<input type="button" name="submit" onclick="submitForm('malariaCase','/hms/hms/mis?method=submitSmoMalariaCase');" class="button" value="Forward"  />

--><script>

function openSmoMalariaCase(){
	//alert("Smo Malaria Case");
	var url="/hms/hms/sHO?method=showSmoMalariaCase";
   	newwindow=window.open(url,'smoMalariaCase','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
}

function submitProtoAjaxWithDivName(formName,action,divName){
	//alert("submitProtoAjaxWithDiv In Malaria Case");
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	//alert('::formName::-'+formName+'\n::action::-'+action+'\n::divName::-'+divName);
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	if(divName == "defaultList"){
        	document.getElementById('defaultList').style.display = 'inline';
        	}
        	new Ajax.Updater(divName,url,
			   {asynchronous:true, evalScripts:true }); 
			
		
	       	return true;
    }


function submitProtoAjaxForHin(formName,action){
	
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	new Ajax.Updater('hinDiv11',url,
			   {asynchronous:true, evalScripts:true }); 
			return true;
    	}

</script>

</form>

