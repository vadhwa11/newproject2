
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.ShoAdmissionDeath"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

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
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	
	List<MasIcd> masIcdList = new ArrayList<MasIcd>();
	
	List<MasRelation> masRelationList = new ArrayList<MasRelation>();	
	if(map.get("masRelationList") != null){
		masRelationList=(List)map.get("masRelationList");
	}
	if(map.get("masIcdList") != null){
		masIcdList=(List)map.get("masIcdList");
	}
	
	List<ShoAdmissionDeath> shoAdmissionDeathList = new ArrayList<ShoAdmissionDeath>();	
	if(map.get("shoAdmissionDeathList") != null){
		shoAdmissionDeathList=(List)map.get("shoAdmissionDeathList");
	}
	Box box = HMSUtil.getBox(request);

	

%>
<!--main content placeholder starts here-->
<form name="shoAdmissionDeath" action="" method="post">

<div class="titleBg">
<h2>Admission / Death</h2>
</div>

 <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();

	</script> 
<div class="clear"></div>



<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0"  id="grid">

<tr>
<th>Sl No.</th>
<th>Date</th>
<th>Last Updated Date</th>
<th>Diagnosis</th>
<th>Category</th>
<th>Relation</th>
<th>No. of Admission</th>
<th>No. of Death</th>
<th>Avg Hospital Stay <br></br>per Patient</th>
<th>Rate per 1000</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%int inc=1;%>
<tr>

<td><input type="text" name="slNo<%=inc %>" id="slNo<%=inc %>"  MAXLENGTH="50" class="auto" size="11" value="<%=inc %>"/></td>

<td><input type="text" name="giveOn<%=inc %>" readonly="readonly" MAXLENGTH="50" id="giveOn<%=inc %>" value="<%=consultationDate%>" class="date" class="auto" size="15" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('giveOn<%=inc %>',document.shoAdmissionDeath.giveOn<%=inc %>, event)"	validate="Pick a date"  />

</td>
<%if(shoAdmissionDeathList.size()>0){ %>
<%Date lDate =new Date();
				for (ShoAdmissionDeath shoAdmissionDeath : shoAdmissionDeathList) {
									
									 lDate = shoAdmissionDeath.getAdmissionDate();
			%>
<%}%>
<td><input type="text" name="lastDate<%=inc %>" readonly="readonly"  MAXLENGTH="50" id="lastDate<%=inc %>" class="date" class="auto" value="<%=HMSUtil.changeDateToddMMyyyy(lDate)%>" size="15" validate="Date,date,yes" /></td>
<%}else{ %>
<td><input type="text" name="lastDate<%=inc %>" readonly="readonly"  MAXLENGTH="50" id="lastDate<%=inc %>" class="date" class="auto" size="11" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('lastDate<%=inc %>',document.shoAdmissionDeath.lastDate<%=inc %>, event)"	validate="Pick a date"  />
<%} %>
</td>



 <%
 String principal="";
 %>
<td width="10%"> 
 <input type="text" tabindex="1"	value="<%=principal%>" id="<%=PRINCIPAL+inc%>"  name="<%=PRINCIPAL+inc%>"	class="auto"  size="22" onblur="checkDisability(this.value,<%= inc%>);"/>
<div id="ac2updatex2"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">

		  new Ajax.Autocompleter('<%=PRINCIPAL+inc%>','ac2updatex2','opd?method=getICDForIdList',{parameters:'requiredField=<%=PRINCIPAL+inc%>'});

</script>
</td>



<td>
<select name="category<%=inc %>"  id="category<%=inc %>"  validate="Category,string,yes" >
<option value="">Select</option>
<option value="Officers">Officers</option>
<option value="JCO">JCO</option>
<option value="PBOR">PBOR</option>
</select>
</td>


<td>
<select name="relation<%=inc %>"  id="relation<%=inc %>"  validate="Relation,string,yes" >


			<option value="0">Select</option>
			<%
				for (MasRelation masRelation : masRelationList) {
									int id = masRelation.getId();
									String name = masRelation.getRelationName();
			%>

			<option value="<%=id%>"><%=name%></option>
			<%
				}
			%>
		</select> <%
		MasRelation masRelation = new MasRelation();

 					for (int i = 0; i < masRelationList.size(); i++) {
 						masRelation = (MasRelation) masRelationList
 								.get(i);
 %> <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masRelation.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masRelation.getRelationName()%>";
            </script> <%
 	}
 %>

</td>


<td><input type="text" name="noOfAd<%=inc %>" id="noOfAd<%=inc %>"  class="auto" size="15" value="" maxlength="50" validate="Number of Addmission,int,no" /></td>


<td><input type="text" name="noOfD<%=inc %>" id="noOfD<%=inc %>"  class="auto" size="15" value="" maxlength="50" validate="Number of Death,int,no" /></td>


<td><input type="text" name="avg<%=inc %>" id="avg<%=inc %>"  class="auto" size="15" value="" validate="Average Stay per Patient,int,no" maxlength="50" onblur="cal(this.value,<%=inc %>);"  /></td>


<td><input type="text" name="rate<%=inc %>" id="rate<%=inc %>"  class="auto" size="15" value="" readonly="readonly" maxlength="50"/></td>



<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /></td>

<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid',<%=inc%>,this);" tabindex="1" /></td>
</tr>
	<input type="hidden" value="<%=inc%>" name="hiddenValue" id="hiddenValue" />
</table>


</div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Button" value="Submit" class="button" onclick="submitForm('shoAdmissionDeath','/hms/hms/mis?method=submitAdmissionDeath')"/>
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('shoAdmissionDeath','/hms/hms/mis?method=showAdmissionDeath');" accesskey="r" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
function addRow(){
    
		var tbl = document.getElementById('grid');
	  	var lastRow = tbl.rows.length;
	   	var iteration = lastRow;
	  	var row = tbl.insertRow(lastRow);
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration;
	
 	  	var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
	  	e0.type = 'text';
	  	e0.name='slNo'+iteration;
	  	e0.id='slNo'+iteration
		e0.size='15';
		e0.value=iteration;
	  	e0.setAttribute('tabindex','1');
	  	cellRight0.appendChild(e0);

	  	var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.className = 'date';
		e1.name='giveOn'+ iteration;
		e1.id='giveOn'+iteration;
		e1.size='15';
		e1.readOnly='readonly';
		e1.value='<%=consultationDate%>'
		e1.setAttribute('tabindex','1');
		cellRight1.appendChild(e1);

		var e11 = document.createElement('img');
		e11.src = '/hms/jsp/images/cal.gif';
		e11.id = 'giveOn'+iteration;
		e11.onclick = function(event){
		setdate('',document.getElementById('giveOn'+iteration),event) };
		cellRight1.appendChild(e11);


		<%if(shoAdmissionDeathList.size()>0){ %>
		<%Date lDate =new Date();
						for (ShoAdmissionDeath shoAdmissionDeath : shoAdmissionDeathList) {
											
											 lDate = shoAdmissionDeath.getLastDate();
					%>
		<%}%>

	  	var cellRight2 = row.insertCell(2);
		var e2 = document.createElement('input');
		e2.type = 'text';
		e2.className = 'date';
		e2.name='lastDate'+ iteration;
		e2.id='lastDate'+iteration;
		e2.size='15';
		e2.readOnly='readonly';
		e2.value='<%=HMSUtil.changeDateToddMMyyyy(lDate)%>'
		e2.setAttribute('tabindex','1');
		cellRight2.appendChild(e2);


		
						
		<%}else{%>

	  	var cellRight2 = row.insertCell(2);
		var e2 = document.createElement('input');
		e2.type = 'text';
		e2.className = 'date';
		e2.name='lastDate'+ iteration;
		e2.id='lastDate'+iteration;
		e2.size='15';
		e2.setAttribute('tabindex','1');
		cellRight2.appendChild(e2);

		var e22 = document.createElement('img');
		e22.src = '/hms/jsp/images/cal.gif';
		e22.id = 'lastDate'+iteration;
		e22.onclick = function(event){
		setdate('',document.getElementById('lastDate'+iteration),event) };
		cellRight2.appendChild(e22);

<%}%>
		var cellRight3 = row.insertCell(3);
		var e3 = document.createElement('input');
		e3.type = 'text';

		e3.name = 'principal' + iteration;
		e3.id = 'principal' + iteration;
		e3.setAttribute('maxlength', 22);
		e3.size = '22';
		e3.setAttribute('tabindex','1');
		e3.onblur=function(){checkDisability(this.value,iteration)};
		cellRight3.appendChild(e3);

		var newdiv3 = document.createElement('div');
		newdiv3.setAttribute('id', 'ac2updatex2'+iteration);
		newdiv3.className = 'autocomplete';
		newdiv3.style.display = 'none';
		cellRight3.appendChild(newdiv3);
		cellRight3.appendChild(e3);
		new Ajax.Autocompleter('principal'+iteration,'ac2updatex2'+iteration,'opd?method=getICDForIdList',{parameters:'requiredField=principal'+iteration});
				
		
	
		  	var cellRight4 = row.insertCell(4);
			var e4 = document.createElement('Select');
		  	e4.name='category'+iteration;
		  	e4.id='category'+iteration;
		  	e4.classname='smalllabel';
		  	e4.setAttribute('tabindex','1');
		  	e4.options[0] = new Option('Select', '');
		  	e4.options[1] = new Option('Officers', 'Officers');
		   	e4.options[2] = new Option('JCO', 'JCO');
		   	e4.options[3] = new Option('PBOR', 'PBOR');
		   	cellRight4.appendChild(e4);

			var cellRight5 = row.insertCell(5);
			  var e5 = document.createElement('Select');
			  e5.name='relation'+iteration;
			  e5.id='relation'+iteration;
			   e5.className='smalllabel';
			  e5.setAttribute('tabindex','1');
			  e5.options[0] = new Option('Select', '0');
			  for(var i = 0;i<icdArray.length;i++ ){
			      e5.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
			      }
			  cellRight5.appendChild(e5);
			  
		
	   	var cellRight6 = row.insertCell(6);
 	  	var e6 = document.createElement('input');
	  	e6.type = 'text';
	  	e6.name='noOfAd'+iteration;
	  	e6.id='noOfAd'+iteration
	  	e6.size=15;
	  	e6.maxlength=5;
	  	e6.setAttribute('tabindex','2');
		cellRight6.appendChild(e6);


	   	var cellRight7 = row.insertCell(7);
 	  	var e7 = document.createElement('input');
	  	e7.type = 'text';
	  	e7.name='noOfD'+iteration;
	  	e7.id='noOfD'+iteration
	  	e7.size=15;
	  	e7.maxlength=5;
	  	e7.setAttribute('tabindex','2');
		cellRight7.appendChild(e7);


		var cellRight8 = row.insertCell(8);
 	  	var e8 = document.createElement('input');
	  	e8.type = 'text';
	  	e8.name='avg'+iteration;
	  	e8.id='avg'+iteration
	  	e8.size=15;
	  	e8.maxlength=5;
	  	e8.setAttribute('tabindex','2');
	  	e8.onblur=function(){cal(this.value,iteration);};
		cellRight8.appendChild(e8);


		var cellRight9 = row.insertCell(9);
 	  	var e9 = document.createElement('input');
	  	e9.type = 'text';
	  	e9.name='rate'+iteration;
	  	e9.id='rate'+iteration
	  	e9.size=15;
	  	e9.maxlength=5;
		e9.readOnly='readonly';
	  	e9.setAttribute('tabindex','2');
		cellRight9.appendChild(e9);
		
		var cellRight10 = row.insertCell(10);
	  	var e10 = document.createElement('input');
	  	e10.type = 'button';
		e10.className = 'buttonAdd';
	  	e10.name='Button';
	  	e10.setAttribute('tabindex','1');
	  	e10.onclick = function(){addRow("grid",hdb,this);}; 
	  	cellRight10.appendChild(e10);

		var cellRight11 = row.insertCell(11);
	  	var e11 = document.createElement('input');
	  	e11.type = 'button';
	  	e11.className = 'buttonDel';
	  	e11.name='delete';
	  	e11.setAttribute('tabindex','1');
	  	e11.onclick = function(){removeRow("grid",hdb,this);}; 
	  	cellRight11.appendChild(e11);
}

function removeRow(idName,countId,obj)
{
var tbl = document.getElementById(idName);
var lastRow = tbl.rows.length;
if (lastRow > 2){
  var i=obj.parentNode.parentNode.rowIndex;
  tbl.deleteRow(i);
}
}

function cal(val,inc)
{
	if(val!=0)
	{
	var cal;
	cal=(val/1000)*100;
	document.getElementById("rate"+inc).value=cal;
	}
}


function checkDisability(val,inc){
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var index = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var id = val.substring(index1,index2);
			var index = index--;
			var disability = val.substring(0,index);		
			if(id == "" ) {
				if(document.getElementById('principal'+inc)){
			      	document.getElementById('principal'+inc).value="";
			    }
		     return false;
			}		
	}
	}
	</script>