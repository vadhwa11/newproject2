

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<script type="text/javascript" language="javascript">
function addMonths()
{
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
      v.setMonth(v.getMonth() + 9);
       v.setDate(v.getDate() + 7);
      var curr_date = v.getDate();
      
      var curr_month = v.getMonth();
      
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = curr_month+1;
       			mth = "0"+mth;
           			
       		}
       		else
       		{
       			mth = curr_month+1;
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
	else
	{
	  document.getElementById('eddId').value="";
	}
}
function setFocusLmp()
{
	  document.gravidagramGestationalDiabitiesOne.<%=LMP%>.focus();
}
function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP")
	  return false;
	}
	else
	{
	return true;
	}
}	

</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<OpdPatientDetails> fwcPatientDataList = new ArrayList<OpdPatientDetails>();
	
	List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();	
	if(map.get("fwcPatientDataList") != null){
		fwcPatientDataList=(List)map.get("fwcPatientDataList");
	}
	if(map.get("fwcOpdDetailHistoryList") != null){
		fwcOpdDetailHistoryList=(List)map.get("fwcOpdDetailHistoryList");
	}
	




%>
<!--main content placeholder starts here-->
<form name="antenatalCard" action="" method="post">
<script type="text/javascript">
	   var icdArray=new Array();

	</script>
<div class="titleBg">
<h2>Delivery Details</h2>
</div>



<div class="clear"></div>

<div class="clear"></div>
	
<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col" rowspan="">Name Of Hospital</TH>
<TH scope="col" rowspan="">Time Of Birth</TH>
<TH scope="col" rowspan="">Type Of Delivery</TH>
<TH scope="col" colspan="">Gestational Age</TH>
<TH scope="col" colspan="">Perinatal History/Neonatal Illness</TH>
</tr>



<%for(OpdPatientDetails opd : fwcPatientDataList){
	
	String p="";
	Set<OpdPatientHistory> ophs=new HashSet<OpdPatientHistory>();				
    ophs=opd.getOpdPatientHistorys();
    for(OpdPatientHistory oph : ophs)
	{
 		System.out.println("oph in jsp-->"+oph.getOpdPatientDetails().getId());
		
	if(oph.getOpdPatientDetails().getId()==opd.getId())
	{
	 p=oph.getPresentComplain()!=null?oph.getPresentComplain():"";
	 break;
	}

    }
	%>
<tr>
<td>

<%if(opd.getHospName()!=null){ %>
<label class="value"><%=opd.getHospName()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
 <td>
 <%if(opd.getTimeOfBirth()!=null){ %>
<label class="value"><%=opd.getTimeOfBirth()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
 </td>
<td>
<%if(opd.getTypeOfDelivery()!=null){ %>
<label class="value"><%=opd.getTypeOfDelivery()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>
<td>
<%if(opd.getGestationalAge()!=null){ %>
<label class="value"><%=opd.getGestationalAge()%></label>
<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</td>

<td>
<%if(!p.equals("")){ %>
<label class="value"><%=p%></label>

<%}else{ %>
<label class="valueSmall">-</label>
<%} %>
</tr>
<%}
 %>
</table>
<div class="clear"></div>


</form>