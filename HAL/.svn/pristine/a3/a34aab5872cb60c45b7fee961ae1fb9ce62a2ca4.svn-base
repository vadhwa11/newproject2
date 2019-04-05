
<%@page import="java.util.*"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.StoreSetup"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>

<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
//<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
 //-->
function isDispenserySelected()
	{

		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Dispensery Name...!")
			return false;
		}
		else
		{
			submitProtoAjax('issueDispensaryForm','stores?method=getDemandList&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}
	function confirm1()
{
	formName="issueDispensaryForm";
	obj = eval('document.'+formName);
	var test = false;
	if((document.getElementById('departmentIdTemp').value != ""))
	{
	if(document.getElementById('requestNo').value != ""){
       test = true;
    }else{
    	alert("Pl. select Demand No!.........")
		return false;
    }
    }
	else
	{
		alert("Pl. check the Input Values!.........")
		return false;
	}
	
	if(test){
	  if(confirm("Are You sure, You want to import Demand items for issue?")){
        obj.action = "/hms/hms/stores?method=searchInternalIndentDetails";
    	obj.submit();
     }	
	}
	
}


</script>
 <script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<%
	Map map = new HashMap();
	String userName="";
	String date="";
	String time="";
	String deptName="";

	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	String message = "";
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Object[]> indentTList=new ArrayList<Object[]>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	StoreSetup storeSetup = new StoreSetup();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Box box=HMSUtil.getBox(request);
	int requestNoForAcc=0;
	String demandNoSelected="";
	if(map.get("requestNoForAcc")!=null){
		requestNoForAcc = (Integer) map.get("requestNoForAcc");
		demandNoSelected=""+requestNoForAcc;
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
		}
		 int requestByEmpId=0;
		 if(map.get("requestByEmpId")!=null){
			 requestByEmpId = (Integer) map.get("requestByEmpId");
			}
		if(map.get("storeSetup")!=null)
			storeSetup = (StoreSetup) map.get("storeSetup");
		if(map.get("storeInternalIndentTList")!=null)
			storeInternalIndentTList = (List) map.get("storeInternalIndentTList");
		
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
		}
		//if(map.get("issueTList")!=null){
		//	issueTList=(List)map.get("issueTList");
		//}
		if(map.get("deptName")!=null){
			deptName=(String)map.get("deptName");
	}
		if(map.get("indentTList")!=null){
			indentTList=(List)map.get("indentTList");
		}
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		List stockList= new ArrayList();
		if(map.get("stockList")!=null){
			stockList=(List)map.get("stockList");
		}
		List loanOutQtyList= new ArrayList();
		if(map.get("loanOutQtyList")!=null){
			loanOutQtyList=(List)map.get("loanOutQtyList");
		}
		int totalPages=0;
		 if(map.get("totalPages")!=null){
			 totalPages=(Integer)map.get("totalPages");
			}
		 if(storeInternalPendingIndentList !=null){
				storeInternalPendingIndentList = (List)map.get("storeInternalPendingIndentList");
			}
			List<Object[]> storeInternalIndentPendingList = new ArrayList<Object[]>();
			if(storeInternalIndentPendingList !=null){
				storeInternalIndentPendingList = (List)map.get("storeInternalIndentPendingList");
			}
		if(map.get("storeInternalIndentMList")!=null){
			storeInternalIndentMList=(List<StoreInternalIndentM>)map.get("storeInternalIndentMList");
		}
		List<Object[]> storeInternalIndentMPOList = new ArrayList<Object[]>();
		if(map.get("storeInternalIndentMPOList")!=null){
			storeInternalIndentMPOList=(List)map.get("storeInternalIndentMPOList");
		}
		if(map.get("searchListForPopup")!=null){
			searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
		}
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(map.get("issueId")!=null)
			 issueId = Integer.parseInt(""+map.get("issueId")) ;
		 String messageTOBeVisibleToTheUser ="";
			
			if(map.get("messageTOBeVisibleToTheUser")!=null){
				messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
			}
			String messageType ="";
			if(map.get("messageType")!=null){
				messageType=(""+map.get("messageType"));
			}
			String demandIndentDate="";
			if(map.get("demandIndentDate")!=null){
				demandIndentDate = (String) map.get("demandIndentDate");
			}
%>


<%-- Start of Content Div --%>
<form name="issueDispensaryForm" method="post">
<input type="hidden" value="<%=deptId %>" name="deptId" id="deptId" />

<%-- Start of Main Form --%>
<%-- Title --%>
<%if(deptId==35){ %>
<div class="titleBg"><h2>Issue Department</h2></div>
<%}else{ %>
<div class="titleBg"><h2>Issue CIV</h2></div>
<%} %>
<div class="Clear"></div>	
<!-- -
<div id="update">
<% int  counter=0; int slNumber = 0;%>
<div id="pageNavPosition"></div>
<h4>Pending Indent</h4>
<div class="clear"></div>
<%if (storeInternalIndentPendingList != null && storeInternalIndentPendingList.size() > 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>Sl.No.</th>
		<th>Demand No</th>
		<th>Demand Date</th>
		<th>From Dept</th>
		<th>To Dept</th>
		<th>Requested By</th>
	</tr>
	<tbody id="tableData">
		<%
			String klass = "even";

		 		for (Iterator iterator = storeInternalIndentPendingList.iterator(); iterator
					.hasNext();) {
				Object[] objects = (Object[]) iterator.next();

				Date date11=  (Date)objects[2];
				String dd=HMSUtil.convertDateTypeToStringWithoutTime(date11);
		 		String id = "";
		 		id = "id" + counter;
		 		counter++;
		 		slNumber = slNumber + 1;
		 		if(counter%2==0){
		 			klass = "even";
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}

		%>

		<tr class=<%= klass%> id="<%=counter%>">
			<td><%=slNumber%></td>
			<td><%=objects[1]%></td>
			<td><%=dd%></td>
			<td><%=objects[3]%></td>
			<td><%=objects[4]%></td>
			<td><%=objects[5]%></td>
		</tr>

		<%
		  	}
		  	%>
	</tbody>
</table>
<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>"/>
<script>
			var pager = new Pager('tableData',2);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script>
<div class="clear"></div>
<label>&nbsp;</label> <%
		 }
		else{
		%>
<h4><span>No Record Exists</span></h4>
<div class="clear"></div>
<%}%>
</div> -->
<%--------------- Start of Search Panel ---------------------------%>

<div class="Clear"></div>
<%-------------------- End of Search Panel ---------------------------%>
	
<%--------------------Start of Status message  ---------------------------%>
	<%if(!(messageTOBeVisibleToTheUser.equals("") ) || (messageTOBeVisibleToTheUser !=null) ){
				if(messageType.equals("success")){%>
<h4><%=messageTOBeVisibleToTheUser %></h4>
			<%}%>
	<%if(messageType.equals("failure")){%>
<h4>	<%=messageTOBeVisibleToTheUser %></h4>
				<%}}%>
	<%--------------------End of Status message  ---------------------------%>
	
<input type="hidden" name="rows" id="rr" value="1"/>
<input type="hidden" name="listSize" value="<%=listSize%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="<%=RequestConstants.ISSUE_ID%>" id="issueId" value="<%=issueId%>" />

<div class="Clear"></div>	

<h4>Issue Details</h4>
<div class="Block">
<%if(deptId==35){ %>
<label> Dispensary Issue No </label>
<%}else{ %>
<label> CIV No. </label>
<%} %>
<%if(map.get("max")!= null){ %>
<input type="text" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo" value="<%=max%>" MAXLENGTH="8" readonly  />
	  	  	   	<%}else{ %>
<input type="text" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo" value="<%=box.get("issueNo")%>"    MAXLENGTH="8" readonly/  >
	  	  	    <%} %>
<%if(deptId==35){ %>
<label>Issue Date</label>
<%}else{ %>
<label>CIV Date</label>
<%} %>

<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="<%= RequestConstants.ISSUE_DATE %>" readonly="readonly" value="<%=date %>"  MAXLENGTH="30" />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.issueDispensaryForm.<%=RequestConstants.ISSUE_DATE%>,event)" />

<label>Issue To</label>
<select name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" tabindex="1" id="departmentIdTemp" validate='Dispensery Name,num,Yes' onChange="isDispenserySelected();" >
				<option value="">Select</option>
				<%for (MasDepartment department :departmentList ) {	%>
					<option value=<%=department.getId()%> <%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
				<%}	%>
</select>
<div class="clear"></div>
 <label>Demand Date</label>
 <%
 if(demandIndentDate!=""){
	 %>
	 <input type="text" tabindex="1" name="<%= REQUEST_DATE %>" readonly="readonly"  value="<%=demandIndentDate %>" MAXLENGTH="30" />
	 <%
 }else{
	 %>
	 <input type="text" tabindex="1" name="<%= REQUEST_DATE %>" readonly="readonly"  value="<%=date %>" MAXLENGTH="30" />
	 <%
 }
 %>
 
 <label><span>*</span>Request By</label> <select
	name="<%= REQUEST_BY%>" id="requestBy" tabindex="1"
	validate="Request By,string,no">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<%String lastName="";
		if(masEmployee.getLastName() !=null){
			lastName=masEmployee.getLastName();
			%>
	<option value=<%=masEmployee.getId()%>
	
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("requestBy")) %>><%=masEmployee.getFirstName()+" "+lastName%></option>
	<%}
	}%>
</select>
<script type="text/javascript">
<%
if(requestByEmpId != 0){

%>
document.issueDispensaryForm.<%=REQUEST_BY%>.value = '<%=requestByEmpId%>';
<%
}
//demandListAjax
//previously this method is used on Demand No on Change; Code Commented By Mukesh Narayan Singh Date 27 Dec 2010
//stores?method=searchInternalIndentDetails
%>
</script>
<!--<label>Indent No.</label>
<div id="testDiv"><select  name="<%= REQUEST_NO%>" tabindex="1"
	validate="Indent No. ,string,no" id="requestNo"
	onchange="submitForm('issueDispensaryForm','stores?method=searchIndentDetails');">
	<option value="0">Select Demand No</option>
	<%for(Object[]  obj : storeInternalIndentMPOList){
		String tempDemandId="";
		tempDemandId=""+obj[0];
			if(demandNoSelected.equalsIgnoreCase(tempDemandId)){
			%>
			<option value="<%=obj[0] %>" selected="selected"><%=obj[1] %></option>
			<%
		}else{
			%>
			<option value="<%=obj[0] %>"><%=obj[1] %></option>
			<%
		}
		//requestNoForAcc

}	%>
</select>
</div>



--><!-- -
<label>Demand Date</label>
	<%
if(box.get("requestDate")!= null && !box.get("requestDate").equals("")){%>
<input type="text" class="date" name="<%= RequestConstants.REQUEST_DATE %>" id="<%= RequestConstants.REQUEST_DATE %>" value="<%= box.get("requestDate")%>"  MAXLENGTH="30" />
				<%}else{ %>
<input type="text" class="date" name="<%= RequestConstants.REQUEST_DATE %>" id="<%= RequestConstants.REQUEST_DATE %>" value=""  MAXLENGTH="30" />
				<%}%>
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  tabindex="1" onClick="setdate('<%=date1%>',document.issueDispensaryForm.<%=RequestConstants.REQUEST_DATE%>,event)" /> -->
<!-- -For smc
<%//if(deptName.equalsIgnoreCase("Dispensary Store")){ %>
<label>Reference  No:</label>
<input type="text" name="<%= RequestConstants.REFERENCE %>" tabindex="1"  id="reference" value="<%=box.get("reference") %>" MAXLENGTH="30" />
				<%//} %>
 -->
<div class="clear"></div>
<label><span>*</span>Approved By</label>
<select name="<%= RequestConstants.APPROVED_BY%>" tabindex="1" id="approvedBy" validate="Approved By,String,no">
					<option value="">Select</option>
					<%for (MasEmployee masEmployee :employeeList ) {String lastName="";
					if(masEmployee.getLastName()!=null){
					lastName=masEmployee.getLastName();
					}%>
				<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+lastName%></option>
				<%}%>
</select>

<label><span>*</span>Issued By</label>
<select name="<%= RequestConstants.ISSUED_BY%>" tabindex="1" id="issuedBy" validate="Issued By,String,no">
					<option value="">Select</option>
					<%for (MasEmployee masEmployee :employeeList ) {
					String lastName="";
					if(masEmployee.getLastName() !=null){
					lastName=masEmployee.getLastName();
					}%>
				<option value=<%=masEmployee.getId()%> ><%=masEmployee.getFirstName()+" "+lastName%></option>
				<%}
				%>
				
</select>

</div>
<input type="hidden" name="internalIndentId" value="<%=internalIndentId%>" />
<div class="Clear"></div>
<input type="hidden" class="button" value="Next"  onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=next');}" align="right" />
<!-- <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=submit');}"/>  -->
<div class="clear paddingTop15"></div>

 <!-- -
<div id="pagination">		 
Page No.
<span class="selected"><%=pageNo%></span>
<input type="text" class="small" name="ValueOfPage" value="" id="page"  MAXLENGTH="3" />
<input type="button" name="goToPage" value="Go" class="button"  onClick="goPage();" />
Total Pages
<span class="selected"><%=totalPages%></span>
</div> -->
<div class="Clear"></div>
	
<input type="hidden" size="2"	value="0"  name="noOfRecords" id="noOfRecords" />
<input type="hidden" name="requestNo1" id="requestNo1" value="" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
	
	 <h4>Item Details</h4>
 	<table  colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
  	<thead>
   	 <tr>
     	<tr>

			<th width="5%">S.No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">BarCode No</th> 
			<th width="13%">A/U</th>				
			<th width="13%">Batch No</th>			 
			<th width="13%">Expiry Date</th> 
			<th width="13%">Availbale Stock</th>
			<th width="13%">Qty Requested</th>
			<th width="13%">Qty Issued</th>
			<th width="3%">&nbsp;</th>
		</tr> 
      <!-- -
      <th width="6%">Loan Out Qty</th> -->
      <!--
       Loan Out Qty will be there for DIspensary Only
       If id in StoreSetup is equivalent to login Id then display this coloumn
       otherwise dont display.  
       -->
     
    </tr>
   </thead>
  <tbody>
		<%
	    	int inc= 0;
	    	try{
    	int detailCounter=10;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String qtyRequested="qtyRequested";
    	String loanOutQty="loanOutQty";
    	String incVar="incVar";
    	String issuedItemId="issuedItemId";
    	String batchNo="batchNo";
    	String barCodeNo="barCodeNo";
    	String batchNo2="batchNo";
    	String barCodeNo2="barCodeNo";
    	String expiryDate="expiryDate";
    	String expiryDate2="expiryDate";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String qtyRequested2="qtyRequested";
    	String loanOutQty2="loanOutQty";
    	String incVar2="incVar2";
    	String issuedItemId2="issuedItemId";
    	String srNo = "srNo";
    	String srNo2 = "srNo";
    	String qtyIssued="qtyIssued";
    	String qtyIssued2="qtyIssued";
    	String detailId="detailId";
    	String detailId2="detailId";
    //	inc=((pageNo-1)*20)+1;
    //	int tempVar=((pageNo-1)*20)+1;

 	//   int incTemp2=inc+20;
 	inc=((pageNo-1)*indentTList.size())+1;
   	int tempVar=((pageNo-1)*indentTList.size())+1;

 	 int incTemp2=inc+indentTList.size();
 	  	for (Iterator iterator = indentTList.iterator(); iterator.hasNext();)
		{
		 Object[] object = (Object[]) iterator.next();

 		  tempVar--;

 		  if(inc<incTemp2){

     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		qtyRequested=qtyRequested2+(""+inc);
     		incVar=incVar2+(""+inc);
     		issuedItemId=issuedItemId2+(""+inc);
     		qtyIssued=qtyIssued2+(""+inc);
     		detailId=detailId2+(""+inc);
     		loanOutQty=loanOutQty2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		barCodeNo=barCodeNo2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		srNo = srNo2+(""+inc);

             System.out.println("inc "+inc);
    	  %>

		<tr>
		 <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
		 <input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
			<td width="5%"><input type="text" size="2" tabindex="1"	value="<%=inc%>" id="srNo<%=inc %>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="8" tabindex="1"
				name="<%=RequestConstants.ITEM_CODE%>"	value="<%=object[1].toString() %>" id="pvmsNo<%=inc%>" />
				<input	type="hidden" size="2" value="<%=object[0].toString() %>" name="itemId<%=inc %>" 
				id="itemId<%=inc %>" />
				<input
				type="hidden" size="2" value="<%=object[6].toString() %>"
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />
				</td>
			<td width="10%"><input type="text" tabindex="1" size="50" value="<%=object[2].toString() %>" 
			    readonly="readonly"	name="<%=RequestConstants.NOMENCLATURE%>" id="nomenclature<%=inc%>"/></td>
			  <div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('nomenclature<%=inc %>','ac2update','stores?method=getItemListForIndent',{parameters:'requiredField=<%=RequestConstants.NOMENCLATURE%>&storeDepartmentId=<%=deptId%>'});
			</script>
			  
			 
				<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=inc %>" 
			id="barCodeNo<%=inc %>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="getDataForBarcode(this.value,<%=inc %>)" /></td>
			
				
				<td width="5%"><input type="text" name="au<%=inc %>" id="au<%=inc %>"	size="7" readonly="readonly" value="" /></td>
			<td width="10%"><input type="text" name="batchNo<%= inc%>" id="batchNo<%= inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId<%= inc%>" id="brandId<%= inc%>" size="10" readonly="readonly" value="" />
			</td>
			<td width="8%"><input type="text" name="expiryDate<%=inc %>" id="expiryDate<%=inc %>"	size="10" readonly="readonly" value="" />
			</td>
			<td width="7%"><input type="text" size="10" name="stockAvailable<%=inc%>" id="stockAvailable<%=inc%>"  value="" readonly /></td>
			<%
	BigDecimal qtyIssueRequest = new BigDecimal(0);
	if(object[7] != null){
		qtyIssueRequest =  new BigDecimal(object[7].toString());
	}
	BigDecimal qtyIssueDB = new BigDecimal(0);
	BigDecimal issyeRequestDiff = new BigDecimal(0);
	if(object[8] != null){
		qtyIssueDB =  new BigDecimal(object[8].toString());
	}
%>
			<td width="10%">
			<%if(qtyIssueRequest.intValue()!=0 && qtyIssueDB.intValue()!=0 && !qtyIssueRequest.equals(qtyIssueDB)){
				issyeRequestDiff =qtyIssueRequest.subtract(qtyIssueDB);

			%><input type="text" size="8"
				value="<%=issyeRequestDiff%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc %>" id="qtyRequested<%=inc%>" />
			<%}else if(qtyIssueRequest.equals(qtyIssueDB)){%>
			<input type="text"  size="8"
					value="<%=qtyIssueRequest%>" readonly="readonly"
					name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc %>" id="<%=qtyRequested%>" />
			<%}else{%>
			<input type="text" tabindex="1" size="8"
				value="<%=qtyIssueRequest%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc %>" id="<%=qtyRequested%>" />
			<%}%>
			<%try{ %>
			<input type="hidden" value="<%=object[2].toString() %>" tabindex="1"
				id="<%=nameItem%>" name="<%=nameItem%>" />
			<%}catch(Exception e ){ %>
			<input type="hidden" value="" id="<%=nameItem%>" name="<%=nameItem%>" />
			<%} %>
			<!-- -<input type="hidden" value="<%=object[9].toString() %>" tabindex="1"
				id="<%=srNo%>" name="<%=srNo%>" /> -->
			</td>
			<td width="8%"><input type="text"  size="10" name="qtyIssued<%=inc%>" id="qtyIssued<%=inc%>" value="" onblur="checkQty(<%=inc%>)"/>
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowIssueCIV(<%=inc %>);" /></td>
			
		<input type="hidden" name="indentDtId" id="indentDtId<%=inc %>"  />
		</tr>
		<% inc++;}  }
 	  //	if(inc<=(pageNo-1)*20+20){
			//  for(;inc<=(pageNo-1)*20+20;inc++){%><!--
		    			   <tr>
	      <td width="5%"><input type="text" size="2"tabindex="1"	value="<%=temp+inc%>"id="srNo<%=inc %>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
	      <td width="10%">

	     <input type="text" size="8" tabindex="1" name="<%=RequestConstants.ITEM_CODE%>" value=""  id="<%=codeItem%>"/>
	      <input type="hidden" size="2"	value="0" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />

	      </td>
	      <td width="10%">
	      	<input type="text" tabindex="1" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.NOMENCLATURE%>" /></td>
	     <td width="10%">
	        <input type="text"size="8" value=""  tabindex="1"readonly="readonly" name="<%=RequestConstants.AV%>"  id="<%=idAu%>"/>
	        </td>
	         <td width="10%">
		   <input type="text"size="8" value=""  maxlength="30" tabindex="1" name="barCodeNo"  id="barCodeNo<%=inc %>"  onblur="getDataForBarcode(this.value,<%=inc %>)"/>
		  </td>
		  <td width="10%">
		   <input type="text" size="8" value="" maxlength="20" tabindex="1" name="batchNo"  id="batchNo<%=inc %>"/>

		  </td>
		   <td width="10%">
		   <input type="text"size="8" value="" maxlength="20" tabindex="1" name="expiryDate"  id="expiryDate<%=inc %>"/>

		  </td>
	       <td width="10%">
     		 <input type="text"size="8" value=""	id="availableStock<%=inc %>"   readonly />
     	 </td>
	      <td width="10%"><input type="text"size="8"	value=""   readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST%>"  id="<%=qtyRequested%>"/>
	      </td>
	   		 <input type="hidden" value=""	id="<%=nameItem%>"    name="<%=RequestConstants.ISSUED_ITEM%>" />
	      <td width="10%"><input type="text"size="8" tabindex="1" readonly="readonly"	value=""  name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="qtyIssued<%=inc %>" />
	      </td>
	      <td>
	       <input type="button" class="buttonIssue" tabindex="1" onclick="" name="Submit2" value=" "  />
	      </td>  </tr>
		    			  -->
		<%//}}
 	  }catch(Exception e ){e.printStackTrace();}
 	  if(requestNoForAcc>0){
 	  %>
	<tr>
		 <td>

		 <input type="hidden" value="<%=requestNoForAcc%>" id="requestNoForAcc" name="requestNoForAcc" />
	   <!--     <input type="button" class="button" tabindex="1" onclick="submitForm('issueDispensaryForm','stores?method=correctDepartmentIssueToAcknowledgement');" name="Submit2" value="Correct"  /> -->
	      </td>
	</tr>

	<%} %>
	</tbody>
	</table><input type="hidden" name="counter" id="listsize"	value="<%=indentTList.size() %>" />
	<input type="button" class="button" tabindex="1" onclick="if(validateIssue()){submitForm('issueDispensaryForm','stores?method=submitIssueForIndent');}" name="Submit2" value="Save"  />
<input type="hidden" id="counter" value="<%=inc %>" />

<div class="Clear"></div>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<div class="Clear"></div>
	<div class="bottom">
		<label>Changed By:</label>			
		<label class="value"><%=userName%></label>
        
        <label>Changed Date:</label>			
		<label class="value"><%=date%></label>

        <label>Changed Time:</label>			
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
</div>
</form>
<%-- End of Main form --%>
<script type="text/javascript">

function testForAdjustLoanOut(deptName)
{
	var errorMessage="";
	formName="issueDispensaryForm"
	obj = eval('document.'+formName)
	
	//if(document.getElementById('issuedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Issue By \n"; 
	//if(document.getElementById('approvedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Approved By \n";
	if(document.getElementById('requestBy').value == "")
		errorMessage=errorMessage+"Please Select Requested By \n";
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(deptName=="Dispensary Store")
	{	
	if(document.getElementById('reference').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	}
	if(deptName=="Dispensary Store")
	{
		if((document.getElementById('reference').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		   if(confirm("Are you Sure, you want to import Demand items for issue ?")){
			return true;
			}else{
			return false;
			}
		}
		else
		{
			alert(errorMessage)
			return false
		}
	}
	else
	{
		if((document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		if(confirm("Are you Sure, you want to import Demand items for issue ?")){
		return true;
		}else{
		return false;
		}
		}
		else
		{
		alert(errorMessage)
		return false
		}
	}
}
		
	function checkForLoanout()
	{
		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Dispensery Name...!")
			return false;
		}
		else
		{
			submitForm('issueDispensaryForm','stores?method=showAdjustLoanOut&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}
	
function testForLotNo(value)
{
		if(value =="")
		{
			return false;
		}
		else
		{
			return true;
		}
}

function goPage()
{
submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=goToPage');
}
function isToDepartmentSelected(){

	if(document.getElementById('toDeptId').value==""){
	alert("Department Name...!")
		return false;
	}else{
		submitProtoAjax('searchPanel','stores?method=getIssueList&toDeptId='+document.getElementById('toDeptId').value);
	}
	}
</script>
<script type="text/javascript">
function test(indentId)
{
   var reqId = "";
   var reqDate = "";
	<% for(int i=0;i<storeInternalIndentMList.size();i++)
 	{ %>
 		if (indentId == <%=storeInternalIndentMList.get(i).getId()%>)
 		{
 		<% if(storeInternalIndentMList.get(i).getRequestedBy() != null){%>
			reqId = '<%=storeInternalIndentMList.get(i).getRequestedBy().getId()%>'
			
		<% }
 		 if(storeInternalIndentMList.get(i).getDemandDate() != null){%>
 			 reqDate = '<%=HMSUtil.changeDateToddMMyyyy(storeInternalIndentMList.get(i).getDemandDate())%>'
 		<% }
 		%>
 		}
	<%}
	%>
	
	var obj = document.getElementById('requestBy');
	if(reqDate != ""){
	document.getElementById('requestDate').value = reqDate;
	}
	for(i=0;i<obj.length;i++)
	{
		if (reqId == obj.options[i].value)
		{
			obj.selectedIndex = i;
			break;
		}
		
	}
}
function cheackForSelect(){
	if(document.getElementById("requestNo").value!=""){
	document.getElementById("requestNo1").value=document.getElementById("requestNo").value;
	return true;}
	else{
	alert("pls select demand no..");
	return false;
	}
	}
function validateIssue()
{

	if(document.getElementById("departmentIdTemp").value=="")
	{
		alert('Select The Department !!!');
		document.getElementById("departmentIdTemp").focus();
		return false;
	}
	if(document.getElementById("requestBy").value=="")
	{
		alert('Select The Requested BY !!!');
		document.getElementById("requestBy").focus();
		return false;
	}
	if(document.getElementById("approvedBy").value=="")
	{
		alert('Select The Approved By !!!');
		document.getElementById("approvedBy").focus();
		return false;
	}

	if(document.getElementById("issuedBy").value=="")
	{
		alert('Select The Issue By !!!');
		document.getElementById("issuedBy").focus();
		return false;
	}

	if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}else{
		return true;
	}
}
//function getDataForBarcode(val,rowVal){

	// if(val!=""){

	// submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);
	// }
	// }

function barCodefill(inc){
	var barCodeNo=document.getElementById('barCodeNo'+inc).value
	if(barCodeNo != ''){
		document.getElementById('qtyIssued'+inc).value =	document.getElementById('qtyRequested'+inc).value
		
	}
}
function getDataForBarcode(val,rowVal)
{
    var itemId=document.getElementById('itemId'+rowVal).value;
	submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
}	
function generateRowIssueCIV(rowVal)
{
	  var tbl = document.getElementById('indentDetails');
	  var lastRow = tbl.rows.length;
	  var deptId = document.getElementById('deptId').value;
	  var listSize=document.getElementById('listsize').value;
	  listSize=(parseInt(listSize))+1;
	  var iteration = listSize;
	
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo'+iteration;
	  e1.id = 'pvmsNo'+iteration;
	  e1.size='10';
	  e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	  e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;
	  e2.readOnly=true;
		 
	 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
		
	  cellRight2.appendChild(e2);

	  var cellRight21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'barCodeNo' + iteration;
	  e21.id = 'barCodeNo' + iteration;
	  e21.size = '8';
	  e21.onblur = function(){getDataForBarcode(this.value,iteration);};
	  e21.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight21.appendChild(e21);
	  			 
	  var cellRight22 = row.insertCell(4);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'au' + iteration;
	  e22.id = 'au' + iteration;
	  e22.size = '7';
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);

	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('input');
	  e23.type = 'text';
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.size = '10';
	  e23.readOnly=true;
	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	  cellRight23.appendChild(e23);
	  cellRight23.appendChild(e24);
	  	  
	  var cellRight25 = row.insertCell(6);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);
	  
	  
	  var cellRight6 = row.insertCell(7);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.size = '10';
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);

	  var cellRight34 = row.insertCell(8);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'qtyRequest' + iteration;
	  e34.id = 'qtyRequested' + iteration;
	  e34.size = '10';

	  if(document.getElementById('qtyIssued'+rowVal).value=="")
	  {	  
	   e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	  }else
		  e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
	   
	   cellRight34.appendChild(e34);
	  
	  var cellRight35 = row.insertCell(9);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '10';
	  e21.onblur = function(){checkQty(iteration)};
	  cellRight35.appendChild(e35); 
	  
	   
	 document.getElementById('listsize').value=listSize;
}

function checkQty(rowVal)
{
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			alert("Issued Quantity Can't be greater than Quantity Prescribed.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}
}	
function submitProtoAjaxForBarcodeData(formName,action,rowVal)
{
	  //alert("submitProtoAjax");
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
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4)
		  {

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var brandId=item.getElementsByTagName("brandId")[0];
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	document.getElementById("qtyIssued"+rowVal).focus();
	        	
	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Invalid Barcode ");
	     
	      	}
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
</script>