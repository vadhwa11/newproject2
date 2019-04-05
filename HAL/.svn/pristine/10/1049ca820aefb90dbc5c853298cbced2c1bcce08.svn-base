<%@page import="jkt.hms.masters.business.MasQaOptionValue"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdQaMaster"%>
<%@page import="jkt.hms.masters.business.OpdQaTransation"%>
<%@page import="jkt.hms.masters.business.MasQuestionHeading"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script>
	 var icdArray=new Array();</script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<OpdQaMaster> questionnaireList=new ArrayList<OpdQaMaster>();
				List<List<OpdQaTransation>> questionnaireTransactionList = new ArrayList<List<OpdQaTransation>>();
				List<MasQuestionHeading > quesHeadingList = null;
				//System.out.println("dd"+questionnaireList.size());
				String message = "";
				int visitId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("questionnaireTransactionList")!= null){
					questionnaireTransactionList = (List<List<OpdQaTransation>>)map.get("questionnaireTransactionList");
					System.out.println("size ="+questionnaireTransactionList.size());
				}
				
				if(map.get("questionnaireList")!= null){
					questionnaireList = (List<OpdQaMaster>)map.get("questionnaireList");
				}
				

				if(map.get("quesHeadingList")!= null){
					quesHeadingList = (List<MasQuestionHeading>)map.get("quesHeadingList");
				}
				if(request.getParameter("visitId")!=null){
					visitId=Integer.parseInt((String)request.getParameter("visitId"));
				}else if(map.get("visitId")!= null){
					visitId = (Integer)map.get("visitId");
				}
//System.out.println("ff"+questionnaireTransactionList.size());
		%>
			<%	
			MasQuestionHeading  quesHeading1 = new MasQuestionHeading();
			     for (int i = 0; i < quesHeadingList.size(); i++) {
			    	 quesHeading1 =  quesHeadingList.get(i);
     			 %> <script>
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=quesHeading1.getId()%>";
	          icdArray[<%=i%>][1] = "<%=quesHeading1.getQuestionHeadingName()%>";
            </script> <% }%>

<form name="submitQuestionnaire" method="post" action="">

<input type="hidden" value="<%=visitId%>" id="visitId" name="visitId">
<div class="titleBg"> <h2>Psychiatrist Questionnaire</h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<div class="Block">
<%if(questionnaireTransactionList.size()>0){
int i=0;
int total=0;
%>
<h4>Patient Questionnaire List</h4>
<div class="clear"></div>
<div id="divTemplet" style="width: 700px;">
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<%for(List<OpdQaTransation> qaTransactionList:questionnaireTransactionList) {i=1;total=0;%>
<tr><th>Question heading</th><td colspan="3"><%=qaTransactionList.get(0).getQuestion().getQuestionHeading().getQuestionHeadingName()%></td></tr>
<tr><th>S.No</th><th>Question</th><th>Answer</th><th>Score</th></tr>
  <%for(OpdQaTransation qaTransaction:qaTransactionList) {%>
<tr><td><%=i++%></td><td><%=qaTransaction.getQuestion().getQuestion()%></td><td><%=qaTransaction.getAnswerOption().getQaOptionValueName()%></td><td style="text-align: right; padding-right: 7px;"><%=qaTransaction.getAnswerOption().getOptionSNo()%></td></tr>
  <%total=total+qaTransaction.getAnswerOption().getOptionSNo(); } %>
<tr><td><h4>Total</h4></td><td colspan="3" style="text-align: right;padding-right: 7px;"><b><%=total%></b></td></tr>
<%} %>
</table>
</div>
<%} %>
<div class="cmntable">
<h4>Questionnaire</h4>
<table border="0"  name="headingGrid" id="headingGrid">
<tr>
<td><label>Question Heading <span>*</span></label></td>

	<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" validate="Department,number,no"> --%>
<%-- <select id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" validate="Department,number,no" > --%>
		<td><select id="headingId1" name="headingId1" validate="Question Heading 1 ,num,yes" 
					onchange="fnGetPsyQuestionByHeading(this.value,'questionTable1',visitId.value, headingInc.value );">
			<option value="0">Select</option>
			<%
				int deptId=(Integer)session.getAttribute("deptId");
				
				for ( MasQuestionHeading quesHeading : quesHeadingList) {
			%>
	
							<option value="<%=quesHeading.getId()%>" ><%=quesHeading.getQuestionHeadingName()%></option>
		
			<%}
				
			%>
		</select>
		</td>
		<td> <input name="Button" type="button" class="buttonAdd"
						value="" onclick="addHeadingRow();" tabindex="1" /></td>
		<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('headingGrid','headingInc',this);" /></td>						
		</tr>
		<tr><td colspan="4"><table border="0" align="center"  style="width:85%;" cellpadding="0" cellspacing="0" id="questionTable1">
			</table>
	    </td>
	    </tr>
	</table>	
	</div>
	<input type="hidden" value="1" id="headingInc" name="headingInc">
	<div class="clear"></div>	
<!-- <input name="add" type="button" class="button" value="Close" onClick="window.close();"/> -->
<div class="clear"></div>
<div class="division"></div>



</div>
<div class="clear"></div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
      
      
<input name="add" type="button" class="button" value="Submit" onClick="jsImport();"/><input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
       </form>

<script language="javascript">

function jsImport()
{
	var visitId= document.getElementById("visitId").value;

	var selectedHeadingId = [];
	var results = [];
    var headingInc =  document.getElementById("headingInc").value
	for (var i = 1; i <= headingInc; i++)
		{
		 if(document.getElementById("headingId"+i)!=null && document.getElementById("headingId"+i).value)
			 {
			  
			  for (var j = 0; j < selectedHeadingId.length; j++) {
				    if (selectedHeadingId[j] == document.getElementById("headingId"+i).value) {
				  alert("Question Heading can not be repeated.");
				  return false;
				    }
				} 
			  if(document.getElementById("headingId"+i).value!="0")
			  selectedHeadingId.push(document.getElementById("headingId"+i).value);
			 }
		}

	
	document.submitQuestionnaire.method="post";
	submitForm('submitQuestionnaire','opd?method=submitPhychiatristAnswer&visitId='+visitId);
	//window.close();
}

function addHeadingRow()
{
	 var tbl = document.getElementById('headingGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('headingInc');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Label');
	  e1.type = 'label';
	  e1.innerHTML = "Question Heading<span>*</span>";
	  cellRight1.appendChild(e1);
  
	  var cellRight5 = row.insertCell(1);
	  var e2 = document.createElement('Select');
	  e2.name='headingId'+iteration;
	  e2.id='headingId'+iteration;
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.setAttribute('validate','Question Heading '+iteration+ ',num,yes');
	  e2.options[0] = new Option('Select', '0');
	  e2.onchange=function(){fnGetPsyQuestionByHeading(this.value,'questionTable'+iteration,document.getElementById('visitId').value,  document.getElementById('headingInc').value);};
	    for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      } 
	  cellRight5.appendChild(e2);
	  
	  var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.value = "";
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  e4.onclick = function(){addHeadingRow();}; 
	  cellRight2.appendChild(e4);
	  
	  var cellRight13 = row.insertCell(3);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.value = "";
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("headingGrid","headingInc",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);
	  
	/*   var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('table');
	  e3.name='questionTable'+iteration;
	  e3.id='questionTable'+iteration;
	  //e2.class = 'medium';
	  e3.setAttribute('tabindex','1');
	  cellRight3.appendChild(e3); */
	  
	  
	  
	   row = tbl.insertRow(lastRow+1);
	   var cellRight3 = row.insertCell(0);
		  var e3 = document.createElement('table');
		  e3.name='questionTable'+iteration;
		  e3.id='questionTable'+iteration;
		  //e2.class = 'medium';
		 // e3.setAttribute('tabindex','1');
		  cellRight3.setAttribute('colspan', '4');
		//  e3.colSpan = 3;
		  cellRight3.appendChild(e3);
		
}
function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 3){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i+1);
    tbl.deleteRow(i);
  }
}
</script>

