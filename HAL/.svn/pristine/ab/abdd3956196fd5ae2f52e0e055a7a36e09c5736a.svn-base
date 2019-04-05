<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"
	language="javascript">
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
	
	<form name="bioMedicalWasteMgt" action="" method="post">

<% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<MasCommand> masCommandList = new ArrayList<MasCommand>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		
		if(map.get("userList")!=null)
	 	{
	 		userList=(List<Users>)map.get("userList");
	 	}		
		
		if(map.get("masCommandList")!=null)
	 	{
			masCommandList=(List<MasCommand>)map.get("masCommandList");
	 	}	
		
		
%>
	
	
	
<div class="titleBg">
<h2>Bio Medical Waste</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label style="width: 300px">Name of Institution<span>*</span></label>
<input type="text" name="nameOfInstitution" maxlength="50" validate="Name of Institution,String,yes" />

<label  style="width: 300px"> Name of the Authorised Person</label>

<%
for(Users user : userList){%>

<input type="text"  name="nameoftheAuthorisedPerson" validate="AuthorisedPersonName,string,no" id="nameoftheAuthorisedPersonId" 
value="<%=user.getEmployee().getRank().getRankName().concat("  ").concat(user.getEmployee().getFirstName()).concat("  ").concat(user.getEmployee().getLastName()) %>" 
maxlength="50" />

<%} %>


<div class="clear"></div>

<label  style="width: 300px"> Command Zone</label>

<%
for(MasCommand masCommand : masCommandList)
{%>
<input  type="text" name="commandZone" validate="zone,string,no" id="commandZoneId" 
value="<%=masCommand.getCommandName()!=null?masCommand.getCommandName():""%>" maxlength="50" readonly="readonly" />

<%} %>

<label  style="width: 300px"> Date of Inspection<span>*</span></label>
<input  type="text"	id="dateOfInspection" name="dateOfInspection" tabindex="1" value=""	readonly="readonly" validate="Date of Inspection,date,yes" MAXLENGTH="30"	class="calDate" onblur="" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
 onClick="setdate('<%=currentDate %>',document.bioMedicalWasteMgt.dateOfInspection,event)"/>	

<div class="clear"></div>


<label  style="width: 300px">Commanding Officer Name</label>	
<%
for(Users user : userList){%>

<input  type="text" name="nameofCommandingOfficer" validate="CommandingOfficer,string,no" id="nameofCommandingOfficerId" 
<%-- value="<%=user.getEmployee().getRank().getRankName().concat("  ").concat(user.getEmployee().getFirstName()).concat("  ").concat(user.getEmployee().getLastName()) %>"  --%>
 maxlength="50" />

<%} %>

<label style="width: 300px">Brief Details of treatment facility</label>
<input type="text" name="briefDetailTreatment" maxlength="100" validate="BriefDetails,string,no"/>

<div class="clear"></div>

<label class="medium">Offsite</label>
<input type="checkbox" name="offsite" value="Offsite" class="radioAuto" id="offsite" onclick="showOffsite();" maxlength="10" />

<input class="transparent" size="5"/>

<div id="offsiteId" style="display: none">

<label>Operator Name</label>
<input type="text" name="operatorName" maxlength="50" />

<label style="width: 300px">Name & Address of Facility</label>
<input type="text" name="nameAddressFacility" maxlength="100" validate="NameAddress,string,no" />

</div>

<div class="clear"></div>

</div>

<h4>Activities</h4>

<div class="clear"></div>

<div class="Block">

<label style="width: 300px"> Amount of waste generated (Category wise)</label>
</div>
<div class="clear PaddingTop10"></div>

<table class="grid_header">

<tr>
<th>Month</th>
<th>Cat 1,2&3</th>
<th>Cat 4</th>
<th>Cat 5</th>
<th>Cat 6</th>
<th>Cat 7</th>
<th>Cat 8</th>
<th>Cat 9&10</th>
</tr>


<tr>
<th>January</th>
<td><input type="text" name="jan_cat_one_three" id="janCatOneThree" maxlength="50" validate="jan_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="jan_cat_four" id="janCatFour" maxlength="50" validate="jan_cat_four,string,no" onblur="totalValFourCat(this.value);"  /></td>
<td><input type="text" name="jan_cat_five" id="janCatFive" maxlength="50" validate="jan_cat_five,string,no" onblur="totalValFiveCat(this.value);"  /></td>
<td><input type="text" name="jan_cat_six" id="janCatSix" maxlength="50" validate="jan_cat_six,string,no" onblur="totalValSixCat(this.value);"  /></td>
<td><input type="text" name="jan_cat_seven" id="janCatSeven" maxlength="50" validate="jan_cat_seven,string,no" onblur="totalValSevenCat(this.value);"  /></td>
<td><input type="text" name="jan_cat_eight" id="janCatEight" maxlength="50" validate="jan_cat_eight,string,no" onblur="totalValEightCat(this.value);"  /></td>
<td><input type="text" name="jan_cat_nine_ten" id="janCatNineTen" maxlength="50" validate="jan_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);"  /></td>
</tr>

<tr>
<th>February</th>
<td><input type="text" name="feb_cat_one_three" id="febCatOneThree" maxlength="50" validate="feb_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="feb_cat_four" id="febCatFour" maxlength="50" validate="feb_cat_one_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="feb_cat_five" id="febCatFive" maxlength="50" validate="feb_cat_one_five_ten,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="feb_cat_six" id="febCatSix" maxlength="50" validate="feb_cat_one_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="feb_cat_seven" id="febCatSeven" maxlength="50" validate="feb_cat_one_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="feb_cat_eight" id="febCatEight" maxlength="50" validate="feb_cat_one_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="feb_cat_nine_ten" id="febCatNineTen" maxlength="50" validate="feb_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);"  /></td>
</tr>

<tr>
<th>March</th>
<td><input type="text" name="mar_cat_one_three" id="marCatOneThree" maxlength="50" validate="mar_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="mar_cat_four" id="marCatFour" maxlength="50" validate="mar_cat_one_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="mar_cat_five" id="marCatFive" maxlength="50" validate="mar_cat_one_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="mar_cat_six" id="marCatSix" maxlength="50" validate="mar_cat_one_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="mar_cat_seven" id="marCatSeven" maxlength="50" validate="mar_cat_one_seven,string,no" onblur="totalValSevenCat(this.value);"/></td>
<td><input type="text" name="mar_cat_eight" id="marCatEight" maxlength="50" validate="mar_cat_one_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="mar_cat_nine_ten" id="marCatNineTen" maxlength="50" validate="mar_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);"  /></td>
</tr>

<tr>
<th>April</th>
<td><input type="text" name="apr_cat_one_three" id="aprCatOneThree" maxlength="50" validate="apr_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="apr_cat_four" id="aprCatFour" maxlength="50" validate="apr_cat_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="apr_cat_five" id="aprCatFive" maxlength="50"  validate="apr_cat_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="apr_cat_six" id="aprCatSix" maxlength="50" validate="apr_cat_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="apr_cat_seven" id="aprCatSeven" maxlength="50" validate="apr_cat_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="apr_cat_eight" id="aprCatEight" maxlength="50" validate="apr_cat_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="apr_cat_nine_ten" id="aprCatNineTen" maxlength="50" validate="apr_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>May</th>
<td><input type="text" name="may_cat_one_three" maxlength="50" id="mayCatOneThree" validate="may_cat_one_three,string,no"  onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="may_cat_four" maxlength="50" id="mayCatFour" validate="may_cat_four,string,no"  onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="may_cat_five" maxlength="50" id="mayCatFive" validate="may_cat_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="may_cat_six" maxlength="50" id="mayCatSix" validate="may_cat_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="may_cat_seven" maxlength="50" id="mayCatSeven" validate="may_cat_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="may_cat_eight" maxlength="50" id="mayCatEight" validate="may_cat_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="may_cat_nine_ten" maxlength="50" id="mayCatNineTen" validate="may_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>June</th>
<td><input type="text" name="jun_cat_one_three" id="junCatOneThree" maxlength="50" validate="jun_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="jun_cat_four" id="junCatFour" maxlength="50" validate="jun_cat_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="jun_cat_five" id="junCatFive" maxlength="50" validate="jun_cat_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="jun_cat_six" id="junCatSix" maxlength="50" validate="jun_cat_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="jun_cat_seven" id="junCatSeven" maxlength="50" validate="jun_cat_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="jun_cat_eight" id="junCatEight" maxlength="50" validate="jun_cat_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="jun_cat_nine_ten" id="junCatNineTen" maxlength="50" validate="jun_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>July</th>
<td><input type="text" name="jul_cat_one_three" id="julCatOneThree" maxlength="50" validate="jul_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="jul_cat_four" id="julCatFour" maxlength="50" validate="jul_cat_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="jul_cat_five" id="julCatFive" maxlength="50" validate="jul_cat_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="jul_cat_six" id="julCatSix" maxlength="50" validate="jul_cat_six,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="jul_cat_seven" id="julCatSeven" maxlength="50" validate="jul_cat_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="jul_cat_eight" id="julCatEight" maxlength="50" validate="jul_cat_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="jul_cat_nine_ten" id="julCatNineTen" maxlength="50" validate="jul_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>August</th>
<td><input type="text" name="aug_cat_one_three" id="augCatOneThree" maxlength="50" validate="aug_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="aug_cat_four" id="augCatFour" maxlength="50" validate="aug_cat_four,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="aug_cat_five" id="augCatFive" maxlength="50" validate="aug_cat_five,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="aug_cat_six" id="augCatSix" maxlength="50" validate="aug_cat_six,string,no" onblur="totalValSixCat(this.value);" /></td> 
<td><input type="text" name="aug_cat_seven" id="augCatSeven" maxlength="50" validate="aug_cat_seven,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="aug_cat_eight" id="augCatEight" maxlength="50" validate="aug_cat_eight,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="aug_cat_nine_ten" id="augCatNineTen" maxlength="50" validate="aug_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>September</th>
<td><input type="text" name="sep_cat_one_three" id="sepCatOneThree" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="sep_cat_four" id="sepCatFour" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="sep_cat_five" id="sepCatFive" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="sep_cat_six" id="sepCatSix" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="sep_cat_seven" id="sepCatSeven" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="sep_cat_eight" id="sepCatEight" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="sep_cat_nine_ten" id="sepCatNineTen" maxlength="50" validate="sep_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>October</th>
<td><input type="text" name="oct_cat_one_three" id="octCatOneThree" maxlength="50" validate="oct_cat_one_three,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="oct_cat_four" id="octCatFour" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="oct_cat_five" id="octCatFive" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="oct_cat_six" id="octCatSix" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="oct_cat_seven" id="octCatSeven" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="oct_cat_eight" id="octCatEight" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="oct_cat_nine_ten" id="octCatNineTen" maxlength="50" validate="oct_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>November</th>
<td><input type="text" name="nov_cat_one_three" id="novCatOneThree" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="nov_cat_four" id="novCatFour" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="nov_cat_five" id="novCatFive" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="nov_cat_six" id="novCatSix" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="nov_cat_seven" id="novCatSeven" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="nov_cat_eight" id="novCatEight" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="nov_cat_nine_ten" id="novCatNineTen" maxlength="50" validate="nov_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>December</th>
<td><input type="text" name="dec_cat_one_three" id="decCatOneThree" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValFirstCat(this.value);" /></td>
<td><input type="text" name="dec_cat_four" id="decCatFour" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValFourCat(this.value);" /></td>
<td><input type="text" name="dec_cat_five" id="decCatFive" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValFiveCat(this.value);" /></td>
<td><input type="text" name="dec_cat_six" id="decCatSix" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValSixCat(this.value);" /></td>
<td><input type="text" name="dec_cat_seven" id="decCatSeven" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValSevenCat(this.value);" /></td>
<td><input type="text" name="dec_cat_eight" id="decCatEight" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValEightCat(this.value);" /></td>
<td><input type="text" name="dec_cat_nine_ten" id="decCatNineTen" maxlength="50" validate="dec_cat_nine_ten,string,no" onblur="totalValNineCat(this.value);" /></td>
</tr>

<tr>
<th>Total</th>
<td><input type="text" name="total_cat_one_three" maxlength="50" id="totalCatOneThree" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_four" maxlength="50" id="totalCatFour" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_five" maxlength="50" id="totalCatFive" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_six" maxlength="50" id="totalCatSix" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_seven" maxlength="50" id="totalCatSeven" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_eight" maxlength="50" id="totalCatEight" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
<td><input type="text" name="total_cat_nine_ten" maxlength="50" id="totalCatNineTen" validate="total_cat_nine_ten,string,no" readonly="readonly" /></td>
</tr>

</table>



<!--<label style="margin-left:5px; width: 70px" >Cat 1,2&3</label>
<label style="margin-left:20px; width: 50px">Cat 4</label>
<label style="margin-left:20px; width: 50px ">Cat 5</label>
<label style="margin-left:20px; width: 50px ">Cat 6</label>
<label style="margin-left:20px; width: 50px ">Cat 7</label>
<label style="margin-left:20px; width: 50px ">Cat 8</label>	
<label style="margin-left:20px; width: 70px ">Cat 9&10</label>	
--><div class="clear"></div>
	
<!--<input	id="date" class="auto" size="11" type="text" name="date"  id="dateID" value="" />
<input	style="margin-left:15px; " class="auto" size="8" type="text" name="date" id="dateID" value="" />

<input	style="margin-left:10px;  id=" class="auto" size="8" type="text" name="date"  id="dateID" value="" />
<input	style="margin-left:10px;id=" class="auto" size="8" type="text" name="date"  id="dateID" value="" />

<input	style="margin-left:13px;id=" class="auto" size="8" type="text" name="date"  id="dateID" value="" />
<input	style="margin-left:10px;id=" class="auto" size="8" type="text" name="date"  id="dateID" value="" />
<input	style="margin-left:13px;id=" class="auto" size="11" type="text" name="date"  id="dateID" value="" />

--><div class="clear"></div>

<div class="Block">

<label style="width: 350px">Collection & Storage Availability of Plastic Bags/Bucket</label>
<select name="collectionStorage">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>

<div class="clear"></div>

<label style="width: 350px">Mode of Treatement</label>
<select name="modeofTransportation">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>

<div class="clear"></div>

<label style="width: 350px">Knowledge,Attitude & Practices among BMW Handlers</label>
<select name="knowledgeAttitude">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>

<div class="clear"></div>

<label style="width: 350px">Use of Personal Protective Clothing</label>
<select name="useofPersonal">
<option value="">Select</option>
<option value="no">Yes</option>
<option value="No">No</option>
</select>

<div class="clear"></div>

</div>

<h4>Final Disposal</h4>

<div class="clear"></div>

<!--<table class="cmntable">

<tr>
<th>Disposal</th>
<th>Working/ Not Working</th>
<th>Category</th>
</tr>

<tr>
<th>Incineratory</th>
<td><select name="incinerator"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select name="incCat1213"><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Deep Burial</th>
<td><select name="deepBru"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Microwave</th>
<td><select name="microwave"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Autoclave</th>
<td><select name="autoclave"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Hydroclave</th>
<td><select name="hydroclave"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Shredder</th>
<td><select name="shredder"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

<tr>
<th>Needle Destroyer</th>
<td><select name="needleDes"><option>Select</option><option>Working</option><option>Not Working</option></select></td>
<td><select><option>Select</option><option>Cat 1,2&3</option><option>Cat 4</option><option>Cat 5</option><option>Cat 6</option><option>Cat 7</option><option>Cat 8</option><option>Cat 9&10</option></select></td>
</tr>

</table>

--><div class="Block">

<label>Incinerator</label>
<select name="incinerator">
<option value="">Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<label>Deep Burial </label>
<select name="deepBru">
<option value="">Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<label>Microwave</label>
<select name="microwave">
<option value="">Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<div class="clear"></div>

<label>Autoclave</label>
<select name="autoclave">
<option>Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<label>Hydroclave</label>
<select name="hydroclave">
<option>Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<label>Shredder</label>
<select name="shredder">
<option>Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<div class="clear"></div>

<label>Needle Destroyer </label>
<select name="needleDes">
<option>Select</option>
<option value="Working">Working</option>
<option value="Not Working">Not Working</option>
</select>

<div class="clear"></div>

<label  style=" width: 310px"> Any other form of handling</label>
<input  type="text" name="anyOther"  id="anyOtherId" value="" maxlength="300" validate="anyOther,string,no" />

<div class="clear"></div>

<label style=" width: 310px">Remarks of Inspecting/Visiting Officer</label>
<input  type="text" name="remarksofInsp"  id="remarksofInspId" value="" maxlength="300" validate="remarksofInsp,string,no" />

<div class="clear"></div>

<label style=" width: 310px">Final Observations</label>	
<input  type="text" name="finalObser"   id="finalObserId" value="" maxlength="300" validate="finalObservation,string,no" />
<div class="clear"></div>
</div>
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<div class="clear PaddingTop10"></div>

<!--<input type="button" name="submit" value="Submit" class="button" onclick="submitForm('bioMedicalWasteMgt','/hms/hms/mis?method=submitBiomedicalwastemgtjsp');" />

--><input type="button" name="Submit" value="Submit" tabindex="1" class="button" onClick="submitForm('bioMedicalWasteMgt','/hms/hms/mis?method=submitBiomedicalwastemgtjsp');" />

<input type="button" name="reset" value="Reset" class="button"  onClick="submitFormForButton('bioMedicalWasteMgt','/hms/hms/mis?method=showBiomedicalwastemgtjsp');" />
<input type="button" name="Back"  value="Back"  onClick="history.back();"  class="button" />	

<div class="clear"></div>
</form>

<script>
function showOffsite(){
	if(document.getElementById('offsite').checked == true){
	  	document.getElementById("offsiteId").style.display='inline';
	}else if(document.getElementById('offsite').checked == false){
		document.getElementById("offsiteId").style.display='none';
	}
}

function totalValFirstCat(val){

	var totalFirst=0;

	if(document.getElementById('janCatOneThree').value != null && document.getElementById('janCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('janCatOneThree').value);
	}

	if(document.getElementById('febCatOneThree').value != null && document.getElementById('febCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('febCatOneThree').value);
	}

	if(document.getElementById('marCatOneThree').value != null && document.getElementById('marCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('marCatOneThree').value);
	}

	if(document.getElementById('aprCatOneThree').value != null && document.getElementById('aprCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('aprCatOneThree').value);
	}

	if(document.getElementById('mayCatOneThree').value != null && document.getElementById('mayCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('mayCatOneThree').value);
	}

	if(document.getElementById('junCatOneThree').value != null && document.getElementById('junCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('junCatOneThree').value);
	}

	if(document.getElementById('julCatOneThree').value != null && document.getElementById('julCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('julCatOneThree').value);
	}

	if(document.getElementById('augCatOneThree').value != null && document.getElementById('augCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('augCatOneThree').value);
	}

	if(document.getElementById('sepCatOneThree').value != null && document.getElementById('sepCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('sepCatOneThree').value);
	}

	if(document.getElementById('octCatOneThree').value != null && document.getElementById('octCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('octCatOneThree').value);
	}

	if(document.getElementById('novCatOneThree').value != null && document.getElementById('novCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('novCatOneThree').value);
	}

	if(document.getElementById('decCatOneThree').value != null && document.getElementById('decCatOneThree').value != 0)
	{
		totalFirst = Number(totalFirst) + Number(document.getElementById('decCatOneThree').value);
	}
	document.getElementById('totalCatOneThree').value = totalFirst;
}

function totalValFourCat(val){

	var totalFour=0;

	if(document.getElementById('janCatFour').value != null && document.getElementById('janCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('janCatFour').value);
	}

	if(document.getElementById('febCatFour').value != null && document.getElementById('febCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('febCatFour').value);
	}

	if(document.getElementById('marCatFour').value != null && document.getElementById('marCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('marCatFour').value);
	}

	if(document.getElementById('aprCatFour').value != null && document.getElementById('aprCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('aprCatFour').value);
	}

	if(document.getElementById('mayCatFour').value != null && document.getElementById('mayCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('mayCatFour').value);
	}

	if(document.getElementById('junCatFour').value != null && document.getElementById('junCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('junCatFour').value);
	}

	if(document.getElementById('julCatFour').value != null && document.getElementById('julCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('julCatFour').value);
	}

	if(document.getElementById('augCatFour').value != null && document.getElementById('augCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('augCatFour').value);
	}

	if(document.getElementById('sepCatFour').value != null && document.getElementById('sepCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('sepCatFour').value);
	}

	if(document.getElementById('octCatFour').value != null && document.getElementById('octCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('octCatFour').value);
	}

	if(document.getElementById('novCatFour').value != null && document.getElementById('novCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('novCatFour').value);
	}

	if(document.getElementById('decCatFour').value != null && document.getElementById('decCatFour').value != 0)
	{
		totalFour = Number(totalFour) + Number(document.getElementById('decCatFour').value);
	}
	document.getElementById('totalCatFour').value = totalFour;
}

function totalValFiveCat(val){
	
	var totalFive=0;

	if(document.getElementById('janCatFive').value != null && document.getElementById('janCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('janCatFive').value);
	}

	if(document.getElementById('febCatFive').value != null && document.getElementById('febCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('febCatFive').value);
	}

	if(document.getElementById('marCatFive').value != null && document.getElementById('marCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('marCatFive').value);
	}

	if(document.getElementById('aprCatFive').value != null && document.getElementById('aprCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('aprCatFive').value);
	}

	if(document.getElementById('mayCatFive').value != null && document.getElementById('mayCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('mayCatFive').value);
	}

	if(document.getElementById('junCatFive').value != null && document.getElementById('junCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('junCatFive').value);
	}

	if(document.getElementById('julCatFive').value != null && document.getElementById('julCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('julCatFive').value);
	}

	if(document.getElementById('augCatFive').value != null && document.getElementById('augCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('augCatFive').value);
	}

	if(document.getElementById('sepCatFive').value != null && document.getElementById('sepCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('sepCatFive').value);
	}

	if(document.getElementById('octCatFive').value != null && document.getElementById('octCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('octCatFive').value);
	}

	if(document.getElementById('novCatFive').value != null && document.getElementById('novCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('novCatFive').value);
	}

	if(document.getElementById('decCatFive').value != null && document.getElementById('decCatFive').value != 0)
	{
		totalFive = Number(totalFive) + Number(document.getElementById('decCatFive').value);
	}
	document.getElementById('totalCatFive').value = totalFive;
}

function totalValSixCat(val){
	
	var totalSix=0;

	if(document.getElementById('janCatSix').value != null && document.getElementById('janCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('janCatSix').value);
	}

	if(document.getElementById('febCatSix').value != null && document.getElementById('febCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('febCatSix').value);
	}

	if(document.getElementById('marCatSix').value != null && document.getElementById('marCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('marCatSix').value);
	}

	if(document.getElementById('aprCatSix').value != null && document.getElementById('aprCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('aprCatSix').value);
	}

	if(document.getElementById('mayCatSix').value != null && document.getElementById('mayCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('mayCatSix').value);
	}

	if(document.getElementById('junCatSix').value != null && document.getElementById('junCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('junCatSix').value);
	}

	if(document.getElementById('julCatSix').value != null && document.getElementById('julCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('julCatSix').value);
	}

	if(document.getElementById('augCatSix').value != null && document.getElementById('augCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('augCatSix').value);
	}

	if(document.getElementById('sepCatSix').value != null && document.getElementById('sepCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('sepCatSix').value);
	}

	if(document.getElementById('octCatSix').value != null && document.getElementById('octCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('octCatSix').value);
	}

	if(document.getElementById('novCatSix').value != null && document.getElementById('novCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('novCatSix').value);
	}

	if(document.getElementById('decCatSix').value != null && document.getElementById('decCatSix').value != 0)
	{
		totalSix = Number(totalSix) + Number(document.getElementById('decCatSix').value);
	}
	document.getElementById('totalCatSix').value = totalSix;
}

function totalValSevenCat(val){
	
	var totalSeven=0;

	if(document.getElementById('janCatSeven').value != null && document.getElementById('janCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('janCatSeven').value);
	}

	if(document.getElementById('febCatSeven').value != null && document.getElementById('febCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('febCatSeven').value);
	}

	if(document.getElementById('marCatSeven').value != null && document.getElementById('marCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('marCatSeven').value);
	}

	if(document.getElementById('aprCatSeven').value != null && document.getElementById('aprCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('aprCatSeven').value);
	}

	if(document.getElementById('mayCatSeven').value != null && document.getElementById('mayCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('mayCatSeven').value);
	}

	if(document.getElementById('junCatSeven').value != null && document.getElementById('junCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('junCatSeven').value);
	}

	if(document.getElementById('julCatSeven').value != null && document.getElementById('julCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('julCatSeven').value);
	}

	if(document.getElementById('augCatSeven').value != null && document.getElementById('augCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('augCatSeven').value);
	}

	if(document.getElementById('sepCatSeven').value != null && document.getElementById('sepCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('sepCatSeven').value);
	}

	if(document.getElementById('octCatSeven').value != null && document.getElementById('octCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('octCatSeven').value);
	}

	if(document.getElementById('novCatSeven').value != null && document.getElementById('novCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('novCatSeven').value);
	}

	if(document.getElementById('decCatSeven').value != null && document.getElementById('decCatSeven').value != 0)
	{
		totalSeven = Number(totalSeven) + Number(document.getElementById('decCatSeven').value);
	}
	document.getElementById('totalCatSeven').value = totalSeven;
}

function totalValEightCat(val){
	
	var totalEight=0;

	if(document.getElementById('janCatEight').value != null && document.getElementById('janCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('janCatEight').value);
	}

	if(document.getElementById('febCatEight').value != null && document.getElementById('febCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('febCatEight').value);
	}

	if(document.getElementById('marCatEight').value != null && document.getElementById('marCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('marCatEight').value);
	}

	if(document.getElementById('aprCatEight').value != null && document.getElementById('aprCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('aprCatEight').value);
	}

	if(document.getElementById('mayCatEight').value != null && document.getElementById('mayCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('mayCatEight').value);
	}

	if(document.getElementById('junCatEight').value != null && document.getElementById('junCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('junCatEight').value);
	}

	if(document.getElementById('julCatEight').value != null && document.getElementById('julCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('julCatEight').value);
	}

	if(document.getElementById('augCatEight').value != null && document.getElementById('augCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('augCatEight').value);
	}

	if(document.getElementById('sepCatEight').value != null && document.getElementById('sepCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('sepCatEight').value);
	}

	if(document.getElementById('octCatEight').value != null && document.getElementById('octCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('octCatEight').value);
	}

	if(document.getElementById('novCatEight').value != null && document.getElementById('novCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('novCatEight').value);
	}

	if(document.getElementById('decCatEight').value != null && document.getElementById('decCatEight').value != 0)
	{
		totalEight = Number(totalEight) + Number(document.getElementById('decCatEight').value);
	}
	document.getElementById('totalCatEight').value = totalEight;
}

function totalValNineCat(val){
	
	var totalNine=0;

	if(document.getElementById('janCatNineTen').value != null && document.getElementById('janCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('janCatNineTen').value);
	}

	if(document.getElementById('febCatNineTen').value != null && document.getElementById('febCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('febCatNineTen').value);
	}

	if(document.getElementById('marCatNineTen').value != null && document.getElementById('marCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('marCatNineTen').value);
	}

	if(document.getElementById('aprCatNineTen').value != null && document.getElementById('aprCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('aprCatNineTen').value);
	}

	if(document.getElementById('mayCatNineTen').value != null && document.getElementById('mayCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('mayCatNineTen').value);
	}

	if(document.getElementById('junCatNineTen').value != null && document.getElementById('junCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('junCatNineTen').value);
	}

	if(document.getElementById('julCatNineTen').value != null && document.getElementById('julCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('julCatNineTen').value);
	}

	if(document.getElementById('augCatNineTen').value != null && document.getElementById('augCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('augCatNineTen').value);
	}

	if(document.getElementById('sepCatNineTen').value != null && document.getElementById('sepCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('sepCatNineTen').value);
	}

	if(document.getElementById('octCatNineTen').value != null && document.getElementById('octCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('octCatNineTen').value);
	}

	if(document.getElementById('novCatNineTen').value != null && document.getElementById('novCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('novCatNineTen').value);
	}

	if(document.getElementById('decCatNineTen').value != null && document.getElementById('decCatNineTen').value != 0)
	{
		totalNine = Number(totalNine) + Number(document.getElementById('decCatNineTen').value);
	}
	document.getElementById('totalCatNineTen').value = totalNine;
}


</script>