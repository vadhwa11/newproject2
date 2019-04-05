<spring:htmlEscape defaultHtmlEscape="true" />
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
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>
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
<form name="vectorControl" method="post" action="">

<div class="titleBg"><h2>Vector Control Activities</h2></div>

 <div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
            <li><a href="#" rel="country1">Anti-Larval</a></li>
           <li><a href="#" rel="country2">Anti-Adult</a></li>
          <li><a href="#" rel="country3">Fogging</a></li>
          <li><a href="#" rel="country4">IBN</a></li>
         <li><a href="#" rel="country5">Anti-Fly</a></li>
        <li><a href="#" rel="country6">DEBUGGING</a></li>
        <li><a href="#" rel="country7">Biological</a></li>
         <li><a href="#" rel="country8">Personal Protective Measures</a></li>
          <li><a href="#" rel="country9">Anti Malaria Commitee</a></li>
           <li><a href="#" rel="country10">Malaria Cases</a></li>
</ul>
<div id="country1" class="tabcontentIn">
<input type="hidden" name="country1" id="country1" value="antiLarval"/>
<div class="cmntable">
<table id="antiMalariaDetail" width="100%" cellspacing="0" cellpadding="0">
 
<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col" >Area</th>
<th rowspan="2" scope="col" >Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>

<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>

<% 
 int inc1 = 0;
inc1= inc1+1;
%>
<input type="hidden" name="srNo" id="srNo" value=<%=inc1%>  />
<tr>

<td><input  name="larvalSerialNo<%=inc1 %>" id="larvalSerialNo<%=inc1 %>"   tabindex="1" size="2" type="text" value=<%=inc1 %> class="auto" size="1.5" /></td>

<td><input type="text" name="larvalDate<%=inc1 %>" id="larvalDate<%=inc1 %>" value="<%=currenDate %>" class="date" size="" /></td>

<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.larvalDate<%=inc1%>,event)" /> </td> 
<td>

<input type="hidden" name="antiMalariaDetail" value="<%=inc1%>" id="antiMalariaDetail<%=inc1 %>" />
<select name="larvalChemical<%=inc1%>" >
<option value="">Select</option>
<option value="Baytex">Baytex</option>
<option value="Baytex G">Baytex G</option>
<option value="Abate">Abate</option>
</select></td>

<td><input type="text" name="larvalarea<%=inc1%>" id="larvalarea<%=inc1%>"   maxlength="79" class="" size="" /></td>

<td><input type="button"  name="larvalAreaUpload<%=inc1%>"  id="areaUpload<%=inc1%>"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(this.value)){javascript:fileUploadWindowArea(<%=inc %>)"} ;   /></td>

<td><input type="text" name="larvalsupervisor<%=inc1%>" id="larvalsupervisor<%=inc1%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="larvalcarriedoutby<%=inc1%>" id=larvalcarriedoutby<%=inc1%>"  maxlength="49"      class="" size="" /></td>

<td><input type="text" name="larvalnoCovered<%=inc1%>"  id="larvalnoCovered<%=inc1%>" validate="Number of Covered,int,no"  maxlength="70"    class="" size="" /></td>

<td><input type="text"  name="larvalrecieve<%=inc1%>"  id="larvalrecieve<%=inc1%>"   validate="Total Qty Recieve,int,no"  maxlength="29"   class="" size="5" /></td>

<td><input type="text" name="larvalissue<%=inc1%>" id="larvalissue<%=inc1%>"    validate="Total Qty Issue,int,no"   maxlength="29"    class="" size="" /></td>

<td><input type="text" name="larvalbalance<%=inc1%>" id="larvalbalance<%=inc1%>" validate="Balance,int,no" maxlength="29"    class="" size="" /></td>

<td><input type="text" name="larvalremarks<%=inc1%>"  id="larvalremarks<%=inc1%>"   maxlength="99"    class="" size="" /></td>

<td><input type="button" name="larvalAdd<%=inc1%>" id="add<%=inc1 %>" value="" class="buttonAdd" onclick="generateRow();" tabindex="1" /></td>

<td><input type="button" name="larvalDelete<%=inc1%>" id="delete<%=inc1 %>" value="" class="buttonDel" onclick="removeRowF();" tabindex="1" /></td>
</tr>
</table>
</div>
</div>
<div id="country2" class="tabcontentIn">
<input type="hidden" name="country2" id="country2" value="adult"/>
<div class="clear paddingTop15"></div>
<div class="cmntable">
<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
  
<table id="adultDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>
<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc2 = 0;
inc2= inc2+1;

%>

<tr>

<input type="hidden" name="srNo2" id="srNo2" value=<%=inc2 %>  />
<td><input type="text" name="adultSerialNo<%=inc2 %>" id="adultserialNo<%=inc2 %>" class="auto" size="1" value=<%=inc2 %>  /></td>

<td><input type="text" name="adultDate<%=inc2 %>" id="adultDate<%=inc2%>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.adultDate<%=inc2%>,event)" /> </td>
<td>
<select name="adultChemical<%=inc2 %>" id="adultChemical<%=inc2%>"  >
<option value="">Select</option>
<option value="MALATHION 50%">MALATHION 50%</option>
<option value="DELTAMETHRIN">DELTAMETHRIN</option>
<option value="CYPHENOTHRIN">CYPHENOTHRIN</option>
</select></td>

<td><input type="text" name="adultarea<%=inc2%>" id="adultarea<%=inc2%>"  maxlength="49"     class="" size="" /></td>

<td><input type="button" name="adultUpload<%=inc2%>" id="adultUpload<%=inc2%>"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)"} ;/></td>

<td><input type="text" name="adultsupervisor<%=inc2%>" id="adultsupervisor<%=inc2%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="adultcarriedOut<%=inc2%>" id="adultcarriedOut<%=inc2%>"  maxlength="49"   class="" size="" /></td>

<td><input type="text" name="adultnoCovered<%=inc2%>"  id="adultnoCovered<%=inc2%>"  validate="No of Covered,int,no"  maxlength="49"     class="" size="" /></td>

<td><input type="text" name="adultrecieve<%=inc2%>"  id="adultrecieve<%=inc2%>" validate="Recieved,int,no"   maxlength="49"   class="" size="5" /></td>

<td><input type="text" name="adultissue<%=inc2%>"  id="adultissue<%=inc2%>"  validate="Issue,int,no" maxlength="49"    class="" size="" /></td>

<td><input type="text" name="adultbalance<%=inc2%>"  id="adultbalance<%=inc2%>"  validate="Balance,int,no"   maxlength="49"      class="" size="" /></td>

<td><input type="text" name="adultremarks<%=inc2%>" id="adultremarks<%=inc2%>"   maxlength="49"     class="" size="" /></td>

<td><input type="button" name="adultAdd<%=inc2%>" id="add<%=inc2%>"  class="buttonAdd" onclick="generateRow1();" tabindex="1" /></td>

<td><input type="button" name="adultDelete<%=inc2%>" id="delete<%=inc2%>" class="buttonDel" onclick="removeRow1();" tabindex="1" /></td>

</tr>

</table>
</div>
</div>

<div id="country3" class="tabcontentIn">
<input type="hidden" name="country3" id="country3" value="fogging"/>
<div class="clear paddingTop15"></div>

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<div class="cmntable">
<div class="clear"></div>

<table id="foggingDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc3 = 0;
inc3= inc3+1;
%>

<tr>
<input type="hidden" name="srNo3" id="srNo3"  value=<%=inc3 %>  />

<td><input type="text" name="foggingSerialNo<%=inc3 %>" id="foggingSerialNo<%=inc3 %>" class="auto" size="1" value=<%=inc3 %> /></td>

<td><input type="text" name="foggingDate<%=inc3 %>" id="foggingDate<%=inc3 %>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.foggingDate<%=inc3 %>,event)" /> </td>
<td>
<select name="foggingChemical<%=inc3%>" >
<option value="">Select</option>
<option value="PYRETHRUM">PYRETHRUM</option>
<option value="MALATHION TECH">MALATHION TECH</option>
</select></td>

<td><input type="text" name="foggingarea<%=inc3 %>" id="foggingarea<%=inc3%>"   maxlength="49"  class="" size="" /></td>

<td><input type="button" name="foggingUpload<%=inc3 %>" id="foggingUpload<%=inc3%>"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)" };/></td>

<td><input type="text" name="foggingsupervisor<%=inc3 %>" id="foggingsupervisor<%=inc3%>"    maxlength="49"  class="" value="" /></td>

<td><input type="text" name="foggingcarriedOut<%=inc3 %>"  id="foggingcarriedOut<%=inc3%>"  maxlength="49"      class="" size="" /></td>

<td><input type="text" name="foggingnoCovered<%=inc3 %>" id="foggingnoCovered<%=inc3%>"  validate="No of Covered,int,no"  maxlength="49"      class="" size="" /></td>

<td><input type="text" name="foggingreceive<%=inc3 %>" id="foggingreceive<%=inc3%>"  validate="Received,int,no"  maxlength="49"    class="" size="5" /></td>

<td><input type="text" name="foggingissue<%=inc3 %>" id="foggingissue<%=inc3%>"   validate="Issue,int,no"  maxlength="49"     class="" size="" /></td>

<td><input type="text" name="foggingbalance<%=inc3 %>"  id="foggingbalance<%=inc3%>"   validate="Balance,int,no"  maxlength="49"   class="" size="" /></td>

<td><input type="text" name="foggingremarks<%=inc3 %>" id="foggingremarks<%=inc3%>"   maxlength="49"  class="" size="" /></td>

<td><input type="button" name="foggingAdd<%=inc3 %>" id="foggingAdd<%=inc3%>"  class="buttonAdd" onclick="generateRow2();" tabindex="1" /></td>

<td><input type="button" name="foggingDelete<%=inc3 %>" id="foggingDelete<%=inc3%>"  class="buttonDel" onclick="removeRow2();" tabindex="1" /></td>
</tr>

</table>
</div>
</div>

<div id="country4" class="tabcontentIn">
<input type="hidden" name="country4" id="country4" value="ibn"/>
<div class="clear paddingTop15"></div>
<div class="cmntable">

<div class="clear"></div>

<table id="ibnDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc4 = 0;
inc4= inc4+1;

%>

<tr>

<input type="hidden" name ="srNo4"  id ="srNo4"  value=<%=inc4 %>  />

<td><input type="text" name="ibnSerialNo<%=inc4 %>" class="auto" size="1" value=<%=inc4 %> /></td>

<td><input type="text" name="ibnDate<%=inc4 %>"  id="ibnDate<%=inc4 %>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.ibnDate<%=inc4 %>,event)" /> </td>
<td>
<select name="ibnChemical<%=inc4 %>"  >
<option value="">Select</option>
<option value="DELTAMETHRIN">DELTAMETHRIN</option>
</select></td>

<td><input type="text" name="ibnarea<%=inc4 %>" id="ibnarea<%=inc4%>"  maxlength="49"  class="" size="" /></td>

<td><input type="button" name="ibnUpload<%=inc4 %>"  id="ibnUpload<%=inc4%>"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)"} ;/></td>

<td><input type="text" name="ibnsupervisor<%=inc4 %>" id="ibnsupervisor<%=inc4%>"  maxlength="49"  class="" value="" /></td>

<td><input type="text" name="ibncarriedOut<%=inc4 %>"  id="ibncarriedOut<%=inc4%>"   maxlength="49"     class="" size="" /></td>

<td><input type="text" name="ibnnoCovered<%=inc4 %>"  id="ibnnoCovered<%=inc4%>"  validate="No of Covered,int,no"  maxlength="49"     class="" size="" /></td>

<td><input type="text" name="ibnreceive<%=inc4 %>"  id="ibnreceive<%=inc4%>"   validate="Recieved,int,no"  maxlength="49"     class="" size="5" /></td>

<td><input type="text" name="ibnissued<%=inc4 %>"  id="ibnissued<%=inc4%>"  validate="Issue,int,no"  maxlength="49"      class="" size="" /></td>

<td><input type="text" name="ibnbalance<%=inc4 %>"  id="ibnbalance<%=inc4%>"  validate="Balance,int,no"   maxlength="49"  class="" size="" /></td>

<td><input type="text" name="ibnremarks<%=inc4 %>"  id="ibnremarks<%=inc4%>"   maxlength="49"    class="" size="" /></td>

<td><input type="button" name="ibnAdd<%=inc4 %>" name="ibnAdd<%=inc4%>"   class="buttonAdd" onclick="generateRow3();" tabindex="1" /></td>

<td><input type="button" name="ibnDelete<%=inc4 %>" name="ibnDelete<%=inc4%>"   class="buttonDel" onclick="removeRow3();" tabindex="1" /></td>
</tr>

</table>
</div>
</div>

<div id="country5" class="tabcontentIn">
<input type="hidden" name="country5" id="country5" value="antiFly"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="antiFlyDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc5 = 0;
inc5= inc5+1;

%>

<tr>
<input type="hidden" name="srNo5" id="srNo5" value=<%=inc5 %>  />
<td><input type="text" name="flyserialNo" id="flyserialNo<%=inc5 %>" class="auto" size="1" value=<%=inc5 %> /></td>

<td><input type="text" name="flyDate<%=inc5 %>"  id="flyDate<%=inc5 %>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.flyDate<%=inc5 %>,event)" /> </td>
<td>
<select name="antiFlyChemical<%=inc5 %>" >
<option value="">Select</option>
<option value="NUVAN">NUVAN</option>
<option value="BAYGON">BAYGON</option>
</select></td>

<td><input type="text" name="flyarea<%=inc5 %>"  id="flyarea<%=inc5%>"    maxlength="49"  class="" size="" /></td>

<td><input type="button" name="antiFlyUpload<%=inc5 %>" id="antiFlyUpload<%=inc5%>"      class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)" };/></td>

<td><input type="text" name="flysupervisor<%=inc5 %>"  id="flysupervisor<%=inc5%>"   maxlength="49"    class="" value="" /></td>

<td><input type="text" name="flycarriedOut<%=inc5 %>"  id="flycarriedOut<%=inc5%>"   maxlength="49"    class="" size="" /></td>

<td><input type="text" name="flynoCovered<%=inc5 %>"  id="flynoCovered<%=inc5%>"  validate="Covered,int,no"  maxlength="49"    class="" size="" /></td>

<td><input type="text" name="flyreceive<%=inc5 %>"  id="flyreceive<%=inc5%>"  validate="Recieved,int,no"   maxlength="49"    class="" size="5" /></td>

<td><input type="text" name="flyissued<%=inc5 %>"  id="flyissued<%=inc5%>"  validate="Issue,int,no"  maxlength="49"    class="" size="" /></td>

<td><input type="text" name="flybalance<%=inc5 %>"  id="flybalance<%=inc5%>"  validate="Balance,int,no" maxlength="49"    class="" size="" /></td>

<td><input type="text" name="flyremarks<%=inc5 %>"  id="flyremarks<%=inc5%>"  maxlength="49"    class="" size="" /></td>

<td><input type="button" name="antiFlyAdd<%=inc5 %>" id="antiFlyAdd<%=inc5%>" class="buttonAdd" onclick="generateRow4();" tabindex="1" /></td>

<td><input type="button" name="antiFlyDelete<%=inc5 %>" id="antiFlyDelete<%=inc5%>" class="buttonDel" onclick="removeRow4();" tabindex="1" /></td>
</tr>

</table>
</div>
</div>

<div id="country6" class="tabcontentIn">
<input type="hidden" name="country6" id="country6" value="debugging"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="debuggingDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc6 = 0;
inc6= inc6+1;
%>

<tr>
<input type="hidden" name="srNo6"  id="srNo6"  value=<%=inc6 %>  />

<td><input type="text" name="debuggingSerialNo<%=inc6 %>"  id="debuggingSerialNo<%=inc6 %>" class="auto" size="1" value=<%=inc6 %> /></td>

<td><input type="text" name="debuggingDate<%=inc6 %>"  id="debuggingDate<%=inc6 %>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.debuggingDate<%=inc6 %>,event)" /> </td>
<td>
<select name="debuggingChemical<%=inc6 %>" id="debuggingChemical<%=inc6 %>" >
<option value="">Select</option>
<option value="BAYGON">BAYGON</option>
</select></td>

<td><input type="text" name="debuggingarea<%=inc6 %>"  id="debuggingarea<%=inc6 %>"   maxlength="49"   class="" size="" /></td>

<td><input type="button" name="debuggingUpload<%=inc6 %>"  id="debuggingUpload<%=inc6 %>"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)" };/></td>

<td><input type="text" name="debuggingsupervisor<%=inc6 %>"  id="debuggingsupervisor<%=inc6 %>"   maxlength="49"   class="" value="" /></td>

<td><input type="text" name="debuggingcarriedOut<%=inc6 %>"  id="debuggingcarriedOut<%=inc6 %>"   maxlength="49"  class="" size="" /></td>

<td><input type="text" name="debuggingnoCovered<%=inc6 %>"  id="debuggingnoCovered<%=inc6 %>"   validate="Covered,int,no"  maxlength="49"    class="" size="" /></td>

<td><input type="text" name="debuggingreceive<%=inc6 %>"  id="debuggingreceive<%=inc6 %>"  validate="Recieved,int,no"  maxlength="49"  class="" size="5" /></td>

<td><input type="text" name="debuggingissued<%=inc6 %>"  id="debuggingissued<%=inc6 %>"   validate="Issue,int,no"  maxlength="49"  class="" size="" /></td>

<td><input type="text" name="debuggingbalance<%=inc6 %>"  id="debuggingbalance<%=inc6 %>"  validate="Balance,int,no"  maxlength="49"  class="" size="" /></td>

<td><input type="text" name="debuggingremarks<%=inc6 %>"  id="debuggingremarks<%=inc6 %>"  maxlength="49"   class="" size="" /></td>

<td><input type="button" name="debuggingAdd<%=inc6 %>" id="debuggingAdd<%=inc6 %>"  value="" class="buttonAdd" onclick="generateRow5();" tabindex="1" /></td>

<td><input type="button" name="debuggingDelete<%=inc6 %>" id="debuggingDelete<%=inc6 %>"  value="" class="buttonDel" onclick="removeRow5();" tabindex="1" /></td>
</tr>

</table>
</div>
</div>
<div id="country7" class="tabcontentIn">
<input type="hidden" name="country7" id="country7" value="biological"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="biologicalDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Chemical</th>
<th rowspan="2" scope="col">Area</th>
<th rowspan="2" scope="col">Upload Map</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Carried Out By</th>
<th rowspan="2">No. of Buildings<br/> Covered</th>
<th colspan="3">Total Qty Used</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
  <th>Received</th>
  <th>Issued</th>

<th>Balance</th>
</tr>
<% 
 int inc7 = 0;
inc7 = inc7+1;
%>

<tr>
<input type="hidden" name="srNo7" id="srNo7"  value=<%=inc7%>  />
<td><input type="text" name="biologicalserialNo<%=inc7%>" class="auto" size="1" value=<%=inc7 %> /></td>

<td><input type="text" name="biologicalDate<%=inc7%>"  id="biologicalDate<%=inc7%>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.biologicalDate<%=inc7%>,event)" /> </td>
<td>
<select name="biologicalChemical<%=inc7%>" id="biologicalChemical<%=inc7%>">
<option value="">Select</option>
<option value="LARVIVOROVS FISH">LARVIVOROVS FISH</option>
<option value="BTI">BTI</option>
</select></td>

<td><input type="text" name="biologicalarea<%=inc7%>"  id="biologicalarea<%=inc7%>"  maxlength="49"    class="" size="" /></td>

<td><input type="button" name="biologicalUpload<%=inc7%>"  id="biologicalUpload<%=inc7%>"  maxlength="49"  class="button" value="Upload" onClick = "if(!validateMetaCharacters(inc)){javascript:fileUploadWindowArea(<%=inc %>)" };/></td>

<td><input type="text" name="biologicalsupervisor<%=inc7%>"  id="biologicalsupervisor<%=inc7%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="biologicalcarriedOut<%=inc7%>"  id="biologicalcarriedOut<%=inc7%>"  maxlength="49"   class="" size="" /></td>

<td><input type="text" name="biologicalnoCovered<%=inc7%>"  id="biologicalnoCovered<%=inc7%>"  validate="No of Covered,int,no"  maxlength="49"  class="" size="" /></td>

<td><input type="text" name="biologicalreceive<%=inc7%>"   id="biologicalreceive<%=inc7%>"  validate="Recieved,int,no"  maxlength="49"   class="" size="5" /></td>

<td><input type="text" name="biologicalissued<%=inc7%>"  id="biologicalissued<%=inc7%>"  validate="Issue,int,no"  maxlength="49"    class="" size="" /></td>

<td><input type="text" name="biologicalbalance<%=inc7%>"  id="biologicalbalance<%=inc7%>"  validate="Balance,int,no"  maxlength="49"     class="" size="" /></td>

<td><input type="text" name="biologicalremarks<%=inc7%>"   id="biologicalremarks<%=inc7%>"  maxlength="49"    class="" size="" /></td>

<td><input type="button" name="biologicalAdd<%=inc7%>" id="biologicalAdd<%=inc7%>"  value="" class="buttonAdd" onclick="generateRow6('antiMalariaDetail6');" tabindex="1" /></td>

<td><input type="button" name="biologicalDelete<%=inc7%>" id="biologicalDelete<%=inc7%>"   class="buttonDel" onclick="removeRow6();" tabindex="1" /></td>
</tr>


</table>
</div>
</div>

<div id="country8" class="tabcontentIn">
<input type="hidden" name="country8" id="country8" value="personalProtectiveMeasures"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="personalProtectiveDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Protective Measures</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
<% 
 int inc8 = 0;
inc8 = inc8+1;
%>

<tr>
<input type="hidden" name="srNo8" id="srNo8"  value=<%=inc8%>  />
<td><input type="text" name="protectiveserialNo<%=inc8%>" class="auto" size="1" value=<%=inc8 %> /></td>

<td><input type="text" name="protectiveDate<%=inc8%>"  id="protectiveDate<%=inc8%>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.protectiveDate<%=inc8%>,event)" /> </td>

<td><input type="text" name="protectiveMeasures<%=inc8%>"  id="protectiveMeasures<%=inc8%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="protectivesupervisor<%=inc8%>"  id="protectivesupervisor<%=inc8%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="protectiveremarks<%=inc8%>"   id="protectiveremarks<%=inc8%>"  maxlength="49"    class="" size="" /></td>

<td><input type="button" name="protectiveAdd<%=inc8%>" id="protectiveAdd<%=inc8%>"  value="" class="buttonAdd" onclick="generateRow7();" tabindex="1" /></td>

<td><input type="button" name="protectiveDelete<%=inc8%>" id="protectiveDelete<%=inc8%>"   class="buttonDel" onclick="removeRow7();" tabindex="1" /></td>
</tr>


</table>
</div>
</div>

<div id="country9" class="tabcontentIn">
<input type="hidden" name="country9" id="country9" value="antiMalaria"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="antiMalariaDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Anti-Malaria Meeting</th>
<th rowspan="2">Under Suppressive treatment</th>
<th rowspan="2">Supervisor (H/A)</th>
<th rowspan="2">Remarks</th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
<% 
 int inc9 = 0;
inc9 = inc9+1;
%>

<tr>
<input type="hidden" name="srNo9" id="srNo9"  value=<%=inc9%>  />
<td><input type="text" name="antiMalariaserialNo<%=inc9%>" class="auto" size="1" value=<%=inc9 %> /></td>

<td><input type="text" name="antiMalariaDate<%=inc9%>"  id="antiMalariaDate<%=inc8%>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.antiMalariaDate<%=inc9%>,event)" /> </td>
<td>
<select name="antiMalariaMeeting<%=inc9%>" id="antiMalariaMeeting<%=inc9%>">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select></td>

<td><select name="suppressiveTreatment<%=inc9%>" id="suppressiveTreatment<%=inc9%>">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select></td>

<td><input type="text" name="antiMalariasupervisor<%=inc9%>"  id="antiMalariasupervisor<%=inc9%>"  maxlength="49"   class="" value="" /></td>

<td><input type="text" name="antiMalariaremarks<%=inc9%>"   id="antiMalariaremarks<%=inc9%>"  maxlength="49"    class="" size="" /></td>

<td><input type="button" name="antiMalariaAdd<%=inc9%>" id="antiMalariaAdd<%=inc9%>"  value="" class="buttonAdd" onclick="generateRow8();" tabindex="1" /></td>

<td><input type="button" name="antiMalariaDelete<%=inc9%>" id="antiMalariaDelete<%=inc9%>"   class="buttonDel" onclick="removeRow8();" tabindex="1" /></td>
</tr>


</table>
</div>
</div>

<div id="country10" class="tabcontentIn">
<input type="hidden" name="country10" id="country10" value="MalariaCases"/>
<div class="cmntable">

<div class="clear"></div>
<div class="clear"></div>
  <div class="clear"></div>
<table id="malariaCasesDetails" width="100%" cellspacing="0" cellpadding="0" >

<tr>

<th rowspan="2">Sl No.</th>
<th rowspan="2" colspan="2">Date</th>
<th rowspan="2">Blood Slides Examined</th>
<th rowspan="2">No.of Malaria Cases Detected (H/A)</th>
<th rowspan="2">Type</th>
<th rowspan="2">Category</th>
<th rowspan="2">Species of Plasmodium</th>
<th rowspan="2">Properly Investigated</th>
<th rowspan="2">Remedial Measures/th>
<th rowspan="2">Add</th>
<th rowspan="2">Delete</th>
</tr>
<tr>
<% 
 int inc10 = 0;
inc10 = inc10+1;
%>

<tr>
<input type="hidden" name="srNo10" id="srNo10"  value=<%=inc10%>  />
<td><input type="text" name="malariaCasesserialNo<%=inc10%>" class="auto" size="1" value=<%=inc10 %> /></td>

<td><input type="text" name="malariaCasesDate<%=inc10%>"  id="malariaCasesDate<%=inc10%>" value="<%=currenDate %>" class="date" size="" /></td>
<td><img src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0"  class="calender"
	onClick="setdate('<%=currenDate %>',document.vectorControl.malariaCases<%=inc10%>,event)" /> </td>

<td><select name="examinedBloodSlides<%=inc10%>" id="examinedBloodSlides<%=inc10%>">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select></td>

<td><input type="text" name="detectedMalariaCases<%=inc10%>"  id="detectedMalariaCases<%=inc10%>"  maxlength="49"  validate="Number of Malaria Case Detected,int,no"  class="" value="" /></td>

<td><select name="type<%=inc10%>" id="type<%=inc10%>">
<option value="">Select</option>
<option value="Fresh Local">Fresh Local</option>
<option value="Fresh Imported">Fresh Imported</option>
</select></td>

<td><select name="category<%=inc10%>" id="category<%=inc10%>">
<option value="">Select</option>
<option value="Officers">Officers</option>
<option value="Airmen">Airmen</option>
<option value="NCs(E)">NCs(E)</option>
<option value="Families">Families</option>
</select></td>

<td><select name="plasmodium<%=inc10%>" id="plasmodium<%=inc10%>">
<option value="">Select</option>
<option value="Vivax">Vivax</option>
<option value="Falciparum">Falciparum</option>
<option value="Mixed">Mixed</option>
</select></td>

<td><select name="properlyInvestigated<%=inc10%>" id="properlyInvestigated<%=inc10%>">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select></td>



<td><input type="text" name="remedialMeasures<%=inc10%>"  id="remedialMeasures<%=inc10%>"  maxlength="49"   class="" value="" /></td>

<td><input type="button" name="malariaCasesAdd<%=inc10%>" id="malariaCasesAdd<%=inc10%>"  value="" class="buttonAdd" onclick="generateRow9();" tabindex="1" /></td>

<td><input type="button" name="malariaCasesDelete<%=inc10%>" id="malariaCasesDelete<%=inc10%>"   class="buttonDel" onclick="removeRow9();" tabindex="1" /></td>
</tr>


</table>
</div>
</div>


<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm('vectorControl','/hms/hms/mis?method=submitVectorControlActivity');"
	value="Submit" class="button" accesskey="a" />

<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
<script type="text/javascript">

function generateRow() {
    	
	  var tbl = document.getElementById('antiMalariaDetail');
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
	  e0.name='larvalSerialNo'+iteration;
	  e0.id='larvalSerialNo'+iteration
	 // e0.value=iteration;	  
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
	  e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
      
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='larvalDate'+iteration;
	  e1.id='larvalDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('img');
      e2.src = '/hms/jsp/images/cal.gif';
     // e3.style.display ='none';
      e2.id = 'calId'+iteration;
      e2.onclick = function(event){
      setdate('serverdate',document.getElementById('larvalDate'+iteration),event) };
      cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'larvalChemical' + iteration;
	  e3.id = 'larvalChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('BAYTEX', 'BAYTEX');
	  e3.options[2] = new Option('BAYTEX G', 'BAYTEX G');
	  e3.options[3] = new Option('ABATE','ABATE');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name= 'larvalarea'+ iteration;
	  e4.id= 'larvalarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
      cellRight4.appendChild(e4);
      
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button';
	  e5.size='20';
      e5.className='Upload';  
	  e5.name='larvalAreaUpload'+iteration;
	  e5.value='UPLOAD';
	  e5.setAttribute('onClick','fileUploadWindowArea("hdb");');
	 // e30.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
      cellRight5.appendChild(e5);

      var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='larvalsupervisor'+iteration;
	  e6.type='text';		  
	  e6.size='20';   
      cellRight6.appendChild(e6);
      
      var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name = 'larvalcarriedoutby'+iteration;
	  e7.type='text';
	  e7.size='20'; 
      cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name= 'larvalnoCovered'+iteration;
	  e8.type='text';
	  e8.size='20'; 
      cellRight8.appendChild(e8);
      
	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='larvalrecieve'+iteration;
	  e9.type='text';
	  e9.size='5';	  
      cellRight9.appendChild(e9);
      
	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='larvalissue'+iteration;	  
	  e10.type='text';
	  e10.size='20';
      cellRight10.appendChild(e10);
      
	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='larvalbalance'+iteration;
	  e11.type='text';
	  e11.size='20';
      cellRight11.appendChild(e11);
      
	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='larvalremarks'+iteration;
	  e12.type='text';
	  e12.size='20';	  
      cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='larvalAdd'+iteration;
	  e13.setAttribute('onClick','generateRow();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='larvalDelete'+iteration;
	  e14.onclick = function(){removeRowF();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}

function generateRow1() {
	
	  var tbl = document.getElementById('adultDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);

	  var hdb = document.getElementById('srNo2');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='adultSerialNo'+iteration;
	  e0.id='adultSerialNo'+iteration
	  e0.value=hdb.value;
	  cellRight0.appendChild(e0);
    
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='adultDate'+iteration;
	  e1.id='adultDate'+iteration
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
    var e2 = document.createElement('img');
    e2.src = '/hms/jsp/images/cal.gif';
   // e3.style.display ='none';
    e2.id = 'calId'+iteration;
    e2.onclick = function(event){
    setdate('',document.getElementById('adultDate'+iteration),event) };
    cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'adultChemical' + iteration;
	  e3.id = 'adultChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('MALATHION 50%', 'MALATHION 50%');
	  e3.options[2] = new Option('DELTAMETHRIN', 'DELTAMETHRIN');
	  e3.options[3]	= new Option('CYPHENOTHRIN','CYPHENOTHRIN');  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='adultarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
    cellRight4.appendChild(e4);
    
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button'
	  e5.size='20'
    e5.className='Upload';  
	  e5.name='adultUpload'+iteration;
	  e5.value='UPLOAD';
    cellRight5.appendChild(e5);

    var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='adultsupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'    
    cellRight6.appendChild(e6);
    
    var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='adultcarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
    cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='adultnoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
    cellRight8.appendChild(e8);
    
	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='adultrecieve'+iteration;
	  e9.type='text'
	  e9.size='5'	  
    cellRight9.appendChild(e9);
    
	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='adultissue'+iteration;	  
	  e10.type='text'
	  e10.size='20'	  
    cellRight10.appendChild(e10);
    
	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='adultbalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
    cellRight11.appendChild(e11);
    
	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='adultremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
    cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='adultAdd'+iteration;
	  e13.setAttribute('onClick','generateRow1();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='adultDelete'+iteration;
	  e14.onclick = function(){removeRow1();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}
function generateRow2() {
	
	  var tbl = document.getElementById('foggingDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var hdb = document.getElementById('srNo3');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='foggingSerialNo'+iteration;
	  e0.id='foggingSerialNo'+iteration
	  e0.value=hdb.value;
	  cellRight0.appendChild(e0);
  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='foggingDate'+iteration;
	  e1.id='foggingDate'+iteration
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
  var e2 = document.createElement('img');
  e2.src = '/hms/jsp/images/cal.gif';
 // e3.style.display ='none';
  e2.id = 'calId'+iteration;
  e2.onclick = function(event){
  setdate('',document.getElementById('foggingDate'+iteration),event) };
  cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'foggingChemical' + iteration;
	  e3.id = 'foggingChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('PYRETHRUM', 'PYRETHRUM');
	  e3.options[2] = new Option('MALATHION TECH', 'MALATHION TECH');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='foggingarea'+iteration;
	  e4.id='foggingarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
      cellRight4.appendChild(e4);
  
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.name='foggingUpload'+iteration;
	  e5.type='button'
	  e5.size='20'
      e5.className='Upload';  
	  //e5.name='UPLOAD'+iteration;
	  e5.value='UPLOAD';
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='foggingsupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'      
	  cellRight6.appendChild(e6);
  
	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='foggingcarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='foggingnoCovered'+iteration;
	  e8.id='foggingnoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
	  cellRight8.appendChild(e8);
  
	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='foggingreceive'+iteration;
	  e9.name='foggingreceive'+iteration;
	  e9.type='text'
	  e9.size='5'	  
	  cellRight9.appendChild(e9);
  
	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='foggingissue'+iteration;
	  e10.id='foggingissue'+iteration;	  
	  e10.type='text'
	  e10.size='20'	  
	  cellRight10.appendChild(e10);
  
	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='foggingbalance'+iteration;
	  e11.id='foggingbalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
	  cellRight11.appendChild(e11);
  
	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='foggingremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
  	  cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='foggingAdd'+iteration;
	  e13.setAttribute('onClick','generateRow2();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='foggingDelete'+iteration;
	  e14.onclick = function(){removeRow2();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}
function generateRow3() {
	
	  var tbl = document.getElementById('ibnDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var hdb = document.getElementById('srNo4');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='ibnSerialNo'+iteration;
	  e0.id='ibnSerialNo'+iteration
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='ibnDate'+iteration;
	  e1.id='ibnDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('img');
	   e2.src = '/hms/jsp/images/cal.gif';
       // e3.style.display ='none';
       e2.id = 'calId'+iteration;
       e2.onclick = function(event){
       setdate('',document.getElementById('ibnDate'+iteration),event) };
       cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'ibnChemical' + iteration;
	  e3.id = 'ibnChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('DELTAMETHRIN', 'DELTAMETHRIN');
	  //e3.options[2] = new Option('Mfa', 'Mfa');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='ibnarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
      cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button'
	  e5.size='20'
      e5.className='Upload';  
	  e5.name='ibnUpload'+iteration;
	  e5.value='UPLOAD';
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='ibnsupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'      
	  cellRight6.appendChild(e6);

	  var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='ibncarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='ibnnoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
	  cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='ibnreceive'+iteration;
	  e9.id='ibnreceive'+iteration;
	  e9.type='text'
	  e9.size='5'	  
	  cellRight9.appendChild(e9);
	  
	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='ibnissued'+iteration;	  
	  e10.type='text'
	  e10.size='20'	  
	  cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='ibnbalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
	  cellRight11.appendChild(e11);

	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='ibnremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
	  cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='ibnAdd'+iteration;
	  e13.setAttribute('onClick','generateRow3();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='ibnDelete'+iteration;
	  e14.onclick = function(){removeRow3();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}
function generateRow4() {
	
	  var tbl = document.getElementById('antiFlyDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var hdb = document.getElementById('srNo5');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='antiFlySerialNo'+iteration;
	  e0.id='antiFlySerialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='flyDate'+iteration;
	  e1.id='flyDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('img');
      e2.src = '/hms/jsp/images/cal.gif';
      //e3.style.display ='none';
      e2.id = 'calId'+iteration;
      e2.onclick = function(event){
      setdate('',document.getElementById('antiFlyDate'+iteration),event) };
      cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'antiFlyChemical' + iteration;
	  e3.id = 'antiFlyChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('NUVAN', 'NUVAN');
	  e3.options[2] = new Option('BAYGON', 'BAYGON');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='flyarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button'
	  e5.size='20'
      e5.className='Upload';  
	  e5.name='antiFlyUpload'+iteration;
	  e5.value='UPLOAD'
cellRight5.appendChild(e5);

var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='flysupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'      
cellRight6.appendChild(e6);

var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='flycarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='flynoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='flyreceive'+iteration;
	  e9.type='text'
	  e9.size='5'	  
cellRight9.appendChild(e9);

	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='flyissued'+iteration;	  
	  e10.type='text'
	  e10.size='20'	  
cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='flybalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
cellRight11.appendChild(e11);

	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='flyremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='antiFlyAdd'+iteration;
	  e13.setAttribute('onClick','generateRow4();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='antiFlyDelete'+iteration;
	  e14.onclick = function(){removeRow4();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}
function generateRow5() {
	
	  var tbl = document.getElementById('debuggingDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var hdb = document.getElementById('srNo6');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='debuggingSerialNo';
	  e0.id='debuggingSerialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly');
	  e1.size='20';
	  e1.name='debuggingDate'+iteration;
	  e1.id='debuggingDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
var e2 = document.createElement('img');
e2.src = '/hms/jsp/images/cal.gif';
//e3.style.display ='none';
e2.id = 'calId'+iteration;
e2.onclick = function(event){
setdate('',document.getElementById('debuggingDate'+iteration),event) };
cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'debuggingChemical' + iteration;
	  e3.id = 'debuggingChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('BAYGON', 'BAYGON');
	  //e3.options[2] = new Option('Mfa', 'Mfa');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='debuggingarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button'
	  e5.size='20'
      e5.className='Upload';  
	  e5.name='debuggingUpload'+iteration;
	  e5.value='UPLOAD';
cellRight5.appendChild(e5);

var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='debuggingsupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'
      //e6.className='Upload';  
	 // e6.name='UPLOAD'+iteration;
	  //e6.value='DOWNLOAD/UPLOAD'
cellRight6.appendChild(e6);

var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='debuggingcarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='debuggingnoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='debuggingreceive'+iteration;
	  e9.type='text'
	  e9.size='5'	  
cellRight9.appendChild(e9);

	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.name='debuggingissued'+iteration;	  
	  e10.type='text'
	  e10.size='20'	  
cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='debuggingbalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
cellRight11.appendChild(e11);

	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='debuggingremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='debuggingAdd'+iteration;
	  e13.setAttribute('onClick','generateRow5();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='debuggingDelete'+iteration;
	  e14.onclick = function(){removeRow5();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}

function generateRow6() {
	
	  var tbl = document.getElementById('biologicalDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo7');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='biologicalSerialNo';
	  e0.id='biologicalSerialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='biologicalDate'+iteration;
	  e1.id='biologicalDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
var e2 = document.createElement('img');
e2.src = '/hms/jsp/images/cal.gif';
//e3.style.display ='none';
e2.id = 'calId'+iteration;
e2.onclick = function(event){
setdate('',document.getElementById('biologicalDate'+iteration),event) };
cellRight2.appendChild(e2);

	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('Select');
	  e3.name = 'biologicalChemical' + iteration;
	  e3.id = 'biologicalChemical' + iteration;
	  e3.className='big';
	  e3.setAttribute('tabindex','2');
	  e3.options[0] = new Option('Select', 'Select');
	  e3.options[1] = new Option('LARVIVOROVS FISH', 'LARVIVOROVS FISH');
	  e3.options[2] = new Option('BTI', 'BTI');	  
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.name='biologicalarea'+iteration;
	  e4.type='text'
	  e4.size='20'	  
cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type='button'
	  e5.size='20'
      e5.className='biologicalUpload';  
	  e5.name='biologicalUpload'+iteration;
	  e5.value='UPLOAD';
cellRight5.appendChild(e5);

var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.name='biologicalsupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'
      //e6.className='Upload';  
	  //e6.name='UPLOAD'+iteration;
	  //e6.value='DOWNLOAD/UPLOAD'
cellRight6.appendChild(e6);

var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.name='biologicalcarriedOut'+iteration;
	  e7.type='text'
	  e7.size='20'	  
cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.name='biologicalnoCovered'+iteration;
	  e8.type='text'
	  e8.size='20'	  
cellRight8.appendChild(e8);

	  var cellRight9 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.name='biologicalreceive'+iteration;
	  e9.type='text'
	  e9.size='5'	  
cellRight9.appendChild(e9);

	  var cellRight10 = row.insertCell(10);
	  var e10 = document.createElement('input');	
	  e10.name='biologicalissued'+iteration;  
	  e10.type='text'
	  e10.size='20'	  
cellRight10.appendChild(e10);

	  var cellRight11 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.name='biologicalbalance'+iteration;
	  e11.type='text'
	  e11.size='20'	  
cellRight11.appendChild(e11);

	  var cellRight12 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.name='biologicalremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
cellRight12.appendChild(e12);

	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='biologicalAdd'+iteration;
	  e13.setAttribute('onClick','generateRow6();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight13.appendChild(e13);

	  var cellRight14 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='biologicalDelete'+iteration;
	  e14.onclick = function(){removeRow6();}
	  e14.setAttribute('tabindex','1');
	  cellRight14.appendChild(e14);
}

function generateRow7() {
	
	  var tbl = document.getElementById('personalProtectiveDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo8');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='protectiveserialNo';
	  e0.id='protectiveserialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='protectiveDate'+iteration;
	  e1.id='protectiveDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	  var cellRight2 = row.insertCell(2);
		var e2 = document.createElement('img');
		e2.src = '/hms/jsp/images/cal.gif';
		//e3.style.display ='none';
		e2.id = 'calId'+iteration;
		e2.onclick = function(event){
		setdate('',document.getElementById('protectiveDate'+iteration),event) };
		cellRight2.appendChild(e2);

		 var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.name='protectiveMeasures'+iteration;
		  e3.type='text'
		  e3.size='20'
	     cellRight3.appendChild(e3);

      var cellRight4 = row.insertCell(4);
	  var e6 = document.createElement('input');
	  e6.name='protectivesupervisor'+iteration;
	  e6.type='text'
	  e6.size='20'
    //e6.className='Upload';  
	  //e6.name='UPLOAD'+iteration;
	  //e6.value='DOWNLOAD/UPLOAD'
     cellRight4.appendChild(e6);
    

	  var cellRight5 = row.insertCell(5);
	  var e12 = document.createElement('input');
	  e12.name='protectiveremarks'+iteration;
	  e12.type='text'
	  e12.size='20'	  
      cellRight5.appendChild(e12);

	  var cellRight6 = row.insertCell(6);
	  var e13 = document.createElement('input');
	  e13.type = 'button';
	  e13.className = 'buttonAdd';
	  e13.name='protectiveAdd'+iteration;
	  e13.setAttribute('onClick','generateRow7();');	  
	  e13.setAttribute('tabindex','1');
	  cellRight6.appendChild(e13);

	  var cellRight7 = row.insertCell(7);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonDel';
	  e14.name='protectiveDelete'+iteration;
	  e14.onclick = function(){removeRow7();}
	  e14.setAttribute('tabindex','1');
	  cellRight7.appendChild(e14);
}

function generateRow8() {
	
	  var tbl = document.getElementById('antiMalariaDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo9');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='antiMalariaserialNo';
	  e0.id='antiMalariaserialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='antiMalariaDate'+iteration;
	  e1.id='antiMalariaDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	   var cellRight2 = row.insertCell(2);
		var e2 = document.createElement('img');
		e2.src = '/hms/jsp/images/cal.gif';
		//e3.style.display ='none';
		e2.id = 'calId'+iteration;
		e2.onclick = function(event){
		setdate('',document.getElementById('antiMalariaDate'+iteration),event) };
		cellRight2.appendChild(e2);

		var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('Select');
		  e3.name = 'antiMalariaMeeting' + iteration;
		  e3.id = 'antiMalariaMeeting' + iteration;
		  e3.className='big';
		  e3.setAttribute('tabindex','2');
		  e3.options[0] = new Option('Select', 'Select');
		  e3.options[1] = new Option('Yes', 'yes');
		  e3.options[2] = new Option('No', 'NO');	  
		  cellRight3.appendChild(e3);

		  var cellRight4 = row.insertCell(4);
		  var e4 = document.createElement('Select');
		  e4.name = 'suppressiveTreatment' + iteration;
		  e4.id = 'suppressiveTreatment' + iteration;
		  e4.className='big';
		  e4.setAttribute('tabindex','2');
		  e4.options[0] = new Option('Select', 'Select');
		  e4.options[1] = new Option('Yes', 'yes');
		  e4.options[2] = new Option('No', 'NO');	  
		  cellRight4.appendChild(e4);

	  	 var cellRight5 = row.insertCell(5);
	 	 var e12 = document.createElement('input');
	 	 e12.name='antiMalariasupervisor'+iteration;
	 	 e12.type='text'
	 	 e12.size='20'	  
 		 cellRight5.appendChild(e12);


	 	 var cellRight6 = row.insertCell(6);
	 	 var e13 = document.createElement('input');
	 	 e13.name='antiMalariaremarks'+iteration;
	 	 e13.type='text'
	 	 e13.size='20'	  
 		 cellRight6.appendChild(e13);

	  var cellRight7 = row.insertCell(7);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonAdd';
	  e14.name='protectiveAdd'+iteration;
	  e14.setAttribute('onClick','generateRow8();');	  
	  e14.setAttribute('tabindex','1');
	  cellRight7.appendChild(e14);

	  var cellRight8 = row.insertCell(8);
	  var e15 = document.createElement('input');
	  e15.type = 'button';
	  e15.className = 'buttonDel';
	  e15.name='protectiveDelete'+iteration;
	  e15.onclick = function(){removeRow8();}
	  e15.setAttribute('tabindex','1');
	  cellRight8.appendChild(e15);
}

function generateRow9() {
	
	  var tbl = document.getElementById('malariaCasesDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo10');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='malariaCasesserialNo';
	  e0.id='malariaCasesserialNo'+iteration;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.className = 'date';
	  e1.setAttribute('readonly','readonly')
	  e1.size='20';
	  e1.name='malariaCasesDate'+iteration;
	  e1.id='malariaCasesDate'+iteration;
	  e1.value='<%=currenDate %>';
	  cellRight1.appendChild(e1);
	  
	   var cellRight2 = row.insertCell(2);
		var e2 = document.createElement('img');
		e2.src = '/hms/jsp/images/cal.gif';
		//e3.style.display ='none';
		e2.id = 'calId'+iteration;
		e2.onclick = function(event){
		setdate('',document.getElementById('malariaCasesDate'+iteration),event) };
		cellRight2.appendChild(e2);

		var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('Select');
		  e3.name = 'examinedBloodSlides' + iteration;
		  e3.id = 'examinedBloodSlides' + iteration;
		  e3.className='big';
		  e3.setAttribute('tabindex','2');
		  e3.options[0] = new Option('Select', 'Select');
		  e3.options[1] = new Option('Yes', 'yes');
		  e3.options[2] = new Option('No', 'NO');	  
		  cellRight3.appendChild(e3);

		  	var cellRight4 = row.insertCell(4);
		 	 var e31 = document.createElement('input');
		 	 e31.name='detectedMalariaCases'+iteration;
		 	 e31.type='text'
		 	 e31.size='20'	  
			 cellRight4.appendChild(e31);

		  var cellRight5 = row.insertCell(5);
		  var e4 = document.createElement('Select');
		  e4.name = 'type' + iteration;
		  e4.id = 'type' + iteration;
		  e4.className='big';
		  e4.setAttribute('tabindex','2');
		  e4.options[0] = new Option('Select', 'Select');
		  e4.options[1] = new Option('Fresh Local', 'Fresh Local');
		  e4.options[2] = new Option('Fresh Imported', 'Fresh Imported');	  
		  cellRight5.appendChild(e4);

		  var cellRight6 = row.insertCell(6);
		  var e41 = document.createElement('Select');
		  e41.name = 'category' + iteration;
		  e41.id = 'category' + iteration;
		  e41.className='big';
		  e41.setAttribute('tabindex','2');
		  e41.options[0] = new Option('Select', 'Select');
		  e41.options[1] = new Option('Offers', 'Offers');
		  e41.options[2] = new Option('Airmen', 'Airmen');
		  e41.options[3] = new Option('NCs(E)', 'NCs(E)');	 
		  e41.options[4] = new Option('Families', 'Families');	 	  
		  cellRight6.appendChild(e41);

		  var cellRight7 = row.insertCell(7);
		  var e43 = document.createElement('Select');
		  e43.name = 'plasmodium' + iteration;
		  e43.id = 'plasmodium' + iteration;
		  e43.className='big';
		  e43.setAttribute('tabindex','2');
		  e43.options[0] = new Option('Select', 'Select');
		  e43.options[1] = new Option('Vivax', 'Vivax');
		  e43.options[2] = new Option('Falciparum', 'Falciparum');
		  e43.options[3] = new Option('Mixed', 'Mixed');	 
		  cellRight7.appendChild(e43);

		  var cellRight8 = row.insertCell(8);
		  var e44 = document.createElement('Select');
		  e44.name = 'properlyInvestigated' + iteration;
		  e44.id = 'properlyInvestigated' + iteration;
		  e44.className='big';
		  e44.setAttribute('tabindex','2');
		  e44.options[0] = new Option('Select', 'Select');
		  e44.options[1] = new Option('Yes', 'yes');
		  e44.options[2] = new Option('No', 'NO');	  
		  cellRight8.appendChild(e44);
		  
		 
	  	 var cellRight9 = row.insertCell(9);
	 	 var e12 = document.createElement('input');
	 	 e12.name='remedialMeasures'+iteration;
	 	 e12.type='text'
	 	 e12.size='20'	  
		 cellRight9.appendChild(e12);
		 

	  var cellRight10 = row.insertCell(10);
	  var e14 = document.createElement('input');
	  e14.type = 'button';
	  e14.className = 'buttonAdd';
	  e14.name='malariaCasesAdd'+iteration;
	  e14.setAttribute('onClick','generateRow9();');	  
	  e14.setAttribute('tabindex','1');
	  cellRight10.appendChild(e14);

	  var cellRight11 = row.insertCell(11);
	  var e15 = document.createElement('input');
	  e15.type = 'button';
	  e15.className = 'buttonDel';
	  e15.name='malariaCasesDelete'+iteration;
	  e15.onclick = function(){removeRow9();}
	  e15.setAttribute('tabindex','1');
	  cellRight11.appendChild(e15);
}
function removeRowF()
{ 
	
  var tbl = document.getElementById('antiMalariaDetail');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('antiMalariaDetail');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('antiMalariaDetail');
  	hdb.value=iteration
  }
}
  function removeRow1()
  {  
    var tbl = document.getElementById('adultDetails');
    
    var lastRow = tbl.rows.length;
    if (lastRow > 2){
    	tbl.deleteRow(lastRow - 1);
    	var tbl = document.getElementById('adultDetails');
    	
    	var lastRow = tbl.rows.length;
  	  // if there's no header row in the table, then iteration = lastRow + 1
   	var iteration = lastRow - 1;
    	var hdb = document.getElementById('adultDetails');    	
    	hdb.value=iteration
    }
  }
    function removeRow2()
    {
      var tbl = document.getElementById('foggingDetails');
      var lastRow = tbl.rows.length;
      if (lastRow > 2){
      	tbl.deleteRow(lastRow - 1);
      	var tbl = document.getElementById('foggingDetails');
      	var lastRow = tbl.rows.length;
    	  // if there's no header row in the table, then iteration = lastRow + 1
     	var iteration = lastRow - 1;
      	var hdb = document.getElementById('foggingDetails');
      	hdb.value=iteration
      }
    }
      function removeRow3()
      {
        var tbl = document.getElementById('ibnDetails');
        var lastRow = tbl.rows.length;
        if (lastRow > 2){
        	tbl.deleteRow(lastRow - 1);
        	var tbl = document.getElementById('ibnDetails');
        	var lastRow = tbl.rows.length;
      	  // if there's no header row in the table, then iteration = lastRow + 1
       	var iteration = lastRow - 1;
        	var hdb = document.getElementById('ibnDetails');
        	hdb.value=iteration
        }
      }
        function removeRow4()
        {
          var tbl = document.getElementById('antiFlyDetails');
          var lastRow = tbl.rows.length;
          if (lastRow > 2){
          	tbl.deleteRow(lastRow - 1);
          	var tbl = document.getElementById('antiFlyDetails');
          	var lastRow = tbl.rows.length;
        	  // if there's no header row in the table, then iteration = lastRow + 1
         	var iteration = lastRow - 1;
          	var hdb = document.getElementById('antiFlyDetails');
          	hdb.value=iteration
          }
        }
          function removeRow5()
          {
            var tbl = document.getElementById('debuggingDetails');
            var lastRow = tbl.rows.length;
            if (lastRow > 2){
            	tbl.deleteRow(lastRow - 1);
            	var tbl = document.getElementById('debuggingDetails');
            	var lastRow = tbl.rows.length;
          	  // if there's no header row in the table, then iteration = lastRow + 1
           	var iteration = lastRow - 1;
            	var hdb = document.getElementById('debuggingDetails');
            	hdb.value=iteration
            }
          }
            function removeRow6()
            {
              var tbl = document.getElementById('biologicalDetails');
              var lastRow = tbl.rows.length;
              if (lastRow > 2){
              	tbl.deleteRow(lastRow - 1);
              	var tbl = document.getElementById('biologicalDetails');
              	var lastRow = tbl.rows.length;
            	  // if there's no header row in the table, then iteration = lastRow + 1
             	var iteration = lastRow - 1;
              	var hdb = document.getElementById('biologicalDetails');
              	hdb.value=iteration
              }
       }


            function removeRow7()
            {
              var tbl = document.getElementById('personalProtectiveDetails');
              var lastRow = tbl.rows.length;
              if (lastRow > 2){
              	tbl.deleteRow(lastRow - 1);
              	var tbl = document.getElementById('personalProtectiveDetails');
              	var lastRow = tbl.rows.length;
            	  // if there's no header row in the table, then iteration = lastRow + 1
             	var iteration = lastRow - 1;
              	var hdb = document.getElementById('personalProtectiveDetails');
              	hdb.value=iteration
              }
       }

            function removeRow8()
            {
              var tbl = document.getElementById('antiMalariaDetails');
              var lastRow = tbl.rows.length;
              if (lastRow > 2){
              	tbl.deleteRow(lastRow - 1);
              	var tbl = document.getElementById('antiMalariaDetails');
              	var lastRow = tbl.rows.length;
            	  // if there's no header row in the table, then iteration = lastRow + 1
             	var iteration = lastRow - 1;
              	var hdb = document.getElementById('antiMalariaDetails');
              	hdb.value=iteration
              }
       }

            function removeRow9()
            {
              var tbl = document.getElementById('malariaCasesDetails');
              var lastRow = tbl.rows.length;
              if (lastRow > 2){
              	tbl.deleteRow(lastRow - 1);
              	var tbl = document.getElementById('malariaCasesDetails');
              	var lastRow = tbl.rows.length;
            	  // if there's no header row in the table, then iteration = lastRow + 1
             	var iteration = lastRow - 1;
              	var hdb = document.getElementById('malariaCasesDetails');
              	hdb.value=iteration
              }
       }

            function fileUploadWindowArea(rowVal)
            {
            	   //alert("fileUploadWindowArea"); 
             		//var val=document.getElementById('chargeCodeName'+rowVal).value;
             	 	//var index1 = val.lastIndexOf("[");
             	 	//var index2 = val.lastIndexOf("]");
             	 	//index1++;
                	//var invest_id = val.substring(index1,index2);
                	 	var folder="vectorControl";
                	if(validateMetaCharacters(folder))
	              {               
             	    var url="/hms/hms/mis?method=displayFileUploadArea&folderName="+folder;            	
            		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	              }     	
             	
            }
            
</script>
</form>

