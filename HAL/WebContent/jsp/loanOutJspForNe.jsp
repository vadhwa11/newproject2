<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for  to Dispensary Manual.
 * @author  Deepti
 * @author  Vivek
 * Create Date: 12st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>


<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script language="javascript">
	
	function checkForDepartmentIssueNE(val,a,inc)
{
		
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	    
	    if(pvms !="")
	    if(document.getElementById('codeItem'+inc).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	return false;
	    	}
	    }
	    
		ajaxFunctionForAutoCompleteDepartmentIssueNE1('departmentIssueNE','nonExp?method=fillItemsForIssueToDispensary&pvmsNo='+pvms , inc);
}



	function ajaxFunctionForGetStock(formName,action,rowVal) {
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
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){
		      
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

		      
		      	
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	     var item = items.childNodes[loop];
			   	  var stockIn  = item.getElementsByTagName("stockIn")[0];
			   		document.getElementById('stockIn'+rowVal).value = stockIn.childNodes[0].nodeValue
		        	
		      	} 
		      }
		    }
		    var url=action+"&"+getNameAndData(formName)
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		    
		    
		  }


	

	function ajaxFunctionForAutoCompleteDepartmentIssueNE1(formName,action,rowVal) {
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
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){
		      
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

		      	var lotNo="lotNo"+rowVal;
				obj =document.getElementById(lotNo); 
				obj.length = 1;
		      	
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	     var item = items.childNodes[loop];
			        var id  = item.getElementsByTagName("id")[0];
			        var pvms  = item.getElementsByTagName("pvms")[0];
			        var au  = item.getElementsByTagName("au")[0];
			        var stockIn  = item.getElementsByTagName("stockIn")[0];
			        //var serialNo  = item.getElementsByTagName("serialNo")[0];
			      var serialLength  = item.getElementsByTagName("serials")[0];
			       
		        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
		        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
		        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
		        	
		        	//document.getElementById('stockIn'+rowVal).value = stockIn.childNodes[0].nodeValue
		        	

		        	for(innerLoop = 0;innerLoop <serialLength.childNodes.length;innerLoop++)
		        	{
		        		var serial = serialLength.childNodes[innerLoop];
			        	var stockId  = serial.getElementsByTagName("stockId")[0];
			        	var serialNo  = serial.getElementsByTagName("serialNo")[0];
			        	//var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
			        	//var manufacturerName = brand.getElementsByTagName("manufacturerName")[0];
			        	
			        	obj.length++;
						obj.options[obj.length-1].value=stockId.childNodes[0].nodeValue;
						obj.options[obj.length-1].text=serialNo.childNodes[0].nodeValue;
						
						//obj1.length++;
						//obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
						//obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
		        	}
		      	} 
		      }
		    }
		    var url=action+"&"+getNameAndData(formName)
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		    
		    
		  }


	  
	
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
}
function testForLotNo(value){

		if(value ==""){
			return false;
		}else{
			
			return true;
		}
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



function fillGridIssueToOTAFU1(formName,action,rowVal) {
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
	   alert("Hiiiiiii")
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length==0){
	      	alert("Item not found with given LotNo...!")
	      	document.getElementById('lotNo'+rowVal).value=""
	      	return false;
	      	}
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('issuedName'+rowVal).value = name.childNodes[0].nodeValue
	        	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue
	        		document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	      	} 
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }

 </script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
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
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	String userName="";
	String date="";
	String time="";
	String max="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Patient> patientList= new ArrayList<Patient>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
		int maxIndentNo=0;
		int issueId =0;
		Box box=HMSUtil.getBox(request);
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
			System.out.print("employeeList      "+employeeList.size());
		}
		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("patientList")!=null)
			patientList = (List) map.get("patientList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
			System.out.println("internalIndentId  "+internalIndentId);
		}
		if(map.get("masStoreBrandList")!=null)
			masStoreBrandList = (List) map.get("masStoreBrandList");
		System.out.println("masStoreBrandList  "+masStoreBrandList.size());
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		
		if(map.get("issueId")!=null)
			issueId = Integer.parseInt(""+map.get("issueId"));
	
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(map.get("searchListForPopup")!=null){
				searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
			}
%>









<div id="searchBlock" style="display:none;">
<form name="departmentIssueNE" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  

	<label class="bodytextB">Issue No:</label> 
	<select name="<%= RequestConstants.ISSUE_UNIT_ID%>">
			<option value="">Select</option>
			
			<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
			<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
			<%}%>
		</select>
		
		 <input type="button" name="sss" class="button" value="SEARCH" 
			onClick="submitForm('departmentIssueNE','nonExp?method=searchDepartmentIssueNE');" />
		
</form>
</div>
</form>
</div>

<div class="titleBg">
<h2>LOAN OUT ENTRY</h2>
</div>



<div class="Block">
<form name="departmentIssueNE" method="post" action="">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
 

<%if(box.get("issueId").equals("")){ %> <input type="hidden" name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> 
<%}else{ %>

<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> 
<input	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />

 <label>Loan Out No. </label> 
 <input	type="text" name="<%=RequestConstants.ISSUE_NO %>"	value="<%=max+box.get("issueNo") %>" id="issueNo" MAXLENGTH="8"/  > 
	
	<label class="bodytextB">Loan Out Date</label> 
	<input	type="text" name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"	value="<%=currentDate %>" id="isssueDate" /> 
	
	<label>Issued To.</label>
	 <select name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp">
	 <option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {%>
		<option value=<%=department.getId()%>
		<%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
	<%}%>
</select> 

<div class="Clear"></div>


	<label>Issued By:</label> 
	<select	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()%></option>
	<%}%>
</select> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="noOfRows" value="0" />
<div class="Clear"></div>






<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" value="0" /> <input
	type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" /> <br />
	<%int inc=1; %>
<div class="cmntable">
<table width="" col="7" id="grid" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		

			<th width="5%">Sl. No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="6%">Serial No.</th>
			<th width="13%">A/U</th>
			<th width="6%">Available Stock</th>
			<th width="10%">Loan Out Qty</th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>

	</thead>
	
	
	<tbody>


	<tr>
		<input type="hidden" name="gridSize" id="gridSize" value="1"/>
			<td width="5%"><input type="text" size="2" value="1"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" size="15"
				name="<%=RequestConstants.ITEM_CODE%>" value="" readonly="readonly"
				class="medcaption" id="codeItem<%=inc%>" /> 
				
				<input type="hidden"
				size="2" value="0" class="smcaption"
				name="<%=RequestConstants.ITEM_ID%>" id="idItem<%=inc%>" /></td>
			<td width="17%"><input type="text" value="" tabindex="1"
				id="nameItem<%=inc%>" size="50"
				onblur="if(fillSrNo('<%=inc %>')){checkForDepartmentIssueNE(this.value, 'nameItem','<%=inc %>');}"
				name="nameItem" />
			<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nameItem'+<%=inc %>,'ac2update','nonExp?method=getItemListForDepartmentIssueNE',{parameters:'requiredField=nameItem'});
			</script>
			</td>
			
			
			<td width="10%">
			
			<select  name="lotNo" id="lotNo<%=inc%>" onchange="ajaxFunctionForGetStock('departmentIssueNE','nonExp?method=getStock&lotNo='+this.value , <%=inc %>)" >
			<option value="">-Select-</option>
			</select>
			<!-- <input type="text" size="15" value="" id="lotNo<%=inc%>"
				
				onblur="if(testForLotNo(this.value)){fillGridIssueToOTAFU1('departmentIssueNE','nonExp?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);}" /></td>
			 -->
			 </td>
			 
			<td width="10%">
			<input type="text" value="" size="15"
				name="<%=RequestConstants.AU%>" id="idAu<%=inc %>" tabindex="2" />
			
			</td>
			
			<td width="10%"><input type="text" readonly="readonly" value=""
				size="15" name="" MAXLENGTH="7" id="stockIn<%=inc%>"
				validate="Qty In Stock,num,no" />
			</td>
			
			<td >
			<input type="text" value="" tabindex="1"
				validate="Qty in MMF,floatWithoutSpaces,no" size="15"
				MAXLENGTH="7" name="<%=RequestConstants.QTY_IN_MMF_TEMP%>"
				id="issuedQtyTemp<%=inc%>" 
				onchange="fillQtyIssuedForIssueCiv(<%=inc%>);" /> 
				
				<input
				type="hidden" value="0" name="<%=RequestConstants.QTY_ISSUED%>"
				id="issuedQty<%=inc%>" />
				</td>
					<td>
			    <input type="button" class="buttonAdd" value="" onclick="addRow('grid');" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" />
	
		   </td>

		</tr>
		
		
	</tbody>

</table>
</div>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" id="totalQty" /> <%--End of Change Panel--%>

<div class="Clear"></div>
<div style="float: left; padding-left: 15px;">
<!-- 
<input type="button"
	class="button" value="Next"
	onclick="if(checkForNext()&&test()&&checkSave()){submitForm('departmentIssueNE','nonExp?method=addNextOrSubmitIssue&buttonName=next');}"
	align="right" /> 
	 -->
	

</div>

<div class="Clear"></div>
<input type="button" name="sss" align="right"
	class="button" value="SAVE"
	onclick="if(checkForSubmit()&& test()&& checkSave()){{submitFormToDisableSubmit('departmentIssueNE','nonExp?method=submitLoanOutForNe');}}" />
	<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />

</form>
</div>




<script type="text/javascript">
function addRow(idName) {
	
	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;

	  var cellRight0 = row.insertCell(el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.setAttribute('tabindex', 1); 
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  ee5.name='<%=ITEM_ID%>';
	  ee5.id = 'idItem'+iteration;
	  
	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='15';
	  e1.setAttribute('tabindex', 1); 
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(e1);


				 
	  var cellRight2 = row.insertCell(++el);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '50';
	  e2.setAttribute('tabindex', 1); 
	  e2.onblur = function(){if(fillSrNo(iteration)){checkForDepartmentIssueNE(this.value, 'nameItem',iteration)}};

	 
	  
	  var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update'+iteration);
 	  newdiv.style.display = 'none';
 	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','nonExp?method=getItemListForDepartmentIssueNE',{parameters:'requiredField=nameItem'});

	  
	  var cellRight44 = row.insertCell(++el);
	  var e44 = document.createElement('select');
	  e44.name='lotNo';
	  e44.id = 'lotNo'+iteration;
	  e44.onchange=function(){ajaxFunctionForGetStock('departmentIssueNE','nonExp?method=getStock&lotNo='+this.value , iteration)}
	 
    	  var choice = document.createElement('option');
  			choice.value ='';
  			choice.appendChild(document.createTextNode('-Select-'));
			e44.appendChild(choice);
			
	
	
  
	cellRight44.appendChild(e44);


	  var celle3 = row.insertCell(++el);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=AU%>';
	  e3.id = 'idAu'+iteration;
	  e3.size='15';
	  e3.setAttribute('tabindex', 1); 
	  e3.setAttribute('maxlength', 30); 
	  celle3.appendChild(e3);
	 
	  
	  var cellRight4 = row.insertCell(++el);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	 // e4.name='<%=QUANTITY_RECEIVED%>';
	  e4.id='stockIn'+iteration;
	  e4.setAttribute('tabindex', 1); 
	  e4.setAttribute('maxlength', 5); 
	 
	  e4.size='15';
	  cellRight4.appendChild(e4);

	  
	  var cellRight7 = row.insertCell(++el);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='<%=QTY_IN_MMF_TEMP%>';
	  e7.id = 'issuedQtyTemp'+iteration;
	  e7.setAttribute('tabindex', 1); 
	  e7.setAttribute('maxlength', 50); 
	  e7.size='15';
	  e7.onblur=function(){fillQtyIssuedForIssueCiv(iteration)};
	  
	  var e77 = document.createElement('input');
	  e77.type = 'hidden';
	  e77.name='<%=QTY_ISSUED%>';
	  e77.id = 'issuedQty'+iteration;
	  e77.size='15';
	  cellRight7.appendChild(e77);
	  cellRight7.appendChild(e7);

	
	  var cellRight5 = row.insertCell(++el);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.name='remarks'+iteration;
	  e5.className = 'buttonAdd';
	  e5.setAttribute('tabindex', 1); 
	  e5.onclick= function(){addRow('grid')};
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(++el);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.name='remarks'+iteration;
	  e6.setAttribute('tabindex', 1); 
	  e6.className = 'buttonDel';
	  e6.onclick= function(){removeRow('grid')};
	  cellRight6.appendChild(e6);
	  				 
}
function removeRow(idName)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;

    	for(var i=rowCount-1; i>0; i++) 
        {
        	var row = table.rows[i];
            if(i>1)
            {
            	table.deleteRow(i);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;
          

       }
       }catch(e)
       	{
           alert(e);
       }
      
}

function checkStockQty(val,rowVal)
{
	var lotNo=document.getElementById('lotNo'+rowVal).value;
	var stockIn=document.getElementById('stockIn'+rowVal).value;
	
	if(lotNo!="")
	{
		stockIn=parseInt(stockIn);
		val=parseInt(val);
		if(stockIn>0 && stockIn>val)
		{
			
		return true;	
		}else
		{
			alert("Please Check Stock!!");
			document.getElementById('issuedQtyTemp'+rowVal).value="";
			document.getElementById('issuedQtyTemp'+rowVal).focus();
			return false;
		}
	}
}

</script>



<script type="text/javascript">

function test(){
	var errorMessage="";
	formName="departmentIssueNE"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n"; 
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Issued To \n";
	
	
	if((document.getElementById('issuedBy').value != "")  &&(document.getElementById('departmentIdTemp').value != "") ){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
</script>
