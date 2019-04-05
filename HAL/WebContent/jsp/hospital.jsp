<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="jkt.hms.masters.business.MasCommand" %>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script> <%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchHospitalList = (ArrayList)map.get("searchHospitalList");
List<MasCommand>  commandList = new ArrayList<MasCommand>();
 commandList = (List)map.get("commandList");
String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
%> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }

%>
<div class="titleBg"><h2>SMC Master</h2></div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>SMC Code</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>" 	value="1" checked="checked" />
<label>SMC Name</label>
<input	type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>"  value="2" />
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Hospital Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'user?method=searchMasHospital')" />

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=searchHospital','checkSearch')"	tabindex=1 />
</div>
</form>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchHospitalList.size()>0)
		 {
			String strForCode = (String)map.get("hospitalCode");
			String strForCodeDescription = (String)map.get("hospitalName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>


<h4><a href="user?method=showHospitalJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchHospitalList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="user?method=showHospitalJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ADDRESS %>"], [4,"<%= CONTACT_NUMBER %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"command"] ];
	 statusTd = 8;
	</script></div>
<div class="clear"></div>
<form name="hospital" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasHospital"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HospitalName">
<input type="hidden" name="title" value="Hospital"> <input
	type="hidden" name="<%=JSP_NAME %>" value="hospital"> <input
	type="hidden" name="pojoPropertyCode" value="HospitalCode">


<div class=Block>
<label> SMC Code <span>*</span></label>
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="SMC Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label> SMC Name<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="SMC Name,string,yes" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'user?method=addHospital')" />
<script>
				document.hospital.<%=CODE%>.focus();
				</script>
<label>Contact Number</label>
<input type="text"	name="<%= CONTACT_NUMBER %>" value="" validate="Contact Number,num,no" MAXLENGTH="12" tabindex=1 />
<div class="Clear"></div>

<label>Address </label> <!--<textarea maxlength="5	0" rows="0" name="<%=ADDRESS %>" onkeyup="return ismaxlength(this)"  tabindex="1"></textarea>-->
<input type="text" name="<%= ADDRESS %>" value=""	validate="Address,string,no" MAXLENGTH="50" tabindex=1 class="auto" size="92"/>
<label>Command</label>
<select name="command"  id="commandId" validate="Command,number, no">
<% 
   if(commandList != null)
   {
	   for(MasCommand masCommand : commandList)
	    {%>
	    <option value="<%=masCommand.getId()%>" ><%=masCommand.getCommandName()%></option>
	   <%		   
	    }
   }
    
%>
 
</select>
</div>
<div class="Clear"></div>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>
<%@page import ="java.text.SimpleDateFormat" %>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>

<%@page import="jkt.hms.masters.business.EmpGroups"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js" ></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function checkforrecord(){

if(trimAll(document.getElementById('firstName').value) == ""){
 alert("Please select one record");
 return false;
}
if(trimAll(document.getElementById('status').value) == "InActive"){
 alert("First create it as Active record");
  return false;
 }
return true;
}
function setloginName(val){
	document.getElementById('loginName').value=val;
	document.getElementById('password').value=val;
}
function validateEmployee(){
var errMsg ="";
if(document.getElementById('codeId').value =="")
    errMsg ="Please fill Employee Code \n"
  if(document.getElementById('serviceNo').value =="")
    errMsg =errMsg+"Please fill Service No \n"
    if(document.getElementById('rankId').value ==0)
    errMsg =errMsg+"Please Select Rank \n"
     if(document.getElementById('unitId').value ==0)
    errMsg =errMsg+"Please Select Unit \n"

   if(document.getElementById('firstName').value =="")
    errMsg =errMsg+"Please fill first name \n"

    if(document.getElementById('lastName').value =="")
    errMsg =errMsg+"Please fill last name \n"

     if(document.getElementById('employeeCategoryId').value ==0)
    errMsg =errMsg+"Please Select Category \n"

    // if(document.getElementById('departmentId').value ==0)
    //errMsg =errMsg+"Please Select department \n"

     if(document.getElementById('TradeId').value ==0)
    errMsg =errMsg+"Please Select Trade \n"

    // if(document.getElementById('offPhone').value =="")
   // errMsg =errMsg+"Please fill office phone number \n"
    
    if(errMsg ==""){
     return true;
    }else{
    alert(errMsg)
    return false
    }

}

function validateEmployeeLogin(){
	var errMsg ="";

	  if(document.getElementById('serviceNo').value =="")
	    errMsg =errMsg+"Please fill Service No \n"
	    if(document.getElementById('rankId').value ==0)
	    errMsg =errMsg+"Please Select Rank \n"
	     if(document.getElementById('unitId').value ==0)
	    errMsg =errMsg+"Please Select Unit \n"

	   if(document.getElementById('firstName').value =="")
	    errMsg =errMsg+"Please fill first name \n"

	    if(document.getElementById('lastName').value =="")
	    errMsg =errMsg+"Please fill last name \n"

	     if(document.getElementById('employeeCategoryId').value ==0)
	    errMsg =errMsg+"Please Select Category \n"

	     //if(document.getElementById('departmentId').value ==0)
	    //errMsg =errMsg+"Please Select department \n"

	     if(document.getElementById('TradeId').value ==0)
	    errMsg =errMsg+"Please Select Trade \n"

	     //if(document.getElementById('offPhone').value =="")
	   // errMsg =errMsg+"Please fill office phone number \n"

	    if(document.getElementById('loginName').value =="")
    	    errMsg ="Please fill Login Name \n"
    		    
    	  if(document.getElementById('password').value =="")
    	    errMsg =errMsg+"Please fill Login Password \n"
		    
	

	    
	    if(errMsg ==""){
	     return true;
	    }else{
	    alert(errMsg)
	    return false
	    }

	}
function getLoginRequired(){
	var templetCnt=0;
	templetCnt=document.getElementById('templetCnt').value;
	if(document.getElementById('loginRequired').checked == true) {
		document.getElementById('loginName').disabled=false;
		document.getElementById('password').disabled=false;
		document.getElementById('appGroupId').disabled=false;
		//document.getElementById('empGroupId').disabled=true;
		document.getElementById('userDepartmentId').disabled=false;
		if(parseInt(templetCnt) > 0){
			for(var i=1;i<=templetCnt;i++){
				document.getElementById('templetId'+i).disabled=false;
			}
		}
	}else {
		document.getElementById('loginName').disabled=true;
		document.getElementById('password').disabled=true;
		document.getElementById('appGroupId').disabled=true;
		//document.getElementById('empGroupId').disabled=true;
		document.getElementById('userDepartmentId').disabled=true;
		document.getElementById('appGroupId').value="0";
		document.getElementById('userDepartmentId').value="0";
		if(parseInt(templetCnt) > 0){
			for(var i=1;i<=templetCnt;i++){
				document.getElementById('templetId'+i).disabled=true;
			}
		}
	} 
}

</script>
<%
String empcode = "";
		Map<String,Object> mapEmployee = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		
		
		if(mapEmployee.get("titleList") != null){
			titleList = (List<MasTitle>)mapEmployee.get("titleList");
			session.setAttribute("titleList", titleList);
		}else if(session.getAttribute("titleList") != null){
			titleList = (List<MasTitle>)session.getAttribute("titleList");
		}
		
		if(mapEmployee.get("departmentList") != null){
			departmentList = (List<MasDepartment>)mapEmployee.get("departmentList");
			session.setAttribute("departmentList", departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
		}
		
		
		
		if(mapEmployee.get("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)mapEmployee.get("empCategoryList");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
		}
	
		
		if(mapEmployee.get("unitList") != null){
			unitList = (List<MasUnit>)mapEmployee.get("unitList");
			session.setAttribute("unitList", unitList);
		}else if(session.getAttribute("unitList") != null){
			unitList = (List<MasUnit>)session.getAttribute("unitList");
		}
		if(mapEmployee.get("rankList") != null){
			rankList = (List<MasRank>)mapEmployee.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (List<MasRank>)session.getAttribute("rankList");
		}
		if(mapEmployee.get("tradeList") != null){
			tradeList = (List<MasTrade>)mapEmployee.get("tradeList");
			session.setAttribute("tradeList", tradeList);
		}else if(session.getAttribute("tradeList") != null){
			tradeList = (List<MasTrade>)session.getAttribute("tradeList");
		}
		
		if(mapEmployee.get("seqList") != null){
			seqList = (List<TransactionSequence>)mapEmployee.get("seqList");
			session.setAttribute("seqList", seqList);
		}else if(session.getAttribute("seqList") != null){
			seqList = (List<TransactionSequence>)session.getAttribute("seqList");
		}
		
		if(seqList.size() > 0){
		TransactionSequence	tran = (TransactionSequence)seqList.get(0);
		 empcode ="E"+(String.valueOf(""+tran.getTransactionSequenceNumber()));
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			Integer temp =  (Integer)session.getAttribute("hospitalId");
			hospitalId = temp.intValue();
		}
%>
<div id="empDiv">
<div class="division"></div>
<h4>Power User/System Administrator Details</h4>
		<div class="Clear"></div>
<div class="Block">
<input id="codeId" type="hidden" readonly="readonly" name="<%= EMPLOYEE_CODE%>" value="<%=empcode%>" validate="Employee Code,string,no"  MAXLENGTH="12"/  >
<label>Service No.<span>*</span></label>
<input type="text" name="<%= SERVICE_NO%>" value="" validate="Service No.,int,no"  MAXLENGTH="15"  tabindex=1  id="serviceNo" onblur="setloginName(this.value);submitProtoAjaxWithDivName('hospital','/hms/hms/user?method=getServiceNoDetails&serviceNo='+this.value,'empDiv');"/>
<label >Rank<span>*</span></label>
<select id="rankId" name=<%=RANK_ID %> validate="Rank,string,no" tabindex=1 >
				<option value="0">Select</option>
				            
				        <%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         %>
						<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
			
			<label >Title </label>
				<select id="titleId" name=<%=TITLE_ID %> validate="Title,string,no" tabindex=1 >
				<option value="0">Select</option>
				            
				        <%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         %>
						<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
	             <div class="Clear"></div>
            <label>First Name<span>*</span></label>
			<input type="text" id="firstName" name="<%=FIRST_NAME %>" value="" tabindex=1  validate="First Name,name,no"  MAXLENGTH="25"/>
			<label>Middle Name</label>
			<input type="text" id="middleName" name="<%=MIDDLE_NAME%>" value=""  tabindex=1  validate="Middle Name,name,no" MAXLENGTH="15" />
			<label>Last Name<span>*</span></label>
			<input type="text" id="lastName" name="<%=LAST_NAME %>" value=""  tabindex=1  validate="Last Name,name,no" MAXLENGTH="15" />
				  <div class="Clear"></div>
			<%--
			<label >Job Code</label>
			 --%>
			<input type="hidden" name="<%= EMPLOYEE_JOB_CODE %>" value=""  validate="Job Code,string,no" MAXLENGTH="8" />		
			
			<label>Trade/Branch<span>*</span></label>
				<select id="TradeId" name=<%=TRADE_ID %> validate="Trade/Branch,string,no" tabindex=1 >
				<option value="0">Select</option>
				            
				        <%
				         		if(tradeList != null){ 	
				         			for (Iterator iter = tradeList.iterator(); iter.hasNext();) {
				         				MasTrade masTrade = (MasTrade) iter.next();
				         %>
						<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
			      
			<label>Category<span>*</span></label>
				  <select id="employeeCategoryId" name=<%=EMPLOYEE_CATEGORY_ID %> validate="Category,string,no" tabindex=1 >
				  	<option value="0">Select</option>
				        <%
				         		if(empCategoryList != null){ 	
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         %>
						<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
	             </select>
	        			       
		<label>Unit<span>*</span></label>
		<select id="unitId" name=<%=UNIT_ID %> validate="Unit,string,no" tabindex=1 >
			<option value="0">Select</option>
				        <%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         %>
						<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>           
				        <%		
				        			}
				        		 } 
				        %>
			      </select>
	         <div class="Clear"></div>
            <%-- 	
            <label>Department<span>*</span></label>
				  <select id="departmentId" name=<%=DEPARTMENT_ID %> validate="Department,string,no">
					 <option value="0">Select</option>
			              
			          <%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           %>
							<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>           
			          <%		
			          			}
			          		 } 
			          %>
	            </select>--%>
	            <!-- default  Department=116, department is hide from view by order of girjesh  19 Oct 2012-->
			<input type="hidden" id="departmentId" name="<%= DEPARTMENT_ID%>" value="116" />
	            
			
			<label>Office Phone</label>
			<input type="text" id="offPhone" name="<%= TELL_NO_OFFICE%>" value="" tabindex=1  validate="Office Phone,alphanumeric,no"  MAXLENGTH=12/ >
			
			<div class="Clear"></div>
	   </div>
	  
	   	 <div class="Clear"></div>
		<%--
		<h4>Login Details<input type="checkbox" name="loginRequired" id="loginRequired" onclick="getLoginRequired()" checked="checked"/>(If Required)</h4>
		 --%>
		<div class="Clear"></div>
	    <div class="Block">
	    	<label> Login Name<span>*</span></label>
	    	<input type="text" name="loginName" id="loginName" value="" readonly="readonly" tabindex=1  validate="Login Name,string,no" />
   			<label>Password<span>*</span>  </label> 
			<input id="password" name=<%=PASSWORD%> type="password" maxlength="15" tabindex="1" readonly="readonly" validate="Password,string,no" /> 
<%--End of Code for Login Menu Assign  --%>
	<div class="division"></div>
			<input type="hidden" id="status" name="<%=STATUS %>" value="" />
			<input id="employeeId" type="hidden" readonly="readonly" name="<%= EMPLOYEE_ID%>" value="0"/>
<input id="loginId" type="hidden" readonly="readonly" name="loginId" value="0"/>
	    </div>
	    </div>
	<!--  End of empDiv --> 
<div id="edited"></div>

<input type="button" name="Submit11" id="addbutton" value="Add"
	class="button"
	onClick="if(validateEmployeeLogin()){submitForm('hospital','user?method=addHospital')}"
	accesskey="a" tabindex=1 />
	<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
	 <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('hospital','user?method=editHospital')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('hospital','user?method=deleteHospital&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="submitFormForButton('hospital','/hms/hms/user?method=showHospitalJsp')" accesskey="r" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('hospital','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> 
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="admin" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "SMC Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "SMC Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Address"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= ADDRESS%>"

data_header[3] = new Array;
data_header[3][0] = "Contact Number"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%= CONTACT_NUMBER %>";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Command"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "command";

data_arr = new Array();

<%
Iterator itr=searchHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasHospital  masHospital = (MasHospital)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHospital.getId()%>
data_arr[<%= counter%>][1] = "<%=masHospital.getHospitalCode()%>"
data_arr[<%= counter%>][2] = "<%= masHospital.getHospitalName()%>"

<%
String addressSmc="";
if(masHospital.getAddress()!=null){
	addressSmc=masHospital.getAddress();
}
%>
data_arr[<%= counter%>][3] = "<%=addressSmc%>"
data_arr[<%= counter%>][4] = "<%= masHospital.getContactNumber()!=null?masHospital.getContactNumber():""%>"

data_arr[<%= counter%>][5] = "<%= masHospital.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masHospital.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masHospital.getLastChgTime() %>"
<% if(masHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%
 for(MasCommand command : commandList)
       {
	 if(masHospital.getCommand().getId().equals(command.getId()) && command.getStatus().equals("y")){%>
		data_arr[<%= counter%>][9] = "<%=command.getCommandName()%>"
	<%}else if(masHospital.getCommand().getId().equals(command.getId()) && command.getStatus().equals("n")){%>
		data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=command.getCommandName()%>";
		
	<%}
}%>
<%
		     counter++;
}
%>
 
formName = "hospital"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
