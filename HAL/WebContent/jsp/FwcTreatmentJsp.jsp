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
<!--
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
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var treatmentNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var genricName=val.substring(0,indexForBrandName);
		    // alert("symptomName--"+symptomName)



	  if(treatmentNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('genericname').value="";
	    
	   return;
	   }
	   else
	   {	
		submitForm('TreatmentSearchForm','fwc?method=showTreatmentPopUp&genericname='+encodeURIComponent(genricName));
		
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
	    	
			submitForm('TreatmentSearchForm','fwc?method=showTreatmentPopUp&search=y');
			
			}else{
				
		submitForm('TreatmentSearchForm','fwc?method=showTreatmentPopUp&search=y');
		
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


<form name="TreatmentSearchForm" action="" method="post">
<input	type="hidden" name="search" id="search" value="<%=search%>">
<div class="titleBg"><h2>Drug Search</h2></div>
<div class="Block">
<label>Generic Name</label>
<input type="text" id="genericname"	name="genericname" value=""  maxlength="30" onblur="filltreatment(this.value)"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('genericname','ac2update','fwc?method=autoCompleteForTreatment',{parameters:'requiredField=genericname'});
		  
		</script>

</div>
<div class="clear"></div>

	


		<%
String icdNameString ="";
if (drugDetailList != null && drugDetailList.size() > 0) { %>

		<% for(int i=0;i<drugDetailList.size();i++)
	{
		drugdetail = (Drugdetails)drugDetailList.get(i);
	%>
<div class="titleBg">
	<h4>Generic Name</h4>
	</div>

		<%
				if(drugdetail.getGenericname()!=null)
				{
						
				%>
	<div class="Block">				
				<label ><%=drugdetail.getGenericname()%></label>
				</div>
				<%}else{%>
				<div class="Block">	
				<label><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">		
	<h4 >Class</h4>
	</div>
				<%if(drugdetail.getDrugClass()!=null)
				{
				String drugclass = (String)drugdetail.getDrugClass();
				drugclass = drugclass.replaceAll(System.getProperty("line.separator"),"");
				drugclass = drugclass.replace('"', ' ');	
					%>
					<div class="Block">
				<label class="auto"><%=drugclass%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">		
	<h4 >Indication Dosage</h4>
	</div>		
				<%if(drugdetail.getIndicationdosage()!=null)
				{
					String dosage = (String)drugdetail.getIndicationdosage();
					dosage = dosage.replaceAll(System.getProperty("line.separator"),"");			
					dosage = dosage.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=dosage%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div> 
				<%}%>
	<div class="clear"></div>
		<div class="titleBg">			
	<h4>Administration</h4>
	</div>		
				<%if(drugdetail.getAdministration()!=null)
				{
					String administrator = (String)drugdetail.getAdministration();
					administrator = administrator.replaceAll(System.getProperty("line.separator"),"");
					administrator = administrator.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=administrator%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4 >Over Dosage<h4>
	</div>		
				<%if(drugdetail.getOverdosage()!=null)
				{
					  
					  String str1 = (String)drugdetail.getOverdosage();
					  str1 = str1.replaceAll(System.getProperty("line.separator"),"");
					  str1 = str1.replace('"', ' ');
					  %>
				<div class="Block">
				<label class="auto"><%=str1%></label>
				</div>
				<%}else{%>
				<div class="Block">				
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4 >Contra Indications</h4>
	</div>		
				<%if(drugdetail.getContraindications()!=null)
				{
					String str2 = (String)drugdetail.getContraindications();
					str2 = str2.replaceAll(System.getProperty("line.separator"),"");
					str2 = str2.replace('"', ' ');%>
					<div class="Block">
				<label class="auto"><%=str2%></label>
				</div>
				<%}else{%>
					<div class="Block">
				<label class="auto"><%="----"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
		<div class="titleBg">
	<h4 >Special Precautions</h4>
	</div>		
				<%if(drugdetail.getSpecialprecautions()!=null)
				{
					String str3 = (String)drugdetail.getSpecialprecautions();
					str3 = str3.replaceAll(System.getProperty("line.separator"),"");
					str3 = str3.replace('"', ' ');
					%>  
					<div class="Block">
				<label class="auto"><%=str3%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
		<div class="clear"></div>
				<div class="titleBg">
		<h4>Adverse Drug Reactions</h4>
		</div>		
				<%if(drugdetail.getAdversedrugreactions()!=null)
				{
					String adverse = (String)drugdetail.getAdversedrugreactions();
					adverse = adverse.replaceAll(System.getProperty("line.separator"),"");
					adverse = adverse.replace('"', ' ');

			         %>  
			     <div class="Block">
				<label class="auto"><%=adverse%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
		<div class="titleBg">			
	<h4 >Drug Interactions</h4>
	</div>		
				<%if(drugdetail.getDruginteractions()!=null)
				{
				String str5 = (String)drugdetail.getDruginteractions();
					str5 = str5.replaceAll(System.getProperty("line.separator"),"");
					str5 = str5.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=str5%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="----"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4>Pregnancy Category</h4>
	</div>		
				<%if(drugdetail.getPregnancycategory()!=null)
				{
					String str6 = (String)drugdetail.getPregnancycategory();
					str6 = str6.replaceAll(System.getProperty("line.separator"),"");
					str6 = str6.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=str6%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4 >Storage</h4>
	</div>		
				<%if(drugdetail.getStorage()!=null)
				{
					String str7 = (String)drugdetail.getStorage();
					str7 = str7.replaceAll(System.getProperty("line.separator"),"");
					str7 = str7.replace('"', ' ');
					%>
					<div class="Block">
				<label class="auto"><%=str7%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4>Mechanism Action</h4>
	</div>		
				<%if(drugdetail.getMechanismaction()!=null)
				{
					String str8 = (String)drugdetail.getMechanismaction();
					str8 = str8.replaceAll(System.getProperty("line.separator"),"");
					str8 = str8.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=str8%></label>
				</div>
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				
				<%}%>
			
	<div class="clear"></div>
	<div class="titleBg">			
	<h4 >Atcclassification</h4>
	</div>
			
				<%if(drugdetail.getAtcclassification()!=null)
				{
					String str9 = (String)drugdetail.getAtcclassification();
					str9 = str9.replaceAll(System.getProperty("line.separator"),"");
					str9 = str9.replace('"', ' ');
					%>
					<div class="Block">
				<label class="auto"><%=str9%></label>
				
				</div>
				<%}else{%>
				<label class="auto"><%="---"%></label>
				<%}%>
	<div class="clear"></div>
	<div class="titleBg">
	<h4>Atcclassificationdetails</h4>
	</div>		
				<%if(drugdetail.getAtcclassificationdetails()!=null)
				{
					String str10 = (String)drugdetail.getAtcclassificationdetails();
					str10 = str10.replaceAll(System.getProperty("line.separator"),"");
					str10 = str10.replace('"', ' ');
				%>
				<div class="Block">
				<label class="auto"><%=str10%></label>
				</div>
				
				<%}else{%>
				<div class="Block">
				<label class="auto"><%="---"%></label>
				</div>
				
				<%}%>
				</div>
		<%
	}
	%>
		<% } 
	 %>




</form>

