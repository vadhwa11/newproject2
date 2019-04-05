<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<div id="contentHolder"><script type="text/javascript" language="javascript">
function fillCompoenetName(){
    var obj = document.getElementById("compId");
    var val = obj.value;
    for(i=0;i<obj.length;i++)
    {
          if(obj.options[i].value == val)
          {
                componentName = obj.options[i].text
                break;
          }
    }
    if(componentName !="Select"){
          document.getElementById("componentName").value =componentName
    }else{
          document.getElementById("componentName").value =""
    }
    }

      </script>

<h6>Blood Stock Register</h6>
<div class="Clear"></div>
<%
                        Map<String, Object> map = new HashMap<String, Object>();
                        if (request.getAttribute("map") != null) {
                              map = (Map<String, Object>) request.getAttribute("map");
                        }
                        List<BloodMasComponent> bldMasCompList = new ArrayList<BloodMasComponent>();
                        if (map.get("bldMasCompList") != null) {

                              bldMasCompList = (List<BloodMasComponent>) map.get("bldMasCompList");
                        }

                   %>

<form name="bloodStockReg" target="_blank" method="post" action="">
<div class="blockFrame">
<input type="hidden" name="sd"  id="sd" value="Pdf" />
<label>Component Name:</label> 
<select id="compId" name="<%=BLOOD_COMPONENT_ID %>" onchange="fillCompoenetName();">>
      <option value="0">All</option>

      <%
               for (BloodMasComponent bldMascomp : bldMasCompList) {

              %>
      <option value="<%=bldMascomp.getId() %>"><%=bldMascomp.getComponentName()%></option>
      <%  }   %>

</select> 
<input type="hidden" name="<%=BLOOD_COMPONENT_NAME%>" id="componentName" />
<label class=""> Summary</label>
<input type="radio" name="summaryDetail" class="radio" value="summary"  checked="checked"/>
<label class="">Detail</label>
<input type="radio" name="summaryDetail" class="radio" value="details" />
      </div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button" onclick="submitForm('bloodStockReg','bloodBank?method=printBloodStockReport');"/> 
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();"      accesskey="r" />
<div class="Clear"></div>
</form>

</div>

