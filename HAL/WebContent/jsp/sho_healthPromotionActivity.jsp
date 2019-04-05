<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasServiceType"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasTrade"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasComplaint"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasDisposal"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasReporting"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.Category"%>

<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

%>

<form name="healthPromotionActivities" method="post" action="">


<%
	Properties properties = new Properties();
	URL resourcePathHIC = Thread.currentThread()
			.getContextClassLoader().getResource(
					"hicDetails.properties");
	try {
		properties.load(resourcePathHIC.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String urlForImportFromHIC = properties
			.getProperty("urlForImportFromHIC");
%> <%
 	
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<MasAdministrativeSex> sexList = null;
 	List<MasDistrict> districtList = null;
 	List<MasState> stateList = null;

 	String administrativeSexMaleCode = properties
 			.getProperty("administrativeSexMaleCode");

 	if (map.get("sexList") != null) {
 		sexList = (List<MasAdministrativeSex>) map.get("sexList");
 	}
 	if (map.get("districtList") != null) {
 		districtList = (List<MasDistrict>) map.get("districtList");
 	}
 	if (map.get("stateList") != null) {
 		stateList = (List<MasState>) map.get("stateList");
 	}
 %>

<div class="titleBg"><h2>Health Promotion Activities </h2></div>

<table class="cmntable" name="promotionalGrid" id="promotionalGrid">

<tr>
<th>Sl No.</th>
<th colspan="2">Date</th>
<th>Type</th>
<th>Subject</th>
<th>Rank Category</th>
<th>Place</th>
<th>No. Attended</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>
<% 
  int inc = 0;
  inc = inc+1;

%>
<input type="hidden" name ="srNo"  id = "srNo" value=<%=inc %>  />
<tr>
<td><input type="text" tabindex="1" name="serialNo<%=inc%>" class="auto" size="2" value=<%=inc%>  /></td>

<td><input type="text" tabindex="1"  name="healthPromotionDate<%=inc %>" value="<%=currenDate %>" class="date" size="" /></td>
  <td>     
       <img src="/hms/jsp/images/cal.gif" width = "16" height="16" border="0" class="calender" 
       onClick="setdate('<%=currenDate %>',document.healthPromotionActivities.healthPromotionDate<%=inc %>,event)" /> 
     </td>                 
<td>
<select name="HealthPromotiontopic<%=inc%>" tabindex="1"  >
<option value="">Select</option>
<option value="SRO">SRO</option>
<option value="Camp">Camp</option>
<option value="Lecture">Lecture</option>
<option value="Training">Training</option>
</select></td>

<td><input type="text" tabindex="1"  name="HealthPromotionSubject<%=inc%>" class="" size="" value=""  maxlength="50"/></td>
<td>
<select name="HealthPromotionRankCat<%=inc%>" tabindex="1" >
<option value="">Select</option>
<option value="Officers">Officers</option>
<option value="JCOs">JCO's</option>
<option value="Others">Others</option>
</select>
</td>

<td><input type="text" name="HealthPromotionplace<%=inc%>"  tabindex="1"  maxlength="50"  size="" /></td>
<td><input type="text" name="HealthPromotionattended<%=inc%>"  tabindex="1"   maxlength="30"  size=""  validate="No Attended,int,no" /></td>
<td><input type="text" name="HealthPromotionremarks<%=inc%>"  tabindex="1"    maxlength="50"  size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" tabindex="1"  onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel"  tabindex="1"  onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

<input type="hidden" name="hdb1" value="<%=inc %>" id="hdb1" />
</table>
</form>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="inc" value=<%=inc%>  />
<input type="button" name="submit" value="Submit" class="button" tabindex="1" onclick="submitForm('healthPromotionActivities','/hms/hms/mis?method=submitHealthPromotionActivityJsp');"    />
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript">

function generateRow(idName) {
	
	  var tbl = document.getElementById('promotionalGrid');

	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo');
	  hdb.value=iteration
	  

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='serialNo'+iteration;
	  e0.id='serialNo'+iteration
	  e0.value=iteration;	  
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
    
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='22';
	  e1.name='healthPromotionDate'+ iteration;
      e1.id='healthPromotionDate'+iteration;
	  e1.value='<%=currenDate %>';
	  e1.size='20';
      e1.setAttribute('maxlength', 30);
	 e1.setAttribute('tabindex','1');
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('img');
      e2.src = '/hms/jsp/images/cal.gif';
     e2.id = 'calId'+iteration;
      e2.onclick = function(event){
     setdate('',document.getElementById('healthPromotionDate'+iteration),event) };     
       cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	    var e3 = document.createElement('Select');   
	    e3.name = 'HealthPromotiontopic'+ iteration;
	    e3.id = 'HealthPromotiontopic'+ iteration;
	    e3.className='big';
	    e3.setAttribute('tabindex','1')
	    e3.options[0] = new Option('Select','Select');
	    e3.options[1] = new Option('SRO','SRO');
	    e3.options[2] = new Option('Camp','Camp');
	    e3.options[3] = new Option('Lecture','Lecture');
	    e3.options[4] = new Option('Training','Training');
	     cellRight3.appendChild(e3);

	     var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.name='HealthPromotionSubject'+iteration;
		  e4.type='text';
		  e4.setAttribute('tabindex','1')
		  e4.size = '20';
		  e4.setAttribute('maxlength', 50);
	      cellRight4.appendChild(e4);

	      var cellRight5 = row.insertCell(5);
		    var e5 = document.createElement('Select');   
		    e5.name = 'HealthPromotionRankCat'+ iteration;
		    e5.id = 'HealthPromotionRankCat'+ iteration;
		    e5.className='big';
		    e5.setAttribute('tabindex','1')
		    e5.options[0] = new Option('Select','Select');
		    e5.options[1] = new Option('Officers','Officers');
		    e5.options[2] = new Option('JCOs','JCOs');
		    e5.options[3] = new Option('Others','Others');
		    cellRight5.appendChild(e5);
	      
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='HealthPromotionplace'+iteration;
	  e6.type='text';
	  e6.setAttribute('tabindex','1')
	  e6.size = '20';
	  e6.setAttribute('maxlength', 50);
      cellRight6.appendChild(e6);
    
	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='HealthPromotionattended'+iteration;
	  e7.type='text'
	e7.setAttribute('tabindex','1')
	  e7.size='20' 
	e7.setAttribute('maxlength', 30);	
      cellRight7.appendChild(e7);

      var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='HealthPromotionremarks'+iteration;
	  e8.type="text";
	  e8.setAttribute('tabindex','1')
	  e8.size = '20'
	  e8.setAttribute('maxlength', 50);
      cellRight8.appendChild(e8);    
   

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonAdd';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick','generateRow(healthPromotionActivities);');	  
	  e9.setAttribute('tabindex','1');
	  cellRight9.appendChild(e9);

	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'button';
	  e10.className = 'buttonDel';
	  e10.name='remarks'+iteration;
	  e10.onclick = function(){removeRowF();}
	  e10.setAttribute('tabindex','1');
	  cellRight10.appendChild(e10);
}
function removeRowF()
{ 	
  var tbl = document.getElementById('promotionalGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('promotionalGrid');
  	var lastRow = tbl.rows.length;

 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('promotionalGrid');
  	hdb.value=iteration
  }
}
</script>

