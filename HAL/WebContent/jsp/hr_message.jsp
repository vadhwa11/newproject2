    <%@ page import="java.util.*"%>
	<%@page import="jkt.hms.util.RequestConstants"%>

	<script >
	function checkMedFitness(link)
	{
	if(document.message.medFit.checked == true && document.message.docSubmitted.checked == true)
 		{
 		location.href = link ;
 		} 
 	else
 		{
 		alert('Please be ensure whether applicant is medically fit and have submitted all documents');
		}
	}
</script>
	<div class="clear"></div>
	<form name="message" action="" method="post" >
	<%  
		List link = null;
		String linkText = "";
		String linkUrl = "";
		String message1 = "There were no message specified.";
	    String urlYes = "/intranet/jkt/indext";
	    String urlNo = "/intranet/jkt/indext";
	    Map map=(Map)request.getAttribute("map");	
	    Integer resumeId = null;
	    Integer statusId = 0;
	    String linkGenerateOfferLetter = "";
	    String linkGenerateAppointmentLetter = "";
	    if(!map.isEmpty()){
	    	String msgArr[] = (String[])map.get("message");
	   		 resumeId = (Integer)map.get("resumeId");
	   		 System.out.println(resumeId);
	   		statusId = (Integer)map.get("statusId");
	   		System.out.println(statusId);
	   		message1 = msgArr[0];

		//	linkGenerateOfferLetter = "/erp/erp/resume?method=generateLetter&letterType=offerLetter&"+RequestConstants.RESUMEID +"="+ resumeId;
		//linkGenerateAppointmentLetter = "/erp/erp/resume?method=generateLetter&letterType=appointmentLetter&"+RequestConstants.RESUMEID +"="+ resumeId;
			
		}
	%>	
		<h4> <%=message1%> &nbsp;&nbsp;</h4>
			<div class="clear"></div>
			<input type="button" value="back" onclick="window.history.go(-1)"; >
			<div class="clear"></div>
			
			<%
			if(map.get("link") != null){
				
				link = (List)map.get("link");
				
				for(int x=0;x<link.size();x++){
					linkText = (String)link.get(x);
					linkUrl = (String)link.get(x+1);
					x++;
				%>
					<a href="<%=linkUrl%>"><%=linkText%></a>
					<div class="clear"></div>
				<%
				}
				
				%>
				<div class="clear"></div>		
		<%
			}	
		%>
		<%if(resumeId != null){%>
			<div class="division"></div>
			
			<div class="clear"></div>
			<%if(false){%>
		
					
					<a href='<%=linkGenerateOfferLetter%>'>Generate Offer Letter</a>
					
				
				<%}
				
				if(false){%>
					
					<label>Medically Fit</label>
					<input type="checkbox" name="medFit" id="med"/>
			
					<div class="clear"></div>
			
					<label>Document Submitted</label>
					<input type="checkbox" name="docSubmitted" id="doc"/>
					<a href="javascript:checkMedFitness('<%=linkGenerateAppointmentLetter%>');">Generate Appointment Letter</a>
					
				
				<%
				}
				
			}%>
		

		</form>
	 

