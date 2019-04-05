<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
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


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
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
	String date = "";
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
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;
	String message = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		
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

<title>Tender PVMS/NIV Report</title>

<script language="Javascript">


	function goPage(pidx) {	
	//alert("In go page method")
	//alert("pidx-----"+pidx)
	stockDetailsForm.currPage.value = pidx;
	var valueOfHiddenField=document.stockDetailsForm.hiddenFieldForRecords.value;
	if(valueOfHiddenField =="true"){
			submitProtoAjax('stockDetailsForm','stores?method=getStockDetailForNextRecord');
		}else{
			submitProtoAjax('stockDetailsForm','stores?method=getStockDetail');
		}
	}
	
			function callNext()
						{
						 if(validateNextRecordButton()){						
						//alert("In cal Next method value of itemid---"+itemIdField)
						stockDetailsForm.method="post";
						
						//document.indentForm.hiddenFieldForRecords.value="true";
					submitProtoAjax('stockDetailsForm','/hms/hms/stores?method=getStockDetailForNextRecord&buttonName=next&currPage=0');
					}}


		function validateNextRecordButton()
		{
		//for(var i = 0; i < document.getElementsByName('itemId').length; i++){
		//alert("document.getElementsByName('itemId').length"+document.getElementsByName('itemId').length +"document.getElementsByName('itemId')[i].value------"+document.getElementsByName('itemId')[i].value)
			if(document.getElementsByName('itemId').length==0){
					alert("Please Go to previous Record and then Click for next 1000 records.")
			return false;
		    }else{
				   return true; 
			   }
			}  
	
		function showReport()
		{	
		//alert("stockDetailsForm.nillStock.checked------"+stockDetailsForm.nillStock.checked)
		if(stockDetailsForm.nillStock.checked)
		{
		//alert("stockDetailsForm.nillStock.checked------"+stockDetailsForm.nillStock.checked)
		 stockDetailsForm.nillStock.value="true";
		}else{
			 stockDetailsForm.nillStock.value="false";
		}
		
		if(stockDetailsForm.nomenclatureVal.value != ""){
		//alert("stockDetailsForm.nomenclature.value----"+stockDetailsForm.nomenclatureVal.value)
			var val = stockDetailsForm.nomenclatureVal.value;
		    var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvms = val.substring(index1,index2);
			    if (pvms!="")
			    {
			    	document.getElementById("item_id").value=pvms;
			    	stockDetailsForm.method="post";
					submitProtoAjax('stockDetailsForm','stores?method=getStockDetail&currPage=0');
					document.getElementById("item_id").value="";
					stockDetailsForm.nomenclatureVal.value="";
					
				}
				else
				{
					alert("Pl. select the Nomenclature!....");
					return;
				}
	}else if(stockDetailsForm.pvmsVal.value != "")
	{ 
	  //alert("stockDetailsForm.pvms.value----"+stockDetailsForm.pvmsVal.value)
		stockDetailsForm.method="post";
		var pvms=document.getElementById("pvmsVal").value
			submitProtoAjax('stockDetailsForm','stores?method=getStockDetail&currPage=0');
		stockDetailsForm.pvmsVal.value="";
	}else{
	  submitProtoAjax('stockDetailsForm','stores?method=getStockDetail&currPage=0');
	}	
}


</script>
</head>

<body>
<form name="stockDetailsForm"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>"> <input
	type="hidden" id="item_id" name="item_id" size="5"> <input
	type="hidden" name="pageCount" size="5" value="10"> <input
	type="hidden" name="numOfRows" size="5" value="20"> <br />
<div id="contentspace">
<div style="float: left;">
<h2 align="left" class="style1">Stock Details</h2>
</div>
<br />


<div style="padding-left: 15px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Stock Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 660px; height: 83px; background-color: #f4f9fe;">
<br />
<label class="bodytextB">Nomenclature </label> <input type="text"
	id="nomenclatureVal" class="bigcaption1" name="nomenclatureVal" />
<div id="ac2update"
	style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclatureVal','ac2update','stores?method=getItemListForCompleteStockNomenclatureByAutocomplete',{parameters:'requiredField=nomenclatureVal'});
					</script> <br />

<label class="bodytextB">PVMS/NIV No: </label> <input type="text"
	id="pvmsVal" class="textbox_size20" name="pvmsVal" /> <label
	class="bodytextB">With Nill Stock: </label> <input type="checkbox"
	value="" id="nillStock" class="smcaption" name="nillStock" /> <br />
<br />
<br />
<input type="button" name="report" onClick="showReport();"
	value="Submit" class="button"></div>
</div>
</div>
<div id="testDiv"></div>
</form>
</body>
</html>