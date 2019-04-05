<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
		SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
		Date wD=null;
		Date cd=new Date();
		Date amcDate=null;
		String status="";
		String s="";
		
		if(hesEquipmentMaster!=null && hesEquipmentMaster.size()!=0){
		if(hesEquipmentMaster.get(0).getWarrentyEndDate()!=null){
			wD=sd.parse(hesEquipmentMaster.get(0).getWarrentyEndDate().toString());
			} 
		
			if(wD!=null){
			if(wD.after(cd)){
				if("warranty".equalsIgnoreCase(hesEquipmentMaster.get(0).getWarrantyType())){
					status="Warranty";
				}else if("camc".equalsIgnoreCase(hesEquipmentMaster.get(0).getWarrantyType())){
					status="CAMC";
				}else if("cmc".equalsIgnoreCase(hesEquipmentMaster.get(0).getWarrantyType())){
					status="CMC";
				}else if("amc".equalsIgnoreCase(hesEquipmentMaster.get(0).getWarrantyType())){
					status="AMC";
				} 
			}else{
				status="None";
				}
			}
			else if(hesEquipmentAmcDetailsEntry.size()>0){
				amcDate=sd.parse(hesEquipmentAmcDetailsEntry.get(0).getAmcWarrentyEndDate().toString());
				if(amcDate.after(cd)){
					status="AMC";
				}else{status="None";}
			}else{status="None";}
			
			}
			String supplyOrderNo="N/A";
			String purchageDate="N/A";
			/* if(hesEquipmentMaster.get(0).getGrnT()!=null){
				if(hesEquipmentMaster.get(0).getGrnT().getGrnMaster()!=null){
					if(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo()!=null){
						supplyOrderNo=hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo().getPoNumber();
					if(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo().getPoDate()!=null)
						purchageDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo().getPoDate());
					}
				}
			} */
			String startDate="";
			String endDate="";
			String amcStartDate="";
			String amcEndDate="";
			String grnDate="";
			String poDate="";
			String installationDate="";
			int depreciation=0;
			Double price = 0.0;
			

			if(hesEquipmentMaster!=null && hesEquipmentMaster.size()!=0){
			if(status.equalsIgnoreCase("Warranty")){
				if(hesEquipmentMaster.get(0).getWarrentyStartDate()!=null){
					startDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getWarrentyStartDate());
				}
				if(hesEquipmentMaster.get(0).getWarrentyEndDate()!=null){
					endDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getWarrentyEndDate());
				}
				}
			}
			
			if(status.equalsIgnoreCase("AMC")){
				if(hesEquipmentAmcDetailsEntry!=null && hesEquipmentAmcDetailsEntry.size()>0){ 
				if(hesEquipmentAmcDetailsEntry.get(0).getAmcWarrentyStartDate()!=null){
					amcStartDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentAmcDetailsEntry.get(0).getAmcWarrentyStartDate());			
				}
				if(hesEquipmentAmcDetailsEntry.get(0).getAmcWarrentyEndDate()!=null){
					amcEndDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentAmcDetailsEntry.get(0).getAmcWarrentyEndDate());
				}
				}
			}
			if(hesEquipmentMaster!=null && hesEquipmentMaster.size()>0 && hesEquipmentMaster.get(0)!=null && hesEquipmentMaster.get(0).getDateOfInstallation()!=null )
			{
				installationDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getDateOfInstallation());
			}
			/* if(hesEquipmentMaster.get(0).getGrnT().getGrnMaster()!=null && hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getGrnDate() !=null )
			{
				grnDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getGrnDate());
			}
			if(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo()!=null && hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo().getPoDate() !=null )
			{
				poDate=HMSUtil.changeDateToddMMyyyy(hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getPo().getPoDate());
			} */
			%><input type="hidden" name="warrantyStatus" value="<%=status%>" />

		<% if(hesEquipmentMaster!=null && hesEquipmentMaster.size()>0){ %>
	 	<label>Item Code</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getItem().getPvmsNo() %></label> 
		<label>Item Name</label>
		<label class="value" style="font-size: 12px;font-weight: normal;height: 24px;"><%=hesEquipmentMaster.get(0).getItem().getNomenclature() %></label>
		<label>Model No/Serial No</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getModelName() %><%="/"+hesEquipmentMaster.get(0).getSerialNo() %></label>
	<%-- 	<div class="clear"></div>
		<label>Serial No</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getSerialNo() %></label> --%>
		
		<div class="clear"></div>
		
		
		<label>Manufacturer</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getManufacturer()!=null?hesEquipmentMaster.get(0).getManufacturer().getManufacturerName():"" %></label>
		<%-- <label>Supply Order No</label>
		<label class="value"><%=supplyOrderNo %></label> --%>
		<!-- <label>Equipment Status</label> -->
		
		<label>Equipment Status</label>
		<label class="value"><%=status %></label>
		
	
		
		<%--<label>Source Of Supply</label>
		<label class="value"> <%=hesEquipmentMaster.get(0).getGrnT().getGrnMaster().getReceiveType() %> --%></label>
		<%-- <label>Purchase Date</label>
		<label class="value"><%=purchageDate %></label>
		<label>Grn Date</label>
		<label class="value"><%=grnDate%></label>  --%>
		
		<label>Installation Date</label>
		<label class="value"><%=installationDate%></label> 
		<%-- <label>PO Date</label>
		<label class="value"><%=poDate%></label>  --%>
	    <label>Price</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getItem().getCostPrice()!=null?hesEquipmentMaster.get(0).getItem().getCostPrice():"" %></label> 
		
		<label>Depreciation</label>
		<label class="value"><%=hesEquipmentMaster.get(0).getDepreciation()!=null?hesEquipmentMaster.get(0).getDepreciation():"" %></label> 
		
		<%if(status=="Warranty"){ %>
		<label>Warranty Start Date</label>
		<label class="value"><%=startDate %></label>
		<label>Warranty End Date</label>
		<label class="value"><%=endDate %></label>
		<%} if(status=="AMC"){%>
		<label>AMC Start Date</label>
		<label class="value"><%=amcStartDate %></label>
		<label>AMC End Date</label>
		<label class="value"><%=amcEndDate %></label>
		<%
		if(hesEquipmentAmcDetailsEntry!=null && hesEquipmentAmcDetailsEntry.size()>0){%>
			<input type="hidden" name="amcId" value="<%=hesEquipmentAmcDetailsEntry.get(0).getId() %>" />
		<%}
		%> 
		<%} %>
<!-- 		<label>Requested Date</label> -->
<%-- 		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(serviceRequest.get(0).getRequestDate()) %></label> --%>
		<input type="hidden" name="equipmentId" value="<%=hesEquipmentMaster.get(0).getId() %>" />

		
		<% }%>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
