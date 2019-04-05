<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script>
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
   function cancelForm(){
   	   close();
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
<div class="clear"></div>
<table border="0" cellspacing="0" cellpadding="0">


	<tr>

		<th scope="col">SEX</th>
		<th scope="col">FROM AGE</th>
		<th scope="col">TO AGE</th>
		<th scope="col">MIN NORMAL VALUE</th>
		<th scope="col">MAX NORMAL VALUE</th>
		<th scope="col">NORMAL VALUE</th>

	</tr>


	<%
   Map<String, Object> map = new HashMap<String, Object>();

   int subTestId=0;
   int chargeCodeId=0;
   List<DgNormalValue> normalValueList=new ArrayList<DgNormalValue>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	if(map.get("subTestId")!=null){
		subTestId =Integer.parseInt(""+map.get("subTestId"));
	}
	if(map.get("chargeCodeId")!=null){
		chargeCodeId =Integer.parseInt(""+map.get("chargeCodeId"));
	}
	if(map.get("normalValueList")!=null){
		normalValueList =(List)map.get("normalValueList");
	}
	
	//out.print("normalValueList="+normalValueList.size());
	for(DgNormalValue dgNorm :normalValueList){
	}
	if(map.get("message") != null)
	{
	 	  String message = (String)map.get("message");
	 	  %>
	<h4><span><%=message %></span></h4>
	<%}
   %>
	<%

    	int pageNo =0;
    	int incr=((pageNo-1)*15)+1;
    	int incTemp2=incr+15;
    	if(normalValueList.size()>0){
    		for(DgNormalValue dgNorm : normalValueList){
    		 if(incr<incTemp2){
    		%> 

	<tr>


		<td width="2%"><input type="hidden" size="2"
			value="<%=subTestId %>" id="<%=SUBTEST_ID %><%=incr %>"
			name="<%=SUBTEST_ID%>" readonly="readonly" /> <input type="hidden"
			size="2" value="<%=chargeCodeId %>" id="chargeCodeId<%=incr %>"
			name="chargeCodeId" readonly="readonly" /> <input type="hidden"
			value="<%=dgNorm.getId() %>" id="<%=dgNorm.getId() %>"
			name="<%=NORMAL_ID %>" readonly="readonly" /> <select
			name="<%=SEX %>" id="f1<%=incr %>" tabindex=1
			validate="Sex,string,no">
			<option value="0">Select</option>
			<option value="n" <%=HMSUtil.isSelected(dgNorm.getSex(),"n")%>>None</option>
			<option value="m" <%=HMSUtil.isSelected(dgNorm.getSex(),"m")%>>Male</option>
			<option value="f" <%=HMSUtil.isSelected(dgNorm.getSex(),"f")%>>Female</option>
			<option value="c" <%=HMSUtil.isSelected(dgNorm.getSex(),"c")%>>Child</option>
		</select></td>

		<td width="2%">
		<%if (dgNorm.getFromAge() != null){ %> <input type="text"
			value="<%=dgNorm.getFromAge() %>" size="2" name="<%=FROM_AGE%>"
			id="f2<%=incr %>" maxlength="3" validate="From Age,int,no" tabindex=1 />
		<%} else{%> <input type="text" value="" size="2" name="<%=FROM_AGE%>"
			id="f2<%=incr %>" maxlength="3" validate="From Age,int,no" tabindex=1 />
		<%} %>
		</td>

		<td width="2%">
		<%if (dgNorm.getToAge() != null){ %> <input type="text"
			value="<%=dgNorm.getToAge() %>" size="2" name="<%=TO_AGE%>"
			id="f3<%=incr %>" maxlength="3" validate="From Age,int,no" tabindex=1 />
		<%} else{%> <input type="text" value="" size="2" name="<%=TO_AGE%>"
			id="f2<%=incr %>" maxlength="3" validate="To Age,int,no" tabindex=1 />
		<%} %>
		</td>

		<td width="2%">
		<%if (dgNorm.getMinNormalValue() != null){ %> <input type="text"
			value="<%=dgNorm.getMinNormalValue() %>" size="2"
			name="<%=MIN_NORMAL_VALUE%>" id="f4<%=incr %>" maxlength="10"
			validate="Min Normal Value,float,no" tabindex=1 onblur="checkMinValue(<%=incr %>);"/> <%}else{ %> <input
			type="text" value="" size="2" name="<%=MIN_NORMAL_VALUE%>"
			id="f4<%=incr %>" maxlength="10" validate="Min Normal Value,float,no"
			tabindex=1 onblur="checkMinValue(<%=incr %>);"/> <%} %>
		</td>
		<td width="2%">
		<%if (dgNorm.getMaxNormalValue() != null){ %> <input type="text"
			value="<%=dgNorm.getMaxNormalValue() %>" size="2"
			name="<%=MAX_NORMAL_VALUE%>" id="f5<%=incr %>" maxlength="10"
			validate="Max normal Value,float,no" tabindex=1 onblur="checkMinValue(<%=incr %>);"/> <%}else{ %> <input
			type="text" value="" size="2" name="<%=MAX_NORMAL_VALUE%>"
			id="f5<%=incr %>" maxlength="10" validate="Min Normal Value,float,no"
			tabindex=1 onblur="checkMinValue(<%=incr %>);"/> <%} %>
		</td>
		<td width="2%">
		<%if (dgNorm.getNormalValue() != null){ %> <input type="text"
			value="<%=dgNorm.getNormalValue() %>" size="20"
			name="<%=NORMAL_VALUE%>" id="f6<%=incr %>" maxlength="200" onblur="checkNormalValue(<%=incr %>);"
			validate="Normal Value,string,no" tabindex=1 /> <%}else{ %> <input
			type="text" value="" size="20" name="<%=NORMAL_VALUE%>"
			id="f6<%=incr %>" maxlength="10" validate="Normal Value,string,no" onblur="checkNormalValue(<%=incr %>);"
			tabindex=1 /> <%} %>
		</td>
		<%}
incr++;
}%>


		<%}%>

	</tr>


</table>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Submit"
	class="button"
	onclick="submitForm('normal','investigation?method=updateNormalValue');"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onclick="cancelForm();"
	accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
