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
<%@page import="jkt.hms.masters.business.Cims"%>

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
List<Cims> drugDetailList = new ArrayList<Cims>();
Cims drugdetail = new Cims();

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("drugDetailList") != null){
	drugDetailList=( List<Cims>)map.get("drugDetailList");
}	
	
%>


<div class="Block">
<%if(drugDetailList.size() >0){ %>

<h4>Generic Name </h4>
<label class="gridResult"><%=drugDetailList.get(0).getGenericname() !=null?drugDetailList.get(0).getGenericname():"N/A"%></label>
<div class="clear"></div>

<h4>Indication Dosage </h4>
<label class="gridResult"><%=drugDetailList.get(0).getIndicationdosage()!=null?drugDetailList.get(0).getIndicationdosage():"N/A"%></label>
<div class="clear"></div>

<h4>Contraindication</h4>
<label class="gridResult"><%=drugDetailList.get(0).getContraindications()!=null?drugDetailList.get(0).getContraindications():"N/A"%></label>
<div class="clear"></div>

<h4>Special Precautions </h4>
<label class="gridResult"><%=drugDetailList.get(0).getSpecialprecautions()!=null?drugDetailList.get(0).getSpecialprecautions():"N/A"%></label>
<div class="clear"></div>

<h4>Adverse Drug Reactions</h4>
<label class="gridResult"><%=drugDetailList.get(0).getAdversedrugreactions()!=null?drugDetailList.get(0).getAdversedrugreactions():"N/A"%></label>
<div class="clear"></div>

<h4>Drug Interactions</h4>
<label class="gridResult"><%=drugDetailList.get(0).getDruginteractions()!=null?drugDetailList.get(0).getDruginteractions():"N/A"%></label>
<div class="clear"></div>

<h4>Pregnancy category</h4>
<label class="gridResult"><%=drugDetailList.get(0).getPregnancycategory()!=null?drugDetailList.get(0).getPregnancycategory():"N/A"%></label>
<div class="clear"></div>

<h4>Storage</h4>
<label class="gridResult"><%=drugDetailList.get(0).getStorage()!=null?drugDetailList.get(0).getStorage():"N/A"%></label>
<div class="clear"></div>

<h4>Mechanism Action</h4>
<label class="gridResult"><%=drugDetailList.get(0).getMechanismaction()!=null?drugDetailList.get(0).getMechanismaction():"N/A"%></label>
<div class="clear"></div>

<h4>ATC classification</h4>
<label class="gridResult"><%=drugDetailList.get(0).getAtcclassification()!=null?drugDetailList.get(0).getAtcclassification():"N/A"%></label>
<div class="clear"></div>

<h4>ATC classification details</h4>
<label class="gridResult"><%=drugDetailList.get(0).getAtcclassificationdetails()!=null?drugDetailList.get(0).getAtcclassificationdetails():"N/A"%></label>
<div class="clear"></div>
<%} %>
</div>

