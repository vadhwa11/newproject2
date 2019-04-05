<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * meScale.jsp  
 * Purpose of the JSP -  This is for Scale.
 * @author  Mansi
 * @author  Dipali
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
	<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchMeScaleList = (ArrayList)map.get("searchMeScaleList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	
}

%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><span><%=message %></span></h4>
	   <% 
	  }

%>

<script type="text/javascript">
function addRow(idName) {
	
	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;

	  var cellRight0 = row.insertCell(el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '5';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  ee5.name='idItem';
	  ee5.id = 'idItem'+iteration;
	  
	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='10';
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(e1);
	 
	  var cellRight2 = row.insertCell(++el);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '30';
	  e2.onblur = function(){checkForMeScale(this.value, 'nameItem',iteration)};

	  var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update'+iteration);
 	  newdiv.style.display = 'none';
 	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','nonExp?method=getItemListForMeScale',{parameters:'requiredField=nameItem'});

	  var cellRight3 = row.insertCell(++el);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=AV%>';
	  e3.id = 'idAu'+iteration;
	  e3.size='10';
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(++el);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='qty';
	  e4.id = 'qty'+iteration;
	  e4.size='10';
	  cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(++el);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.name='remarks'+iteration;
	  e5.className = 'buttonAdd';
	  e5.onclick= function(){addRow('grid')};
	  cellRight5.appendChild(e5);

	  var cellRight6 = row.insertCell(++el);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.name='remarks'+iteration;
	  e6.className = 'buttonDel';
	  e6.onclick= function(){removeRow('grid')};
	  cellRight6.appendChild(e6);
	  				 
}

function removeRow(idName)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;

    	for(var i=rowCount-1; i>0; i++) 
        {
        	var row = table.rows[i];
            if(i>1)
            {
            	table.deleteRow(i);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;
          

       }
       }catch(e)
       	{
           alert(e);
       }
      
}

function checkForItemDetailsGrid()
{
	var gridSize =parseInt(document.getElementById('gridSize').value) 
	
    for(var i=1;i<=gridSize;i++)
	    {
		  
		   
		   
		      	if (document.getElementById('codeItem'+i).value=="")
			    { 
			    alert('Pl. Check PVMS/NIV No: in Row No' + i);
			    document.getElementById('codeItem'+i).focus();
			    return false;
			    }

				if (document.getElementById('nameItem'+i).value=="")
			    { 
			    alert('Pl. Select Nomenclature in Row No:' + i);
			    document.getElementById('nameItem'+i).focus();
			    return false;
			    }
				
			    if (document.getElementById('idAu'+i).value=="")
			    { 
			    alert('Pl. Check A/U in Row No:' + i);
			    document.getElementById('idAu'+i).focus();
			    return false;
			    }
		
	  }
	   
	    return true;
}	    

 function checkForMeScale(val,a,inc)
{
			
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvms = val.substring(index1,index2);
		ajaxFunctionForAutoMeScale('meScale','nonExp?method=fillItemsForMeScale&requiredField=' + pvms,inc);
}


function ajaxFunctionForAutoMeScale(formName,action,rowVal) 
{
var xmlHttp;
	try
	{
	  xmlHttp=new XMLHttpRequest();
	}catch (e)
	{
	try
	{
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");

	}catch (e)
	{
		alert(e)
	try
	{
	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}catch (e)
	{
	alert("Your browser does not support AJAX!");
	return false;
	}
	}
	}
	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4)
	{
	var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) 
	{
		var item = items.childNodes[loop];
		var id  = item.getElementsByTagName("id")[0];
		var pvms  = item.getElementsByTagName("pvms")[0];
		var au  = item.getElementsByTagName("au")[0];
		document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
		document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
		document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	}    	
	}
	}
	var url=action
	xmlHttp.open("GET",url,true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

</script>

<script	type="text/javascript">
				<!--
					// Main vBulletin Javascript Initialization
					vBulletin_init();
				//-->
				</script>




<div id="searchBlock" style="display:none;">
<form name="searchForm" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>ME Scale No.</label>
<input	type="text" name="<%=ME_SCALE_NUMBER%>" value="" tabindex=1 MAXLENGTH="30" id="codeId" />
<label>ME Scale Description</label>
<input	type="text" name="<%=ME_SCALE_DESCRIPTION%>" value="" tabindex=1 MAXLENGTH="50" />
<label>PVMS/NIV No.</label>
<input	type="text" name="<%=ITEM_CODE%>" value="" tabindex=1 MAXLENGTH="25" />
<input	name="button" type="button" class="button"	onclick="submitForm('searchForm','pharmacy?method=searchMeScale');" value="Search" />
</form>
</div>
</form>
</div>

<h6>ME SCALE ENTRY</h6>
<div class="Clear"></div>		  
<form name="meScale" method="post" action="">
<div class="clear"></div>

<div class="Block">
<label >ME Scale No.<span>*</span></label>
<input id="codeId" type="text" name="<%= ME_SCALE_NUMBER%>" value="" validate="AF Scale No,alphanumeric,yes"  MAXLENGTH="30"x tabindex=1 />
<label >ME Scale Description <span>*</span> </label>
<input type="text" name="<%= ME_SCALE_DESCRIPTION %>" value="" validate="AF Scale Description,alphanumeric,yes"  MAXLENGTH="50" tabindex=1)" />
<script>
    document.meScale.<%=ME_SCALE_NUMBER%>.focus();
</script>

<div class="clear"></div>
<div class="division"></div>

<h2> ITEM DETAILS</h2>


<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<th>Sl. No.</th>
		<th>PVMS/NIV No.</th>
		<th>Nomenclature</th>
		<th>A/U</th>
		<th>Qty.</th>
		<th></th>
		<th></th>
		
	</tr>
	
<tr>
		<input type="hidden" name="gridSize" id="gridSize" value="1"/>
	<td>
		
	    <input type="text" value="1" tabindex="1" id="allergyTypeId" size="5"  name=<%=SR_NO%> />
	    
	<td>
	     <input type="text"  name="<%=ITEM_CODE %>" tabindex="1" size="10" id="codeItem1" />
	      <input type="hidden"  name="idItem" tabindex="1" id="idItem1"/>
      
      </td>
      
      </td>
		<td >
      	<input type="text" size="30" value=""	id="nameItem1" onblur="checkForMeScale(this.value, 'nameItem1','1');"  name="nameItem" tabindex="1" />
			<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nameItem1','ac2update','nonExp?method=getItemListForMeScale',{parameters:'requiredField=nameItem'});
			</script>
		</td> 
     
      <td >
      <input type="text" value=""  size="10" readonly="readonly" name="<%=AV%>" id="idAu1" tabindex="1" validate="A/U ,String,no"/>
      </td>
     
	
	
	<td><input type="text" name="qty" tabindex="1" id="qty"  size="10"	maxlength="3"  /></td>
	
	<td>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grid');" tabindex="1" />
	</td>
	<td>
	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid');" tabindex="1" />
	
	</td>
			
		
	</tr>


</table>
 
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="SAVE" class="button" onClick="if(checkForItemDetailsGrid()){submitForm('meScale','pharmacy?method=saveMeScale');}" accesskey="a" tabindex=1/>
<!-- <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('meScale','pharmacy?method=editMeScale')" accesskey="u" tabindex=1 /> -->
<input type="button" name="Print" id="printbutton" value="PRINT" class="button" onClick="submitForm('meScale','pharmacy?method=deleteMeScale&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<div class="clear"></div>

<div class="division"></div>

<div class="clear"></div>
<div class="bottom">
<label>Changed By </label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date </label>   
<label class="value"><%=date%></label>
 
<label>Changed Time </label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
</div> 
    

   
   </form>
 

