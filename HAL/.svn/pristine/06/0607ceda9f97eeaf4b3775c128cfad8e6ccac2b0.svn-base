<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sub_Test.jsp  
 * Purpose of the JSP -  This is for Sub Test.
 * @author  Deeplai
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>

<link href="/hms/jsp/css/hms_basic_style.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<style>
html,body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	width: 100%;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	font-size: 11px;
	color: #4E4E4E;
	text-decoration: none;
	line-height: 20px;
	text-align: center;
	letter-spacing: .03em;
	overflow: auto !important;
}

form {
	margin: 0px;
}

#contentspace h2 {
	color: #339900;
	font-family: "Trebuchet MS" !important;
	letter-spacing: 1px;
	font-weight: bold;
	font-size: 18px;
}

#contentspace h3 {
	color: #3897DC;
	font-family: "Trebuchet MS" !important;
	letter-spacing: 1px;
	font-weight: 500;
	border-bottom: 1px dashed #3897DC;
}

#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
}

#contentspace input {
	border: 0px;
	width: 124px;
	height: 22px;
	padding-right: 10px;
	padding-left: 6px;
	padding-top: 3px;
	background-image: url(/hms/jsp/images/textfield10.gif);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: 0px 0px;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	font-size: 11px;
	color: #4E4E4E;
	float: left;
	margin-right: 6px;
}

html>body #contentspace input {
	background-attachment: inherit;
}

.button {
	background-image: url(/hms/jsp/images/button.gif) !important;
	width: 82px !important;
	height: 21px !important;
	font-size: 11px;
	color: #FFFFFF !important;
	margin-right: 10px;
	border: none;
}

.setborder {
	background-image: url(../images/button.gif) !important;
	width: 84px !important;
	height: 23px !important;
	font-size: 11px;
	color: #FFFFFF !important;
	margin-right: 10px;
	border: 2px solid yellow;
}

#searchresults table {
	margin: 10px;
}

#contentspace br {
	clear: both;
}

#contentspace select {
	float: left;
	width: 140px;
	margin-right: 7px;
	margin-top: 3px;
	font-size: 10px;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
}

#searchresults table thead,leavedetails,thead {
	background-image: url(/hms/jsp/images/tablehead.gif);
	height: 20px;
	text-align: center
}

#searchresults .odd {
	background-color: #A9EDFE;
}

#searchresults .even {
	background-color: #F5FDFE
}

.tableover {
	background-color: #39D7FF !important;
}

td {
	font-size: 0.84em !important;
}

.hide {
	display: none;
}

#contentspace span {
	float: left;
	width: 110px;
}

#contentspace input {
	border: 0px;
	width: 140px;
	height: 22px;
	padding-right: 10px;
	padding-left: 6px;
	padding-top: 3px;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	font-size: 1em;
	color: #4E4E4E;
	float: left
}

html>body #contentspace input {
	background-attachment: scroll;
}
</style>

<script type="text/javascript">
	subTest = new Array();
	cnt = 0;
	arr = window.opener.subtest_arr;
	
	checkDelete=0;
	if(arr.length>0){
		for(a=0;a<arr.length;a++){
			if(window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value == arr[a][3]){
				subTest[cnt] = new Array();
				subTest[cnt][0] = arr[a][0];	
				subTest[cnt][1] = arr[a][1];
				subTest[cnt][2] = arr[a][2];
				if(arr[a][3] == ""){
					subTest[cnt][3] = "~^";
				}
				else{
				subTest[cnt][3] = arr[a][3];
				}
				if(arr[a][4] == ""){
					subTest[cnt][4] = "~^";
				}
				else{
					subTest[cnt][4] = arr[a][4];
				}	
				if(arr[a][5] == ""){
					subTest[cnt][5] = "~^";
				}
				else{
					subTest[cnt][5] = arr[a][5];
				}
				
				subTest[cnt][6] = arr[a][6];				
				cnt++
			}
		}
		showResults();				
	}
	else if(window.opener.document.chargeCode.subTest.value != ""){
	arr = window.opener.document.chargeCode.subTest.value
		for(a=0;a<arr.length;a++){
			if(window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value == arr[a][3]){
				subTest[cnt] = new Array();
				subTest[cnt][0] = arr[a][0];	
				subTest[cnt][1] = arr[a][1];
				subTest[cnt][2] = arr[a][2];
				subTest[cnt][3] = arr[a][3];
				subTest[cnt][4] = arr[a][4];
				subTest[cnt][5] = arr[a][5];
				subTest[cnt][6] = arr[a][6];								
				cnt++
			}
		}
		showResults();		
	}
	
<%
	ArrayList unitOfResultMeasurementListForSubTest = (ArrayList)session.getAttribute("unitOfResultMeasurementTypeFromCTDForSubTest");
%>
	function addSubTest(){
	if(document.subTest.subTestCode.value == "" || document.subTest.subTestDesc.value == ""){
		if(document.subTest.subTestCode.value == "" && document.subTest.subTestDesc.value == ""){
			alert("Sub Test Code And SubTest Description Can't Be Blank");
			return false;
		}
		if(document.subTest.subTestCode.value == ""){
			alert("Sub Test Code Can't Be Blank.");
		}
		if(document.subTest.subTestDesc.value == ""){
			alert("Sub Test Description Can't Be Blank.");
		}
		return false;
	}	
		else{
		if(chkUnique()){
			subTest[cnt] = new Array();
			subTest[cnt][0] = "0";
			subTest[cnt][1] = document.subTest.subTestCode.value;
			subTest[cnt][2] = document.subTest.subTestDesc.value;
			if(window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value == ""){
				subTest[cnt][3] = "~^";
				
			}
			else
			{
				subTest[cnt][3] = window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value;   
			}
			
			
			if(document.subTest.normalValue.value == ""){
				subTest[cnt][4] = "~^";
			}
			else{
				subTest[cnt][4] = document.subTest.normalValue.value;
			}
			if(document.subTest.unitOfResult.value == ""){
				subTest[cnt][5] = "~^";
			}
			else{
				subTest[cnt][5] = document.subTest.unitOfResult.value;
			}
			
			subTest[cnt][6] = 1;						
			cnt++
			document.subTest.subTestCode.value = "";
			document.subTest.subTestDesc.value = "";
			document.subTest.unitOfResult.value = "";
			document.subTest.normalValue.value = "";
			document.subTest.chargeCode.value = "";
			document.subTest.status.value = "";						
			showResults();
		}
		}
	}
	function chkUnique(){
		if(subTest.length>0){
			for(j=0;j<subTest.length;j++){
				if(subTest[j][1]==document.subTest.subTestCode.value || subTest[j][2]==document.subTest.subTestDesc.value){
					alert("Sub Test Code and description should be unique");
					return false;
				}
			}
		}
		return true;
	}
	function showResults(){
	       
			tmp = '<table width="575" align="left"><thead><tr><td width="20%">Sub Test Code</td><td>Sub Test Description</td><td class="hide">&nbsp;</td><td class="hide">&nbsp;</td></tr></thead><tbody id="searchresulttable">';
			for(i=0;i<subTest.length;i++){
				tmp+='<tr class="'
				if(i%2 == 0)
					tmp+='odd'
				else
					tmp+='even'
				tmp+='" id="'+subTest[i][0]+'" onClick="editRecord(this,\'subTest\');">';
				tmp+='<td>'+subTest[i][1]+'</td>';
				tmp+='<td>'+subTest[i][2]+'</td>';
				tmp+='<td class="hide">'+subTest[i][3]+'</td>';
				if(subTest[i][4] == "~^"){
					tmp+='<td class="hide"></td>';	
				}
				else{
					tmp+='<td class="hide">'+subTest[i][4]+'</td>';
				}
				
				tmp+='<td class="hide">'+subTest[i][5]+'</td>';
				tmp+='<td class="hide">'+subTest[i][6]+'</td>';
				tmp+='</tr>';
			}
			tmp+='</tbody></table>'
			document.getElementById('searchresults').innerHTML = tmp;
	}
	function editSubTest(){
		if(currentRowClicked == ""){
			alert("Select a record to edit");
			return false;
		}
		else{
			id = findID(currentRowClicked)
			if(document.subTest.subTestDesc.value != ""){
			
				subTest[id][1]=document.subTest.subTestCode.value;
				subTest[id][2]=document.subTest.subTestDesc.value;
				subTest[id][3]=window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value;
				if(document.subTest.normalValue.value == ""){
					subTest[id][4] = "~^";
				}
				else{
					subTest[id][4] = document.subTest.normalValue.value;
				}
				if(document.subTest.unitOfResult.value == ""){
					subTest[id][5] = "~^";
				}
				else{
					subTest[id][5] = document.subTest.unitOfResult.value;
				}		
				subTest[id][6]=1;					
				showResults();
				document.subTest.subTestCode.value = "";
				document.subTest.subTestDesc.value = "";
				document.subTest.unitOfResult.value = "";
				document.subTest.normalValue.value = "";
			}else{
				alert(" double click on update not allowed!!!!");
			}
		}
	}
	function deleteSubTest(){
		if(currentRowClicked == ""){
			alert("Select a record to delete/undelete");
			return false;
		}
		else{
			subTest.splice((findID(currentRowClicked)),1);
			checkDelete=1;
			currentRowClicked ="";
			cnt--;
			document.subTest.subTestCode.value = "";
			document.subTest.subTestDesc.value = "";
			document.subTest.unitOfResult.value = "";
			document.subTest.normalValue.value = "";			
			showResults();
		}	
	}
	
	function findID(id){
        for(p=0;p<subTest.length;p++){
        	if(subTest[p][0] == id)
        		return p;	
        }
	}
	function doneSubTest(){
		
		window.opener.document.chargeCode.subTest.value = subTest;
		
		window.close();
	
		
	}
	
	
</script>
</head>
<body>
<div id="contentspace" style="margin-right: 0px;">
<h2>Add Sub test to Charge Code</h2>
<div id="searchresults"></div>


<br />
<br />
<form name="subTest" method="post" action=""><label><font
	id="error" color="Red">*</font> Sub Test Code:</label> <input type="text"
	name="subTestCode" value="" validate="Sub Test Code,string,yes"
	MAXLENGTH="8" /> <label><font id="error" color="Red">*</font>Sub
Test Description:</label> <input type="text" name="subTestDesc" value=""
	validate="Sub Test Description,string,yes" MAXLENGTH="30" /> <br />
<label> Normal Value:</label> <input type="text" name="normalValue"
	value="" validate="Normal Value,string,yes" /> <br />

<label>Unit Of Result:</label> <select
	name="<%= RequestConstants.UNIT_OF_RESULT%>"
	validate="Unit Of Result,string,yes">
	<option value="">Select</option>
	<%
			
				Iterator itrUnitOfMeasurementType=unitOfResultMeasurementListForSubTest.iterator();      	 
               		while(itrUnitOfMeasurementType.hasNext())
               		{
                	MasUnitOfMeasurement  unitOfMeasurement = (MasUnitOfMeasurement)itrUnitOfMeasurementType.next(); 
            %>

	<option value="<%=unitOfMeasurement.getId ()%>"><%=unitOfMeasurement.getUnitOfMeasurementCode()%>--<%=unitOfMeasurement.getUnitOfMeasurementName ()%></option>

	<%}%>


</select> <br />
<br />
<input type="hidden" name="chargeCode"
	value="window.opener.document.chargeCode.<%= RequestConstants.CHARGE_CODE_ID%>.value"
	class="hide" /> <input type="hidden" name="status" value="1"
	class="hide" /> <input type="button" name="add" value="Add"
	class="button" onClick="addSubTest()" accesskey="a" /> <input
	type="button" name="edit" value="Update" class="button"
	onClick="editSubTest()" accesskey="e" /> <input type="button"
	name="delete" value="Delete" class="button" onClick="deleteSubTest()"
	accesskey="d" /> <input type="button" name="done" value="Done"
	class="button" onClick="doneSubTest()" accesskey="o" /> <input
	type="hidden" name="subTestId" value="" /> <input type="hidden"
	name="subTest1" value="" /> <input type="hidden" name="checkDelete"
	value="" />
<div id="edited"></div>
</form>
</div>


<script type="text/javascript">
	showResults()
	formFields = [
	 			[0, "subTestId", "id"], [1,"subTestCode"], [2,"subTestDesc"],[3,"chargeCode"], [4,"normalValue"], [5,"unitOfResult"], [6,"status"] 
	 ];
	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

</body>