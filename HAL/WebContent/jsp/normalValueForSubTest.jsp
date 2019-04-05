
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>

<div id="contentHolder">
<form name="normal" method="post" action="">


<div class="tableHolderAuto">
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th>SEX</th>
			<th>FROM AGE</th>
			<th>TO AGE</th>
			<th>NORMAL VALUE</th>

		</tr>
	</thead>
	<tbody>
		<%
   Map<String, Object> map = new HashMap<String, Object>();
   int rowNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("rowNo")!=null){
		rowNo =Integer.parseInt(""+map.get("rowNo"));
		System.out.println("ROW IN JSP  "+rowNo);
	}
   %>
		<%
    	int detailCounter=5; 
    	int temp=0;
    	int incr = 0;    	
    
    	for(incr=1;incr<=5;incr++){
    		%>

		<tr>


			<td width="2%"><input type="hidden" size="2"
				value="<%=temp+incr%>" id="<%=SR_NO %><%=incr %>" name="<%=SR_NO%>"
				readonly="readonly" /> <select name="<%=SEX %>" id="f1<%=incr %>"
				tabindex=1 validate="Sex,string,yes">
				<option value="0">Select</option>
				<option value="n">None</option>
				<option value="m">Male</option>
				<option value="f">Female</option>
				<option value="c">Child</option>
			</select></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=FROM_AGE%>" id="f2<%=incr %>" maxlength="3"
				validate="From Age,int,no" tabindex=1 /></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=TO_AGE%>" id="f3<%=incr %>" maxlength="3"
				validate="From Age,int,no" tabindex=1 /></td>

			<td width="2%"><input type="text" value="" size="2"
				name="<%=NORMAL_VALUE%>" id="f4<%=incr %>" maxlength="3"
				validate="From Age,int,no" tabindex=1 /></td>
			<%} %>

		</tr>
	</tbody>

</table>
</div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Submit" class="button" onClick="setVar(<%=rowNo%>);"
	accesskey="a" tabindex=1 /> <input type="button" name="reset"
	id="addbutton" value="Reset" class="button" onClick="resetForm();"
	accesskey="a" tabindex=1 /> <input type="button" name="cancel"
	id="addbutton" value="Cancel" class="button" onClick="cancelForm();"
	accesskey="a" tabindex=1 /></div>
</form>
</div>