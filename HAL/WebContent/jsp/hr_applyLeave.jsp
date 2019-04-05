<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.lang.RandomStringUtils"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.UserManager"%>
<%@page import="jkt.hms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hms.masters.business.Holidaycalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.HrMasLeave"%>
<%@page import="jkt.hms.masters.business.HrMasLeaveTypeMediator"%>
<%@page import="jkt.hms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<!-- <script type="text/javascript" language="javascript" src="/erp/jsp/js/proto.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script> -->

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">
var $j = jQuery.noConflict();
</script>
<%
	session.setAttribute("save", true);
	Map map=(Map)request.getAttribute("map");
	List mgr=(List)map.get("manager");
	request.getSession(true);
	Users loggedUser =(Users)session.getAttribute(USERS);
	UserManager manager=null;
	if(mgr!=null && mgr.size()>0)
	{
		 manager=(UserManager)mgr.get(0);
	}
	
	List listOfHolidays=(List)map.get("listOfHolidays"); 
	List<HrEmployeeBalanceNew> leaveBalance=(List)map.get("leaveBalance");
	//System.out.println("in apply jsp :"+leaveBalance.size());

    List<HrMasLeave> listOfTypesOfLeaves=new ArrayList<HrMasLeave>();
    List<HrMasLeaveTypeMediator> listOfTypesOfLeavesMedType=new ArrayList<HrMasLeaveTypeMediator>();
    List<Integer> empDependents = new ArrayList<Integer>();
    List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
    List<Object> empMatAvailedOrNot = new ArrayList<Object>();
    List<Object> empPatAvailedOrNot = new ArrayList<Object>();
    String statusMaternity ="";
    String statusPaternity ="";
    MasEmployee loggedEmp = new MasEmployee();
    if(map.get("employee")!=null){
    	loggedEmp = (MasEmployee)map.get("employee");
    }
    
    if(map.get("listOfTypesOfLeaves")!=null){
    	listOfTypesOfLeaves = (List)map.get("listOfTypesOfLeaves");
    }
    
    if(map.get("listOfTypesOfLeavesMedType")!=null){
    	listOfTypesOfLeavesMedType = (List)map.get("listOfTypesOfLeavesMedType");
    }
    if(map.get("empDependents")!=null){
    	empDependents = (List)map.get("empDependents");
    }
    if(map.get("empMatAvailedOrNot")!=null){
    	empMatAvailedOrNot = (List)map.get("empMatAvailedOrNot");
    }
    if(map.get("empPatAvailedOrNot")!=null){
    	empPatAvailedOrNot = (List)map.get("empPatAvailedOrNot");
    }
    if(map.get("masDepartmentList")!=null){
    	masDepartmentList = (List)map.get("masDepartmentList");
    }
    if(empMatAvailedOrNot.size()>0){
    	statusMaternity = (String)empMatAvailedOrNot.get(0);
    }
    if(empPatAvailedOrNot.size()>0){
    	statusPaternity = (String)empPatAvailedOrNot.get(0);
    }
    int childrenCount = empDependents.get(0);
%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script>
<%
		Calendar calendar=Calendar.getInstance();

        String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
%>

serverdate = '<%=date+"/"+month+"/"+year%>'

var errorMsg = '';
window.onload=function()
{
showLeaveBalance(13);
document.getElementById('balance').value = '';
//document.getElementById('balanceLbl').innerHTML = ''
//document.getElementById('balanceLbl').innerHTML = 'Balance:';
//document.getElementById('allowDayLbl').innerHTML ='';
//document.getElementById('allowDayLbl').innerHTML ='Entitlement:';
}
function showLeaveBalance(idvalue){
	//alert(idvalue)
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :leaveBalance){
		int id = hrEmployeeBalance.getLeaveType().getLeaveType().getId();
		//String leaveBalance1 = new DecimalFormat("0.##").format((double)Float.valueOf(hrEmployeeBalance.getClosingBalance()));
		String leaveBalance1="";
		if(hrEmployeeBalance.getClosingBalanceYearly() != null){
			 leaveBalance1 = new DecimalFormat("0.##").format((double)Float.valueOf(hrEmployeeBalance.getClosingBalanceYearly()));
		}else{
			leaveBalance1 = new DecimalFormat("0.##").format((double)Float.valueOf("0"));
		}
		if(hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId() == 10){ %>

				document.getElementById('SLBalance').value='<%=hrEmployeeBalance.getClosingBalance()%>'
					
		<%} 
		if(hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId()== 12){ %>
				document.getElementById('CLBalance').value='<%=hrEmployeeBalance.getClosingBalance()%>'
					
		<%} 
		if(hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId()==13){ %>
				document.getElementById('PLBalance').value='<%=hrEmployeeBalance.getClosingBalance()%>'
				
		<%} 
		%>
		
		js =<%= leaveBalance1%>;
	
		//alert(js)
		if(idvalue == <%=id%> ){
	    	document.getElementById('hrMasLeaveTypeNewId').value =<%=hrEmployeeBalance.getLeaveType().getLeaveType().getId()%>
	    	document.getElementById('noOfDaysAllowedForPatMat').value =<%=hrEmployeeBalance.getLeaveType().getLeaveType().getAllowedDays()%>
	    	if(idvalue==13 && js > 90 ){
				alert("Your PL Balance crossed 90.Please Encash your PL");
			}
	    	
			document.getElementById('balance').value = <%= leaveBalance1%>;
	    	document.getElementById('leaveId').value = '<%= hrEmployeeBalance.getLeaveType().getId()%>'
	    	document.getElementById('balanceId').value='<%= hrEmployeeBalance.getId()%>';
	    	document.getElementById('leaveTaken').value='<%=hrEmployeeBalance.getTaken()%>';
		}
		if(idvalue == "" ){
	    	document.getElementById('noOfDaysAllowedForPatMat').value ='';
			document.getElementById('balance').value = '';
	    	document.getElementById('leaveId').value = '';
	    	document.getElementById('balanceId').value = '';
		}
		<%
	}
	%>
}	

	
	function chkDate()
	{
		
		var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
		obj1 = document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
		obj2 = document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value;
		obj3 = document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value;
		no_of_days = document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value;
		
		fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
		toDate= new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
		joiningDate = new Date(obj3.substring(6),(obj3.substring(3,5) - 1) ,obj3.substring(0,2));
		
		var nextDate=new Date(serverdate.substring(6),(serverdate.substring(3,5)),serverdate.substring(0,2));
		
		if(obj1 != "" && obj2 != "" && obj3 != "")
		{
			if(fromDate > nextDate)
			{
				errorMsg += "Only single month advance leaves can be applied.\n ";
				return false;
			}
			else if(fromDate > toDate)
			{
				errorMsg += "From Date should be smaller than To Date.\n ";
				return false;
			}
			else if(fromDate > joiningDate && toDate > joiningDate)
			{
				errorMsg += "Joining Date should be greater than both dates.\n ";
				return false;
			}
			else if(fromDate > joiningDate)
			{
				errorMsg += "Joining Date should be greater than From date.\n ";
				return false;
			}
			else if(toDate > joiningDate)
			{
				errorMsg += "Joining Date should be greater than To Date.\n ";
				return false;
			}
		}
		if(document.<%=APPLY_LEAVE%>.checkbox.checked && document.<%=APPLY_LEAVE%>.<%=HALF_DAY%>[1].checked==true){
			if(obj1 != "" && obj3 != "")
			{
				if(fromDate > nextDate)
				{
					errorMsg += "Only single month advance leaves can be applied.\n ";
					return false;
				}
				else if(fromDate > joiningDate)
				{
					errorMsg += "Joining Date should be greater than From date.\n ";
					return false;
				}
		  	}
		}
		if(document.<%=APPLY_LEAVE%>.checkbox.checked && document.<%=APPLY_LEAVE%>.<%=HALF_DAY%>[0].checked==true){
			if(obj1 != "")
			{
				if(fromDate > nextDate)
				{
					errorMsg += "Only single month advance leaves can be applied.\n ";
					return false;
				}
			}
		}

	    return true;
	}

var inCalculateDays = false;
function calculateDays(){

		inCalculateDays = true;
		
	fdate=document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
	tdate=document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value;
	if(fdate!="" && tdate!=""){
		inCalculateDays = true;
		count = '<%=RandomStringUtils.randomNumeric(3)%>';
		url="leave?method=getNoOfWorkingDays&abc="+count+"&fromDate="+fdate+"&toDate="+tdate;
		/* url = url+'&'+tokenName+'='+tokenValue; */
		
			
				
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
		  xmlHttp.onreadystatechange=function() {
			  callback(xmlHttp);
		};
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
	
}


function submitThisForm(){
	var returnVal = chkForCL();
	//alert(returnVal)
	if(returnVal){
		//if(chkForCLandSL()){
			 submitForm('<%=APPLY_LEAVE%>','leave?method=submitLeaveForm','chkDate','paternityCheck','noSatSunOrHoliday');
			
		//}
	}
}
function chkForCL(){
	var leavetake = document.getElementById('leaveTaken').value ;
	<%
	Calendar currentDateCal1 = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String currentDateString =dateFormat.format(currentDateCal1.getTime());
	
	currentDateCal1.setTime(HMSUtil.dateFormatterDDMMYYYY(currentDateString));
	
	java.util.Date joiningDate1 =(java.util.Date)loggedUser.getEmployee().getJoinDate();
	Calendar joiningDateCal1 = Calendar.getInstance();
	joiningDateCal1.setTime(joiningDate1);
	joiningDateCal1.add(Calendar.DAY_OF_MONTH, 3000);
	int diff = joiningDateCal1.compareTo(currentDateCal1);
%>
var diffval = <%=diff%>;

<% 
java.util.Date joiningDateCL =(java.util.Date)loggedUser.getEmployee().getJoinDate();
Date currentDateCL=new Date();
//System.out.println(joiningDateCL+"joiningDateCL");
String daysssCL=LeaveManagementUtil.getNumberOfDaysBetweenTwoDates(joiningDateCL,currentDateCL);
StringTokenizer stringDaysCL=new StringTokenizer(daysssCL);
String expDaysCL=stringDaysCL.nextToken(); 
%>	
expDaysInJS=<%=expDaysCL%>;


if(document.getElementById("leaveType").value==12){
	if(document.getElementById("noOfDays").value > 5){
   
       alert("You can not take more 5 CL at a time" );
       return false;
    } 
	//if(diffval == 1){
		//alert('You can not take Casual Leave upto 30 days of joining.');
		//return false;
	//}
	//alert(leavetake+"   "+expDaysInJS)
	if(leavetake >=12){
	if(expDaysInJS >365){
		if(leavetake ==15){
			 alert("You can not take more 15 CL in a year" );
			 return false;
		}else{
		return true;
		}
	}
	else{
		alert("You have not completed 1 year after joining so  not take more 12 CL in a year" );
		return false;
	}
	}
}else if(document.getElementById("leaveType").value==23){
	//alert(leavetake)
	if(leavetake ==7){
		 alert("You can not take more than 7 Special casual Leave in a year" );
		 return false;
	}else{
	return true;
	}
	
	
}else if(document.getElementById("leaveType").value==13){	
	
		if(document.getElementById("noOfDays").value > 5){
			var fromDate = document.getElementById("fromDate").value;
			var currentDate=serverdate.substring(0,2)+"/"+(serverdate.substring(3,5))+"/"+serverdate.substring(6);

	    	var ONE_DAY = 1000 * 60 * 60 * 24
	    	var date1_ms = new Date(fromDate.split("/")[2],fromDate.split("/")[1],fromDate.split("/")[0])
	   	 	var date2_ms = new Date(serverdate.substring(6),serverdate.substring(3,5),serverdate.substring(0,2))
	    	var diffDays = Math.round(Math.abs((date1_ms.getTime() - date2_ms.getTime())/(ONE_DAY)));
	    if(diffDays >=7){
	    	if(document.getElementById("noOfDays").value > 90){
	 	       alert("You can not take more than  90 Earned Leave at a time." );
	 	       return false;
	 	    } 
	    	
	    	
	    }else{
	    	alert("Please apply at least 7 days before.");
	    	 return false;
	    }
	    
		
		
	}
	
		
}else if(document.getElementById("leaveType").value==3){
		if(document.getElementById("noOfDays").value > 180){
			alert("You can not take more than 180 days Maternity Leave at a time." );
	      	 return false;
	}
}else if(document.getElementById("leaveType").value==22){
	if(leavetake == 545 ){ // 18 month
		alert("You can not take more than 18 months Extra Ordianry Leave in a service year." );
     	 return false;
	
	
}else{
	if(document.getElementById("noOfDays").value > 120){ // for 4 month
		alert("You can not take more than 120 days Extra Ordianry Leave at a time." );
      	 return false;
}else if(document.getElementById("noOfDays").value > 90 &&  document.getElementById("noOfDays").value < 121 ) {
	var medcer = document.getElementById("medCer").value;
	if (medcer== "y"){
		return true
	} else{
		alert("please select Medical Certificate as yes." );
     	 return false;
	}
	
}
	
}
}
return true;
}
function callback(http_request) {
	
    
    if (http_request.readyState == 1 || http_request.readyState==2 || http_request.readyState==3 || http_request.readyState==0) {
    document.<%=APPLY_LEAVE%>.apply.disabled = 'disabled';
    document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = 'calculating ...';
   
    document.getElementById('waitMessage').style.display = 'block';
    }
    
    if (http_request.readyState == 4 || http_request.readyState=="complete") {
     
     var response = http_request.responseText;
    
     var responsearr = new Array(3);
     responsearr = response.split("$");
     var dys = responsearr[0];
     var holiday=responsearr[1];
    
     var typeFlag= "";
     if(responsearr[2] != "")
     	typeFlag=responsearr[2];
    
     typeFlag = "";
     document.<%=APPLY_LEAVE%>.holiday.value = holiday;
     document.<%=APPLY_LEAVE%>.typeFlag.value = typeFlag;
     document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = dys;
     inCalculateDays = false;
     document.<%=APPLY_LEAVE%>.apply.disabled = '';	
     document.getElementById('waitMessage').style.display = 'none';
    }
}

function availedRh(){
type=document.getElementById("leaveType").value;

enteredDate=document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
enteredMonth=enteredDate.substring(3,5);
if(type==7){
	<%
		if(map.get("listOfRhAvailed")!=null){
			List listOfRhAvailed=(List)map.get("listOfRhAvailed");
			if(listOfRhAvailed.size()==1){
					HrLeaveDetails availedRH=(HrLeaveDetails)listOfRhAvailed.get(0);
					Date availedRh=(Date)availedRH.getFromDate();
					int availRhMonth=availedRh.getMonth();
					if(availRhMonth<=6){%>
					availRhMonth=<%=availRhMonth%>;
					if(enteredMonth<=6){
						alert("You have already availed RH of first half");
						visibleHidden(type);
						resetValues(type);
						readonlyValues(type);
						document.getElementById("leaveType").selectedIndex=0;
						document.getElementById("listOfRestrictedForm").style.display ='none';
						manageCalendar(1);
						}
					<%}
					if(availRhMonth>6){%>
						if(enteredMonth>6){
						alert("You have already availed RH of second half.");
						visibleHidden(type);
						resetValues(type);
						readonlyValues(1);
						document.getElementById("leaveType").selectedIndex=0;
						document.getElementById("listOfRestrictedForm").style.display ='none';
						manageCalendar(type);
						}
					<%}
				}
				if(listOfRhAvailed.size()==2){
	%>
					alert("You have already availed RH.");
					visibleHidden(type);
					resetValues(type);
					readonlyValues(type);	
					document.getElementById("leaveType").selectedIndex=0;
					document.getElementById("listOfRestrictedForm").style.display ='none';
					manageCalendar(1);
	<%         }
			
		}
		
	%>
	}
	
}

function noSatSunOrHoliday(){
	//if(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value!='')
	//if(!noSatSun(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value,"fromDate")) return false;
	//if(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value!='')
	//if(!noSatSun(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value,"toDate"))return false; 
	
	if(document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value!='')
		if(!noSatSun(document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value,"joinDate"))return false;
	if(document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value!='' && document.getElementById("leaveType").value==2)
		//if(!checkEncashedDays(document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value)) return false;
	var ans=true;
	 ans = checkNoOfDays();
	if(ans == true)
		return true;
	else
		return false;	
}

function noSatSun(serdate,whichDate){
	
	//serdate = document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value
	anyDate= new Date(serdate.substring(6),(serdate.substring(3,5) - 1) ,serdate.substring(0,2));
    isday=anyDate.getDay();
    
   
  	if(isday==0 || isday == 6){
  			//if(whichDate=="fromDate")
  				//errorMsg += "From Date cannot be Sunday. \n ";
  			//if(whichDate=="toDate")
  				//errorMsg += "To Date cannot be Sunday. \n ";
  			if(whichDate=="joinDate"){
				errorMsg += "Joining Date cannot be Sunday. \n ";
			return false;
			}
	}
	else{
	<%
		for (Iterator iter = listOfHolidays.iterator(); iter.hasNext();){
		Holidaycalendar element = (Holidaycalendar) iter.next();
		Date h=(Date)element.getHolidayDate();
		String holiday=LeaveManagementUtil.convertDateToStringWithoutTime(h);
	%>
		holi='<%=holiday%>'
		if(serdate==holi){
			//if(whichDate=="fromDate")
  				//errorMsg += "From Date cannot be holiday. \n ";
  			//if(whichDate=="toDate")
  				//errorMsg += "To Date cannot be holiday. \n ";
  			if(whichDate=="joinDate"){
				errorMsg += "Joining Date cannot be a holiday. \n ";
			return false;
			}
		}
	<%}%>
 	}
 	return true;
}

function availedAnniversaryLeave(){
	type = document.getElementById("leaveType").value;
	if(type==6)
	{
		<%
		if(map.get("anniversaryLeaveList")!=null)
		{
			List anniversaryLeaveList = (List)map.get("anniversaryLeaveList");
			if(anniversaryLeaveList.size()!=0)
			{
			%>
					alert("You have already availed Anniversary leave.")
					document.getElementById("leaveType").selectedIndex=0;
					document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
					return false;
		<%  }
		}%>
	}
	
	return true;

}

function manageDates(type){

	if(type==1 || type > 8){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='';
	}
	
	//if(type==2){
	//	visibleHidden(type);
	//	resetValues(type);
	//	readonlyValues(type);
	
	//	document.
	<%//=APPLY_LEAVE%>
	//.
	<%//=REASON%>
	//.
	///value='Encashment Leave';
	
		<%//if(!"".equals(leaveBalance.getEarned()) && leaveBalance.getEarned()!=null ){
				//Float empLeaveBalance=Float.valueOf(leaveBalance.getEarned());
				//if(empLeaveBalance<2){%>
				// 	alert("You can't avail encashment leave as your leave balance is low.");
				//	document.getElementById("leaveType").selectedIndex=0;
				//	manageCalendar();
				//	visibleHidden(1);
				//	resetValues(1);
				//	readonlyValues(1);
				
				//	document.
				<%//=APPLY_LEAVE%>
				//.
				<%//=REASON%>
				//.value='';
				
		<%  //   }
		 // }
		%>
	//}
	
	if(type==3){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Maternity Leave';
		<%if("".equals(map.get("anniversary")) || map.get("anniversary")==null){%>
			alert("You can't avail maternity leave.");
			document.getElementById("leaveType").selectedIndex=0;
			manageCalendar();
			document.<%=APPLY_LEAVE%>.<%=REASON%>.value='';
		<%}%>
	}
	
	if(type==4){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Paternity Leave';
		<%if("".equals(map.get("anniversary")) || map.get("anniversary")==null){%>
			alert("You can't avail paternity leave.");
			document.getElementById("leaveType").selectedIndex=0;
			manageCalendar();
			document.<%=APPLY_LEAVE%>.<%=REASON%>.value='';
	<%}%>
	}
	
	if(type==5){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
	   <%
			if(!"".equals(map.get("bday")) && map.get("bday")!=null){
				java.util.Date jDate = (java.util.Date)map.get("bday");
				String bdate=LeaveManagementUtil.convertDateToStringWithoutTime(jDate);
				String birthdate=bdate.replace(bdate.substring(6),Integer.toString(year));
	   %>
	   	bdate="<%=birthdate%>";
	    birthDate= new Date(bdate.substring(6),(bdate.substring(3,5) - 1) ,bdate.substring(0,2));
	  	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value='<%=bdate.replace(bdate.substring(6),Integer.toString(year))%>';
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value='<%=bdate.replace(bdate.substring(6),Integer.toString(year))%>';
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Birthday Leave';
	   <%}%> 
	   
	   fillJoiningDate(bdate)
	   calculateDays();
	  setTimeout("holidayOnBirthdayOrAnniversary(1,birthDate)",100)
	}
	if(type==6){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
	 <%
	    	if(!"".equals(map.get("anniversary")) && map.get("anniversary")!=null){
	    		java.util.Date jDate = (java.util.Date)map.get("anniversary");
	    		String adate=LeaveManagementUtil.convertDateToStringWithoutTime(jDate);
	 %>
	 	adate = "<%=adate.replace(adate.substring(6),Integer.toString(year))%>";
	 	 anniversaryDate= new Date(adate.substring(6),(adate.substring(3,5) - 1) ,adate.substring(0,2));
		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value='<%=adate.replace(adate.substring(6),Integer.toString(year))%>';
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value='<%=adate.replace(adate.substring(6),Integer.toString(year))%>';
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Anniversary Leave';
		fillJoiningDate(adate);
		calculateDays();
		if(availedAnniversaryLeave()){
	     setTimeout("holidayOnBirthdayOrAnniversary(2,anniversaryDate)",100)
	    } 
	 <% } else{
	    %>
		alert("You can't take anniversary leave. ");
		document.getElementById("leaveType").selectedIndex=0;
		manageCalendar();
	 <%}%>
	}
	
	if(type==7){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Restricted Holiday';
	}
	
	if(type==8){
		visibleHidden(type);
		resetValues(type);
		readonlyValues(type);
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value='Leave without pay';
	}
}

function visibleHidden(type){
	
	if(type==1 || type==3 ||  type==4 || type==5 || type==6 ||  type==8 || type==12 || type==13 || type==10){
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
    	document.getElementById("divToDate").style.display="block";
    	document.getElementById("divJoinDate").style.display="block";
		//document.getElementById("datesForm").style.display ='block';
	}
	if(type==2){
		document.getElementById("datesForm").style.display="none";
    	document.getElementById("divToDate").style.display="none";
    	document.getElementById("divJoinDate").style.display="none";
		//document.getElementById("datesForm").style.display ='none';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		if(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').substring(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').length-2)=='es'){
		 document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').length-3)+'no')
		 document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-3)+'no')
		 document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.getAttribute('validate').length-3)+'no')
	  
	  }
	}
	if(type==1 || type==3 ||  type==4 || type==5 || type==6 || type==7 || type==8){
		if(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').substring(document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').length-2)=='no'){
		 document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.getAttribute('validate').length-2)+'yes')
		 document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-2)+'yes')
		 document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.getAttribute('validate').length-2)+'yes')
	  
	  }
	}
	if(type==7){
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
    	document.getElementById("divToDate").style.display="block";
    	document.getElementById("divJoinDate").style.display="block";
	}
	if(type==20){
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
		
    	document.getElementById("divToDate").style.display="none";
    	
    	document.getElementById("divJoinDate").style.display="block";
	}
	if(type==8 && document.getElementById("halfDayChkBox").checked)
	{
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
		
    	document.getElementById("divToDate").style.display="none";
    	
    	document.getElementById("divJoinDate").style.display="block";
	}
	if(type==12 && document.getElementById("halfDayChkBox").checked)
	{
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
		
    	document.getElementById("divToDate").style.display="none";
    	
    	document.getElementById("divJoinDate").style.display="block";
	}
	if(type==13 && document.getElementById("halfDayChkBox").checked)
	{
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
	   	document.getElementById("divToDate").style.display="none";
    	document.getElementById("divJoinDate").style.display="block";
	}
	if(type==10 && document.getElementById("halfDayChkBox").checked)
	{
		document.getElementById("listOfRestrictedForm").style.display ='block';
		//document.getElementById("datesForm").style.display ='block';
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("datesForm").style.display="block";
    	document.getElementById("divToDate").style.display="none";
    	document.getElementById("divJoinDate").style.display="block";
	}
	
}
function setHalfDay()
{
	if(document.getElementById("halfDayChkBox").checked)
	{
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value=document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
	}
}

function resetValues(type){
	if(type==1 || type==2 ||  type==3 || type==4 || type==5 || type==6 || type==7 ||  type==8 || type > 8){
		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value="";
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value="";
		
		if(document.<%=APPLY_LEAVE%>.checkbox.checked == false){
			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value="";
		}
		
		document.<%=APPLY_LEAVE%>.<%=REASON%>.value="";
	}
	document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value="";
}

function readonlyValues(type){
	if(type==2){
		document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.readOnly=false;
	}
	else{
		document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.readOnly=true; 
	}
	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.readOnly=true;
	document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.readOnly=true;
}

function holidayOnBirthdayOrAnniversary(callingBlock,aDate){
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	noOfDays=document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value;
	if(noOfDays==0 && document.<%=APPLY_LEAVE%>.holiday.value =='y'){
		if(callingBlock==1){
			alert("You already have holiday on your birthday but your leave balance will be increased by 1 at the end of the month!")
			document.getElementById("leaveType").selectedIndex=0;
			manageCalendar(1);
			document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = '';
			return false;
		}	
		else if(callingBlock==2){
			alert("You already have holiday on your anniversary but your leave balance will be increased by 1 at the end of the month!")
			document.getElementById("leaveType").selectedIndex=0;
			manageCalendar(1);
			document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = '';
			return false;
		}
		
		
	}
	else{
		if(aDate<currentDate){
			if(callingBlock==1)
				alert("You can't take birthday leave. Apply it as an Earned leave.");
			if(callingBlock==2)
			 	alert("You can't take anniversary leave. Apply it as an Earned leave.");
			document.getElementById("leaveType").selectedIndex=0;
			manageCalendar(1);
			document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
			document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = '';
			return false;
		}
		else
		  return true;
	}		  
}

function fillDates(){

	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value=document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.value;
	document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value=document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.value;
	rhdate = document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.value;
	calculateDays();
	fillJoiningDate(rhdate);
}

function otherManager(){
	<%if(manager!=null){%>
	if(<%=manager.getManagerId()%>!=document.<%=APPLY_LEAVE%>.<%=APPROVED_BY%>.value)
	{
		alert("You have not selected your immediate manager!")
	}
	<%}%>
}

function manageCalendar(type){
 	if(type==5 || type==6 || type==7){
		/* document.getElementById("calFromDate").style.display ='none';
		document.getElementById("calToDate").style.display ='none'; */
		document.getElementById("fromDate").style.display ='block';
		document.getElementById("toDate").style.display ='block';
	}
	else{
		//document.getElementById("calFromDate").style.display ='block';
		//document.getElementById("calToDate").style.display ='block';
		document.getElementById("fromDate").style.display ='block';
		document.getElementById("toDate").style.display ='block';
	
	}
}

function selectHalfDay(){
//document.getElementById("leaveType").value='1';
document.<%=APPLY_LEAVE%>.<%=HALF_DAY%>[0].checked=true;
//document.getElementById("calFromDate").style.display ='block';
document.getElementById("fromDate").style.display ='block';
manageCalendar();
visibleHidden(1);
resetValues(1);
readonlyValues(1);
document.<%=APPLY_LEAVE%>.<%=REASON%>.value='';
document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value='';
document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value='';
document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value='';
	if(document.<%=APPLY_LEAVE%>.checkbox.checked){
		document.getElementById("listOfRestrictedForm").style.display ='none';
		document.getElementById("divHalfDay").style.display ='block';
		document.getElementById("selectType").style.display ='block';
		
		//changes
		//document.getElementById("labelType").style.display ='block';
		
		document.getElementById("divToDate").style.display ='none';
		if(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-2) == "es"){
			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-3)+"no")
		}	
		document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='0.5';
	} else{
		document.getElementById("divHalfDay").style.display ='none';
		document.getElementById("selectType").style.display ='block';
		
		//document.getElementById("labelType").style.display ='none';
		document.getElementById("divToDate").style.display ='block';
		if(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-2) == "no"){
			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute('validate',document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').substring(0,document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.getAttribute('validate').length-2)+"yes")
		}
		document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='';
		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value='';
		document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value='';
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value='';
		document.getElementById("leaveType").selectedIndex=0;
		document.<%=APPLY_LEAVE%>.<%=LEAVE_BALANCE%>.value='';
		document.getElementById('leaveBalanceDiv').style.display ='none';
	}
	document.<%=APPLY_LEAVE%>.<%=REASON%>.value='';
}

function setJoiningDate(sdate)
{
	if(document.<%=APPLY_LEAVE%>.checkbox.checked)
	{
		if(document.<%=APPLY_LEAVE%>.<%=HALF_DAY%>[0].checked )
		{
			document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
		}
		else if(document.<%=APPLY_LEAVE%>.<%=HALF_DAY%>[1].checked )
		{
			fillJoiningDate(sdate);
		}
	}
}
function fillToDateAutomatically(sdate)
{
  sdate=new Date(sdate.substring(6),(sdate.substring(3,5) - 1) ,sdate.substring(0,2));
   noOfDaysAllowed = document.getElementById('noOfDaysAllowedForPatMat').value;

   		sdate.setDate(sdate.getDate()+parseInt(noOfDaysAllowed)-1);

  		dayOfToDate=sdate.getDate();
		monthOfToDate=sdate.getMonth();
		yearOfToDate=sdate.getFullYear();
		monthOfToDate++;
		if(dayOfToDate < 10)
			dayOfToDate = "0"+dayOfToDate;
		if(monthOfToDate < 10)
			monthOfToDate = "0"+monthOfToDate;
		
		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value =dayOfToDate+"/"+monthOfToDate+"/"+yearOfToDate;
		fillJoiningDate(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value);
}

function clearJoiningDate(){
	document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value = '';
	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
}

function hideCalJoiningDate(){
	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value='';
	document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value='';
}

function availedBirthdayLeave(type){
	if(type==5)
	{
		<%
		if(map.get("birthdayLeaveList")!=null)
		{
			List birthdayLeaveList = (List)map.get("birthdayLeaveList");
			if(birthdayLeaveList.size()!=0)
			{
			%>
					alert("You have already availed Birthday leave.")
					
					document.getElementById("leaveType").selectedIndex=0;
					document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
					return false;
		<%  }
		}%>
	}
	if(type==4)
	{
		<%
		if(map.get("paternityLeaveList")!=null)
		{
			List paternityLeaveList = (List)map.get("paternityLeaveList");
			if(paternityLeaveList.size()!=0)
			{
			%>
					alert("You have already availed Paternity leave.")
					
					document.getElementById("leaveType").selectedIndex=0;
					document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
					return false;
		<%  }
		}%>
	}
	if(type==2)
	{
		<%
		if(map.get("encashmentLeaveWaiting")!=null)
		{
			List encashmentLeaveWaiting = (List)map.get("encashmentLeaveWaiting");
			if(encashmentLeaveWaiting.size()!=0)
			{
			%>
					alert("Your encashment leave request is already waiting for approval.")
					
					document.getElementById("leaveType").selectedIndex=0;
					visibleHidden(type);
					resetValues(type);
					readonlyValues(type);
					document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value = '';
					document.<%=APPLY_LEAVE%>.<%=REASON%>.value = '';
					return false;
		<%  }
		}%>
	}
	return true;
}

function paternityCheck(){
	type=document.getElementById("leaveType").value;
	noOfDays=document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value;
	
	if(type==4){
		if(noOfDays>5 && type==4){
			errorMsg += "You can't take paternity leave of more than 5 days.\n";
			return false;
		}
	}
	
	//changes
	if(type==3 ){
	<%
		Boolean flag=false;
		//java.util.Date joiningDate = new Date();
		//changes 
		java.util.Date joiningDate =(java.util.Date)loggedUser.getEmployee().getJoinDate();
		Date currentDate=new Date();
		
		String daysss=LeaveManagementUtil.getNumberOfDaysBetweenTwoDates(joiningDate,currentDate);
		StringTokenizer stringDays=new StringTokenizer(daysss);
		String expDays=stringDays.nextToken(); 
	%>	
	expDaysInJS=<%=expDays%>;
	//changes
	//if(expDaysInJS<365){
	//	errorMsg += "Can't avail maternity leave before completion of one year.\n";
	//	return false;
	//}
	//else if(expDaysInJS>=365 && expDaysInJS<730 && noOfDays>30){
	//	errorMsg += "Can't avail more than 30 days maternity leave.\n";
	//	return false;
	//}
	//else if(expDaysInJS>=730 && expDaysInJS<1095 && noOfDays>60){
	//	errorMsg += "Can't avail more than 60 days maternity leave.\n";
	//	return false;
	//}
	//else if(expDaysInJS>=1095 && noOfDays>90){
	//	errorMsg += "Can't avail more than 90 days maternity leave.\n";
	//	return false;
	//}
}
return true;
}

//function checkEncashedDays(noOfDayz){

	<% // Float empLeaveBalance=Float.valueOf(leaveBalance.getEarned());%>
	
	//bal=
	<%//=empLeaveBalance%>
	//-noOfDayz;
	
	//claimBal=
	<%//=empLeaveBalance%>
	//-15;
	
	//if(bal<15){
	//	errorMsg += "You are claiming for more than your balance.(Claim Balance is:" + claimBal + ")\n";
	//	return false;
	//}
	//else if(noOfDayz%11!=0){
	//	errorMsg += "Number of working Days should be multiple of 11.(eg. 11/22/33..)\n";
	//return false;
	//}
	//return true;
//}

function fillJoiningDate(sdate){
	

flag=true;

		if(sdate!=''){
		sdate=new Date(sdate.substring(6),(sdate.substring(3,5) - 1) ,sdate.substring(0,2));
		while(flag){
			dayOfToDate=sdate.getDate();
			monthOfToDate=sdate.getMonth();
			yearOfToDate=sdate.getFullYear();
			dayOfToDate++;
			sdate.setDate(dayOfToDate);
			sdate.setMonth(monthOfToDate);
			sdate.setYear(yearOfToDate);
		
			dayOfToDate=sdate.getDate();
			monthOfToDate=sdate.getMonth();
			yearOfToDate=sdate.getFullYear();
		
			if(dayOfToDate==1)
			monthOfToDate++;
			if(dayOfToDate==1 && monthOfToDate==12)
			yearOfToDate++;
		
			sdate.setDate(dayOfToDate);
			sdate.setMonth(monthOfToDate);
			sdate.setYear(yearOfToDate);
			//alert(sdate.getDay());
			if(sdate.getDay()==0 ||sdate.getDay()==6 )
				flag=true;
			else 
				flag=false;
			<%
				Iterator holiIterator=listOfHolidays.iterator();
				for(int i=1;holiIterator.hasNext();i++)
				{
					Holidaycalendar holiday=(Holidaycalendar)holiIterator.next();
					java.util.Date holiDate=(java.util.Date)holiday.getHolidayDate();
					String holidaydate = LeaveManagementUtil.convertDateToStringWithoutTime(holiDate);
			%>	
					holidate="<%=holidaydate%>";	
					holidaydate  = new Date(holidate.substring(6),(holidate.substring(3,5) - 1) ,holidate.substring(0,2));
					if(sdate-holidaydate==0)	
					{
						flag=true;
					}
				
			<%}%>
				
		}
		dayOfToDate=sdate.getDate();
		monthOfToDate=sdate.getMonth();
		yearOfToDate=sdate.getFullYear();
		monthOfToDate++;
		if(dayOfToDate < 10)
			dayOfToDate = "0"+dayOfToDate;
		if(monthOfToDate < 10)
			monthOfToDate = "0"+monthOfToDate;
		
		document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value =dayOfToDate+"/"+monthOfToDate+"/"+yearOfToDate;
		
	}
	
}

function checkNoOfDays(){

	noOfDays = document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value;
	leaveBalance = document.<%=APPLY_LEAVE%>.<%=LEAVE_BALANCE%>.value;
	
	
	noOfDays = parseFloat(noOfDays)
	leaveBalance = parseFloat(leaveBalance); 
	
	if((document.getElementById("leaveType").value==="3") ||(document.getElementById("leaveType").value==="4"))
	{
	}else{
	if(noOfDays > leaveBalance || leaveBalance==0){
			answer = confirm(" Your Leave Balance will go in negative. Do you want to Continue ?")
			
			//alert(answer);
			//return false;
			if (answer == false)
			{
					return false;
			}
	}
	}
	return true;
}
function getLeaveList(field)
{
	var half;
	if(field.checked)
	{
		half='n';
	}
	else
	{
		half='y';
	}
	
	var orGroupId ="";
    var x=document.getElementById("selectType");
	
	 //----------------------AJAX PART------------Start------
  
  	var xmlHttp;
  	try {
    	// Firefox, Opera 8.0+, Safari
    	xmlHttp=new XMLHttpRequest();
  	}catch (e){
    	// Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("selectType").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("selectType").innerHTML="";
    }else
      if(xmlHttp.readyState==4){

         document.getElementById("selectType").innerHTML = xmlHttp.responseText;
      }
    }
    /* xmlHttp.open("POST","/erp/erp/leave?method=getLeaveListJsp&half="+half+'&'+tokenName+'='+tokenValue,true); */
    xmlHttp.open("POST","leave?method=getLeaveListJsp&half="+half,true);
    xmlHttp.send(null);
    
}


function chkMedCer(leaveId){
	if(leaveId==22){
		document.getElementById('EOl').style.display ='block';
		
	}else{
		document.getElementById('EOl').style.display ='none';
		
	}
	
}

</script>
<%
String sex ="";
String maritalStatusCode ="";
String employee_type="";
if(loggedUser.getEmployee().getGender() != null){
	
	
	sex = (loggedEmp.getGender() != null?loggedEmp.getGender().getAdministrativeSexName():"");
	maritalStatusCode = (loggedUser.getEmployee().getMaritalStatus() != null?loggedUser.getEmployee().getMaritalStatus().getMaritalStatusCode():"");
}
if(loggedUser.getEmployee().getEmployeeType() != null){
employee_type = loggedEmp.getRankCategory().getRankCategoryName();
}
%>
<form name="<%=APPLY_LEAVE%>"  id="applyLeave" method="post" >
	<div class="titleBg"><h2>Leave Application </h2></div>
	<div style="float:right; margin-right:20px;">
	<h4 style="border-bottom:0"><a href="javascript:void(0)"  onclick="submitFormForButton('applyLeave','report?method=printCompanyHoliday&year=<%=year%>')"> Company Holidays List</a></h4>
	</div>
	
	<div class="clear"></div>
	<div class="Block">
	
	<!-- 	<h4><div id="message"></div></h4> -->
		
		<div class="clear"></div>
	

	
	<div class="division"></div>
	 <jsp:include page="showLeaveBalanceDetails.jsp"></jsp:include>	
		
	<div class="clear"></div>
	
	<label class="Auto">Half Day Leave</label>
	<input type="checkbox" name="checkbox" id="halfDayChkBox" value="half day" onclick="getLeaveList(this);selectHalfDay();" class="radioCheck" />

	<!-- <label class="auto">Select only in case of Half Day Leave</label> -->
	<div id="divHalfDay" style="display:none;" name="divHalfDay">
		<input type="radio" id="<%=HALF_DAY%>" name="<%=HALF_DAY%>" value="f"  onclick="hideCalJoiningDate();clearJoiningDate();" class="radioAuto" /><label class="medium">First Half</label>
		<input type="radio" id="<%=HALF_DAY%>" name="<%=HALF_DAY%>" value="s"  onclick="hideCalJoiningDate();clearJoiningDate();" class="radioAuto" /><label class="medium">Second Half</label>		
	</div>
	<div class="clear"></div>
	
	<%-- <div class="Block">--%>
	<div class="clear"></div>
    <div class="division"></div>
		<%--</div>--%>
 
	<div id="selectType" style="display:block;"> 
		<label>Leave Type <span>*</span></label> 
		<select id="leaveType" name="<%=TYPE%>"  validate="Type,nothing,yes" class="mediumm"
			onkeyup="showLeaveBalance(this.value);" onchange="availedBirthdayLeave(this.value);manageDates(this.value);manageCalendar(this.value);showLeaveBalance(this.value);chkMedCer(this.value);chkForPL(this.value);chkForPaternity(this.value);">
		<option value="">Select</option>
		<%for(HrMasLeave hrMasLeaveType:listOfTypesOfLeaves){ 
			if(hrMasLeaveType.getStatus().equals("y")
					&& !hrMasLeaveType.getId().equals(20)){
	    			if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("male") && hrMasLeaveType.getId().equals(4)){ 
	    				if(childrenCount < 2 && statusPaternity.equals("n") ){%>
		    				<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getDescription()%></option>	    				
	    				<%}%>
	    			<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("female") &&  hrMasLeaveType.getId().equals(3)){
		    				if(childrenCount < 2 && statusMaternity.equals("n") && employee_type.equalsIgnoreCase("Regular")){ 	// for permanent Employee 
		    				%>
		    					<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getDescription()%></option>		    					
		    			<%	} %>
	    			<%} else { 
	    				if(!hrMasLeaveType.getId().equals(4)
	    					&&  !hrMasLeaveType.getId().equals(3) && hrMasLeaveType.getStatus().equalsIgnoreCase("y")){ %>
								<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getDescription()%></option>	    					
	    				<%}%>
				   <%}}}%>
	    </select>
    </div> 
    
    <div id="EOl" style="display: none;" >
    	<label> Medical Certificate <span>*</span></label>
		<select name="medCer" id="medCer" validate="Medical Certificate,string,no"  >
 	 	<option value="">Select</option>
		<option value="y">Yes</option>
		<option value="n">No</option>
	
		</select>
    </div>
   
    <script type="text/javascript">
    function chkForPL(leaveId)
    {
    	<%
    		Date today= new Date();

    		String gapDays=LeaveManagementUtil.getNumberOfDaysBetweenTwoDates(joiningDate,today);
    		gapDays = gapDays.substring(0,3);
    		%>
    		daysGap=<%=gapDays%>;
    	//	alert(daysGap);
    	if(leaveId==13)
    	{
    		if(daysGap > 180)
    		{
    		//alert("gr8");
    		}
    	}
    	else {
    		
    	}
    }
    function chkForShortLeave()
    {
    	//alert(document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value);
    	if(document.getElementById("leaveType").value==20)
    	{
    		
    			document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value=document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
    			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='0';
    			document.<%=APPLY_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.setAttribute("validate","");
    		
    	}
    }
    
   
    
  
   //function chkForCLandSL() {
	//	var SLBal = document.getElementById("SLBalance").value;
	//	var CLBal = document.getElementById("CLBalance").value;
	//	var PLBal = document.getElementById("PLBalance").value;
    //	if(document.getElementById("leaveType").value==12
   // 	    || document.getElementById("leaveType").value==10){
	//			if(SLBal <=0 && CLBal <=0 && PLBal > 0){
	//				alert('You can not take casual leave and sick leave.');
	//				return false;
	//			}
//		}
   // 	if(document.getElementById("leaveType").value==12
    //	    || document.getElementById("leaveType").value==10
    //	    || document.getElementById("leaveType").value==13){
	//			if(SLBal <=0 && CLBal <=0 && PLBal <= 0){
	//				if(confirm('Your CL,PL and SL are 0 or less than 0.\nDo you still want to continue.')){
	//					return true;
	//				}else{
	//					return false;
	//				}
	//			}
   // 	}
    //	if(document.getElementById("leaveType").value==13){
	//			if(SLBal >0 && CLBal <=0 && PLBal <= 0){
	//				if(confirm('Your PL 0 or less than 0.\nDo you still want to continue.')){
	//					return true;
	//				}else{
	//					return false;
	//				}
	//			}
   // 	}
   	////return true;
   
   // }
    
    function chkForOptionalLeave(leaveId)
    {
    	if(leaveId==21)
    	{
    		document.getElementById("listOfRestrictedForm").style.display="block";
    		document.getElementById("leaveBalanceDiv").style.display="none";
    		document.getElementById("dates").style.display="none";
    		//document.getElementById("divToDate").style.display="none";
    		
    		fillDates();
    	 	document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","Holiday,string,yes");
			document.<%=APPLY_LEAVE%>.<%= NO_OF_WORKING_DAYS %>.value="1";
    	}
    	else if(leaveId!=2){
    		
    		document.getElementById("listOfRestrictedForm").style.display="none";
    		
    		document.getElementById("dates").style.display="block";
    	//	document.getElementById("divToDate").style.display="block";
    		//document.getElementById("divJoinDate").style.display="block";
    		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.setAttribute("validate","From Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute("validate","To Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.setAttribute("validate","Joining Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","");
    	}
    	
    }
    function chkForPaternity(leaveId)
    {
    	
    	if(leaveId == 4 || leaveId == 3)
    	{
    	    document.getElementById("divToDate").style.display="none";
    	    document.getElementById("toDate").setAttribute("validate","To Date,date,no");
    		//document.getElementById("childDiv").style.display="block";
    		//document.getElementById("childselect").setAttribute("validate","Child,string,yes");	
    		//document.getElementById("leaveBalanceDiv").style.display="none";
    	}
    	else if(document.getElementById('halfDayChkBox').checked == false)
    	{
    		document.getElementById("divToDate").style.display="block";
    		document.getElementById("toDate").setAttribute("validate","To Date,date,yes");
    		//document.getElementById("childDiv").style.display="none";	
    		//document.getElementById("childselect").setAttribute("validate","");	
    	}
    	
    }
    function chkForEncashment(leaveId)
    {
    	
    	if(leaveId==2)
    	{
    		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.setAttribute("validate","");
    		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute("validate","");
    		document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.setAttribute("validate","");
    		document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","");
    		document.<%=APPLY_LEAVE%>.<%= NO_OF_WORKING_DAYS %>.value="";
    		document.<%=APPLY_LEAVE%>.<%= NO_OF_WORKING_DAYS %>.readOnly=false;
    		document.getElementById("dates").style.display="none";
    		document.getElementById("divJoinDate").style.display="none";
    		document.getElementById("listOfRestrictedForm").style.display="none";
    		
    	}
    	else if(leaveId!==21){
    
    		document.getElementById("dates").style.display="block";
    		
    		document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.setAttribute("validate","From Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.setAttribute("validate","To Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.setAttribute("validate","Joining Date,date,yes");
    		document.<%=APPLY_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","Holiday,string,yes");
    		document.<%=APPLY_LEAVE%>.<%= NO_OF_WORKING_DAYS %>.readOnly=true;
    	}
    }
    function showHideLineManager(obj){
    	var checkedLineOrOther = obj.value;
    	if(checkedLineOrOther == 'o'){
    		document.getElementById('divLineManager').style.display='none';
    		document.getElementById('<%=APPROVED_BY%>').setAttribute("validate","Approver,string,no");
    		document.getElementById('divOtherManager').style.display='block';
    		document.getElementById('<%=APPROVED_BY_OTHER%>').setAttribute("validate","Approver,string,yes");
    		document.getElementById('<%=DEPARTMENT_ID%>').setAttribute("validate","Department,string,yes");
    	}else{
    		document.getElementById('divLineManager').style.display='block';
    		document.getElementById('<%=APPROVED_BY%>').setAttribute("validate","Approver,string,yes");
    		document.getElementById('divOtherManager').style.display='none';
    		document.getElementById('<%=APPROVED_BY_OTHER%>').setAttribute("validate","Approver,string,no");
    		document.getElementById('<%=DEPARTMENT_ID%>').setAttribute("validate","Department,string,no");
    	}
    }
    </script>
      <input type="hidden" name="hrMasLeaveTypeNewId" id="hrMasLeaveTypeNewId" value=""/>
    <script>
			document.<%=APPLY_LEAVE%>.<%=TYPE%>.focus();
	</script>
	<script type="text/javascript">
	
	function chkHalfDayAllow()
	{

	<%
		for(HrMasLeaveTypeMediator hrMasLeaveType:listOfTypesOfLeavesMedType){ 
			if(hrMasLeaveType.getLeaveType().getStatus().equals("y")){
				%>
				if(document.<%=APPLY_LEAVE%>.leaveType.value==='<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>')
				{
				 <% if(hrMasLeaveType.getLeaveType().getHalfDayAllow()!=null &&(hrMasLeaveType.getLeaveType().getHalfDayAllow().equalsIgnoreCase("y"))){%>
					 document.<%=APPLY_LEAVE%>.checkbox.checked=false
					 document.<%=APPLY_LEAVE%>.checkbox.disabled=true;
					 document.getElementById('divHalfDay').style.display='none';
					
				 <%}else{%>
				 	document.<%=APPLY_LEAVE%>.checkbox.disabled=false;
				 	document.getElementById('divHalfDay').style.display='block';
				 <%}%>
				}
		<% }
		}
		%>
	}
	</script>
	<div id="childDiv" style="display: none;" >
    	<label> Child <span>*</span></label>
		<select name="childselect" id="childselect" validate="Child,string,no" onchange="chkChildren(this.value);" >
 	 	<option value="">Select</option>
		<option value="1">First Child</option>
		<option value="2">Second Child</option>
	
		</select>
    </div>
    <script type="text/javascript">
    
    
    function abc(){
    	if(document.applyLeave.checkbox.checked){
    		var sdate =	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value
    		setJoiningDate(sdate);
    	}else{
    		var todate=document.<%=APPLY_LEAVE%>.<%=TO_DATE%>.value;
        	var fromDate =	document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>.value;
        	
    	if(fromDate != ""){
    	calculateDays();
    	fillJoiningDate(todate);
    	}else{
    		alert("Please Select From date ");
    		
    	}
    	}
    	
    }
    
    
    
    
    
    function chkChildren(noOfChild)
    {
    	
    //	if(noOfChild == 3)
    //	{
    //		document.getElementById("childselect").value="";
    //		alert("You are not eligble for this leave");
    		
    //		return false;
    //	}
    //		return true;
    	
    }
    function showEmployeeListAjax(obj){
    	var departmentId = obj.value;
    	if(departmentId != '0' && departmentId != ''){
    		submitProtoAjaxWithDivName('<%=APPLY_LEAVE%>','leave?method=showEmpForDept','employeeDiv');
    	}
    }
    
    function resetForm(){
    	submitFormForButton('<%=APPLY_LEAVE%>','leave?method=showLeaveApplicationJsp');
    }
   </script>
    
    <div id="listOfRestrictedForm" style="display:none;">
    <label> Optional Holidays <span>*</span></label>
    	<select name="<%=RESTRICTED_HOLIDAYS%>" validate="Holiday,string,no" onchange="fillDates(),availedRh()">
    	<option value="">Select</option>
    	<%
		    List listOfRestrictedHolidays=(List)map.get("listOfRestrictedHolidays");
			if(listOfRestrictedHolidays!=null){
    		Iterator rhIterator=listOfRestrictedHolidays.iterator();
			while(rhIterator.hasNext())
			{
			Holidaycalendar rh=(Holidaycalendar)rhIterator.next();
			java.util.Date jDate = (java.util.Date)rh.getHolidayDate();
		%>
	<option value="<%=LeaveManagementUtil.convertDateToStringWithoutTime(jDate)%>"><%=LeaveManagementUtil.convertDateToStringWithoutTime(jDate)%><%="-(" %><%=rh.getTitle()%><%=")" %></option>
		<% 
			}}
		%>
    	</select>
    </div>
    
    <div id="leaveBalanceDiv"  style= "display:none;">
    	<label id="balanceLbl" >Balance </label>
		<input type="hidden" id="balance" name="<%=LEAVE_BALANCE%>" value="">
		<label id="allowDayLbl" >Entitlement</label>
    </div>
    
    
    
    <div id="labelType" style="display:none;">
    	<label>Type:</label><label class="value">Earned</label> 
    	<input type ="hidden" id="typeId" name="<%=TYPE%>" value="1" />
    </div>
    
    <div id="dates" style="display:block;">
    <div id="datesForm" style="display:block;">

    <label id="Label1"> From Date <span>*</span></label>
    <input name="<%=FROM_DATE%>" id="fromDate" type="text" readonly validate='From Date,date,yes' value=""    class="calDate"  onchange="abc();startEndDateValidation()" />
 <%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" id="calFromDate" 
   	onclick="javascript:setdate('',document.<%=APPLY_LEAVE%>.<%=FROM_DATE%>,event)"  />  --%>
    </div>
	<div id="divToDate" >
	<label id="Label2">To Date <span>*</span></label>
   	<input type="text" name="<%=TO_DATE%>" id="toDate"  readonly   validate='To Date,date,yes'  value=""  class="calDate" onchange="abc();startEndDateValidation()"/>
    	<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate" onclick="javascript:setdate('',document.<%=APPLY_LEAVE%>.<%=TO_DATE%>,event)" /> --%> 
	</div>
	</div>
	<div class="clear"></div>
	<label>No. of Days</label>
   	<input type="text" name="<%=NO_OF_WORKING_DAYS%>" id='noOfDays' readonly maxlength="4"  
   		validate="Other Dates,num,yes" value=""> 
     	
	
	<div id="divJoinDate" >
	    <label>Joining Back On <span>*</span> </label>
		<input type="text" name="<%=JOINING_DATE%>" id="jDate" readonly="readonly" validate='Joinning Date,date,yes' value=""  class="date">
	    	<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate" onclick="javascript:setdate('',document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>,event)" /> --%>
	</div>
    
 	<label> Contact Number <span>*</span> </label>
	<input type="text" name="<%=CONTACT_PHONE%>"  maxlength="11" validate="Contact Number,int,yes"> 
 <div class="clear"></div>
    <label>Alternate Email Id</label>
	<input type="text" name="<%=EMAIL%>" maxlength="50" validate="Email Id,email,no"> 
    
	
 	<label> Reason <span>*</span> </label>
    <textarea  id="reason" name="<%=REASON %>"  maxlength="200"    onkeydown="refreshLengthWithoutMeter1(this.id,200)" onkeyup="refreshLengthWithoutMeter(this.id,200)" validate="Reason,string,yes"></textarea> 
	
 	<label>Address during Leave</label>
  	<textarea id="contactAddress" name="<%=CONTACT_ADDRESS%>"  onkeydown="refreshLengthWithoutMeter1(this.id,200)" onkeyup="refreshLengthWithoutMeter(this.id,200)" validate="Contact Address,address,no" maxlength="200"></textarea> 
   	<div class="clear"></div>
	
 	<label class="Auto">Line Manager</label>
	<input type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>" value="m"  
			onclick="showHideLineManager(this)" checked="checked" class="radioAuto" />
			
	<label class="Auto">Other</label>
	<input type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>" value="o"  
			onclick="showHideLineManager(this);" class="radioAuto"  />
			
	   	<div class="clear"></div>
	
 	<div id="divLineManager" style="display: block;">
 	<label> Approver <span>*</span> </label>
		<select name="<%=APPROVED_BY%>" id="<%=APPROVED_BY%>" validate="Approver,string,yes" >
	 	 <option value="">Select</option>
	 		<%List<UserManager> userList=(List<UserManager>)map.get("manager");
			Iterator iterator=userList.iterator();
			while(iterator.hasNext()){
				UserManager user = (UserManager)iterator.next();
				if(user.getManagers() != null){
				%>
				<%-- <option value="<%= user.getManagers().getId() %>"><%=user.getManagers().getFirstName()+" "+(user.getManagers().getLastName()!= null ? user.getManagers().getLastName(): "") %></option> --%>
				<option value="<%= user.getManagers().getId() %>"><%=user.getManagers().getFirstName()%></option>
				<%} %>
			<%} %>
	 	</select>
 	</div>
 
  	<div id="divOtherManager" style="display: none;">
 	<label> Department <span>*</span> </label>
		<select name="<%=DEPARTMENT_ID%>" id="<%=DEPARTMENT_ID%>" onchange="showEmployeeListAjax(this);" validate="Department,string,no" >
	 	 <option value="" >Select</option>
	 		<%for(MasDepartment masDepartment : masDepartmentList){%>
				<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
			<%} %>
	 	</select>
		<div id="employeeDiv">
			<label> Approver <span>*</span> </label>
			<select name="<%=APPROVED_BY_OTHER%>" id="<%=APPROVED_BY_OTHER%>" validate="Approver,string,no" >
			 	 <option value="">Select</option>
		 	</select>
	 	</div>
 	</div>
 
    
   	<div class="clear"></div>
   	
    <input type="hidden" name="holiday"/>
    <input type="hidden" name="typeFlag"/>
    <input type="hidden" name="typeFlagForJoiningDate" id="typeFlagForJoiningDate" value=""/>
    
    <input type ="hidden" id="CLBalance" name="CLBalance" value="" />
    <input type ="hidden" id="SLBalance" name="SLBalance" value="" />
    <input type ="hidden" id="PLBalance" name="PLBalance" value="" />
    
    <input type ="hidden" id="leaveId" name="leaveIdForDatabase" value="" />
    <input type ="hidden" id="balanceId" name="balanceIdForDatabase" value="" />
    <input type ="hidden" id="noOfDaysAllowedForPatMat" name="noOfDaysAllowedForPatMat" value="" />
        <input type ="hidden" id="leaveTaken" name="leaveTaken" value="" />
 	
    <div class="clear"></div> 
	<div class="clear"></div> <div class="clear"></div><div class="clear"></div>
	<div id = "waitMessage" class="msg" style="display: none">
		Please Wait...
	</div>		
	<div class="paddingTop15"></div>
	<%--<input type="button" name="apply" value="Apply" class="button" onclick="setHalfDay();chkForShortLeave();submitThisForm();"/> --%>
	<input type="button" name="apply" value="Apply" class="button" onclick="setHalfDay();submitThisForm();"/>
	<input type="button" name="reset" id="reset" value="Reset" class="button" onclick="resetForm()"/>
		
    <div class="clear"></div>	
	</div>
</form>
