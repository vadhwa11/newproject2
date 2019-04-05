<%-- 
	 * Copyright 20011 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.08.2011   Name:
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.Diagnosispro"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(hinNo) {
	var search = document.getElementById('search').value;
	 if(search == "n"){
		opener.jsSetIcdData(hinNo);
		self.close();
	  }
		
	}
	function filldiagnosis(val)
	{
		
		submitForm('TreatmentSearchForm','fwc?method=showDiagnosisPopUp&diagnosisname='+encodeURIComponent(val));
		
		}
	function sub()
	{
	
	var search = document.getElementById('search').value;
	
	if (TreatmentSearchForm.generic_name.value=="")
    {
		
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
	    if(search == "n"){
	    	
			submitForm('TreatmentSearchForm','fwc?method=showTreatmentPopUp&search=y');
			
			}else{
				
		submitForm('TreatmentSearchForm','fwc?method=showTreatmentPopUp&search=y');
		
		}
	}
	}
	function addRow(val)
	{
		if(val!="")
		{
			var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var diagnosisNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var diagnosisName=val.substring(0,indexForBrandName);
		    



	  if(diagnosisNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('diagnosisname').value="";
	    
	   return;
	   }
	   else
	   {		
		 var tbl = document.getElementById('differentialId');
		 var lastRow = tbl.rows.length;
		 var listSize=document.getElementById('listSize').value;
		 
		document.getElementById('results').style.display='inline'
		 listSize=(parseInt(listSize))+1;
		 var iteration = lastRow;
		 var row = tbl.insertRow(lastRow);
		 //var hdb = document.getElementById('hdb');
		// hdb.value=iteration


		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.size = '50';
		  e0.name='condition'+iteration;
		  e0.id = 'condition'+iteration;
		  e0.value=diagnosisName;
		  e0.readOnly=true;
		  cellRight0.appendChild(e0);

		  var cellRight1 = row.insertCell(1);
		  var e11 = document.createElement('input');
		  e11.type = 'checkbox';
		  e11.size = '50';
		  e11.name = 'removeRow' + iteration;
		  e11.id = 'removeRow' + iteration;
		  cellRight1.appendChild(e11);
		  
		  document.getElementById('rr').value=(parseInt(lastRow))+1;
		 
		  document.getElementById('listSize').value=parseInt(listSize);
		  document.getElementById('diagnosisname').value="";
		}	  
		}
	}	
    function checkFormData()
    {
    	var listSize=document.getElementById('listSize').value;
        
        var paraValue="";
   	     for(var i=1;i<=listSize;i++)
		 {
   	    	 var tbl = document.getElementById('differentialId');
   			
			 if(document.getElementById('condition'+i)!=null)
			 {		 
                paraValue=paraValue+document.getElementById('condition'+i).value+"=";	 
		     }
			 
		 } 	  
		 var url='fwc?method=submitDifferentialDiagnosis&paraVal='+paraValue;
		 submitProtoAjax('TreatmentSearchForm',url);
    }
	function removeRowFunction()
	{
		var listSize=document.getElementById('listSize').value;
		 //alert("remove list size ===>"+listSize)
		 var tbl = document.getElementById('differentialId');
	     var lastRow = tbl.rows.length;
         var j=1;
		 for(var i=1;i<=listSize;i++)
		 {
			 if(document.getElementById('removeRow'+i)!=null)
			 {		 
			   if(document.getElementById('removeRow'+i).checked==true)
			   {
				 tbl.deleteRow(j);
        		 }else
				 {
				    j++;	 	 
			 }
		 }
			 
		 } 	 
	 }
//-->
</SCRIPT>
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Diagnosispro> DiagnosisproList = new ArrayList<Diagnosispro>();
	Diagnosispro diagnosisdetails = new Diagnosispro();
	String search = "";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		
		
		if(map.get("DiagnosisproList") != null){
			DiagnosisproList=( List<Diagnosispro>)map.get("DiagnosisproList");
		}	
		
		if (map.get("search")!=null){
			search = (String)map.get("search");
		}
		
	}
	
%>


<form name="TreatmentSearchForm" action="" method="post">
<input	type="hidden" name="search" id="search" value="<%=search%>">
<div class="titleBg"><h2>Differential Diagnosis Search</h2></div>
<div class="Block">
<label>Differential Diagnosis</label>
<input type="text" id="diagnosisname"	name="diagnosisname" value=""  maxlength="30" onblur="addRow(this.value)"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('diagnosisname','ac2update','fwc?method=autoCompleteForDiagnosis',{parameters:'requiredField=diagnosisname'});
		  
		</script>
</div>
</div>
<input type="hidden" name="rows" id="rr" value="1" />
<input type="hidden" id="listSize"	name="listSize" value="0" />
<div class="clear" ></div>
<div id="results" style="display: none;">
<div class="titleBg"><h2>Results</h2></div>

<div class="Block">
<div  class="cmntable">
	<table width="70%" colspan="2" id="differentialId" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="50%">Condition</th>
			<th width="50%">Remove Row</th>
			
		</tr>
	</thead>
	
	<tbody>l
	</tbody>
	</table>
</div>
</div>	
<div class="clear" ></div>
<div class="clear" ></div>
<input type="button" name="diagnosis"	id="diagnosis" value="Diagnosis" class="buttonBig"	onClick="checkFormData();" />
<input type="button" name="deleteRow"	id="deleteRow" value="Delete Row" class="button"	onClick="removeRowFunction();" />
<div class="clear" ></div>
<div id="testDiv">


</div>	


</form>

