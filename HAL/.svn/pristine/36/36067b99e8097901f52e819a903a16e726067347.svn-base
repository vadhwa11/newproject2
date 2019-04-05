<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgment.jsp  
	 * Purpose of the JSP -  This is for Department Indent.
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5  
	--%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>



<script language="Javascript">
	
deptArray = new Array();
	    
/*function populateIssueNoAndDate(val,formName){
		obj = eval('document.'+formName+'.issueNo');
		obj.length = 1;
		for(i=0;i<deptArray.length;i++){
			if(deptArray[i][1]==val){
				obj.length++;
				obj.options[obj.length-1].value=deptArray[i][0];
				obj.options[obj.length-1].text=deptArray[i][2];			
			}
		}
	}
*/




//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	ack.currPage.value = pidx;
	ack.method="post";
	submitForm('ack','stores?method=createGridIssueData');
}

/*function showAck(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=closeAckJsp";
  obj.submit();
}*/

	</script>

<%
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
	
		orderDateOnly.append("/");
	
		int month1 = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month1 < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month1);
		} else {
			orderDateOnly.append(month1);
		}
	
		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
	
		Box box = HMSUtil.getBox(request);
		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		int deptId = 0;
		
		int issueMId = 0;
		//List<StoreIssueM> searchStoreIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
		if (request.getAttribute("map") != null) 
		{
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		if (map.get("issueMId")!=null){
			issueMId=Integer.parseInt(""+map.get("issueMId"));
		}
		if(session.getAttribute("deptId") != null){
			deptId = Integer.parseInt(""+session.getAttribute("deptId"));
		}
		//System.out.println("deptId ==>"+deptId);
		//if(map.get("searchStoreIssueMList")!=null)
			//searchStoreIssueMList = (List) map.get("searchStoreIssueMList");
		
		if(map.get("storeIssueMList")!=null)
			storeIssueMList = (List<StoreIssueM>) map.get("storeIssueMList");
		
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		String deptName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(session.getAttribute("deptName") != null){
			deptName = (String)session.getAttribute("deptName");
		}
		
		
		TreeMap tm = new TreeMap();
		if(map.get("tm")!=null)
			tm = (TreeMap) map.get("tm");
		
	
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		if(map.get("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
			session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
		}
		else if(session.getAttribute("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		}
		
		if (map.get("departmentList")!=null)
		{
			departmentList = (ArrayList)map.get("departmentList");
		}
	
		
		if(map.get("message") != null)
		{
			   String message = (String)map.get("message");
			   %>

<%
			   out.println(message);
		}
		
		int approvedById = 0;
		
		if(session.getAttribute("approvedById") != null)
		{
			approvedById = Integer.parseInt(""+session.getAttribute("approvedById"));
		}
		
		
		if(map.get("storeIssueTList") != null)
		{
			storeIssueTList = (List)map.get("storeIssueTList"); 
		}
	%>


<%if(deptId==35){ %>
<!--  <div class="titleBg"><h2>CRV Dispensary</h2></div>-->
<!-- <div class="titleBg"><h2>CIV Receipt Entry</h2></div>-->
<div class="titleBg"><h2>Acknowledgement Of RC</h2></div>
<% }else{%>
<div class="titleBg"><h2>Acknowledgement Of RC</h2></div>
<% }%>
<form name="ack" method="post">
<input type="hidden" name="numOfRows" size="5" value="8">
<input type="hidden" name="pageCount" size="5" value="10">
<script>
				document.ack.<%=ISSUE_DEPT%>.focus();
</script>
<div class="Block">
<input type="hidden" name="<%=ISSUE_DEPT%>" id="issueDept" validate="Issue Department,String,yes" value="24">
<!-- ------------- <label><span>*</span>Issue Department</label>
<select
	name="<%=ISSUE_DEPT%>" id="issueDept"
	validate="Issue Department,String,yes"
	onchange="populateIssueNoAndDate(this.value,'ack')" tabindex=1>
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList) {
					%>

	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(ISSUE_DEPT)) %>><%=masDepartment.getDepartmentName()%></option>

	<%
						}
					%>
</select>-->
 	
<%-- <%if(deptId==35){ %> --%>
<label>Request No.<span>*</span></label> 
<%-- <% }else{%>
<label>Issue No.</label> 
<%} %> --%>
<select id="issueNo"
	name="<%=ISSUE_NO%>" validate="Issue No,String,yes" onchange=""
	tabindex=1>
	<option value="0">Select</option>
	<%
		//if (box.getInt(ISSUE_NO)!=0) 
		//{
				for(StoreIssueM storeIssueM : storeIssueMList)
				{
					//if (storeIssueM.getToStore().getId().equals("35"))
					//{
						System.out.println("storeIssueM.getRequestHeader()"+storeIssueM.getRequestHeader());
				%>
	<option value="<%=storeIssueM.getId()%>"
		<%=HMSUtil.isSelected(storeIssueM.getId().toString(),box.getString(ISSUE_NO)) %>><%=storeIssueM.getRequestHeader()!=null?storeIssueM.getRequestHeader().getRequestNo():""%></option>
	     <% }
					//}
				//}
		%>
</select> 

<%
				for (StoreIssueM storeIssueM :storeIssueMList ) {System.out.println(storeIssueM .getId()+"ISSUE_NO"+box.getString(ISSUE_NO));
				if(box.getString(ISSUE_NO)!= null && box.getString(ISSUE_NO) != ""){
				if(Integer.parseInt(box.getString(ISSUE_NO))== (Integer)storeIssueM .getId()){
				%> <label>Issue Date</label>
				<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(storeIssueM.getIssueDate())%></label>
<input type="hidden" name="<%=ISSUE_DATE%>"
	value="<%=storeIssueM.getToStore().getId() %>"> <%	//break;	
					}}}
				%>
<%if(deptId==35){ %>
<!--  <label>CRV Date</label>-->
<% }else{%>
<label>AcknowledgeDate</label>
<label class="value"><%=box.get(ACK_DATE)==""?currentDate:box.get(ACK_DATE)%></label>
<%} %>
 <input type="hidden" name="<%=ACK_DATE %>"	value="<%=box.get(ACK_DATE)==""?currentDate:box.get(ACK_DATE)%>"	class="date" readonly validate="Pick a date,date,yes" />
<!-- 
 <img 
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" onClick="setdate('<%=currentDate%>',document.ack.<%=ACK_DATE %>,event)" />
-->


<!-- <label>Department</label> -->
<input type="hidden" value="<%=deptName%>" readonly="readonly" />
<!--  <label class="value">Dispensary </label>-->
<%-- <%if(deptId==35){ %> --%>
<label>Received By<span>*</span></label> 
<%-- <% }else{%>
<label>Acknowledge By</label> 
<%} %> --%>

<select	name="<%=ACK_BY %>" id="acknowledgedBy"	validate="Acknowledgment By,String,yes" tabindex=1>
	<option value="0">Select</option>
	<%
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
					String name="",m_name="",l_name="";
			         if(approvedBy.getFirstName()!=null)
			        	 name=approvedBy.getFirstName();
			         if(approvedBy.getMiddleName()!=null)
			        	 name=name+" "+approvedBy.getMiddleName();
			         if(approvedBy.getLastName()!=null)
			        	 name=name+" "+approvedBy.getLastName();
			         
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(ACK_BY)) %>><%=name%></option>
	<%	
							
				
					}
				%>
</select>


				<input type="hidden" name="<%=CHANGED_BY %>"	value="<%=userName%>" />
	<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
	<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="deptId" value="<%=deptId%>" />
	<input type="hidden"	name="issueMId"	value="<%=map.get("issueMId") == null?0:map.get("issueMId")%>" />
	</div>
	<div class="clear"></div>
	<!-- <input	type="button" name="ss" value="Submit" class="button"	onClick="getIssue('ack');" accesskey="a" tabindex=1 /> <br /> -->


<% if (pagedArray == null) { %>

<div class="clear paddingTop15"></div>
<h4>Details</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="indentDetails"	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="13%">MAT Code</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U	</th>
			<!-- <th width="10%">Brand Name</th>-->
			<th width="13%">Batch No.</th>
			<th width="10%">DOM</th>
			<th width="10%">DOE</th>
			<th width="10%">Manufacturer</th>
			<th width="10%">Qty Demanded</th>
			<th width="10%">Qty Received</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td >No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
<!-- javed khan -->
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input	type="button" name="ss" value="Import" class="button"	onClick="getIssue('ack');" accesskey="a" tabindex=1 /> 

<% } else { %>
<%if(deptId==35){ %>
 <h4>Details</h4>
<% }else{%>
 <h4>Acknowledgment Details</h4>
<% }%>
<div class="cmntable">
<table id="cmntable">
<thead>
		<tr>

			<th width="5%">Sl No.</th>	
				<th width="13%">MAT Code</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<!-- <th width="10%">Brand	Name</th>--> 
			<th width="13%">Batch No.</th>
			<th width="10%">DOM</th>
			<th width="10%">DOE</th>
			<th width="10%">Manufacturer</th>
			<th width="10%">Qty Demanded</th>
			<th width="10%">Qty Received</th>
			

		</tr>
	</thead>
	<tbody>
		<%
				    gridData = (HashMap[])pagedArray.getPagedArray();
					int iFirstRow = pagedArray.getFirstRowIdx();
				    for(int i=0;i<gridData.length;i++)
				    { %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>" size="2"	 name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"	 value="<%=gridData[i].get("pvms")%>"  name="pvms" size="8"		readonly="readonly" /></td>
			<td width="40%"><input type="text"	 value="<%=gridData[i].get("nomenclature")%>" size="48" name="nomenclature" readonly="readonly" /></td>
			<td width="5%"><input type="text"    value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>" size="6"		 name="au" readonly="readonly" /></td>
				
			<input type="hidden"	value="<%=gridData[i].get("brandname")%>" name="brandname"		validate="Brand Name,string,no" readonly="readonly" />
			<td width="12%">
			<%if(((String)gridData[i].get("batchNo")).equals("0")){ %>
			<input type="text" size="7"		value="<%=""%>" name="batchNo"	readonly="readonly" validate="Batch No.,string,no" />
			<%}else{ %>
			<input type="text" size="7"		value="<%=gridData[i].get("batchNo")%>" name="batchNo"	readonly="readonly" validate="Batch No.,string,no" />
			<%} %>
			</td>
			
			<td width="10%">
			<%if((gridData[i].get("manu_date"))== null){ %>
			<input type="text"	size="10"	value="<%=""%>" name="manu_date" readonly="readonly" />
				
				<%}else{ %>
			<input type="text" size="10"		value="<%=gridData[i].get("manu_date")%>" name="manu_date"	readonly="readonly" validate="Batch No.,string,no" />
			<%} %>
			</td>
			<td width="10%">
			<%if((gridData[i].get("expiry_date"))== null){ %>
			<input type="text"	size="10"	value="<%=""%>" name="expiry_date" readonly="readonly" />
				
				<%}else{ %>
			<input type="text" size="10"		value="<%=gridData[i].get("expiry_date")%>" name="expiry_date"	readonly="readonly" validate="Batch No.,string,no" />
			<%} %>
			</td>
			<td width="10%">
			<%if((gridData[i].get("comp"))== null){ %>
			<input type="text"	size="22"	value="<%=""%>" name="comp" readonly="readonly" />
				
				<%}else{ %>
			<input type="text" size="22"		value="<%=gridData[i].get("comp")%>" name="comp"	readonly="readonly" validate="Batch No.,string,no" />
			<%} %>
			</td>
			<td width="10%">
			<input type="text"  size="8"	value="<%=gridData[i].get("qtyRequest")%>" name="qtyRequest" readonly="readonly" validate="Demand Qty,num,no" />
			</td>
			<td width="10%">
			<%if((gridData[i].get("qtyIssued"))== null){ %>
			
			<input type="text" size="8"	value="<%="0"%>" name="qtyIssued"	readonly="readonly" validate="Issue Qty,num,no" />
			<%}else{ %>
			<input type="text" size="8"	value="<%=gridData[i].get("qtyIssued")%>" name="qtyIssued"	readonly="readonly" validate="Issue Qty,num,no" />
			<%} %>
			</td>
		    
				<input type="hidden"	value="<%=gridData[i].get("brand")%>" name="brand"	readonly="readonly" />
			    <input type="hidden"	value="<%=gridData[i].get("issueId")%>" name="issueId" />
			    <input type="hidden" value="<%=gridData[i].get("itemId")%>"	name="itemId" />
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Update"
	class="button" onClick="ackconfirm();" accesskey="a" tabindex=1 /> <!--  <input type="button" name="close" id="closebutton" value="Close" class="button" onClick="showAck('ack')" accesskey="u" tabindex=1 />  -->
	<!-- <input	type="button" name="ss" value="Import CIV" class="button"	onClick="getIssue('ack');" accesskey="a" tabindex=1 /> <br /> -->
<div class="clear"></div>
<div class="division"></div>
<% } %>

</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>

<script language="Javascript">
	function populateIssueNoAndDate(val,formName)
	{
		obj = eval('document.'+formName+'.issueNo');
		obj.length = 1;
		<% for(StoreIssueM storeIssueM : storeIssueMList) 
		{ %>
				if (val == <%=storeIssueM.getDepartment().getId().toString()%>)
				{
				obj.length++;
				obj.options[obj.length-1].value="<%=storeIssueM.getId()%>";
				obj.options[obj.length-1].text="<%=storeIssueM.getIssueNo()%>";
				}			
		<% } %>
	}
	function ackconfirm()
	{
	  if(confirm("Are You sure, You want to accept the items?"))
	  {
	      submitForm('ack','stores?method=addAckForRC');
			return true;
	   }else{
		  return false;
       }
	
	}
	
	function getIssue(form)
	{
			  
		form.method="post";
		var issueNo = document.getElementById('issueNo').value;
		var issueDept = document.getElementById('issueDept').value;
		var acknowledgedBy = document.getElementById('acknowledgedBy').value;
		if (issueNo==0 || issueDept==0 || acknowledgedBy==0)
		{
			alert("Pl. Check your Inputs!...  ");
			return;
		}
		var strValue = document.ack.<%=ACK_DATE %>.value;
	    
	    if(strValue=='')
	    {
	    	alert("Issue Date can't be Blank ....");
			return ;
	    }      
		var crvDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	   
	    //alert("date ----"+date)
		//	strValue = document.grReturnRecieptRegister.<%=TO_DATE%>.value;
		 
		var strValue = document.ack.<%=CHANGED_DATE %>.value;   
	   	var currDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
			
		if (crvDate < currDate)
	 	{
			alert("Issue Date can't be less than Current Date !....");
			return false;			
	 	}
	 	
	 
		submitForm(form,'stores?method=createGridIssueDataForRC&<%=ISSUE_NO%>='+issueNo+"&currPage=1");
	}


	
	
	</script>
