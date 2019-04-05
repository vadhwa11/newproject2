<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


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

<script language="Javascript">

function showReport()
{
		if(stockPosition.nomenclature.value != "")
		{
		var val = stockPosition.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	stockPosition.method="post";
			submitForm('stockPosition','stores?method=generateStockPositionReport');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(stockPosition.pvms.value != "")
		{
		stockPosition.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		submitForm('stockPosition','stores?method=generateStockPositionReport&pvmsNo='+pvms);
		}
	else if(stockPosition.<%=COMMON_NAME %>.value !=""){
		var val = stockPosition.<%=COMMON_NAME %>.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	stockPosition.method="post";
			submitForm('stockPosition','stores?method=generateStockPositionReport');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
	} 	
	else{
	   alert("Please Enter The value.")
		}	
}

</script>

<form name="stockPosition">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>"> 
<input type="hidden" name="deptId" size="5" value="<%=deptId%>"> 
<input type="hidden" name="item_id" size="5" id="item_id"> <br />

<div class="titleBg">
<h2>Stock Position Item Wise</h2>
</div>

<h4>Stock Position Item Wise</h4>

<div class="Block">
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script> 
<!-- -
<label>Common Name </label>
<input type="text" name="<%=COMMON_NAME %>" id = "<%=COMMON_NAME %>"  class="large" MAXLENGTH="30" />
<div id="ac3update" style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('<%=COMMON_NAME %>','ac3update','stores?method=getItemListForBINCardByCommonNameAutocomplete',{parameters:'requiredField=<%=COMMON_NAME %>'});
</script> -->
<label>PVMS/NIV No </label> 
<input type="text" value="" id="pvms" class="textbox_size20" name="pvms" /> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="showReport();"
	value="Submit" class="button">
	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
