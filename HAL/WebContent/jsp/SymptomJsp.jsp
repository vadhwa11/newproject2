<%-- 
	 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
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

 
<%@page import="jkt.hms.masters.business.Medicinenet"%>

<%@page import="jkt.hms.masters.business.Symptom"%>
<%@page import="jkt.hms.masters.business.SymptomCause"%>
<%@page import="jkt.hms.masters.business.SymptomMedication"%>
<%@page import="jkt.hms.masters.business.SymptomRelatedName"%>
<%@page import="jkt.hms.masters.business.SymptomSubComplains"%>
<%@page import="jkt.hms.masters.business.SymptomDesc"%>
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
	function fillSymptom(val)
	{
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var symptomNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var symptomName=val.substring(0,indexForBrandName);
		    // alert("symptomName--"+symptomName)



	  if(symptomNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('symptomname').value="";
	    
	   return;
	   }
	   else
	   {	submitForm('TreatmentSearchForm','opd?method=showSymptomPopUp&symptomname='+encodeURIComponent(symptomName));
	     }
		}	
}
	function fillSymptomSubName(val)
	{
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var symptomNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var subSymptomName=val.substring(0,indexForBrandName);
		    // alert("symptomName--"+symptomName)



	  if(symptomNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('symptomsubname').value="";
	    
	   return;
	   }
	   else
	   {	
		submitForm('TreatmentSearchForm','opd?method=showSymptomSubPopUp&symptomsubname='+encodeURIComponent(subSymptomName));
		
		}
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
	
//-->
</SCRIPT>
</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Symptom> symptomList = new ArrayList<Symptom>();
	List<SymptomCause>	symptomCauseList=new ArrayList<SymptomCause>();
	List<SymptomMedication>	symptomMedicationList=new ArrayList<SymptomMedication>();
	List<SymptomRelatedName> symptomRelatedNameList=new ArrayList<SymptomRelatedName>();
	List<SymptomSubComplains>	symptomSubComplainsList=new ArrayList<SymptomSubComplains>();
	List<SymptomDesc> symptomDescList=new ArrayList<SymptomDesc>();
	
	Medicinenet medicinedetails = new Medicinenet();
	String search = "";
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		
		
		if(map.get("symptomList") != null){
			symptomList=( List<Symptom>)map.get("symptomList");
		}	
		if(map.get("symptomCauseList") != null){
			symptomCauseList=( List<SymptomCause>)map.get("symptomCauseList");
		}
		if(map.get("symptomMedicationList") != null){
			symptomMedicationList=( List<SymptomMedication>)map.get("symptomMedicationList");
		}
		if(map.get("symptomRelatedNameList") != null){
			symptomRelatedNameList=( List<SymptomRelatedName>)map.get("symptomRelatedNameList");
		}
		if(map.get("symptomSubComplainsList") != null){
			symptomSubComplainsList=( List<SymptomSubComplains>)map.get("symptomSubComplainsList");
		}
		if(map.get("symptomDescList") != null){
			symptomDescList=( List<SymptomDesc>)map.get("symptomDescList");
		}
		if (map.get("search")!=null){
			search = (String)map.get("search");
		}
		
	}
	
%>


<form name="TreatmentSearchForm" action="" method="post">
<input	type="hidden" name="search" id="search" value="<%=search%>">
<div class="titleBg"><h2>Symptomp Search</h2></div>
<div class="Block">
<label>Symptomp Name</label>
<input type="text" id="symptomname"	name="symptomname" value=""  maxlength="30" onblur="fillSymptom(this.value)"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('symptomname','ac2update','opd?method=autoCompleteForSymptom',{parameters:'requiredField=symptomname'});
		   //document.getElementById('slide0').style.display="hide"
</script>


</div>
<div class="clear"></div>
 
<div class="Block">
<label>Sub Symptomp Name</label>
<input type="text" id="symptomsubname"	name="symptomsubname" value=""  maxlength="30" onblur="fillSymptomSubName(this.value)"/>
<div id="ac2update12"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('symptomsubname','ac2update12','opd?method=autoCompleteForSymptomSubName',{parameters:'requiredField=symptomsubname'});
		  
		</script>

</div>

	
<% if(symptomList.size()>0){%>
		<div class="clear"></div>
<div class="titleBg">
	<h4>Symptomp Name</h4>
	</div>
<%} %>	
<%
     for(Symptom symptom:symptomList)
     {	 
%>	
	<div class="clear"></div>
		<%
				if(symptom.getComplaintDescription()!=null)
				{
						
				%>
				<div class="Block">
				<label class="auto"><%=symptom.getComplaintDescription()%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}
     }	%>
<% if(symptomRelatedNameList.size()>0){ %>			
				<div class="clear"></div>
<div class="titleBg">
	<h4>Related Name</h4>
	</div>					<div class="clear"></div>
	<%} %>
				<%
				for(SymptomRelatedName symptomRelatedName:symptomRelatedNameList)
				{	
					%>
					<div class="Block">
				<label class="auto"><%=symptomRelatedName.getSymptomName()%></label>
				</div>
				<%}%>
				
	<% if(symptomDescList.size()>0){%>					
	<div class="clear"></div>
		<div class="titleBg">			
	<h4>Description</h4>
	</div>		<%} %>
				<%
				for(SymptomDesc symptomDesc:symptomDescList)
				{	
			%>
				<div class="Block">
				<label class="auto"><%=symptomDesc.getDescription()%></label>
				</div>
				<%}%>
							
	<% if(symptomCauseList.size()>0){%>				
	<div class="clear"></div>
	<div class="titleBg">		
	<h4 >Cause</h4>
	</div><% }%>		
				<%
				for(SymptomCause symptomCause:symptomCauseList)
				{	
					if(symptomCause.getMainOther().equalsIgnoreCase("C"))
					{	
				 %>
				<div class="Block">
				<label class="auto"><%=symptomCause.getCause()%></label>
				
				</div>
				<%}}%>
	<% if(symptomCauseList.size()>0){%>					
	<div class="clear"></div>
	<div class="titleBg">		
	<h4 >other Cause</h4>
	</div>	<%} %>	
				<%
				for(SymptomCause symptomCause1:symptomCauseList)
				{	
					if(symptomCause1.getMainOther().equalsIgnoreCase("O"))
					{	
				 %>
				<div class="Block">
				<label class="auto"><%=symptomCause1.getCause()%></label>
				
				</div>
				<%}}%>
	<% if(symptomMedicationList.size()>0){%>					
	<div class="clear"></div>
		<div class="titleBg">			
	<h4>Medication</h4>
	</div>		<%} %>
				<%
				for(SymptomMedication symptomMedication:symptomMedicationList)
				{	
			%>
				<div class="Block">
				<label class="auto"><%=symptomMedication.getMedication()%></label>
				</div>
				<%}%>
	
	<% if(symptomSubComplainsList.size()>0){%>					
	<div class="clear"></div>
		<div class="titleBg">			
	<h4>Sub Symptomp Name</h4>
	</div>		<%} %>
				<%
				for(SymptomSubComplains symptomSubComplains:symptomSubComplainsList)
				{	
			%>
				<div class="Block">
				<label class="auto"><%=symptomSubComplains.getSubSymptomName()%></label>
				</div>
				<%}%>
		
				<div class="clear"></div>


</form>

