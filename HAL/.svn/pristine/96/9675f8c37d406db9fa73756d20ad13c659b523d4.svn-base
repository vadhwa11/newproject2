<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreProformaHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
		<script type="text/javascript">


		function openPdf()
{
	for(var i = 0; i < document.getElementsByName('radio').length; i++){
		  if(document.getElementsByName('pId')[i].checked == true)
        {

          var proformaNo = document.getElementsByName('pNo')[i].value
          //alert(proformaId);
  			submitForm('proformaBApproval','stores?method=generateProformaBReport&proformaNo='+proformaNo);
          return true;
		  }
	}
	alert("Please select the Proforma  No. !!!")
	return false;

}
		</script>
		<script type="text/javascript">
function getSearchBlock()
{
document.getElementById('searchBlock').style.display = 'inline';
}
function closeSearchBlock()
{
document.getElementById('searchBlock').style.display = 'none';
}
</script>


<%
List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}

		orderDateOnly.append("/");

		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month);
		} else {
			orderDateOnly.append(month);
		}

		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
	%>
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

	System.out.println("this is in search part");

	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			System.out.println("i am in the map part");

		}
		List<StoreProformaHeader> gridProformaBnoList = new ArrayList<StoreProformaHeader>();
		List<StoreProformaHeader> gridProformaBnoList1 = new ArrayList<StoreProformaHeader>();

		try{
			if(map.get("storeProformaList")!=null){
				gridProformaBnoList=(List)map.get("storeProformaList");
			System.out.println("gridProformaBnoListList  in JSP "+gridProformaBnoList.size());
			}else{
				System.out.println("gridProformaBnoListList  in else part ");
			}
			if(map.get("storeProformaList1")!=null){
				gridProformaBnoList1=(List)map.get("storeProformaList1");
			System.out.println("gridProformaBnoListList  in JSP "+gridProformaBnoList1.size());
			}else{
				System.out.println("gridProformaBnoListList  in else part ");
			}
			}catch(Exception e){
		}

		String userName = "";
		if(session.getAttribute("userName") != null)
		{
			userName = (String)session.getAttribute("userName");
		}
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM/dd/yyyy");
	%>



<form name="searchDefectiveDrug" method="post" action="">


<!--<table class="tborder" width="100%" align="center">-->
<!--	<tr>-->
<!--		<td width="20%" nowrap="nowrap" class="vbmenu_control"-->
<!--			id="threadsearch"><a href="">Search</a> <script-->
<!--			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>-->
<!--		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>-->
<!---->
<!---->
<!--		-->
<!--			-->
<!--		-->
<!--		</td>-->
<!--	</tr>-->
<!--</table>-->



<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div id="searchBlock" style="display:none;">
<form name="createGrn" method="post">
<div class="clear"></div>
<h6>TRACK</h6>
<div class="Block">
	<label>From</label>
	<input type="text" name="fromDate" class="date" id="fromDate" value=""/>
	<img src="/hms/jsp/images/cal.gif"  width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchDefectiveDrug.fromDate,event)" />
	<label>To</label>
	<input type="text" class="date" name="toDate" id="toDate" value=""/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchDefectiveDrug.toDate,event)" />
<div class="clear"></div>


<label >Proforma SI No.</label>
<select name="<%=ENTRY_NO%>">
<option value="0">Select</option>
<%
   for (StoreProformaHeader storeProforma :gridProformaBnoList1 ) {
%>

			<option value=<%=storeProforma.getProformaNo()%>><%=storeProforma.getProformaNo()%></option>

			<%
					}
				%>
</select>

<input type="button" name="sss" class="button" value="TRACK" onClick="submitForm('searchDefectiveDrug','stores?method=searchProformaBEntryTrack');" />
<input name="button" type="button" class="button" onclick="closeSearchBlock();" value="CLOSE" />
</div>
</form>
</div>

<jsp:include page="searchResultPO.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>




</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<script type="text/javascript" language="javascript">

	formFields = [
			[0, "<%= ENTRY_ID%>", "id"],[1, "<%= ENTRY_NO%>"], [2,"<%= ENTRY_DATE%>"],[3,"<%=STATUS%>"] ];
	 statusTd =3;

</script>



<div class="Block">
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" name="gridId" id="gridId"  value="" >
<input
					type="hidden" name="Add" type="submit" value="Add"
					class="button">
				<input
					type="hidden" name="Modify" type="submit" value="Modify"
					class="button"
					onClick="submitForm('searchDefectiveDrug','stores?method=modifyDefectiveDrug');">
				<input
					type="hidden" name="Reset" type="submit" value="Reset"
					class="button">
				
				<input
					type="button" name="print" type="submit" class="button"
					value="print " onClick="openPdf();">
				
				<input
					type="button" name="exportExcel" type="submit" value="EXPORT TO EXCEL"
					class="buttonBig" onClick="openExcel();">

					<input type="button" name="sss1" class="button" value="BACK" onClick="submitForm('searchDefectiveDrug','stores?method=showProformaBEntryJsp');" />
					<input type="button" name="sss1" align="right" class="buttonBig2" value="SENT FOR COMMAND APPROVAL" onclick="approvalFun();"/>
<input type="button" name="sss3" class="button" value="TRACK"  onclick="getSearchBlock();"/>



					</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<script type="text/javascript" language="javascript">

		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "data";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%=RADIO_FOR_TABLE%>"

		data_header[1] = new Array;
		data_header[1][0] = "Proforma SI No."
		data_header[1][1] = "data";
		data_header[1][2] = "5%";
		data_header[1][3] = "<%= ENTRY_NO%>"

		data_header[2] = new Array;
		data_header[2][0] = "Proforma Date"
		data_header[2][1] = "data";
		data_header[2][2] = "5%";
		data_header[2][3] = "<%= ENTRY_DATE %>";

		data_header[3] = new Array;
		data_header[3][0] = "Status"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=STATUS %>";

		data_arr = new Array();

		<%
		System.out.println(gridProformaBnoList.size());
		String st="";
		Iterator itrrr=gridProformaBnoList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {
		        	  StoreProformaHeader  storeDefectiveDrugM = (StoreProformaHeader)itrrr.next();
		        	String rad="radio"+counter;
		             %>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= storeDefectiveDrugM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%=storeDefectiveDrugM.getProformaNo()%>" id="<%=rad%>"  onclick="checkRadio(<%=counter%>);"/>'
			data_arr[<%= counter%>][2] = "<%=storeDefectiveDrugM.getProformaNo()%>"
			data_arr[<%= counter%>][3]="<%= formatter.format(storeDefectiveDrugM.getProformaDate())%>"

				<%if(storeDefectiveDrugM.getStatus().equals("y")){%>
						data_arr[<%= counter%>][4]="Active"
						<%}else{%>
						data_arr[<%= counter%>][4]="InActive"
						<%}%>
		<% counter++;
			}
		%>

		formName = "searchDefectiveDrug3"


		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);

		intializeHover('searchresulttable', 'TR', ' tableover');
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<script type="text/javascript">
function checkRadio(val)
{

	document.getElementById('gridId').value=document.getElementById('radio'+val).value;
}
</script>
<script type="text/javascript">
function openPdf()
{

            if(document.getElementById('gridId').value==''){
            	alert("Please select the Proforma  No. !!!")
				return false;
          }else{
        	   var proformaNo = document.getElementById('gridId').value;

       			submitForm('searchDefectiveDrug','stores?method=generateProformaBReport&proformaNo='+proformaNo);
               return true;

          }

}


function openExcel()
{

            if(document.getElementById('gridId').value==''){
            	alert("Please select the Proforma  No. !!!")
				return false;
          }else{
        	   var proformaNo = document.getElementById('gridId').value;

       			submitForm('searchDefectiveDrug','stores?method=ExportExcelForPerformaB&proformaNo='+proformaNo);
               return true;

          }

}


</script>

<script type="text/javascript">
function approvalFun(){
    if(document.getElementById('gridId').value==''){
    	alert("Please select the Proforma  No. !!!")
		return false;
  }else{
	   var proformaNo = document.getElementById('gridId').value;
		ajaxFunctionForApprovalUpdate('searchDefectiveDrug','stores?method=updateApprovedData&proformaNo='+ proformaNo);

  }
}
</script>
<script type="text/javascript">
	function ajaxFunctionForApprovalUpdate(formName,action)
	{
		  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	for (loop = 0; loop < items.childNodes.length; loop++)
	      	{
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        alert(id.childNodes[0].nodeValue);
	      }
	    }
	  }
	}
	</script>
</form>