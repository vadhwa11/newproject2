<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.HrMasReimbersement"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>(); 
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			if(map.get("reimbList")!= null){
				reimbList = (List)map.get("reimbList");
			}
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			int hospitalId = 0;
			if(hospitalList.size()>0){
				MasHospital masHospital = hospitalList.get(0);
				hospitalId = masHospital.getId();
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
		
%>

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
		
	 function selectTaxable(obj){
	   	if(obj.checked){
			
	   		document.getElementById('maxTaxExempId').value ="";
	   		document.getElementById('maxTaxExempId').readOnly = true;
	   	}else{
	   		document.getElementById('maxTaxExempId').readOnly = false;
	   	}
	  }
	  function checkAmount(){
	  if(parseInt(document.reimbersement.<%=MAXIMUM_AMOUNT%>.value) == 0){
	  	alert("Maximum Amount should not be zero");
	  	document.reimbersement.<%=MAXIMUM_AMOUNT%>.value == "";
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

<div class="titleBg"><h2>Reimbursement Master</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">


<label>Reimbursement Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>"   value="1" checked="checked" class="radioCheck" />
<label>Reimbursement Desc</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" style="margin-right:76px;" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Reimb Description,string,no"   MAXLENGTH="10" tabindex=1  onkeypress="return submitenter(this,event,'payrollMasters?method=searchReimbersement')" />
<input type="hidden" name="colCode" value="reimb_code">
<input type="hidden" name="colName" value="reimb_desc">
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchReimbersement','checkSearch')" tabindex=1  />


<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> --> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="hr_mas_reimbursement">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
<form name="ancher" method="post">

</form>
<% 
if(reimbList.size()>0)
{
String strForCode = (String)map.get("reimbCode");
String strForCodeDescription = (String)map.get("reimbDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> 


<a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showReimbersementJsp');">Show All Records</a>
<%
}
}
if(reimbList.size()==0 && map.get("search") != null)
{
%>
<a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showReimbersementJsp');">Show All Records</a>

<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= MAXIMUM_AMOUNT%>"],[4,"<%= TAXABLE%>"],[5,"<%= MAX_TAX_EXEMPTION%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],
[10,"<%=STATUS%>"]];
statusTd = 9;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="reimbersement" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="HrMasReimbersement">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ReimbDesc">
<input type="hidden" name="title" value="Reimbersement"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="hr_reimbersement"> 
<input	type="hidden" name="pojoPropertyCode" value="ReimbCode">
<div class="Block">
<label> Reimbursement Code<span>*</span></label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="ReimbCode,string,yes" MAXLENGTH="8" tabindex=1 />

<label class="auto">Reimbursement Description<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Reimb Description,string,yes" style="width:125px;" 
MAXLENGTH="200" tabindex=1  onkeypress="return submitenter(this,event,'attendance?method=saveShiftCode')" />
<script>
document.reimbersement.<%=CODE%>.focus();
</script>

<label>Max.Amount<span>*</span></label>
<input  type="text" name="<%= MAXIMUM_AMOUNT%>" id="maxAmount" value="" validate="Max.Amount,floatWithoutZero,yes"   MAXLENGTH="9" tabindex=1 />

<div class="clear"></div>

<label> Taxable</label>
<input  type="checkbox" name="<%= TAXABLE%>" value="" onclick="selectTaxable(this);" validate="Taxable,string,yes"  tabindex=1 class="radioCheck" />

<label> Max Tax Exemption</label>
<input id="maxTaxExempId" type="text" name="<%= MAX_TAX_EXEMPTION%>" id="maxTax"   value="" validate="Max Tax Exemption,floatWithoutZero,no" MAXLENGTH="9" tabindex=1 />

<label>Carry Forward</label>
<input  type="checkbox" name="<%= CARRY_FORWARD%>" value="" validate="Carry Forward,string,yes"  tabindex=1 class="radioCheck" />


<div class="clear"></div>
</div>


<div class="division"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('reimbersement','payrollMasters?method=saveReimbersement','checkAmount');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" style="display: none;"  class="button" onClick="submitForm('reimbersement','payrollMasters?method=editReimbersement','checkAmount')" accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;"  class="button" onClick="submitForm('reimbersement','payrollMasters?method=deleteReimbersement&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onClick="submitFormForButton('reimbersement','payrollMasters?method=showReimbersementJsp');" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
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

</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Reimbursement Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Reimbursement Desc."
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Max.Amount"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= MAXIMUM_AMOUNT %>"

data_header[3] = new Array;
data_header[3][0] = "Taxable"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= TAXABLE %>"

data_header[4] = new Array;
data_header[4][0] = "Max Tax Exemption"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= MAX_TAX_EXEMPTION %>"

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
data_header[9][2] = "15%";
data_header[9][3] = "<%=CARRY_FORWARD %>";



data_arr = new Array();

<%


Iterator itr=reimbList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasReimbersement hrMasReimbersement= (HrMasReimbersement)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasReimbersement.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasReimbersement.getReimbCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasReimbersement.getReimbDesc()%>"
data_arr[<%= counter%>][3] = "<%= hrMasReimbersement.getMaxAmount()%>"
data_arr[<%= counter%>][4] = "<%= hrMasReimbersement.getTaxable()%>"
<%
	if(hrMasReimbersement.getMaxTaxExemption() != null && !(hrMasReimbersement.getMaxTaxExemption().equals(""))){
%>
data_arr[<%= counter%>][5] = "<%= hrMasReimbersement.getMaxTaxExemption()%>"
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>
data_arr[<%= counter%>][6] = "<%= hrMasReimbersement.getLastChgBy()!=null?(hrMasReimbersement.getLastChgBy().getId()!=null?hrMasReimbersement.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasReimbersement.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrMasReimbersement.getLastChgTime() %>"


<% 

if(hrMasReimbersement.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>

data_arr[<%= counter%>][10] = "<%= hrMasReimbersement.getCarryForward() %>"
<%
counter++;
}
%>

formName = "reimbersement"
	nonEditable = ['<%= CODE%>'];

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	

