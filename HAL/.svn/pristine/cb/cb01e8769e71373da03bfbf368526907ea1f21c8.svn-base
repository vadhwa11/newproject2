<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
		
	     
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
.locatorArrow
{
    COLOR: #666666;
    FONT-FAMILY: Verdana;
    FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 String currenDate = (String) utilMap.get("currentDate");
	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	Vector supplier_ids = null;
	String message = null;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		storeTenderMList =   (ArrayList)map.get("storeTenderMList");
		
		if (map.get("message")!=null)
		{%>
		 <script>alert('<%=map.get("message").toString()%>');</script>			
		<%
		}
    }
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>


<script language="Javascript">

function showReport()
{	
		if(PVMSNIVForm.nomenclature.value != "")
		{
		var val = PVMSNIVForm.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		 if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	PVMSNIVForm.method="post";
			submitForm('PVMSNIVForm','tender?method=generateTenderForNomenclatureReport&pvmsNo='+pvms);
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(PVMSNIVForm.pvms.value != "")
		{
		PVMSNIVForm.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=pvms;
			submitForm('PVMSNIVForm','tender?method=generateTenderForNomenclatureReport&pvmsNo='+pvms);
		
		}
	else if(PVMSNIVForm.brand.value != "")
		{
		PVMSNIVForm.method="post";
		var brand=document.getElementById("brand").value;
		//document.getElementById("item_id").value=pvms;
			submitForm('PVMSNIVForm','tender?method=generateTenderForNomenclatureReport');
		
		}
	else{
	   alert("Please Enter The value.")
		}	
}
</script>

	<form name="PVMSNIVForm">
		<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
		<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
		<input type="hidden" name="date" size="5" value="<%=date%>">
		<input type="hidden" id="item_id" name="item_id" size="5">
		
		<div id="contentHolder">
		<h6>Tender PVMS/NIV Report</h6>
		<div class="Clear"></div>
		<div class="blockTitle">Tender PVMS/NIV Report</div><div class="blockTitleCurve"></div>
				<div class="blockFrame">	
				 <label>Nomenclature </label>
				<input type="text" value=""	id="nomenclature" class="large2" name="nomenclature" />
					<div id="ac2update" style="display:none;"></div>
					<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','tender?method=getItemListForTenderForNomenclatureByAutocomplete',{parameters:'requiredField=nomenclature'});
					</script>
				<div class="Clear"></div>
					
					<label c>PVMS/NIV No: </label>
					<input type="text" value=""	id="pvms"  name="pvms" />
				
					<label>Brand Name: </label>
					<input type="text" value=""	id="brand" class="" name="brand" />
		
		
	<div class="Clear"></div>
		</div>
<div class="Clear"></div>
		<input type="button" name="report" onClick="showReport();" value="Submit" class="button" >
	<div class="Clear"></div>
		</div>
	</form>
</body>
</html>