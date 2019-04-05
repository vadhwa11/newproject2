<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import = " java.text.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
		Map map = new HashMap();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
        String SPName = "";
        String rank ="";
        String trade = "";
        String unit ="";
        String relation ="";
        String patientName ="";
        String gender ="";
        String age = "";
        String address = "";
        String contact = "";
        Date dateOfAdmission = null;
        DateFormat formatter ; 
	        Date date ; 
	        String date1Admn="";
	         formatter = new SimpleDateFormat("dd-MMM-yy");
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
        
		if (map.get("patientList") != null)
		{
			patientList =(List<Patient>)map.get("patientList");
			
		}
		inpatientList = (List<Inpatient>) map.get("inpatientList");
		
		if(map.get("inpatientList")!= null)
		  {
			inpatientList = (List<Inpatient>) map.get("inpatientList");
		  }		
  	 	   if (patientList!=null && patientList.size() > 0 )
	     	{	   		
    		
	       for(Patient patient : patientList)	        	 
	           {     	    				
	    				patientName=patient.getPFirstName();
	    				
						if(patient.getPMiddleName()!=null){
							patientName =patientName+" "+patient.getPMiddleName();
	    				}
	    				if(patient.getPLastName()!=null){
	    					patientName =patientName+" "+patient.getPLastName();
	    				}
	    				if(patient.getTrade()!= null)
	    				{
	    				 trade = patient.getTrade().getTradeName();
	    				}
	     			    if(patient.getContactNo()!= null)
	     			     {
	     			    	contact = patient.getContactNo() ;
	     			    	
	     			     }
	     			    if(patient.getRank()!= null)
	     			    {
	     	             if(patient.getRank().getRankName()!= null)
	     	              {
	     	            	 rank = patient.getRank().getRankName();
	     	              }
	     			    }
	     	             if(patient.getSFirstName()!= null)
	     	             {
	     	                SPName = patient.getSFirstName();
	     	             }
	     	             if(patient.getSLastName()!= null)
	     	              {
	     	            	SPName =SPName + " "+ patient.getSLastName();
	     	              }
	     	             if(patient.getUnit()!= null)
	     	              {
	     	            	 unit =patient.getUnit().getUnitName();
	     	              }
	     	             if(patient.getRelation()!= null)
	     	              {
	     	            	relation = patient.getRelation().getRelationName(); 
	     	              }
	     	             if(patient.getSex()!= null)
	     	             {
	     	            	 gender = patient.getSex().getAdministrativeSexName();
	     	             }
	     	             if(patient.getAddress()!= null)
	     	             {
	     	            	 address = patient.getAddress();
	     	             }
	     	             if(patient.getAge()!= null)
	     	             {
	     	            	 age = patient.getAge();
	     	             }
	     	           
	     	   			int hinId=patient.getId();	     	   			
	     	   			if(inpatientList != null && inpatientList.size()>0)
	     	   			{
	     	   				for(Inpatient inpatient: inpatientList)
	     	   				  {       
	     	   				          if(inpatient.getDateOfAddmission()!= null)
	     	   				          {	     	   				        	
	     	   				        	dateOfAdmission = inpatient.getDateOfAddmission()  ;	     	   				        	
	     	   				        	
	     	   				          }
	     	   				          
	     	   				  }
	     	   			}
	     	   			
	     	   		
				%>			


<div id="hinDiv11">
<label>Rank</label>
<input type="text" name="rank" readonly="readonly"  id="rank/RateId" value="<%=rank%>"  />

<label>Name</label>
<input type="text" name="ServName" readonly="readonly" id="nameId"   value="<%=SPName%>" />

<label>Trade/ Branch</label>
<input type="text" name="trade" id="trade" readonly="readonly" value="<%=trade %>" />

<label>Unit</label>
<input type="text" name="unit" id="unit" readonly="readonly" value="<%=unit%>" />

<div class="clear"></div>

<label>Relation</label>
<input type="text" name="relation" id="relation" readonly="readonly" value="<%=relation%>" />

<label>Patient Name</label>
<input type="text" name="patientName" readonly="readonly" value="<%=patientName %>" />

<label>Gender</label>
<input type="text" name="gender" readonly="readonly" value="<%=gender%>" />

<div class="clear"></div>

<label>Age</label>
<input type="text" name="age" readonly="readonly" value="<%=age%>" />

<label>Address</label>
<input type="text" name="address" readonly="readonly" value="<%=address%>" />

<label>Contact</label>
<input type="text" name="contact" readonly="readonly" value="<%=contact%>" />

<input type="hidden" name="hinId" value=<%=hinId %>  />

<label>Date of Admission to Hospital/ Sick Bay/ SSQ</label>

<% if(dateOfAdmission != null) {
	date1Admn=HMSUtil.changeDateToddMMyyyy(dateOfAdmission);
	


%>
<input type="text" name="admissionDate" readonly="readonly" value="<%=date1Admn %>" MAXLENGTH="20"  id="toAppDate" />
<%} else{ %>
<input type="text" name="admissionDate" readonly="readonly" value="" /> 
<%}}} %>
</div>


	