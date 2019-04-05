<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<div id="contentHolder"><script>
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
</script> <%
String errorMsg = "";
errorMsg = "BloodBagNo. ";
int donationhdId = 0;
	int pageNo=1;
	int hinId=0;
	int bloodDonationId=0;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
 	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("occupationList") != null){
	occupationList= (ArrayList) map.get("occupationList");
	}
	if(map.get("donationhdId") != null){
		donationhdId=(Integer)map.get("donationhdId");
	}

	if(map.get("donorList") != null){
		donorList =(List)map.get("donorList");
	}
	BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
	if(donorList != null && donorList.size()>0){
		System.out.println("in service");
		donationEntryHeader = donorList.get(0);	
	}
	
	if(donationEntryHeader.getHin()!=null){
		hinId = donationEntryHeader.getHin().getId();			
	}
	if(map.get("bloodDonationId") != null){
		bloodDonationId =(Integer)map.get("bloodDonationId");
	}
	System.out.println("bloodDonationId--in jsp-----"+bloodDonationId);
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
		}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
		
%>!--Block Two Starts-->
<div class="Clear"></div>
<div class="division"></div>
<div class="blockTitle">Questionnaire 1</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div id="slide1">
<div class="blockFrame">
<div class="Height10"></div>
<div class="Clear"></div>
<label class="noHeight">Do you Feel Well Today ?</label> <select
	name="<%=WELL_TODAY %>" class="small2">
	<%if(donationEntryHeader.getWellToday().equalsIgnoreCase("y")) %>
	<option value="y">yes</option>
	<option value="n">No</option>
</select> <label class="noHeight">Did you have something to eat in the
last 4 hours ?</label> <select name="<%=SOMTHING_EAT %>" class="small2">
	<option value="y">yes</option>
	<option value="n">No</option>
</select> <label class="noHeight">Did you sleep well last night ?</label> <select
	name="<%=SLEEP_LAST%>" class="small2">
	<option value="y">yes</option>
	<option value="n">No</option>
</select>

<div class="Clear"></div>
<div class="paddLeft55"><label class="valueNoWidth">Have
you any reason to believe that you may be infected by either Hepatitis,
(HBsAg &amp; HCV), Malaria, HIV/ AIDS and/ or venereal<br />
disease ?</label></div>
<select name="<%=INFECTED_DISEASE%>" class="small2">
	<option value="n">No</option>
	<option value="y">Yes</option>
</select>
<div class="Clear"></div>
<div class="Height10"></div>
</div>
</div>
<!--Block Two Ends-->
<div class="division"></div>
<!--Block Three Starts-->
<div class="blockTitle">Questionnaire 2</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide2">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">In the last
6 months have you had any history of the following :</label>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="noHeight">Unexpected Weight Loss</label> <%if(donationEntryHeader.getWeightLoss().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=WEIGHT_LOSS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=WEIGHT_LOSS %>" value="" /> <%} %> <label class="noHeight">Repeated
Diarrhoeas</label> <%if(donationEntryHeader.getDiasrrhoes().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=DIARROCES %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=DIARROCES %>" value="" /> <%} %> <label class="noHeight">Swollen
Glands</label> <%if(donationEntryHeader.getSwollwn().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=SWOLLEN %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SWOLLEN %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">Continuous Low Grade Fever</label> <%if(donationEntryHeader.getLowGradeFever().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LOW_GRADE_FEVER %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=LOW_GRADE_FEVER %>" value="" /> <%} %> <label
	class="noHeight">N/A</label> <%if(donationEntryHeader.getNA1().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A1 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A1 %>" value="" /> <%} %>

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">In the last
6 months have you had any :</label></div>
<div class="Clear"></div>
<label class="noHeight">Tattooing</label> <%if(donationEntryHeader.getTattoing().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TATTOOING %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TATTOOING %>" value="" /> <%} %> <label class="noHeight">Ear
Piercing</label> <%if(donationEntryHeader.getEarPiercing().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=EAR_PIERCING %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=EAR_PIERCING %>" value="" /> <%} %> <label class="noHeight">Dental
Extraction</label> <%if(donationEntryHeader.getDentalExtraction().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=DENTAL_EXTRACTION %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">N/A</label> <%if(donationEntryHeader.getNA2().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A2 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A2%>" value="" /> <%} %>

<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Do you
suffer from or have suffered from any of the following ?</label></div>
<div class="Clear"></div>
<label class="noHeight">Heart Disease</label> <%if(donationEntryHeader.getHeartDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HEART_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=HEART_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Lung Disease</label> <%if(donationEntryHeader.getLungDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LUNG_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=LUNG_DISEASE %>" value="" /> <%} %> <label class="noHeight">Kidney
Disease</label> <%if(donationEntryHeader.getKidneyDisease().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=KIDNEY_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=KIDNEY_DISEASE %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Cancer/ Malignant Disease</label> <%if(donationEntryHeader.getCancer().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=CANCER_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=CANCER_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Epilepsy</label> <%if(donationEntryHeader.getEpilepsy().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=EPILEPSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=EPILEPSY %>" value="" /> <%} %> <label class="noHeight">CDiabetes</label>
<%if(donationEntryHeader.getCdiabetes().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=CDIABETES %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=CDIABETES %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Tuberculosis</label> <%if(donationEntryHeader.getTuberculosis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TUBERCULOSIS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TUBERCULOSIS %>" value="" /> <%} %> <label class="noHeight">Abnormal
Bleeding</label> <%if(donationEntryHeader.getAbnormalBleeding().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ABNORMAL_BLEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ABNORMAL_BLEEDING %>" value="" /> <%} %> <label
	class="noHeight">Hepatitis B/C</label> <%if(donationEntryHeader.getHepatitis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HEPATITIS_BC %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=HEPATITIS_BC %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Allergic Disease</label> <%if(donationEntryHeader.getAllergicDisease().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ALLERGIC_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ALLERGIC_DISEASE %>" value="" /> <%} %> <label
	class="noHeight">Dental Extraction</label> <%if(donationEntryHeader.getDentalExtraction1().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=DENTAL_EXTRACTION1 %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=DENTAL_EXTRACTION1 %>" value="" /> <%} %> <label
	class="noHeight">Sexually Transmitted Disease</label> <%if(donationEntryHeader.getSexuallyDisease().equals("y") ){ %>
<input type="checkbox" class="radio2"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" checked="checked" />
<%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Jaundice (Last 1 Yr)</label> <%if(donationEntryHeader.getJaundiceLastYear().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=JAUNDICE_LAST %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=JAUNDICE_LAST %>" value="" /> <%} %> <label
	class="noHeight">Typhoid (Last 1 Yr)</label> <%if(donationEntryHeader.getTyphoidLastOne().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=TYPHOID_LAST %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=TYPHOID_LAST %>" value="" /> <%} %> <label class="noHeight">Malaria
(6 Months)</label> <%if(donationEntryHeader.getMalariaSixMonth().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=MALARIA_LAST %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=MALARIA_LAST %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Fainting Spells</label> <%if(donationEntryHeader.getFaintingSpells().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=FAINTING_SPELL %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=FAINTING_SPELL %>" value="" /> <%} %> <label
	class="noHeight">Leprosy</label> <%if(donationEntryHeader.getLeprosy().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=LEPROSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=LEPROSY %>" value="" /> <%} %> <label class="noHeight">Schizophernia</label>
<%if(donationEntryHeader.getSchizophernia().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=SCHIZOPHERNIA %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=SCHIZOPHERNIA %>" value="" /> <%} %>
<div class="Clear"></div>

<label class="noHeight">Endocrine Disorders</label> <%if(donationEntryHeader.getEndocrineDisorders().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ENDOCRING_DISORDERS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio2" name="<%=ENDOCRING_DISORDERS %>" value="" /> <%} %> <label
	class="noHeight">N/A</label> <%if(donationEntryHeader.getNA3().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=N_A3 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio2"
	name="<%=N_A3 %>" value="" /> <%} %>
</div>
<div class="Clear"></div>
</div>
</div>

<!--Block Three Ends-->
<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">Questionnaire 3</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide3">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Condition
for deferment of blood donation :</label>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="col1">Condition
</h5>
<label class="col2">Period of Deferment</label> <label class="col1">Condition
</h5>
<label class="col2">Period of Deferment</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getAbortion().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=ABORTION %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=ABORTION %>" value="" /> <%} %> <label class="col1Value">Abortions</label>
<label class="col2Value">:06 months</label> <%if(donationEntryHeader.getAcuteNephritis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=ACUTE_NERPHRITIS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=ACUTE_NERPHRITIS %>" value="" /> <%} %> <label
	class="col1Value">Acute nephritis</label> <label class="col2Value">:06
months after recovery</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getBloodTransfusion().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=BLOOD_TRANSFUSION %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=BLOOD_TRANSFUSION %>" value="" /> <%} %> <label
	class="col1Value">H/O Blood Transfusion</label> <label
	class="col2Value">:06 months</label> <%if(donationEntryHeader.getImmunoglobulinNephritis().equals("y") ){ %>
<input type="checkbox" class="radio2"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS%>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radio"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS %>" value="" /> <%} %> <label
	class="col1Value">Immunozalic (cholera, Typhoid, Aiptheria,
Teteinus, Plague, Gammaglobulin)</label> <label class="col2Value">:15
days</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getAlcholism().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=ALCHOLISM %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=ALCHOLISM %>" value="" /> <%} %> <label class="col1Value">Alcholism</label>
<label class="col2Value">:Till intoxicated</label> <%if(donationEntryHeader.getRabieVaccination().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=RABIES_VACCINATION %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=RABIES_VACCINATION %>" value="" /> <%} %> <label
	class="col1Value">Rabies vaccination after bite or rabid animal
</label> <label class="col2Value">:1yr after bite</label>
<div class="Clear"></div>
<%if(donationEntryHeader.getMinorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=MINOR_SURGERY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=MINOR_SURGERY %>" value="" /> <%} %> <label class="col1Value">Minor
Surgery</label> <label class="col2Value">:03 Months</label> <%if(donationEntryHeader.getHoHapatitis().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HO_HEPATITIS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=HO_HEPATITIS %>" value="" /> <%} %> <label class="col1Value">H/O
Hepatitis in family or close contact</label> <label class="col2Value">:12
months </label>

<div class="Clear"></div>
<%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=MAJOR_SURGERY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=MAJOR_SURGERY %>" value="" /> <%} %> <label class="col1Value">Major
Surgery</label> <label class="col2Value">:05 Months</label> <%if(donationEntryHeader.getIImmunozalic().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=IMMUNOZALIC %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=IMMUNOZALIC %>" value="" /> <%} %> <label class="col1Value">Immunoglobulin
nephritis</label> <label class="col2Value">:12 months</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getTyphoid().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=TYPHOID %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=TYPHOID %>" value="" /> <%} %> <label class="col1Value">Typhoid</label>
<label class="col2Value">:12 months after recovery</label> <%if(donationEntryHeader.getHoMalaria().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=HO_MALARIA %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=HO_MALARIA %>" value="" /> <%} %> <label class="col1Value">H/O
malaria &amp; duly treated </label> <label class="col2Value">:03 months
(endemic) & 03yrs (non endemic area)</label>
<div class="Clear"></div>
<%if(donationEntryHeader.getTattoing1().equals("y") ){ %> <input
	type="checkbox" class="radio2" name="<%=TATTOOING1 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox" class="radio"
	name="<%=TATTOOING1 %>" value="" /> <%} %> <label class="col1Value">Tattooing</label>
<label class="col2Value">:06 months</label> <%if(donationEntryHeader.getBreastFeeding().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=BREAST_FEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radio" name="<%=BREAST_FEEDING %>" value="" /> <%} %> <label
	class="col1Value">Breast feeding</label> <label class="col2Value">:12
months after delivery</label>

<div class="Clear"></div>
<%if(donationEntryHeader.getNA4().equals("y") ){ %> <input type="checkbox"
	class="radio2" name="<%=N_A4 %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radio" name="<%=N_A4 %>" value="" /> <%} %>
<label class="col1Value">N/A</label>

<div class="Clear"></div></div>
<div class="Clear"></div>
</div>
</div>

<div class="division"></div>
<!--Block Four Ends-->

<div class="blockTitle">Questionnaire 4</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div id="slide4">
<div class="blockFrame">
<div class="Clear"></div>
<div class="paddLeft55"><label class="noWidth">Is there
any history of surgery or blood transfusion in the past 6 months ?</label>
<div class="Clear"></div>
<div class="Height10"></div>
<label class="noHeight">Major</label> <%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=SELECTED_RADIO %>"
	value="" checked="checked" /> <%}else{ %> <input type="radio"
	class="radio2" name="<%=SELECTED_RADIO %>" value="" /> <%} %> <label
	class="noHeight">Minor</label> <%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=SELECTED_RADIO %>"
	value="" checked="checked" /> <%}else{ %> <input type="radio"
	class="radio2" name="<%=SELECTED_RADIO%>" value="" /> <%} %> <label
	class="noHeight">Blood Transfusion</label> <%if(donationEntryHeader.getBloodTransfusion().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=SELECTED_RADIO %>"
	value="" checked="checked" /> <%}else{ %> <input type="radio"
	class="radio2" name="<%=SELECTED_RADIO %>" value="" /> <%} %>

<div class="Clear"></div>

<label class="noHeight">N/A</label> <%if(donationEntryHeader.getNA5().equals("y") ){ %>
<input type="checkbox" class="radio2" name="<%=SELECTED_RADIO %>"
	value="" checked="checked" /> <%}else{ %> <input type="radio"
	class="radio2" name="<%=SELECTED_RADIO%>" value="" /> <%} %>
<div class="Clear"></div>
<label class="noWidth">For women donors :</label>
<div class="Clear"></div>
<div class="Height10"></div>

<label class="noHeight">Are you pregnant ?</label> <label class="small">Yes</label>
<input type="radio" class="radio" name="<%=PREGNENT %>" value="" /> <label
	class="small">No</label> <input type="radio" class="radio"
	name="<%=PREGNENT %>" value="" checked="checked" />

<div class="Clear"></div>

<label class="noHeight">Have you had an abortion in the last 3
months ?</label> <label class="small">Yes</label> <input type="radio"
	class="radio" name="<%=ABORTION1 %>" value="" /> <label class="small">No</label>
<input type="radio" class="radio" name="<%=ABORTION1 %>" value=""
	checked="checked" />

<div class="Clear"></div>

<label class="noHeight">Do you have a child less than one year
old ?</label> <label class="small">Yes</label> <input type="radio" class="radio"
	name="<%=CHILD_LESS %>" value="" /> <label class="small">No</label> <input
	type="radio" class="radio" name="<%=CHILD_LESS %>" value=""
	checked="checked" />

<div class="Clear"></div>

<label class="noHeight">Are you under menses today ?</label> <label
	class="small">Yes</label> <input type="radio" class="radio"
	name="<%=MENSES %>" value="" /> <label class="small">No</label> <input
	type="radio" class="radio" name="<%=MENSES %>" value=""
	checked="checked" />

<div class="Clear"></div>

<label class="noHeight">N/A</label> <label class="small">Yes</label> <input
	type="radio" class="radio" name="<%=N_A4 %>" value="" /> <label
	class="small">No</label> <input type="radio" class="radio"
	name="<%=N_A4 %>" value="" />

<div class="Clear"></div>
<div class="Height10"></div>
<label class="noWidth">Would you like to be informed about any
abnormal test result at the address furnished by you ?</label> <label
	class="small">Yes</label> <input type="radio" class="radio"
	name="<%=ABNORMAL_TEST_RESULT %>" value="" /> <label class="small">No</label>
<input type="radio" class="radio" name="<%=ABNORMAL_TEST_RESULT %>"
	value="" />

<div class="Clear"></div>
<label>Date of Collection</label> <%if(donationEntryHeader.getCollectionDate() != null){ %>
<input type="text" class="calDate" id="lastDateId"
	name="<%=COLLECTION_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getCollectionDate()) %>" />
<%}else{ %> <input type="text" class="calDate" id="lastDateId"
	name="<%=COLLECTION_DATE %>" value="<%=currentDate %>"
	validate="Date of Collection,date,no" MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=COLLECTION_DATE%>,event)" />

<label>Collection Time</label> <%if(donationEntryHeader.getCollectionTime() != null){ %>
<input type="text" id="sampleCollectionTime"
	name="<%=COLLECTION_TIME %>"
	value="<%=donationEntryHeader.getCollectionTime() %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="10" tabindex=1 /> <%}else{ %> <input id="sampleCollectionTime"
	type="text" name="<%= COLLECTION_TIME%>" value="<%=time %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="10" tabindex=1 /> <%} %>
<div class="Clear"></div>
<div class="Height10"></div>

</div>
<div class="Clear"></div>
</div>
</div>


<div class="division"></div>
<!--Block Four Ends-->