<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.*"%>
<%
Calendar calendar=Calendar.getInstance();
int year=calendar.get(calendar.YEAR);
System.out.println("-----------------------  >"+year);
String deptName="&nbsp;";

Date manu  = null;
Date expiry = null;


	
	
	Map<String, Object> map = new HashMap<String, Object>();


	String message = "";
	String manufacturer = "";
	String url = "";
	String lifeType="";

	

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	List objectList = new ArrayList();
	if (map.get("objectList1") != null) {
		objectList = (List)map.get("objectList1");
		System.out.println("objectList in jsp "+objectList.size());

	}
	List objectList2 = new ArrayList();

	if (map.get("objectList2") != null) {
		objectList2 = (List)map.get("objectList2");
		System.out.println("objectList in jsp "+objectList2.size());

	}
	
	if(map.get("expiryDate") !=null){
		 expiry = (Date)map.get("expiryDate");
		System.out.println("expiry > "+expiry);
		}
		if(map.get("manufacturingDate") !=null){
			manu = (Date) map.get("manufacturingDate");
			System.out.println("manu > "+manu);
			}
		if(map.get("manufacturer") !=null){
			manufacturer =""+ map.get("manufacturer");
			System.out.println("manufacturer>"+manufacturer);
			}
		if(map.get("lifeType") !=null){
			lifeType =""+ map.get("lifeType");
			System.out.println("lifeType>"+lifeType);
			}

		if (map.get("msg") != null) {
		             message = (String)map.get("msg");
		             //out.println("--2  "+message);
		      }
		if(!message.equalsIgnoreCase("")){
		%>
		<div class="clear"></div>
<div class="clear"></div>
		<h4><%=message %></h4>
		<%} %>
<div class="clear"></div>
<div class="clear"></div>
<!-- <div id="testDiv"> -->
		
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
<%if(objectList2.size()>0){ %>
<!-- <table  width="100%" id="main"> -->
 <table width="92%" colspan="7" id="grnDetails" 	border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		
			<th width="1%">Select</th>
			<th width="1%">Sl No.</th>
			<th width="10%">PVMS/NIV No.</th>
			<th width="25%">Nomenclature</th>
			<th width="15%">A/U</th>
			
			<th width="10%">Life Span</th>
			<th width="5%">MMF</th>
			<th width="15%">Current STOCK</th>
			<th width="15%">Qty Demanded</th>
			
		</tr>
	</thead>

	<% if(objectList2.size()>0){int sr=0;
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
<td width="10%"><input type="text" value="<%= ob[2]%>" name="pvms<%=sr%>" id="pvms<%=sr%>" readonly="readonly" size="5"/>
<input type="hidden" value="<%=ob[6]%>" name="itemId<%=sr%>" id="itemId<%=sr%>" />
</td>
<td width="25%"><input type="text" value="<%=ob[1]%>" name="nomen<%=sr%>" id="nomen<%=sr%>" readonly="readonly" size="30"/>
<input type="hidden" value="<%=ob[7]%>" name="sect<%=sr%>" id="sect<%=sr%>" />
</td>
<td width="15%"><input type="text" value="<%=ob[5]%>" name="au<%=sr%>" id="au<%=sr%>" readonly="readonly"/ size="20"></td>
<td width="10%"><input type="text" value="<%=lifeType%>" name="lifeType<%=sr%>" id="lifeType<%=sr%>" readonly="readonly" size="3"/></td>
<td width="5%"><input type="text" value="<%=ob[3]%>" name="mmf<%=sr%>" id="mmf<%=sr%>" readonly="readonly"/ size="3"></td>
<td width="15%"><input type="text" value="<%=ob[4]%>" name="stock<%=sr%>" id="stock<%=sr%>" readonly="readonly"/ size="3"></td>
<% 
int indentQty=0;
int mmfForIndent=0;
int mmf=((BigDecimal)ob[3]).intValue();

							int closingStock=((BigDecimal)ob[4]).intValue();
							if(lifeType.equals("SLB")){
							 mmfForIndent=6*mmf;
							}else if(lifeType.equals("SLA")){
								mmfForIndent=5*mmf;
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
 <td width="15%"><input type="text" value="<%=indentQty%>" name="demand<%=sr%>" id="demand<%=sr%>" readonly="readonly"/></td>
</tr>
<%}} %>
<input type="hidden" name="hdb1" value="1" id="hdb1" />
</table>
<%} %>
<!-- </div> -->