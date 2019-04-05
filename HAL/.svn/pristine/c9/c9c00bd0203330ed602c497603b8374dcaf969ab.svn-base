
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>



<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=localPurchaseRegisterReportJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%

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

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier> ();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");

	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("supplierList") != null) {
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
		//System.out.println("supplierList in jsp.... "+supplierList.size());
	}
%>
<form name="localPurchaseRegister" method="post" action="">
<div class="titleBg">
<h2>LOCAL PURCHASE REGISTER</h2>
</div>
<div class="Block">
<%String nameItem="nameItem" ; %>
<label> Date From  </label>
<input type="text" name="<%=FROM_DATE%>" value="" class="date" MAXLENGTH="30" validate="Pick a from date,date,no" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.localPurchaseRegister.<%=FROM_DATE%>,event)" />
<label> To </label>
<input type="text" name="<%=TO_DATE%>" value="" class="date"" MAXLENGTH="30" validate="Pick a to date,date,no" readonly="readonly" />

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.localPurchaseRegister.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>  CRV No. From  </label>
<input  type="text" name="fromCrv" value="" MAXLENGTH="30" validate="CRV No. From,alphanumeric1,no"/>



<label> To  </label>
<input  type="text" name="toCrv" value="" MAXLENGTH="30" validate="CRV No. To,alphanumeric1,no"/>
<div class="clear"></div>
<label> PVMS No.  </label>
<input  type="text" name="pvms" value="" MAXLENGTH="30" validate="PVMS/NIV NO.,alphanumeric1,no"/>
<%--
<script>
function alphanumeric(inputtxt)  
{  
	alert("alphanumeric"+inputtxt);
 var letterNumber = /^[0-9a-zA-Z/]+$/;  
 if!(inputtxt.test(letterNumber)){
 alert("message67"); 
  }  

</script>
 --%>
<label >Nomenclature</label>
			<input type="text" value="" name="<%=nameItem%>" id="<%=nameItem%>" onblur=""
			 />
			<div id="ac2update"	style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForTurnOverByAutocomplete',{parameters:'requiredField=<%=nameItem%>' });
			</script>
<div class="clear"></div>
<label> Vendor Name  </label>
		<select	name="<%= SUPPLIER_ID %>" id="supplierId" validate="Vendor Name,String,no">
			<option value="0">--Select--</option>
<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
			<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
			}
%>
		</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig" onClick="submitForm('localPurchaseRegister','stores?method=generateLocalPurchaseRegisterReport&flag=j');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="" accesskey="a" tabindex=1 />
<!--  <input type="button" name="add1" id="addbutton1" value="Print" class="button" onClick="submitForm('localPurchaseRegister','stores?method=generateReceiptRegisterReport&flag=p');" accesskey="a" tabindex=1 />-->
<input type="button" name="clear" id="clearbutton" value="Reset" class="button" onClick="clearButton('localPurchaseRegister');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>







