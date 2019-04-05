<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />

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
	
	<form name="SanitaryRound" action="" method="post">

   <% Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");%>
	
	
<div class="titleBg"><h2>Sanitary Round</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label>Sanitary Round Type </label>	

	<select id="sinceId" name="sanitarytype"	validate="Sanitary Round Type,string,yes" tabindex="1" >
	<option value="0">Select</option>
    <option value="Daily"> Daily </option>
    <option value="Surprise"> Surprise</option>
    <option value="Monthly"> Monthly</option>
    
</select>

<label>Date </label>	
<input type="text"	id="saniatrydate" name="saniatrydate" tabindex="1" value="<%=currentDate %>"	readonly="readonly" validate="commission Date,date,no" MAXLENGTH="30"	class="date" onblur="calculateTotalService(this.value);" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  onClick="setdate('<%=currentDate %>',document.SanitaryRound.saniatrydate,event)" />
		
</div>

<div class="clear paddingTop15"></div>
<h4>Sanitary Inspection Carried Out by</h4>


<table	id="Grid" class="cmntable">
	<tr>
	    <th>Service No.</th>
		<th>Name</th>
		<th>Branch/Trade</th>
		<th>Designation</th>
		<th>Classification/Speciality</th>
		<th>Area</th>
		<th>Place</th>
		<!-- <th>Add</th>
		<th>Delete</th> -->
	</tr>
	<%
	int inc=1;
	%>
	
		<tr>
		<td>
		
		<input type="text" name="<%=SERVICE_NO %>"  validate="Service No,string,no" id="serviceNoId" value=""
		onblur="ajaxFunctionSHOService(SanitaryRound,<%=inc %>,this.value);" />
		</td>		
   
   <!--<td><input  type="text" name="hinOfSanitaryRound" validate="name , string,no" id="hinOfSanitaryRound<%=inc %>" value="" /></td>
		-->
		
		
		<td>
		<input  type="text" name="nameofSanitaryRound" validate="name , string,no" id="nameofSanitaryRound<%=inc %>" value="" />
		<input type="hidden" name="itemId" validate="name , string,no" id="itemId<%=inc %>" value="" />
		<input type="hidden" name="hinId<%=inc %>" id="hinId<%=inc %>" value=""/>
		</td>
		
		<td>
        <input  type="text" name="sanitaryBranch" validate="sanitaryBranch , string,no" id="sanitaryBranch<%=inc %>" value="" />
        <input type="hidden" name="branchId<%=inc %>" id="branchId<%=inc %>" />
		</td>
		
	
		<td>
		<input   type="text" name="sanitaryDesignation" validate="name , string,no" id="sanitaryDesignation<%=inc %>" value="" />
		</td>
		
		<td>
        <input  type="text" name="sanitaryClassification" validate="name , string,no" id="sanitaryClassification<%=inc %>" value="" maxlength="50" />
		</td>
		
		<td>
		<input  type="text" name="sanitaryarea" validate="name , string,no" id="nameofSchoolId<%=inc %>" value="" maxlength="50" />
		</td>
		
		<td>
		<input  type="text" name="sanitaryplace" validate="name , string,no" id="nameofInspectingPersonId<%=inc %>" value="" maxlength="50" />
		</td>
	
		<!-- <td>
		<input name="buttonAdd" type="button" class="buttonAdd" value="" onclick="addRow();" />
		</td>
		
		<td>
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" />
		</td> -->

	</tr>
<input type="hidden" name="counter" id="counter" value="<%=inc %>"/>
</table>


 <div class="clear paddingTop15"></div>
 
<div class="Block">

 
<label>Observations</label>	
<textarea  name="sanitaryobservation" maxlength="4000" validate="name , number,no"  class="txtarea"  id="noofChildrenMedicallyExaminedId" value="" ></textarea>

<label>Suggestions</label>	
<textarea  name="sanitarysuggestion" maxlength="4000" validate="name , number,no"   class="txtarea" id="noofChildrenMedicallyExaminedId" value="" ></textarea>
<div class="clear"></div>
</div>	
	
<%--

<label style=" width: 310px">Remarks(Officer In Charge SHO)</label>	
 <textarea style=" width: 500px" name="remarksinchargesho" 
	id="remarksinchargesho" cols="20" rows="2" tabindex="1"
	validate="remarks,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
 <div class="clear"></div>
 <div class="clear"></div>

 <label style=" width: 310px">Remarks(Sr Med Officer)</label>	
<textarea style=" width: 500px" name="remarkssrmedofficer"
	id="remarkssrmedofficer" cols="20" rows="2" tabindex="1"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
 <div class="clear"></div>
 <div class="clear"></div>
 <label style=" width: 310px">Remarks(Officer In Charge Org)</label>	
<textarea style=" width: 500px" name="remasrkofficerinchargeorg"
	id="remasrkofficerinchargeorg" cols="20" rows="2" tabindex="1"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
 <div class="clear"></div>
 
 <div class="clear"></div>
 <label style=" width: 310px">Remarks(CADMO)</label>	                    
 <textarea style=" width: 500px" name="remarkscadmo"
	id="remarkscadmo" cols="20" rows="2" tabindex="1" size="20"                
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"   
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
 <div class="clear"></div>
                                                                    
 <div class="clear"></div>
 <label style=" width: 310px">Remarks(Stn.Cdr/Aoc)</label>	
<textarea style=" width: 500px" sname="complaintDescriptions"
	id="complaintDescriptions" cols="20" rows="2" tabindex="1"
	validate="Complaint Descriptions,string,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
	
--%>
	 
 <div class="clear paddingTop15"></div> 
 
<input type="button" name="Submit" value="Submit"  onClick= "submitForm('SanitaryRound','/hms/hms/mis?method=submitSanitaryRoundJSP');" class="button" />
<!--<input type="button" name="edit" value="Print" class="button" />
-->
<!--<input type="button" name="Reset" onclick="submitForm('lmcPsychiatricPatientCounseling','sHO?method=showLowMedCatPsychiatricPatientCounelingEntry');" value="Reset" class="button"/>
<input type="button" name="edit" value="Back" class="button" />	
<input type="button" name="edit" value="Forward" class="button" />	

	-->

	<div class="clear"></div>
	<script type="text/javascript">
	function fillNameByServiceNo(val,inc)
	{
			
		    ajaxFunctionForfillNameByServiceNo('SanitaryRound','mis?method=getServiceNoDetailsForSanitary&serviceNo=' +  val , inc);
			//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
	}



	function ajaxFunctionForfillNameByServiceNo(formName,action,rowVal) {

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
		   	    //var hinNo = items.getElementByTagName("hin")[0];
		        var itemId  = item.getElementsByTagName("id")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var designation  = item.getElementsByTagName("designation")[0];
		        var branch=item.getElementsByTagName("branch")[0];
		       
		      //  document.getElementById('hinOfSanitaryRound'+rowVal).value = hinNo.childNode[0].nodeValue
	        	document.getElementById('nameofSanitaryRound'+rowVal).value = name.childNodes[0].nodeValue
	        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
	        	document.getElementById('sanitaryBranch'+rowVal).value = branch.childNodes[0].nodeValue
	        	document.getElementById('sanitaryDesignation'+rowVal).value = designation.childNodes[0].nodeValue

			
		
	      }
	    }
	  }
	}
		






	
	function getPatientDetails(val)
	{	
		submitProtoAjaxforPatientDetails('SanitaryRound','/hms/hms/mis?method=getServiceNoDetailsForSanitary&serviceNo='+val);
	}
	function addRow(){

		  var tbl = document.getElementById('Grid');
		  var lastRow = tbl.rows.length;
		
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		
		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.name = '<%=SERVICE_NO %>' + iteration;
		  e0.id = 'serviceNoId' + iteration;
		  e0.setAttribute('maxlength', 50);
	      e0.size = '20';
	      e0.setAttribute('tabindex','1');
	      e0.onblur=function(){fillNameByServiceNo(this.value,iteration);}
		  cellRight0.appendChild(e0);
		  
		  var e1 = document.createElement('input');
		  e1.type = 'hidden';
		  e1.name = 'itemId' + iteration;
		  e1.id = 'itemId' + iteration;
		  e1.setAttribute('maxlength', 50);
	      e1.size = '5';
		  e1.setAttribute('tabindex','1');

		 // var cellRight2 = row.insertCell(1);
		//  var e2 = document.createElement('input');
		 // e2.type = 'text';
		 // e2.name = 'hinOfSanitaryRound' + iteration;
		 // e2.id = 'hinOfSanitaryRound' + iteration;
		 // e2.setAttribute('maxlength', 50);
	     // e2.size = '20';
		//  e2.setAttribute('tabindex','1');
		  //cellRight00.appendChild(e1);
		//  cellRight2.appendChild(e2);
		  
		  var cellRight2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name = 'nameofSanitaryRound' + iteration;
		  e2.id = 'nameofSanitaryRound' + iteration;
		  e2.setAttribute('maxlength', 50);
		  //e0.value=hdb.value;
	      e2.size = '20';
		  e2.setAttribute('tabindex','1');
		 // cellRight0.appendChild(e1);
		  cellRight2.appendChild(e2);

		  /*
		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name = 'principal' + iteration;
		  e1.id = 'principal' + iteration;
		  e1.setAttribute('maxlength', 10);
	     e1.size = '20';
		  e1.setAttribute('tabindex','1');
	     cellRight1.appendChild(e1);
	*/
	 var cellRight3 = row.insertCell(2);
	var e3 = document.createElement('input');
	e3.type = 'text';

	e3.name = 'sanitaryDesignation' + iteration;
	e3.id = 'sanitaryDesignation' + iteration;
	e3.setAttribute('maxlength', 50);
	e3.size = '20';
	e3.setAttribute('tabindex','1');
	cellRight3.appendChild(e3);


	     var cellRight4 = row.insertCell(3);
		 var e4 = document.createElement('input');
		 e4.type = 'text';
		 e4.name = 'sanitaryBranch' + iteration;
		 e4.id = 'sanitaryBranch' + iteration;
	     e4.size = '20';
	    
	     e4.setAttribute('maxlength', 50);
		 e4.setAttribute('tabindex','1');
	     cellRight4.appendChild(e4);

	     var cellRight5 = row.insertCell(4);
		 var e5 = document.createElement('input');
		 e5.type='text';
		 e5.name='sanitaryClassification'+ iteration;
		 e5.id='sanitaryClassification' + iteration;
		 e5.size = '20';
		 e5.setAttribute('maxlength', 50);
		 e5.setAttribute('tabindex','1');	        
	     cellRight5.appendChild(e5);

	     var cellRight6 = row.insertCell(5);
		 var e6 = document.createElement('input');
		 e6.type='text';
		 e6.name='nameofSchoolId'+ iteration;
		 e6.id='nameofSchoolId' + iteration;
		 e6.size = '20';
		 e6.setAttribute('maxlength', 50);
		 e6.setAttribute('tabindex','1');	        
	     cellRight6.appendChild(e6);

	     var cellRight7 = row.insertCell(6);
		 var e7 = document.createElement('input');
		 e7.type='text';
		 e7.name='nameofInspectingPersonId'+ iteration;
		 e7.id='nameofInspectingPersonId' + iteration;
		 e7.size = '20';
		 e7.setAttribute('maxlength', 50);
		 e7.setAttribute('tabindex','1');	        
	     cellRight7.appendChild(e7);

	     var cellRight8 = row.insertCell(7);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd' ;
		  e8.name = 'addbutton' + iteration;	
		  e8.setAttribute('onClick','addRow();');     
		  e8.setAttribute('tabindex','1');
	     cellRight8.appendChild(e8);    	   

		  var cellRight9 = row.insertCell(8);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'removeRowIndividual("Grid","hdb",this);');
		  e9.setAttribute('tabindex','1');
		  cellRight9.appendChild(e9);
	}
	 function removeRowIndividual(idName,countId,obj)
	 {
	   var tbl = document.getElementById('Grid');
	   var lastRow = tbl.rows.length;
	   if (lastRow > 2){
	   //	tbl.deleteRow(lastRow - 1);
	     var i=obj.parentNode.parentNode.rowIndex;
	     tbl.deleteRow(i);
	   }
	 }
	 function submitProtoAjaxforPatientDetails(formName,action){
			errorMsg = "";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName)
		        	
		        	new Ajax.Updater('srNoDiv',url,
					   {asynchronous:false, evalScripts:true }); 
			       	return true;
		    	}
	 function submitProtoAjaxWithDivName(formName,action,divName){
			//alert("hello----------");
			errorMsg = "";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			//alert('::formName::-'+formName+'\n::action::-'+action+'\n::divName::-'+divName);
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName)
		        	if(divName == "defaultList"){
		        	document.getElementById('defaultList').style.display = 'inline';
		        	}
		        	new Ajax.Updater(divName,url,
					   {asynchronous:true, evalScripts:true }); 
					
				
			       	return true;
		    }

	
	</script>
</form>








