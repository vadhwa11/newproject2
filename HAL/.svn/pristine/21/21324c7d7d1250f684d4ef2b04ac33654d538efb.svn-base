<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasBook"%>
<%@page import="jkt.hms.masters.business.MasPublisher"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasBookCategory"%>
<%@page import="jkt.hms.masters.business.MasBookClass"%>
<%@page import="jkt.hms.masters.business.MasBookSubClass"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<%

		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();

	 	int deptId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		ArrayList<MasBookCategory> bookCategoryList = (ArrayList<MasBookCategory>)map.get("bookCategoryList");
		ArrayList<MasBookClass> bookClassList = (ArrayList<MasBookClass>)map.get("bookClassList");
		ArrayList<MasBookSubClass> bookSubClassList = (ArrayList<MasBookSubClass>)map.get("bookSubClassList");
		ArrayList<MasDepartment> departmentList = (ArrayList<MasDepartment>)map.get("departmentList");
		ArrayList<MasPublisher> publisherList = (ArrayList<MasPublisher>)map.get("publisherList");
	%>

<h6>Book Stock Report</h6>
<form name="bookClass" action="" method="post">
<div class="blockFrame">

<label>Type</label>
<select name="<%= TYPE %>" id="<%=TYPE %>" tabindex=1
	validate="Type,string,no" />
	<option value="">Select</option>
	<option value="b">Books</option>
	<option value="j">Journal</option>
	<option value="m">Magazine</option>
</select>

<label>Book Category</label>
 <select name="<%= BOOK_CATEGORY_ID %>" id="<%= BOOK_CATEGORY_ID %>" tabindex=1	validate="Book Category Name,string,no" onChange="populateBookClass(this.value,'bookClass')" />
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


<label>Book Class Name</label>
 <select name="<%= BOOK_CLASS_ID %>" id="<%= BOOK_CLASS_ID %>" tabindex=1 validate="Book Class Name,string,no" onChange="populateBookSubClass(this.value,'bookClass')" />
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
</script> 
<div class="Clear"></div>
<label> Book Sub Class</label>
 <select name="<%= BOOK_SUB_CLASS_ID %>" id="<%=BOOK_SUB_CLASS_ID %>" tabindex=1 validate="Book Sub Class Name,string,no" />
 	<option value="0">Select</option>
	<% 
    			for (MasBookSubClass  masbookSubClass : bookSubClassList){
    		%>
	<option value="<%=masbookSubClass.getId ()%>"><%=masbookSubClass.getSubClassName()%></option>

	<%}%>
</select> 

<label>Books For Department</label> 
<select	name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>" tabindex=1 validate="books For Department,string,no" />
	<option value="0">Select</option>
	<% 
    			for (MasDepartment  masDepartment : departmentList){
    		%>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select>
<label>Publisher Name</label> 
<select name="<%= PUBLISHER_ID %>" id="<%= PUBLISHER_ID %>" tabindex=1 validate="Publisher Name,string,no" />
	<option value="0">Select</option>
	<% 
    			for (MasPublisher  masPublisher : publisherList){
    		%>
	<option value="<%=masPublisher.getId ()%>"><%=masPublisher.getPublisherName()%></option>

	<%}%>
<div class="Clear"></div>

</div>
<div class="bottom"><input type="button" name="OK" value="OK" class="button" onClick="submitForm('bookClass','lib?method=generateBookStockReport');" />

<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>
