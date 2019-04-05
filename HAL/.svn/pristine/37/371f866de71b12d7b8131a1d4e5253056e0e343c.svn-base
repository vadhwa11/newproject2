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
<%@page import="jkt.hms.masters.business.MasStoreMeScale" %>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>



<script language="javascript">
		
		//this function will be called by the Bean (not from JSP)
	
	function goPage(pidx) {	
	viewMeScaleForm.currPage.value = pidx;
	viewMeScaleForm.method="post";
	submitForm('viewMeScaleForm','neStores?method=getMeScaleData');
	}

		function openPopupWindow()
		{
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		if(meScaleMasterId ==0){
		alert("Please select ME Scale number..!")
		return false;
		}
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		var url="/hms/hms/neStores?method=viewMeScaleAdditionJsp&meScaleMasterId="+meScaleMasterId;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=950');
		}
		
	
		function upd()
		{
		var meScaleMasterId = document.viewMeScaleForm.<%=ME_SCALE_NUMBER %>.value;
		if(meScaleMasterId ==0){
		alert("Please select ME Scale number..!")
		return false;
		}
		
		viewMeScale.method="post";
		submitForm('viewMeScaleForm','neStores?method=updateGridItemsInViewMeScale');
		}
		
		function fillSrNo(rowVal){


			var pageNo=parseInt(document.getElementById('noOfRows').value);
		   		rowVal=rowVal%10
		   		if(rowVal==0){
		   			rowVal=10
		   	 		}
		   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
		 		  	document.getElementById('noOfRows').value=rowVal
					}
			return true;
		}
		function validate(){
			 var msg = "";
			if(document.getElementById('meScaleNumber').value == '')
	        {
				msg += "Please select the meScaleNumber";
				
			 }	
			if(msg!=''){
				alert(msg);
				return false;
			}
		return true;	
		 }



function validateDeleteButton()
{
	if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (viewMeScaleForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	viewMeScaleForm.method="post";
	submitForm('viewMeScaleForm','neStores?method=deleteMeScaleItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}


		</script>
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
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		Map map = new HashMap();
		String includedJsp = null;
		String previousPage="no";
		int pageNo=1;
		Box box=HMSUtil.getBox(request);
  		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		String userName = "";
		String PvmsNo="";
		int ItemId = 0;
		if(request.getAttribute("map") != null)
		{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		}
		if(map.get("searchMeScaleList") !=null){
			searchMeScaleList=(List<MasStoreMeScale>)map.get("searchMeScaleList");
		}
		if(map.get("box") !=null){
			box=(Box)map.get("box");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
		String title=(String)map.get("title");
    	
    	
		Vector<HashMap> meScaleItems= null;
		if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		try{
		if(box.getString("meScaleDesc").equals("") || box.getString("meScaleDesc") !=null ){
			if(map.get("meScaleDesc") !=null)
			box.put("meScaleDesc",""+map.get("meScaleDesc"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	 	}
			%>
<br />
<div class="titleBg">
 <h2 >ME Scale Equipment Details</h2>
</div>
<form name="viewMeScale" method="post">
<input type="hidden"
	name="numOfRows" size="5" value="5"> <input type="hidden"
	name="pageCount" size="5" value="10">
	<div class="Block">

<br>



<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
<input	type="hidden" name="hospitalId" value="<%=HOSPITAL_ID%>"
	id="hospitalId" /> <input type="hidden" name="departmentId"
	value="<%=DEPARTMENT_ID%>" id="departmentId" /> <input type="hidden"
	size="2" value="" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" />
	
	 <label	class="bodytextB">ME Scale No.<span>*</span></label>
	 <input type="text"  name="meScaleNumber" id="meScaleNumber" maxlength="4" value="" size="8" />
 <!--<select name="<%=ME_SCALE_NUMBER%>" 	onchange="submitForm('viewMeScaleForm','neStores?method=getMeScaleDescription');" />
	<option value="0">Select</option>
	<%
					for (MasStoreMeScale mEScaleNumber : searchMeScaleList) {
						System.out.println("mEScaleNumber.getId()   "+mEScaleNumber.getId());
					%>
	<option value=<%=mEScaleNumber.getId()%>
		<%=HMSUtil.isSelected(mEScaleNumber.getId().toString(),box.getString("meScaleNumber")) %>><%=mEScaleNumber.getMeScale()%></option>
	<% } %>
</select>
-->

<%-- <label class="bodytextB">ME Scale Description </label>
 <input type="text"	name="<%=ME_SCALE_DESCRIPTION%>" MAXLENGTH="200" cols="27" rows="2"	id="Authority" 	/>--%>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<h4>Item Details</h4>

<div class="cmntable">
<table width="200px" colspan="7" id="viewMeScale" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SL No.</th>
			<th width="10%">PVMS No.</th>			
			<th width="10%">Nomenclature</th>			
			<th width="10%">A/U</th>			
			<th width="10%">Quantity</th>
            <th width="10%"></th>
			<th width="10%"></th>
		    
		</tr>
		<%
		  int inc=0;
		inc= inc+1;
		String codeItem="codeItem";
		String idItem="idItem";
		String nameItem="nameItem";
		String idAu="idAu";
		%>
		<input type="hidden" name ="srNo"  id = "srNo" value=<%=inc %>  />
		<tr>
		   <td width="5%">
		   <input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%><%=inc %>" readonly="readonly" />
		    </td>
		    <td  width="10%">
		     <input type="text" size="8"  name="<%=ITEM_CODE %><%=inc%>" id="<%=codeItem%><%=inc%>" />
		    <input type="hidden" size="20" value="" name="<%=ITEM_ID%><%=inc%>" id="<%=idItem%><%=inc%>"  />
		    </td>
		    <td width="10%">
		   <input type="text" size="60" value="" name="<%=nameItem%>" id="<%=nameItem%>" onblur="if(fillSrNo('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}"    />
			      <div id="ac2update"	style="display: none;" class="autocomplete">
				</div>				
				
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForDefectiveDrugsByAutocompleteForMeScale',{parameters:'requiredField=<%=nameItem%>'});
			</script>
			</td>
			
		    <td width="10%">
		    <input type="text" name="AV<%=inc %>" value="" id="<%=idAu%><%=inc %>"     />
		    <input type="hidden" value="" class="smcaption"	readonly="readonly" name="AV<%=inc %>" id="<%=idAu%><%=inc %>" tabindex="1" />
		    </td>
		      <td width="10%">
		      <input type="text" name="qty<%=inc%>"  value="" id="qty<%=inc%>" />
		      </td>
		     
		   <td width="10%">
		    <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('grid');" tabindex="1" /></td>
		    <td width="10%"><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" /></td>
		</tr>
	</thead>
	<input type="hidden" name="hdb1" value="<%=inc %>" id="hdb1" />
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div style="float: left; padding-left: 15px;">
	<input type="button" name="sss" align="right" class="button" value="SAVE"
	onclick="if(validate()){submitForm('viewMeScale','neStores?method=submitMeScale');}" />
	<!--<input type="button" name="sss" class="button" value="PRINT" 
	onclick="submitForm('grnGrid','neStores?method=printWorkOrder');"	/>
	<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
	
	-->
	</div>
	</div>
	</form>
	<script type="text/javascript">

function generateRow(idName) {
	
	  var tbl = document.getElementById('viewMeScale');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('srNo');
	 // var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size='1.5';
	  e0.name='SR_NO'+iteration;
	  e0.id='SR_NO'+iteration
	  e0.value=iteration;	  
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  //ee5.name='itemId'+iteration;
	  ee5.name='itemId'+iteration;
	  ee5.id = 'idItem'+iteration;
	  
    
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e1.className = 'date';
	  //e1.setAttribute('readonly','readonly')	 
	  //e1.name='avic34Id'+iteration;
	  //e1.id='avic34Id'+iteration
	  //e1.name='ITEM_CODE'+ iteration;
      //e1.id='ITEM_CODE'+iteration;
      e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	 // e1.value=iteration;
	  e1.size='8';
	 // e1.setAttribute('onblur','checkForDefectiveDrugs(this.value, '<%=nameItem%>')');
      e1.setAttribute('maxlength', 30);
	 e1.setAttribute('tabindex','1');
	 cellRight1.appendChild(ee5);
	  cellRight1.appendChild(e1);
	  
	 
	  var cellRight2 = row.insertCell(2);
	        // var e3 = document.createElement('input');
	       //e3.type='text'
	      //  e3.size = '20'
	    var e2 = document.createElement('input');  
	    e2.type='text'; 
	    e2.name = 'nameItem';
	    e2.id = 'nameItem'+ iteration;	
	    e2.size='60';
	    
	    e2.onblur = function(){checkForDefectiveDrugs(this.value, 'nameItem',iteration)};
	   // e2.value=iteration; 
	    e2.setAttribute('tabindex','1')	   
	     cellRight2.appendChild(e2);

	    var newdiv = document.createElement('div');
	 	  newdiv.setAttribute('id', 'ac2update');
	 	 newdiv.style.display = 'none';
	 	  newdiv.className = "autocomplete";
		  cellRight2.appendChild(e2);
		  cellRight2.appendChild(newdiv);
		  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','neStores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=nameItem'});

	    
	  var cellRight3 = row.insertCell(3);
	 // var e4 = document.createElement('Select');
	  //e4.name = 'pNo'+ iteration;
	  //e4.id = 'pNo'+ iteration;
	  //e4.className='big';
	  //e4.setAttribute('tabindex','2');
	  //e4.options[0] = new Option('Select','Select');  
	  //e4.options[0] = new Option('OccupationalHazard','OccupationalHazard'); 
	  //e4.options[1] = new Option('SwimmingPool','SwimmingPool'); 
	  
	  var e3 = document.createElement('input');
	  //e3.name='au';
	  //e3.id='au'+iteration;
	  e3.name='AV';
	  e3.id = 'idAu'+iteration;
	  //e3.value=iteration;
	  e3.type='text';
	  e3.size = '20';
      cellRight3.appendChild(e3);
      
    
	 var cellRight4 = row.insertCell(4);
	 var e4= document.createElement('input');
     e4.name='qty'+iteration;
     e4.id='qty'+iteration;
     //e4.value=iteration;
     e4.type='text';
     e4.size='20'
     cellRight4.appendChild(e4);

         
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick','generateRow(viewMeScale);');	  
	  e5.setAttribute('tabindex','1');
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='remarks'+iteration;
	  e6.onclick = function(){removeRow();}
	  e6.setAttribute('tabindex','1');
	  cellRight6.appendChild(e6);
}
function removeRow()
{ 	
  var tbl = document.getElementById('viewMeScale');
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('viewMeScale');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('viewMeScale');
  	hdb.value=iteration
  }
}
function checkForDefectiveDrugs(val,a,inc)
{
      //alert("checkForDefectiveDrugs----->2222222222");
		//var pageNo =parseInt(document.getElementById('pageNo').value)
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    //var inc =1
	   // alert("checkForDefectiveDrugs"+pvms);
	   //ajaxFunctionForAutoCompleteInTurnOver('mmfDepartment','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
	    //ajaxFunctionForAutoCompleteInBoardofSurvey('viewMeScale','neStores?method=fillItemsForBoardofsurvey&pvmsNo=' + pvms , inc);
	    ajaxFunctionForAutoCompleteInMeScale('viewMeScale','neStores?method=fillItemsForMeScale&pvmsNo=' + pvms , inc);
}
</script>

	
<div class="clear" ></div>
<div class="clear" ></div>
<div class="clear" ></div>
<div class="bottom"></div>
<label class="bodytextB">Changed By:</label>
<input type="text" class="auto" size="10" value="<%=userName%>"/>

<label class="bodytextB">Changed Date:</label>
<input type="text" size="12" class="auto"  value="<%=date%>" />

<label class="bodytextB">Changed Time:</label>
<input type="text" size="8" class="auto" value="<%=time%>" />


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>