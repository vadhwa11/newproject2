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
int inc=1;
%>

<form name="freeFromInfection" method="post" action="">


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
%> 
<%
 	//Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
   time = (String) utilMap.get("currentTime");
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

<div class="titleBg"><h2>Free From Infection</h2></div>
<table class="cmntable" name="cmntable"  id="infectionGrid">

<tr>
<th>Sl No.</th>
<th colspan="2">Date</th>
<th>Purpose</th>
<th>Place</th>
<th>Particulars of Ind</th>
<th>Fit/ Unfit</th>
<th>Add</th>
<th>Delete</th>
</tr>
<% 
 int inc1 = 0;
inc1 = inc1+1;

%>
<input type="hidden" name ="srNo"  id = "srNo" value=<%=inc1 %>  />
<tr>
    <td>
        <input type="text" name="serialNo"<%=inc1%> class="auto" size="2" value=<%=inc1 %>   />
    </td>

    <td>
        <input type="text" name="infectionDate<%=inc1%>" id="" value="<%=currenDate %>" class="date" size="" />
    </td>
     <td>
          <img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	       onClick="setdate('<%=currenDate %>',document.freeFromInfection.infectionDate<%=inc1%>,event)" />
	 </td>
     <td>
       <input type="text" name="Purpose<%=inc1%>"  maxlength="30"   size="" value="" />
     </td>
     <td>
        <select name="place<%=inc1%>" id="place<%=inc1%>" >
         <option value="Occupational Hazard">Occupational Hazard</option>
         <option value="Swimming Pool">Swimming Pool</option>
        </select>
     </td>

      <td>
          <input type="text" name="particularInd<%=inc1%>"   maxlength="29"   class="" size="" />
      </td>
       <td>
			<select name="Fit_Unfit"<%=inc1%>  >
				<option value="Fit">Fit</option>
				<option value="Unfit">Unfit</option>
			</select>
	  </td>

    	<td>
    	     <input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" />
    	</td>

         <td>
             <input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" />
         </td>
</tr>

</table>


</form>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" onclick= "submitForm('freeFromInfection', '/hms/hms/mis?method=submitFreeFromInfection');"    />
<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
<script type="text/javascript">
function generateRow(idName) {
	
	  var tbl = document.getElementById('infectionGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

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
	  e1.name='infectionDate'+iteration;
	  e1.id='infectionDate'+iteration
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('img');
      e2.src = '/hms/jsp/images/cal.gif';
      // e3.style.display ='none';
      e2.id = 'calId'+iteration;
      e2.onclick = function(event){
     setdate('serverdate',document.getElementById('infectionDate'+iteration),event) };
       cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type='text'
	  e3.name='Purpose'+iteration	  
	  e3.size = '20'
	  cellRight3.appendChild(e3);
	 

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	  e4.name = 'place'+ iteration;
	  //e4.id = 'pNo'+ iteration;
	  e4.className='big';
	  e4.setAttribute('tabindex','2');
	  e4.options[0] = new Option('Select','Select');  
	  e4.options[0] = new Option('OccupationalHazard','OccupationalHazard'); 
	  e4.options[1] = new Option('SwimmingPool','SwimmingPool'); 
      cellRight4.appendChild(e4);
    
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='text'
	  e5.name='particularInd'+iteration;
	  e5.size='20' 	
      cellRight5.appendChild(e5);

      var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');
	  e6.setAttribute('tabindex','2');
	  e6.name='Fit_Unfit'+iteration;
	  e6.options[0] = new Option('Select','Select');  
	  e6.options[1] = new Option('Fit','Fit'); 
	  e6.options[2] = new Option('Unfit','Unfit'); 
      cellRight6.appendChild(e6);    
   

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	  e7.name='remarks'+iteration;
	  e7.setAttribute('onClick','generateRow(freeFromInfection);');	  
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  e8.name='remarks'+iteration;
	  e8.onclick = function(){removeRowF();}
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);
}
function removeRowF()
{ 
	
  var tbl = document.getElementById('infectionGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('infectionGrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('infectionGrid');
  	hdb.value=iteration
  }
}
</script>