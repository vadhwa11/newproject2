<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * manufacturer.jsp  
 * Purpose of the JSP -  This is for Manufacturer.
 * @author  Dipali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>



<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchManufacturerList = (ArrayList)map.get("searchManufacturerList");
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	int itemIdFromBrandPopup = 0;
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	districtList = (ArrayList)map.get("districtList");
	int brandIdFromBrandPopup = 0;
	if(map.get("parameterMap") != null){
		parameterMap = (Map)map.get("parameterMap");
	}
	if(parameterMap.get("itemIdFromBrandPopup") != null){
		itemIdFromBrandPopup = (Integer)parameterMap.get("itemIdFromBrandPopup");
	}
	if(parameterMap.get("brandIdFromBrandPopup") != null){
		brandIdFromBrandPopup = (Integer)parameterMap.get("brandIdFromBrandPopup");
	}
	
	ArrayList gridDistrictList = (ArrayList)map.get("gridDistrictList");
	
	List<MasState> stateList = new ArrayList<MasState>();
	stateList = (ArrayList)map.get("stateList");
	
	
	ArrayList gridStateList = (ArrayList)map.get("gridStateList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	  }
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	
%>
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		</script>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><span><%=message %></span></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Manufacturer Master</h2>
</div>
<div class="clear"></div>
<div id="searcharea">   
<div id="searchbar">
<form name="search" method="post" action=""> 
<div class="Block">
<label>Manufacturer Code </label>      
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="unchecked" tabindex=1 />
<label>Manufacturer Name </label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" checked="checked" tabindex=1/>
    
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Manufacturer Code,name,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchManufacturer')" />
     	<input	type="hidden" name="colCode" value="manufacturer_code"/>
<input	type="hidden" name="colName" value="manufacturer_name"/>
<input type="submit" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchManufacturer','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_manufacturer_list">
</div>
</form>
<div class="clear"></div>
</div>
</div>  
      
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1 >
<div id="searchtable" tabindex=1 ></div>
 
 <% 
  if(searchManufacturerList.size()>0)
   {
   String strForCode = (String)map.get("manufacturerCode");
   String strForCodeDescription = (String)map.get("manufacturerName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
	   
 %>   
 
    <h4> <a  href="pharmacy?method=showManufacturerJsp">Show All Records</a></h4>
 <%
   }
   }
 if(searchManufacturerList.size()==0 && map.get("search") != null)
 {
%>
		 <h4> <a  href="pharmacy?method=showManufacturerJsp">Show All Records</a></h4>

	 <%
  }
	%>


 <script type="text/javascript"> 
 formFields = [
 
				  [0, "<%= COMMON_ID%>", "id"], 
				  [1,"<%= CODE%>"], 
				  [2,"<%= SEARCH_NAME %>"],
				  [3,"<%= CONTACT_PERSON %>"], 
				  [4,"<%= CF_DISTRIBUTOR_NAME %>"],
				  [5,"<%= CF_DISTRIBUTOR_ADDRESS1%>"],
				  [6,"<%= CF_DISTRIBUTOR_ADDRESS2%>"],
				  [7,"<%= ADDRESS1 %>"],
				  [8,"<%= ADDRESS2 %>"],
				  [9,"<%= DISTRICT %>"],
				  [10,"<%= PHONE_NO %>"],
				  [11,"<%= MOBILE_NO %>"],
				  [12,"<%= STATE%>"],
				  [13,"<%= FAX_NO %>"],
				  [14,"<%= URL %>"], 
				  [15,"<%= EMAIL_ID%>"],  
				  [16,"<%= LICENCE_NO %>"],  
				  [17,"<%= SALES_TAX_NO%>"], 
				  [18,"<%= PINCODE%>"],
				  [19,"<%= CHANGED_BY %>"],
				  [20,"<%= CHANGED_DATE %>"],
				  [21,"<%= CHANGED_TIME %>"],
				  [22,"<%=STATUS%>"]];
  
  statusTd = 22;
 
 </script>
 </div>
 <div class="clear"></div>
<form name="manufacturer" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value = "MasManufacturer">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ManufacturerName">
<input type="hidden" name="<%=JSP_NAME %>" value = "manufacturer">
<input type="hidden" name="pojoPropertyCode" value = "ManufacturerCode">
  
<script>
				document.manufacturer.<%=SELECTED_RADIO%>.focus();
</script> 
<div class="clear"></div> 	 
<div class="clear"></div> 	
<div class="Block">
<label class="large"> Manufacturer Code<span>*</span>  </label>
<input id="codeId" type="text"  class="large" name="<%= CODE%>" value=""  validate="Manufacturer Code,alphanumeric,yes"  MAXLENGTH="8" tabindex=1 />
 
<label class="large"> Manufacturer Name <span>*</span> </label>
<input type="text"  class="large" name="<%= SEARCH_NAME %>" value="" validate="Manufacturer Name,alphanumeric,yes"  MAXLENGTH="30" tabindex=1 />
   
<div class="clear"></div>
   
<label class="large"> Contact No.  </label>
<input type="text"    class="large" name="<%= CONTACT_PERSON %>" value="" validate="Contact No.,phone,no"  MAXLENGTH="10" tabindex=1 />
  
<label class="large">C&amp;F/Local Distributor Name</label>
<input type="text"  class="large" name="<%= CF_DISTRIBUTOR_NAME %>" value="" validate="C & F/Local Distributor Name ,name,no"  MAXLENGTH="100" tabindex=1 />
   
<div class="Clear"></div>
   
<label class="large">C&amp;F/Local Distributor Addr.1</label>
<input type="text"  class="large" name="<%= CF_DISTRIBUTOR_ADDRESS1 %>" value="" validate="C & F/Local Distributor Address1 ,string,no"  MAXLENGTH="200" tabindex=1 />
   
<label class="large">C&amp;F/Local Distributor Addr.2</label>
<input type="text"  class="large" name="<%= CF_DISTRIBUTOR_ADDRESS2 %>" value="" validate="C & F/Local Distributor Address2 ,string,no"  MAXLENGTH="200" tabindex=1 />
  
<div class="clear"></div>
  
<label class="large"> Address1</label>
<input type="text"  class="large" name="<%= ADDRESS1 %>" value="" validate="Address1 ,string,no"  MAXLENGTH="200" tabindex=1 />
<label class="large"> Address2</label>
<input type="text"  class="large" name="<%= ADDRESS2 %>" value=""   MAXLENGTH="200" tabindex=1 />
  
<div class="clear"></div>
<label> State  </label>
<select name="<%=STATE%>" validate="State,string,no"      onChange="populateDistrict(this.value,'manufacturer','srcityId')"  tabindex=1>
<option value="0">Select</option>
			 <%

				for(MasState masState : stateList){
				
						%>
					<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
			<%			
					
				}%>
			</select>
    
<label>Phone No</label>
<input type="text" name="<%= PHONE_NO %>"  validate="Phone No ,phone,no" value=""   MAXLENGTH="10" tabindex=1 />
<label>Mobile No</label>
<input type="text" name="<%= MOBILE_NO %>" validate="Mobile No ,phone,no" value=""   MAXLENGTH="10" tabindex=1 />
 	
<div class="clear"></div>
<label >City/District </label>
<select name="<%=DISTRICT%>"  id ="srcityId" validate="District,string,no" tabindex=1>
<option value="0">Select</option>
			<%
				for(MasDistrict masDistrict : districtList){
				%>
							<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
			<%			
				}%>
			</select>	

<label> Fax No.</label>
<input type="text" name="<%= FAX_NO %>" value=""   MAXLENGTH="10" tabindex=1 />
<div class="clear"></div>
<label>URL</label>
<input type="text"  class="large" name="<%= URL %>" value=""   MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label> Email Id</label>
<input type="text" name="<%= EMAIL_ID %>" validate="Email Id ,email,no" value=""   MAXLENGTH="30" tabindex=1 >
   
<label> Licence No</label>
<input type="text" name="<%= LICENCE_NO %>"  validate="Licence No ,string,no" value=""   MAXLENGTH="10" tabindex=1 />
<label>Sales Tax No</label>
<input type="text" name="<%= SALES_TAX_NO %>"  validate="Sales Tax ,string,no" value=""   MAXLENGTH="10" tabindex=1 />
   
<div class="clear"></div>
<label>Pin Code No</label>
<input type="text" name="<%= PINCODE %>"  validate="Pin Code No ,num,no" value=""   MAXLENGTH="8" tabindex=1 />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('manufacturer','pharmacy?method=addManufacturer');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('manufacturer','pharmacy?method=editManufacturer')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('manufacturer','pharmacy?method=deleteManufacturer&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" value ="Reset" class="button" accesskey="r" onclick="clearRecords(this)" tabindex=1 />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
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
		<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
<input type="hidden" name="itemIdFromBrandPopup"  value="<%=itemIdFromBrandPopup%>" />
<input type="hidden" name="brandIdFromBrandPopup"  value="<%=brandIdFromBrandPopup%>" />
</div> 
</form>
 

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Manufacturer Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Manufacturer Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CONTACT_PERSON %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CF_DISTRIBUTOR_NAME%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CF_DISTRIBUTOR_ADDRESS1%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CF_DISTRIBUTOR_ADDRESS2%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=ADDRESS1%>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=ADDRESS2%>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=DISTRICT%>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=PHONE_NO%>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=MOBILE_NO%>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=STATE%>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=FAX_NO %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=URL%>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=EMAIL_ID%>"


data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=LICENCE_NO%>"


data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=SALES_TAX_NO%>"


data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=PINCODE%>"


data_header[18] = new Array;
data_header[18][0] = "Admin"
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=CHANGED_BY%>"

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%= CHANGED_DATE%>"

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%= CHANGED_TIME %>"

data_header[21] = new Array;
data_header[21][0] = "Status"
data_header[21][1] = "data";
data_header[21][2] = "15%";
data_header[21][3] = "<%=STATUS %>";




	data_arr = new Array();
	<%
	Iterator itr=searchManufacturerList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
           {            
             MasManufacturer  masManufacturer = (MasManufacturer)itr.next();       

%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= masManufacturer.getId()%>
		data_arr[<%= counter%>][1] = "<%=masManufacturer.getManufacturerCode()%>"
		data_arr[<%= counter%>][2] = "<%= masManufacturer.getManufacturerName()%>"
		<% if(masManufacturer.getContactPerson()!=null){ %>
		data_arr[<%= counter%>][3] = "<%= masManufacturer.getContactPerson()%>"
		<%}else{%>
		data_arr[<%= counter%>][3] = ""
		<%}%>
		<% if(masManufacturer.getCfLocalDistributorName()!=null){ %>
		data_arr[<%= counter%>][4] = "<%= masManufacturer.getCfLocalDistributorName()%>"
		<%}else{%>
		data_arr[<%= counter%>][4] = ""
		<%}%>
		<% if(masManufacturer.getCfLocalDistributorAddress1()!=null){ %>
		data_arr[<%= counter%>][5] = "<%= masManufacturer.getCfLocalDistributorAddress1()%>"
		<%}else{%>
		data_arr[<%= counter%>][5] = ""
		<%}%>
		<% if(masManufacturer.getCfLocalDistributorAddress2()!=null){ %>
		data_arr[<%= counter%>][6] = "<%= masManufacturer.getCfLocalDistributorAddress2()%>"
		<%}else{%>
		data_arr[<%= counter%>][6] = ""
		<%}%>
		<% if(masManufacturer.getAddress1()!=null){ %>
		data_arr[<%= counter%>][7] = "<%= masManufacturer.getAddress1() %>"
		<%}else{%>
		data_arr[<%= counter%>][7] = ""
		<%}%>
		<% if(masManufacturer.getAddress2()!=null){ %>
		data_arr[<%= counter%>][8] = "<%= masManufacturer.getAddress2() %>"
		<%}else{%>
		data_arr[<%= counter%>][8] = ""
		<%}%>
		
	<%
		Iterator itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {
			 try
			 {
	             MasDistrict  districtGrid = (MasDistrict)itrGridDistrictList.next(); 
				 if(masManufacturer.getCity().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("y")){
				 System.out.println("districtGrid.getDistrictName()---------"+districtGrid.getDistrictName());
	%>
			data_arr[<%= counter%>][9] = "<%=districtGrid.getDistrictName()%>"
			
	<%
	   }else if(masManufacturer.getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("n")){
	%>
		  data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid.getDistrictName()%>";
				
	<%  }
          }catch(Exception e){
        	  System.out.println("Exception----> "+e);
        	  }
       }
    %>


	<%if(masManufacturer.getPhoneno()!=null){%>
		data_arr[<%= counter%>][10] = "<%= masManufacturer.getPhoneno()%>"
		<%}else{%>
		data_arr[<%= counter%>][10] = ""
		<%}%>
		
	<%if(masManufacturer.getMobileno()!=null){%>
		data_arr[<%= counter%>][11] = "<%= masManufacturer.getMobileno()%>"
		<%}else{%>
		data_arr[<%= counter%>][11] = ""
		<%}%>	
	

<%
		Iterator itrGridStateList=gridStateList.iterator();
		 while(itrGridStateList.hasNext())
            {try{
             MasState stateGrid = (MasState)itrGridStateList.next(); 
			 if(masManufacturer.getState().getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("y")){
				 System.out.println("masManufacturer.getState().getId()--"+masManufacturer.getState().getId());
				 System.out.println("stateGrid.getId()---"+stateGrid.getId());
				 System.out.println("INSIDE IF Loop--"+stateGrid.getStateName());
			 %>
				data_arr[<%= counter%>][12] = "<%=stateGrid.getStateName()%>"
			<%}else if(masManufacturer.getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("n")){
				System.out.println("INSIDE ELSE Loop");
			%>
				data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
	
	   <%if(masManufacturer.getFaxNumber()!=null){%>
		data_arr[<%= counter%>][13] = "<%= masManufacturer.getFaxNumber() %>"
		<%}else{%>
		data_arr[<%= counter%>][13] = ""
		<%}%>
		
		<%if(masManufacturer.getUrl()!=null){%>
		data_arr[<%= counter%>][14] = "<%= masManufacturer.getUrl() %>"
		<%}else{%>
		data_arr[<%= counter%>][14] = ""
		<%}%>
		<%if(masManufacturer.getEmailId()!=null){%>
		data_arr[<%= counter%>][15] = "<%= masManufacturer.getEmailId() %>"
		<%}else{%>
		data_arr[<%= counter%>][15] = ""
		<%}%>
		
			<%if(masManufacturer.getLicenceNo()!=null){%>
		data_arr[<%= counter%>][16] = "<%=masManufacturer.getLicenceNo()%>"
		<%}else{%>
		data_arr[<%= counter%>][16] = ""
		<%}%>
	
		<%if(masManufacturer.getSalesTaxNo()!=null){%>
		data_arr[<%= counter%>][17] = "<%=masManufacturer.getSalesTaxNo()%>"
		<%}else{%>
		data_arr[<%= counter%>][17] = ""
		<%}%>
	
		<%if( masManufacturer.getPinCode()!=null){%>
		data_arr[<%= counter%>][18] = "<%= masManufacturer.getPinCode()%>"
		<%}else{%>
		data_arr[<%= counter%>][18] = ""
		<%}%>
	
		data_arr[<%= counter%>][19] = "<%= masManufacturer.getLastChgBy() %>"
		data_arr[<%= counter%>][20] = "<%= HMSUtil.convertDateToStringWithoutTime(masManufacturer.getLastChgDate()) %>"
		data_arr[<%= counter%>][21] = "<%= masManufacturer.getLastChgTime() %>"
		<% if(masManufacturer.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][22] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][22] = "InActive"
		<%}%>
		<%
		       counter++;
		}
		%>
 
	formName = "manufacturer"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
	 end = data_arr.length;
	else
	 end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');  
	</script>


