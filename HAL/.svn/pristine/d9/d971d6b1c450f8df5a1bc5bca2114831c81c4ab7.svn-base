<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.MathContext"%>
<%@page import="jkt.hms.masters.business.AvPilotRegistrationHd"%>
<%@page import="jkt.hms.masters.business.AvPilotRegistrationDt"%>



<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<script type="text/javascript" language="javascript">

function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

</script>
<%
Map map = new HashMap();
String choice = "";
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}


int numberOfRecordsInLoanIn = 0;
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");



%>


<div id="gridDiv">
<div class="Clear"></div>
<h4>Pilot Details</h4>
<div class="Clear"></div>
<div class="cmntableWithHeight">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridService">
		
<tr>
<th scope="col"></th>
<th>Service No.</th>
<th>Rank</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Unit</th>
<th>Sortie of the Day</th>
<th>Visual Inspection</th>
<th>Category</th>
<th>Photo</th>
<th></th>
<th></th>
</tr>
		
		<%
	
 		int noOfRows = 0;

	    int inc = 0;
		List<AvPilotRegistrationDt> pilotRegDtList= new ArrayList<AvPilotRegistrationDt>();
        List<AvPilotRegistrationHd> pilotRegHdList= new ArrayList<AvPilotRegistrationHd>();
 		if (map.get("pilotRegistrationList")!=null)
	    {
 			pilotRegDtList = (List) map.get("pilotRegistrationList");
	    	noOfRows = pilotRegDtList.size();
	    }
 		if (map.get("pilotRegHdList")!=null)
	    {
 			pilotRegHdList = (List) map.get("pilotRegHdList");
	    }
 		System.out.println("pilotRegHdList-->"+pilotRegHdList.size());
 		System.out.println("pilotRegistrationList-->"+pilotRegDtList.size());
 		List<Category> categoryList = new ArrayList<Category>();
 		if(map.get("categoryList") != null)	{
 			categoryList = (List<Category>)map.get("categoryList");
 		}
 		
	   	if (pilotRegDtList != null && pilotRegDtList.size()>0)
	    {
	   		int rowLenSize=pilotRegDtList.size();
    		 for(AvPilotRegistrationDt avDt : pilotRegDtList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
			<td width="5%">
			<input type="text" size="1" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<%if(avDt.getServiceNo()!=null){ %>
			<input type="text"	value="<%=avDt.getServiceNo() %>" tabindex="1"	name="<%=SERVICE_NO %>" size="6" id="<%=SERVICE_NO+""+inc%>" />
			<%}else{ %>
			<input	type="text" value=" "  name="<%=SERVICE_NO %>" size="6"	tabindex="1" id="<%=SERVICE_NO+""+inc%>" />
			<%} %>
			<input type="hidden" name="<%=DETAIL_ID %>"	value="<%=avDt.getId() %>" id="hdb" />
			<input type="hidden" value="<%=avDt.getAvPilotRegistrationHd().getId()%>" name="avHtId<%=inc%>" id="avHtId<%=inc%>" />
								</td>

	
			<td width="25%"><input type="text"	value="<%=avDt.getFullName()%>" name="pilotName<%=inc%>" class="medcaption"	readonly="readonly" size="9"/></td>
		
			<td width="25%"><input type="text" value="<%=avDt.getRank().getRankName()%>"  name="rank<%=inc%>" class="medcaption" readonly="readonly" size="9"/></td>
			
			<td width="25%"><input type="text" value="<%=avDt.getAge()%>" name="age<%=inc%>" class="medcaption"readonly="readonly" size="9"/>	
				<input type="hidden" value="<%=avDt.getId()%>" name="pilot_dt_id<%=inc%>"	class="medcaption" readonly="readonly" /></td>
			
			
			<%if(avDt.getCategory()!=null){ %>
			<td width="10%"> 
			<input type="text"	value="<%=avDt.getCategory().getCategories()%>" class="medcaption" name="<%=MED_CAT%><%=inc%>" readonly="readonly"  size="9"/></td>	
			
			<%}else{ %>
		<%

			int cId = 0;
		
			String categoryName = "";
		
		   	if (categoryList != null && categoryList.size()>0)
		    {
		   	 for(Category category : categoryList){
	    			
		   		categoryName = category.getCategories();
	    				 cId = category.getCategoryid();
	    			
	    			 }
	    		 }
	    	

			%>
			
	
			
			<td width="10%">
			<select name="cat<%=inc%>" tabindex="1" id="cat<%=inc%>" tabindex="1" >
				<option value="<%=cId%>"><%=categoryName%></option>
			</select>
			</td>
			<%} %>
			
			<input type="hidden" value="<%=avDt.getAvPilotRegistrationHd().getId()%>" name="pilot_hd_id<%=inc%>"  id="pilot_hd_id<%=inc%>" class="medcaption"	readonly="readonly" />	
			
<td><input type="file" name="<%=UPLOAD_FILENAME %><%=inc %>" id="fileNameId<%=inc %>" class="browse"></td>
	

			
	<td>
<input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('gridService');" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('gridService','hdb',this);" tabindex="1" />
</td>	
	
			
		</tr>
		<% }
	} //for loop ends here %>
	
		
<input type="hidden" name="gridSize" id="gridSize" value="<%=inc%>"/>
</table>
</div>
<div class="clear"></div>
<div class="Block">
</div>