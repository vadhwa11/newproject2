<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employee.jsp  
 * Purpose of the JSP -  This is for Employee Details.
 * @author  Dipali  
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrSpecialistMaster"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation" %>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent" %>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>
<%@page import="jkt.hms.masters.business.HrorderlyMessMaster"%>
<%@page import="jkt.hms.masters.business.HrorderlyClassificationMaster"%>
<%@page import="jkt.hms.masters.business.HrLeaveTypeMaster"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeavechoice"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeaveAccount"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript">

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets');
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1');
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1');
animatedcollapse.init();
</script>
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
<SCRIPT LANGUAGE="JavaScript">
<!--<div id="xyz" style="font-size: 24px; display: none;">

var ShowTableFlag = 0;
function showTable(){
if(ShowTableFlag==0){
document.getElementById('searchresults').style.display= "";
ShowTableFlag=1;
}else{
document.getElementById('searchresults').style.display= "none";
ShowTableFlag=0;
}

}
function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	
function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("newUnitId").length;i++)
	 {
		 if (document.getElementById("newUnitId").options[i].value==unitId)
		 {
		 	document.getElementById("newUnitId").selectedIndex = i;
		 }
	 }
	
	}	
	function displayImage()
{
	var url = document.getElementById('fileId').value;
	document.getElementById('img1').style.display = 'inline';
	//document['pat'].src = 'file://'+url; 
	document.getElementById('img1').src=url;
	document.getElementById('photoUrlId').value =url;
}

function changeMandatoryField(){
     var FieldForLiving =document.getElementById('<%=LIVING %>').value;
     var FieldForRationMoney =document.getElementById('<%=RATION_MONEY_DRAWN%>').value;
     if(FieldForLiving=="0"){
     document.getElementById('spanLivingIn').style.display=""
     document.getElementById('spanLivingout').style.display="none"
     document.getElementById('spanMessName').style.display=""
     }
     if(FieldForLiving =="1"){
     document.getElementById('spanLivingIn').style.display="none"
     document.getElementById('spanLivingout').style.display=""
     document.getElementById('spanMessName').style.display="none"
     }
     if(FieldForLiving==""){
     document.getElementById('spanLivingIn').style.display="none"
     document.getElementById('spanLivingout').style.display="none"
     document.getElementById('spanMessName').style.display="none"
     }
     if(FieldForRationMoney=="r"){
     document.getElementById('spanRation').style.display=""
     document.getElementById('spanMoney').style.display="none"
     }
     if(FieldForRationMoney =="m"){
     document.getElementById('spanRation').style.display="none"
     document.getElementById('spanMoney').style.display=""
     }
     if(FieldForRationMoney==""){
     document.getElementById('spanRation').style.display="none"
     document.getElementById('spanMoney').style.display="none"
     }
     if(document.getElementById('PostedUnitId').value=="31")
    {
     document.getElementById('spanDepartment').style.display="none";
     }else{
     document.getElementById('spanDepartment').style.display="none";
     }
         
     	              
}
function LeaveChoiceFunction(){
	var leavechoice1=document.getElementById('<%=LEAVE_CHOICE_1 %>').value;
     var leavechoice2=document.getElementById('<%=LEAVE_CHOICE_2 %>').value;
     
       if(leavechoice1=="0" && leavechoice2=="0" ){
        } else {     
     
               if(leavechoice1==leavechoice2){
                    alert('Both choices cannot be same ');
   
                     document.getElementById('<%=LEAVE_CHOICE_2 %>').focus();
                }
           }
           }
function TorsFunction()
{
var Torsdate = document.getElementById('postedId').value;
document.getElementById('torsId').value=Torsdate;

}
function FieldCheck(){
    var LivingSelectField=document.getElementById('<%=LIVING %>').value;
    var RationMoneyField=document.getElementById('<%=RATION_MONEY_DRAWN%>').value;
    var MessNameField=document.getElementById('<%=MESS_NAME%>').value;
    var UnitNameField=document.getElementById('PostedUnitId').value;
    mesg="";
	if(LivingSelectField=="0"){
	    
	   if(document.getElementById('livingInId').value=="" ){
	   mesg=mesg+'\n Living In Date is Mandatory';
	   }
	   
	   if(document.getElementById('messName').value=="0" ){
	   mesg=mesg+ "\n Mess Name Mandatory " ;
	   }
	   	
	}else if(LivingSelectField=="1"){
	   if(document.getElementById('livingOutId').value==""){
	   mesg=mesg+'\n living out date is Mandatory ';
	   }
	}else if (LivingSelectField =="" ){
	   mesg=mesg+'select either LivingIn or LivingOut '
	}
	if(RationMoneyField=="r"){
	   if(document.getElementById('rationFromId').value=="" ){
	   mesg=mesg+'\n Ration From  Date is Mandatory';
	   }
	}else if(RationMoneyField=="m"){
	   if(document.getElementById('moneyId').value==""){
	   mesg=mesg+'\n Money Drawn date is Mandatory ';
	   }
	}else if(RationMoneyField=="" ){
	mesg=mesg + '\n select either Ration Drawn  or Money Drawn';
	}
	//if(UnitNameField=="31"){
 	//	if(document.getElementById('departmentId').value=="0"){
 	//	mesg=mesg+'\n Department Field Is Mandatory ';
 		//}	
	//}
	if(mesg!=""){
	alert(mesg);
	return false;
	}
	return true;
}	
 function generateRowMedicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		//tblCtrl[0].value=d.length-2;
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=0;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
					
			
		}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >=1){
	
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	  else
	  alert("There should be atleast one row")
	  
	}
	function compareTimeAgendaPoints()
    {


var dateOfBirth =document.getElementById('<%=DATE_OF_BIRTH%>').value;
var currentDate = document.getElementById('entryDateId').value;

var current =new Date(currentDate.substring(6),(currentDate.substring(3,5) - 1) ,currentDate.substring(0,2))
var DateOfBir =new Date(dateOfBirth.substring(6),(dateOfBirth.substring(3,5) - 1) ,dateOfBirth.substring(0,2))

 if(DateOfBir > current)
{
alert("Date Of Birth Should be less than CurrentDate");
document.getElementById('<%=DATE_OF_BIRTH%>').value="";
document.getElementById('<%=DATE_OF_BIRTH%>').focus();
return false;
}   
return true;
}

	     
    
function handleRem() {
  if(document.getElementById('disPen').value == "1")
  {
  document.getElementById('abc').style.display = "block";
  }
  else{
  document.getElementById('abc').style.display = "none";
  }
  }
function defaultleavevalue(i){
var flag=document.getElementById('LeaveType'+i).checked;
if(flag==true){
if(document.getElementById('Carryleave'+i).value=="")
document.getElementById('Carryleave'+i).value='0';
if(document.getElementById('Availed'+i).value=="")
document.getElementById('Availed'+i).value='0';
}
if(flag==false){
document.getElementById('Carryleave'+i).value="";
document.getElementById('Availed'+i).value="";
}
}  
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
       } 

// -->
</SCRIPT>

<%
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
		Map<String,Object> mapEmployee = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasUnit> chafbUnitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<HrSpecialistMaster> specialityList = new ArrayList<HrSpecialistMaster>();
		List<HrorderlyMessMaster> messList = new ArrayList<HrorderlyMessMaster>();
		List<HrorderlyClassificationMaster> classificationList = new ArrayList<HrorderlyClassificationMaster>();
		List<HrLeaveTypeMaster> hrleavetypemasterlist = new ArrayList<HrLeaveTypeMaster>();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		if(mapEmployee.get("hrleavetypemasterlist") != null){
			hrleavetypemasterlist = (List<HrLeaveTypeMaster>)mapEmployee.get("hrleavetypemasterlist");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("hrleavetypemasterlist") != null){
			hrleavetypemasterlist = (List<HrLeaveTypeMaster>)session.getAttribute("hrleavetypemasterlist");
		}
		
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
		
		if(mapEmployee.get("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)mapEmployee.get("empStatusList");
			session.setAttribute("empStatusList", empStatusList);
		}else if(session.getAttribute("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)session.getAttribute("empStatusList");
		}
		
		if(mapEmployee.get("costCenterList") != null){
			costCenterList = (List<MasCostCenter>)mapEmployee.get("costCenterList");
			session.setAttribute("costCenterList", costCenterList);
		}else if(session.getAttribute("costCenterList") != null){
			costCenterList = (List<MasCostCenter>)session.getAttribute("costCenterList");
		}
		
		if(mapEmployee.get("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)mapEmployee.get("empCategoryList");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
		}
		
		if(mapEmployee.get("gradeList") != null){
			gradeList = (List<MasGrade>)mapEmployee.get("gradeList");
			session.setAttribute("gradeList", gradeList);
		}else if(session.getAttribute("gradeList") != null){
			gradeList = (List<MasGrade>)session.getAttribute("gradeList");
		}
		
		if(mapEmployee.get("unitList") != null){
			unitList = (List<MasUnit>)mapEmployee.get("unitList");
			session.setAttribute("unitList", unitList);
		}else if(session.getAttribute("unitList") != null){
			unitList = (List<MasUnit>)session.getAttribute("unitList");
		}
		if(mapEmployee.get("chafbUnitList") != null){
			chafbUnitList = (List<MasUnit>)mapEmployee.get("chafbUnitList");
			session.setAttribute("chafbUnitList", unitList);
		}else if(session.getAttribute("chafbUnitList") != null){
			chafbUnitList = (List<MasUnit>)session.getAttribute("chafbUnitList");
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
		if(mapEmployee.get("serviceTypeList") != null){
			serviceTypeList = (List<MasServiceType>)mapEmployee.get("serviceTypeList");
			session.setAttribute("serviceTypeList", serviceTypeList);
		}else if(session.getAttribute("serviceTypeList") != null){
			serviceTypeList = (List<MasServiceType>)session.getAttribute("serviceTypeList");
		}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>(); 
		if(mapEmployee.get("searchEmployeeList") != null){
			searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
		}
		if(mapEmployee.get("masEmployeeDependentList") != null){
			masEmployeeDependentList = (List<MasEmployeeDependent>)mapEmployee.get("masEmployeeDependentList");
		}
		if(mapEmployee.get("masRelationList") != null){
			masRelationList = (List<MasRelation>)mapEmployee.get("masRelationList");
		}
		System.out.println("masEmployeeDependentList"+masEmployeeDependentList.size());
		 List<HrorderlyLeavechoice> hroderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		 if(mapEmployee.get("hroderlyleavechoiceList") != null){
			 hroderlyleavechoiceList = (List)mapEmployee.get("hroderlyleavechoiceList");
			}
		 List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		 if(mapEmployee.get("hrorderlyleaveaccountList") != null){
			 hrorderlyleaveaccountList = (List)mapEmployee.get("hrorderlyleaveaccountList");
			} 
		if(mapEmployee.get("specialityList") != null){
			specialityList = (List)mapEmployee.get("specialityList");
		}
		if(mapEmployee.get("messList") != null){
			messList = (List)mapEmployee.get("messList");
		}
		if(mapEmployee.get("classificationList") != null){
			classificationList = (List)mapEmployee.get("classificationList");
		}
		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message ="";
		if(map.get("message") != null){
			   message = (String)map.get("message");
			  
		}
		boolean arrival = false;
		if(map.get("arrival") != null){
			arrival = (Boolean)map.get("arrival");
		}
	    System.out.println("::2::"+arrival);      
		%>

<div id="contentHolder">
<h1 style="font-size: 15px; color: red;"><%=message %></h1>
<h6>Employee Arrival Update Form</h6>
<form name="employee" method="post" action=""
	onLoad="changeMandatoryField();"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasEmployee"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName">
<input type="hidden" name="title" value="Employee"> <input
	type="hidden" name="<%=JSP_NAME %>" value="employee"> <input
	type="hidden" name="pojoPropertyCode" value="EmployeeCode"> <input
	type="hidden" id="dclick" value="yes"> <input type="hidden"
	id="rowid" value="">
	<input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" />
	<input type="hidden" value="<%=arrival %>"
	name="arrival" id="arrival" />

<div class="Clear"></div>
<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%if(searchEmployeeList.size()>0){
  	MasEmployee masemployee =searchEmployeeList.get(0);
  		%> <label><span>*</span> Employee Code </label> <input id="codeId"
	type="text" name="<%= EMPLOYEE_CODE%>"
	value="<%=masemployee.getEmployeeCode()%>"
	validate="Employee Code,string,yes" MAXLENGTH="12" tabindex="1"/ >
<script>
				document.employee.<%=EMPLOYEE_CODE%>.focus();
			</script> <label>PreFix</label> <%if(masemployee.getPrefix()!=null && !masemployee.getPrefix().equals("")){ %>
<input type="text" name="preFix" id="preFix"
	value="<%= masemployee.getPrefix()%>"
	class="textbox_size20" tabindex="1" /> <%}else{ %> <input type="text"
	name="preFix" id="preFix" value="" 
	class="textbox_size20" tabindex="1" /> <%} %> <label><span>*</span>
Service No. </label> <input type="text" name="<%= SERVICE_NO%>"
	value="<%=masemployee.getServiceNo() %>"
	validate="Service No.,string,yes" MAXLENGTH="15" 
	class="textbox_size20" tabindex="1"/ disabled="disabled" > 
<div class="clear"></div>

<label>
SuFFix</label> <select id="suffixId" name="<%=SUFFIX%>"
	validate="Suffix,string,no" tabindex="1" >
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
				if(masemployee.getSuffix()!=null && !masemployee.getSuffix().equals("")){
				if( masemployee.getSuffix().equals(String.valueOf(i))){
		%>
	<option value="<%=i%>" selected="selected"><%=i%></option>
	<%}else{%>
	<option value="<%=i%>"><%=i%></option>
	<%}}else{ %>
	<option value="<%=i%>"><%=i%></option>
	<%}
				}%>
	<option value="-">-</option>
</select>

<label><span>*</span> Service Type </label> <select id="serviceTypeId"
	name="<%=SERVICE_TYPE_ID %>" tabindex="1"
	validate="Service Type,string,no" disabled="disabled">
	<option value="0">Select</option>

	<%
				         		if(serviceTypeList != null){ 	
				         			for (Iterator iter = serviceTypeList.iterator(); iter.hasNext();) {
				         				MasServiceType masServiceType = (MasServiceType) iter.next();
				         				if(masemployee.getServiceType()!=null){
				         				if(masemployee.getServiceType().getId().equals(masServiceType.getId())){
				         %><option value="<%=masServiceType.getId() %>"
		selected="selected"><%=masServiceType.getServiceTypeName() %></option>
	<%}else{ %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%		}}
				         				else{ %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%		}
				        			}
				        		 } 
				        %>
</select> <label><span>*</span> Rank </label> <select id="rankId"
	name="<%=RANK_ID %>" tabindex="1" validate="Rank,string,yes">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         				if(masemployee.getRank()!=null){
				         				if(masemployee.getRank().getId().equals(masRank.getId())){
				         %><option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName() %></option>
	<%}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%		}}
				         				else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%		}
				        			}
				        		 } 
				        %>
</select>  <select style="display: none;" id="titleId" name="<%=TITLE_ID %>"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         				if(masemployee.getTitle()!=null){
				         				if(masemployee.getTitle().getId().equals(masTitle.getId())){
				         %>
	<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName() %></option>
	<%}else{ %>
	<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>
	<%		}}
				         				else{ %>
	<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>
	<%		}
				        			}
				        		 } 
				        %>
</select>

<div class="Clear"></div>

<label><span>*</span> First Name</label>
 <input type="text"	name="<%=FIRST_NAME %>" value="<%=masemployee.getFirstName() %>"
	validate="First Name,name,yes" tabindex="1" MAXLENGTH="25" />
	
 <label>MiddleName</label> 
<%if(masemployee.getMiddleName()!=null && !masemployee.getMiddleName().equalsIgnoreCase("")){ %>
<input type="text" name="<%=MIDDLE_NAME%>"	value="<%=masemployee.getMiddleName() %>"
	validate="Middle Name,name,no" tabindex="1" MAXLENGTH="15" />
	 <%}else{ %>
<input type="text" name="<%=MIDDLE_NAME%>" value=""	validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" />
 <%} %>
	
<label>Last Name</label> 
<%if(masemployee.getLastName()!=null && !masemployee.getLastName().equalsIgnoreCase("")){ %>

<input type="text" name="<%=LAST_NAME %>" value="<%=masemployee.getLastName() %>" validate="Last Name,name,no"
	MAXLENGTH="15" tabindex="1" />
	<%}else{ %>
<input type="text" name="<%=LAST_NAME %>" value="" validate="Last Name,name,no"	MAXLENGTH="15" tabindex="1" />
<%} %>
<div class="Clear"></div>


<label><span>*</span> Category </label> <select id="employeeCategoryId"
	name="<%=EMPLOYEE_CATEGORY_ID %>" tabindex="1"
	validate="Category,string,yes">
	<option value="0">Select</option>

	<%
				         		if(empCategoryList != null){ 	
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         				if(masemployee.getEmpCategory()!=null){
				         				if(masemployee.getEmpCategory().getId().equals(masEmpCategory.getId())){
				         %>
	<option value="<%=masEmpCategory.getId() %>" selected="selected"><%=masEmpCategory.getEmpCategoryName() %></option>
	<%}else{ %>
	<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>

	<%	}}
				         				else{ %>
	<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>

	<%	}
				        			}
				        		 } 
				        %>
</select>  <select id="gradeId" style="display: none;"
	name="<%=EMPLOYEE_GRADE_ID %>" tabindex="1">
	<option value="0">Select</option>

	<%          	
		           		if(gradeList != null){ 	
		           			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
		           				MasGrade masGrade = (MasGrade) iter.next();
		           				if(masemployee.getGrade()!=null){
		           				if(masemployee.getGrade().getId().equals(masGrade.getId())){
		           %>
	<option value="<%=masGrade.getId() %>" selected="selected"><%=masGrade.getGradeName() %></option>
	<%}else{ %>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>

	<%}}
		           				else{ %>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>

	<%}
		          			}
		          		 } 
		          %>
</select> <select id="empStatusId" style="display: none;"
	name=<%=EMP_STATUS_ID %>>
	<option value="0">Select</option>

	<%
			           		if(empStatusList != null){ 	
			           			for (Iterator iter = empStatusList.iterator(); iter.hasNext();) {
			           				MasEmpStatus masEmpStatus = (MasEmpStatus) iter.next();
			           				if(masemployee.getEmployeeStatus()!=null){
			           				if(masemployee.getEmployeeStatus().getId().equals(masEmpStatus.getId())){
			           %>
	<option value="<%=masEmpStatus.getId() %>" selected="selected"><%=masEmpStatus.getEmpStatusName() %></option>
	<%}else{ %>
	<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>
	<%}}
			           				else{ %>
	<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>
	<%		}

			          			}
			          		 } 
			          %>
</select>



<label><span>*</span> Trade</label> <select id="unitId"
	name="<%=TRADE_ID %>" tabindex="1" validate="Trade,string,yes">
	<option value="0">Select</option>

	<%
				         		if(tradeList != null){ 	
				         			for (Iterator iter = tradeList.iterator(); iter.hasNext();) {
				         				MasTrade masTrade = (MasTrade) iter.next();
				         				if(masemployee.getTrade()!=null){
				         				if(masemployee.getTrade().getId().equals(masTrade.getId())){
				         %>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName() %></option>
	<%}else{ %>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%}}
				         				else{ %>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%}
				        			}
				        		 } 
				        %>
</select> <label><span>*</span> Unit(Posted To) </label> <select
	id="PostedUnitId" name="<%=UNIT_ID %>" tabindex="1"
	validate="Unit,string,yes" onchange="changeMandatoryField();">
	<option value="0">Select</option>

	<%
				         		if(chafbUnitList != null){ 	
				         			for (Iterator iter = chafbUnitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         				if(masemployee.getUnit()!=null){
				         				if(masemployee.getUnit().getId().equals(masUnit.getId())){
				         %>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName() %></option>
	<%}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		}}
				         				else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		}
								        	
				        			}
				        		 } 
				        %>
</select> 
<div class="Clear"></div>
<label>
Department </label> <select id="departmentId" name="<%=DEPARTMENT_ID %>"
	tabindex="1">
	<option value="0">Select</option>

	<%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           				if(masemployee.getDepartment()!=null){
			           				if(masemployee.getDepartment().getId().equals(masDepartment.getId())){
			           					%>

	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		}}
			           				else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		}
			          			}
			          		 } 
			          %>
</select>


<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('Joining-details-box1',expand_bca1);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca1
	alt=Expand src="/hms/jsp/images/minus1.gif" ; align=left /> <font
	class="boxtitle">Employee Joining Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=Joining-details-box1 style="display: block;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;">

<div class="Clear"></div>

<div class="blockFrame"> <label
	style="text-align: right;">Posted From</label> <select
	style="text-align: left; width: 97px;" id="newUnitId"
	name="<%=POSTED_UNIT_ID %>" tabindex="1"
	validate="Posted From,string,no">
	<option value="0">Select</option>

	<%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         				if(masemployee.getPostedUnit()!=null){
				         				if(masemployee.getPostedUnit().getId().equals(masUnit.getId())){
				         %>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName() %></option>
	<%}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%	}}
				         				else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%	}
				        			}
				        		 } 
				        %>
</select><IMG style="padding-left: 0px" SRC="/hms/jsp/images/s_search.gif"
	WIDTH="26" HEIGHT="26" style="cursor:pointer;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From">
	 <label>Vide</label> 
	 <%if(masemployee.getVide()!=null && !masemployee.getVide().equalsIgnoreCase("")){ %>
<input type="text" name="<%= VIDE%>" tabindex="1"	value="<%=masemployee.getVide() %>" validate="Vide,string,no"
	MAXLENGTH="75" /> <%}else{ %> <input type="text" name="<%= VIDE%>"
	tabindex="1" value="" validate="Vide,string,no" MAXLENGTH="75" /> 
	<%} %>	
	<label>Discipline pending</label> <select id="disPen"
	name="<%=DISCIPLINE_PENDING%>" tabindex="1" onchange="handleRem()">
	<%if(masemployee.getDisciplinePending()!=null ){
		if(masemployee.getDisciplinePending().equals("1")){ %>
	<option value="0">No</option>
	<option value="1" selected="selected">Yes</option>
	<%}else{ %>
	<option value="0" selected="selected">No</option>
	<option value="1">Yes</option>
	<%}}else{ %>
	<option value="0" selected="selected">No</option>
	<option value="1">Yes</option>
	<%} %>
</select> 
	
	
	

<div class="Clear"></div>

<label>Date of Posting In</label> <% if(masemployee.getPostedDate()!=null){ %>
<input type="text" id="postedId" tabindex="1" name="<%=POSTING_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getPostedDate()) %>"
	class="calDate" validate="Posted Date,date,no" onblur="TorsFunction();"
	MAXLENGTH="30" /> <%}else{ %> <input type="text" id="postedId"
	tabindex="1" name="<%=POSTING_DATE%>" value="" class="calDate"
	onblur="TorsFunction();" validate="Posted Date,date,no" MAXLENGTH="30" />
<%} %> <img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a from date,date,yes"
	onClick="setdate('<%=POSTING_DATE %>',document.getElementById('postedId'),event)" />



<label>TORS</label> <% if(masemployee.getTors()!=null){ %> <input
	type="text" id="torsId" tabindex="1" name="<%=TORS%>"
	onfocus="TorsFunction();"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getTors()) %>"
	class="calDate" validate="TORS,date,no" MAXLENGTH="30" /> <%}else{ %> <input
	type="text" id="torsId" tabindex="1" name="<%=TORS%>"
	onfocus="TorsFunction();" value="" class="calDate"
	validate="TORS,date,no" MAXLENGTH="30" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=TORS %>',document.getElementById('torsId'),event)" />

<label>POR sl.No.</label> <%if(masemployee.getPorSlNo()!=null && !masemployee.getPorSlNo().equalsIgnoreCase("")){ %>
<input type="text" name="<%= POR_SLNO%>" tabindex="1"
	value="<%=masemployee.getPorSlNo() %>" validate="Por Sl No.,string,no"
	MAXLENGTH="25" /> <%}else{ %> <input type="text" name="<%= POR_SLNO%>"
	tabindex="1" value="" validate="Por Sl No.,string,no" MAXLENGTH="25" />
<%} %>

<div class="Clear"></div>

<label><span>*</span>Living In/Out</label> <select id="<%=LIVING %>"
	name="<%=LIVING %>" tabindex="1" onChange="changeMandatoryField();">
	<option value="">Select</option>
	<%if(masemployee.getLivingInOut()!=null){
		if(masemployee.getLivingInOut().equals("0")){ %>
	<option value="0" selected="selected">Living In</option>
	<option value="1">Living Out</option>
	<% }else{ %>
	<option value="0">Living In</option>
	<option value="1" selected="selected">Living Out</option>
	<%}}else{ %>
	<option value="0">Living In</option>
	<option value="1">Living Out</option>
	<%} %>
</select> <label><span id="spanLivingIn" style="display: none">*</span>Living
In Date </label> <%if(masemployee.getLivingInDate()!=null){ %> <input type="text"
	id="livingInId" tabindex="1" name="<%=LIVING_IN_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getLivingInDate()) %>"
	class="calDate" MAXLENGTH="30" style="visibility: show" /> <%}else{ %> <input
	type="text" id="livingInId" tabindex="1" name="<%=LIVING_IN_DATE %>"
	value="" class="calDate" MAXLENGTH="30" style="visibility: show" /> <%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=LIVING_IN_DATE %>',document.getElementById('livingInId'),event)" />
<label><span id="spanLivingout" style="display: none">*</span>Living
Out Date </label> <%if(masemployee.getLivingOutDate()!=null){ %> <input
	type="text" id="livingOutId" tabindex="1" name="<%=LIVING_OUT_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getLivingOutDate()) %>"
	class="calDate" MAXLENGTH="30" style="visibility: show" /> <%}else{ %> <input
	type="text" id="livingOutId" tabindex="1" name="<%=LIVING_OUT_DATE %>"
	value="" class="calDate" MAXLENGTH="30" style="visibility: show" /> <%} %>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=LIVING_OUT_DATE %>',document.getElementById('livingOutId'),event)" />

<div class="Clear"></div>

<label><span>*</span>Ration / Money Drawn</label> <select
	id="<%=RATION_MONEY_DRAWN%>" tabindex="1"
	name="<%=RATION_MONEY_DRAWN%>" onChange="changeMandatoryField();">
	<option value="">Select</option>
	<%if(masemployee.getRationMoneyDrawn()!=null && !masemployee.getRationMoneyDrawn().equals("")){
		if(masemployee.getRationMoneyDrawn().equals("r")){ %>
	<option value="r" selected="selected">Ration Drawn</option>
	<option value="m">Money Drawn</option>
	<%}else if(masemployee.getRationMoneyDrawn().equals("m")){ %>
	<option value="r">Ration Drawn</option>
	<option value="m" selected="selected">Money Drawn</option>
	<% }}else{%>
	<option value="r">Ration Drawn</option>
	<option value="m">Money Drawn</option>
	<%} %>


</select> <label><span id="spanRation" style="display: none">*</span>Ration
Drawn From</label> <%if(masemployee.getRationDrawnFrom()!=null){ %> <input
	type="text" id="rationFromId" tabindex="1"
	name="<%=RATION_DRAWN_FROM%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getRationDrawnFrom())%>"
	class="calDate" MAXLENGTH="30" /> <%}else{ %> <input type="text"
	id="rationFromId" tabindex="1" name="<%=RATION_DRAWN_FROM%>" value=""
	class="calDate" MAXLENGTH="30" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=RATION_DRAWN_FROM %>',document.getElementById('rationFromId'),event)" />
<label><span id="spanMoney" style="display: none">*</span>Money
Drawn From</label> <%if(masemployee.getMoneyDrawnFrom()!=null){ %> <input
	type="text" id="moneyId" tabindex="1" name="<%=MONEY_DRAWN_FROM%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getMoneyDrawnFrom()) %>"
	class="calDate" MAXLENGTH="30" /> <%}else{ %> <input type="text"
	id="moneyId" tabindex="1" name="<%=MONEY_DRAWN_FROM%>" value=""
	class="calDate" MAXLENGTH="30" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=MONEY_DRAWN_FROM %>',document.getElementById('moneyId'),event)" />

<div class="Clear"></div>

<label><span id="spanMessName" style="display: none">*</span>
Mess Name </label> <select id="<%=MESS_NAME %>" tabindex="1"
	name=<%=MESS_NAME %>>
	<option value="0">Select</option>

	<%
				         		if(messList != null){ 	
				         			for (Iterator iter = messList.iterator(); iter.hasNext();) {
				         				HrorderlyMessMaster mess = (HrorderlyMessMaster) iter.next();
				         				if(masemployee.getMess()!=null){
				         				if(masemployee.getMess().getId().equals(mess.getId())){
				         %>
	<option value="<%=mess.getId() %>" selected="selected"><%=mess.getMessName() %></option>
	<%}else { %>
	<option value="<%=mess.getId() %>"><%=mess.getMessName() %></option>
	<%	}	}
				         				else { %>
	<option value="<%=mess.getId() %>"><%=mess.getMessName() %></option>
	<%		}
				        			}
				        		 } 
				        %>
</select> 

<% String monthName[]={"Select","Jan-Feb","Feb-Mar","Mar-Apr","Apr-May","May-Jun","Jun-Jul","Jul-Aug","Aug-Sep","Sep-Oct","Oct-Nov","Nov-Dec"};;
   String yeararray[]= date.split("/");
   String currentyear=yeararray[2];
   int leavechoiceid=0;
%> <label>Leave choice1</label> <select id="<%=LEAVE_CHOICE_1%>"
	tabindex="1" name="<%=LEAVE_CHOICE_1%>"
	onchange=" LeaveChoiceFunction();">
	<% if(hroderlyleavechoiceList!=null){
			for(int i=0 ;i<12;i++){
				 boolean set=true;
			 for(HrorderlyLeavechoice hrorderlyleavechoice1 : hroderlyleavechoiceList){
				if(hrorderlyleavechoice1.getYear().equals(currentyear) && Integer.parseInt(hrorderlyleavechoice1.getLeaveChoice1())==i && !hrorderlyleavechoice1.getLeaveChoice1().equals("0"))  
				{ set=false; leavechoiceid=hrorderlyleavechoice1.getId();
	   	%>
	<option value="<%=i %>" selected="selected"><%=monthName[i] %>
	</option>

	<%}} if(set){%>
	<option value="<%=i %>"><%= monthName[i]%></option>
	<%}}}else{
		     for(int i=0;i<12;i++){
		%>
	<option value="<%=i %>"><%= monthName[i]%></option>
	<%}} %>
</select> <label>Leave choice2</label> <select id="<%=LEAVE_CHOICE_2%>"
	tabindex="1" name="<%=LEAVE_CHOICE_2%>"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();">
	<% if(hroderlyleavechoiceList!=null){
			for(int i=0 ;i<12;i++){
				 boolean set=true;
			 for(HrorderlyLeavechoice hrorderlyleavechoice1 : hroderlyleavechoiceList){
				if(hrorderlyleavechoice1.getYear().equals(currentyear) && Integer.parseInt(hrorderlyleavechoice1.getLeaveChoice2())==i && !hrorderlyleavechoice1.getLeaveChoice1().equals("0"))  
				{ set=false;leavechoiceid=hrorderlyleavechoice1.getId();
	   	%>
	<option value="<%=i %>" selected="selected"><%=monthName[i] %>
	</option>

	<%}} if(set){%>
	<option value="<%=i %>"><%= monthName[i]%></option>
	<%}}}else{
		     for(int i=0;i<12;i++){
		%>
	<option value="<%=i %>"><%= monthName[i]%></option>
	<%}}
		
		%>
</select> <input type="hidden" tabindex="1" name="leavechoiceid"
	id="leavechoiceid" value="<%=leavechoiceid %>" />
<div class="Clear"></div>

<label>On PRC</label> <select id="<%=ON_PRC%>" tabindex="1"
	name="<%=ON_PRC%>">
	<option value="">Select</option>
	<%if(masemployee.getOnPrc()!=null && !masemployee.getOnPrc().equals("") ){
			if(masemployee.getOnPrc().equals("y")){
		
		%>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%}else if(masemployee.getOnPrc().equals("n")){ %>
	<option value="y">Yes</option>
	<option value="n" selected="selected">No</option>
	<%}}else{ %>
	<option value="y">Yes</option>
	<option value="n">No</option>
	<%} %>

</select> 
<%if(searchEmployeeList.size()>0){ %> <input type="hidden" name="empId"
	id="empId" tabindex="1" value="<%=searchEmployeeList.get(0).getId() %>" />
<input type="hidden" name="rank" id="rank" tabindex="1"
	value="<%=searchEmployeeList.get(0).getRank().getId() %>" /> <%} %>

<div id="abc" style="display: none;"><label>Discipline
Remarks </label>
<body onload="handleRem();"></body>
<%if(masemployee.getDisciplineRemarks()!=null && !masemployee.getDisciplineRemarks().equalsIgnoreCase("")){ %>
<textarea rows="" id="disRem" cols="" name="<%=DISCIPLINE_REMARKS %>"><%=masemployee.getDisciplineRemarks() %>	</textarea>
<%}else{ %> <textarea rows="" id="disRem" cols=""
	name="<%=DISCIPLINE_REMARKS %>">	</textarea> <%} %>
<div class="Clear"></div>

</div>
<label>Arrival Completed</label> <%if(masemployee.getArrivalCompleted()!=null){ %>
<input type="text" id="arrivalCompleted" tabindex="1"
	name="arrivalCompleted"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getArrivalCompleted()) %>"
	class="calDate" readonly="readonly" validate="Appointment Date,date,no"
	MAXLENGTH="30" /> <%}else{ %> <input type="text" id="arrivalCompleted"
	tabindex="1" name="arrivalCompleted" value="" class="calDate"
	readonly="readonly" validate="Appointment Date,date,no" MAXLENGTH="30" />
<%} %> <img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0"
	onclick="setdate('<%=date %>',document.getElementById('arrivalCompleted'),event)"
	validate="Pick a date" class="calender" />
	
	<label>Seniority/Enrollment Date</label>
	 <%if(masemployee.getAppointmentDate()!=null){ %>
<input type="text" id="appointmentId" tabindex="1"	name="<%=APPOINTMENT_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getAppointmentDate()) %>"
	class="calDate" readonly="readonly" validate="Appointment Date,date,no"
	MAXLENGTH="30" /> 
	<%	}else{ %> 
	<input type="text" id="appointmentId"
	tabindex="1" name="<%=APPOINTMENT_DATE%>" value="" class="calDate"
	readonly="readonly" validate="Appointment Date,date,no" MAXLENGTH="30" />
<%} %> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0"
	onclick="setdate('<%=APPOINTMENT_DATE %>',document.getElementById('appointmentId'),event)"
	validate="Pick a date" class="calender" />
	<div class="Clear"></div>
	
	<label>Date of Birth</label>
	 <%if(masemployee.getBirthDate()!=null){ %>
	 <input	type="text" id="dobId" name="<%=BIRTH_DATE%>"tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getBirthDate()) %>" 
	 class="calDate" readonly="readonly"
	validate="Birth Date,date,no" MAXLENGTH="30" />
	<%	}else{ %> 
	 <input	type="text" id="dobId" name="<%=BIRTH_DATE%>"tabindex="1" value="" 
	 class="calDate" readonly="readonly"
	validate="Birth Date,date,no" MAXLENGTH="30" />
	<%} %> 	
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=BIRTH_DATE %>',document.getElementById('dobId'),event)"
	validate="Pick a Birth date" class="calender" />
	
	<label>Date of Marriage</label> 
	 <%if(masemployee.getDateOfMarriage()!=null){ %>
	<input	type="text" id="dateOfMarriage" name="<%=DATE_OF_MARRIAGE%>"
	tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(masemployee.getDateOfMarriage()) %>" class="calDate" readonly="readonly"
	validate="Birth Date,date,no" MAXLENGTH="30" /> 
	<%	}else{ %> 
	<input	type="text" id="dateOfMarriage" name="<%=DATE_OF_MARRIAGE%>"
	tabindex="1" value="" class="calDate" readonly="readonly"	validate="Birth Date,date,no" MAXLENGTH="30" /> 
	
		<%} %> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=DATE_OF_MARRIAGE%>',document.getElementById('dateOfMarriage'),event)"
	validate="Pick a Birth date" class="calender" />
	
	
	
	</div>
</div>
</div>
</div>
</div>
<div class="Clear"></div>
<!-- dependent -->
<div style="width: 15px; height: 20px; float: left;"></div>
<div class="Clear"></div>
<div onClick="togPlus('Family-box1',expand_bca3);" class="collapsetag"
	style="float: left;">
<div class="blockTitle"><IMG id=expand_bca3 alt=Expand
	src="/hms/jsp/images/minus1.gif" ; align=left /> Employee Family
Detail</div>
<div class="blockTitleCurve"></div>
</div>
<div class="Clear"></div>
<div class=box-content id=Family-box1 style="display: block;">
<div class="blockFrame">
<div style="float: left;">
	<input type="button" class="delbutton" value="" onclick="removeRowMedicalBoard1(this,'amcDetailId')" align="right" /> 
	<input type="button" class="addbutton" value=""	onclick="generateRowMedicalBoard1('amcDetailId');" align="right" /> 
	<input type="hidden" size="1" value="0" name="noOfRecords" id="noOfRecords" />
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="amcDetailId">
	<tr>
		<th scope="col"><span>*</span>Relation</th>
		<th scope="col"><span>*</span>Name</th>
		<th scope="col">DOB</th>
		
	</tr>
	<tbody>
     <%if(masEmployeeDependentList!=null && masEmployeeDependentList.size()>0){
              for(MasEmployeeDependent masEmployeeDependent : masEmployeeDependentList){
    	 %>
     
		<tr>

			<td width="10%" style="padding-left: 50px;">
				<select	name="<%=FAMILY%>" id="<%=FAMILY %>" validate="Family,string,yes">
					<option value="">Select</option>
					<%  System.out.println("masRelationList::"+masRelationList.size());
					if(masRelationList!=null && masRelationList.size()>0){
							for(MasRelation masRelation : masRelationList){ 
								System.out.println("masRelation.getId():::"+masRelation.getId()+"::masEmployeeDependent.getRelation().getId()::"+masEmployeeDependent.getRelation().getId());
							   if(masRelation.getId().equals(masEmployeeDependent.getRelation().getId())){%>
					<option value="<%=masRelation.getId() %>" selected="selected" ><%=masRelation.getRelationName() %></option>
					<%}else{ %>
					<option value="<%=masRelation.getId() %>" ><%=masRelation.getRelationName() %></option>
					<%}}} %>
				</select>
			</td>
			<td width="10%" style="padding-left: 50px;">
			    <input type="text" name="<%=NAME %>" id="<%=NAME%>" value="<%= masEmployeeDependent.getEmployeeDependentName()%>" validate="Age,string,yes">
			</td>
			<td width="10%" style="padding-left: 50px;">
			    <%if(masEmployeeDependent.getDateOfBirth()!=null && !masEmployeeDependent.getDateOfBirth().equals("")){ %>
			    <input type="text" name="<%=DATE_OF_BIRTH %>" id="<%=DATE_OF_BIRTH%>" value="<%= HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getDateOfBirth())%>" onKeyUp="mask(this.value,this,'2,5','/');" onchange="compareTimeAgendaPoints();" MAXLENGTH="10" validate="Date Of Birth,date,no">
			    <%}else{ %>
			    <input type="text" name="<%=DATE_OF_BIRTH %>" id="<%=DATE_OF_BIRTH%>" value="" onKeyUp="mask(this.value,this,'2,5','/');" onchange="compareTimeAgendaPoints();" MAXLENGTH="10" validate="Date Of Birth,date,no">
			    <%} %>
			</td>
			
		</tr>
	<%}}else{%>
	<tr>

			<td width="10%" style="padding-left: 50px;">
				<select	name="<%=FAMILY%>" id="<%=FAMILY %>" validate="Family,string,yes">
					<option value="">Select</option>
					<% if(masRelationList!=null && masRelationList.size()>0){
							for(MasRelation masRelation : masRelationList){ %>
					<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName() %></option>
					<%}} %>
				</select>
			</td>
			<td width="10%" style="padding-left: 50px;">
			    <input type="text" name="<%=NAME %>" id="<%=NAME%>" validate="Age,string,yes">
			</td>
			<td width="10%" style="padding-left: 50px;">
			    <input type="text" name="<%=DATE_OF_BIRTH %>" id="<%=DATE_OF_BIRTH%>" onKeyUp="mask(this.value,this,'2,5','/');" onchange="compareTimeAgendaPoints();" MAXLENGTH="10" validate="Date Of Birth,date,no">
			</td>
			
	</tr>
	<%} %>	
	</tbody>
</table>
</div>
</div>
<div class="Clear"></div>

<!-- end of dependent -->

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('Contact-details-box1',expand_bca2);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca2
	alt=Expand src="/hms/jsp/images/minus1.gif" ; align=left /> <font
	class="boxtitle">Employee Contact Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=Contact-details-box1 style="display: block;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;">

<div class="Clear"></div>

<div class="blockFrame"><label>Mobile</label> <%if(masemployee.getCellNoEmergency()!=null && !masemployee.getCellNoEmergency().equals("")){ %>
<input type="text" name="<%= EMERGENCY_MOBILE%>" tabindex="1"
	value="<%=masemployee.getCellNoEmergency() %>"
	validate="Mobile,alphanumeric,no" MAXLENGTH="12"/ > <%}else{ %> <input
	type="text" name="<%= EMERGENCY_MOBILE%>" tabindex="1" value=""
	validate="Mobile,alphanumeric,no" MAXLENGTH="12"/ > <%} %> 
	<label>Office Phone</label>
	 <%if(masemployee.getTelNoOffice()!=null && !masemployee.getTelNoOffice().equals("")){ %>
<input type="text" name="<%= TELL_NO_OFFICE%>" tabindex="1"	value="<%=masemployee.getTelNoOffice() %>"
	validate="Office Phone,alphanumeric,no" MAXLENGTH=12/ > 
	<%}else{ %>
<input type="text" name="<%= TELL_NO_OFFICE%>" tabindex="1" value=""
	validate="Office Phone,alphanumeric,no" MAXLENGTH=12/ > 
	<%}%> 
	<label>Resi.Phone</label> <%if(masemployee.getTelNoResidence()!=null && !masemployee.getTelNoResidence().equals("")){ %>
<input type="text" name="<%= TELL_NO_RESIDENCE %>" tabindex="1"
	value="<%=masemployee.getTelNoResidence() %>"
	validate="Residence Phone,alphanumeric,no" MAXLENGTH="12"/ > <%}else { %>
<input type="text" name="<%= TELL_NO_RESIDENCE %>" tabindex="1" value=""
	validate="Residence Phone,alphanumeric,no" MAXLENGTH="12"/ > <%} %>

<label>Email Id</label> <%if(masemployee.getEmail()!=null && ! masemployee.getEmail().equals("")){ %>
<input type="text" name="<%= EMAIL %>" tabindex="1"
	validate="email Id,email,no" value="<%=masemployee.getEmail() %>"
	MAXLENGTH="30" /> <%}else{ %> <input type="text" name="<%= EMAIL %>"
	tabindex="1" validate="email Id,email,no" value="" MAXLENGTH="30" /> <%} %>
<br />
<label>Emp Url</label> <%if(masemployee.getUrl()!=null && !masemployee.getUrl().equals("")){ %>
<input type="text" name="<%= URL%>" tabindex="1"
	value="<%=masemployee.getUrl() %>" validate="Employee Url,string,no"
	MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'personnel?method=addEmployee')" />
<%}else{ %> <input type="text" name="<%= URL%>" tabindex="1" value=""
	validate="Employee Url,string,no" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'personnel?method=addEmployee')" />
<%} %>
</div>
</div>
</div>
</div>
</div>




<div class="Clear"></div>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('Leave-details-box1',expand_bca4);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca4
	alt=Expand src="/hms/jsp/images/plus1.gif" ; align=left /> <font
	class="boxtitle">Employee Leave Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=Leave-details-box1 style="display: none;">

<div class="Clear"></div>
<div class="tableHolderAuto">
<div class="blockFrame">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="amcDetailId">
	<tr>
		<th scope="col">Leave Type</th>
		<th scope="col">Carry Forward Leave</th>
		<th scope="col">Leave Availed Till Date</th>
	</tr>
	<tbody>
		<% int i=0;
		if(hrleavetypemasterlist.size()>0){
	   for(HrLeaveTypeMaster  hrleavetypemaster:hrleavetypemasterlist){
		  i++; 
       if(hrorderlyleaveaccountList.size()>0){
        boolean flag=true;	   
       for(HrorderlyLeaveAccount hrorderlyleaveaccount :hrorderlyleaveaccountList ){
	   if(!(hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type"))&& 
			   hrorderlyleaveaccount.getLeaveTypeId().equals(hrleavetypemaster.getId()) ){
%>
		<tr>
			<td width="10%"><input type="checkbox" name="LeaveType<%=i %>"
				tabindex="1" onclick="defaultleavevalue(<%=i %>);"
				id="LeaveType<%=i %>" value="<%=hrleavetypemaster.getId() %>"
				checked /> <label><%=hrleavetypemaster.getDetails() %></label></td>

			<td width="10%">
			<%if(hrorderlyleaveaccount.getOLeaveBalance()!=null){ %> <input
				type="text" name="Carryleave<%=i %>" tabindex="1"
				id="Carryleave<%=i %>"
				value="<%=hrorderlyleaveaccount.getOLeaveBalance() %>"
				onKeyUp="isNumber(this);" onchange="compareTimeAgendaPoints();"
				MAXLENGTH="10"> <%}%>
			</td>

			<td width="10%">
			<%if(hrorderlyleaveaccount.getLeaveAvailed()!=null){ %> <input
				type="text" name="Availed<%=i %>" tabindex="1" id="Availed<%=i %>"
				value="<%=hrorderlyleaveaccount.getLeaveAvailed() %>" id=""
				onKeyUp="isNumber(this);"> <%}%>
			</td>
		</tr>
		<% flag=false;
	}} if(flag && !hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type")){%>
		<tr width="10%">
			<td><input type="checkbox" name="LeaveType<%=i %>" tabindex="1"
				onclick="defaultleavevalue(<%=i %>);" id="LeaveType<%=i %>"
				value="<%=hrleavetypemaster.getId() %>" /> <label><%= hrleavetypemaster.getDetails()%></label>
			</td>
			<td width="10%"><input type="text" name="Carryleave<%=i %>"
				tabindex="1" id="Carryleave<%=i %>" onKeyUp="isNumber(this);"
				MAXLENGTH="10" /></td>
			<td width="10%"><input type="text" name="Availed<%=i %>"
				tabindex="1" id="Availed<%=i %>" onKeyUp="isNumber(this);"/ >
			</td>

		</tr>

		<%}}else{
      if(!hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type")){
%>
		<tr width="10%">
			<td><input type="checkbox" name="LeaveType<%=i %>" tabindex="1"
				onclick="defaultleavevalue(<%=i %>);" id="LeaveType<%=i %>"
				value="<%=hrleavetypemaster.getId() %>" /> <label><%= hrleavetypemaster.getDetails()%></label>
			</td>
			<td width="10%"><input type="text" name="Carryleave<%=i %>"
				tabindex="1" id="Carryleave<%=i %>" onKeyUp="isNumber(this);"
				MAXLENGTH="10" /></td>
			<td width="10%"><input type="text" name="Availed<%=i %>"
				tabindex="1" id="Availed<%=i %>" onKeyUp="isNumber(this);"/ >
			</td>

		</tr>
		<%}}}} %>
		<input type="hidden" name="hrleavetypemasterlist" tabindex="1"
			id="hrleavetypemasterlist" value="<%=hrleavetypemasterlist.size()%>" />

	</tbody>
</table>
</div>
</div>
</div>

<div class="Clear"></div>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('Bank-details-box1',expand_bca2);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca2
	alt=Expand src="/hms/jsp/images/plus1.gif" ; align=left /> <font
	class="boxtitle">Employee Bank Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=Bank-details-box1 style="display: none;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;">

<div class="Clear"></div>

<div class="blockFrame"><label>Bank Code</label> <%if(masemployee.getBankCode()!=null && !masemployee.getBankCode().equals("")){%>
<input type="text" name="<%= BANK_CODE%>" tabindex="1"
	value="<%=masemployee.getBankCode() %>" validate="Bank Code,string,no"
	MAXLENGTH="8"/ > <%}else{ %> <input type="text"
	name="<%= BANK_CODE%>" tabindex="1" value=""
	validate="Bank Code,string,no" MAXLENGTH="8"/ > <%} %> <label>Bank
A/C Code</label> <%if(masemployee.getBankAccountCode()!=null && !masemployee.getBankAccountNumber().equals("")){ %>
<input type="text" name="<%= BANK_ACCOUNT_CODE%>" tabindex="1"
	value="<%=masemployee.getBankAccountCode() %>"
	validate="Bank Account Code,string,no" MAXLENGTH="10" /> <%}else{ %> <input
	type="text" name="<%= BANK_ACCOUNT_CODE%>" tabindex="1" value=""
	validate="Bank Account Code,string,no" MAXLENGTH="10" /> <%} %> <label>A/C
Number</label> <%if(masemployee.getBankAccountNumber()!=null && !masemployee.getBankAccountNumber().equals("")){ %>
<input type="text" name="<%= BANK_ACCOUNT_NUMBER%>" tabindex="1"
	value="<%=masemployee.getBankAccountNumber() %>"
	validate="Bank Account Number,string,no" MAXLENGTH="20" /> <%}else{ %> <input
	type="text" name="<%= BANK_ACCOUNT_NUMBER%>" tabindex="1" value=""
	validate="Bank Account Number,string,no" MAXLENGTH="20" /> <%} %> <label>A/C
Head</label> <%if(masemployee.getAccountHead()!=null && !masemployee.getAccountHead().equals("")){ %>
<input type="text" name="<%= ACCOUNT_HEAD%>" tabindex="1"
	value="<%=masemployee.getAccountHead() %>"
	validate="Account Head,name,no" MAXLENGTH="10"/ > <%}else{ %> <input
	type="text" name="<%= ACCOUNT_HEAD%>" tabindex="1" value=""
	validate="Account Head,name,no" MAXLENGTH="10"/ > <%} %>
</div>
</div>
</div>
</div>
</div>


<div class="Clear"></div>

<div class="blockFrame"></div>
<input type="hidden" name="employee_id" id="employee_id"
	value="<%=masemployee.getId()%>" /> <input type="hidden"
	name="rankCategoryId" id="rankCategoryId"
	value="<%=masemployee.getRank().getRankCategory().getId()%>" />
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><input type="button" name="Update" id="Update"
	value="Update" class="button"
	onClick="if(FieldCheck()){submitForm('employee','hrOrderly?method=editEmployee');}"
	accesskey="a" /> <%if(masemployee.getStatus().equals("n")){ %> <input
	type="button" name="Delete" id="Delete" value="Activate" class="button"
	onClick="submitForm('employee','hrOrderly?method=deleteEmployee');"
	accesskey="u" /> <%} } %> <input type="button" name="Print Arrival"
	id="Print Arrival" class="button" value="Print Arrival "
	onclick="submitForm('employee','hrOrderly?method=generateArrivalReport');" />

<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <input type="hidden"
	name="<%= HOSPITAL_ID%>" value="" /> <input type="hidden"
	value="<%=request.getParameter("employeeId")%>" name="employeeId"%>

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
</div>
</form>
</div>
<script type="text/javascript">
var faqtable=new switchicon("icongroup2", "div") //Limit scanning of switch contents to just "div" elements
faqtable.setHeader('<img src="/hms/jsp/images/minus.gif" />', '<img src="/hms/jsp/images/plus.gif" />') //Set header HTML
faqtable.collapsePrevious(false) //Allow more than 1 content to be open simultanously
faqtable.setPersist(true, 0) //Enable persistence to remember last switch content states for 7 days
faqtable.init()
</script>


