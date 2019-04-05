<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<div id="show">
<script type="text/javascript"
	language="javascript">
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
	</script> <script type="text/javascript">
		function checkLD()
		{
		
		}
	</script> <%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			 	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			 	List<Patient> patientList = new ArrayList<Patient>();
			 	List<OpdPatientDetails> visitList = new ArrayList<OpdPatientDetails>();
			 	Date toDate  = null;
				Date fromDate=null;
				//String category=null;
				int category=0;
			 	
				
			 	if (map.get("rankCategoryList") != null) {
			 		rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
			 	}
			 	if (map.get("disposalList") != null) {
			 		disposalList = (List<MasDisposal>) map.get("disposalList");
			 	}
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 	}
			 	if (map.get("showList") != null) {
			 		visitList = (List<OpdPatientDetails>) map.get("showList");
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 	}
			 	if (map.get("category") != null) {
			 		category = (Integer) map.get("category");
			 	}
			 	 int hospitalId =0;
			     if(map.get("hospitalId")!=null){
			    	 hospitalId = (Integer)map.get("hospitalId");
			     }
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <label class="noWidth"><span> <%=message %></label> </span>
<div class="Clear"></div>
<%}%>

<input type="hidden" name="hospitalId" value="<%=hospitalId %>"/>
<div class="Clear"></div>
<%if(visitList.size()>0)
{ %>
<table id="EdReturn" cellpadding="0" cellspacing="0">
  	<thead>
     	<tr>
			<th>Service No.</th>
			<th>Rank</th>
			<th>Name</th>
			<th>Branch / Trade</th>
			<%---
			<th width="7%">Age</th> --%>
			<th>Diagnosis</th>
			<th>No of days</th>
			<th>Date</th>
			<th>How disposed off</th>
			<th>Unit</th>
			<%--
			<th width="10%">No of days</th>
			<th width="20%">Date of ED</th>
			<th width="12%">Disposal</th>
			 --%>
			
		</tr> 
     
   </thead>
  <tbody>
  <% 
	  int inc=0;
	  for(OpdPatientDetails patientDetail:visitList)
	  {
		  String patientName="";
		  if(patientDetail.getVisit().getHin().getPFirstName()!=null)
			  patientName=patientName+patientDetail.getVisit().getHin().getPFirstName();
		  if(patientDetail.getVisit().getHin().getPMiddleName()!=null)
			  patientName=patientName+" "+patientDetail.getVisit().getHin().getPMiddleName();
		  if(patientDetail.getVisit().getHin().getPLastName()!=null)
			  patientName=patientName+" "+patientDetail.getVisit().getHin().getPLastName();
		  String Date_Of_Ed="dateOfEd"+inc;
		 %> <tr>
			<td>
			 <input type="hidden" name="opdId" id="opdId<%=inc %>" value="<%=patientDetail.getId() %>" />
			 <input type="text" tabindex="1" size="4"	value="<%=patientDetail.getVisit().getHin().getServiceNo() %>" id="serviceNo<%=inc %>"
					name="<%=RequestConstants.SERVICE_NO%>" readonly="readonly" />
			</td>
			<%if(patientDetail.getVisit().getHin().getRank()!=null)
					{
						%>
				<td width="7%">
				<input type="text" size="5"  tabindex="1" name="<%=RequestConstants.RANK%>"
					value="<%=patientDetail.getVisit().getHin().getRank().getRankName() %>" id="rank<%=inc%>" readonly="readonly"/>
				</td>	
			<%}else{ %>
				<td width="7%">
				<input type="text" size="5"  tabindex="1" name="<%=RequestConstants.RANK%>"
					value="" id="rank<%=inc%>" readonly="readonly"/>
				</td>	
			<%} %>	
				<td width="16%">
				 <input	type="text" size="22" tabindex="1"  value="<%=patientName %>"
					name="patientName" id="patientName<%=inc%>" readonly="readonly"/>
			</td>
			<%if(patientDetail.getVisit().getHin().getTrade()!=null)
					{
						%>
			<td width="10%">
					<input
					type="text" tabindex="1" size="5"  value="<%=patientDetail.getVisit().getHin().getTrade().getTradeName() %>"
					name="trade" id="trade<%=inc%>" readonly="readonly"/>
					</td>
			<%}else{ %>
			<td width="10%">
					<input
					type="text" tabindex="1"  value="" size="5"
					name="trade" id="trade<%=inc%>" readonly="readonly"/>
					</td>
			<%} %>		
			<%
			String diagnosis="";
			String noOfDays="";
			String opdDate="";
			/*Set<DischargeIcdCode> dischargeIcdSet = new HashSet<DischargeIcdCode>();
			dischargeIcdSet = patientDetail.getVisit().getDischargeIcdCodes();
			for(DischargeIcdCode dischargeIcdCode :dischargeIcdSet)
			{
				if(!diagnosis.equals("")){
					diagnosis += ",";
				}
				diagnosis +=" "+dischargeIcdCode.getIcd().getIcdName();
			}*/
			if(patientDetail.getInitialDiagnosis()!=null){
				diagnosis = patientDetail.getInitialDiagnosis();
			}
			if(patientDetail.getDays() !=null){
				noOfDays=patientDetail.getDays();
			}
			if(patientDetail.getOpdDate() !=null){
				opdDate=HMSUtil.convertDateToStringTypeDateOnly(patientDetail.getOpdDate());
			}
			%>
			<td width="10%">
					<input size="40"
					type="text" tabindex="1" value="<%=diagnosis%>"
					name="diagnosis" id="diagnosis<%=inc%>" maxlength="100"/>
					</td>	
         		<td width="10%">
					<input size="2"
					type="text" tabindex="1" value="<%=noOfDays %>"
					name="noOfDay" id="noOfDay<%=inc%>"  readonly="readonly"/>
					</td>
					<td>
					<input size="7"
					type="text" tabindex="1" value="<%=opdDate %>"
					name="opdDate" id="opdDate<%=inc%>"  readonly="readonly"/></td>
					<td><input size="20"
					type="text" tabindex="1" value="<%=patientDetail.getDisposedOff()!=null?patientDetail.getDisposedOff():"" %>"
					name="disposedOff" id="disposedOff<%=inc%>"  maxlength="50"/></td>
					<td width="10%">
					<input size="10"
					type="text" tabindex="1"  value="<%=patientDetail.getVisit().getHin().getUnit().getUnitName() %>"
					name="unit" id="unit<%=inc%>" readonly="readonly"/>
         	</td>
			<%--- 
			<td width="7%">
					<input size="7%"
					type="text" tabindex="1"  value="<%=visit.getHin().getAge() %>"
					name="age" id="age<%=inc%>" readonly="readonly"/>
					</td>
					<%if(visit.getHin().getUnit()!=null)
					{
						%>			
			
         	<%}else{ %>
         	<td width="10%">
					<input size="10%"
					type="text" tabindex="1"  value=""
					name="unit" id="unit<%=inc%>" readonly="readonly"/>
         	</td>
         	<%} %>
		
			<td width="18%">
					<input size="20%"
	              type="text" id="edDate<%=inc %>" tabindex="1" name="<%=Date_Of_Ed%>" title="ED Date" value=""
	              class="calDate" validate="Date of ED," MAXLENGTH="30"
                  readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	             width="16" height="16" border="0" validate="Pick a date"
	             class="calender"
	             onClick="setdate('<%=currenDate%>',document.EDDetails.<%=Date_Of_Ed%>,event)" />

					</td>
			<td width="15%">
				<select id="edDispose<%=inc %>" name="disposal_name" tabindex="1">
                 <option value="0">Select</option>
                 <%for(MasDisposal masDisposal:disposalList)
                 {	 %>
                  <option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalCode() %></option>
                  <%} %>
	            </select>
			</td>	--%>
		<% inc++; 
	  }
	  %>
	   <input type="hidden" name="inc" id="inc" value="<%=inc %>" />
  
	</tbody>
	</table>
	<input type="button" name="print" id="print" value="print" class="button"
	onClick="submitForm('EDDetails','/hms/hms/mis?method=showEDreports');"	accesskey="u" tabindex=1 />
	<%---
	<input type="button" name="edit" id="editbutton" value="Submit" class="button"
	onClick="if(checkValue()){submitForm('EDDetails','/hms/hms/mis?method=editEDReturns');}"
	accesskey="u" tabindex=1 /> --%>
	</div>
	<%}
  else
  { 
  %><h4>No Record Found.</h4>
  <%} %>