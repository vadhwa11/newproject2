<%@ page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.AvPilotRegistrationHd"%>
<%@page import="jkt.hms.masters.business.AvPilotRegistrationDt"%>
<%@page import="jkt.hms.masters.business.MasRank"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.Patient"%><script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}
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
	<script type="text/javascript">
	var rankArray=new Array();
	var categoryArray=new Array();
</script>
<form name="avPilotRegistration" method="post" action="">
       <%
       Properties properties = new Properties();
       URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
       try {
       	properties.load(resourcePathHIC.openStream());
       } catch (Exception e) {
       	e.printStackTrace();
       }
       

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTimeWithoutSc");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			List<MasUnit> unitList=null;
			if(map.get("unitList") != null){
				unitList =(List<MasUnit>)map.get("unitList");
			}
			List<AvPilotRegistrationDt> avPilotRegistrationDtList=null;
			if(map.get("avPilotRegistrationDtList") != null){
				avPilotRegistrationDtList =(List<AvPilotRegistrationDt>)map.get("avPilotRegistrationDtList");
			}
			List<Category> categoryList=null;
			if(map.get("categoryList") != null){
				categoryList =(List<Category>)map.get("categoryList");
			}
			List<MasRank> rankList = new ArrayList<MasRank>();
			if(map.get("rankList") != null)	{
				rankList = (List<MasRank>)map.get("rankList");
			}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
	
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			
			%>  

<div class="titleBg">
<h2>Pilot Registration</h2>
</div>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <%   }%>
<div class="clear paddingTop15"></div>
<div class="Block">

<div class="clear"></div>

<label>Unit<span>*</span></label>
<select name="<%=UNIT %>"  id="<%=UNIT %>" tabindex="1" validate="Unit,metachar,yes" onblur="checkAll(this.value);">
<option value="0">Select</option>
	<%for(MasUnit masUnit : unitList){%>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
		}%>
</select>
</div>

<div class="clear paddingTop15"></div>

<table class="cmntable" id="grid">

<tr>
<th>Sl No.</th>
<th>Service No.</th>
<th>Rank</th>
<th>Name</th>
<th>Age</th>
<th>MedCat</th>
<th>Date of Last Medical Exam</th>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc=0;inc=inc+1;%>
<tr>
<td>
<input type="text" name="<%=SIRIAL_NO%>" value="<%=inc %>" tabindex="1" size="1" class="auto"  readonly="readonly"/></td>

<td><input type="text" tabindex="1" name="serviceNo<%=inc %>" id="serviceNo<%=inc %>" onblur="ajaxFunctionAVPilotRegService(avPilotRegistration,<%=inc %>,this.value);check(this.value,<%=inc%>);"/></td>
<td>
<select	id="<%=RANK_ID %><%=inc %>" name="<%=RANK_ID %><%=inc %>"	validate="Rank,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(rankList!=null && rankList.size() >0){
	 for(MasRank masRank : rankList){
	%>

	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}
	} %>
</select>
<%
int i1=0;
for (MasRank masRank : rankList) {
     			 %> <script>

     			rankArray[<%=i1%>]= new Array();
     			rankArray[<%=i1%>][0] = "<%=masRank.getId()%>";
     			rankArray[<%=i1%>][1] = "<%=masRank.getRankName()%>";
            </script> <%
++i1;
}%></td>


<td><input type="text" name="sName<%=inc %>" id="sName<%=inc %>" value=""/>
<input type="hidden" name="hinId<%=inc %>" id="hinId<%=inc %>" value="0"/></td>

<td><input type="text" name="age<%=inc %>" id="age<%=inc %>" value=""/></td>

<td>
<select	id="medCatId<%=inc %>" name="medCatId<%=inc %>"	validate="category,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%if(categoryList!=null && categoryList.size() >0){
	 for(Category category : categoryList){
	%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%></option>
	<%}
	} %>
</select>
<%
int i33=0;
for (Category masCategory : categoryList) {
     			 %> <script>

     			categoryArray[<%=i33%>]= new Array();
     			categoryArray[<%=i33%>][0] = "<%=masCategory.getCategoryid()%>";
     			categoryArray[<%=i33%>][1] = "<%=masCategory.getCategories()%>";
            </script> <%
++i33;
}%></td>

<td>
			<input tabindex="1"  type="text"  name="dateOfLastME<%=inc%>" maxlength="10" class="auto" size="11" id="dateOfLastME<%=inc%>"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',avPilotRegistration.dateOfLastME<%=inc%>,event);" />
		</td>
<td>

<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" />
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" tabindex="1" />
</td>
</tr>
<input type="hidden" name="hdb" value="<%=inc%>" id="hdb" />
</table>
<div class="division"></div>
<div id="edited"></div>
<input	type="button" name="Submit" value="Submit" onClick="submitForm('avPilotRegistration','aviationMedicine?method=submitPilotRegistration');" tabindex="1"	class="buttonbig"  />
<input type="reset" name="Reset" value="Reset" class="button" 	tabindex="1"   />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>

<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<script type="text/javascript">
function checkAll(unit)
{
	var inc = document.getElementById('hdb').value;

	for(i=0;i<inc;i++){
		
	  var serNo=document.getElementById('serviceNo'+i).value;
	  if(serNo!=0)
	  {
			<%
			if(avPilotRegistrationDtList != null && avPilotRegistrationDtList.size() > 0){
					for (AvPilotRegistrationDt dt : avPilotRegistrationDtList) {%>
									var serVo ='<%=dt.getServiceNo()%>';
									var unitAv =<%=dt.getAvPilotRegistrationHd().getUnit().getId()%>
									if(serVo == serNo &&  unitAv==unit){
															
		 								alert("Service No. already selected...")
		 						 		document.getElementById('serviceNo'+inc).value="";
		 								
		 								document.getElementById('rankId'+inc).value=0;
		 								document.getElementById('sName'+inc).value="";
		 								document.getElementById('hinId'+inc).value="";
		 								document.getElementById('age'+inc).value="";
		 								document.getElementById('medCatId'+inc).value = 0;
		 								document.getElementById('dateOfLastME'+inc).value="";
		 								var e=eval(document.getElementById('serviceNo'+inc));
		 								e.focus();
		 								return false;
		 					
									}
		 							<%}}%>
	  }
	}
	  
}
function check(serviceNo,inc)
{
	var unit = document.getElementById('unit').value;
	if(unit!=0){
	
	for(i=0;i<inc;i++){

		if(inc != 1){
			if(document.getElementById('serviceNo'+i) && document.getElementById('serviceNo'+i).value==serviceNo) {
				alert("service No already selected...!")
				document.getElementById('serviceNo'+inc).value=""
				
					document.getElementById('rankId'+inc).value=0;
					document.getElementById('sName'+inc).value="";
					document.getElementById('hinId'+inc).value="";
					document.getElementById('age'+inc).value="";
					document.getElementById('medCatId'+inc).value = 0;
					document.getElementById('dateOfLastME'+inc).value="";
				var e=eval(document.getElementById('serviceNo'+inc));
				e.focus();
				return false;
			}
		}
	}
	<%
	if(avPilotRegistrationDtList != null && avPilotRegistrationDtList.size() > 0){
			for (AvPilotRegistrationDt dt : avPilotRegistrationDtList) {%>
							var serVo ='<%=dt.getServiceNo()%>';
							var unitAv =<%=dt.getAvPilotRegistrationHd().getUnit().getId()%>
							if(serVo == serviceNo &&  unitAv==unit){
													
 								alert("Service No. already selected...")
 						 		document.getElementById('serviceNo'+inc).value="";
 								document.getElementById('rankId'+inc).value=0;
 								document.getElementById('sName'+inc).value="";
 								document.getElementById('hinId'+inc).value="";
 								document.getElementById('age'+inc).value="";
 								document.getElementById('medCatId'+inc).value = 0;
 								document.getElementById('dateOfLastME'+inc).value="";
 								var e=eval(document.getElementById('serviceNo'+inc));
 								e.focus();
 								return false;
 					
							}
 							<%}}%>
	}else{
 							alert("Please Unit Select.");
 							var e=eval(document.getElementById('unit'));
 							document.getElementById('serviceNo'+inc).value="";
								document.getElementById('rankId'+inc).value=0;
								document.getElementById('sName'+inc).value="";
								document.getElementById('hinId'+inc).value="";
								document.getElementById('age'+inc).value="";
								document.getElementById('medCatId'+inc).value = 0;
								document.getElementById('dateOfLastME'+inc).value="";
								e.focus();
								return false;
								}
}
function addRow(){

	  var tbl = document.getElementById('grid');

	  var lastRow = tbl.rows.length;
	//alert("tbl length---"+lastRow);
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);

	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'serialNo' + iteration;
	  e0.id = 'serialNo' + iteration;
	  e0.setAttribute('maxlength', 20);
	  e0.setAttribute('readonly','readonly');
      e0.size = '1';
      e0.value=hdb.value;
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'serviceNo'+iteration ;
	  e1.id = 'serviceNo' + iteration;
	  e1.onblur=function(){
		  ajaxFunctionAVPilotRegService(avPilotRegistration,iteration,this.value);check(this.value,iteration);
		  };
	  e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);



	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	e2.name='<%=RANK_ID%>'+iteration
	e2.id='<%=RANK_ID%>'+iteration
	e2.setAttribute('tabindex','1');
	e2.options[0] = new Option('Select', '0');
	for(var i= 0;i<rankArray.length;i++ ){
	   e2.options[i+1] = new Option(rankArray[i][1],rankArray[i][0]);
	   }
	cellRight2.appendChild(e2);
   	  
    var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'sName'+ iteration;
	  e3.id = 'sName' + iteration;
   	  e3.setAttribute('maxlength', 30);
	  e3.setAttribute('tabindex','1');

	  var e33 = document.createElement('input');
	  e33.type = 'hidden';
	  e33.name = 'hinId'+ iteration;
	  e33.id = 'hinId' + iteration;
   	  e33.size = '20';
   	 e33.value='0'
   	  e33.setAttribute('maxlength', 30);
   	 cellRight3.appendChild(e3);
   	cellRight3.appendChild(e33);



    var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'age'+ iteration;
	  e4.id = 'age' + iteration;
 	  e4.setAttribute('maxlength', 30);
	  e4.setAttribute('tabindex','1');
	  cellRight4.appendChild(e4);


		var cellRight5= row.insertCell(5);
		var e5 = document.createElement('Select');
		e5.name='medCatId'+iteration
		e5.id='medCatId'+iteration
		e5.setAttribute('tabindex','1');
		e5.options[0] = new Option('Select', '0');
		for(var i= 0;i<categoryArray.length;i++ ){
			e5.options[i+1] = new Option(categoryArray[i][1],categoryArray[i][0]);
			}
		cellRight5.appendChild(e5); 

	  

		  var cellRight6 = row.insertCell(6);
		    var e6 = document.createElement('input');
		    e6.type = 'text';
		    e6.className = 'date';
		    e6.name='dateOfLastME'+ iteration;
		    e6.id='dateOfLastME'+iteration;
		    e6.size='11';
		    e6.setAttribute('tabindex','1');
		    cellRight6.appendChild(e6);

		    
		    var e66 = document.createElement('img');
		    e66.src = '/hms/jsp/images/cal.gif';
		    e66.id = 'calId'+iteration;
		    e66.onclick = function(event){
		    setdate('',document.getElementById('dateOfLastME'+iteration),event) };
		    cellRight6.appendChild(e66);
  
    var cellRight7 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonAdd';
	   e7.onclick = function(){addRow();};
	  e7.setAttribute('tabindex','1');
	  cellRight7.appendChild(e7);

	  var cellRight8 = row.insertCell(8);
	  var e8= document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonDel';
	  //  e5.setAttribute('onClick', 'removeRow('grid','hdb',this);');
	  e8.onclick =function(){removeRow('grid','hdb',this);};
	  e8.setAttribute('tabindex','1');
	  cellRight8.appendChild(e8);

	}


	function removeRow1()
	{
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hdb');
	  	hdb.value=iteration
	  }
	}
	function removeRow(idName,countId,obj)
	{
		var tbl = document.getElementById(idName);
		  var lastRow = tbl.rows.length;
		  if (lastRow > 2){
		  //	tbl.deleteRow(lastRow - 1);
		    var i=obj.parentNode.parentNode.rowIndex;
		    tbl.deleteRow(i);
		  }
	}

</script>
</form>