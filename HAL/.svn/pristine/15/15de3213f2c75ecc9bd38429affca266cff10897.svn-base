<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
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
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">


var $j = jQuery.noConflict();
</script>


<script>
		 var nameArray=new Array();
		 var itemsArray1=new Array();
		 
		 function checkValidation()
		 {
			 boolean flag = true;
			 if(document.getElementById('departmentId').value.trim()=="0")
				 {
				 if(document.getElementById('fromDate').value.trim()=="")
				 {
				 alert("Please select ward or a date range");
				 flag = false;
				 }
				 else if(document.getElementById('fromDate').value.trim()=="")
					 {
					 alert("Please select ward or a date range");
					 flag = false;
					 }
				 }
			
				return flag; 
		 }
	</script>

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script>
	<%
	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
	if(map.get("departmentList")!=null){
		departmentList = (ArrayList)map.get("departmentList");
	}
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
		
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String)utilMap.get("currentDate");  
	%>
	

<div class="titleBg">
<h2>Issued Medicine Report</h2>
</div>
<form name="cashSheet" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>


<label >From Date<span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="From Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />


<label >To Date <span>*</span></label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="To Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />


<label>Ward<span></span></label>
<select name="departmentId" id="departmentId" validate="Department,string,no" tabindex=1	>
<option value="0">Select</option>
	<%
	
				for (MasDepartment  e	 : departmentList){

				%>
<option value="<%=e.getId()%>"><%=e.getDepartmentName()%></option>

	<%}%>
	<option value="123">EMERGENCY</option>
</select>

<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1&flag=k'});
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Print" value="Print" class="button" onClick="submitForm('cashSheet','stores?method=generateIssueMedicineReport', 'checkValidation');" />
<!-- <input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" /> -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
