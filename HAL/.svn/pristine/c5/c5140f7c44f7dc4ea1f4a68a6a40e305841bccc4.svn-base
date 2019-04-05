<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreCondemnationM"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">

function checkForWorkOrder(val)
{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=getWorkOrderDetails&workId='+val);
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	condemnForm.currPage.value = pidx;
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=getWorkOrderDataForDisplayGrid');
}

function validateDeleteButton()
{
	if (condemnForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < condemnForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (condemnForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (condemnForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=deleteGridItemsForCondemnation');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function upd()
{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=updateGridItemsInCondemnation');
}

function jsDisplay() {
	var condemnationId = document.searchPanel.<%=CONDEMNATION_ID%>.value	
	if (condemnationId == "")
	{
	alert('Pl. select Condemnation No....');
	return;
	}
	var workDate = document.condemnForm.<%=WORK_ORDER_DATE %>.value;
	var condemnationDate = document.condemnForm.<%=CONDEMNATION_DATE %>.value;
	var deptId = document.searchPanel.<%= FROM_WARD%>.value;
	//var condemnationNo = document.condemnForm.<%= CONDEMNATION_NO%>.value;
		
	searchPanel.method="post";
	submitForm('searchPanel','nonExpNew?method=searchCondemnation&<%=WORK_ORDER_DATE%>='+workDate+'&<%=CONDEMNATION_DATE%>=' + condemnationDate+'&<%=CONDEMNATION_ID%>='+condemnationId+'&deptId='+deptId);
}

</script>


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
	Box box = HMSUtil.getBox(request);
	HashMap[] gridData = null;
	PagedArray pagedArray = null;
	
	Map map = new HashMap();
	String message = "";
	String userName = "";
	int deptId = 0;
	int hospitalId = 0;
	String time ="";
	int condemnationId = 0;	
	int condemnationNo = 0;
	int workOrderId = 0;
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
	List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
	List<StoreCondemnationM> condemnationMList = new ArrayList<StoreCondemnationM>();
	List<StoreCondemnationM> searchCondemnationMList = new ArrayList<StoreCondemnationM>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if(map.get("condemnationId")!=null){
		condemnationId=Integer.parseInt(""+map.get("condemnationId"));
	}	
	if(map.get("condemnationNo")!=null){
		condemnationNo = (Integer)map.get("condemnationNo");
	}
	if(map.get("workOrderId")!=null){
		workOrderId = (Integer)map.get("workOrderId");
	}
	String condemnationDate = "";
	String workOrderDate = "";
	
	
	if(map.get("condemnationDate")!=null){
		condemnationDate = (String)map.get("condemnationDate");
	}
	if(map.get("workOrderDate")!=null){
		workOrderDate = (String)map.get("workOrderDate");
	}
	
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
	}
	if(map.get("searchWorkOrderList")!=null)
	{
		searchWorkOrderList = (List) map.get("searchWorkOrderList");
	}
	if(map.get("message") != null)
	{
		message = (String)map.get("message"); 
	}
	if (session.getAttribute("userName") != null) 
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("deptId") != null) 
	{
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (session.getAttribute("hospitalId") != null) 
	{
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	if(map.get("workOrderMList")!=null)
	{
		workOrderMList = (List<StoreWorkOrderM>) map.get("workOrderMList");
	}
	else if(map.get("condemnationMList")!=null)
	{
		condemnationMList = (List<StoreCondemnationM>) map.get("condemnationMList");
	}
	
	if(map.get("searchCondemnationMList")!=null)
	{
		searchCondemnationMList = (List<StoreCondemnationM>) map.get("searchCondemnationMList");
	}
		
	StoreWorkOrderM  storeWorkOrderObj = null;
	
%>



<!-- 
<input
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="button"
					onClick="submitForm('createGrn','nonExpNew?method=showGrnJsp');"> -->
		

<div id="searchBlock" style="display:none;">
<form name="departmentIndent" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label	> Condemnation No: </label> <select
			name="<%=CONDEMNATION_ID%>">
			<option value="0">Select Condemnation No</option>
			<%
				for (StoreCondemnationM mObj :searchCondemnationMList ) {
					System.out.print("mObj======= >"+mObj.getId());
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getCondemnationNo()%></option>
			<%
			System.out.print("mObj  ------- >"+mObj.getId());
				}
			%>
		</select> <input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" /> 
		<input	type="button" name="Submit" id="addbutton" value="SEARCH"
			class="button" onClick="jsDisplay();" />
		
</div>
</div>

</form>


<div class="titleBg">
<h2 >Condemnation Entry</h2>
</div>
<div class="clear"></div>
<form name="condemnForm" method="post">
<h4 ><%=message %></h4>
<div class="Block">
<input type="hidden" name="deptId" value="<%=deptId%>" /> 
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" /> 

<label>I.V. No.</label>
<input type="text" name="IVNo" id="Iv" size=6 validate="I.V. No.,String,no" />

<label>I.V. Date</label>
<input type="text" name="condemnationDate" id="<%=WORK_ORDER_DATE%>" value="<%=currentDate%>">
<img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate('<%=currentDate%>',document.condemnForm.<%=WORK_ORDER_DATE%>,event)" />
</div>
<% if (pagedArray == null) {  %>

<div class="clear"></div>
<div class="division"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl. No.</label></th>
			<th width="10%">PVMS/NIV No.</label></th>
			<th width="23%">Nomenclature</label></th>
			<th width="8%">Serial No.</label></th>
			<%--<th width="10%">Part No. </label></th> --%>
			<th width="10%">AU</label></th>
			<th width="10%">Qty</label></th>
			<th width="23%">Value For Sentence</label></th>
			<th width="10%">Report showing causes of loss,damage or Unserviceability and name of person responsible.</label></th>
			<th width="23%">Remarks</label></th>
		</tr>
	</thead>
	<tbody>
		<%-- <tr>
			<td colspan=6>No Data Found</td>
		</tr>
		--%>
		<%
		String codeItem1="codeItem1";
		String idItem1="idItem1";
		String nameItem1="nameItem1";
	 	String idAu="idAu"; 
		int inc=0;
		inc = inc+1;
		%>
		
		<tr>
			<td width="5%">
			<input type="text" value="1"
				class="smcaption" name="srno"  /></td>
			<td width="10%">
			 <input type="text" size="8" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem1%>" />
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem1%>" />
				</td>
			<td width="40%">
			
			  <input type="text" size="60" value="" name="<%=nameItem1%>" id="<%=nameItem1%>" onblur="checkForCondemnation(this.value, '<%=nameItem1%>');"></input>
			      <div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem1%>','ac2update','neStores?method=getItemListForCondemnationByAutocomplete',{parameters:'requiredField=<%=nameItem1%>'});
			</script>
			
			  </td>
			<td width="12%">
			<input type="text"	value="" class="medcaption" name="serialNo" maxlength="25"  /></td>
			<td width="10%">
			<input type="text"	value=""
				class="medcaption" name="<%=AU %>" readonly="readonly" id="<%=idAu%>" />
				</td>
			
			<td width="10%"><input type="text" value="" name="qty" validate="Qty,int,no" readonly  maxlength="4" id="qty1" /></td>
			<%-- <input type="text"	value="" name="partNo" validate="Part No,num,no" maxlength="6" /></td>--%>
			
			<td width="10%"> <input type="text" size="40" value="" name="reason" validate="Reason For Sentence,String,no" maxlength="80" /></td>
		 <td width="10%"> <input type="text" size="80" value="" name="reportRemarks" validate="Reason For Sentence,String,no" maxlength="80" /></td>
			
			<td align="center" width="10%"><input type="text" name="remarks" value="" maxlength="80">
			</td>
			
		</tr>
		
	</tbody>
</table>
</div>

<% } else { System.out.println("else in condemnation"); 
	%>

<h4>Work Order</h4>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>


<div class="Clear"></div>
<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="100%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl. No.</label></th>
			<th width="10%">PVMS/NIV No.</label></th>
			<th width="23%">Nomenclature</label></th>
			<th width="8%">Serial No.</label></th>
			<%--<th width="10%">Part No. </label></th> --%>
			<th width="10%">Qty</label></th>
			<th width="23%">Value For Sentence</label></th>
			<th width="10%">Report showing causes of loss,damage or Unserviceability and name of person responsible.</label></th>
			<th width="23%">Remarks</label></th>
		</tr>
	</thead>

	<tbody>
		<%
	    gridData = (HashMap[])pagedArray.getPagedArray();
		int iFirstRow = pagedArray.getFirstRowIdx();
	    for(int i=0;i<gridData.length;i++)
	    { System.out.println(" Within For Loop");   
	    	%>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")==null?"":gridData[i].get("pvms")%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")==null?"":gridData[i].get("nomenclature")%>"
				class="bigcaption" name="nomenclature"  readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("serialNo")==null?"":gridData[i].get("serialNo")%>"
				class="medcaption" name="serialNo"  /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("partNo")==null?"":gridData[i].get("partNo")%>"
				name="partNo" validate="Part No,num,no" maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qty")==null?"":gridData[i].get("qty")%>"
				name="qty" validate="Qty,int,no"  maxlength="30" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("reason")==null?"":gridData[i].get("reason")%>"
				name="reason" validate="Reason For Sentence,String,no"
				maxlength="30" /></td>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>">
			</td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>
<%} %> 

<div class="Clear"></div>
<div class="division"></div>

<%-- <input	type="button" name="Modify" type="submit" value="SAVE" class="button" onClick="submitForm('condemnForm','nonExpNew?method=updateGridItemsInCondemnation');">--%>
 <input	type="button" name="Modify" type="submit" value="SAVE" class="button" onClick="submitForm('condemnForm','nonExpNew?method=saveCondemnationEntry','validate');">
				<!-- <input
					type="button" name="Reset" type="submit" value="Reset"
					class="button"> -->
					
					
				<input
					type="button" name="print" type="submit" value="PRINT"
					class="button"  onClick="submitForm('condemnForm','nonExpNew?method=printCondemnationJsp','validate');" />
				
				<input type="button" name="Add" value="REPLACEMENT INDENT"  class="buttonBig"  onClick="submitForm('condemnForm','nonExp?method=showIndentJspSOC');">
				
				<%-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />--%>


<div class="division"></div>


<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="+" id="rr" value="1" />
<script type="text/javascript">

function validate(){
	 var msg = "";
	if(document.getElementById('Iv').value == '')
   {
		msg += "Please Enter I.V. No.";
		
	 }	
	if(msg!=''){
		alert(msg);
		return false;
	}
return true;	
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

</script></form>
<script type="text/javascript" >
function checkForCondemnation(val,a)
{
       // alert("checkForDefectiveDrugs----->2222222222");
		//var pageNo =parseInt(document.getElementById('pageNo').value)
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    var inc =1
	   // alert("checkForDefectiveDrugs"+pvms);
	   //ajaxFunctionForAutoCompleteInTurnOver('mmfDepartment','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
	    ajaxFunctionForAutoCompleteInBoardofSurvey('departmentIndent','neStores?method=fillItemsForBoardofsurvey&pvmsNo=' + pvms , inc);

}
</script>