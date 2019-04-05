<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showboardofsurvey.jsp  
 * Purpose of the JSP -  This is for boardofsurvey.
 * @author  HITESH
 * Create Date: 21st May,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreBosM" %>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock" %>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
	<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script language="Javascript">
function search()
{
searchBlock.method="post";
submitForm('searchBlock','neStores?method=searchBosData');
}


function importBosData()
{
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=createAndImportBosData');
}

function upd()
{ alert("upd");
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=updateGridItemsBos');
}

function load(){
boardOfSurvey.method="post";
submitForm('boardOfSurvey','neStores?method=loadGridItemsBos');
	
}

function goPage(pidx) {	
	boardOfSurvey.currPage.value = pidx;
	boardOfSurvey.method="post";
	submitForm('boardOfSurvey','neStores?method=getBosData');
}

function showReport(formName)
{
  obj = eval('document.'+formName)
  var bosNo = document.getElementById('bosNo').value
  obj.action = "/hms/hms/neStores?method=printBoardOfSurvey&bosNo="+bosNo;
  obj.submit();
}


</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
    HashMap[] gridData =null;
    PagedArray pagedArray = null;
	String previousPage="no";
	List<StoreBosM> storeBosMlist = new ArrayList<StoreBosM>();
	List<StoreItemBatchStock> storeItemBatchStockMList = new ArrayList<StoreItemBatchStock>();
	int pageNo=1;
	String bosNo="";
	int hospitalId = 0;
	 int deptId = 0;
	 String userName="";
	 String lastchangedby="";
	 String lastchangeTime="";
	 String time ="";
	 String message="";
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	
		pagedArray = (PagedArray)map.get("pagedArray");
	
		if(map.get("BosNo")!=null){
			bosNo=(String) map.get("BosNo");
		}
		
		if(map.get("StoreBosMList")!=null){
			storeBosMlist=(List) map.get("StoreBosMList");
		}
		if(map.get("storeItemBatchStockMList")!=null){
			storeItemBatchStockMList=(List) map.get("storeItemBatchStockMList");
			}
		
		if(map.get("message") != null)
		 {
			message = (String)map.get("message");
		 }
		if (session.getAttribute("userName") != null){
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
		
			String pvmsNo="";
			String pvmsNo1="";
			pvmsNo=box.getString("pvmsNo");
	}
%>
<div class="titleBg">

<h2 >Board Of Survey</h2>
</div>
<!-- <input	type="button" id="addbutton" name="Add" type="submit" value="Add" class="button" onClick="submitForm('createGrn','neStores?method=showWorkOrderJsp');">
<input	type="button" name="Modify" type="submit" value="Modify" class="button">
<input	type="button" name="Reset" type="submit" value="Reset"	class="button">
<input	type="button" name="Delete" type="submit" value="Delete"class="button">
<input	type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('createGrn');">
 -->
<div id="searchBlock" style="display:none;">
<form name="searchBlock" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
	<label>Bos No:</label>
	 <select name="<%=BOS_ID%>" class="bigselect">
	<option value="">Select</option>
	<%
	     for (StoreBosM storeBosM:storeBosMlist ){
			  	
	%>
			<option value="<%=storeBosM.getBosNo()%>"><%=storeBosM.getBosNo()%></option>
			<% } %>
		</select> <input type="button" class="button" value="Search"
			onClick="search()" />

</div>
</form>
</div>

<div class="clear"></div>
<form name="boardOfSurvey" method="post">
<div id="searchBlock1" style="display:inline;">
<h4 ><%=message %></h4>
</div>
<div class="Block">

<input type="hidden"

	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	 <label> Authority No.<span>*</span></label>
	  <input type="text" name="<%=BOS_ID%>" id="bosNo" value="<%=bosNo%>" 
	class="textbox_size20" MAXLENGTH="30"    validate="Authority No.,metachar,yes"/>
	 <label	>Authority Date <span>*</span> </label>
	  <input type="text" name=<%=BOS_DATE%> class="textbox_size20" value="<%=currentDate%>"	 validate="Authority Date,date,yes"/> 
	
</div>
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />


<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" /> 
<script type="text/javascript">
		document.getElementById('noOfRecords').value='';
</script>


<div class="cmntable">
<table width="100%" colspan="7" id="bosDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="2%" rowspan="2">Sl. No.</th>
			<th width="5%" rowspan="2">PVMS/NIV No.</th>
			<th width="25%" rowspan="2">Nomenclature</th>
			<th width="5%" rowspan="2">A/U</th>
			<th width="5%" rowspan="2">Serial No.</th>
			<th width="10%" rowspan="2">
			<label valign="left"
				class="smalllabel">Qty Held</label></th>
			<th colspan="4" align="center" class="smalllabel">Condition of
			Store Found by Board</th>
			<th colspan="5" align="center" class="smalllabel">Recommendation
			of Board</th>
			<th align="center" class="smalllabel">&nbsp;</th>
			<th>Remarks</th>
		</tr>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">Serviceable</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Repairable</label></td>
			<td width="5%"><label valign="left" class="smalllabel">U/S</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Obs</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Retained in Service</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Repair Necessary</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Disposed Off in whole state or destroyed</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Returned to AFMSD</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Convert to Produce To</label></td>
			<td width="5%"><label valign="left" class="smalllabel">RV No & Date
			To Cost</label></td>
			<td width="5%"><label valign="left" class="smalllabel"></label></td>
		</tr>
	</thead>
	<tbody>
	<%
	String codeItem1="codeItem1";
	String idItem1="idItem1";
	String nameItem1="nameItem1";
 	String idAu="idAu"; 
	%>
	 <tr>
			<td width="10%">
			    <input type="text" value="1" size="2" 
				class="auto" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">			
			   <input type="text" size="8" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem1%>" />
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem1%>" />
			</td>
			<td width="10%">
			      <input type="text" size="60" value="" name="<%=nameItem1%>" id="<%=nameItem1%>" onblur="checkForBoardofsurvey(this.value, '<%=nameItem1%>');"></input>
			      <div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem1%>','ac2update','neStores?method=getItemListForBoardOfSurveyAutocom',{parameters:'requiredField=<%=nameItem1%>'});
			</script>
			</td>
			<td width="10%">
			<input type="text"	value=""
				class="medcaption" name="<%=AU %>" readonly="readonly" id="<%=idAu%>" />
				</td>
			<td width="10%"><input type="text"	 name="<%=SERIAL_NUMBER %>"
				validate="Serial Number,metachar,no"  maxlength="30"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=QTY %>"
				readonly="readonly" maxlength="5" validate="Qty,num,no" id="qty1"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=SERVICABLE %>"
				maxlength=5 validate="SERVICABLE,num,no" id="s"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=REPAIRABLE %>"
				maxlength=5 validate="REPAIRABLE,num,no" id="r"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=UN_SERVICABLE %>"
				maxlength=5 validate="UN SERVICABLE,num,no" id="u"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=OBS%>" maxlength=5
				validate="OBS,num,no" onblur="sum();" id="o"/></td>
			<td width="10%"><input type="text"
				value="" name="<%=BOARD_SERVICABLE%>"
				maxlength=5 validate="Retained in Service,num,no" /></td>
			<td width="10%"><input type="text"
				value="" name="<%=BACKLOADED%>"
				maxlength=5 validate="Repair Necessary,num,no" /></td>
			<td width="10%"><input type="text"
				value=""
				name="<%=BOARD_UN_SERVICABLE %>" maxlength=5
				validate="Disposed off in whole State or destroyed,num,no" /></td>
			<td width="10%"><input type="text"
				value=""
				name="<%=BOARD_DESTROYED%>" maxlength=5
				validate="Return to AFMSD,num,no" /></td>
			<td width="10%"><input type="text"
				value="" name="<%=REDUCED_TO %>"
				maxlength=5 validate="Converted to produce,num,no" /></td>
			<td width="20%"><input type="text"
				value="" class="bigcaption"
				name="<%=CRV_COST%>" maxlength=75 validate="RV No & Date,string,no" /></td>
			<td width="10%"><input type="text"
				value="" name="<%=REMARKS%>"
				maxlength=100 validate="REMARKS,metachar,no" />
			<input type="hidden"value="" name="id" />
		<input type="hidden" name="<%=COST%>" size="5"	value=""/></td>
		</tr>
	</tbody>
</table>
</div>


<div class="clear"></div>
<div class="division"></div>
	<!--<input type="button" name="Add" value="LOAD ALL EQUIPMENT"  class="buttonBig" onclick="load()">
	--><%--<input type="button" name="Add" value="SAVE" onClick="openPopupWindow();" class="button"> --%>
	<input	type="button" name="Submit" value="SAVE" onClick="if(checkFilledRow()){submitForm('boardOfSurvey','neStores?method=updateGridItemsBos');}" />
	<!--<input type="button" name="Add" value="CONDEMNATION ENTRY"  class="buttonBig">
	--><%--<input type="button" name="Reset" value="Reset" class="toolbutton"/>
	<input type="button" name="Delete" value="Delete" class="toolbutton"/>--%>
	<input  type="button" name="Modify" value="PRINT" class="toolbutton" onClick="submitForm('searchBlock','neStores?method=printBOSJsp');" />
	<!--<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
	--><%--<input type="button" name="Submit" id="addbutton" value="Import Condemnation Entry" class="buttonbig" onClick="importBosData();" /> --%> 
<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="hospitalId" value="" />

</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->


function checkFilledRow(){ 
	if(document.getElementById('codeItem1').value != ''){
			return true;
		}
	else{
		alert("Please fill atleast one row to submit.");
		return false;
		}
	
	 }
	
	function sum()
	 {
		 var s=document.getElementById('s').value;
		 var r=document.getElementById('r').value;
		 var u=document.getElementById('u').value;
		 var o=document.getElementById('o').value;
		 var sum=parseInt(s)+parseInt(r)+parseInt(u)+parseInt(o);
		 var qty=document.getElementById('qty1').value;

		 if(sum > qty)
		 {
			 alert("The Sum of(Serviceable,Repairable,U/S,Obs) should not exceed Qty.");
			 document.getElementById('qty1').value="";
			
		 }
		 else
		 {
			 return true;
		 }
		 
	 }
	 
	function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
	
	  function checkForIndentToDepot(val){
			//var pageNo =parseInt(document.getElementById('pageNo').value)
			//var start=((pageNo-1)*10)+1;
	    	//var end=((pageNo-1)*10)+10;

		    var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvms = val.substring(index1,index2);
		    for(i=1;i<=10;i++){
		    if(pvms !="")
		    if(document.getElementById('codeItem'+i).value==pvms){
		    if(document.getElementById('codeItem'+inc).value!=pvms){
		    	//alert("Item already selected...!")
		    	//document.getElementById('nameItem'+inc).value=""

		    	//return false;
		    	}
		    }}
			ajaxFunctionForAutoAA('boardOfSurvey','stores?method=fillItemsForIndentToSOC&pvmsNo='+ pvms );
	}
	  function checkForIndentToDepotPvsm(val,a,inc){

			var pageNo =parseInt(document.getElementById('pageNo').value)
			var start=((pageNo-1)*10)+1;
	    	var end=((pageNo-1)*10)+10;

		    var pvms = val;
		    for(i=1;i<=10;i++){
		    if(pvms !="")
		    if(document.getElementById('nameItem'+i).value==pvms){
		    if(document.getElementById('nameItem'+inc).value!=pvms){
		    	alert("Item already selected...!")
		    	document.getElementById('codeItem'+inc).value=""

		    	return false;
		    	}
		    }}
			ajaxFunctionForAutoAA('boardOfSurvey','stores?method=fillItemsForIndentToPvsm&pvmsNo=' +  pvms , inc);
	}
	  function pvmsNomenclatureSearch()
	  {  
	  	//	mmfDepartment.method="post";
	  	//	var docId = document.mmfDepartment.docId.value;
	  	//	var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	  		var pvmsNo1=document.mmfDepartment.pvmsNo1.value;
	  		var pvmsNo=pvmsNo1;
	  	//	var storeType = document.mmfDepartment.storeType.value;
	  	//	var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;

	  	submitForm('boardOfSurvey','stores?method=getMmfDepartmentData&pvmsNo='+pvmsNo+'&numOfRows=10&pageCount=10&currPage=1');

	  }
	  function checkForBoardofsurvey(val,a)
	  {
	  		//var pageNo =parseInt(document.getElementById('pageNo').value)
	  		//var start=((pageNo-1)*8)+1;
	      	//var end=((pageNo-1)*8)+8;
	  	    var index1 = val.lastIndexOf("[");
	  	    var index2 = val.lastIndexOf("]");
	  	    index1++;
	  	    var pvms = val.substring(index1,index2);
	  	    var inc =1
	  	   //ajaxFunctionForAutoCompleteInTurnOver('mmfDepartment','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
	  	    ajaxFunctionForAutoCompleteInBoardofSurvey('boardOfSurvey','neStores?method=fillItemsForBoardofsurvey&pvmsNo=' + pvms , inc);
	  }
	
	</script>