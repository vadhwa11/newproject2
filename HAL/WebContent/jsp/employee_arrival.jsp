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
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasRelation" %>
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
<%@page import="jkt.hms.masters.business.MasRelation;"%>
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
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
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

var rankIdArray=new Array();
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
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
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
     document.getElementById('spanDepartment').style.display="inline";
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
     
    
     

function FieldCheck(){
    var LivingSelectField=document.getElementById('<%=LIVING %>').value;
    var RationMoneyField=document.getElementById('<%=RATION_MONEY_DRAWN%>').value;
    var MessNameField=document.getElementById('<%=MESS_NAME%>').value;
    var UnitNameField=document.getElementById('PostedUnitId').value;
    var rankids=document.getElementById('rankId').value;
    var flag=true;
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
	for(i=0;i<rankForOfficer;i++){
	if(rankForOfficer[i]==rankids)
	flag=false;
	}
	if(!flag){
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
	}
	//if(UnitNameField=="31"){
 		//if(document.getElementById('departmentId').value=="0"){
 		//mesg=mesg+'\n Department Field Is Mandatory ';
 	//	}	
	//}
	if(mesg!=""){
	alert(mesg);
	return false;
	}
	return true;
}	
function TorsFunction()
{
var Torsdate = document.getElementById('postedId').value;
document.getElementById('torsId').value=Torsdate;

}

function rankForOfficerfunction(){
var rankids=document.getElementById('rankId').value;
var flag=true;
for(i=0;i<rankIdArray.length;i++){
if(rankIdArray[i]==rankids)
{
document.getElementById('rankForOfficer').style.display="";
flag=false;
return;
}
}
if(flag){
document.getElementById('rankForOfficer').style.display="none";
}
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
		for(var i=0;i<tblCtrl.length;i++){
			tblCtrl[i].value="";
			
			}
					
			
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
function employeeExist()
{
var serviceNo = document.getElementById('serviceNo').value;
var serviceType = document.getElementById('serviceTypeId').value;
if(serviceNo !="" && serviceType !="0")
{
checkForEmployeeFromDB(serviceNo ,serviceType );
}
}
/*  if(confirm(first_Name.childNodes[0].nodeValue+' '+last_Name.childNodes[0].nodeValue+'\n'+
 ' with Service Number '+service_No.childNodes[0].nodeValue+'( '+service_Type.childNodes[0].nodeValue+
 ' ) already Exist \n Do you want to Update it ')){
	        document.getElementById('serviceTypeId').selectedIndex = 0;
	        document.getElementById('serviceNo').value ="";
	    	document.getElementById('serviceTypeId').focus();
	    	var obj = eval('document.employee');
	    	obj.action= 'hrOrderly?method=showEmployeeUpdateJsp&employeeId='+employeeId.childNodes[0].nodeValue ;
	    	obj.submit();
	      	}else{
	    	document.getElementById('serviceTypeId').selectedIndex = 0;
	        document.getElementById('serviceNo').value ="";
	  	document.getElementById('serviceTypeId').focus();
		}*/ 
function checkForEmployeeFromDB(serviceNo , serviceType) {
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
        
      	var items =xmlHttp.responseXML.getElementsByTagName('Employees')[0];
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var service_No  = item.getElementsByTagName("ServiceNo")[0];
	        var employeeId =  item.getElementsByTagName("employeeId")[0] 
	        var service_Type  = item.getElementsByTagName("ServiceType")[0];
	        var flag  = item.getElementsByTagName("flag")[0];
	        var first_Name  = item.getElementsByTagName("FirstName")[0];
	        var last_Name  = item.getElementsByTagName("LastName")[0];
	        if(flag.childNodes[0].nodeValue == 'false' ){
	        	
	        	if(confirm(first_Name.childNodes[0].nodeValue+' '+last_Name.childNodes[0].nodeValue+'\n with Service Number '+service_No.childNodes[0].nodeValue+'( '+service_Type.childNodes[0].nodeValue+' ) already Exist \n Are you want to update'))
	        	{ 
	    			obj = eval('document.employee');
	    			obj.action = 'hrOrderly?method=showEmployeeUpdateJsp&arrival=true&employeeId='+employeeId.childNodes[0].nodeValue ;
	    			obj.submit();
	      		}else{
	    		    document.getElementById('serviceTypeId').selectedIndex = 0;
	                document.getElementById('serviceNo').value ="";
	    	        document.getElementById('serviceTypeId').focus();
	    		}
      	} 
      }
    }
    }
    var url="hrOrderly?method=checkEmployeeFromDB"+"&serviceNo="+serviceNo+"&serviceType="+serviceType ;
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
  
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
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> rankForOfficerList = new ArrayList<MasRank>();		
		List<MasTrade> tradeList = new ArrayList<MasTrade>();		
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<HrorderlyMessMaster> messList = new ArrayList<HrorderlyMessMaster>();
		List<HrLeaveTypeMaster> hrleavetypemasterlist = new ArrayList<HrLeaveTypeMaster>();
		
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
		if(mapEmployee.get("masRelationList")!=null ){
			masRelationList=(List<MasRelation>)mapEmployee.get("masRelationList");
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
		if(mapEmployee.get("rankList") != null){
			rankList = (List<MasRank>)mapEmployee.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (List<MasRank>)session.getAttribute("rankList");
		}
		if(mapEmployee.get("rankForOfficerList") != null){
			rankForOfficerList = (List<MasRank>)mapEmployee.get("rankForOfficerList");
			session.setAttribute("rankForOfficerList", rankForOfficerList);
		}else if(session.getAttribute("rankForOfficerList") != null){
			rankForOfficerList = (List<MasRank>)session.getAttribute("rankForOfficerList");
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
		
		
				
		if(mapEmployee.get("messList") != null){
			messList = (List)mapEmployee.get("messList");
		}
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message = "";
		if(mapEmployee.get("message") != null){
			message =(String)mapEmployee.get("message");
			   out.println(message);
			 }
		
			ArrayList chafbUnitList = new ArrayList();
			if(mapEmployee.get("chafbUnitList") != null){
			chafbUnitList = (ArrayList)mapEmployee.get("chafbUnitList");
		}	
		
			
			
%>
<div id="contentHolder">
<h1 style="font-size: 15px; color: red;"><%=message %></h1>
<h6>Employee Arrival Form</h6>
<div class="Clear"></div>
<form name="employee" method="post" action=""
	onLoad="changeMandatoryField();"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasEmployee"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName">
<input type="hidden" name="title" value="Employee"> <input
	type="hidden" name="<%=JSP_NAME %>" value="employee"> <input
	type="hidden" name="pojoPropertyCode" value="EmployeeCode"> <input
	type="hidden" id="dclick" value="yes"> <input type="hidden"
	id="rowid" value=""> <input type="hidden" value="1"
	name="hiddenValue" id="hiddenValue" />


<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<label><span>*</span> Employee Code </label> 
<input id="codeId" type="text" name="<%= EMPLOYEE_CODE%>"
	value="<%=empcode%>" validate="Employee Code,string,yes"
	 tabindex="1"/ readonly="readonly" > 
<script>
				document.employee.<%=EMPLOYEE_CODE%>.focus();
</script> 
<label><span>*</span> Service Type </label> 
<select id="serviceTypeId"
	name=<%=SERVICE_TYPE_ID %> validate="Service Type,string,no"
	maxlength="8" tabindex="1" onblur="employeeExist();">
	<option value="0">Select</option>

	<%
				         		if(serviceTypeList != null){ 	
				         			for (Iterator iter = serviceTypeList.iterator(); iter.hasNext();) {
				         				MasServiceType masServiceType = (MasServiceType) iter.next();
				         %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> 
<label>PreFix</label> <input name="<%=PREFIX%>" 
	class="textbox_size20" tabindex="1" /> 
	<div class="Clear"></div>
	<label><span>*</span>Service No. </label> 
	<input type="text" id="serviceNo" name="<%= SERVICE_NO%>" value=""	validate="Service No.,string,yes" MAXLENGTH="10" class="textbox_size20" tabindex="1"/ onblur="employeeExist();" >
	
	 <label>SuFFix</label>
<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,string,no"
	tabindex="1" >
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select>


<label><span>*</span> Rank </label> <select id="rankId"
	name="<%=RANK_ID %>" onchange="rankForOfficerfunction();"
	validate="Rank,string,yes" tabindex="1">
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

<div class="Clear"></div>

<label><span>*</span> First Name</label> <input type="text"
	name="<%=FIRST_NAME %>" value="" validate="First Name,name,yes"
	MAXLENGTH="25" / tabindex="1"> <label>Middle Name</label> <input
	type="text" name="<%=MIDDLE_NAME%>" value=""
	validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" /> <label>
Last Name</label> <input type="text" name="<%=LAST_NAME %>" value=""
	validate="Last Name,name,no" MAXLENGTH="15" tabindex="1" />



<div class="Clear"></div>


<label><span>*</span> Category </label> <select id="employeeCategoryId"
	name="<%=EMPLOYEE_CATEGORY_ID %>" validate="Category,string,yes"
	tabindex="1">
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



<label><span>*</span> Trade</label> <select id="unitId"
	name="<%=TRADE_ID %>" tabindex="1" validate="Trade,string,yes">
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
</select> <label><span>*</span> Unit(Posted To) </label> <select
	id="PostedUnitId" name="<%=UNIT_ID %>" tabindex="1"
	validate="Unit,string,yes" onchange="changeMandatoryField();">
	<option value="0">Select</option>

	<%
				         		if(chafbUnitList != null){ 	
				         			for (Iterator iter = chafbUnitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select>
<div class="Clear"></div>
 <label><span id="spanDepartment" style="display: none">*</span>
Department </label> <select id="departmentId" name="<%=DEPARTMENT_ID %>"
	tabindex="1">
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
</select>


 <select style="display: none;" id="titleId" name="<%=TITLE_ID %>"
	tabindex="1">
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
  <select id="gradeId" style="display: none;"
	name="<%=EMPLOYEE_GRADE_ID %>" tabindex="1">
	<option value="0">Select</option>

	<%          	
		           		if(gradeList != null){ 	
		           			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
		           				MasGrade masGrade = (MasGrade) iter.next();
		           %>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>
	<%		
		          			}
		          		 } 
		          %>
</select> 
 <select id="empStatusId" style="display: none;"
	name="<%=EMP_STATUS_ID %>" tabindex="1">
	<option   value="0">Select</option>

	<%
			           		if(empStatusList != null){ 	
			           			for (Iterator iter = empStatusList.iterator(); iter.hasNext();) {
			           				MasEmpStatus masEmpStatus = (MasEmpStatus) iter.next();
			           %>
	<option  value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>
	<%		
			          			}
			          		 } 
			          %>
</select>
</div>
<div class="Clear"></div>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('visit-details-box1',expand_bca1);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca1
	alt=Expand src="/hms/jsp/images/minus1.gif" ; align=left /> <font
	class="boxtitle">Employee Joining Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=visit-details-box1 style="display: block;">
<div class=clearfix>
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;">
<div class="blockFrame"><label
	style="text-align: right;">Posted From</label> <select
	style="text-align: left; width: 105px;" "id="newUnitId"
	name="<%=POSTED_UNIT_ID %>" tabindex="1"
	validate="Posted From,string,no">
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
</select> <img class="newUnitId" SRC="/hms/jsp/images/s_search.gif" WIDTH="26"
	HEIGHT="26" style="cursor: pointer;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From"> <label>Vide</label> <input
	type="text" name="<%= VIDE%>" tabindex="1" value=""
	validate="Vide,string,no" MAXLENGTH="75" />
	
	
	 <label>Discipline pending</label> <select id="disPen"
	name="<%=DISCIPLINE_PENDING%>" tabindex="1" onchange="handleRem()">
	<option value="0">No</option>
	<option value="1">Yes</option>
</select>

<div id="abc" style="display: none;"><label>Discipline
Remarks </label> <textarea rows="" id="disRem" cols=""
	name="<%=DISCIPLINE_REMARKS %>" tabindex="1">	</textarea></div>
	

<div class="Clear"></div>


<label>Date of Posting In</label> <input type="text" id="postedId"
	name="<%=POSTING_DATE%>" value="" class="calDate"
	validate="Posted Date,date,no" MAXLENGTH="30" onblur="TorsFunction();"
	tabindex="1" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a from date,date,yes"
	onClick="setdate('<%=POSTING_DATE %>',document.getElementById('postedId'),event)" />

<label>TORS</label> <input type="text" id="torsId" name="<%=TORS%>"
	value="" class="calDate" onfocus="TorsFunction();"
	validate="TORS,date,no" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=TORS %>',document.getElementById('torsId'),event)" />

<label>POR sl.No.</label> <input type="text" name="<%= POR_SLNO%>"
	value="" validate="Por Sl No.,string,no" tabindex="1" MAXLENGTH="25" />

<div class="Clear"></div>

<label><span>*</span>Living In/Out</label> <select id="<%=LIVING %>"
	name="<%=LIVING %>" tabindex="1" onChange="changeMandatoryField();">
	<option value="">Select</option>
	<option value="0">Living In</option>
	<option value="1">Living Out</option>
</select> <label><span id="spanLivingIn" style="display: none">*</span>Living
In Date </label> <input type="text" id="livingInId" name="<%=LIVING_IN_DATE %>"
	value="" class="calDate" MAXLENGTH="30" tabindex="1"
	style="visibility: show" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a from date,date,yes"
	onClick="setdate('<%=LIVING_IN_DATE %>',document.getElementById('livingInId'),event)" />
<label><span id="spanLivingout" style="display: none">*</span>Living
Out Date </label> <input type="text" id="livingOutId"
	name="<%=LIVING_OUT_DATE %>" value="" class="calDate" MAXLENGTH="30"
	tabindex="1" style="visibility: show" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=LIVING_OUT_DATE %>',document.getElementById('livingOutId'),event)" />

<div class="Clear"></div>
<div id="rankForOfficer" style="display: none"><label><span>*</span>Ration
/ Money Drawn</label> <select id="<%=RATION_MONEY_DRAWN%>" tabindex="1"
	name="<%=RATION_MONEY_DRAWN%>" onChange="changeMandatoryField();">
	<option value="">Select</option>
	<option value="r">Ration Drawn</option>
	<option value="m">Money Drawn</option>
</select> <label><span id="spanRation" style="display: none">*</span>Ration
Drawn From</label> <input type="text" id="rationFromId"
	name="<%=RATION_DRAWN_FROM%>" tabindex="1" value="" class="calDate"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a from date,date,yes"
	onClick="setdate('<%=RATION_DRAWN_FROM %>',document.getElementById('rationFromId'),event)" />
<label><span id="spanMoney" style="display: none">*</span>Money
Drawn From</label> <input type="text" id="moneyId" name="<%=MONEY_DRAWN_FROM%>"
	tabindex="1" value="" class="calDate" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a from date,date,yes"
	onClick="setdate('<%=MONEY_DRAWN_FROM %>',document.getElementById('moneyId'),event)" />
</div>
<div class="Clear"></div>

<label><span id="spanMessName" style="display: none">*</span>
Mess Name </label> <select id="<%=MESS_NAME %>" tabindex="1"
	name=<%=MESS_NAME %>>
	<option value="0">Select</option>

	<%
				         		if(messList != null){ 	
				         			for (Iterator iter = messList.iterator(); iter.hasNext();) {
				         				HrorderlyMessMaster mess = (HrorderlyMessMaster) iter.next();
				         %>
	<option value="<%=mess.getId() %>"><%=mess.getMessName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label>Leave choice1</label> <select id="<%=LEAVE_CHOICE_1%>"
	name="<%=LEAVE_CHOICE_1%>" tabindex="1"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();">
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select> <label>Leave choice2</label> <select id="<%=LEAVE_CHOICE_2%>"
	name="<%=LEAVE_CHOICE_2%>" tabindex="1"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();">
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select>

<div class="Clear"></div>

<label>On PRC</label> <select id="<%=ON_PRC%>" tabindex="1"
	name="<%=ON_PRC%>">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
	<label>Seniority Date</label> <input
	type="text" id="appointmentId" name="<%=APPOINTMENT_DATE%>"
	tabindex="1" value="" class="calDate" readonly="readonly"
	validate="Appointment Date,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=APPOINTMENT_DATE %>',document.getElementById('appointmentId'),event)"
	validate="Pick a date" class="calender" />
	
	<label>Date of Birth</label> <input
	type="text" id="dobId" name="<%=BIRTH_DATE%>"
	tabindex="1" value="" class="calDate" readonly="readonly"
	validate="Birth Date,date,no" MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=BIRTH_DATE %>',document.getElementById('dobId'),event)"
	validate="Pick a Birth date" class="calender" />
	
	<div class="Clear"></div>
		<label>Date of Marriage</label> <input
	type="text" id="dateOfMarriage" name="<%=DATE_OF_MARRIAGE%>"
	tabindex="1" value="" class="calDate" readonly="readonly"
	validate="Birth Date,date,no" MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=DATE_OF_MARRIAGE%>',document.getElementById('dateOfMarriage'),event)"
	validate="Pick a Birth date" class="calender" />
	
	
</div>
</div>
</div>
</div>
</div>
<div class="Clear"></div>
<!--dependend--> 
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
	</tbody>
</table>
</div>
</div>
<div class="Clear"></div>
<!-- end of dependent-->
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<div onClick="togPlus('contact-details-box1',expand_bca3);"
	class="collapsetag" style="float: left;"><IMG id=expand_bca3
	alt=Expand src="/hms/jsp/images/minus1.gif" ; align=left /> <font
	class="boxtitle">Employee Contact Detail </font></div>


</div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div class=box-content id=contact-details-box1 style="display: block;">
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;">
<div class="Clear"></div>

<div class="blockFrame"><label>Mobile</label> <input type="text"
	name="<%= EMERGENCY_MOBILE%>" value=""
	validate="Mobile,alphanumeric,no" tabindex="1" MAXLENGTH="12"/ >

<label> Office Phone</label> <input type="text"
	name="<%= TELL_NO_OFFICE%>" value=""
	validate="Office Phone,alphanumeric,no" tabindex="1" MAXLENGTH=12/ >

<label>Resi. Phone</label> <input type="text"
	name="<%= TELL_NO_RESIDENCE %>" value=""
	validate="Residence Phone,alphanumeric,no" tabindex="1" MAXLENGTH="12"/ >

<label>Email Id</label> <input type="text" name="<%= EMAIL %>"
	validate="email Id,email,no" value="" tabindex="1" MAXLENGTH="30" /> <br />
<label style="display: none;">Emp Url</label> <input type="text"
	style="display: none;" name="<%= URL%>" value=""
	validate="Employee Url,string,no" tabindex="1" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'personnel?method=addEmployee')" />


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
<div class=clearfix>

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;">
<div class="Clear"></div>
<div class="blockFrame">
<div class="tableHolderAuto">
<table id="amcDetailId">
	<tr>
		<th scope="col">Leave Type</th>
		<th scope="col">Carry Forward Leave Of Pre. Year</th>
		<th scope="col">Leave Availed Till Date</th>

	</tr>
	<tbody>
		<%if(hrleavetypemasterlist.size()>0){%>
		<input type="hidden" name="hrleavetypemasterlist" tabindex="1"
			id="hrleavetypemasterlist" value="<%=hrleavetypemasterlist.size()%>" />
		<%
		
		int i=0;
	   for(HrLeaveTypeMaster  hrleavetypemaster:hrleavetypemasterlist){
		   i++;
		   if(!(hrleavetypemaster.getLeaveType().equalsIgnoreCase("All Type"))){
	%>
		<tr width="10%">
			<td><input type="checkbox" name="LeaveType<%=i %>"
				onclick="defaultleavevalue(<%=i %>);" tabindex="1"
				id="LeaveType<%=i %>" value="<%=hrleavetypemaster.getId() %>" /><label><%= hrleavetypemaster.getDetails()%></label>
			</td>
			<td width="10%"><input type="text" name="Carryleave<%=i %>"
				onclick="defaultleavevalue(<%=i %>);" tabindex="1"
				id="Carryleave<%=i %>" onKeyUp="isNumber(this);" MAXLENGTH="10" />
			</td>
			<td width="10%"><input type="text" name="Availed<%=i %>"
				onclick="defaultleavevalue(<%=i %>);" tabindex="1"
				id="Availed<%=i %>" onKeyUp="isNumber(this);"/ ></td>

		</tr>
		<%}
	   }
	   }%>
	</tbody>
</table>
</div>
</div>
</div>
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

<div class="blockFrame"><label>Bank Code</label> <input
	type="text" name="<%= BANK_CODE%>" tabindex="1" value=""
	validate="Bank Code,string,no" MAXLENGTH="8"/ > <label>Bank
A/C Code</label> <input type="text" name="<%= BANK_ACCOUNT_CODE%>" tabindex="1"
	value="" validate="Bank Account Code,string,no" MAXLENGTH="10" /> <label>A/C
Number</label> <input type="text" name="<%= BANK_ACCOUNT_NUMBER%>" tabindex="1"
	value="" validate="Bank Account Number,string,no" MAXLENGTH="20" /> <label>A/C
Head</label> <input type="text" name="<%= ACCOUNT_HEAD%>" tabindex="1" value=""
	validate="Account Head,name,no" MAXLENGTH="10"/ ></div>
</div>
</div>
</div>
</div>

<div class="Clear"></div>

<div class="blockFrame"></div>

<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><input type="button" name="add" id="edited"
	value="Add" class="button"
	onClick="if(FieldCheck()){submitForm('employee','hrOrderly?method=addEmployee');}"
	accesskey="a" /> <input type="button" name="edit" id="editbutton"
	value="Update" class="button"
	onClick="submitForm('employee','hrOrderly?method=editEmployee');"
	accesskey="u" /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('employee','hrOrderly?method=deleteEmployee&flag='+this.value);"
	accesskey="d" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <input type="hidden"
	name="<%= HOSPITAL_ID%>" value="" />

<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
</div>
<script type="text/javascript">
      <%  int counter=0;
	if(rankForOfficerList!=null){
	for(MasRank masranks:rankForOfficerList){%>
	
		rankIdArray[<%=counter%>]=<%=masranks.getId()%>
	
	<%	counter++;}
		}
	%>
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
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
function generateRowMedicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
					
			
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
      
      </script>
      
      </form>

</div>
