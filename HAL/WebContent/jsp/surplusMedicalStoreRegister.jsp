
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=surplusMedicalStore";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
	
	Map map = new HashMap();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");	
    }
	
	Map<String, Object> surplusMedicalStoreItem = new HashMap<String, Object>();
	if (map.get("surplusMedicalStoreItem") != null) {
		
		surplusMedicalStoreItem = (Map<String, Object>)map.get("surplusMedicalStoreItem");
		System.out.println("in not null");
		
	}
	List objectList = new ArrayList();
	List objectList1 = new ArrayList();
		if (surplusMedicalStoreItem.get("objectList") != null) {
			objectList = (List)surplusMedicalStoreItem.get("objectList");
			System.out.println("objectList in jsp "+objectList.size());

		}
		
		
		String message ="";
		
		if (surplusMedicalStoreItem.get("msg") != null) {
		             message = (String) surplusMedicalStoreItem.get("msg");
		             
		      }
		if(!message.equalsIgnoreCase("")){
		%>
		<h4><%=message %></h4>
		<%} %>

<form name="surplusMedicalStore" method="post" action="">
<div class="titleBg">
<h2>Surplus Medical Store Register</h2>
</div>
<div class="Block">
<label> From Date  <span>*</span></label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>" class="textbox_date" MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.surplusMedicalStore.<%=FROM_DATE%>,event)" />
<label> To Date <span>*</span></label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate%>" class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.surplusMedicalStore.<%=TO_DATE%>,event)" />
<div class="clear"></div>

</div> 
<div class="clear"></div>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('surplusMedicalStore','stores?method=generateSurplusMedicalStoreRegister&flag=j');" accesskey="a" tabindex=1 />
<!-- <input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('surplusMedicalStore','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />-->  
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('surplusMedicalStore');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<%if(objectList.size()>0){%>
<div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">      
<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Declared Vide With Date</th>
			<th>Authority for Issue With Date</th>
			<th>PVMS No.</th>
			<th>Nomenclature</th>
			<th>A/U </th>
			<th >Qty</th>
			<th >Batch No</th>	
			<th >DOM</th>	
			<th >DOE</th>
			<th>Ex IV No</th>
			<th>Address</th>
			<th>Demand No.</th>            
			<th>RV No.</th> 
			<th >Remark</th>		
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		%>
		
	
<tr>
<td><%=++count%></td>
<%if(object[0] != null) {%>
<td ><div class="calcell"><%=object[0]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[1] != null) {%>
<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<td ><div class="calcell"><%=object[10]%></div></td>
<%if(object[9] != null) {%>
	<td ><div class="calcell"><%=object[9]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<td><div class="calcell"><%=object[12]%></div></td>
<td ><div class="calcell"><%=object[5]%></div></td>
<td ><div class="calcell"><%=object[6]%></div></td>
<%if(object[8] != null) {%>
	<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[8])%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	
	<%if(object[7] != null) {%>
	<td ><div class="calcell"><%=HMSUtil.changeDateToddMMyyyy((Date)object[7])%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[13] != null) {%>
	<td ><div class="calcell"><%=object[13]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[3] != null) {%>
	<td ><div class="calcell"><%=object[3]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	<td ><div class="calcell"><%= "RV"%></div></td>

<%if(object[11] != null) {%>
	<td ><div class="calcell"><%=object[11]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
</tr>
</tr>
<%}%>
</table>
</div>







<%	
}
%>







