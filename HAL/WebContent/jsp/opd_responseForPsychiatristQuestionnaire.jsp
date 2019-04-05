
<%@page import="jkt.hms.masters.business.OpdQaMaster"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasQaOptionValue"%>

<%Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OpdQaMaster> questionnaireDataList = null;
if(map.get("questionnaireList") != null){
	questionnaireDataList = (List<OpdQaMaster>)map.get("questionnaireList");
}
List<MasQaOptionValue> optionValueList = null; 
if(map.get("optionValueList") != null){
	optionValueList = (List<MasQaOptionValue>)map.get("optionValueList");
}

int headingInc = 0;
System.out.println("headingInc "+map.get("headingInc"));
if(map.get("headingInc") != null){
	headingInc = (Integer)map.get("headingInc");
}
%>


 <%
int i=1;
 int j=1;
 int k=0;
for(OpdQaMaster qa:questionnaireDataList) {k=1;%>
  <tr>
   <td><input type="hidden"  id="questionId<%=headingInc%><%=i%>" name="questionId<%=headingInc%><%=i%>" value="<%=qa.getId()%>"><%=qa.getQuestion()%></td>
   <td><select name="answerId<%=headingInc%><%=i%>" validate="answerId<%=headingInc%><%=i%>,string,yes"> 
    <option value="0">Select Answer</option>
   <%for(MasQaOptionValue option :optionValueList){
                    /*   if(k>qa.getOptionValue())
                    	  break; */
                    	 if(option.getQuestion().getId() == qa.getId()) {
                    	 %>
       <option value="<%=option.getId()%>"><%=option.getQaOptionValueName()%></option>
     <%k++;}}%>
   </select></td>
  </tr>
<%i++;j++;}
%> 
<input type="hidden" value="<%=j%>" id="totalHeadingQuestion<%=headingInc%>" name="totalHeadingQuestion<%=headingInc%>">

