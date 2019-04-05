<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="java.util.Iterator"%>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script type="text/javascript" language="javascript">
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
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasIcd> masIcdList= new ArrayList<MasIcd>();
	
 %> 
 <div class="titleBg">
<h2>Disease Wise Patient Details</h2>
</div> 
<div class="clear"></div>
<form name="diseaseWisePatientDetails" method="post" >
<div class="Block">
<div class="clear"></div>
<label>From Date<span>*</span> </label>
<input	class="date" type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"	validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.diseaseWisePatientDetails.<%=FROM_DATE%>,event);" />
<label> To Date </label>
<input class="date" type="text"	name="<%=TO_DATE%>" value="<%=currentDate%>"	validate="To Date,dateOfAdmission,no" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"onclick="setdate('<%=currentDate%>',document.diseaseWisePatientDetails.<%=TO_DATE%>,event);" />

<label> Select Disease Name <span>*</span> </label>
<%--  <select name="diseaseWise" id="diseaseWise" validate  >
<option value="0" >Select</option>
<%
	Iterator iterator=masIcdList.iterator();
		while(iterator.hasNext()){
		 MasIcd masIcd = (MasIcd) iterator.next();
		 
					%>
					
	<option value=<%=masIcd.getId()%>
		<%=(masIcd.getId()) %>><%=masIcd.getIcdName()%></option>

	<%
						}
					%>
</select>--%>

<input type="text" value="" size="50" tabindex=1 class="largeNew" id="diseaseWise" tabindex="1" name="diseaseWise" />
			<div id="ac23update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('diseaseWise','ac23update','opd?method=getListForDisease',{parameters:'requiredField=diseaseWise'});
			</script>
<div class="clear"></div>
<label>Age</label>
<input type="text" value="" id="age" maxlength="3" name="age" onblur="checkValue();chkEd();" />

<div class="clear"></div>
<label class="medium">Years</label> 
<input type="radio" class="radioAuto" name="age1" value="Years" disabled="true"  id="age2"/>

<label class="medium">Months </label> 
<input type="radio" class="radioAuto" name="age1" value="Months"  disabled="true"  id="age3"/>

<label class="medium">Days </label> 
<input type="radio" class="radioAuto" name="age1" value="Days"  disabled="true"  id="age4"/>

<div class="clear"></div>
<label class="medium">IPD</label> 
<input type="radio" class="radioAuto" name="ipd" value="1"   />

<label class="medium">OPD </label> 
<input type="radio" class="radioAuto" name="ipd" value="2"   />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Generate Report" class="buttonBig" onclick="if(checkTemplateId1())if(chkE()){submitForm('diseaseWisePatientDetails','/hms/hms/opd?method=printDiseaseWisePatientReport');}"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script>

function checkTemplateId1(){
	
	var templateId=document.getElementById('diseaseWise').value.trim();
    //alert(templateId)
    if(templateId==""){
        alert('Please Select Disease');
      return false;
    }
      else if(templateId=="----------No Items found-------------"){
    	  alert('Disease Name Is Not Correct');
    	  return false;
      }else
       return true;
  }

function chkE()
{
  if(document.getElementById('age').value!=null )
  {
	  if( document.getElementById('age').value!="")
	  {
		if(document.getElementById('age2').checked == false && document.getElementById('age3').checked == false && document.getElementById('age4').checked == false)
		{
			alert("Please Select Years/Months/Days");
			return false;
		}
	  }
	  return true;
  }
}

function chkEd()
{
	var x=trim(document.getElementById('age').value);
  if(x!=null )
  {
	  if( trim(x)!="")
	  {
	document.getElementById('age2').disabled = false;
	document.getElementById('age3').disabled = false;
	document.getElementById('age4').disabled = false;
  }
	  
}
  if(x=="" || x==null)
	  {
	    document.getElementById('age2').disabled = true;
		document.getElementById('age3').disabled = true;
		document.getElementById('age4').disabled = true;
	  }
	  
}
function trim (str)
{
     return str.replace (/^\s+|\s+$/g, '');
}
function checkValue()
{
var val=document.getElementById('age').value;
if(isNaN(val))
{
	alert("Please Enter Only Numeric Value");
	document.getElementById('age').value ='';
return false;
	
}
else{
	return true;
}
	
}

</script>