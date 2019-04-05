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

<%@page import="jkt.hms.masters.business.OpdDifferentialDisease"%>
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


</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<OpdDifferentialDisease> differentialDiseaseList = new ArrayList<OpdDifferentialDisease>();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
	}
		
		if(map.get("differentialDiseaseList") != null){
			differentialDiseaseList=( List<OpdDifferentialDisease>)map.get("differentialDiseaseList");
		}	
		
	String diseaseName = "";
	String signSymptoms = "";
	String Synonyms = "";
	String investigation = "";
	String treatments = "";
	String drug = "";
	String surgery = "";
	String otherAdvice = "";
	if(differentialDiseaseList.size()>0){
		OpdDifferentialDisease opdDifferentialDisease =differentialDiseaseList.get(0); 
		diseaseName = opdDifferentialDisease.getDifferentialDiseaseName();
		signSymptoms = opdDifferentialDisease.getSignSymptoms();
		Synonyms = opdDifferentialDisease.getSynonyms();
		investigation  = opdDifferentialDisease.getInvestigation();
		treatments = opdDifferentialDisease.getTreatments();
		drug = opdDifferentialDisease.getDrugs();
		surgery = opdDifferentialDisease.getSurgery();
		otherAdvice = opdDifferentialDisease.getOtherAdvice();
	}
	
%>


<form name="diseaseSearchForm" action="" method="post">

<!-- <div class=""><h2>Disease</h2></div> -->
<div class="titleBg">
	<h2><%=diseaseName %></h2>
	</div>
	<div class="clear"></div>
	<div class="Block">
<div class=""><h4>Synonyms</h4></div>
<div class="clear"></div>
<%if(Synonyms != null){ %>	
<label class="gridResult">
<%
String str6[]=Synonyms.split("#");
for(int p=0;p<str6.length;p++){
	%>
	
		
			
			<%
				if(p!=0){
					%>
			<%=" * "%>
					<%
				}
			%>
			
			<%=str6[p] %>
	<%}%>
	</label>
		<div class="clear"></div>
<%}else{ %>
<label class="gridResult">Nil</label>
	<%} %>

<div class="clear"></div>
<div class=""><h4>Sign &amp; Symptoms</h4></div>
<div class="clear"></div>
<%if(signSymptoms != null){ %>	
<label  class="gridResult">
<%
String str[]=signSymptoms.split("#");
for(int j=0;j<str.length;j++){
	String str_new[]=str[j].split("!");
	for(int k=0;k<str_new.length;k++){
	%>
			<%
				if(j!=0){
					%>
			<%=" * "%>
					<%
				}
			%>
			
			<%=str_new[k] %>
		<div class="clear"></div>
	<%}}%>	
	</label>	
<%--signSymptoms --%>
<%}else{ %>
<label class="gridResult">Nil</label>
	<%} %>


<div class="clear"></div>
<div class=""><h4>Investigations</h4></div>
	<div class="clear"></div>
<%if(investigation != null){ %>	
<label  class="gridResult">
<%
String str1[]=investigation.split("#");
for(int i=0;i<str1.length;i++){
	%>
			
			<%
				if(i!=0){%>
			<%=" * "%>
			<%}%>
			<%=str1[i] %>
		<div class="clear"></div>
	<%
}
%>	
</label>	
<%--investigation --%>

	<%}else{ %>
<label class="gridResult">Nil</label>
	<%} %>

<div class=""><h4>Treatment</h4></div>
<div class="clear"></div>
<%if(treatments != null){ %>	
<label  class="gridResult">
<%
String str2[]=treatments.split("#");
for(int k=0;k<str2.length;k++){
	%>
		
			<%
				if(k!=0){%>
			<%=" * "%>
			<%}%>
			<%=str2[k] %>
		<div class="clear"></div>
	<%
}
%>		
</label>
<%}else{ %>
<label class="gridResult">Nil</label>
	<%} %>
<%--treatment --%>
<div class=""><h4>Drugs</h4></div>
<div class="clear"></div>
<%if(drug != null){ %>
<label class="gridResult">		
	<%
String str3[]=drug.split("#");
for(int l=0;l<str3.length;l++){
	%>
			
			<%
				if(l!=0){%>
			<%=" * "%>
			<%}%>
			<%=str3[l] %>
		<div class="clear"></div>
	<%
}
%>		
<%--Drug --%>
</label>
	<%}else{ %>
<label class="gridResult">Nil</label>
	<%} %>

<div class="clear"></div>
<div class="">
	<h4>Surgery</h4>
	</div>
	<%if(surgery != null){ %>
<%
String str4[]=surgery.split("#");
for(int m=0;m<str4.length;m++){
	%>
			<label  class="gridResult">
			<%
				if(m!=0){%>
			<%=" * "%>
			<%}%>
			<%=str4[m] %></label>
		<div class="clear"></div>
	<%
}
%>		
<%--Surgery --%>

<%}else{ %>
<label class="gridResult">Nil</label>
<%} %>
<div class="clear"></div>
<div class="">
	<h4>Other Advice</h4>
	</div>
	<div class="clear"></div>
<%if(otherAdvice != null){ %>	
<%
String str5[]=otherAdvice.split("#");
for(int n=0;n<str5.length;n++){
	%>
			<label  class="gridResult">
			<%
				if(n!=0){%>
			<%=" * "%>
			<%}%>
			<%=str5[n] %></label>
		<div class="clear"></div>
	<%
}
%>		
<%--other Advice --%>
<%}else{ %>
<label class="gridResult">	Nil</label>
<%} %>
</div>
</form>

