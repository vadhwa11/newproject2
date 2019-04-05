<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
Map<String,Object> map = new HashMap<String,Object>();


int subTestId=0;

if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

if(map.get("subTestId")!=null){
	subTestId =Integer.parseInt(""+map.get("subTestId"));
}
	List<DgFixedValue> fixedList=new ArrayList<DgFixedValue>();
	if (map.get("fixedList") != null) {
		fixedList = (List<DgFixedValue>)map.get("fixedList");
	}

	%>
<%
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

	if(map.get("subTestId")!=null){
		subTestId =Integer.parseInt(""+map.get("subTestId"));
	}
	if(map.get("message") != null)
	{
	 	  String message = (String)map.get("message");
	 	   %>
<h4>
	<span><%=message %></span>
</h4>
<%} %>

<script>
	function resultTypeee(rowVal) {
		var rt = document.getElementById('resultType' + rowVal).value;
		if (rt == "h") {
			document.getElementById('comparisonType' + rowVal).value = 'n'
		}
		return true;
	}
</script>

<script type="text/javascript">
	var icdArray = new Array();
	var usedForArray = new Array();
</script>


<script>
	var newwindow;
	function popwindow(url) {

		newwindow = window.open(url, 'name', "height=250,width=950,status=1");
		if (window.focus) {
			newwindow.focus()
		}
	}
	function checkFilledRow444() {
		var msg = "";
		var rowLength = document.getElementById('amcTDetailsListSize').value;

		if (document.getElementById('orderNo1').value === "") {
			alert("Please fill atleast one row to submit.");
			return false;
		}
		for (var i = 1; i <= parseInt(rowLength); i++) {
			var subTestName = document.getElementById('subTestName' + i).value;
			var subTestCode = document.getElementById('subTestCode' + i).value;
			var compressionType = document
					.getElementById('compressionType' + i).value;
			if (subTestName != "") {
				if (subTestCode != "") {
					if (compressionType == "") {
						alert("Please Select Compression Type");
						return false;
					} else {

					}
				} else {
					alert("please Enter Test Code");
					return false;
				}
			} else {
				alert("please Enter Test Name");
				return false;
			}

		}

	}

	function checkFilledRow() {
		var count = document.getElementById('amcTDetailsListSize').value;

		var msg = "";

		for (var i = 1; i <= count; i++) {

			if (document.getElementById('orderNo' + i).value != "") {

			} else {
				msg += "please fill atleast one raw\n";
				document.getElementById('orderNo' + i).focus();

			}

		}
		if (msg != "") {
			alert(msg)
			return false;
		} else {
			return true;
		}

	}
</script>
<div class="titleBg">
	<h2>Fixed Value</h2>
</div>
<form name="fixed" method="post" action="">
	<input type="hidden" value="<%=subTestId %>" id="<%=SUBTEST_ID %>"
		name="<%=SUBTEST_ID%>" readonly="readonly" />
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="cmntable">
		<table width="100%" border="0" id="chargeDetails" cellspacing="0"
			cellpadding="0">

			<tr>
				<th></th>
				<th>Fixed Value</th>
			</tr>
			<% 
    			int temp=0;
    			int inc = 0; 
    			%>
			<tr>
				<td><input type="checkbox" value="<%=inc%>"
					name="selectedChrage" class="radioCheck" /></td>
				<td><input type="text" name="<%=FIXED_VALUE1 %>" value=""
					id="<%=FIXED_VALUE1 %>" maxlength="500"
					validate="Fixed Value,string,yes" tabindex="1" /></td>
			</tr>
			<input type="hidden" class="medcaption" name="" value="y" id="status" />
		</table>
	</div>
	<input type="hidden" name="hiddenValueCharge" value="y"
		id="hiddenValueCharge" />
	<div class="clear"></div>
	<input type="button" name="add" value="" class="buttonAdd"
		onclick="addRow();" tabindex="1" /> <input type="button"
		name="delete" value="" class="buttonDel" onclick="removeRow();" />

	<div class="paddingTop15"></div>

	<div class="clear"></div>
	<div class="division"></div>
	<input type="hidden" id="amcTDetailsListSize"
		name="amcTDetailsListSize" value="1" /> <input type="button"
		name="add" id="addbutton" value="Submit" class="button"
		onclick="submitForm('fixed','investigation?method=submitFixedValues');"
		accesskey="a" tabindex=1 /> <input type="button" name="cancel"
		id="addbutton" value="Cancel" class="button" onclick="cancelForm();"
		accesskey="a" tabindex=1 />
	<div class="clear"></div>
	<div class="division"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	function generateRowWithoutSrNo(idName) {

		var d = document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length - 1]
		var noOfRows = d.length
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone, lastTr.nextSibling)
		var tblCtrl = d[d.length - 1].getElementsByTagName("input");
		for (var i = 0; i < tblCtrl.length; i++)
			tblCtrl[i].value = "";
		document.getElementById('amcTDetailsListSize').value = noOfRows

	}

	function checkComparisionType(resultType, inc) {
		obj = document.getElementById('compressionType' + inc);

		obj.length = 1;

		if (resultType == "h") {
			obj.length++;
			obj.options[obj.length - 1].value = "n";
			obj.options[obj.length - 1].text = "None";
			obj.options[obj.length - 1].selected = true;
		} else {
			obj.length++;
			obj.options[obj.length - 1].value = "n";
			obj.options[obj.length - 1].text = "None";
			obj.length++;
			obj.options[obj.length - 1].value = "f";
			obj.options[obj.length - 1].text = "Fixed Values";
			obj.length++;
			obj.options[obj.length - 1].value = "v";
			obj.options[obj.length - 1].text = "Normal Values";

		}

	}

	function addRow() {
		var tbl = document.getElementById('chargeDetails');
		var lastRow = tbl.rows.length;
		document.getElementById('amcTDetailsListSize').value = lastRow

		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('amcTDetailsListSize');

		var iteration = parseInt(hdb.value);

		hdb.value = iteration;
		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name = 'selectedChrage';
		e0.className = 'radioCheck';
		e0.tabIndex = "1";
		e0.value = (iteration);
		cell0.appendChild(e0);

		var cell1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'fixedValue' + (iteration);
		e1.validate = "Fixed Value,string,yes";
		e1.id = 'fixedValue' + (iteration);
		e1.tabIndex = "1";
		cell1.appendChild(e1);
	}
	function removeRow() {
		var tbl = document.getElementById('chargeDetails');
		var lastRow = document.getElementById('amcTDetailsListSize').value;
		var tblRows = tbl.getElementsByTagName("tr");

		if (tblRows.length - 2 == 0) {
			alert("Can not delete all rows")
			return false;
		}

		for (counter = 0; counter < document
				.getElementsByName('selectedChrage').length; counter++) {
			if (document.getElementsByName('selectedChrage')[counter].checked == true) {
				tbl.deleteRow(counter + 1);
				document.getElementById('amcTDetailsListSize').value = parseInt(lastRow) - 1;
			}
		}
	}
</script>