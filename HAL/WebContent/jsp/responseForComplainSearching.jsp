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
<%@ page import="java.util.Iterator"%>


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
	
	
	//if(map.get("patientList") != null){
		//patientList = (List<OpdPatientDetails>)map.get("patientList");
	//}
	
	List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
	List<Complain> searchComplainDetailList = new ArrayList<Complain>();
	if(map.get("searchComplainDetailList")!=null)
 	{
 		searchComplainDetailList=(List<Complain>)map.get("searchComplainDetailList"); 		
 	}
	Box box = HMSUtil.getBox(request);
	gridEmployeeList=(List<MasEmployee>)map.get("gridEmployeeList");
	String test="";
%>

<%
	if(searchComplainDetailList.size() > 0){
%>


<div id="reg">
<table class="cmntable" width="100%">

<tr>
<th>Complain Date</th>
<th>Complain By</th>
<th>Complain Type</th>
<th>Status</th>
</tr>

<%
System.out.println("Complain List JSP size--->>"+searchComplainDetailList.size());
for(Complain complain : searchComplainDetailList){
%>

<tr onclick="submitProtoAjax('complainA','/hms/hms/user?method=getComplainData&compainId=<%=complain.getId() %>')">
<td><%=HMSUtil.convertDateToStringWithoutTime(complain.getComplainDate()) %></td>
<%
		Iterator itrGridEmployeeList=gridEmployeeList.iterator();
		 while(itrGridEmployeeList.hasNext())
            {try{
             MasEmployee  masEmployee = (MasEmployee)itrGridEmployeeList.next(); 
			 if(complain.getRequestBy().getId().equals(masEmployee.getId())){
				test=complain.getRequestBy().getRank().getRankName().concat("  ").concat(complain.getRequestBy().getFirstName()).concat("  ").concat(complain.getRequestBy().getLastName());
			
            }else
            	{
            	test=complain.getRequestBy().getRank().getRankName().concat("  ").concat(complain.getRequestBy().getFirstName()).concat("  ").concat(complain.getRequestBy().getLastName());
            	}}catch(Exception e){System.out.println("Exception----> "+e);}}%>            	
<td><%=test %></td>
<td><%=complain.getRequestType()!=null?complain.getRequestType():"" %></td>
<td><%=complain.getStatus()!=null?complain.getStatus():"" %></td>
</tr>
<%} %>
</table>
</div>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>
