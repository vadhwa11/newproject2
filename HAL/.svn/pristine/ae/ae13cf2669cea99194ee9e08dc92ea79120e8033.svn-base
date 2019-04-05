<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
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
			submitForm('monthlySick','mis?method=searchMonthlySickExcelReport','checkFromNTodata');
			}else{
			submitForm('monthlySick','mis?method=searchMonthlySickReport','checkFromNTodata');
			}	
		}	
		
		function setradioValue(type){
	
		document.getElementById("OutType").value=type;
		}
	</script>
	
<form name="monthlySick" method="post" action="">
	
<div class="titleBg">
<h2>Monthly Sick Admission Report for Staff (38-A)</h2>
</div>	

<div class="Clear"></div>
<%
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
    if (map.get("rankCategoryList") != null) {
     rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
    }
	

%>

<div class="Block">
<input type="hidden" name="OutType"	id="OutType" value="Pdf" /> 
<%--
<label>From Date <span>*</span></label>

<input type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>" class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	class="calender" onClick="setdate('<%=currenDate%>',document.monthlySick.<%=FROM_DATE%>,event)" />

<label>To Date <span>*</span></label>
<input type="text"	id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"	class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.monthlySick.<%=TO_DATE%>,event)" />
 --%>
 
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
<div class="Clear"></div>
<%--
<label>NC/NON NC</label>

<label class="unit">NC</label> 
<input type="radio" name="nc" id="nc" value="nc" class="radioAuto"	checked="checked" />
<label class="unit">Non NC</label>
<input type="radio" name="nc" id="nc" value="nonnc" class="radioAuto" /> --%>
<div class="Clear"></div>
<%--
<label>Output To <span>*</span></label>
 <label class="unit">PDF</label>
 <input type="radio" class="radioAuto" name="outputType" value="Pdf" checked="checked"	onClick="setradioValue(this.value)" />
 <label class="unit">Excel</label>
<input type="radio" name="outputType" class="radioAuto" value="Excel" onClick="setradioValue(this.value)" /> --%>
</div>
<div class="clearPaddingTop10"></div>
<div class="division"></div>
<div class="clearPaddingTop10"></div>

<!--<input type="button" name="OK" value="OK" class="button" onClick="checkTheOptions();" />--> 
	<input type="button" name="OK" value="OK" class="button" onClick="submitProtoAjax('monthlySick','/hms/hms/mis?method=getMonthlySickAdmissionDetails')" /> 
	
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();"	accesskey="r" />
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
	  e4.name="age"+iteration;
	  e4.id="age"+iteration;
	  e4.size = '4';
	  e4.tabIndex="1";
	  cell4.appendChild(e4);

	  var cell5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name="unit"+iteration;
	  e5.id="unit"+iteration;
	  e5.size = '5';
	  e5.tabIndex="1";
	  cell5.appendChild(e5);

	  var cell6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name="trade"+iteration;
	  e6.id="trade"+iteration;
	  e6.size = '9';
	  e6.tabIndex="1";
	  cell6.appendChild(e6);

	  var cell7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name="diagnosis"+iteration;
	  e7.size = '25';
	  e7.maxLength='1000'
	  e7.tabIndex="1";
	  cell7.appendChild(e7);

	  var cell8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name="doa"+iteration;
	  e8.id="doa"+iteration;
	  e8.onblur=function(){getNoOfDays(iteration)};
	  e8.size = '8';
	  e8.tabIndex="1";
	  cell8.appendChild(e8);

	  var cell9 = row.insertCell(9);
	  var e81 = document.createElement('img');
	  e81.src = '/hms/jsp/images/cal.gif';
	  e81.id = 'calId'+iteration;
	  e81.onclick = function(event){
	  setdate('',document.getElementById('doa'+iteration),event) };
	  cell9.appendChild(e81);


	  var cell10 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name="disposedOff"+iteration;
	  e9.maxLength='100'
	  e9.tabIndex="1";
	  cell10.appendChild(e9);

	  var cell11 = row.insertCell(11);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.name="dod"+iteration;
	  e10.id="dod"+iteration;
	  e10.onblur=function(){getNoOfDays(iteration)};
	  e10.size = '8';
	  e10.tabIndex="1";
	  cell11.appendChild(e10);

	  var cell12 = row.insertCell(12);
	  var e101 = document.createElement('img');
	  e101.src = '/hms/jsp/images/cal.gif';
	  e101.id = 'calDId'+iteration;
	  e101.onclick = function(event){
	  setdate('',document.getElementById('dod'+iteration),event) };
	  cell12.appendChild(e101);

	  var cell13 = row.insertCell(13);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name="noOfDays"+iteration;
	  e11.id="noOfDays"+iteration;
	  e11.size = '2';
	  e11.tabIndex="1";
	  cell13.appendChild(e11);

	  var cell14 = row.insertCell(14);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.name="remarks"+iteration;
	  e12.id="remarks"+iteration;
	  e12.maxLength = '200';
	  e12.tabIndex="1";
	  cell14.appendChild(e12);

	  var cell15 = row.insertCell(15);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='Button'+iteration;
	  e13.onclick=function(){addRow();}; 
	  e13.tabindex='1';
	  cell15.appendChild(e13);

	  var cell16 = row.insertCell(16);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='delete'+iteration;
	  e14.onclick = function(){removeRow(this);}; 
	  e14.tabindex='1';
	  cell16.appendChild(e14);
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

function getNoOfDays(inc){

	var doa = document.getElementById('doa'+inc).value;
	var dod = document.getElementById('dod'+inc).value;
	currentDate = new Date();
	if(doa!=''){
		var doaDate = new Date(doa.substring(6),(doa.substring(3,5) - 1) ,doa.substring(0,2))
		if(doaDate > currentDate){
			alert("Date of Admission can not ne greater than current date.");
			document.getElementById('doa'+inc).value ='';
			return false;
		}
	}
	if(dod!=''){
		var dodDate = new Date(dod.substring(6),(dod.substring(3,5) - 1) ,dod.substring(0,2))
		if(dodDate > currentDate){
			alert("Date of Discharge can not ne greater than current date.");
			document.getElementById('dod'+inc).value ='';
			return false;
		}
	}
	if(doa!='' && dod!=''){
		if(doaDate > dodDate){
			alert("Date of Discharge is not valid.");
			document.getElementById('dod'+inc).value ='';
			return false;
		}
	
		var one_day=1000*60*60*24; 
	    var da=doa.split("/");
	    var dd=dod.split("/");
	    var date1=new Date(da[2],(da[1]-1),da[0]);
	    var date2=new Date(dd[2],(dd[1]-1),dd[0]);
	 
	    diff=Math.ceil((date2.getTime()-date1.getTime())/(one_day)); 
	    document.getElementById('noOfDays'+inc).value = parseInt(diff)+1;
	}
}

</script>