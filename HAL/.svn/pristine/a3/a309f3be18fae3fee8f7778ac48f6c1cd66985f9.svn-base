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
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>	
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	System.out.println("u r in modify OPD Patient Issue in stores jsp");
	List<StoreOpPatientIssueT> storeOPDIssueTList= new ArrayList<StoreOpPatientIssueT>();
	String issueNo = "";
	String service = "";
	try {
			if(map.get("storeOPDIssueTList")!=null)
			{
				storeOPDIssueTList=(List)map.get("storeOPDIssueTList");
			}
	} catch (Exception exp) {
			exp.printStackTrace();
	}
	
	if(storeOPDIssueTList.size() > 0){
		issueNo = storeOPDIssueTList.get(0).getOpIssue().getIssueNo();
		service = storeOPDIssueTList.get(0).getOpIssue().getServiceNo();
	}
	
	System.out.println(":::::::::::::::::"+service);
	String search = "n";
	if(map.get("search")!=null)
	{
		search =(String)map.get("search");
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
<div class="titlrBg">
<h2 >Modify Stock Details</h2>
</div>
<div class="clear paddingtop15"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<form name="modifyOPDPatientIssue" method="post"><br />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		if(storeOPDIssueTList != null)
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
		data_header[7][1] = "hide";
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
			Iterator iterator=storeOPDIssueTList.iterator();
		    int  i=0;
		          while(iterator.hasNext())
		           {    
		        	  String expiryDateInString=null;
		        	  String issueDateInString= null;
		        	  StoreOpPatientIssueT storeOpPatientIssueT= (StoreOpPatientIssueT)iterator.next();
		        	  StoreOpPatientIssueM storeOpPatientIssueM=(StoreOpPatientIssueM)storeOpPatientIssueT.getOpIssue();
		        	  String pvmsno=storeOpPatientIssueT.getItemIdIssue().getPvmsNo();
		        	  String nomenclature=storeOpPatientIssueT.getItemIdIssue().getNomenclature();
		        	  String batchNo=storeOpPatientIssueT.getBatchNo();
		        	  String brandName=storeOpPatientIssueT.getBrand().getBrandName();
		        	  Date expiryDate=storeOpPatientIssueT.getExpiryDate();
		        	  int brandId=storeOpPatientIssueT.getBrand().getId();
		        	  Date issueDate=storeOpPatientIssueT.getOpIssue().getIssueDate();
		        	  if(expiryDate != null) {
		        	  expiryDateInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
		        	  } else  {
		        		  expiryDateInString="";
		        	  }
		        	  if(issueDate != null) {
		        		  issueDateInString=HMSUtil.changeDateToddMMyyyy(issueDate);
		        	  } else {
		        		  issueDateInString="";
		        	  }
		        	 BigDecimal costPrice=new BigDecimal(""+storeOpPatientIssueT.getRate());
		        	 BigDecimal qtyIssued=new BigDecimal(""+storeOpPatientIssueT.getQtyIssued()); 
		        	  
		%>
			data_arr[<%= i%>] = new Array();
			data_arr[<%= i%>][0] =<%=storeOpPatientIssueT.getId()%>
			data_arr[<%= i%>][1] = '<input type="radio" style="width:15px; padding-left: 3px;" name="parent" value="<%= storeOpPatientIssueT.getId()%>" id="parent" />'
			<%
				if(pvmsno !=null || pvmsno !="") {
			%>
			data_arr[<%= i%>][2] = "<%=pvmsno%>"
			<% } else {	%>
			data_arr[<%= i%>][2] = ""
			<% }
			 if(nomenclature != null || nomenclature !="") { %>
			data_arr[<%= i%>][3]="<%=nomenclature%>"
			<% } else { %>
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
		formName = "modifyOPDPatientIssue"
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGrid(start,end);
</script>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" id="search" name="search" value="<%=search%>"> 
<input	type="hidden" id="opdIssueno" name="opdIssueno" value="<%=issueNo %>">
<input type="hidden" id="serviceNo" name="serviceNo"	value="<%=service%>"> 
<input type="button" name="add"	id="addbutton" value="Print" class="button"	onClick="submitForm('modifyOPDPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" /> 
<input type="button" class="button" value="Delete " align="left"  onClick="if(validateRadioForDelete()){submitForm('modifyOPDPatientIssue','stores?method=deleteStockDetails');}" />
<input type="button" class="button" value="Back" align="left"	onClick="if(<%=search.equals("y")%>){javascript:history.back()}else{cancelForm();}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> 

<script type="text/javascript">
	function cancelForm(){
	var search = document.getElementById('search').value
	if(search == "n"){
  	 close();
  	 } else {
  	 
  	 }
  	 
  	 
  	 
   	}
	function validateRadioForDelete(){
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select the Brand to Update the Stock ")
		return false;
	}

</script></form>
</div>
