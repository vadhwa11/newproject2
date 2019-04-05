<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPublisher"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.MasBookCategory"%>
<%@page import="jkt.hms.masters.business.MasBookClass"%>
<%@page import="jkt.hms.masters.business.MasBookSubClass"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script>
function checkSpecialChar(){
var code;
 code = document.getElementById('codeId').value;
 
 var name ;
 name= document.getElementById('search_name').value;
 if(code.match("\"")|| name.match("\"")){
 alert('Please Do not enter " as Entry field')
 return false;
 }else if(code.match("\<")|| name.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
 }
}
</script>
<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasBook> searchBookList = (ArrayList<MasBook>)map.get("searchBookList");
	ArrayList<MasBookCategory> bookCategoryList = (ArrayList<MasBookCategory>)map.get("bookCategoryList");
	ArrayList<MasBookCategory> gridBookCategoryList = (ArrayList<MasBookCategory>)map.get("gridBookCategoryList");
	ArrayList<MasBookClass> bookClassList = (ArrayList<MasBookClass>)map.get("bookClassList");
	ArrayList<MasBookClass> gridBookClassList = (ArrayList<MasBookClass>)map.get("gridBookClassList");
	ArrayList<MasBookSubClass> bookSubClassList = (ArrayList<MasBookSubClass>)map.get("bookSubClassList");
	ArrayList<MasBookSubClass> gridBookSubClassList = (ArrayList<MasBookSubClass>)map.get("gridBookSubClassList");
	ArrayList<MasDepartment> departmentList = (ArrayList<MasDepartment>)map.get("departmentList");
	ArrayList<MasDepartment> gridDepartmentList = (ArrayList<MasDepartment>)map.get("gridDepartmentList");
	ArrayList<MasPublisher> publisherList = (ArrayList<MasPublisher>)map.get("publisherList");
	ArrayList<MasPublisher> gridPublisherList = (ArrayList<MasPublisher>)map.get("gridPublisherList");
	

	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>

<div id="contentHolder">
<div class="Clear"></div>
<h6>Book Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Book
Acc No</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <label>Book Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radio" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Book Acc No,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'lib?method=searchBook')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','lib?method=searchBook','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchBookList.size()>0)
		 {
			String strForCode = (String)map.get("bookCode");
			String strForCodeDescription = (String)map.get("bookName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h5><a href="lib?method=showBookMaster">Show All Records</a></h5>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchBookList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h5><a href="lib?method=showBookMaster">Show All Records</a></h5>
<div class="Clear"></div>
<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= BOOK_CATEGORY_ID %>"],[4,"<%= BOOK_CLASS_ID %>"],[5,"<%= BOOK_SUB_CLASS_ID %>"],[6,"<%= AUTHOR_NAME %>"],[7,"<%= PUBLICATION_YEAR %>"],[8,"<%= PURCHASE_DATE %>"],[9,"<%= EDITION %>"],[10,"<%= LOCATION %>"],[11,"<%= TYPE %>"],[12,"<%= DEPARTMENT_ID %>"],[13,"<%= VOLUME %>"],[14,"<%= PUBLISHER_ID %>"],[15,"<%= PAGES %>"],[16,"<%= PRICE %>"],[17,"<%= CHANGED_BY%>"], [18,"<%= CHANGED_DATE %>"],[19,"<%= CHANGED_TIME %>"],[20,"<%=STATUS%>"] ];
	 statusTd =20;
	</script></div>
<div class="Clear"></div>
<form name="bookClass" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasBook"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BookName">
<input type="hidden" name="title" value="Book"> <input
	type="hidden" name="<%=JSP_NAME %>" value="book"> <input
	type="hidden" name="pojoPropertyCode" value="BookNo">

<div class="division"></div>
<div class="blockFrame"><label class="common"><span>*</span>
Book Acc No.</label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Book Acc No.,string,yes" maxlength="15" tabindex=1 /> <label
	class="common"><span>*</span> Book Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" id="<%=SEARCH_NAME %>" value=""
	validate="Book Name,string,yes" maxlength="150" tabindex=1 /> <script>
				document.bookClass.<%=CODE%>.focus();
			</script> <label class="common"><span>*</span> Book Category Name</label> <select
	name="<%= BOOK_CATEGORY_ID %>" id="<%= BOOK_CATEGORY_ID %>" tabindex=1
	validate="Book Category Name,string,yes"
	onChange="populateBookClass(this.value,'bookClass')" />
	<option value="0">Select</option>
	<% 
    			for (MasBookCategory  masbookCategory : bookCategoryList){
    		%>
	<option value="<%=masbookCategory.getId ()%>"><%=masbookCategory.getBookCategoryName()%></option>

	<%}%>
</select> <script type="text/javascript">
          catArray = new Array();
			<%
			int count = 0;
			for (Iterator iter = bookCategoryList.iterator(); iter.hasNext();) 
			{
				MasBookCategory masbookCategory = (MasBookCategory) iter.next();
				for (Iterator iterBookClass = bookClassList.iterator(); iterBookClass.hasNext();) 
				{
					MasBookClass masbookClass = (MasBookClass) iterBookClass.next();
					if(masbookCategory.getId().equals(masbookClass.getBookCategory().getId())){
								%>
									catArray[<%=count%>] = new Array();
									catArray[<%=count%>][0] = <%=masbookCategory.getId()%>;
									catArray[<%=count%>][1] = <%=masbookClass.getId()%>;									
									catArray[<%=count%>][2] = "<%=masbookClass.getClassName()%>";

								<%
								count++;
						}
					}
				}
			
		%>
		</script>
<div class="Clear"></div>

<label class="common"><span>*</span> Book Class Name</label> <select
	name="<%= BOOK_CLASS_ID %>" id="<%= BOOK_CLASS_ID %>" tabindex=1
	validate="Book Class Name,string,yes"
	onChange="populateBookSubClass(this.value,'bookClass')" />
	<option value="0">Select</option>
	<% 
    			for (MasBookClass  masBookClass : bookClassList){
    		%>
	<option value="<%=masBookClass.getId ()%>"><%=masBookClass.getClassName()%></option>

	<%}%>
</select> <script type="text/javascript">
          classArray = new Array();
		<%
			int count1 = 0;
			for (Iterator iter = bookClassList.iterator(); iter.hasNext();) 
			{
				MasBookClass masbookClass = (MasBookClass) iter.next();
				for (Iterator iterClass = bookSubClassList.iterator(); iterClass.hasNext();) 
				{
					MasBookSubClass subClass = (MasBookSubClass) iterClass.next();
					if(masbookClass.getId().equals(subClass.getBookClass().getId())){
								%>
									classArray[<%=count1%>] = new Array();
									classArray[<%=count1%>][0] = <%=masbookClass.getId()%>;
									classArray[<%=count1%>][1] = <%=subClass.getId()%>;									
									classArray[<%=count1%>][2] = "<%=subClass.getSubClassName()%>";

								<%
								count1++;
						}
					}
				}
			
		%>
		</script> <label class="common"><span>*</span> Book Sub Class Name</label> <select
	name="<%= BOOK_SUB_CLASS_ID %>" id="<%=BOOK_SUB_CLASS_ID %>" tabindex=1
	validate="Book Sub Class Name,string,yes" />
	<option value="0">Select</option>
	<% 
    			for (MasBookSubClass  masbookSubClass : bookSubClassList){
    		%>
	<option value="<%=masbookSubClass.getId ()%>"><%=masbookSubClass.getSubClassName()%></option>

	<%}%>
</select> <label class="common">Author Name</label> <input type="text"
	name="<%=AUTHOR_NAME%>" id="<%=AUTHOR_NAME%>" value="" maxlength="25"
	validate="Author Name,string,no" tabindex="1" />

<div class="Clear"></div>

<label class="common">Year Of Publication</label> <input type="text"
	name="<%=PUBLICATION_YEAR %>" id="<%=PUBLICATION_YEAR %>" value=""
	maxlength="10" validate="Year Of Publication,string,no" tabindex="1" />
<label class="common">Date of Purchase</label> <input type="text"
	class="calDate" id="purchaseDateId" name="<%=PURCHASE_DATE %>"
	value="<%=date %>" readonly="readonly" MAXLENGTH="30" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.bookClass.<%=PURCHASE_DATE%>,event)" />

<label class="common">Edition</label> <input type="text"
	name="<%=EDITION %>" id="<%=EDITION %>" value="" maxlength="15"
	validate="Edition,string,no" tabindex="1" />

<div class="Clear"></div>

<label class="common">Location</label> <input type="text"
	name="<%=LOCATION %>" id="<%=LOCATION %>" value="" maxlength="10"
	validate="Location,string,no" tabindex="1" /> <label class="common">Type</label>
<select name="<%= TYPE %>" id="<%=TYPE %>" tabindex=1
	validate="Type,string,no" />
	<option value="">Select</option>
	<option value="b">Books</option>
	<option value="j">Journal</option>
	<option value="m">Magazine</option>
</select> <label class="common">Books For Department</label> <select
	name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>" tabindex=1
	validate="books For Department,string,no" />
	<option value="0">Select</option>
	<% 
    			for (MasDepartment  masDepartment : departmentList){
    		%>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select>

<div class="Clear"></div>

<label class="common">Volume</label> <input type="text"
	name="<%=VOLUME %>" id="<%=VOLUME %>" value="" maxlength="10"
	validate="Volume,string,no" tabindex="1" /> <label class="common">Publisher
Name</label> <select name="<%= PUBLISHER_ID %>" id="<%= PUBLISHER_ID %>"
	tabindex=1 validate="Publisher Name,string,no" />
	<option value="0">Select</option>
	<% 
    			for (MasPublisher  masPublisher : publisherList){
    		%>
	<option value="<%=masPublisher.getId ()%>"><%=masPublisher.getPublisherName()%></option>

	<%}%>
</select> <label class="common">Pages</label> <input type="text"
	name="<%=PAGES %>" id="<%=PAGES %>" value="" maxlength="10"
	validate="Pages,string,no" tabindex="1" />

<div class="Clear"></div>
<label class="common">Price</label> <input type="text"
	name="<%=PRICE %>" id="<%=PRICE %>" value="" maxlength="8"
	validate="Price,float,no" tabindex="1" /></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=addBook');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=editBook');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('bookClass','lib?method=deleteBook&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>



<div class="Clear"></div>
</form>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Book No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Book Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "District Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=BOOK_CATEGORY_ID %>";

data_header[3] = new Array;
data_header[3][0] = "State Name"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%=BOOK_CLASS_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Pincode"
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%=BOOK_SUB_CLASS_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Address"
data_header[5][1] = "hide";
data_header[5][2] = "40%";
data_header[5][3] = "<%=AUTHOR_NAME %>";

data_header[6] = new Array;
data_header[6][0] = "Address1"
data_header[6][1] = "hide";
data_header[6][2] = "40%";
data_header[6][3] = "<%=PUBLICATION_YEAR %>";

data_header[7] = new Array;
data_header[7][0] = "Address2"
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "<%=PURCHASE_DATE %>";

data_header[8] = new Array;
data_header[8][0] = "Pincode"
data_header[8][1] = "hide";
data_header[8][2] = "40%";
data_header[8][3] = "<%=EDITION %>";

data_header[9] = new Array;
data_header[9][0] = "Address"
data_header[9][1] = "hide";
data_header[9][2] = "40%";
data_header[9][3] = "<%=LOCATION %>";

data_header[10] = new Array;
data_header[10][0] = "Address1"
data_header[10][1] = "hide";
data_header[10][2] = "40%";
data_header[10][3] = "<%=TYPE %>";

data_header[11] = new Array;
data_header[11][0] = "Address2"
data_header[11][1] = "hide";
data_header[11][2] = "40%";
data_header[11][3] = "<%=DEPARTMENT_ID %>";

data_header[12] = new Array;
data_header[12][0] = "Pincode"
data_header[12][1] = "hide";
data_header[12][2] = "40%";
data_header[12][3] = "<%=PUBLISHER_ID %>";

data_header[13] = new Array;
data_header[13][0] = "Pincode"
data_header[13][1] = "hide";
data_header[13][2] = "40%";
data_header[13][3] = "<%=VOLUME %>";

data_header[14] = new Array;
data_header[14][0] = "Address"
data_header[14][1] = "hide";
data_header[14][2] = "40%";
data_header[14][3] = "<%=PAGES %>";

data_header[15] = new Array;
data_header[15][0] = "Address1"
data_header[15][1] = "hide";
data_header[15][2] = "40%";
data_header[15][3] = "<%=PRICE %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= CHANGED_BY %>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%= CHANGED_DATE %>"

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "<%= CHANGED_TIME %>";

data_header[19] = new Array;
data_header[19][0] = "Status"
data_header[19][1] = "data";
data_header[19][2] = "15%";
data_header[19][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasBook> itr=searchBookList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasBook  book = (MasBook)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= book.getId()%>"
data_arr[<%= counter%>][1] = "<%=book.getBookNo()%>"
data_arr[<%= counter%>][2] = "<%=book.getBookName()%>"
<%
		Iterator<MasBookCategory> itrGridBookCatList=gridBookCategoryList.iterator();
		 while(itrGridBookCatList.hasNext())
            {try{
             MasBookCategory  bookCatGrid = (MasBookCategory)itrGridBookCatList.next(); 
			 if(book.getBookCategory().getId().equals(bookCatGrid.getId()) && bookCatGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=bookCatGrid.getBookCategoryName()%>"
			<%}else if(book.getBookCategory().getId().equals(bookCatGrid.getId()) && bookCatGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=bookCatGrid.getBookCategoryName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in MasBookCategory ----> "+e);}}
%>
<%
		Iterator<MasBookClass> itrGridBookClassList=gridBookClassList.iterator();
		 while(itrGridBookClassList.hasNext())
            {try{
            	MasBookClass  bookClassGrid = (MasBookClass)itrGridBookClassList.next(); 
			 if(book.getBookClass().getId().equals(bookClassGrid.getId()) && bookClassGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=bookClassGrid.getClassName()%>"
			<%}else if(book.getBookClass().getId().equals(bookClassGrid.getId()) && bookClassGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=bookClassGrid.getClassName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in MasBookClass ----> "+e);}}
%>
<%
		Iterator<MasBookSubClass> itrGridBookSubClassList=gridBookSubClassList.iterator();
		 while(itrGridBookSubClassList.hasNext())
            {try{
            	MasBookSubClass  bookSubClassGrid = (MasBookSubClass)itrGridBookSubClassList.next(); 
			 if(book.getBookSubClass().getId().equals(bookSubClassGrid.getId()) && bookSubClassGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=bookSubClassGrid.getSubClassName()%>"
			<%}else if(book.getBookSubClass().getId().equals(bookSubClassGrid.getId()) && bookSubClassGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=bookSubClassGrid.getSubClassName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in MasBookSubClass ----> "+e);}}
%>

<%if(book.getAuthorName() != null){%>
data_arr[<%= counter%>][6] = "<%= book.getAuthorName()%>"
<%}else{%>
data_arr[<%= counter%>][6] ="-"
<%}%>
<%if(book.getYearPublication() != null){%>
data_arr[<%= counter%>][7] = "<%=book.getYearPublication()%>"
<%}else{%>
data_arr[<%= counter%>][7] ="-"
<%}%>
<%if(book.getPurchaseDate() != null){%>
data_arr[<%= counter%>][8] = "<%=HMSUtil.convertDateToStringWithoutTime(book.getPurchaseDate())%>"
<%}else{%>
data_arr[<%= counter%>][8] = "-"
<%}%>
<%if(book.getEdition() != null){%>
data_arr[<%= counter%>][9] = "<%= book.getEdition()%>"
<%}else{%>
data_arr[<%= counter%>][9] ="-"
<%}%>
<%if(book.getLocation() != null){%>
data_arr[<%= counter%>][10] = "<%=book.getLocation()%>"
<%}else{%>
data_arr[<%= counter%>][10] ="-"
<%}%>
<%if(book.getTypes() !=null){%>
data_arr[<%= counter%>][11] = "<%=book.getTypes()%>"
<%}else{%>
data_arr[<%= counter%>][11] = "-"
<%}%>
<%
		Iterator<MasDepartment> itrGridDeptList=gridDepartmentList.iterator();
		 while(itrGridDeptList.hasNext())
            {try{
            	MasDepartment  deptGrid = (MasDepartment)itrGridDeptList.next(); 
			 if(book.getDepartment().getId().equals(deptGrid.getId()) && deptGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][12] = "<%=deptGrid.getDepartmentName()%>"
			<%}else if(book.getDepartment().getId().equals(deptGrid.getId()) && deptGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=deptGrid.getDepartmentName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in MasDepartment ----> "+e);}}
%>
<%if(book.getTypes() != null){%>
data_arr[<%= counter%>][13] = "<%=book.getVolume()%>"
<%}else{%>
data_arr[<%= counter%>][13] ="-"
<%}%>
<%
		Iterator<MasPublisher> itrGridPubList=gridPublisherList.iterator();
		 while(itrGridPubList.hasNext())
            {try{
            	MasPublisher  pubGrid = (MasPublisher)itrGridPubList.next(); 
			 if(book.getPublisher().getId().equals(pubGrid.getId()) && pubGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][14] = "<%=pubGrid.getPublisherName()%>"
			<%}else if(book.getPublisher().getId().equals(pubGrid.getId()) && pubGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][14] = "<font id='error'>*</font>Parent InActivated--<%=pubGrid.getPublisherName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in MasPublisher ----> "+e);}}
%>
<%if(book.getPrice() != null){%>
data_arr[<%= counter%>][15] = "<%=book.getPages()%>"
<%}else{%>
data_arr[<%= counter%>][15] =""
<%}%>
<%if(book.getPrice() != null){%>
data_arr[<%= counter%>][16] = "<%=book.getPrice()%>"
<%}else{%>
data_arr[<%= counter%>][16] =""
<%}%>
data_arr[<%= counter%>][17] = "<%=book.getLastChgBy() %>"
data_arr[<%= counter%>][18] = "<%= HMSUtil.convertDateToStringWithoutTime(book.getLastChgDate()) %>"
data_arr[<%= counter%>][19] = "<%= book.getLastChgTime() %>"
<% if(book.getStatus().equals("y")){ %>
data_arr[<%= counter%>][20] = "Active"
<%}else{%>
data_arr[<%= counter%>][20] = "InActive"
<%}%>
<%
		     counter++;
}
          
%>
 
formName = "bookClass"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
