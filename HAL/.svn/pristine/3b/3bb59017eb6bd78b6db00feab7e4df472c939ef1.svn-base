<%@page import="jkt.hms.masters.business.HrMasBonus"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
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
			List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			if(map.get("bonusList")!= null){
				bonusList = (List)map.get("bonusList");
			}
			if(map.get("gradeList")!= null){
				gradeList = (List)map.get("gradeList");
			}
			System.out.println("in jsp gradeList------"+gradeList.size());
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
		
%>

<%@page import="jkt.hms.masters.business.MasGrade"%>
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
		
   function selectPaymentFrequency(val){
   	if(val == "Yearly"){
   		document.getElementById('paymentFrequencyId').readOnly = true;
   		document.getElementById('paymentFrequencyId').value="Yearly";
   	}else {
		document.getElementById('paymentFrequencyId').readOnly = false;
   		document.getElementById('paymentFrequencyId').value="";
   	}
  }
  
  function checkFromDate(){
		var fDate = document.bonus.<%= FROM_DATE%>.value;
		var tDate = document.bonus.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert("To Date should be greater than From Date.");
			document.bonus.<%= FROM_DATE%>.value = "";
			document.bonus.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	
	function validateFieldsForDisplay(){
		var errMsg = "";
		var fixedAmount = document.getElementById('fixedAmountId').value;
		var maxBasic = document.getElementById('maxBasicId').value;
		var bonusRate = document.getElementById('bonusRateId').value;
		
		if(fixedAmount == "" && maxBasic == "" && bonusRate ==  ""  ){
			errMsg += "Please fill either Fixed Amount or Fixed Amount & MaxBasic or either MaxBasic & Basic Rate  .\n";
		}
	
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}
		
		return true;
}

</script>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg"><h2>Bonus Master</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Bonus Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>"   value="1" checked="checked" class="radioCheck" tabindex="1"/>
<label>Bonus Description</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"  tabindex="1"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  tabindex="1" validate="Bonus Description,string,no"   MAXLENGTH="15"  onkeypress="return submitenter(this,event,'payrollMasters?method=searchBonus')" />
<input type="hidden" name="colCode" value="bonus_code">
<input type="hidden" name="colName" value="description">
<input type="button" name="search" tabindex="1" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchBonus','checkSearch')"  />



<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> --> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="hr_mas_bonus">
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
if(bonusList.size()>0)
{
String strForCode = (String)map.get("bonusCode");
String strForCodeDescription = (String)map.get("bonusDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> 


<!-- <h4><a href="payrollMasters?method=showBonusJsp">Show All Records</a></h4> -->
<h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showBonusJsp');">Show All Records</a></h4>
<%
}
}
if(bonusList.size()==0 && map.get("search") != null)
{
%>
<!-- <h4><a href="payrollMasters?method=showBonusJsp">Show All Records</a></h4> -->
<h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showBonusJsp');">Show All Records</a></h4>
<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= PAYMENT_FREQUENCY%>"],[4,"<%= BONUS_RATE%>"],[5,"<%= DUE_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],
[10,"<%=FROM_DATE%>"],[11,"<%=TO_DATE%>"],[12,"<%=TAXABLE%>"],[13,"<%=BONUS_TYPE%>"],[14,"<%=FIXED_AMOUNT%>"],[15,"<%=MAX_BASIC%>"] ,[16,"<%=GRADE_ID%>"]];
statusTd = 9;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="bonus" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="HrMasBonus">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Description">
<input type="hidden" name="title" value="Bonus"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="hr_bonus"> 
<input	type="hidden" name="pojoPropertyCode" value="BonusCode">
<div class="Block">
<label> Bonus Code<span>*</span></label>
<input id="codeId" type="text" tabindex="1" name="<%= CODE%>" value="" validate="BonusCode,string,yes" MAXLENGTH="8" />

<label id=biglabel> Bonus Description<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" tabindex="1"  value="" validate="Bonus Description,string,yes"  MAXLENGTH="200"   />
<script>
document.bonus.<%=CODE%>.focus();
</script>
<label> From Date<span>*</span></label>
<input type="text" name="<%=FROM_DATE %>" tabindex="1"  id="fd" value=""  tabindex="1" validate="From date ,date,yes"  class="calDate" size="7"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'fd');" />
 
<script>
document.bonus.<%=FROM_DATE%>.focus();
</script>
<div class="clear"></div>
<label> To Date<span>*</span></label>
<input type="text" tabindex="1"  id="td" name="<%=TO_DATE %>" value=""  tabindex="1" validate="To date ,date,yes"  class="calDate" size="7" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" />
 
<label> Taxable<span>*</span></label>
<input  type="checkbox"  tabindex="1" name="<%= TAXABLE%>" value="" validate="Taxable,string,yes"  class="radioCheck" />

<label>Bonus Type<span>*</span></label>
<select  name="<%=BONUS_TYPE %>"   tabindex="1"  validate="Bonus Type,string,yes" onchange="selectPaymentFrequency(this.value);" >
<option value="">Select</option>
<option value="Yearly">Yearly</option>
<option value="pro">Pro</option>
</select>
<div class="clear"></div>
<label> Payment Frequency<span>*</span></label>
<select id="paymentFrequencyId"  tabindex="1" name="<%=PAYMENT_FREQUENCY %>"   validate="Payment Frequency,string,yes" class="mediumm" >
<option value="0">Select</option>
<option value="Yearly">Yearly</option>
<option value="Weekly">Weekly</option>
<option value="Monthly">Monthly</option>
</select>

<label> Due Date<span>*</span></label>
<input type="text" name="<%=DUE_DATE %>" tabindex="1"  value=""  id="dueDate" tabindex="1" validate="Due date ,date,yes"  class="calDate" size="7"   onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'dueDate');" />


<div class="clear"></div>
</div>
<div class="clear"></div>

<h4>Maximum Basic For Fixed Amount</h4>
<div class="clear"></div>
<div class="Block">
<label> Fixed Amount</label>
<input id="fixedAmountId"  tabindex="1"  type="text" name="<%= FIXED_AMOUNT%>" value=""  validate="Fixed Amount,floatWithoutZero,no" MAXLENGTH="9" />
<label> Max Basic</label>
<input id="maxBasicId"  tabindex="1"  type="text" name="<%= MAX_BASIC%>" value=""   validate="Max Basic,floatWithoutZero,no" MAXLENGTH="9" />
<label> Grade</label>
<select  name="<%=GRADE_ID %>" validate="Grade Code,string,no"  tabindex="1" >
<option value="0">Select</option>
<%
	for(MasGrade masGrade :gradeList){
%>
<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName()%></option>
<%
	}
%>
</select>
<div class="clear"></div>
<label> Bonus% Rate</label>
<input id="bonusRateId"   tabindex="1" type="text" name="<%= BONUS_RATE%>" value=""   validate="Bonus% Rate,floatWithoutZero,no" MAXLENGTH="5" />
<div class="clear"></div>
</div>

<div id="edited"></div>
<input type="button"  tabindex="1" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('bonus','payrollMasters?method=saveBonus','checkFromDate','validateFieldsForDisplay');" accesskey="a" />

<input type="button"  tabindex="1" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('bonus','payrollMasters?method=editBonus','checkFromDate')" accesskey="u" />

<input type="button"  tabindex="1" name="Delete" id="deletebutton" value="Activate"  style="display: none;" class="button" onClick="submitForm('bonus','payrollMasters?method=deleteBonus&flag='+this.value)" accesskey="d" />		


<input type="reset"  tabindex="1" name ="Reset" id="reset" value ="Reset" class="button" onClick="submitFormForButton('bonus','payrollMasters?method=showBonusJsp');" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
data_header[0][0] = "Bonus Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "P.Frequency"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= PAYMENT_FREQUENCY %>"

data_header[3] = new Array;
data_header[3][0] = "Bonus%Rate"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= BONUS_RATE %>"

data_header[4] = new Array;
data_header[4][0] = "Due Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= DUE_DATE %>"

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
data_header[9][3] = "<%= FROM_DATE%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= TO_DATE%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%= TAXABLE%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=BONUS_TYPE%>";


data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= FIXED_AMOUNT%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= MAX_BASIC%>";

data_header[15] = new Array;
data_header[15][0] = "Grade"
data_header[15][1] = "data";
data_header[15][2] = 0;
data_header[15][3] = "<%= GRADE_ID%>";

data_arr = new Array();

<%


Iterator itr=bonusList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasBonus hrMasBonus= (HrMasBonus)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasBonus.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasBonus.getBonusCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasBonus.getDescription()%>"
data_arr[<%= counter%>][3] = "<%= hrMasBonus.getPaymentFrequency()%>"
<%
	if(hrMasBonus.getBonusRate() != null && !(hrMasBonus.getBonusRate().equals(""))){
%>
data_arr[<%= counter%>][4] = "<%= hrMasBonus.getBonusRate()%>"
<%
	}else{
%>
data_arr[<%= counter%>][4] = ""
<%
	}
%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getDueDate())%>"
	data_arr[<%= counter%>][6] = "<%= hrMasBonus.getLastChgBy()!=null?(hrMasBonus.getLastChgBy().getId()!=null?hrMasBonus.getLastChgBy().getId():"0" ):"0"%>"

data_arr[<%= counter%>][7] = "<%= hrMasBonus.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getLastChgDate()):"" %>"
data_arr[<%= counter%>][8] = "<%= hrMasBonus.getLastChgTime()!=null?hrMasBonus.getLastChgTime():"" %>"



<% 

if(hrMasBonus.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active";
<%}else{%>
data_arr[<%= counter%>][9] = "InActive";
<%}%>
data_arr[<%= counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getFromDate()) %>"
data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getToDate()) %>"
data_arr[<%= counter%>][12] = "<%= hrMasBonus.getTaxable() %>"
data_arr[<%= counter%>][13] = "<%= hrMasBonus.getBonusType() %>"
<%
	if(hrMasBonus.getFixedAmount() != null && !(hrMasBonus.getFixedAmount().equals(""))){
%>
data_arr[<%= counter%>][14] = "<%=hrMasBonus.getFixedAmount()%>"
<%
	}else{
%>
data_arr[<%= counter%>][14] = ""
<%
	}
%>
<%
	if(hrMasBonus.getMaxBasic() != null && !(hrMasBonus.getMaxBasic().equals(""))){
%>
data_arr[<%= counter%>][15] = "<%= hrMasBonus.getMaxBasic()%>"
<%
	}else{
%>
data_arr[<%= counter%>][15] = ""
<%
	}
%>


<%
Iterator itrGridGradeList=gradeList.iterator();
 while(itrGridGradeList.hasNext())
    {
	 try{
		 MasGrade  masGrade = (MasGrade)itrGridGradeList.next(); 
	 if(hrMasBonus.getGrade().getId().equals(masGrade.getId()) && masGrade.getStatus().equals("y")){%>
		data_arr[<%= counter%>][16] = "<%=masGrade.getGradeName()%>"
	<%}else if(hrMasBonus.getGrade().getId().equals(masGrade.getId()) && masGrade.getStatus().equals("n")){%>
		data_arr[<%= counter%>]16] = "<font id='error'>*</font>Parent InActivated--<%=masGrade.getGradeName()%>";
		
	<%}
    }catch(Exception e){}}%>
<%
counter++;
}
%>

formName = "bonus"
nonEditable = ['<%= CODE%>'];

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

