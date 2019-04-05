

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>


<%
    String pageTitle = "";
String toDate = "&nbsp;";
String fromDate = "&nbsp;";	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	if (map.get("toDate") != null) {
		toDate = (String)map.get("toDate");
	}
	if (map.get("fromDate") != null) {
		fromDate = (String)map.get("fromDate");
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
	//out.print("hospitalId="+hospitalId);
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}

%>
<form name="searchMedicalExam" method="post" action="">
<div class="titleBg">
<h2>Drug Expiry List </h2>
</div>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">
<label class="">From Date</label> 
<input type="text" id="fromDate" name="fromDate"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="From Date,date,no" onkeyup="mask(this.value,this,'2,5','/');" />


<label class="">To Date <span>*</span></label> 
<input type="text" id="toDate"  name="toDate"   MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="To Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />

<!-- <label>Expiry Duration</label>

<select name ="ddlExpiryPeriod" id="ddlExpiryPeriod"  onchange ="GetDrugExpiryList('FILTER');">
<option value="0">As on Date</option>
	<option value="29">Within 30 days</option>
	<option value="30">After 30 days</option>
	<option value="45">After 45 days</option>
	<option value="60">After 60 days</option>
	<option value="90">After 90 days</option>
	<option value="120">After 120 days</option>
	<option value="150">After 150 days</option>
</select> -->



<label>Mat Code: </label>
<%--<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv"  validate="PVMS/NIV No,alphanumeric1,no"/> --%> 
<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv" validate="PVMS/NIV NO.,string,no"  />
<input type="hidden" name="pvmsId" value="" id="pvmsId" validate="PVMS/NIV NO.,metachar,num,no" /> 
<div class="clear"></div>
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="large" name="nomenclature" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validateMetaCharacters(this.value))
{new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})};
</script> 
<input type="hidden"	value="" id="itemId"  name="itemId" /> 
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<!-- <input type="button" name="reset" id="resetbutton" value="Generate Report" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 /> -->


<input type="button" name="add" id="addbutton" value="Search" class="button" onClick="GetDrugExpiryList1('FILTER');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('searchMedicalExam','stores?method=generateDrugExpiryListReport&flag=p');" accesskey="a" tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Show All" class="button" onclick="GetDrugExpiryList('ALL');" accesskey="r" /> 
<!--  <div class="Block" style="padding-top:20px;"> -->

<div class="clear"></div>
<div class="paddingTop10"></div>
<div class="clear"></div>
<div id="divSearchResult">

		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>				
				</td>
				</tr>
		</table>
			
  	<table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>				
				<th id="th1" style='width: 100px;'>Mat Code</th>
				<th id="th2" style='width: 300px;'>Nomenclature</th>
				<th id="th3" style='width: 100px;'>A/U</th>
				<th id="th4" style='width: 120px;'>	Batch No</th>	
				<th id="th4" style='width: 100px;'>	Closing Stock</th>				
				<th id="th5" style='width: 150px;'>Expiry Date</th>			
			</tr>
			<tbody id="tblListOfDrugExpiry">
			</tbody>
			</table>			

</div>
 <div id="pageNavPosition"></div>
 

</form>


<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			GetDrugExpiryList('ALL');
	
		});
		
		function GetDrugExpiryList1(MODE)
		{
			nPageNo = 1;
			GetDrugExpiryList(MODE)
		}
		
function GetDrugExpiryList(MODE)
{
	
	var hospitalId = <%out.print(hospitalId);%>;
	var ddlExpiryPeriod = $j("#ddlExpiryPeriod").val();
	var pvmsNiv = $j("#pvmsNiv").val();
	var nomenclature=$j("#nomenclature").val();
	var fromDate=$j("#fromDate").val();
	var toDate=$j("#toDate").val();
	//alert("fromDate"+fromDate);
	

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&hospitalId="+hospitalId;
		}
	else
		{
		var data = "PN="+nPageNo+"&hospitalId="+hospitalId+"&fromDate="+fromDate+"&toDate="+toDate+"&pvmsNiv="+pvmsNiv+"&nomenclature="+nomenclature;
		
		}
	var url = "stores?method=getDrugExpiryList";
	var bClickable = false;
	GetJsonData('tblListOfDrugExpiry',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			//alert(jsonData);
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Pvms+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].Nonenclature+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].AU+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].Batch+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].ClosingStock+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].ExpiryDate+"</td>";
			
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfDrugExpiry").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	showMedicalExamDetails(Id);
}

function showMedicalExamDetails(tempId)
{
	//alert(tempId);
	var array = new Array();
	array = tempId.split("~~~");
	var visitId = array[0];
	var ExamType = array[1];
	
	
	window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+ExamType;
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetDrugExpiryList('FILTER');
	
}

function ShowAllList(pageNo)
{

	$j("#pvmsNiv").val("");
	$j("#nomenclature").val("");
	$j("#fromDate").val("");
	$j("#toDate").val();
	nPageNo = 1;	
	GetDrugExpiryList('ALL');
}



</script>

