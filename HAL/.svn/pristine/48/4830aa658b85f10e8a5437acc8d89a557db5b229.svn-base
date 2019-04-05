<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.HrMasPayElement"%>
<%@ page import="jkt.hms.util.HMSUtil" %>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script language="javascript">

var $j = jQuery.noConflict();
</script>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
			if(map.get("payElementList")!= null){
				payElementList = (List)map.get("payElementList");
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
						
			List<MasHospital> locationList = new ArrayList<MasHospital>();
			locationList = (ArrayList)map.get("locationList");

			ArrayList lList = (ArrayList)map.get("lList");
		
%>


<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript">
	
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
		
	 function selectBasicDependent(obj){
	   	if(obj.checked){
			document.getElementById('basicMultiplierId').readOnly = false;
	   		document.getElementById('basicMultiplierId').focus();
	   	}else{
	   		document.getElementById('basicMultiplierId').value ="";
	   		document.getElementById('basicMultiplierId').readOnly = true;
	   	}
	  }
		
		function prevailingPercentage(obj){
		   	if(obj.checked){
				document.getElementById('percentageAmt').readOnly = false;
		   		document.getElementById('percentageAmt').focus();
		   	}else{
		   		document.getElementById('percentageAmt').value ="";
		   		document.getElementById('percentageAmt').readOnly = true;
		   	}
		  }
	function checkStatusDate(){
			var eDate = document.payElement.<%= EFFECTIVE_DATE%>.value;
			var sDate = document.payElement.<%= STATUS_DATE %>.value;
		
			var	effectiveDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
			var statusDate =new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2))
			if(effectiveDate > statusDate)
			{
				alert(" Effective date should not be greater than status date.");
				document.payElement.<%= EFFECTIVE_DATE%>.value = "";
				document.payElement.<%= STATUS_DATE %>.value = "";
				return false;
			}
			return true;
		}
	

</script>

<div class="titleBg"><h2>Pay Element Master</h2></div>

<div class="clear"></div>

<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>PayElement Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>"   value="1" checked="checked" class="radioAuto" tabindex="1"/>
<label>PayElement Description</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto"  tabindex="1"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" tabindex="1" validate="PayElement Description,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'payrollMasters?method=searchPayElement')" />

<input type="hidden" name="colCode" value="pay_element_code">
<input type="hidden" name="colName" value="pay_element_desc">

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchPayElement','checkSearch')" tabindex=1  />

<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> --> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="hr_mas_pay_element">
</form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="ancher" method="post">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<% 
if(payElementList.size()>0)
{
String strForCode = (String)map.get("payElementCode");
String strForCodeDescription = (String)map.get("payElementDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> 


<!-- <h4><a href="payrollMasters?method=showPayElementJsp">Show All Records</a></h4> -->
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showPayElementJsp');">Show All Records</a></h4>
<%
}
}
if(payElementList.size()==0 && map.get("search") != null)
{
%>
<!-- <h4><a href="payrollMasters?method=showPayElementJsp">Show All Records</a></h4> -->
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showPayElementJsp');">Show All Records</a></h4>
<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= PAY_ELEMENT_TYPE%>"],[4,"<%= BASIC_DEPENDENT%>"],[5,"<%= PF_DEPENDENT%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],
 [10,"<%=EFFECTIVE_DATE%>"],[11,"<%=TAXABLE%>"],[12,"<%=OT_CALCULATION%>"],[13,"<%=BASIC_MULTIPLIER%>"],[14,"<%=ARREAR_ELEMENT%>"],[15,"<%=REIMB_ELEMENT%>"],[16,"<%=PAY_ELEMENT_STATUS%>"],[17,"<%=STATUS_DATE%>"],[18,"<%=MAXIMUM_AMOUNT%>"],[19,"<%=CTC_HEADING%>"],[20,"<%=SHOW_IN_PAYSLIP%>"],[21,"locationId"],[22,"lblPrePercentage"],[23,"percentageAmt"] ];
statusTd = 9;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="payElement" method="post" action="">

<div class="Block">
<label> Pay Element Code<span>*</span> </label>
<input id="codeId" type="text" name="<%= CODE%>" tabindex="1" value="" validate="PayElement,string,yes" MAXLENGTH="15" />

<label> Description<span>*</span> </label>
<input type="text" name="<%= SEARCH_NAME %>" tabindex="1" value="" validate="PayElement Description,string,yes"  MAXLENGTH="200"  />
<script>
document.payElement.<%=CODE%>.focus();
</script>
<label> Effective Date<span>*</span>  </label>
<input type="text" name="<%=EFFECTIVE_DATE %>" id="ed" tabindex="1" value="" class="calDate" size="7" validate="Effective Date  ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'ed');" />

<div class="clear"></div>
<label> Pay Ele. Type<span>*</span> </label>
<select  name="<%=PAY_ELEMENT_TYPE %>"   validate="PayElement Type,string,yes"  tabindex="1">
<option value="">Select</option>
<option value="Addition">Earning</option>
<option value="Deduction">Deduction</option>
<option value="Reimb">Reimbursement</option>
<option value="Other Benefits">Other Benefits</option>
</select>

<label> Taxable Element</label>
<input  type="checkbox" name="<%= TAXABLE%>" value="" validate="Taxable Element,string,yes" tabindex="1" class="radioCheck" />

<label> Over Time Cal.</label>
<input type="checkbox" name="<%= OT_CALCULATION %>" value="" validate="Over Time,string,yes"  tabindex="1" class="radioCheck" />


<div class="clear"></div>
<label> Basic Multiplier(%)</label>
<input id="basicMultiplierId" type="text" readonly="readonly" name="<%= BASIC_MULTIPLIER%>" value="0.0" validate="Basic Multiplier,Float,no" MAXLENGTH="5"tabindex="1" />
<label> Arrear Element</label>
<input id="codeId" type="checkbox" name="<%= ARREAR_ELEMENT%>" value="" validate="Arrear Element,string,yes"  tabindex="1" class="radioCheck" />
<label> Reimb Element </label>
<input id="codeId" type="checkbox" name="<%= REIMB_ELEMENT%>" value="" validate="Reimb Element,string,yes"  tabindex="1"class="radioCheck" />
<div class="clear"></div>
<label>Status Date<span>*</span></label>
<input type="text" name="<%=STATUS_DATE %>" id="sd" value="" class="calDate" size="7" validate="Status date ,date,yes"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'sd');"  tabindex="1"/>

 <label>Basic Dependent</label>
<input  type="checkbox" name="<%= BASIC_DEPENDENT%>" value="" tabindex="1" validate="Basic Dependent,string,yes" onclick="selectBasicDependent(this);" tabindex=1 class="radioCheck" />
<label>PF Dependent</label>
<input id="codeId" type="checkbox" name="<%= PF_DEPENDENT %>" tabindex="1" value="" validate="PF Dependent,string,yes"   class="radioCheck" />
<div class="clear"></div>
<label>Max Amount</label>
<input type="text" name="<%=MAXIMUM_AMOUNT %>" id="maxAmount" validate="Max Amount,float,no" tabindex="1" onchange="checkAmount(this);" maxlength="8"/>

<label>CTC Annx Heading<span>*</span></label>
<select  name="<%=CTC_HEADING %>"   validate="CTC Annx Heading,string,yes"  tabindex="1">
<option value="">Select</option>
<option value="None">None</option>
<option value="Other Allowance">Other Allowance</option>
<option value="Reimbursement">Reimbursement</option>
<option value="Retiral Benefits">Retiral Benefits</option>
<option value="Value of Benefits in kind to be provided by company">Value of Benefits in kind to be provided by company</option>
</select>

<label>Status<span>*</span></label>
<select id="paymentFrequencyId" name="<%=PAY_ELEMENT_STATUS %>"   tabindex="1" validate="Status,string,yes"  >
<option value="">Select</option>
<option value="Active">Active</option>
<option value="InActive">InActive</option>
</select>

<div class="clear"></div>


<%-- <label> Centre<span>*</span></label> 
 <select name="locationId" tabindex="1" validate="Centre,nothing,yes">
<option value="0">Select</option>
	<% 	for (MasHospital  masHospital : locationList){%>
		
		<option value="<%=masHospital.getId ()%>"><%=masHospital.getHospitalName()%>
	<%}%>

</select> --%>

<label>Prevailing Percentage</label>
<input  type="checkbox" name="lblPrePercentage" id="lblPrePercentage" tabindex="1" value="" validate="Prevailing Percentage,string,yes"  class="radioCheck" onClick="prevailingPercentage(this)"/>
<label> Percentage(%)</label>
<input id="percentageAmt" type="text" readonly="readonly" name="percentageAmt" value="0.0" validate="Prevailing Percentage,Float,no" MAXLENGTH="5"tabindex="1" />
<div class="clear"></div>
<label>Show in Payslip</label>
<input  type="checkbox" name="<%= SHOW_IN_PAYSLIP%>" tabindex="1" value="" validate="Show in JSP,string,yes"  class="radioCheck" />

<div class="clear"></div>


</div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" tabindex="1" id="addbutton" value="Add" class="button" onClick="submitForm('payElement','payrollMasters?method=savePayElement','checkStatusDate');" accesskey="a" tabindex=1/>

<input type="button" name="edit" tabindex="1" id="editbutton" value="Update" class="button"style="display: none;" onClick="submitForm('payElement','payrollMasters?method=editPayElement','checkStatusDate')" accesskey="u" tabindex=1 />

<input type="button" name="Delete" tabindex="1" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('payElement','payrollMasters?method=deletePayElement&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" tabindex="1" id="reset" value ="Reset" class="button" onClick="submitFormForButton('payElement','payrollMasters?method=showPayElementJsp')" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>

<label>Changed Time</label>   
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
</div>	

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />


</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "PayEle.Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "PayEle.Type"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= PAY_ELEMENT_TYPE %>"

data_header[3] = new Array;
data_header[3][0] = "Basic Dep."
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= BASIC_DEPENDENT %>"

data_header[4] = new Array;
data_header[4][0] = "PF Dep."
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PF_DEPENDENT %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= EFFECTIVE_DATE%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= TAXABLE%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%= OT_CALCULATION%>";



data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%= BASIC_MULTIPLIER%>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= ARREAR_ELEMENT%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= REIMB_ELEMENT%>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%= PAY_ELEMENT_STATUS%>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= STATUS_DATE%>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%= MAXIMUM_AMOUNT%>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%= CTC_HEADING%>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%= SHOW_IN_PAYSLIP%>";


data_header[20] = new Array;
data_header[20][0] = "Centre"
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "locationId";

data_header[21] = new Array;
data_header[21][0] = "lblPrePercentage"
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "lblPrePercentage";

data_header[22] = new Array;
data_header[22][0] = "percentageAmt"
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "percentageAmt";

data_arr = new Array();

<%


Iterator itr=payElementList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasPayElement hrMasPayElement= (HrMasPayElement)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasPayElement.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasPayElement.getPayElementCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasPayElement.getPayElementDesc()%>"
data_arr[<%= counter%>][3] = "<%= hrMasPayElement.getPayElementType()%>"
data_arr[<%= counter%>][4] = "<%= hrMasPayElement.getBasicDependent()%>"
data_arr[<%= counter%>][5] = "<%= hrMasPayElement.getPfDependent()%>"
data_arr[<%= counter%>][6] = "<%= hrMasPayElement.getLastChgBy()!=null?(hrMasPayElement.getLastChgBy().getId()!=null?hrMasPayElement.getLastChgBy().getId():"0" ):"0"%>"

data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasPayElement.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrMasPayElement.getLastChgTime() %>"

data_arr[<%= counter%>][22] = "<%= hrMasPayElement.getPrevailingPercentage()%>"

	<%
	if(hrMasPayElement.getPercentage()!= null && !(hrMasPayElement.getPercentage().equals(""))){

%>

data_arr[<%= counter%>][23] = "<%= hrMasPayElement.getPercentage()%>"
<% 
	}else {
%>
data_arr[<%= counter%>][23] = "";
<%}%>

<% 
if(hrMasPayElement.getPayElementStatus().equals("Active")){ %>
data_arr[<%= counter%>][9] = "Active"<%}else{%>data_arr[<%= counter%>][9] = "InActive"
<%}%>
data_arr[<%= counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasPayElement.getEffectiveDate()) %>"
data_arr[<%= counter%>][11] = "<%=hrMasPayElement.getTaxableElement() %>"
data_arr[<%= counter%>][12] = "<%= hrMasPayElement.getOtCalculation() %>"
<%
	if(hrMasPayElement.getBasicMultiplier()!= null && !(hrMasPayElement.getBasicMultiplier().equals(""))){

%>

data_arr[<%= counter%>][13] = "<%= hrMasPayElement.getBasicMultiplier()%>"
<% 
	}else {
%>
data_arr[<%= counter%>][13] = ""
<%}
%>
data_arr[<%= counter%>][14] = "<%= hrMasPayElement.getArrearElement() %>"
data_arr[<%= counter%>][15] = "<%= hrMasPayElement.getReimbElement() %>"
data_arr[<%= counter%>][16] = "<%= hrMasPayElement.getPayElementStatus() %>"
data_arr[<%= counter%>][17] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasPayElement.getStatusDate()) %>"
<%if(hrMasPayElement.getMaxAmount()!=null){%>
data_arr[<%= counter%>][18] = "<%= hrMasPayElement.getMaxAmount() %>"
<%}else{%>
data_arr[<%= counter%>][18] = ""
<%}%>
<%if(hrMasPayElement.getCtcHeading()!=null){%>
data_arr[<%= counter%>][19] = "<%=hrMasPayElement.getCtcHeading()  %>"
<%}else{%>
data_arr[<%= counter%>][19] = "";<%}%>
	

data_arr[<%= counter%>][20] = "<%= hrMasPayElement.getShowInPayslip() %>"
	

<%
Iterator locList=lList.iterator();
 while(locList.hasNext())
    {
	 try{
		 MasHospital  location = (MasHospital)locList.next(); 
	 if(hrMasPayElement.getHospital().getId().equals(location.getId()) && location.getStatus().equals("y")){%>
		data_arr[<%= counter%>][21] = "<%=location.getHospitalName()%>"
	<%}else if(hrMasPayElement.getHospital().getId().equals(location.getId()) && location.getStatus().equals("n")){%>
		data_arr[<%= counter%>][21] = "<font id='error'>*</font>Parent InActivated--<%=location.getHospitalName()%>";
		
	<%}
    }catch(Exception e){}}%>
<%
counter++;
}
%>

formName = "payElement"

nonEditable = ['<%= CODE%>'];


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	

