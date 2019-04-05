
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showDMConsumDrugWiseReportJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreItemGeneric> searchMasStoreItemGenericList = new ArrayList<MasStoreItemGeneric>();
	if(map.get("searchMasStoreItemGenericList")!=null)
		searchMasStoreItemGenericList = (List) map.get("searchMasStoreItemGenericList");


%>
<form name="DMConsumDrugWise" method="post" action="">

<div class="titleBg"><h2>Controlled/Dangerous Drug Issue Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label> 
<input type="text" name="<%=FROM_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.DMConsumDrugWise.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date  </label> 
<input type="text" name="<%=TO_DATE%>" value="" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.DMConsumDrugWise.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<!--<label ><span>*</span> Generic Name </label>-->
<!--<select name="<%=ITEM_GENERIC_ID%>" validate="Generic Name,String,yes">-->
<!--<option value=0>Select</option>-->
	<%
				for (MasStoreItemGeneric masStoreItemGeneric :searchMasStoreItemGenericList ) {
				
				%>
<!--<option value=<%=masStoreItemGeneric.getId()%>><%=masStoreItemGeneric.getGenericName()%>-->
<!--</option>-->
	<%	
					}
				
					
				%>
<!--</select> -->
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center><input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('DMConsumDrugWise','stores?method=generateDMConsumDrugWiseReportReport');" accesskey="a" tabindex=1 /> 
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('DMConsumDrugWise');" accesskey="a" tabindex=1 />
</center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>







