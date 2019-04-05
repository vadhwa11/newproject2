
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseUnitValidate.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  
 * @author  
 * Create Date: 12th september,2008 
 * Revision Date:      
 * Revision By: 
 * @version   
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.OtBookSurgeon"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<%
	Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
  List<OtBooking> otBookingList = new ArrayList<OtBooking>();
  List<OtBookSurgeon> otBookSurgeonList= new ArrayList<OtBookSurgeon>();
  List<Inpatient> inPatientList= new ArrayList<Inpatient>();
  List<MasUnit> allUnitList = new ArrayList<MasUnit>();
  List<EmpAfmsfDet> empAfmsfListOfUnit = new ArrayList<EmpAfmsfDet>();
  
    if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("otBookingList") != null)	{
		otBookingList = (List<OtBooking>)map.get("otBookingList");
	}
	
	if(map.get("otBookSurgeonList") != null)	{
		otBookSurgeonList = (List<OtBookSurgeon>)map.get("otBookSurgeonList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }


%>
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">


<%if(otBookingList!= null && otBookingList.size() > 0){ 
     for(OtBooking otBooking : otBookingList){
   %> <label class="bodytextB">Surgery Date :</label> <span
	class="wardspan"><%= HMSUtil.changeDateToddMMyyyy(otBooking.getSurgeryDate())%></span>

<label class="bodytextB">Surgery Name :</label> <span class="wardspan"><%= otBooking.getChargeCode().getChargeCodeName() %></span>



<label class="bodytextB">OT Name :</label> <span class="wardspan"><%= otBooking.getOt().getOtName() %></span>
<br>
<label class="bodytextB">Surgeon Name:</label> <%
   String name = "";
    for(OtBookSurgeon otBookingSur : otBookSurgeonList){ 
	   
       if(name.length() == 0){
	    name = name + otBookingSur.getEmployee().getFirstName() + " " + otBookingSur.getEmployee().getMiddleName() + " " + otBookingSur.getEmployee().getLastName();
	   }else{
		name = name + ","+ otBookingSur.getEmployee().getFirstName() + " " + otBookingSur.getEmployee().getMiddleName() + " " + otBookingSur.getEmployee().getLastName();   
	   }
   }
   %> <span class="wardspan"><%=name %></span> <%}}else{ %> <span
	class="wardspan"><%="No Data Found"%></span> <%} %>
</div>

