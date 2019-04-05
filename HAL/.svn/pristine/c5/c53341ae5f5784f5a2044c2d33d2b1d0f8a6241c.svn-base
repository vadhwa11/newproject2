<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DgFilmDetail"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<div id="contentHolder"><script type="text/javascript"
	language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		
		String filmSizeUsedPopUp = "None";
		Integer filmUsedPopUp = 0;
		
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
		int resultId = 0;
		int dgResultEntryDetailId = 0;
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
		Set<DgFilmDetail> dgFilmDetailSet = new HashSet<DgFilmDetail>();
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		//Set<DgFilmDetail> dgFilmDetailSetAll = new HashSet<DgFilmDetail>();
		
		DgResultEntryDetail dgResultEntryDetail = null;
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		if(map.get("resultId") != null)
		{
			resultId = (Integer)map.get("resultId");
		}
		
		if(map.get("resultList") != null)
		{
			resultList = (List<DgResultEntryHeader>)map.get("resultList");
		}
		
		if(resultList.size()>0){
			//for(DgResultEntryHeader dgHeader:resultList ){
				dgResultEntryHeader = resultList.get(0);
				dgDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
			//}
			if(dgDetailSet.size()>0){
				DgFilmDetail detail =new DgFilmDetail();

				 Iterator  iterator = dgDetailSet.iterator();
				 dgResultEntryDetail = (DgResultEntryDetail)iterator.next();
				 dgResultEntryDetailId = dgResultEntryDetail.getId();
				 dgFilmDetailSet = dgResultEntryDetail.getDgFilmDetail();
				 System.out.println("film set size :"+dgFilmDetailSet.size());
				 System.out.println("dgResultEntryDetailId :"+dgResultEntryDetailId);
			}
		}

	%> <%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
 	date = (String) utilMap.get("currentDate");

 	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}

%> <script>
<%System.out.println(":::::2112::::"+filmSizeUsedPopUp);%>
//document.getElementById("filmSizeUsedPopUp").value ='<%=filmSizeUsedPopUp%>';
//document.getElementById("filmUsedPopUp").value ='<%=filmUsedPopUp%>';

</script>

<div class="Clear"></div>
<div class="blockTitle">Patient Film Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label>&nbsp;</label> <label>Impression</label> <input type="text"
	name="<%=IMPRESSION%>" id="<%=IMPRESSION%>" value="" MAXLENGTH="50" />

<%if(dgResultEntryHeader.getImpression()!=null){ %> <script
	type="text/javascript">
			document.getElementById('<%=IMPRESSION%>').value='<%=dgResultEntryHeader.getImpression()%>';
		</script> <%} %>

<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<td><label>&nbsp;</label></td>
		<td style="padding-right: 30px;"><label
			style="text-align: center;"><span>*</span>Film Size Used</label></td>
		<td style="text-align: justify;"><label
			style="text-align: center;"><span>*</span>Film Used</label></td>
		<td><input type="button" class="ButtonDel" alt="Delete"
			value=" " onclick="removeSingleRow();" style="float: right;" /></td>
		<td style="text-align: justify;"><input type="button"
			class="ButtonAdd" alt="Add" onclick="addRow();" value=" "
			style="float: left;" /></td>

	</tr>
	<%
	int inc=1;
	for(DgFilmDetail dgFilmDetail : dgFilmDetailSet){ 
		String filmSizeUsed = dgFilmDetail.getFilmSize();
		
		Integer filmUsed = dgFilmDetail.getFilmUsed();

	%>
	<tr>
		<td><label>&nbsp;</label></td>
		<td style="text-align: justify;"><select
			id="filmSizeUsedPopUp<%=inc%>" name="filmSizeUsed<%=inc%>"
			validate="Film Size Used,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="17X14">17"*14"</option>
			<option value="15X12">15"*12"</option>
			<option value="12X10">12"*10"</option>
			<option value="10X8">10"*8"</option>
			<option value="USG">USG</option>
		</select></td>
		<script type="text/javascript">
			document.getElementById('filmSizeUsedPopUp<%=inc%>').value='<%=filmSizeUsed%>';
		</script>

		<td style="text-align: justify;"><select
			id="filmUsedPopUp<%=inc%>" name="filmUsed<%=inc%>"
			validate="Film Used,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select> <script type="text/javascript">
			document.getElementById('filmUsedPopUp<%=inc%>').value='<%=filmUsed%>';
		</script></td>
	</tr>
	<%
	inc++;	
	} %>
	<%if(inc > 1) {%>
	<input type="hidden" name="hdb" value="<%=inc-1%>" id="hdb" />
	<%}else{ System.out.println("In else");%>
	<tr>
		<td><label>&nbsp;</label></td>
		<td style="text-align: justify;"><select
			id="filmSizeUsedPopUp<%=inc%>" name="filmSizeUsed<%=inc%>"
			validate="Film Size Used,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="17X14">17"*14"</option>
			<option value="15X12">15"*12"</option>
			<option value="12X10">12"*10"</option>
			<option value="10X8">10"*8"</option>
			<option value="USG">USG</option>
		</select></td>

		<td style="text-align: justify;"><select
			id="filmUsedPopUp<%=inc%>" name="filmUsed<%=inc%>"
			validate="Film Used,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select></td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
	<%} %>
</table>
<div class="Clear"></div>
<input type="hidden" name="resultIdPopUp" id="resultIdPopUp"
	value="<%=resultId%>" /></div>
<div class="Clear"></div>
<%System.out.println(dgResultEntryDetailId); %> <input type="hidden"
	name="dgResultEntryDetailId" id="dgResultEntryDetailId"
	value="<%=dgResultEntryDetailId%>" /> <input type="button"
	name="submit" id="updatebutton" onclick="submitPopUpForm();"
	value="Update" class="cmnButton" accesskey="b" /></div>
<script type="text/javascript">

</script>
