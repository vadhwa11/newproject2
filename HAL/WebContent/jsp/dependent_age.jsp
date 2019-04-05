<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasDivision"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasDivision> divisionList = new ArrayList<MasDivision>();
if(map.get("divisionList") != null){
	divisionList = (List<MasDivision>)map.get("divisionList");
	session.setAttribute("divisionList", divisionList);
}

%>

<script>

function validateVal(){
	var fromAge=document.getElementById('fromAge').value;
	var toAge=document.getElementById('toAge').value;
	if(fromAge!="" && toAge!="" )
		{
		if(fromAge>toAge){
			alert(" From Age  cannot be greater than  To Age ");
			return false;
		}
		
		}
	return true;
}
</script>
<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Dependent Age Report</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Age From <span>*</span> </label>
<input type="text" id="fromAge" name="fromAge" value=""	 MAXLENGTH="30"	 validate="Age From,int,yes"  onblur="validateVal();"/>


<label>Age To <span>*</span>  </label>
<input type="text" id="toAge" name="toAge" value=""	 MAXLENGTH="30"	 validate="Age To,int,yes" onblur="validateVal();" />
<label>Division</label> 
		<select id="divisionId" 	name="divisionId" validate="Division,string,no" >
			<option value="0">Select</option>

			<%
				         		if(divisionList != null){ 	
				         			for (Iterator iter = divisionList.iterator(); iter.hasNext();) {
				         				MasDivision division = (MasDivision) iter.next();
				         %>
			<option value="<%=division.getId() %>"><%=division.getDivisionName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
	
</div>



<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Print" class="button" onClick="submitForm('search','personnel?method=printDependentAgeReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





