<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.TemplateApplication"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%
	
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List<Object> grpAppList= new ArrayList<Object>();
		 grpAppList = (List<Object>) map.get("grpAppList");
		 System.out.println("grpAppList.size()in jsp     "+grpAppList.size());
		 int j=0;
		   for (int i=0;i<grpAppList.size();i++){%>
<input type="hidden" value="<%=grpAppList.get(i) %>"
	name="grpAppId<%=i %>" />
<% j++; }%>
<input type="hidden" name="counter" value="<%=j %>" />

<% List<Object> usrGrpHospList= new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		 System.out.println("usrGrpHospList.size()in jsp     "+usrGrpHospList.size());
		 int m=0;
		   for (int n=0;n<usrGrpHospList.size();n++){%>
<input type="hidden" value="<%=usrGrpHospList.get(n) %>"
	name="userGrpId<%=n%>" />
<% m++; }%>
<input type="hidden" name="counter" value="<%=m %>" />
<%
		 
		 
		List<TemplateApplication> tempAppList= new ArrayList<TemplateApplication>();
		if (map.get("tempAppList") != null)
			tempAppList =(List<TemplateApplication>)map.get("tempAppList");
		
		%>

<link href="css/hms_style.css" rel="stylesheet" type="text/css" />

<div id="contentHolder">

<div class="division"></div>

<div class="tableHholderCmnLarge2"
	style="width: 700px; height: 300px; float: left;"><label
	class="bodytextB_blue" style="width: 130px;">Application Name :</label>

<select name="<%=APPLICATION_ID %>" class="large">
	<option value="">Select</option>

	<%
				Iterator<TemplateApplication> iter=tempAppList.iterator();
				
				while(iter.hasNext()){
			    	TemplateApplication tempApp= (TemplateApplication) iter.next();
					String appId=tempApp.getApp().getId();
			%>
	<option value=<%=appId%>><%=tempApp.getApp().getName()%></option>

	<%	
			}
				%>


</select>
<tbody id="searchresulttable">
</tbody>

</div>
</div>

<div class="division"></div>


<input type="hidden" id="chkStatus" value="no" />

<div class="Clear"></div>
<br />
<br />
<!-- </form> -->





