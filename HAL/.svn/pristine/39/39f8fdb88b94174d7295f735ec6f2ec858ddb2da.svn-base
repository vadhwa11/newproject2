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

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
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
<form name="vectorControl" method="post" action="">

<div class="titleBg"><h2>Vector Control Activities/ Anti Larva</h2></div>

<div class="clear"></div>
<ul id="countrytabs" class="shadetabs">
<li><a href="#" rel="country1">CHEMICAL</a></li>
<li><a href="#" rel="country2">BIOLOGICAL</a></li>
<li><a href="#" rel="country3">IRS</a></li>
<li><a href="#" rel="country4">IBN</a></li>
<li><a href="#" rel="country5">FOGGING</a></li>
<li><a href="#" rel="country6">DEBUGGING</a></li>
</ul>
<div class="clear"></div>

<div id="country1" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>CHEMICAL</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>
</div>



<div id="country2" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>BIOLOGICAL</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>
</div>


<div id="country3" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>IRS</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>
</div>


<div id="country4" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>IBN</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>
</div>


<div id="country5" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>FOGGING</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>

</div>


<div id="country6" class="tabcontentIn">
<div class="clear paddingTop15"></div>
<h4>DEBUGGING</h4>
<div class="clear"></div>

<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Chemical</th>
<th>Area</th>
<th>Supervisor (H/A)</th>
<th>Carried Out By</th>
<th>No Covered</th>
<th>Qty of Hygiene</th>
<th>Chemical Used</th>
<th>Remarks</th>
<th>Add</th>
<th>Delete</th>
</tr>

<tr>
<td><input type="text" name="serialNo" class="auto" size="5" /></td>

<td><input type="text" name="date" class="date" size="" /></td>

<td><select><option>Select</option></select></td>

<td><input type="button" name="area" class="button" value="Download/ Upload" /></td>

<td><input type="text" name="supervisor" class="" size="" /></td>

<td><input type="text" name="carriedOut" class="" size="" /></td>

<td><input type="text" name="noCovered" class="" size="" /></td>

<td><input type="text" name="qtyOfHygiene" class="" size="" /></td>

<td><input type="text" name="chemicalUsed" class="" size="" /></td>

<td><input type="text" name="remarks" class="" size="" /></td>

<td><input type="button" name="add" value="" class="buttonAdd" onclick="generateRow('appTable');" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('appTable','cnt',this);" tabindex="1" /></td>
</tr>

</table>

</div>
</form>

