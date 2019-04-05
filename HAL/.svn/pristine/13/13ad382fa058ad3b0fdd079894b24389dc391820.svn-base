<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>



<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhysiotherapyDetails"%>

<%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.Complain"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
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


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentTimeWithoutSecond();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
		
	List<Complain> complainList = new ArrayList<Complain>();
	if(map.get("complainList") != null){
		complainList = (List<Complain>)map.get("complainList");
	}
	Box box = HMSUtil.getBox(request);
	Visit visit = new Visit();
	Complain complain = new Complain();
	if(complainList.size() > 0){
		complain = complainList.get(0);
		
	}
%>

<div class="clear paddingTop15"></div>
<div class="Block">

<label>Date</label>
<input type="text" name="complainDate" tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(complain.getComplainDate())%>" />

<label>Time</label>
<input type="text" name="ComplainTime" tabindex="1" value="<%=complain.getComplainTime()%>" />

<label>Requested By</label>
<input type="text" name="requested_by" tabindex="1" value="<%=complain.getRequestBy().getRank().getRankName().concat("  ").concat(complain.getRequestBy().getFirstName()).concat("  ").concat(complain.getRequestBy().getLastName())%>" />
<input type="hidden" name="requested_by1" value="<%=complain.getRequestBy().getId() %>" />
<input type="hidden" name="status" value="Open" />

<div class="clear"></div>

<label>Request Type</label>
<select name="request_type" tabindex="1">
<option>Select</option>
<%if(complain.getRequestType().equalsIgnoreCase("Software (MEDNET)")){ %>
<option selected="selected">Software (MEDNET)</option>
<option>Hardware</option>
<option>Network</option>
<%}else if(complain.getRequestType().equalsIgnoreCase("Hardware")){ %>
<option>Software (MEDNET)</option>
<option  selected="selected">Hardware</option>
<option>Network</option>
<%}else{ %>
<option>Software (MEDNET)</option>
<option>Hardware</option>
<option selected="selected">Network</option>
<%} %>
</select>

<label>Description</label>
<% if(complain.getDiscription()!="" && complain.getDiscription()!=null){ %>
<textarea rows="" cols="" name="description" tabindex="1">
<%=complain.getDiscription() %>
</textarea>
<%}else{ %>
<textarea name="description"  maxlength="300" onkeyup="chkLength(this,300);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" tabindex="1"></textarea>
<%} %>
</div>

<div class="clear paddingTop10"></div>
<div class="division"></div>
<div class="clear paddingTop10"></div>
	<div class="clear"></div>
	<input type="hidden" name="flag" value="<%=box.getString("flag") %>">

	<input type="hidden" name="complainId" value="<%=complain.getId() %>">
	
	
	<input type="button" name="add" id="addbutton"	value="Update" class="button" onClick="submitForm('complainA','user?method=updateComplainA&compainId=<%=complain.getId() %>');" accesskey="a" tabindex=1 />
	
