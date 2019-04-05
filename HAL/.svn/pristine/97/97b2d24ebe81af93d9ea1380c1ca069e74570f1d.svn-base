
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>


<script  type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

	<%
	//Object[] obj=null;
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}	
 			
 			List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
 		List<MasItemCategory> subSectionList = new ArrayList<MasItemCategory>();
 		Map<String, Object> vedItem = new HashMap<String, Object>();
 		List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
 		System.out.println(map.get("searchStoreIndentMList"));
 		if(map.get("searchStoreIndentMList")!= null){
 			searchStoreIndentMList = (List<StoreIndentM>)map.get("searchStoreIndentMList");
 			//System.out.println("------size----->"+searchStoreIndentMList.size());
 			//System.out.println("-------indentNo---->"+searchStoreIndentMList.get(0).getIndentNo());
 			//System.out.println("------id---->"+searchStoreIndentMList.get(0).getId());

 		}
 		List objectList = new ArrayList();
 		if (vedItem.get("objectList") != null) {
 			objectList = (List)vedItem.get("objectList");
 			System.out.println("objectList in jsp "+objectList.size());

 		}
 		
 		
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
		String message ="";
		 //System.out.println("--1----- "+surplusItemList.get("msg"));
		
		 // javed khan 28 march
		 List objectList2 = new ArrayList();
		 if (map.get("objectList2") != null) {
		objectList2 = (List)map.get("objectList2");
		System.out.println("objectList in jsp "+objectList2.size());

	}
		 String lifeType="";

		 if(map.get("lifeType") !=null){
				lifeType =""+ map.get("lifeType");
				System.out.println("lifeType>"+lifeType);
				}
		 
		 // javed khan 28 march	
		 
		 String section="0";
		  if(map.get("section") !=null){
				section =""+ map.get("section");
				System.out.println("section pending >"+section);
				}
		 
		 
		 if(map.get("sectionList")!=null)
	storeSectionList = (List<MasStoreSection>)map.get("sectionList");
		
		
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
			</script> <script>
function aa()
{
    if ( document.PvmsNivMasterReport.<%=SECTION_ID%>.checked == true )
    {
    	document.getElementById("sectionList").style.display='inline';
    	document.getElementById("subSectionList").style.display='none';
    	document.getElementById("SubSectionWise").checked=false;
    }
    else
    {
    	document.getElementById("sectionList").style.display='none';
    }
 }
 
function bb()
{    if ( document.getElementById('SubSectionWise').checked == true )
    {
    	document.getElementById("subSectionList").style.display='inline';
    	document.getElementById("sectionList").style.display='none';
    	document.getElementById("SectionWise").checked=false;
    }
    else
    {
    	document.getElementById("subSectionList").style.display='none';
    }
 }
</script> 

<script type="text/javascript" language="javascript">
function clearButton(formName)
{
obj = eval('document.'+formName)
obj.action = "/hms/hms/stores?method=vedAnalysisReport";
obj.submit();
}
function fillValues(){
	//alert("in fill");
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=j');
    
}
function fillValues1(){
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=p');
    
}
</script>
<%if(!message.equals("")){
	
	%>
<h4><%=message %></h4>
<%} %>


<div class="titleBg">
<h2>Items Pending For Indent</h2>
</div>
<form name="pendingForIndent" method="post" action="">
<input type="hidden"  name="lifeType" id="lifeType"  value="<%=lifeType %>" />
 <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					 System.out.println(masStoreSection.getId()+"  out  "+section);
					  if(masStoreSection.getId()==Integer.parseInt(section)){
						  System.out.println(masStoreSection.getId()+" in "+section+" -- "+masStoreSection.getSectionName());
				  %>
				  <input type="hidden" id="sectionId1" name="sectionId" value="<%=masStoreSection.getId()%>" />
				  <%}} %>
				  
				  <!-- comment by javed khan for merging indent 29 may -->
<%-- 

<label > Life Span</label>

<select name="lifeType" id="lifeType" onChange="" tabindex=1
	validate=" Life Span,String,yes">
	<%if(lifeType.equals("")){ %> <!-- javed 28 -->
	<option value="a">Select</option>
	<option value="SL">SL</option>
	<!-- <option value="SLB">SLB</option> -->
	<option value="LL">LL</option>
	<% }else if(!lifeType.equals("a")){%> <!-- javed 28 -->
	<option value="<%=lifeType %>"><%=lifeType %></option>
	<option value="a">Select</option>
	<option value="SL">SL</option>
	<!--<option value="SLB">SLB</option>-->
	<option value="LL">LL</option>
	<%}else{ %> 
	<option value="<%=lifeType %>">Select</option>
	<option value="SL">SL</option>
	<!--<option value="SLB">SLB</option>-->
	<option value="LL">LL</option>
	<%} %>
	
	
	
	<!-- javed 28 -->
	</select>
	
	<!-- javed add section  -->
	<div class="clear"></div>
	<label>Section</label>
<%if(!section.equals("0") && !section.equals("")){%>
				<select id="sectionId1" name="sectionId"   onchange="" tabindex=1>
			
				
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					 System.out.println(masStoreSection.getId()+"  out  "+section);
					  if(masStoreSection.getId()==Integer.parseInt(section)){
						  System.out.println(masStoreSection.getId()+" in "+section+" -- "+masStoreSection.getSectionName());
				  %>
				  <option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
				  <%}} %>
				  <option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				  	</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="" tabindex=1>

				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>
	
	
	
	 <input type="button" name="add" id="addbutton" value="Display Item" class="button" onClick="submitProtoAjax('pendingForIndent','stores?method=getPendingForIndentData&batchId='+document.getElementById('<%="lifeType"%>').value);" accesskey="a" tabindex=1 /> 
	<input type="button" name="add" id="addbutton" value="Display Item" class="button" onClick="submitForm('pendingForIndent','stores?method=getPendingForIndentData&batchId='+document.getElementById('<%="lifeType"%>').value);" accesskey="a" tabindex=1 />
	<% if (searchStoreIndentMList.size()>0){ %> 
	<input type="button" name="add" id="addbutton" value="Import Previous Indent" class="buttonBig" onClick="submitForm('pendingForIndent','stores?method=getIndentDepotDate&<%=INDENT_NO%>='+<%=searchStoreIndentMList.get(0).getId()%>);" accesskey="a" tabindex=1 />
	<%} %>
	
	<input type="button" name="add" id="addbutton" value="New Indent" class="button" onClick="submitForm('pendingForIndent','stores?method=showIndentJspDepot');" accesskey="a" tabindex=1 />
	--%>
	
	
	
	
	
	
			<!--    javed khan 28 march -->
			
			<!-- <div id="testDiv">
			</div> -->
			<div class="clear"></div>
					<!--  <input type="button" name="add23" id="addbutton" value="Select All" class="button" onClick="selectToggle('pendingForIndent');;" accesskey="a" tabindex=1 /> -->
			<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('pendingForIndent','stores?method=createIndent&flag='+ document.getElementById('lifeType').value);" accesskey="a" tabindex=1 />
			<div class="clear"></div>
			<%if(objectList2.size()>0){ %>
<!-- <table  width="100%" id="main"> -->
<div class="cmntableWithHeight">

 <table width="92%" colspan="7" id="grnDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		
			
			<th width="1%">Sl No.</th>
			<th width="10%">PVMS/ <br/>NIV No.</th>
			<th width="25%">Nomenclature</th>
			<th width="15%">A/U</th>
			
			<th width="10%">Life <br/>Span</th>
			<th width="5%">MMF</th>
			<th width="15%">Current Stock</th>
			<th width="15%">Qty Demanded</th>
			<th width="1%">Select <br/>All<input type="checkbox"  onClick="selectToggle('pendingForIndent');" />
			</th>
			
		</tr>
	</thead>

	<% if(objectList2.size()>0 && !lifeType.equals("a") ){int sr=0;
		for(int i=0; i<objectList2.size() ; i++){
			sr++;
			Object[]	ob=(Object[])objectList2.get(i);
			
			
			//r= r+((BigDecimal)ob[2]).intValue();
			// int closing=r-((BigDecimal)ob[3]).intValue();
			// r=closing;
			%>	
	
	
<tr>
<input type="hidden" value="<%=ob[3]%>" name="item_id" id="item_id<%=sr%>" />

<td width="1%"><input type="text" value="<%=sr%>" name="sr" id="sr" readonly="readonly" size="2"/></td>
<td width="8%"><input type="text" value="<%= ob[2]%>" name="pvms<%=sr%>" id="pvms<%=sr%>" readonly="readonly" size="8"/>
<input type="hidden" value="<%=ob[6]%>" name="itemId<%=sr%>" id="itemId<%=sr%>" />
</td>
<td width="25%"><input type="text" value="<%=ob[1]%>" name="nomen<%=sr%>" id="nomen<%=sr%>" readonly="readonly" size="70"/>
<input type="hidden" value="<%=ob[7]%>" name="sect<%=sr%>" id="sect<%=sr%>" />
</td>
<td width="15%"><input type="text" value="<%=ob[5]%>" name="au<%=sr%>" id="au<%=sr%>" readonly="readonly"/ size="5"></td>
<td width="10%"><input type="text" value="<%=lifeType%>" class="small" name="lifeType<%=sr%>" id="lifeType<%=sr%>" readonly="readonly" size="3"/></td>
<td width="5%"><input type="text" value="<%=ob[3]%>" name="mmf<%=sr%>" id="mmf<%=sr%>" readonly="readonly"/ size="5"></td>
<td width="15%"><input type="text" value="<%=ob[4]%>" name="stock<%=sr%>" id="stock<%=sr%>" readonly="readonly"/ size="10"></td>
<% 
int indentQty=0;
int mmfForIndent=0;
int mmf=((BigDecimal)ob[3]).intValue();

							int closingStock=((BigDecimal)ob[4]).intValue();
							if(lifeType.equals("SLB")){
							 mmfForIndent=6*mmf;
							}else if(lifeType.equals("SL")){
								mmfForIndent=6*mmf;
							}else if(lifeType.equals("LL"))
							{
								mmfForIndent=9*mmf;
							}
							if(mmfForIndent>closingStock)
							{
								//System.out.println("IN IF");
								indentQty=mmfForIndent-closingStock;
								 //objectList1.add(indentQty);
							}
							else{
								System.out.println("IN ELSE");
								//objectList1.remove(iterator.next());
							}
							%>
 <td width="15%"><input type="text" value="<%=indentQty%>" name="demand<%=sr%>" size="5" id="demand<%=sr%>" readonly="readonly"/></td>
 <td width="2%">
			<input type="checkbox" size="15" name="require<%=sr%>" id="require<%=sr%>" value="y"  />
	</td>
</tr>
<%}}else{ int sr=0;
		for(int i=0; i<objectList2.size() ; i++){
			sr++;
			Object[]	ob=(Object[])objectList2.get(i);
			//System.out.println(" object trn-- "+ob[0]+"  "+ob[1]+"  "+ob[2]+"  "+ob[3]+"  "+ob[4]+" "+ob[6]);
			
			//r= r+((BigDecimal)ob[2]).intValue();
			// int closing=r-((BigDecimal)ob[3]).intValue();
			// r=closing;
			%>	
	
	
<tr>
<input type="hidden" value="<%=ob[3]%>" name="item_id" id="item_id<%=sr%>" />
<td width="1%">
			<input type="checkbox" size="15" name="require<%=sr%>" id="require<%=sr%>" value="y"  />
			</td>
<td width="1%"><input type="text" value="<%=sr%>" name="sr" id="sr" readonly="readonly" size="2"/></td>
<td width="10%"><input type="text" value="<%= ob[2]%>" name="pvms<%=sr%>" id="pvms<%=sr%>" readonly="readonly" size="10"/>
<input type="hidden" value="<%=ob[6]%>" name="itemId<%=sr%>" id="itemId<%=sr%>" />
</td>
<td width="25%"><input type="text" value="<%=ob[1]%>" name="nomen<%=sr%>" id="nomen<%=sr%>" readonly="readonly" size="100"/>
<input type="hidden" value="<%=ob[7]%>" name="sect<%=sr%>" id="sect<%=sr%>" />
</td>
<td width="15%"><input type="text" value="<%=ob[5]%>" name="au<%=sr%>" id="au<%=sr%>" readonly="readonly"/ size="20"></td>
<td width="10%"><input type="text" value="<%=ob[8]%>" name="lifeType<%=sr%>" id="lifeType<%=sr%>" readonly="readonly" size="3"/></td>
<td width="5%"><input type="text" value="<%=ob[3]%>" name="mmf<%=sr%>" id="mmf<%=sr%>" readonly="readonly"/ size="5"></td>
<td width="15%"><input type="text" value="<%=ob[4]%>" name="stock<%=sr%>" id="stock<%=sr%>" readonly="readonly"/ size="10"></td>

<% 
int indentQty=0;
int mmfForIndent=0;
int mmf=((BigDecimal)ob[3]).intValue();

							int closingStock=((BigDecimal)ob[4]).intValue();
							if((""+ob[8]).equals("SLB")){
							 mmfForIndent=6*mmf;
							}else if((""+ob[8]).equals("SL")){
								mmfForIndent=6*mmf;
							}else if((""+ob[8]).equals("LL"))
							{
								mmfForIndent=9*mmf;
							}
							if(mmfForIndent>closingStock)
							{
								//System.out.println("IN IF");
								indentQty=mmfForIndent-closingStock;
								 //objectList1.add(indentQty);
							}
							else{
								System.out.println("IN ELSE");
								//objectList1.remove(iterator.next());
							}
							%>
 <td width="15%"><input type="text" value="<%=indentQty%>" name="demand<%=sr%>" size="25"  id="demand<%=sr%>" readonly="readonly"/></td>
 <td width="2%">
			<input type="checkbox" size="15" name="require<%=sr%>" id="require<%=sr%>" value="y"  />
	</td>
	
</tr>
<%} }%>
<input type="hidden" name="hdb1" value="1" id="hdb1" />
</table>
<%} %>
			
	<!--    javed khan 28 march -->		
			
 </div>
<div class="clear"></div>
<div class="clear"></div>
 <div class="division"></div>
 <%if(objectList2.size()==0){ %>
<div style="padding-left: 170px;">
<%}%>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('pendingForIndent','stores?method=createIndent&flag='+ document.getElementById('lifeType').value);" accesskey="a" tabindex=1 />
 
</div>

<!-- <input type="button" name="add" id="addbutton" value="Excel" class="button" onClick="submitForm('pendingForIndent','stores?method=vedAnalysisJspReport&flag=e');" accesskey="a" tabindex=1 /> -->  
<!--<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('pendingForIndent');" accesskey="a" tabindex=1 />-->
</form>
<script type="text/javascript">
function selectToggle(form) {
    var myForm = document.forms[form];
    for( var i=0; i < myForm.length; i++ ) { 
              
              if(myForm.elements[i].checked== true){
                  myForm.elements[i].checked = "";
                  
              }else {
            	  myForm.elements[i].checked = "checked";
              } 
    }
}


 function checkSection(){
	 var sectionId=document.getElementById('sectionListId').value
	 var subSectionId=document.getElementById('subSectionListId').value
	 if((sectionId !=0 || sectionId != "") && (subSectionId !=0 || subSectionId != "")){
		 alert("Either Select Section or Sub Section..."); 
	 }
 }
 </script>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items Pending For Indent</title>
</head>
<body>

</body>
</html>