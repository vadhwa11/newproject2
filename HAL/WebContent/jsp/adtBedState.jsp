<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : finalDischarge.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>



<div id="contentHolder">
<h6>ADT Daily Bed Status</h6>
<form name="bedStatusSearch" method="post" action="">

<div class="Clear"></div>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List bedStatusList = new ArrayList();
		List sumList = new ArrayList();
		List todayList = new ArrayList();
		Date currentDate=new Date();
		int totcount = 0;
	 	if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("bedStatusList") != null){
			bedStatusList= (List)map.get("bedStatusList");
		}
		
		if(map.get("todayList") != null){
			todayList = (List)map.get("todayList");
		}
		
		if(map.get("sumList") != null){
			sumList= (List)map.get("sumList");
		}
		
		if(map.get("totcount") != null){
			totcount = (Integer)map.get("totcount");
		}
		
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	
	function showDeptRecords()
	{
	// var str = 'commandent?method=showTodayAdmissionJsp&parent=' + document.getElementById("parent").value; 
	// submitForm('finalDischarge',str,'validateRadio');

    var id = "";
	var check = "";
	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				id = document.getElementsByName('parent')[i].value
				check = "yes";
				 // return true;
			  }		
  		}
  	      if(check=="yes"){
  	          var str = 'commandent?method=showTodaySILDILJsp&parent=' +id;
	        submitForm('finalDischarge','commandent?method=showTodayAdmissionJsp&parent='+id);
		   }else{
		 	alert("Please select  one department...!\n");
		 	return false;
		    }


	}
	
	function showSILDILRecords()
	{
	
	var id = "";
	var check = "";
	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				id = document.getElementsByName('parent')[i].value
				check = "yes";
				 // return true;
			  }		
  		}
  	      if(check=="yes"){
  	          var str = 'commandent?method=showTodaySILDILJsp&parent=' +id;
	         submitForm('finalDischarge','commandent?method=showTodaySILDILJsp&parent='+id);
		   }else{
		 	alert("Please select  one department...!\n");
		 	return false;
		    }
	}
	</script> <label class="bodytextBNoWidth">Bed State as on <%=currentDate%></label>
<%  
   int counter = 0;
  //System.out.println("sumList size :::::::"+sumList.size());
   if(sumList.size()>0)
    	{
    	   	 BigDecimal tot = null;
    	   	 try
    	   	 {
    	   	 tot = new BigDecimal(sumList.get(0).toString());
    	   	 }
    	   	 catch(Exception e)
    	   	 {
    	   		tot= new BigDecimal("0");
    	   	 }
	    %> <%		
    	}
 %> <label class="bodytextBNoWidth">Total : <%=totcount%></label></form>
<br />

<jsp:include page="searchResultBlock.jsp" /> <br />
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript">

   formFields = [
    [0, "<%= DEPARTMENT_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"], [2,"<%= WARD_NAME%>"],[3,"<%= BEDS_AUTH %>"], [4,"<%= BEDS_OCCUPIED %>"],[5,"<%= DISCHARGE %>"],[6,"<%=DIL%>"], [7,"<%= SIL %>"],[8,"<%= VEG %>"],[9,"<%= NON_VEG %>"]];
    statusTd = 9;

   </script></div>
</div>

<br />
<br />
<form name="finalDischarge" method="post" action=""><input
	type="button" name="patients" id="patientsButton" value="Patients"
	class="button" onClick="showDeptRecords();" accesskey="a" tabindex=1 />
<input type="button" name="dilSil" id="dilSil" value="DIL SIL"
	class="button" onClick="showSILDILRecords();" accesskey="a" tabindex=1 />
<!--     <input type="button" name="dilSil" id="dilSil"  value="DIL SIL" class="button" onClick="submitForm('finalDischarge','commandent?method=showTodaySILDILJsp','validateRadio');" accesskey="a" tabindex=1/>
 -->
</div>

<script type="text/javascript">
    data_header = new Array();
        
   	data_header[0] = new Array;
	data_header[0][0] = "Radio"
	data_header[0][1] = "radio";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"
    
    data_header[1] = new Array;
    data_header[1][0] = "Ward"
    data_header[1][1] = "data";
    data_header[1][2] = "30%";
    data_header[1][3] = "<%=WARD_NAME%>";
    
    data_header[2] = new Array;
    data_header[2][0] = "Beds Auth"
    data_header[2][1] = "data";
    data_header[2][2] = "12%";
    data_header[2][3] = "<%=BEDS_AUTH%>";
    
    data_header[3] = new Array;
    data_header[3][0] = "Beds Occupied"
    data_header[3][1] = "data";
    data_header[3][2] = "12%";
    data_header[3][3] = "<%=BEDS_OCCUPIED%>";
    
    
    data_header[4] = new Array;
    data_header[4][0] = "Today Dis"
    data_header[4][1] = "data";
    data_header[4][2] = "12%";
    data_header[4][3] = "<%=DISCHARGE%>";
    
    data_header[5] = new Array;
    data_header[5][0] = "DIL"
    data_header[5][1] = "data";
    data_header[5][2] = "15%";
    data_header[5][3] = "<%=DIL%>";
    
    data_header[6] = new Array;
    data_header[6][0] = "SIL"
    data_header[6][1] = "data";
    data_header[6][2] = "14%";
    data_header[6][3] = "<%=SIL%>";
    
    data_header[7] = new Array;
    data_header[7][0] = "Veg"
    data_header[7][1] = "data";
    data_header[7][2] = "12%";
    data_header[7][3] = "<%=VEG%>";
    
    data_header[8] = new Array;
    data_header[8][0] = "Non Veg"
    data_header[8][1] = "data";
    data_header[8][2] = "12%";
    data_header[8][3] = "<%=NON_VEG%>";
    
    
     data_arr = new Array();
    
    <%
   
    counter = 0;
    	if(bedStatusList.size()>0)
    	{
    		
			Iterator ite = bedStatusList.iterator();
			while ( ite.hasNext() ) {
		         Object[] pair = (Object[]) ite.next();
		         		       	 
		         String deptname = null;
		         BigInteger total = new BigInteger("0");
		       	 BigDecimal sil = new BigDecimal("0");
		       	 BigDecimal dil = new BigDecimal("0");
		       	 BigDecimal veg = new BigDecimal("0");
		       	 BigDecimal nonveg = new BigDecimal("0");
		       	 Integer bedStrength = new Integer("0");
		       	 int tDis = 0;
		       	 int deptid = 0;
		       	 
		       	 if (pair[0]!=null)
		         	deptname = (String)pair[0];
		       	 
		         if (pair[1]!=null)
			        total = (BigInteger)pair[1];
		         
		         if (pair[2]!=null)
			         sil = (BigDecimal)pair[2];
		         
		         if (pair[3]!=null)
			         dil =(BigDecimal)pair[3];
		         
		         if (pair[4]!=null)
			         veg =(BigDecimal)pair[4];
		         
		         if (pair[5]!=null)
			         nonveg =(BigDecimal)pair[5];
		         
		         if (pair[6]!=null)
		         {
			         deptid =(Integer)pair[6];
		         }

		         if (pair[7]!=null)
		         {
			         bedStrength =(Integer)pair[7];
		         }
		         
		        // System.out.println("deptId:::::"+deptid+"::::::::::"+todayList.size());
		         if(todayList.size() > 0){
		        	 Iterator ited = todayList.iterator();
		 			while ( ited.hasNext() ) {
		 		         Object[] today = (Object[]) ited.next();
		 		     //    int edep = Integer.parseInt(today[0].toString());
		 		    // System.out.println(":::::::"+today[0].toString());
		 		        if(Integer.parseInt(today[0].toString()) == deptid){ 
		 		        	tDis = Integer.parseInt(today[1].toString());
		 			}
		         }
		        }				
  	%>
		    	data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] = <%=deptid%>
				data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=deptid%>" id="parent" />'
				data_arr[<%= counter%>][2] = "<%=deptname%>"
				data_arr[<%= counter%>][3] = "<%=bedStrength%>"
				
				<% if(total!=null){%>
						data_arr[<%= counter%>][4] = "<%= total%>"
			    <% }else{%>
						data_arr[<%= counter%>][4] = 0
				<%} %>
				
				  data_arr[<%= counter%>][5] = "<%= tDis%>"

				<%if(dil!=null){%>
						data_arr[<%= counter%>][6] = "<%= dil%>"
				<%}else{%>
						data_arr[<%= counter%>][6] = 0
				<%} 
				
				if(sil!=null){%>
						data_arr[<%= counter%>][7] = "<%= sil%>"
				<%}else{%>
						data_arr[<%= counter%>][7] = 0
				<%}
			
				if(veg!=null){%>
						data_arr[<%= counter%>][8] = "<%= veg%>"
				<%}else{%>
						data_arr[<%= counter%>][8] = 0
				<%}
			
				if(nonveg!=null){%>
						data_arr[<%= counter%>][9] = "<%= nonveg%>"
				<%}else{%>
						data_arr[<%= counter%>][9] = 0
				<%}%>
				
				      
    		
  	<%		counter++;	
  				
    		}
    	}
 %>
     formName = "finalDischarge"
	 start = 0
    if(data_arr.length < rowsPerPage)
     end = data_arr.length;
    else
     end = rowsPerPage;
    
    makeTable(start,end);
    
    intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
    </script>

</form>

