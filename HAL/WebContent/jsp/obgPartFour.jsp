<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>

<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function checkDate(){

	var vDate = new Date() ;
	
		var vDate =  new Date();
	var mth;
	var dt;
	var da = vDate.getDate();
	var m = vDate.getMonth()+1;
	if(vDate.getDate() < 10)
	{
		dt = "0"+da;
	}
	else
	{
		dt = da;
	}
	if(vDate.getMonth()+1 < 10)
	{
		mth = "0"+m
	}
	else
	{
		mth = m
	}
	var finalToday=dt+"/"+mth+"/"+vDate.getFullYear();
	
	
	
	var dobDate1 = document.getElementById('startDateId').value ;
	if(dobDate1 != ""){
		if(dobDate1<finalToday)
		{
			alert("Please ensure that the Today Date is greater than or equal to the Start Date.");
			document.getElementById('startDateId').value = "";
			return false;
		}
			return false;
	}

}
</script>

<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
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
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			
	List<MasOccupation> masOccupationList= new ArrayList<MasOccupation>();
	if(map.get("masOccupationList") != null){
		masOccupationList=(List)map.get("masOccupationList");
	}
	List<MasReligion> masReligionList= new ArrayList<MasReligion>();
	if(map.get("masReligionList") != null){
		masReligionList=(List)map.get("masReligionList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

	 
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}
		
		List opdObgList= new ArrayList();
		if(map.get("opdObgList") != null){
			opdObgList=(List)map.get("opdObgList");
		}	
%>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="OBG" action="" method="post">
<h6>Infertility Clinic</h6>
<div class="Clear"></div>
<!--Block One Starts--> <%
if (opdObgList.size() > 0)
	{
	Iterator itr = opdObgList.iterator();
	while (itr.hasNext()) 
	{
		OpdObg opdObg = (OpdObg) itr.next();
 %>

<div class="blockTitleFixed">HORMONAL TESTS: <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>T3 </label><label></label> <input name="<%=T_THREE_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=T_THREE_HUSBAND %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>T4 </label><label></label> <input name="<%=T_FOUR_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=T_FOUR_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>TSH </label><label></label> <input name="<%=TSH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=TSH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>S Prolactin </label><label></label> <input
	name="<%=S_PROLACTIN_WIFE %>" maxlength="20" type="text"> <label></label>
<input name="<%=S_PROLACTIN_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>FSH </label><label></label> <input name="<%=FSH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=FSH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>LH </label><label></label> <input name="<%=LH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=LH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>S Testosterone </label><label></label> <input
	name="<%=S_TESTOSTERONE_WIFE %>" maxlength="20" type="text"> <label></label>
<input name="<%=S_TESTOSTERONE_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>DHES </label><label></label> <input name="<%=DHES_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=DHES_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

</div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitleFixed">ULTRASONOGRAPHY <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth"><U>Test of Tubal Patency</U> </label>
<div class="Clear"></div>
<h5>Hysterosalpingography</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input
	name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>Tubes </label><label>R</label> <input name="<%=TUBES_RIGHT %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=TUBES_LEFT %>" maxlength="20" type="text">

<div class="Clear"></div>
<h5>Hysteroscopy</h5>
<div class="Clear"></div>
<label>Endometrical Cavity </label> <label></label> <input
	name="<%=ENDOMETRICAL %>" maxlength="20" type="text"> <label>Cornual
Openings </label> <input name="<%=CORNUAL_OPENING %>" maxlength="20" type="text">


<div class="Clear"></div>
<h5>Endoscopy</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input name="<%=UTERUS %>"
	maxlength="20" type="text"> <label>Pelvis </label> <input
	name="<%=PELVIS_ENDOSCOPY_UTERUS %>" maxlength="20" type="text">
<div class="Clear"></div>
<label>Tubes </label> <label>R</label> <input
	name="<%=TUBES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
<label>L</label> <input name="<%=TUBES_LEFT_ENDOSCOPY %>" maxlength="20"
	type="text">

<div class="Clear"></div>
<label>Ovaries </label> <label>R</label> <input
	name="<%=OVERIES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
<label>L</label> <input name="<%=OVERIES_LEFT_ENDOSCOPY %>"
	maxlength="20" type="text">
<div class="Clear"></div>
<label>Pelvis </label> <label></label> <input
	name="<%=PELVIS_ENDOSCOPY %>" maxlength="20" type="text">
<div class="Clear"></div>
<h5>Endometrical Biposy</h5>
<div class="Clear"></div>

<label>Date</label> <label></label> <%if(opdObg.getObgDate()==null)
{%> <input type="text" onblur="checkDate();" class="calDate"
	id="startDateId" name="<%=DATE_OBG %>" value="" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.OBG.<%=DATE_OBG%>,event)"
	onblur="checkDate();" /> <%}else{%> <input type="text"
	onblur="checkDate();"
	value="<%=HMSUtil.changeDateToddMMyyyy(opdObg.getObgDate()) %>"
	class="calDate" id="startDateId" name="<%=DATE_OBG %>" value=""
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.OBG.<%=DATE_OBG%>,event)"
	onblur="checkDate();" /> <%} %> <label>Days of Cycle</label> <input
	name="<%=DAYS_OF_CYCLE %>" validate="Days of Cycle,num,no"
	maxlength="9" type="text">


<div class="Clear"></div>

<label>Proliferative</label> <label></label> <input
	name="<%=PROLIFERATIVE %>" maxlength="20" type="text"> <label>Secretory</label>
<input name="<%=SECRETORY %>" maxlength="20" type="text" />

<div class="Clear"></div>

<label>Dating</label> <label></label> <input name="<%=DATING %>"
	maxlength="20" type="text" /></div>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Three Ends--> <%}}else{ %>
<div class="Clear"></div>
<!--Block One Starts-->
<div class="blockTitleFixed">HORMONAL TESTS: <a
	href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide1">
<div class="blockFrame">
<div class="Clear"></div>
<div class="header"><label>&nbsp;</label>
<div class="paddLeft55"><label class="paddLeft25">Wife</label></div>
<label></label>
<div class="paddLeft25"><label>Husband</label></div>
</div>

<div class="Clear"></div>
<label>T3 </label><label></label> <input name="<%=T_THREE_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=T_THREE_HUSBAND %>" maxlength="20" type="text">

<div class="Clear"></div>

<label>T4 </label><label></label> <input name="<%=T_FOUR_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=T_FOUR_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>TSH </label><label></label> <input name="<%=TSH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=TSH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>S Prolactin </label><label></label> <input
	name="<%=S_PROLACTIN_WIFE %>" maxlength="20" type="text"> <label></label>
<input name="<%=S_PROLACTIN_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>FSH </label><label></label> <input name="<%=FSH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=FSH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>LH </label><label></label> <input name="<%=LH_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=LH_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>S Testosterone </label><label></label> <input
	name="<%=S_TESTOSTERONE_WIFE %>" maxlength="20" type="text"> <label></label>
<input name="<%=S_TESTOSTERONE_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

<label>DHES </label><label></label> <input name="<%=DHES_WIFE %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=DHES_HUSBAND %>" maxlength="20" type="text">
<div class="Clear"></div>

</div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Two Starts-->
<div class="blockTitleFixed">ULTRASONOGRAPHY <a
	href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<label class="noWidth"><U>Test of Tubal Patency</U> </label>
<div class="Clear"></div>
<h5>Hysterosalpingography</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input
	name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>" maxlength="20" type="text">

<div class="Clear"></div>
<label>Tubes </label><label>R</label> <input name="<%=TUBES_RIGHT %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=TUBES_LEFT %>" maxlength="20" type="text">

<div class="Clear"></div>
<h5>Hysteroscopy</h5>
<div class="Clear"></div>
<label>Endometrical Cavity </label> <label></label> <input
	name="<%=ENDOMETRICAL %>" maxlength="20" type="text"> <label>Cornual
Openings </label> <input name="<%=CORNUAL_OPENING %>" maxlength="20" type="text">


<div class="Clear"></div>
<h5>Endoscopy</h5>
<div class="Clear"></div>
<label>Uterus </label> <label></label> <input name="<%=UTERUS %>"
	maxlength="20" type="text"> <label>Pelvis </label> <input
	name="<%=PELVIS_ENDOSCOPY_UTERUS %>" maxlength="20" type="text">
<div class="Clear"></div>
<label>Tubes </label> <label>R</label> <input
	name="<%=TUBES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
<label>L</label> <input name="<%=TUBES_LEFT_ENDOSCOPY %>" maxlength="20"
	type="text">

<div class="Clear"></div>
<label>Ovaries </label> <label>R</label> <input
	name="<%=OVERIES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
<label>L</label> <input name="<%=OVERIES_LEFT_ENDOSCOPY %>"
	maxlength="20" type="text">
<div class="Clear"></div>
<label>Pelvis </label> <label></label> <input
	name="<%=PELVIS_ENDOSCOPY %>" maxlength="20" type="text">
<div class="Clear"></div>
<h5>Endometrical Biposy</h5>
<div class="Clear"></div>

<label>Date</label> <label></label> <input type="text" id="startDateId"
	name="<%=DATE_OBG%>" value="" class="calDate" readonly="readonly"
	validate="DOB,date,no" tabindex="1" onblur="checkDate();" /> <a
	href="javascript:setdate('',document.OBG.<%=DATE_OBG%>)"> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" class="calender"
	onblur="checkDate();" /></a> <label>Days of Cycle</label> <input
	name="<%=DAYS_OF_CYCLE %>" maxlength="9" type="text"
	validate="Days of Cycle,num,no">


<div class="Clear"></div>

<label>Proliferative</label> <label></label> <input
	name="<%=PROLIFERATIVE %>" maxlength="20" type="text"> <label>Secretory</label>
<input name="<%=SECRETORY %>" maxlength="20" type="text" />

<div class="Clear"></div>

<label>Dating</label> <label></label> <input name="<%=DATING %>"
	maxlength="20" type="text" /></div>
</div>
<!--Block Two Ends--> <%} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="<%=HOSPITAL_ID %>"
	value="<%=visit.getHin().getHospital().getId() %>"> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>">
<div class="division"></div>

<div class="bottom"><input name="Button" type="button"
	class="buttonActive" value="Page 4" /> <input type="button"
	class="button" value="Submit"
	onclick="submitForm('OBG','fwc?method=addOBGJsp&visitId=<%=visit.getId()%>','checkDate()');" />
</div>


<!--Bottom labels starts--></form>
</div>
<!--main content placeholder ends here-->

