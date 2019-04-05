<%-- <%@page import="jkt.hms.masters.business.FaMasAccount"%> --%>
<%-- <%@page import="jkt.hms.masters.business.MmPreventiveCheckListDetails"%> --%>
<%-- <%@page import="jkt.hms.masters.business.MmPreventiveCheckList"%> --%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MmInspectionReport"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%-- <%@page import="jkt.hms.masters.business.MasCostCenter"%> --%>
<%@page import="jkt.hms.masters.business.MasStoreSupplierType"%>
<%@page import="jkt.hms.masters.business.CostCenter"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
		
		function actionType(id){
			document.getElementById("topView").style.display="none";
			document.getElementById("closeType").style.display="none";
			document.getElementById("viewUO").style.display="none";
			document.getElementById("viewR").style.display="none";
			document.getElementById("view1").style.display="none";
			document.getElementById("view2").style.display="none";
			document.getElementById("view3").style.display="none";
			document.getElementById("view4").style.display="none";
			document.getElementById("view5").style.display="none";
			document.getElementById("view6").style.display="none";
			document.getElementById("SubmitUpdate").style.display="none";
			document.getElementById("Closed").style.display="none";
			document.getElementById("Reset").style.display="none";
			document.getElementById("accountDiv").style.display="none";
			document.getElementById("plannedDetails").style.display="none";
			document.getElementById("imergencyIndent").style.display="none";
			document.getElementById("ObservationRemark").setAttribute("validate", "ObservationRemark,string,no");
			document.getElementById("obDate").setAttribute("validate", "Observation Date,string,no");
			document.getElementById("obTime").setAttribute("validate", "Observation Time,string,no");
			document.getElementById("OnHoldReason").setAttribute("validate", "OnHoldReason,string,no");
			document.getElementById("scheduledDate").setAttribute("validate", "ScheduledDate,string,no");
			document.getElementById("ScheduledTime").setAttribute("validate", "ScheduledTime,string,no");
			document.getElementById("ContactPerson").setAttribute("validate", "ContactPerson,string,no");
			document.getElementById("ResourceRequirment").setAttribute("validate", "Resource Requirment,string,no");
			document.getElementById("DescriptionOfWork").setAttribute("validate", "Description Of Work,string,no");
// 			document.getElementById("WorkOrderType").setAttribute("validate", "Work Order Type,string,no");
			if(document.getElementById("ItemName1")!=null){
			document.getElementById("ItemName1").setAttribute("validate", "Item Name,string,no");
			document.getElementById("RequiredQty1").setAttribute("validate", "Required Qty,string,no");
			}
			document.getElementById("ServiceCost").setAttribute("validate", "Service Cost,string,no");
			document.getElementById("MeterialCost").setAttribute("validate", "Material Cost,string,no");
			document.getElementById("PlannedCost").setAttribute("validate", "Planned Cost,string,no");
			document.getElementById("SupplierName").setAttribute("validate", "Vendor Name,string,no");
			var closeType= document.getElementById("closeType");
			if(id!=null && id!=""){
				if(id=="SC"){
					document.getElementById("closeType").style.display="";
// 					document.getElementById("closeType1").value="";alert();
					document.getElementById("topView").style.display="";
					document.getElementById("view2").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("Closed").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementsByName("CloseType")[0].checked=true;
				}
				if(id=="UO"){
					document.getElementById("topView").style.display="";
					document.getElementById("viewUO").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("SubmitUpdate").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementById("obDate").setAttribute("validate", "Observation Date,string,yes");
					document.getElementById("obTime").setAttribute("validate", "Observation Time,string,yes");
				}
				if(id=="WO"){
					document.getElementById("topView").style.display="";
					document.getElementById("view1").style.display="";
					document.getElementById("view2").style.display="";
					document.getElementById("view3").style.display="";
					document.getElementById("view4").style.display="";
					document.getElementById("SubmitUpdate").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementById("accountDiv").style.display="";
					document.getElementById("plannedDetails").style.display="";
					document.getElementById("imergencyIndent").style.display="";
// 					document.getElementById("WorkOrderType").setAttribute("validate", "Work Order Type,string,yes");
					document.getElementById("ResourceRequirment").setAttribute("validate", "Resource Requirment,string,yes");
					document.getElementById("DescriptionOfWork").setAttribute("validate", "Description Of Work,string,yes");
					if(document.getElementById("ItemName1")!=null){
					document.getElementById("ItemName1").setAttribute("validate", "Item Name,string,yes");
					document.getElementById("RequiredQty1").setAttribute("validate", "Required Qty,string,yes");
					}
					document.getElementById("ServiceCost").setAttribute("validate", "Service Cost,string,yes");
					document.getElementById("MeterialCost").setAttribute("validate", "Material Cost,string,yes");
					document.getElementById("PlannedCost").setAttribute("validate", "Planned Cost,string,yes");
					document.getElementById("SupplierName").setAttribute("validate", "Vendor Name,string,yes");
				}
				if(id=="SCH"){
					document.getElementById("topView").style.display="";
					document.getElementById("view5").style.display="";
					document.getElementById("SubmitUpdate").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("ObservationRemark").setAttribute("validate", "Remark,string,no");
					document.getElementById("scheduledDate").setAttribute("validate", "ScheduledDate,string,yes");
					document.getElementById("ScheduledTime").setAttribute("validate", "ScheduledTime,string,yes");
					document.getElementById("ContactPerson").setAttribute("validate", "ContactPerson,string,yes");
				}
				if(id=="OH"){
					document.getElementById("topView").style.display="";
					document.getElementById("view6").style.display="";
					document.getElementById("SubmitUpdate").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("ObservationRemark").setAttribute("validate", "Remark,string,yes");
					document.getElementById("OnHoldReason").setAttribute("validate", "Reason,string,yes");
				}
				if(id=="CND"){
					document.getElementById("topView").style.display="";
					document.getElementById("SubmitUpdate").style.display="";
					document.getElementById("Reset").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("ObservationRemark").setAttribute("validate", "Remark,string,yes");
				}
			}
			dayCalculate();
		}
		
		function closeType(id){
			document.getElementById("topView").style.display="none";
			document.getElementById("view2").style.display="none";
			document.getElementById("viewR").style.display="none";
			document.getElementById("view3").style.display="none";
			document.getElementById("SubmitUpdate").style.display="none";
			document.getElementById("Closed").style.display="none";
			document.getElementById("Reset").style.display="none";
			if(id!=null && id!=""){
				if(id=="WS"){
					document.getElementById("topView").style.display="";
					document.getElementById("view2").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("Closed").style.display="";
					document.getElementById("Reset").style.display="";
				}
				if(id=="S"){
					document.getElementById("topView").style.display="";
					document.getElementById("view2").style.display="";
					document.getElementById("view3").style.display="";
					document.getElementById("viewR").style.display="";
					document.getElementById("Closed").style.display="";
					document.getElementById("Reset").style.display="";
				}
			}
		}
		
		function add(){
			var table=document.getElementById("safetyPM"); 
			var tableLength=table.rows.length;
			var iteration=tableLength;
			var row=table.insertRow(tableLength);
			var cell2 = row.insertCell(0);
			 var e2 = document.createElement('input');
			  e2.type = 'checkbox';
			  e2.name='Item';
			  e2.id='Item'+iteration;
			  cell2.appendChild(e2);
			  var e2 = document.createElement('input');
			  e2.type = 'hidden';
			  e2.name='ItemId';
			  e2.id='ItemId'+iteration;
			  cell2.appendChild(e2);
			  
			  var cell2 = row.insertCell(1);
			  cell2.id='ItemCode'+iteration;
			  /*var e2 = document.createElement('input');
			   e2.type = 'text';
			  e2.name='ItemCode';
			  e2.readOnly='readOnly';
			  e2.id='ItemCode'+iteration;
			  cell2.appendChild(e2); */
			  
			  var cell2 = row.insertCell(2);
			  var e2 = document.createElement('input');
			  e2.type = 'text';
			  e2.name='ItemName';
			  e2.value='';
			  e2.validate='Item Name,string,yes';
			  e2.onblur=function(){if(this.value!=''){checkForIndentToDepot(this.value, "ItemCode"+iteration, "ItemId"+iteration, "AvailableItem"+iteration, "RequiredQty"+iteration, "ItemRate"+iteration, "ItemCost"+iteration )}};
			  e2.id='ItemName'+iteration;
			  e2.autocomplete="off";
			  cell2.appendChild(e2);
			  
			  var div = document.createElement('div');
			  div.id='autoconecpt'+iteration;
			  div.style.display=' none';
			  div.className='autocomplete';
			  div.autocomplete="off";
			  cell2.appendChild(div);
			  var script = document.createElement( "script" );
			  script.type = "text/javascript";
			  script.charset = "utf-8";
			  script.innerHTML = "new Ajax.Autocompleter('ItemName"+iteration+"','autoconecpt"+iteration+"','fm?method=getItemListAutoComplet',{minChars:1,parameters:'code=1'})";
			  cell2.appendChild(script);
			  
			  var cell2 = row.insertCell(3);
			  	  cell2.id = "AvailableItem"+iteration;
			  
			  var cell2 = row.insertCell(4);
			  var e2 = document.createElement('input');
			  e2.type = 'text';
			  e2.name='RequiredQty';
			  e2.validate='Required Qty,string,yes';
			  e2.onblur=function(){if(this.value!=''){addCost(this.value, 'ItemRate'+iteration, 'ItemCost'+iteration)}};
			  cell2.appendChild(e2);
			  
			  var cell2 = row.insertCell(5);
			  cell2.id = "ItemRate"+iteration;
			  cell2.innerHTML="0.0";
			  
			  var cell2 = row.insertCell(6);
			  cell2.id = "ItemCost"+iteration;
			  cell2.innerHTML="0.0";
			  
			  var cell2 = row.insertCell(7);
			  var e3 = document.createElement('input');
			  e3.type = 'text';
			  e3.id = "specification"+iteration;
			  e3.name='specification';
			  e3.validate='Specification,string,no';
			  e3.maxlength='50'
			  cell2.appendChild(e3);
			 
		}
		
		function removeRow(){
			var table=document.getElementById("safetyPM"); 
			var tableLength=table.rows.length;
			var item=document.getElementsByName("Item");
			var itemLength=0;
			for(var i=0;i<item.length;i++){
				if(item[i].checked==true){
					itemLength=itemLength+1;
				}
			}
			if((itemLength+2)<=tableLength){
				for(var i=0;i<item.length;i++){
					if(item[i].checked==true){
						table.deleteRow(i+1);
					}
			}
			}else{
				alert("You Con't Delete!");
			}
		}
		
		  function checkForIndentToDepot(val, ItemCode, ItemId, AvailableItem, RequiredQty, ItemRate, ItemCost){
			  var index1 = val.lastIndexOf("[");
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var requestId = val.substring(index1,index2);
			      try {
			        // Firefox, Opera 8.0+, Safari
			        xmlHttp=new XMLHttpRequest();
			      }catch (e){
			        // Internet Explorer
			        try{
			          xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			        }catch (e){
			            alert(e)
			          try{
			            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			          }catch (e){
			            alert("Your browser does not support AJAX!");
			            return false;
			          }
			         }
			       }
			        xmlHttp.onreadystatechange=function()
			        {
			          if(xmlHttp.readyState==4){
			              var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

			              for (loop = 0; loop < items.childNodes.length; loop++) {
	 		                   var item = items.childNodes[loop];
			                var itemId  = item.getElementsByTagName("itemId")[0];
			                var itemCode  = item.getElementsByTagName("itemCode")[0];
			                var itemAvl=item.getElementsByTagName("itemAvl")[0];
			                var itemRate=item.getElementsByTagName("itemRate")[0];
			                document.getElementById(ItemCode).innerHTML = itemCode.childNodes[0].nodeValue;
			                document.getElementById(AvailableItem).innerHTML = itemAvl.childNodes[0].nodeValue;
			                document.getElementById(ItemId).value = itemId.childNodes[0].nodeValue;
			                document.getElementById(ItemRate).innerHTML=itemRate.childNodes[0].nodeValue;
// 			                document.getElementById(ItemCost).innerHTML=itemRate.childNodes[0].nodeValue;
			                  }
			          }
			        }
			         url="/hms/hms/fm?method=getItemDetail&requestId="+requestId;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			        xmlHttp.open("GET",url,true);
			        xmlHttp.setRequestHeader("Content-Type", "text/xml");
			        xmlHttp.send(null);
			        
			     }
		  
		  function validation(){
			  var  ActionType=document.getElementById("ActionType");
			  if(ActionType.value!=""){
				  /*------Self Close Validation Start-------*/
				  if(ActionType.value=="SC"){
						var closeType=document.getElementsByName("CloseType");
						if(closeType[0].checked==true){
							var att=document.getElementById("DescriptionOfWork").value;
							if(att==""){
								alert("Description Of Work Empty.");
								return false;
							}
						}
						if(closeType[1].checked==true){
							var att=document.getElementById("DescriptionOfWork").value;
							if(att==""){
								alert("Description Of Work Empty.");
								return false;
							}
						}
						return true; 
				  }
				  /*------Self Close Validation End-------*/
			  }else{
				  alert("Action Type Not Selected.");
				  return false;
			  }
		  }
		  
		  function isNumber(evt)
		  {
		     var charCode = (evt.which) ? evt.which : event.keyCode
		     if (charCode != 46 && charCode > 31
		       && (charCode < 48 || charCode > 57))
		        return false;

		     return true;
		  }
		  
		  function dayCalculate(){
				var  ServiceCost=0;
				var MeterialCost=0;
				var PlannedCost=0;
				if(document.getElementById("ServiceCost").value!="")
					ServiceCost=parseInt(document.getElementById("ServiceCost").value);
				if(document.getElementById("MeterialCost").value!="")
					MeterialCost=parseInt(document.getElementById("MeterialCost").value);
				document.getElementById("PlannedCost").value=ServiceCost+MeterialCost;
		  }
		  
		  function workOrderVali(){
// 			  var wot=document.getElementById("WorkOrderType");
			  var DescriptionOfWork=document.getElementById("DescriptionOfWork");
			  var plannedCost=document.getElementById("PlannedCost");
			  var ActionType=document.getElementById("ActionType");
			  var obDate=document.getElementById("obDate");
			  var obTime=document.getElementById("obTime");
			  var msg="";
			  /*------Work Order Start-------*/
			  if(ActionType.value=='WO'){
				  if(wot.value==null || wot.value==""){
					  msg+="Work Order Type Empty.\n"
				  }
				  if(DescriptionOfWork.value==null || DescriptionOfWork.value==""){
					  msg+="Description Of Work Empty.\n"
				  }
				  if(plannedCost.value==null || plannedCost.value==""){
					  msg+="Planned Cost Empty.\n"
				  }
				  if(msg.length!=0){
					  alert(msg);
					  return false;
				  }
			  }
			  /*------Work Order End-------*/
			  /*------Under Observartion Start-------*/
			  if(ActionType.value=="UO"){
				  if(obDate.value==null || obDate.value==""){
					  msg+="Obeservation Date Empty.\n"
				  }
				  if(obTime.value==null || obTime.value==""){
					  msg+="Obeservation Time Empty.\n"
				  }
				  if(msg.length!=0){
					  alert(msg);
					  return false;
				  }
			  }
			  /*------Under Observartion End-------*/
			  return true;
		  }
		  
		  function openPopupWindow()
		  {
		  	var id = document.getElementById('ServiceRequestId').value;
// 		  	var mode = document.getElementById('mode').value;
		  	var url="/hms/hms/fm?method=getEquipmentFile&RequestId="+id;
		   	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		  }
		  
		  /*------For Calculate Cost------*/
		  function addCost(val, rate, cost){
			  var qty=0.0;
			  if(val!=null && val!='NaN' && val!='')
				  qty=val;
			  document.getElementById(cost).innerHTML=parseFloat(document.getElementById(rate).innerHTML)*parseFloat(qty);
			  var table=document.getElementById("safetyPM");
			  var tableRow=table.rows;
			  var tableCell=tableRow[1].cells;
			  var totCost=0.0;
			  for(var i=1;i<tableRow.length;i++){
				  totCost+=parseFloat(tableRow[i].cells[6].innerHTML);
			  }
			  document.getElementById("MeterialCost").value=totCost;
			  dayCalculate();
		  }
</script>


<% Map<String, Object> map=new HashMap<String, Object>();
	List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
/* 	List<MasCostCenter> costCenters=new ArrayList<MasCostCenter>(); */
	List<MasStoreSupplierType> supplierType=new ArrayList<MasStoreSupplierType>();
	List<MmMasRequestStatus> status1=new ArrayList<MmMasRequestStatus>();
 	List<MmInspectionReport> mmInspectionReport=new ArrayList<MmInspectionReport>(); 
	List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
	List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
	List<MasStoreSupplier> suppliers=new ArrayList<MasStoreSupplier>();
/* 	List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
	List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
	List<FaMasAccount> faMasAccounts=new ArrayList<FaMasAccount>(); */
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("hesEquipmentAmcDetailsEntry")!=null){
		hesEquipmentAmcDetailsEntry=(List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
	}
	if(map.get("hesEquipmentMaster")!=null){
		hesEquipmentMaster=(List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}
	if(map.get("mmServiceRequests")!=null){
		mmServiceRequests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
/* 	if(map.get("costCenter")!=null){
		costCenters = (List<MasCostCenter>)map.get("costCenter");
	} */
	if(map.get("supplierType")!=null){
		supplierType = (List<MasStoreSupplierType>)map.get("supplierType");
	}
	if(map.get("mmMasRequestStatus")!=null){
		status1=(List<MmMasRequestStatus>)map.get("mmMasRequestStatus");
	}
 if(map.get("mmInspectionReport")!=null){
		mmInspectionReport=(List<MmInspectionReport>)map.get("mmInspectionReport");
	} 
	if(map.get("suppliers")!=null){
		suppliers=(List<MasStoreSupplier>)map.get("suppliers");
	}
	/* if(map.get("mmPreventiveCheckList")!=null){
		mmPreventiveCheckList=(List<MmPreventiveCheckList>)map.get("mmPreventiveCheckList");
	}
	if(map.get("mmPreventiveCheckListDetails")!=null){
		mmPreventiveCheckListDetails=(List<MmPreventiveCheckListDetails>)map.get("mmPreventiveCheckListDetails");
	}
	if(map.get("faMasAccounts")!=null){
		faMasAccounts=(List<FaMasAccount>)map.get("faMasAccounts");
	} */
	String observationDate="";
	String observationTime="";
	String remark="";
	String obFlag="";
/* 	if(mmInspectionReport.size()!=0){
		if(mmInspectionReport.get(0).getObservationDate()!=null){
		try{
			observationDate=sdf.format(mmInspectionReport.get(0).getObservationDate());
		}catch(Exception e){e.printStackTrace();}
		}
		if(mmInspectionReport.get(0).getObservationTime()!=null)
		observationTime=mmInspectionReport.get(0).getObservationTime();
		if(mmInspectionReport.get(0).getObservationRemark()!=null){
			remark=mmInspectionReport.get(0).getObservationRemark();
		}
		obFlag="selected";
	} */
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>
<div class="titleBg">
<h2>Inspection Report</h2>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<form name="mInspectionRequest"  method="post" >
<%for(MmServiceRequest mmServiceRequest:mmServiceRequests){
	String approvedBy="";
	if(mmServiceRequest.getApprovedBy()!=null)
		approvedBy=mmServiceRequest.getApprovedBy().getEmployee().getFirstName();
	%>
<div class="Block">

	<%@include file="mEquipmentDetail.jsp" %>
	<div class="clear"></div>	
	<label>Request Type</label>
	<label class="value"><%=mmServiceRequest.getRequestType()%></label>
	<label>Priority</label>
	<label class="value"><%=mmServiceRequest.getPriority().getCodesName()%></label>
	<label>Required By Date</label>
	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getRequiredDate())%></label>
	<div class="clear"></div>
	
	<label>Requested By</label>
	<label class="value"><%=mmServiceRequest.getLastChgBy().getEmployee().getFirstName()%></label>
	<label>Requested From</label>
	<label class="value"><%=mmServiceRequest.getEquipment().getDepartment().getDepartmentName()%></label>
	<label>Approved By</label>
	<label class="value"><%=approvedBy%></label>
	<div class="clear"></div> 
	<label>Status</label>
	<label class="value"><%=mmServiceRequest.getRequestStatus().getStatusName() %></label>
	<label>Request No</label>
	<label class="value"><%=mmServiceRequest.getServiceRequestNo() %></label>
	<%if(mmServiceRequest.getTransferDetail()!=null && mmServiceRequest.getTransferDetail()!=""){ %>
	<label>Transfer Detail </label>
	<textarea><%=mmServiceRequest.getTransferDetail() %></textarea> 
	<%} %>
	<div class="clear"></div>
	<label>Description</label>
	<input type="text" name="desciption" value="<%=mmServiceRequest.getDescription()%>" readonly="readonly"  class="large"/> 
	
	
	<label><a href="/hms/hms/fm?method=showEquipmentHistory&eqId=<%=mmServiceRequest.getEquipment().getId()%>">History</a></label>
	<%-- <label><a href="/hms/hms/fm?method=showEquipmentDashBoard&eqId=<%=mmServiceRequest.getEquipment().getId()%>">DashBoard</a></label> --%>
	
	<input type="hidden" id="ServiceRequestId" name="ServiceRequestId" value="<%=mmServiceRequest.getId()%>" />
	<input type="hidden" name="equipmentId" value="<%=mmServiceRequest.getEquipment().getId()%>" />
	<div class="clear"></div>
	
	<%if(mmInspectionReport.size()>0) 
	{
		
%>
<label>Previous Service Remarks</label>

	<textarea class="large" readonly="readonly"><%= mmInspectionReport.get(0).getRemarks()!=null?mmInspectionReport.get(0).getRemarks() : "" %></textarea>
<%		
	}
	%>
	
	<%
	if(!status.equalsIgnoreCase("None")){
	if(mmServiceRequest.getRequestType().equalsIgnoreCase("Preventive")){ 
		Integer preventiveCycle=0;
		Integer completedCycle=0;
		Integer preventiveCycleNo=0;
		int month1=0;
		
		String preventiveDueDate="";
		Calendar  instaletionDate= Calendar.getInstance();
		if(mmServiceRequest.getEquipment()!=null){
			if(mmServiceRequest.getEquipment().getPreventiveCycle()!=null)
			preventiveCycle=mmServiceRequest.getEquipment().getPreventiveCycle();
			if(mmServiceRequest.getEquipment().getPreventiveCompletedCycle()!=null)
			completedCycle=mmServiceRequest.getEquipment().getPreventiveCompletedCycle();
			
			instaletionDate.setTime(mmServiceRequest.getEquipment().getDateOfInstallation());
		}
		if(mmServiceRequest.getAmc()!=null){
// 			preventiveCycle=mmServiceRequest.getAmc().getPreventiveCycle();
// 			completedCycle=mmServiceRequest.getAmc().getPreventiveCompletedCycle();
// 			instaletionDate=mmServiceRequest.getAmc().getAmcWarrentyStartDate();
		}
		
		preventiveCycleNo=preventiveCycle-completedCycle;
		if(preventiveCycle!=0){
			month1=(12/preventiveCycle)*(completedCycle+1);
		}
		instaletionDate.set(Calendar.MONTH, month1);
		int m=instaletionDate.get(Calendar.MONTH);
		int d=instaletionDate.get(Calendar.DAY_OF_MONTH);
		if(instaletionDate!=null){
			preventiveDueDate=instaletionDate.get(Calendar.DAY_OF_MONTH)+"/"+instaletionDate.get(Calendar.MONTH)+"/"+instaletionDate.get(Calendar.YEAR);
		}
		String preventiveDonOn=date+"/"+month+"/"+year;
	/* 	if(mmInspectionReport.size()>0){
		if(mmInspectionReport.get(0).getPreventiveDoneOn()!=null){
			preventiveDonOn=sdf.format(mmInspectionReport.get(0).getPreventiveDoneOn());
		}
		} */
	%>
	<div class="division"></div>
	<label>Preventive Due Date</label>
	<label class="value"><%=preventiveDueDate %></label>
	<label>Preventive Done On</label>
	<input id="PreventiveDoneOn" class="date" type="text" maxlength="30" readonly="readonly" value="<%=preventiveDonOn%>" name="PreventiveDoneOn">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mInspectionRequest.PreventiveDoneOn,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<%-- 	<%if(mmPreventiveCheckList.size()!=0){ %>
	<table style="width: 220px"><tr><th></th><th>Check List</th></tr>
	<% for(MmPreventiveCheckList mmPreventiveCheckLists:mmPreventiveCheckList){
			String checkedStatus="";
			if(mmPreventiveCheckListDetails.size()!=0){
				for(MmPreventiveCheckListDetails preventiveDetail:mmPreventiveCheckListDetails){
					if(preventiveDetail.getCheckList().getId()==mmPreventiveCheckLists.getId()){
						checkedStatus="checked='checked'";
					}
				}
			}
		
		%>
			<tr><td><input type="checkbox" <%=checkedStatus %>  name="checkList" validate="ItemName,string,yes" value="<%=mmPreventiveCheckLists.getId() %>" /><input type="hidden" name="AllCheckList" value="<%=mmPreventiveCheckLists.getId() %>" /></td><td><%=mmPreventiveCheckLists.getCheckListName() %></td></tr>
	<%} %>
		</table> --%>
		<%//}
}} %>
</div>
<%}

/* if(mmServiceRequests.get(0).getRequestStatus().getId()==3 || mmServiceRequests.get(0).getRequestStatus().getId()==4 || mmServiceRequests.get(0).getRequestStatus().getId()==17 || mmServiceRequests.get(0).getRequestStatus().getId()==18){ */
	if( !mmServiceRequests.get(0).getRequestStatus().getStatusCode().equalsIgnoreCase("CL")){
%>

<h4>Action Taken</h4>
<div class="Block">
	<label><span>* </span>Action Type</label>
	<input type="hidden" id="tempAction" value="<%=mmServiceRequests.get(0).getRequestStatus().getStatusCode()  %>" />
	<!-- <select name="ActionType" id="ActionType" onchange="actionType(this.value)" > -->
	<select name="ActionType" id="ActionType" validate="Action type, int, yes">
	<option value="0">Select</option>
	<%for(MmMasRequestStatus mmMasRequestStatus:status1){ %>
		<option  value="<%=mmMasRequestStatus.getStatusCode()%>"><%=mmMasRequestStatus.getStatusName() %></option>
		<%} %>
	</select>
	 <label>Equipment Received Date</label> 
 <input id="equipRecDate" class="date" type="text" maxlength="30" readonly="readonly"  name="equipRecDate" validate="Equipment Received date,date,no">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mInspectionRequest.equipRecDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	
		<div class="clear"></div>
	<label><span>* </span>Remarks</label>
	<textarea id="remarks" class="large" name="remarks"maxlength="200" validate="Remarks,String,yes"/></textarea>
<!-- 	<div id="closeType" style="display: none">
	<label>Without Spare</label>
	<input type="radio" name="CloseType" checked="checked" onclick="closeType(this.value)" value="WS" /> 
	<label>With Spare</label>
	<input type="radio" name="CloseType" onclick="closeType(this.value)" value="S" /> 
	</div> -->
</div>
<div id="topView" style="display: none">
<%-- <h4>Inspection Detail</h4>
<div class="Block" >
	<div id="view1" style="display: none">
<!-- 		<label><span>* </span> Work Order Type</label> -->
<!-- 		<select name="WorkOrderType" id="WorkOrderType"> -->
<!-- 			<option value="">Select</option> -->
<!-- 			<option value="Corrective">Corrective</option> -->
<!-- 			<option value="Preventive">Preventive</option> -->
<!-- 			<option value="Breakdown">Breakdown</option> -->
<!-- 		</select> -->
<!-- 		<label>Work Order Status</label> -->
<!-- 		<select><option>Select</option></select> -->
		<label>Resource Requirement</label>
		<textarea   maxlength="200" name="ResourceRequirment" id="ResourceRequirment" ></textarea>
	</div>
<!-- 		<div class="clear"></div> -->
<!-- 		<label>Upload Document</label> -->
<!-- 		<input  type="file" name="inspectionDocument"/> -->
		
		<label><a href="#" onclick="javascript:openPopupWindow();">View Document</a></label>
 		<div class="clear"></div> 
		<div id="view2" style="display: none">
			<label><span>* </span>Description of work</label>
			<textarea  id="DescriptionOfWork" name="DescriptionOfWork" maxlength="200" ></textarea>
	</div>
	<div id="viewUO" style="display: none">
		<label><span>* </span>Observation Date</label>
		<input id="obDate" class="date" type="text" validate="Pick a Date" maxlength="30" readonly="readonly" value="<%=observationDate%>" name="obDate">
		<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mInspectionRequest.obDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
		 <label><span>* </span>Observation Time</label>
		 <input type="text" id="obTime" name="ObservationTime" MAXLENGTH="5" onkeypress="return isNumber(event)" onkeyup="mask(this.value,this,'2',':');" value="<%=observationTime %>" />
	</div>
	<div id="viewR" style="display: none">
		<label>Remarks</label><textarea name="ObservationRemark" id="ObservationRemark" maxlength="200" ><%=remark %></textarea>
	</div>
	<div id="view3" style="display: none">
			<div class="clear"></div>
			<label style="width: 170px;margin-top: 30px">Materials Requirment</label>
			<input class="buttonAdd" type="button" onclick="add()" value="" name="Add">
			<input class="buttonDel" type="button" onclick="removeRow()" value="" name="delete">
			<table  id="safetyPM">
			 	<tr><th></th><th>Item Code</th><th>Spares</th><th>Available Qty</th><th>Required Qty</th><th>Rate</th><th>Amount</th><th>Specification</th></tr>
			 	<tr><td><input type='checkbox' name='Item' id='Item1' /><input type="hidden" name="ItemId" value="" id="ItemId1"/></td><td id="ItemCode1"></td>
			 	<td> <input type="text" name="ItemName" value="" onblur="if(this.value!=''){checkForIndentToDepot(this.value, 'ItemCode1', 'ItemId1', 'AvailableItem1', 'RequiredQty1', 'ItemRate1', 'ItemCost1' )}" id="ItemName1"/>
				    <div id="autoconecpt1" style="display: none;" class="autocomplete"></div>
					 <script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('ItemName1','autoconecpt1','fm?method=getItemListAutoComplet',{minChars:1,parameters:'code=1'});
				  	 </script>
			 	</td><td id='AvailableItem1'>0.0</td><td><input type='text' onblur="addCost(this.value, 'ItemRate1', 'ItemCost1')" onkeydown="return isNumber(event)" name="RequiredQty" id="RequiredQty1" value="0"  /></td>
			 	<td id="ItemRate1">0.0</td>
			 	<td id="ItemCost1">0.0</td>
			 	<td id="specification1"><input type="text" name="specification" id="specification1" value="" validate="specification,string,no" maxlength="50"  /></td>
			 	</tr>
			</table>
			<div class="clear"></div>
	</div>
	<div id="view4" style="display: none">
		 <label>Service Cost</label> 
	 	 <input id="ServiceCost"  type="text" maxlength="30" onblur="dayCalculate()" onkeydown="return isNumber(event)"  value="0" name="ServiceCost">
		 <label>Material Cost</label>
		 <input id="MeterialCost"  type="text" maxlength="30" onblur="dayCalculate()" readonly="readonly" onkeydown="return isNumber(event)" value="0" name="MeterialCost">
		 <label>Planned Cost</label> <input type="text" readonly="readonly"	name="PlannedCost" value="0" MAXLENGTH="30" id="PlannedCost" />
		 <div class="clear"></div>
		 
		 <div id="plannedDetails" style="display: none">
		 <label>Planned Start Date</label>
		 <input id="PlannedStartDate" class="date"  onblur="return dateCalculation()" type="text" validate="Planned Start Date" maxlength="30" readonly="readonly" value="<%=currentDate%>" name="PlannedStartDate">
		<img width="16" height="16" border="0"  onclick="javascript:setdate('',document.mInspectionRequest.PlannedStartDate,event)" validate="Planned Start Date" src="/hms/jsp/images/cal.gif">
		 <label>Planned Start End</label>
		 <input id="PlannedEndDate" class="date"  onblur="return dateCalculation()" type="text" validate="Planned Start End" maxlength="30" readonly="readonly" value="<%=currentDate%>" name="PlannedEndDate">
		<img width="16" height="16" border="0"  onclick="javascript:setdate('',document.mInspectionRequest.PlannedEndDate,event)" validate="Planned Start End" src="/hms/jsp/images/cal.gif">
		 <label>Duration</label>
		 <input type="text" name="Duration" readonly="readonly" id="Duration" value="" />
		 </div>
<!--		  <label>Vendor Type</label>
		 <select name="SupplierType"  onchange="if(this.value!=''){submitProtoAjaxWithDivNameToShowStatus('mInspectionRequest','/hms/hms/fm?method=getSupplierList','supplierList');}"><option value="">Select</option>
		 	<%for(MasStoreSupplierType supplierTypes:supplierType){ %>
		 	<option value="<%=supplierTypes.getId()%>"><%=supplierTypes.getSupplierTypeName() %></option>
		 	<%} %>
		 </select>
 		 <label>Vendor TIN No</label> -->
<!-- 		 <select><option>Select</option></select> -->
		 <label>Vendor Name</label>
		 <div id="supplierList">
			 <select id="SupplierName" name="SupplierName" onchange="if(this.value!=''){submitProtoAjax('mInspectionRequest','/hms/hms/fm?method=getVendorAddress');}">
				<option value="">Select</option>
				<%for(MasStoreSupplier supplier:suppliers){ %>
				<option value="<%=supplier.getId()%>"><%=supplier.getSupplierName()%></option>
				<%} %>
			</select>
			<div id="accountDiv" style="display: none">
			<label>Account</label>
			<select name="Account" >
				<option value="">Select</option>
				<%for(FaMasAccount account:faMasAccounts){ %>
					<option value="<%=account.getId()%>"><%=account.getAccDesc()%></option>
				<%} %>
			</select>
			<label>WO Required Date</label>
			 <input id="WORequiredDate" class="date" type="text" validate="WO Requiered Date" maxlength="30" readonly="readonly" value="<%=currentDate%>" name="WORequiredDate">
			<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mInspectionRequest.WORequiredDate,event)" validate="WO Required Date" src="/hms/jsp/images/cal.gif">
		 
			</div>
			
		 </div>
		  <div class="clear"></div>
		 <label>Remarks</label> 
		 <textarea maxlength="200" name="WorkOrderRemark" ></textarea>
		 <div class="clear"></div>
		 <div id="imergencyIndent" style="display: none">
		  <input type="checkbox"  style="margin: 2px" onclick="return emergencyIndent('ImergencyIndent')" name="ImergencyIndent" id="ImergencyIndent" value="y"/>
		  <label>Emergency Indent.</label>
		 </div>
	 </div>
	 <%
	 	String scheduleDate=date+"/"+month+"/"+year;
	 	String scheduleTime="";
	 	String contactPerson="";
	 	String resion="";
/* 	 	if(mmInspectionReport.size()!=0){
	 	if(mmInspectionReport.get(0).getScheduledDate()!=null)
	 		scheduleDate=sdf.format(mmInspectionReport.get(0).getScheduledDate());
	 	if(mmInspectionReport.get(0).getScheduledTime()!=null)
	 		scheduleTime=mmInspectionReport.get(0).getScheduledTime();
 		if(mmInspectionReport.get(0).getContactPerson()!=null)
 			contactPerson=mmInspectionReport.get(0).getContactPerson();
 		if(mmInspectionReport.get(0).getReason()!=null)
 			resion=mmInspectionReport.get(0).getReason();
	 	} */
	 %>
	  <div class="clear"></div>
	 <div id="view5" style="display: none">
	 	<label><span>* </span>Scheduled Date</label>
	 	<input id="scheduledDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=scheduleDate %>" name="ScheduledDate">
		<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mInspectionRequest.ScheduledDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
		<label><span>* </span>Scheduled Time</label>
		<input type="text" name="ScheduledTime" id="ScheduledTime" validate="ScheduledTime,string,no" onkeyup="mask(this.value,this,'2',':');" onkeypress="return isNumber(event)" maxlength="5" value="<%=scheduleTime%>" />
		<label><span>* </span>Contact Person</label>
		<input type="text" name="ContactPerson" id="ContactPerson" validate="ContactPerson,string,no" value="<%=contactPerson %>" />
	 </div>
	 <div id="view6" style="display: none">
	 <input type="hidden" name="tempOnHold" id="tempOnHold" value="<%=resion %>" />
	 	<label>Reason</label>
	 	<select name="OnHoldReason" id="OnHoldReason"> 
	 		<option value="">Select</option>
	 		<option value="Contact Person Not Available">Contact Person Not Available</option>
	 		<option value="Machin Not Available">Machine Not Available</option>
	 		<option value="Spares Not Available">Spares Not Available</option>
	 	</select>
	 	</div>
	 	<div class="clear"></div>
	 	<div class="clear"></div>
	 	</div>
	 <div>
	
	 </div> --%>
		

</div>
<input type="button" class="button" onclick="submitForm('mInspectionRequest','/hms/hms/fm?method=submitInspectionReport&type=SU');" id="SubmitUpdate" value="Submit" />
	<!-- 	<input type="button" class="button" onclick="if(validation()){submitForm('mInspectionRequest','/hms/hms/fm?method=submitInspectionReport&type=CL');}" id="Closed" value="Submit" /> -->
<!-- 		<input type="button" class="button" value="Upload" onClick="javascript:openPopupWindow();" /> -->
		<input type="Reset" class="button" onclick=""  id="Reset" style="display: none" value="Reset" />
		<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 
	<%}else{ %>
	<h4>Request Status</h4>
	<div class="Block">
		<label><%=mmServiceRequests.get(0).getRequestStatus().getStatusName() %></label>
	</div>
	<%} %>
<%if(obFlag!=null && obFlag!=""){%>
<script>
		var actionTacken=document.getElementById("tempAction").value;
		document.getElementById("ActionType").value=actionTacken;
		actionType(actionTacken);
		document.getElementById("OnHoldReason").value=document.getElementById("tempOnHold").value;
		dayCalculate();
		
		
</script>
<%}%>
<div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
<%-- 	dateCalculation();
	function dateCalculation(){
		var difference=0;
		var day=0;
		var strDate=document.getElementById("PlannedStartDate").value;
		var endDate=document.getElementById("PlannedEndDate").value;
		 startDate=new Date(strDate.split("/")[1]+" "+strDate.split("/")[0]+', '+strDate.split("/")[2]);
		 endDate=new Date(endDate.split("/")[1]+" "+endDate.split("/")[0]+', '+endDate.split("/")[2]);
		 if(endDate>=startDate){
			difference = endDate - startDate;
			days = Math.round(difference/(1000*60*60*24));
			document.getElementById("Duration").value=days;
			return true;
		 }else{
			 alert("Date is Incorrect.");
			 document.getElementById("PlannedStartDate").value='<%=currentDate%>';
			 document.getElementById("PlannedEndDate").value='<%=currentDate%>';
			 return false;
		 }
		
	}
	
	function emergencyIndent(id){
		if(document.getElementById(id).checked){
			flag=confirm("You want to Emergency Workorder.");
			if(flag){
				return true;
			}else{
				return false;
			}
		}
	} --%>
</script>