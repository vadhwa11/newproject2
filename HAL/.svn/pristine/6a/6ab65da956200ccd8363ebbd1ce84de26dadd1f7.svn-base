<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>  
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
<%

Map<String,Object> utilMap1 = new HashMap<String,Object>();


utilMap1 = (Map)HMSUtil.getCurrentDateAndTime();
String newdate = (String)utilMap1.get("currentDate");  
String time = (String)utilMap1.get("currentTime");



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

<script type="text/javascript" language="javascript">







</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Box box = null;

	

	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	

	
	
	if(map.get("financialYearList") != null)
	 {
		 financialYearList =  (List<Object[]>)map.get("financialYearList");	  		 
		   
	  }
System.out.println("financialYearList------"+financialYearList.size());
	

	
	
%>


 <div class="titleBg">
<h2>Receiving Report Entry</h2>
</div>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>
<form name="nisDetails" method="post">

<div class="Block">
<div class="clear"></div>
	
<label>Select Year</label>

<select name ="yearId" id="yearId" onchange="submitProtoAjaxWithDivNameToShowStatus('nisDetails','/hms/hms/stores?method=getPOYear','divPOList');">
<option value="0">Select</option>
	<%
		if(financialYearList.size()>0)
		{
			for(Object[] year : financialYearList)
			{
				%>
					<option value="<%=year[0]%>"><%=year[1]%></option>
				<%
			}
		}
	%>
</select>


<div id="divPOList">
	<label> Purchase Order No  <span>*</span></label>
	<select	class="" name="poNo" id="poNo" validate="Purchase Order No,String,yes" tabindex=1 >
		<option value="">Select Purchase Order No</option>


</select>
<label>RR No. <span>*</span></label>
<select name="grnId" validate="RR No." tabindex=1	validate="RR No.,string,yes" >
<option value="0">Select</option>
</select>
</div>
	
</div>
	
	
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('nisDetails','/hms/hms/stores?method=generateReceivingReport');"  tabindex=1 />
	
</form>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">
		
	
		
		function getPOList()
		{
	
			if($j("#ddlRequestYear").val() == 0)
			{
				alert("Please select the Year");
				return;
			}
			var yearId=$j("#ddlRequestYear").val();
			if(yearId !=0)
				{
					
				}
			
		}
		
	
	
		
		 </script>
		 