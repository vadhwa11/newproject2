<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

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



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		
		
		System.out.println("map " + map);
		//System.out.println("map&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& " + hiddenFieldForRecords);
		
	}
	
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
		System.out.println("itemIdForNextRecord------------------in jsp department indent addition------------"+itemIdForNextRecord);
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int internalIndentId = 0;
	if (box.getInt("internalIndentId")!=0)
	{
		internalIndentId = box.getInt("internalIndentId"); 
	}
	else if (map.get("newinternalIndentId")!=null) 
	{
		internalIndentId = (Integer)map.get("newinternalIndentId");
	}
	
%>

<title>Department Indent Addition</title>

<script>


							            
	function jsClose()
	{
	  window.opener.location.href = "stores?method=getStockDetail&numOfRows=15";
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	  window.close();
	}



</script>

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<br />



<div id="contentspace"><input type="hidden" name="numOfRows"
	size="5" value="15"> <input type="hidden" name="pageCount"
	size="5" value="10"> <!--  <input type="button" name="Submit" id="addbutton" onClick="jsSubmit()" value="Submit" class="button"  />-->


<input type="hidden" name="itemIdForNextRecord"
	value="<%=itemIdForNextRecord %>" /> <%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %> <br />
<div style="padding-left: 350px;"><input type="button"
	name="nextRecords" id="nextRecords" onClick="callNext()"
	value="Next 1000 Records" class="cmnButton" /></div>

<%		
		if (pagedArray == null) {
		%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div
		   	<br/>
		    
			<div style="overflow: scroll; overflow-x: hidden;  width: 95%;  BORDER: #202020 1px solid;">
			<table align="center" width="100%" colspan="7"  class="grid_header" border="1" cellpadding="0" cellspacing="0">
				<thead>
			    	<tr>
				      <td width="5%"><label valign="left" class="smalllabel">SR No</label></td>
				      <td width="10%"><label valign="left" class="smalllabel">PVMS No</label></td>
				      <td width="30%"><label valign="left" class="smalllabel">Nomenclature</label></td>
				      <td width="10%"><label valign="left" class="smalllabel">A/U</label></td>
				      <td width="10%"><label valign="left" class="smalllabel">Stock In Hand</label></td>
				      <td width="10%"><label valign="left" class="smalllabel">Loan In Qty</label></td>
				    	<td width="10%"><label valign="left" class="smalllabel">Loan Out Qty</label></td>
				       
					</tr>
				</thead>
				<tbody>
				<tr>
				    <td colspan=8 align="center"> No Items Found </td>
				</tr>
				</tbody>
		     </table>
				</div>
		
		  <%  } else { %>
			 <div style="width: 15px; height: 20px; float:left;"></div>
			 <div style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid;  BORDER-LEFT: #9A9A9A 1px solid;   width: 187px; height: 20px; float:left;">
	            <font class="boxtitle">Item Details</font>
           	</div>
	 	
	    	<div style="width: 15px; float:left;"><img src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
		   	<br/>
		 
			<div style="overflow: scroll; overflow-x: scroll;  width: 95%; height: 300px; BORDER: #202020 1px solid;">
			<table align="center" width="100%" colspan="7"  class="grid_header" border="1" cellpadding="0" cellspacing="0">
			<thead>
				    <tr>
				      <td ><label valign="left" class="smalllabel">SR No</label></td>
				      <td ><label valign="left" class="smalllabel">PVMS No</label>      </td>
				      <td ><label valign="left" class="smalllabel">Nomenclature</label>      </td>
				      <td ><label valign="left" class="smalllabel">A/U</label>      </td>
				      <td ><label valign="left" class="smalllabel">Stock In Hand</label>      </td>
				      <td width="10%"><label valign="left" class="smalllabel">Loan In Qty</label></td>
				      <td width="10%"><label valign="left" class="smalllabel">Loan Out Qty</label></td>
				      
				     
				    </tr>
				 </thead>
				<tbody>
			  <%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
				
			    for(int i=0;i<gridData.length;i++)
			    {
			    //	System.out.println("inm for loop for grid data88888888888"+i);
			    %>
			    <tr>
				    <td><input type="text" value="<%=iFirstRow++%>" class="smcaption" name="srno" readonly="readonly" /></td>
			        <td><input type="text" value="<%=gridData[i].get("pvms" )%>" class="medcaption" name="pvms" readonly="readonly" /></td>
					<td><input type="text" value="<%=gridData[i].get("nomenclature")%>" class="bigcaption" name="nomenclature" readonly="readonly" /></td>
					<td><input type="text" value="<%=gridData[i].get("au")%>" name="au" readonly="readonly" class="smcaption"/> </td>
					<td><input type="text"	value="<%=gridData[i].get("stockInHand")==null?"0":gridData[i].get("stockInHand")%>"  readonly="readonly" class="medcaption" name="stock" validate="Stock In Hand,String,no" /> </td>
					<td><input type="text"	value="<%=gridData[i].get("loanIn")==null?"0":gridData[i].get("loanIn")%>"  readonly="readonly" class="medcaption" name="loanIn" validate="Loan In Qty,String,no" /> </td>
					<td><input type="text"	value="<%=gridData[i].get("loanOut")==null?"0":gridData[i].get("loanOut")%>"  readonly="readonly" class="medcaption" name="loanOut" validate="Loan Out Qty,String,no" /> </td>
					<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"  name="itemId"  /> </td>
					
		      	</tr>
		   	
		   		
				<% } %>
		   		</tbody>
		     </table>
		</div>

		<div style="padding-left: 250px;">

	     	<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div> 
	     	<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%> </div>
     	
</div>
<div></div>
<br />
<br />
</div>

<%}%>
<script type="text/javascript">
				   
			</script>





