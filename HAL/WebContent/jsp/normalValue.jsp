
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> 
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<form name="normal" method="post" action=""><script>

function setVar(rowNo){

  		var sex="sex";
   		var fromAge="fromAge";
   		var toAge="toAge";
    	var minNormalValue="minNormalValue";
    	var maxNormalValue ="maxNormalValue";
    	var normalValue ="normalValue";

    	var sex2="sex";
    	sex=sex2+(rowNo);

    	var fromAge2="fromAge";
    	fromAge=fromAge2+(rowNo);

    	var toAge2="toAge";
    	toAge=toAge2+(rowNo);

    	var minNormalValue2="minNormalValue";
    	minNormalValue=minNormalValue2+(rowNo);

    	var maxNormalValue2="maxNormalValue";
    	maxNormalValue=maxNormalValue2+(rowNo);

    	var normalValue2="normalValue";
    	normalValue=normalValue2+(rowNo);

    	 var j;
    	for(j=1;j<=5;j++){
    	if(document.getElementById('f1'+j).value != ""){
     	window.opener.document.getElementById(sex+j).value = document.getElementById('f1'+j).value;
     	}else{
     	window.opener.document.getElementById(sex+j).value="";
     	}

     	if(document.getElementById('f2'+j).value != ""){
	 	window.opener.document.getElementById(fromAge+j).value = document.getElementById('f2'+j).value;
	 	}else{
	 	window.opener.document.getElementById(fromAge+j).value ="";
	 	}

	 	if(document.getElementById('f3'+j).value != ""){
	   	window.opener.document.getElementById(toAge+j).value = document.getElementById('f3'+j).value;
	  	 }else{
	   	window.opener.document.getElementById(toAge+j).value="";
	   	}

	    if(document.getElementById('f4'+j).value != ""){
	   window.opener.document.getElementById(minNormalValue+j).value = document.getElementById('f4'+j).value;
	   }else{
	   window.opener.document.getElementById(minNormalValue+j).value="";
	   }

	   if(document.getElementById('f5'+j).value != ""){
	   window.opener.document.getElementById(maxNormalValue+j).value = document.getElementById('f5'+j).value;
	   }else{
	   window.opener.document.getElementById(maxNormalValue+j).value="";
	   }

	   if(document.getElementById('f6'+j).value != ""){
	   window.opener.document.getElementById(normalValue+j).value = document.getElementById('f6'+j).value;
	   }else{
	   window.opener.document.getElementById(normalValue+j).value="";
	   }
	    }
     close();
   }

  function resetForm(){
  var j;
  for(j=1;j<=5;j++){
	   document.getElementById('f1'+j).value="0";
	   document.getElementById('f2'+j).value="";
	   document.getElementById('f3'+j).value="";
	   document.getElementById('f4'+j).value="";
	   document.getElementById('f5'+j).value="";
	   document.getElementById('f6'+j).value="";
	    }
   }
   function cancelForm(){
   	   close();
   }

function inputValue(){
   var j;
   for(j=1;j<=5;j++){

    if(document.getElementById('f1'+j).value != "0"){
    break;
    }
 else{
          alert("Please select Sex")
 }
    }
    return true;

   }

</script>
<input type="hidden" id="amcTDetailsListSize"
	name="amcTDetailsListSize" value="1" />
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th></th>
			<th>SEX</th>
			<th>FROM AGE</th>
			<th>TO AGE</th>
			<th>MIN NORMAL VALUE</th>
			<th>MAX NORMAL VALUE</th>
			<th>NORMAL VALUE</th>

		</tr>
	</thead>
	<tbody>
		<%
   Map<String, Object> map = new HashMap<String, Object>();

   int subTestId=0;
   int chargeCodeId=0;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>)request.getAttribute("map");
	}

	if(map.get("subTestId")!=null){
		subTestId =Integer.parseInt(""+map.get("subTestId"));
	}
	if(map.get("chargeCodeId")!=null){
		chargeCodeId =Integer.parseInt(""+map.get("chargeCodeId"));
	}
	if(map.get("message") != null)
	{
	 	  String message = (String)map.get("message");
	 	  %>
		<h4><span><%=message %></span></h4>
		<%}%>
		<%
    	int incr = 0;
    	for(incr=1;incr<=1;incr++){
   %>
		<div class="clear"></div>
		<tr>

		<td><input type="checkbox" value="<%=incr%>" name="selectedChrage" class="radioCheck" /></td>
			<td width="2%"><input type="hidden" size="2"
				value="<%=subTestId %>" id="<%=SUBTEST_ID %><%=incr %>"
				name="<%=SUBTEST_ID%>" readonly="readonly" /> <input type="hidden"
				size="2" value="<%=chargeCodeId %>" id="chargeCodeId<%=incr %>"
				name="chargeCodeId" readonly="readonly" /> <select name="<%=SEX %>"
				id="f1<%=incr %>" tabindex=1>
				<option value="">Select</option>
				<option value="n" selected="selected">None</option>
				<option value="m">Male</option>
				<option value="f">Female</option>
				<!-- -
				<option value="c">Child</option>
				 -->
			</select></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=FROM_AGE%>" id="f2<%=incr %>" maxlength="3" tabindex=1  /></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=TO_AGE%>" id="f3<%=incr %>" maxlength="3" tabindex=1 /></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=MIN_NORMAL_VALUE%>" id="f4<%=incr %>" maxlength="10"
				tabindex=1 onblur="checkMinValue(<%=incr %>);"/></td>
			<td width="2%"><input type="text" value="" size="2"
				name="<%=MAX_NORMAL_VALUE%>" id="f5<%=incr %>" maxlength="10"
				tabindex=1 onblur="checkMinValue(<%=incr %>);"/></td>
			<td width="2%"><input type="text" value="" size="20"
				name="<%=NORMAL_VALUE%>" id="f6<%=incr %>" maxlength="100" tabindex=1 />
			</td>
			<%} %>

		</tr>
	</tbody>

</table>
<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();"
			<%--onclick="generateRowWithoutSrNo('chargeDetails');"--%> tabindex="1" />
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Submit"
	class="button"
	onclick="submitForm('normal','investigation?method=submitNormalValues');"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="buttonHighlight"
	onclick="resetForm();" accesskey="a" tabindex=1 /> <input
	type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onclick="cancelForm();" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>

<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	document.getElementById('amcTDetailsListSize').value=lastRow

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('amcTDetailsListSize');

	var iteration = parseInt(hdb.value);

	hdb.value = iteration;
	var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

		var cell1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name = "<%=SEX %>";
		e1.id = 'f1'+(iteration);
		e1.options[0] = new Option('Select', '');
		e1.options[1] = new Option('None', 'n',"selected");
		e1.options[2] = new Option('Male', 'm');
		e1.options[3] = new Option('Female', 'f');
		e1.options[4] = new Option('Child', 'c');
		cell1.appendChild(e1);

		var cell2 = row.insertCell(2);
		var e2 = document.createElement('input');
		e2.type = 'text';
		e2.size='2';
		e2.name="<%=FROM_AGE%>";
		e2.id = 'f2'+(iteration)
		e2.tabIndex="1";

		cell2.appendChild(e2);


		var cell3 = row.insertCell(3);
		var e3 = document.createElement('input');
		e3.type = 'text';
		e3.name="<%=TO_AGE%>";
		e3.id = 'f3'+(iteration);
		e3.size='2';
		e3.tabIndex="1";
		cell3.appendChild(e3);



		var cell4 = row.insertCell(4);
		var e4 = document.createElement('input');
		e4.type = 'text';
		e4.name="<%=MIN_NORMAL_VALUE%>";
		e4.id = 'f4'+(iteration);
		e4.size='2';
		e4.tabIndex="1";
		e4.onblur = function()
					{
						checkMinValue(iteration);
					};
		cell4.appendChild(e4);



		var cell5 = row.insertCell(5);
		var e5 = document.createElement('input');
		e5.type = 'text';
		e5.name="<%=MAX_NORMAL_VALUE%>";
		e5.id = 'f5'+(iteration);
		e5.size='2';
		e5.tabIndex="1";
		e5.onblur = function()
					{
						checkMinValue(iteration);
					};
		cell5.appendChild(e5);


		var cell6 = row.insertCell(6);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name="<%=NORMAL_VALUE%>";
		e6.id = 'f6'+(iteration);
		e6.size='20';
		e6.tabIndex="1";
		e6.onblur = function()
					{
						
					};
		cell6.appendChild(e6);

	}
function removeRow()
	{
		var tbl = document.getElementById('chargeDetails');
		var lastRow=document.getElementById('amcTDetailsListSize').value;
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
			  	document.getElementById('amcTDetailsListSize').value=parseInt(lastRow)-1;
			}
		}
	}

 function checkFilledRow()
{
	var count=document.getElementById('amcTDetailsListSize').value;

	var msg ="";


	  	for(var i=1;i<=count;i++){

	  	 if(document.getElementById('f1'+i).value!= ""){
	  	 	if(document.getElementById('f2'+i).value!= ""){
	  	 		if(document.getElementById('f3'+i).value != ""){




		  			if(msg != ""){
		  				break;
		  			}

		  			}


	  		}

	  		}
	  		else
	  		{
	  		msg += "please Select Sex.\n";
	  		document.getElementById('f1'+i).focus();

	  		}

	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}

	}
	function checkNum(id)
	{

	  var s_len=document.getElementById(id).value.length ;
  	var s_charcode = 0;
	    for (var s_i=0;s_i<s_len;s_i++)
	    {
     		s_charcode =document.getElementById(id).value.charCodeAt(s_i);
     	if(!((s_charcode>=48 && s_charcode<=57)))
      	{
        	 alert("Only Numeric Values Allowed");
          document.getElementById(id).value='';
         	document.getElementById(id).focus();
        return false;
      	}
    	}
    return true;
 }

 function checkNormalValue(incr)
	{

 		var minNormalValue=document.getElementById('f4'+incr).value;
 		var maxNormalValue=document.getElementById('f5'+incr).value;
 		var normalValue=document.getElementById('f6'+incr).value;
 		if(normalValue!="")
 		{
 		document.getElementById('f4'+incr).disabled = true;
 		document.getElementById('f5'+incr).disabled = true;
 		return true;
 		}

 	 	else{
 	 	document.getElementById('f4'+incr).disabled = false;
 		document.getElementById('f5'+incr).disabled = false;
 	 		return true;
 	 		}

 	 }


 	 function checkMinValue(incr)
	{

 		var minNormalValue=document.getElementById('f4'+incr).value;
 		var maxNormalValue=document.getElementById('f5'+incr).value;
 		var normalValue=document.getElementById('f6'+incr).value;
 		if(minNormalValue!="" || maxNormalValue)
 		{
 		document.getElementById('f6'+incr).disabled = true;
 		return true;
 		}

 	 	else{
 	 	document.getElementById('f6'+incr).disabled = false;

 	 		return true;
 	 		}

 	 }

 </script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
