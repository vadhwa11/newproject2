<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.RequestConstants"%>

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	String deptName="&nbsp;";
	Date manu  = null;
	Date expiry = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String manufacturer = "";
	String url = "";
	String type="";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	
	if (map.get("type") != null) {
		type = (String)map.get("type");
	}
	List<MasUnit> unitList = new ArrayList<MasUnit> ();
	if (map.get("unitList") != null) {
		unitList = (List<MasUnit>)map.get("unitList");
	}
	List<MasDepartment> departList = new ArrayList<MasDepartment> ();
	if (map.get("departList") != null) {
		departList = (List<MasDepartment>)map.get("departList");
	}
	List<Object[]> storeInternalIndentMPOList = new ArrayList<Object[]>();
	if(map.get("storeInternalIndentMPOList")!=null){
		storeInternalIndentMPOList=(List)map.get("storeInternalIndentMPOList");
	}
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee> ();
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
%>
<% if (type.equals("UIssue")){ %>
<!-- 
<div id="testDivR2">
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
			<select name="departmentIdTemp" tabindex="1" id="departmentIdTemp" validate='Unit Name,num,Yes'  >
				<option value="">Select</option>
	<%for (MasUnit unit :unitList ) {	%>
		<option value=<%=unit.getId()%> ><%=unit.getUnitName()%></option>
	<%}	%>
</select>
<label>Indent No.</label>
<input type="text" name="indent" value="" id="indent" tabindex="1" />
 -->

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%}	%>
<!--  
<% if (type.equals("DIssue")){ %>
<div id="testDivR2">
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
			<select name="departmentIdTemp" tabindex="1" id="departmentIdTemp" validate='Department Name,num,Yes'  >
				<option value="">Select</option>
				<%for (MasDepartment department :departList ) {	%>
					<option value=<%=department.getId()%> ><%=department.getDepartmentName()%></option>
				<%}	%>
</select>

<%}	%>
-->
<form name="issueDispensaryForm" method="post">
<%-- Start of Main Form --%>
<%-- Title --%>

<div class="titleBg"><h2>Department/Unit Issue</h2></div>
<div class="Clear"></div>	

<h4>Issue Details</h4>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<div class="Block">
<% if (type.equals("FirstAidIssue")){ %>

<label> Dispensary Issue No. </label>
<input type="text" value="<%=map.get("issue") %>" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo"  MAXLENGTH="8" readonly />
<label>Issue Date</label>
<input type="text" class="date" name="<%=RequestConstants.ISSUE_DATE%>" id="<%= RequestConstants.ISSUE_DATE %>" readonly="readonly"  value="<%=map.get("date") %>"  MAXLENGTH="50" />

<div class="clear"></div>
	 <label class="medium">Department </label>
	 <input type="radio" name="Issue" value="DIssue" id="depart" class="radioAuto" maxlength="30" tabindex=1  onClick="getUnit(this.value)"/>
	 <label class="medium">Unit</label> 
	<input type="radio" name="Issue" value="UIssue" id="unit"  class="radioAuto" maxlength="20" tabindex=1  />
	 
			<select class="small2" name="departmentIdTemp" tabindex="1" id="departmentIdTemp" validate='Unit Name,num,no'  >
				<option value="">Select</option>
				<%for (MasUnit unit :unitList ) {	%>
					<option value=<%=unit.getId()%> ><%=unit.getUnitName()%></option>
				<%}	%>
</select>
 <label class="medium">First Aid </label>
	 <input type="radio" name="Issue" value="FirstAidIssue" id="FirstAidIssue" class="radioAuto" checked ="true" maxlength="30" tabindex=1  onClick="getFirstAid(this.value)"/>
	 <%
	 String firstAidDeptId = "0";
	   if(request.getParameter("deptId") != null)
	   {
		  firstAidDeptId = request.getParameter("deptId");
	   }
	   
	 
	 %>
	 <input type="hidden" value="<%out.print(firstAidDeptId); %>" name="firstAidDeptId" id="firstAidDeptId">
	 <label>Section Name<span>*</span> </label>
<input type="text" name="firstAidSectionName" value="" id="firstAidSectionName" tabindex="1" validate='Section Name,string,Yes' />
<div class="clear"></div>
<label>Indent No.</label>
<input type="text" name="<%= REQUEST_NO%>" value="" id="indent" tabindex="1" />

<label>Issued By<span>*</span></label>
<select name="<%= RequestConstants.ISSUED_BY%>" tabindex="1" id="issuedBy" validate="Issued By,String,no" onchange="if(testForAdjustLoanOut()&&cheackForSelect())submitForm('issueDispensaryForm','stores?method=searchIndentDetailsWithoutBar');">
					<option value="">Select</option>
					<%for (MasEmployee masEmployee :employeeList ) {
					String lastName="";
					if(masEmployee.getLastName() !=null){
					lastName=masEmployee.getLastName();
					}%>
				<option value=<%=masEmployee.getId()%> ><%=masEmployee.getFirstName()+" "+lastName+"  "+masEmployee.getRank().getRankName()%></option>
				<%}
				%>
				
</select>
 
<%}	%>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

	 <h4>Item Details</h4>
	 <div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">  
 	<table  colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
  	<thead>
   	 
     	<tr>

			<th width="5%">Sl  No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<!-- <th width="2%">B/G</th> -->
			
			<th width="13%">A/U</th>
			<th width="13%">Barcode</th> 				
			<th width="13%">Batch No.</th>
			<th width="13%">DOM</th> 			 
			<th width="13%">DOE</th> 
			<!-- <th width="13%">Source</th> --> 
			<th width="13%">Available</br>Stock</th>
			<th width="13%">Batch</br>Stock</th>
			<th width="13%">Qty</br>Demanded</th>
		<!-- 	<th width="13%">Qty On Loan</th> -->
			<th width="13%">Qty</br>Issued</th>
			<th width="13%">Balance</br>after Issue</th>
			<th width="3%">&nbsp;</th>
			<th width="3%">&nbsp;</th>
		</tr> 
      <!-- -
      <th width="6%">Loan Out Qty</th> -->
      <!--
       Loan Out Qty will be there for DIspensary Only
       If id in StoreSetup is equivalent to login Id then display this coloumn
       otherwise dont display.  
       -->
     
   </thead>
  <tbody>
		<%
			int inc = 1;
				try {
					int detailCounter = 10;
					int temp = 0;
					String idItem = "idItem";
					String codeItem = "codeItem";
					String nameItem = "nameItem";
					String idAu = "idAu";
					String qtyRequested = "qtyRequested";
					String loanOutQty = "loanOutQty";
					String incVar = "incVar";
					String issuedItemId = "issuedItemId";
					String batchNo = "batchNo";
					String batchId = "batchId";
					String barCodeNo = "barCodeNo";
					String batchNo2 = "batchNo";
					String batchId2 = "batchId";
					String barCodeNo2 = "barCodeNo";
					String expiryDate = "expiryDate";
					String expiryDate2 = "expiryDate";
					String idItem2 = "idItem";
					String codeItem2 = "codeItem";
					String nameItem2 = "nameItem";
					String idAu2 = "idAu";
					String qtyRequested2 = "qtyRequested";
					String loanOutQty2 = "loanOutQty";
					String incVar2 = "incVar2";
					String issuedItemId2 = "issuedItemId";
					String srNo = "srNo";
					String srNo2 = "srNo";
					String qtyIssued = "qtyIssued";
					String qtyIssued2 = "qtyIssued";
					String detailId = "detailId";
					String detailId2 = "detailId";
					String manuDate = "manuDate";
					String manuDate2 = "manuDate";

					//	inc=((pageNo-1)*20)+1;
					//	int tempVar=((pageNo-1)*20)+1;

					//   int incTemp2=inc+20;
					
					
					//inc = ((pageNo - 1) * indentTList.size()) + 1;
					//int tempVar = ((pageNo - 1) * indentTList.size()) + 1;

					//int incTemp2 = inc + indentTList.size();
					int incTemp2=10;
				//	for (Iterator iterator = indentTList.iterator(); iterator.hasNext();) {
							
						//Object[] object = (Object[]) iterator.next();

						//tempVar--;

						if (inc < incTemp2) {

							idItem = idItem2 + ("" + inc);
							codeItem = codeItem2 + ("" + inc);
							nameItem = nameItem2 + ("" + inc);
							idAu = idAu2 + ("" + inc);
							qtyRequested = qtyRequested2 + ("" + inc);
							incVar = incVar2 + ("" + inc);
							issuedItemId = issuedItemId2 + ("" + inc);
							qtyIssued = qtyIssued2 + ("" + inc);
							detailId = detailId2 + ("" + inc);
							loanOutQty = loanOutQty2 + ("" + inc);
							batchNo = batchNo2 + ("" + inc);
							batchId = batchId2 + ("" + inc);
							barCodeNo = barCodeNo2 + ("" + inc);
							expiryDate = expiryDate2 + ("" + inc);
							srNo = srNo2 + ("" + inc);
		%>

		<tr>
		
		 <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc%>' value="blank" readonly="readonly"/>
		 <input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
			<td width="5%"><input type="text" size="2" tabindex="1"	value="<%=inc%>" id="srNo<%=inc%>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" size="10" tabindex="1" 
				name="<%=RequestConstants.ITEM_CODE%>"	value="" id="pvmsNo<%=inc%>"  onblur="checkForIssueUnitPvms(this.value, '<%=RequestConstants.ITEM_CODE%>','<%=inc%>');"/>
				 <input	type="hidden" size="5" value="" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
				
				<input	type="hidden" size="2" value="" name="itemId<%=inc%>" 
				id="itemId<%=inc%>" />
				<input
				type="hidden" size="2" value=""
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />
				</td>
			<td width="10%"><input type="text" tabindex="1" size="50" value="" 
			    	name="<%=RequestConstants.NOMENCLATURE%>" id="nomenclature<%=inc%>" onblur="checkForIssueUnit(this.value, '<%=RequestConstants.NOMENCLATURE%>','<%=inc%>');"/>
			    	<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=<%=RequestConstants.NOMENCLATURE%>'});
			  
			</script>
			    	
			    	<!--  </td>
			    
			    <td width="2%"><input type="text" tabindex="1" size="2" value="" 
			   name="<%=RequestConstants.BRAND_GENERIC%>" id="BG<%=inc%>"/>
			    </td>-->
			    
			    <td width="5%"><input type="text" name="au<%=inc%>" id="au<%=inc%>"	size="7" readonly="readonly" value="" /></td>
			    
				<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=inc%>" 
			id="barCodeNo<%=inc%>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="getDataForBarcode(this.value,<%=inc%>)" /></td>
			
				
				
			<td width="10%">
			
			<select name="batchNo<%=inc%>" id="batchNo<%=inc%>" class="small3" onchange="getDataForBarcode(this.value,<%=inc%>)" >
			<option value="0">Select Batch</option>
			
			
			</select>
			
 
			<input type="hidden" name="batchId<%=inc%>" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId<%=inc%>" id="brandId<%=inc%>" size="10" readonly="readonly" value="" />
			</td>
			<td width="8%"><input type="text" name="manuDate<%=inc%>" id="manuDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			</td>
			<td width="8%"><input type="text" name="expiryDate<%=inc%>" id="expiryDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			<!-- <td width="8%"><input type="text" name="source<%=inc%>" id="source<%=inc%>"	size="10" readonly="readonly" value="" />
			</td> -->
			<td width="7%">
			<input type="text"
				 size="8" value="" id="stockAvailable<%=inc%>"
				class="medcaption" readonly /> </td>
				
				<td width="7%">
			 <input type="text"
				 size="8" value="" id="batchStock<%=inc%>"
				class="medcaption" readonly /> </td>
			
			
		
			<td width="10%">
			
			<input type="text" tabindex="1" size="8"
				value="" 
				name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc%>" id="<%=qtyRequested%>" />
			
			<%
				try {
			%>
			<input type="hidden" value="" tabindex="1"
				id="<%=nameItem%>" name="<%=nameItem%>" />
			<%
				} catch (Exception e) {
			%>
			<input type="hidden" value="" id="<%=nameItem%>" name="<%=nameItem%>" />
			<%
				}
			%>
			
			</td>
			
			<!-- <td width="8%"><input type="text"  size="10" name="qtyOnLoan<%=inc%>" id="qtyOnLoan<%=inc%>" value="" /> -->
		
			<td width="8%"><input type="text"  size="8" name="qtyIssued<%=inc%>" id="qtyIssued<%=inc%>" value="" onblur="if(checkQty(<%=inc %>)){setData(<%=inc %>)}" validate="Issue Qty,no,no"/>
			<td width="8%"><input type="text"  size="8" name="qtyAftrIssued<%=inc%>" id="qtyAftrIssued<%=inc%>" value="" />
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="addRowIssue(<%=inc%>);" /></td>
		<td width="8%"> 	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('indentDetails','hdb',this);"  tabindex="1" />
			</td>
			
		<input type="hidden" name="indentDtId" id="indentDtId<%=inc%>"  />
		</tr>
		<%
			inc++;
						}
					
					//	if(inc<=(pageNo-1)*20+20){
					//  for(;inc<=(pageNo-1)*20+20;inc++){
		%>
		
		<%
			//}}
					//}
					}catch (Exception e) {
					e.printStackTrace();
				}
				
		%>
	</tbody>
	<input type="hidden" name="hdb" value="1" id="hdb" />
	</table>
	</div>
	<input type="button" class="button" tabindex="1" onclick="if(validateIssue()){submitForm('issueDispensaryForm','stores?method=submitIssueForFirstAid');}" name="Submit2" value="Save"  />
	<!-- <input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> --> 
<input type="hidden" id="counter" value="<%=inc%>" />
</form>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<script type="text/javascript">
function getUnit(val){
	// var ele = document.getElementById("toggleText");
	
	
		
		submitForm('issueDispensaryForm','stores?method=showIssueDispWithoutBarCodeJsp');
		
	
 }


//javed khan
function checkForIssueUnit(val,a,inc)
{
	
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		   
	   // alert("checkForDefectiveDrugs"+pvms);
	    ajaxFunctionForAutoCompleteInUnitIssue('issueDispensaryForm','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}

//javed khan
function checkForIssueUnitPvms(val,a,inc)
{
	
		   
	   // alert("checkForDefectiveDrugs"+pvms);
	    ajaxFunctionForAutoCompleteInUnitIssuePvms('issueDispensaryForm','stores?method=fillItemsForDefectiveDrugs&pvmsNo='+val , inc);
		
}

function ajaxFunctionForAutoCompleteInUnitIssue(formName,action,rowVal) {
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
	      
	      	
	      	var batchId="batchNo"+rowVal;
			      
			obj = document.getElementById(batchId);
			obj.length = 1;
	      
					
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var brandLength  = item.getElementsByTagName("brands")[0];
		         var batchLength  = item.getElementsByTagName("batchsForTurn")[0];
	        
	        	var stock = item.getElementsByTagName("stock")[0];
	        	document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	        	
	        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
	        	//document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	//document.getElementById('batchNo'+rowVal).value = batchno.childNodes[0].nodeValue
	        	//document.getElementById('expiryDate'+rowVal).value = expirydate.childNodes[0].nodeValue 
	        	//document.getElementById('stockId'+rowVal).value = BatchStockId.childNodes[0].nodeValue 
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchIdForTurn")[0];
		        	var batchName  = batch.getElementsByTagName("batchNameForTurn")[0];
		        	obj.length++;
		        	// change by javed khan
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        
	        		
	      	} 
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }


// javed khan

function ajaxFunctionForAutoCompleteInUnitIssuePvms(formName,action,rowVal) {
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
	      
	      	
	      	var batchId="batchNo"+rowVal;
			      
			obj = document.getElementById(batchId);
			obj.length = 1;
	      
					
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];

		   	 var nomen  = item.getElementsByTagName("nomen")[0];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var brandLength  = item.getElementsByTagName("brands")[0];
		         var batchLength  = item.getElementsByTagName("batchsForTurn")[0];
	        
	        	var stock = item.getElementsByTagName("stock")[0];
	        	document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	        	
	        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('nomenclature'+rowVal).value = nomen.childNodes[0].nodeValue+"["+pvms.childNodes[0].nodeValue+"]"
	        	//document.getElementById('batchNo'+rowVal).value = batchno.childNodes[0].nodeValue
	        	//document.getElementById('expiryDate'+rowVal).value = expirydate.childNodes[0].nodeValue 
	        	//document.getElementById('stockId'+rowVal).value = BatchStockId.childNodes[0].nodeValue 
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchIdForTurn")[0];
		        	var batchName  = batch.getElementsByTagName("batchNameForTurn")[0];
		        	obj.length++;
		        	// change by javed khan
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        
	        		
	      	} 
	      }
	    }
	    var url=action+"&"+getNameAndData(formName)
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
function getDataForBarcode(val,rowVal){
	

	 if(val!=""){
		 var itemId=document.getElementById('itemId'+rowVal).value;
		// alert(itemId);
		 //alert(val);
			submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
	
	 }
	 }


function submitProtoAjaxForBarcodeData(formName,action,rowVal)
{
	  //alert("submitProtoAjax");
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
	      if(xmlHttp.readyState==4)
		  {

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
	        	
	        	document.getElementById("qtyIssued"+rowVal).focus();
	        	
	        	document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Invalid Barcode ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }


//add  javed khan
function addRow(){
  
	  var tbl = document.getElementById('indentDetails');
	 
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo1'+iteration;
	  e1.id='pvmsNo'+iteration
	  e1.size='10';
	  e1.setAttribute('tabindex','1');
	 // e1.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e1);

	  var sel11 = document.createElement('input');
	  sel11.type = 'hidden';
	  sel11.name='itemId'+iteration;
	  sel11.id='itemId'+iteration
	  sel11.size = '10';
	  sel11.setAttribute('tabindex','1');
	  cellRight1.appendChild(sel11);
	  
	  
	//  alert("1---");
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
	e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur=function(){checkForReturnDispensary(this.value, document.getElementById('nomenclature'+iteration).value,iteration)}
	  var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
   	newdiv.style.display = 'none';
	
  e2.size = '30';
	//  alert("3-1--");
	  e2.setAttribute('tabindex','1');
	//  alert("3-2--");
	            cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=Nomenclature'+iteration});
	   //alert("name--"+e0.name)
 //alert("4---");
	    
	//  alert("5---");
	
	 var cellRight3 = row.insertCell(3);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='au'+iteration;
	  e11.id='au'+iteration
	  e11.size='5';
	  e11.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight3.appendChild(e11);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '5';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	  var cellRight5 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.name='bar'+iteration;
	  e21.id='bar'+iteration;
	  //e21.classname='smalllabel';
	 // e21.setAttribute('tabindex','1');
	  e21.size = '9';
	  e21.onBlur=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  cellRight5.appendChild(e21);
	 
	 
	 
	 
	  var cellRight51 = row.insertCell(5);
	  var e215 = document.createElement('Select');
	  e215.name='batchId'+iteration;
	  e215.id='batchId'+iteration;
	  e215.className="small3"
	 // e21.setAttribute('tabindex','1');
	  e215.options[0] = new Option('Select', '0');
	  e215.onchange=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  cellRight51.appendChild(e215);
	  



	   

	  var cellRight611 = row.insertCell(6);
	  var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.className='date';
	  e51.name='manuDate'+iteration;
	  e51.id='manuDate'+iteration;
	  e51.size='12';
	  e51.setAttribute('maxlength', 10); 
	  e51.setAttribute('tabindex','1');
	  cellRight611.appendChild(e51);
	  

	  var cellRight61 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.className='date';
	  e5.name='expiryDate'+iteration;
	  e5.id='expiryDate'+iteration;
	  e5.size='12';
	  e5.setAttribute('maxlength', 10); 
	  e5.setAttribute('tabindex','1');
	  cellRight61.appendChild(e5);

	  var cellRight612 = row.insertCell(8);
	  var e512 = document.createElement('input');
	  e512.type = 'text';
	  e512.className='date';
	  e512.name='manuf'+iteration;
	  e512.id='manuf'+iteration;
	  e512.size='18';
	  e512.setAttribute('maxlength', 10); 
	  e512.setAttribute('tabindex','1');
	  cellRight612.appendChild(e512);

/*

	 // var cellRight311 = row.insertCell(6);
		 var e311 = document.createElement('img');
	     e311.src = '/hms/jsp/images/cal.gif';
	    // e3.style.display ='none';
	     e311.id = 'calId'+iteration;
	     e311.onclick = function(event){
	     setdate('',document.getElementById('expiryDate'+iteration),event) };
	     cellRight61.appendChild(e311);
		 */
	  
	  var cellRight6 = row.insertCell(9);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='issueQty'+iteration;
	  e4.id='qtyIssued'+iteration;
	  e4.size='8';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur=function(){fillValue(this.value,iteration)};
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);




	  var cellRight10 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick', 'removeRow("stockDetails","hdb",this);'); 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);


	  

	}


function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}
function checkQty(rowVal)
{// javed khan
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			alert("Qty Issued can't be greater than Qty Demanded.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
			return false;
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('batchStock'+rowVal).value))
		{
			alert("Qty Issued can't be greater than Batch stock Quantity .");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
			return false;
		}else{
					var a=document.getElementById('qtyIssued'+rowVal).value;
				var b=document.getElementById('batchStock'+rowVal).value;
        	
			document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
			return true;
		}
		return true;
}	


//add by javed khan
function setData(rowVal)
{
	var sum = 0;
  	var totalQtyInHand = 0;
  	var totalAmt = 0;
  	var saleTax = 0;
	var saleTaxAmt = 0;
	var netSaleTax = 0;
	var uom ='';
	var qq="";
	var ss="";
	var inSum=0;
	var totalRows=parseInt(document.getElementById('counter').value);
	
	//var rowVal=parseInt(document.getElementById('rowVal').value);
	//var issueQty = parseInt(document.getElementById('issueQty').value);
 	for(var index = rowVal; index <= rowVal; index++ ){
 	
 		var qtyIssuedObj = eval(document.getElementById('qtyIssued'+index));
 		//alert("totalRows3>>"+document.getElementById('qtyIssued'+index).value)
 		//alert(document.getElementById('qtyIssued'+index).value+"------"+document.getElementById('bbatch'+index).value)
			//sum = parseFloat(sum) + parseInt(qtyIssuedObj.value);
 			if(parseInt(document.getElementById('qtyIssued'+index).value)!="0" ){
 	 			//alert("setData"+document.getElementById('qtyIssued'+index).value);
 	 			//alert("setData"+	document.getElementById('costPrice'+index).value);
			qq=qq+','+document.getElementById('qtyIssued'+index).value
								+'@'+
								document.getElementById('batchNo'+index).value
								+'@'+
								document.getElementById('expiryDate'+index).value
								+'@'+
								document.getElementById('batchId'+index).value
								+'@'+'null';
								//document.getElementById('costPrice'+index).value;
 				}//alert("qq---"+qq);
 			
		document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);
		}
 	
		if(qq.length == 0){
			document.getElementById('issueQtyAndBatch'+rowVal).value = "blank";
		} else{
			document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);
		}

		var totalQtyIssued = eval(document.getElementById('quantityToIssueOverAll'));
		if(sum == 0){
			totalQtyIssued.value = '0';
		}else{
			totalQtyIssued.value = sum;
		}
		
		if(parseInt(totalQtyIssued.value)>parseInt(document.getElementById("reqQty").value)){
			alert('Qty Issued Value Should be less than or Equal to Requested Qty');
		 return false;
		}
 		//window.opener.document.getElementById('qtyIssued'+rowVal).value=totalQtyIssued.value;
 		
		//close();
 		return true;
}


function validateIssue()
{

	if(document.getElementById("firstAidSectionName").value=="")
	{
		alert('Enter the Section Name');
		document.getElementById("firstAidSectionName").focus();
		return false;
	}
	/*if(document.getElementById("requestBy").value=="")
	{
		alert('Select The Requested BY !!!');
		document.getElementById("requestBy").focus();
		return false;
	}*/
	//if(document.getElementById("approvedBy").value=="")
	//{
	//	alert('Select The Approved By !!!');
	//	document.getElementById("approvedBy").focus();
	//	return false;
	//}

	if(document.getElementById("issuedBy").value=="")
	{
		alert('Select The Issued By !!!');
	document.getElementById("issuedBy").focus();
		return false;
	}

	/*if(document.getElementById("indent").value=="")
	{
		alert('Type The indent No !!!');
		document.getElementById("indent").focus();
		return false;
	}else{
		return true;
	}*/
	return true;
}


function addRowIssue(rowVal)
{
	  var tbl = document.getElementById('indentDetails');
	 
	  //var deptId = document.getElementById('deptId').value;
	 /* var listSize=document.getElementById('listsize').value;
	  listSize=(parseInt(listSize))+1;*/
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	 
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	 
	 // var iteration = listSize;		 
	
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var e1111 = document.createElement('input');
	  e1111.type = 'hidden';
	  e1111.name='tt8';
	  e1111.id = 'issueQtyAndBatch'+iteration;
	  e1111.value="blank"; 
	  cellRight0.appendChild(e1111);

	  var e11111 = document.createElement('input');
	  e11111.type = 'hidden';
	  e11111.name='tt6';
	  e11111.id = 'quantityToIssueOverAll'+iteration;
	  e11111.value=""; 
	  cellRight0.appendChild(e11111);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemCode'+iteration;
	  e1.id = 'pvmsNo'+iteration;
	  e1.size='10';
	  e1.onblur=function(){checkForIssueUnitPvms(this.value, document.getElementById('pvmsNo'+iteration).value,iteration)}
	  //e1.value=document.getElementById('codeItem'+rowVal).value;
	  
	  cellRight1.appendChild(e1);
	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	 // e11.value=document.getElementById('itemId'+rowVal).value; 
	  cellRight1.appendChild(e11);

	  var e114 = document.createElement('input');
	  e114.type = 'hidden';
	  e114.name='detailId'+iteration;
	  e114.id = 'detailId'+iteration;
	  //e114.value=document.getElementById('idItem'+rowVal).value; 
	  cellRight1.appendChild(e114);

	  var cellRight2 = row.insertCell(2);
	 var e2 = document.createElement('input');
	  e2.type = 'text';
	  /*e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;
	  e2.readOnly=true;
		 
	 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
		
	  cellRight2.appendChild(e2);*/

	  e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur=function(){checkForIssueUnit(this.value, document.getElementById('nomenclature'+iteration).value,iteration)}
	  var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
   	newdiv.style.display = 'none';
	e2.size = '50';
		e2.setAttribute('tabindex','1');
	  cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=Nomenclature'+iteration});

	  var cellRight227 = row.insertCell(3);
	  var e227 = document.createElement('input');
	  e227.type = 'text';
	  e227.name = 'au' + iteration;
	  e227.id = 'au' + iteration;
	  e227.size = '7';
	  //e227.value=document.getElementById('idAu'+rowVal).value;
	  e227.readOnly=true;
	  cellRight227.appendChild(e227);
	  			 
	  var cellRight22 = row.insertCell(4);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'barCodeNo' + iteration;
	  e22.id = 'barCodeNo' + iteration;
	  e22.size = '8';
	//  e22.value=document.getElementById('idAu'+rowVal).value;
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);
	  
	  
	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('Select');
	  //e23.type = 'text';
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.className="small3";
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.onchange=function(){getDataForBarcode(this.value,iteration)};
  //for(var i = 0;i<batchArray.length;i++ ){
	     //e23.options[i+1] = new Option(batchArray[i][1],batchArray[i][0]);
		             // e23.options[i+1] = new Option(document.getElementById('batchNo'+rowVal).option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML,document.getElementById('batchNo'+rowVal)option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML);
	   // }
	//  e23.readOnly=true;
	 cellRight23.appendChild(e23);

	 var e246 = document.createElement('input');
	  e246.type = 'hidden';
	  e246.name = 'batchId' + iteration;
	  e246.id = 'batchId' + iteration;
	  e246.size = '10';
	  cellRight23.appendChild(e246);
	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	  cellRight23.appendChild(e24);


	  var cellRight30 = row.insertCell(6);
	  var e30 = document.createElement('input');
	  e30.type = 'text';
	  e30.name = 'manuDate' + iteration;
	  e30.id = 'manuDate' + iteration;
	  e30.size = '10';
	  e30.readOnly=true;	  
	  cellRight30.appendChild(e30);
	  	  
	  var cellRight25 = row.insertCell(7);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);

	 /* var cellRight251 = row.insertCell(8);
	  var e251 = document.createElement('input');
	  e251.type = 'text';
	  e251.name = 'manufact' + iteration;
	  e251.id = 'manufact' + iteration;
	  e251.size = '10';
	  e251.readOnly=true;	  
	  cellRight251.appendChild(e251);*/
	  
	  
	  var cellRight6 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.size = '8';
	  //e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);

	 // var cellRight34 = row.insertCell(8);
	  //var e34 = document.createElement('input');
	// e34.type = 'text';
	 // e34.name = 'qtyIssued' + iteration;
	 // e34.id = 'qtyIssued' + iteration;
	  //e34.size = '10';

	 // if(document.getElementById('qtyIssued'+rowVal).value=="")
	  //{	  
	  // e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	 // }else
		 // e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
	   
	   //cellRight34.appendChild(e34);
	   
	   
	   
	   var cellRight2212 = row.insertCell(9);
	  var e2212 = document.createElement('input');
	  e2212.type = 'text';
	  e2212.name = 'batchStock' + iteration;
	  e2212.id = 'batchStock' + iteration;
	  e2212.size = '8';
	  //e2212.value=document.getElementById('batchStock'+rowVal).value;
	  e2212.readOnly=true;
	  cellRight2212.appendChild(e2212);
	   
	   
	   var cellRight221 = row.insertCell(10);
	  var e221 = document.createElement('input');
	  e221.type = 'text';
	  e221.name = 'qtyRequest' + iteration;
	  e221.id = 'qtyRequested' + iteration;
	  e221.size = '8';
	 // e221.value=document.getElementById('qtyRequested'+rowVal).value;
	  //e221.readOnly=true;
	  cellRight221.appendChild(e221);
	  
	  var cellRight35 = row.insertCell(11);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '8';
	  e35.onblur = function(){if(checkQty(iteration)){setData(iteration)}};
	  cellRight35.appendChild(e35); 

	  var cellRight3333 = row.insertCell(12);
	  var e3333 = document.createElement('input');
	  e3333.type = 'text';
	  e3333.name = 'qtyAftrIssued' + iteration;
	  e3333.id = 'qtyAftrIssued' + iteration;
	  e3333.size = '8';
	 // e3333.value=document.getElementById('qtyRequested'+rowVal).value;
	  e3333.readOnly=true;
	  cellRight3333.appendChild(e3333);
	  

	  var cellRight10 = row.insertCell(13);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='Button';
	 // alert(this.value+"iteration.> "+iteration )
	 e8.setAttribute('onClick', 'addRowIssue(this.value);'); 
	// e8.onClick = function(){addRowIssue(iteration)};
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(14);
	  var e91 = document.createElement('input');
	  e91.type = 'button';
	  e91.className = 'buttonDel';
	  e91.name='remarks'+iteration;
	  e91.setAttribute('onClick', 'removeRow("indentDetails","hdb",this);'); 
	  e91.setAttribute('tabindex','1');
	  cellRight11.appendChild(e91);
	  
	   
	 document.getElementById('listsize').value=listSize;
}
// javed khan
function cheackForBatch(rowVal){
    // alert(rowVal+" --- "+document.getElementById("batchNo"+rowVal).value)
		if(rowVal>1){
	for(i=1;i<rowVal;i++){
		//alert(i+" --i- "+document.getElementById("batchNo"+i).value)
		if(document.getElementById("batchNo"+rowVal).value==document.getElementById("batchNo"+i).value)
		{
			alert("Please select another Batch !!!");
			document.getElementById("batchNo"+rowVal).value="0";
			return false;
		
		}
	
	}
		
}
	return true;
}

function getFirstAid(val){
	// var ele = document.getElementById("toggleText");
	//alert(val);
	
		var issue_no= document.getElementById('issueNo').value;
		var date = document.getElementById('issueDate').value;
		//submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
		submitForm('issueDispensaryForm','stores?method=getFirstAid&type='+val+'&deptId=120&issue='+issue_no+'&date='+date);
		//document.getElementById('departmentIdTemp').style.visibility = "hidden";
		//document.getElementById('requestNo').style.visibility = "hidden";
		//ele.style.display = "none";	

	if(val != null  && document.getElementById('depart').value==val ){
		
		submitProtoAjaxdiv2('issueDispensaryForm','stores?method=getUnit&type='+val);
		document.getElementById('departmentIdTemp').style.visibility = "visible";
		//document.getElementById('requestNo').style.visibility = "visible";
		//ele.style.display = "block";	 
	}
	
 }

</script>



