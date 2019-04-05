<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDietMenuItem"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<!--Main div starts-->
<div id="contentHolder">
<form name="breakfastDistribution" method="post" action="">

<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> wardWiseStrengthList = new ArrayList<Object[]>();
	List<MasDietMenuItem> menuItemlist = new ArrayList<MasDietMenuItem>();
	List<Object[]> wardWiseEggQtyList = new ArrayList<Object[]>();
	List<Object[]> wardListForBread = new ArrayList<Object[]>();
	List<Object> cDietPatientList = new ArrayList<Object>();
	List<Object> diabeticPatientList = new ArrayList<Object>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("wardWiseStrengthList") != null){
		wardWiseStrengthList = (List<Object[]>)map.get("wardWiseStrengthList");
	}
	if(map.get("menuItemlist") != null){
		menuItemlist = (List<MasDietMenuItem>)map.get("menuItemlist");
	}
	if(map.get("wardWiseEggQtyList") != null){
		wardWiseEggQtyList = (List<Object[]>)map.get("wardWiseEggQtyList");
	}
	if(map.get("wardListForBread") != null){
		wardListForBread = (List<Object[]>)map.get("wardListForBread");
	}
	if(map.get("cDietPatientList") != null){
		cDietPatientList = (List<Object>)map.get("cDietPatientList");
	}
	if(map.get("diabeticPatientList") != null){
		diabeticPatientList = (List<Object>)map.get("diabeticPatientList");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	
	String time = (String)utilMap.get("currentTime");	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>

<div class="Clear"></div>

<h6>Breakfast Distribution: Patient Mess</h6>
<div class="blockFrame">

<label> Date:</label>
<input type="text" name="<%=DATE %>" value="<%=currentDate %>" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.breakfastDistribution.<%=DATE%>,event)"/> 
<label> Breakfast Item:</label>
<select name="<%=ITEM_ID %>" validate="Breakfast Item,string,yes" onchange="submitProtoAjax('breakfastDistribution','diet?method=getItemQtyForBreakfast&totalPatient='+total+'&totalEggQty='+totalEggQty);">
<option value="0">Select</option>
<%
	for(MasDietMenuItem dietMenuItem : menuItemlist){
%>
<option value="<%=dietMenuItem.getDietItems().getId() %>"><%=dietMenuItem.getDietItems().getDietItemsName() %></option>
<%} %>
</select>

</div>

<div class="division"></div>

<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>Ward</th>
    <th>Strength</th>
    <th>Eggs</th>
   </tr>
   <%
   int total =0;
   int eggCount = 0;
   String deptName = "";
   int qty = 0;
   int eggQty = 0;
   int totalEggs = 0;
   	if(wardWiseStrengthList.size() > 0){
   		Integer count = 0;
   		String department = "";
   		for(Object[] obj : wardWiseStrengthList){
   		  int wardWiseTotalEggs =0;
   			count = Integer.parseInt(obj[0].toString());
   			department = (String)obj[1];
   			total = total+count;
   			for(Object[] object : wardWiseEggQtyList){
   				eggCount = Integer.parseInt(object[0].toString());
   				deptName = (String)object[1];
   			 	qty = ((BigDecimal)object[2]).intValueExact();
   			 	if(department.equals(deptName) 
   			 			&& ((String)object[3]).equals("Other") && ((String)object[4]).equals("W")){
	   					eggQty = eggCount*qty;
	   					wardWiseTotalEggs = wardWiseTotalEggs+eggQty;
   				}
   			}
   			totalEggs = totalEggs + wardWiseTotalEggs;
   %>
   <tr>
   <td><%=department %></td>
   <td><%=count %></td>
   <td><%=wardWiseTotalEggs %></td>
   </tr>
   <%}
   		}%>
   <tr> 
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 </tr>
   <tr>
 	<td>Total</td>
   	<td><%=total %></td>
   	<td><%=totalEggs %></td>
 </tr>
 
 <tr> 
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 </tr>
 
 	<tr>
   	<td>C-Diet</td>
   	<%
   		if(cDietPatientList != null && cDietPatientList.size() > 0){
   	%>
   	<td><%=Integer.parseInt(cDietPatientList.get(0).toString())%></td>
   	<%}else{ %>
   	<td>&nbsp;</td>
   	<%} %>
   	<td>&nbsp;</td>
   	</tr>  
  
   	<tr>
   	<td>Diabetic</td>
   	<%
   		if(diabeticPatientList != null && diabeticPatientList.size() > 0){
   	%>
   	<td><%=Integer.parseInt(diabeticPatientList.get(0).toString()) %></td>
   	<%}else{ %>
   	<td>&nbsp;</td>
   	<%} %>
   	<td>&nbsp;</td>
   	</tr>  
   	 	
 
</table>
</div>

<div id="testDiv">

</div>
<script type="text/javascript">
	var total = <%=total%>;
	var totalEggQty = <%=totalEggs%>
</script>

<div class="division"></div>

<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>Ward</th>
    <th>Bread</th>
    <th>Eggs</th>
   </tr>
 <%
 	int totalBreadQty = 0;
   
 	for(Object[] ob : wardListForBread){
 		int wardWiseTotalEggs =0;
 		int noOfPatients = Integer.parseInt(ob[0].toString());
 		String dept = (String)ob[1];
 		int breadQty = noOfPatients/3;
 		int rem = noOfPatients%3;
 		if(rem > 0){
 			breadQty = breadQty+1; 
 		}
 			totalBreadQty = totalBreadQty+breadQty;
 		
 		
 		for(Object[] object : wardWiseEggQtyList){
				eggCount = Integer.parseInt(object[0].toString());
				deptName = (String)object[1];
			 	qty = ((BigDecimal)object[2]).intValueExact();
			 	if(dept.equals(deptName) 
			 			&& ((String)object[3]).equals("Officer")){
   					eggQty = eggCount*qty;
   					wardWiseTotalEggs = wardWiseTotalEggs+eggQty;
				}
			}
			totalEggs = totalEggs + wardWiseTotalEggs;
 %>
 
   <tr>
  <td><%= dept%>
  <input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%= (Integer)ob[2]%>">
  </td>
 <td><%=breadQty %>
   <input type="hidden" name="breadQty" value="<%=breadQty%>">
 </td>
 <td><%=wardWiseTotalEggs %>
 <input type="hidden" name="eggQty" value="<%=wardWiseTotalEggs%>">
 </td>
   </tr>
   <%} %>
   <td>Total</td>
   	<td><%=totalBreadQty %></td>
   	<td><%=totalEggs %></td>
 </tr>
 
</table>
</div>
<div class="Clear"></div>
<input type="button" class="button" name="Submit" value="Save" onclick="submitForm('breakfastDistribution','diet?method=saveBreakastDistributionDetails');"/>
<input type="reset" class="button" name="reset" value="Reset" /> 
<div class="Clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date </label>
<label class="value"><%=currentDate %></label>

<label>Changed time </label>
<label class="value"><%=time %></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate %>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time %>" />



</div>

<div class="Height10"></div>
<!--main div ends-->
</form>
</div>
