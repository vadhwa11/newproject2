<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.StoreProformaHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">




<script	type="text/javascript" language="javascript">



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
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
String message = "";
Date toDate  = null;
Date fromDate = null;
int unitId=0;
List<StoreOpPatientIssueT> storeOpPatientIssueTList=new ArrayList<StoreOpPatientIssueT>();
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
Map<String, Object> dailyIssueItem = new HashMap<String, Object>();
if (map.get("dailyIssueItem") != null) {

	dailyIssueItem = (Map<String, Object>)map.get("dailyIssueItem");

}
List objectList = new ArrayList();
	if (dailyIssueItem.get("objectList") != null) {
		objectList = (List)dailyIssueItem.get("objectList");

	}
	String reportType="";
	if(map.get("reportType") != null){
		reportType= (String) map.get("reportType");
	}
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	if (map.get("deptList") != null) {
		deptList = (List<MasDepartment>)map.get("deptList");

	}
	if (dailyIssueItem.get("deptList") != null) {
		deptList = (List<MasDepartment>)dailyIssueItem.get("deptList");

	}



	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<StoreProformaHeader> storeProformaHList = new ArrayList<StoreProformaHeader>();
		List<StoreProformaHeader> storeProformaHList1 = new ArrayList<StoreProformaHeader>();
		if(map.get("hospitalList")!= null){
			hospitalList = (List<MasHospital>)map.get("hospitalList");

		}
		if(map.get("storeProformaHList")!= null){
			storeProformaHList = (List<StoreProformaHeader>)map.get("storeProformaHList");
		}

		if(map.get("storeProformaHList1")!= null){
			storeProformaHList1 = (List<StoreProformaHeader>)map.get("storeProformaHList1");
		}
		if(map.get("unitId")!= null){
			unitId = Integer.parseInt((""+map.get("unitId")));
		}


	if (dailyIssueItem.get("msg") != null) {
	             message = (String)dailyIssueItem.get("msg");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
	<h4><%=message %></h4>
	<%} %>

<form name="proformaBApproval" action="" method="post">
<div class="clear"></div>
<div class="titleBg">
<h2>Proforma B Pending for Approval</h2>
</div>
<div class="clear"></div>
<div class="Block">

 <label > Total Pending</label>
<% if(storeProformaHList.size() > 0){ %>
<input type="text" name="pending" id="pending" value="<%=storeProformaHList.size() %>" readonly maxlength="30" tabindex=1 />
<%}else{ %>
<input type="text" name="pending" id="pending" value="0" readonly maxlength="30" tabindex=1 />
<%} %>
	<!-- javed add section  -->

	<label> Unit</label>
	<select id="unit" name="unit" class="auto"  onchange=""  MAXLENGTH="25" tabindex=1>
	<option value="0">Select</option>
<%--
				  <%
				  for(MasHospital masHospital : hospitalList) {
					  if(unitId == masHospital.getId()){
				  %>
				  <option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
				  <%}}%> --%>
				  <%-- <option value="0">Select</option>--%>
				  <%
				  for(MasHospital masHospital : hospitalList) {
				  %>
				   <option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
				  <%}%>
				</select>
				<script>
					document.getElementById('unit').value = '<%=unitId%>'
				</script>
				<input type="button" name="add" id="addbutton" value="Display" class="button" onClick="submitForm('proformaBApproval','stores?method=getPendingProformaForApprovalAccont');" accesskey="a" tabindex=1 />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="divison"></div>
<div class="division"></div>


<%if(storeProformaHList1.size()>0){ %>
<%--
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">--%>
<!-- <table id="main"> -->
 <table width="90%" colspan="5" border="00" cellpadding="0"	cellspacing="0">
	<thead>
		<tr>
			<th width="2%"></th>
			<th width="10%">Proforma B No.</th>
			<th width="10%">Proforma B Date</th>
			<th width="78%">View Details</th>

		</tr>
	</thead>

		<%
		int count=0;
		for (StoreProformaHeader sph : storeProformaHList1) {

		//Object[] object = (Object[]) iterator.next();
		%>


<tr>

<td ><input type="radio" name="pId"  id="pId" value="<%=sph.getId() %>" />
<input type="hidden" name="hId"  id="hId" value="<%=sph.getHospital().getId() %>" />
</td>
<td><%--<%=++count %>--%><%=sph.getProformaNo() %>
<input type="hidden" name="pId1" id="pId1" value="<%=sph.getId() %>" readonly tabindex=1 />
<input type="hidden" name="pNo" id="pNo" value="<%=sph.getProformaNo() %>" readonly tabindex=1 />

</td>
<td ><%=HMSUtil.changeDateToddMMyyyy(sph.getProformaDate())%></td>
<td ><input type="button" name="add" id="addbutton" value="View Details" class="button" onClick="openPopupWindow();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="View PDF" class="button" onClick="openPdf();" accesskey="a" tabindex=1 />
</td>

</tr>
 <%}%>

</table>
<%--</div> --%>


<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<label>Viewed</label>
	<select id="approval" name="approval" validate="Approved ,String,no"  MAXLENGTH="25" tabindex=1>
	<option value="0">Select</option>
	<option value="p">Yes</option>
	<%--<option value="c">No</option> --%>
</select>
<label>Remarks</label>
<textarea value=""	name="remarks" id="remarks" validate="Remarks ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" />
 </textarea>
 
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="setApproval()" accesskey="a" tabindex=1 />
<%}else{%>
<h4>No Record Found !</h4>
<%} %>

</form>
<script>

function checkPvms()
{
	var pvmsNo='';
	 pvmsNo=document.getElementById('pvmsNiv').value;

	if(pvmsNo=='')
	{
		alert("Please Enter pvmsNo ");
		return false;
	}else
	{
		return true;
	}


}
function methodForReport(){
	var pvmsNo=document.getElementById('pvmsNiv').value;

	/*if(pvmsNo !=""){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSactionReport');
	}else{*/
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=p');
	//}
}
function methodForReport1(){
	var pvmsNo=document.getElementById('pvmsNiv').value;

	/*if(pvmsNo !=""){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSactionReport');
	}else{*/
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=j');
	//}
}



function setApproval()
{

 if(document.getElementById('approval').value != "0"){

 	for(var i = 0; i < document.getElementsByName('pId').length; i++){
			  if(document.getElementsByName('pId')[i].checked == true)
              {
	              //alert(document.getElementsByName('parent')[i].value)
                submitForm('proformaBApproval','stores?method=proformaBApproved&pId='+document.getElementsByName('pId')[i].value);
                return true;
			  }
  		}
  		alert("Please select the Proforma  No. !!!")
		return false;
 }else{
	 alert("Please select the Approved  !!!")
		return false;
 }

}



function openPopupWindow()
{



	for(var i = 0; i < document.getElementsByName('pId').length; i++){
		  if(document.getElementsByName('pId')[i].checked == true)
        {
            //alert(document.getElementsByName('parent')[i].value)
          var proformaId = document.getElementsByName('pId')[i].value
         // alert(proformaId);
          var url="/hms/hms/stores?method=showProformaBeforApproval&pId="+proformaId;
  			newwindow=window.open(url,'name','top=0, left=5, height=800,width=1010,status=1,scrollbars=yes');
          return true;
		  }
	}
	alert("Please select the Proforma  No. !!!")
	return false;

}

function prescriptionDetails(val){
	//alert(val);
	if(val != null)
	submitProtoAjax('dailyIssueSummery','stores?method=showPrescriptionDetailsReport&precriptionId='+val);

}
function openPdf()
{
	for(var i = 0; i < document.getElementsByName('pId').length; i++){
		  if(document.getElementsByName('pId')[i].checked == true)
        {

          var proformaNo = document.getElementsByName('pNo')[i].value
          //alert(proformaId);
  			submitForm('proformaBApproval','stores?method=generateProformaBReport&proformaNo='+proformaNo);
          return true;
		  }
	}
	alert("Please select the Proforma  No. !!!")
	return false;

}
</script>