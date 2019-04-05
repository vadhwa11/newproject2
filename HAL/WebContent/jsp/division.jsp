
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDivision"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDivisionList = (ArrayList)map.get("searchDivisionList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <% }%>
<div class="titleBg">
<h2>Division Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Division Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Division Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Division Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchDivision')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchDivision','checkSearch')"	tabindex="1" />
<%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex="1" />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_division">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchDivisionList.size()>0)
		 {
			String strForCode = (String)map.get("divisionCode");
			String strForCodeDescription = (String)map.get("divisionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h2><a href="generalMaster?method=showDivisionJsp">Show All Records</a> </h2>
<%
			}
		 }
	 if(searchDivisionList.size()==0 && map.get("search") != null)
	  {
	 %> <h2><a href="generalMaster?method=showDivisionJsp">Show All Records</a> </h2>
	 <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"cla"],[7,"dila"],[8,"dela"],[9,"nsaa"],[10,"dla"],[11,"dlh"],[12,"<%=STATUS%>"] ];
	 statusTd = 9;
	 </script>
	</div>
<div class="Clear paddingTop15"></div>	
<form name="division" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasDivision">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DivisionName">
<input type="hidden" name="title" value="Division">
<input type="hidden" name="<%=JSP_NAME %>" value="division">
<input type="hidden" name="pojoPropertyCode" value="DivisionCode"> 
<div class="Clear"></div>
<div class="Block">
<label > Division Code <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Division Code,string,yes"	 MAXLENGTH="8" tabindex=1 />
<label> Division Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Division Name,string,yes" MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=addDivision')">
<script>
document.division.<%=CODE%>.focus();
</script> 


<div class="Clear"></div>


<label>Covering Letter Authority</label>
<textarea rows="" cols="" name="cla" 	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex=""  ></textarea>

<label>Dispatch Letter Authority</label>
<textarea rows="" cols="" name="dla" 	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex=""  ></textarea>

<label>Dispatch Letter Header</label>
<textarea rows="" cols="" name="dlh" 	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex=""  ></textarea>



<label>Divisional Letter Authority</label>
<textarea rows="" cols="" name="dila" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500"></textarea>


	<label>Notesheet Signature Authority</label>
<textarea rows="" cols="" name="nsaa" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500"></textarea>
	
	<label>Diet Letter Authority</label>
<textarea rows="" cols="" name="dela" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,string,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500"></textarea>
	
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('division','generalMaster?method=addDivision');"accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('division','generalMaster?method=editDivision')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('division','generalMaster?method=deleteDivision&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Division Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Division Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Covering Letter Authority"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "cla";



data_header[6] = new Array;
data_header[6][0] = "Divisional Letter Authority"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "dila";



data_header[7] = new Array;
data_header[7][0] = "Diet Letter Authority"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "dela";

data_header[8] = new Array;
data_header[8][0] = "Notesheet Signature Authority"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "nsaa";

data_header[9] = new Array;
data_header[9][0] = "Dispatch Signature Authority"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "dla";

data_header[10] = new Array;
data_header[10][0] = "Dispatch Signature Authority"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "dlh";

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchDivisionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDivision  masDivision = (MasDivision)itr.next(); 
             
			%>data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDivision.getId()%>
data_arr[<%= counter%>][1] = "<%=masDivision.getDivisionCode()%>"
data_arr[<%= counter%>][2] = "<%= masDivision.getDivisionName()%>"
data_arr[<%= counter%>][3] = "<%= masDivision.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masDivision.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masDivision.getLastChgTime() %>"
	<%

	String coveringLA=masDivision.getCoveringLetterAuthority()!=null?masDivision.getCoveringLetterAuthority():"";
	coveringLA = coveringLA.replace("\r", "$");
	coveringLA = coveringLA.replace("\n", "^");

	%>

	var coveringLA = "<%=coveringLA%>";		
	coveringLA = coveringLA.split('$').join("\r");
	coveringLA = coveringLA.split('^').join("\n");	  
	  

	data_arr[<%= counter%>][6] = coveringLA;
	
	
	<%

	String divisionLA=masDivision.getDivisionalLetterAuthority()!=null?masDivision.getDivisionalLetterAuthority():"";
	divisionLA = divisionLA.replace("\r", "$");
	divisionLA = divisionLA.replace("\n", "^");

	%>

	var divisionLA = "<%=divisionLA%>";		
	divisionLA = divisionLA.split('$').join("\r");
	divisionLA = divisionLA.split('^').join("\n");	  
	  

	data_arr[<%= counter%>][7] = divisionLA;
	

	<%

	String dietLA=masDivision.getDietLetterAuthority() !=null?masDivision.getDietLetterAuthority():"";
	dietLA = dietLA.replace("\r", "$");
	dietLA = dietLA.replace("\n", "^");

	%>

	var dietLA = "<%=dietLA%>";		
	dietLA = dietLA.split('$').join("\r");
	dietLA = dietLA.split('^').join("\n");	  
	  

	data_arr[<%= counter%>][8] = dietLA;
	
		
		
				<%

				String noteSheetSA=masDivision.getNoteSheetSignatureAuthority() !=null?masDivision.getNoteSheetSignatureAuthority():"";
				noteSheetSA = noteSheetSA.replace("\r", "$");
				noteSheetSA = noteSheetSA.replace("\n", "^");

				%>

				var noteSheetSA = "<%=noteSheetSA%>";		
				noteSheetSA = noteSheetSA.split('$').join("\r");
				noteSheetSA = noteSheetSA.split('^').join("\n");	  
				  
			
				data_arr[<%= counter%>][9] = noteSheetSA;
				
				
				<%

				String dipatchLA=masDivision.getDispatchLetterAuthority() !=null?masDivision.getDispatchLetterAuthority():"";
				dipatchLA = dipatchLA.replace("\r", "$");
				dipatchLA = dipatchLA.replace("\n", "^");

				%>

				var dipatchLA = "<%=dipatchLA%>";		
				dipatchLA = dipatchLA.split('$').join("\r");
				dipatchLA = dipatchLA.split('^').join("\n");	  
				  
			
				data_arr[<%= counter%>][10] = dipatchLA;
				
				<%

				String dipatchH=masDivision.getDispatchLetterHeader() !=null?masDivision.getDispatchLetterHeader():"";
				dipatchH = dipatchH.replace("\r", "$");
				dipatchH = dipatchH.replace("\n", "^");

				%>

				var dipatchH = "<%=dipatchH%>";		
				dipatchH = dipatchH.split('$').join("\r");
				dipatchH = dipatchH.split('^').join("\n");	  
				  
			
				data_arr[<%= counter%>][11] = dipatchH;
				
<% if(masDivision.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "division"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
