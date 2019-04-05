
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	List<Visit> meVisitList = new ArrayList<Visit>();
	int totalPatient=0;
	if(map.get("meVisitList") != null)
	{
		meVisitList=(List<Visit>)map.get("meVisitList");
	}
	List<String> labResultStausList = new ArrayList<String>();
	if(map.get("labResultStausList") != null)
	{
		labResultStausList=(List<String>)map.get("labResultStausList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	%>

<div class="titleBg">
<h2>Waiting List </h2>
</div>
<div class="clear"></div>
<%
if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
	<h4><span><%=message %></span></h4>
	<%} %>

<form name="meWaitingList" method="post" action="">
<div class="clear"></div>
<div class="clear"></div>
</form>
<div class="clear"></div>

<div class="floatRight">
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex="2" class="cmntable noBg"></div>

<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.VISIT_NUMBER %>"], [3,"<%= RequestConstants.VISIT_DATE %>"],[4,"<%= RequestConstants.VISIT_TIME %>"],[5,"<%= RequestConstants.HIN_NO %>"],[6,"<%=RequestConstants.SERVICE_NO%>"],[7,"<%= RequestConstants.RANK_NAME %>"],[8,"<%=RequestConstants.PATIENT_NAME%>"],[9,"<%=RequestConstants.UNIT%>"]];
	statusTd =12;

	</script></div>

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
</div>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "Med Exam Type"

	//data_header[1] = new Array;
	//data_header[1][0] = "Visit No"
	//data_header[1][1] = "data";
	//data_header[1][2] = "8%";
	//data_header[1][3] = "<= RequestConstants.VISIT_NUMBER%>"

	data_header[1] = new Array;
	data_header[1][0] = "Visit Date"
	data_header[1][1] = "data";
	data_header[1][2] = "10%";
	data_header[1][3] = "<%= RequestConstants.VISIT_DATE %>";

	data_header[2] = new Array;
	data_header[2][0] = "Visit Time"
	data_header[2][1] = "data";
	data_header[2][2] = "5%";
	data_header[2][3] = "<%=RequestConstants.VISIT_TIME  %>";

	//data_header[4] = new Array;
	//data_header[4][0] = "HIN No"
	//data_header[4][1] = "data";
	//data_header[4][2] = "6%";
	//data_header[4][3] = "<=RequestConstants.HIN_NO%>";

	data_header[3] = new Array;
	data_header[3][0] = "Service No."
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	data_header[3][3] = "<%=RequestConstants.SERVICE_NO %>";

	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";
	data_header[4][3] = "<%=RequestConstants.RANK_NAME %>";

	data_header[5] = new Array;
	data_header[5][0] = "Name"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "<%=RequestConstants.PATIENT_NAME %>";

	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "<%=RequestConstants.UNIT %>";

	data_header[7] = new Array;
	data_header[7][0] = "Medical Exam Type"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "<%=RequestConstants.UNIT %>";

	data_header[8] = new Array;
	data_header[8][0] = "Contact No."
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "<%=RequestConstants.CONTACT_NUMBER %>";

	data_header[9] = new Array;
	 data_header[9][0] = "Status"
    data_header[9][1] = "data"
    data_header[9][2] = "10%" 
    data_header[9][3] = "<%= RequestConstants.MA_STATUS %>";   
    
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	//Iterator iterator=meVisitList.iterator();
	//while(iterator.hasNext())
	for(Visit visit:meVisitList)	
	{
	//Visit visit= (Visit) iterator.next();
	if(visit.getVisitStatus().equalsIgnoreCase("c"))
	{
	Patient patientHin=(Patient)visit.getHin();
	MasDepartment deptObj=(MasDepartment)visit.getDepartment();
	String servicepatientName="";
	if(visit.getHin().getPFirstName()!= null){
		servicepatientName=visit.getHin().getSFirstName();
	}
	//System.out.println("contactNo===hhhhh>>>>>>"+visit.getHin().getMobileNumber() );
	if(visit.getHin().getContactNo()!= null )
	{
		System.out.println("contactNo===hhhhh>>>>>>"+visit.getHin().getContactNo());
	}
	if(visit.getHin().getSMiddleName()!= null){
		servicepatientName=servicepatientName+" "+visit.getHin().getSMiddleName();
	}
	if(visit.getHin().getSLastName()!= null)
	{
		servicepatientName=servicepatientName+" "+visit.getHin().getSLastName();
	}

	MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
	String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	
	%>
	data_arr[<%= i%>] = new Array();
	data_arr[<%= i%>][0] =<%=visit.getId()%>
	data_arr[<%= i%>][1] = '<%=visit.getMedExamType()%>'

	//<
	//if(visit.getVisitNo()!=null)
	//{
	//>
	//data_arr[<//%= i%>][2] = "<//%=visit.getVisitNo()%>"
	//<
	//}else{
	// %>
	//data_arr[<//%= i%>][2] = ""
	<%
	//}
	if(visit.getVisitDate()!=null)
	{
	%>
	data_arr[<%= i%>][2]="<%=visitDate%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][2]=""
	<%
	}
	if(visit.getVisitTime()!= null || visit.getVisitTime()!= "" )
	{
	%>
	data_arr[<%= i%>][3] = "<%=visit.getVisitTime()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = ""
	<%
	}%>
	//if(visit.getHin().getHinNo()!= null ||visit.getHin().getHinNo() != "")
	//{
	
	//data_arr[< i%>][5] = "<visit.getHin().getHinNo()%>"
	//<
	//}else{
	//%>
	//data_arr[< i%>][5] = ""
	
	//}
	<%
	if(visit.getHin().getServiceNo()!= null )
	{
	%>
	data_arr[<%= i%>][4] = "<%=visit.getHin().getServiceNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][4] = ""

		<%
	}
	if(visit.getHin().getRank().getRankName()!= null )
	{
	%>
	data_arr[<%= i%>][5] = "<%=visit.getHin().getRank().getRankName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][5] = ""
	<%
	}
	if(servicepatientName!= null )
	{
	%>
	data_arr[<%= i%>][6] = "<%=servicepatientName%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][6] = ""
	<%}
	if(visit.getHin().getUnit() != null)
	{
	%>

	data_arr[<%= i%>][7] = "<%=visit.getHin().getUnit().getUnitName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][7] = ""
	<%   }
	if(servicepatientName!= null )
	{
	%>
	data_arr[<%= i%>][8] = "<%=visit.getMedExamType()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""
	<%}
	if(visit.getHin().getMobileNumber()!= null)
	{
	%>
	data_arr[<%= i%>][9] = "<%= visit.getHin().getMobileNumber() %>"
		
	<%}else{
		%>
		data_arr[<%= i%>][9] = ""
			<%}
	String ma_status="";
	Set<DgOrderhd> dgOrderhdSet=new HashSet<DgOrderhd>();
		boolean orderStatusFlag=true;
	if(visit.getDgOrderhds()!=null){
		dgOrderhdSet=visit.getDgOrderhds();
		//System.out.println(visit.getId()+"<-visit id-dgOrderhdSet.size()-->"+dgOrderhdSet.size());
		if(dgOrderhdSet.size()>0){
		
		/**	
			for(DgOrderhd dgOrderhd:dgOrderhdSet){
				Set<DgOrderdt> dgOrderdtSet=new HashSet<DgOrderdt>();
				if(dgOrderhd.getDgOrderdts()!=null){
					dgOrderdtSet=dgOrderhd.getDgOrderdts();
					if(dgOrderdtSet.size()>0){
						for(DgOrderdt dgOrderdt :dgOrderdtSet){
							if(!dgOrderdt.getOrderStatus().equalsIgnoreCase("p")){
								orderStatusFlag=false;
								break;
							}
						}
					}
					if(orderStatusFlag){
						break;
					}
				}**/
				/*
				System.out.println("dgOrderhd.getId--->"+dgOrderhd.getId());
				Set<DgSampleCollectionHeader> dgSampleCollectionHeaderSet=new HashSet<DgSampleCollectionHeader>();
				if(dgOrderhd.getDgSampleCollectionHeaders()!=null){
				dgSampleCollectionHeaderSet=dgOrderhd.getDgSampleCollectionHeaders();
				System.out.println("dgSampleCollectionHeaderSet.size()-->"+dgSampleCollectionHeaderSet.size());
				if(dgSampleCollectionHeaderSet.size()>0){
					for(DgSampleCollectionHeader dgSampleCollectionHeader :dgSampleCollectionHeaderSet){
						Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet=new HashSet<DgSampleCollectionDetails>();
						if(dgSampleCollectionHeader.getDgSampleCollectionDetails()!=null){
						dgSampleCollectionDetailsSet=dgSampleCollectionHeader.getDgSampleCollectionDetails();
						System.out.println("dgSampleCollectionDetailsSet.size()-->"+dgSampleCollectionDetailsSet.size());
						if(dgSampleCollectionDetailsSet.size()>0){
							for(DgSampleCollectionDetails dgSampleCollectionDetails :dgSampleCollectionDetailsSet){
								if(!dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("e")){
									orderStatusFlag=true;
									break;
								}
							}
						}
						if(orderStatusFlag){
							break;
						}
					}
					}
				}
				if(orderStatusFlag){
					break;
				}
			}
				*/
			/**}
			if(!orderStatusFlag){
				ma_status="Result Validated";
			}else{
				if(visit.getPriority()!=null){
					if(visit.getPriority()==4){
						ma_status="Pending For Result";
					}else if(visit.getPriority()==5){
						ma_status="Pending For Result";
					}else if(visit.getPriority()==6){
						ma_status="Pending For Result";
					}else if(visit.getPriority()==7){
						ma_status="Rejected By MO";
					}else if(visit.getPriority()==8){
						ma_status="Rejected By MO";
					}else if(visit.getPriority()==9){
						ma_status="Rejected By MO";
					}else{
						ma_status="New";
					}
				}else{
					
					ma_status="New";
				}
			} **/
			String labResultStatus=labResultStausList.get(i);
			if(labResultStatus.equalsIgnoreCase("no"))
			{
				ma_status="New";
			}else if(labResultStatus.equalsIgnoreCase("pending"))
			{
				ma_status="Investigation Pending";
			}else if(labResultStatus.equalsIgnoreCase("validated"))
			{
				ma_status="Result Validated";
			}
			if(visit.getPriority()!=null)
			{
			if(visit.getPriority()==7){
				ma_status="Rejected By MO";
			}else if(visit.getPriority()==8){
				ma_status="Rejected By MO";
			}else if(visit.getPriority()==9){
				ma_status="Rejected By MO";
			}
			}	
			
		}else{
			if(visit.getPriority()!=null){
				if(visit.getPriority()==4){
					ma_status="Investigation Pending";
				}else if(visit.getPriority()==5){
					ma_status="Investigation Pending";
				}else if(visit.getPriority()==6){
					ma_status="Investigation Pending";
				}else if(visit.getPriority()==7){
					ma_status="Rejected By MO";
				}else if(visit.getPriority()==8){
					ma_status="Rejected By MO";
				}else if(visit.getPriority()==9){
					ma_status="Rejected By MO";
				}else{
					ma_status="New";
				}
			}else{
				
				ma_status="New";
			}
		}
	//System.out.println("orderStatusFlag-->"+orderStatusFlag);
	}

	
	/*
	if(visit.getPriority()!=null){
		if(visit.getPriority()==4){
			ma_status="Pending For Result";
		}else if(visit.getPriority()==5){
			ma_status="Pending For Result";
		}else if(visit.getPriority()==6){
			ma_status="Pending For Result";
		}else if(visit.getPriority()==7){
			ma_status="Rejected By MO";
		}else if(visit.getPriority()==8){
			ma_status="Rejected By MO";
		}else if(visit.getPriority()==9){
			ma_status="Rejected By MO";
		}else{
			ma_status="New";
		}
	}else{
		
		ma_status="New";
	}
	*/
	%>
	data_arr[<%= i%>][10] = "<%=ma_status%>"
	<%
	if(visit.getPriority()!= null)
	{
	%>
	data_arr[<%= i%>][11] = "<%=visit.getPriority()%>"
	<%}else{
		%>
		data_arr[<%= i%>][11] = "0"
			<%}
	
	i++;
	totalPatient++;
	}
	}
	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "meWaitingList"
		
	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
<%-- 
<input type="text" class="signPriority1" readonly="readonly" >
<label class="valueAutoPriority">Priority-1</label>
<input type="text" class="signPriority2" readonly="readonly" >
<label class="valueAutoPriority">Priority-2</label>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="valueAutoPriority">Priority-3</label> 
--%>
<div class="floatRight"><label class="auto">Total : </label>
		<label	class="valueAuto"><%=totalPatient%></label>
		</div>
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">

	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;

	}
	function openTokenDisplay()
	{
	 var url="/hms/hms/opd?method=showPopupTokenJsp";
	 newwindow=window.open(url,'opentoken','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
	}
	function closeTokenDisplay(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}

	}
</script>