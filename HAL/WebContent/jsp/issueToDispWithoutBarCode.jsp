<%@page import="java.util.*"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.RequestConstants"%>
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
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
//<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
 //-->
 
 
 
 function getUnit(val){
	// var ele = document.getElementById("toggleText");
	
	if(val != null  && document.getElementById('unit').value==val ){
		var issue_no= document.getElementById('issueNo').value;
		var date = document.getElementById('issueDate').value;
		//submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
		submitForm('issueDispensaryForm','stores?method=getUnit&type='+val+'&issue='+issue_no+'&date='+date);
		//document.getElementById('departmentIdTemp').style.visibility = "hidden";
		//document.getElementById('requestNo').style.visibility = "hidden";
		//ele.style.display = "none";	
	}
	if(val != null  && document.getElementById('depart').value==val ){
		
		submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
		document.getElementById('departmentIdTemp').style.visibility = "visible";
		//document.getElementById('requestNo').style.visibility = "visible";
		//ele.style.display = "block";	 
	}
	
 }
 
 function getFirstAid(val){
		// var ele = document.getElementById("toggleText");
		//alert(val);
		
			var issue_no= document.getElementById('issueNo').value;
			var date = document.getElementById('issueDate').value;
			//submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
			submitForm('issueDispensaryForm','stores?method=getFirstAid&type='+val+'&deptId=120&issue='+issue_no+'&date='+date);
			//document.getElementById('departmentIdTemp').style.visibility = "hidden";
			//document.getElementById('requestNo').style.visibility = "hidden";
			//ele.style.display = "none";	
	
		if(val != null  && document.getElementById('depart').value==val ){
			
			submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
			document.getElementById('departmentIdTemp').style.visibility = "visible";
			//document.getElementById('requestNo').style.visibility = "visible";
			//ele.style.display = "block";	 
		}
		
	 }
 
function isDispenserySelected()
	{

		if(document.getElementById('departmentIdTemp').value=="")
		{
			alert("Please select Department Name...!")
			return false;
		}
		else
		{
			submitProtoAjax('issueDispensaryForm','stores?method=getDemandListForWithoutBar&departmentIdTemp='+document.getElementById('departmentIdTemp').value);
		}
	}


function getdpt(){

	
	var indent_id=document.getElementById('requestNo').value;
	submitProtoAjaxdiv('issueDispensaryForm','stores?method=setDepartmentWithoutbarcode&indent_id='+document.getElementById('requestNo').value);	
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
	int approvedBy=0;
	String max="";
	String message = "";
	String Employee_id="";
	String Employee_name="";
	String IndentDate="";
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
		 
		 
		
		 if(map.get("approvedBy")!=null){
			 approvedBy =Integer.parseInt(""+map.get("approvedBy"))  ;
			}
		 int issuedBy=0;
		 if(map.get("issuedBy")!=null){
			 issuedBy =Integer.parseInt(""+map.get("issuedBy"))  ;
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
			System.out.println("indentTList bar "+indentTList.size());
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
		System.out.println("list"+listSize);
		
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
			if(map.get("Employee_id")!=null){
				Employee_id=map.get("Employee_id").toString();
				System.out.println("this is my employee code"+Employee_id);
			}
			if(map.get("Employee_name")!=null){
				Employee_name=map.get("Employee_name").toString();
				System.out.println("this is my employee code"+Employee_name);
			}
			if(map.get("Demand_Date")!=null){
		// add by javed khan			
			String IndentDate1=map.get("Demand_Date").toString();	
				IndentDate=IndentDate1.substring(0,2)+"/"+IndentDate1.substring(3,5)+"/"
								+IndentDate1.substring(6,10);
			}
			
// add by javed khan
			Map mapbatch=new HashMap();
			if(map.get("mapbatch")!=null){
				mapbatch=(Map)map.get("mapbatch");
			}
			int depart_id=0;
			if(map.get("depart")!=null){
				depart_id=Integer.parseInt((String)map.get("depart"));
			}
			
			List storeIssueMList = new ArrayList();
			 if (map.get("storeIssueMList") != null) {
				 storeIssueMList = (List) map.get("storeIssueMList");
			}
%>


<%-- Start of Content Div --%>



 <div id="searchBlock" style="display:none;">
 
<form name="depCiv" method="post" action="">
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>
<h6>SEARCH</h6>
<!--  <div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>-->
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div> -->
<div class="clear"></div>
<!-- <div class="searchBlock" id="threadsearch_menu" style="display: none"> -->
<!-- <form name="searchPanel" method="post"> -->
<div class="clear"></div>
<label> CIV	No. </label>
<select name="<%=DEMAND_NO%>">
			<option value="0">Select CIV No.</option>
			<%
			for (Iterator iterator = storeIssueMList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				%>
			
			<option value=<%=object[0]%>><%=object[1]%></option>
			<%
				}
			%>
</select>
		<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
		<input			type="hidden" name="numOfRows" size="5" value="5">
		<input type="button" name="sss" class="button" value="SEARCH" onClick="civDisplay();" /></td>
</form>
</div>
</form>

</div>
<form name="issueDispensaryForm" method="post">
<%-- Start of Main Form --%>
<%-- Title --%>
<%if(deptId==35){ %>
<div class="titleBg"><h2>Department/Unit Issue</h2></div>
<%}else{ %>
<div class="titleBg"><h2>Issue CIV</h2></div>
<%} %>
<div class="Clear"></div>	

<Script>
var batchArray=new Array();

</Script>
<!-- -
<%--------------- Start of Tool Panel ---------------------------%>
<table class="tborder" width="100%" align="center" >
<tr>
	   <td width="20%" nowrap="nowrap" class="vbmenu_control" id="threadsearch">
	   <a href="">Search</a>
	    <script type="text/javascript"> vbmenu_register("threadsearch"); </script>
	    </td>
	    <td width="20%">
	     <%if(!message.equals("")) {%>
		<td>
		<label class="noWidth"><span><%=message %></span></label></td>
		<%} %>
		</td>
</tr>
</table>-->
<%--------------- End of Tool Panel ---------------------------%>
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
<label> Dispensary Issue No. </label>
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
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="<%= RequestConstants.ISSUE_DATE %>" readonly="readonly" value="<%=date %>"  MAXLENGTH="50" />
<div class="clear" style="padding-top:5px;"></div>
 <%if(deptId!=35){ %>
<label>Issue To<span>*</span></label>
<select name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" tabindex="1" id="departmentIdTemp" validate='Dispensery Name,num,Yes'  >
				<option value="">Select</option>
				<%for (MasDepartment department :departmentList ) {	%>
					<option value=<%=department.getId()%> <%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
				<%}	%>
</select>
<%} %>
<%if(deptId==35){ %>


	 <label class="medium">Department</label> 
	 <input type="radio" name="Issue" value="DIssue" id="depart" class="radioAuto" maxlength="30" tabindex=1 checked ="true" onClick=""/>
	 <label class="medium">Unit</label> 
	 	<input type="radio" name="Issue" value="UIssue" id="unit"  class="radioAuto" maxlength="20" tabindex=1 onClick="getUnit(this.value)"/>
	 	
	 <%if(depart_id==0){ %>
	   <select class="small2" name="departmentIdTemp" tabindex="1" id="departmentIdTemp" validate='Department Name,num,Yes'  >
				 <option value="">Select</option>
				<%for (MasDepartment department :departmentList ) {	%>
					<option value=<%=department.getId()%> ><%=department.getDepartmentName()%></option>
				<%}	%>
		</select> 
				<%}else{ %>
            <select  class="small2" name="departmentIdTemp" tabindex="1" id="departmentIdTemp" validate='Department Name,num,Yes'  >
				<%for (MasDepartment department :departmentList ) {if(depart_id==department.getId()){	%>
				 <option value=<%=department.getId()%>><%=department.getDepartmentName()%></option>
				<%for (MasDepartment department1 :departmentList ) {	%>
					<option value=<%=department1.getId()%> ><%=department1.getDepartmentName()%></option>
				<%}	}}
				%>
			</select>
				<%}%> 
				
				 <label class="medium">First AID</label> 
	 	<input type="radio" name="Issue" value="FirstAidIssue" id="unit"  class="radioAuto" maxlength="20" tabindex=1 onClick="getFirstAid(this.value)"/>


<div id="testDivR2"></div>
	 


<%} %>
<div class="clear" style="padding-top:5px;"></div>



<!--<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.issueDispensaryForm.<%=RequestConstants.ISSUE_DATE%>,event)" />


<input type="hidden" name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="35">
-->

<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>"></input>
<div class="clear"></div>
<!-- 
<%if(deptId==35){ %>
<div id="toggleText" style="display: none">
<%} %>-->
<%if(deptId==35){ %>

<label >Indent No.</label>
<div id="testDiv">
<select  name="<%= REQUEST_NO%>" tabindex="1" validate="Indent No. ,string,no" id="requestNo" onclick="isDispenserySelected();" onchange="submitForm('issueDispensaryForm','stores?method=searchIndentDetails');">
	<option value="0">Select  Indent No</option>
	<%for(Object[]  obj : storeInternalIndentMPOList){
		String tempDemandId="";
		tempDemandId=""+obj[0];
		if(demandNoSelected.equalsIgnoreCase(tempDemandId)){
			%>
			<option value="<%=obj[0] %>" selected="selected"><%=obj[1] %></option>
			<%
		}
	    else{

			%>
			<option value="<%=obj[0] %>"><%=obj[1] %></option>
			<%
		}
		//requestNoForAcc
}
%>
</select>
</div>

<%}else{ %>
<label >Indent No.</label>

<div id="testDiv">
<select  name="<%= REQUEST_NO%>" tabindex="1" validate="Indent No. ,string,no" id="requestNo" onclick="isDispenserySelected();"
	>
	<option value="0">Select Indent No</option>
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
<%} %>
<div id="testDivR">
<label>Indent Date<span>*</span></label>
<input type="text" class="date" name="IndentDate" id="IndentDate" value="<%=IndentDate%>" readonly="readonly" maxlength="50"/>
<input type="hidden" name="requestDate" id="IndentDate" value="<%=IndentDate%>" />
<!-- <label><span>*</span>Request By</label> -->
<input type="hidden" name="<%=REQUEST_BY%>" id="requestBy" validate="Request By,string,no" value="<%=Employee_id%>"/>
<input type="hidden" name="<%= REQUEST_BY_NAME%>" id="requestByName" validate="Request By,string,no" value="<%=Employee_name%>"/>
<input type="hidden" name="<%=REQUEST_BY%>" id="requestBy" validate="Request By,string,no" value="<%=Employee_id%>"/>
</div>
<script type="text/javascript">
<%
if(requestByEmpId != 0){%>
document.issueDispensaryForm.<%=REQUEST_BY%>.value = '<%=requestByEmpId%>';
<%
}
//demandListAjax
//previously this method is used on Demand No on Change; 

%>
</script>
<!--<label><span>*</span>Approved By</label>
--><!--<select name="<%=RequestConstants.APPROVED_BY%>" tabindex="1" id="approvedBy" validate="Approved By,String,yes">
					<option value="">Select</option>
					<%for (MasEmployee masEmployee :employeeList ) {String lastName="";
					if(masEmployee.getLastName()!=null){
					lastName=masEmployee.getLastName();
					}%>
				<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+lastName%></option>
				<%}%>
</select>
-->
<script type="text/javascript">
<%
if(approvedBy != 0){%>
document.issueDispensaryForm.<%=APPROVED_BY%>.value = '<%=approvedBy%>';
<%
}
//demandListAjax
//previously this method is used on Demand No on Change; 

%>
</script>
<!-- -
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



<label>Issued By<span>*</span></label>
<select name="<%= RequestConstants.ISSUED_BY%>" tabindex="1" id="issuedBy" validate="Issued By,String,no" onchange="if(testForAdjustLoanOut()&&cheackForSelect())submitForm('issueDispensaryForm','stores?method=searchIndentDetailsWithoutBar');">
					<option value="">Select</option>
					<%for (MasEmployee masEmployee :employeeList ) {
					String lastName="";
					if(masEmployee.getLastName() !=null){
					lastName=masEmployee.getLastName();
					}%>
				<option value=<%=masEmployee.getId()%> ><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName%></option>
				<%}
				%>
				
</select>
<script type="text/javascript">
<%
if(issuedBy != 0){%>
document.issueDispensaryForm.<%=ISSUED_BY%>.value = '<%=issuedBy%>';
<%
}
//demandListAjax
//previously this method is used on Demand No on Change; 

%>
</script>
</div>

<input type="hidden" name="internalIndentId" value="<%=internalIndentId%>" />
<div class="Clear"></div>
<input type="hidden" class="button" value="Next"  onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=next');}" align="right" />
<!-- <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkDateForIssueCiv()){submitForm('issueDispensaryForm','stores?method=addNextOrSubmitIssue&buttonName=submit');}"/>  -->
<div class="clear paddingTop15"></div>
<div class="Clear"></div>
<!--  <input type="button" class="buttonBig" value="IMPORT LOAN OUT" />-->
<div class="Clear"></div>
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
	<%if(indentTList.size()>0){ %>
	 <h4>Item Details</h4>
	
	 <div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">  
 	<table  colspan="7" id="indentDetails11" cellpadding="0" cellspacing="0">
  	<thead>
     	<tr>

			<th width="5%">Sl No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">A/U</th>
			<th width="13%">Qty</br>Demanded</th>
					
			<th width="13%">Barcode</th> 
				
			<th width="13%">Batch No1.</th>
			 <th width="13%">DOM</th>  
			<th width="13%">DOE</th>  
			<th width="13%">Manufacturer</th>  
			<th width="13%">Available</br>Stock</th>
			
			<th width="13%">Qty</br>Issued</th>
			<th width="3%">Add</th>
			<th width="3%">Delete</th>  
		</tr> 
      <!-- -
      <th width="6%">Loan Out Qty</th> -->
      <!--
       Loan Out Qty will be there for DIspensary Only
       If id in StoreSetup is equivalent to login Id then display this coloumn
       otherwise dont display.  
       -->
     
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
    	String manuDate="manuDate";
    	String manuDate2="manuDate";
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
			System.out.println(incTemp2+"CIV"+inc);
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
     		manuDate=manuDate2+(""+inc);
     		srNo = srNo2+(""+inc);

    	  %>

		<tr>
		<td width="5%">
		 <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
		 <input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
			<input type="text" size="2" tabindex="1"	value="<%=temp+inc%>" id="srNo<%=inc %>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="8" tabindex="1"
				name="<%=RequestConstants.ITEM_CODE%>"
				value="<%=object[1].toString() %>" id="codeItem<%=inc %>" />
				  <input	type="hidden" size="5" value="<%=object[0].toString() %>"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
				 <input	type="hidden" size="2" value="<%=object[0].toString() %>" name="itemId<%=inc %>" 
				id="itemId<%=inc %>" />
				<input
				type="hidden" size="2" value="<%=object[6].toString() %>"
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />
				</td>
			<td width="10%"><input type="text" tabindex="1" size="50"
				value="<%=object[2].toString() %>" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>"  id="nomenclature<%=inc%>"/></td>
			<td width="10%">
			<%
      String conv = null;
      try
      {
	  		conv = object[3].toString();
	  }
      catch(Exception e )
      {
	   	  e.printStackTrace();
	   	  conv="";
	  }
	  %> 
	  <input type="text" size="8" value="<%=conv%>" tabindex="1"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" />
			</td>
			
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
				value="<%=qtyIssueRequest%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}else if(qtyIssueRequest.equals(qtyIssueDB)){%>
			<input type="text"  size="8"
					value="<%=qtyIssueRequest%>" readonly="readonly"
					name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}else{%>
			<input type="text" tabindex="1" size="8"
				value="<%=qtyIssueRequest%>" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			<%}%>
			<%try{ %>
			<input type="hidden" value="<%=object[2].toString() %>" tabindex="1"
				id="<%=nameItem%>" name="<%=nameItem%>" />
			<%}catch(Exception e ){ %>
			<input type="hidden" value="" id="<%=nameItem%>" name="<%=nameItem%>" />
			<%} %>
			<input type="hidden" value="<%=object[9].toString() %>" tabindex="1"
				id="<%=srNo%>" name="<%=srNo%>" />
			</td>
			<td width="10%"><input type="text" size="10" value=""
				maxlength="30" tabindex="1" name="barCodeNo" id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>)" /></td>
			
			<td width="10%">
			<%
			List lis=new ArrayList();
			lis=(List)mapbatch.get(object[0]);
			%>
			<select name="batchNo<%= inc%>" id="batchNo<%= inc%>" class="small3" onchange="getDataForBarcode(this.value,<%=inc %>)" >
			<option value="0">Select Batch</option>
			<%for(int j=0;j<lis.size();j++){%>
			<option value="<%=lis.get(j)%>" ><%=lis.get(j)%></option>
			<%}%>
			</select>
			<%
	    		
			List lis1=new ArrayList();
			lis1=(List)mapbatch.get(object[0]);
			     for (int i = 0; i < lis1.size(); i++) {
			        	
     			 %> <script>

	          batchArray[<%=i%>]= new Array();
	          batchArray[<%=i%>][0] = "<%=lis1.get(i)%>";
	          batchArray[<%=i%>][1] = "<%=lis1.get(i)%>";
            </script> <% }%>
			<input type="hidden" name="batchId<%= inc%>" id="batchId<%= inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId" id="brandId<%= inc%>" size="10" readonly="readonly" value="" />
			</td>
			
		 <td width="10%"><input type="text" size="10" value=""
				maxlength="20" tabindex="1" name="manuDate"
				id="manuDate<%=inc %>" />
				
		</td>
		
		<td width="10%"><input type="text" size="10" value=""
				maxlength="20" tabindex="1" name="expiryDate"
				id="expiryDate<%=inc %>" />
			<input type="hidden" size="8" value=""
				maxlength="20" tabindex="1" name="expiryDate"
				id="expiryDate<%=inc %>" />
				<input type="hidden"
				value="" name="costPrice<%=counter %>"
				id="costPrice<%=inc %>"/>
		</td>
		
		<td width="10%"><input type="text" size="10" value=""
				maxlength="20" tabindex="1" name="manufact"
				id="manufact<%=inc %>" />
				
		</td>

		<!--<td width="10%">
			<input type="hidden" size="8" value=""
				maxlength="30" tabindex="1" name="barCodeNo" id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>);barCodefill(<%=inc %>);" />
				-->
		<td>
			<%if(inc<=stockList.size()){%> <input type="text" size="8"
				value="<%=stockList.get(inc-1) %>" id="availableStock<%=inc %>"
				class="medcaption" readonly /> <%}else{ %> <input type="text"
				 size="8" value="" id="availableStock<%=inc %>"
				class="medcaption" readonly /> <%} %>
			</td>


			<!-- Code commented by vikas For loan out
	       If id in StoreSetup is equivalent to login Id then display this coloumn
	       otherwise dont display.
	       -->
			<%--//if (storeSetup.getStoreDispensary().getId() == deptId) { %>
	      <!-- <td width="10%">
	      <input type="text" readonly="readonly" value="<%=map.get(storeIssueT.getItem().getId().toString()) %>"  name="loanOutQty" tabindex="2" align="right" />
	      </td>
	       -->
	      <% //} --%>
			<!-- Code commented by vikas For loan out-->
			<td width="10%">
			<%if(qtyIssueRequest.equals(qtyIssueDB)){ %>
			<input type="text" size="8" readonly="readonly"
				 value="<%=qtyIssueDB%>" name="qtyIssued<%=inc %>" tabindex="2"
				id="qtyIssued<%=inc %>"  onblur="if(checkQty(<%=inc %>)){setData(<%=inc %>)}" align="right"  />
			<%}else{%>
			<input type="text" size="8" readonly="readonly"
				 name="qtyIssued<%=inc %>" tabindex="2"
				id="qtyIssued<%=inc %>" onblur="if(checkQty(<%=inc %>)){setData(<%=inc %>)}"   align="right" />
			<%}%>
			<%if(object[12]!=null){ %><input type="hidden" id=brandId<%=inc %> name="brandId" value="<%=object[12].toString() %>"/>
				<% }%>
				
				<input type="hidden"
				value="<%=object[0].toString() %>" name="issuedItemId" tabindex="2"
				id=<%=issuedItemId%> align="right" /></td>
				<%
				Date reqDate  = new Date();
					if(object[10] != null){
						 reqDate = (Date)(object[10]);
					}
				%>
				
			<!--  <td width="3%">
			<%if(qtyIssueRequest.equals(qtyIssueDB)){%>
			<font face="arial" size="4" color="red">Issued</font>
			<%}else{ %>
			<input type="button" tabindex="1"
				class="buttonIssue" tabindex="1"
				onclick="{openPopupForBrand(this.value,'<%=object[7].toString()%>',<%=inc%>,<%=issueId %>,<%=object[6].toString() %>,<%=object[5].toString() %>,'<%=HMSUtil.convertDateToStringWithoutTime(reqDate)%>');}"
				name="Submit2" value=" " />
			<%}%>
		
				</td>-->
				<input type="hidden" name="indentDtId" id="indentDtId<%=inc %>"  />
				  <td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="addRowIssue(<%=inc %>);" /></td>
				<td width="8%"> <input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('indentDetails11','hdb',this);" tabindex="1" /></td>
		</tr>
		<% inc++;}  }
 	  %>
		<%
 	  }catch(Exception e ){e.printStackTrace();}
 	  if(requestNoForAcc>0){
 	  %>
	

	<%} %>
	</tbody>
	<input type="hidden" name="hdb" value="1" id="hdb" />
	<input type="hidden" name="counter" id="listsize"	value="<%=indentTList.size() %>" />
	</table>
	
	</div>
<input type="button" class="button" tabindex="1" onclick="if(validateIssue()){submitForm('issueDispensaryForm','stores?method=submitIssueForIndentwithoutbar');}" name="s" value="Save"  />
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<!--
<table id="batchDetails">
	<%

	int k = 0;
	%>
	 <tr>
		<td><input id="parentRowNo<%=k %>" name="parentRowNo" type="text" value=""/>
		<input 	id="batchId<%=k %>" name="batchId" type="text"
			value=""/></td>
		<td><input id="parentbatchNo<%=k %>" name="parentbatchNo"
			type="text" value=""/></td>
		<td><input id="parentAu<%=k %>" name="parentAu"
			type="text" value=""/></td>
		<td><input id="parentExpiry<%=k %>" name="parentExpiry"
			type="text" value=""/></td>
		<td><input id="parentstockIn<%=k %>" name="parentstockIn<%=k %>"
			type="text" value=""/></td>
		<td><input id="parentcostPrice<%=k %>" name="psrentcostPrice<%=k %>"
			type="text" value=""/></td>
		<td><input id="parentQtyTemp<%=k %>"
			name="parentQtyTemp<%=k %>" type="text"
			value=""/></td>
		<td><input id="parentQty<%=k %>"
			name="parentQty<%=k %>" type="text"
			value=""/></td>
		<td><input id="remarksTemp<%=k %>" name="remarksTemp<%=k %>"
			type="text" value=""/></td>
		<td><input id="remarks<%=k %>" name="remarks<%=k %>"
			type="text" value=""/></td>
	</tr>


</table> 
<input type="hidden" id="totalBatchId" name="batchNoCounter"
	value="<%=k %>" />
	<input type="hidden" id="cheildBatchId" name="cheildBatchId"
	value="<%=k %>" />-->
<%} %>
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
<div class="Clear"></div>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<div class="Clear"></div>
	<div class="paddingTop10"></div>
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


// javed khan

function civDisplay() {
	var civNo = document.depCiv.<%=DEMAND_NO%>.value	
	if (civNo == "0")
	{
	alert('Pl. select CIV No.');
	return;
	}
	
	document.depCiv.method="post";
	submitForm('depCiv','stores?method=getDepartmentIssueData&<%=DEMAND_NO%>='+civNo);
}


function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function testForAdjustLoanOut(deptName)
{
	var errorMessage="";
	formName="issueDispensaryForm"
	obj = eval('document.'+formName)
	
	//if(document.getElementById('issuedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Issue By \n"; 
	//if(document.getElementById('approvedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Approved By \n";
	//if(document.getElementById('requestBy').value == "")
		//errorMessage=errorMessage+"Please Select Requested By \n";
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
		   if(confirm("Are you sure, you want to import Demand items for issue ?")){
			return true;
			}else{
			return false;
			}
		}
		else
		{
			//alert(errorMessage)
			return false
		}
	}
	else
	{
		if((document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != ""))
		{
		if(confirm("Are you sure, you want to import Demand items for issue ?")){
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

// javed khan

function addRowIssue(rowVal)
{
	  var tbl = document.getElementById('indentDetails11');
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



	  var e1111 = document.createElement('input');
	  e1111.type = 'hidden';
	  e1111.name="tt8";
	  
	  e1111.id = 'issueQtyAndBatch'+iteration;
	  e1111.value="blank"; 
	

	  var e11111 = document.createElement('input');
	  e11111.type = 'hidden';
	  e11111.name='tt6';
	  e11111.id = 'quantityToIssueOverAll'+iteration;
	  e11111.value=""; 
	  cellRight0.appendChild(e1111);
	  cellRight0.appendChild(e11111);
	  


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemCode';
	  e1.id = 'codeItem'+iteration;
	  e1.size='8';
	  e1.value=document.getElementById('codeItem'+rowVal).value;
	  e1.readOnly=true;
	  cellRight1.appendChild(e1);
	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId';
	  e11.id = 'itemId'+iteration;
	  e11.value=document.getElementById('itemId'+rowVal).value; 
	  cellRight1.appendChild(e11);

	  var e114 = document.createElement('input');
	  e114.type = 'hidden';
	  e114.name='detailId'+iteration;
	  e114.id = 'detailId'+iteration;
	  e114.value=document.getElementById('itemId'+rowVal).value; 
	  cellRight1.appendChild(e114);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;
	  e2.readOnly=true;
		 
	 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
		
	  cellRight2.appendChild(e2);
	  			 
	  var cellRight22 = row.insertCell(3);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'idAu' + iteration;
	  e22.id = 'idAu' + iteration;
	  e22.size = '8';
	  e22.value=document.getElementById('idAu'+rowVal).value;
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);

	  var cellRight221 = row.insertCell(4);
	  var e221 = document.createElement('input');
	  e221.type = 'text';
	  e221.name = 'qtyRequested' + iteration;
	  e221.id = 'qtyRequested' + iteration;
	  e221.size = '8';
	  e221.value=document.getElementById('qtyRequested'+rowVal).value;
	  e221.readOnly=true;
	  cellRight221.appendChild(e221);
	  
	  var cellRight29 = row.insertCell(5);
	  var e29 = document.createElement('input');
	  e29.type = 'text';
	  e29.name = 'barCodeNo' + iteration;
	  e29.id = 'barCodeNo' + iteration;
	  e29.size = '10';
	//  e29.value=document.getElementById('qtyRequested'+rowVal).value;
	  e29.readOnly=true;
	  cellRight29.appendChild(e29);
	  
	  
	  var cellRight23 = row.insertCell(6);
	  var e23 = document.createElement('Select');
	  //e23.type = 'text';
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.className="small3";
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.onchange=function(){getDataForBarcode(this.value,iteration)};
  for(var i = 0;i<batchArray.length;i++ ){
	     e23.options[i+1] = new Option(batchArray[i][1],batchArray[i][0]);
		// e23.options[i+1] = new Option(document.getElementById('batchNo'+rowVal).option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML,document.getElementById('batchNo'+rowVal)option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML);
	    }
	//  e23.readOnly=true;
	 cellRight23.appendChild(e23);
	
	 var e246 = document.createElement('input');
	  e246.type = 'hidden';
	  e246.name = 'batchId' + iteration;
	  e246.id = 'batchId' + iteration;
	  e246.size = '10';
	  cellRight23.appendChild(e246);

	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId';
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	  cellRight23.appendChild(e24);

	  var cellRight30 = row.insertCell(7);
	  var e30 = document.createElement('input');
	  e30.type = 'text';
	  e30.name = 'manuDate' + iteration;
	  e30.id = 'manuDate' + iteration;
	  e30.size = '10';
	  e30.readOnly=true;	  
	  cellRight30.appendChild(e30);
	  	  
	  var cellRight25 = row.insertCell(8);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);

	  var cellRight251 = row.insertCell(9);
	  var e251 = document.createElement('input');
	  e251.type = 'text';
	  e251.name = 'manufact' + iteration;
	  e251.id = 'manufact' + iteration;
	  e251.size = '10';
	  e251.readOnly=true;	  
	  cellRight251.appendChild(e251);
	  
	  var cellRight6 = row.insertCell(10);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'availableStock' + iteration;
	  e6.id = 'availableStock' + iteration;
	  e6.size = '8';
	  e6.value=document.getElementById('availableStock'+rowVal).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);

	 // var cellRight34 = row.insertCell(8);
	  //var e34 = document.createElement('input');
	// e34.type = 'text';
	 // e34.name = 'qtyIssued' + iteration;
	 // e34.id = 'qtyIssued' + iteration;
	  //e34.size = '10';

	 // if(document.getElementById('qtyIssued'+rowVal).value=="")
	  //{	  
	  // e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	 // }else
		 // e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
	   
	   //cellRight34.appendChild(e34);
	  
	  var cellRight35 = row.insertCell(11);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '8';
	  e35.onblur = function(){setData(iteration)};
	  cellRight35.appendChild(e35); 


	  var cellRight10 = row.insertCell(12);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.name='Button';
	  e8.className = 'buttonAdd';
	  //e8.setAttribute('tabindex', 1);
	  e8.onclick = function(){addRowIssue(iteration)};
	  cellRight10.appendChild(e8);

	  //var cellRight21 = row.insertCell(16);
	  //var e21 = document.createElement('input');
	  //e21.type = 'button';
	  //e21.name='remarks'+iteration;
	  //e21.className = 'buttonAdd';
	  //e21.setAttribute('tabindex', 1);
	 // e21.onclick= function(){generateRowIssueCIV(iteration)};
	  //cellRight21.appendChild(e21);
	  
	  var cellRight11 = row.insertCell(13);
	  var e91 = document.createElement('input');
	  e91.type = 'button';
	  e91.className = 'buttonDel';
	  e91.name='remarks'+iteration;
	  e91.setAttribute('onClick', 'removeRow("indentDetails11","hdb",this);'); 
	  e91.setAttribute('tabindex','1');
	  cellRight11.appendChild(e91);
	  
	   
	 document.getElementById('listsize').value=listSize;
}



function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  //alert("l>"+tbl.rows.length);
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
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
	return true;
	}
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
	//if(document.getElementById("approvedBy").value=="")
	//{
	//	alert('Select The Approved By !!!');
	//	document.getElementById("approvedBy").focus();
	//	return false;
	//}

//	if(document.getElementById("issuedBy").value=="")
//	{
	//	alert('Select The Issue By !!!');
	//	document.getElementById("issuedBy").focus();
	//	return false;
	//}

	if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}else{
		return true;
	}
	
}

function getDataForBarcode(val,rowVal){
	


	 if(val!=""){
		 var itemId=document.getElementById('itemId'+rowVal).value;
		
			submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
	
	 }
	 }

function barCodefill(inc){
	var barCodeNo=document.getElementById('barCodeNo'+inc).value
	if(barCodeNo != ''){
		document.getElementById('qtyIssued'+inc).value =	document.getElementById('qtyRequested'+inc).value
		
	}
}



// add by javed khan

function checkQty(rowVal)
{	
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) <= parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			//var a=document.getElementById('qtyIssued'+rowVal).value;
			//var b=document.getElementById('batchStock'+rowVal).value;
    		//document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
			return true;
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyRequested'+rowVal).value)){
			alert("Qty Issued can't be greater than Qty Demanded.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
			return false;
		}
		
		return true;
}	
			
		
		
//add by javed khan
function setData(rowVal)
{
	//alert("setData"+rowVal);
	var sum = 0;
  	var totalQtyInHand = 0;
  	var totalAmt = 0;
  	var saleTax = 0;
	var saleTaxAmt = 0;
	var netSaleTax = 0;
	var uom ='';
	var qq="";
	var ss="";
	var inSum=0;
	var totalRows=parseInt(document.getElementById('counter').value);
	
	//var rowVal=parseInt(document.getElementById('rowVal').value);
	//var issueQty = parseInt(document.getElementById('issueQty').value);
 	for(var index = rowVal; index <= rowVal; index++ ){
 	
 		var qtyIssuedObj = eval(document.getElementById('qtyIssued'+index));
			//sum = parseFloat(sum) + parseInt(qtyIssuedObj.value);
 			if(parseInt(document.getElementById('qtyIssued'+index).value)!="0" ){
			qq=qq+','+document.getElementById('qtyIssued'+index).value
								+'@'+
								document.getElementById('batchNo'+index).value
								+'@'+
								document.getElementById('expiryDate'+index).value
								+'@'+
								document.getElementById('batchId'+index).value
								+'@'+'null';
								//document.getElementById('costPrice'+index).value;
 				}
 			
		document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);
		}
 	
		if(qq.length == 0){
			document.getElementById('issueQtyAndBatch'+rowVal).value = "blank";
		} else{
			document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);
		}

		var totalQtyIssued = eval(document.getElementById('quantityToIssueOverAll'));
		if(sum == 0){
			totalQtyIssued.value = '0';
		}else{
			totalQtyIssued.value = sum;
		}
		
		if(parseInt(totalQtyIssued.value)>parseInt(document.getElementById("reqQty").value)){
			alert('Qty Issued Value Should be less than or Equal to Requested Qty');
		 return false;
		}
 		//window.opener.document.getElementById('qtyIssued'+rowVal).value=totalQtyIssued.value;
 		
		//close();
 		return true;
}

function submitProtoAjaxForIssueBatch(formName,action){
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
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0){

	      	for (loop = 0; loop < items.childNodes.length; loop++) {

		   	 var item = items.childNodes[loop];

		   	 var message = item.getElementsByTagName("message")[0];
		   	 if(message.childNodes[0] == undefined)
		       {
	    			submitForm('issueDispensaryForm','stores?method=submitIssueForIndentwithoutbar');
		       }else{
		       		alert(message.childNodes[0].nodeValue);
		       }

		   	  }
		   	  }

	      }
	    }

	   // var counter = document.getElementById('countId').value;
	    var url=action+"&"+getNameAndData(formName)
	 /*   for(var i=1;i<=counter;i++){
	    	if(document.getElementById('issueId'+i).checked){
	    		url += "&batchId"+i+"="+document.getElementById('issueId'+i).value+"&qty"+i+"="+document.getElementById('qtyId'+i).value;
	    		}
	    }*/
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }

// javed khan

function submitProtoAjaxForBarcodeData(formName,action,rowVal) {
	 
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
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0){
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
	      		
		   	    var item = items.childNodes[loop];
		       // var id  = item.getElementsByTagName("id")[0];
		     var pvms  = item.getElementsByTagName("pvms")[0];
		   
		      //  var au  = item.getElementsByTagName("au")[0];
		      //  var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		     
		      // var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		      
		       var manu_Date=item.getElementsByTagName("dom")[0];
		       var bID=item.getElementsByTagName("batchId")[0];
		     //  var cost=item.getElementsByTagName("costPrice")[0];
	        	if(document.getElementById("codeItem"+rowVal).value!=""){
	        	if(pvms.childNodes[0].nodeValue==document.getElementById('codeItem'+rowVal).value){
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=bID.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=cost.childNodes[0].nodeValue
	        	document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	//document.getElementById("manuDate"+rowVal).value=manu_Date.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;

	        	document.getElementById("qtyIssued"+rowVal).readOnly=false;
	        	document.getElementById("qtyIssued"+rowVal).focus();
	        	}
	        	else{
	        	alert("The Barcode you entered is not For this item..");
	        	document.getElementById("barCodeNo"+rowVal).value="";
	        	}
	        	}
	        	else{
	        	//document.getElementById("codeItem"+rowVal).value=pvms.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=bID.childNodes[0].nodeValue;
	        	//document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	//document.getElementById("nameItem"+rowVal).value=name.childNodes[0].nodeValue;
	        	//document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	//document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	}

	      	}
	      	}
	      	else{
	      	alert("There are No items for this Barcode ");
	      document.getElementById("barCodeNo"+rowVal).value="";
	      	}
	      }
	    }
	    var url=action;

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }

// javed khan
function cheackForBatch(rowVal){
		if(rowVal>1){
	for(i=1;i<rowVal;i++){
		if(document.getElementById("batchNo"+rowVal).value==document.getElementById("batchNo"+i).value)
		{
			alert("Please select another Batch !!!");
			document.getElementById("batchNo"+rowVal).value="0";
			return false;		
		}	
	}		
}
	return true;
}

</script>