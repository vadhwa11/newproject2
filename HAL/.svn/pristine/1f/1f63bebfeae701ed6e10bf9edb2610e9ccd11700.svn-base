<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.

 * Purpose of the JSP -  
 * @author  Vinay
 * Create Date: 16 May,2014 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%-- <%@page import="jkt.hms.masters.business.MasBudgetComponent"%> --%>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Cache-control", "no-store");
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);

%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%-- <%@ page import="jkt.hms.masters.business.MasHospitalDetails" %>
<%@ page import="jkt.hms.masters.business.MktBudgetHeader" %>
<%@ page import="jkt.hms.masters.business.MktBudgetDetails" %> --%>
<%-- <%@include file="csrfToken.jsp" %> --%>


<%@ page import="java.net.URL"%>



<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css?n=1" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/datePicker.css?n=1" />

 

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/lightbox-form.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/lightbox-form.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>


<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<%


    String Print = "N";
    if(request.getParameter("Print") != null)
    {
    	Print = request.getParameter("Print");
    }
	int locationId = 0;
	if (request.getParameter("locationId") != null) {
		locationId =  Integer.parseInt(request.getParameter("locationId"));
	}


    String pageTitle = "";
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
	if(map.get("subLedList") != null)
	 {
		 subledgerList =  (List<FaMasSubLed>)map.get("subLedList");		   
	 }	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	
	int userId = 0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	//out.print("User="+userId);
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	 
	 boolean bSuccessfullyAdded = false;
	 String message = "";
	 //String AUStockId = "";
	 
	 if(map.get("bSuccessfullyAdded") != null)
	 {
		 bSuccessfullyAdded =  (Boolean)map.get("bSuccessfullyAdded");
	 }
	 if(map.get("title") != null)
	 {
		 pageTitle =  (String)map.get("title");	  
		   
	  }	 
	 
	 if(map.get("message") != null)
	 {
		 message =  (String)map.get("message");	  
		   
	  }		
	 	 
	 
	  if(bSuccessfullyAdded)
	 {
			out.println("<h4 id='divResult' class='success'>"+message+"</h4>");
	 }
	 else
	 {
		 out.println("<h4 id='divResult' class='failure'>"+message+"</h4>");
	 } 
	}
	
	
	
	
	
	int departmentId = 0;
	if (session.getAttribute("departmentId") != null) {
		departmentId =  (Integer)session.getAttribute("departmentId");
	}
	
	int Id = 0;
	String TransactionType = "";
	
	if(request.getParameter("Id") != null)
	{
		Id  = Integer.parseInt(request.getParameter("Id"));
	}
	
	if(request.getParameter("TransactionType") != null)
	{
		TransactionType  = request.getParameter("TransactionType");
	}
	
	
%>
<html>
<head>
<title>Transaction History </title>
</head>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script language="javascript">


var $j = jQuery.noConflict();
</script>

<form name="TransactionHistory" id="frmTransactionHistory" method="post" action="" autocomplete="off">

<div class="page_title">Transaction Details </div>

<div class="Block">
<label class="medium7">SubLedger</label>
<select name ="ddlSubledgerList" id="ddlSubledgerList" onchange="GetTransactionDetails('FILTER'); showPrint();" >
<option value="0">Select</option>
	<%
	if(subledgerList.size()>0){
		for(FaMasSubLed subled :subledgerList){%>
			
		<option value="<%=subled.getId() %>" ><%=subled.getSubLedDesc() %></option>
		
	<%}
		}%>
</select>

<label>From:<span>*</span></label>
<input name="textfield3" type="text" validate="From date,string,yes" id="fromdate-pick" placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" maxlength='10' onchange="GetKSDAReqisitionList('FILTER');" />

<label>To:<span>*</span> </label>
<input name="textfield2" type="text" validate="To date,string,yes"   id="todate-pick" placeholder="DD/MM/YYYY" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'todate-pick');" maxlength='10' onchange="GetKSDAReqisitionList('FILTER');" />
<div class="clear" ></div>
<input type="button" name="reset" id="resetbutton" value="Show all" class="button" onClick="ShowAllList('1');" accesskey="r" tabindex=1 />
<!-- <input  type="button" name="reset" id="printbutton" value="Print"  class="button" onClick="printGrowerLedgerAccount();" accesskey="r" tabindex=1 /> -->
 <div class="clear" ></div>
 <div class="clear" style="padding-top: 30px;"></div>
 <div id="divTransactionDetails">

<table class="appContentContainer" align="center" cellspacing="0" cellpadding="0" borde="0">
	
	<tr><td>
		<table class="tblSearchActions" cellspacing="0" cellpadding="0" border="0" >
			<tr>
				<td class="SearchStatus" style="font-size: 13px;" width: 400px; align="left">Search Results</td>
				<td>
				<div id=resultnavigation></div>
				
				</td>
				
				
				
			</tr>
		</table>
	</td></tr>	
	<tr><td>
  <table id="tblSearchResultsHeader" class="tblSearchResultsHeader" cellspacing="0" cellpadding="0" border="0">
			<tr>
				
				<th style="width:80px;">Date</th>
				<th style="width:150px;">A/C Name</th>
				<th style="width:150px;">Subledger Name</th>
				<th style="width:100px;">Dr Amount</th>
				<th style="width:100px;">Cr Amount</th>
				<!-- <th>Transaction Type</th> -->
				<th style="width:200px;">Narration</th>
				<th style="width:100px;">Transaction By</th>
				
			</tr>
			
</table>
</td></tr>
<tr><td>
		<table id="tblListOfHistoryOfTransaction" class="tblSearchResults" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td colspan="6"><img src="/hms/jsp/images/dot.gif" width="1" height="200"/></td>
			</tr>
			
		</table>
</td></tr>	


          
        
</table>
</div>
</div>
<div class="clear" style="padding-top: 30px;"></div>

</form>
</html>
<script language="javascript">

var nPageNo=1;
$j(document).ready(function(){
	
	GetHistoryOfTransaction('ALL');
	
});


function GetHistoryOfTransaction(MODE)
{
	var TransactionType = '<% out.print(TransactionType);%>';
	var Id = <% out.print(Id);%>;
	var locationId = <%out.print(locationId);%>;

	if(MODE == 'ALL')
		{
			var data = "PN="+nPageNo+"&TransactionType="+TransactionType+"&Id="+Id+"&locationId="+locationId;
		}
	else
		{
		var data = "PN="+nPageNo+"&TransactionType="+TransactionType+"&Id="+Id+"&locationId="+locationId;
		}
	var url = "account?method=getTransactionHistory";
	var bClickable = false;
	GetJsonData('tblListOfHistoryOfTransaction',data,url,bClickable);
}

function GetTransactionDetails(MODE)
{
	
	var ddlSubledgerId = $j("#ddlSubledgerList").val();	
	var locationId = <%out.print(locationId);%>;
	var Id = <% out.print(Id);%>;
	var TransactionType= "S";
	var data="";

	if(MODE == 'ALL')
		{
			data = "PN="+nPageNo+"ddlSubledgerId=0&TransactionType="+TransactionType+"&locationId="+locationId;
		}
	else
		{
			 data = "PN="+nPageNo+"&ddlSubledgerId="+ddlSubledgerId+"&TransactionType="+TransactionType+"&locationId="+locationId+"&accountId="+Id;
		}
	var url = "account?method=getSubledgerTransactionDetails";
	var bClickable = true;
	GetJsonData('tblListOfHistoryOfTransaction',data,url,bClickable);
}


function makeTable(jsonData)
{
	var htmlTable = "<table id='tblListOfHistoryOfTransaction' class='tblSearchResults' cellspacing='0' cellpadding='0' border='0'>";
	for(i=0;i<jsonData.length;i++)
		{			
			
			htmlTable = htmlTable+"<tr id='"+jsonData[i].Id+"'>";
			htmlTable = htmlTable +"<td style=\"width:80px;\">"+jsonData[i].Date+"</td>";
			htmlTable = htmlTable +"<td style=\"width:150px;\">"+jsonData[i].Name+"</td>";
			htmlTable = htmlTable +"<td style=\"width:150px;\">"+jsonData[i].Subledname+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].DrAmount+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].CrAmount+"</td>";
			htmlTable = htmlTable +"<td style=\"width:200px;\">"+jsonData[i].Narration+"</td>";
			htmlTable = htmlTable +"<td style=\"width:100px;\">"+jsonData[i].LastChgBy+"</td>";
			
			htmlTable = htmlTable+"</tr>";
		}
	if(jsonData.length == 0)
		{
		   htmlTable = htmlTable+"<tr><td colspan='6'><img src='/hms/jsp/images/dot.gif' width='1' height='200'/></td></tr>";
		}
		htmlTable = htmlTable +"</table>";		
	
	$j("#tblListOfHistoryOfTransaction").parent().html(htmlTable);	
	
	
}

function executeClickEvent(Id)
{
	//ViewUpdateCentreBudget(Id);
}

function showResultPage(pageNo)
{
	nPageNo = pageNo;	
	GetHistoryOfTransaction('FILTER');	
}

function ShowAllList(pageNo)
{
	nPageNo = pageNo;		
	GetHistoryOfTransaction('ALL');
	
}

function printGrowerLedgerAccount()
{
	var locationId = <% out.print(locationId);%>;
	var accountId = <% out.print(Id);%>;
	var ddlSubledgerId = parseInt($j("#ddlSubledgerList").val());	
	/* alert(ddlSubledgerId);
	 */
	
	if(ddlSubledgerId!=0){
		obj = eval('document.TransactionHistory');
		obj.action ="account?method=printGrowerLedgerAccount&locationId="+locationId+"&Id="+ddlSubledgerId;
		var input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = tokenName;
	    input.value = tokenValue;
	    obj.appendChild(input);
		obj.submit();
	}else if(accountId!=0){
		obj = eval('document.TransactionHistory');
		obj.action ="account?method=printGrowerLedgerAccount&locationId="+locationId+"&accountId="+accountId;
		var inputId = document.createElement('input');
		inputId.type = 'hidden';
		inputId.name = tokenName;
		inputId.value = tokenValue;
	    obj.appendChild(inputId);
		obj.submit();
	}else{
		alert("Select Sub ledger.");
	}
	

}
function showPrint(){
	document.getElementById('printbutton').style.display='block';
}
</script>