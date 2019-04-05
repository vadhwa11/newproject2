

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
<form name="searchMedicalBoard" method="post" action="">
<h2>Medical Board waiting List </h2>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">

<label>Service No.</label>

<input name ="ServiceNo" id ="ServiceNo"  type="text">
<input type="button" name="reset" id="resetbutton" value="Search" class="button" onClick="GetMedicalBoardList('FILTER');" accesskey="r" tabindex=1 />
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
				<th id="th5" style='width: 100px;'>Med Cat</th>
				<th id="th6" style='width: 200px;'>Medical Board Type</th>
				<th id="th6" style='width: 100px;'>Contact No.</th>
				<th id="th6" style='width: 100px;'>Status</th>
				
			</tr>
			<tbody id="tblListOfMedicalBoard">		
			
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
			GetMedicalBoardList('ALL');
	
		});
		
function GetMedicalBoardList(MODE)
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
	var url = "medicalBoard?method=getListOfMedicalBoard";
	var bClickable = true;
	GetJsonData('tblListOfMedicalBoard',data,url,bClickable);
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
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].cat+"</td>";
			htmlTable = htmlTable +"<td style='width: 150px;'>"+jsonData[i].examType+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].contactNo+"</td>";
			htmlTable = htmlTable +"<td style='width: 200px;'>"+jsonData[i].ma_status+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='7'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}			
	
	$j("#tblListOfMedicalBoard").html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	showMedicalBoardDetails(Id);
}

function showMedicalBoardDetails(tempId)
{
	//alert(tempId);
	var array = new Array();
	array = tempId.split("~~~");
	var visitId = array[0];
	var medExamType = array[1];
	
	
	
	//window.location="medicalBoard?method=showInitialMedicalBoardMedExamJsp&visitId="+visitId+"&medExamType="+ExamType;
	
	if((medExamType=='Initial Medical Board AFMSF 15')||(medExamType=='Medical Board Review AFMSF 15')){
    	
    		window.location="medicalBoard?method=showInitialMedicalBoardMedExamJsp&visitId="+encodeURIComponent(visitId)+"&medExamType="+encodeURIComponent(medExamType);
    	
    }
    if((medExamType=='Medical Board AFMSF 16')){
    	
    		window.location="medicalBoard?method=showMedBoardMAForm16&visitId="+encodeURIComponent(visitId)+"&medExamType="+encodeURIComponent(medExamType);
    	
    }
    if(medExamType=='Form - 10'){
    	
    		window.location="medicalBoard?method=showMedBoardForm10&visitId="+encodeURIComponent(visitId)+"&medExamType="+encodeURIComponent(medExamType);
    	
    }
    
    //--by kiran
    if((medExamType=='Form-44')){
    	
    		window.location="medicalBoard?method=showMbForm44JSP&visitId="+encodeURIComponent(visitId)+"&medExamType="+encodeURIComponent(medExamType);
    	
    }
    if((medExamType=='Form-44 (Interim Category)')){
    	
    		window.location="medicalBoard?method=showMbForm44IntermeJSP&visitId="+encodeURIComponent(visitId)+"&medExamType="+encodeURIComponent(medExamType);
    	
    }
	
}


function showResultPage(pageNo)
{
	
	
	nPageNo = pageNo;	
	GetMedicalBoardList('FILTER');
	
}

function ShowAllList(pageNo)
{
	$j("#ServiceNo").val("");	
	$j("#pageno").val("");	
	nPageNo = pageNo;	
	GetMedicalBoardList('ALL');
}

function goToPageForPatient(pageNo)
{
	
	if(parseInt(TotalNumberOfPages)<parseInt(pageNo))
		{
		
			alert("Please enter correct page No.");
			return;
			
		}
	nPageNo = pageNo;	
	GetMedicalBoardList('FILTER');
}



</script>

