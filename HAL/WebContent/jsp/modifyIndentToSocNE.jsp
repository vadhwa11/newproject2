<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentS.jsp  
 * Purpose of the JSP -  This is for indentS.
 * @author  Mansis
 * @author  Deepali
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.text.SimpleDateFormat"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	System.out.print("INdent TO SOC");
	String patientDetails=""; 
	int itemReqDept=0;
	String pacEqpt="";
	String pacJustification="";
	int dose=0;
	int days=0;
	int course=0;
	int duration=0;
	int durationType=0;
	String PvmsAlreadyPrescribed="";
	String justificationNiv="";
	String clinicalTrailReq="";
	
	
	
	Map map = new HashMap();
	String includedJsp = null;
	String userName="";
	int pageNo=1;
	int indentId=0;
	String date="";
	String time="";
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<StoreIndentM>	indentMList=new ArrayList<StoreIndentM>();
	List<StoreIndentT>	indentTList=new ArrayList<StoreIndentT>();
	List<StoreIndentM>	searchIndentList=new ArrayList<StoreIndentM>();
		String  maxIndentNo="";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("indentMList")!=null)
		indentMList = (List) map.get("indentMList");
	if(map.get("indentTList")!=null)
		indentTList = (List) map.get("indentTList");
	if(map.get("searchIndentList")!=null)
		searchIndentList = (List) map.get("searchIndentList");
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 Set set=new HashSet();
	 String indentNo="";
	 
	 if(map.get("indentNo")!=null)
			indentNo=""+map.get("indentNo");
	 
	 
%>
<script language="javascript">
function checkForSocNe(val){

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForcheckForSocNe('indentToSoc','nonExp?method=chackForItemExistence&pvmsNo=' + pvms);
}

function limitText(textArea, length) {
    if (textArea.value.length > length) {
        textArea.value = textArea.value.substr(0,length);
    }
}
function validateDateSOC( strValue ) {
  var objRegExp = /^\d{1,2}(\/)\d{1,2}\1\d{4}$/

  if(!objRegExp.test(strValue))
    return false; 
  else{
    var strSeparator = strValue.substring(2,3) 

    var arrayDate = strValue.split(strSeparator); 
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
var intDay = parseInt(arrayDate[0],10);


    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true; 
    }
var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) { 
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false; 
}
function checkForSOC(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoCompleteInSOC('indentToSoc','stores?method=fillItemsForIndentToSOC&pvmsNo=' + pvms ,inc);
}

function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
  function fillUnitRate(inc)
  {
   	if(document.getElementById('unitRateTemp'+inc).value!=""){
    	document.getElementById('unitRate'+inc).value=document.getElementById('unitRateTemp'+inc).value
    	}else{
    		document.getElementById('unitRate'+inc).value=0
    	}
  }
  function fillDate(inc)
  {
  if(validateDateSOC(document.getElementById('lastRecpDateTemp'+inc).value)){
  }else{
  document.getElementById('lastRecpDateTemp'+inc).value=""
  	alert("Invalid Date..!")
  	return false
  }
   	if(document.getElementById('lastRecpDateTemp'+inc).value!=""){
    	document.getElementById('lastRecpDate'+inc).value=document.getElementById('lastRecpDateTemp'+inc).value
    	}
  }
 </script>
<style>
.bodytextBtab {
	FONT-SIZE: 11px;
	COLOR: #0438A5;
	font-weight: bold;
	LINE-HEIGHT: 16px;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	width: auto;
	padding-left: 6px;
	padding-top: 4px;
}

.smalllabel1 {
	text-align: left !important;
	width: auto;
	height: 25px !important;
	font-size: 11px;
	font-weight: bold;
	padding-top: 4px;
	padding-left: 3px;
	color: #000000 !important;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
}
</style>


<div id="contentspace">

<form name="indentToSoc" method="post"><br />
<h2 align="left" class="style1">Indent To DGAFMS in the form of
SOC-Modify</h2>
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"
					onClick="submitForm('indentToSoc','stores?method=showPrintIndentSocJsp');""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Indent No:</label> <select
			name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('indentToSoc','nonExp?method=searchIndentSOC');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>



<br />
</form>
<br />
</form>
<form name="indentGrid" method="post">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 110px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">
<%
					String date4MySQL ="";
					for(StoreIndentM storeIndentM : indentMList){
						try{
						SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
					 date4MySQL = formatterOut.format(formatterIn.parse((""+storeIndentM.getIndentDate())));
						}catch(Exception ee){
							ee.printStackTrace();
						}
					%> <label class="bodytextB"><font id="error"></font> Indent
No: </label> <input type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=storeIndentM.getIndentNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"><font id="error"></font>Indent Date :</label> <input
	type="text" name="<%=RequestConstants.INDENT_DATE%>"
	readonly="readonly" value="<%=date4MySQL%>" class="textbox_size20"
	MAXLENGTH="30" /> <label class="bodytextB"><font id="error"></font>Command:</label>
<input type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="CHAF,Bangalore"
	class="textbox_size20" MAXLENGTH="20" /> <br />
<label class="bodytextB"><font id="error"></font>Hosp/Unit Addr:</label>
<textarea name="<%=RequestConstants.DETAIL_OF_PATIENT%>" cols="25"
	rows="2" class="txtarea" validate="Hosp/Unit Addr ,string,yes"
	onKeyPress="limitText(this,70);"><%=storeIndentM.getRequiredForm()%></textarea>

<label class="bodytextB"><font id="error"></font>Item req for
Dept/WARD:</label> <select name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>"
	validate="Item req for Dept/WARD ,string,yes">
	<option value="0">Select</option>
	<%for(MasDepartment department:departmentList){
						if(department.getId()==storeIndentM.getItemReqDept().getId()){%>
	<option value="<%=department.getId() %>" selected="selected"><%=department.getDepartmentName() %></option>
	<%}else{%>
	<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%} }%>
</select> <br />
<input type="hidden" name="indentMId" value="<%=storeIndentM.getId()%>"
	id="indentMId" /> <%} %> <%for(StoreIndentT storeIndentT : indentTList){
					String str=storeIndentT.getItem().getNomenclature()+"["+storeIndentT.getItem().getPvmsNo()+"]";%>
<input type="hidden" name="indentTId" value="<%=storeIndentT.getId()%>"
	id="indentTId" /> <label class="bodytextB"><font id="error"></font>Nomenclature
of Item :</label> <input type="text" value="<%=str%>" tabindex="1"
	id="<%=RequestConstants.ITEM_NAME%>"
	onblur="checkForSocNe(this.value);" class="bigcaption"
	validate="Item name ,string,yes" name="<%=RequestConstants.ITEM_NAME%>"
	MAXLENGTH="256" />
<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('<%=RequestConstants.ITEM_NAME%>','ac2update','stores?method=getItemListForMMFIndent',{parameters:'requiredField=<%=RequestConstants.ITEM_NAME%>&mmfForTheYear=0' });
						</script> <%} %>
</div>


<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="{submitForm('indentGrid','nonExp?method=updateIndentToSOC&buttonName=submit');}" />
<%for(StoreIndentM storeIndentM : indentMList){ %>
<table class="grid_header" cellpadding="2" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Brief mention of functions and Justification of
			proposed eqpt:</font>
			<td colspan="9"><textarea
				name="<%=RequestConstants.BRIEF_JUSTIFICATION%>" rows="2" cols="30"
				maxlenth="1" onKeyPress="limitText(this,256);"
				validate="Brief mention of functions and Justification of proposed eqpt ,string,no"><%=storeIndentM.getBriefMentionOfFunctions() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Existing facilities at the hospital and deficiency
			/ inadequacy if any :</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.EXISTING_FACILITIES%>" rows="2"
				onKeyPress="limitText(this,256);" cols="30"
				validate="Existing facilities at the hospital and deficiency / inadequacy if any  ,string,no"><%=storeIndentM.getExistingFacilities() %></textarea></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>How was the work going on in the absence of
			subject equipment :</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.HOW_WAS_THE_WORK%>" rows="2" cols="30"
				onKeyPress="limitText(this,256);"
				validate="How was the work going on in the absence of subject equipment ,string,no"><%=storeIndentM.getHowWasTheWork() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Feedback about the performance from hospitals
			having the equipment :</font></td>
			<td colspan="9"><textarea name="<%=RequestConstants.FEEDBACK%>"
				rows="2" cols="30" onKeyPress="limitText(this,256);"
				validate="Feedback about the performance from hospitals having the equipment ,string,no"><%=storeIndentM.getFeedbackAboutThePerformance() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>No. of patients will be benefited from the
			equipment :</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.NO_OF_PATIENTS%>" rows="2" cols="30"
				onKeyPress="limitText(this,256);"
				validate="No. of patients will be benefited from the equipment ,string,no"><%=storeIndentM.getNoOfPatientsWillBeBenefited() %></textarea></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Desirability of out sourcing the required service
			from economy point of view:</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.DESIRABILITY%>" rows="2" cols="30"
				onKeyPress="limitText(this,256);"
				validate="Desirability of out sourcing the required service from economy point of view ,string,no"><%=storeIndentM.getDesirabilityOfOutSourcing() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Manufacturer (Full Address)</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.MANUFACTURER_NAME%>" rows="2" cols="30"
				onKeyPress="limitText(this,100);"
				validate="Manufacturer (Full Address),string,no"><%=storeIndentM.getManufacturerFullAddress() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Country of origin :</font></td>
			<td colspan="9"><input type="text"
				name="<%=RequestConstants.COUNTRY_CODE %>"
				onKeyPress="limitText(this,20);"
				value="<%=storeIndentM.getCountryOfOrigin() %>"
				class="textbox_size20" validate="Country of origin,string,no"
				MAXLENGTH="20" /></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Indian agent Delhi Address :</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.INDIAN_AGENT%>" rows="2" cols="30"
				onKeyPress="limitText(this,100);"
				validate="Indian agent  Delhi Address ,string,no"><%=storeIndentM.getIndianAgentDelhiAddress() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>STD code, Tele No : </font></td>
			<td colspan="9"><input name="<%=RequestConstants.STD_CODE %>"
				type="text" value="<%=storeIndentM.getStdCode() %>"
				onKeyPress="limitText(this,7);" class="smcaption" size="6"
				validate="STD code ,num,no" /> <%if(storeIndentM.getTellNo()!=null){%>
			<input type="text" name="<%=RequestConstants.TELE_NO %>"
				value="<%=storeIndentM.getTellNo() %>"
				onKeyPress="limitText(this,10);" class="textbox_size20"
				validate="Tele No  ,numWithoutSpaces,no" MAXLENGTH="20" /> <%}else{ %>
			<input type="text" name="<%=RequestConstants.TELE_NO %>" value=""
				onKeyPress="limitText(this,10);" class="textbox_size20"
				validate="Tele No  ,numWithoutSpaces,no" MAXLENGTH="20" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Fax No: </font></td>
			<td colspan="9">
			<%if(storeIndentM.getFaxNo()!=null){ %> <input type="text"
				name="<%=RequestConstants.FAX_NO %>"
				onKeyPress="limitText(this,10);"
				value="<%=storeIndentM.getFaxNo() %>" class="textbox_size20"
				validate="Fax No,numWithoutSpaces,no" MAXLENGTH="20" /> <%}else{ %> <input
				type="text" name="<%=RequestConstants.FAX_NO %>"
				onKeyPress="limitText(this,10);" value="" class="textbox_size20"
				validate="Fax No,numWithoutSpaces,no" MAXLENGTH="20" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Email: </font></td>
			<td colspan="9"><input type="text"
				name="<%=RequestConstants.EMAIL %>" onKeyPress="limitText(this,30);"
				value="<%=storeIndentM.getEmail() %>" class="textbox_size20"
				validate="Email,email,no" MAXLENGTH="20" /></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Local Address: </font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.LOCAL_ADDRESS%>" rows="2"
				onKeyPress="limitText(this,256);" cols="30"
				validate="Local Address ,string,no"><%=storeIndentM.getLocalAddress() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>STD code, Tele No : </font></td>
			<td colspan="9"><input
				value="<%=storeIndentM.getLocalStdCode() %>"
				name="<%=RequestConstants.LOCAL_STD_CODE %>" type="text"
				onKeyPress="limitText(this,7);" class="smcaption" size="6"
				validate="Local STD code,num,no" /> <%if(storeIndentM.getLocalTellNo()!=null){ %>
			<input type="text" name="<%=RequestConstants.LOCAL_TELE_NO %>"
				value="<%=storeIndentM.getLocalTellNo() %>"
				onKeyPress="limitText(this,10);" class="textbox_size20"
				validate="Local Tel no,numWithoutSpaces,no" MAXLENGTH="20" /> <%}else{ %>
			<input type="text" name="<%=RequestConstants.LOCAL_TELE_NO %>"
				value="" onKeyPress="limitText(this,10);" class="textbox_size20"
				validate="Local Tel no,numWithoutSpaces,no" MAXLENGTH="20" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Fax No: </font></td>
			<td colspan="9">
			<%if(storeIndentM.getLocalFaxNo()!=null){ %> <input type="text"
				name="<%=RequestConstants.LOCAL_FAX_NO %>"
				onKeyPress="limitText(this,10);"
				value="<%=storeIndentM.getLocalFaxNo() %>" class="textbox_size20"
				validate="Local Fax No,numWithoutSpaces,no" MAXLENGTH="10" /> <%}else{ %>
			<input type="text" name="<%=RequestConstants.LOCAL_FAX_NO %>"
				onKeyPress="limitText(this,10);" value="" class="textbox_size20"
				validate="Local Fax No,numWithoutSpaces,no" MAXLENGTH="10" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Email: </font></td>
			<td colspan="9"><input type="text"
				name="<%=RequestConstants.LOCAL_EMAIL %>"
				onKeyPress="limitText(this,130);"
				value="<%=storeIndentM.getLocalEmail() %>" class="textbox_size20"
				MAXLENGTH="20" /></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Quantity of standered eqp : </font></td>
			<td colspan="9">
			<%if(storeIndentM.getQty() !=null){ %> <input type="text"
				onKeyPress="limitText(this,10);"
				name="<%=RequestConstants.QTY_OF_STND_EQPMT %>"
				value="<%=storeIndentM.getQty() %>"
				validate="Quantity of standered eqp,floatWithoutSpaces,no"
				class="textbox_size20" MAXLENGTH="20" /> <%}else{ %> <input
				type="text" onKeyPress="limitText(this,10);"
				name="<%=RequestConstants.QTY_OF_STND_EQPMT %>" value=""
				validate="Quantity of standered eqp,floatWithoutSpaces,no"
				class="textbox_size20" MAXLENGTH="20" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Must accessories (attach list with qty) :</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.MUST_ACCESSORIES%>"
				onKeyPress="limitText(this,256);" rows="2" cols="30"
				validate="Must accessories (attach list with qty)  ,string,no"><%=storeIndentM.getMustAccessories() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Essential accessories (attach list with qty)</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.ESSENTIAL_ACCESSORIES%>"
				onKeyPress="limitText(this,256);" rows="2" cols="30"
				validate="Essential accessories (attach list with qty) ,string,no"><%=storeIndentM.getEssentialAccessories() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>AT/SO number and qty. of similar items received</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.AT_SO_NUMBER%>"
				onKeyPress="limitText(this,150);" rows="2" cols="30"
				validate="AT/SO number and qty. of similar items received ,string,no"><%=storeIndentM.getAtSoNumber() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Reference of indents not yet materialized</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.REFERENCE_OF_INDENTS%>" rows="2"
				onKeyPress="limitText(this,150);" cols="30"
				validate="Reference of indents not yet materialized ,string,no"><%=storeIndentM.getReferenceOfIndents() %></textarea>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Approximate total cost in Rs. (Attach Budgetary
			Quotation ) </font></td>
			<td colspan="9">
			<%if(storeIndentM.getApproximateTotal() !=null){ %> <input type="text"
				name="<%=RequestConstants.APPROXIMATE_TOTAL %>"
				onKeyPress="limitText(this,10);"
				value="<%=storeIndentM.getApproximateTotal() %>"
				class="textbox_size20"
				validate="Approximate total cost in Rs. (Attach Budgetary Quotation ) ,floatWithoutSpaces,no"
				MAXLENGTH="6" /> <%}else{%> <input type="text"
				name="<%=RequestConstants.APPROXIMATE_TOTAL %>"
				onKeyPress="limitText(this,10);" value="" class="textbox_size20"
				validate="Approximate total cost in Rs. (Attach Budgetary Quotation ) ,floatWithoutSpaces,no"
				MAXLENGTH="6" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>PAC (Attach certificate from manufacturer and
			endorse justification) </font></td>
			<td colspan="9"><input type="text"
				name="<%=RequestConstants.PAC_JUSTIFICATION %>"
				onKeyPress="limitText(this,256);"
				value="<%=storeIndentM.getPacAttachCertificate() %>"
				class="textbox_size20"
				validate="PAC (Attach certificate from manufacturer and endorse justification) ,string,no"
				MAXLENGTH="20" /></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Consumables required(Y/N): </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getConsumablesRequired().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getConsumablesRequired().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>

		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>if yes Qty </font></td>
			<td colspan="9">
			<% if(storeIndentM.getIfYesQty() !=null){%> <input type="text"
				name="<%=RequestConstants.IF_YES_QTY %>"
				value="<%=storeIndentM.getIfYesQty() %>" class="textbox_size20"
				validate="if yes Qty ,floatWithoutSpaces,no" MAXLENGTH="7" /> <%}else{ %>
			<input type="text" name="<%=RequestConstants.IF_YES_QTY %>" value=""
				class="textbox_size20" validate="if yes Qty ,floatWithoutSpaces,no"
				MAXLENGTH="7" /> <%} %>
			</td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Duration for which required </font></td>
			<td colspan="9">
			<%if(storeIndentM.getDurationForWhichReqd() !=null){ %> <input
				type="text" name="<%=RequestConstants.DURATION_FOR_WHICH_REQD %>"
				value="<%=storeIndentM.getDurationForWhichReqd() %>"
				class="textbox_size20"
				validate="Duration for which required ,numWithoutSpaces,no"
				MAXLENGTH="20" /> <%}else{ %> <input type="text"
				name="<%=RequestConstants.DURATION_FOR_WHICH_REQD %>" value=""
				class="textbox_size20"
				validate="Duration for which required ,numWithoutSpaces,no"
				MAXLENGTH="20" /> <%} %>
			</td>
		</tr>

		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>User trial required(Y/N): </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.USER_TRAIL_REQUIRED%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getUsertrialrequired().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getUsertrialrequired().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Installation by firm required (Y/N): </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.INSTALLATION_BY_FIRM_REQUIRED%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getInstallationByFirmRequired().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getInstallationByFirmRequired().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Turnkey required (Y/N) : </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.TURN_KEY_REQUIRED%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getTurnkeyRequired().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getTurnkeyRequired().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Annual Maint. Contract reqd. (Y/N): </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.ANNUAL_MAINT_CONTRACT_REQD%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getAnnualMaintContractReqd().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getAnnualMaintContractReqd().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>Training required (Y/N): </font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.TRAINING_REQUIRED%>">
				<option value="0">Select</option>
				<%if(storeIndentM.getTrainingRequired().equals("y")){ %>
				<option value="y" selected="selected">Yes</option>
				<%}else{ %>
				<option value="y">Yes</option>
				<%} %>
				<%if(storeIndentM.getTrainingRequired().equals("n")){ %>
				<option value="n" selected="selected">No</option>
				<%}else{ %>
				<option value="n">No</option>
				<%} %>
			</select></td>
		</tr>
	</tbody>
</table>
<%} %> <br />

<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script></div>
</form>

</div>
