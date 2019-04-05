

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
    String pageTitle = "";
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
<h2>Medical Exam waiting List </h2>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">

<label>Service No.</label>

<input name ="ServiceNo" id ="ServiceNo"  type="text">
<input type="button" name="reset" id="resetbutton" value="Search" class="button" onClick="GetMedicalExamList('FILTER');" accesskey="r" tabindex=1 />
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
</div>
  <div class="Block" style="padding-top:20px;">
<div id="divSearchResult">

		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>
				
				
				</td>
				 <td style="width:80px;">
				
				<input id="pageno" type="text"  maxlength="4" name="pageno" style="width:25px;">
				<input class="button" type="button" onclick="goToPageForPatient(pageno.value)" value="Go" name="ok" style="width:35px;">
				</td> 
				</tr>
		</table>
			
  	<table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				
				<th id="th1" style='width: 100px;'>Visit Date</th>
				<th id="th2" style='width: 100px;'>Visit Time</th>
				<th id="th3" style='width: 120px;'>Service No.</th>
				<th id="th4" style='width: 120px;'>	Rank</th>				
				<th id="th5" style='width: 150px;'>Name</th>
				<th id="th5" style='width: 100px;'>Unit</th>
				<th id="th6" style='width: 200px;'>Medical Exam Type</th>
				<th id="th6" style='width: 100px;'>Contact No.</th>
				<th id="th6" style='width: 100px;'>Status</th>
				
			</tr>
			<tbody id="tblListOfMedicalExam">		
			
			</tbody>
			</table>
			

</div>
 <div id="pageNavPosition"></div>
 
</div>
</form>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js?n=1"></script>

<script language="javascript">
var nPageNo=1;

var $j = jQuery.noConflict();

$j(document).ready(function()
		{
			GetMedicalExamList('ALL');
	
		});
		
function GetMedicalExamList(MODE)
{
	
	var hospitalId = <%out.print(hospitalId);%>;
	var ServiceNo = $j("#ServiceNo").val();	

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&hospitalId="+hospitalId;
		}
	else
		{
		var data = "PN="+nPageNo+"&hospitalId="+hospitalId+"&ServiceNo="+ServiceNo;
		}
	var url = "medicalExam?method=getListOfMedicalExam";
	var bClickable = true;
	GetJsonData('tblListOfMedicalExam',data,url,bClickable);
}



function makeTable(jsonData)
{
	var htmlTable = "";
	for(i=0;i<jsonData.length;i++)
		{			
			
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"~~~"+jsonData[i].examType+"'>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].visitDate+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].visitTime+"</td>";
			htmlTable = htmlTable +"<td style='width: 100px;'>"+jsonData[i].serviceNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].rank+"</td>";
			htmlTable = htmlTable +"<td style='width: 120px;'>"+jsonData[i].name+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].unit+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].examType+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].contactNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].ma_status+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfMedicalExam").html(htmlTable);	
	
	
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
	var medExamType = array[1];
	
	
	//window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+ExamType;
	
	if(medExamType=='Primary/Extension Med. Exam(AFMSF-2A)'){
		window.location = "medicalExam?method=showPrimaryExtMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
    }else if((medExamType=='Annual Medical Exam(AFMSF-3B)')||(medExamType=='Prior To Proceedings Abroad Med. Exam(AFMSF-3B)')||(medExamType=='High Altitude Med. Exam(AFMSF-3B)'))
    {   
    	if(validateMetaCharactersExam(medExamType)){
    		window.location = "medicalExam?method=showAnnualMedExamJsp&visitId="+visitId+"&medExamType="+medExamType;
    	}
    }else if(medExamType=='Med. Exam On Release/Discharge(AFMSF-18)')
    {
    	if(validateMetaCharactersExam(medExamType)){
    		window.location = "medicalExam?method=showReleaseDischargeJsp&visitId="+visitId+"&medExamType="+medExamType;
    	}
    }else if(medExamType == 'Medical Case Sheet(AFMSF-7A)'){
    	window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
    	
    }else if(medExamType == 'Form-44(AFMSF-44)'){
    	window.location = "opd?method=showOPDMainJsp&visitId="+visitId;
    }	    
    else if(medExamType=='AFMSF-7A')
    { 
    	window.location = "medicalExam?method=showAFMSF7AJsp&visitId="+visitId+"&medExamType="+medExamType;
    }
    //-by kiran
    else if(medExamType == 'Form-44')
    {
    	window.location = "medicalExam?method=showMeForm44JSP&visitId="+visitId;
    }
   	
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetMedicalExamList('FILTER');
	
	
}

function ShowAllList(pageNo)
{
	$j("#ServiceNo").val("");	
	$j("#pageno").val("");	
	nPageNo = pageNo;	
	GetMedicalExamList('ALL');
	
}

function goToPageForPatient(pageNo)
{
	if(pageNo != "")
	{
		if(parseInt(TotalNumberOfPages)<parseInt(pageNo))
		{
		
			alert("Please enter correct page No.");
			return;
			
		}
	}
	else
		{
			alert("Please enter correct page No.");
			return;
		}
	
	nPageNo = pageNo;	
	GetMedicalExamList('FILTER');
}


</script>

