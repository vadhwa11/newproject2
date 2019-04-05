<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import=" java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
   int issueNo =0;
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	System.out.println("u r in modify ward consumption jsp");
	List storeIpIssueTList= new ArrayList();
	try {
			if(map.get("storeIpIssueTList")!=null)
			{
			 storeIpIssueTList=(List)map.get("storeIpIssueTList");
			}
	} catch (Exception exp) {
			exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<div id="contentspace"><br />
<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>
<h2 align="left" class="style1">Modify Stock Details</h2>
<jsp:include page="searchResultBlockForIPD.jsp" />


<form name="modifyWardConsumption" method="post"><br />
<div style="padding-left: 15px;">
<div
	style="overflow: auto; overflow-x: hidden; border: 1px solid #737373; width: 950px; height: 250px;">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		if(storeIpIssueTList != null)
		{
	%> <script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.PVMS_NO%>"], [3,"<%= RequestConstants.NOMENCLATURE %>"], [4,"<%= RequestConstants.BATCH_NO %>"],[5,"<%= RequestConstants.BRAND_NAME %>"],[6,"<%= RequestConstants.DATE_OF_EXPIRY %>"],[7,"<%=RequestConstants.COST_PRICE%>"],[8,"<%= RequestConstants.QTY_IN_HAND %>"],[9,"<%=RequestConstants.ISSUE_QUANTITY%>"] ];
	 statusTd =9;
</script></div>
</div>
<!--  <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"></div>
</div>
<script type="text/javascript" language="javascript">
		data_header = new Array();
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "1%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "PVMS/NIV No"
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Nomenclature"
		data_header[2][1] = "data";
		data_header[2][2] = "20%";
		data_header[2][3] = "<%= RequestConstants.PATIENT_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Batch Number"
		data_header[3][1] = "data";
		data_header[3][2] = "7%";
		data_header[3][3] = "<%=RequestConstants.SERVICE_NUMBER %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Brand Name"
		data_header[4][1] = "data";
		data_header[4][2] = "8%";
		data_header[4][3] = "<%=RequestConstants.AGE %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Date Of Expiry"
		data_header[5][1] = "data";
		data_header[5][2] = "4%";
		data_header[5][3] = "<%=RequestConstants.SEX %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Issue Date"
		data_header[6][1] = "data";
		data_header[6][2] = "4%";
		data_header[6][3] = "<%=RequestConstants.PATIENT_DEPARTMENT %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Cost Price"
		data_header[7][1] = "data";
		data_header[7][2] = "4%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_DIAGNOSIS %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Quantity Issued"
		data_header[8][1] = "data";
		data_header[8][2] = "4%";
		data_header[8][3] = "<%=RequestConstants.DATE_OF_ADMISSION %>";
		
		data_arr = new Array();
		<%
			String st="";
		
			Iterator iterator=storeIpIssueTList.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {    
		        	  String expiryDateInString=null;
		        	  String issueDateInString= null;
		        	  StoreIpIssueT storeIpIssueT= (StoreIpIssueT) iterator.next();
		        	  StoreIpIssueM storeIpIssueM=(StoreIpIssueM)storeIpIssueT.getIpIssue();
		        	  issueNo = storeIpIssueM.getId();
		        	  String pvmsno=storeIpIssueT.getItem().getPvmsNo();
		        	  String nomenclature=storeIpIssueT.getItem().getNomenclature();
		        	  String batchNo=storeIpIssueT.getBatchNo();
		        	  String brandName=storeIpIssueT.getBrand().getBrandName();
		        	  Date expiryDate=storeIpIssueT.getExpiryDate();
		        	  int brandId=storeIpIssueT.getBrand().getId();
		        	  Date issueDate=storeIpIssueT.getIpIssue().getIpIssueDate();
		        	  if(expiryDate != null)
		        	  {
		        	  expiryDateInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
		        	  }else
		        	  {
		        		  expiryDateInString="";
		        	  }
		        	  if(issueDate != null)
		        	  {
		        		  issueDateInString=HMSUtil.changeDateToddMMyyyy(issueDate);
		        	  }
		        	  else{
		        		  issueDateInString="";
		        	  }
		        	 BigDecimal costPrice=new BigDecimal(""+storeIpIssueT.getRate());
		        	 BigDecimal qtyIssued=new BigDecimal(""+storeIpIssueT.getQtyIssued()); 
		        	  
		%>
			data_arr[<%= i%>] = new Array();
			data_arr[<%= i%>][0] =<%=storeIpIssueT.getId()%>
			data_arr[<%= i%>][1] = <%=i%>+1
			<%
				if(pvmsno !=null || pvmsno !="")
				{
			%>
			data_arr[<%= i%>][2] = "<%=pvmsno%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(nomenclature != null || nomenclature !="")
			   {
			%>
			data_arr[<%= i%>][3]='<%=nomenclature%>'
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(batchNo != null || batchNo !="")
			   {
			%>
			data_arr[<%= i%>][4] = "<%=batchNo%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }if(brandName != null || brandName != "")
			   {
			%>
			data_arr[<%= i%>][5] = "<%=brandName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			   }
			   if(expiryDateInString != null || expiryDateInString != "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=expiryDateInString%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(issueDateInString != null || issueDateInString != "" )
			   {
			%>
			data_arr[<%= i%>][7] = "<%=issueDateInString%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%
			   }
			   if(costPrice != null )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=costPrice%>"
			<%
			   }else{
			%>
			  data_arr[<%= i%>][8] = ""
			<%
			   }
			   if(qtyIssued != null)
			   {
			%>
			data_arr[<%= i%>][9] = "<%=qtyIssued%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<% 
		  	}
			i++;
		  }
		}else{
		%>
		  No records to display
  			<%
  		}
  
      %>
		formName = "modifyWardConsumption"
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGrid(start,end);
</script>
<div style="padding-left: 5px;"><input type="hidden"
	name="issueNo" id="issueNo" value="<%=issueNo%>"
	<input type="button" class="button" value="Back" align="left" onClick="cancelForm();" />
	<input type="button" class="button" value="Print" align="left" onClick="printForm();" /></div>


<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <script type="text/javascript">
	function cancelForm(){
  	 close();
   	}
   	function printForm(){
   	var issueNo = document.getElementById('issueNo').value
    modifyWardConsumption.method="post";
   	submitForm('modifyWardConsumption','ipd?method=showWardConsumptionReport&issueNo='+issueNo);
   	}


</script></form>
</div>
