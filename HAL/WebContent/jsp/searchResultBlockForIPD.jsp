<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchResultBlockForIPD.jsp  
 * Purpose of the JSP -  This is for Search Result Block for IPD.
 * @author  Vikas
 * Create Date: 01st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<div id="resultnavigation">
<form name="paging" method="post" action=""><!--


|---- <span id="currStart">1</span> to
<span id="totalRecs"> </span> of <span id="currEnd">10 </span>----| --><!--|----  Total <span  id="currEnd">10 </span> Showing <span id="currStart">1</span> to <span id="totalRecs"> </span> ----|-->
  <input type="hidden" id="totalRecs" name=""/>
    <input type="hidden" id="currEnd" name=""/>
        <input type="hidden" id="currStart" name=""/>
<input type="button" name="firstpage" value="f"
	onClick="navigateIPD(this)" accesskey="f" class="previous" /> <input
	type="button" name="prevpage" value="p" onClick="navigateIPD(this)"
	accesskey="p" class="singlePrev" /> Page <span id="current"> 1
</span> of <span id="total"> </span> <input type="button" name="nextpage"
	value="n" onClick="navigateIPD(this)" accesskey="n" class="singleNext" />
<input type="button" name="lastpage" value="l"
	onClick="navigateIPD(this)" accesskey="l" class="next" /> <input
	type="text" name="pageno" id="pageno" MAXLENGTH="4"
	onkeypress="submitenter(this,event,'','goToPageForPatient(document.paging.pageno.value)')" />

<input type="button" name="ok" value="Go"
	onClick="goToPageForPatient(pageno.value)" class="button" />

</form>
</div>

