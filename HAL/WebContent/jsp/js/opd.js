/**
 * contains all method of opd and ipd page 
 */

var index = 0;
var jsonData;
var currentCountDisplayed;
var displaySearch;
var h = 80;
var dialogFormHTML;
var divDialogForm;
var txtId;
var selectedConceptId;
var stateParam;
var semantictagParam;
var acceptabilityParam;
var returnlimitParam;

var enumSERVICES = {
	SEARCH : {
		type : "search",
		suggestbyacceptability_url : "http://192.168.203.227:8080/csnoserv/api/search/suggestbyacceptability",
		searchbyacceptability_url : "http://192.168.203.227:8080/csnoserv/api/search/searchbyacceptability",
	},
};

var enumACCEPTABILITY = {
	ALL : "all",
	PREFERRED : "preferred",
	PREFERRED_EXCLUDING_FSN : "preferredexcludingfsn",
	SYNONYMS : "synonyms",
	ACCEPTABLE : "acceptable"
};
var enumSTATE = {
	BOTH : "both",
	ACTIVE : "active",
	INACTIVE : "inactive"
};

var enumSEMANTICTAG = {

	ALL : "all",
	PROCEDURE : "procedure",
	DISORDER : "disorder",
	FINDING : "finding",
	OBSERVABLE_ENTITY : "observable entity",
	BODY_STRUCTURE : "body structure",
	ORGANISM : "organism",
	SUBSTANCE : "substance",
	SPECIMEN : "specimen",
	SPECIAL_CONCEPT : "special concept",
	LINKAGE_CONCEPT : "linkage concept",
	PHYSICAL_FORCE : "physical force",
	EVENT : "event",
	ENVIRONMENT : "environment",
	GEOGRAPHIC_LOCATION : "geographic location",
	SOCIAL_CONCEPT : "social concept",
	SITUATION_WITH_EXPLICIT_CONTEXT : "situation",
	STAGING_SCALE : "staging scale",
	PHYSICAL_OBJECT : "physical object",
	QUALIFIER_VALUE : "qualifier value",
	RECORD_ARTIFACT : "record artifact",
	PERSON : "person",
	LINK_ASSERTION : "link assertion",
	NAMESPACE_CONCEPT : "namespace concept",
	ATTRIBUTE : "attribute",
	ASSESSMENT_SCALE : "assessment scale",
	RACIAL_GROUP : "racial group",
	TUMOR_STAGING : "tumor staging",
	OCCUPATION : "occupation",
	MORPHOLOGIC_ABNORMALITY : "morphologic abnormality",
	CELL : "cell",
	CELL_STRUCTURE : "cell structure",
	ETHNIC_GROUP : "ethnic group",
	PRODUCT : "product",
	INACTIVE_CONCEPT : "inactive concept",
	NAVIGATIONAL_CONCEPT : "navigational concept",
	LIFE_STYLE : "life style",
	REGIME_THERAPY : "regime/therapy",
	RELIGION_PHILOSOPHY : "religion/philosophy"
};

var enumLANGREFSET={
	UK: "uk",
	US: "us",
};
var enumRELATIONSHIP={
	IS_A: "is a",
	FINDING_SITE:"finding site",
	CAUSATIVE_AGENT:"causative agent",
	HAS_INTENT:"has intent",
	PROCEDURE_SITE:"procedure site",
	SPECIMEN_SUBSTANCE:"specimen substance",
	ASSOCIATED_FINDING:"associated finding",
	ASSOCIATED_WITH:"associated with",
	ASSOCIATED_MORPHOLOGY:"associated morphology",
	HAS_ACTIVE_INGREDIENT:"has active ingredient",
	PROCEDURE_SITE_DIRECT:"procedure site direct",
	SPECIMEN_SOURCE_TOPOGRAPHY:"specimen source topography",
	HAS_FOCUS:"has focus",
	HAS_MEASURED_COMPONENT:"has measured component",
	COMPONENT:"component",
	PROCEDURE_SITE_INDIRECT:"procedure site indirect",
	USING:"using",
	DIRECT_DEVICE:"direct device",
	USING_DEVICE:"using device",
	SPECIMEN_SOURCE_MORPHOLOGY:"specimen source morphology",
	DIRECT_MORPHOLOGY:"direct morphology ",
	INDIRECT_MORPHOLOGY:"indirect morphology ",
	PART_OF:"part of ",
	DUE_TO:"due to ",
	RECIPIENT_CATEGORY:"recipient category ",
	SUBJECT_RELATIONSHIP_CONTEXT:"subject relationship context ",
	DIRECT_SUBSTANCE:"direct substance ",
	USING_SUBSTANCE:"using substance ",
	INTERPRETS:"interprets ",
	SPECIMEN_PROCEDURE:"specimen procedure ",
	HAS_DEFINITIONAL_MANIFESTATION:"has definitional manifestation ",
	ASSOCIATED_ETIOLOGIC_FINDING:"associated etiologic finding ",
	HAS_INTERPRETATION:"has interpretation ",
	AFTER:"after ",
	METHOD:"method ",
	TEMPORALLY_FOLLOWS:"temporally follows ",
	ASSOCIATED_PROCEDURE:"associated procedure ",
	ASSOCIATED_FUNCTION:"associated function ",
	PROCEDURE_DEVICE:"procedure device ",
	REVISION_STATUS:"revision status ",
	MEASUREMENT_METHOD:"measurement method ",
	OCCURRENCE:"occurrence ",
	MEASURES:"measures ",
	PROCEDURE_MORPHOLOGY:"procedure morphology ",
	FINDING_METHOD:"finding method ",
	INDIRECT_DEVICE:"indirect device ",
	ROUTE_OF_ADMINISTRATION:"route of administration ",
	USING_ACCESS_DEVICE:"using access device ",
	TEMPORAL_CONTEXT:"temporal context ",
	APPROACH:"approach ",
	SURGICAL_APPROACH:"surgical approach ",
	SEVERITY:"severity ",
	COURSE:"course ",
	CLINICAL_COURSE:"clinical course ",
	LATERALITY:"laterality ",
	HAS_DOSE_FORM:"has dose form ",
	SPECIMEN_SOURCE_IDENTITY:"specimen source identity ",
	ACCESS_INSTRUMENT:"access instrument ",
	STAGE:"stage ",
	USING_ENERGY:"using energy ",
	ONSET:"onset ",
	INSTRUMENTATION:"instrumentation ",
	PRIORITY:"priority  ",
	EXTENT:"extent ",
	SCALE_TYPE:"scale type ",
	SUBJECT_OF_INFORMATION:"subject of information ",
	FINDING_CONTEXT:"finding context ",
	HAS_SPECIMEN:"has specimen ",
	ACCESS:"access ",
	PROPERTY:"property ",
	TIME_ASPECT:"time aspect ",
	EPISODICITY:"episodicity ",
	LOCATION:"location ",
	PATHOLOGICAL_PROCESS:"pathological process ",
	COMMUNICATION_WITH_WOUND:"communication with wound ",
	PROCEDURE_CONTEXT:"procedure context ",
	FINDING_INFORMER:"finding informer"
};


function loadResultsList(state, semantictag, acceptability, returnlimit, call,from) {
	jQuery(function ($) {
		if (document.getElementById("conceptdiv"))
			$("#conceptdiv").remove();
		
		if (displaySearch == false) {
			if (document.getElementById("conceptdiv"))
			$("#conceptdiv").remove();
			displaySearch = true;
		}
		if (displaySearch == true) {
			
			var dataValue = document.getElementById(from).value;
	
			if (dataValue.trim() == '') {
				if (document.getElementById("conceptdiv"))
					$("#conceptdiv").remove();
				var txtBox = document.getElementById(from);
				txtBox.focus();
				return;
			}
			var servURL = '';
	
			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
			
			servURL += "?term=" + encodeURIComponent(dataValue) + "&state=" + state
					+ "&semantictag=" + semantictag + "&acceptability=" + acceptability
					+ "&returnlimit=" + returnlimit+"&csrfTokenName"+'='+csrfTokenValue;
			
			$.ajax({
						type : "GET",
						url : servURL,
						dataType : "jsonp",
						crossDomain : true,
						success : function(data, textStatus, jqXHR) {
	
							var htmlData = '';
							jsonData = data;
							$('#reccount').text(data.length);
							if (data.length == 0) {
								
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								var txtBox = document
										.getElementById(from);
								txtBox.focus();
								return;
							}
	
							displaySearch = false;
	
							htmlData = '';
							htmlData += '<div class="concept" id="conceptdiv">';
	
							htmlData += '<table class="bordered">';
							htmlData += '<thead><tr><th>Description&nbsp;&nbsp;</th></tr></thead>';
							currentCountDisplayed = data.length;
							
							for (var i = 0; i < data.length; ++i) {
								var val = '\'' + data[i].conceptId + '###$$$'
										+ data[i].term + '###$$$' + data[i].id
										+ '\'';
	
								/*htmlData += '<tr title="' + data[i].conceptFsn
										+ '" onclick="selectValue(\'' + escape(val)
										+ '\',' + call + ');"><td>' + data[i].term
										+ '</td></tr>';*/
								
								var data = unescape(escape(val));
								var term = data.split('###$$$');
								var returnconceptid_OUT =term[0].replace("'", "");
								if(returnconceptid_OUT=="undefined"){
									break;
								}
								if (typeof call === "function"){
									call(returnconceptid_OUT);
								}	
								
							}
							
							
							htmlData += '</table>';
							htmlData += '</div>';
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(textStatus);
						}
					});
		}
	});
}

/*function selectValue(value, callback) {
	var data = unescape(value);
	var term = data.split('###$$$');
	var returnterm_OUT = "Description: " + term[1] + "\r\n" + "Concept Id: "
			+ term[0].replace("'", "") + "\r\n" + "Description id: "
			+ term[2].replace("'", "");
	
	var returnconceptid_OUT =term[0].replace("'", "");
	alert(returnconceptid_OUT);
	if (typeof callback === "function"){
		callback(returnconceptid_OUT);
	}	
}*/

function selectSNOMEDCT(state_IN, semantictag_IN, acceptability_IN, returnlimit_IN,	callback,from) {
	jQuery(function ($) {
	if (returnlimit_IN <= -1 || returnlimit_IN == '' || returnlimit_IN == undefined
			|| returnlimit_IN == null) {
		returnlimit_IN = -1;

	}
	returnlimitParam = returnlimit_IN;

	if (state_IN == -1 || state_IN == null || state_IN == ''
			|| state_IN == undefined) {
		state_IN = enumSTATE.BOTH;
	} else

		state_IN = enumSTATE[state_IN];

	stateParam = state_IN;

	if (semantictag_IN == -1 || semantictag_IN == null || semantictag_IN == undefined
			|| semantictag_IN == '') {
		semantictag_IN = enumSEMANTICTAG.ALL;
	} else
		semantictag_IN = enumSEMANTICTAG[semantictag_IN];

	semantictagParam = semantictag_IN;

	if (acceptability_IN == -1 || acceptability_IN == null
			|| acceptability_IN == undefined || acceptability_IN == '') {
		acceptability_IN = enumACCEPTABILITY.ALL;
	} else
		acceptability_IN = enumACCEPTABILITY[acceptability_IN];

	acceptabilityParam = acceptability_IN;
	
	jQuery('.ui-dialog button:nth-child(0)').button('disable');
	$('.ui-dialog-buttonpane').find("button").show().filter(":contains('.')").hide();
	
	var txtBox = document.getElementById(from);
	txtBox.focus();
	
	/*$("#"+from).keyup(
			function(e) {
				if (e.which == 13) {
					var dataValue = document
							.getElementById(from).value;
					if (dataValue == '') {
						var txtBox = document.getElementById(from);
						txtBox.focus();
						return;
					}
	
					if (dataValue.length >= 3) {
						if (document.getElementById("conceptdiv"))
							$("#conceptdiv").remove();
						$("#msg3chars").hide();
						$('#nosuggestion').hide();
						var txtBox = document
								.getElementById(from);
						txtBox.blur();
						loadResultsList(stateParam, semantictagParam,acceptabilityParam, returnlimitParam, callback);
					} else {
						if (document.getElementById("conceptdiv"))
							$("#conceptdiv").remove();
					}
				}
			});*/


	var xhrRequest = null;
	$("#"+from).autocomplete(
					{
						max : 20,
						minLength : 3,
						cacheLength : 1,
						scroll : false,
						width : 520,
						highlight : false,
						autoFocus : false,
						source : function(request, response) {

							var dataValue = document.getElementById(from).value;

							var servURL = "";
							if (dataValue == '') {
								$("#dialog-form").dialog("option", "height",
										160);
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								var txtBox = document
										.getElementById(from);
								txtBox.focus();
								return;
							}

							if (dataValue.length >= 3) {
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								$("#msg3chars").hide();
								$('#nosuggestion').hide();

							} else {
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
							}

							servURL = enumSERVICES.SEARCH.suggestbyacceptability_url;
							
							servURL += "?term="
									+ encodeURIComponent(request.term)
									+ "&state=" + stateParam + "&semantictag="
									+ semantictagParam + "&acceptability="
									+ acceptabilityParam + "&returnlimit=5";
							console.log(servURL);

							if (xhrRequest && xhrRequest.readystate != 4)
								xhrRequest.abort();
							xhrRequest = $
									.ajax({
										type : "GET",
										url : servURL,
										dataType : "jsonp",
										crossDomain : true,
										success : function(data, textStatus,
												jqXHR) {
											console.log(data);
											var items = data;
											
											response(items);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.log(textStatus);

										}
									});

						},
						select : function(event, ui) {
							var data = document.getElementById(from).value;
							if (data.length >= 3) {
								$("#msg3chars").hide();
								$('#nosuggestion').hide();
								document.getElementById(from).value = ui.item.value;
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								displaySearch=false;	
								loadResultsList(stateParam, semantictagParam,acceptabilityParam, returnlimitParam, callback,from);
							} else {
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
							}
						}

					});
	});
}
/*snomed codes ends*/

//var $ = jQuery.noConflict();

jQuery(function ($) {
	

	
	 $("#admDiv").hide();
	 $("#referDiv").hide();
	 $("#minorOTSchedulingDiv").hide();
	 $("#obg").hide();
	 $("#gyna").hide();
	 
	 
	 $("#referral").change(function(){
		 document.getElementById("referInternal").checked = true;
		if($("#referral").val()==1){
			checkReferTO('referInternal');
/*			if($("#referralotherpatient").val()=='y')
				{ 
			$("#admDiv").hide(); 
			$("#admissionAdvised").attr( "checked", false );
			$("#admissionAdvised").attr('disabled', true);
			$("#referInternal").attr('checked', true);
				}
			else
				{
				  $("#referral").val('0');
				  alert("Billable patient cannot refer to other Department");
				}*/
			
			$("#admDiv").hide(); 
			$("#admissionAdvised").attr( "checked", false );
			$("#admissionAdvised").attr('disabled', true);
			//$("#referInternal").attr('checked', true);
			$("#referInternal").attr('checked', 'checked');
			/*document.getElementById('referral_treatment_type').setAttribute("validate", " ");
			document.getElementById('referral_treatment_type').style.display='none';
			document.getElementById('referral_treatment_type_label').style.display='none';*/
			/*document.getElementById('referredFor').style.display='none';
			document.getElementById('referredForLabel').style.display='none';
			document.getElementById('referredFor').setAttribute("validate", " ");*/
			
		}else{
			document.getElementById('referhospital').setAttribute("validate", " ");
			document.getElementById('referredFor').setAttribute("validate", " ");
			 $("#referDiv").show();
			 
			$("#admissionAdvised").attr('disabled', false);
		}
	});
	 
	 
	 
	// $("").change(function(event){
		 
		 //$(document).delegate("#templateId","change",function(){
	 $(document).delegate("#templateId","change",function(){
		  //	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		  var templateId = document.getElementById('templateId').value;
		  	var totalRow= parseInt($("#nomenclaturehdb").val());
		  		var itemIdArray = "";
		  		$("#nomenclaturehdb").remove();
		  	   if(templateId==0)
		  	     {
		  		 var rowCount = $('#nomenclatureGrid tr').length;
			  		for(var i=0;i<=rowCount;i++) 
					{
			  		//$("#nomenclatureGrid tr:eq("+i+")").remove();
			  			$("#nomenclatureGrid > tr").remove();
			  			 //$().closest('tr').remove();
					}
			  		totalRow =1;
		  	     }
		  	   else{
		  		  //$("#nomenclaturehdb").remove();
			  	for(var i=1;i<=totalRow;i++) 
				{
			  	
				   if (document.getElementById("itemId"+i)!=null && $('#itemId'+i).val()!="")
					   itemIdArray += $('#itemId'+i).val()+",";
				}
		  	   
			  /* if(totalRow==1)
		  		   {*/
		  		   if(document.getElementById("nomenclature1")!=null&&document.getElementById("nomenclature1").value=="")
		  			   {
		  			   $("#nomenclatureGrid tr:eq(1)").remove();
		  			   }
		  		   //}
		  	
		  	 totalRow = totalRow+1;
		  	   }
			new Ajax.Request(
					'opd?method=showGridInMainJsp&hinId=' + document.getElementById('hinId').value+'&templateId='+document.getElementById('templateId').value+"&totalRow="+totalRow +"&itemIdArray="+itemIdArray,
					{
						 contentType: "application/json",
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								$('#nomenclatureGrid').append(response.responseText);
							}
						}
					});
			
		});
	 
		
	 $(document).delegate("#templateIdFAC","change",function(){
	 	  //	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
	 	  var templateIdFAC = document.getElementById('templateIdFAC').value;
	 	  	var totalRow= parseInt($("#hdb").val());
	 	  	
	 	  		var itemIdArray = "";
	 	  		$("#hdb").remove();
	 	  	   if(templateIdFAC==0)
	 	  	     {
	 	  		 var rowCount = $('#nomenclatureGrid tr').length;
	 		  		for(var i=0;i<=rowCount;i++) 
	 				{
	 		  		//$("#nomenclatureGrid tr:eq("+i+")").remove();
	 		  			$("#nomenclatureGrid > tr").remove();
	 		  			 //$().closest('tr').remove();
	 				}
	 		  		totalRow =1;
	 	  	     }
	 	  	   else{
	 	  		  //$("#nomenclaturehdb").remove();
	 		  	for(var i=1;i<=totalRow;i++) 
	 			{
	 		  	
	 			   if (document.getElementById("itemId"+i)!=null && $('#itemId'+i).val()!="")
	 				   itemIdArray += $('#itemId'+i).val()+",";
	 			}
	 	  	   
	 		  /* if(totalRow==1)
	 	  		   {*/
	 	  		   if(document.getElementById("nomenclature1")!=null&&document.getElementById("nomenclature1").value=="")
	 	  			   {
	 	  			   $("#nomenclatureGrid tr:eq(1)").remove();
	 	  			   }
	 	  		   //}
	 	  	
	 	  	 totalRow = totalRow+1;
	 	  	   }
	 		new Ajax.Request(
	 				'opd?method=showGridInMainJspFAC&hinId=' + document.getElementById('hinId').value+'&templateId='+document.getElementById('templateIdFAC').value+"&totalRow="+totalRow +"&itemIdArray="+itemIdArray,
	 				{
	 					 contentType: "application/json",
	 					onSuccess : function(response) {
	 						if (response.responseText.trim() != '') {
	 							$('#nomenclatureGrid').append(response.responseText);
	 						}
	 					}
	 				});
	 		
	 	});
	 
	 
	 
	 /*$("#investigationTemplateId").change(function(){*/
	$(document).delegate("#investigationTemplateId","change",function(){
		 
		  //	document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		  var templateId = document.getElementById('investigationTemplateId').value;
		  	var totalRow= parseInt($("#hiddenValue").val());
	  		var itemIdArray = "";
	  		$("#hiddenValue").remove();
		  	   if(templateId==0)
		  	     {
		  		 var rowCount = $('#investigationGrid tr').length;
			  		for(var i=0;i<=rowCount;i++) 
					{
			  		//$("#nomenclatureGrid tr:eq("+i+")").remove();
			  			$("#investigationGrid > tr").remove();
			  			 //$().closest('tr').remove();
					}
			  		totalRow =1;
		  	     }
		  	   else{
		  		  //$("#nomenclaturehdb").remove();
		  		   var val="";
		  		   var id=0;
			  	for(var i=1;i<=totalRow;i++) 
				{
			  	
				   if (document.getElementById("chargeCodeName"+i)!=null && $('#chargeCodeName'+i).val()!=""){
					   //itemIdArray += $('#itemId'+i).val()+",";
					   val = $('#chargeCodeName'+i).val();
				   var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
						  index1++;
					 id = val.substring(index1,index2);
					itemIdArray += id+",";
				   }
				}
		  	   
			   if(totalRow==1)
		  		   {
		  		   if(document.getElementById("chargeCodeName1")!=null&&document.getElementById("chargeCodeName1").value=="")
		  			   {
		  			   $("#investigationGrid tr:eq(2)").remove();
		  			   }
		  		   }
		  	
		  	 totalRow = totalRow+1;
		  	   }
		  	  
			new Ajax.Request(
					'opd?method=showGridForInvestigation&hinId=' + document.getElementById('hinId').value+'&investigationTemplateId='+templateId+"&totalRow="+totalRow +"&itemIdArray="+itemIdArray,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								//alert(response.responseText);
								$('#investigationGrid').append(response.responseText);
							}
						}
					});
			
		});
	 
	 $("#cycles").change(function(){
			if($("#cycles").val()=='Regular'){
				$("#cycle_text").show();
				document.getElementById('cycle_text').value="3-5/28-30";
				
			}
			else if($("#cycles").val()=='Irregular')
				{
				 $("#cycle_text").show();
				 if(document.getElementById("cycle_text_hidden")!=null)
					 document.getElementById('cycle_text').value=document.getElementById("cycle_text_hidden").value;
				 else
					 document.getElementById('cycle_text').value="";
				}
			else{
				 $("#cycle_text").hide();
				document.getElementById('cycle_text').value="";
			}
		});
	 
	 $("#external_genitalia").change(function(){
		 
			if($("#external_genitalia").val()=='Other'){
				$("#external_genitalia_other").show();
			}
		
			else{
				 $("#external_genitalia_other").hide();
				document.getElementById('external_genitalia_other').value="";
			}
		});
	 $("#removesnomedList").click(function(){
		 $("#snomedList option:selected").remove();
	 });
	 
	 $(".primary-items a").click(function () {
		    $(this).siblings('#subMenu').slideToggle();
		});

	
	
	
	$('input[name="labradiologyCheck"]').change(function(){
		//alert($('input[name="labradiologyCheck"]:checked').val());
		$('#investigationCategory').val($('input[name="labradiologyCheck"]:checked').val());
	});
	$('#investigationCategory').val($('input[name="labradiologyCheck"]:checked').val());
	
	$('input[name="surgeryCheck"]').change(function(){
		//alert($('input[name="labradiologyCheck"]:checked').val());
		$('#surgeryCategory').val($('input[name="surgeryCheck"]:checked').val());
	});
	$('#surgeryCategory').val($('input[name="surgeryCheck"]:checked').val());
	
	$('input[name="procedureCheck"]').change(function(){
		//alert($('input[name="labradiologyCheck"]:checked').val());
		$('#nursingCategory').val($('input[name="procedureCheck"]:checked').val());
	});
	$('#nursingCategory').val($('input[name="procedureCheck"]:checked').val());
	/*$("#vitalTrends").click(function(){
		var hinId=document.getElementById("hinId").value;;
		new Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='No vital Details')
    	    	  {		
	    	  		  $("#vitalUHID").val(document.getElementById("hinNo").value);
	    	    	  $("#vitalPname").val(document.getElementById("patientName").value); 
	    	    	  $("#vitalTable").html(response.responseText.trim()); 
	    	    	  $("#vitalDialog").dialog({width:842,height:332,modal: true});
    	    	  }else{
    	    		  alert("No vital details");
    	    	  }
	    	  }
	  	  });
		});
	 $("#calculateBmi").click(function(){
		 $("#dialog").css("color:black");
		 $("#dialog").dialog({width: 350,modal: true});
	 });*/
	 
	$("#resetBmi").click(function(){
			$("#height").val("");
			$("#weight").val("");
	});
	/* $("#submitCalBMI").click(function(){
		 var bmicat;
			$("#bmi").val("");
			
			if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
			{
			
			 $("#heightHidden").val($("#height").val());
			 $("#weightHidden").val($("#weight").val());
			 
			 var height = 	parseFloat($("#height").val())/100;
			 var weight = 	$("#weight").val();
			 
			 $("#bmi").val((weight/(height*height)).toFixed(2));
			 bmicat=(weight/(height*height)).toFixed(2);
			
			 $("#bmicat").val(" ");
			 if(bmicat<18.5){
				 $("#bmicat").val("Underweight");
				 $("#bmicat").prev().css('color', '#F65C5C');
				 $("#bmicat").css('color', '#F65C5C');
			}else if(bmicat>=18.5 && bmicat<25){
				$("#bmicat").val("Healthy Range");	
				$("#bmicat").prev().css('color', 'green');
				$("#bmicat").css('color', 'green');
			}else if(bmicat>=25 && bmicat<=30){
				$("#bmicat").val("Overweight");
				$("#bmicat").prev().css('color', '#574F4F');
				$("#bmicat").css('color', '#574F4F');
			}else if(bmicat>=30 && bmicat<=35){
				$("#bmicat").val("Obese");
				$("#bmicat").prev().css('color', '#C40707');
				$("#bmicat").css('color', '#C40707');
			}else if(bmicat>35){
				$("#bmicat").val("Severely obese ");
				$("#bmicat").prev().css('color', '#AD0C0C');
				$("#bmicat").css('color', '#AD0C0C');
			}
			}
			$("#bmicat").val()
			$('#dialog').dialog('close');
	});*/
	 
	 $("#temperature").blur(function (){
		if($("#temperature").val()>999 ){
			alert("Invalide Temperature");
			$("#temperature").focus();
			$("#temperature").val("");
		}
	}); 
	
	 /*$(".allownumericwithdecimal").on("keypress keyup blur",function (event) {
         //this.value = this.value.replace(/[^0-9\.]/g,'');
	  	$(this).val($(this).val().replace(/[^0-9\.]/g,''));
	         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) && ((event.keyCode !=  39)) && (event.keyCode != 9) && (event.keyCode != 8)&&(event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	             event.preventDefault();
	         }
	   });

	$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
        $(this).val($(this).val().replace(/[^\d].+/, ""));
         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) &&((event.keyCode !=  39))  && (event.keyCode != 9) && (event.keyCode != 8)&&(event.which < 48 || event.which > 57)) {
             event.preventDefault();
         }
     });*/

	 
	 $("#generalExamination1").dblclick(function(){
		 $("#generalExaminationOPC").val($.trim($("#generalExaminationOPC").val()+"\n"+$("#generalExamination1 option:selected" ).text()));
		 $("#generalExaminationEXM").val($.trim($("#generalExaminationEXM").val()+"\n"+$("#generalExamination2 option:selected" ).text()));
	 });
	 $("#generalExamination2").dblclick(function(){
		 $("#generalExaminationOPC").val($.trim($("#generalExaminationOPC").val()+"\n"+$("#generalExamination1 option:selected" ).text()));
		 $("#generalExaminationEXM").val($.trim($("#generalExaminationEXM").val()+"\n"+$("#generalExamination2 option:selected" ).text()));
	 });
	 $("#diastolic").blur(function(){
	    if(parseInt($("#systolic").val())<parseInt($("#diastolic").val())){
	    	alert("Diastolic should be less than Systolic");
	    	$("#diastolic").val("");
	    	$("#diastolic").focus();
	    }
	});
	 $("#removeOPDisgnosis").click(function(){
		 if($("#diagnosisId option:selected").length>1){
			 alert("You can delete only one option at a time !");
		 }else{
			 $("#diagnosisId option:selected").remove();
			 deleteRowFromOPConsultationTab($("#diagnosisId1 option:selected").index());
		 }
	}); 
	 $("#removeOPDisgnosis").click(function(){
		 if($("#diagnosisId option:selected").length>1){
			 alert("You can delete only one option at a time !");
		 }else{
			 $("#diagnosisId option:selected").remove();
			 deleteRowFromOPConsultationTab($("#diagnosisId1 option:selected").index());
		 }
	});
	 $("#removeSnomed").click(function(){
		 document.getElementById("snomed").value='';
	});
	 $("#icd").blur(function(){
		 var code1 = {};
		
		 $("select[name='diagnosisId'] > option").each(function () {
		     if(code1[this.text]) {
		         $(this).remove();
		     } else {
		         code1[this.text] = this.value;
		     }
		 }); 
		 
	 });
	 $('#admissionAdvised').click(function () {
		
		    $("#admDiv").toggle(this.checked);
	});
	 
	 $('#patient_expire').click(function () {
		 var checked = $(this).is(':checked');
		 $("#referral").val('0');
		 if(checked){
			 if($("#referral").val()==0){
     			 $("#referalDiv").hide();
			 	 $("#referDiv").hide();
			 	$("#siftedToMortuaryDiv").show();
			 }
		 }else{
     			$("#referalDiv").show();
			 	$("#referDiv").hide();
			 	$("#siftedToMortuaryDiv").hide();
		 }
	});
	 $('#referral').click(function () {
		var selVal= $("#referral").val();
		 if(selVal==0){
			 $("#referDiv").hide();
		 }else if(selVal==1){
			 $("#referDiv").show();
		 }
	});
	 
});




	if (!''.trim) {
	        String.prototype.trim = function() {
	            return this.replace(/^\s+|\s+$/g, '');
	        };
	    }
	

	function fnSubmitPatient(from){
		 if(from=='s'){
			 if(validateFieldValues(from)){
				if(confirm("Do you want to submit !")){
					submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2');
					
				}
			}   
		}else if(from=='n'){
			if(validateFieldValues(from)){
				if(confirm("Do you want to submit !")){
					submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1');
			    }
			} 
		}else if(from=='p'){
			if(validateFieldValues(from)){
				if(confirm("Do you want to park patient !")){
					submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=3');
			    }
			} 
		}else if(from=='secondop'){
			if(validateFieldValues(from)){
				if(confirm("Do you want patient send to Second Opinion !")){
					submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=4');
			    }
			}
		}
	}
		
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode1").value=icd_no;
	document.getElementById("icdCode").focus();
	}
	
	function checkFrequency(counter,loc){
		if(counter>0 && loc=="opc"){
			var obj=document.getElementById("frequency"+(counter-1));
			var unit=document.getElementById("unit"+(counter-1)).value;
			if(unit==""){
				alert("Unit not available");
				document.getElementById("nomenclature"+(counter-1)).focus();
				return;
			}	
			if(obj.selectedIndex==0){
					alert("Select Frequency");
					document.getElementById("frequency"+(counter-1)).focus();
					return;
			}	
			
		}else if(counter>0 && loc=="tab"){
			var obj=document.getElementById("frequencypTab"+(counter-1));
			var unit=document.getElementById("unitpTab"+(counter-1)).value;
			if(unit==""){
				alert("Unit not available");
				document.getElementById("nomenclaturepTab"+(counter-1)).focus();
				return;
			}
			if(obj.selectedIndex==0){
					alert("Select Frequency");
					document.getElementById("frequencypTab"+(counter-1)).focus();
					return;
			}
			
		}
	}
	
	function deleteRow(r) {
	    var i = r.parentNode.parentNode.rowIndex;
	    if(document.getElementById("diagnosisId1")!=null){
	    	document.getElementById("diagnosisId1").deleteRow(i);
		    var x = document.getElementById("diagnosisId");
		  //x.remove(x.selectedIndex);
		    x.remove((i-1));
	    }
	}
	function deleteRowFromOPConsultationTab(i) {
		if(document.getElementById("diagnosisId1")!=null){
			document.getElementById("diagnosisId1").deleteRow(i);
		}
	    //var x = document.getElementById("diagnosisId");
	    //x.remove((i-1));
	}
	
function checkEnteredDiagnosis(){
		if(document.getElementById('diagnosisId').length == 0 && document.getElementById('OtherDiagnosis').value.trim().length==0)
	     {
			 alert("Please Diagnos the deasease first");
			 var cntr=new ddtabcontent("countrytabsIn")
			 cntr.setpersist(true)
			 cntr.setselectedClassTarget("link")
			 cntr.init()
			 cntr.expandit(0);
			 document.getElementById("snomed").focus();
			 return true;
        }else{
        	return false;
        }
}


function checkDrugToDiseaseCantra(obj){
	jQuery(function ($) {
		var index1 = obj.value.lastIndexOf("(");
	    var index2 = obj.value.lastIndexOf(")");
	    index1++;
	    var itemId = obj.value.substring(index1,index2);
	    var diagObj=document.getElementById("diagnosisId");
	    var strText="";
		for(var i=0;i<diagObj.options.length;i++){
				 if(diagObj.options[i].selected ==true){
			    	 var icdCode =diagObj.options[i].value.split("@@@")[0];
			    	 new Ajax.Request('opd?method=checkDrugCantraIndicative&icdCode='+icdCode+"&itemId="+itemId+'&'+csrfTokenName+'='+csrfTokenValue, {
				    	  onSuccess: function(response) {
				    		  if(response.responseText.trim()!=" "){
	   					 		strText=response.responseText.trim();
	   						 	$("#cantraMsgDisease").html(strText);  
	   					 		$("#cantralabelDisease").show();
				    		  }else{
				    			  $("#cantralabelDisease").hide();
				    		  }
				    	}
				  	  });   
				 } 
			 } 	 
		});
}


function getLoincSnomedList(inc){
	jQuery(function ($) { 
		var labText=$("#chargeCodeName"+inc).val();
		new Ajax.Request('opd?method=getLoincSnomedList&labText='+labText+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	   if(response.responseText.trim()!='No Snomed Mapping Founds')
		    	  {		
	    	    	 $('#snomedTermsInv'+inc).val(response.responseText.trim())
		    	  }
	    	}
	  	  });   
	 });	
}
function deleteKeyword(str)
{
	var regex = new RegExp("(^" + str + "$\n|\n^" + str + "$)", "gim");
	var textarea = document.getElementById("systemicExamination");
	textarea.value = textarea.value.replace(regex, "");
}
function checkTextColor(id){
	 jQuery(function ($) {
		var text=$("#"+id).val();
		if(text==""){
			$("#"+id).css({ 'color': 'black', 'font-size': '125%' });			
		}
	 });	 
}


function validatePrescriptionAutocomplete(flag, strValue,inc ) {
	if(flag=='opmain'){
		var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    var count=document.getElementById('hdb').value;
	    if(id =="")
	    {		
	    		document.getElementById('nomenclature'+inc).value="";
				return ;
		}
	    
	    for(var i=0;i<count;i++)
		{
		if(document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value==strValue  && i!=inc)
			{
			alert('This Prescription is already selected.');
			document.getElementById('nomenclature'+inc).value="";
			return false;
			}
		}
			return true;	
	}else if(flag=='opPTab'){
		var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    var count=document.getElementById('hdb').value;
	    if(id =="")
	    {		
	    		document.getElementById('nomenclaturepTab'+inc).value="";
				return ;
		}
	    
	    for(var i=0;i<count;i++)
		{
		if(document.getElementById('nomenclaturepTab'+i)!=null && document.getElementById('nomenclaturepTab'+i).value==strValue  && i!=inc)
			{
			alert('This Prescription is already selected.');
			document.getElementById('nomenclaturepTab'+inc).value="";
			return false;
			}
		}
			return true;		
	}
	
}


function changeTest()
{
	var count=document.getElementById("hdb").value; 
	var val=document.getElementById("route"+count).value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
		  index1++;
	var id = val.substring(index1,index2);
	var text=val.replace("["+id+"]","");
	document.getElementById("route"+count).value=text;
	document.getElementById("routeHidden"+count).value=id;
}	
function changeTestpTab()
	{
	var count = document.getElementById('pTabhdb').value;
	var val=document.getElementById("routepTab"+count).value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
		  index1++;
	var id = val.substring(index1,index2);
	var text=val.replace("["+id+"]","");
	document.getElementById("routepTab"+count).value=text;
	//document.getElementById("routepTabId"+count).value=id;
}

function setEndDate(nod,inc){
	var nextDay;
	nextDay = new Date();
	nextDay.setDate(nextDay.getDate()+parseInt(nod));
	document.getElementById("endDate"+inc).value=nextDay.getDate()+"/"+(nextDay.getMonth()+1)+"/"+nextDay.getFullYear();
}
function showParkPatient(status){
    document.opdMain.action="/hms/hms/opd?method=getOPClinicalWaitingList&flag="+status;
    document.opdMain.submit();
 }


function fillDiagnosisCombo(val) {
	
	var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var id = val.substring(index1,index2);
    if(id ==""){
	  return;
	}else{
		var obj =document.getElementById('diagnosisId');
		var b="false";
		for(var i=0;i<obj.length;i++){
		    
        	var val1=obj.options[i].value;
        	var length=obj.length-1;
        	
        	if(id==val1)
        	{
            	alert("ICD  Already taken");
            	document.getElementById('icd').value =""
            	document.getElementById('icd2').value =""
            	b=true;
           	}
        }
	
        if(b=="false")
        {
        	var flag=2;
        	obj =document.getElementById('diagnosisId');
        	for(var x=0;x<obj.length;x++){
        		var dpId=obj.options[x].value;
        		dpId=dpId.split("-");
        		if(dpId[0]==id)
       			{
       				flag=1;
       				break;
       			}
        	}
        	if(flag!=1){
	        		obj.length = document.getElementById('diagnosisId').length;
	            	obj.length++;
	        		obj.options[obj.length-1].value=id+"-0";
	            	document.getElementById('icdCode').value =id;
	            	id=id.replace(".","_");
	            	id=id.replace("*","idid");
	            	id=id.replace("?","~");
	            	obj.options[obj.length-1].selected=true;
	    			obj.options[obj.length-1].text=val;
	    			document.getElementById('icd').value ="";
	    			document.getElementById('icd2').value ="";
	    			jQuery(function ($) {
	    			 $.post('opd?method=getDeseaseStatus&icdCode='+id+'&'+csrfTokenName+'='+csrfTokenValue, function( data ) {
	    					 try {	
	    							 var str=data.split("_");
	    							  var objColor =document.getElementById('diagnosisIdNP');
	    							  if(str[0]=="n"||str[0]=="N"){
	    								  var opt = document.createElement('option');
	    								  opt.value = id;
	    								  opt.innerHTML = val;
	    								  objColor.appendChild(opt);
	    								  objColor.options[objColor.length-1].style="color: #FF0000";
	    								  var code2 = {};
	    								  $("select[name='diagnosisIdNP'] > option").each(function () {
	    									     if(code2[this.value]) {
	    									         $(this).remove();
	    									     } else {
	    									         code2[this.value] = this.value;
	    									     }
	    									 });  
	    							  }
	    							  if(str[1]=="p"||str[1]=="P"){	
	    								  var opt = document.createElement('option');
	    								  opt.value = id;
	    								  opt.innerHTML = val;
	    								  objColor.appendChild(opt);
	    								  objColor.options[objColor.length-1].style="color:#008000";
	    								  var code2 = {};
	    								  $("select[name='diagnosisIdNP'] > option").each(function () {
	    									     if(code2[this.value]) {
	    									         $(this).remove();
	    									     } else {
	    									         code2[this.value] = this.value;
	    									     }
	    									 });  
	    							  } 
	    						} catch (e) {
	    						  alert(e);
	    						}
	    				}); 
	    			});  
	    		    obj =document.getElementById('diagnosisId1');
	    			var tableRow=obj.rows.length;
	    			var row = obj.insertRow(tableRow);
	    			var cell1 = row.insertCell(0);
	    			var cell2 = row.insertCell(1);
	    			var cell3 = row.insertCell(2);
	    			cell1.innerHTML=val;
	    			cell2.innerHTML = "<input type='checkbox' id='"+id+"' class='radioCheckCol2' value='"+id+"' onclick='fnCopyToComorbidityTab(\""+id+"\")'/>";
	    			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"    
        	}else{
        		alert("Diagnosis already exist.");
        	}
	   }
	}
}


function getIcd(from){
	var icdCode;
if(from==1){
	icdCode =document.getElementById("icdCode").value;
}else if(from==2){
	icdCode =document.getElementById("icdCode1").value
}	
 if(icdCode !="")
  {
  var xmlHttp;
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
	var b="false";
  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
  	for (loop = 0; loop < items.childNodes.length; loop++) {
   	    var item = items.childNodes[loop];
         icdString  = item.getElementsByTagName('icdString')[0];
         document.getElementById('icd').value =icdString.childNodes[0].nodeValue
         document.getElementById('icdCode').value="";
         document.getElementById('icdCode1').value="";
         var val=document.getElementById('icd').value;
         var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    if(id ==""){
			  return;
			}else{
				var obj =document.getElementById('diagnosisId');
				for(var i=0;i<obj.length;i++){
                	var val1=obj.options[i].value;
                	var length=obj.length-1;
                	if(id==val1)
                	{
                    	alert("ICD  Already taken");
                    	document.getElementById('icd').value =""
                    	document.getElementById('icd2').value =""
                    	b=true;
                   	}
                }
			}
		    if(!b){
		    	var flag=2;
		    	var obj=document.getElementById('diagnosisId');
            	for(var x=1;x<=obj.length;x++){
            		var dpId=obj.options[x].value;
            		dpId=dpId.split("-");
            		if(dpId[0]==id)
           			{
           				flag=1;
           				break;
           			}
            	}
            	if(flag!=1){
            		var length=obj.length+1;
                	obj.options[length].text=document.getElementById('icd').value;
            		obj.options[length].value=id+"-0";	
            	}else{
            		alert("Diagnosis already exist");
            	}
            	
		    }
  }
  }
  }
var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)+'&'+csrfTokenName+'='+csrfTokenValue;
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);

	}
} 



function checkVitals(){
	jQuery(function ($) {
		 if($("#observationStatus").prop("checked")){
			 if($("#pulse").val()==""){
					alert("Enter Pulse vital for observation");
					$("#pulse").focus();
				}else if($("#temperature").val()=="0.0"){
					alert("Enter Temperature vital for observation");
					$("#temperature").focus();
				}else if($("#diastolic").val()==""){
					alert("Enter diastolic vital for observation");
					$("#diastolic").focus();
				}else if($("#systolic").val()==""){
					alert("Enter systolic vital for observation");
					$("#systolic").focus();
				}			 
		 }
	});
}




function compareDate(idno){
	var sDate=document.getElementById("startDate"+idno).value;
	var eDate=document.getElementById("endDate"+idno).value;
	if(sDate!="" && eDate!=""){
		stDate= new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2));
		edDate= new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2));
		var seperator = "/"
		startDate = new Date();
		endDate = new Date();
		var month = stDate.getMonth() + 1
		var day = stDate.getDate();
		var year = stDate.getFullYear();
		startDate = new Date(month + seperator + day + seperator + year);
		
		month = edDate.getMonth() + 1
		day = edDate.getDate()
		year = edDate.getFullYear()
		endDate = new Date(month + seperator + day + seperator + year);
		if(startDate > endDate)
	 	{
	 		alert("StartDate should be not greater than EndDate !");
	 		document.getElementById("startDate"+idno).value="";
	 		document.getElementById("endDate"+idno).value="";
			return false;
	 	}
		 return true;
	}
}


function checkStartDate(nod){
	var dob =document.getElementById("startDate"+nod).value;
	if(dob!=""){
		adDate= new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
	 	currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		if(adDate < currentDate)
	 	{
	 		alert("Date is not valid. please check StartDate!");
	 		document.getElementById("startDate"+nod).value = "";
	 		document.getElementById("startDate"+nod).focus();
			return false;
	 	}
		 return true;
	}
}
function checkEndDate(nod){
	if(document.getElementById("EndDate"+nod)!=null){
		var dob =document.getElementById("EndDate"+nod).value;
		if(dob!=""){
			adDate= new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
		 	currentDate = new Date();
			var month = currentDate.getMonth() + 1
			var day = currentDate.getDate()
			var year = currentDate.getFullYear()
			var seperator = "/"
			currentDate = new Date(month + seperator + day + seperator + year);

			if(adDate < currentDate)
		 	{
		 		alert("Date is not valid. please check EndDate!");
		 		document.getElementById("EndDate"+nod).value= "";
		 		document.getElementById('EndDate'+nod).focus();
				return false;
		 	}
			 return true;
		}
	}
}

function getICDListBasedOnSnomedId()
{
	
	var $ = jQuery.noConflict();
	var val="";
	if($("#snomedTermConceptIdEXM").val()!=""){
		val=$("#snomedTermConceptIdEXM").val();
	}	
	if($("#snomedTermConceptId").val()!=""){
		val=$("#snomedTermConceptId").val();
	}
	var temp = val;
	$("#icdName").empty();
	$("#divIcdName").hide();
	
	$("#icdNameExm").empty();
	$("#divIcdNameExm").hide();
	
	if(val!= "")
		{
		//console.log("val="+val);
		//var index1 = val.lastIndexOf("[");
	    //var index2 = val.lastIndexOf("]");
	   // index1++;
	    var id =val; //val.substring(index1,index2);
	    
	    var tempStr=$("#snomed").val(); //val.substring(0,index1-1);
		var objsnomedList=document.getElementById('snomedList');
		var SnStatus=false;
		for(var i=0;i<objsnomedList.length;i++){
			var temp=$("#snomedList option").eq(i).text();
			if(temp==tempStr)
        		SnStatus=true;
        }
		if(!SnStatus && tempStr!=""){
			$("#snomedList").append("<option value='"+tempStr+"'>"+tempStr+"</option>");
			objsnomedList.options[objsnomedList.length-1].selected=true;
		}
		
	    var data = "snomedId="+id;
	    var url = "opd?method=getICDListBasedOnSnomedId&"+csrfTokenName+'='+csrfTokenValue;
	   
	    $("#icdName").empty();
	    document.getElementById('icdCode').value="";
	    document.getElementById('icd1').value="";
	    
	    jQuery(function ($) {
	  
	    	$.ajax({
				type:"POST",
				url: url,
				data: data,	
				dataType: "json",			
				cache: false,
				success: function(msg)
				{									 
					var jsonData = msg;						
					var totalMatches = jsonData.length;
					/*if(totalMatches == 0)
						{
							alert("ICD Name does not exist with this Snomed Name");
							return
						}*/
					if(totalMatches == 1)
						{
						
									var b=false;
									document.getElementById('icd1').value =jsonData[0].IndName+"["+jsonData[0].IcdCode+"@@@"+jsonData[0].SnomedId+"]";
							         document.getElementById('icdCode').value="["+jsonData[0].IcdCode+"]";
							         
							         var val=document.getElementById('icd1').value;
							         var index1 = val.lastIndexOf("[");
									    var index2 = val.lastIndexOf("]");
									    index1++;
									    var BothId = val.substring(index1,index2);
									    var tempArray = new Array();
									    tempArray = BothId.split("@@@");
									    var ICdId = tempArray[0];
									    var SnomedId = tempArray[1];
									    
									    var tempIcdId=ICdId;
									    tempIcdId=tempIcdId.replace(".","_");
									    tempIcdId=tempIcdId.replace("*","idid");
									    tempIcdId=tempIcdId.replace("?","~");
									    
									    if(id ==""){
										  return;
										}else{
											var obj =document.getElementById('diagnosisId');
											
											for(var i=0;i<obj.length;i++){
												var temp=$("#diagnosisId option").eq(i).val();
												/* var temp = obj.options[i].value;
           										var length=obj.length-1; */
           										var BothId = new Array();
												BothId=temp.split("-");	
												
												var tempArray =  new Array();
												tempArray = BothId[0].split("@@@");
												var tempICdId = tempArray[0];
												var tempSnomedId = tempArray[1];	
												/* alert("ICdId="+ICdId);
												alert("tempICdId="+tempICdId); */
							                	
							                	if(ICdId==tempICdId)
							                	{
							                    	alert("ICD  Already taken");
							                    	document.getElementById('icd').value =""
							                    	document.getElementById('icd2').value =""
							                    	b=true;
							                    	break
							                   	}
							                }
										}
									    if(!b){
									    	var flag=2;
									    	var obj=document.getElementById('diagnosisId');
									    
							            	for(var x=0;x<obj.length;x++){        		
							            		
							            		var temp=$("#diagnosisId option").eq(x).val();
							            		/* alert(temp); */
							            		var BothId=temp.split("-");	
												var tempArray =  new Array();
												tempArray = BothId[0].split("@@@");
												var tempICdId = tempArray[0];
												var tempSnomedId = tempArray[1];							       
									       		
									       		if(SnomedId==tempSnomedId)
									      			{
									      				flag=1;
									      				break;
									      			}
							            	}
							            
							            	if(flag!=1){
							            		var obj=document.getElementById('diagnosisId');
							            		var length=obj.length+1;
							            		
							            		$("#diagnosisId").append("<option value="+jsonData[0].IcdCode+"@@@"+jsonData[0].SnomedId+"-0>"+jsonData[0].IndName+"["+jsonData[0].IcdCode+"]</option>");
							            		
												obj.options[obj.length-1].selected=true;
												if(document.getElementById('diagnosisId1')!=null){
													obj =document.getElementById('diagnosisId1');
									    			var tableRow=obj.rows.length;
									    			var row = obj.insertRow(tableRow);
									    			var cell1 = row.insertCell(0);
									    			var cell2 = row.insertCell(1);
									    			var cell3 = row.insertCell(2);
									    			cell1.innerHTML=jsonData[0].IndName+"["+jsonData[0].IcdCode+"]";
									    			cell2.innerHTML = "<input type='checkbox' id='"+tempIcdId+"' class='radioCheckCol2' value='"+tempIcdId+"' onclick='fnCopyToComorbidityTab(\""+tempIcdId+"\")'/>";
									    			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
												}
								    			notifiablePregisterCheck(tempIcdId,jsonData[0].IndName+"["+jsonData[0].IcdCode+"]");
							            	}else{
							            		alert("Diagnosis already exist");
							            	}
									}
						}
					
					if(parseInt(totalMatches)>1)
						{
						
								$("#divIcdName").show();
								$("#icdName").append("<option value='0'>Select</option>");
								for(i=0;i<jsonData.length;i++)
								{			
									
									$("#icdName").append("<option value="+jsonData[i].IcdCode+"@@@"+jsonData[i].SnomedId+">"+jsonData[i].IndName+"["+jsonData[i].IcdCode+"]</option>");
									
									
								}
								
								$("#divIcdNameExm").show();
								$("#icdNameExm").append("<option value='0'>Select</option>");
								for(i=0;i<jsonData.length;i++)
								{			
									
									$("#icdNameExm").append("<option value="+jsonData[i].IcdCode+"@@@"+jsonData[i].SnomedId+">"+jsonData[i].IndName+"["+jsonData[i].IcdCode+"]</option>");
									
									
								}
								
						}
					
				},
				error: function(msg)
				{					
					
					//alert("An error has occurred while contacting the server");
					
					
				}
				
				
			});
	    });   
	 
		
		
		}// close else
	$("#snomed").val("");
	$("#icd2").val("");
	$("#snomedTermConceptId").val("");
	$("#snomedTermConceptIdEXM").val("");

}

function fillICDValue(val2,from)
{

	var b=false;
	if(val2 != 0)
		{
	
		 var $ = jQuery.noConflict();
		 document.getElementById('icd1').value =val2;
		 var tempVal2=val2;
		 tempVal2=tempVal2.replace(".","_");
		 tempVal2=tempVal2.replace("*","idid");
		 var tempVal22=tempVal2.split("@@@");
		 if(from=="op"){
		 	var text = $("#icdName option:selected").text();
		 	$('#icdNameExm').prop('selectedIndex', $("select[name='icdName'] option:selected").index());
		 }else if(from=="exm"){
			var text = $("#icdNameExm option:selected").text();
			$('#icdName').prop('selectedIndex', $("select[name='icdNameExm'] option:selected").index());
		 }
		

		 if(from=="op"){
			 document.getElementById('icd1').value = $("#icdName option:selected").text();
		 }else if(from=="exm"){
			 document.getElementById('icd1').value = $("#icdNameExm option:selected").text();
		 }
	
			   
			    tempArray = val2.split("@@@");
			    var ICdId = tempArray[0];
			    var SnomedId = tempArray[1];			   
			    document.getElementById('icdCode').value=ICdId;
			    
			    if(ICdId ==""){
				  return;
				}else{
					var obj =document.getElementById('diagnosisId');
					
					for(var i=0;i<obj.length;i++){
						var temp=$("#diagnosisId option").eq(i).val();
						
							var BothId = new Array();
						BothId=temp.split("-");	
						
						var tempArray =  new Array();
						tempArray = BothId[0].split("@@@");
						var tempICdId = tempArray[0];
						var tempSnomedId = tempArray[1];	
						/* alert("ICdId="+ICdId);
						alert("tempICdId="+tempICdId); */
	                	
	                	if(ICdId==tempICdId)
	                	{
	                    	alert("ICD  Already taken");
	                    	document.getElementById('icd').value =""
	                    	document.getElementById('icd2').value =""
	                    	b=true;
	                    	break
	                   	}
	                }
				}
			    var flag=2;
		    	var obj=document.getElementById('diagnosisId');		    
            	for(var x=0;x<obj.length;x++){        		
            		
            		var temp=$("#diagnosisId option").eq(x).val();
            		
            		var BothId=temp.split("-");	
					var tempArray =  new Array();
					tempArray = BothId[0].split("@@@");
					var tempICdId = tempArray[0];
					var tempSnomedId = tempArray[1];							       
		       		
		       		if(SnomedId==tempSnomedId)
		      			{
		      				flag=1;
		      				break;
		      			}
            	}
            	
		       	if(flag!=1){
		       		var obj=document.getElementById('diagnosisId');
		       		var length=obj.length+1;      		
		         
		       		$("#diagnosisId").append("<option value="+val2+"-0>"+text+"</option>");
		       		obj.options[obj.length-1].selected=true;
		       		
		       		if(document.getElementById('diagnosisId1')!=null){
		       			obj =document.getElementById('diagnosisId1');
		    			var tableRow=obj.rows.length;
		    			var row = obj.insertRow(tableRow);
		    			var cell1 = row.insertCell(0);
		    			var cell2 = row.insertCell(1);
		    			var cell3 = row.insertCell(2);
		    			cell1.innerHTML=text;
		    			cell2.innerHTML = "<input type='checkbox' id='"+tempVal22[0]+"' class='radioCheckCol2' value='"+tempVal22[0]+"' onclick='fnCopyToComorbidityTab(\""+tempVal22[0]+"\")'/>";
		    			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
		       		}
	    			notifiablePregisterCheck(tempVal22[0],text);
		       	}else{
		       		alert("Diagnosis already exist");
		       	}
		       	
		       	
		}// if close
}

function setIcdCodeAndNameFromChildWindow(tempValue)
{
	
	 var $ = jQuery.noConflict();
	 var b=false;
		document.getElementById('icd1').value =tempValue;
		
		var index = tempValue.indexOf("@@@");
		var exactValue= tempValue.substring(0,index);
		exactValue = exactValue+"]";
     
      
      var val=document.getElementById('icd1').value;
      var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var BothId = val.substring(index1,index2);
	    var tempArray = new Array();
	    tempArray = BothId.split("@@@");
	    var ICdId = tempArray[0];
	    var SnomedId = tempArray[1];
	    document.getElementById('icdCode').value="["+ICdId+"]";
	    
	
	    var tempVal2=ICdId;
	   	tempVal2=tempVal2.replace(".","_");
	    tempVal2=tempVal2.replace("*","idid");
		    
		    
		    /* alert("ICdId="+ICdId);
			alert("SnomedId="+SnomedId);  */
		    if(ICdId ==""){
			  return;
			}else{
				var obj =document.getElementById('diagnosisId');
				
				for(var i=0;i<obj.length;i++){
					var temp=$("#diagnosisId option").eq(i).val();
					/* var temp = obj.options[i].value;
					var length=obj.length-1; */
					var BothId = new Array();
					BothId=temp.split("-");	
					
					var tempArray =  new Array();
					tempArray = BothId[0].split("@@@");
					var tempICdId = tempArray[0];
					var tempSnomedId = tempArray[1];	
					/* alert("ICdId="+ICdId);
					alert("tempICdId="+tempICdId); */
             	
             	if(ICdId==tempICdId)
             	{
                 	alert("ICD  Already taken");
                 	document.getElementById('icd').value =""
                 	document.getElementById('icd2').value =""
                 	b=true;
                 	break
                	}
             }
			}
		    if(!b){
		    	var flag=2;
		    	var obj=document.getElementById('diagnosisId');
		    
         	for(var x=0;x<obj.length;x++){        		
         		
         		var temp=$("#diagnosisId option").eq(x).val();
         		/* alert(temp); */
         		var BothId=temp.split("-");	
					var tempArray =  new Array();
					tempArray = BothId[0].split("@@@");
					var tempICdId = tempArray[0];
					var tempSnomedId = tempArray[1];							       
		       		
		       		if(SnomedId==tempSnomedId)
		      			{
		      				flag=1;
		      				break;
		      			}
         	}
         
         	if(flag!=1){
         		var obj=document.getElementById('diagnosisId');
           		var length=obj.length+1;      		
           		$("#diagnosisId").append("<option value="+ICdId+"@@@"+SnomedId+"-0>"+exactValue+"</option>");
           		obj.options[obj.length-1].selected=true;
           		
           	if(document.getElementById('diagnosisId1')!=null){
           		obj =document.getElementById('diagnosisId1');
      			var tableRow=obj.rows.length;
      			var row = obj.insertRow(tableRow);
      			var cell1 = row.insertCell(0);
      			var cell2 = row.insertCell(1);
      			var cell3 = row.insertCell(2);
      			cell1.innerHTML=exactValue;
      			cell2.innerHTML = "<input type='checkbox' id='"+tempVal2+"' class='radioCheckCol2' value='"+tempVal2+"' onclick='fnCopyToComorbidityTab(\""+tempVal2+"\")'/>";
      			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
           	}	
  			notifiablePregisterCheck(tempVal2,exactValue);
         	}else{
         		alert("Diagnosis already exist!");
         	}
         	
		}
}
function notifiablePregisterCheck(id,val){
	 jQuery(function ($) {
		 $.post('opd?method=getDeseaseStatus&icdCode='+id+'&'+csrfTokenName+'='+csrfTokenValue, function( data ) {
				 try {
						 var str=data.split("_");
						  var objColor =document.getElementById('diagnosisIdNP');
						  if(str[0]=="n"||str[0]=="N"){
							  var opt = document.createElement('option');
							  opt.value = id;
							  opt.innerHTML = val;
							  objColor.appendChild(opt);
							  objColor.options[objColor.length-1].style="color: #FF0000";
							  var code2 = {};
							  $("select[name='diagnosisIdNP'] > option").each(function () {
								     if(code2[this.value]) {
								         $(this).remove();
								     } else {
								         code2[this.value] = this.value;
								     }
								 });  
						  }
						  if(str[1]=="p"||str[1]=="P"){	
							  var opt = document.createElement('option');
							  opt.value = id;
							  opt.innerHTML = val;
							  objColor.appendChild(opt);
							  objColor.options[objColor.length-1].style="color:#008000";
							  var code2 = {};
							  $("select[name='diagnosisIdNP'] > option").each(function () {
								     if(code2[this.value]) {
								         $(this).remove();
								     } else {
								         code2[this.value] = this.value;
								     }
								 });  
						  } 
					} catch (e) {
					  alert(e);
					}
			}); 
	}); 
}



function showHideDrugTemplateCombo(valueOfTemplate){
		if(valueOfTemplate=="0"){
      		 return false;
        }else{
	  	//document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		submitProtoAjaxForOpdMainTemplate('opdMain','/hms/hms/opd?method=showGridInMainJsp','divTemplet');
	}
}
function showTreatment()
{
   	var url="/hms/hms/opd?method=showTreatmentPopUp"+"&"+csrfTokenName+"="+csrfTokenValue;
    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=yes,resizable=0");
}
//written by rajendra kumar :18-04-2015
function showWaitingList () {
	var url='/hms/hms/opd?method=getOPClinicalWaitingList'+'&'+csrfTokenName+'='+csrfTokenValue;
	window.location.href=url;			 	
}

function popwindowImmunization(url)
{
	var height=550;
	var width=1010;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	//url = url +"&"+csrfTokenName+"="+csrfTokenValue;
	window.open( url, "Patient Details","resizable=0,scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left )

 }
function popFuturConsultation(url)
{
	var height=250;
	var width=1100;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	url = url +"&"+csrfTokenName+"="+csrfTokenValue;
	window.open( url, "Patient Details","resizable=0,scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left )

 }


/*Template : 17-04-2015*/
   
	 function getPresentTemplate(tempCode,fieldId)
	{
	//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
		 if(fieldId==undefined)
			 fieldId='';
		 var url='/hms/hms/opd?method=showPopUpHistoryTemplate&tempCode='+tempCode+"&fieldId="+fieldId;
	 popwindow(url);
	} 
	 
	 function getFamilyHistoryTemplate(tempCode)
	 {
		 
	// var url='/hms/hms/opd?method=showPopUpFamilyHistory&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
		 var url='/hms/hms/opd?method=showPopUpHistoryTemplate&tempCode='+tempCode;
	  popwindow(url);
	 }
	 
	 function getHistoryOfPastIllnessTemplate(csrf)
	 {
	 var url='/hms/hms/opd?method=showPopUpHistoryOfPastIllness&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 
	 function getPersonalHistoryTemplate(csrf)
	 {
	 var url='/hms/hms/opd?method=showPopUpPersonalHistory&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 
	 function getMedicationHistoryTemplate(csrf)
	 {
	 var url='/hms/hms/opd?method=showPopUpMedicationHistory&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }

	 function getGeneralExaminationTemplate(csrf)
	 {
	 var url='/hms/hms/opd?method=showPopUpGeneralExamination&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 } 
	 
	 function getSystemicExaminationTemplate(csrf)
	 {
	 var url='/hms/hms/opd?method=showPopUpSystemicExamination&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 } 
	 
var newwindow;
function popwindow(url)
{
//url = url+'&'+csrfTokenName+'='+csrfTokenValue;
	url = url;
 newwindow=window.open(url,'name','height=500,width=800,status=1');
 if (window.focus) 
 {
 newwindow.focus()
 }
 newwindow.createPopup();
}


function openPopupDiagnosisWindow()
{
	 var $ = jQuery.noConflict();
	$("#divIcdName").hide();
	$("#snomed").val("");
 var url="/hms/hms/adt?method=showICDSearchJsp&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
}


function addTermInSelect(termId,term,action,code){
	/* Delete duplicate entry options*/
	var desSelect=document.getElementById("disorder");
	if(desSelect.length>0){
		for(var x=0;x<desSelect.length;x++){
			if(desSelect[x].id==termId){
				desSelect.remove(x);
			}
		}
	}
 	desSelect=document.getElementById("finding");
	if(desSelect.length>0){
		for(var x=0;x<desSelect.length;x++){
			if(desSelect[x].id==termId){
				desSelect.remove(x);
			}
		}
	}

	/* Add new options */
	var select = null;
	var newOption = document.createElement("option");
	newOption.id =termId;
	newOption.text =term;
	newOption.value =termId+":"+term;
	newOption.setAttribute("selected", "selected");
	if(code==1){
		select=document.getElementById("disorder");
		if(action==1){
			select.appendChild(newOption);	
		}else if(action==2){
			  for (var i=0; i<select.length; i++){
			  if (select.options[i].id == termId )
				  select.remove(i);
			  }
		}
	}else if(code==2){
		select=document.getElementById("finding");
		if(action==1){
			select.appendChild(newOption);	
		}else if(action==2){
			 for (var i=0; i<select.length; i++){
			  if (select.options[i].id == termId )
				  select.remove(i);
			  }
		}
	}
}	



function jsSetSnomedFindingData(findingCode)
{
document.getElementById("finding").value=findingCode;
document.getElementById("finding").focus();
}

function openPopupWindowSnomedCT(code)
{
 var url="/hms/hms/opd?method=showSnomedCTSearchJsp&code="+code+"&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'opd_window',"left=100,top=100,height=640,width=850,status=1,scrollbars=yes,resizable=0");
}


function addRowTreatmentNursingCare(){

	  var tbl = document.getElementById('gridNursing');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('nursinghdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='nursingRadio'+iteration;
	  e1.id='nursingRadio'+iteration;
	  e1.className='radioCheck';
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='procedureDetailId'+iteration;
	  e1.id='procedureDetailId'+iteration;
	  e1.className="opdTextBoxSmall textYellow";
	  e1.size='35';
	  cellRight1.appendChild(e1);
	  
	
	  
	  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='procedureName_nursing'+iteration;
	  e1.id='procedureName_nursing'+iteration;
	  e1.className="opdTextBoxSmall textYellow";
	  e1.size='35';
	  e1.onblur = function(event) {
		  validateNursingCare(this.value,iteration);
  	};
	  
	  var e03 = document.createElement('input');
	  e03.type = 'hidden';
	  e03.name='procedureType'+iteration;
	  e03.id='procedureType'+iteration;
	  e03.value='';
	  e03.className="opdTextBoxSmall textYellow";
	  e03.size='35';
	  cellRight1.appendChild(e03);
	  
	  cellRight1.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates_nursing'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('procedureName_nursing'+iteration,'ac2updates_nursing'+iteration,'registration?method=getProcedureForAutoComplete',{
		  callback: function(element, entry) {
	            return entry + '&minor_major=1'+'&procedureType=' + document.getElementById('nursingCategory').value;;
	        }, parameters:'requiredField=procedureName_nursing'+iteration});
    
   var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='frequency_nursing'+iteration;
	  e1.id='frequency_nursing'+iteration;
	  e1.options[0] = new Option('Select', '0'); 
	   for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight2.appendChild(e1);
	  
	  var cellRight3 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='noOfDays_nursing'+iteration;
	  e1.className="opdTextBoxTSmall textYellow";
	  e1.id='noOfDays_nursing'+iteration;
	  e1.size='5';
	  cellRight3.appendChild(e1); 
	  
	  var cellRight4 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='remark_nursing'+iteration;
	  e1.id='remark_nursing'+iteration;
	  e1.setAttribute('maxLength','100');
	  e1.className="largTextBoxOpd textYellow";
	  cellRight4.appendChild(e1);
	 
	 /*  var cellRight5 = row.insertCell(5);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='alert'+iteration;
	  e1.id='alert'+iteration;
	  e1.className="radioCheck";
	  e1.size='5';
	  cellRight5.appendChild(e1); */
	}

function addRowTherapy(procedureType){

	  
	  var tbl = document.getElementById('gridTherapy');
	  var lastRow = tbl.rows.length;
    var i=0;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('therapyhdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(i);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='therapyRadio'+iteration;
	  e1.id='therapyRadio'+iteration;
	  e1.className='radioCheck';
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='therapyDetailId'+iteration;
	  e1.id='therapyDetailId'+iteration;
	  e1.className="opdTextBoxSmall textYellow";
	  e1.size='35';
	  cellRight1.appendChild(e1);
	  
	  if(procedureType=='d'){
		  i++;
	  var cellRight4 = row.insertCell(i);
	  	  var e1 = document.createElement('input');
	  e1.type = "text";
	  e1.name='proc_treatment_teeth'+iteration;
	  e1.id='proc_treatment_teeth'+iteration;
	  e1.setAttribute('maxlength', 40);
	  e1.value="";
	  cellRight4.appendChild(e1);
	  }
	  
	  i++;
	  var cellRight1 = row.insertCell(i);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='therapy_nursing'+iteration;
	  e1.id='therapy_nursing'+iteration;
	  e1.className="opdTextBoxSmall textYellow";
	  e1.size='35';
		  e1.onfocus = function(event) {
			  fillProcedure(this,iteration);
  	};
	  
	  cellRight1.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates_therapy'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('therapy_nursing'+iteration,'ac2updates_therapy'+iteration,'registration?method=getProcedureForAutoComplete&procedureType='+procedureType,{
		  callback: function(element, entry) {
	            return entry + '&minor_major=1';
	        }, parameters:'requiredField=therapy_nursing'+iteration});
  
 /*var cellRight2 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='frequency_nursing'+iteration;
	  e1.id='frequency_nursing'+iteration;
	  e1.options[0] = new Option('Select', '0'); 
	   for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight2.appendChild(e1);
	  
	  var cellRight3 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='noOfDays_nursing'+iteration;
	  e1.className="opdTextBoxTSmall textYellow";
	  e1.id='noOfDays_nursing'+iteration;
	  e1.size='5';
	  cellRight3.appendChild(e1); 
	  */
	  
	
	  i++;
	  var cellRight4 = row.insertCell(i);
	  var e1 = document.createElement('input');
	  e1.type = "radio";
	  e1.checked=true
	  e1.setAttribute('style', "margin:-3px 5px 0px 0px"); 
	  e1.name='appointStatus'+iteration;
	  e1.id='close'+iteration;
	  e1.value="c";
/*	 e1.onclick = function(event) {
		  clearAppointment("appointmentDate"+iteration+",appointmentTime"+iteration);
			e4.setAttribute('onclick', "setdate('26/07/2017',document.getElementById('appointmentDate"+iteration+"'),event)"); 
	  	};*/
		e1.setAttribute("onclick", "clearAppointment('appointmentDate"+iteration+"','appointmentTime"+iteration+"',"+iteration+")"); 
	  
	  var div = document.createElement("div");
	  div.style.width = "110px";
	  div.style.float = "left";
	  div.innerHTML = "Close";
	  div.appendChild(e1);
	  cellRight4.appendChild(div);
	  
	  var e2 = document.createElement('input');
	  e2.type = "radio";
	  e2.setAttribute('style', "margin:-3px 5px 0px 0px"); 
	  e2.name='appointStatus'+iteration;
	  e2.id='nextAppoint'+iteration;
	  e2.value="na";
	  e2.setAttribute("onclick", "markAppointMandatory("+iteration+")");
	  var div2 = document.createElement("div");
	  div2.style.width = "115px";
	  div2.style.float = "left";
	  div2.innerHTML = "Next Appointment";
	  div2.appendChild(e2);
	  cellRight4.appendChild(div2);
	  
	  
	  var e2 = document.createElement('input');
	  e2.type = "radio";
	  e2.setAttribute('style', "margin:-3px 5px 0px 0px"); 
	  e2.name='appointStatus'+iteration;
	  e2.id='appoint'+iteration;
	  e2.setAttribute("onclick", "markAppointMandatory("+iteration+")");
	  e2.value="a";
	  var div2 = document.createElement("div");
	  div2.style.width = "110px";
	  div2.style.float = "left";
	  div2.innerHTML = "Appointment";
	  div2.appendChild(e2);
	  cellRight4.appendChild(div2);
	  
	  var br = document.createElement('br');
	  cellRight4.appendChild(br);
	  
	  var e3 = document.createElement('input');
	  e3.type = "text";
	  e3.name='appointmentDate'+iteration;
	  e3.placeholder="DD/MM/YYYY";
	  e3.value="";
	  e3.className='calDate';
	  e3.id='appointmentDate'+iteration;
		 e3.setAttribute("onblur", "validateExpDate(this,'appointmentDate"+iteration+"')");
		 e3.setAttribute("onkeyup", "mask(this.value,this,'2,5','/')");
		 
		 
	  var div3 = document.createElement("div");
	  div3.style.width = "110px";
	  div3.style.float = "left";
	  div3.innerHTML = "Appointment Date <span id='appointDateSpan"+iteration+"' style='display: none'>*</span>";
	  cellRight4.appendChild(div3);
	  cellRight4.appendChild(e3);
	  
	/*  var e3 = document.createElement('input');
	  e3.type = "text";
	  e3.name='appointmentDate'+iteration;
	  e3.id='appointmentDate'+iteration;
	  var div3 = document.createElement("div");
	  div3.style.width = "110px";
	  div3.style.float = "left";
	  div3.innerHTML = "Appointment Date <span id='appointDateSpan"+iteration+"' style='display: none'>*</span>";
	  cellRight4.appendChild(div3);
	  cellRight4.appendChild(e3);
	  
	  var e4 = document.createElement('img');
	  e4.src = '/hms/jsp/images/cal.gif';
	  e4.name='appointmentDate'+iteration;
	  e4.id='calendar';
	  e4.width='16';
	  e4.height='16';
	  e4.onclick = function(event) {
		  setdate(document.getElementById('consultationDate'),document.getElementById('appointmentDate'+iteration,'event'));
  	};
  	e4.setAttribute('onclick', "setdate(document.getElementById('consultationDate'),document.getElementById('appointmentDate"+iteration+"'),event)"); 
	  cellRight4.appendChild(e4);*/
	  
	  
	  
	  var br1 = document.createElement('br');
	  cellRight4.appendChild(br1);
	  var br1 = document.createElement('br');
	  cellRight4.appendChild(br1);
	  var e5 = document.createElement('input');
	  e5.type = "text";
	  e5.name='appointmentTime'+iteration;
	  e5.id='appointmentTime'+iteration;
	 e5.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e5.setAttribute("onkeyup", "mask(this.value,this,'2',':')");

	  
	  var div4 = document.createElement("div");
	  div4.style.width = "110px";
	  div4.style.float = "left";
	  div4.innerHTML = "Appointment Time <span id='appointTimeSpan"+iteration+"' style='display: none'>*</span>";
	  cellRight4.appendChild(div4);
	  cellRight4.appendChild(e5);
	  
	  i++;
	  var cellRight4 = row.insertCell(i);
	  var e1 = document.createElement('textarea');
	  e1.setAttribute('maxlength', 300);
	  e1.setAttribute('style', "width:250px;height:50px"); 
	  e1.className='large';
	  e1.name='remark_therapy'+iteration;
	  e1.id='remark_therapy'+iteration;
	  e1.className="largTextBoxOpd textYellow";
	  cellRight4.appendChild(e1);
	  
	 /*  var cellRight5 = row.insertCell(5);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='alert'+iteration;
	  e1.id='alert'+iteration;
	  e1.className="radioCheck";
	  e1.size='5';
	  cellRight5.appendChild(e1); */
	}

function removeRowTreatmentNursingCare ()
{
	var tbl = document.getElementById('gridNursing');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('nursinghdb');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("nursingRadio"+i)!=null && (typeof  document.getElementById("nursingRadio"+i).checked)!='undefined' && document.getElementById("nursingRadio"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 2){
	    	  for(var i=1;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("nursingRadio"+i)!=null && (typeof  document.getElementById("nursingRadio"+i).checked)!='undefined' && document.getElementById("nursingRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("nursingRadio"+i).parentNode.parentNode;
	    		  document.getElementById("nursingRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
}

function removeRowTherapy  ()
{
	var tbl = document.getElementById('gridTherapy');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('therapyhdb');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	 // alert("f"+lastRow);
	  for(var i=0;i<=iteration;i++)
		  {
		  if(document.getElementById("therapyRadio"+i)!=null && (typeof  document.getElementById("therapyRadio"+i).checked)!='undefined' && document.getElementById("therapyRadio"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 1){
	    	  for(var i=0;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("therapyRadio"+i)!=null && (typeof  document.getElementById("therapyRadio"+i).checked)!='undefined' && document.getElementById("therapyRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("therapyRadio"+i).parentNode.parentNode;
	    		  document.getElementById("therapyRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
}



function addRowTreatmentSurgery(){

	  var tbl = document.getElementById('gridSurgery');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('surgeryhdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='surgeryRadio'+iteration;
	  e1.id='surgeryRadio'+iteration;
	  e1.className='radioCheck';
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='surgeryDetailsId'+iteration;
	  e1.id='surgeryDetailsId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='procedureName_surgery'+iteration;
	  e1.id='procedureName_surgery'+iteration;
	  e1.className="opdTextBoxSmall textYellow";
	  e1.size='35';
	  
	  cellRight2.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates_surgery'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete textYellow";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('procedureName_surgery'+iteration,'ac2updates_surgery'+iteration,'opd?method=getNursingCareProcedureAutoList',{minChars:3,
		  callback: function(element, entry) {
	            return entry + '&minor_major=2';
	        }, parameters:'requiredField=procedureName_surgery'+iteration});
      
	  
	  var cellRight3 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='tentativeDate'+iteration;
	  e1.id='tentativeDate'+iteration;
	  e1.size='5';
	  e1.value="";
	  e1.className='small textYellow';
	  e1.readOnly=true;
	  cellRight3.appendChild(e1);
	 
	  var img1 = document.createElement('img');
	  img1.src = '/hms/jsp/images/cal.gif';
	  img1.onclick=function(event)
      {	
		  var obj=document.getElementById('tentativeDate'+iteration);
		  setdate(document.createElement('consultationDate').value,obj,event);
      };
	  cellRight3.appendChild(img1);
	  
	  
	  var cellRight4 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.name='remark_surgery'+iteration;
	  e1.id='remark_surgery'+iteration;
	  e1.className="largTextBoxOpd textYellow";
	  cellRight4.appendChild(e1);
	  
	  var cellRight5 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='alertToStaff'+iteration;
	  e1.id='alertToStaff'+iteration;
	  e1.onclick = function(){displayPhAlert(this.value,iteration)};
	  e1.size='5';
	  cellRight5.appendChild(e1); 
	  
	  //var cellRight5 = row.insertCell(5);
		/*var e1 = document.createElement('select');
		e1.options[0] = new Option('Select', '');
		e1.options[1] = new Option('Delivery', 'DL');
		e1.options[2] = new Option('Birth', 'BR');
		e1.options[3] = new Option('Communicable Disease', 'CD');
		e1.options[4] = new Option('Non Communicable Disease', 'NCD');
		e1.options[5] = new Option('Pregnancy Diagnosed', 'PD');
		e1.options[6] = new Option('MTP', 'MTP');
		e1.options[7] = new Option('Abbortion', 'AB');
		e1.style.display='none';
		e1.name = 'phAlert'+ iteration;
		e1.id = 'phAlert' + iteration;
		e1.tabIndex="1";
		cellRight5.appendChild(e1);*/
	 
	 
	  
	}


function addRowForComorbidity(){

	  var tbl = document.getElementById('comorbidityGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('comorbidityCount');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='comorbidityRadio'+iteration;
	  e0.id='comorbidityRadio'+iteration;
	  e0.className='radioCheck';
	  cellRight1.appendChild(e0);
	  
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'comorbidityName' + iteration;
	  e0.id = 'comorbidityName' + iteration;
	  e0.size = '20'
	  e0.className="opdTextBoxSmall textYellow";
	  cellRight0.appendChild(e0);

	  var updatediv = document.createElement('div');
	  updatediv.setAttribute('id', 'ac2updateComorbidity'+iteration);
	  updatediv.style.display = 'none';
	  updatediv.className = "autocomplete textYellow";
	  cellRight0.appendChild(updatediv);
	  new Ajax.Autocompleter('comorbidityName'+iteration,'ac2updateComorbidity'+iteration,'opd?method=getICDList',{parameters:'requiredField=icd'});

	  var cellRight3 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='comorbidityMonth'+iteration;
	  e0.id='comorbidityMonth'+iteration;
	  e0.size='20'
	  e0.className="opdTextBoxSmall textYellow";
	  cellRight3.appendChild(e0);
	  
	  var cellRight3 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='comorbidityYear'+iteration;
	  e0.id='comorbidityYear'+iteration;
	  e0.size='20'
	  e0.className="opdTextBoxSmall textYellow";
	  cellRight3.appendChild(e0);
	  
	  var cellRight3 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='comorbidityRemark'+iteration;
	  e0.id='comorbidityRemark'+iteration;
	  e0.size='20'
	  e0.className="opdTextBoxSmall textYellow";
	  cellRight3.appendChild(e0);
	}




function removeRowTreatmentSurgery ()
{
	var tbl = document.getElementById('gridSurgery');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('surgeryhdb');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("surgeryRadio"+i)!=null && (typeof  document.getElementById("surgeryRadio"+i).checked)!='undefined' && document.getElementById("surgeryRadio"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 2){
	    	  for(var i=1;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("surgeryRadio"+i)!=null && (typeof  document.getElementById("surgeryRadio"+i).checked)!='undefined' && document.getElementById("surgeryRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("surgeryRadio"+i).parentNode.parentNode;
	    		  document.getElementById("surgeryRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
}	


function checkTemplateId(templateId){
  //alert(templateId)
  if(templateId=="0"){
    return false;
    }else
       return true;
}



function validateBpValue(obj){
	var bpObj = document.getElementById('bp');
	 var bool =validateBpWithSlash(obj)
	if(bool)
	{

	if(obj != ""){
	var index=obj.indexOf('/');
	if(index != 3){
		 alert("BP should be in max/min Format.")
		 bpObj.value="";
		 bpObj.focus();
		 return false;
		 }


		 var pairs2 = obj.substring(0,obj.length).split('/');
		 if (pairs2.length!=2) {
			 alert("Invalid  Format.")
			return false;
			}

		val3=eval(pairs2[0]);
		if (val3>240) {
		  alert("Maximum BP should be less than 240.")
		 return false;}

		val2=eval(pairs2[1]);
		if (val2<60 ) {
		  alert("Minimum BP should be greater than 60")
		  return false;}


	}
	return true;
	}
	bpObj.value="";
	bpObj.focus();
	return false;
	}






function validateInvestigationAutoComplete(strValue,inc ) {

			var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    var count=document.getElementById('hiddenValue').value;
	    
	    //alert("inc----"+inc)
	    if(id =="")
	    {		
	    		document.getElementById('chargeCodeName'+inc).value="";
   				//document.getElementById('chargeCode'+inc).value="";
					return ;
			}
	    
	    for(var i=0;i<=count;i++)
    	{
    	if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value==strValue  && i!=inc)
    		{
    		alert('This Investigation is already selected.');
    		document.getElementById('chargeCodeName'+inc).value="";
				//document.getElementById('chargeCode'+inc).value="";
    		return false;
    		}
    	}
			return true;
	}



function validateBpWithSlash(strValue){
	if(strValue != ""){
	var objRegExp = "/^(\d{1,}[\/]\d*)$/";
	obj =  objRegExp.test(strValue);
	if(!obj){
		alert("BP is not having Valid Value.");
		return false;
	}
	return true;
  }
}

function validateTemp( strValue ) {
			 var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
			return objRegExp.test(strValue);
	}






/*written code by rajendra kumar : 29-04-2015 :add remove row of allegy grid START*/
function removeRowForAllergy ()
{
  var tbl = document.getElementById('alergyGrid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('allergyCount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=0;i<=iteration;i++)
	  {
	  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=0;i<=iteration;i++)
    	  {
    		  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("allergyRadio"+i).parentNode.parentNode;
    		  document.getElementById("allergyRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}



function removeForComorbidity ()
{
var tbl = document.getElementById('comorbidityGrid');
var lastRow = tbl.rows.length;
var hdb = document.getElementById('comorbidityCount');
var iteration = parseInt(hdb.value);
var totalSelected=0;
for(var i=1;i<=iteration;i++)
{
if(document.getElementById("comorbidityRadio"+i)!=null && (typeof  document.getElementById("comorbidityRadio"+i).checked)!='undefined' && document.getElementById("comorbidityRadio"+i).checked )
  {
  totalSelected=totalSelected+1;
  }
}
if(totalSelected==0)
{
alert('Please select atleast 1 row to delete');
}
else  if(lastRow==2 || lastRow==(totalSelected+1))
{
  alert('You can not delete all Row.');
}
else if (lastRow > 2){
  for(var i=1;i<=iteration;i++)
  {
	  if(document.getElementById("comorbidityRadio"+i)!=null && (typeof  document.getElementById("comorbidityRadio"+i).checked)!='undefined' && document.getElementById("comorbidityRadio"+i).checked )
	  {
	  var deleteRow= document.getElementById("comorbidityRadio"+i).parentNode.parentNode;
	  document.getElementById("comorbidityRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	  }
  }
}
}




function addRowForAllergy(){
	var tbl = document.getElementById('alergyGrid');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('allergyCount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='allergyRadio'+iteration;
	e1.id='allergyRadio'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);
	
	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name='allergyDetailId'+iteration;
	e1.id='allergyDetailId'+iteration;
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name='allergyType'+iteration;
	e1.id='allergyType'+iteration;
	e1.style.background="#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for(var i = 0;i<allergyTypeArray.length;i++ ){
		e1.options[i+1] = new Option(allergyTypeArray[i][1],allergyTypeArray[i][0]);
	} 
	
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='allergyName'+iteration;
	e1.id='allergyName'+iteration;
	e1.className="largTextBoxOpd textYellow ";
	e1.maxLength="60";
	e1.size='20'
	cellRight1.appendChild(e1);
	/* 
	var newdiv = document.createElement('div');
    newdiv.setAttribute('id', 'allergy_ac2updates'+iteration);
    newdiv.style.display = 'none';
    newdiv.className = "autocomplete textYellow";
    cellRight1.appendChild(newdiv);
    new Ajax.Autocompleter('allergyName'+iteration,'allergy_ac2updates'+iteration,'opd?method=getItemListForAutoCompleteItemAllergy',{minChars:3,
	 callback: function(element, entry) {
        return entry + '&allergyTypeCheck=' + document.getElementById('allergyType'+iteration).value;
  	},parameters:'requiredField=allergyName'+iteration});
   */
	
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name='allergyseverity'+iteration;
	e1.id='allergyseverity'+iteration;
	e1.style.background="#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for(var i = 0;i<saverityCodeArray.length;i++ ){
		e1.options[i+1] = new Option(saverityCodeArray[i][1],saverityCodeArray[i][0]);
	} 
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='allergymonth'+iteration;
	e1.id='allergymonth'+iteration;
	e1.size='20';
		e1.maxLength="2";
		e1.validate="Allergy Year,int,no";
	e1.className="small textYellow";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='allergyyear'+iteration;
	e1.id='allergyyear'+iteration;
	e1.size='20';
		e1.maxLength="2";
		e1.validate="Allergy Month,int,no";

	e1.className='small textYellow';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name='allergystatus'+iteration;
	e1.id='allergystatus'+iteration;
	e1.style.background="#FFFF99";
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Active', '1');
	e1.options[2] = new Option('Inactive', '2');
	cellRight1.appendChild(e1);
	}






/*written code by rajendra kumar : 29-04-2015 :add remove row of allegy grid END
function addRow(){

  var tbl = document.getElementById('grid');
  var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value)+1;
  document.getElementById('hdbTabIndex').value=hdbTabIndex;
  				  
  var lastRow = tbl.rows.length;

  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);
  var hdb = document.getElementById('hdb');
  iteration = parseInt(hdb.value)+1;
  hdb.value=iteration;
//  document.getElementById('pulse').value=hdb.value;
  
  var cellRight1 = row.insertCell(0);
  var e1 = document.createElement('input');
  e1.type = 'checkbox';
  e1.name='itemRadio'+iteration;
  e1.id='itemRadio'+iteration;
  e1.className='radioCheck';
  e1.onchange=function(){
	 checkPrescriptionCheck(iteration);
  }; 
  e1.tabIndex =hdbTabIndex+"1" ;
  cellRight1.appendChild(e1);
  
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='prescription_availableStatus'+iteration;
  e1.id='prescription_availableStatus'+iteration;
  e1.className="textYellow grdTextSmall";
  cellRight1.appendChild(e1);
  
  
  var cellRight1 = row.insertCell(1);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='nomenclature'+iteration;
  e1.id='nomenclature'+iteration;
  e1.className="textYellow largTextBoxOpd";
  e1.onfocus=function(){checkEnteredDiagnosis();checkFrequency(iteration,"opc");}
  e1.onkeypress=function(){checkTextColor('nomenclature'+iteration);};
  e1.onblur=function(){checkForAlreadyIssuedPrescribtion(this.value,iteration);populatePVMS(this.value,iteration);checkItem(iteration);copyToPrescriptionTAb(iteration,'opconsult');
  						ValidateCantra();displayAu(this.value,iteration);validatePrescriptionAutocomplete('opmain',this.value,iteration);checkForAllergy(this.value,iteration);};
  e1.size='35';
  e1.tabIndex =hdbTabIndex+"2" ;
  cellRight1.appendChild(e1);
  e1.focus();
  
  var newdiv = document.createElement('div');
  newdiv.setAttribute('id', 'ac2updates'+iteration);
  newdiv.style.display = 'none';
  newdiv.className = "autocomplete";
  cellRight1.appendChild(newdiv);
  new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature'+iteration});


  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='brandId'+iteration;
  e1.id='brandId'+iteration;
  cellRight1.appendChild(e1);
  
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='manufactureId'+iteration;
  e1.id='manufactureId'+iteration;
  cellRight1.appendChild(e1);
  
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='pvmsNo'+iteration;
  e1.id='pvmsNo'+iteration;
  cellRight1.appendChild(e1);
  
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='actualDispensingQty'+iteration;
  e1.id='actualDispensingQty'+iteration;
  cellRight1.appendChild(e1);
  
   var cellRight1 = row.insertCell(2);
  var e1 = document.createElement('input');
  e1.name='route'+iteration;
  e1.id='route'+iteration;
  e1.className="textYellow opdgridText";
  e1.onblur=function() { fillRouteOnTAb(iteration);};
  cellRight1.appendChild(e1);
  
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='routeHidden'+iteration;
  e1.id='routeHidden'+iteration;
  e1.className="textYellow opdgridText";
  cellRight1.appendChild(e1);
  
  var newdiv = document.createElement('div');
  newdiv.setAttribute('id', 'ac2updatesRoute'+iteration);
  newdiv.style.display = 'none';
  newdiv.className = "autocomplete";
  cellRight1.appendChild(newdiv);
  new Ajax.Autocompleter('route'+iteration,'ac2updatesRoute'+iteration,'opd?method=getRouteAutoList',{minChars:1,parameters:'requiredField=route'+iteration,afterUpdateElement : changeTest});
 
   var cellRight1 = row.insertCell(2);
  var e1 = document.createElement('Select');
  e1.name='route'+iteration;
  e1.id='route'+iteration;
  e1.style.width = "90px";
  e1.style.background="#FFFF99";
  e1.tabIndex =hdbTabIndex+"3" ;
  e1.options[0] = new Option('Select', '0');
  for(var i = 0;i<routeArray.length;i++ ){
	e1.options[i+1] = new Option(routeArray[i][1],routeArray[i][0]);
  }
  e1.onblur=function() { fillRouteOnTAb(iteration);};
  cellRight1.appendChild(e1); 
  
  var cellRight1 = row.insertCell(3);
  var e1 = document.createElement('input');
  e1.name='dosage'+iteration;
  e1.id='dosage'+iteration;
  e1.className="textYellow opdTextBoxTSmall";
  e1.onblur=function()
  {
	  fillValue(this.value,iteration);
  }; 
  e1.tabIndex =hdbTabIndex+"4" ;
  cellRight1.appendChild(e1);
 
  var cellRight1 = row.insertCell(4);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='unit'+iteration;
  e1.id='unit'+iteration;
  e1.className='textYellow opdTextBoxTSmall';
  e1.readOnly='readOnly';
  e1.tabIndex =hdbTabIndex+"5" ;
  cellRight1.appendChild(e1);
  
  
  var cellRight1 = row.insertCell(5);
  var e1 = document.createElement('Select');
  e1.name='frequency'+iteration;
  e1.id='frequency'+iteration;
  e1.style.width = "90px";
  e1.style.background="#FFFF99";
  e1.tabIndex =hdbTabIndex+"6" ;
  e1.options[0] = new Option('Select', '0'); 
   for(var i = 0;i<icdArray.length;i++ ){
      e1.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
      }
  e1.onblur=function() {getFrequencyValue(this.value,iteration);fillValue(this.value,iteration);displaySOSQty(this.value,iteration);};
  cellRight1.appendChild(e1);
  
  var e21 = document.createElement('input');
  e21.type = 'hidden';
  e21.name='sosQty'+iteration;
  e21.id='sosQty'+iteration;
  e21.size='5';
  e21.setAttribute('tabindex','1');
  cellRight1.appendChild(e21);
  
  var e21 = document.createElement('input');
  e21.type = 'hidden';
  e21.name='frequencyValue'+iteration;
  e21.id='frequencyValue'+iteration;
  e21.size='5';
  e21.setAttribute('tabindex','1');
  cellRight1.appendChild(e21);
  
  
  var cellRight1 = row.insertCell(6);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='noOfDays'+iteration;
  e1.className="textYellow opdTextBoxTSmall";
  e1.id='noOfDays'+iteration;
  e1.size='3';
  e1.tabIndex =hdbTabIndex+"7" ;
  e1.onblur=function()
  {
	  fillValueDays(iteration);fillValue(this.value,iteration);
  }; 
  cellRight1.appendChild(e1);
  
  var cellRight1 = row.insertCell(7);
  var e1 = document.createElement('Select');
  e1.name='instrunction'+iteration;
  e1.id='instrunction'+iteration;
  e1.style.width = "90px";
  e1.style.background="#FFFF99";
  e1.tabIndex =hdbTabIndex+"8" ;
  e1.options[0] = new Option('Select', '0');
  for(var i = 0;i<instructionArray.length;i++ ){
      e1.options[i+1] = new Option(instructionArray[i][1],instructionArray[i][0]);
      }	
  e1.onblur=function()
  {
	  fillInstrunctionOnTAb(iteration);
  };
  cellRight1.appendChild(e1);
  
  var cellRight1 = row.insertCell(8);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='splInstrunction'+iteration;
  e1.id='splInstrunction'+iteration;
  e1.tabIndex =hdbTabIndex+"9" ;
  e1.className="textYellow opdTextBoxSmall";
  e1.onblur=function()
  {
	  fillSPLInstrunctionOnPTAb(iteration);
  };
  e1.size='5';
  cellRight1.appendChild(e1);
  
  
  var cellRight1 = row.insertCell(9);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='total'+iteration;
  e1.id='total'+iteration;
  e1.className="textYellow opdTextBoxTSmall";
  e1.readOnly='readOnly';
  e1.size='5';
  cellRight1.appendChild(e1);

  var cellRight1 = row.insertCell(10);
  var e1 = document.createElement('input');
  e1.type = 'text';
  e1.name='unitLable'+iteration;
  e1.id='unitLable'+iteration;
  e1.className="textYellow opdTextBoxTSmall";
  e1.readOnly='readOnly';
  e1.size='5';
  cellRight1.appendChild(e1);

}*/
function addRow(){
	   var visitId =  document.getElementById('visitId').value;
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;
	
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 

	e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
	   								disableOtherMedicine(this.value,iteration);
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);disableOtherMedicine(this.value,iteration);checkForAlreadyIssuedPrescription(this.value,iteration,visitId);displayAu(this.value,iteration,'<%= hinId%>');checkForPurchase(this.value,iteration);checkForContradiction(this.value,iteration); 
						   }
	                       else
							    {
							    		document.getElementById('nomenclature'+iteration).value="";
		   								document.getElementById('pvmsNo'+iteration).value="";
		   								document.getElementById('itemId'+iteration).value="";
		   								disableOtherMedicine(this.value,iteration);
							     return;
							    }
	                       
	  					  };
	  
	var newdiv = document.createElement('div');
     	    newdiv.id='ac2update'+iteration;
     	    newdiv.className='autocomplete';
       	newdiv.style.display = 'none';
          e0.size = '30';
	        e0.setAttribute('tabindex','1');

		var e01 = document.createElement('input');
	  e01.type = 'hidden';
	  e01.name = 'itemId' + iteration;
	  e01.id = 'itemId' + iteration;
	  e0.focus();
	  var e02 = document.createElement('input');
	  e02.type = 'hidden';
	  e02.name = 'itemIdClassificationId' + iteration;
	  e02.id = 'itemIdClassificationId' + iteration;
	
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(e01);
	  cellRight0.appendChild(e02);
	  cellRight0.appendChild(newdiv);

	  
	  
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	   //alert("name--"+e0.name)
//alert("4---");
	    /* var cellRight1 = row.insertCell(1);
	    var eImg = document.createElement('img');
	  eImg.src = '/hms/jsp/images/search.gif';
	  eImg.name = 'search' + iteration;
	  eImg.id = 'search' + iteration;
	  eImg.WIDTH = '26';
	  eImg.HEIGHT = '26';
	  //eImg.id = 'billDateId'+iteration;
	  eImg.onclick = function(){
	   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
	    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
	  cellRight1.appendChild(eImg);*/
	//  alert("5---");
	
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}
	  else{readOnlyNomenclature(this.value,iteration);} };
	  cellRight1.appendChild(e11);

	   var cellRight2 = row.insertCell(2);
	  var e12 = document.createElement('Select');
	  e12.name='itemClass'+iteration;
	  e12.id='itemClass'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<itemClassArray.length;i++ ){
	      e12.options[i+1] = new Option(itemClassArray[i][1],itemClassArray[i][0]);
	      }
	  cellRight2.appendChild(e12); 

	  //itemClassArray
	  
	   var cellRight14 = row.insertCell(3);
	  var e12 = document.createElement('Select');
	  e12.name='itemConversionId'+iteration;
	  e12.id='itemConversionId'+iteration;
	  e12.className='medium';
	  //e2.class = 'medium';
	  e12.setAttribute('tabindex','1');
	  e12.options[0] = new Option('Select', '0');
	   for(var i = 0;i<unitArray.length;i++ ){
	      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
	      }
	  cellRight14.appendChild(e12); 
	  
	   var cellRight15 = row.insertCell(4);
		  var e12 = document.createElement('Select');
		  e12.name='dispensingUnit'+iteration;
		  e12.id='dispensingUnit'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<unitArray.length;i++ ){
		      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
		      }
		  cellRight15.appendChild(e12); 
	  

	  
	 // var cellRight3 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight15.appendChild(e15);
	  
	  var e016 = document.createElement('input');
	  e016.type = 'hidden';
	  e016.name='itemClassCode'+iteration;
	  e016.id='itemClassCode'+iteration
	  e016.size='6';
	  e016.setAttribute('tabindex','1');
	  cellRight15.appendChild(e016);
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.name='au'+iteration;
	  e13.id='au'+iteration
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight15.appendChild(e13);

	 
	  cellRight15.appendChild(e1);
	  
	  
	 /* var cellRight3 = row.insertCell(4);
	  var e31 = document.createElement('input');
	  e31.type = 'checkbox';
	  e31.name='injCategory'+iteration;
	  e31.id='injCategory'+iteration
	  e31.size='10';
	  e31.className='radio';
	  e31.value='y';
	  e31.setAttribute('tabindex','1');
	  cellRight3.appendChild(e31);*/

	  var cellRight4 = row.insertCell(5);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(6);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	   for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(7);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='5';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);

	  
		var cellRight16 = row.insertCell(8);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	 // validate="total,num,no"
	  e5.setAttribute('validate','total,num,no');
	  cellRight16.appendChild(e5);

	  /*
	  var cellRight6 = row.insertCell(6);
	  var e6 = document.createElement('Select');

	  e6.name='instructionACPC'+iteration;
	  e6.id='instructionACPC'+iteration;
	  e6.classname='smalllabel';
	  e6.setAttribute('tabindex','1');
	  e6.options[0] = new Option('Select', '');
	  e6.options[1] = new Option('AC', 'AC');
	  e6.options[2] = new Option('PC', 'PC',true);
	  cellRight6.appendChild(e6);


	  var cellRight7 = row.insertCell(7);
	   var e7 = document.createElement('Select');

	  e7.name='typeLeftRight'+iteration;
	  e7.id='typeLeftRight'+iteration;
	  e7.classname='smalllabel';
	  e7.setAttribute('tabindex','1');
	   e7.options[0] = new Option('Select', '');
	   e7.options[1] = new Option('Left', 'left');
	   e7.options[2] = new Option('Right', 'right');
	   cellRight7.appendChild(e7);
*/

	//	var cellRight7 = row.insertCell(7);
		
		

		var cellRight8 = row.insertCell(9);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6);

	  var cellRight9 = row.insertCell(10);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

/* 	  var cellRight10 = row.insertCell(9);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name='ct'+iteration;
	  e71.id='ct'+iteration
	  e71.size='10';
	  e71.className='radio';
	  e71.value='y';
	  e71.setAttribute('tabindex','1');
	  cellRight10.appendChild(e71); */

	  var cellRight11 = row.insertCell(11);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(12);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.value = "";
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(13);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.value = "";
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
 //   var e9 = document.createElement('input');
//     e9.id = 'a'
//     e9.type = 'checkbox';
//    cellRight9.appendChild(e9);

	}

function removeRow()
{
	var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  if(confirm("Do you want to delete !")){
	  for(var i=0;i<=iteration;i++)
		  {
		  if(document.getElementById("itemRadio"+i)!=null && (typeof  document.getElementById("itemRadio"+i).checked)!='undefined' && document.getElementById("itemRadio"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	  
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      /*else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 2){*/
	    	  for(var i=0;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("itemRadio"+i)!=null && (typeof  document.getElementById("itemRadio"+i).checked)!='undefined' && document.getElementById("itemRadio"+i).checked )
	    		  {
			    		  var deleteRow= document.getElementById("itemRadio"+i).parentNode.parentNode;
			    		  document.getElementById("itemRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	     // }
	   removeRowPrescriptionTab('opc');   
	 }  
}


function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}
function removeRowPrescriptionTab(from)
{
	  var tbl = document.getElementById('prescriptionTabGrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('pTabhdb');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  if(from!='opc'?confirm("Do you want to delete !"):true){
		  for(var i=0;i<=iteration;i++)
			  {
			  if(document.getElementById("itemRadiopTab"+i)!=null && (typeof  document.getElementById("itemRadiopTab"+i).checked)!='undefined' && document.getElementById("itemRadiopTab"+i).checked )
				  {
				  totalSelected=totalSelected+1;
				  }
			  }
		  
		      if(totalSelected==0)
			  {
		    	  if(from!='opc')
		    		  alert('Please select atleast 1 row to delete');
			  }
		     /* else  if(lastRow==2 || lastRow==(totalSelected+1))
			  {
		    	  alert('You can not delete all Row.');
		      }
		      else if (lastRow > 2){*/
		    	  var flag=0;
		    		  for(var i=0;i<=iteration;i++)
			    	  {
			    		  if(document.getElementById("itemRadiopTab"+i)!=null && (typeof  document.getElementById("itemRadiopTab"+i).checked)!='undefined' && document.getElementById("itemRadiopTab"+i).checked )
			    		  {
			    			  jQuery(function ($) {
			    				  if(document.getElementById("parkPrescriptionIds"+i)!=null){
			    					  var ids= document.getElementById("parkPrescriptionIds"+i).value;
					    			  if(ids!="" && ids!="0"){
					    				   $.post('opd?method=deleteOPDdetails&ids='+ids+"&for="+"prc"+"&"+csrfTokenName+"="+csrfTokenValue, function( data ) {
											 	try {	
											 		flag=1;
											 		msgFlag=data;
												} catch (e) {
												  alert(e);
												}
											});  
									  } 	
			    				  }
								 });
			    			  
			    		  var deleteRow= document.getElementById("itemRadiopTab"+i).parentNode.parentNode;
			    		  document.getElementById("itemRadiopTab"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
			    		  }
			    	  }			
		  }	 
	  //}
}	


function display(obj,val){
	var splName = document.getElementById("splName").value;
	
	if(val != 'Nicu Case Record'){
		if(splName =='' || splName != val)
			submitProtoAjaxNew('opdMain','/hms/hms/opd?method=getGroupAndParameterValues&tempLate='+obj,'specialityDiv');
	}else{
		if(splName =='' || splName != val){
			submitProtoAjaxNew('opdMain','/hms/hms/opd?method=showNicuCaseRecordJsp','specialityDiv');
		}
	}
}

function fnGetPrescriptionTemplate(tempId){
	 submitProtoAjaxNew('opdMain',"/hms/hms/opd?method=getPrescriptionTemplateOP&templateId="+tempId,'divTemplet1');
	 submitProtoAjaxNew('opdMain',"/hms/hms/opd?method=getPrescriptionTemplateTab&templateId="+tempId,'divTemplet2');
}

/****************************************/
function changeDiagnosisStaus(status){
	if(status==1){
		document.getElementById("diagnosis_status_p1").checked=true;
		document.getElementById("diagnosis_status_p2").checked=true;
	}else if(status==2){
		document.getElementById("diagnosis_status_f1").checked=true;
		document.getElementById("diagnosis_status_f2").checked=true;
	}
}

function fnShowHideMLCTab(){
	if(document.getElementById("mlcCheck").checked)
		document.getElementById("mlcTab").style.display='block';
	else	
		document.getElementById("mlcTab").style.display='none';
}
 
 function fnGetDistrictHospital(){
	var hospitalTypeId = document.getElementById('referHospitalType').value;
	var districtId = document.getElementById('referdistrict').value;
	if(districtId != 0 && hospitalTypeId != 0){
	 new Ajax.Request('opd?method=getDistrictHospital&districtId='+districtId+'&hospitalTypeId='+hospitalTypeId+'&'+csrfTokenName+'='+csrfTokenValue, {
    	  onSuccess: function(response) {
    	      if(response.responseText.trim()!='')
    	    	  {
    	    	  document.getElementById('referhospital').innerHTML=response.responseText.trim();
    	    	  }
    	  }
    	});
	}
} 
 function fnGetHospitalDepartment(hospitalId){
	 //new Ajax.Request('opd?method=getHospitalDepartment&hospitalId='+hospitalId+'&'+csrfTokenName+'='+csrfTokenValue, {
	 new Ajax.Request('opd?method=getHospitalDepartment&hospitalId='+hospitalId, {
    	  onSuccess: function(response) {
    	      if(response.responseText.trim()!='')
    	    	  {
    	    	  document.getElementById('referdepartment').innerHTML=response.responseText.trim();
    	    	  }
    	  }
    	});
}
 function fnGetHospitalWards(hospitalId){
	 //new Ajax.Request('opd?method=getHospitalDepartment&hospitalId='+hospitalId+'&'+csrfTokenName+'='+csrfTokenValue, {
	 new Ajax.Request('opd?method=getHospitalWards&hospitalId='+hospitalId, {
    	  onSuccess: function(response) {
    	      if(response.responseText.trim()!='')
    	    	  {
    	    	  document.getElementById('referdepartment').innerHTML=response.responseText.trim();
    	    	  }
    	  }
    	});
}
 
 function checkVal(val){
		if(parseInt(val)>299){
			alert("Pulse should be less than 300");
			document.getElementById('pulse').focus;
		}
	}
	function showDiagnosis(csrf)
	{
				var msg="Decision making is finally according to the judgment of the treating doctor";
				if(confirm(msg)){
					var url="/hms/hms/opd?method=showDiagnosisPopUp&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue;;
					newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");	
				}
			   	
	}
 
	function validateFieldValues(from){
		var dateSelected=document.getElementById("reviewDate").value;
		var tab=document.getElementById("tab").value;
		
		if(from=='n'){
	       	  if (confirm("Do you want to skip this patient!")) {
		    	   submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
		       }	
	       	  return false;
	     }else{
	    	 if(document.getElementById('diagnosisId').length == 0 && document.getElementById('OtherDiagnosis').value.trim().length==0)
		      {
		       alert("Please Enter the diagnosis of the Patient.");
		       document.getElementById("snomed").focus();
		       	if(from!='s' && from!='p'){
		       	  if (confirm("Do you want to skip this patient!")) {
			    	   submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
			       }	 
		       	}
		        return false;
		      }
	     }
		 
		 if(dateSelected != "")
			{
				var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
				var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
					if(visitDate<currentDate)
				    {
					document.getElementById("reviewDate").value=document.createElement('consultationDate').value;
					alert("Please enter the correct Visit date.")
					return false;
				    }
	  	  }
		 
		 var systolic=document.getElementById("systolic").value;
		 var diastolic=document.getElementById("diastolic").value;
		 if(diastolic!=null && diastolic!=''&& (systolic==null || systolic==''))
			 {
			 alert('please fill systolic');
			 return false;
			 }
		 else if(systolic!=null && systolic!=''&& (diastolic==null || diastolic==''))
			 {
			 alert('please fill diastolic');
			 return false;
			 }
	    //code for chaecking investigation requistion grid
	      var tbl = document.getElementById('grid');
		  var ptbl = document.getElementById('prescriptionTabGrid');
		  var lastRow = parseInt(tbl.rows.length);
		  var plastRow = parseInt(ptbl.rows.length);
		  var nomenclature="";
		  var pnomenclature="";
		  if(tab==1){
			  for(var i=1;i<lastRow;i++){
				  if(document.getElementById("dosage"+i).value==""){
					  alert("Please fill dosage in row "+i +" On Consultaion")
					  return false;
					  }
					  if(document.getElementById("frequency"+i).value=="0"){
					  alert("Please select frequency in row "+i+" On Consultaion")
					  return false;
					  }
					  if(document.getElementById("noOfDays"+i).value==""){
					  alert("Please fill noOfDays in row "+i+" On Consultaion")
					  return false;
					  }
					  if(document.getElementById("instrunction"+i).value==""){
				      alert("Please fill instrunction in row "+i+" On Consultaion")
					  return false;
					 }
			  }
		  }else if(tab==2){
			  for(var i=1;i<plastRow;i++){
				 	 if(document.getElementById("dosagepTab"+i).value==""){
					  	alert("Please fill dosage in row "+i+" On Prescription")
					  return false;
					  }
					  if(document.getElementById("frequencypTab"+i).value=="0"){
					  	alert("Please select frequency in row "+i+" On Prescription")
					  return false;
					  }
					  if(document.getElementById("noOfDayspTab"+i).value==""){
					  	alert("Please fill noOfDays in row "+i+" On Prescription")
					  return false;
					  }
					  if(document.getElementById("instrunctionpTab"+i).value==""){
						  	alert("Please fill instrunction in row "+i+" On Prescription")
						  return false;
					 }
			 }
		  }
	  if(document.getElementById('mlscasetype').length != 0) {
		  var x=document.getElementById("mlscasetype");
			var val="";
			  for (var i = 0; i < x.options.length; i++) {
			     if(x.options[i].selected ==true){
			    	 val =x.options[i].value;
			    	 //alert(val);
			    	// alert(val.contains('postmortem'));
			    	 if (val.indexOf("postmortem")>-1) {
			    		 if(document.getElementById('patient_expire').checked == false){
			    				alert("Please check Patient is dead as you are referring for postmortem examination.");
			    				return false;
			    			}
			    		}
			      }
			  }
		 }
		  return true;
	}
	
	
 
/* function fnGetDoctorDepartment(departmentId){
	// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
	 new Ajax.Request('opd?method=getDoctorDetails&departmentId='+departmentId,{
    	  onSuccess: function(response) {
    	      if(response.responseText.trim()!='')
    	    	  {
    	    	  document.getElementById('refereddoctor').innerHTML=response.responseText.trim();
    	    	  }
    	  }
    	});
}*/
 
	function checkTab(tab){
		document.getElementById("tab").value=tab;	
	}
	
	function validateFieldaddrow(){

	    var tbl = document.getElementById('grid');
		  var lastRow = tbl.rows.length;
		  lastRow =parseInt(lastRow)-1;
		if(document.getElementById("brandId"+lastRow).value==""){
			 alert("Please Select The Brand Name "+lastRow);
			 return false;
		  }else{
			  //document.getElementById("brandId"+lastRow).selectedIndex=true;

			  }
	    return true;
	}
	
	
function validateFieldValuesPediatricsOpd(){

	var ageId=document.getElementById("ageId").value
	var age = ageId.substring(0,2);
	var ageIntoInt=parseInt(age);
	if(ageIntoInt<=15)
	{
		var dateSelected=document.getElementById("nextVisitDate").value;
		if(document.getElementById('diagnosisId').length == 0)
	      {
	       alert("Please Enter the diagnosis of the Patient.");
	        return false;
	      }
		if(dateSelected != "")
		{
			var visitDate = new Date(dateSelected.substring(6),(dateSelected.substring(3,5) - 1) ,dateSelected.substring(0,2))
			var currentDate = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2))
				if(visitDate<currentDate)
			    {
				document.getElementById("nextVisitDate").value="";
				alert("Please enter the correct Visit date.")
				return false;
			    }
  	  }
    return true;
   }
   else
   {
    	alert("Not more 15 years.");
    	return false;
}
  return true;
}


function fnShowBroughtBy(){
	document.getElementById('policeDiv').style.display='none';
	document.getElementById('otherSelfDiv').style.display='none';
	if(document.getElementById('PoliceCheck').checked){
		document.getElementById('policeDiv').style.display='block';
	}else if(document.getElementById('OtherCheck').checked){
		document.getElementById('otherSelfDiv').style.display='block';
	}else if(document.getElementById('SelfCheck').checked){
		document.getElementById('otherSelfDiv').style.display='block';
	}
}


function putSystemicExamiantionText(id,text){
	var putText=document.getElementById('systemicExamination').value;
	var nad=document.getElementById("nad");
	var cvs=document.getElementById("cvs");
	var cns=document.getElementById("cns");
	var rs=document.getElementById('rs');
	var grs=document.getElementById('grs');
	if(nad.checked==true){
		cvs.disabled=true;
		cns.disabled=true;
		rs.disabled=true;
		grs.disabled=true;
		document.getElementById('systemicExamination').value="";
		document.getElementById('systemicExamination').value=text;	
	}else{
		nad.disabled=true;
		cvs.disabled=false;
		cns.disabled=false;
		rs.disabled=false;
		grs.disabled=false;
		if(cvs.checked==true){
			document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
		}else if(cns.checked==true){
			document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
		}else if(rs.checked==true){
			document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
		}else if(grs.checked==true){
			document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
		}else{
			nad.disabled=false;
			document.getElementById('systemicExamination').value="";
		}
	}
	
	
}


function populatePVMSTab(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);

	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclaturepTab'+inc).value="";
	    document.getElementById('pvmsNopTab'+inc).value="";
	    document.getElementById('dosagepTab'+inc).value="";
	    document.getElementById('noOfDayspTab'+inc).value="";
	    document.getElementById('unitpTab'+inc).value="";
	   return;
	   }
	   else
		   {//alert("pvmsNo  "+pvmsNo);
	      document.getElementById('pvmsNopTab'+inc).value=pvmsNo;
	      document.getElementById('dosagepTab'+inc).value=1;
	      document.getElementById('noOfDayspTab'+inc).value=1;
	      
	      new Ajax.Request('ipd?method=updateItemUnit&pvmsNo='+pvmsNo+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  var str=response.responseText.trim().split("###");
	    	    	  /*document.getElementById('unitpTab'+inc).value=response.responseText.trim();
	    	    	  document.getElementById('unit'+inc).value=response.responseText.trim();*/
	    	    	  document.getElementById('unit'+inc).value=str[0];
	    	    	  document.getElementById('unitpTab'+inc).value=str[0];
	    	    	  document.getElementById('unitLable'+inc).value =str[1]!=undefined?str[1]:"";
	    	    	  document.getElementById('unitLablepTab'+inc).value =str[1]!=undefined?str[1]:"";
	    	    	  
	    	    	  }
	    	  }
	    	});
	 }
	}
	else
		{
		document.getElementById('nomenclaturepTab'+inc).value="";
	    document.getElementById('pvmsNopTab'+inc).value="";
	    document.getElementById('dosagepTab'+inc).value="";
	    document.getElementById('noOfDayspTab'+inc).value="";
	    document.getElementById('unitpTab'+inc).value="";
	    }
}	
function getUnavailableInvestigation(cnt){
	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
	var chargeCodeName = document.getElementById("chargeCodeName"+cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
    var indexForBrandName=index1;
    var index2 = chargeCodeName.lastIndexOf("]");
    	index1++;
	var chargeCode = chargeCodeName.substring(index1,index2);
//	alert("chargeCode----->>>"+chargeCode)
}
function checkInvestigationItem(cnt){
	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
	var chargeCodeName = document.getElementById("chargeCodeName"+cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
    var indexForBrandName=index1;
    var index2 = chargeCodeName.lastIndexOf("]");
    	index1++;

    var chargeCode = chargeCodeName.substring(index1,index2);
	if(chargeCode !=""){
	var xmlHttp;
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
	     		jQuery(function ($) {
	    	      if(xmlHttp.response=="B"){
	    	    	  $("#chargeCodeName"+cnt).css({ 'color': 'blue', 'font-size': '125%' });
	    	    	  $("#availableStatus"+cnt).val("nav");
	    	    	  alert("Investigation temporarily blocked by lab/radiology department");
			       }else if(xmlHttp.response!="A"){
			    	   $("#chargeCodeName"+cnt).css({ 'color': 'red', 'font-size': '125%' });
		    	       $("#availableStatus"+cnt).val("nav"); 
			    	   }else{ 
			    	   $("#availableStatus"+cnt).val("av");
			       }
	     		 });
	      	}  
	    }
	    var url="/hms/hms/opd?method=checkInvestigationItem&chargeCode="+chargeCode+"&"+csrfTokenName+"="+csrfTokenValue;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	} 
}


/* for op constulatation tab Start*/	
function fillValueDays(inc){
	document.getElementById('noOfDayspTab'+inc).value= document.getElementById('noOfDays'+inc).value;
}


function fillValue(inc){
	  
	  
    var noOfDays = document.getElementById('noOfDays'+inc).value 
	  var dosage = document.getElementById('dosage'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var itemClassCode = document.getElementById('itemClassCode'+inc).value;
	  var total = freq*noOfDays*dosage;
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
	   for(var i = 0;i<itemClassCodeArray.length;i++ ){
		      if(itemClassCodeArray[i][0] == itemClassCode)
		    	  {
		    	  //dosage = Math.ceil(dosage*1/10);
		    	  total = Math.ceil(total*1/10);
		    	  break;
		    	  }
		      }
	  }
	
	 
	  var finalQty;
	  
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		//  alert(totalQty);
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  else
			  {
			 	 finalQty = 1;
			  }
		  
		  document.getElementById('total'+inc).value=finalQty;
		  if(finalQty>2)
			  alert("Total quantity  is more than 2");
		 }else{
			  document.getElementById('total'+inc).value=freq*noOfDays*dosage
		  }
	 //	document.getElementById('noOfDays'+inc).disabled = false;
	// 	document.getElementById('sosQty'+inc).disabled = true;
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  //commented for sos var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  //alert(document.getElementById('total'+inc).value +"noOfDays="+noOfDays);
			  var totalQty = (parseFloat(freq*noOfDays*dosage)/parseFloat(dispenseQty)).toFixed(2);
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('total'+inc).value=finalQty;
			 }else{
				  //commented for sos document.getElementById('total'+inc).value=freq*sosQty*dosage
				 document.getElementById('total'+inc).value=freq*noOfDays*dosage
			  }
	//	   document.getElementById('noOfDays'+inc).disabled = true;
	//	   document.getElementById('sosQty'+inc).disabled = false;

	  }
	  
	 }


/*function  fillValue(value,inc,from){
	  var dosage ;
	  var freq;
	  var dispenseQty;
	  var noOfDays ;
	  var sosQty;
	  if(from!='tab'){
		  alert("tab" +document.getElementById('dosage'+inc));
		  dosage = document.getElementById('dosage'+inc).value;
		  freq=document.getElementById('frequencyValue'+inc).value;
		  dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
		  noOfDays = document.getElementById('noOfDays'+inc).value;
		  sosQty = document.getElementById('sosQty'+inc).value;
		  if(freq>0 && dosage>0 &&  noOfDays>0){
		 		 total = freq*noOfDays*dosage;
		 	  }else{
		 		 total=0;
		 	  }
			  var finalQty="";
			  if(document.getElementById('frequency'+inc).value != 13 ){
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2);
				  if(totalQty != '0.00'){
					  finalQty = freq>0?Math.ceil(totalQty):"";
				  }
				  document.getElementById('total'+inc).value=finalQty;
				  document.getElementById('totalpTab'+inc).value=finalQty;
				 }else{
					  document.getElementById('total'+inc).value=total;
					  document.getElementById('totalpTab'+inc).value=total;
				  }
			  }else{
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2);
					  if(totalQty != '0.00'){
						  finalQty = freq>0?Math.ceil(totalQty):"";
					  }
					  document.getElementById('total'+inc).value=finalQty;
					  document.getElementById('totalpTab'+inc).value=finalQty;
					 }else{
						  document.getElementById('total'+inc).value=sosQty*freq*dosage;
						  document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage;
					  }
			  }
			  
			  dosage = document.getElementById('dosagepTab'+inc).value=dosage;
			  document.getElementById('noOfDayspTab'+inc).value=noOfDays;
			  document.getElementById('frequencyValuepTab'+inc).value=freq;
			  document.getElementById('actualDispensingQtypTab'+inc).value=dispenseQty;
		 	  document.getElementById('sosQtypTab'+inc).value=sosQty;
		 	  document.getElementById('frequencypTab'+inc).value=document.getElementById('frequency'+inc).value;
		      document.getElementById('frequencypTab'+inc).text=document.getElementById('frequency'+inc).text;
	  }else{
		  dosage = document.getElementById('dosagepTab'+inc).value
		  noOfDays=document.getElementById('noOfDayspTab'+inc).value
		  freq=document.getElementById('frequencyValuepTab'+inc).value
		  document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage
		  dispenseQty = document.getElementById('actualDispensingQtypTab'+inc).value;
		  sosQty = document.getElementById('sosQty'+inc).value;
		  if(freq>0 && dosage>0 &&  noOfDays>0){
		 		 total = freq*noOfDays*dosage;
		 	}else{
		 		 total=0;
		   }
			  var finalQty="";
			  if(document.getElementById('frequency'+inc).value != 13 ){
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2);
				  if(totalQty != '0.00'){
					  finalQty = freq>0?Math.ceil(totalQty):"";
				  }
				  document.getElementById('totalpTab'+inc).value=finalQty;
				 }else{
					  document.getElementById('totalpTab'+inc).value=total;
				  }
			  }else{
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2);
					  if(totalQty != '0.00'){
						  finalQty = freq>0?Math.ceil(totalQty):"";
					  }
					  document.getElementById('totalpTab'+inc).value=finalQty;
					 }else{
						  document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage;
					  }
			  }
	  }
	 }*/
/*
function  fillValueFromFrequency(value,inc){
 	  var dosage = document.getElementById('dosage'+inc).value;
	  var noOfDays=document.getElementById('noOfDays'+inc).value
	  var freq=document.getElementById('frequencyValue'+inc).value
	  document.getElementById('total'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
 	  var sosQty = document.getElementById('sosQty'+inc).value;
 	 if(freq>0 && dosage>0 &&  noOfDays>0){
 		 total = freq*noOfDays*dosage;
 	  }else{
 		 total=0;
 	  }
	  var finalQty="";
	  if(document.getElementById('frequency'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2);
		  if(totalQty != '0.00'){
			  finalQty = freq>0?Math.ceil(totalQty):"";
		  }
		  document.getElementById('total'+inc).value=finalQty;
		  document.getElementById('totalpTab'+inc).value=finalQty;
		 }else{
			  document.getElementById('total'+inc).value=noOfDays*freq*dosage
			  document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage
		  }
	  }else{
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2);
			  if(totalQty != '0.00'){
				  finalQty = freq>0?Math.ceil(totalQty):"";
			  }
			  document.getElementById('total'+inc).value=finalQty;
			  document.getElementById('totalpTab'+inc).value=finalQty;
		
			 }else{
				  document.getElementById('total'+inc).value=sosQty*freq*dosage
				  document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage
			  }
	  }
	  dosage = document.getElementById('dosagepTab'+inc).value=dosage;
	  document.getElementById('noOfDayspTab'+inc).value=noOfDays;
	  document.getElementById('frequencyValuepTab'+inc).value=freq;
	  document.getElementById('actualDispensingQtypTab'+inc).value=dispenseQty;
 	  document.getElementById('sosQtypTab'+inc).value=sosQty;
 	  document.getElementById('frequencypTab'+inc).value=document.getElementById('frequency'+inc).value;
    document.getElementById('frequencypTab'+inc).text=document.getElementById('frequency'+inc).text;
	 } 
*/

/*function displaySOSQty(val,inc){
	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
		document.getElementById('sosQtypTab'+inc).style.display = 'block';
		document.getElementById('noOfDayspTab'+inc).disabled = true;
	 }else{
	
	  document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	  document.getElementById('sosQtypTab'+inc).style.display  = 'none';
	  document.getElementById('noOfDayspTab'+inc).disabled = false;
	 }
	}*/


function displaySOSQty(val,inc){
	
/*	if(val == '13'){
		document.getElementById('sosQty'+inc).style.display = 'block';
		document.getElementById('noOfDays'+inc).disabled = true;
	 }else{
	
	 document.getElementById('sosQty'+inc).style.display  = 'none';
	  document.getElementById('noOfDays'+inc).disabled = false;
	 }*/
	}
	


function checkHighValueMedicine(pvmsNo,inc,hinid){

	if (pvmsNo != "" && document.getElementById('highValueMedicine' + inc).value =='y')
	   {
		  
	    /*   var index1 = val.lastIndexOf("[");
	       var indexForBrandName=index1;
	       var index2 = val.lastIndexOf("]");
	       index1++;
	       var pvmsNo = val.substring(index1,index2);*/
	      
	     if(pvmsNo == "")
	     {
	       document.getElementById('nomenclature'+inc).value="";
	       document.getElementById('pvmsNo'+inc).value="";
	      return;
	      }
	      else
	           var xmlHttp;
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
	                     
	                          		var highValueMedicine = item
	            					.getElementsByTagName("highValueMedicine")[0];
	            			          if (highValueMedicine.childNodes[0] != undefined
	            					   && highValueMedicine.childNodes[0].nodeValue == 'true') 
	            			           {
	            			        	  document.getElementById('highValueMedicine' + inc).value = 'y';
	            			        	 
	            			           }
	            			          else
	            			        	  {
	            			        	  alert("This is high Value Medicine")
	            			        	
	            			        	  document.getElementById('highValueMedicine' + inc).value = 'n';
	            			        		document.getElementById('nomenclature' + inc).value = ""
	            								document.getElementById('pvmsNo' + inc).value = "";
	            								var e = eval(document.getElementById('nomenclature' + inc));
	            								e.focus();
	            								
	            			        	  }
	            			      
	                         }
	                 }
	                }
	               var url = "/hms/hms/opd?method=checkHighValueMedicine&pvmsNo=" + pvmsNo+"&hinId=" + hinid;
	               xmlHttp.open("GET",url,true);
	               xmlHttp.setRequestHeader("Content-Type", "text/xml");
	               xmlHttp.send(null);
	           }
	}




/*function displayAu(val,inc){
   if(val != "")
   {
       var index1 = val.lastIndexOf("[");
       var indexForBrandName=index1;
       var index2 = val.lastIndexOf("]");
       index1++;
       var pvmsNo = val.substring(index1,index2);
       var indexForBrandName=indexForBrandName--;
       var brandName=val.substring(0,indexForBrandName);
     if(pvmsNo == "")
     {
       document.getElementById('nomenclature'+inc).value="";
       document.getElementById('pvmsNo'+inc).value="";
      return;
      }
      else
           var xmlHttp;
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
                               
                           var au  = item.getElementsByTagName("au")[0];
                           var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
                           var stock = item.getElementsByTagName("stock")[0];
                           
                           if(document.getElementById('au'+inc) && au.childNodes[0] != undefined ){
                                   document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
                           }
                            if(document.getElementById('closingStock'+inc) && stock.childNodes[0] != undefined){
                                   document.getElementById('closingStock'+inc).value = stock.childNodes[0].nodeValue;
                                   if(stock.childNodes[0].nodeValue == 0){
                                      alert("Stock is not available...");
                                   }
                           }else{
                           } 
                           if(document.getElementById('actualDispensingQty'+inc)){
                           if(actualDispensingQty.childNodes[0]!=undefined){
                                   document.getElementById('actualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
                           }else{
                                   document.getElementById('actualDispensingQty'+inc).value = 0;

                           }
                           }
                           var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
                           if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
                                   alert("This drug is dangerous.");
                           }
                         }
                 }
                }
               var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
               xmlHttp.open("GET",url,true);
               xmlHttp.setRequestHeader("Content-Type", "text/xml");
               xmlHttp.send(null);
           }
   else
	   {
	   document.getElementById('itemId'+inc).value = "";
	   }
}*/




/*function  fillValueFromFrequencypTab(value,inc){
 	  var dosage = document.getElementById('dosagepTab'+inc).value
	  var noOfDays=document.getElementById('noOfDayspTab'+inc).value
	  var freq=document.getElementById('frequencyValuepTab'+inc).value
	  document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage
	  var dispenseQty = document.getElementById('actualDispensingQtypTab'+inc).value;
 	  var sosQty = document.getElementById('sosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('frequencypTab'+inc).value != 13 ){
	  if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('totalpTab'+inc).value=finalQty;
		 }else{
			  document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage
		  }
	  }else{
		  if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('totalpTab'+inc).value=finalQty;
		
			 }else{
				  document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage
			  }
	  }
	 } 
*/





function displayAupTab(val,inc){
   if(val != "")
   {
       var index1 = val.lastIndexOf("[");
       var indexForBrandName=index1;
       var index2 = val.lastIndexOf("]");
       index1++;
       var pvmsNo = val.substring(index1,index2);
       var indexForBrandName=indexForBrandName--;
       var brandName=val.substring(0,indexForBrandName);
     if(pvmsNo == "")
     {
       document.getElementById('nomenclaturepTab'+inc).value="";
       document.getElementById('pvmsNopTab'+inc).value="";
      return;
      }
      else
           var xmlHttp;
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
                               
                           var au  = item.getElementsByTagName("au")[0];
                           var actualDispensingQty = item.getElementsByTagName("actualDispensingQtypTab")[0];
                           var stock = item.getElementsByTagName("stock")[0];
                           
                           if(document.getElementById('au'+inc) && au.childNodes[0] != undefined ){
                                   document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
                           }
                        /*    if(document.getElementById('closingStock'+inc) && stock.childNodes[0] != undefined){
                                   document.getElementById('closingStock'+inc).value = stock.childNodes[0].nodeValue;
                                   if(stock.childNodes[0].nodeValue == 0){
                                      alert("Stock is not available...");
                                   }
                           }else{
                           } */
                           if(document.getElementById('actualDispensingQtypTab'+inc)){
                           if(actualDispensingQty.childNodes[0]!=undefined){
                                   document.getElementById('actualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
                           }else{
                                   document.getElementById('actualDispensingQtypTab'+inc).value = 0;

                           }
                           }
                           var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
                           if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
                                   alert("This drug is dangerous.");
                           }
                         }
                 }
                }
               var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo+"&"+csrfTokenName+"="+csrfTokenValue;
               xmlHttp.open("GET",url,true);
               xmlHttp.setRequestHeader("Content-Type", "text/xml");
               xmlHttp.send(null);
           }
}

function parent_disable() {
	  if(newwindow && !newwindow.closed)
	 	newwindow.focus();
	 }		 
   function showPatientHistory(hinNo,csrf){
      var visitId = document.getElementById("visitId").value;
      var url='/hms/hms/enquiry?method=showPatientDetails&hinNo='+hinNo+'&visitId='+visitId+'&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
      newwindow=window.open(url,'opd_window',"left=100,top=10,height=630,width=1024,status=1,scrollbars=yes,resizable=0");
      
   }


   function showImmunization(hinNo){
	        document.opdMain.action="/hms/hms/opd?method=showImmunization&hinNo="+hinNo;
	        document.opdMain.submit();
	  }
   
   function showPreviousStudentVisit(hinId){
  	 	document.opdMain.action="/hms/hms/opd?method=showStudentPreviousVisit&hinId=<%=visit.getHin().getId()%>";
	        document.opdMain.submit();
		     }
   function openPopupForPatientInvestigation(visitNo,hinId,csrf){
		if(visitNo >1){
		var chargeCodeName1=document.getElementById("chargeCodeName1").value;
		var url="/hms/hms/opd?method=showPatientPreviousInvestigation&chargeCodeName1="+chargeCodeName1+"&visitNo="+visitNo+"&hinId="+hinId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue;
      newwindow=window.open(url,'name',"height=300,width=800,status=1,scrollbars=yes");
      }else{
        alert("This is Patient's First Visit. ")
      }
   }
   

   function openPopupForOphthalmology(url){
			
  	 var height=450;
  		var width=1170;
  		var left = (screen.width/2)-(width/2);
  		var top = (screen.height/2)-(height/2);
  		url = url+'&'+csrfTokenName+'='+csrfTokenValue;
  		window.open( url, "Patient Details","resizable=0,scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left );
	        
	     }
   
   
   function openPopupForAntenatal(url){
			
  	 var height=450;
  		var width=1170;
  		var left = (screen.width/2)-(width/2);
  		var top = (screen.height/2)-(height/2);
  		url = url+'&'+csrfTokenName+'='+csrfTokenValue;
  		window.open( url, "Patient Details","resizable=0,scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left );
	        
	     }
   
   
   function populateManufacturer(val,count){

       var counter1=document.getElementById('hdb').value
   	if(val !="0"){
    		for(i=1;i<=counter1;i++)
   		{
   				if(count != i){
   				if(document.getElementById('brandId'+i).value == val)
   				{
   					alert("Brand Name already selected...!");
   					document.getElementById('brandId'+count).value="0";
   					document.getElementById('nomenclature'+count).value="";
   					document.getElementById('manufactureId'+count).value="";
   					var e=eval(document.getElementById('brandId'+count));
   					e.focus();
   					return false;
   				}
   				}

   	  	}
   		submitProtoAjaxForManufacturerClass('opdMain','/hms/hms/opd?method=getItemBrandManufacturerName&brandId='+val+'&counter='+count,count);
   		submitProtoAjaxForNomenClature('opdMain','/hms/hms/opd?method=getNomenclature&brandId='+val+'&counter='+count,count);
   }
   }
   
   
	

   function checkDrugType(rowVal){

   	var pvmsNo=document.getElementById("pvmsNo"+rowVal).value;
   	var xmlHttp;
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
   			    var drugType  = item.getElementsByTagName("drugType")[0];
   		   	    if(drugType.childNodes[0] != undefined){
   			        if(drugType.childNodes[0].nodeValue == 'Drops'){
   			        	document.getElementById('typeLeftRight'+rowVal).disabled = false;
   			        }else{
   			        	document.getElementById('typeLeftRight'+rowVal).disabled = true;
   			        }
   	          }
   	      	}
   	      }
   	      }
   	    var url="opd?method=getDrugTypeOfItem&pvmsNo="+pvmsNo+"&"+csrfTokenName+"="+csrfTokenValue;

   	    xmlHttp.open("GET",url,true);
   	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
   	    xmlHttp.send(null);

   }
   
   

   function populatebrand(val,incr){
    		//var itemId=document.getElementById('itemIdForPvms'+incr).value;

   		var pvmsNo;
   		if(val !=""){
   			var index1 = val.lastIndexOf("[");
   			var index2 = val.lastIndexOf("]");
   			index1++;
   			pvmsNo = val.substring(index1,index2);

   		document.getElementById('pvmsNo'+incr).value=pvmsNo;
   	if(pvmsNo != ""){
   		for(i=1;i<incr;i++)
   		{

   			if(incr != 1)
   			{
   				if(val!=""){
   				if(document.getElementById('nomenclature'+i).value == val)
   				{
   					alert("Item Name already selected...!");
   					document.getElementById('nomenclature'+incr).value="";
   					document.getElementById('pvmsNo'+incr).value="";
   					var e=eval(document.getElementById('nomenclature'+incr));
   					e.focus();
   				}
   				}else{
   					return false;
   				}

   			}
   	  	}

   		submitProtoAjaxForLionClass('opdMain','/hms/hms/opd?method=getItemBrandName&pvmsNo='+pvmsNo+'&counter='+incr+'&'+csrfTokenName+'='+csrfTokenValue,incr);
    }
   		}
   }

	
	/* for prescription tab tab Start*/	
/*	function  fillValuepTab(value,inc){
		  var dosage = document.getElementById('dosagepTab'+inc).value
		  var freq=document.getElementById('frequencyValuepTab'+inc).value;
		  var noOfDays=document.getElementById('noOfDayspTab'+inc).value
		  var dispenseQty = document.getElementById('actualDispensingQtypTab'+inc).value;
		  var sosQty = document.getElementById('sosQtypTab'+inc).value;
		  var total = freq*noOfDays*dosage;
		  var finalQty;
		  if(document.getElementById('frequencypTab'+inc).value != 13 ){
		  if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){
			  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('totalpTab'+inc).value=finalQty;
			 }else{
				  document.getElementById('totalpTab'+inc).value=freq*value*dosage;
			  }
		  }else{
			  if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){
				  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('totalpTab'+inc).value=finalQty;
				 }else{
					  document.getElementById('totalpTab'+inc).value=freq*sosQty*dosage;
				  }
		  }
		  
		 }*/
   
	function displaySOSQtypTab(val,inc){
		if(val == '13'){
			document.getElementById('sosQtypTab'+inc).style.display = 'block';
			document.getElementById('noOfDayspTab'+inc).disabled = true;
		 }else{
		
		 document.getElementById('sosQtypTab'+inc).style.display  = 'none';
		  document.getElementById('noOfDayspTab'+inc).disabled = false;
		 }
		}
	
	
	 function openPopupForPatientPrescription(visitNo,hinId,csrf){
	   if(visitNo >1){
		//var nomenclature1=document.getElementById("nomenclature1").value;
		var url="/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="+visitNo+"&hinId="+hinId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue;
		newwindow=window.open(url,'opd_window',"height=420,width=1050,status=1,scrollbars=yes");
      }else{
        alert("This Is Patient's first Visit.")
      }
	   
   }


   function submitProtoAjaxForNomenClature(formName,action,counter1){

   	errorMsg = "";
   	ob1 = true;
   	ob2 = true;
   	ob3 = true;
   	obj = eval('document.'+formName);
   	       	obj.action = action;

       	   	 var url=action+"&"+getNameAndData(formName);
   			new Ajax.Updater('nomenclatureDiv'+counter1,url,
   			   {asynchronous:true, evalScripts:true });
       	 //	document.getElementById('nomenclature'+counter1).style.display='none';
       	   	return true;
       	}


   function submitProtoAjaxForManufacturerClass(formName,action,counter1){

   	errorMsg = "";
   	ob1 = true;
   	ob2 = true;
   	ob3 = true;
   	obj = eval('document.'+formName);
   	       	obj.action = action;

       	   	 var url=action+"&"+getNameAndData(formName);
   			new Ajax.Updater('manufacturereDiv'+counter1,url,
   			   {asynchronous:true, evalScripts:true });
       	 	//document.getElementById('manufacturer'+counter1).style.display='none';
       	   	return true;
       	}
   

   function submitProtoAjaxForLionClass(formName,action,incr){

   	errorMsg = "";
   	ob1 = true;
   	ob2 = true;
   	ob3 = true;
   	obj = eval('document.'+formName);
   	       	obj.action = action;
       	   	 var url=action+"&"+getNameAndData(formName);

           	new Ajax.Updater('testDiv'+incr,url,
   			   {asynchronous:true, evalScripts:true });

       	   //	document.getElementById('brandId'+incr).style.display='none';
   			return true;
       	}
   
	

   function populatePvmsNo(val,inc){
   	if(val != "")
   	{
   	    var index1 = val.lastIndexOf("[");
   	    var indexForBrandName=index1;
   	   
   	    var index2 = val.lastIndexOf("]");
   	   
   	    index1++;
   	    var pvmsNo = val.substring(index1,index2);
   	   
   	    var indexForBrandName=indexForBrandName--;
   	    var brandName=val.substring(0,indexForBrandName);
   	 
   		var index3 = brandName.lastIndexOf("[");
   		index3++;
   	    var index4 = brandName.lastIndexOf("]");
   	    var itemId = val.substring(index3,index4);
     if(pvmsNo == "")
     {
      	document.getElementById('nomenclature'+inc).value="";
       document.getElementById('pvmsNooo'+inc).value="";
       document.getElementById('itemId'+inc).value="";
      return;
      }
      else
         document.getElementById('pvmsNooo'+inc).value=pvmsNo;
         document.getElementById('itemId'+inc).value=itemId;

    }
   } 

   



   function calculateTotalDispensingPrice(){
   	var cnt = document.getElementById('hdb').value;
   	var totalDispPrice = 0;
   	for(var i=1;i<=cnt;i++){
   		if(document.getElementById("dispensingPrice"+i) != null){
   		if(document.getElementById("dispensingPrice"+i).value !="")
   			totalDispPrice = parseFloat(totalDispPrice) + (parseFloat(document.getElementById("dispensingPrice"+i).value)*parseFloat(parseFloat(document.getElementById("total"+i).value)) );
   		}
   	}
   	document.getElementById("totalDispPrice").value = totalDispPrice;
   }


   function calculateTotalRate(){
   	var cntRate = document.getElementById('hiddenValue').value;
   	var totalRate = 0;
   	for(var i=1;i<=cntRate;i++){
   		if(document.getElementById("rate"+i) != null){
   		if(document.getElementById("rate"+i).value !="")
   			totalRate = parseFloat(totalRate) + (parseFloat(document.getElementById("rate"+i).value));
   		}
   	}
   	document.getElementById("totalRate").value = totalRate;
   }

   
   
function displayPhAlert(val,i){
	if(document.getElementById('alertToStaff'+i).checked == true){
		document.getElementById('phAlert'+i).style.display = 'inline';
	}else{
		document.getElementById('phAlert'+i).style.display = 'none';
	}
	
}	


function checkPayWard(payward){
		var flag;
		if(document.getElementById(payward).checked){
			flag="y";
		}else{
			flag="n";
		}
		 new Ajax.Request('opd?method=getPayward&flag='+flag+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  document.getElementById('admissionWard').innerHTML=response.responseText.trim();
	    	    	  }
	    	  }
	    	});
}


function getAllTemplate(){
	var e1 = document.getElementById('tempLateInvestigation');
	
	e1.length=0;
	e1.innerHTML = "";
	e1.options[0] = new Option('Select', '0');
	for(var i = 0;i<tempArrayTemp.length;i++ ){
		e1.length++;
		e1.options[e1.length-1] = new Option(tempArrayTemp[i][1],tempArrayTemp[i][0]);
	} 
}


function getTemplate(type,from,frompTab){
	 new Ajax.Request('opd?method=getTemplate&type='+type+'&from='+from+'&'+csrfTokenName+'='+csrfTokenValue, {
   	  onSuccess: function(response) {
   	      if(response.responseText.trim()!='')
   	    	  {
   	    	  	if(from=='i')
   	    	  		document.getElementById('tempLateInvestigation').innerHTML=response.responseText.trim();
   	    	  	else if(from=='p' && frompTab=='')
   	    	  		document.getElementById('tempLatePrescription').innerHTML=response.responseText.trim();
   	    	  	else if(frompTab=='ptab'){
   	    	  		document.getElementById('tempLatePrescriptionTab').innerHTML=response.responseText.trim();
   	    	  	}	
   	    	  }
   		  }
   	});
}



function addRowPrescriptionTab(){
	/** For prescription tab : START*/
	 var tbl = document.getElementById('prescriptionTabGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('pTabhdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;
	  
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='itemRadiopTab'+iteration;
	  e1.id='itemRadiopTab'+iteration;
	  e1.className='radioCheck';
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='prescription_availableStatuspTab'+iteration;
	  e1.id='prescription_availableStatuspTab'+iteration;
	  e1.className='textYellow grdTextSmall';
	  cellRight1.appendChild(e1);
	  
	  
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='parkPrescriptionIds'+iteration;
	  e1.id='parkPrescriptionIds'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='nomenclaturepTab'+iteration;
	  e1.id='nomenclaturepTab'+iteration;
	  e1.size='35'
	  e1.className='textYellow largTextBoxOpd';
	  e1.onfocus=function(){checkEnteredDiagnosis();checkFrequency(iteration,"tab");}
	  e1.onkeypress=function(){checkTextColor('nomenclaturepTab'+iteration);};
	  e1.onblur=function(){populatePVMSTab(this.value,iteration);checkPItem(iteration);validatePrescriptionAutocomplete('opPTab',this.value,iteration);checkForAllergy(this.value,iteration);};
        
	  cellRight1.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updatespTab'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('nomenclaturepTab'+iteration,'ac2updatespTab'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturepTab'+iteration});
	  e1.focus();
	  
 	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='brandIdpTab'+iteration;
	  e1.id='brandId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='manufactureIdpTab'+iteration;
	  e1.id='manufactureId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='routepTab'+iteration;
	  e1.id='routepTab'+iteration;
	  e1.style.width = "70px";
	  e1.style.background="#FFFF99";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<routeArray.length;i++ ){
		e1.options[i+1] = new Option(routeArray[i][1],routeArray[i][0]);
	  }
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQtypTab'+iteration;
	  e1.id='actualDispensingQtypTab'+iteration;
	  cellRight1.appendChild(e1);
	  
	  
	  
	  var cellRight1 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.name='dosagepTab'+iteration;
	  e1.id='dosagepTab'+iteration;
	  e1.className="textYellow opdTextBoxTSmall";
	  e1.onblur=function()
      {
		  fillValue(this.value,iteration,'tab');
      };
	  cellRight1.appendChild(e1);
	 
	  var cellRight1 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='unitpTab'+iteration;
	  e1.id='unitpTab'+iteration;
	  e1.className='textYellow opdTextBoxTSmall';
	  e1.readOnly='readOnly';
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight1 = row.insertCell(5);
	  var e1 = document.createElement('Select');
	  e1.name='frequencypTab'+iteration;
	  e1.id='frequencypTab'+iteration;
	  e1.style.width = "70px";
	  e1.style.background="#FFFF99";
	  e1.options[0] = new Option('Select', '0');
	   for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	   e1.onchange=function(){	getFrequencyValuepTab(this.value,iteration);fillValue(this.value,iteration,'tab');
	   				displaySOSQtypTab(this.value,iteration)
		   	};
	  cellRight1.appendChild(e1);
	  
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='sosQtypTab'+iteration;
	  e21.id='sosQtypTab'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);
	  
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValuepTab'+iteration;
	  e21.id='frequencyValuepTab'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);
	  
	  
	  var cellRight1 = row.insertCell(6);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='noOfDayspTab'+iteration;
	  e1.id='noOfDayspTab'+iteration;
	  e1.size='3';
	  e1.className='textYellow opdTextBoxTSmall';
	  e1.onblur=function()
      {
		  fillValue(this.value,iteration,'tab');
		  setEndDate(this.value,iteration);
      };
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(7);
	  var e1 = document.createElement('Select');
	  e1.name='instrunctionpTab'+iteration;
	  e1.id='instrunctionpTab'+iteration;
	  e1.style.width = "70px";
	  e1.style.background="#FFFF99";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<instructionArray.length;i++ ){
	      e1.options[i+1] = new Option(instructionArray[i][1],instructionArray[i][0]);
	      }	
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(8);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.maxlength = '200';
	  e1.name='splInstrunctionpTab'+iteration;
	  e1.id='splInstrunctionpTab'+iteration;
	  e1.className="textYellow opdTextBoxSmall";
	  
	  e1.size='5';
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(9);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='totalpTab'+iteration;
	  e1.id='totalpTab'+iteration;
	  e1.size='5';
	  e1.readOnly=true;
	  e1.className='textYellow opdTextBoxTSmall';
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight1 = row.insertCell(10);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='unitLablepTab'+iteration;
	  e1.id='unitLablepTab'+iteration;
	  e1.className="textYellow opdTextBoxTSmall";
	  e1.readOnly='readOnly';
	  e1.size='5';
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(11);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='startDate'+iteration;
	  e1.id='startDate'+iteration;
	  e1.size='5';
	  e1.value=document.getElementById('consultationDate').value;
	  e1.className='textYellow small';
	  e1.readOnly=true;
	  e1.onblur=function()
      {
		  compareDate(iteration);
      };
	  cellRight1.appendChild(e1);
	 
	  var img1 = document.createElement('img');
	  img1.src = '/hms/jsp/images/cal.gif';
	  img1.onclick=function(event)
      {	
		  var obj=document.getElementById('startDate'+iteration);
		  setdate(document.getElementById('consultationDate').value,obj,event);
      };
	  cellRight1.appendChild(img1);
	  
	  var cellRight1 = row.insertCell(12);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='endDate'+iteration;
	  e1.id='endDate'+iteration;
	  e1.size='5';
	  e1.value="";
	  e1.readOnly=true;
	  e1.className='textYellow small';
	  e1.readOnly=true;
	  e1.onblur=function()
      {
		  compareDate(iteration);
      };
	  cellRight1.appendChild(e1); 
	  
	  var img2 = document.createElement('img');
	  img2.src = '/hms/jsp/images/cal.gif';
	  img2.onclick=function(event)
      {
		  var obj=document.getElementById('endDate'+iteration);
		  setdate(document.getElementById('consultationDate').value,obj,event);
      };
	  cellRight1.appendChild(img2);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='pvmsNopTab'+iteration;
	  e1.id='pvmsNopTab'+iteration;
	  cellRight1.appendChild(e1);
	  
	  /** For prescription tab : END*/
}	 




function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='chargeRadio'+iteration;
	  e0.id='chargeRadio'+iteration;
	  e0.className='radioCheck';
	  cellRight1.appendChild(e0);
	  
	  var e0 = document.createElement('input');
	  e0.type = 'hidden';
	  e0.name='availableStatus'+iteration;
	  e0.id='availableStatus'+iteration;
	  e0.size='20';
	  cellRight1.appendChild(e0);
	  
	  var e0 = document.createElement('input');
	  e0.type = 'hidden';
	  e0.name='parkInvestigationId'+iteration;
	  e0.id='parkInvestigationId'+iteration;
	  cellRight1.appendChild(e0);
	  
	  
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.onkeypress=function(){checkTextColor('chargeCodeName'+iteration);};
	  e0.onblur=function(){getUnavailableInvestigation(iteration);checkInvestigationItem(iteration);getLoincSnomedList(iteration);
		  					if(validateInvestigationAutoComplete(this.value,iteration)){submitProtoAjaxNew('opdMain',"/hms/hms/opd?method=fillChargeCode&hinId="+document.getElementById("hinId").value+"&rowVal="+iteration,'chargeCodeVal'+iteration);}
	  					  };
	  e0.size = '65';
	  e0.className = "textYellow largTextBoxOpd";
	  cellRight0.appendChild(e0);

	  var updatediv = document.createElement('div');
	  updatediv.setAttribute('id', 'ac2update'+iteration);
	  updatediv.style.display = 'none';
	  updatediv.className = "autocomplete";
	  cellRight0.appendChild(updatediv);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',
			  {minChars:3, 
		  callback: function(element, entry) {
          return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
      },parameters:'requiredField=chargeCodeName'+iteration+'&fromOpd=fromOpd'});

	  var cellRight3 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='snomedTermsInv'+iteration;
	  e0.id='snomedTermsInv'+iteration;
	  e0.size='20';
	  e0.className = "largTextBoxOpd textYellow";
	  cellRight3.appendChild(e0);
	  
	  // var cellRightSel = row.insertCell(3);
	  //cellRightSel.id='chargeCodeVal'+iteration;
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration;
	  sel.size = '15';
	  cellRight3.appendChild(sel);  

	  var cellRight3 = row.insertCell(3);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='clinicalNotes'+iteration;
	  e0.id='clinicalNotes'+iteration;
	  e0.size='20';
	  e0.className = "opdTextBoxSmall textYellow";
	  cellRight3.appendChild(e0);
	}



function fillSPLInstrunctionOnPTAb(iteration)
{									
	document.getElementById("splInstrunctionpTab"+iteration).value=document.getElementById("splInstrunction"+iteration).value;
}

function fillInstrunctionOnTAb(iteration)
{									
	var e = document.getElementById("instrunction"+iteration);
	var index=e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	
	var eTab = document.getElementById("instrunctionpTab"+iteration);
	eTab.selectedIndex=index;
	eTab.options[e.selectedIndex].value=strValue;
	eTab.options[e.selectedIndex].text=stText;
}

function fillRouteOnTAb(iteration){
	var e = document.getElementById("route"+iteration);
	var index=e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	
	var eTab = document.getElementById("routepTab"+iteration);
	eTab.selectedIndex=index;
	eTab.options[e.selectedIndex].value=strValue;
	eTab.options[e.selectedIndex].text=stText;
}






function removeRowForInvestigation ()
{
  var tbl = document.getElementById('investigationGrid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hiddenValue');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  if(confirm("Do you want to delete !")){
			  for(var i=1;i<=iteration;i++)
			  {
			  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
				  {
				  totalSelected=totalSelected+1;
				  }
			  }
		      if(totalSelected==0)
			  {
			  alert('Please select atleast 1 row to delete');
			  }
		      else  if(lastRow==2 || lastRow==(totalSelected+1))
			  {
		    	  alert('You can not delete all Row.');
		      }
		      else if (lastRow > 2){
		    	  for(var i=1;i<=iteration;i++)
		    	  {
		    		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
		    		  {
		    			  jQuery(function ($) {
			    			  var ids= document.getElementById("parkInvestigationId"+i).value;
			    			  
			    			  if(ids!=""){
			    				   $.post("opd?method=deleteOPDdetails&ids="+ids+"&for="+"Inv"+"&"+csrfTokenName+"="+csrfTokenValue, function( data ) {
									 	try {	
									 		flag=1;
									 		msgFlag=data;
										} catch (e) {
										  alert(e);
										}
									});  
							  } 
							 });
			    		  var deleteRow= document.getElementById("chargeRadio"+i).parentNode.parentNode;
			    		  document.getElementById("chargeRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
		    		  }
		    	  }
		  }
  }
 
}


function checkForAllergy(val,inc){
	//alert(val+"<<<-------val======inc------>>"+inc);
	var visitId=document.getElementById("visitId").value;
	var id;
	if(val!=""){

		  var xmlHttp;
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
			var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		         icdString  = item.getElementsByTagName('allergyString')[0];
		        // alert("icdString"+icdString);
		         b =icdString.childNodes[0].nodeValue
		       //alert("b-->>"+b);
		       
		        // var val=document.getElementById('icd').value;
		         var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				    //alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				  
				    if(b=='true'){
						   alert("Medicine is allergic to Patient!!");
						   document.getElementById('nomenclature'+inc).value="";
					   }
				    }
					
		  }
		  }
		var url="/hms/hms/opd?method=getItemForAllergy&val="+val+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function SecondOpinion() {
	var height=350;
	var width=700;
	var csrf=csrfTokenName+'='+csrfTokenValue;
	var visitId=document.getElementById("visitId").value;
	var hinId=document.getElementById("hinId").value;
	var hinNo=document.getElementById("hinNo").value;

	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open("/hms/hms/opd?method=getSecondOpinionScreenJSP&visitId="+visitId+"&hinNo="+hinId+"&uhidNo="+hinNo+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue,"Second Opinion","scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left )
}

function patientDetails(csrf) {
	var height=400;
	var width=900;
	var visitId=document.getElementById("visitId").value;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open( "/hms/hms/opd?method=getPatientDetails&hinId="+visitId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue,"Patient Details","scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left )
}


function AboutEmrEhr() {
	var height=400;
	var width=700;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open( "../jsp/EmrEhr.jsp", "About EMR and EHR","status = no, height = "+height+", width =" +width+",top="+top+", left="+left )
}

function fnGetInvestigationTemplate(tempId){
	 var result="";
	  for (var i=0; i<tempId.options.length; i++) {
	    opt = tempId.options[i];
	    if (opt.selected) {
	    	result +=opt.value+",";
	    }
	  }
	  if(tempId.value!=0){
		  submitProtoAjaxNew('opdMain',"/hms/hms/opd?method=getLabInvestigationTemplate&templateid="+result+"&hinId="+document.getElementById("hinId").value+"&"+csrfTokenName+"="+csrfTokenValue,"labInvDiv");	  
	  }
}

//=========To get Icd String with icd code==========================

function fnCopyToComorbidityTab(diagnosis){
	  jQuery(function ($) {
		  var action=1;
		  var hospitalId=document.getElementById("hospitalId").value;
		  var hinId=document.getElementById("hinId").value;
		  var visitId=document.getElementById("visitId").value;
		  if(document.getElementById(diagnosis).checked){
			  action=1;
		  }else{
			  action=0;
		  }
		  $.post('opd?method=saveAndGetTempComorbidity&diagnosis='+diagnosis+'&visitNo='+visitId+'&hospitalId='+hospitalId+'&hinId='+hinId+'&action='+action+'&'+csrfTokenName+'='+csrfTokenValue,
				  	function( data ) {
					  $("#divComorbidity" ).html( data );
		  }); 
	 }); 
	
 }



function getDetails(){
	 var hinId=document.getElementById("hinId").value;
	 var visitId=document.getElementById("visitId").value;
	 var url="/hms/hms/opd?method=getTodayOtherPrescription&visitId="+visitId+"&hinId="+hinId+"&"+csrfTokenName+"="+csrfTokenValue;
	 newwindow=window.open(url,'name','height=500,width=800,status=1');
return false;

}


function getTodayAllPrescriptionPopup(hinId,bufferingFlag, backFlag){
	
	 //var url="/hms/hms/opd?method=getTodayOtherPrescription&visitId="+visitId+"&hinId="+hinId+"&"+csrfTokenName+"="+csrfTokenValue;
	var p="";
	if(bufferingFlag!=undefined && bufferingFlag=='y')
		p=bufferingFlag;
	var url="/hms/hms/opd?method=getTodayOtherPrescription&hinId="+hinId+"&bufferingFlag="+p+"&backFlag="+backFlag;
	 newwindow=window.open(url,'name','height=500,width=1000,status=1');
return false;

}

function getTodayAllPrescriptionPopupForIPD(hinId, bufferingFlag){	
	 //var url="/hms/hms/opd?method=getTodayOtherPrescription&visitId="+visitId+"&hinId="+hinId+"&"+csrfTokenName+"="+csrfTokenValue;
	var p="";
	if(bufferingFlag!=undefined && bufferingFlag=='y')
		p=bufferingFlag;
	var url="/hms/hms/opd?method=getTodayOtherPrescriptionForIPD&hinId="+hinId+"&bufferingFlag="+p;
	 newwindow=window.open(url,'name','height=500,width=1000,status=1');
return false;
}





function previousSystemPatientPrescriptions()
{
 var hinNo=document.getElementById("hinNo").value;	
 var url="/hms/hms/opd?method=showPreviousSystemPatientPrescriptions&hinNo="+hinNo+"&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'opd_window',"height=300,width=750,status=1,scrollbars=yes");
}



function checkForAlreadyIssuedPrescription(val,inc){
	//
	//var value1=document.getElementsByName('nomenclature'+inc).value;
	//alert(val+"<<<-------val======inc------>>"+value1);
	
	var hinId=document.getElementById("hinId").value;
	var id;
	if(val!=""){

		  var xmlHttp;
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
			  var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var dupl  = item.getElementsByTagName('alreadyIssued1')[0];
		        //alert("icdString"+icdString);
		         b =dupl.childNodes[0].nodeValue
		     // alert("b-->>"+b);
		       
		        // var val=document.getElementById('icd').value;
		        /*  var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				    //alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				   */
				    if(b=='true'){
						   alert(" Already Prescribed to Patient!!");
						   document.getElementById('nomenclature'+inc).value="";
						   document.getElementById('itemId'+inc).value="";
						   document.getElementById('closingStock'+inc).value="";
					   }
				    }
					
		  }
		  }
		//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
		  	
		 //var url="/hms/hms/opd?method=checkForAlreadyIssuedPrescribtion&val="+val+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
				var url="/hms/hms/opd?method=checkForAlreadyIssuedPrescription&val="+encodeURIComponent(val)+"&hinId="+hinId;
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
		

			
	}
	else
		{
		 document.getElementById('itemId'+inc).value="";
		}
	
	
}

function checkForAlreadyPrescribedInvestigation(val,inc,hinId){
	//
	//var value1=document.getElementsByName('nomenclature'+inc).value;
	//alert(val+"<<<-------val======inc------>>"+value1);
	
	//var visitId=document.getElementById("visitId").value;
	if(investigationDateCheck(inc))
	{
		
	var investigationDate;
	if(document.getElementById("investigationDate"+inc)!=null)
	investigationDate = document.getElementById("investigationDate"+inc).value;
	else
	  investigationDate = document.getElementById("consultationDate").value;
	

	
	var id;
	if(val!=""){

		  var xmlHttp;
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
			  var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var dupl  = item.getElementsByTagName('alreadyIssued1')[0];
		        //alert("icdString"+icdString);
		         b =dupl.childNodes[0].nodeValue
		     // alert("b-->>"+b);
		       
		        // var val=document.getElementById('icd').value;
		        /*  var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				    //alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				   */
		         
		      
				    if(b=='true'){
						   alert("Already Prescribed to Patient!!");
						   document.getElementById('chargeCodeName'+inc).value="";
						
					   }
				    }
					
		  }
		  }
		//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
		  	
		 //var url="/hms/hms/opd?method=checkForAlreadyIssuedPrescribtion&val="+val+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
				var url="/hms/hms/opd?method=checkForAlreadyPrescibedInvestigation&val="+encodeURIComponent(val)+"&hinId="+hinId+"&investigationDate="+investigationDate;
				
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
		

			
	}
	else
		{
		 //document.getElementById('chargeCodeName'+inc).value="";
		}
	
}
}

function investigationDateCheck(inc) {
	
	  var date = investigationDate = document.getElementById("investigationDate"+inc).value;
	  var parts =date.split('/');
    var selectedDate = new Date(parts[2], parts[1] - 1, parts[0]); 
	  var now = new Date();
	
	  now.setHours(0,0,0,0);
	  if (selectedDate < now) {
	    alert("Can't give investigation for back date");
	    document.getElementById("investigationDate"+inc).value = "";
	    return false;
	  } else {
	  return true;
	  }
	}


function checkForContradiction(val,inc){
	
		    var itemIdArray ="";
			for (i = 1; i <= inc; i++) {

				if (inc != i) {
					if (document.getElementById('itemId' + i)
							&& document.getElementById('itemId' + i).value !="") {
						itemIdArray = itemIdArray+ document.getElementById('itemId' + i).value +",";
					}
				}
			}
			
			  var index1 = val.lastIndexOf("[");
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvms = val.substring(index1,index2);
		
		if(val!=""){

			  var xmlHttp;
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
					  var b="false";
				  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
				  	for (loop = 0; loop < items.childNodes.length; loop++) {
				   	    var item = items.childNodes[loop];
				        var str  = item.getElementsByTagName('returnString')[0];
				   
				         b =str.childNodes[0].nodeValue;
			
						    if(b!='null'){
						    	alert(b);
							   }
				  	}
							
				  }
				  }
			//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
			  	
			 //var url="/hms/hms/opd?method=checkForAlreadyIssuedPrescribtion&val="+val+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
					var url="/hms/hms/opd?method=checkForContradiction&pvms="+pvms+"&itemIdArray="+itemIdArray;
			xmlHttp.open("GET",url,true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);

		}
		
		
		}
	
function addRowForInvestigation(){
	 var hinId =  document.getElementById('hinId').value;
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
   
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
		  					checkForAlreadyPrescribedInvestigation(this.value,iteration,hinId);
	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2updateInv'+iteration;
	  newdiv1.className='autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2updateInv'+iteration,'opd?method=getInvestigationListForAutoComplete',{callback: function(element, entry) { return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;},parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  																																								
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	
		 var cellRight2 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = "text";
	  e3.name='investigationDate'+iteration;
	  e3.placeholder="DD/MM/YYYY";
	  e3.value=document.getElementById("consultationDate").value;;
	  e3.className='calDate';
	  e3.id='investigationDate'+iteration;
		 e3.setAttribute("onblur", "validateExpDate(this,'investigationDate"+iteration+"')");
		 e3.setAttribute("onkeyup", "mask(this.value,this,'2,5','/')");
		  e3.onchange=function(){/*checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);*/
				checkForAlreadyPrescribedInvestigation(this.value,iteration,visitId);
			  };
		 
		 cellRight2.appendChild(e3);
		 
	 var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.value = "";
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation();}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.value = ""
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	}
function checkReferTO(id){
	if(document.getElementById('referInternal').checked==true){
		//document.getElementById('referdistrictLabel').style.display='none';
		//document.getElementById('referHospitalTypeLabel').style.display='none';
		document.getElementById('referhospital').setAttribute("validate", " ");
		document.getElementById('referredFor').setAttribute("validate", " ");
		/*document.getElementById('referral_treatment_type').setAttribute("validate", " ");
		document.getElementById('referral_treatment_type').style.display='none';
		document.getElementById('referral_treatment_type_label').style.display='none';*/
		document.getElementById('priorityLabelId').style.display='block';
		document.getElementById('priorityId').style.display='block';
		//document.getElementById('referdistrict').style.display='none';
		//document.getElementById('referHospitalType').style.display='none';
		document.getElementById('referhospitalLabel').style.display='none';
		document.getElementById('referhospital').style.display='none';
		document.getElementById('referdayslLabel').style.display='none';
		document.getElementById('referdays').style.display='none';
		document.getElementById('referral_treatment_type_label').style.display='none';
		document.getElementById('referral_treatment_type').style.display='none';
		document.getElementById('referredFor').style.display='none';
		document.getElementById('referredForLabel').style.display='none';
		
		/*document.getElementById('referdepartmentLabel').style.display='block';
		document.getElementById('referdepartment').style.display='block';
		document.getElementById('refereddoctorlabel').style.display='block';
		document.getElementById('refereddoctor').style.display='block';*/
		
		fnGetHospitalDepartment(document.getElementById("hospitalId").value);
		
		document.getElementById('referDepartmentDiv').style.display='block';
	}else if(document.getElementById('referExternal').checked==true){
		//document.getElementById('referdistrictLabel').style.display='block';

		//document.getElementById('referdistrict').style.display='block';
		//document.getElementById('referHospitalType').style.display='block';
		//document.getElementById('referHospitalTypeLabel').style.display='block';
		document.getElementById('referhospital').setAttribute("validate", "Hospital,String,yes");
		document.getElementById('referral_treatment_type').setAttribute("validate", "Referral Type,String,yes");
		document.getElementById('referredFor').setAttribute("validate", "Referred for,String,yes");
		/*document.getElementById('referral_treatment_type').setAttribute("validate", "Treatment Type,String,yes");
		document.getElementById('referral_treatment_type').style.display='block';
		document.getElementById('referral_treatment_type_label').style.display='block';*/
		document.getElementById('referhospitalLabel').style.display='block'
		document.getElementById('referhospital').style.display='block';
		document.getElementById('priorityLabelId').style.display='none';
		document.getElementById('priorityId').style.display='none';
	
		document.getElementById('referdayslLabel').style.display='block';
		document.getElementById('referdays').style.display='block';
		document.getElementById('referral_treatment_type_label').style.display='block';
		document.getElementById('referral_treatment_type').style.display='block';
		document.getElementById('referredFor').style.display='block';
		document.getElementById('referredForLabel').style.display='block';
		
		/*document.getElementById('referdepartmentLabel').style.display='none';
		document.getElementById('referdepartment').style.display='none';
		document.getElementById('refereddoctorlabel').style.display='none';
		document.getElementById('refereddoctor').style.display='none';*/
		
		/*if(document.getElementById("referCheck")==null)
		document.getElementById("referdepartment").options.length = 1;*/
		
		document.getElementById('referDepartmentDiv').style.display='none';
	}
	else
		{
		document.getElementById('referhospital').setAttribute("validate", "Hospital,String,yes");
		document.getElementById('referral_treatment_type').setAttribute("validate", "Referral Type,String,yes");
		document.getElementById('referredFor').setAttribute("validate", "Referred for,String,yes");
	document.getElementById('referhospitalLabel').style.display='block'
		document.getElementById('referhospital').style.display='block';
	;
	document.getElementById('referdayslLabel').style.display='block';
		document.getElementById('referdays').style.display='block';
		document.getElementById('referral_treatment_type_label').style.display='block';
		document.getElementById('referral_treatment_type').style.display='block';
		document.getElementById('referredFor').style.display='block';
		document.getElementById('referredForLabel').style.display='block';

	document.getElementById('priorityLabelId').style.display='block';
		document.getElementById('priorityId').style.display='block';
		document.getElementById('referDepartmentDiv').style.display='block';
		}
}

function checkReferTOIPD(id){
	if(document.getElementById('referInternal').checked==true){
		//document.getElementById('referdistrictLabel').style.display='none';
		//document.getElementById('referHospitalTypeLabel').style.display='none';
		/*document.getElementById('priorityLabelId').style.display='block';
		document.getElementById('priorityId').style.display='block';*/
		//document.getElementById('referdistrict').style.display='none';
		//document.getElementById('referHospitalType').style.display='none';
		document.getElementById('referhospitalLabel').style.display='none';
		document.getElementById('referhospital').style.display='none';
		document.getElementById('referdayslLabel').style.display='none';
		document.getElementById('referdays').style.display='none';
		
		document.getElementById('referdepartmentLabel').style.display='block';
		document.getElementById('referdepartment').style.display='block';
		document.getElementById('refereddoctorlabel').style.display='block';
		document.getElementById('refereddoctor').style.display='block';
		
		fnGetHospitalWards(document.getElementById("hospitalId").value);
	}else{
		//document.getElementById('referdistrictLabel').style.display='block';

		//document.getElementById('referdistrict').style.display='block';
		//document.getElementById('referHospitalType').style.display='block';
		//document.getElementById('referHospitalTypeLabel').style.display='block';
		document.getElementById('referhospitalLabel').style.display='block'
		document.getElementById('referhospital').style.display='block';
		/*document.getElementById('priorityLabelId').style.display='none';
		document.getElementById('priorityId').style.display='none';*/
		document.getElementById('referdepartmentLabel').style.display='none';
		document.getElementById('referdepartment').style.display='none';
		document.getElementById('referdayslLabel').style.display='block';
		document.getElementById('referdays').style.display='block';
		
		document.getElementById('referdepartmentLabel').style.display='none';
		document.getElementById('referdepartment').style.display='none';
		document.getElementById('refereddoctorlabel').style.display='none';
		document.getElementById('refereddoctor').style.display='none';
		if(document.getElementById("referCheck")==null)
		document.getElementById("referdepartment").options.length = 1;
	}
}


function ValidateCantra(){
	var ids="";
	var cantraCounter=0;
	
	 jQuery(function ($) {
		  var code2 = "";
		 $("select[name='diagnosisId'] > option").each(function () {
			 	if(code2==""){
			 		code2=this.value;	
			 	}else{
			 		code2=this.value+","+code2;
			 	}
		         
		 });
		 
		  for(;cantraCounter<=$("#hdb").val();cantraCounter++){
					if(document.getElementById("nomenclature"+cantraCounter)!=undefined &&  $("#nomenclature"+cantraCounter).val()!=""){
						 var nomenclature=$("#nomenclature"+cantraCounter).val();
 						 var index1 = nomenclature.lastIndexOf("[");
						 var index2 = nomenclature.lastIndexOf("]");
						 index1++;
						 ids =nomenclature.substring(index1,index2)+","+ids;	
						 var matchIds=nomenclature.substring(index1,index2)
						 var matchPres=nomenclature.substring(0,(index1-1));
						 $.post('opd?method=checkDrugCantraIndicative&ids='+ids+"&code2="+code2+"&hinId="+document.getElementById("hinId").value+"&"+csrfTokenName+"="+csrfTokenValue, function( data ) {
							 try {	
								 	var dt="";	
								 	if(data!=""){	
								 		$("#cantralabel").show();
								 		$("#cantraMsg").html(data);
								 	}else{
								 		$("#cantraMsg").html("");
								 		$("#cantralabel").hide();
								 	} 
								} catch (e) {
								  alert(e);
								}
						}); 
					}
			} 
	 });
}


function checkAdmte(){
	var dob = document.getElementById('admissionDate').value;
	adDate= new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	
	if(adDate < currentDate)
 	{
 		alert("Admission Date is not valid.");
 		document.getElementById('admissionDate').value =document.getElementById("consultationDate").value;
 		document.getElementById('admissionDate').focus();
		return false;
 	}
	 return true;

}

/*function populatePVMS(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);

	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	    document.getElementById('dosage'+inc).value="";
	    document.getElementById('noOfDays'+inc).value="";
	    document.getElementById('unit'+inc).value="";
	    
	   return;
	   }
	   else
		   {
	      document.getElementById('pvmsNo'+inc).value=pvmsNo;
	      document.getElementById('dosage'+inc).value=1;
	      document.getElementById('noOfDays'+inc).value=1;
	      
	      new Ajax.Request('ipd?method=updateItemUnit&pvmsNo='+pvmsNo+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  var str=response.responseText.trim().split("###");
	    	    	  document.getElementById('unit'+inc).value=str[0];
	    	    	  document.getElementById('unitpTab'+inc).value=str[0];
	    	    	  document.getElementById('unitLable'+inc).value =str[1]!=undefined?str[1]:"";
	    	    	  document.getElementById('unitLablepTab'+inc).value =str[1]!=undefined?str[1]:"";
	    	    	  }
	    	  }
	    	});
	 }
	}
	else
		{
		document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	    document.getElementById('dosage'+inc).value="";
	    document.getElementById('noOfDays'+inc).value="";
	    document.getElementById('unit'+inc).value="";
	    }
 }

*/
function populatePVMS(val,inc){

	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);
	   //  alert("pvms no--"+pvmsNo)



  if(pvmsNo == "")
  {
   // alert("pvms no1111--"+pvmsNo)
   	document.getElementById('nomenclature'+inc).value="";
    document.getElementById('pvmsNo'+inc).value="";
   return false;
   }
   else
	   {
	   document.getElementById('pvmsNo'+inc).value=pvmsNo
	      return true;

	   }
    

 }
	else
		{
		 return false;
		}
}
	function checkPayWard(){
		var flag;
		if(document.getElementById("payward").checked){
			flag="y";
		}else{
			flag="n";
		}
		 new Ajax.Request('opd?method=getPayward&flag='+flag+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  document.getElementById('admissionWard').innerHTML=response.responseText.trim();
	    	    	  }
	    	  }
	    	});
	}
	/*function openPopupWindow()
	{
	 var $ = jQuery.noConflict();
	//$("#icdName").empty();
	//$("#icdName").hide();
	$("#divIcdName").hide();
	$("#snomed").val("");
	var url="/hms/hms/adt?method=showICDSearchJsp";
	newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
	}
	
*/	
	
	function getTemplate(type,from,frompTab){
		 new Ajax.Request('opd?method=getTemplate&type='+type+'&from='+from+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  	if(from=='i')
	    	    	  		document.getElementById('tempLateInvestigation').innerHTML=response.responseText.trim();
	    	    	  	else if(from=='p' && frompTab=='')
	    	    	  		document.getElementById('tempLatePrescription').innerHTML=response.responseText.trim();
	    	    	  	else if(frompTab=='ptab'){
	    	    	  		document.getElementById('tempLatePrescriptionTab').innerHTML=response.responseText.trim();
	    	    	  	}	
	    	    	  }
	    		  }
	    	});
}
		
	function getAllTemplate(){
		var e1 = document.getElementById('tempLateInvestigation');
		e1.length=0;
		e1.innerHTML = "";
		e1.options[0] = new Option('Select', '0');
		for(var i = 0;i<tempArrayTemp.length;i++ ){
			e1.length++;
			e1.options[e1.length-1] = new Option(tempArrayTemp[i][1],tempArrayTemp[i][0]);
		} 
	}
	
	function checkPItem(cnt){
		
				var tbl = document.getElementById('grid');
				var lastRow = tbl.rows.length;
				var iteration = lastRow-1;

				//var pvmsNo=document.getElementById("pvmsNo"+iteration).value
				var visitId=document.getElementById("visitId").value
				var nomenclature = document.getElementById("nomenclaturepTab"+cnt).value
				 var index1 = nomenclature.lastIndexOf("[");
			    var indexForBrandName=index1;
			    var index2 = nomenclature.lastIndexOf("]");
			    	index1++;

			    var pvmsNo = nomenclature.substring(index1,index2);
				if(pvmsNo !=""){

				var xmlHttp;
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
					        var stockStstus  = item.getElementsByTagName("stock")[0];
					        	jQuery(function ($) {
				    	       	  if(stockStstus.childNodes[0].nodeValue=='0'){
			    	    	  	 	  $("#nomenclaturepTab"+cnt).css({ 'color': 'red', 'font-size': '125%' });
					    	    	  $("#prescription_availableStatuspTab"+cnt).val('y');
					    	       }else{
					    	    	   $("#prescription_availableStatuspTab"+cnt).val('n');
					    	       } 
					        	});
				      	}
				      }
				      }
				    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;
				    xmlHttp.open("GET",url,true);
				    xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(null);
				}
				}
			
	
	function copyToPrescriptionTAb(incr,flag)
	{	
		
		if(flag=="opconsult"){
							var pTabhdbValue=document.getElementById('pTabhdb').value;
							var hdbValue=document.getElementById('hdb').value;
					if(document.getElementById("nomenclature"+incr).value!="" ){
							var tbl1 = document.getElementById('grid');
							var tbl2 = document.getElementById('prescriptionTabGrid');
							var lastRow1 = tbl1.rows.length;
							var lastRow2 = tbl2.rows.length;
							/* if(pTabhdb<hdbValue)
							{   document.getElementById('pTabhdb').value=document.getElementById('hdb').value-1;
							} */
							
							if(hdbValue>pTabhdbValue){
								addRowPrescriptionTab();
							}
					}	
					document.getElementById("nomenclaturepTab"+incr).value=document.getElementById("nomenclature"+incr).value;
					document.getElementById("dosagepTab"+incr).value=document.getElementById("dosage"+incr).value;
					document.getElementById("unitpTab"+incr).value=document.getElementById("unit"+incr).value;
					document.getElementById("noOfDayspTab"+incr).value=document.getElementById("noOfDays"+incr).value;
					document.getElementById("routepTab"+incr).value=document.getElementById("route"+incr).value;
		}
	}
	
	
	function checkPrescriptionCheck(iteration){
		if(document.getElementById("itemRadio"+iteration).checked){
			document.getElementById("itemRadiopTab"+iteration).checked = true;	
		}else{
			document.getElementById("itemRadiopTab"+iteration).checked = false;
		}
	}
	

	/*function checkItem(cnt){
		var tbl = document.getElementById('grid');
		var lastRow = tbl.rows.length;
		var iteration = lastRow-1;

		//var pvmsNo=document.getElementById("pvmsNo"+iteration).value
		var visitId=0;
		if(document.getElementById("visitId")!=null && document.getElementById("visitId").value!=''){
			visitId = document.getElementById("visitId").value;
		}
		var nomenclature = document.getElementById("nomenclature"+cnt).value
		 var index1 = nomenclature.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = nomenclature.lastIndexOf("]");
	    	index1++;

	    var pvmsNo = nomenclature.substring(index1,index2);
	    var prescriptionName = nomenclature.substring(0,(index1-1));
		if(pvmsNo !=""){

		var xmlHttp;
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
		    	  jQuery(function ($) {
			      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
			      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
			      	for (loop = 0; loop < items.childNodes.length; loop++) {
				   	    var item = items.childNodes[loop];
				        var stockStstus  = item.getElementsByTagName("stock")[0];				        
			    	      if(stockStstus.childNodes[0].nodeValue=='0'){
			    	    	  $("#nomenclature"+cnt).css({ 'color': 'red', 'font-size': '125%' });
			    	    	  $("#nomenclaturepTab"+cnt).css({ 'color': 'red', 'font-size': '125%' });
			    	    	  $("#prescription_availableStatus"+cnt).val('y');
			    	    	  $("#prescription_availableStatuspTab"+cnt).val('y');
				    	   }else{
				    		   $("#prescription_availableStatuspTab"+cnt).val('n');
				    	   }
			     	 	}
		      		 });
			     }
		      }
		    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId+"&"+csrfTokenName+"="+csrfTokenValue;

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}
	}
	*/
	
	function checkItem(iteration){

		//var tbl = document.getElementById('grid');
		//var lastRow = tbl.rows.length;
		//var iteration = lastRow-1;

		var pvmsNo='';
		if(document.getElementById("pvmsNo"+iteration))
			pvmsNo = document.getElementById("pvmsNo"+iteration).value;
		var nomenclature = '';

		if(document.getElementById("nomenclature"+iteration))
			nomenclature = document.getElementById("nomenclature"+iteration).value

		var visitId=0;
		if(document.getElementById("visitId"))
			visitId = document.getElementById("visitId").value
		var xmlHttp;
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
			        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
			         if(bedStatus.childNodes[0].nodeValue=='yes'){
			           	alert("This Drug is Alergic for this patient..!")
			        if(document.getElementById("nomenclature"+iteration))
			        	document.getElementById("nomenclature"+iteration).value = ""
		       		if(document.getElementById("pvmsNo"+iteration))
		       			document.getElementById("pvmsNo"+iteration).value= ""
			       	pvmsNo=pvmsNo.childNodes[0].nodeValue
			       return true
			       }else{
		    	   if(document.getElementById("visitId"))
		    		   document.getElementById("visitId").selectedIndex=0
			        pvmsNo=0
			       	return false;
			       }

		      	}
		      	
		      }
		      
		      }
		  //  if(nomenclature!="")
		  //  {
		        
		  	  var flag = checkForNomenclature(nomenclature,iteration)
		   // }
		    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
          return flag;
		}
	
	
	
	
	function validateReferredDate()
	{
	    var dob = document.forms["opdMain"]["referVisitDate"].value;
	    var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
	    if (dob == null || dob == "" || !pattern.test(dob)) {
	        alert("Please enter dd-mm-yy!!");
	        document.forms["opdMain"]["referVisitDate"].value="";
	        return false;
	    }
	    else {
	        return true
	    }
	}

	function selectReferBack(val)
	{
		
	//alert(val);
	     var temp = new Array();
	     temp = val.split("@@@");
	     var districtId = temp[0];
	     var hospitalId = temp[1];
	     var deptId = temp[2];
	     var referType = temp[3];
	     var deptNameforExternal = temp[4];
	     
	     var $ = jQuery.noConflict();
	     
	     if(referType == 'NA')
	     {
	    	  // do nothing
	     }
	     if(referType == 'Internal')
		 {
	    	 $("#referdepartment option[value="+temp[2]+"]").prop("selected","selected");
		 }
	     
	     if(referType == 'External')
		 {
	    	 $("#referdistrict option[value="+temp[0]+"]").prop("selected","selected");
	    	 $("#referhospital option[value="+temp[1]+"]").prop("selected","selected");
	    	 $("#referdepartment").append("<option value="+deptId+">"+deptNameforExternal+"</option>");
	    	 $("#referdepartment option[value="+temp[2]+"]").prop("selected","selected");
		 }
		 

		//alert(Id);

		
	}
	
	
	
	

	function popwindowUploadDocuments(tempId,csrf)
	{
		var array = new Array();
		array= tempId.split("@@@");
		var hinId= array[0];
		var visitId= array[1];
		var url="/hms/hms/opd?method=openUploadPopWindow&hinId="+hinId+"&visitId="+visitId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue;
	 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
	}

	function openPopupWindowAllergy(csrf){
		   var requestId=document.getElementById("requestId").value.trim();
			
		 window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
		}
	
	function openPopupWindowNCDPattern(csrf,hinId){
		 window.open("/hms/hms/opd?method=showNCDPattern&hinId="+hinId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
		}
	
	function openPopupWindowPhTravelHistory(surveyId,csrf){
		  // var requestId=document.getElementById("requestId").value.trim();
		   var url="/hms/hms/opd?method=displayTravelHistory&surveyId="+surveyId+"&"+csrf+"&"+csrfTokenName+"="+csrfTokenValue;
		 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");		}
		
	function popwindowResultEntry(tempId)
	{
		var array = new Array();
		array= tempId.split("@@@");
		var hinId= array[0];
		var visitId= array[1];
		var url="/hms/hms/investigation?method=showPendingResultEntryTemplateOPD&hinId="+hinId+"&RequisitionFrom=OPD&"+csrfTokenName+'='+csrfTokenValue;
	 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1124,status=1,scrollbars=1,resizable=0");
	}
	
	
	function getBedStatus(val){
		submitProtoAjaxNew('opdMain','opd?method=getBedStatus&deptId='+val,'bedDiv');
	}
		function submitSecondOpinion(){
		
			 opener.fnSubmitPatient('secondop');
			submitForm('secondopinion','/hms/hms/opd?method=submitSecondOpinion')
			self.close(); 
		}
	
	

	function openPopupForSaveInvestigation()
	{
		   var totalRow=document.getElementById('hiddenValue').value;
		   var htmlText="";
		   var count=0;
		   if(!isNaN(totalRow) && totalRow>0)
			   {
			   htmlText +='<form method="post" action="/hms/hms/opd?method=submitInvestigationTamplate">'
			   +'<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
			   htmlText +='<table width="100%" border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
			   for(var i=0;i<=totalRow;i++)
				   {
				   if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value!='')
					   {
					 
					   if(count==0)
						   {
						   htmlText +=''
							         +'<tr>'
							         +'<th scope="col">Test Name</th>'
							         +'<th scope="col">Clinical Notes</th>'
							    
							         +'</tr>';
						   }
					   count++;
					   htmlText +=''
					         +'<tr>'
					         +'<td>'
					   		 //+'<input type="hidden" name="chargeCode'+count+'" value="'+document.getElementById('chargeCode'+i).value+'" />'
					   		 +'<input type="hidden" name="chargeCodeName'+count+'" value="'+document.getElementById('chargeCodeName'+i).value+'" />'
					   		 +''+document.getElementById('chargeCodeName'+i).value
					   		 +'</td>'
					   		+'<td>'
					   		 +'<input type="hidden" name="clinicalNotes'+count+'" value="'+document.getElementById('clinicalNotes'+i).value+'" />'
					   		 +''+document.getElementById('clinicalNotes'+i).value
					   		
					   		+'</td>'
					   	 htmlText +='</td>'
					   		
					   		 +'</tr>';
					   
					   }
				   
				   }
			   htmlText +='</table>'
			   +'<div style="clear:both;"><div><br/><br/><input type="hidden" id="total" name="total" value="'+count+'" /><br/><br/><div>'
			   +'<div><input type="submit" id="submit" value="Save"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
			   +'<input type="button" id="close" value="Close"  onclick="window.close()" />'
			   +'</div></div></div></form>';
			   }
		  // alert(htmlText);
		   if(count==0)
			   {
			   alert('Please enter some data to save Tamplate');
			   }
		   else
			   {
			   var myWindow = window.open("", "saveprescriptionWindow", "width=500, height=500");
			   myWindow.document.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
			   myWindow.document.write(htmlText);
			   }
		  
	}
	
	
	

	function openPopupForSavePrescriptiontamplateTab()
	{
		   var totalRow=document.getElementById('pTabhdb').value;
		   var htmlText="";
		   var count=0;
		   if(!isNaN(totalRow) && totalRow>0)
			   {
			   htmlText +='<form method="post" action="/hms/hms/opd?method=submitPrescriptionTamplate">'
				   +'<input type="hidden" name="'+csrfTokenName+'"value="'+csrfTokenValue+'"/>'   
			   +'<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
			   htmlText +='<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
			   for(var i=0;i<totalRow;i++)
				   {
				   
				   if(document.getElementById('nomenclaturepTab'+i)!=null && document.getElementById('nomenclaturepTab'+i).value!='' && 
						   document.getElementById('pvmsNopTab'+i).value!='' && document.getElementById('pvmsNopTab'+i).value!='0')
					   {
					  
					   if(count==0)
						   {
						   htmlText +=''
							         +'<tr>'
							         +'<th scope="col">Item Name</th>'
							         +'<th scope="col">Route</th>'
							         +'<th scope="col">Dosage</th>'
							         +'<th scope="col">Frequency</th>'
							         +'<th scope="col">Days</th>'
							         +'<th scope="col">Instruction </th>'
							         +'<th scope="col">Total</th>'
							         +'</tr>';
						   }
					   count++;
					   htmlText +=''
					         +'<tr>'
					         +'<td>'
					   		 +'<input type="hidden" name="pvms'+count+'" value="'+document.getElementById('pvmsNopTab'+i).value+'" />'
					   		 +'<input type="hidden" name="nomenclature'+count+'" value="'+document.getElementById('nomenclaturepTab'+i).value+'" />'
					   		 +''+document.getElementById('nomenclaturepTab'+i).value;
					   		 
					   		htmlText +='<td>'
						   		+'<input type="hidden" name="route'+count+'" value="'+document.getElementById('routepTab'+i).value+'" />';
						   	 if(document.getElementById('routepTab'+i).value!=0)
				   			 {
						   		// htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text+'" />';
						   		 htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('routepTab'+i).value+'" />';

						   		// htmlText +=''+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text;
						   		
						   		 htmlText +=''+document.getElementById('routepTab'+i).value;
				   			 }
						   	 
						   	htmlText +='</td>'
					   		 +'</td>'
					   		+'<td>'
					   		 +'<input type="hidden" name="dosage'+count+'" value="'+document.getElementById('dosage'+i).value+'" />'
					   		 +''+document.getElementById('dosagepTab'+i).value
					   		+'</td>'
					   		 +'<td>'  
					   		+'<input type="hidden" name="frequency'+count+'" value="'+document.getElementById('frequencypTab'+i).value+'" />';
					   	 if(document.getElementById('frequencypTab'+i).value!=0)
			   			 {
					   		 htmlText +='<input type="hidden" name="frequencyname'+count+'" value="'+document.getElementById('frequencypTab'+i).options[document.getElementById('frequencypTab'+i).selectedIndex].text+'" />';
					   		 htmlText +=''+document.getElementById('frequencypTab'+i).options[document.getElementById('frequencypTab'+i).selectedIndex].text;
			   			 }
					   	htmlText +='</td>'
					   		+'<td>'
					   		+'<input type="hidden" name="noOfDays'+count+'" value="'+document.getElementById('noOfDayspTab'+i).value+'" />'
					   		 +''+document.getElementById('noOfDayspTab'+i).value
					   		+'</td>'
					   		+'<td>'
					   		+'<input type="hidden" name="instrunction'+count+'" value="'+document.getElementById('instrunctionpTab'+i).value+'" />';
					   	 if(document.getElementById('instrunctionpTab'+i).value!=0)
			   			 {
					   		 htmlText +='<input type="hidden" name="instrunctionname'+count+'" value="'+document.getElementById('instrunctionpTab'+i).options[document.getElementById('instrunctionpTab'+i).selectedIndex].text+'" />';

					   		 htmlText +=''+document.getElementById('instrunctionpTab'+i).options[document.getElementById('instrunctionpTab'+i).selectedIndex].text;
			   			 }
					   	htmlText +='<td>'
				   		+'<input type="hidden" name="route'+count+'" value="'+document.getElementById('routepTab'+i).value+'" />';
				   	 if(document.getElementById('routepTab'+i).value!=0)
		   			 {
				   		 htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text+'" />';

				   		 htmlText +=''+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text;
		   			 }
				   	 
				   	htmlText +='</td>'
				   	+'<td>'
			   		+'<input type="hidden" name="total'+count+'" value="'+document.getElementById('total'+i).value+'" />'
			   	 +''+document.getElementById('total'+i).value;
					   	 htmlText +='</td>'
					   		
					   		 +'</tr>';
					   
					   }
				   
				   }
			   htmlText +='</table>'
			   +'<div style="clear:boath;"><div><br/><br/><input type="hidden" id="pTabhdb" name="pTabhdb" value="'+count+'" /><br/><br/><div><input type="submit" id="submit" value="Save" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
			   +'</form>';
			   }
		  // alert(htmlText);
		   if(count==0)
			   {
			   alert('Please enter some data to save Tamplate');
			   }
		   else
			   {
			   var myWindow = window.open("", "saveprescriptionWindow", "width=500, height=500");
			   myWindow.document.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
			   myWindow.document.write(htmlText);
			   }
		  
	}
	
	
	

	function openPopupForSavePrescriptiontamplate()
	{
		   var totalRow=document.getElementById('hdb').value;
		   //add one for total number or row for adding local templete by rajat singh
		   totalRow=totalRow+1;
		   var htmlText="";
		   var count=0;
		   if(!isNaN(totalRow) && totalRow>0)
			   {
			   htmlText +='<form method="post" action="/hms/hms/opd?method=submitPrescriptionTamplate">'
				   +'<input type="hidden" name="'+csrfTokenName+'"value="'+csrfTokenValue+'"/>'   
			   +'<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
			   htmlText +='<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
			   for(var i=0;i<totalRow;i++)
				   {
				   
				   if(document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='' && 
						   document.getElementById('pvmsNo'+i).value!='' && document.getElementById('pvmsNo'+i).value!='0')
					   {
					  
					   if(count==0)
						   {
						   htmlText +=''
							         +'<tr>'
							         +'<th scope="col">Item Name</th>'
							         +'<th scope="col">Route</th>'
							         +'<th scope="col">Dosage</th>'
							         +'<th scope="col">Frequency</th>'
							         +'<th scope="col">Days</th>'
							         +'<th scope="col">Instruction </th>'
							         +'<th scope="col">Total</th>'
							         +'</tr>';
						   }
					   count++;
					   htmlText +=''
					         +'<tr>'
					         +'<td>'
					   		 +'<input type="hidden" name="pvms'+count+'" value="'+document.getElementById('pvmsNo'+i).value+'" />'
					   		 +'<input type="hidden" name="nomenclature'+count+'" value="'+document.getElementById('nomenclature'+i).value+'" />'
					   		 +''+document.getElementById('nomenclature'+i).value;
					   		 +'</td>'
					   		
					   		htmlText +='<td>'
						   		+'<input type="hidden" name="route'+count+'" value="'+document.getElementById('route'+i).value+'" />';
						   	 if(document.getElementById('route'+i).value!=0)
				   			 {
						   		 //htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text+'" />';
						   		 htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('route'+i).value+'" />';

						   		// htmlText +=''+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text;
						   		 htmlText +=''+document.getElementById('route'+i).value;
				   			 }
						   	 
						   	htmlText +='</td>'
					   		 
					   		 +'<td>'
					   		 +'<input type="hidden" name="dosage'+count+'" value="'+document.getElementById('dosage'+i).value+'" />'
					   		 +''+document.getElementById('dosage'+i).value
					   		
					   		+'</td>'
					   		 +'<td>'
					   		
					   		+'<input type="hidden" name="frequency'+count+'" value="'+document.getElementById('frequency'+i).value+'" />';
					   	 if(document.getElementById('frequency'+i).value!=0)
			   			 {
					   		 htmlText +='<input type="hidden" name="frequencyname'+count+'" value="'+document.getElementById('frequency'+i).options[document.getElementById('frequency'+i).selectedIndex].text+'" />';
					   		 htmlText +=''+document.getElementById('frequency'+i).options[document.getElementById('frequency'+i).selectedIndex].text;
			   			 }
					   	htmlText +='</td>'
					   		+'<td>'
					   		+'<input type="hidden" name="noOfDays'+count+'" value="'+document.getElementById('noOfDays'+i).value+'" />'
					   		 +''+document.getElementById('noOfDays'+i).value
					   		+'</td>'
					   		+'<td>'
					   		+'<input type="hidden" name="instrunction'+count+'" value="'+document.getElementById('instrunction'+i).value+'" />';
					   	 if(document.getElementById('instrunction'+i).value!=0)
			   			 {
					   		 htmlText +='<input type="hidden" name="instrunctionname'+count+'" value="'+document.getElementById('instrunction'+i).options[document.getElementById('instrunction'+i).selectedIndex].text+'" />';

					   		 htmlText +=''+document.getElementById('instrunction'+i).options[document.getElementById('instrunction'+i).selectedIndex].text;
			   			 }
					   	htmlText +='</td>'
					   	+'<td>'
					   	htmlText +='<input type="hidden" id="total'+count+'" name="total'+count+'" value="'+document.getElementById('total'+i).value+'" />'
					   	+''+document.getElementById('total'+i).value
						+'</td>';
					   		
					+'</tr>';
					   }
				   }
			   htmlText +='</table>'
			   +'<div style="clear:boath;"><div><br/><br/><input type="hidden" id="hdb" name="hdb" value="'+count+'" /><br/><br/><div><input type="submit" id="submit" value="Save"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
			   +'</form>';
			   }
		  // alert(htmlText);
		   if(count==0)
			   {
			   alert('Please enter some data to save Tamplate');
			   }
		   else
			   {
			   var myWindow = window.open("", "saveprescriptionWindow", "width=900, height=500");
			   myWindow.document.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
			   myWindow.document.write(htmlText);
			   }
		  
	}
	
	function populateNoOfDaysForNursingProcedure(value,incr){
		
		var procedureName_nursing=document.getElementById('procedureName_nursing'+incr).value;
		
		if(procedureName_nursing){
			if(value>0){
				document.getElementById('noOfDays_nursing'+incr).value=1;
			}
		}
		
	}

	
	
	

	function fillcheckDoseFrequency(){
		
	var hdb=document.getElementById("hdb").value;


	var i;
	var status=true;

	for(i=0;i<=hdb;i++){
		if(document.getElementById("nomenclature"+i)!=null){
			var itemName=document.getElementById("nomenclature"+i).value;
			//alert(itemName);
			if(itemName){
			var res = itemName.split("(");
			if(res){
				var dosage=document.getElementById("dosage"+i).value;
				if(!dosage ){
					status=false;
					alert("Enter the Dosage")
					return;
				}
				
				var unit=document.getElementById("unit"+i).value;
				if(unit==""){
					alert("Unit not avaiable")
					status=false;
					return;
				}
				if(document.getElementById("frequency"+i).selectedIndex =="0"){
					alert("Select Frequency")
					status=false;
					return;
				}
				
				
				var noOfDays=document.getElementById("noOfDays"+i).value;
				
				if(!noOfDays){
					alert("Enter Days")
					status=false;
					return;
				}
				
				}
			}
		}
	}

	return status;
		
	}

	function checkForProcedure(){
		var i;
		var procstatus=true;

		var hdb=document.getElementById("nursinghdb").value;
		
		for(i=0;i<=hdb;i++){
			
			
			var itemName=document.getElementById("procedureName_nursing"+i).value;
			
			if(itemName){
			var res = itemName.split("(");
			if(res){
				if(document.getElementById("frequency_nursing"+i).selectedIndex =="0"){
					alert("Select Procedure Frequency")
					procstatus=false;
					
				}
				
				var noOfDays=document.getElementById("noOfDays_nursing"+i).value;
				
				if( noOfDays<=0){
					alert("Enter Procedure No.Of Days")
					procstatus=false;
				}
				
				}
			}
			
		}
		return procstatus;
	}

	function checkForValidMortuary(){
		
		var mlscasetype = document.getElementById("mlscasetype");
		var patientExpire = document.getElementById("patient_expire");
		var i;
		var count =0;
		var mortuaryFlag = false;
		var remainingFlag = false;
		for(i=0;i<mlscasetype.length;i++){
			if(mlscasetype.options[i].selected && mlscasetype.options[i].value == 'Mortuary'){
				count++;
				if(patientExpire.checked){
					mortuaryFlag = true;
					break;
				} else{
					remainingFlag = false;
					break;		
				}
			} else if(mlscasetype.options[i].selected) {
				count++;
				remainingFlag = true;
			}
			
		}	
		
			if(mortuaryFlag)
				return true;
			else if(remainingFlag)
				return true;
			else if(!mortuaryFlag && !remainingFlag && count>0){
				alert("Please select Patient is Dead !");
				return false;
			} else if(count==0)
				return true;	
		
	}	
	
	
	function displaySpecialty(splName){
		document.getElementById("splName").value=splName;
		
		 var cntr=new ddtabcontent("countrytabsIn")
		 cntr.setpersist(true)
		 cntr.setselectedClassTarget("link")
		 cntr.init()
		 cntr.expandit(7);
	

}
	//dental functions

	function addDentalProcedureRow(){
		
		  var tbl = document.getElementById('dentalGrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('dentalCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('Select');
		  //e1.size = '70';
		  e1.name='teeth'+iteration;
		  e1.id='teethId'+iteration
		  e1.setAttribute('tabindex','1');
		  e1.options[0] = new Option('Select', '0');
	/*	  <%  for (int i=11; i <49; i++) { %>
		  e1.options[<%=i%>] = new Option('<%=i%>', '<%=i%>');
		 <%}%>*/
		   var j=1;
		 for(var i=11;i<=49;i++)
	   	  {
			 e1.options[j++] = new Option(i, i); 
	   	  }
		  cell1.appendChild(e1);
		  e1.focus();
		  
		  var cell11 = row.insertCell(1);
		  var e21 = document.createElement('Select');
		  e21.name='dentalTreatment'+iteration;
		  e21.id='dentalTreatment'+iteration
		  e21.setAttribute('tabindex','1');
		  e21.options[0] = new Option('Select', '0');
		  e21.options[1] = new Option('PI','PI');
		  e21.options[2] = new Option('PII','PII');
		  e21.options[3] = new Option('PIII','PIII');
		  cell11.appendChild(e21);

		  
		  var cell12 = row.insertCell(2);
		  var e22 = document.createElement('Select');
		  e22.name='dtc'+iteration;
		  e22.id='dtc'+iteration
		  e22.setAttribute('tabindex','1');
		  e22.options[0] = new Option('Select', '0');
		  e22.options[1] = new Option('PI', 'PI');
		  e22.options[2] = new Option('PII', 'PII');
		  e22.options[3] = new Option('PIII', 'PIII');
		  cell12.appendChild(e22);

		  var cell14 = row.insertCell(3);
		  var e23 = document.createElement('input');
		  e23.type = 'text';
		  e23.name='remarks'+iteration;
		  e23.id='remarks'+iteration
		  e23.size = '70';
		  e23.setAttribute('tabindex','1');
		  cell14.appendChild(e23);
		  
		  
		  var cell15 = row.insertCell(4);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='Button'+iteration;
		  e31.onclick = function(){addDentalProcedureRow();}; 
		  e31.setAttribute('tabindex','1');
		  cell15.appendChild(e31);

		  var cell16 = row.insertCell(5);
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.className = 'buttonDel';
		  e41.name='delete'+iteration;
		  //e41.setAttribute('onClick', 'removeRow();');
		  e41.onclick = function(){removeRow('dentalGrid','hiddenValue',this);};  
		  e41.setAttribute('tabindex','1');
		  cell16.appendChild(e41);
	}
	
	function chkValue(Obj)
	{
		var newdentalValue="";
		var duplicate = new Boolean(false)
		var dstr=document.getElementById('UnserTeeth123').value;
		 var mySplitResult = dstr.split(",");
		 for(i=1;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==Obj.id)
			 {
				 duplicate=true;
			 }else{
				 newdentalValue=newdentalValue+","+mySplitResult[i];
			 }
		 }
		 if(duplicate==false)
		 {
			 if(dstr!=''){
				 dstr=dstr+",";
			 }
		dstr=dstr+Obj.id;
		document.getElementById('UnserTeeth123').value = dstr;
		 }else{
				document.getElementById('UnserTeeth123').value = newdentalValue;
		 }

	}
	
	function chkDentalValue(Obj)
	{
		
		//var idValue = Obj.id.replace(/AT|CT/g,'');
		var idValue = Obj.id.replace(/[^0-9\.]+/g,'');
		var dstr=document.getElementById('treatableTooth').value;
		//var tstr=document.getElementById('proc_treatment_teeth0').value;
	
		var checked = new Boolean(false);
		 checked = Obj.checked;
		 var mySplitResult = dstr.split(",");
		if(checked && dstr.length<=35){
		 for(i=1;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==idValue)
				 return false;
		 }
		 document.getElementById('treatableTooth').value = document.getElementById('treatableTooth').value!=""?document.getElementById('treatableTooth').value+","+idValue:idValue;
		 document.getElementById('proc_treatment_teeth0').value = document.getElementById('proc_treatment_teeth0').value!=""?document.getElementById('proc_treatment_teeth0').value+","+idValue:idValue;
		}
		else
		{
		
		str1 = ","+idValue+"|"+idValue;
			var re = new RegExp(str1, "g");
		
		document.getElementById('treatableTooth').value = document.getElementById('treatableTooth').value.replace(re,'');
		document.getElementById('proc_treatment_teeth0').value = document.getElementById('proc_treatment_teeth0').value.replace(re,'');
		
		if(dstr.length>=35)
			Obj.checked=false;
		}
		
	}
	
	
	function chkValueMissing(Obj)
	{
		var newdentalValue="";
		var duplicate = new Boolean(false)
		var dstr=document.getElementById('MissTeeth123').value;
		 var mySplitResult = dstr.split(",");
		 for(i=1;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==Obj.id)
			 {
				 duplicate=true;
			 }else{
				 newdentalValue=newdentalValue+","+mySplitResult[i];
			 }
		 }
		 if(duplicate==false)
		 {
			 if(dstr!=''){
				 dstr=dstr+",";
			 }
		dstr=dstr+Obj.id;
		document.getElementById('MissTeeth123').value = dstr;
		 }else{
				document.getElementById('MissTeeth123').value = newdentalValue;
		 }

	}
	
	
	function fillDentalValue(chkId)
	{
		if(document.getElementById(chkId).checked) {
			document.getElementById(chkId).value =  'Y';
        }
		else
			document.getElementById(chkId).value =  '';
	}
	
	function fillPregnancylValue(chkId)
	{
		if(document.getElementById(chkId).checked) {
			document.getElementById(chkId).value =  'y';
        }
		else
			{
			 document.getElementById(chkId).value =  'n';
			 document.getElementById('lmp_date').value="";
			 document.getElementById('edd').value="";
			 document.getElementById('currentEdd').value="";
			 document.getElementById('operation_period_today').value="";
			}
		
	}
	
	function fillProcedure(Obj,inc)
	{
		
		if(document.getElementById('proc_treatment_teeth'+inc).value=="")
			{
			  alert("Please enter teeth first");
			  document.getElementById('proc_treatment_teeth'+inc).focus();
			  return false;
			}
		else if(Obj.value!=""){
		var duplicate = new Boolean(false);
		var newdentalValue="";
		var d=Obj.value.split("[");
		//alert(d[0]);
		var dstr=document.getElementById('teethRemarks').value;
		 //var mySplitResult = dstr.split(","); dstr+","+
		 newdentalValue="["+document.getElementById('proc_treatment_teeth'+inc).value+" - "+d[0]+"]";
		 document.getElementById('teethRemarks').value = dstr!=""?dstr+","+newdentalValue:newdentalValue;
		}
		/* for(i=0;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==d[0])
			 {
				 duplicate=true;
			 }
			 else
				 {
				// newdentalValue= newdentalValue+","+mySplitResult[i];
				 newdentalValue=newdentalValue+","+"["+document.getElementById('proc_treatment_teeth'+i).value+"-"+mySplitResult[i]+"]";
				 }
		 }
		 
		 if(duplicate==false)
		 {
		//dstr=dstr!=""?dstr+","+Obj.id:Obj.id;
			 dstr=dstr+","+d[0];
		document.getElementById('teethRemarks').value = dstr;
	
		 }*//*else{
				document.getElementById('teethRemarks').value = newdentalValue;
			
			 }*/
		
		/*var newdentalValue="";
		var duplicate = new Boolean(false)
		var dstr=document.getElementById('treatableTooth').value;
		 var mySplitResult = dstr.split(",");
		
		 for(i=1;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==Obj.id)
			 {
				 duplicate=true;
			 }else{
				 //newdentalValue= mySplitResult!=""?newdentalValue+","+mySplitResult[i]:mySplitResult[i];
				 newdentalValue= newdentalValue+","+mySplitResult[i];

			 }
		 }
		 if(duplicate==false)
		 {
		//dstr=dstr!=""?dstr+","+Obj.id:Obj.id;
			 dstr=dstr+","+Obj.id;
		document.getElementById('treatableTooth').value = dstr;
		document.getElementById('proc_treatment_teeth').value = dstr;
		 }else{
				document.getElementById('treatableTooth').value = newdentalValue;
				document.getElementById('proc_treatment_teeth').value = newdentalValue;
			 }*/
	}
	
	function putLMPEDD(chkId,lmpDate, EddDate)
	{
		if(!lmpDate && !EddDate)
			{
		if(document.getElementById(chkId).checked)
			{
			 document.getElementById('lmp_date').value=lmpDate;
			 document.getElementById('edd').value=EddDate;	
			}
			}
	}
	
	function generateEDD(lmpDate, pregChk)
	{
		//alert(document.getElementById(lmpDate));
		if(pregChk.value =='y')
			{
		      	if(document.getElementById("lmp_date")!="")
		      		{
		      		setPregencyValues();
		      		}
			}
		else
			{
			document.getElementById("lmp_date").value="";
			alert("Please check pregnancy before filling LMP Date");
			}
		
		//alert(document.getElementById(pregChk).checked);
		/**/
	}
	
	function setPregencyValues()
	{
		if(document.getElementById("lmp_date")!=null){
		var newdate = (document.getElementById("lmp_date").value).split("/").reverse().join("/");
 		 var someDate = new Date(newdate);
 		 //
 		someDate.setMonth(someDate.getMonth() + 9);
 		someDate.setDate(someDate.getDate() + 7); 
 		 var dateFormated = someDate.toISOString().substr(0,12);
 		// console.log(dateFormated.split("/").reverse().join("/"));
 		 
 		 var datePart = dateFormated.match(/\d+/g),
 	    year = datePart[0].substring(0), // get only two digits
 	     month = datePart[1], day = datePart[2];

 		dateFormated = day+'/'+month+'/'+year;
 		 document.getElementById("edd").value =dateFormated;
 		 
 		var d1=document.getElementById("lmp_date").value.split('/');
 	    var d2=document.getElementById("consultationDate").value.split('/');
	         var t2 = new Date(d2[2],d2[1]-1,d2[0]);
   	 var t1 = new Date(d1[2],d1[1]-1,d1[0]); 
   	 var n= ((t2-t1) / (24*3600*1000));
   	 var weeks= Math.floor(n/7);
   	 var day = n%7;
   	 
 	     document.getElementById("operation_period_today").value = weeks+" weeks "+day+" days";
 	     document.getElementById("currentEdd").value = document.getElementById("consultationDate").value;
		}
	}
	
	//end dental
	
	function setValueInText(radVal,count){
		document.getElementById("textValue"+count).value=radVal;
	}
	
	


	function popwindowresult(url)
	{
			   	
			   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
			  
	}

	function checkForPurchase(val,inc)
	{
			    	
		    var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvms = val.substring(index1,index2);
		   //console.log(pvms +" d "+inc);
		  
		  if(pvms !="")
		  {
			
			  ajaxFunctionForAutoCompleteInLPOGeneral('opdMain','opd?method=fillItemsInGrid&pvmsNo=' +  pvms , inc);
					//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
				   	
				}
		  else{
				    return false;
				}
		    
	}

	function ajaxFunctionForAutoCompleteInLPOGeneral(formName,action,rowVal) {
		
		  var xmlHttp;
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
	  var url=action
	  xmlHttp.open("GET",url,true);
	  xmlHttp.setRequestHeader("Content-Type", "text/xml");
	  xmlHttp.send(null);
	  xmlHttp.onreadystatechange=function()
	  {
	    if(xmlHttp.readyState==4){
	  	  

		     var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	    	 
			
			
	    	for (loop = 0; loop < items.childNodes.length; loop++) 
	    	{
	    
		   	    var item = items.childNodes[loop];
		   	    
		        var id  = item.getElementsByTagName("id")[0];
		        var classificationId  = 0;
		        if(item.getElementsByTagName("itemClassificationId")!=null)
		        	classificationId= item.getElementsByTagName("itemClassificationId")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        
	      	/* document.getElementById('itemCode'+rowVal).value = pvms.childNodes[0].nodeValue */
	      	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	      	if(document.getElementById('itemIdClassificationId'+rowVal)!=null)
	     	document.getElementById('itemIdClassificationId'+rowVal).value = classificationId.childNodes[0].nodeValue
	      	/* document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue	 */		
	      	
	    }
	  }
	}
	}
	
	

	function disableOtherMedicine(val,inc){
		 document.getElementById('itemConversionId'+inc).value = "0";
		   document.getElementById('itemClass'+inc).value = "0";
		   document.getElementById('dispensingUnit'+inc).value = "0";
	  if(val != "")
		{
	   document.getElementById('otherMedicine'+inc).disabled = true;
	   document.getElementById('otherMedicine'+inc).value ="";
	  // document.getElementById('total'+inc).readOnly = true;
	   document.getElementById('itemConversionId'+inc).disabled = true;
	   document.getElementById('itemClass'+inc).disabled = true;
	   document.getElementById('dispensingUnit'+inc).disabled = true;
	   //document.getElementById('injCategory'+inc).disabled = true;	
	   
		}else{
			document.getElementById('otherMedicine'+inc).disabled = false;
			document.getElementById('itemConversionId'+inc).disabled = false;
			document.getElementById('itemClass'+inc).disabled = false;
			document.getElementById('dispensingUnit'+inc).disabled = false;
			//document.getElementById('total'+inc).readOnly = false;
			//document.getElementById('injCategory'+inc).disabled = false;	

		}
	}
	function readOnlyNomenclature(val,inc){

	if(val != ""){
		//alert("Please confirm PVMS/NIV is not available");
		 document.getElementById('nomenclature'+inc).readOnly = true;
		 document.getElementById('au'+inc).readOnly = true;				
	     document.getElementById('nomenclature'+inc).value ="";
	     if(document.getElementById('itemId'+inc)){
	    	 document.getElementById('pvmsNo'+inc).value = "";
	     }
	  }else{
		document.getElementById('nomenclature'+inc).readOnly = false;
		 document.getElementById('au'+inc).readOnly = false;			

	  }
   }

	   function showSimilarMedicineNames(otherDrug){
       	newwindow=window.open('/hms/hms/opd?method=showRelatedMedicineNames&otherDrug='+otherDrug,'name',"left=2,top=100,height=300,width=800,status=1,scrollbars=1,resizable=0");
       }
	   
	   function validateFrequency(counter){
		   
		   if(counter!=undefined)
			   var count = document.getElementById(counter).value;
		   else
			var count = document.getElementById('hdb').value;
			//alert("fasfsf"+count);
			for(var i = 1; i <= count;i++){
				
				//var nomenclature = document.getElementById('nomenclature'+i).value;
				if((document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != '') ||( document.getElementById('otherMedicine'+i) && document.getElementById('otherMedicine'+i).value != '')){
				//if(document.getElementById('nomenclature'+i).value != ''){
					if(document.getElementById('frequency'+i)){
					if(document.getElementById('frequency'+i).value == '0'){
						alert('Please select frequency.');
						return false;
					  }
					 }
					
		
		             if(document.getElementById('dosage'+i)){
					if(document.getElementById('dosage'+i).value == ''){
						alert('Please Enter dosage.');
						return false;
					 }
					}
				
					//var noOfDays = document.getElementById('noOfDays'+i).value;
				//commented for sos	if(document.getElementById('frequency'+i).value != '13'){
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value == ''){
						alert('Please Enter No. of Days.');
						return false;
					 }
					 }
				/*commented for sos		}else{
						if(document.getElementById('sosQty'+i)){
							if(document.getElementById('sosQty'+i).value == ''){
								alert('Please Enter SOS Qty.');
								return false;
							 }
							 }
					}*/
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value!="")
					{
					if( isNaN(document.getElementById('noOfDays'+i).value))
			    	{
						document.getElementById('noOfDays'+i).value =""; 
			        	alert("No. of Days should be a number");
			        	return false;
			    	 }
					 }
				   }
					
					/*var instructionACPC = document.getElementById('instructionACPC'+i).value;
					if(instructionACPC == ''){
						alert('Please select Intake.');
						return false;
					}
					var typeLeftRight = document.getElementById('typeLeftRight'+i).value;
					if(typeLeftRight == ''){
						alert('Please select Type.');
						return false;
					}
					var remarks = document.getElementById('remarks'+i).value;
					if(remarks == ''){
						alert('Please Enter remarks.');
						return false;
					}*/
				//}
				/*else
				{
					alert("Please Enter Nomenclature");
					return false;
				}*/
				
			 }
			}
			return true;
		}
	   
	   function validateNip(){
			var count = document.getElementById('hdb').value;
			var j=0;;
			var uomMatch;
			for(var i = 500; i <= count;i++){
				uomMatch =true;
				//var nomenclature = document.getElementById('nomenclature'+i).value;
				if(document.getElementById('otherMedicine'+i)){
					j++;
				if(document.getElementById('otherMedicine'+i).value != ''){
					if(document.getElementById('itemClass'+i)){
					if(document.getElementById('itemClass'+i).value == '0'){
						alert('Please select class for Nip Medicine '+j);
						return false;
					  }
					 }

		            if(document.getElementById('itemConversionId'+i)){
					if(document.getElementById('itemConversionId'+i).value == '0'){
						alert('Please select Au for Nip Medicine '+j);
						return false;
					 }
					}
				
					//var noOfDays = document.getElementById('noOfDays'+i).value;
			
					if(document.getElementById('dispensingUnit'+i)){
					if(document.getElementById('dispensingUnit'+i).value == '0'){
						alert('Please select Dispensing Unit for Nip Medicine '+j);
						return false;
					 }
					 }
	
					for(var n=0;n<ItemClassIdUOMNotRequired.length;n++)
						{
						 if(ItemClassIdUOMNotRequired[n] == document.getElementById('itemClass'+i).value)
							 {
							 uomMatch=false;
							 break;
							 }
						
						}
					
							if(document.getElementById('uomQty'+i) && uomMatch){
								if(document.getElementById('uomQty'+i).value == ''){
									alert('Please enter UOM Qty for Nip Medicine '+j);
									return false;
								  }
								else
									{
									var num = parseFloat(document.getElementById('uomQty'+i).value, 10);
									if(num<=0)
										{
										alert('UOM Qty should be greater than 0 for Nip Medicine '+j);
										return false;
										}
									}
								 }
						
					
					//
					if(document.getElementById('dosage'+i)){
						if(document.getElementById('dosage'+i).value == ''){
							alert('Please enter dosage for Nip Medicine '+j);
							return false;
						 }
						 }
					
					if(document.getElementById('frequency'+i)){
						if(document.getElementById('frequency'+i).value == '0'){
							alert('Please select frequency for Nip Medicine '+j);
							return false;
						 }
						 }
					
					if(document.getElementById('noOfDays'+i)){
						if(document.getElementById('noOfDays'+i).value == ''){
							alert('Please Enter No. of Days. for Nip Medicine '+j);
							return false;
						 }
						 }
					
				}
			 }
			}
			return true;
		}
	   
	   function validateProcedure(){
			var count = document.getElementById('nursinghdb').value;
			for(var i = 0; i <=count;i++){
				//var nomenclature = document.getElementById('nomenclature'+i).value;
				if(document.getElementById('procedureName_nursing'+i)){
				if(document.getElementById('procedureName_nursing'+i).value != ''){
					if(document.getElementById('frequency_nursing'+i)){
					if(document.getElementById('frequency_nursing'+i).value == '0'){
						alert('Please select frequency for procedure');
						return false;
					  }
					 }

		            if(document.getElementById('noOfDays_nursing'+i)){
					if(document.getElementById('noOfDays_nursing'+i).value == ''){
						alert('Please select days for frequency');
						return false;
					 }
					}
				}
			 }
			}
			return true;
		}
	
	   function validateICD(){
			var icd = document.getElementById('diagnosisId');
			for(i=0; i<icd.options.length;i++){
				if(icd.options[i].value=='NA' && document.getElementById('initialDiagnosis').value.trim()=="")
					{
						alert("Working Diagnosis can't be blank");
					  return false;
					}
				}
			return true;
	   }
	   function openPopupInvestigation(hinId)
   	{
   	 var url="/hms/hms/lab?method=viewAllTestForOrderNo&hinId="+hinId;
   	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
   	}
	   
	   function openPopupRadioInvestigation(hinNo)
	   	{
	   	 var url="/hms/hms/opd?method=showPacsPendingJsp&hinNo="+hinNo;
	   	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	   	}
	   
	   function openDentalXray(hinNo)
	   	{
	   	 var url="/hms/hms/opd?method=showPreviousDentalXray&hinNo="+hinNo;
	   	 newwindow=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	   	}
	   
		function validatePregnancy(){
			if(document.getElementById("pregnancy")!=null && document.getElementById("pregnancy").checked &&( document.getElementById('lmp_date').value=="" || document.getElementById('edd').value=="" || document.getElementById('currentEdd').value=="" ||document.getElementById('operation_period_today').value=="" ))
			{
			  alert("LMP, EDD, Current EDD and Period of Gestation for today cannot be blank if patient is pregnant")	
			  return false;
			}
			return true;
		}
	
		
		function validateReferal()
		{
			var returnValue = true;
		  
			if(document.getElementById('referral')==null)
				return returnValue;
			var referral = document.getElementById('referral').value;
			if(referral =='1')
		       {		
				 if(document.getElementById('referInternal').checked || (document.getElementById('referBoth')!=null && document.getElementById('referBoth').checked))
					 {
					 
					 var hiddenValueRefer = document.getElementById('hiddenValueRefer').value;
					 returnValue =false;
					 for(var i=1;i<=hiddenValueRefer;i++)
						 {
						   if(document.getElementById('refereddoctor'+i)!=null && document.getElementById('refereddoctor'+i).value!="0"){
							   returnValue = true;
							   break;
						   }
						 }
					    if(!returnValue)
					    	{
					    	 alert("Please Select Refer Doctor");
					    	}
					    
					    	 
					 }
				 else if(document.getElementById('referExternal').checked)	 
					 {
					    var refHosp = document.getElementById('referhospital').value;
					    if(refHosp==0 )
					    	{
					    	 alert("Please select hospital");
					    	 returnValue = false;
					    	} 
					 }
		       }
			
			return returnValue;
		}
		function validateAdmission()
		{
			if(document.getElementById('admissionAdvised') &&  document.getElementById('admissionAdvised').checked)
				{
				
				  var admissionWard = document.getElementById('admissionWard').value;
				  if(admissionWard==0)
				   {alert("Select admission ward.");
				   return false;
				   }
				}
			return true;
		}

		function validateSurgery()
		{
		 var count = document.getElementById('procCount').value;
		 
		 for(var i=1; i<=count;i++)
			 {
			
			 if(document.getElementById('proscedureName'+i)!=null && document.getElementById('proscedureName'+i).value!="" &&  document.getElementById('surgeryType'+i).value == "minor")
		    	{
				 var msg ="";
				 if(document.getElementById('tentativeDateId').value =="")
					 {
					  msg = "Enter Surgery Date\n";
					 }
				 
				 if(document.getElementById('startTime').value =="")
				 {
				  msg += "Enter Surgery Start Time \n";
				 }
				 
				 if(document.getElementById('endTime').value =="")
				 {
				  msg += "Enter Surgery End Time\n";
				 }
				 
				 if(document.getElementById('deptId').value =="0")
				 {
				  msg += "Select Surgery Department\n";
				 }
				 
				 if(document.getElementById('otId').value =="0")
				 {
				  msg += "Select OT\n";
				 }
				 if(document.getElementById('tableId').value =="0")
				 {
				  msg += "Select OT table\n";
				 }
				 if(msg!="")
					 {
					  alert(msg);
					  return false;
					 }
				   
		    	}
			 }
		 return true;
		}
		
		//Major/Minor Surgery
		  function checkMappedChargeIP(val, count) {
	        	
	        	var index1 = val.lastIndexOf("[");
	        	var index2 = val.lastIndexOf("]");
	        	index1++;
	        	
	        	var id = val.substring(index1, index2);
	        	if (id == "") {
	        		
	        			document.getElementById('proscedureName' + count).value = "";
	        			
	        		
	        	}
	        	
	        		if (val != "") {				
	        					
	        					document.getElementById("procedureId" + count).value = id;
	        								for (var xx = 1; xx <count; xx++) {
	        									if (document.getElementById("procedureId" + count)!=null  && document.getElementById("procedureId" + xx)!=null && document.getElementById("procedureId" + count).value == document.getElementById("procedureId" + xx).value)
	        									{
	        										document.getElementById("procedureId" + count).value = "";
	        										document.getElementById("proscedureName" + count).value = "";
	        										alert("charge already taken");
	        										break;
	        									}
	        								
	        								}
	        							
	        } 
	        		
	        }
		  
		    
		    function getProcedureId(val,inc){
		    	if(val!=''){
		    		var index1 = val.indexOf("[");
		    		var index2 = val.indexOf("]");
		    		index1++;
		    		var procName = val.substring(0,index1-1);
		    		var procId = val.substring(index1,index2);
		    		
		    		var index1 = val.lastIndexOf("[");
		    		var index2 = val.lastIndexOf("]");
		    		index1++;
		    		var procCode = val.substring(index1,index2);
		    		document.getElementById('proscedureName'+inc).value=procName;
		    		document.getElementById('procedureId'+inc).value = procId;
		    		//document.getElementById('procedurecode'+inc).value = procCode;
		    		
		    		
		    	}else{
		    		if(document.getElementById('proscedureName'+inc)){
		    	      	document.getElementById('proscedureName'+inc).value="";
		    	      	document.getElementById('procedureId'+inc).value="";
		    	    	//document.getElementById('proDtId'+inc).value="";
		    	        //document.getElementById('procRemarks'+inc).value="";
		    	      	//document.getElementById('procedurecode'+inc).value="";
		    			}
		    	}
		    	
		    }
		    
		    function getSurgeryDiv(count) {
		        
		     	//console.log();
		     	 	//var select = document.getElementById("pacstatus"+count);
		         	//var option = document.createElement('option');
		        
		         if(document.getElementById('proscedureName'+count).value!="")
		        	 {
		        if(document.getElementById('minorSurgery').checked)
		        	{
		        	 //document.getElementById('pacstatus'+count).innerHTML = "";
		         	// option.text = option.value = "completed";
		         	 //select.add(option, 0);
		         	document.getElementById('surgeryType'+count).value = "minor";
		        	}
		        else if(document.getElementById('majorSurgery').checked)
		    	{
		       	// document.getElementById('pacstatus'+count).innerHTML = "";
		        	// option.text = option.value = "pending";
		        	 //select.add(option, 0);
		          	document.getElementById('surgeryType'+count).value = "major";
		       	}
		        	
		        	 }
		        
		        schedulingDiv(count);
		        return;
		        }
		    
		    function schedulingDiv(count){
		    	//alert("gher");
		    	    	for (var xx = 1; xx <=count; xx++) {  
		    				 if(document.getElementById("surgeryType" + xx)!=null && document.getElementById("procedureId" + xx)!=null  && document.getElementById("procedureId" + xx).value && document.getElementById("surgeryType" + xx).value =='minor')
		    					 {
		    						document.getElementById("minorOTSchedulingDiv").style.display='block';
		    						
		    					    return true;
		    				     }
		    				}
		    	    	
		    	    	document.getElementById("minorOTSchedulingDiv").style.display='none';
		    		    return false;
		    	    }
		    
		    function checkSurgeryDate(tentativeDateId)
		    {
		    	var surgeryDate = document.getElementById(tentativeDateId).value;
		    	if(surgeryDate=="")
		    	{
		    	  alert("Select surgery date");
		    	  var element = document.getElementById('deptId');
		          element.value = "0";
		          document.getElementById('startTime').value= '';
		          document.getElementById('endTime').value= '';
		          
		          
		    	  return false;
		    	}
		    	return true;
		    }
		        function displayOT(val)
		    {
		     var surgeryDate = document.getElementById('tentativeDateId').value;
		    	if(checkSurgeryDate('tentativeDateId'))
		    	   ajaxFunctionDisplayOT('opdMain','ot?method=displayDepartmentOT&deptId='+val+"&surgeryDate="+surgeryDate);
		    	
		    } 

		        function onSelectSurgeryDate(sDate)
		        {
		        	if(sDate!=""){
		        	currentDate = new Date();
		       	 var month = currentDate.getMonth() + 1
		       	 var day = currentDate.getDate()
		       	 var year = currentDate.getFullYear()
		       	 var seperator = "/"
		       	 currentDate = new Date(month + seperator + day + seperator + year);
		       	 
		     
		    	   	var  tentativeDate = new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2))
		    	   	if(tentativeDate < currentDate || tentativeDate == currentDate ){
		    	   		alert("Tentative Should be Future Date or Current Date.");
		    	   		 document.getElementById('tentativeDateId').value ="";
		    	   		return false;
		    	   	}}
		        	
		        	document.getElementById('startTime').value ="";
	    	   		document.getElementById('endTime').value ="";
		        }
		        
		        function addSurgicalRequRow() {

		        	var tbl = document.getElementById('surgicalGrid');
		        	//var hdbTabIndex = parseInt(document.getElementById('usghdbTabIndex').value) + 1;
		        	//document.getElementById('usghdbTabIndex').value = hdbTabIndex;

		        	var lastRow = tbl.rows.length;

		        	// if there's no header row in the table, then iteration = lastRow + 1
		        	var iteration = lastRow;
		        	var row = tbl.insertRow(lastRow);
		        	var hdb = document.getElementById('procCount');
		        	iteration = parseInt(hdb.value) + 1;
		        	hdb.value = iteration;
		        	// document.getElementById('pulse').value=hdb.value;

		        	var cellRight1 = row.insertCell(0);
		        	cellRight1.innerHTML=iteration;

		/*         	var cellRight1 = row.insertCell(1);
		        	cellRight1.innerHTML=document.getElementById('admisDate').value;
		        	
		        	var cellRight1 = row.insertCell(2);
		        	cellRight1.innerHTML=document.getElementById('UHID').value;
		        	
		        	var cellRight1 = row.insertCell(3);
		        	cellRight1.innerHTML=document.getElementById('patName').value;
		        	
		        	var cellRight1 = row.insertCell(4);
		        	cellRight1.innerHTML=document.getElementById('IPNo').value;	
		        	
		        	var cellRight1 = row.insertCell(5);
		        	cellRight1.innerHTML=document.getElementById('deptName').value;	 */
		        	
		        	/* var cellRight1 = row.insertCell(6);
		        	cellRight1.innerHTML=""; */
		        	
		        	var cellRight1 = row.insertCell(1);
		        	var e1 = document.createElement('input');
		        	var e2 = document.createElement('input');
		        	e1.type = 'text';
		        	e2.type = 'hidden';
		        	e1.name = 'proscedureName' + iteration;
		        	e1.id = 'proscedureName' + iteration;
		        	e1.className = "opdTextBoxSmall textYellow";
		        	
		        	/* e1.onkeypress = function(event) {
		        		selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'proscedureName'+iteration);
		        	}; */
		        	
		        	e1.onblur = function(event) {
		        		checkMappedChargeIP(this.value,iteration);getProcedureId(this.value,iteration);getSurgeryDiv(iteration);
		        	};
		        	 var newdiv1 = document.createElement('div');
		        	  newdiv1.id='ac2update2'+iteration;
		        	  newdiv1.className = 'autocomplete';
		        	  newdiv1.style.display = 'none';
		        	  
		        	  cellRight1.appendChild(e1);
		        		cellRight1.appendChild(newdiv1);
		        	  
		        	  new Ajax.Autocompleter('proscedureName'+iteration,'ac2update2'+iteration,'ipd?method=checkMappedCharge',{minChars:1,
		        		  callback: function(element, entry) {
		        	            return entry + '&chargeName=' + document.getElementById('proscedureName'+iteration).value
		        	            +'&surgeryCheck=' + document.getElementById('surgeryCategory').value ;
		        	        },parameters:'requiredField=proscedureName'+iteration});	 

		        	
		        	e2.name = 'procedureId' + iteration;
		        	e2.id = 'procedureId' + iteration;
		        	cellRight1.appendChild(e2);

		        	var e3 = document.createElement('input');
		        	e3.type = 'hidden';
		        	e3.name = 'surgeryType' + iteration;
		        	e3.id = 'surgeryType' + iteration;
		        	e3.value='';
		          	cellRight1.appendChild(e3);
		        	
		        	//var cellRight1 = row.insertCell(2);
		        	//var e1 = document.createElement('select');
		        	/* e1.options[0] = new Option('Select', '0'); */
		        //	e1.options[0] = new Option('Pending', 'Pending');
		        	/* e1.options[2] = new Option('Clear', 'Cleared');
		        	e1.options[3] = new Option('Not Fit', 'Not Fit'); */
		        	//e1.name = 'pacstatus' + iteration;
		        	//e1.id = 'pacstatus' + iteration;
		        	//cellRight1.appendChild(e1);

		        	var cellRight1 = row.insertCell(2);
		        	var e1 = document.createElement('input');
		        	e1.type = 'checkbox';
		        	e1.name = 'surgeryradio' + iteration;
		        	e1.id = 'surgeryradio' + iteration;
		        	e1.className = 'smalll';
		        	
		      /*   	var e2 = document.createElement('input');
		        	e2.type = 'hidden';
		        	e2.name = 'inpatientId' + iteration;
		        	e2.id = 'inpatientId' + iteration;
		        	e2.value=document.getElementById('inpatientId').value;
		        	
		        	var e3 = document.createElement('input');
		        	e3.type = 'hidden';
		        	e3.name = 'hinId' + iteration;
		        	e3.id = 'hinId' + iteration;
		        	e3.value=document.getElementById('hinId').value; */
		        	cellRight1.appendChild(e1);
		        //	cellRight1.appendChild(e2);
		        	//cellRight1.appendChild(e3);	
		        	
		        }
		        

		        function removeSurgicalRow(form) {
		        	var tbl = document.getElementById(form);
		        	var lastRow = tbl.rows.length;
		        	var hdb;
		        	var radio = "";
		        	if (form == 'surgicalGrid') {
		        		hdb = document.getElementById('procCount');
		        		radio = "surgeryradio";
		        	}
		        	

		        	var iteration = parseInt(hdb.value);
		        	var totalSelected = 0;
		        	if (confirm("Do you want to delete !")) {
		        		for (var i = 0; i <= iteration; i++) {
		        			if (document.getElementById(radio + i) != null
		        					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
		        					&& document.getElementById(radio + i).checked) {
		        				totalSelected = totalSelected + 1;
		        			}
		        		}

		        		if (totalSelected == 0) {
		        			alert('Please select atleast 1 row to delete');
		        		}
		        		/*
		        		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		        		 * not delete all Row.'); } else if (lastRow > 2){
		        		 */
		        		for (var i = 0; i <= iteration; i++) {
		        			if (document.getElementById(radio + i) != null
		        					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
		        					&& document.getElementById(radio + i).checked) {
		        				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
		        				document.getElementById(radio + i).parentNode.parentNode.parentNode
		        						.removeChild(deleteRow);
		        			}
		        		}

		        	}
		        }
		        

		        function ajaxFunctionDisplayOT(formName,action) {

		        	  var xmlHttp;
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

		        	      //	var brandId="brandId"+rowVal;
		        	      	var OtId="otId";
		        	      //	var batchName ="batchName"+rowVal;
		        	      //	alert(batchName);
		        		//	obj1 =document.getElementById(brandId);
		        			obj = document.getElementById(OtId);
		        			//obj1 = document.getElementById(batchName);
		        			obj.length = 1;
		        			//obj1.length =1;

		        	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		        	      		var item = items.childNodes[loop];
		        		         var batchLength  = item.getElementsByTagName("tables")[0];
		        		      

		        	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
		        	        	{
		        	        		var table = batchLength.childNodes[innerLoop];
		        		        	var tableId  = table.getElementsByTagName("tableId")[0];
		        		        	var tableNo  = table.getElementsByTagName("tableNo")[0];
		        		        	obj.length++;
		        					obj.options[obj.length-1].value=tableId.childNodes[0].nodeValue;
		        					obj.options[obj.length-1].text=tableNo.childNodes[0].nodeValue;
		        					
		        	        	}

		        	        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
		        	        		var brand = brandLength.childNodes[innerLoop];
		        		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        		        	var brandName  = brand.getElementsByTagName("brandName")[0];

		        		        	obj1.length++;
		        					obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
		        					obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

		        	        	}*/

		        	      	}
		        	      }
		        	    }
		        	   // var url=action+"&"+getNameAndData(formName);
		        	 //	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		        	 
		        	    var url=action+"&"+getNameAndData(formName);
		        	    xmlHttp.open("GET",url,true);
		        	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		        	    xmlHttp.send(null);


		        	  }
		        
		        function ajaxFunctionDisplayOtTable(formName,action) {

		  		  var xmlHttp;
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

		  		      //	var brandId="brandId"+rowVal;
		  		      	var tableId="tableId";
		  		      //	var batchName ="batchName"+rowVal;
		  		      //	alert(batchName);
		  			//	obj1 =document.getElementById(brandId);
		  				obj = document.getElementById(tableId);
		  				//obj1 = document.getElementById(batchName);
		  				obj.length = 1;
		  				//obj1.length =1;

		  		      	for (loop = 0; loop < items.childNodes.length; loop++) {
		  		      		var item = items.childNodes[loop];
		  			         var batchLength  = item.getElementsByTagName("tables")[0];
		  			      

		  		        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
		  		        	{
		  		        		var table = batchLength.childNodes[innerLoop];
		  			        	var tableId  = table.getElementsByTagName("tableId")[0];
		  			        	var tableNo  = table.getElementsByTagName("tableNo")[0];
		  			        	obj.length++;
		  						obj.options[obj.length-1].value=tableId.childNodes[0].nodeValue;
		  						obj.options[obj.length-1].text=tableNo.childNodes[0].nodeValue;
		  						
		  		        	}

		  		        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
		  		        		var brand = brandLength.childNodes[innerLoop];
		  			        	var brandId  = brand.getElementsByTagName("brandId")[0];
		  			        	var brandName  = brand.getElementsByTagName("brandName")[0];

		  			        	obj1.length++;
		  						obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
		  						obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

		  		        	}*/

		  		      	}
		  		      }
		  		    }
		  		    var url=action+"&"+getNameAndData(formName);
		  		  
		  		    xmlHttp.open("GET",url,true);
		  		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		  		    xmlHttp.send(null);


		  		  }
		      
		  	 
		        
		        function displayTable(val, startTime, endTime,formName,minorOt)
		    	{
		    		 startTime = startTime.value;
		    		 endTime = endTime.value;
		    		 
		    		 var st = startTime.split(":");
		    		 var stsec = parseInt(st[1]) + 1;
		    		 if(stsec.toString().length==1)
		    		     startTime = st[0] +':0'+stsec;
		    		 else
		    			 startTime = st[0] +':'+stsec;
		    			 
		    			 var st = endTime.split(":");
		    			 var stsec = parseInt(st[1]) + 1;
		    			 if(stsec.toString().length==1)
		    				 endTime = st[0] +':0'+stsec;
		    			 else
		    				 endTime = st[0] +':'+stsec;
		    				 
		    		 var surgeryDate = document.getElementById('tentativeDateId').value;
		    		 if(minorOt==undefined)
		    			 minorOt ='n';
		    		 
		    		 ajaxFunctionDisplayOtTable(formName,'ot?method=displayOtTableForDepartmentWiseOT&otId='+val+"&surgeryDate="+surgeryDate+"&minorOt="+minorOt);
		    		
		        } 
		        
		  	  function validateNursingCare(val, count) {
		        	var index1 = val.lastIndexOf("[");
		        	var index2 = val.lastIndexOf("]");
		        	index1++;
		        	
		        	var id = val.substring(index1, index2);
		        	if (id == "") {
		        			document.getElementById('procedureName_nursing' + count).value = "";
		        	}
		        	else
		        		document.getElementById("procedureType" + count).value = document.getElementById("nursingCategory").value;
		        	
		        	if(document.getElementById("nursingCategory").value ==document.getElementById("nurCodePhy").value)
		        		{
		        			document.getElementById('frequency_nursing' + count).value = "1";
		        			document.getElementById('noOfDays_nursing' + count).value = "7";
		        			   document.getElementById('frequency_nursing'+count).disabled = true;
		        			   document.getElementById('noOfDays_nursing'+count).readOnly = true;
		        		}
		        	else
		        		{
		        		document.getElementById('frequency_nursing' + count).value = "0";
	        			document.getElementById('noOfDays_nursing' + count).value = "";
	        			   document.getElementById('frequency_nursing'+count).disabled = false;
	        			   document.getElementById('noOfDays_nursing'+count).readOnly = false;
		        		}
		        	
		        }
		  	  
		    function validateTherapy(){
		    	var therapyhdb =-1;
		    	if(document.getElementById("therapyhdb")!=null)
		    		therapyhdb=document.getElementById("therapyhdb").value;
		 for(var inc=0;inc<=therapyhdb;inc++){
			     if(document.getElementById("therapy_nursing" + inc)!=null && document.getElementById("therapy_nursing" + inc).value!="")
			    	 {
							var currentDate = new Date();
							//appointSt = document.getElementById("appointStatus"+inc).value;
							var appointmentDate = document.getElementById("appointmentDate"+inc).value;
							var appointTime = document.getElementById("appointmentTime"+inc).value; 
							
							 if(document.getElementById("proc_treatment_teeth"+inc)!=null && document.getElementById("proc_treatment_teeth"+inc).value=="")
								{
								alert("Please enter teeth for procedure");
								return false;
								}
						 if(!document.getElementById("close"+inc).checked && appointmentDate=="")
							{
							alert("Please enter appointment Date");
							return false;
							}
						 else if(validateDate(appointmentDate,"appointmentDate"+inc)==false)
							 {
							  return false;
							 }
						 
						 if(!document.getElementById("close"+inc).checked && appointTime=="")
							{
							alert("Please enter appointment time");
							return false;
							}
			    	 }
			     
		               }
			    	 
			    	  return true;  
			    }  
			    
			    function validateDate(dateValue,varId)
			    {
			    	
			    	if(dateValue!=""){
			      	currentDate = new Date();
			       	 var month = currentDate.getMonth() + 1
			       	 var day = currentDate.getDate()
			       	 var year = currentDate.getFullYear()
			       	 var seperator = "/"
			       	 currentDate = new Date(month + seperator + day + seperator + year);
			       	 
			     
			    	   	var  tentativeDate = new Date(dateValue.substring(6),(dateValue.substring(3,5) - 1) ,dateValue.substring(0,2))
			    	   	if(tentativeDate < currentDate || tentativeDate == currentDate ){
			    	   		alert("Tentative Should be Future Date or Current Date.");
			    	   		 document.getElementById(varId).value ="";
			    	   		return false;
			    	   	}
			    	}  	
			    }
			    
		  	  
	function toggleDiv(divId,btn) {
        var d = document.getElementById(divId);
        if (d.style.display == 'none') {
        	document.getElementById(btn).value="-";
              d.style.display = 'block';
        } 
        else {
        	document.getElementById(btn).value="+";
             d.style.display = 'none';
        }
    }
		  	  
	
	function addNomenclatureRow(){
		 //  var visitId =  document.getElementById('visitId').value;
		  var tbl = document.getElementById('nomenclatureGrid');
		 
		  var lastRow = tbl.rows.length;
		
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var nomenclaturehdb = document.getElementById('nomenclaturehdb');
		  var iteration = parseInt(nomenclaturehdb.value)+1;
		  nomenclaturehdb.value=iteration
		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		 

		e0.name = 'nomenclature' + iteration;
		  e0.id = 'nomenclature' + iteration;
		  e0.onblur=function(){
		                       var val=e0.value
		                       if(val != "")
								{
							    var index1 = val.lastIndexOf("[");
							    var indexForPvms=index1;
							    var index2 = val.lastIndexOf("]");
							    index1++;
							    var pvmsNo = val.substring(index1,index2);
							    var indexForPvms=indexForPvms--;
							    var nomenclature=val.substring(0,indexForPvms);
							   	if(pvmsNo =="")
							    {
							    		document.getElementById('nomenclature'+iteration).value="";
		   								document.getElementById('pvmsNo'+iteration).value="";
		   								//disableOtherMedicine(this.value,iteration);
							     return;
							    }
							    else
		      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
		      						checkItem(iteration);checkForAlreadyIssuedPrescription(this.value,iteration/*,visitId*/);displayAu(this.value,iteration,'<%= hinId%>');checkForPurchase(this.value,iteration);checkForContradiction(this.value,iteration); 
							   }
		                       else
								    {
								    		document.getElementById('nomenclature'+iteration).value="";
			   								document.getElementById('pvmsNo'+iteration).value="";
			   								document.getElementById('itemId'+iteration).value="";
			   								//disableOtherMedicine(this.value,iteration);
								     return;
								    }
		                       
		  					  };
		  
		var newdiv = document.createElement('div');
	     	    newdiv.id='ac2update'+iteration;
	     	    newdiv.className='autocomplete';
	       	newdiv.style.display = 'none';
	          e0.size = '77';
		        e0.setAttribute('tabindex','1');

			var e01 = document.createElement('input');
		  e01.type = 'hidden';
		  e01.name = 'itemId' + iteration;
		  e01.id = 'itemId' + iteration;
		  e0.focus();
		  var e02 = document.createElement('input');
		  e02.type = 'hidden';
		  e02.name = 'itemIdClassificationId' + iteration;
		  e02.id = 'itemIdClassificationId' + iteration;
		
		  cellRight0.appendChild(e0);
		  cellRight0.appendChild(e01);
		  cellRight0.appendChild(e02);
		  cellRight0.appendChild(newdiv);

		  
		  
		
		//  alert("3--3-"+iteration);
		 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
		   //alert("name--"+e0.name)
	//alert("4---");
		    /* var cellRight1 = row.insertCell(1);
		    var eImg = document.createElement('img');
		  eImg.src = '/hms/jsp/images/search.gif';
		  eImg.name = 'search' + iteration;
		  eImg.id = 'search' + iteration;
		  eImg.WIDTH = '26';
		  eImg.HEIGHT = '26';
		  //eImg.id = 'billDateId'+iteration;
		  eImg.onclick = function(){
		   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
		    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
		  cellRight1.appendChild(eImg);*/
		//  alert("5---");
		
/*		 var cellRight1 = row.insertCell(1);
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='otherMedicine'+iteration;
		  e11.id='otherMedicine'+iteration
		  e11.size='20';
		  e11.setAttribute('tabindex','1');
		  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}
		  else{readOnlyNomenclature(this.value,iteration);} };
		  cellRight1.appendChild(e11);*/

		  /* var cellRight2 = row.insertCell(2);
		  var e12 = document.createElement('Select');
		  e12.name='itemClass'+iteration;
		  e12.id='itemClass'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<itemClassArray.length;i++ ){
		      e12.options[i+1] = new Option(itemClassArray[i][1],itemClassArray[i][0]);
		      }
		  cellRight2.appendChild(e12); */

		  //itemClassArray
		  
	/*	   var cellRight14 = row.insertCell(3);
		  var e12 = document.createElement('Select');
		  e12.name='itemConversionId'+iteration;
		  e12.id='itemConversionId'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<unitArray.length;i++ ){
		      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
		      }
		  cellRight14.appendChild(e12); */
		  
		/*   var cellRight15 = row.insertCell(1);
			  var e12 = document.createElement('Select');
			  e12.name='dispensingUnit'+iteration;
			  e12.id='dispensingUnit'+iteration;
			  e12.className='medium';
			  //e2.class = 'medium';
			  e12.setAttribute('tabindex','1');
			  e12.options[0] = new Option('Select', '0');
			   for(var i = 0;i<unitArray.length;i++ ){
			      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][1]);
			      }
			  cellRight15.appendChild(e12); */
		 var cellRight15 = row.insertCell(1);
		 var e12 = document.createElement('input');
		  e12.type = 'text';
		  e12.name='dispensingUnit'+iteration;
		  e12.id='dispensingUnit'+iteration
		  e12.readOnly=true;
		  e12.size='6';
		  e12.setAttribute('tabindex','1');
		  //e12.onblur=function(){displayAU(this.value,iteration)};
		  cellRight15.appendChild(e12);

		  
		 // var cellRight3 = row.insertCell(4);
		  var e1 = document.createElement('input');
		  e1.type = 'hidden';
		  e1.name='actualDispensingQty'+iteration;
		  e1.id='actualDispensingQty'+iteration
		  e1.size='6';
		  e1.setAttribute('tabindex','1');
		 
		  
		  var e15 = document.createElement('input');
		  e15.type = 'hidden';
		  e15.name='highValueMedicine'+iteration;
		  e15.id='highValueMedicine'+iteration
		  e15.size='1';
		  e15.setAttribute('tabindex','1');
		  cellRight15.appendChild(e15);
		  
		  var e016 = document.createElement('input');
		  e016.type = 'hidden';
		  e016.name='itemClassCode'+iteration;
		  e016.id='itemClassCode'+iteration
		  e016.size='6';
		  e016.setAttribute('tabindex','1');
		  cellRight15.appendChild(e016);
		  //end
		  var e13 = document.createElement('input');
		  e13.type = 'hidden';
		  e13.name='au'+iteration;
		  e13.id='au'+iteration
		  e13.size='6';
		  e13.setAttribute('tabindex','1');
		  //e12.onblur=function(){displayAU(this.value,iteration)};
		  cellRight15.appendChild(e13);

		 
		  cellRight15.appendChild(e1);
		  
		  
		 /* var cellRight3 = row.insertCell(4);
		  var e31 = document.createElement('input');
		  e31.type = 'checkbox';
		  e31.name='injCategory'+iteration;
		  e31.id='injCategory'+iteration
		  e31.size='10';
		  e31.className='radio';
		  e31.value='y';
		  e31.setAttribute('tabindex','1');
		  cellRight3.appendChild(e31);*/

		  var cellRight4 = row.insertCell(2);
		  var e14 = document.createElement('input');
		  e14.type = 'text';
		  e14.name='dosage'+iteration;
		  e14.id='dosage'+iteration
		  e14.size='5';
		  e14.setAttribute('maxlength', 5); 
		  e14.setAttribute('tabindex','1');
		  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
		  cellRight4.appendChild(e14);
		  
		  

		  var sel = document.createElement('input');
		  sel.type = 'hidden';
		  sel.name='pvmsNo'+iteration;
		  sel.id='pvmsNo'+iteration
		  sel.size = '10';
		  sel.setAttribute('tabindex','1');
		  cellRight4.appendChild(sel);
		
		 
		//  var cellRightSel = row.insertCell(2);
		 
		  var cellRight5 = row.insertCell(3);
		  var e2 = document.createElement('Select');
		  e2.name='frequency'+iteration;
		  e2.id='frequency'+iteration;
		  e2.className='medium';
		  //e2.class = 'medium';
		  e2.setAttribute('tabindex','1');
		  e2.options[0] = new Option('Select', '0');
		  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
		   for(var i = 0;i<icdArray.length;i++ ){
		      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		      }
		  cellRight5.appendChild(e2);
		  var e52 = document.createElement('input');
			e52.type = 'text';
			e52.name='sosQty'+iteration;
			e52.id='sosQty'+iteration;
			e52.tabIndex='1';
			e52.size='3';
			e52.style.display='none';
			e52.setAttribute('maxlength', 3); 
		    e52.onblur=function(){fillValue(iteration)};
			cellRight5.appendChild(e52);

		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='frequencyValue'+iteration;
		  e21.id='frequencyValue'+iteration;
		  e21.size='5';
		  e21.setAttribute('tabindex','1');
		  cellRight5.appendChild(e21);
		  	  
		  var cellRight6 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='noOfDays'+iteration;
		  e4.id='noOfDays'+iteration;
		  e4.size='5';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','No. of Days,int,no');
		  e4.onblur=function(){fillValue(iteration)};
		  cellRight6.appendChild(e4);

		  
			var cellRight16 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='total'+iteration;
		  e5.id='total'+iteration;
		  e5.size='5';
		  e5.setAttribute('tabindex','1');
		 // validate="total,num,no"
		  e5.setAttribute('validate','total,num,no');
		  e5.onblur=function(){treatmentTotalAlert(this.value,iteration)};
		  cellRight16.appendChild(e5);

		  /*
		  var cellRight6 = row.insertCell(6);
		  var e6 = document.createElement('Select');

		  e6.name='instructionACPC'+iteration;
		  e6.id='instructionACPC'+iteration;
		  e6.classname='smalllabel';
		  e6.setAttribute('tabindex','1');
		  e6.options[0] = new Option('Select', '');
		  e6.options[1] = new Option('AC', 'AC');
		  e6.options[2] = new Option('PC', 'PC',true);
		  cellRight6.appendChild(e6);


		  var cellRight7 = row.insertCell(7);
		   var e7 = document.createElement('Select');

		  e7.name='typeLeftRight'+iteration;
		  e7.id='typeLeftRight'+iteration;
		  e7.classname='smalllabel';
		  e7.setAttribute('tabindex','1');
		   e7.options[0] = new Option('Select', '');
		   e7.options[1] = new Option('Left', 'left');
		   e7.options[2] = new Option('Right', 'right');
		   cellRight7.appendChild(e7);
	*/

		//	var cellRight7 = row.insertCell(7);
			
			

			/*var cellRight8 = row.insertCell(9);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='route'+iteration;
			e6.id='route'+iteration
			e6.size='5';
			e6.value=''
			e6.setAttribute('maxlength', 20); 
			e6.setAttribute('tabindex','1');
			cellRight8.appendChild(e6);*/

		  var cellRight9 = row.insertCell(6);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='remarks'+iteration;
		  e7.id='remarks'+iteration
		  e7.size='10';
		  e7.setAttribute('placeholder','1-1-1');
		  e7.setAttribute('maxlength', 15); 
		  e7.setAttribute('tabindex','1');
		  cellRight9.appendChild(e7);

	/* 	  var cellRight10 = row.insertCell(9);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name='ct'+iteration;
		  e71.id='ct'+iteration
		  e71.size='10';
		  e71.className='radio';
		  e71.value='y';
		  e71.setAttribute('tabindex','1');
		  cellRight10.appendChild(e71); */

		  var cellRight11 = row.insertCell(7);
		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name='closingStock'+iteration;
		  e72.id='closingStock'+iteration
		  e72.size='3';
		  e72.setAttribute('tabindex','1');
		  cellRight11.appendChild(e72);

		  var cellRight12 = row.insertCell(8);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.value = "";
		  e8.name='remarks'+iteration;
		 // e8.setAttribute('onClick', 'addRow();'); 
		  e8.onclick = function(){addNomenclatureRow();}; 
		  e8.setAttribute('tabindex','1');
		  cellRight12.appendChild(e8);

		  var cellRight13 = row.insertCell(9);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.value = "";
		  e9.name='remarks'+iteration;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e9.onclick = function(){removeRow("nomenclatureGrid","nomenclaturehdb",this);};  
		  e9.setAttribute('tabindex','1');
		  cellRight13.appendChild(e9);

		 
		  
		   //added - fayaz
		//  var cellRight9 = row.insertCell(9);
	 //   var e9 = document.createElement('input');
//	     e9.id = 'a'
//	     e9.type = 'checkbox';
//	    cellRight9.appendChild(e9);

		}

	function addRowForNIP(){
		  /* var visitId =  document.getElementById('visitId').value;*/
		  var tbl = document.getElementById('grid');
		 
		  var lastRow = tbl.rows.length;
		
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value=iteration
		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		 

		e0.name = 'nomenclature' + iteration;
		  e0.id = 'nomenclature' + iteration;
		  e0.onblur=function(){
		                       var val=e0.value
		                       if(val != "")
								{
							    var index1 = val.lastIndexOf("[");
							    var indexForPvms=index1;
							    var index2 = val.lastIndexOf("]");
							    index1++;
							    var pvmsNo = val.substring(index1,index2);
							    var indexForPvms=indexForPvms--;
							    var nomenclature=val.substring(0,indexForPvms);
							   	if(pvmsNo =="")
							    {
							    		document.getElementById('nomenclature'+iteration).value="";
		   								document.getElementById('pvmsNo'+iteration).value="";
		   								disableOtherMedicine(this.value,iteration);
							     return;
							    }
							    else
		      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
		      						checkItem(iteration);disableOtherMedicine(this.value,iteration);checkForAlreadyIssuedPrescription(this.value,iteration/*,visitId*/);displayAu(this.value,iteration,'<%= hinId%>');checkForPurchase(this.value,iteration);checkForContradiction(this.value,iteration); 
							   }
		                       else
								    {
								    		document.getElementById('nomenclature'+iteration).value="";
			   								document.getElementById('pvmsNo'+iteration).value="";
			   								document.getElementById('itemId'+iteration).value="";
			   								disableOtherMedicine(this.value,iteration);
								     return;
								    }
		                       
		  					  };
		  
		var newdiv = document.createElement('div');
	     	    newdiv.id='ac2update'+iteration;
	     	    newdiv.className='autocomplete';
	       	newdiv.style.display = 'none';
	          e0.size = '30';
		        e0.setAttribute('tabindex','1');

			var e01 = document.createElement('input');
		  e01.type = 'hidden';
		  e01.name = 'itemId' + iteration;
		  e01.id = 'itemId' + iteration;
		  e0.focus();
		  var e02 = document.createElement('input');
		  e02.type = 'hidden';
		  e02.name = 'itemIdClassificationId' + iteration;
		  e02.id = 'itemIdClassificationId' + iteration;
		
		  cellRight0.appendChild(e0);
		  cellRight0.appendChild(e01);
		  cellRight0.appendChild(e02);
		  cellRight0.appendChild(newdiv);

		  
		  
		
		//  alert("3--3-"+iteration);
		 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'opd?method=getNipItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
		   //alert("name--"+e0.name)
	//alert("4---");
		    /* var cellRight1 = row.insertCell(1);
		    var eImg = document.createElement('img');
		  eImg.src = '/hms/jsp/images/search.gif';
		  eImg.name = 'search' + iteration;
		  eImg.id = 'search' + iteration;
		  eImg.WIDTH = '26';
		  eImg.HEIGHT = '26';
		  //eImg.id = 'billDateId'+iteration;
		  eImg.onclick = function(){
		   var url="/hms/hms/opd?method=showItemSearchJsp&count="+iteration;
		    newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
		  cellRight1.appendChild(eImg);*/
		//  alert("5---");
		
		 var cellRight1 = row.insertCell(1);
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='otherMedicine'+iteration;
		  e11.id='otherMedicine'+iteration
		  e11.size='20';
		  e11.setAttribute('tabindex','1');
		  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}
		  else{readOnlyNomenclature(this.value,iteration);} };
		  cellRight1.appendChild(e11);

		   var cellRight2 = row.insertCell(2);
		  var e12 = document.createElement('Select');
		  e12.name='itemClass'+iteration;
		  e12.id='itemClass'+iteration;
		 // e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<itemClassArray.length;i++ ){
		      e12.options[i+1] = new Option(itemClassArray[i][1],itemClassArray[i][0]);
		      }
		  cellRight2.appendChild(e12); 

		  //itemClassArray
		  
		   var cellRight14 = row.insertCell(3);
		  var e12 = document.createElement('Select');
		  e12.name='itemConversionId'+iteration;
		  e12.id='itemConversionId'+iteration;
		  e12.className='medium';
		  //e2.class = 'medium';
		  e12.setAttribute('tabindex','1');
		  e12.options[0] = new Option('Select', '0');
		   for(var i = 0;i<unitArray.length;i++ ){
		      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][0]);
		      }
		  cellRight14.appendChild(e12); 
		  
		   var cellRight15 = row.insertCell(4);
			  var e12 = document.createElement('Select');
			  e12.name='dispensingUnit'+iteration;
			  e12.id='dispensingUnit'+iteration;
			  e12.className='medium';
			  //e2.class = 'medium';
			  e12.setAttribute('tabindex','1');
			  e12.options[0] = new Option('Select', '0');
			   for(var i = 0;i<unitArray.length;i++ ){
			      e12.options[i+1] = new Option(unitArray[i][1],unitArray[i][1]);
			      }
			  cellRight15.appendChild(e12); 
		  

		  
		 // var cellRight3 = row.insertCell(4);
		  var e1 = document.createElement('input');
		  e1.type = 'hidden';
		  e1.name='actualDispensingQty'+iteration;
		  e1.id='actualDispensingQty'+iteration
		  e1.size='6';
		  e1.setAttribute('tabindex','1');
		 
		  
		  var e15 = document.createElement('input');
		  e15.type = 'hidden';
		  e15.name='highValueMedicine'+iteration;
		  e15.id='highValueMedicine'+iteration
		  e15.size='1';
		  e15.setAttribute('tabindex','1');
		  cellRight15.appendChild(e15);
		  
		  var e016 = document.createElement('input');
		  e016.type = 'hidden';
		  e016.name='itemClassCode'+iteration;
		  e016.id='itemClassCode'+iteration
		  e016.size='6';
		  e016.setAttribute('tabindex','1');
		  cellRight15.appendChild(e016);
		  //end
		  var e13 = document.createElement('input');
		  e13.type = 'hidden';
		  e13.name='au'+iteration;
		  e13.id='au'+iteration
		  e13.size='6';
		  e13.setAttribute('tabindex','1');
		  //e12.onblur=function(){displayAU(this.value,iteration)};
		  cellRight15.appendChild(e13);

		 
		  cellRight15.appendChild(e1);
		  
		  
		  
		  var cellRight10 = row.insertCell(5);
		  var e31 = document.createElement('input');
		  e31.type = 'text';
		  e31.name='uomQty'+iteration;
		  e31.id='uomQty'+iteration
		  e31.size='5';
		  e31.setAttribute('maxlength', 5); 
		  e31.setAttribute('tabindex','1');
		  e31.setAttribute('validate','UOM Qty,float,no');
		  cellRight10.appendChild(e31);
		  

		  var cellRight4 = row.insertCell(6);
		  var e14 = document.createElement('input');
		  e14.type = 'text';
		  e14.name='dosage'+iteration;
		  e14.id='dosage'+iteration
		  e14.size='5';
		  e14.setAttribute('maxlength', 5); 
		  e14.setAttribute('tabindex','1');
		  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
		  cellRight4.appendChild(e14);
		  
		  

		  var sel = document.createElement('input');
		  sel.type = 'hidden';
		  sel.name='pvmsNo'+iteration;
		  sel.id='pvmsNo'+iteration
		  sel.size = '10';
		  sel.setAttribute('tabindex','1');
		  cellRight4.appendChild(sel);
		
		 
		//  var cellRightSel = row.insertCell(2);
		 
		  var cellRight5 = row.insertCell(7);
		  var e2 = document.createElement('Select');
		  e2.name='frequency'+iteration;
		  e2.id='frequency'+iteration;
		  e2.className='medium';
		  //e2.class = 'medium';
		  e2.setAttribute('tabindex','1');
		  e2.options[0] = new Option('Select', '0');
		  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
		   for(var i = 0;i<icdArray.length;i++ ){
		      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		      }
		  cellRight5.appendChild(e2);
		  var e52 = document.createElement('input');
			e52.type = 'text';
			e52.name='sosQty'+iteration;
			e52.id='sosQty'+iteration;
			e52.tabIndex='1';
			e52.size='3';
			e52.style.display='none';
			e52.setAttribute('maxlength', 3); 
		    e52.onblur=function(){fillValue(iteration)};
			cellRight5.appendChild(e52);

		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='frequencyValue'+iteration;
		  e21.id='frequencyValue'+iteration;
		  e21.size='5';
		  e21.setAttribute('tabindex','1');
		  cellRight5.appendChild(e21);
		  	  
		  var cellRight6 = row.insertCell(8);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='noOfDays'+iteration;
		  e4.id='noOfDays'+iteration;
		  e4.size='5';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','No. of Days,int,no');
		  e4.onblur=function(){fillValue(iteration)};
		  cellRight6.appendChild(e4);

		  
			var cellRight16 = row.insertCell(9);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='total'+iteration;
		  e5.id='total'+iteration;
		  e5.size='5';
		  e5.setAttribute('tabindex','1');
		 // validate="total,num,no"
		  e5.setAttribute('validate','total,num,no');
		  e5.onblur=function(){treatmentTotalAlert(this.value,iteration)};
		  cellRight16.appendChild(e5);

		  /*
		  var cellRight6 = row.insertCell(6);
		  var e6 = document.createElement('Select');

		  e6.name='instructionACPC'+iteration;
		  e6.id='instructionACPC'+iteration;
		  e6.classname='smalllabel';
		  e6.setAttribute('tabindex','1');
		  e6.options[0] = new Option('Select', '');
		  e6.options[1] = new Option('AC', 'AC');
		  e6.options[2] = new Option('PC', 'PC',true);
		  cellRight6.appendChild(e6);


		  var cellRight7 = row.insertCell(7);
		   var e7 = document.createElement('Select');

		  e7.name='typeLeftRight'+iteration;
		  e7.id='typeLeftRight'+iteration;
		  e7.classname='smalllabel';
		  e7.setAttribute('tabindex','1');
		   e7.options[0] = new Option('Select', '');
		   e7.options[1] = new Option('Left', 'left');
		   e7.options[2] = new Option('Right', 'right');
		   cellRight7.appendChild(e7);
	*/

		//	var cellRight7 = row.insertCell(7);
			
			

		/*	var cellRight8 = row.insertCell(9);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='route'+iteration;
			e6.id='route'+iteration
			e6.size='5';
			e6.value=''
			e6.setAttribute('maxlength', 20); 
			e6.setAttribute('tabindex','1');
			cellRight8.appendChild(e6);*/

		  var cellRight9 = row.insertCell(10);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.name='remarks'+iteration;
		  e7.id='remarks'+iteration
		  e7.size='10';
		  e7.setAttribute('placeholder','1-1-1');
		  e7.setAttribute('maxlength', 15); 
		  e7.setAttribute('tabindex','1');
		  cellRight9.appendChild(e7);

	/* 	  var cellRight10 = row.insertCell(9);
		  var e71 = document.createElement('input');
		  e71.type = 'checkbox';
		  e71.name='ct'+iteration;
		  e71.id='ct'+iteration
		  e71.size='10';
		  e71.className='radio';
		  e71.value='y';
		  e71.setAttribute('tabindex','1');
		  cellRight10.appendChild(e71); */

		  var cellRight11 = row.insertCell(11);
		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name='closingStock'+iteration;
		  e72.id='closingStock'+iteration
		  e72.size='3';
		  e72.setAttribute('tabindex','1');
		  cellRight11.appendChild(e72);

		  var cellRight12 = row.insertCell(12);
		  var e8 = document.createElement('input');
		  e8.type = 'button';
		  e8.className = 'buttonAdd';
		  e8.value = "";
		  e8.name='remarks'+iteration;
		 // e8.setAttribute('onClick', 'addRow();'); 
		  e8.onclick = function(){addRowForNIP();}; 
		  e8.setAttribute('tabindex','1');
		  cellRight12.appendChild(e8);

		  var cellRight13 = row.insertCell(13);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.value = "";
		  e9.name='remarks'+iteration;
		  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
		  e9.onclick = function(){removeRow("grid","hdb",this);};  
		  e9.setAttribute('tabindex','1');
		  cellRight13.appendChild(e9);

		 
		  
		   //added - fayaz
		//  var cellRight9 = row.insertCell(9);
	 //   var e9 = document.createElement('input');
//	     e9.id = 'a'
//	     e9.type = 'checkbox';
//	    cellRight9.appendChild(e9);

		}
	function enablePhysioProcedure(){
  var count = document.getElementById('nursinghdb').value
	   for(var i=0;i<=count;i++)
		  {
		   if(document.getElementById('frequency_nursing'+i)!=null)
		   document.getElementById('frequency_nursing'+i).disabled = false;
		  }
	}
	
	function deleteDgItems(value){
	     if(document.getElementById('diagnosisId').selectedIndex!=0){
		 if(confirm("are you sure want to delete ?")){
			    if(document.getElementById('diagnosisId').options[1].value ==document.getElementById('NAIcd').value)
			    	document.getElementById('NAIcd').checked=false;
	 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)
		    }
		   }
	     }
//	function showHideDrugTemplateCombo(valueOfTemplate){
//		
//	
//	}
	

    function checkAvailbilityForSurgeryTime(t1, t2, divName){
      	 var  endTime = t1;
      	 var startTime = t2.value;
      	 var surgeryDate = document.getElementById('tentativeDateId').value;
      	if( startTime!="")
      		{
      		var now = new Date();
      		surgeryDate = new Date(surgeryDate.substring(6),(surgeryDate.substring(3,5) - 1) ,surgeryDate.substring(0,2));
      		var isToday = (now.toDateString() == surgeryDate.toDateString());
      		//alert(today.toDateString() +" ff" +otherDate.toDateString() +" f" +isToday);
      		now = now.toString().substr(16,5);
      		
      		
      		
      		if(isToday && ( now > startTime || now >endTime) )
      			{
      			document.getElementById('endTime').value  = '';
      			document.getElementById('startTime').value  = '';
      			alert("Surgery time should be a future time");
      			return false;
      			}
      		else if(startTime>endTime)
      			{
      			alert("Surgery start time should be less than Surgery end time");
      			document.getElementById('endTime').value  = '';
      			document.getElementById('startTime').value  = '';
      			return false;
      			}
      			
      	}
   	else
  		{
  			document.getElementById('endTime').value  = '';
  		alert("Please enter Start time first");
  		return false;
  		}
       }
    
    function showCIMS()
    {
    		   	var url="/hms/hms/opd?method=showCIMSPopUp&flag=opd";
    		    newwindow=window.open(url,'CIMS',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    }
    
	function clearAppointment(appDt, appTime,inc)
	{
		document.getElementById(appDt).value="";
		document.getElementById(appTime).value=""; 
		if(document.getElementById("appointDateSpan"+inc)!=null && document.getElementById("appointTimeSpan"+inc)){
			document.getElementById("appointDateSpan"+inc).style.display='none';
			document.getElementById("appointTimeSpan"+inc).style.display='none';
		}
	}
	
	function markAppointMandatory(inc)
	{
		if(document.getElementById("appointDateSpan"+inc)!=null && document.getElementById("appointTimeSpan"+inc)){
			document.getElementById("appointDateSpan"+inc).style.display='inline-block';
			document.getElementById("appointTimeSpan"+inc).style.display='inline-block';
		}
	}
	
	  function showUpdateOpdTempate(templateType){
	      
			//	document.getElementById('prescriptionImportButton').style.display = 'inline';
			   	var url="/hms/hms/opd?method=showUpdateOpdTempate&templateType="+templateType;
			    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
			   
			     }
function addNAIcd(val,obj1) {

        
	  	/*  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;*/
		    var id = val;
		   
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
                    var valu=obj.options[obj.length-1].value;
					var b="false";
			/*		for(var i=1;i<obj.length;i++){
							    
		                    	var val1=obj.options[i].value;
		                    	var length=obj.length-1;
                                	
		                    	if(id==val1)
		                    	{
		                        	alert("ICD  Already taken");
		                        	document.getElementById('icd').value =""
		                        	b=true;
		                       	}
		                              	
		                    }*/
					
		                    if(obj1.checked)
		                    {
		                    	
		                    	for(var i=1;i<obj.length;i++){
								    
			         /*           	var val1=obj.options[i].value;
			                    	var length=obj.length-1;
	                                	
			                    	if(id==val1)
			                    	{
			                        	alert("ICD  Already taken");
			                        	document.getElementById('icd').value =""
			                        	b=true;
			                       	}
			                    	
			                    	  if (selectobject.options[i].value == 'A' )*/
			                    		  obj.remove(i);
			                    	
			                              	
			                    }
		                    	
		                    	obj.length++;
		    					obj.options[obj.length-1].value=val;
		    					obj.options[obj.length-1].text="Not available in ICD";
		    					obj.options[obj.length-1].selected=true
		    					document.getElementById('icd').value =""
		    			                    
		                    }
		                    else
		                    	{
		                    	  obj.remove(1);
		                    	}
		                    
		                  /*  function deleteDgItems(value){
		               	     if(document.getElementById('diagnosisId').selectedIndex!=0){
		               		 if(confirm("are you sure want to delete ?")){
		               	 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)
		               		    }
		               		   }
		               	     }*/
		                    
				}
	  }

function fnGetAvailableDoctor(departmentId, divName, loginDoctor) {
	// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
	 var extraArg ='n';
	 if(loginDoctor!=null)
		 extraArg = loginDoctor;
	new Ajax.Request(
			'opd?method=getAvailableDoctorDetails&departmentId=' + departmentId+'&loginDoctor='+extraArg,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById(divName).innerHTML = response.responseText
								.trim();
					}
				}
			});
}
 
function addRowForRefer() {
	
	
	var tbl = document.getElementById('referGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueRefer');
	var iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
    var colPosition = 0;


/* 	var cellRight0 = row.insertCell(colPosition);
	var e0 = document.createElement('textarea');
	  e0.setAttribute('maxlength', 100);
	  e0.name='referral_notes'+iteration;
	  e0.id='referral_notes'+iteration;
	cellRight0.appendChild(e0);
	 colPosition = colPosition+1; */
	 
	
	  
	  var cellRight1 = row.insertCell(colPosition);
	  var e2 = document.createElement('Select');
	  e2.name='refereddept'+iteration;
	  e2.id='deptId'+iteration;
	  //e2.class = 'medium';
	 // e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	 e2.onblur=function(){fnGetAvailableDoctor(this.value,'refereddoctor'+iteration);};
	   for(var i = 0;i<departmentArray.length;i++ ){
	      e2.options[i+1] = new Option(departmentArray[i][1],departmentArray[i][0]);
	      }
	  cellRight1.appendChild(e2);

	   colPosition = colPosition+1;
		  var cellRight2 = row.insertCell(colPosition);
		  var e3 = document.createElement('Select');
		  e3.name='refereddoctor'+iteration;
		  e3.id='refereddoctor'+iteration;
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('Select', '0');
		
		  cellRight2.appendChild(e3);
	 
	 colPosition = colPosition+1;
	var cellRight3 = row.insertCell(colPosition);
	var e4 = document.createElement('input');
	e4.type = 'button';
	e4.className = 'buttonAdd';
	e4.name = 'Button';
	e4.value = '';
	
	e4.setAttribute('tabindex', '1');
	e4.onclick = function() {
		addRowForRefer();
	};
	cellRight3.appendChild(e4);

	colPosition = colPosition+1;
	var cellRight4 = row.insertCell(colPosition);
	var e5 = document.createElement('input');
	e5.type = 'button';
	e5.className = 'buttonDel';
	e5.value = '';
	e5.setAttribute('tabindex', '1');
	e5.onclick = function() {
		removeRow("referGrid", "hdb", this);
	};
	cellRight4.appendChild(e5);

}

function treatmentTotalAlert(val,inc)
{
	if(document.getElementById('actualDispensingQty'+inc).value != 0 && val>2)
		alert("Total quantity  is more than 2");
}

function setTextValue(val,Id)
{
	
	document.getElementById(Id.value).value =val;
}

function toogleVaccinDetails(i,j,csrfTokenName,csrfTokenValue){
	if(j.checked){
	/* 	document.getElementById("vaccinDetails"+i).style.display = '';
		document.getElementById("dosage"+i).value = '1';
		displayAu(i,csrfTokenName,csrfTokenValue); */
		document.getElementById("checkItem"+i).value = 'Y';
		document.getElementById("completionDate"+i).value= document.getElementById("currentDate").value;
	}else{
	/* 	document.getElementById("vaccinDetails"+i).style.display = 'none'; */
		document.getElementById("checkItem"+i).value = 'N';
		document.getElementById("completionDate"+i).value="";
	} 
}

function updateDeleteNISNIP(flag,dtId,inc)
{
	var confirmation =false;
	if(flag=="u" && confirm("Do You want to modify the issued prescription?")){
		confirmation=true;
	}
	else if(flag=="d" && confirm("Do You want to delete the issued prescription?")){
		confirmation=true;
	}	
		if(confirmation){
	var data="&flag="+flag+"&dtId="+dtId;
	if(flag=="u"){
		data =data+ "&freq="+document.getElementById("issuedfrequency"+inc).value+"&days="+document.getElementById("issuedDays"+inc).value+"&dosage="+document.getElementById("issuedDosage"+inc).value+"&total="+document.getElementById("issuedTotal"+inc).value;;
	}
	new Ajax.Request(
			'opd?method=updateDeleteNISNIP'+data,
			{
				
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						if(response.responseText=="s"){
							alert("Action Completed");
						if(flag=="d"){
							 document.getElementById("issuedTreatmentGrid").deleteRow(inc); 
						}
						}
						else{
							alert("Action could not be completed, All fields are mandatory");
						}
					}
				}
			});
	}
}

function showCreatePrescriptionTempate(){
    
		document.getElementById('prescriptionImportButton').style.display = 'inline';
   	var url="/hms/hms/opd?method=showCreatePrescriptionTempate";
    newwindow=window.open(url,'presciption',"height=500,width=1010,status=1,top=0,left=2");
     }
function showCreateInvestigationTemplate(){
    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
}

function getListForTreatment(val, formName){
 	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName(formName,'/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName(formName,'/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
//	document.getElementById('prescriptionImportButton').style.display = 'none';
//	document.getElementById("investigationImportButton").style.display='none'
 }


