<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmpCategory> empCategorylist = new ArrayList<MasEmpCategory>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();	
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("financialList")!= null){
					financialList = (List)map.get("financialList");
				}
				if(map.get("empCategorylist")!= null){
					empCategorylist = (List)map.get("empCategorylist");
				}
				
				
	%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<script type="text/javascript">
	function convertMonthInString(month){
	var pMonth = "" ;
		if(month == 0){
			pMonth = "";
		}else if(month == 1){
			pMonth = "January";
		}else if(month == 2){
			pMonth = "February";
		}else if(month == 3){
			pMonth = "March";
		}else if(month == 4){
			pMonth = "April";
		}else if(month == 5){
			pMonth = "May";
		}else if(month == 6){
			pMonth = "June";
		}else if(month == 7){
			pMonth = "July";
		}else if(month == 8){
			pMonth = "August";
		}else if(month == 9){
			pMonth = "September";
		}else if(month == 10){
			pMonth = "October";
		}else if(month == 11){
			pMonth = "November";
		}else if(month == 12){
			pMonth = "December";
		}
		
		
		document.getElementById('monthStringId').value = pMonth;
	}
	
function getEmpList(idvalue){
		var w = document.getElementById('empCategoryId').selectedIndex;

	    var selectedText = document.getElementById('empCategoryId').options[w].text;
        
        document.getElementById('categoryString').value = selectedText;
        
        
 		var sel1 = document.getElementById("empId");
		removeAllOptions(sel1);
		var sel = document.getElementById("empId");
		sel.options.add(new Option('All','0'));
		<%
		for (MasEmployee masEmployee : employeeList) {
			if(masEmployee.getEmpCategory() != null){%>
			if(idvalue == <%=masEmployee.getEmpCategory().getId()%>){
				sel.options.add(new Option('<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"---"+masEmployee.getEmployeeCode()%>' , '<%=masEmployee.getId()%>'));
			}
	<%}
		}
	%>
	
	}



</script>


<form name="earningAndDeduction" method="post" action="" >
<div class="titleBg"> <h2>Earning And Deduction Summary</h2></div>
<div class="clear"></div>
<div class="Block">
<%-- 
<label>Employee Category</label>
<select name="<%=EMP_CATEGORY_ID %>" id="empCategoryId" validate="Employee Category,string,no" onchange="getEmpList(this.value);" onkeyUp="getEmpList(this.value);" tabindex=1 >
<option value="0">Select</option>
<%
	for(MasEmpCategory masEmpCategory :empCategorylist){
%>
<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName()%></option>
			
<%
	}
%>
</select>
--%>
<label>Employee</label>
<select name="<%=EMPLOYEE_ID %>" id="empId" validate="Employee ,string,no"  >
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
			
<%
	}
%>
</select>

<label><span>*</span>Year</label>
<select  name="<%=YEAR %>" validate="Year,string,yes" ">
<option value="0">Select</option>
<%
for(MasStoreFinancial msf : financialList)
{

%>
<option value=<%=msf.getYearDescription()%>><%=msf.getFinancialYear()%></option>
<%
	
}
%>
</select>

<label><span>*</span> Month</label>
<select  name="<%=MONTH %>" validate="Month,string,yes" onchange="convertMonthInString(this.value)">
<option value="0">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<input type="hidden" name ="monthString" id="monthStringId" value="">


<input type="hidden" name ="categoryString" id="categoryString" value="">

<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="View" onclick="submitForm('earningAndDeduction','payroll?method=printEarningAndDeductionReport');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

</form>

