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
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot" %>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>


<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<%
	
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
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<MasStoreSupplier>	supplierList=new ArrayList<MasStoreSupplier>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
		String  maxIndentNo="";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
		System.out.print("  indentId    "+indentId);
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	//Header Information
	if(map.get("patientDetails")!=null)
		patientDetails=(""+map.get("patientDetails"));
	
	if(map.get("itemReqDept")!=null)
		itemReqDept=Integer.parseInt((""+map.get("itemReqDept"))) ;

	if(map.get("pacEqpt")!=null)
		pacEqpt=(""+map.get("pacEqpt"));

	if(map.get("pacJustification")!=null)
		pacJustification=(""+map.get("pacJustification"));

	if(map.get("dose")!=null)
		dose=Integer.parseInt((""+map.get("dose"))) ;

	if(map.get("days")!=null)
		days=Integer.parseInt((""+map.get("days"))) ;

	if(map.get("course")!=null)
		course=Integer.parseInt((""+map.get("course"))) ;

	if(map.get("duration")!=null)
		duration=Integer.parseInt((""+map.get("duration"))) ;

	if(map.get("durationType")!=null)
		days=Integer.parseInt((""+map.get("durationType"))) ;

	if(map.get("PvmsAlreadyPrescribed")!=null)
		PvmsAlreadyPrescribed=((""+map.get("PvmsAlreadyPrescribed"))) ;
	
	if(map.get("justificationNiv")!=null)
		justificationNiv=((""+map.get("justificationNiv"))) ;
	
	if(map.get("clinicalTrailReq")!=null)
		clinicalTrailReq=((""+map.get("clinicalTrailReq"))) ;

	
	//End of Header Information 
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	
	if(map.get("supplierList")!=null)
		supplierList = (List) map.get("supplierList");
	
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
	 if(map.get("sectionList")!=null)
			storeSectionList = (List<MasStoreSection>)map.get("sectionList");
	 String hospitalName = "";
	 if(map.get("hospitalName") != null){
		 hospitalName = (String)map.get("hospitalName");
	 }
	 
%>
<script language="javascript">
function checkForSocNe(val){

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForcheckForSocNe('indentToSoc','nonExp?method=chackForItemExistence&pvmsNo=' + pvms);
}
function testInt(val){
	if(validateInteger(val)){
	alert("y")
	}else{
	alert("n")
	}
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


<div class="clear"></div>



<form name="indentToSoc" method="post" >

<div class="clear"></div>
<div class="Block">
<h2 align="left" class="style1">Indent To Depot</h2>
<div class="clear"></div>

<label class="bodytextB"> Indent No. </label> 
      <input	type="text" name="<%=RequestConstants.INDENT_NO %>"
	       value="<%=maxIndentNo%>" readonly="readonly" class="textbox_size20"	MAXLENGTH="8" />
<label class="bodytextB">Indent Date </label>
	   <input type="text"	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	       value="<%=date%>" class="textbox_size20" MAXLENGTH="30" />
<%--<label	class="bodytextB"> Command</label> 
	   <input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value=""
	       class="textbox_size20" MAXLENGTH="20" />
--%><label class="bodytextB">SMC/Unit Address</label>
          <textarea name="<%=RequestConstants.INDENT_FROM%>" cols="25" rows="2"
	              class="txtarea" validate="Hosp/Unit Addr ,metachar,no"
	               onKeyPress="limitText(this,70);"><%=hospitalName %></textarea> 
<label class="bodytextB">Supply Depot</label> 
	      <select	name="<%=SUPPLY_DEPOT%>" id="supplyDepot"	validate="Supply Depot,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
		<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),map.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select> 

            <div class="clear"></div>
            <div class="clear"></div>
<label class="auto_text"> Life Span</label>

<select name="lifeType" id="lifeType" onChange="" tabindex=1
	validate=" Life Span,metachar,no">
	
	<option value="a">Select</option>
	
	<!-- <option value="SLB">SLB</option> -->
	<option value="LL">LL</option>
	<option value="SL">SL</option>
	</select>
	
	<!-- javed add section  -->
	
	<label>Section</label>

				<select id="sectionId1" name="sectionId"   onchange="" tabindex=1>
			  <option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				  	</select>






</div>
<div class="Clear"></div>
<%--<label class="bodytextB">Nomenclature of Item </label>
            <input type="text" value="" tabindex="1"	id="<%=RequestConstants.ITEM_NAME%>"
	               onblur="checkForSocNe(this.value);" class="bigcaption"
	                 validate="Item name ,string,yes" name="<%=RequestConstants.ITEM_NAME%>"
	                MAXLENGTH="256" />
             <div id="ac2update"
        	style="display: none; padding-right: 550px; background-color: white;"></div>
       <script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('<%=RequestConstants.ITEM_NAME%>','ac2update','stores?method=getItemListForMMFIndent',{parameters:'requiredField=<%=RequestConstants.ITEM_NAME%>&mmfForTheYear=0' });
						</script>
						</div>
						--%>
						
					<div class="clear"></div>	
					<h4>Item Details</h4>	
					<div class="cmntable">
<table width="200px" col="7" id="grid" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="8%">PVMS/NIV No.</th>
			<th width="15%">Nomenclature</th>
		    <th width="9%">A/U</th>			
			<th width="9%">Qty In Stock</th>
			<th width="23%">Qty Auth </th>
			<th width="23%">Qty Demanded</th>
			<th width="23%">Add</th>
			<th width="23%">Delete</th>
			
		</tr>

	</thead>
	<tbody>


		<%
		int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";   	
    	String qtyInHand="qtyInHand";
    	//String idItem2="idItem2";
    	//String codeItem2="codeItem";
    	//String nameItem2="nameItem";
    	int inc = 0;
    	inc = inc+1;
    	  %>
		<tr>
			<input type="hidden" name="gridSize" id="gridSize" value="<%=inc %>"/>
			
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				class="smcaption" name="<%=SR_NO%><%=inc %>" id="srNo" readonly="readonly" /></td>
			<td width="10%">
			<input type="text" size="8" name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%><%=inc%>" />
				<input type="hidden" size="2" value="0" name="<%=ITEM_ID%><%=inc%>" id="<%=idItem%><%=inc%>" />
              </td>
			<td width="10%">
			 <input type="text" size="60" value="" name="<%=nameItem%><%=inc %>" id="<%=nameItem%><%=inc%>" onblur="checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');"></input>
			      <div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem%><%=inc %>','ac2update','neStores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%><%=inc %>'});
			</script>
			</td>
		     <td width="10%">
			<input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%><%=inc %>" id="<%=idAu%><%=inc %>" tabindex="1" />
				</td>
			
		
			
			<td width="10%">
			<input type="text"  size="8" 
				  name="<%=QUANTITY_RECEIVED%><%=inc %>"   id="stockAvailable<%=inc%>" tabindex="1"  maxlength="10" />
				
				</td>


			<td width="23%"><input type="text" value="" size="20"
				 id="qtyAuth<%=inc%>" name="qtyAuth<%=inc %>" tabindex="1" maxlength="149"
				onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" /></td>

				<td width="23%"><input type="text" value="" size="25"
				 id="qtyDemanded<%=inc%>" name="qtyDemanded<%=inc %>" tabindex="1" maxlength="100"
				onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" /> 
						</td>
						 <td width="10%">
		    <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow('grid');" tabindex="1" /></td>
		    <td width="10%"><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" /></td>
				
			
		</tr>


	</tbody>
</table>
</div>
			
			<div class="division"></div>
						
        <input type="hidden" name="<%=RequestConstants.INDENT_ID %>"	value="<%=indentId%>" id="indentId" /> 
	 <input type="button" name="sss" align="right" class="button" value="Submit"
	onclick="{submitForm('indentToSoc','nonExp?method=addNextOrSubmitIndentToSOC&buttonName=submit');}" />



<div class="clear"></div>



	</div>
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


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</form>
<div class="clear"></div>

<script type="text/javascript">

function checkForDefectiveDrugs(val,a,inc)
{
       // alert("checkForDefectiveDrugs----->2222222222");
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
	  ajaxFunctionForAutoCompleteIndentToDepot1('indentToSoc','neStores?method=fillItemsForIndentToDepot1&pvmsNo=' + pvms , inc);

}

function generateRow(idName) {
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  //var iteration = parseInt(hdb.value)+1;
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
	  ee5.name='itemId'+iteration;
	  ee5.id = 'idItem'+iteration;
	  ee5.value = 0;
	  
	  
  
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='8';
      e1.setAttribute('maxlength', 30);
	  e1.setAttribute('tabindex','1');
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(e1);
	  
	 
      var cellRight2 = row.insertCell(2);
      var e2 = document.createElement('input');  
      e2.type='text'; 
      e2.name = 'nameItem'+iteration;
      e2.id = 'nameItem'+ iteration;	
      e2.size='60';
      e2.onblur = function(){checkForDefectiveDrugs(this.value, 'nameItem',iteration)};
      e2.setAttribute('tabindex','1')	   
      cellRight2.appendChild(e2);

      var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update');
 	  newdiv.style.display = 'none';
 	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','neStores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=nameItem'+iteration});

	    
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.name='AV';
	  e3.id = 'idAu'+iteration;
	  e3.type='text';
	  e3.size = '20';
      cellRight3.appendChild(e3);
    
  
	  var cellRight4 = row.insertCell(4);
	  var e4= document.createElement('input');
      e4.name='<%=QUANTITY_RECEIVED%>'+iteration;
      e4.id='stockAvailable'+iteration;
      e4.type='text';
      e4.size='20'
      cellRight4.appendChild(e4);

      var cellRight5 = row.insertCell(5);
	  var e41= document.createElement('input');
      e41.name='qtyAuth'+iteration;
      e41.id='qtyAuth'+iteration;
      e41.type='text';
      e41.size='20'
      cellRight5.appendChild(e41);

      var cellRight6 = row.insertCell(6);
	  var e42= document.createElement('input');
      e42.name='qtyDemanded'+iteration;
      e42.id='qtyDemanded'+iteration;
      e42.type='text';
      e42.size='20'
      cellRight6.appendChild(e42);

       
	  var cellRight7 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonAdd';
	  e5.name='remarks'+iteration;
	  e5.setAttribute('onClick','generateRow(grid);');	  
	  e5.setAttribute('tabindex','1');
	  cellRight7.appendChild(e5);

	  var cellRight8 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonDel';
	  e6.name='remarks'+iteration;
	  e6.onclick = function(){removeRow();}
	  e6.setAttribute('tabindex','1');
	  cellRight8.appendChild(e6);
}
function removeRow()
{ 	
var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
if (lastRow > 1){
	tbl.deleteRow(lastRow - 1);
	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow - 1;
	var hdb = document.getElementById('grid');
	hdb.value=iteration
}
}

</script>



