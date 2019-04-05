<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>



<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>



<script>
	<%  String condition = "";
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
		List<Object> admissionNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("admissionNoList") != null)
			admissionNoList =(List)map.get("admissionNoList");
		
%>
<div id="testDiv"><label>A&D No. <span>*</span></label> <select
	name="<%=AD_NO%>" id="<%=AD_NO%>" validate="A&D No.,string,yes" onblur="">
	<option value="">Select</option>
	<% 
	     	if (admissionNoList!=null && admissionNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = admissionNoList.iterator(); iterator.hasNext();) {
	    			Object[] object = (Object[]) iterator.next();
					Inpatient inpatient = (Inpatient)object[0];
					
					if(map.get("wound") != null){
			%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>
	<%	}else{
						if( !inpatient.getAdStatus().equals("C")){
				%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>
	<% 
  		     			}
					}
	     		}
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='* No Record Found!!';
			 	
			 </script>
	<%
			  } 
	     	 %>
	     	 <script>
function chekFRWDone(ADNumber)
	{
	 alert("in frw check11 ");
	 var xmlHttp;
	 if(trimAll(ADNumber) != ""){
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
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
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	
	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	    
	       var condition  = item.getElementsByTagName("Condition")[0];
	       if(condition==false){	 
	       alert("FRW For this AD Number is already Done ");     
	       document.getElementById("<%=AD_NO%>").option.selectedIndex=0;
	       }
	     } 
      }
    }
   
   var url="/hms/hms/mis?method=checkFRWDone&ADNumber="+ADNumber
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    }
	}
	     	 </script>
</select></div>
