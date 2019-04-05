
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript"	language="javascript">
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
	</script>
<script type="text/javascript" language="javascript">
function checkTheOptions(){
		 var obj = document.getElementById("OutType").value;
			if(obj == "Excel"){
			submitForm('monthlySick','mis?method=searchMonthlySickExcelForm38BReport','checkFromNTodata');
			}else{
			submitForm('monthlySick','mis?method=searchMonthlySickDischargeReport','checkFromNTodata');
			}	
		}	
		
		function setradioValue(type){
	
		document.getElementById("OutType").value=type;
		}
	</script>
	
<form name="monthlySick" method="post" action="">

<div class="titleBg">
<h2>Monthly Sick Discharge Report for Staff (38-B)</h2>
</div>

<div class="Clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			    if (map.get("rankCategoryList") != null) {
			     rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
			    }
			 %>



<div class="Block">


<label> Date <span>*</span></label>

<input type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	class="calender" onClick="setdate('<%=currenDate%>',document.monthlySick.<%=FROM_DATE%>,event)" />

 
<label>Category </label> 
<select id="categoryId"	name="<%=CATEGORY_ID %>" onblur="getRankCatName(this);">
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {
		if(masRankCategory.getId()!=3 && masRankCategory.getId()!=4 && masRankCategory.getId()!=5 && masRankCategory.getId()!=6){
	%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}
	}%>
</select>
<input type="hidden" name="rankCatName" id="rankCatName" value="">
<%--
<input type="hidden" name="OutType"	id="OutType" value="Pdf" /> 
<label> From Date<span>*</span></label>
<input type="text" id="fromDateId" name="<%=FROM_DATE %>"	value="<%=currenDate %>" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currenDate%>',document.monthlySick.<%=FROM_DATE%>,event)" />

<label> To Date<span>*</span></label>
<input type="text"	id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	   onClick="setdate('<%=currenDate%>',document.monthlySick.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<label class="">NC/NON NC</label>

<label class="unit">NC</label>
<input type="radio" name="nc" id="nc" value="nc" class="radioAuto"	checked="checked" />
<label class="unit">Non NC</label>
<input type="radio" name="nc" id="nc" value="nonnc" class="radioAuto" /> 
<div class="Clear"></div>
<label>Output To <span>*</span></label>
 <label class="unit">PDF</label>
 <input type="radio" class="radioAuto" name="outputType" value="Pdf" checked="checked"	onClick="setradioValue(this.value)" />
 <label class="unit">Excel</label>
<input type="radio" name="outputType" class="radioAuto" value="Excel" onClick="setradioValue(this.value)" />

 --%>
</div>
<div class="clearPaddingTop10"></div>
<div class="division"></div>
<div class="clearPaddingTop10"></div><!--

<input type="button" name="OK" value="OK" class="button" onClick="checkTheOptions();" /> 
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();"	accesskey="r" />
-->
<input type="button" name="OK" value="OK" class="button" onClick="submitProtoAjax('monthlySick','/hms/hms/mis?method=getMonthlySickDischargeDetails')" /> 
	
<div class="Clear"></div>
<div id="testDiv"></div>
</form>
<script>
function getRankCatName(obj){
	var rank=obj.options[obj.selectedIndex].text;
	document.getElementById('rankCatName').value = rank;
}
function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var cnt = document.getElementById('cnt');
	  var iteration = parseInt(cnt.value)+1;
	  cnt.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name="serviceNo"+iteration;
	  e1.size = '7';
	  e1.tabIndex="1";
	  e1.onblur=function(){getServiceNoDetails('monthlySick','/hms/hms/mis?method=getServiceNoDetails&serviceNo='+this.value+'&counter='+iteration,iteration)};
	  cell1.appendChild(e1);

	  var cell11 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name="adNo"+iteration;
	  e11.id="adNo"+iteration;
	  e11.maxLength='50';
	  e11.size = '7';
	  e11.tabIndex="1";
	  cell11.appendChild(e11);

	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name="rank"+iteration;
	  e2.id="rank"+iteration;
	  e2.size = '5';
	  e2.tabIndex="1";
	  cell2.appendChild(e2);

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name="name"+iteration;
	  e3.id="name"+iteration;
	  e3.tabIndex="1";
	  cell3.appendChild(e3);

	  var e31 = document.createElement('input');
	  e31.type = 'hidden';
	  e31.name="hinId"+iteration;
	  e31.id="hinId"+iteration;
	  e31.tabIndex="1";
	  cell3.appendChild(e31);

	  var e32 = document.createElement('input');
	  e32.type = 'hidden';
	  e32.name="inpatientId"+iteration;
	  e32.id="inpatientId"+iteration;
	  e32.tabIndex="1";
	  cell3.appendChild(e32);

	  var cell4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name="unit"+iteration;
	  e4.id="unit"+iteration;
	  e4.size = '5';
	  e4.tabIndex="1";
	  cell4.appendChild(e4);

	  var cell5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name="diagnosis"+iteration;
	  e5.id="diagnosis"+iteration;
	  e5.maxLength='1000'
	  e5.size = '25';
	  e5.tabIndex="1";
	  cell5.appendChild(e5);

	  var cell6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name="disposedOff"+iteration;
	  e6.id="disposedOff"+iteration;
	  e6.maxLength='100'
	  e6.tabIndex="1";
	  cell6.appendChild(e6);

	 
	  var cell7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name="dod"+iteration;
	  e7.id="dod"+iteration;
	  e7.readOnly =true;
	  e7.size = '8';
	  e7.tabIndex="1";
	  cell7.appendChild(e7);

	  var cell8 = row.insertCell(8);
	  var e8 = document.createElement('img');
	  e8.src = '/hms/jsp/images/cal.gif';
	  e8.id = 'calDId'+iteration;
	  e8.onclick = function(event){
	  setdate('',document.getElementById('dod'+iteration),event) };
	  cell8.appendChild(e8);


	  var cell9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonAdd';
	  e9.name='Button'+iteration;
	  e9.onclick=function(){addRow();}; 
	  e9.tabindex='1';
	  cell9.appendChild(e9);

	  var cell10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonDel';
	  e10.name='delete'+iteration;
	  e10.onclick = function(){removeRow(this);}; 
	  e10.tabindex='1';
	  cell10.appendChild(e10);
}

function removeRow(obj)
{
var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
if (lastRow > 2){
  var i=obj.parentNode.parentNode.rowIndex;
  tbl.deleteRow(i);
}
}
</script>