<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.IpdHandTakeOver"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<style>

</style>

<%-- <%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%> --%>

<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	
	%>
	 <%
	
	List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
	if(map.get("ipdHandTakeOverList")!=null){
		ipdHandTakeOverList= (List<IpdHandTakeOver>)map.get("ipdHandTakeOverList");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
%>
 <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Care transfer Acceptance</h2>
</div>
<div class="clear"></div>

</form>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp"  />
<div class="clear"></div>
<form name="careAcceptance" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "select"], [2,"transferdate"], [3,"transfertime"], [4,"uhid"],[5,"pname"],[6,"ipdno"],[7,"fdept"],[8,"fdoctor"],[9,"tdept"],[10,"tdoctor"],[11,"authby"]];
	 statusTd = 9;
	</script>
	
</div>

<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "select";
	
	data_header[1] = new Array;
	data_header[1][0] = "Transfer Date"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "transferdate";
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Transfer Time"
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "transfertime";
	
	data_header[3] = new Array;
	data_header[3][0] = "UHID"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "uhid";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "patName";
	
	data_header[5] = new Array;
	data_header[5][0] = "IP No."
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "ipdno";
	
	
	data_header[6] = new Array;
	data_header[6][0] = "From Dept"
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "fdept";
	
	data_header[7] = new Array;
	data_header[7][0] = "From Doctor"
	data_header[7][1] = "data";
	data_header[7][2] = "20%";
	data_header[7][3] = "fdoctor";
	
	data_header[8] = new Array;
	data_header[8][0] = "To Dept"
	data_header[8][1] = "data";
	data_header[8][2] = "20%";
	data_header[8][3] = "tdept";
	
	data_header[9] = new Array;
	data_header[9][0] = "To Doctor"
	data_header[9][1] = "data";
	data_header[9][2] = "20%";
	data_header[9][3] = "tdoctor";
	
	
	data_header[10] = new Array;
	data_header[10][0] = "Autherized By"
	data_header[10][1] = "data";
	data_header[10][2] = "20%";
	data_header[10][3] = "authby";
	
	<%
	System.out.println("ipdHandTakeOverList size is == "+ipdHandTakeOverList.size());
	%>
	 data_arr = new Array();
	<%
	if(ipdHandTakeOverList.size()>0)
	{ 
		int handtakeCount=0;
		%>
		 data_arr = new Array();
		<%
		for(IpdHandTakeOver ipdHandTakeOver:ipdHandTakeOverList)
		{
			String transferPatientname=ipdHandTakeOver.getHin().getPFirstName();
			if(ipdHandTakeOver.getHin().getPMiddleName()!=null){
				transferPatientname += " "+ipdHandTakeOver.getHin().getPMiddleName();
			}
			if(ipdHandTakeOver.getHin().getPLastName()!=null){
				transferPatientname += " "+ipdHandTakeOver.getHin().getPLastName();
			}
			
			String fromDoctorName=ipdHandTakeOver.getHandBy().getFirstName();
			if(ipdHandTakeOver.getHandBy().getMiddleName()!=null){
				fromDoctorName += " "+ipdHandTakeOver.getHandBy().getMiddleName();
			}
			if(ipdHandTakeOver.getHandBy().getLastName()!=null){
				fromDoctorName += " "+ipdHandTakeOver.getHandBy().getLastName();
			}
			
			String toDoctorName=ipdHandTakeOver.getTakeBy().getFirstName();
			if(ipdHandTakeOver.getTakeBy().getMiddleName()!=null){
				toDoctorName += " "+ipdHandTakeOver.getTakeBy().getMiddleName();
			}
			if(ipdHandTakeOver.getTakeBy().getLastName()!=null){
				toDoctorName += " "+ipdHandTakeOver.getTakeBy().getLastName();
			}
			String status="Pending";

			
		%>
		
		    
			data_arr[<%=handtakeCount%>] = new Array();
			data_arr[<%=handtakeCount%>][0] = '<%=ipdHandTakeOver.getId()%>'
			data_arr[<%=handtakeCount%>][1] = '<input type="radio" name="handoverId" id="handoverId<%=handtakeCount%>" value="<%=ipdHandTakeOver.getId()%>" style="margin:0;">'
			data_arr[<%=handtakeCount%>][2] ="<%=ipdHandTakeOver.getEntryDate()%>"
			data_arr[<%=handtakeCount%>][3] = "<%=ipdHandTakeOver.getEntryTime()%>"
			data_arr[<%=handtakeCount%>][4] = "<%=ipdHandTakeOver.getHin().getHinNo()%>"
			data_arr[<%=handtakeCount%>][5] = "<%=transferPatientname%>"
			data_arr[<%=handtakeCount%>][6] = "<%=ipdHandTakeOver.getInpatient().getAdNo()%>"
			data_arr[<%=handtakeCount%>][7] = "<%=ipdHandTakeOver.getFromDepartment().getDepartmentName()%>"
			data_arr[<%=handtakeCount%>][8] = "<%=fromDoctorName%>"
			data_arr[<%=handtakeCount%>][9] = "<%=ipdHandTakeOver.getDepartment().getDepartmentName()%>"
			data_arr[<%=handtakeCount%>][10] = "<%=toDoctorName%>"
			data_arr[<%=handtakeCount%>][11] = "<%=status%>"
			<%
			handtakeCount++;
			}
	}
	%>
	
		
		
	
    formName = "careAcceptance";
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label class="valueAuto">Ward/Bed Transfer Required</label>

<input type="checkbox" class="radioCheck" name="transferRequired" id="transferRequired" value="1" />
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>Remarks</label>
<textarea rows="" cols="" class="medium" name="<%=REMARKS%>" id="<%=REMARKS%>" ></textarea>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div> 
<input type="button" name="Submit" value="Take Over" class="button" onclick="submitAcceptTCareransfer();" />
<input type="button" name="Submit" value="Reject" class="button" onclick="submitrejectCareTransfer();" />
<input type="button" name="Submit" value="Reset" class="button" onClick="submitFormForButton('careAcceptance','ipd?method=showCareTransferAccepJsp');" />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('careAcceptance','ipd?method=showPatientListJsp');"/>
<div class="clear"></div>

<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
</form>
</div>
<div class="clear"></div>
<div class="clear"></div>



<script type="text/javascript" >

function submitAcceptTCareransfer()
{
	var patientSelected=false;
	var patients=document.getElementsByName('handoverId');
	for(var j=0;j<patients.length;j++)
		{
		if(patients[j].checked)
		{
			patientSelected=true;
			transferId=patients[j].value;
			break;
		}
		}
	if(!patientSelected)
		{
		alert('Please select Patient.');
		return;
		}
	
	 document.getElementById("<%=REMARKS%>").setAttribute("validate", "Remarks,metachar,no");
	
	submitForm('careAcceptance','/hms/hms/ipd?method=submitCareTransferAccepJsp&Accept=1');
	
	
	
}
	
function submitrejectCareTransfer()
{
	var patientSelected=false;
	var bedSelected=false;
	var bedrequired=false;
	var transferId=0;
	var patients=document.getElementsByName('handoverId');
	for(var j=0;j<patients.length;j++)
		{
		if(patients[j].checked)
		{
			patientSelected=true;
			transferId=patients[j].value;
			break;
		}
		}
	if(!patientSelected)
		{
		alert('Please select Patient.');
		return;
		}
	
	 document.getElementById("<%=REMARKS%>").setAttribute("validate", "Remarks,metachar,no");
	
	submitForm('careAcceptance','/hms/hms/ipd?method=submitCareTransferAccepJsp&Accept=2');
	
}
</script>
