<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>


<%@page import="java.net.URL"%>
<script>
		 var nameArray=new Array();
		 var itemsArray1=new Array();
	</script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month1+"/"+year1%>'
	</script>


<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String)utilMap.get("currentDate"); 
		if(request.getAttribute("map") != null){
		 map = (Map) request.getAttribute("map");
		}
		
	 	 List<MasDivision> divisionList = new ArrayList<MasDivision>();
			
			if(map.get("divisionList") != null){
				divisionList = (List<MasDivision>)map.get("divisionList");
			}
	%>
	

<div class="titleBg">
<h2>Payroll Deduction Journal</h2>
</div>
<form name="cashSheet" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>
<label>From Date <span>*</span></label>
<input	type="text" name="<%= FROM_DATE %>"  placeholder="DD/MM/YYYY" validate="From Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');"  class="calDate" maxlength="30" tabindex=1 value="<%=currentDate %>" />

<label>To Date <span>*</span></label>
<input	type="text" name="<%= TO_DATE %>"  placeholder="DD/MM/YYYY" validate="To Date,string,yes"  onkeyup="mask(this.value,this,'2,5','/');" class="calDate" maxlength="30"  tabindex=1 value="<%=currentDate %>"/>


<label>Division. <span>*</span></label> 
<select name ="divisionId" id="divisionId" validate="Division,string,yes"   onchange="GetPatientList('FILTER');">
<option value="0">Select</option>
	<%
		if(divisionList.size()>0)
		{
			for(MasDivision md: divisionList)
			{
				%>
					<option value="<%=md.getId()%>"><%=md.getDivisionName()%></option>
				<%
			}
		}
	%>
	</select>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Print" class="button" onClick="submitForm('cashSheet','ipd?method=printPayrollDeductionJournalReport');" />
<input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
