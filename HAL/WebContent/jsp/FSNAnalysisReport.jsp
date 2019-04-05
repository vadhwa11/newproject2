
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="java.math.BigInteger"%>
<%@page import="java.math.BigDecimal"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
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
  obj.action = "/hms/hms/stores?method=fsnAnalysisReport";
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

Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> fsnItem = new HashMap<String, Object>();
String fsnType="";
String flag="";

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");

}
if (map.get("fsnType") != null) {
	
	fsnType = (String)map.get("fsnType");
}
if (map.get("fsnItem") != null) {
	fsnItem = (Map<String, Object>)map.get("fsnItem");
}
if (map.get("flag") != null) {
	
	flag = (String)map.get("flag");
}
List objectList = new ArrayList();
if (fsnItem.get("objectList") != null) {
	objectList = (List)fsnItem.get("objectList");

}
String message ="";
if (fsnItem.get("msg") != null) {
             message = (String) fsnItem.get("msg");
      }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>
<% 
if(flag.equalsIgnoreCase("e")){

}%>

<form name="fsnAnalysis" method="post" action="">
<div class="titleBg">
<h2>FSN Analysis Report</h2>
</div>
<div class="Block">


<label >Type</label> 
<select name="fsnType" id="fsnType" tabindex=1 validate="FSN Type,String,yes">
	<option value="a">Select</option>
	<option value="f">Fast</option>
	<option value="n">Non Moving</option>
	<option value="s">Slow</option>

	</select>
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('fsnAnalysis','stores?method=fsnAnalysisJspReport&flag=j&fsnType='+document.getElementById('fsnType').value);" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Export to Excel" class="buttonBig" onClick="submitForm('fsnAnalysis','stores?method=fsnAnalysisJspReport&flag=e');" accesskey="a" tabindex=1 />
<input type="button" name="print"  value="Print" class="button" onClick="submitForm('fsnAnalysis','stores?method=printfsnAnalysisJspReport&fsnType='+document.getElementById('fsnType').value);" accesskey="a" tabindex=1 />
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" value="<%=fsnType %>" name="fsnTypeValue" id="fsnTypeValue"/>
</form>
<% int f=0; 
int s=0;
int nm=0;
int af=0; 
int as=0;
int anm=0;

%>
<%if(objectList.size()>0 && flag.equals("j")){ %>
<%if(fsnType.equals("f")) {%>
<h2>FAST MOVING ITEM</h2>
<%}else if(fsnType.equals("s")) {  %>
<h2>SLOW MOVING ITEM</h2>
<%}else if(fsnType.equals("n")) {  %>
<h2>NON MOVING ITEM</h2>
<%} %>

<div STYLE=" height:416px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="cmntableWithHeight">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS/ NIV No.</th>
			<th>Nomenclature</th>
			<th>A/ U</th>
			<th>MMF Qty</th>            
	    	<th >Consumption Qty</th>
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); 
		iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		
		%>
		
		<tr>
<td><%=++count%></td>
<%if(fsnType.equals("n")){ %>
<td ><div class="calcell"><%=object[3]%></div></td>
<%}else{ %>
<td ><div class="calcell"><%=object[4]%></div></td>
<%} %>
<%if(fsnType.equals("n")){ %>
<td ><div class="calcell"><%=object[2]%></div></td>
<%}else{ %>
<td ><div class="calcell"><%=object[3]%></div></td>
<%} %>

<%if(fsnType.equals("f") ) {%>
<td ><div class="calcell"><%=object[8]%></div></td>
	<%}else if(fsnType.equals("s") ){ %>
	<td ><div class="calcell"><%=object[8]%></div></td>
	<%}else{ %>
	<td ><div class="calcell"><%=object[4]%></div></td>
<%} %>
<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[6] != null) {%>
	<td ><div class="calcell"><%=object[6]%></div></td>
	<%}else{ %>
	<td ><div class="calcell"><%="0"%>  </div></td>
	<%} %>


</tr>
	
<%} %>
	</table>
</div>

<%	
}
%>
