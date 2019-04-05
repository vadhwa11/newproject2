<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
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


<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
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
 	
  	Map map = new HashMap();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>

<title>BIN Card</title>

<script language="Javascript">

function showReport()
{
		if (!validateDates()) return false;	
		if(BINCardForm.nomenclature.value != "")
		{
		var val = BINCardForm.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		 if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	BINCardForm.method="post";
			submitForm('BINCardForm','stores?method=generateBINCardReport');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(BINCardForm.pvms.value != "")
		{
		BINCardForm.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		submitForm('BINCardForm','stores?method=generateBINCardReport&pvmsNo='+pvms);
		}
	else{
	   alert("Please Enter The value.")
		}	
}


function validateDates() 
{
	var strValue = BINCardForm.<%=FROM_DATE%>.value;
	var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	strValue = BINCardForm.<%=TO_DATE%>.value;
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
</head>

<body>
<form name="stockStatusForm"><input type="hidden" name="hospitalId"
	size="5" value="<%=hospitalId%>"> <input type="hidden"
	name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="item_id" size="5" id="item_id"> <br />
<div id="contentspace">
		<br />


<div style="padding-left: 15px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Stock Status Report</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 660px; height: auto; background-color: #f4f9fe;">
<br />

<label class="bodytextB"><font id="error">*</font>From Date :</label> <input
	type="text" name="<%=FROM_DATE%>" value="" class="textbox_date"
	validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.stockStatus.<%=FROM_DATE%>,event)" />

<label class="bodytextB"><font id="error">*</font>To Date :</label> <input
	type="text" name="<%=TO_DATE%>" value="" class="textbox_date"
	validate="To Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.stockStatus.<%=TO_DATE%>,event)" />
<br />
<br />


<label class="bodytextB">Nomenclature </label> <input type="text"
	value="" id="nomenclature" class="bigcaption1" name="nomenclature" />
<div id="ac2update"
	style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
					</script> <br />
<br />

<label class="bodytextB">PVMS/NIV No: </label> <input type="text"
	value="" id="pvms" class="textbox_size20" name="pvms" /> <br />
<br />
</div>
<br />
<input type="button" name="report" onClick="showReport();"
	value="Submit" class="button"></div>
</div>
</form>
</body>
</html>