<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R   
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


<%@page import="jkt.hms.masters.business.Drugdetails"%>
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

	function jsSelData(hinNo) {
	var search = document.getElementById('search').value;
	 if(search == "n"){
		opener.jsSetIcdData(hinNo);
		self.close();
	  }
		
	}
	function filltreatment(val)
	{
		
		if(val != "")
		{
			//alert(document.getElementById('genericname').value);
		
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var treatmentNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var genricName=val.substring(0,indexForBrandName);
		   // alert("da "+cimsId +val);
		   // var indexForBrandName=indexForBrandName--;
		   // var genricName=val.substring(0,indexForBrandName);
		    // alert("symptomName--"+symptomName)



	/*   if(cimsId == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('genericname').value="";
	    
	   return;
	   }
	   else
	   {	
		submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&genericname='+encodeURIComponent(genricName));
		
		}
	  } */
	  
	  
	  //function fnGetDoctorDepartment(departmentId, divName, loginDoctor) {
			
			// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
		
			new Ajax.Request(
					'opd?method=showCIMSItemDetails&cimsId=' + treatmentNo,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								document.getElementById("cims_details").innerHTML = response.responseText
										.trim();
							}
						}
					});
		}
	  
	  
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
	    	
			submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&search=y');
			
			}else{
				
		submitForm('TreatmentSearchForm','opd?method=showTreatmentPopUp&search=y');
		
		}
	}
	}
	

</SCRIPT>
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Drugdetails> drugDetailList = new ArrayList<Drugdetails>();
	Drugdetails drugdetail = new Drugdetails();
	String search = "";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		
		
		if(map.get("drugDetailList") != null){
			drugDetailList=( List<Drugdetails>)map.get("drugDetailList");
		}	
		System.out.println("jsp drugDetailList---"+drugDetailList.size());	

		
		if (map.get("search")!=null){
			search = (String)map.get("search");
		}
		
	}
	
%>

<div class="popupbg">

<form name="TreatmentSearchForm" action="" method="post">
<input	type="hidden" name="search" id="search" value="<%=search%>">
<div class="titleBg"><h2>CIMS Search</h2></div>
<div class="Block">
<label>Nomenclature</label>
<input type="text" id="genericname"	name="genericname" value=""  maxlength="30" onblur="filltreatment(this.value)" style="width: 550px;"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('genericname','ac2update','opd?method=autoCompleteForCIMS',{parameters:'requiredField=genericname'});
		  
		</script>

</div>

<div id="cims_details"></div>
<div class="clear"></div>

</form>
</div>


<style>
.Block{width:988px!important;}
.Block input {height:24px;}
</style>
