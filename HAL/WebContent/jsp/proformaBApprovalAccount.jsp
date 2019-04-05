
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
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
 		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
 		List<StoreProformaHeader> storeProformaHList = new ArrayList<StoreProformaHeader>();
 		System.out.println(map.get("hospitalList"));
 		if(map.get("hospitalList")!= null){
 			hospitalList = (List<MasHospital>)map.get("hospitalList");
 			//System.out.println("------size----->"+searchStoreIndentMList.size());
 			//System.out.println("-------indentNo---->"+searchStoreIndentMList.get(0).getIndentNo());
 			//System.out.println("------id---->"+searchStoreIndentMList.get(0).getId());

 		}
 		if(map.get("storeProformaHList")!= null){
 			storeProformaHList = (List<StoreProformaHeader>)map.get("storeProformaHList");


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

<h2>Proforma B A/C Pending for Approval</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<form name="proformaApproval" method="post" action="">
<div class="Block">
<label   class="auto_text" > Total Pending</label>
<% if(storeProformaHList.size() > 0){ %>
<input type="text" name="pending" id="pending" value="<%=storeProformaHList.size() %>" readonly maxlength="30" tabindex=1 />
<%}else{ %>
<input type="text" name="pending" id="pending" value="0" readonly maxlength="30" tabindex=1 />
<%} %>
	<!-- javed add section  -->

	<label class="auto_text" >Select Units</label>
	<select id="unit" name="unit" class="large"   onchange=""  MAXLENGTH="25" tabindex=1>

	<%--
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
				<%}else{%>--%>


				<option value="0">Select</option>
				  <%
				  for(MasHospital masHospital : hospitalList) {
				  %>
				  <option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
				  <%}%>
				</select>
					<%--<% }%> --%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>




	<!-- <input type="button" name="add" id="addbutton" value="Display" class="button" onClick="submitForm('proformaApproval','stores?method=getPendingForIndentData&batchId='+document.getElementById('<%="lifeType"%>').value);" accesskey="a" tabindex=1 />
	 -->
	 
	 </div>
	 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
			
<input type="button" name="add" id="addbutton" value="Display" class="button" onClick="if(chk()){submitForm('proformaApproval','stores?method=getPendingProformaForApprovalAccont')};" accesskey="a" tabindex=1 />

	


 <!--
 <input type="button" name="add23" id="addbutton" value="Select All" class="button" onClick="selectToggle('pendingForIndent');;" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('pendingForIndent','stores?method=createIndent&flag='+ document.getElementById('lifeType').value);" accesskey="a" tabindex=1 />
 -->


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
 function chk(){
	 var unitId=document.getElementById('unit').value
	 //var subSectionId=document.getElementById('subSectionListId').value
	 if((unitId ==0) ){
		 alert(" Select Unit...");
		 return false;
	 }
	 return true ;
 }
 </script>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="jkt.hms.masters.business.StoreProformaHeader"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profroma B Approval</title>
</head>
<body>

</body>
</html>