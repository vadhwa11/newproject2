<%@ page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.Patient"%><script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}
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
<form name="aircrewMedicalLectures" method="post" action="">
       <%
       Properties properties = new Properties();
       URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
       try {
       	properties.load(resourcePathHIC.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       String urlForImportFromHIC = properties.getProperty("urlForImportFromHIC");

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTimeWithoutSc");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			List<MasUnit> unitList=null;
			if(map.get("unitList") != null){
				unitList =(List<MasUnit>)map.get("unitList");
			}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
			List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
			List<Patient> patientList = new ArrayList<Patient>();
			if(map.get("doctorList") != null){
				doctorList=(List)map.get("doctorList");
			}
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			
			%>  

<div class="titleBg">
<h2>Aircrew Medical Lectures</h2>
</div>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <%   }%>
<div class="clear paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<label>Date</label> 
<input type="text" id="<%=DATE %>" name="<%=DATE %>" tabindex="1" value="<%=currentDate %>" readonly="readonly"	validate="Date of Birth,date,no" MAXLENGTH="7" class="calDate"	/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.aircrewMedicalLectures.<%=DATE%>,event)" />
<label>Time Started</label>
<input  name="<%=TIME %>" id="<%=TIME %>" value="<%=time %>" type="text" tabindex="1" maxlength="5" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTimeForSetup1(this.value,this.id);"/> 
<label>Duration</label>
<input  name="<%=DURATION %>" id="<%=DURATION %>" type="text"  tabindex="1" maxlength="2" class="auto" size="2" validate="Duration,int,no"/>
<label class="unit">mins</label> 

<div class="clear"></div>
<label>Unit<span>*</span></label>
<select name="<%=PLACE_OF_LECTURE %>"  id="<%=PLACE_OF_LECTURE %>" tabindex="1" validate="Unit,metachar,yes">
<option value="0">Select</option>
	<%for(MasUnit masUnit : unitList){%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>
<label>MO</label> 
<select name="<%=MO_NAME %>"  id="<%=MO_NAME %>" tabindex="1">
<option value="0">Select</option>
	<%
int doctorId=0;
for(MasEmployee masEmployee : doctorList){
	doctorId = masEmployee.getId();
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
			if(user.getEmployee().getId() == doctorId){
%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%		} } } }%>
</select>
<label>Topic</label>
<input  name="<%=LECTURE_SUBJECT %>" id="<%=LECTURE_SUBJECT %>" type="text" tabindex="1" maxlength="32" /> 

<div class="clear"></div>
	
<label>No. Attended</label>
<input type="text" name="<%=NUMBER_ATTENDED %>" id="<%=NUMBER_ATTENDED %>" value="" validate="Number Attended,int,no" id="remarks" maxlength="4" tabindex="1"/>

<label>Remarks</label>
<textarea name="<%=REMARKS %>" id="<%=REMARKS %>"	cols="55" rows="2" tabindex="1" validate="Remarks,metachar,no" onkeyup="chkLength(this,100);" ></textarea>
</div>

<div class="clear paddingTop15"></div>

<table class="cmntable" id="grid">

<tr>
<th>Sl No.</th>
<th>Service No.</th>
<th>Rank</th>
<th>Name</th>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc=0;inc=inc+1;%>
<tr>
<td>
<input type="text" name="<%=SIRIAL_NO%>" value="<%=inc %>" tabindex="1" size="1" class="auto"  readonly="readonly"/></td>
<td><input type="text" name="serviceNo<%=inc %>" id="serviceNo<%=inc %>" onblur="ajaxFunctionAVService(aircrewMedicalLectures,<%=inc %>,this.value);"/></td>
<td><input type="text" name="rankName<%=inc %>" id="rankName<%=inc %>" />
<input type="hidden" name="rankId<%=inc %>" id="rankId<%=inc %>" /></td>
<td><input type="text" name="sName<%=inc %>" id="sName<%=inc %>" value=""/>
<input type="hidden" name="hinId<%=inc %>" id="hinId<%=inc %>" value=""/></td>
<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>
</tr>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
</table>
<div class="division"></div>
<div id="edited"></div>
<input	type="button" name="Submit" value="Submit" onClick="submitForm('aircrewMedicalLectures','aviationMedicine?method=submitAircrewMedicalLecture');" tabindex="1"	class="buttonbig"  />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1"   />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<script type="text/javascript">

function addRow(){

	  var tbl = document.getElementById('grid');

	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);

	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'serialNo' + iteration;
	  e0.id = 'serialNo' + iteration;
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
      e0.size = '1';
      e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'serviceNo'+iteration ;
	  e1.id = 'serviceNo' + iteration;
	  e1.onblur=function(){
		  ajaxFunctionAVService(aircrewMedicalLectures,iteration,this.value)
		  };
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);

    var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'rankName'+ iteration ;
	  e2.id = 'rankName' + iteration;
    e2.setAttribute('tabindex','1');
    
    var e22 = document.createElement('input');
	  e22.type = 'hidden';
	  e22.name = 'rankId'+ iteration ;
	  e22.id = 'rankId' + iteration;
	  e22.setAttribute('tabindex','1');
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(e22);
  	  
    var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'sName'+ iteration;
	  e3.id = 'sName' + iteration;
   	  e3.setAttribute('maxlength', 30);
	  e3.setAttribute('tabindex','1');

	  var e33 = document.createElement('input');
	  e33.type = 'hidden';
	  e33.name = 'hinId'+ iteration;
	  e33.id = 'hinId' + iteration;
   	  e33.size = '20';
   	  e33.setAttribute('maxlength', 30);
   	 cellRight3.appendChild(e3);
   	cellRight3.appendChild(e33);

  
    var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='remarks'+iteration;
	  e4.onclick = function(){addRow();};
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5= document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='remarks'+iteration;
	//  e5.setAttribute('onClick', 'removeRow('grid','hdb',this);');
	  e5.onclick =function(){removeRow('grid','hdb',this);};
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	}


	function removeRow1()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
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
</script>
</form>