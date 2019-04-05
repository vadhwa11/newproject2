<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.AvPreFlightDt"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Category"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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
	<script type="text/javascript">
	var rankArray=new Array();
	var unitArray=new Array();
	var sexArray=new Array();
	var categoryArray=new Array();
</script>

<%
String userName="";
if(session.getAttribute("userName")!=null)
 userName=(String)session.getAttribute("userName");
	Users users =null;
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
	}
	int loginEmpId=0;
	if(users!=null){
		if(users.getEmployee()!=null){
			loginEmpId=users.getEmployee().getId();
		}
	}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<AvPreFlightDt> flightDtList = new ArrayList<AvPreFlightDt>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<Category> categoryList = new ArrayList<Category>();
	
	if(map.get("flightDtList") != null){
		flightDtList =(List<AvPreFlightDt>)map.get("flightDtList");
	}
	if(map.get("unitList") != null){
		unitList =(List<MasUnit>)map.get("unitList");
	}
	if(map.get("rankList") != null)	{
		rankList = (List<MasRank>)map.get("rankList");
	}
	if(map.get("sexList") != null)	{
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("categoryList") != null)	{
		categoryList = (List<Category>)map.get("categoryList");
	}
%>
<form name="preFlight" method="post" action="" enctype="multipart/form-data">
<%--
<div id="srPhoto" class="photoAv">
	<div class="clear"></div>
	<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="80" id="img1" />
	<span style="color:#ddd">Date/ Time</span>
</div> --%>
<div class="titleBg">
<h2>Pre Flight Medical Checkup</h2>
</div>
<div class="clear"></div>
<div class="Block">

<label>Date</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="toAppDate" validate="A Date,frdate,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"	onClick="setdate('',document.preFlight.<%=DATE %>,event)" />

<label>Time</label>
<input type="text" name="time" maxlenght="7" value="<%=time %>" class="small" readonly="readonly" validate="Time,string,no"/>

<label>Unit</label>
<select name="unitNameId" id="unitNameId" onchange="getPilotDetails();" validate="Unit,metachar,no">
<option value="0">Select</option>
<%for(MasUnit masUnit:unitList ){ %>
<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
<%} %>
</select>
<div class="clear"></div>
</div>
<div class="clear paddingTop15"></div>
 <div class="Block">
<label>Verified by</label>
<label class="auto">FLT CDR</label>
<input type="checkbox" name="wgcdr" id="wgcdrId" class="radioAuto" maxlenght="1" tabindex="1"/>

<input class="transparent" size="14" />

<label>Fit by</label>
<label class="auto">MO</label>
<input type="checkbox" name="mo" id="moId" class="radioAuto" onclick="showMoName();" tabindex="1"/>
<div id="medicalOfficer" style="display: none" >
<select	name="medOfficer" id="medOfficer" validate="Medical Officer,metachar,no" tabindex="1" >
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
				if(obj.getRank() != null){
					rankName = obj.getRank().getRankName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=rankName+" "+obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  
	} %>
</select></div>
<div class="clear"></div>

<label>If Unfit, Remarks</label>
<input type="text" name="unfitRemarks" id="unfitRemarksId" maxlength="50" tabindex="1"/>
</div>
	 <input type="hidden" name="pilot_hd_id" id="pilot_hd_id" value="" validate="pilot_hd_id,int,no"/>
	<input type="hidden" name="temp" id="temp" value="" />
<div id="gridDiv">
<div class="clear paddingTop15"></div>
<div class="cmntable">
<table  cellpadding="0" cellspacing="0" id="gridService" style="display: none">
<tr>
<th>Sl No.</th>
<th>Service No.</th>
<th>Name</th>
<th>Rank</th>
<th>Age</th>
<th>Med Cat</th>
<th>Sortie of the Day</th>
<th>Visual Inspection</th>
<th>Photo</th>
<%--
<th></th>
<th></th> --%>
</tr>

<%---
<%int inc=0;
if(inc<=0){
	++inc;%>
<tr>
<td>
<input type="text" value="<%=inc%>"	class="smcaption" name="srNo" id="srNo<%=inc %>" size="1" readonly="readonly" /></td>
<td><input type="text" value="" name="<%=SERVICE_NO %><%=inc %>" id="serviceNo<%=inc %>" class="auto" size="10"
	onblur="showRegisterDetail('preFlight',this.value,<%=inc %>);"/>
<input type="hidden" value="0" name="<%=HIN_ID %><%=inc %>" id="hinId<%=inc %>"/></td>
<td><input type="text" value="" name="<%=NAME %><%=inc %>" id="name<%=inc %>"/></td>
<td>
<select	id="<%=RANK_ID %><%=inc %>" name="<%=RANK_ID %><%=inc %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	}%>
</select>
<%
int i1=0;
for (MasRank masRank : rankList) {
     			 %> <script>

     			rankArray[<%=i1%>]= new Array();
     			rankArray[<%=i1%>][0] = "<%=masRank.getId()%>";
     			rankArray[<%=i1%>][1] = "<%=masRank.getRankName()%>";
            </script> <%
++i1;
}%></td>

<td><input type="text" value="" name="<%=AGE %><%=inc %>" id="age<%=inc %>" class="auto" size="6"/></td>
<td>
<select	id="<%=CATEGORY_ID %><%=inc %>" name="<%=CATEGORY_ID %><%=inc %>"	validate="category,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(categoryList!=null && categoryList.size() >0){
	 for(Category category : categoryList){
	%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%></option>
	<%}
	} %>
</select>
<%
int i33=0;
for (Category masCategory : categoryList) {
     			 %> <script>

     			categoryArray[<%=i33%>]= new Array();
     			categoryArray[<%=i33%>][0] = "<%=masCategory.getCategoryid()%>";
     			categoryArray[<%=i33%>][1] = "<%=masCategory.getCategories()%>";
            </script> <%
++i33;
}%></td>
<td><input type="text" value="" name="sortiDay<%=inc %>" id="sortiDay<%=inc %>" maxlength="49" tabindex="1"/>
<input type="hidden" value="0" name="flightId<%=inc %>" id="flightId<%=inc %>"/></td>
<td><input type="text" value="" name="visualInspec<%=inc %>" id="visualInspec<%=inc %>"maxlength="49" tabindex="1"/></td>

<%---
<td><input name="Send" type="button"  class="buttonSm" value="Photo" 
			onClick="javascript:FileUploadWindow(<%=inc %>);" /></td> --%>
			<%---
<td><input type="file" name="<%=UPLOAD_FILENAME %><%=inc %>" id="fileNameId<%=inc %>" class="browse"></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('gridService');" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridService','hdb',this);" tabindex="1" />
</td>
</tr>
<%} %>--%>
<input type="hidden" name="hdb" value="0" id="hdb" validate="hdb,int,no" />
<input type="hidden" name="immCount" value="0" id="immCount"  /> 
</table>
</div>
</div>
<div class="clear"></div>

<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<%--
<input type="button" class="button" name="Submit11" value="SUBMIT" onclick="if(remarks()){submitForm('preFlight','/hms/hms/aviationMedicine?method=submitPreFlight&flag=preFlight');};" />
 --%>
 <input type="button" class="button" name="Submit11" value="SUBMIT" onclick="jsImport();" tabindex="1"/>
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" tabindex="1"/>
<!-- <input type="button" class="button" name="Submit11" value="Inactive" onclick="submitForm('preFlight','/hms/hms/aviationMedicine?method=inactivePreFlight');" tabindex="1"/> -->
</form>
<script>
function remarks(){
	var wgcdrId  =document.getElementById('wgcdrId');
	var moId = document.getElementById('moId');
	var unfitRemarksId = document.getElementById('unfitRemarksId');
	if((wgcdrId.checked == false || moId.checked == false) && (unfitRemarksId.value=='')){
		alert("Please Fill Unfit Remarks.");
		return false;
	}
		return true;	
}
	function generateRow(idName) {
	
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='srNo'+iteration;
	  e0.id='srNo'+iteration;
	  e0.size = '1';
      e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size='10';
	  e1.name='<%=SERVICE_NO%>'+iteration;
	  e1.id='<%=SERVICE_NO%>'+iteration;
	  e1.onblur= function(){
		 showRegisterDetail('preFlight',this.value,iteration);
	  };
		  
		var e110 = document.createElement('input');
		e110.type = 'hidden';
		e110.name='hinId'+iteration;
		e110.id='hinId'+iteration
		e110.value='0';
		cell1.appendChild(e110);
		cell1.appendChild(e1);


		 var cell2 = row.insertCell(2);
		 var e2 = document.createElement('input');
		 e2.type = 'text';
		 e2.size='20';
		 e2.name='<%=NAME%>'+iteration;
		 e2.id='<%=NAME%>'+iteration
		 cell2.appendChild(e2);
		

		var cell3 = row.insertCell(3);
		var e3 = document.createElement('Select');
		e3.name='<%=RANK_ID%>'+iteration
		e3.id='<%=RANK_ID%>'+iteration
		e3.setAttribute('tabindex','1');
		e3.options[0] = new Option('Select', '0');
		for(var i= 0;i<rankArray.length;i++ ){
		   e3.options[i+1] = new Option(rankArray[i][1],rankArray[i][0]);
		   }
		cell3.appendChild(e3);

		

		var cell4 = row.insertCell(4);
		var e4 = document.createElement('input');
		e4.type = 'text';
		e4.size='6'; 
		e4.name='<%=AGE %>'+iteration;
		e4.id='<%=AGE %>'+iteration;
		cell4.appendChild(e4); 

		var cellRight5= row.insertCell(5);
		var e5 = document.createElement('Select');
		e5.name='<%=CATEGORY_ID%>';
		e5.id='<%=CATEGORY_ID%>'+iteration
		e5.setAttribute('tabindex','1');
		e5.options[0] = new Option('Select', '0');
		for(var i= 0;i<categoryArray.length;i++ ){
			e5.options[i+1] = new Option(categoryArray[i][1],categoryArray[i][0]);
			}
		cellRight5.appendChild(e5);

		
		var cell6 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='sortiDay'+ iteration;
		e6.id='sortiDay'+iteration;
		e6.maxLength="49";
		//e7.setAttribute('maxlength', 49);
		e6.setAttribute('tabindex','1');
		cell6.appendChild(e6);

		var cell7 = row.insertCell(7);
		var e7 = document.createElement('input');
		e7.type = 'text';
		e7.name = 'visualInspec' + iteration;
		e7.id = 'visualInspec' + iteration;
		e7.maxLength="49";
		//e8.setAttribute('maxlength', 49);
		e7.setAttribute('tabindex','1');
		cell7.appendChild(e7);

	//	var cellRight9 = row.insertCell(9);
		//var e9 = document.createElement('input');
		//e9.type = 'button';
		//e9.className = 'buttonSm';
		//e9.value = 'photo';
		//e9.setAttribute('onClick','FileUploadWindow(iteration);');
		//e9.setAttribute('tabindex','1');
		//cellRight9.appendChild(e9);

		 

		  var cell8 = row.insertCell(8);
		  var e8 = document.createElement('input');
		  e8.type = 'file';
		  e8.size = '20';
		  e8.className='browse';
		  e8.name='upload_filename'+iteration;
		  e8.id='fileNameId'+iteration
		  cell8.appendChild(e8);
		 <%--
		  var cellRight9 = row.insertCell(9);
		var e9 = document.createElement('input');
		e9.type = 'button';
		e9.className = 'buttonAdd';
		e9.setAttribute('onClick', 'generateRow("gridService");'); 
		e9.setAttribute('tabindex','1');
		cellRight9.appendChild(e9);	
		
		var cellRight10 = row.insertCell(10);
		var e10 = document.createElement('input');
		e10.type = 'button';
		e10.className = 'buttonDel';
		e10.setAttribute('onClick', 'removeRow("gridService","hdb",this);'); 
		e10.setAttribute('tabindex','1');
		cellRight10.appendChild(e10);	  --%>
 }

function removeRow(idName,countId,obj)
{
	var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
  
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}

function jsImport()
{
	var wgcdrId  =document.getElementById('wgcdrId');
var moId = document.getElementById('moId');
var unfitRemarksId = document.getElementById('unfitRemarksId');
if((wgcdrId.checked == false || moId.checked == false) && (unfitRemarksId.value=='')){
	alert("Please Fill Unfit Remarks.");
	return false;
}else{
	
	var inc = document.getElementById('hdb').value;
	var flag = '';
	var fileNames = '';
	var filename = '';
	for(i=1;i<=inc;i++ ){
		if (document.getElementById('fileNameId'+i).value!="")
		{
			flag='exists';
			var fname = document.getElementById('fileNameId'+i).value;
			var ind = fname.lastIndexOf("\\");
			var filename = fname.substring(ind+1);
			fileNames +='&filename'+i+'='+filename;
		}
	}
	document.preFlight.method="post";
	submitForm('preFlight','aviationMedicine?method=submitPreFlight&flag=preFlight&filename='+fileNames);
}return true;	
}

function showMoName()
{
	if(document.getElementById('moId').checked ==true){
	  	document.getElementById('medicalOfficer').style.display='inline';
	}else{
		document.getElementById('medicalOfficer').style.display='none';
	}	
}
	function getPilotDetails(){
		var unitNameId = document.getElementById('unitNameId').value;
		   	currPage=1;
			numOfRows=10;
			var pageType="add";
		   if(unitNameId != 0 && unitNameId != ""){
		  	   var url="/hms/hms/aviationMedicine?method=findPilotDetail&unitNameId="+unitNameId;
				newwindow=window.open(url,'name','top=0, left=5, height=675,width=1010,status=1');
			} else {
		 	 	alert("Please select Unit ..!!!");
		 	}
	}
</script>
