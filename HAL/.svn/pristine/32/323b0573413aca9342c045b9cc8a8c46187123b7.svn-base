<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.LibBookIssueHeader"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

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
	int pageNo=1;
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
		List<LibBookIssueHeader> issueHdList = new ArrayList<LibBookIssueHeader>();
		List<MasEmployee> receiveByList = new ArrayList<MasEmployee>();
		if(map.get("receiveByList") != null){
			receiveByList = (List<MasEmployee>)map.get("receiveByList");
		}
		if(map.get("issueHdList") != null){
			issueHdList = (List<LibBookIssueHeader>)map.get("issueHdList");
		}

		String returnSeqNo="";
		if(map.get("returnSeqNo") != null){
			returnSeqNo = (String)map.get("returnSeqNo");
		}
%>
<form name="bookReturn" method="post" action="">
<div id="contentHolder">
<h6>Books/Journal Return Entry</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv">
<label>Return No.</label>
<input id="orderNoId" type=hidden name="<%=RETURN_NO %>" value="<%=returnSeqNo%>" title="Issue No" />
<label class="value"><%=returnSeqNo %></label>

<label> Return Date</label>
<input type="text" class="calDate" id="issueDateId" name="<%=RETURN_DATE %>" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.bookReturn.<%=RETURN_DATE%>,event)" />

<label><span>*</span> Issue No. </label>
<input type="text" id="issueNo" name="<%= ISSUE_NO%>" value="" validate="Issue No,string,yes" class="textbox_size20" maxlength="20" tabindex=1	onblur="ajaxFunctionForIssueNo(bookReturn);" />
<input type="hidden" id="issueId" name="<%= BOOK_ISSUE_HD_ID%>" value="" tabindex=1 />

<div class="Clear"></div>

<label>Issue Date </label> <input type="text" id="issueDate" name="<%= ISSUE_DATE%>" value="" class="textbox_size20" tabindex=1 readonly="readonly"/>
<label>Service Number </label> <input type="text" id="serviceNo" name="<%= SERVICE_NO%>" value="" validate="Service No,string,yes" class="textbox_size20" readonly="readonly" maxlength="20" tabindex=1 />

<label>Name</label> <input type="text" id="name" name="<%= NAME%>" value="" readonly="readonly" />
<div class="Clear"></div>

<label>Rank</label> <input type="text" id="rankId" name="<%= RANK_ID%>" value="" readonly="readonly" />

<label><span>*</span> Received By</label> <select name="<%=RECEIVED_BY %>" validate="Received By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			  if(receiveByList != null){
				for (MasEmployee  masEmployee : receiveByList){
				%>
	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()%><%=masEmployee.getMiddleName()%><%=masEmployee.getLastName()%></option>

	<%}
}%>
</select>
<div class="Clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" /></div>

<div class="Clear"></div>

<div id="abcd"></div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Add" onclick="submitForm('bookReturn','lib?method=submitBookReturn');" align="right" />
<input type="reset" class="button" name="Reset" id="reset" value="Reset" onclick="resetClicked('bookReturn');"	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate %>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

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
