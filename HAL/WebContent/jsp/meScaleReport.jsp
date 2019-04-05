
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderT"%>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=showWorkRegisterReportJsp";
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
	List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
	if(map.get("searchMasStoreItemList")!=null)
		searchMasStoreItemList = (List) map.get("searchMasStoreItemList");
	System.out.println("searchMasStoreItemList--jsp-->"+searchMasStoreItemList);


%>
<form name="meScale" method="post" action=""><br />
<div class="titleBg">
<h2>ME Scale Report</h2>
</div>
<div class="Block">
<!--<label> From Date <span>*</span> </label> 
<input type="text" class="date" name="<%=FROM_DATE%>" value="<%=currentDate %>"  MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.workRegister.<%=FROM_DATE%>,event)" />

<label>To Date<span>*</span> </label> 
<input type="text" class="date" name="<%=TO_DATE%>" value="<%=currentDate %>" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.workRegister.<%=TO_DATE%>,event)" />

-->

<label>ME Scale No. <span>*</span></label>
<input type="text" name="meScaleNo" validate="ME Scale No,String,yes"  />


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('meScale','neStores?method=generateMeScaleReport');" accesskey="a" tabindex=1 />

<input type="button" name="clear" id="clearbutton" value="Clear" class="button" onClick="clearButton('meScale');" accesskey="a" tabindex=1 />

</form>
