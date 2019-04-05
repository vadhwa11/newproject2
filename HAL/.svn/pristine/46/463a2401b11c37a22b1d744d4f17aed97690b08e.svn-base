<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BudgetExpenseEntryDetail"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

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

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	String majorCodeHead = null;
	String codeHead = null;
	if(map.get("majorCodeHead") != null){
		majorCodeHead = (String)map.get("majorCodeHead");
	}
	if(map.get("codeHead") != null){
		codeHead = (String)map.get("codeHead");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}

	List<BudgetExpenseEntryDetail> budgetExpenseEntryDetailList= new ArrayList<BudgetExpenseEntryDetail>();
	if(map.get("budgetExpenseEntryDetailList") != null){
		budgetExpenseEntryDetailList=(List)map.get("budgetExpenseEntryDetailList");
	}
	%>
<!--main content placeholder starts here-->
<form name="budgetAndExpenseEntry" action="" method="post">
<input type="hidden" name="userName" value="<%=userName %>" /> 
<div class="titleBg"><h2>Budget and Expense Entry </h2></div>
<div class="clear"></div>


<div class="clear"></div>

<%if(budgetExpenseEntryDetailList.size() > 0){
	BudgetExpenseEntryDetail budgetExpenseEntryDetail = budgetExpenseEntryDetailList.get(0);
	int idHeader=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getId();
%>
<input type="hidden"  id="idHeader" value="<%=idHeader %>" name="idHeader" />
<label>Budget for year</label> 
<input type="text"  id="" tabindex="1" value="<%=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getBudgetForYear() %>"	name="budgetForYear" maxlength="100" readonly="readonly" />

<label>Major Code Head</label> 
<input type="text" id="majorCodeHead" value="<%=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getMajorCodeHead() %>" name="majorCodeHead" maxlength="100" validate="Major Code Head,string,yes" />
<div class="clear"></div>

<label>Code Head</label>
<input type="text" id="codeHead"  value="<%=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getCodeHead() %>" name="codeHead" maxlength="100" validate="Code Head,string,yes" onchange="search()"/>

<label>Budget Details</label>
<input type="text"  value="<%=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getBudgetDetails() %>" name="budgetDetails" maxlength="100" validate="Budget Details,string,no"/>

<label>Allotted Amount</label>
<input type="text"  value="<%=budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getAllottedAmount() %>" name="allottedAmount" id="allottedAmount" maxlength="100" validate="Allotted Amount,num,no" onchange="allottedAmountMethod()"/>

<%}else{ %>
<label>Budget for year</label> 
<input type="text"  id="" tabindex="1" value="2011"	name="budgetForYear" maxlength="100" readonly="readonly" />

<label>Major Code Head</label> 
<%if(majorCodeHead!=null){ %>
<input type="text" id="majorCodeHead" value="<%=majorCodeHead %>" name="majorCodeHead" maxlength="100" validate="Major Code Head,string,yes" />
<%}else{ %>
<input type="text" id="majorCodeHead" value="" name="majorCodeHead" maxlength="100" validate="Major Code Head,string,yes" />
<%} %>
<div class="clear"></div>

<label>Code Head</label>
<%if(codeHead!=null){ %>
<input type="text" id="codeHead"   value="<%=codeHead %>" name="codeHead" maxlength="100" validate="Code Head,string,yes" onchange="search()"/>
<%}else{ %>
<input type="text" id="codeHead"   value="" name="codeHead" maxlength="100" validate="Code Head,string,yes" onchange="search()"/>
<%} %>
<label>Budget Details</label>
<input type="text" id=""  name="budgetDetails" maxlength="100" validate="Budget Details,string,no"/>

<label>Allotted Amount</label>
<input type="text" id="allottedAmount"  name="allottedAmount" maxlength="100" validate="Allotted Amount,num,no" onchange="allottedAmountMethod()"/>
<%}%>
<div class="clear"></div>


<h4>Expense Details</h4>
<div class="clear"></div>
<div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="expenseGrid">
	<tr>
		<th scope="col">Date</th>
		<th scope="col">Amount Allotted</th>
		<th scope="col">Expended Amount</th>
		<th scope="col">Balance</th>
		<th scope="col">Remarks</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	<tr>
	<% 
	 if(budgetExpenseEntryDetailList.size()>0)
	 	{
  	Iterator itr= budgetExpenseEntryDetailList.iterator();
  	int inc=1;
  	while(itr.hasNext())
  	{		
  		BudgetExpenseEntryDetail budgetExpenseEntryDetail = (BudgetExpenseEntryDetail)itr.next();
  		int idDetail= budgetExpenseEntryDetail.getId();
  		int idHeader= budgetExpenseEntryDetail.getBudgetExpenseEntryHeader().getId();
  	%>


		<td>
		
		<input type="hidden"  id="idDetail<%=inc %>" value="<%=idDetail%>" name="idDetail<%=inc %>" /> 
		<input type="hidden"  id="idHeader<%=inc %>" value="<%=idHeader%>" name="idHeader<%=inc %>" /> 
		<input type="text"	id="detailDate<%=inc %>" name="detailDate<%=inc %>" tabindex="1" value="<%=HMSUtil.changeDateToddMMyyyy(budgetExpenseEntryDetail.getDetailDate())%>"	readonly="readonly" validate="Date,date,no" MAXLENGTH="30"	class="calDate"  /> 
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.budgetAndExpenseEntry.detailDate<%=inc %>,event)" /> 

		</td>
		
		<td>
		 
		<input type="text"  validate="Amount Allotted,num,no" tabindex="1" value="<%=budgetExpenseEntryDetail.getAmountAllotted()%>" id="amountAllotted<%=inc %>"  name="amountAllotted<%=inc %>" onblur="calcuaterBalance(<%=inc %>);"/>
		</td>
		
		<td>
		 
		<input type="text"  validate="Expended Amount,num,no" tabindex="1" id="expendedAmount<%=inc %>" value="<%=budgetExpenseEntryDetail.getExpendedAmount() %>" name="expendedAmount<%=inc %>" onblur="calcuaterBalance(<%=inc%>);"/>
		</td>
		
		<td>
		 
		<input type="text"  validate="Balance,num,no"  tabindex="1" readonly="readonly" id="balance<%=inc %>" value="<%=budgetExpenseEntryDetail.getBalance() %>" name="balance<%=inc %>" onblur="calcuaterBalance(<%=inc%>);"/>
		</td>
		
		<td><input type="text"  validate="Remarks,string,no"  tabindex="1" id="remarks<%=inc %>"  value="<%=budgetExpenseEntryDetail.getRemarks() %>" name="remarks<%=inc %>"/>
		</td>
		
		<td><input name="Button" type="button" class="buttonAdd" 	onclick="addRowForExpense();allottedAmountMethod();"/></td>
		<td><input type="button" name="delete"  class="buttonDel"  onclick="removeRowForExpense();" /></td>


	</tr>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
	<%
	inc++;
  	}
  	
	 	
	 	}else{	
	 		int inc=1;	
	 		%>
			
		<td>
		 
	<input type="text"	id="detailDate<%=inc %>" name="detailDate<%=inc %>" tabindex="1" value=""	readonly="readonly" validate="Date,date,no" MAXLENGTH="30"	class="calDate"  /> 
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('',document.budgetAndExpenseEntry.detailDate<%=inc %>,event)" /> 

		</td>
		
		<td>
		 
		<input type="text" value="" validate="Amount Allotted,num,no" tabindex="1" id="amountAllotted<%=inc %>"  name="amountAllotted<%=inc %>" onblur="calcuaterBalance(<%=inc %>);"/>
		</td>
		
		<td>
		 
		<input type="text" value="" validate="Expended Amount,num,no" tabindex="1" id="expendedAmount<%=inc %>"  name="expendedAmount<%=inc %>" onblur="calcuaterBalance(<%=inc%>);"/>
		</td>
		
		<td>
		 
		<input type="text" value="" validate="Balance,num,no"  tabindex="1" readonly="readonly" id="balance<%=inc %>" name="balance<%=inc %>" onblur="calcuaterBalance(<%=inc%>);"/>
		</td>
		
		<td><input type="text" value="" validate="Remarks,string,no"  tabindex="1" id="remarks<%=inc %>"  name="remarks<%=inc %>"/>
		</td>
		
		<td><input name="Button" type="button" class="buttonAdd" value=""	onclick="addRowForExpense();allottedAmountMethod();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"  onclick="removeRowForExpense();" /></td>


	</tr>

	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />

	<%} %>

	
</table>

</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<% 
	 if(budgetExpenseEntryDetailList.size()>0)
	 	{%>
<input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Update" onclick="updateBudgetAndExpenseEntry();" />
 <%}else{%>
 <input name="Submit" type="button"	tabindex="1" align="right" class="button" value="Submit" onclick="submitBudgetAndExpenseEntry();" />
<%} %>
 
<input name="Reset" type="reset" tabindex="1" align="right"	class="button" value="Reset" onclick="resetdata()" />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<!--main content placeholder ends here--> 
<script type="text/javascript">
function updateBudgetAndExpenseEntry(){

				submitForm('budgetAndExpenseEntry','fwc?method=updateBudgetAndExpenseEntry');

}
function submitBudgetAndExpenseEntry(){

	submitForm('budgetAndExpenseEntry','fwc?method=submitBudgetAndExpenseEntry');

}
function resetdata()
{
   
    document.budgetAndExpenseEntry.action="/hms/hms/fwc?method=showUpdateBudgetAndExpenseEntryJsp";
    document.budgetAndExpenseEntry.submit();
   
}
function addRowForExpense(){
      
	  var tbl = document.getElementById('expenseGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration

	//  var idValue=document.getElementById('idDetail'+iteration).value;

	

		  
	  var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'text';
		e0.readOnly = true;
		e0.name='detailDate'+ iteration;
		e0.id='detailDate'+iteration;

		var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.class = 'calender';
		eImg.id = 'calendar'+iteration;
		eImg.onclick = function(event){
						setdate('',document.getElementById('detailDate'+iteration),event) };

						  var ehide = document.createElement('input');
						  ehide.type = 'hidden';
						  ehide.name='idDetail';
						  ehide.id='idDetail'+iteration
						 		
		cellRight0.appendChild(e0);
		cellRight0.appendChild(eImg);
		cellRight0.appendChild(ehide);

	  var cellRight2 = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='amountAllotted'+iteration;
	  sel.id='amountAllotted'+iteration
	  sel.onblur=function(){

		  calcuaterBalance(iteration);

		  };
	  sel.setAttribute('tabindex','1');
	  cellRight2.appendChild(sel);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='expendedAmount'+iteration;
	  e2.id='expendedAmount'+iteration
	  e2.onblur=function(){

		  calcuaterBalance(iteration);

		  };
	  e2.setAttribute('tabindex','1');
	  cellRight3.appendChild(e2);

	  var cellRight4 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.readOnly = true;
	  e5.name='balance'+iteration;
	  e5.id='balance'+iteration
	  e5.setAttribute('tabindex','1');
	  cellRight4.appendChild(e5);

	  var cellRight5 = row.insertCell(4);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='remarks'+iteration;
	  e6.id='remarks'+iteration
	  e6.setAttribute('tabindex','1');
	  cellRight5.appendChild(e6);
	  
	 var cellRight6 = row.insertCell(5);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForExpense();allottedAmountMethod();');
	  cellRight6.appendChild(e3);

	  var cellRight7 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForExpense();');
	  cellRight7.appendChild(e4);
	  
	}

function removeRowForExpense()
{
  var tbl = document.getElementById('expenseGrid');
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  	tbl.deleteRow(lastRow - 1);
  	var tbl = document.getElementById('expenseGrid');
  	var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
 	var iteration = lastRow - 1;
  	var hdb = document.getElementById('hiddenValue');
  	hdb.value=iteration

  }
}

function calcuaterBalance(inc)
{
	var bal;
	
	for(i=1;i<=inc;i++){

	var e=document.getElementById('expendedAmount'+inc).value;
	var a=document.getElementById('amountAllotted'+inc).value;
	if(inc!=0){
				bal=a-e;
				document.getElementById('balance'+inc).value=bal;
				bal=document.getElementById('balance'+(inc-1)).value;
				if(inc>1)
					{
					e=document.getElementById('expendedAmount'+inc).value;
					bal=bal-e;
					document.getElementById('balance'+inc).value=bal;
					}
				return true;
				}			
		}
}
function allottedAmountMethod()
{
	var allottedAmount = document.getElementById('allottedAmount').value;;
	var hdb = document.getElementById('hiddenValue').value;
	for(i=1;i<=hdb;i++){
	if(allottedAmount!=0){
				
				document.getElementById('amountAllotted'+hdb).value=allottedAmount;
				return true;
			}		
		
	}
}

function search()
{

	var majorCodeHead=document.getElementById('majorCodeHead').value;
	var codeHead=document.getElementById('codeHead').value;

	submitForm('budgetAndExpenseEntry','fwc?method=searchBudgetAndExpenseEntry&majorCodeHead='+majorCodeHead+'&codeHead='+codeHead);
	
	//var url="/hms/hms/fwc?method=searchBudgetAndExpenseEntry&majorCodeHead="+majorCodeHead+"&codeHead="+codeHead;
	//newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
    
}

</script>
</form>