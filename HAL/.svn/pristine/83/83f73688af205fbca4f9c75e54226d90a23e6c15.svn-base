<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	int itemId=0;
	String qtyRequested=""; 
	int rowVal=0;
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	String issueNo ="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List resultEntryDetailList= new ArrayList();
	if(map.get("resultEntryDetailList")!=null){
		resultEntryDetailList = (List) map.get("resultEntryDetailList");
	}
	List dgOrderHList= new ArrayList();
	if(map.get("dgOrderHList")!=null){
		dgOrderHList = (List) map.get("dgOrderHList");
	}
	String patientStatus="";
	if(map.get("patientStatus")!=null){
		patientStatus = (String) map.get("patientStatus");
	}
	
	String date="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<h2>Investigation Details</h2>
<title>Investigation Details</title>
<div id="contentHolder">



<form name="investgationForm" method="post">
<%if(dgOrderHList.size()>0){
		
		
		  
		  try{
			   DgOrderhd dgOrderHeader=(DgOrderhd)dgOrderHList.get(0);
			  
				String patientName="";
				if(dgOrderHeader.getHin().getPFirstName()!= null){
					patientName=dgOrderHeader.getHin().getPFirstName();
				}
				if(dgOrderHeader.getHin().getPMiddleName()!= null){
					patientName=patientName+" "+dgOrderHeader.getHin().getPMiddleName();
				}
				if(dgOrderHeader.getHin().getPLastName()!= null){
					patientName=patientName+" "+dgOrderHeader.getHin().getPLastName();
				}
				
					
				
				 
		  
	%>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="paddLeft55"><label>Patient Name</label> <label
	class="value"><%=patientName%></label> <label>Patient Status</label> <label
	class="value"><%=patientStatus%></label></div>
<div class="Clear"></div>
<div class="Height10"></div>
<table width="70%" colspan="7" class="tableHolderPopup"
	id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>


		<tr>
			<th>Investigation</th>
			<th>Result</th>
			<th>Result Date</th>
		</tr>
	</thead>
	<tbody>
		<%
		  Iterator itr =resultEntryDetailList.iterator();
			while(itr.hasNext()){
				List dgResultEntryDetailList=(List)itr.next();
				Iterator itr1=dgResultEntryDetailList.iterator();
				while(itr1.hasNext()){
				DgResultEntryDetail dgResultEntryDetail=(DgResultEntryDetail) itr1.next();
 		 %>

		<tr>
			<td><input type="text" readonly="readonly"
				value="<%=dgResultEntryDetail.getInvestigation().getInvestigationName() %>" />
			</td>
			<td><input type="text" readonly="readonly" name="result"
				value="<%=dgResultEntryDetail.getResult()%>" /></td>
			<td><input type="text" readonly="readonly" name="resultDate"
				value="<%=HMSUtil.changeDateToddMMyyyy(dgResultEntryDetail.getResultEntry().getResultDate())%>" />
			</td>
			<tr />
				<%}}}
  	 catch(Exception w){w.printStackTrace();}%>
			
	</tbody>
</table>



<div id="edited"></div>

<%}else{ %>
<h2><font id="error">Records not Found</font></h2>
<br />
<%} %> <input type="button" name="cancel" id="addbutton" value="Close"
	class="cmnButton" onClick="cancelForm();" accesskey="a" tabindex=1 /></form>
</div>
</div>

