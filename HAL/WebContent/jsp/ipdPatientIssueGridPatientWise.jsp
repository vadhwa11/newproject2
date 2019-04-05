<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%><script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
 -->
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);


 function fillId(i)
{
	  var value = document.getElementById('detailsId'+i).value+"-"+parseInt(window.opener.document.getElementById('currentRowNum').value);
	  var currentRowNum = parseInt(window.opener.document.getElementById('currentRowNum').value);
	  var qtyIssued =0;
	  if(window.opener.document.getElementById("qtyIssued"+currentRowNum).value.trim() != "")
		  {
		  qtyIssued = parseInt(window.opener.document.getElementById("qtyIssued"+currentRowNum).value);
		  }
	 if(document.getElementById("detailsId"+i).checked)
		 {
		 
		 if((qtyIssued + parseInt(document.getElementById("qtyPrescription"+i).value)) > parseInt(window.opener.document.getElementById("stockAvailable"+currentRowNum).value))
			 {
			  alert("Not Enough Stock!");
			  document.getElementById("detailsId"+i).checked =false;
			  
			 }
		 else
			 {
			 window.opener.valCheckBox.push(value);	 
			 window.opener.document.getElementById("qtyIssued"+currentRowNum).value = qtyIssued + parseInt(document.getElementById("qtyPrescription"+i).value);
			 }
		 
		 
		 
		 }
	 else
		 {
		 window.opener.valCheckBox = window.opener.valCheckBox.filter(item => item !== value);
		 window.opener.document.getElementById("qtyIssued"+currentRowNum).value = qtyIssued - parseInt(document.getElementById("qtyPrescription"+i).value);    
		 	
		 }
	 window.opener.document.getElementById('selectedDetailsId').value =window.opener.valCheckBox; 
	 checkQty(currentRowNum);
	 checkRC(currentRowNum);
	
	} 
 function init()
 {
	 
 for(var i=1; i<=parseInt(document.getElementById('listsize').value); i++)
	 {
	 for(var j=0; j<window.opener.valCheckBox.length; j++)
	 {
	  if(parseInt(document.getElementById("detailsId"+i).value)==parseInt(window.opener.valCheckBox[j].split("-")[0]))
		  {
		  if(parseInt(window.opener.valCheckBox[j].split("-")[1]) == parseInt(window.opener.document.getElementById('currentRowNum').value))
			  {
			  document.getElementById("detailsId"+i).checked = true;
			  }
		  else
			  {
			  var tbl = document.getElementById('patientIssueDetails');
			  tbl.rows[i].style.display="none";
			  }
		  
		  }
	 }
	 }
 }
</script>

<body onload="init()">
<%
	 int pageNo=0;
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));

	}
	int deptId=0;
	if (map.get("deptId") != null) {
		deptId = Integer.parseInt(""+map.get("deptId"));

	}
	Map mapItem=new HashMap();
	if(map.get("mapItem")!=null){
		mapItem=(Map)map.get("mapItem");
	}
	
	//System.out.println("deptId "+deptId);
	//	int deptId = (Integer)map.get("deptId");
	//	String date=(String)map.get("date");
	//	String time=(String)map.get("time");
	//	String fromDateToDate=(String)map.get("fromDateToDate");
	List listOfItemsInStock=new ArrayList();
	List listOfItemsStockInStock=new ArrayList();
	List itemList= new ArrayList();
	List issueNoList= new ArrayList();
	List empList= new ArrayList();
	List listOfItemsStock=new ArrayList();
	String date="";
	List<PatientPrescriptionDetails>  presList = new ArrayList<PatientPrescriptionDetails>();
	String time="";
	int hinId=0;
	String buttonFlagForNext="";
	String hinNo="";
	String prescription="";
	int consultantId=0;
	int consultantFromIssue = 0;
	String prescriptionNo = "";
	String serviceNo="";
	List<Object[]> stockInHandList = new ArrayList<Object[]>();
	List<StoreOpPatientIssueM> issueList = new ArrayList<StoreOpPatientIssueM>();
	try {

			if(map.get("listOfItemsInStock") != null){
				listOfItemsInStock=(List)map.get("listOfItemsInStock");
			}
			if(map.get("listOfItemsStock") != null){
			
				listOfItemsStock=(List)map.get("listOfItemsStock");
				
			}
			if(map.get("listOfItemsStockInStock")!=null){
				listOfItemsStockInStock=(List)map.get("listOfItemsStockInStock");
			}
			if (map.get("itemList") != null) {
				itemList = (List)map.get("itemList");
			}
			if (map.get("issueNoList") != null) {
				issueNoList = (List)map.get("issueNoList");
			}
			if (map.get("date") != null) {
				date = (String)map.get("date");
			}
			if (map.get("time") != null) {
				time = (String)map.get("time");
			}
			if (map.get("hinId") != null) {
				hinId = (Integer)map.get("hinId");
			}
			if (map.get("hinNo") != null) {
				hinNo = (String)map.get("hinNo");
			}
			if(map.get("serviceNo")!=null)
			{
				serviceNo=(String)map.get("serviceNo");
			}
			if (map.get("prescription") != null) {
				prescription = (String)map.get("prescription");

			}
			if (map.get("consultantId") != null) {
				consultantId = (Integer)map.get("consultantId");

			}
			if(map.get("empList") != null)
			{
				empList=(List)map.get("empList");

			}
			if (map.get("buttonFlag") != null) {
				buttonFlagForNext = (String)map.get("buttonFlag");
			}
			else{
				buttonFlagForNext="empty";
			}
			if(map.get("presList") != null){
				presList = (List<PatientPrescriptionDetails>)map.get("presList");
			}
			if(map.get("stockInHandList") != null){
				stockInHandList = (List<Object[]>)map.get("stockInHandList");
			}
			if(map.get("issueList") != null){
				issueList = (List<StoreOpPatientIssueM>)map.get("issueList");
			}
			
			StoreOpPatientIssueM opPatientIssueM = new StoreOpPatientIssueM();

			if(issueList.size() > 0){
				opPatientIssueM = issueList.get(0);
				prescriptionNo = opPatientIssueM.getPrescriptionNo();
				//consultantFromIssue = opPatientIssueM.getEmp().getId();
			}
	} catch (Exception exp) {
		exp.printStackTrace();
	}



	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null)
	{
		frequencyList=(List)map.get("frequencyList");
	}
	%>
	



 
<div id="testDiv">
<input type="hidden"	name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		 List opdIssueNo=(List)map.get("opdIssueNo");
		 StoreFyDocumentNo storeFyDocumentNo= new StoreFyDocumentNo();
		 int storeFyDocumentNoId =0 ;
		 if(opdIssueNo.size() > 0){
			 storeFyDocumentNo = (StoreFyDocumentNo)opdIssueNo.get(0);
			  storeFyDocumentNoId = storeFyDocumentNo!=null ? storeFyDocumentNo.getId():0;
		 }
		//String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	%>
<div class="Block">

<%
String visitNo = "";
int prescription_No=0;
String doctorName=" ";
String pre_date="";
String pre_time="";

int empId=0;

PatientPrescriptionHeader prescriptionHeader=null;
/*if(presList.size() >0){
for(PatientPrescriptionDetails prescriptionDetails : presList)
	prescriptionHeader=prescriptionDetails.getPrescription();   	

    prescriptionHeaderId=prescriptionHeader.getId();
     if(prescriptionHeader.getVisit().getDoctor()!=null)
	 visitNo =""+ prescriptionHeader.getVisit().getVisitNo();
		if(prescriptionHeader.getVisit().getDoctor()!=null)
			consultantId = prescriptionHeader.getVisit().getDoctor().getId();
		if(prescriptionHeader.getPrescriptionNo()!=null)
		prescription_No=prescriptionHeader.getPrescriptionNo();
		if(prescriptionHeader.getVisit().getDoctor()!=null)
		doctorName=prescriptionHeader.getVisit().getDoctor().getFirstName()+" "+presList.get(0).getPrescription().getVisit().getDoctor().getLastName();
		if(prescriptionHeader.getPrescriptionDate()!=null)
		pre_date=""+prescriptionHeader.getPrescriptionDate();
		if(prescriptionHeader.getPrescriptionTime()!=null)
		pre_time=prescriptionHeader.getPrescriptionTime();	
}*/
	%>
	
	<!-- <label> MO</label> -->


<!--<select name="specialty">
<option value="AMA">AMA</option>
<option value="physician">physician</option>
</select>	
-->

<div class="Clear"></div>


<input type="hidden" name="serviceNo" id="serviceNoNo" value=""/>
<input type="hidden" name="hinNoS" value="<%=hinNo%>"/>
<input type="hidden" name="serviceNoS" value="<%=serviceNo%>"/>

<%
%>

<div class="Clear"></div>
</div>
<input type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId" value="<%=storeFyDocumentNoId%>"  />
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->

<!--<label>Page No</label>
<label class="value"><%=pageNo%></label>

-->

<div class="Clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<input type="hidden" value="<%=deptId %>" name="deptId" id="deptId" />
<input type="hidden" value="" name="empId" id="empId" />
<input type="hidden" value="<%=hinId %>" name="hinId" id="hinId" />
<input type="hidden" value="" name="prescription" id="prescription" />
<input type="hidden" name="date1" id="date" value="<%=date %>" />
<input type="hidden" name="time1" id="time" value="<%=time %>" />
<input type="hidden" name="changeBy" id="changeBy" value="<%=userName %>"/>
<input type="hidden" name="opdIssueMasterId" id="opdIssueMasterId" value="" />
<div class="Clear"></div>
<!--<h4>Ward Consumption Details</h4>-->
	<%
	int i=1;
	int presHdId = 0;
	if(presList.size() > 0){ %>
<!--<input type="button" name="delete" value="" class="buttonDel" onclick="removeRowPrescription();" align="right" />
	 <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowPrescription();" value=" "	

align="right" />

-->
<!--<div id="searchresults" tabindex=1>
<jsp:include page="searchResultPO.jsp" />
<div id="searchtable"></div>
--><div class="Clear"></div>
<div  class="cmntable">
	<table width="100%" colspan="7" id="patientIssueDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Select</th>
			<!-- 
			<td width="10%">
			<label valign="left" class="smalllabel">Lot Number</label>
			</td>  
			-->
			<th width="5%">Patient</th>
			<th width="5%">Bed No</th>
			<th width="5%">Mat Code</th>
			<th width="10%">Nomenclature</th>

			<th width="2%">Qty </br>Prescribed</th>
		
		</tr>
	</thead>
	<tbody>
	<%
	System.out.println("presList.size"+presList.size());
	    String pname ="";
		for(PatientPrescriptionDetails prescriptionDetails : presList){
		int qtyIssued = 0;
		
		if(prescriptionDetails.getQtyIssued() != null){
			qtyIssued = prescriptionDetails.getQtyIssued();
		}
		presHdId = prescriptionDetails.getPrescription().getId();

		int qtyPending =0;
		BigDecimal totalQty=new BigDecimal(0);
		
		Iterator itr= listOfItemsStock.iterator();
			
			while(itr.hasNext())
			{
				 Object[] pair = (Object[]) itr.next();
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		 if(pair[1]!=null){
	         	   totalQty=new BigDecimal((pair[1].toString()));
	         		 }
	         	 }
			} 
			
			
			Iterator itrsis=listOfItemsStockInStock.iterator();
			BigDecimal totalStockQty=new BigDecimal(0);
			while(itrsis.hasNext())
			{
				 Object[] pair = (Object[]) itrsis.next();
				if(pair[0]!=null)
				{
	         	 int itemId=Integer.parseInt(pair[0].toString());
	         	 if(itemId==prescriptionDetails.getItem().getId())
	         	 {	 
	         		 if(pair[1]!=null){
	         		totalStockQty=new BigDecimal((pair[1].toString()));
	         		 }
	         	 }
				}
			}
	
		int totalPresQty = 0;
		if(prescriptionDetails.getTotal()!=null){
			totalPresQty = prescriptionDetails.getTotal();
		}
				qtyPending =totalPresQty -  qtyIssued;
		if(prescriptionDetails.getPrescription().getHin().getPFirstName()!=null){
			pname = prescriptionDetails.getPrescription().getHin().getPFirstName();
				}		
		if(prescriptionDetails.getPrescription().getHin().getPMiddleName()!=null){
			pname += prescriptionDetails.getPrescription().getHin().getPMiddleName();
				}
		if(prescriptionDetails.getPrescription().getHin().getPLastName()!=null){
			pname += prescriptionDetails.getPrescription().getHin().getPLastName();
				}
	%>
<tr>
            <td width="5%"><input type="checkbox" size="2" value="<%=prescriptionDetails.getId()%>" id="detailsId<%=i%>" name="detailsId<%=i%>" onchange="fillId(<%=i%>)"/>
			<%-- <td width="5%"><input type="text" size="2" value="<%=i%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /> --%>
			<input type="hidden" size="2" value="<%=prescriptionDetails.getId()%>" id="patientPrescriptionDtId<%=i%>" name="patientPrescriptionDtId<%=i %>" readonly="readonly" />
			</td>
			<td><input type="text" size="40" value="<%=pname%>" id="bedNo<%=i%>" name="bedNo<%=i %>" readonly="readonly" /></td>
			<td><input type="text" size="10" value="<%=prescriptionDetails.getPrescription().getInpatient().getBed().getBedNo()%>" id="patientName<%=i%>" name="patientName<%=i %>" readonly="readonly" /></td>
			<td width="5%"><input type="text" size="10" value="<%=prescriptionDetails.getItem().getPvmsNo() %>" name="pvmsNo" readonly="readonly" id="pvmsNo<%=i%>" />
			<input type="hidden" name="itemId<%=i %>" id="itemId<%=i %>" value="<%=prescriptionDetails.getItem().getId() %>" />
			</td>
			<td width="10%"><input type="text" size="50" value="<%=prescriptionDetails.getItem().getNomenclature() %>" tabindex="1" name="nomenclature<%=i%>" id="nomenclature<%=i%>"readonly="readonly" />
			<input type="hidden" name="itemId" id="itemId<%=i %>"	value="<%=prescriptionDetails.getItem().getId() %>" />
		
			<td width="5%"><input type="text" size="6" value="<%=prescriptionDetails.getTotal() %>" name="qtyPrescription" readonly="readonly" id="qtyPrescription<%=i%>" /></td>			
		
		

		</tr>
		<%i++;
		}%>
		</tbody>
		</table>
		<div class="Clear"></div>
		</div>
		<div class="Clear"></div>
	<%}%>
	

</div>
</div>
<input type="hidden" name="listsize" id="listsize"	value="<%=(i-1)%>" />

<input type="hidden" name="presHdId" id="presHdId" value="<%=presHdId %>"/>


<!-- <input type="button" name="save"	value="Save" class="button" onclick="fillPrescribeBy();" />

<input type="button" name="reset"	value="Next Prescription" class="buttonBig"  

onclick="fillPrescribeBy();" />-->
<!-- 
<input type="button" class="button" value="Send for Lp" 

onclick="if(checkSendForLP()){submitForm('opdPatientIssue','stores?method=submitDispensaryForLp');}"	align="right" />
 -->
  <%-- <%if(deptId!=24){ %>
 <input type="hidden" class="button" value="Send for Lp" 
onclick="submitForm('opdPatientIssue','stores?method=submitDispensaryForLpWithBarCode')"	align="right" />
<%}%>
<input type="hidden" name="add"	id="addbutton" value="Print" class="button"	

onClick="submitForm('opdPatientIssue','stores?method=generateOpdPatientIssueReport','checkTargetForYes');" accesskey="g" />
<input type="button" name="add"	id="addbutton" value="Print Previous Prescription" class="buttonBig2"	onClick="submitForm('opdPatientIssue','stores?method=printPatientIssue');" accesskey="g" /> --%>
<%--<input type="hidden" class="button" value="Delete"	onclick="openPopupForDelete('<%=opdIssuenoIncremented%>');" 

align="right" />--%>	

<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>
<input type="hidden" name="changeDate" id="changeDate" value="<%=date %>"/>
<label>Changed Time:</label>
<label class="value"><%=time%></label>
<div class="Clear"></div>
</div>
<input type="hidden" name="rows" id="rr" value="1" />
</body>
<style>
.rcDiv {width:180px; float:left; padding:0px;}
.rcDiv span {float: left; width: 47px; margin-left: 2px; padding-top:3px; color:#000;}

</style>
