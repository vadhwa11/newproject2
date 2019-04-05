<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.AmeLmc"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.IFNULL"%>
<%@page import="jkt.hms.masters.business.AmeLmcHeader"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="java.text.SimpleDateFormat"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%  
   String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<AmeLmc> ameLmcList=new ArrayList<AmeLmc>();
	List<AmeLmcHeader> ameLmcHList = new ArrayList<AmeLmcHeader>();
	AmeLmcHeader ameLmcH = null;
	List<AmeLmcHeader> existAmeList = new ArrayList<AmeLmcHeader>();
	
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("lmcList") != null) {
 		ameLmcList = (List<AmeLmc>) map.get("lmcList");
 	}
 	if(map.get("ameH") != null){
 		ameLmcH = (AmeLmcHeader) map.get("ameH");
 	}
 	
 	if(map.get("existAmeList") != null)
 		existAmeList = (List<AmeLmcHeader>) map.get("existAmeList");
 	
 	String fwdLetter = "";
 	String fwdLetterDate = "";
 	String recpLetter = "";
 	String recpLetterDate = "";
 	String remarks = "";
 	int ameH = 0; %>
 	
  	<div id="contentHolder">
  	<h2>LMC Details</h2>
      <div class="blockFrame">
      <%if(ameLmcH != null){ %>
      <label  class="bodytextB">Fwd-letter No:</label>  
      <label style="FONT-SIZE: 13px; COLOR: black;font-weight: bold;"><%= ameLmcH.getFwdLetterNo()!= null ? ameLmcH.getFwdLetterNo() :""%> </label>
      <label  class="bodytextB">Fwd-letter Date:</label>
      <label style="FONT-SIZE: 13px; COLOR: black;font-weight: bold;"><%= ameLmcH.getFwdLetterDate()!= null ? HMSUtil.convertDateToStringWithoutTime(ameLmcH.getFwdLetterDate()):""%> </label>
      <label  class="bodytextB">Receipt-letter No:</label>
      <label style="FONT-SIZE: 13px; COLOR: black;font-weight: bold;"><%= ameLmcH.getReceiptLetterNo()!= null ? ameLmcH.getReceiptLetterNo():""%> </label>
     <div class="Clear"></div>
      <label  class="bodytextB">Receipt-letter Date:</label>
     <label style="FONT-SIZE: 13px; COLOR: black;font-weight: bold;"><%= ameLmcH.getReceiptLetterDate()!= null ? HMSUtil.convertDateToStringWithoutTime(ameLmcH.getReceiptLetterDate()):""%> </label>
	 <label  class="bodytextB">Remarks:</label>
	   <textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
       	class="large" tabindex="3" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	      maxlength="100" tabindex="1" /> <%=ameLmcH.getRemarks()%></textarea>
	  <%} %>
	      	 
      </div>
   <div class="blockFrame">
<div class="title">Disability Details</div>
<div class="Clear"></div>
<div id="testDiv">
  	<div class="tableHolderAuto">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	  <tr>
	    <th scope="col">Disablity Name</th>
	    <th scope="col">Category </th>
	    <th scope="col">Duration</th>
	    <th scope="col">Perm Temp</th>
	    <th scope="col">Date of Next Review</th>
	    <th scope="col">Employment Restriction</th>
	  </tr>
	   <%   for(AmeLmc ameLmc:ameLmcList){  %>
	  <tr>
	    <td>   <label><%=ameLmc.getDisabilityName() %></label>    </td>
	    <td>   <label><%=ameLmc.getCategory().getMedicalCategoryName() %></label>  </td>
	    <td>   <label><%= ameLmc.getDuration()%></label>  </td>  
	    <td>   <label><%= ameLmc.getPermTemp().equals("P")?"Permanent":"Temporary"%></label> </td>
        <td>   <label> <%= HMSUtil.convertDateToStringWithoutTime(ameLmc.getDateOfNrv())%> </label> </td>
	    <td>   <label><%= ameLmc.getEmpRestriction()%>  </label> </td>
	  </tr>
	   <% } %>
	    	</table>
		<div class="Clear"></div>
	</div>
	  </div>
	  <input type="button" name="sub" value="Close" class="Button"  onclick="javascript:window.close();">
	 </div> 
	 </div>