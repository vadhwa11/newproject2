<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<script type="text/javascript" language="javascript" src="/erp/jsp/js/proto.js"></script>

<% 
	Map<String,Object> map=(Map)request.getAttribute("map");
	List<HrEmployeeBalanceNew> encashableMasLeaveType = new ArrayList<HrEmployeeBalanceNew>();
	List<UserManager> managers = new ArrayList<UserManager>();
    List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

	String message=null;
	if(map!=null)
	{
		if(map.get("encashableMasLeaveType")!= null){
			encashableMasLeaveType = (List)map.get("encashableMasLeaveType");
			//System.out.println("Size :"+encashableMasLeaveType.size());
		}
		if(map.get("managers")!= null){
			managers = (List)map.get("managers");
		}
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
	    if(map.get("masDepartmentList")!=null){
	    	masDepartmentList = (List)map.get("masDepartmentList");
	    }
	}

	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
%>
<%@page import="jkt.hms.masters.business.HrMasLeaveType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.UserManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrEmployeeBalance"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script>

function chkAllreadytaken(){
	ajaxEncash('hrLeaveEncashment','leave?method=getEncashment');
}



function ajaxEncash(formName,action)
{
	
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
    var url=action;
    url = url+'&'+tokenName+'='+tokenValue;
  xmlHttp.open("POST",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	   	    var item = items.childNodes[loop];

	   	 var encashLeave= item.getElementsByTagName("encash")[0];
			var encashLeaveVal = encashLeave.childNodes[0].nodeValue ;
			//alert(encashLeaveVal)
			if(encashLeaveVal == "yes"){
				alert("This employee allready Encash leave in this year.")
					document.getElementById('balance').value ="";
				return false;
				}else{

				
				return true;
      		}
		}
	        
      }
    }
  }


function showLeaveBalance(idvalue){
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :encashableMasLeaveType){
		int id = hrEmployeeBalance.getId();
		
		//double allowedDays = Float.valueOf(employeeBalance.getLeaveType().getLeaveType().getAllowedDays());
	//	double leaveTaken = Float.valueOf(employeeBalance.getTaken());
	//	double leaveAdjusted = Float.valueOf(employeeBalance.getBalanceAdjustedBy());
	//	double balance = 0;
	//	balance= Float.valueOf(employeeBalance.getClosingBalance());
		
    	double balance=0;
    	
   		if(hrEmployeeBalance.getClosingBalanceYearly()!=null){
	   	 	balance =  Float.valueOf(hrEmployeeBalance.getClosingBalanceYearly());
   		}
		//balance = allowedDays - leaveTaken + leaveAdjusted;
		double unforBalance=0;
		//System.out.print(hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent());
		if(hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent()!=null && !hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent().equals(0)){
			 unforBalance = ((balance)*(hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent()))/100;
		}else{
			 unforBalance=((balance)-(hrEmployeeBalance.getLeaveType().getLeaveType().getBufferRequired()));
		}
		//System.out.println("float balance :"+unforBalance);
		
		int balance1=(int)unforBalance;
			//new DecimalFormat("0.##").format((double)unforBalance);
		//System.out.println("balance is :"+balance);
	%>
		if(idvalue == <%=id%> ){
			<% if(balance1 > 0){ %>// if Encashable amount is negetive
	    	document.getElementById('balance').value = '<%= balance1%>';
			<%}else{%>
			document.getElementById('balance').value ='0';
			<%}%>
	    	document.getElementById('leaveId').value = '<%= hrEmployeeBalance.getLeaveType().getId()%>'
	    	document.getElementById('balanceId').value = '<%= hrEmployeeBalance.getId()%>'
		}
		if(idvalue == "" ){
	    	document.getElementById('balance').value = '';
	    	document.getElementById('leaveId').value = '';
	    	document.getElementById('balanceId').value = '';
		}
		
		<%
	}

	%>
		
}
function checkEnchashedDays(){
	encashableBalance = document.<%=ENCASHMENT_LEAVE_FORM%>.<%=LEAVE_BALANCE%>.value;
	toEncash = document.<%=ENCASHMENT_LEAVE_FORM%>.<%=LEAVE_TO_ENCASH%>.value;
	encashableBalance=parseInt(encashableBalance);
	toEncash=parseInt(toEncash);
	
	if(toEncash>encashableBalance){
		alert("Leaves To Encash can't be greater than Leave Balance");
		return false;
	}
	return true
}

function submitThisForm(){
	val=checkEnchashedDays();
	//alert("submitThisForm");
	if(val==true)
	{
		submitForm('<%=ENCASHMENT_LEAVE_FORM%>','leave?method=applyForEncashment');
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
    function showEmployeeListAjax(obj){
    	var departmentId = obj.value;
    	if(departmentId != '0' && departmentId != ''){
    		submitProtoAjaxWithDivName('<%=ENCASHMENT_LEAVE_FORM%>','/erp/erp/leave?method=showEmpForDept','employeeDiv');
    	}
    }

</script>
<div class="titleBg"><h2>Leave Encashment  </h2></div>
<div class="clear"></div>
<div class="Block">
<form name="<%=ENCASHMENT_LEAVE_FORM%>" method="post" >

	<%
		if(message!= null){
	%>
		<h4><%=message %></h4>
	<%} %>
	<div class="clear"></div>
	<label> Leave Type <span>*</span></label>
	
	<select id="leaveType" name="<%=TYPE%>"  readonly validate="Type,nothing,yes" onchange="chkAllreadytaken(this.value);showLeaveBalance(this.value);" onkeyup="showLeaveBalance(this.value);" class="mediumm">
	 <option value="">Select</option>
		<%
			
			for(HrEmployeeBalanceNew employeeBalance:encashableMasLeaveType){
				%>
				<option value="<%=employeeBalance.getId()%>"><%=employeeBalance.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
				<% 
			}
		%>
	    </select>
		<script>
			document.<%=ENCASHMENT_LEAVE_FORM%>.<%=TYPE%>.focus();
		</script>
		
	  		<label>Encashable Balance </label>
	  		<input type="text" id="balance" class="readOnly"  value="" name="<%=LEAVE_BALANCE%>" readonly="readonly" maxlength="10" />
	  		
	  		<label> Leaves To Encash <span>*</span></label>
	  		<input type="text" id="toEncash" name="<%=LEAVE_TO_ENCASH%>" validate="Leaves To Encash,int,yes" maxlength="10" />
	 	
	<div class="clear"></div> 
 	<label> Reason <span>*</span></label>

    <textarea   name="<%=REASON %>"  maxlength="200" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" validate="Reason,string,yes"></textarea> 

	
 	
	
	<label>Line Manager</label>
	<input type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>" value="m"  
			onclick="showHideLineManager(this)" checked="checked" class="radioAuto" />
			<label>Other</label>	
	<input type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>" value="o"  
			onclick="showHideLineManager(this);" class="radioAuto"  />
		
	<div class="clear"></div>
	
 	<div id="divLineManager" style="display: block;">
 	<label> Approver <span>*</span></label>
		<select name="<%=APPROVED_BY%>" id="<%=APPROVED_BY%>" validate="Approver,string,yes"  class="mediumm">
	 	 <option value="">Select</option>
	 		<%List<UserManager> userList=(List<UserManager>)map.get("managers");
			Iterator iterator=userList.iterator();
			while(iterator.hasNext()){
				UserManager user = (UserManager)iterator.next();%>
				<%
					if(user.getManagers() != null)
					{
						%>
							<option value="<%= user.getManagers().getId() %>"><%=user.getManagers().getFirstName()+" "+user.getManagers().getLastName()%></option>
						<%
					}
				} %>
	 	</select>
 	</div>
 
  	<div id="divOtherManager" style="display: none;">
 	<label> Department <span>*</span></label>
		<select name="<%=DEPARTMENT_ID%>" id="<%=DEPARTMENT_ID%>" validate="Department,string,no" >
	 	 <option value="" onclick="showEmployeeListAjax(this);">Select</option>
	 		<%for(MasDepartment masDepartment : masDepartmentList){%>
				<option onclick="showEmployeeListAjax(this);" value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
			<%} %>
	 	</select>
		<div id="employeeDiv">
			<label> Approver <span>*</span></label>
			<select name="<%=APPROVED_BY_OTHER%>" id="<%=APPROVED_BY_OTHER%>" validate="Approver,string,no" >
			 	 <option value="">Select</option>
		 	</select>
	 	</div>
 	</div>

 	  <input type ="hidden" id="leaveId" name="leaveIdForDatabase" value="" />
 	    <input type ="hidden" id="balanceId" name="balanceIdForDatabase" value="" />
 	    
	<div class="clear"></div>  
    <div class="clear"></div> 
	
			
	<input type="button" name="apply" value="Apply" class="button" onclick="submitThisForm();"/>
	<input type="button" name="reset" value="Reset" class="button" onclick="location.href='leave?method=encashLeaves'"/>
	  		
	<div class="clear"></div>   
	
	<div class="division"></div>
	<div class="clear"></div>   
	<div class="paddingTop15"></div>   
		<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=currentDate%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
	</div>
	<div class="clear"></div>   
</div>
</form>
