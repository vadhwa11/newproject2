
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * opdTemplateTreatment.jsp  
	 * Purpose of the JSP -  This is for All OpdTemplateTreatment Master.
	 * @author  Mansi
	 * Create Date: 25 June,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5
	--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/commom.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>




<script type="text/javascript">
	
	templateArray = new Array();
	
	function populateTemplate(val,formName){
		obj = eval('document.'+formName+'.templateId');
		obj.length = 1;
		for(i=0;i<templateArray.length;i++){
			if(templateArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=templateArray[i][1];
				obj.options[obj.length-1].text=templateArray[i][2];			
			}
		}
	}
	

	
	
	</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList = (List<MasDepartment>)map.get("departmentList");
	
	List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
	opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
	
		
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	%>
	
	<%
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><%=message %></h4>
		 
		 <% }%>
	
	
	
<script type="text/javascript">
			<%
				int counter1 = 0;
				for (MasDepartment masDepartment : departmentList)
				{
					for (OpdTemplate opdTemplate : opdTemplateList) 
					{
						if(opdTemplate.getDepartment() != null){
							if(masDepartment.getId().equals(opdTemplate.getDepartment().getId() )){
									%>
										templateArray[<%=counter1%>] = new Array();
										templateArray[<%=counter1%>][0]=<%=masDepartment.getId()%>;
										templateArray[<%=counter1%>][1] = <%=opdTemplate.getId()%>;									
										templateArray[<%=counter1%>][2] = "<%=opdTemplate.getTemplateName()%>";
	
									<%
									counter1++;
							}
						}
					}
				}
				
			%>
	
		</script>

<div class="titleBg">
<h2>Standard  Treatment Templates</h2>
</div>
<div class="clear"></div>
<form name="opdTemplateTreatment" action="">
<div class="Block">
<label>Department Name<span>*</span>  </label>
<select id="deptId" name="<%= DEPARTMENT_ID %>" id="depId"	validate="Department Name,string,yes" tabindex=1 onmouseout="populateTemplate(this.value,'opdTemplateTreatment');">
	<option value="0">Select</option>
	<%
								  	for (MasDepartment masDepartment : departmentList) {
					  %>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%
					  		  				  	}
					  		  				  %>
</select>
<script type="text/javascript">
	
		document.getElementById('deptId').value = '<%=deptId%>';
		
		</script>
<label> Template Group <span>*</span> </label>
<select	name="<%=TEMPLATE_ID%>" validate="Template Group,string,yes" onchange="submitProtoAjax('opdTemplateTreatment','/hms/hms/opdMaster?method=getTemplateGroup');">
	<option value="0">Select</option>

</select>
	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
</div>
</form>
<div class="clear"></div>

<div id="testDiv"></div>



<script type="text/javascript">

		
function checkForPVMS(val){
	
	 var counter=document.getElementById('counter').value
		 if(counter>0)
		  {
		 for(var i=0;i<=counter; i++)
		 {
		 	 var itemNameFromDS=data_arr[i][4]
		 	if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForNomenclature=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForNomenclature=indexForNomenclature--;
			    var nomenclature=val.substring(0,indexForNomenclature);
			   
		 	}
		 	if(pvmsNo =="")
			{
				return;
			}
			
			if(nomenclature==itemNameFromDS)
			{
				alert("Nomenclature already selected...!")
	     		document.getElementById('nomenclature').value=""
	     		document.getElementById('pvmsNo').value=""
	     		return false;
			}
					ajaxFunctionForAutoCompletePVMS('testOPD','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);	
		
		}
		}else{
			if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForNomenclature=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForNomenclature=indexForNomenclature--;
			    var nomenclature=val.substring(0,indexForNomenclature);
			   
		 	}
		 	if(pvmsNo =="")
			{
				return;
			}
			ajaxFunctionForAutoCompletePVMS('testOPD','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);
			
		}
	
	
	}
	
	


		function showPage()
		{	
		 obj = eval('document.'+formName)
 		 obj.action = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";
  		 obj.submit();
		}
		
		
       function callTotal(){
    	   var total=0;
    	    var dosageCalculation = document.getElementById('dosageCalculation').value;
    	    var noOfDays = document.getElementById('noOfDays').value;
			var fCodeId = document.getElementById('frequency').value;
         	var fCode = fCodeId;
         	//var frqId=0;
         	if(dosageCalculation!="" && noOfDays !=""&& fCode !="")
         	{
         		frqId=fCode;
         		
         		if(fCode=='15')
             	{  
         			
         		    fCode=1;
         			noOfDays=noOfDays/7;
         			var mySplitResult = noOfDays.toString().split('.'); 
         			noOfDays=mySplitResult[0];
         			
             	}
         		if(fCode=='16')
             	{
         			
         			fCode=1;
         			noOfDays=noOfDays/15;
         			var mySplitResult = noOfDays.toString().split('.'); 
         			noOfDays=mySplitResult[0];
         			
             	}
         		if(fCode=='17')
             	{
         			fCode=1;
         			noOfDays=noOfDays/2;
         			var mySplitResult = noOfDays.toString().split('.'); 
         			noOfDays=mySplitResult[0];
         			
             	}
         		if(fCode=='18')
             	{
         			fCode=1;
         			noOfDays=noOfDays/30;
         			var mySplitResult = noOfDays.toString().split('.'); 
         			noOfDays=mySplitResult[0];
         			
             	}
         		
             	
             	
       	     total = parseInt(fCode)*parseInt(noOfDays)*parseInt(dosageCalculation);
            
         	}else
     		{
         		  
     			// fCode = fCodeId.substring(2);
     			// frqId=fCode;
     			 total = parseInt(fCode)*parseInt(noOfDays)*parseInt(dosageCalculation);
     		}
         	
         	if(total==NaN)
         	{
         		
         	total=0;
         	}
         	
         	if(total > 0)
         	{
             
         	
         	}else
         	{
         		
         		total=0;
         	}
         	document.getElementById('totalId').value = total;
         	//alert("fCode--"+fCode);
         //	document.getElementById('frequency').value = fCode;
       		
       }
       
       

function checkPVMSNo()
{
		var r = document.getElementById('nomenclature').value;
		if(r=="")
		{
			alert("Please Enter Nomenclature")
			return false;
		}
		else
		{
			return true;
		}
}

</script>

