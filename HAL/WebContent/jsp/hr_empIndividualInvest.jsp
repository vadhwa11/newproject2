<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.HrMasItaxSecInvestment"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.HrEmployeeInvestment"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<script language="javascript">
var $j = jQuery.noConflict();
</script>
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
</script>
<%

Map map = new HashMap();
MasEmployee employee = null;
List<HrMasItaxSecInvestment> hrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
List<HrEmployeeInvestment> employeeInvestmentList = new ArrayList<HrEmployeeInvestment>();
if(request.getAttribute("map")!=null)
{
	map= (Map)request.getAttribute("map");
}
if(map.get("employee")!= null){
	employee = (MasEmployee)map.get("employee");
}
if(map.get("hrMasItaxSecInvestmentList")!= null){
	hrMasItaxSecInvestmentList = (List)map.get("hrMasItaxSecInvestmentList");
}
if(map.get("financialYearList")!= null){
	financialYearList = (List<MasStoreFinancial>)map.get("financialYearList");
}
if(map.get("employeeInvestmentList")!= null){
	employeeInvestmentList = (List<HrEmployeeInvestment>)map.get("employeeInvestmentList");
}
int invYear=0;
if(map.get("invYear")!=null)
{
invYear=(Integer)map.get("invYear");
}
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String sdate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String message="";
	if (map.get("msg") != null) {
		 message = (String) map.get("msg");
		//out.println(message);
	}
%>
<%int row = hrMasItaxSecInvestmentList.size(); %>
<%if(!message.equals("")){%>

<h4><%=message %></h4>


<%}%>
<div class="titleBg"><h2>My Investments</h2></div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<form name="employeeInvestment" method="post" enctype="multipart/form-data"	>
 
<div id="pageNavPosition"></div>
<div class="clear"></div>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div id="labelsDiv">
		<input name="empid" id="empid" type="hidden" value="<%=employee.getId()%>" > 
		<label>Service No.</label>
		<label id="Ecode" class="value"> <%=employee.getServiceNo() %> </label>
		<label>Employee Name</label>
		<label id="Ename" class="value"><%=employee.getFirstName()+" "+(employee.getLastName() != null ? employee.getLastName() :"")%></label>
		<label> Year<span>*</span></label>
		<select id="invYear" name="invYear" validate="Year,string,yes" onchange="submitDataOnChange();"> 
		<option id="0" value="0">Select</option>
		<%
		      for(MasStoreFinancial obj : financialYearList)
			 
		   		{%>
		<option value="<%=obj.getId() %>"  <%=obj.getId().equals(invYear)?"selected":"" %> ><%=obj.getFinancialYear() %></option>
		<%} %>
		 </select>
	</div>
	
	
	
	
	<table id="secInvestList" width="100%" >
 	 <tr>
 	 <th>Section</th>	
 	 <th>Investment</th> 
 	 <th>Amount</th>
 	 <th>Investment Date</th>
 	 <th>Max. Amount</th>
 	 <th>Proofs</th>
 	 </tr>		
		<tbody id = "tableData12">
			<%int i=1;
			
			if(hrMasItaxSecInvestmentList!=null && hrMasItaxSecInvestmentList.size()>0)
			{
				%>
				<input type="hidden" name="listLen" id="9012" value="<%=hrMasItaxSecInvestmentList.size()%>" >
				
				<%
		      for(HrMasItaxSecInvestment obj : hrMasItaxSecInvestmentList){
		    	  	BigDecimal amt = new BigDecimal("0");
		    	  	String MainFileName="Docs Uploaded";
			    	Date invDate =null; 
			    	String docStatus=null;
			    	MasStoreFinancial finYear2 = null; 
			    	
			    	HrEmployeeInvestment employeeInvestment = null;
			   if(employeeInvestmentList.size()>0){
			    	  for(HrEmployeeInvestment invObj : employeeInvestmentList)
			    	  {
			    	  	if(invObj.getSecInvest().getId().equals(obj.getId()))
			    	 	 {
			    	  	  amt=invObj.getInvAmount();
			    		  invDate = invObj.getInvDate();
			    		  finYear2 = invObj.getInvYear();
			    		  employeeInvestment = invObj;
			    		  docStatus=invObj.getDocumentSubmitted();
			    		  /* Testing Purpose */
			    	List listOfUploadedDocs = new ArrayList();
			    	if(map.get("invObj.getSecInvest().getInvestmentType().getInvestmentDescription()")!= null){
			    		listOfUploadedDocs = (List)map.get("invObj.getSecInvest().getInvestmentType().getInvestmentDescription()");
			    	}
			    	System.out.println("listOfUploadedDocs size "+listOfUploadedDocs.size()); 
			    		  /* Ended */
			    	  	}
			      	}
			    	}
		    	  
		    	  
			  if(i%2==0)
		   		{%>
					<tr class="odd"  onclick="">		  
				<%}else{%>
		  			<tr class="even" onclick="">		  				  		
				<%} %>
				
				<input type="hidden"  name="invSec<%=i %>" id="invSec<%=i %>" value="<%=obj.getId() %>" >
				<td  width="20%" id="td1<%=i %>"><%=obj.getHrMasItaxExemption().getSectionCode() %></td>
				<td  width="40%" id="td2<%=i %>"><%=obj.getInvestmentType().getInvestmentDescription()%></td>
				<td  width="10%" id="td3<%=i %>"><div align="center"> <input type="text" name="amount<%=i %>" id="amount<%=i %>" value="<%=!amt.equals(0)?amt:"" %>" validation='Amount,int,yes'  onchange="chkIfEmpSelected(this); setDateOfEntry(this.value,'<%=i %>')"></div></td>
				<td  width="20%" id="td4<%=i %>">
				<input type="text" id="date<%=i %>" name="date<%=i %>" value="<%=invDate!=null?HMSUtil.convertDateToStringWithoutTime(invDate):"" %>" class="calDate" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" validate="Date,date,no"  MAXLENGTH="10" />
				</td>
				<td  width="10%" id="td5<%=i %>"><input type="text" name="max_amount<%=i %>" id="max_amount<%=i %>" readonly value=" <%=obj.getMaxAmount() %>"/></td>
				<%if(docStatus!= null && docStatus.equalsIgnoreCase("y")){%>
				<td>
				<%=MainFileName %>
				<input type="file" class="browse" name="<%=RequestConstants.UPLOAD+obj.getInvestmentType().getInvestmentDescription()%>" /></td>
				<%}else{%>
				<td><input type="file" class="browse" name="<%=RequestConstants.UPLOAD+obj.getInvestmentType().getInvestmentDescription()%>" /></td>
				<%}%>
				</tr>
			
			  <%i++;}}%>
					
	
	   </tbody>
		  
</table>
		
	 <div class="paddingTop40"></div>
	 <div>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	 <%if(employeeInvestmentList.size()>0){ %>
	 
	  <%}else{%>
	  <input type="button" name="save" value="Save" class="button" onclick="submitInvestmentForm(<%=row%>);">
	  <%}%>
	<!-- <input type="reset" name="reset" id="reset" value="Reset" class="button"> -->
	<!-- <input type="button" name="cancel" value="Cancel" class="button"> -->
	</div>
	<div class="division"></div>
	<div class="paddingTop15"></div>
    	
    	<div class="clear"></div>
    	<div class="division"></div>
    	<div class="bottom">
        <label>Changed By</label>   
		<label class="value"><%=userName%></label>
		<label>Changed Date</label>   
		<label class="value"><%=sdate%></label>
		<label>Changed Time</label>   
		<label class="value"><%=time%></label>
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=sdate%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
		</div>
		<div class="clear"></div>
   		<div class="paddingTop40"></div>
 </form>

</div>
<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
<script type="text/javascript">
		function populateEmpInfo(eid,empCode,Fname,Lname)
		{
			document.getElementById("empid").value=eid;
			
			document.getElementById('labelsDiv').style.display="block";
			document.getElementById('Ecode').innerHTML=empCode;
			document.getElementById('Ename').innerHTML=Fname+" "+Lname;
			//document.getElementById('year').innerHTML=2009;
		}

		function setDateOfEntry(val,index)
		{
			
			var max_amount = parseInt(document.getElementById("max_amount"+index).value) ;
			var amount =parseInt( document.getElementById("amount"+index).value) ;
		
			if(amount<=max_amount){
			if(val=="")
			{
			document.getElementById("date"+index).value='';
			}
			else{
			document.getElementById("date"+index).value='<%= HMSUtil.convertDateToStringWithoutTime(new Date())%>';
			}
			}else{
				alert("Amount should be less than or equal to Max Amount.")
				document.getElementById("date"+index).value='';
				document.getElementById("amount"+index).value='';
			}
			
		}
		
		function chkIfEmpSelected(field)
		{
	if(document.getElementById('labelsDiv').style.display==="none")
			{
				alert("Please Select Employee First !");
				field.value="";
				document.getElementById("employeeList").focus();
			}
		}
		
		
		function submitInvestment(row){
			for(var i=1;i<=row;i++){
				if(document.getElementById('amount'+i).value!='0' && document.getElementById('amount'+i).value!=''){
					return true;
				}
			}
			return false;
	
		}
		function submitInvestmentForm(row){
			var flag = submitInvestment(row);
			if(flag == true){
				submitForm('employeeInvestment','/hms/hms/incomeTaxMaster?method=saveEmpIndividualInvestment');	
			}else{
				return alert("Please fill atleast one Section");
			}
		}
		
		function submitDataOnChange(){
			var flag =true;
			if(flag == true){
				submitForm('employeeInvestment','/hms/hms/incomeTaxMaster?method=showEmpIndividualInvestWithData');	
			}
		}
</script>