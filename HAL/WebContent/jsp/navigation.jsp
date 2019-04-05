<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * navigation.jsp  
 * Purpose of the JSP -  This is for navigation.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>
<script language="javascript" type="text/javascript">//script for show hide menu
function showHide(shID) {
   if (document.getElementById(shID)) {
      if (document.getElementById(shID+'-show').style.display != 'none') {
         document.getElementById(shID+'-show').style.display = 'none';
         document.getElementById(shID).style.display = 'block';
      }
      else {
         document.getElementById(shID+'-show').style.display = 'block';
         document.getElementById(shID).style.display = 'none';
      }
   }
}
</script>
<% String SessrfToken = (String) session.getAttribute("csrfToken");
    	System.out.println("nav method"+SessrfToken);
   %>
<form name="navigation" method="post" >
<!--  <a href="#" id="menu-show" class="showMenu" onclick="showHide('menu');return false;">

</a>-->

<DIV id="menu">
<script type="text/javascript">
			var menu = new Array();
<% 
        //			code for jsp
                Map map = null;
                int counter = 0;
        	    Set<MasApplication> applicationSet = null;
           	//	List<Object> applicationSet = new ArrayList<Object>();    
                if(request.getAttribute("map") != null)
                {
					map = (Map)request.getAttribute("map"); 
				}
		        
                if(map.get("applicationSet")!=null)
                {
                	applicationSet = (Set<MasApplication>)map.get("applicationSet");
                	session.setAttribute("applicationSet",applicationSet);
                }
                else if(session.getAttribute("applicationSet") != null){
                	applicationSet = (Set<MasApplication>)session.getAttribute("applicationSet");
                }
                    String appId = "";
                    if(session.getAttribute("appId")!= null){
                    	appId = (String)session.getAttribute("appId");
                    }
                
                    System.out.print("suize="+applicationSet.size());
//            	   MasApplication appMaster = (MasApplication)object[4];
           	for(MasApplication appMaster : applicationSet){
           		
           		System.out.print("name="+appMaster.getName());
            		out.println("menu["+ counter + "] = new Array();");
       				out.println("menu["+ counter + "][0] ='" + appMaster.getId()+"'");
       				out.println("menu["+ counter + "][1] ='" + appMaster.getParentId()+"'");
       				out.println("menu["+ counter + "][2] ='" + appMaster.getName()+"'");
       				out.println("menu["+ counter + "][3] ='" + appMaster.getUrl()+"&appId="+appMaster.getId()+"'");
       				out.println("menu["+ counter + "][4] ='" + appId+"'");
       				counter++;
               }
 %>       
   
           	makeMainMenu();
           	var formlist = document.getElementsByTagName("form");
           	if(formlist.length > 0)
           	{
           		for(var i=0; i<formlist.length; i++)
           		{
           			var ele = document.createElement("input");
               		ele.setAttribute("id","csrfToken");
               		ele.setAttribute("name","csrfToken");
               		ele.setAttribute("type","hidden");
               		ele.setAttribute("value","<%=session.getAttribute("csrfToken")%>");
               		
           			formlist[i].appendChild(ele);
               	}
            }
           	//var prev_handler = window.onload;
           	window.onload = function(){
           		//if (prev_handler) {
           	      //  prev_handler();
           	   // }
           	var formlist = document.getElementsByTagName("form");
           	if(formlist.length > 0)
           	{
           		for(var i=0; i<formlist.length; i++)
           		{
           			var ele = document.createElement("input");
               		ele.setAttribute("id","csrfToken");
               		ele.setAttribute("name","csrfToken");
               		ele.setAttribute("type","hidden");
               		ele.setAttribute("value","<%=session.getAttribute("csrfToken")%>");
               		
           			formlist[i].appendChild(ele);
               	}
            }
           	}
  </script>

   <!-- <li><a href="#" id="menu-hide" onclick="showHide('menu');return false;" class="hideMenu"></a></li> -->
  <div class="clear"></div>
  </div>
  
<div class="clear"></div>
</form>
<div id="mainIn">
