<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>


<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	System.out.println("box inside jsp" + box);
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;
	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
		 System.out.println("pageno in jsp " + pageno);
	}
	
	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}
	
	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}

	List<MasEmployee> employeeDetailList = new ArrayList<MasEmployee>();
	List<HrDutyTimeMaster>dutyTimeMasterList=new ArrayList<HrDutyTimeMaster>();
	List<HrGuardDutyEntry>dutyEntryList=new ArrayList<HrGuardDutyEntry>();
	List<HrLeaveMaintenance>employeeLeaveList=new ArrayList<HrLeaveMaintenance>();
	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();	
	List<ProposalForHroEntry> pendingList = new ArrayList<ProposalForHroEntry>();

	if (map.get("employeeDetailList")!=null)
	{
		employeeDetailList = (List)map.get("employeeDetailList");
	}
	if (map.get("dutyTimeMasterList")!=null)
	{
		dutyTimeMasterList = (List)map.get("dutyTimeMasterList");
	}
	if (map.get("dutyEntryList")!=null)
	{
		dutyEntryList = (List)map.get("dutyEntryList");
	}
	if (map.get("employeeLeaveList")!=null)
	{
		employeeLeaveList = (List)map.get("employeeLeaveList");
	}
	if (map.get("holidayList")!=null)
	{
		holidayList = (List)map.get("holidayList");
	}
	if (map.get("pendingList")!=null)
	{
		pendingList = (List)map.get("pendingList");
	}

%>

<title>Pending Proposal List</title>

<script>

function swapApplication(){
			
			 for(var i = 0; i < document.getElementsByName('appIdToSwap').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				var temp = document.getElementsByName('appIdToSwap')[i].value;
				document.getElementsByName('appIdToSwap')[i].value = document.getElementsByName('appIdToSwap')[i-1].value;
				document.getElementsByName('appIdToSwap')[i-1].value = temp;

				var temp = document.getElementsByName('appName')[i].value;
				document.getElementsByName('appName')[i].value = document.getElementsByName('appName')[i-1].value;
				document.getElementsByName('appName')[i-1].value = temp;
				
				document.getElementsByName('appId')[i-1].checked = true;
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}


function checkForNextDutyDate()
{
	var msg="";
			 for(var i = 0; i < document.getElementsByName('pendingListAdded').length; i++){
			  if(document.getElementsByName('pendingListAdded')[i].checked == true )
              { 
              	var dutyFrom=document.getElementsByName('nextDutyDate')[i].value;
				if(dutyFrom!="")
				{
					currentDate = new Date();
					var month = currentDate.getMonth() + 1
					var day = currentDate.getDate()
					var year = currentDate.getFullYear()
					var seperator = "/"
					currentDate = new Date(month + seperator + day + seperator + year);
					dutyFrom = new Date(dutyFrom.substring(6),(dutyFrom.substring(3,5) - 1) ,dutyFrom.substring(0,2));
					
					if(currentDate > dutyFrom)
					{	
						msg += "Next Duty Date should be greater than current date in row "+eval(i+1)+".\n"
						document.getElementsByName('nextDutyDate')[i].value="";
					}
			
				}
				else
				{
					msg += "Please Enter Next Duty Date in row "+eval(i+1)+".\n"
				}
            }
           }  
              
       if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;        
   }           
//this function will be called by the Bean (not from JSP)
function GoPage() {	
	var pgno = parseInt(guardDutyAddForm.gopage.value);
	var totalPages = parseInt(guardDutyAddForm.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}  
	guardDutyAddForm.pageno.value = pgno; 
	guardDutyAddForm.method="post";
	submitForm('guardDutyAddForm','hrRelated?method=getGridDataForGuardEmployeeAdd');
}

function goNext()
{
 var pgno = parseInt(guardDutyAddForm.pageno.value)+1;
 
 if (pgno > guardDutyAddForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 guardDutyAddForm.pageno.value = pgno;
 guardDutyAddForm.method="post";
 submitForm('guardDutyAddForm','hrRelated?method=getGridDataForGuardEmployeeAdd');
}

function validateButton()
{
	if (pendingList.<%=PENDING_LIST_ADDED%>.length)
	{
			 for(var i = 0; i < pendingList.<%=PENDING_LIST_ADDED%>.length; i++)
			 {
			  if (pendingList.<%=PENDING_LIST_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (pendingList.<%=PENDING_LIST_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
		if (validateButton())
		{
			pendingList.method="post";
			{
				submitForm('pendingList','hrOrderly?method=updateProposalForHro');
				
			}
		}
		else
		alert('Pl. select Employee to add!......'); 
}

			            
	function jsClose()
	{
	  window.opener.location.href = "hrOrderly?method=showGuardDutyEntryJsp";
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	  window.close();
	}
    function getLastDutyDetails(empData)
    {
    	guardDutyAddForm.method="post";
 		submitForm('guardDutyAddForm','hrRelated?method=getGuardEmployeeLastDutyDetails&empData='+empData);
    }

function moveRowup(slno){
		    	var i=slno
			
			  if(slno>0)
              {
				var temp = document.getElementsByName('departmentName')[i].value;
				document.getElementsByName('departmentName')[i].value = document.getElementsByName('departmentName')[i-1].value;
				document.getElementsByName('departmentName')[i-1].value = temp;

				var temp = document.getElementsByName('date')[i].value;
				document.getElementsByName('date')[i].value = document.getElementsByName('date')[i-1].value;
				document.getElementsByName('date')[i-1].value = temp;

                var temp = document.getElementsByName('subject')[i].value;
				document.getElementsByName('subject')[i].value = document.getElementsByName('subject')[i-1].value;
				document.getElementsByName('subject')[i-1].value = temp;

                var temp = document.getElementsByName('pendingListAdded')[i].value;
				document.getElementsByName('pendingListAdded')[i].value = document.getElementsByName('pendingListAdded')[i-1].value;
				document.getElementsByName('pendingListAdded')[i-1].value = temp;
 
				var temp = document.getElementsByName('proposalId')[i].value;
				document.getElementsByName('proposalId')[i].value = document.getElementsByName('proposalId')[i-1].value;
				document.getElementsByName('proposalId')[i-1].value = temp;
				
				
				return true;
			  }		
  		
		return false;
		
	}
function showHro(slno){
			  var i=slno
			  var temp = document.getElementsByName('proposalId')[i].value;
              window.open('hrOrderly?method=showUpdateProposalJsp&proposalId='+temp);   
              

}	


</script>

<% 
String message="";
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
%>
<DIV class="Clear"></DIV>
<div id="contentHolder">
<%if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>	
<h6>Pending Proposal For HRO Entry</h6>
<DIV class="Clear"></DIV>
	<form name="pendingList">
		
		<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
		<input type="hidden" name="changedBy"  value="<%=userName%>" />
		<input type="hidden" name="changedDate"  value="<%=date%>" />
		<input type="hidden" name="changedTime"  value="<%=time%>" />
		<input type="hidden" name="pageno" value=<%=pageno%> />
		<input type="hidden" name="totalPages" value=<%=totalPages%> />
		<input type="hidden" name="totalRecords" value=<%=totalRecords%> />
		<input type="hidden" name="numOfRows" value="10" />
		
		<%		
		if (pendingList == null || pendingList.size() == 0) {
		%>
			
<div class="blockTitle">Pending Proposal List </div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
			<table align="center" width="100%" colspan="7"   cellpadding="0" cellspacing="0">
				<thead>
			    	<tr>
				      <th width="10%">From Department</th>
				      <th width="30%">Date</th>
				      <th width="10%">Subject</th>
					</tr>
				</thead>
				<tbody>
				<tr>
				    <td colspan=8 align="center"> No Items Found </td>
				</tr>
				</tbody>
		     </table>
				</div>
		
		  <%  } else { %>
			 
		<div class="blockTitle">Proposal Pending List</div><div class="blockTitleCurve"></div>
		<div class="Clear"></div>
	 
			<div class="tableHolderAuto">
			<table align="center" width="100%" colspan="7"   cellpadding="0" cellspacing="0">
			<thead>
				    <tr>
				      <th>From Department</th>
				      <th>Date</th>
				      <th>Subject</th> 
				      <th>Placed in Order</th>
				      <th>View</th>
				      <th>ADD</th>
				    </tr>
				 </thead>
				<tbody id="tbodyid">
			  <%
			    int slno = 0;
			    for(ProposalForHroEntry proposal :pendingList){ 
			    	
			    %>
			    <tr>
			        <td><input type="text" value="<%=proposal.getDepartmentName()%>"  name="departmentName" readonly="readonly" /></td>
						<td><input type="text"  name="date" value="<%=proposal.getPropsalDate() %>" readonly="readonly" /></td>
					<td><input type="text" value="<%=proposal.getSubject()%>"  name="subject" readonly="readonly" /></td>
					<td><INPUT  type="button" value="move row up"  onClick="moveRowup(<%=slno %>);" /></td>
					<%System.out.println("slno::"+slno); %>
					<td><input type="button" value="View" class="button" onClick="showHro('<%=slno %>');" /></td>
					<td><input type="checkbox" name="pendingListAdded"  value="<%=proposal.getId()%>" /> </td>
					<td><input type="hidden" value="<%=proposal.getId()%>"  name="proposalId" id="proposalId<%=slno %>" /></td>
		      	</tr>
				<%slno=slno+1; }%>
				</tbody>
		     </table>
			</div> 
			<% } %>
		   		
		<div class="Clear"></div>
		<div id="pagination">
		<% if (totalPages > 0 ) { %>
		Page <span class="selected"><%=pageno %></span> of <span class="selected"><%=totalPages %></span>
		<a href="javascript:goPrevious()">Prev</a>
		<a href="javascript:goNext()">Next</a>
		<input type="button" name="Go Page" type="submit" class="button"  value="Go Page" onclick="javascript:GoPage();">
		<input type="text" name="gopage" size="3" />
		<% } %> 
		</div>
			
		<div class="division"></div>
		<div class="bottom">
		<%	
		if (pendingList != null && pendingList.size() > 0) {
		%>
	    <input type="button" name="Add" onClick="jsAdd()" value="Add" class="button"  />
	    <%} %>
		<input type="button" name="Close" onClick="jsClose()" value="Close" class="button"  />
		<div class="division"></div>
		<label>Changed By</label>
		<label class="value"><%=userName %></label>

		<label>Changed Date</label>
		<label class="value"><%=date %></label>

		<label>Changed Time</label>
		<label class="value"><%=time %></label>
		<div class="Clear"></div>
		</div>
		
</form>
</div>
		
			
			
			