<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.LibBookReturnHd"%>
<%@page import="jkt.hms.masters.business.LibBookReturnDt"%>
<%@page import="jkt.hms.masters.business.LibBookIssueDetail"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
function second(formName,action,divName) {
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
         document.getElementById(divName).innerHTML = xmlHttp.responseText;
      }
    }
    var url=action+"&"+getNameAndData(formName)
     
    xmlHttp.open("GET",action,true);
    
    xmlHttp.send(null);
  }

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		List<LibBookReturnHd> bookReturnHdList = new ArrayList<LibBookReturnHd>();
		LibBookReturnHd bokReturnHd= new LibBookReturnHd();
		List<MasEmployee> receiveByList = new ArrayList<MasEmployee>();
		if(map.get("receiveByList") != null){
			receiveByList = (List<MasEmployee>)map.get("receiveByList");
		}
		if(map.get("bookReturnHdList") != null){
			bookReturnHdList = (List<LibBookReturnHd>)map.get("bookReturnHdList");
		}
		int empId=0;
		if(bookReturnHdList != null) {
			bokReturnHd = (LibBookReturnHd) bookReturnHdList.get(0);
			empId =bokReturnHd.getIssueHd().getEmployee().getId();
		}
%>
<form name="bookReturn" method="post" action="">
<div id="contentHolder">
<h6>Update Books/Journal Return Entry</h6>
<div class="Clear"></div>

<div class="blockFrame" id="testDiv">

<input id="issueHdId"	type=hidden name="<%=BOOK_ISSUE_HD_ID %>" value="<%=bokReturnHd.getIssueHd().getId() %>" title="Issue No" />

 <input id="<%=BOOK_RETURN_HD_ID %>" type=hidden name="<%=BOOK_RETURN_HD_ID %>"	value="<%=bokReturnHd.getId() %>" title="Issue No" /> 
 
 <label>Return No.</label> 
 <input id="orderNoId" type=hidden name="<%=RETURN_NO %>"	value="<%=bokReturnHd.getReturnNo() %>" title="Issue No" /> 
 <label	class="value"><%=bokReturnHd.getReturnNo() %></label> 
 
 <label>Return Date</label> 
 
 <%if(bokReturnHd.getReturnDate()!=null){ %> 
 <input type="text"	class="calDate" id="issueDateId" name="<%=RETURN_DATE %>"	value="<%=HMSUtil.convertDateToStringWithoutTime(bokReturnHd.getReturnDate()) %>"	readonly="readonly" MAXLENGTH="30" /> 
 
 <%}else{ %>
  <input type="text"	class="calDate" id="issueDateId" name="<%=RETURN_DATE %>"	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> 
  <%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.bookReturn.<%=RETURN_DATE%>,event)" />
 
 <label><span>*</span> Issue No. </label> 
 
 <%if(bokReturnHd.getIssueHd() !=null)
  { %>
<input type="text" id="issueNo" name="<%= ISSUE_NO%>"	validate="Issue No,string,yes" class="textbox_size20" maxlength="20"	tabindex=1 value="<%=bokReturnHd.getIssueHd().getIssueNo()  %>"	readonly="readonly" /> <%} %>
<input type="hidden" id="issueId"	name="<%= BOOK_ISSUE_HD_ID%>" value="" tabindex=1 />

<div class="Clear"></div>

<label>Issue Date </label> 
<input type="text" id="issueDate" name="<%= ISSUE_DATE%>" value="<%=HMSUtil.convertDateToStringWithoutTime(bokReturnHd.getIssueHd().getIssueDate()) %>"	class="textbox_size20" tabindex=1 readonly="readonly" /> 

<label>Service Number </label> 
<%if(bokReturnHd.getIssueHd().getEmployee() !=null){ %> 
<input	type="text" id="serviceNo" name="<%= SERVICE_NO%>"	value="<%=bokReturnHd.getIssueHd().getEmployee().getServiceNo() %>"	validate="Service No,string,yes" class="textbox_size20" maxlength="20"	tabindex=1 readonly="readonly" /> 
<%}else{ %> 
<input type="text"	id="serviceNo" name="<%= SERVICE_NO%>" value=""	validate="Service No,string,yes" class="textbox_size20" maxlength="20"	tabindex=1 /> 
<%} %>

<label>Name</label> <%if(bokReturnHd.getIssueHd().getEmployee() !=null){ %>
<input type="text" id="name" name="<%= NAME%>"	value="<%=bokReturnHd.getIssueHd().getEmployee() .getFirstName() %> <%=bokReturnHd.getIssueHd().getEmployee() .getLastName() %>"	readonly="readonly" /> 
<%}else{ %> 
<input type="text" id="name" name="<%= NAME%>" value="" readonly="readonly" /> <%} %> 

<div class="Clear"></div>

<label>Rank</label> <%if(bokReturnHd.getIssueHd().getEmployee().getRank() !=null){ %>
<input type="text" id="rankId" name="<%= RANK_ID%>"	value="<%=bokReturnHd.getIssueHd().getEmployee().getRank() .getRankName()  %>"	readonly="readonly" /> 
<%}else{ %>
<input type="text" id="rankId"	name="<%= RANK_ID%>" value="" readonly="readonly" />
 <%} %> 
<label><span>*</span> Received By</label> <select name="<%=RECEIVED_BY %>"	validate="Received By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
				         		if(receiveByList != null){ 	
				         			for (Iterator iter = receiveByList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<%if(bokReturnHd.getReceivedBy().getId() .equals(masEmployee.getId())){ %>
	<option value="<%=bokReturnHd.getReceivedBy().getId()%>" selected="selected"><%=bokReturnHd.getReceivedBy().getFirstName()%><%=bokReturnHd.getReceivedBy().getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getLastName()%></option>
	<%		}} } %>
</select>
<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" /></div>

<div class="Clear"></div>
<div class="division"></div>

<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Sl No.</th>
			<th scope="col">Acc. No.</th>
			<th scope="col">Name Of Book</th>
			<th scope="col">Quantity</th>
			<th scope="col">Return</th>
		</tr>
	</thead>
	<tbody>

		<%
		int inc = 1;
		List<LibBookReturnDt>bookReturnDtList=new ArrayList<LibBookReturnDt>();
		if(map.get("bookReturnDtList")!=null){
			bookReturnDtList=(List<LibBookReturnDt>)map.get("bookReturnDtList");
		}
		 if(bookReturnDtList!= null && bookReturnDtList.size()>0){
			 for(LibBookReturnDt bookReturnDt:bookReturnDtList){
				 LibBookIssueDetail libBookIssueDetail=new LibBookIssueDetail();
				 libBookIssueDetail=bookReturnDt.getIssueDt();
			 
	%>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td>
			<%if(bookReturnDt.getIssueDt().getBook()!=null){ %>
			 <input type="text"	name="<%=BOOK_NO%>" id="accountNo<%=inc %>"		value="<%=bookReturnDt.getIssueDt().getBook().getBookNo() %>" size="30" align="right" tabindex="1" readonly="readonly" /> 
			 <%}else{ %>
			 <input type="text" name="<%=BOOK_NO%>"	id="accountNo<%=inc %>" value="<%=libBookIssueDetail.getBook().getBookNo() %>" size="30" align="right" tabindex="1" readonly="readonly" /> 
			 <%} %>
			</td>
			<td>
			<%if(bookReturnDt.getIssueDt().getBook()!=null){ %> 
			
			<input type="text"	tabindex="1" align="right" name="<%=BOOK_NAME%>" size="30"	id="bookName<%=inc %>"	value="<%=bookReturnDt.getIssueDt().getBook().getBookName() %>"	readonly="readonly" />
			
			 <input type="hidden" name="<%=BOOK_ISSUE_DETAIL_ID %>"	id="bookIssueDtId<%=inc %>" 	value="<%=bookReturnDt.getIssueDt().getId() %>" /> 
			 
			 <input	type="hidden" name="<%=BOOK_RETURN_DT_ID %>" id="bookReturnDtId<%=inc %>" value="<%=bookReturnDt.getId() %>" /> 
			 <%} %>
			</td>

			<td>
			<%if(bookReturnDt.getIssueDt().getQuantity() !=null){ %> 
			<input type="text" name="<%=QUANTITY%>" id="quantity<%=inc %>" 	value="<%=bookReturnDt.getIssueDt().getQuantity() %>" size="4" align="right" tabindex="1" readonly="readonly" /> 
			<%}else{ %> 
			<input type="text" name="<%=QUANTITY%>" id="quantity<%=inc %>"	value="<%=libBookIssueDetail.getQuantity() %>" size="4" align="right" tabindex="1" readonly="readonly" /> <%} %>
			</td>
			<td>
			<%if(bookReturnDt.getBookReturn().equals("y")){ %> 
			<input id="return<%=inc%>" name="<%=RETURN%>" type="checkbox" class="check" value="y" checked="checked" />
			<%}else{%> 
			<input id="return<%=inc%>" name="<%=RETURN%>" type="checkbox" value="n" class="check" /> 
			<%} %>
			
			<input	type="hidden" name="returnId" id="returnId" /></td>
		</tr>
		<% inc++;  } } %>
		<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"	id="hiddenValueCharge" />
	</tbody>
</table>
</div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="cmnButton" value="Update" onclick="submitForm('bookReturn','lib?method=updateBookReturn');" align="right" /> 
	<input type="reset" class="cmnButton" name="Reset" id="reset" value="Reset" onclick="resetClicked('bookReturn');" accesskey="r" />
<div class="division"></div>

<label>Changed By</label>
 <label class="value"><%=userName%></label> 
<label>Changed Date</label>
 <label class="value"><%=currentDate%></label> 
 <label>Changed Time</label> 
 <label class="value"><%=time%></label> 
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
<input type="hidden" name="counter"></div>
</div>

</form>

<script type="text/javascript">
function validateReturn(){
var msg="";
var count=document.getElementsByName('return').length;
		 for(var i = 0; i < document.getElementsByName('return').length; i++){
		 
			  if(document.getElementsByName('return')[i].checked == true )
              { 
				count=count-1
			}		
  		}
  		 if(count == document.getElementsByName('return').length )
              { 
				
				alert("Please Return atleast one Book....")
				return false;
			}	
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
</script>
