<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.AvPilotRegistrationDt"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function addAll(){
var rowLength=document.getElementById("count").value;

if(document.getElementById("add_ALL").checked){

	for(i=1;i<=rowLength;i++){
		document.getElementById("pilot_dt_id"+i).checked=true;
		}	
}else{
	for(i=1;i<=rowLength;i++){
		document.getElementById("pilot_dt_id"+i).checked=false;
		}
}
}
</script>
<%
	String date = "";
	String time = "";
	String userName = "";
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	date = (String)utilMap.get("currentDate");	 
	time = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int currentPage=1;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}System.out.println("pagedArray--->"+pagedArray);
	if(pagedArray!=null){
		if((Integer)pagedArray.getCurrentPage()!=null){
			currentPage=pagedArray.getCurrentPage();
		}
	}
	List<AvPilotRegistrationDt>pilotRegistrationList = new ArrayList<AvPilotRegistrationDt>();
	if(map.get("pilotRegistrationList")!=null){
		pilotRegistrationList=(List<AvPilotRegistrationDt>)map.get("pilotRegistrationList");
	}
%>
<form name="pilotDetail">
<input type="hidden" name="pageType" id="pageType" value="<%=box.get("pageType")%>" /> 
<input type="hidden" id="addedItems" name="addedItems" value="<%=box.get("addedItems")%>" />
<%
if(pilotRegistrationList.size() >0){ %> 


<div class="Clear"></div>
<h4>Pilot Details</h4>
<div class="Clear"></div>
<div class="cmntableWithHeight">
<table width="75%" colspan="7" id="pilotDetail" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="10%">Sl No.</th>
			<th width="10%">Service No.</th>
			<th width="55%">Name</th>
			<th width="25%">Rank</th>
			<th width="25%">Age</th>
			<th width="25%">Med Cat</th>
			<th width="10%">Select all<input type="checkbox"  id="add_ALL" value="" onclick="addAll();" /></th>
		</tr>
	</thead>
	<tbody>
	<%
	int inc=0;
	for (AvPilotRegistrationDt pilotRegDt : pilotRegistrationList) {
		inc++;
			int pilot_hd_id = 0;
			int pilot_dt_id=0;
			int hinId=0;
			String pilotName = null;
			String service_no = null;
			String rank = null;
			String age="";
			String unit="";
			String medCat="";
			int rankId = 0;
			int categoryId=0;
			int unitId=0;
			if (pilotRegDt.getServiceNo() != null) {
				service_no = pilotRegDt.getServiceNo();
				pilot_hd_id = pilotRegDt.getAvPilotRegistrationHd().getId();
				pilot_dt_id = pilotRegDt.getId();
				pilotName=pilotRegDt.getFullName();
				if(pilotRegDt.getRank()!=null){
					rank=pilotRegDt.getRank().getRankName();
				}
				if(pilotRegDt.getAge()!=null){
					age=pilotRegDt.getAge();
				}
				if(pilotRegDt.getAvPilotRegistrationHd().getUnit() !=null){
					unit=pilotRegDt.getAvPilotRegistrationHd().getUnit().getUnitName();
				}
				if(pilotRegDt.getCategory() !=null){
					medCat=pilotRegDt.getCategory().getCategories();
				}
				if(pilotRegDt.getHin() !=null){
					hinId=pilotRegDt.getHin().getId();
				}
				if(pilotRegDt.getRank() !=null){
					rankId=pilotRegDt.getRank().getId();
				}
				if(pilotRegDt.getCategory() !=null){
					categoryId=pilotRegDt.getCategory().getCategoryid();
				}
				
			}

	%>
<tr>		
	<td width="10%">
	<input type="text" value="<%=inc%>"	class="smcaption" name="srNo" id="srNo<%=inc %>" size="5" readonly="readonly" />
	<input type="hidden" value="<%=pilot_hd_id%>" name="pilot_hd_id"  id="pilot_hd_id<%=inc %>" class="medcaption"	readonly="readonly" /></td>
	<td width="25%"><input type="text"	value='<%=service_no%>' class="bigcaption" name="serviceNo" id="serviceNo<%=inc %>" readonly="readonly"  size="10" validate="Service No,metachar,no"/>
	<input type="hidden" value="<%=hinId %>" name="<%=HIN_ID %><%=inc %>" id="hinId<%=inc %>"/>
	</td>	
	<td width="25%"><input type="text"	value="<%=pilotName%>" name="name" class="medcaption"	readonly="readonly" size="20" id="name<%=inc %>"/></td>
	<td width="25%"><input type="text" value="<%=rank%>"  name="rankName" class="medcaption" readonly="readonly" size="9" id="rankName<%=inc %>"/></td>
	<input type="hidden" value="<%=rankId %>" name="rankId<%=inc %>" id="rankId<%=inc %>"/>
	<td width="25%"><input type="text" value="<%=age%>" name="age" class="medcaption" readonly="readonly" size="9" id="age<%=inc %>"/>	
		</td>	
	<td width="10%"> <input type="text"	value="<%=medCat%>" class="medcaption" name="categoryName" readonly="readonly"  size="9" id="categoryName<%=inc %>"/></td>
	<input type="hidden" value="<%=categoryId %>" name="categoryId<%=inc %>" id="categoryId<%=inc %>"/>	
	<td width="10%"><input type="checkbox"	name="pilot_dt_id" value="<%=pilot_dt_id%>" id="pilot_dt_id<%=inc%>" onclick=""></td>
	</tr>
<% } %>
	</tbody>
</table>
<input type="hidden" name="count" value="<%=inc %>" id="count" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Add"	onClick="setValuesInParent();" value="Add" class="button" /> 
<input	type="button" name="Add" onClick="window.close();" value="Close"	class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% }else{ %>
<h2> No Record Found !!</h2>
<%} %>
</form>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<script type="text/javascript">
function setValuesInParent(){
	
	var count = document.getElementById('count').value;	
	
	
	var tbl = window.opener.document.getElementById('gridService');	
	tbl.style.display = 'inline';
	for(var i=1;i<=count;i++){
	if(document.getElementById('pilot_dt_id'+i).checked){
	var immCount = window.opener.document.getElementById('immCount').value	
	var lastRow = tbl.rows.length;	
	var row = tbl.insertRow(lastRow);	
	var iteration = parseInt(immCount);
	
	var cell0 = row.insertCell(0);
	var e0 = window.opener.document.createElement('input');
	e0.type = 'text';
	e0.name='srNo'+(iteration+1);
	e0.id='srNo'+(iteration+1);
	e0.size='5';
	e0.value = document.getElementById('srNo'+i).value;
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = window.opener.document.createElement('input');
	e1.type = 'text';
	e1.name='serviceNo'+(iteration+1);
	e1.id='serviceNo'+(iteration+1);
	e1.value = document.getElementById('serviceNo'+i).value;
	   
	var e101 = window.opener.document.createElement('input');
	e101.type = 'hidden';
	e101.name='hinId'+(iteration+1);
	e101.id='hinId'+(iteration+1);
	e101.value = document.getElementById('hinId'+i).value;
	cell1.appendChild(e101);
	cell1.appendChild(e1);
	
	var cell2 = row.insertCell(2);
	var e2 = window.opener.document.createElement('input');
	e2.type = 'text';
	e2.name='pilotName'+(iteration+1);
	e2.id='pilotName'+(iteration+1);
	e2.value = document.getElementById('name'+i).value;
	cell2.appendChild(e2);
	
	var cell3 = row.insertCell(3);
	var e3 = window.opener.document.createElement('input');
	e3.type = 'text';
	e3.name='rankName'+(iteration+1);
	e3.id='rankName'+(iteration+1);
	e3.value = document.getElementById('rankName'+i).value;
	cell3.appendChild(e3);
	
	var e301 = window.opener.document.createElement('input');
	e301.type = 'hidden';
	e301.name='rankId'+(iteration+1);
	e301.id='rankId'+(iteration+1);
	e301.value = document.getElementById('rankId'+i).value;
	cell3.appendChild(e301);
	cell3.appendChild(e3);
	
	var cell4 = row.insertCell(4);
	var e4 = window.opener.document.createElement('input');
	e4.type = 'text';
	e4.name='age'+(iteration+1);
	e4.id='age'+(iteration+1);
	e4.value = document.getElementById('age'+i).value;
	cell4.appendChild(e4);
	
	var cell5 = row.insertCell(5);
	var e5 = window.opener.document.createElement('input');
	e5.type = 'text';
	e5.name='categoryName'+(iteration+1);
	e5.id='categoryName'+(iteration+1);
	e5.value = document.getElementById('categoryName'+i).value;
	cell5.appendChild(e5);
	
	var e501 = window.opener.document.createElement('input');
	e501.type = 'hidden';
	e501.name='categoryId'+(iteration+1);
	e501.id='categoryId'+(iteration+1);
	e501.value = document.getElementById('categoryId'+i).value;
	cell5.appendChild(e501);
	cell5.appendChild(e5);
	
	var cell6 = row.insertCell(6);
	var e6 = window.opener.document.createElement('input');
	e6.type = 'text';
	e6.name='sortiDay'+(iteration+1);
	e6.id='sortiDay'+(iteration+1);
	e6.value = '';
	cell6.appendChild(e6);
	
	var cell7 = row.insertCell(7);
	var e7 = window.opener.document.createElement('input');
	e7.type = 'text';
	e7.name='visualInspec'+(iteration+1);
	e7.id='visualInspec'+(iteration+1);
	e7.value = '';
	cell7.appendChild(e7);
	
	
	var cell8 = row.insertCell(8);
	var e8 = window.opener.document.createElement('input');
	e8.type = 'file';
	e8.size = '20';
	e8.className='flie';
	e8.name='upload_filename'+iteration;
	e8.id='fileNameId'+iteration;
	cell8.appendChild(e8);
	<%---
	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'button';
	e9.className = 'buttonAdd';
	e9.setAttribute('onClick', 'generateRow("gridService");'); 
	e9.setAttribute('tabindex','1');
	cell9.appendChild(e9);	
	
	var cell10 = row.insertCell(10);
	var e10 = document.createElement('input');
	e10.type = 'button';
	e10.className = 'buttonDel';
	e10.setAttribute('onClick', 'removeRow("gridService","hdb",this);'); 
	e10.setAttribute('tabindex','1');
	cell10.appendChild(e10);
   --%>
  
   window.opener.document.getElementById('immCount').value = (iteration+1);
 	}
}
	window.close();
}


</script>