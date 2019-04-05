<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
Map map = new HashMap();
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
	<h4><%=message %></h4>
	<%} %>

<script language="Javascript">

function showReport()
{
		if (!validateFromToDate()) return false;	
		if(document.BINCardForm.nomenclature.value != "")
		{
		var val = document.BINCardForm.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		 if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	document.BINCardForm.method="post";
			submitForm('BINCardForm','stores?method=generateBINCardReport');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(document.BINCardForm.pvms.value != "")
		{
		document.BINCardForm.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		submitForm('BINCardForm','stores?method=generateBINCardReport&pvmsNo='+pvms);
		}
}
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.BINCardForm.fromDate)
	obj2 = eval(document.BINCardForm.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}
			
		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}
	
	}
	return true;
}

function displayPVMS(val){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("(");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf(")");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	   
	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclature').value="";
	    document.getElementById('pvms').value="";
	   return;
	   }
	   else
	      document.getElementById('pvms').value=pvmsNo
	
	
	 }
}
function validateDates() 

{
	var strValue = document.BINCardForm.<%=FROM_DATE%>.value;
	var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	strValue = document.BINCardForm.<%=TO_DATE%>.value;
 	var toDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	var month = 3;
	var day = 31;
	var year = 2009;
	var seperator = "/"
	var stockDate = new Date(month + seperator + day + seperator + year);
	
	if (fromDate > toDate)
 	{
		alert('From Date cannot be greater than To Date!....');
		return false;
 	}
 	
 	if (fromDate < stockDate)
 	{
 		alert('From Date cannot be lesser than Stock Date (31/03/2009) !....');
		return false;
 	}
 	
 	return true; 
}
</script>

<body>
<form name="BINCardForm"  target="_blank" action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>BIN Card</h2>
</div>
<div class="Block">
<label><span>*</span> From Date  </label>
<input type="text" name="<%=FROM_DATE%>" value="" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.BINCardForm.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date  </label>
<input	type="text" name="<%=TO_DATE%>" value="" validate="To Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1" onClick="setdate('<%=date%>',document.BINCardForm.<%=TO_DATE%>,event)" />
<div class="clear"></div>

<label>PVMS/NIV No  </label>
<input type="text" 	value="" id="pvms"  name="pvms" />
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" name="nomenclature" onblur="displayPVMS(this.value);"/>
<div id="ac2update" class="autocomplete" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="showReport();"	value="Ok" class="button">
<input type="reset" name="Reset" id="reset" value="Cancel" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


</form>
</body>
