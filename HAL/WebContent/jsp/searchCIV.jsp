<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreDrugCost"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
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
<%

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
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreIssueM> searchList = new ArrayList<StoreIssueM>();
		try{
			searchList=(List)map.get("searchList");
			//searchDrugList=(List)map.get("searchDrugList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
	
		}
		List<MasManufacturer> manuList1 = new ArrayList<MasManufacturer>();
		if(map.get("manuList")!=null)
			manuList1 = (List) map.get("manuList");
		
		List  objectList= new ArrayList();
		if(map.get("objectList")!=null)
			{
			objectList=(List)map.get("objectList");
		}
	
	%>
	
	
	
	
<form name="createGrn" method="post" action="">

<div class="clear"></div>
<h6>SEARCH</h6>

<div class="clear"></div>


</form>


<div class="clear"></div>

<div class="clear"></div>





<!--  <div class="searchBlock" id="threadsearch_menu" style="display: none">-->


<!-- </div> -->
<!-- 
<jsp:include page="searchResultPO.jsp" />
-->
<jsp:include page="searchResultBlock.jsp" />
<form name="searchCiv" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>




</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= ISSUE_ID%>", "id"],,[1, "<%= RADIO_FOR_TABLE%>"],[2, "<%= ISSUE_NO%>"],[3, "<%= ISSUE_DATE%>"]];
	 statusTd =3;

</script>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input
					type="hidden" name="Add" type="submit" value="Add"
					class="button">
				<input
					type="hidden" name="Modify" type="submit" value="Modify"
					class="button"
					onClick="submitForm('searchDefectiveDrug1','stores?method=modifyDefectiveDrug');">
				<input
					type="hidden" name="Reset" type="submit" value="Reset"
					class="button">
				<input
					type="hidden" name="Delete" type="submit" value="Delete"
					class="button">
				<input
					type="hidden" name="print" type="submit" class="button"
					value="print " onClick="">
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
				
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "data";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"

		data_header[1] = new Array;
		data_header[1][0] = "CIV No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= ISSUE_NO%>"	
		
		data_header[2] = new Array;
		data_header[2][0] = "CIV Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= ISSUE_DATE%>"
		
		
		
		
		
	
		
		data_arr = new Array();
		
		<%String st="";
		          int  counter=0;
for(StoreIssueM storeIssueM:searchList)		           {           
		        	 // Object []  object = (Object[] )itr.next(); 
//		        	  StoreIssueM storeissueM=(StoreIssueM)itr.next();
		        	  
//		        	  System.out.println("lk"+object[0]+"-- "+ object[2]+"****>>>> "+object[3]);
		        	 // String ser=""+searchList.get(2);
		        	  
		             %>
		             		             data_arr[<%= counter%>] = new Array();
		             data_arr[<%= counter%>][0] = <%= ""+storeIssueM.getId()%>
		             data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= ""+storeIssueM.getId()%>" id="radio" />'
		             data_arr[<%= counter%>][2] = "<%=storeIssueM.getIssueNo()%>"
		             data_arr[<%= counter%>][3] = "<%=storeIssueM.getIssueDate()%>"
<%--//		             data_arr[<%= counter%>][3] = "<%=HMSUtil.changeDateToddMMyyyy((Date)object[3])%>"--%>

		<% counter++;
			}
		%>
		 
		formName = "searchCiv"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<script type="text/javascript">

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport();">
<input type="button" name="Modify" type="submit" value="Modify" 	class="button" onClick="if(requiredFields()){submitForm('searchCiv','stores?method=searchIssueCiv');}">

<script type="text/javascript">

function showReport()
{
 
  
 	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
	              //alert(document.getElementsByName('parent')[i].value)
                submitForm('searchCiv','stores?method=printIssueToDispensary&issueId='+document.getElementsByName('parent')[i].value);
                return true;
			  }		
  		}
  		alert("Please select the CIV No. !!!")
		return false;
  
}

function requiredFields(){
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
				  if(document.getElementsByName('parent')[i].checked == true)
	              {
	                return true;
				  }		
	  		}
	  		alert("Please select the  CIV  No. !!")
			return false;
	}
</script>
</form>