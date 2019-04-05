<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartment.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  Deepali
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<!--

  
  <link href="/hms/jsp/fx-css/960.css" rel="stylesheet" media="screen" />
  <link href="/hms/jsp/fx-css/defaultTheme.css" rel="stylesheet" media="screen" />
  <link href="/hms/jsp/fx-css/myTheme.css" rel="stylesheet" media="screen" />
  <link href="/hms/jsp/fx-css/defaultTheme.css" rel="stylesheet" media="screen" />
        <script src="/hms/jsp/js/jquery.min.js"></script>
        <script src="/hms/jsp/fx-js/jquery.fixedheadertable.min.js"></script>
        <script src="/hms/jsp/demo.js"></script>
-->

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
	
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// 
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
	<script type="text/javascript">
	function autocompleteBasedOnPvms(val)
	{
			ajaxFunctionForAutoCompleteMedcineMaster('searchMedcineMater','stores?method=fillItemsCommon&pvmsNo=' + val);
	}
	</script>
	<script type="text/javascript">
	function ajaxFunctionForAutoCompleteMedcineMaster(formName,action) 
	{
		  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) 
	      	{
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var name  = item.getElementsByTagName("name")[0];
		    	document.getElementById('nomenclature1').value = name.childNodes[0].nodeValue +"[" + id.childNodes[0].nodeValue + "]" +"(" + pvms.childNodes[0].nodeValue + ")" 	
		    	document.getElementById('pvmsNo').value = id.childNodes[0].nodeValue
	      }
	    }
	  }
	}	
	</script>
<style>
	div.calcell{width:80px;height:15px;overflow:auto;}.
	</style>
	
	
	

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else 
	{
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else 
	{
		orderDateOnly.append(month);
	}
	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
	%>


<%
	Box box = HMSUtil.getBox(request);
	String pvmsNo="";
	String pvmsNo1="";
	pvmsNo=box.getString("pvmsNo");
	Vector mmfTItems = new Vector();
	mmfTItems=box.getVector("mmfTItems");
	box.put("mmfTItems",mmfTItems);
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String userName = "";
	int hospitalId = 0;
	String  docId = "";
	
	String time="";
	int currentPage=0;
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasManufacturer> approvedByManufacturerList = new ArrayList<MasManufacturer>();
	List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreFyDocumentNo> mmfNoList = new ArrayList<StoreFyDocumentNo>();
	List<StoreMmfDepartmentM> storeMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List MedcineMasterObjectList = new ArrayList();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	String flagForRefresh="";
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if (session.getAttribute("userName") != null)
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");

		if (map.get("objectList") != null) {
			MedcineMasterObjectList = (List)map.get("objectList");
	}
	
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		
	}
	
	
	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}
	if(map.get("manufacturerList") != null)
	{
		approvedByManufacturerList = (ArrayList) map.get("manufacturerList");
	}
	
	
	if(map.get("sectionList") != null)
	{
		sectionList = (ArrayList) map.get("sectionList");
	}

	
	if(map.get("mmfNoList")!=null)
	{
		mmfNoList = (List) map.get("mmfNoList");
	}
	
	if(map.get("docId")!=null)
	{
		docId = (String)map.get("docId");
		box.put("docId",docId);
	}
	
	if(map.get("remarks")!=null)
	{
		box.put(REMARKS, map.get("remarks").toString());
	}
	if(map.get("checkedBy")!=null)
	{
		box.put(CHECKED_BY, map.get("checkedBy").toString());
	}
	if(map.get("preparedBy")!=null)
	{
		box.put(PREPARED_BY, map.get("preparedBy").toString());
	}
	String preparedBy=box.get("PREPARED_BY").toString();

	if(map.get("searchStoreMmfDepartmentMList")!=null)
		searchStoreMmfDepartmentMList = (List) map.get("searchStoreMmfDepartmentMList");
	
	if(map.get("storeMmfDepartmentMList")!=null)
		storeMmfDepartmentMList = (List) map.get("storeMmfDepartmentMList");

	
%>
<div class="titleBg">
<h2>MEDICINE MASTER SEARCH</h2>
</div>
<div class="Clear"></div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchMedcineMater" method="post">
<div class="clear"></div>
<label class="bodytextB"> MMF No. </label> 
<select name="<%=DOC_NO%>">
			<option value="">Select MMF No</option>
			<%
				for (StoreMmfDepartmentM mObj : searchStoreMmfDepartmentMList) {
			%>
			<option value=<%=mObj.getDocNo()%>><%=mObj.getDocNo()%></option>
			<%
				}
			%>
</select> 
<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" /> 
<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="jsDisplay();" />			 

</div>

<div class="Clear"></div>
<form name="mmfDepartment" method="post"><input type="hidden"
	name="numOfRows" size="10" value="10"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="docId" id="docId" value="<%=docId%>" /> <%
	String mmfNo = "";
	if (map.get("finalMmfNo") != null) {
		mmfNo = (String) map.get("finalMmfNo");
	} else if (map.get("mmfNo") != null) {
		mmfNo = (String) map.get("mmfNo");
	}
%> <input type="hidden" name="mmfNo" value="<%=mmfNo%>">
<h4>SEARCH BY</h4>
<div class="Clear"></div>
<div class="Block">
<label>Section</label> 
<select name="sectionCode" id="sectionCode" onchange="" tabindex=1>
				    <option value="0">Select</option>
				      <% 
				      
				      String sectionName="";
				      for (MasStoreSection masStoreSection :sectionList) {  
				    	  sectionName=masStoreSection.getSectionName()+"[ "+masStoreSection.getSectionCode()+" ]";
				      
				      %>
				    <option value="<%=masStoreSection.getId ()%>"><%=sectionName%></option>
				      <%}%>
				   </select>

<label>PVMS/NIV No.</label> 
<input type="text" name="PVMS_NIV_NO" id="pvms_no" value="" onmousemove="autocompleteBasedOnPvms(this.value);" onblur="autocompleteBasedOnPvms(this.value);" tabindex=2> 

	<script type="text/javascript">
	function test(){

		var itemNameSearch1 =  document.getElementById('nomenclature1').value;
	    var index1 = itemNameSearch1.lastIndexOf("[");
	    var index2 = itemNameSearch1.lastIndexOf("]");
	    var index3 = itemNameSearch1.lastIndexOf("(");
	    var index4 = itemNameSearch1.lastIndexOf(")");
	    index1++;
	    index3++;
	    var itemNameSearch = itemNameSearch1.substring(0,index1-1);
	    var itemId = itemNameSearch1.substring(index1,index2);
	    var itempvms=itemNameSearch1.substring(index3,index4);
	    if(itemId!="")
	    document.getElementById("pvmsNo").value=itemId;
	    else
	    document.getElementById("pvmsNo").value=0;
	    if(itempvms!=null)
	    document.getElementById("pvms_no").value=itempvms;
	    else
	    	document.getElementById("pvms_no").value=0;  
	    // document.physicalStock.method="post";
		//	submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
	
	}
</script>
<label>Nomenclature</label> 
<input type="text"	value="" id="nomenclature1" name="nomenclature1" onblur="test();" tabindex=1/>
<div id="ac2update" style="display: none;"	class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature1','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature1'});
</script>
<input type="hidden" id="pvmsNo" class="small" name="pvmsNo"   readonly="readonly"/>


 
<div class="Clear"></div>
<label>Source</label>
<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1 >
	<option value="0">Select</option>
	<option value="A">Depot</option>
	<option value="L">LP</option>
	<option value="G">Other Gov Source</option>
	<option value="U">Other Units</option>
	
	<!-- -
	<option value="o">Other Units</option>
	<option value="i">AFMSD Without Indent</option>
	<option value="w">CRV without LPO</option> -->
</select>
<label>Manufacturer</label> 
<select name="MANUFACTURER" tabindex=1>
<option value="0">Select</option>
<%
if(approvedByManufacturerList!=null){
for(MasManufacturer masManufacturer :approvedByManufacturerList){ 
%>
<option value="<%=masManufacturer.getId()%>"><%=masManufacturer.getManufacturerName()%></option>
<%
}
}
%>
</select>
<label>Life Span</label> 
<select value="0" name="LIFE_SPAN" tabindex=1>
	<option value="0">Select</option>
	<option value="LL">LL</option>
	<option value="SL">SL</option>
</select>
<div class="Clear"></div>
<label>B/G</label> 
 <select name="<%=BRAND_GENERIC%>"  tabindex=1>
			  <option value="0">Select</option>
			  <option value="B">Branded</option>
			  <option value="G">Generic</option>
			  </select> 
<label>ABC</label> 
<SELECT id="abc" name="<%=ABC%>" value="" maxlength="30" tabindex="1">
			<option value="0">Select</option>
			<option value="a">A</option>
			<option value="b">B</option>
			<option value="c">C</option>
			</SELECT>
<label>VED</label> 
<SELECT id="ved" name="<%=VED %>" value="" maxlength="30" tabindex="1">
			   <option value="0">Select</option>
			   <option value="D">D</option>
			   <option value="E">E</option>
			   <option value="V">V</option>
			</SELECT>
<div class="Clear"></div>
<label class="">CRV No.</label>
<label class="">  From</label>
<input type="text" name="crvFrom" value="">
<label>To</label>
<input type="text" name="crvTo" value="">
<div class="Clear"></div>
<label>DOE</label>
<label>  From</label>
<input type="text" name="doeFrom" class="date"  vaue=""/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchMedcineMater.<%="doeFrom"%>,event)" />
<label>To</label>
<input type="text"  class="date" name="doeTo" value="">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchMedcineMater.<%="doeTo"%>,event)" />
<div class="Clear"></div>
<label>Discount%</label>
<label>  From</label>
<input type="text" name="discountFrom" value="">
<label>To</label>
<input type="text" name="discountTo" value="">
<div class="Clear"></div>
<label>SO No.</label>
<label>  From</label>
<input type="text" name="soFrom" value="">
<label>To</label>
<input type="text" name="soTo" value="">

<div class="Clear"></div>
<label>Date</label>
<label>From</label>
<input type="text" class="date" name="fromDate"  value=""/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchMedcineMater.<%="fromDate"%>,event)" />
<label>To</label>
<input type="text" class="date" name="toDate" value="">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
			onClick="setdate('<%=currentDate%>',document.searchMedcineMater.<%="toDate"%>,event)" />


</div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_M_ID %>"
	value="<%=map.get("mmfMasterId") == null?0:map.get("mmfMasterId")%>" />
	</form>	
<div class="Clear"></div>

<input type="button" name="Submit" id="addbutton" value="SEARCH" class="button" onClick="submitForm('searchMedcineMater','stores?method=searchMedicenMasterJsp&buttonName=submit');" /> 

<div class="Clear"></div>
<div class="clear"></div>
<div class="Clear"></div>
<div class="clear"></div>

<h4>MEDICINE MASTER DETAILS</h4>
<div class="Clear"></div>

<!--<script type="text/javascript">

function getVal(e) {
    var targ;
    if (!e) var e = window.event;
    if (e.target) targ = e.target;
    else if (e.srcElement) targ = e.srcElement;
    if (targ.nodeType == 3) // defeat Safari bug
        targ = targ.parentNode;

    alert(targ.innerHTML);
}

onload = function() {
    var t = document.getElementById("main").getElementsByTagName("td");
    for ( var i = 0; i < t.length; i++ )
        t[i].onclick = getVal;
}

</script>

-->
<div class="cmntableWithHeight">
<table >
	<thead>
		<tr>
			<th>Sl No.</th>
			<!--
			 <th>Section&nbsp;</th>            
			-->
			<th>PVMS/ NIV No.</th>
			<th>Nomenclature </th>
			<TH>Salt</TH>
			<th>A/U </th>
			
			<th>Storage<br></br>Temp</th>
			
			<th>MMF</th>
			<th >Source</th>
			<th >Life Span</th>
			<th >SO/Depot Date </th>
			<th >SO/Depot No. </th>
			<th >CRV No.</th>
			<th >CRV Date</th>
			
			
			
		
			<th>Batch No.</th>
			<th >DOM</th>
			<th >DOE</th>
			
			<th >Type(G/B)</th>
			<th >Manufacturer</th>
			<th>Dispense</BR>Type</th>
			<th>Packaging</th>
			<th >MRP</BR>Per Packing</th>
			<th >MRP</BR>Per A/U</th>
			<th >Disc %</th>
			<th >Tax %</th>
			<th>Actual Cost</th>
			<th >Received</BR> Qty</th>
			<th>Issue to</BR> Dispensary</th>
			<th>Issue to</BR> Other Unit</th>
			<th >Total </BR>Issue Qty</th>
			<th >Total </BR></>Stock Qty</th>	
			<th >ABC</th>	
			<th >VED</th>	
			
		</tr>
	</thead>

		<%
		String pvmsNocheck="";
if (MedcineMasterObjectList != null && MedcineMasterObjectList.size() > 0) { 
int i=0;
for (Iterator iterator = MedcineMasterObjectList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
			
%>
<tr >
<%
if(objects[26].toString().equals("0")){
%>
<td ><%=++i%></td>
<%}else{
	%>
<td style="background: red;"><%=++i%></td>
<%}%>
<!--<%if(objects[3]!=null){
%>
<td ><%=objects[3]%></td>
<%}else{%>
<td >NA</td>
<%}%>
-->
<%
if(!(objects[0].toString().equals(pvmsNocheck))){
	pvmsNocheck=objects[0].toString();
%>
<%if(objects[0]!=null){%>
<td><%=objects[0]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[1]!=null){%>
<td ><%=objects[1]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[25]!=null){%>
<td><%=objects[25]%></td>
<%}else{%>
<td>NA</td>
<%}%>
<%if(objects[2]!=null){%>
<td ><%=objects[2]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<td></td>
<%if(objects[4]!=null){%>
<td><%=objects[4]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[13]!=null){

//String abc[]=objects[13].toString().split("-");
//String da=abc[0]+"-"+abc[1]+"-"+abc[2];%>
<td ><%=objects[13]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%}else{%>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<%}%>

<%if(objects[9]!=null){%>
<td ><%=objects[9]%></td>
<%}else{%>
<td >NA</td>
<%}%>

<%if(objects[8]!=null){
	String abc[]=objects[8].toString().split("-");
	String da=abc[2]+"-"+abc[1]+"-"+abc[0];

%>
<td ><%=da%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[7]!=null){
%>
<td ><%=objects[7]%></td>
<%}else{%>
<td >NA</td>
<%}%>





<%if(objects[5]!=null){%>
<td ><%=objects[5]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[6]!=null){
	String abc[]=objects[6].toString().split("-");
	//String da=abc[2]+"-"+abc[1]+"-"+abc[0];
String da=HMSUtil.convertDateToStringWithoutTime((Date)objects[6]);
%>
<td ><%=da%></td>
<%}else{%>
<td >NA</td>
<%}%>


<%if(objects[10]!=null){%>
<td ><%=objects[10]%></td>
<%}else{%>
<td >NA</td>
<%}%>

<%if(objects[11]!=null){
	String abc[]=objects[11].toString().split("-");
	//String da=abc[2]+"-"+abc[1]+"-"+"20"+abc[0].substring(2);
	String da=HMSUtil.convertDateToStringWithoutTime((Date)objects[11]);
	%>
<td ><%=da%></td>
<%}else{%>
<td >NA</td>
<%}%>

<%
if(objects[12]!=null){
	String abc[]=objects[12].toString().split("-");
	//String da=abc[2]+"-"+abc[1]+"-"+"20"+abc[0].substring(2);
	String da=HMSUtil.convertDateToStringWithoutTime((Date)objects[12]);
%>
<td ><%=da%></td>
<%}else{%>
<td >NA</td>
<%}%>


<%if(objects[14]!=null){
	//String abc[]=objects[14].toString().split("-");
	//String da=abc[0]+"-"+abc[1]+"-"+abc[2];
%>
<td ><%=objects[14]%></td>
<%}else{%>
<td >NA</td>
<%}%>

<%if(objects[15]!=null){%>
<td ><%=objects[15]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[22]!=null){%>
<td><%=objects[22]%></td>
<%}else{%>
<td>NA</td>
<%}%>
<%if(objects[23]!=null){%>
<td><%=objects[23]%></td>
<%}else{%>
<td>NA</td>
<%}%>
<%if(objects[16]!=null){%>
<td ><%=objects[16]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%
double s=0.0;
if(objects[23]!=null && objects[16]!=null){

	double b=Double.parseDouble(objects[23].toString());
	if(b!=0.0){
		double c=Double.parseDouble(objects[16].toString());
		s=c/b;
		
	}
}
%>
<td ><%=s%></td>
<%if(objects[18]!=null){%>
<td ><%=objects[18]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[24]!=null){%>
<td><%=objects[24]%></td>
<%}else{%>
<td>NA</td>
<%}%>
<%if(objects[17]!=null){%>
<td ><%=objects[17]%></td>
<%}else{%>
<td >NA</td>
<%}%>

<%if(objects[19]!=null){%>
<td ><%=objects[19]%></td>
<%}else{%>
<td >NA</td>
<%}%>


<%if(objects[20]!=null){%>
<td ><%=objects[20]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[20]!=null){%>
<td >0</td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[20]!=null){%>
<td ><%=objects[20]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<%if(objects[21]!=null){%>
<td ><%=objects[21]%></td>
<%}else{%>
<td >NA</td>
<%}%>
<td ></td>
<td ></td>

</tr>
<%}}%>
</table>
</div>
<div class="Clear"></div>
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />  
<div class="Clear paddingTop15"></div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>