
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

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
	String Labresult="NotPresent";
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	if(map.get("patientInvestigationHeader")!=null){
		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	}
	List<PatientInvestigationDetails> patientInvestigationdetails=null;
	if(map.get("patientInvestigationDetailsList")!=null){
		patientInvestigationdetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetailsList");
	}
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
	}
	DgOrderhd dgOrderhd=null;
	if(map.get("dgOrderhd")!=null){
		dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	}
	List<DgOrderdt> getDgOrderdts=null;
	if(map.get("dgOrderdtList")!=null)
	{
		getDgOrderdts=(List<DgOrderdt>)map.get("dgOrderdtList");
	}
	int famPlanId = 0;
	if(map.get("famPlanId")!=null){
		famPlanId = (Integer)map.get("famPlanId");
	}
	String empName = "";
	if(session.getAttribute("empName")!=null){
		empName= (String)session.getAttribute("empName");
	}
%>
<!--main content placeholder starts here-->
<form name="issueCertificate" action="" method="post">
<input type="hidden" name="famPlanId" value="<%=famPlanId %>"/>
<div class="titleBg">
<h2>Sterilization Certificate</h2>
</div>

<div class="clear"></div>
<h4>INVESTIGATION</h4>

<table border="0" align="center" cellpadding="0" cellspacing="0" >

<tr>
<TH scope="col" class="large">Investigation</TH>
<TH scope="col">Refer to MH</TH>
<th scope="col">Result</th>
<th scope="col">Upload/ View</th>
<!--<TH scope="col">Add</TH>
<TH scope="col">Delete</TH>
--></tr>

	<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	<input type="hidden" name="Investigated" tabindex="2" value="yes" />
	<% }else{%>
	<input type="hidden" name="Investigated" tabindex="2" value="No" />
	<%  }

if(patientInvestigationHeader.getId()!=null)
{
%>
	<input type="hidden" value="<%=patientInvestigationHeader.getId() %>"
		name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
	<%
}else{%>
	<input type="hidden" name="patientInvestigationHeaderId"
		id="patientInvestigationHeaderId" />
	<% }
if(dgOrderhd!=null)
{
%>
	<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId"
		id="dgOrderhdId" />
	<%
}else{%>
	<input type="hidden" name="dgOrderhdId" id="dgOrderhdId" />
	<% }

String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0)
{
	HashMap second = new HashMap();
	   List<String> firstKeyList=new ArrayList<String>();
	   List<Integer> firstValueList=new ArrayList<Integer>();
	   List<Integer> secondKeyList=new ArrayList<Integer>();
	   List<String> secondValueList=new ArrayList<String>();
	   List<String> thirdKeyList=new ArrayList<String>();
	   List<Integer> thirdValueList=new ArrayList<Integer>();
	   List<String> referToMHList=new ArrayList<String>();
	   int inc21=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {   	int cnt=0;
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	//first.put(investigationName,patientInvestigation.getChargeCode().getId());
		    	//third.put(investigationName,patientInvestigation.getId());
		    	firstKeyList.add(investigationName);
		    	firstValueList.add(patientInvestigation.getChargeCode().getId());
		    	thirdKeyList.add(investigationName);
		    	thirdValueList.add(patientInvestigation.getId());
		    	referToMHList.add(patientInvestigation.getReferToMh());

		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		    	if(resultList.size()>0 && inc21<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc21-1);
		    	int masInvestId=dgEH.getDgMasInvestigation().getId();
		       	if(patientInvestigation.getChargeCode().getId()==masInvestId)
		    	{
		    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	{   
		    		if(dgre.getSubInvestigation()!=null)
		    		val1=dgre.getSubInvestigation().getSubInvestigationName();
		    	if(!dgre.getResultType().equalsIgnoreCase("t"))
	    		{
		      	    ++cnt;
		    		if(dgre.getResult()!=null)
		    			val2=dgre.getResult();
		    		if(cnt==1){
		    	    	val=" "+val1+":"+val2;
		    	    }else{
		    	    	val=" "+val+","+val1+":"+val2;
		    	    }

	    		}
		    	    investigationId=dgre.getInvestigation().getId();
		    		if(dgre.getResultType().equalsIgnoreCase("s"))
		    		{
		    		    	val=val.substring(2);
		    				resultid=0;			
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("m"))
		    		{
		    			val=val.substring(1);
		    			resultid=0;
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("t"))
		    		{

		    			resultid=dgre.getResultEntry().getId();
		    			template="template"+"/"+resultid;
		    			val=template;
		    		}
		    	}
		    	++inc21;
		    	}else
		    	{
		    		val=" ";
		    		investigationId=patientInvestigation.getChargeCode().getId();
		    	}

		    	}else{
		    		++inc21;
		    	}
		    	
		    	if(investigationId!=0)
		    	{	
		    		secondKeyList.add(investigationId);
		    		secondValueList.add(val);
		    	
		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
			    	second.put(investigationId,val);
			    	//++inc21;
		    }
		    int i=0;
	          
			 for(String firstKey:firstKeyList)
			 {
		%>
 <tr>
	<input type="hidden" value="<%=thirdValueList.get(i) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=firstKey%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="45" name="chargeCodeName<%=inc %>" />
				</td>
		<%

 if(secondValueList.size()>0)	
{
	  if(i<secondValueList.size())
	  {	  
		  Labresult="present";
	//String st=(String)second.get(first.get(key));
	String st=secondValueList.get(i);

	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{
	%>
	<td>
	<% if(referToMHList.get(i).equalsIgnoreCase("y")){System.out.println("in if condition For if Lab result present");
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>
 </td>
	<td><input type="text" value="<%=secondValueList.get(i)%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<% }else{
%>
<td>&nbsp;</td>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>

<%}}else
{ 
	%>
	<td> <% if(referToMHList.get(i).equalsIgnoreCase("y")){
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>	 </td>
		<td><input type="text" value="" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>
<%
}
	  }else{
		  
	String investigationVal=firstKey;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>
		<td>
		<%
	if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts)
	{
	    int finalVal=Integer.parseInt(finalInvestVal);
	    if(dgOrderdt.getInvestigation().getId()==finalVal)
	    {
	    	if(dgOrderdt.getInvestigationToMH()!=null)
	    	{
		    	if(dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
		    	{

		    		%><input tabindex="1" type="checkbox"
		    			name="investigationReferToMH<%=inc %>" value="y" disabled="disabled" checked="checked" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
	<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" />
	</td>
	<% 	    	}else
	            {
		%>
	            <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="n" disabled="disabled"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
	    <td><input type="text" value="" readonly="readonly"
				 tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" />
	</td>
	            <%

	             }
		    	}else
	    	{%> <input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" />
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65"  /></td>
		<%	}
	    }
	}}else{
	%> <input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" />
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65" /></td>
		<% }%>
		</td>

		<% }%>
		<td><input name="uploadReport<%=inc %>"
			id="uploadReport<%=inc %>" type="button" class="button"
			value="UPLOAD/VIEW" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" /></td>
		<!--<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation();" /></td>
	--></tr>
	<% inc++;i++;
		    }

%>
	<input type="hidden" value="<%=inc-1 %>" name="hiddenValue"
		id="hiddenValue" />

	<%
}else{
	%>
           
	<tr>
		<td><input type="text" value="" tabindex="1" id="chargeCodeName1"
			size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
		<td><input tabindex="1" type="checkbox"
			name="investigationReferToMH1" value="n" id="investigationReferToMH1"
			onclick="checkForInvestigationMH(1);" /></td>
		<td><input type="text" value="" readonly="readonly"
			name="Result1" id="Result1" size="65" /></td>
		<td><input name="uploadReport1" id="uploadReport1" type="button"
			class="button" value="UPLOAD/VIEW" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(1);" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation(this);" /> </td>

	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />


	<% }%>


</table>
<div class="clear"></div>
<h4>Issue Certificate</h4>
<div class="Block">
<%--
<label>Date</label>
<input type="text" name="givenOn" class="date" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="" class="calender" onclick="" />

<label>Time</label>
<input type="text" name="givenOn" class="" />
 --%>
<label>Issued By</label>
<input type="text" name="issuedBy" value="<%=empName %>" readonly="readonly"/>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="save" value="Issue Certificate" class="buttonBig" onclick="submitForm('issueCertificate','/hms/hms/fwc?method=issueSterilisationCertificate')"/>
<input type="button" name="save" value="Reject" class="buttonBig" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>