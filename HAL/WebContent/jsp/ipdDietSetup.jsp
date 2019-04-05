<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.IpdPatientDiet"%>
<%@page import="jkt.hms.masters.business.PatientDietIndoorDetail"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<body onload="fillValueDetail(1);"> 
</body>
<script type="text/javascript" language="javascript">

function openPopupWindow()
{
	 var url="/hms/hms/ipd?method=showPatientSearchJsp";
	 newwindow=window.open(url,'name',"height=600,width=1010,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(serviceNo)
{
	document.intakeOutputChartReportForm.<%=SERVICE_NO%>.value=serviceNo;
	document.intakeOutputChartReportForm.<%=SERVICE_NO%>.focus();
}
function checkHinNo(hinNo){
if(hinNo ==""){
	return false;
}else{
	return true
}
}
</script>


<% int i=1;
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	 utilMap=(Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	Set patientSet = null;
	String hinNo ="";
	String andNo ="";
	String 	deptName="";
	String currentDate =(String)utilMap.get("currentDate");
	List ipdPatientDietList = new ArrayList();
	List<Inpatient> inpatientList =  new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<PatientDietIndoorDetail> patientDietList = new ArrayList<PatientDietIndoorDetail>();
	List<PatientDietIndoorDetail> patientDietList1 = new ArrayList<PatientDietIndoorDetail>();
	List<IpdPatientDiet> ipdDietList = new ArrayList<IpdPatientDiet>();
	List<MasDiet> dietTypeList = new ArrayList<MasDiet>();	
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}
	if (map.get("deptName") != null) {
		deptName = (String)map.get("deptName");
	}	

	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		if (map.get("hinNo") != null) {
			hinNo =  ""+map.get("hinNo");
		}
		if (map.get("andNo") != null) {
			andNo =  ""+map.get("andNo");
		}
		try
		{
			if(map.get("employeeList") != null){
			    employeeList = (List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("dietTypeList") != null){
				dietTypeList = (List<MasDiet>)map.get("dietTypeList");
			}
			if(map.get("patientDietList") != null){
				patientDietList = (List<PatientDietIndoorDetail>)map.get("patientDietList");
			}
			if(map.get("patientDietList1") != null){
				patientDietList1 = (List<PatientDietIndoorDetail>)map.get("patientDietList1");
			}
		    if(map.get("ipdPatientDietList") != null)
		      {
			    ipdPatientDietList = (List) map.get("ipdPatientDietList");
		      }
		    if(map.get("ipdDietList") != null)
		      {
		    	ipdDietList = (List) map.get("ipdDietList");
		      }
	         if(map.get("inpatientList")!= null)
		     {
			    inpatientList = (List) map.get("inpatientList");
			   
	      	}
		}
		catch(Exception e)
		 {
			e.printStackTrace();
		 }
		
      %>

<div class="titleBg"><h2 >Diet Setup</h2></div>
<div class="clear"></div>
<form name="ipdDietSetup" 	method="post">
<div class="Block">
<label class="medium">Date</label>
<input type="text" value="<%=currentDate%>" name="dateForAll" class="calDate" readonly="readonly"/>

<label class="medium">Time</label>
<input type="text"	id="timeId" name="timeForAll" value="<%=time%>" class="calDate"	readonly="readonly" tabindex=1 onblur="fillTime(this.value)"
	onchange="IsValidTime(this.value,this.id);" />

<label class="medium">Diet For<span>*</span></label>
   <select class="" name="dietFor"  id="dietFor"onblur="changeValue(this.value);fillValueDetail(this.value);"> 
          <option value="0">Select</option>
          <option value="1">Morning</option>
          <option value="2">Evening</option>
   </select>

<label class="medium">Prepared By<span>*</span></label>
   <select name="preparedBy" validate="Prepared By,string,yes"><option value="">Select</option>
   <%
   for(MasEmployee empList: employeeList){ 
   String empName=empList.getFirstName();
   if(empList.getMiddleName()!=null && empList.getMiddleName()!=""){
   empName=empName+" "+empList.getMiddleName();
   }
   if(empList.getLastName()!=null && empList.getLastName()!=""){
   empName=empName+" "+empList.getLastName();
   }%>

<option value="<%=empList.getId()%>"><%=empName%></option>
<%} %>
         
   </select>
   <div class="clear"></div>
   </div>
   
<div class="clear paddingTop15"></div>
<table class="grid">
    <tr>
       <!--<th></th>
       --><th>Sl No.</th>
       <th >Patient Name</th>
       <th>HIN</th>
       <th>Bed No.</th>
       <th>Type of Diet</th>
       <th>Diet</th>
       <th>Morning Tea</th>
       <th>Lunch</th>
       <th>Evening Tea</th>
       <th>Dinner</th>
       <th>Spl. Instruction</th>
   </tr>
   <%
       if(inpatientList != null)
        { 
    	   for(Inpatient inpatient:inpatientList )
    	    {  
    		  
    	    String pName=inpatient.getHin().getPFirstName();
    		   	
       		if(inpatient.getHin().getPMiddleName() != null){
       			pName = pName+" "+inpatient.getHin().getPMiddleName();
       		}
       		if(inpatient.getHin().getPLastName() != null){
       			pName = pName+" "+inpatient.getHin().getPLastName();
       		}
    		   %>
    		   
    		   <tr>
    		         <!--<td>
    		             <input type="checkbox" name="check" value="check" id="radioCheck" class="radioAuto" />
    		         </td>
    		         --><td><%=i %></td>
    		         <td><%=pName%>
    		             <input type="hidden" class="auto" value="<%=pName%>" name="patientName<%=i %>" />
    		          </td>
    		        <td><%=inpatient.getHinNo() %>
    		        <input type="hidden" name="hinId<%=i %>" value="<%=inpatient.getHin().getId()%>">
    		        <input type="hidden" name="bedId<%=i %>" value="<%=inpatient.getBed().getId()%>">
 					<input type="hidden" name="inpatientId<%=i %>" value="<%=inpatient.getId()%>">
 					<input type="hidden" name="dietId<%=i %>" value="<%=inpatient.getDiet()!=null?inpatient.getDiet().getId():0%>">
    		        <input type="hidden" name="hinNo<%=i %>" value="<%=inpatient.getHinNo()%>"/>
    		        <input type="hidden" name="hinNo<%=i %>" value="<%=inpatient.getHinNo()%>"/>
    		        </td>    		        
    		        <td><%=inpatient.getBed().getBedNo() %>
    		         <input type="hidden" name="bedNo"<%=i %> value="<%=inpatient.getBed().getBedNo() %>"/></td>
    		       
    		       <%if(inpatient.getDiet()!=null){ %>
    		       <td>
    		              <select name="typeOfDiet<%=i %>"  id="typeOfDiet<%=i %>" class="">
    		              <option value="0">select</option>
    		              <%for(MasDiet dietLi: dietTypeList){ 
    		              if(inpatient.getDiet().getId()==dietLi.getId()){ %>
    		              <option value="<%=dietLi.getId() %>" selected="selected"><%=dietLi.getDietName() %></option>
    		              <%}else{ %>
    		              
    		               <option value="<%=dietLi.getId() %>"><%=dietLi.getDietName() %></option>
    		              <%} }%>
    		                </select>
    		          </td>
    		       <%}else{ %>
    		         <td>
    		              <select name="typeOfDiet<%=i %>"  id="typeOfDiet<%=i %>" class="auto">
    		              <option value="0">select</option>
    		              <%for(MasDiet dietLi: dietTypeList){ %>
    		              <option value="<%=dietLi.getId() %>"><%=dietLi.getDietName() %></option>
    		              <%} %>
    		              </select>
    		          </td>
    		          <%} %>
    		          <td>
    		             <select name="diet<%=i %>" id="diet<%=i %>" class="small">
    		             <option value="0">Select</option>
    		             <option>Veg</option>
    		             <option>NonVeg</option>
    		             <option>Egg</option>
    		             </select>
    		          </td>
    		        <td>
    		          <select name="morningTea<%=i %>" id="morningTea<%=i %>" class="small">
    		             <option value="0">Select</option>
    		             <option value="Y">Yes</option>
    		             <option value="N">No</option>
    		          </select>
    		        </td>
    		        <td>
    		           <select name="lunch<%=i %>" class="small" id="lunch<%=i %>">
    		             <option value="0">Select</option>
    		             <option value="Y">Yes</option>
    		             <option value="N">No</option>
    		             </select>
    		        </td>
    		        <td>
    		          <select name="eveningTea<%=i %>" class="small" disabled="disabled" id="eveningTea<%=i %>">
    		           <option value="0">Select</option>
    		             <option value="Y">Yes</option>
    		             <option value="N">No</option>
    		             </select>
    		        </td>
    		        <td>
    		          <select name="dinner<%=i %>" class="small" disabled="disabled" id="dinner<%=i %>">
    		             <option value="0">Select</option>
    		             <option value="Y">Yes</option>
    		             <option value="N">No</option>
    		             </select>
    		        </td>
    		        <%if(inpatient.getRemarks()!=null && inpatient.getRemarks()!=""){ %>
    		        <td><input type="text" name="splIns<%=i %>" id="splIns<%=i %>" maxlength="50" value="<%=inpatient.getRemarks() %>"/></td>
    		        <%}else{ %>
    		   <td><input type="text" name="splIns<%=i %>" id="splIns<%=i %>" maxlength="50"/></td>
    		   <%} %>
    		   </tr>
<% i++; } %>
    		 </table> 
    	 <%  
        }
   
   %> 

<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>
<input type="hidden" name="hiddenValue" id="hiddenValue" value="<%=i-1 %>">
<input type="button" value="SUBMIT" class="button"  onclick="if(checkSelect())if(checkAllSelect()){submitForm('ipdDietSetup','ipd?method=addDietSetup')}" />
<!--<input type="button" value="PRINT" class="button" onclick="submitForm('ipdDietSetup','/hms/hms/ipd?method=printDietSetup');" />
--><input type="button" value="BACK" class="button" onclick="submitFormForButton('ipdDietSetup','/hms/hms/ipd?method=showPatientListJsp');"/>
<!--<input type="button" value="RESET" class="button" />
--><script type="text/javascript">
function checkSelect()
{  
	if(document.getElementById('dietFor').value==0){
		alert("Please Selct Diet For First !!");
	return false;
		}
	else{
return true;
		}
}
function checkAllSelect()
{  
	var len = document.getElementById('hiddenValue').value;
	var a = document.getElementById('dietFor').value;
	var msg="";
	for(var i=1;i<=len;i++){
		if(a=="1" ){
			if(document.getElementById('typeOfDiet'+i).value =="0"){
		msg="Check Type of Diet at Line "+i;
		alert(msg)
		return false;
				}
			if(document.getElementById('diet'+i).value =="0"){
				msg="Check Diet at Line "+i;
				alert(msg)
				return false;
						}
			if(document.getElementById('typeOfDiet'+i).value =="0"){
				msg="Check Type of Diet at Line "+i;
				alert(msg)
				return false;
						}
			if(document.getElementById('morningTea'+i).value =="0"){
				msg="Check Morning Tea at Line "+i;
				alert(msg)
				return false;
						}
			if(document.getElementById('lunch'+i).value =="0"){
				msg="Check lunch at Line "+i;
				alert(msg)
				return false;
						}
		}
		else if(a=="2"){
				
			if(document.getElementById('typeOfDiet'+i).value =="0"){
				msg="Check Type of Diet at Line "+i;
				alert(msg)
				return false;
						}
					if(document.getElementById('diet'+i).value =="0"){
						msg="Check Diet at Line "+i;
						alert(msg)
						return false;
								}
					if(document.getElementById('typeOfDiet'+i).value =="0"){
						msg="Check Type of Diet at Line "+i;
						alert(msg)
						return false;
								}
					if(document.getElementById('eveningTea'+i).value =="0"){
						msg="Check Evening Tea at Line "+i;
						alert(msg)
						return false;
								}
					if(document.getElementById('dinner'+i).value =="0"){
						msg="Check Dinner at Line "+i;
						alert(msg)
						return false;
								}
		}
	}
	return true
}

function changeValue(a)
{
	var len = document.getElementById('hiddenValue').value;
	for(var i=1;i<=len;i++){
	if(a=="1"){
document.getElementById('eveningTea'+i).disabled=true;
document.getElementById('dinner'+i).disabled=true;
document.getElementById('morningTea'+i).disabled=false;
document.getElementById('lunch'+i).disabled=false;
		}
	else if(a==2){
		document.getElementById('eveningTea'+i).disabled=false;
		document.getElementById('dinner'+i).disabled=false;
		document.getElementById('morningTea'+i).disabled=true;
		document.getElementById('lunch'+i).disabled=true;
		}

}

}



function fillValueDetail(obj){   
	var i=1;
	var k=1;
	if(obj==1){
	<%if(patientDietList != null && patientDietList.size() > 0){
	for (PatientDietIndoorDetail bloodStockDetail : patientDietList) {%>
	var invObj =<%= bloodStockDetail.getMN()%>
	if(invObj == obj){
		<%if(bloodStockDetail.getDietId()!=null ){%>
		document.getElementById('typeOfDiet'+i).value="<%=bloodStockDetail.getDietId().getId()%>"
			<%}else{%>
			document.getElementById('typeOfDiet'+i).value="0"
			<%}%>
		<%if(bloodStockDetail.getDiet()!=null && bloodStockDetail.getDiet()!=""){%>
		document.getElementById('diet'+i).value="<%=bloodStockDetail.getDiet()%>"
			<%}else{%>
			document.getElementById('diet'+i).value="0"
			<%}%>
		<%if(bloodStockDetail.getMorningTeaBread()!=null && bloodStockDetail.getMorningTeaBread()!=""){%>
	document.getElementById('morningTea'+i).value="<%=bloodStockDetail.getMorningTeaBread()%>"
		<%}else{%>
			document.getElementById('morningTea'+i).value="0"
			<%}%>
		<%if(bloodStockDetail.getLunch()!=null && bloodStockDetail.getLunch()!=""){%>
	document.getElementById('lunch'+i).value="<%=bloodStockDetail.getLunch()%>"
		<%}else{%>
			document.getElementById('lunch'+i).value="0"
			<%}%>
		<%if(bloodStockDetail.getEveningTea()!=null && bloodStockDetail.getEveningTea()!=""){%>
	document.getElementById('eveningTea'+i).value="<%=bloodStockDetail.getEveningTea()%>"
		<%}else{%>
			document.getElementById('eveningTea'+i).value="0"
			<%}%>
		<%if(bloodStockDetail.getDinner()!=null && bloodStockDetail.getDinner()!=""){%>
    document.getElementById('dinner'+i).value="<%=bloodStockDetail.getDinner()%>"
    	<%}else{%>
			document.getElementById('dinner'+i).value="0"
			<%}%>
    	<%if(bloodStockDetail.getSpecialInst()!=null && bloodStockDetail.getSpecialInst()!=""){%>
    document.getElementById('splIns'+i).value="<%=bloodStockDetail.getSpecialInst()%>"
    	<%}else{%>
			document.getElementById('splIns'+i).value=""
			<%}%>
	}
	else{
		document.getElementById('typeOfDiet'+i).value="0"
			document.getElementById('diet'+i).value="0"
			document.getElementById('morningTea'+i).value="0"
			document.getElementById('lunch'+i).value="0"
			document.getElementById('eveningTea'+i).value="0"
			document.getElementById('dinner'+i).value="0"
		document.getElementById('splIns'+i).value=""
			
	}
	i++;
	<%}}
	else{
	for(int j=0;j<inpatientList.size();j++){%>
	//document.getElementById('typeOfDiet'+k).value="0"
		document.getElementById('diet'+k).value="0"
		document.getElementById('morningTea'+k).value="0"
		document.getElementById('lunch'+k).value="0"
		document.getElementById('eveningTea'+k).value="0"
		document.getElementById('dinner'+k).value="0"
	//document.getElementById('splIns'+k).value=""
		k++
	<%}}%>
	}
	else if(obj==2){
		var t=1;
		<%if(patientDietList1 != null && patientDietList1.size() > 0){
			for (PatientDietIndoorDetail bloodStockDetail1 : patientDietList1) {%>
			var invObj =<%= bloodStockDetail1.getMN()%>
			if(invObj == obj){
				<%if(bloodStockDetail1.getDietId()!=null ){%>
				document.getElementById('typeOfDiet'+i).value="<%=bloodStockDetail1.getDietId().getId()%>"
					<%}else{%>
			document.getElementById('typeOfDiet'+i).value="0"
			<%}%>
				<%if(bloodStockDetail1.getDiet()!=null && bloodStockDetail1.getDiet()!=""){%>
				document.getElementById('diet'+i).value="<%=bloodStockDetail1.getDiet()%>"
					<%}else{%>
			document.getElementById('diet'+i).value="0"
			<%}%>
				<%if(bloodStockDetail1.getMorningTeaBread()!=null && bloodStockDetail1.getMorningTeaBread()!=""){%>
			document.getElementById('morningTea'+i).value="<%=bloodStockDetail1.getMorningTeaBread()%>"
				<%}else{%>
			document.getElementById('morningTea'+i).value="0"
			<%}%>
				<%if(bloodStockDetail1.getLunch()!=null && bloodStockDetail1.getLunch()!=""){%>
			document.getElementById('lunch'+i).value="<%=bloodStockDetail1.getLunch()%>"
				<%}else{%>
			document.getElementById('lunch'+i).value="0"
			<%}%>
				<%if(bloodStockDetail1.getEveningTea()!=null && bloodStockDetail1.getEveningTea()!=""){%>
			document.getElementById('eveningTea'+i).value="<%=bloodStockDetail1.getEveningTea()%>"
				<%}else{%>
			document.getElementById('eveningTea'+i).value="0"
			<%}%>
				<%if(bloodStockDetail1.getDinner()!=null && bloodStockDetail1.getDinner()!=""){%>
		    document.getElementById('dinner'+i).value="<%=bloodStockDetail1.getDinner()%>"
		    	<%}else{%>
			document.getElementById('dinner'+i).value="0"
			<%}%>
		    	<%if(bloodStockDetail1.getSpecialInst()!=null && bloodStockDetail1.getSpecialInst()!=""){%>
		    document.getElementById('splIns'+i).value="<%=bloodStockDetail1.getSpecialInst()%>"
		    	<%}else{%>
			document.getElementById('splIns'+i).value=""
			<%}%>
			}
			else{
				document.getElementById('typeOfDiet'+i).value="0"
					document.getElementById('diet'+i).value="0"
					document.getElementById('morningTea'+i).value="0"
					document.getElementById('lunch'+i).value="0"
					document.getElementById('eveningTea'+i).value="0"
					document.getElementById('dinner'+i).value="0"
				document.getElementById('splIns'+i).value=""
					
			}
			i++;
			<%}}
			else{
				for(int j=0;j<inpatientList.size();j++){%>
					document.getElementById('typeOfDiet'+t).value="0"
					document.getElementById('diet'+t).value="0"
					document.getElementById('morningTea'+t).value="0"
					document.getElementById('lunch'+t).value="0"
					document.getElementById('eveningTea'+t).value="0"
					document.getElementById('dinner'+t).value="0"
				document.getElementById('splIns'+t).value=""
					t++
			<%}}%>
	}
}

</script>
</form>

