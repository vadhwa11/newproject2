<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<form name="searchIndentToDepo" method="post">
<div class="titleBg"><h2>Indent TO DEPOT</h2></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
List<StoreIndentM> searchStoreIndentMExistList = new ArrayList<StoreIndentM>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if(map.get("searchStoreIndentMList")!= null){
	searchStoreIndentMList = (List<StoreIndentM>)map.get("searchStoreIndentMList");
}

if(map.get("searchStoreIndentMExistList")!= null){
	searchStoreIndentMExistList = (List<StoreIndentM>)map.get("searchStoreIndentMExistList");
	//System.out.println("this is on jsp"+searchStoreIndentMExistList.size());
}

int deptId = 0;
if(session.getAttribute("deptId") != null)
{
	deptId = Integer.parseInt(""+session.getAttribute("deptId"));
}
List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
if(map.get("sectionList")!=null)
	storeSectionList = (List<MasStoreSection>)map.get("sectionList");
%>
<div class="Block">
<label class="auto">Import Previous Indent</label>
<input type="radio" name="indentType" id="indentType" value="old" class="radioAuto" checked="checked" onclick="displayField(this.value);"/>
<div id="dmdNoDiv" >
<label class="noWidth"> Indent No. </label>
<select id="demandNo" name="<%=INDENT_NO%>">

	<%
		for (StoreIndentM mObj :searchStoreIndentMList ) {
	%>
	<option value=<%=mObj.getId()%>><%=mObj.getIndentNo()%></option>
	<%
		}
	%>
</select>

<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
</div>
<label>Create New Indent</label>
<input type="radio" name="indentType" id="indentType" value="new" class="radioAuto" onclick="displayField(this.value);" />


<label class="auto">Add Items to Existing Indent</label>
<input type="radio" name="indentType" id="indentType" value="exist" class="radioAuto" checked="checked" onclick="displayField(this.value);" />
<input type="hidden" name="existingIndentSize" id="existingIndentSize" value="<%=searchStoreIndentMExistList.size()%>" />
<%if(searchStoreIndentMExistList.size()> 0){ %>
<input type="hidden" name="existingIndent" id="existingIndent"  value="<%=searchStoreIndentMExistList.get(0).getId()%>" />
<%} %>
<div class="clear"></div>
<div class="clear"></div>
<label class="auto_text"> Life Span</label>

<select name="lifeType" id="lifeType" onChange="" tabindex=1
	validate=" Life Span,String,no">
	
	<option value="a">Select</option>
	
	<!-- <option value="SLB">SLB</option> -->
	<option value="LL">LL</option>
	<option value="SL">SL</option>
	</select>
	
	<!-- javed add section  -->
	
	<label>Section</label>

				<select id="sectionId1" name="sectionId"   onchange="" tabindex=1>
			  <option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				  	</select>






</div>
<div class="Clear"></div>
<div class="division"></div>
<input name="Button2" type="button" class="buttonSm" value="Ok" onclick="checkIndentType()"/>
<div class="Clear"></div>
<div class="division"></div>
<script type="text/javascript">
function checkIndentType(){
	for(var i = 0; i < document.getElementsByName('indentType').length; i++){
  		if(document.getElementsByName('indentType')[i].checked == true)
           {
  			if(document.getElementsByName('indentType')[i].value == "new"){
  				var span = document.getElementById('lifeType').value;
  				var sec = document.getElementById('sectionId1').value;
  				//alert(span+"----------"+sec)
  	  			if(document.getElementById('existingIndentSize').value>0 ){
  	  	  		   alert("Please first submit existing indent then create new indent.")
  	  			}else{
  	  	  			if(span == "a" && sec == "0"){
  	  	  			//alert("not")
  				submitForm('searchIndentToDepo','/hms/hms/stores?method=showIndentJspDepot');
  	  	  			}else{
  	  	  			//alert("yes")
  	  	  			//submitForm('searchIndentToDepo','/hms/hms/stores?method=getPendingForIndentData&batchId='+span);
  	  	  			submitForm('searchIndentToDepo','/hms/hms/stores?method=showIndentJspDepot');
  	  			}
  	  			}
  	  			}else if(document.getElementsByName('indentType')[i].value == "old") {
  	  			var demandNo = document.getElementById('demandNo').value;
  	  			if(demandNo != ""){
  	  			if(document.getElementById('existingIndentSize').value>0 ){
   	  	  		   alert("Please first submit existing indent then create new indent.")
   	  			}else{	
  	  			submitForm('searchIndentToDepo','stores?method=getIndentDepotDate&<%=INDENT_NO%>='+demandNo);
   	  			}
  	  			}
  	  			else{

					alert("Please select Indent No.");
  	  	  		}
  			}
  			else{
  				var existingIndent= document.getElementById('existingIndentSize').value ;
  				
  				if(existingIndent >0){
  					var demandNo= document.getElementById('existingIndent').value ;
  			
  	  			submitForm('searchIndentToDepo','stores?method=getIndentDepotDate&<%=INDENT_NO%>='+demandNo);
  				}
  				else{
  					alert("Selected indent is already closed.Please select other indent.");
  	  				
  				}
           }
	}

}
	}
function displayField(val){
	if(val == "old"){
		document.getElementById('dmdNoDiv').style.display = 'inline';
	}else if(val == "new"){
		document.getElementById('dmdNoDiv').style.display = 'none';
	}else if(val == "exist"){
		document.getElementById('dmdNoDiv').style.display = 'inline';
	}
}

</script>
</form>