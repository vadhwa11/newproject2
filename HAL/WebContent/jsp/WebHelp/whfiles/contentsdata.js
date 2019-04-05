var ContentItems = [
	["Home", "source/MainHMS.html", "1",
	    ["Enquiry", "source/MainEnquiry.html", "1",
			["Patient Enquiry", "source/enq_inpatientenquiry.html", "11"],
			["Doctor Enquiry", "source/enq_doctorenquiry.html", "11"],
			["Patient Enquiry Details", "source/enq_patientdetails.html", "11"]
		],
		["Admission Discharge And Transfer", "source/MainADT.html", "1",
			["Patient Registration", "source/MainSubADT_PATIENTREGISTATION.html", "1",
				["Patient Registration", "source/adt_PatientRegistration.html", "11"],
				["Update Patient Registration", "source/adt_UpdatePatientRegistrati.html", "11"]
			],
			["Patient Visit", "source/MainSubADT_PATIENTVISIT.html", "1",
				["Patient Visit Search", "source/adt_PatientVisitSearch.html", "11"],
				["Patient Visit Details", "source/adt_PatientVisitDetails.html", "11"]
			],
			["IP Admission", "source/MainSubADT_IPADDMISSION.html", "1",
				["IP Admission Search", "source/adt_ipaddmissionsearch.html", "11"],
				["IP Admission Details", "source/adt_ipaddmissiondetails.html", "11"]
			],
			["IP Admission Transfer", "source/MainSubADT_IPADMISSIONTRANSFER.html", "1",
				["IP Admission Transfer Search", "source/adt_PatientTransferSearch.html", "11"],
				["IP Admission Transfer Details", "source/adt_PatientTransferDetails.html", "11"]
			],
			["IP Admission Discharge", "source/MainSubADT_IpadmissionDischarge.html", "1",
				["IP Admission Discharge Search", "source/adt_PatientDischargeSearch.html", "11"],
				["IP Admission Discharge Details", "source/adt_PatientDischargeDetails.html", "11"],
				["Final Discharge", "source/adt_finalDischarge.html", "11"]
			],
			["Expiry Details", "source/adt_PatientDischargeExpiry.html", "11"],
			["Daily Bed Status", "source/adt_dailybedstatus.html", "11"],
			["OP MLC Case", "source/adt_OpmlcCase.html", "11"]
		],
		["Appointment", "source/MainAppointment.html", "1",
			["Appointment Setup", "source/app_appointmentsetup.html", "11"],
			["Patient Appointments", "source/app_opdpatientappointment.html", "11"],
			["Investigation Appointments Setup", "source/app_investigationappointmen.html", "11"],
			["Investigation Appointments", "source/app_opdinvestigationappoint.html", "11"],
			["Cancel Patient Appointments", "source/app_cancellationforpatienta.html", "11"],
			["Cancel Investigation Appointments", "source/app_cancellationforinvestig.html", "11"],
		],
		["Out Patient Department", "source/MainOPD.html", "1",
			["OPD Waiting List", "source/opd_waitingpatientlist.html", "11"],
			["OPD Cardiology", "source/opd_Cardiology.html", "11"],
			["OPD ENT", "source/opd_ent.html", "11"],
			["OPD Onco Surgery Case Sheet", "source/opd_oncosurgerycasesheet.html", "11"],
			["OPD Ophthalmology", "source/opd_Opthomology.html", "11"],
			["Ophthalmology Follow Up", "source/opd_Opthomology_floowup.html", "11"],
			["Retinal Laser Proforma", "source/opd_Opthomology_retinal.html", "11"],
			["OPD Pediatric Case Sheet", "source/opd_Paediatrics.html", "11"],
			["OPD Urology Case Sheet", "source/opd_urologycasesheet.html", "11"],
			["OPD -Main (AFMSF-7A 2002)  View ", "source/opd_patientpreviousvisits.html", "11"],
			["OPD- Main (AFMSF- 7A 2002)", "source/opd_main_afmsf7casesheet.html", "11"],
			["In Patient Surgery Requisition Form", "source/OT_surgeryrequesitions.html", "11"],
			["OPD Patient Info", "source/MainSubOPD_PATIENTINFO.html", "1",
				["OPD Search Patient Previous Visit", "source/opd_searchpatientpreviousvi.html", "11"],
				["OPD Patient Details Update", "source/opd_patientvisitupdate.html", "11"]
			],
		],
		["Laboratory", "source/MainLaboratory.html", "1",
			["Diagnostic Master", "source/Lab_Diagnosticmaster.html", "11"],
			["Order Booking", "source/MainSubLAB_ORDERBOOKING.html", "1",
			    ["Order Booking", "source/Lab_orderbooking.html", "11"],
			    ["Order Booking Search", "source/Lab_orderbookingIPDSearch.html", "11"],
			    ["Cancel Order Booking", "source/Lab_cancelorderbooking.html", "11"],
			    ["Confidential Order Booking Request", "source/Lab_Confidentialorderreq.html", "11"]
			],
			["Pending For Sample Validation", "source/MainSubLAB_PENDINGFORSAMPLEVALIDATION.html", "1",
				["Pending For Sample Validation Search", "source/Lab_samplevalidationsearch.html", "11"],
				["Pending For Sample Validation Details", "source/Lab_samplevalidationdetail.html", "11"]
			],
			["Pending For Result Entry", "source/MainSubLAB_PENDINGFORRESULTENTRY.html", "1",
				["Pending For Result Entry Search", "source/Lab_resultentrysearch.html", "11"],
				["Pending For Result Entry Details", "source/Lab_resultentrydetail.html", "11"]
			],
			["Pending For Result Validation", "source/MainSubLAB_PENDINGFORRESULTVALIDATION.html", "1",
				["Pending For Result Validation Search", "source/Lab_resultvalidationsearch.html", "11"],
				["Pending For Result Validation Details", "source/Lab_resultvalidationdetail.html", "11"]
			],
			["Result Delivery", "source/MainSubLAB_REPORTDELIVERY.html", "1",
				["Result Delivery Search", "source/Lab_reportdeliverysearch.html", "11"],
				["Result Delivery Details", "source/Lab_reportdeliverydetail.html", "11"]
			],
			["Result Printing", "source/Lab_resultprinting.html", "11"],
			["Result Modification", "source/MainSubLAB_RESULTMODIFICATION.html", "1",
				["Result Modification Search", "source/Lab_resultentrymodifysearch.html", "11"],
				["Result Modification Details", "source/Lab_resultentrymodifydetail.html", "11"]
			]
		],
		["Radiology", "source/MainRadiology.html", "1",
			["Diagnostic Master", "source/Rad_diagnosticmaster.html", "11"],
			["Order Booking", "source/MainSubRAD_ORDERBOOKING.html", "1",
			    ["Radiology Order Booking", "source/Rad_orderbooking.html", "11"],
				["Radiology Cancel Order Booking", "source/Rad_cancelOBsearch.html", "11"]
			],
			["Radiology Acceptance For Investigations", "source/MainSubRAD_PENDINGFORSAMPLEVALIDATION.html", "1",
				["Radiology Acceptance For Investigations Search", "source/Rad_AcceptanceforRadiologicalInvestigationsSearch.html", "11"],
				["Radiology Acceptance For Investigations Details", "source/Rad_AcceptanceforRadiologicalInvestigations.html", "11"]
			],
			["Pending For Report Entry", "source/MainSubRAD_PENDINGFORRESULTENTRY.html", "1",
				["Radiology Pending For Report Entry Search", "source/Rad_pendingreportentrysearch.html", "11"],
				["Radiology Pending For Report Entry Details", "source/Rad_pendingreportentryDetails.html", "11"]
			],
			["Pending For Report Validation", "source/MainSubRAD_PENDINGFORRESULTVALIDATION.html", "1",
				["Radiology Pending For Report Validation Search", "source/Rad_resultvalidsearch.html", "11"],
				["Radiology Pending For Report Validation Details", "source/Rad_reportvalidationdetail.html", "11"]
			],
			["Film Entry", "source/Rad_filmentry.html", "11"],
			["Report Delivery", "source/MainSubRAD_REPORTDELIVERY.html", "1",
				["Radiology Report Delivery Search", "source/Rad_reportdeliverysearch.html", "11"],
				["Radiology Report Delivery Details", "source/Rad_reportdeliverydetail.html", "11"]
			],
			["Result Printing", "source/Rad_reportprinting.html", "11"],
			["Radiology Confidential Order Booking Request", "source/Rad_Confidentialorderreq.html", "11"]

		],
		["Ward Management", "source/MainIPD.html", "1",
		    ["Nursing Station", "source/IPD_patientsearch.html", "11"],
			["Clinical Setup", "source/IPD_clinicalsetup.html", "11"],
			["Nursing Entry", "source/IPD_nursingentry.html", "11"],
			["Clinical Chart", "source/IPD_clinicalchart.html", "11"],
			["Intake/Output", "source/IPD_intakeandouttake.html", "11"],
			["Discharge Sum General", "source/IPD_dischargesumgeneral.html", "11"],
			["Discharge Sum O & G", "source/IPD_dischargesumOG.html", "11"],
			["Discharge Sum Paediatrice", "source/IPD_dischargesumPaediatrice.html", "11"],
			["Discharge Sum NABH", "source/IPD_dischargesumNABH.html", "11"],
			["Ward Consumption", "source/IPD_wardconsumption.html", "11"],
			["Food Fasting", "source/IPD_foodtasting.html", "11"],
			["Patient Issue", "source/IPD_patientissue.html", "11"],
			["Department Indent", "source/IPD_departmentindent.html", "11"],
			["Patient Diagnosis", "source/IPD_patientdiagnosis.html", "11"],
            ["SILDIL", "source/IPD_sildil.html", "11"],
			["Patient Transfer", "source/IPD_patienttransfer.html", "11"],
			["Patient Discharge", "source/IPD_patientdischarge.html", "11"],
			["Daily Remarks", "source/IPD_dailyremarks.html", "11"],
			["Patient Remarks", "source/IPD_patientremark.html", "11"],
			["Order Booking", "source/IPD_orderbooking.html", "11"],
			["Order Status", "source/IPD_orderstatus.html", "11"],
		],
		["Operation Theatre", "source/MainOT.html", "1",
			["PAC Clearance List", "source/OT_pacClearanceList.html", "11"],
			["OT Booking List", "source/OT_bookingList.html", "11"],
			["OT List Change", "source/OT_Changelist.html", "11"],
			["Post OP Notes Anaesthesia Search", "source/OT_PostOPNotesAnaesthesiaSearch.html", "11"],
			["Post OP Notes Anaesthesia Details", "source/OT_PostOPNotesAnaesthesia.html", "11"],
			["Post OP Notes Surgery Search", "source/OT_PostOPNotesSurgerySearch.html", "11"],
			["Post OP Notes Surgery Details", "source/OT_PostOPNotesSurgery.html", "11"],
			["Specimen Dispatch Entry Search", "source/OT_SpecimenDispatchEntrySearch.html", "11"],
			["Specimen Dispatch Entry Details", "source/OT_SpecimenDispatchEntry.html", "11"],
			["Human Body Parts Disposal Search", "source/OT_HumanBodyPartsDisposalSearch.html", "11"],
			["Human Body Parts Disposal Details", "source/OT_HumanBodyDisposalEntry.html", "11"],
			["Surgery Enquiry", "source/OT_SurgeryEnquiry.html", "11"],
			["Actual Surgery Perform", "source/OT_Actualsurgeryperform.html", "11"],
			["Surgery Requesitions", "source/OT_surgeryrequesitions.html", "11"]
		],
		["Blood Bank", "source/MainBloodBank.html", "1",
			["Blood Component Master", "source/BLD_component_Master.html", "11"],
			["Consent for Blood Transfusion Entry", "source/BLD_Consent_Blood_Transfusion.html", "11"],
			["Blood Request Entry", "source/BLD_Blood_Request_Entry.html", "11"],
			["Pending For Blood Grouping & Cross Matching", "source/BLD_Pending_For_Blood_Grouping_Cross_Matching.html", "11"],
			["Blood Issue Entry", "source/BLD_Pending_Blood_Issue.html", "11"],
			["Blood Donation Entry", "source/BLD_blood_donation_entry.html", "11"],
			["Update Blood Donation Entry", "source/BLD_update_blood_donation_entry.html", "11"],
			["Donor Blood Pending For Sample Screering", "source/BLD_Donor_Blood_Pending_For_Sample_Screening.html", "11"],
			["Blood Reaction Form Entry", "source/BLD_Blood_Reaction_Form_Entry.html", "11"],
			["Update Blood Reaction", "source/BLD_Update_Blood_Reaction_Form_Entry.html", "11"],
			["Investigation Pending For Transfusion Reaction", "source/BLD_Investigation_Pending_Transfusion_Reaction.html", "11"],
			["Blood Test Entry", "source/BLD_blood_test_entry.html", "11"],
			["Update Blood Test Entry", "source/BLD_update_blood_test_entry.html", "11"],
			["Blood Component Separation", "source/BLD_Blood_Component_Separation.html", "11"],
			["Pending Blood Discard Entry", "source/BLD_pending_blood_discard_entry.html", "11"],
			["Blood Stock Opening Balance Entry", "source/BLD_Blood_Stock_Opening_Balance_Entry.html", "11"],
			["Pending for Sample Receipt Entry", "source/BLD_Pending_for_Sample_Receipt_Entry.html", "11"],
			["Pending Sample Validation", "source/BLD_pending_sample_validation.html", "11"]
		],
		["Diet", "source/MainDiet.html", "1",
		    ["Patient Diet Change", "source/Diet_patientdietchange.html", "11"],
		    ["Daily Diet & Extra Requisition", "source/Diet_dailydietextrareq.html", "11"],
			["Extra Items Formula", "source/Diet_extraitem.html", "11"],
			["Menu Item Formula", "source/Diet_menuitem.html", "11"],
			["Indent Item Formula", "source/Diet_dietindent.html", "11"],
			["Internal Demand & Issue Voucher", "source/Diet_internaldemand.html", "11"],
			["Breakfast Distribution", "source/Diet_breakfast.html", "11"]
		],
		["MIS", "source/MainMIS.html", "1",
			["ED Returns", "source/mis_edreturn.html", "11"],
			["Fatal Document Tracking", "source/mis_fataldocumenttracking.html", "11"],
			["FRW Requisition", "source/mis_requisitionforissueofrw.html", "11"],
			["Birth Certificate", "source/mis_birthcertificate.html", "11"],
			["Death Certificate", "source/mis_deathcertificate.html", "11"],
			["Update Birth Certificate", "source/mis_updatebirthcertificate.html", "11"],
			["Update Death Certificate", "source/mis_updatedeathcertificate.html", "11"],
			["Annual Medical Examination", "source/mis_annuvalmedicalexamination.html", "11"]
		],
		["Tender Process", "source/MainProcurement.html", "1",
			["Tender Creation", "source/pro_tendercreation.html", "11"],
			["Invitation for Tender", "source/pro_inviationtender.html", "11"],
			["Tender Document", "source/pro_tenderdocument.html", "11"],
			["Export Tender Data", "source/Pro_export.html", "11"],
			["Import Tender Data", "source/Pro_import.html", "11"],
			["Technical Bid", "source/pro_TechnicalBid.html", "11"],
			["Board Recommendations", "source/pro_CommercialBid.html", "11"],
			["Tender PNC", "source/pro_Tender_PNC.html", "11"],
			["Tender LPO Note", "source/pro_Tender_LPONote.html", "11"],
			["Tender Proposal", "source/Pro_tenderproposal.html", "11"],
			["Tender SO FOR L1", "source/pro_Tender_SO_L1.html", "11"],
			["Tender RE SO For Cancelled", "source/pro_Tender_SO_Cancel.html", "11"],
			["Re Tender Proposal", "source/pro_RE_Tender_PRO.html", "11"],
			["Re Tender SO For L1", "source/pro_RE_Tender_SOL1.html", "11"],
			["Re Tender RE SO For Cancelled", "source/pro_RE_Tender_SOCancel.html", "11"],
			["Prevuious Tender Items", "source/pro_Pre_TenderItems.html", "11"]
		],
		["Stores Consumable/Expendable", "source/MainStoresConsumable.html", "1",
			["MMF Projections To DGAFMS", "source/ST_MMFProjectionToDGAFMS.html", "11"],
			["Indent To Depot", "source/ST_indenttodepot.html", "11"],
			["SOC Indent", "source/ST_indentSOC.html", "11"],
			["Store SOC Tracker", "source/ST_indentSOCtracker.html", "11"],
			["Local Supply Order", "source/ST_LocalSupplyOrder.html", "11"],
			["Store CRV", "source/ST_crv.html", "11"],
			["LoanIn", "source/ST_loanin.html", "11"],
			["Issue CIV IAFF(Q) 429 ", "source/ST_IssueCIV.html", "11"],
			["Loan Out", "source/ST_LoanOut.html", "11"],
			["Issue To Other Than Airforce Units", "source/ST_issueotherairforce.html", "11"],
			["Department Return", "source/ST_departmentreturn.html", "11"],
			["Vendor Return", "source/ST_Vender_Return.html", "11"],
			["AT/Supply Order Entry", "source/ST_ATSupplyOrder.html", "11"],
			["Opening Balance Entry", "source/ST_OpeningBalanceEntry.html", "11"],
			["Certificate of Stock Taking", "source/ST_certiofStocktaking.html", "11"],
			["Defective Drugs Entry", "source/ST_DefectiveDurgsEntry.html", "11"],
			["Issues To Other Units", "source/ST_IssueOtherUnitsCIV.html", "11"],
			["ACK", "source/ST_ACKForm.html", "11"],
			["MMF Department Approval", "source/ST_MMFDeptApproval.html", "11"],
			["CRV Ledger Action", "source/ST_CRVListPendingLed.html", "11"],
			["MMF Entry", "source/ST_mmfdeptentry.html", "11"]
		],
		["Non Expendable Stores ", "source/MainStoresAssets.html", "1",
			["Non Expendable - LoanIn", "source/NES_Loan_in.html", "11"],
			["NonExpendable-CRV", "source/NES_CRV.html", "11"],
			["AMC Maintenance", "source/NES_AMC_Maintenance.html", "11"],
			["ME ScaleEquipment", "source/NES_ME_Scale.html", "11"],
			["Indent to DGAFMS (SOC)", "source/NES_Indent_to_DGAFMS(SOC).html", "11"],
			["Work Order", "source/NES_Work_Order.html", "11"],
			["AMC Repair", "source/NES_AMC_repair.html", "11"],
			["SOC Tracker", "source/NES_SOC_Tracker.html", "11"],
			["Issue CIVAFF(Q) 429", "source/NES_Department_Issue.html", "11"],
			["Condemnation Entry", "source/NES_Condemnation_Entry.html", "11"],
			["Board of Survey", "source/NES_board_of_survey.html", "11"]
		],
		["Laundry", "source/MainLaundry.html", "1",
			["Laundry Machine Master", "source/LDR_Machine_master.html", "11"],
			["Linen Weight Master", "source/LDR_linen_weight.html", "11"],
			["Machine Activity Entry", "source/LDR_machine_activity_entry.html", "11"],
			["Drivers Car Diary Entry", "source/LDR_driver_car_dairy_entry.html", "11"],
			["Daily WorkLoad Entry", "source/LDR_daily_workload_entry.html", "11"]
		],
		["CSSD", "source/MainCSSD.html", "1",
			["Instrument Master", "source/CSSD_Instrument_Master.html", "11"],
			["Material Stock Entry", "source/CSSD_Material_Stock_Entry.html", "11"],
			["Autoclave Request", "source/CSSD_Autoclave_Request_Entry.html", "11"],
			["Autoclave Entry", "source/CSSD_Autoclave_Entry.html", "11"],
			["Material Master", "source/CSSD_Material_Master.html", "11"],
			["Autoclave Material Recipt", "source/CSSD_Autoclave_Material_Receipt_Entry.html", "11"],
			["Sterilize Recall", "source/CSSD_Sterilize_Recall_List.html", "11"]
		],
		["Library", "source/MainLibrary.html", "1",
		    ["Library Master", "source/MainSubLIB_LIBMASTER.html", "1",
		        ["Book Master", "source/LIB_Book_Master.html", "11"],
				["Book Category Master", "source/LIB_Book_Category.html", "11"],
				["Book Class Master", "source/LIB_Book_Class.html", "11"],
			    ["Book Sub Class Master", "source/LIB_book_sub_class.html", "11"],
			    ["Vendor Master", "source/LIB_vendor_master.html", "11"],
			    ["Publisher Master", "source/LIB_publisher_master.html", "11"],
		    ],
			["Supply Order Entry", "source/LIB_supply_order_entry.html", "11"],
			["Update Supply Order Entry", "source/LIB_update_supply_order_entry.html", "11"],
			["CRV Entry", "source/LIB_CRV_entry.html", "11"],
			["Update CRV Entry", "source/LIB_Update_CRV_entry.html", "11"],
			["Journal Receipt Register", "source/LIB_Journal_Receipt_Entry.html", "11"],
			["Update Journal Receipt Entry", "source/LIB_Update_Journal_Receipt_Entry.html", "11"],
			["Book/Journal Issue Entry", "source/LIB_Books_Journal_Issue_Entry.html", "11"],
			["Update Book/Journal Issue Entry", "source/LIB_Update_Books_Journal_Issue_Entry.html", "11"],
			["Book/Journal Return Entry", "source/LIB_Books_Journal_Return_Entry.html", "11"],
			["Update Book/Journal Return Entry", "source/LIB_update_Books_Journal_Return_Entry.html", "11"],
			["Book Stock Taking Entry", "source/LIB_Books_stock_Taking_Entry.html", "11"],
			["Update Book Stock Taking Entry", "source/LIB_update_book_stock_taking.html", "11"],
		],
		["HR", "source/MainHR.html", "1",
			["Leave Maintenance", "source/HR_Leave_Maintenance.html", "11"],
			["Night Duty Entry", "source/HR_Night_duty_entry_Medical_Assistant.html", "11"],
			["Guard Duty Entry", "source/HR_Guard_duty_entry.html", "11"],
			["Ward Duty Entry", "source/HR_Ward_duty_entry.html", "11"],
			["Orderly SGT Duty Entry", "source/HR_Orderly_SGT_duty_entry.html", "11"],
			["Range Firing Duty Entry", "source/HR_Range_firing_duty_entry.html", "11"],
			["Duty Display For Service Personnel", "source/HR_Duty_display_service_personnel.html", "11"],
			["Duty Exemption Entry", "source/HR_Duty_exemption_entry.html", "11"],
			["Detailing Of Daily Routine, Scott & Sick Transfer Duty Entry", "source/HR_Detailing_daily_routine_Scottsick_transferduty_entry.html", "11"],
			["Update Arrival Service Personnel Details", "source/HR_Update_arrival_service_personnel_details.html", "11"],
			["Leave Application Pending For Recommenation", "source/HR_Leave_Application_Pending_Recommenation.html", "11"]
		],
		["Masters", "source/MainMasters.html", "1",
			["Laboratory Related", "source/MainSubMST_LABRELATED.html", "1",
				["Sample Container Master", "source/mst_SampleContainerMaster.html", "11"],
				["Investigation UOM", "source/mst_InvestigationUOM.html", "11"],
				["Collection Center", "source/mst_CollectionCenter.html", "11"],
				["Organism Group", "source/mst_OrganismGroup.html", "11"],
				["Organism", "source/mst_Organism.html", "11"],
				["Sensitivity", "source/mst_Sensitivity.html", "11"],
				["Parameter Master", "source/mst_ParameterMaster.html", "11"],
				["Organism Group Detail", "source/mst_OrganismGroupDetails.html", "11"],
				["Organism Detail", "source/mst_OrganismDetails.html", "11"],
				["Biopsy", "source/mst_BiopsyLabMaster.html", "11"],
				["Sample", "source/mst_SampleMaster.html", "11"],
		    ],
			["Blood Bank", "source/MainSubMST_BlOODBANK.html", "1",
				["Blood Bank Status", "source/mst_bloodbankstatus.html", "11"],
				["Blood Donation", "source/mst_blooddonation.html", "11"],
				["Blood Group", "source/mst_bloodgroup.html", "11"]
			],
			["Registration Related", "source/MainSubMST_REGISTRATIONRELATED.html", "1",
				["Document", "source/mst_DocumentMaster.html", "11"],
				["Admission Type", "source/mst_AdmissionTypeMaster.html", "11"],
				["Administrative Sex", "source/mst_AdministrativeSex.html", "11"],
				["Title", "source/mst_TitalMaster.html", "11"],
				["Marital Status", "source/mst_MaritalStatusMaster.html", "11"],
				["Occupation", "source/mst_OccupationMaster.html", "11"],
				["Caste", "source/mst_CasteMaster.html", "11"],
				["Religion", "source/mst_ReligionMaster.html", "11"],
				["Relation", "source/mst_RelationMaster.html", "11"],
				["Reference", "source/mst_ReferenceMaster.html", "11"],
				["Disposal", "source/mst_DisposalMaster.html", "11"]
			],
			["OT Masters", "source/MainSubMST_OTMASTERS.html", "1",
				["OT Entry", "source/mst_OTMaster.html", "11"],
				["OT Distribution", "source/mst_OTDistribution.html", "11"],
				["Anesthesia", "source/mst_Anesthesia.html", "11"]
			],
			["OPD Master", "source/MainSubMST_OPD.html", "1",
				["OPD Holiday", "source/mst_OPDHoliday.html", "11"],
				["OPD Treatment Template", "source/mst_OPDTeratmentTemplate.html", "11"],
				["OPD Instruction Treatment", "source/mst_OPDInstructionTreatment.html", "11"],
				["OPD Template Investigation", "source/mst_OPdTemplateInvestigation.html", "11"],
				["Opd Vaccinating", "source/mst_OPDVaccinating.html", "11"],
				["OPD Equipment", "source/mst_OPDEquipment.html", "11"],
				["OPD Frequency", "source/mst_OPDFrequency.html", "11"],
				["OPD Physiotherapy Treatment", "source/mst_OPDPhysiotherapy.html", "11"]
			],
			["Diet", "source/MainSubMST_CANTEEN.html", "1",
				["Diet", "source/mst_DietMaster.html", "11"],
				["Diet Menu Item", "source/mst_DietMenuItem.html", "11"],
				["Diet Combination", "source/mst_DietCombination.html", "11"],
				["Diet Indent Item", "source/mst_DietIndentItemMaster.html", "11"],
				["Diet Type", "source/mst_DiteType.html", "11"],
				["Diet Items", "source/mst_DietItem.html", "11"]
			],
			["General Master", "source/MainSubMST_GENERAL.html", "1",
				["Country", "source/mst_Country.html", "11"],
				["Currency", "source/mst_Currency.html", "11"],
				["State", "source/mst_state.html", "11"],
				["District", "source/mst_District.html", "11"],
				["Block", "source/mst_Block.html", "11"],
				["Post Code", "source/mst_PostCode.html", "11"],
			],
			["System Related", "source/MainSubMST_SYSTEMRELATEd.html", "1",
				["Department Type", "source/mst_DepartmentType.html", "11"],
				["Transaction Type", "source/mst_TranscctionType.html", "11"],
				["Frequency", "source/mst_frequencyMaster.html", "11"],
				["Department Master", "source/mst_DepartmentMaster.html", "11"],
			],
			["Personnel", "source/MainSubMST_PERSONNEL.html", "1",
				["Rank Category", "source/mst_RankCategoryMaster.html", "11"],
				["Employee Status", "source/mst_EmployeeStatusMaster.html", "11"],
				["Employee Dependent", "source/mst_employeeDependentMaster.html", "11"],
				["Referral Doctor", "source/mst_ReferralDoctorMaster.html", "11"],
				["Employee", "source/mst_employeeMaster.html", "11"],
				["Rank", "source/mst_RankMaster.html", "11"],
				["Formation", "source/mst_FormationMaster.html", "11"],
				["Unit", "source/mst_unitMaster.html", "11"],
				["Trade", "source/mst_TradeMaster.html", "11"],
				["Record Office Address", "source/mst_RecordOfficeAddressMast.html", "11"]
			],
			["HR Related", "source/MainSubMST_HRHRELATED.html", "1",
				["Speciality Master", "source/mst_SpecialityMaster.html", "11"],
				["Medical Course Master", "source/mst_MedicalCourceMaster.html", "11"],
				["Leave Type Master", "source/mst_LeaveTypeMaster.html", "11"],
				["Duty Time Master", "source/mst_DutyTimeMaster.html", "11"],
				["Class Master", "source/mst_classmaster.html", "11"],
				["Duty Master", "source/mst_dutymaster.html", "11"],
				["Establishment Master for Medical Assistant", "source/mst_EstablishmentMasterForM.html", "11"]
			],
			["Hospital Related", "source/MainSubMST_HOSPITALRELATED.html", "1",
				["Nursing Care", "source/mst_NursingCareMaster.html", "11"],
				["Case Type", "source/mst_CaseTypeMaster.html", "11"],
				["Cause Of Death", "source/mst_DeathCauseMaster.html", "11"],
				["Main Type", "source/mst_MainChargeMaster.html", "11"],
				["Sub Type", "source/mst_SubChargeCode.html", "11"],
				["Cost Centre", "source/mst_CostCenterMaster.html", "11"],
				["Complaint Code", "source/mst_ComplaintMaster.html", "11"],
				["Complications", "source/mst_ComplicationMaster.html", "11"],
				["Authorizer", "source/mst_AuthorizerMaster.html", "11"],
				["Bed Master", "source/mst_Bedmaster.html", "11"],
				["Bed Status Master", "source/mst_BedStatusMaster.html", "11"],
				["Test Master", "source/mst_testmaster.html", "11"],
				["Room Master", "source/mst_RoomMaster.html", "11"],
				["ICD Cause Group", "source/mst_ICDCauseGroup.html", "11"],
				["ICD Sub Category", "source/mst_ICDSubCategoryMaster.html", "11"],
				["ICD Main Category", "source/mst_ICDMainCategory.html", "11"],
				["ICD Master", "source/mst_ICDMaster.html", "11"],
				["Service Type", "source/mst_serviceType.html", "11"],
				["Service Status", "source/mst_serviceStatus.html", "11"]
			],
			["In-patient Related", "source/MainSubMST_INPATIENTRELATED.html", "1",
				["Disposed To", "source/mst_DisposedToMaster.html", "11"],
				["Care Type", "source/mst_CareType.html", "11"],
				["Discharge Status", "source/mst_DischargeStatusMaster.html", "11"],
				["Discharge Items", "source/mst_DischargeItems.html", "11"],
				["Injury Nature", "source/mst_InjuryNatureMaster.html", "11"],
				["Bed Status", "source/mst_BedStatusMaster.html", "11"],
				["Baby Status", "source/mst_BabyStatusMaster.html", "11"],
				["Delivery Type", "source/mst_DeliveryMaster.html", "11"]
			],
			["Marriage Accomodation", "source/MainSubMST_MARR_ACC.html", "1",
				["Pool Category Master", "source/mst_PoolCategory.html", "11"],
				["Pool Master", "source/mst_Pool.html", "11"],
				["Location Master", "source/mst_Location.html", "11"],
				["SMQ Master", "source/mst_SMQ.html", "11"],
				["Car Garage Master", "source/mst_cargarage.html", "11"]
			],
			["Stores", "source/MainSubMST_STORES.html", "1",
			    ["PVMS/NIV", "source/mst_PVMSNIVMaster.html", "11"],
				["PVMS/NIV Section", "source/mst_PVMSNIVSectionMaster.html", "11"],
				["PVMS/NIV Sub Section", "source/mst_PVMSNIVSubSection.html", "11"],
				["PVMS/NIV Groups", "source/mst_PVMSNIVGroupMaster.html", "11"],
				["Financial", "source/mst_FinancialMaster.html", "11"],
				["Accounting Unit(A/U) Conversion", "source/mst_AccountingUnitConversion.html", "11"],
				["Item Unit", "source/mst_ItemUnitMaster.html", "11"],
				["Item Type", "source/mst_ItemTypeMaster.html", "11"],
				["Budget Master", "source/mst_BudgetMaster.html", "11"],
				["AirForce Unit Depot", "source/mst_AirforceUnitDepotMaster.html", "11"],
				["ME Scale", "source/mst_MeScaleMaster.html", "11"],
				["Supply Order Delivery/Payment Terms", "source/mst_SupplyOrderDeliveryPayment.html", "11"],
				["Manufacturer", "source/mst_ManufactureMaster.html", "11"],
				["Supplier Type", "source/mst_SupplierTypeMaster.html", "11"],
				["Vendor Master", "source/mst_VenderMaster.html", "11"],
				["Pharma Index", "source/mst_PharmaIndexMaster.html", "11"]
			]
		],
		["Security", "source/MainSecurity.html", "1",
		    ["Module Management ", "source/MainSubSEC_MODULEMANAG.html", "1",
		        ["Hospital Master", "source/sec_hospitalmaster.html", "11"],
				["Application Group", "source/sec_usergroupmaster.html", "11"],
				["Employee Group", "source/sec_employeegroup.html", "11"],
			    ["Add Form/Reports", "source/sec_addformreport.html", "11"],
			    ["Edit Form/Reports", "source/sec_editformreport.html", "11"],
			    ["User Creation", "source/sec_user.html", "11"],
			    ["User Management", "source/sec_usermanagement.html", "11"],
			    ["User Management Details", "source/sec_usermanagementdetails.html", "11"],
			    ["User Group Hospital", "source/sec_usergrouphospital.html", "11"],
			    ["User Hospital Maintenace", "source/sec_userhospitalmaintainenc.html", "11"],
			    ["User Department", "source/sec_department.html", "11"],
			    ["Button Details", "source/sec_buttondetilamaster.html", "11"],
			    ["Remove Button Rights", "source/sec_removebuttonrights.html", "11"],
			    ["View/Remove User Rights", "source/sec_viewremovebuttonrights.html", "11"],
			    ["Change Order", "source/sec_changeorderapplication.html", "11"],
		    ],
			["Change word/Department", "source/sec_changedepartment.html", "11"],
			["Change Pasword", "source/sec_changepassword.html", "11"],
			["Assign Button Rights to Employee Groups", "source/sec_assignbuttonrightsemployeegroup.html", "11"],
			["Assign Application Rights to User", "source/sec_applicationtoemployeegroup.html", "11"],
			["Assign Module Rights to Employee Groups", "source/sec_assignmoduletoemployygroup.html", "11"]
		],
		["Agenda Points", "source/MainAgendaPoints.html", "1",
			["Agenda Points For Work Services", "source/ag_workservices.html", "11"],
			["Agenda Point Search", "source/ag_agendapointsearch.html", "11"],
			["Priority for Agenda Points", "source/ag_priorityforagendapoints.html", "11"],
			["MOM Details Against Agenda", "source/ag_momdetailsagendasearch.html", "11"]
		],
		["HR Orderly Room", "source/MainHROrderlyRoom.html", "1",
		    ["Leave Details", "source/MainSubOHR_LEAVEDETAILS.html", "1",
		        ["Leave Application", "source/OHR_Leave_Application.html", "11"],
				["Leave Application Update", "source/OHR_Update_Leave_Application.html", "11"],
				["Leave Application Pending For Approval", "source/OHR_Pending_leave_application.html", "11"],
			    ["Leave Restriction", "source/OHR_Leave_Restriction_entry.html", "11"],
		    ],
			["Employee Arrival Form", "source/OHR_Employee_Arrival_Form.html", "11"],
			["Employee Update Form", "source/OHR_Update_Employee_Arrival_Form.html", "11"],
			["Clearence From", "source/OHR_clearance_from.html", "11"]
		],
		["Medical Board Proceedings", "source/MainMedicalBoardProceedings.html", "1",
			["Type Of Entry Master", "source/MBP_TypeEntryMaster.html", "11"],
			["Medical Board Proceedings Search", "source/MBP_MMBPSearch.html", "11"],
			["Medical Examination Report On Entry", "source/MBP_MEReport.html", "11"],
			["Candidate Found Unfit By Board", "source/MBP_ICFUSpecial_MB.html", "11"],
			["Certificate By The Candidate", "source/MBP_CByTheCandEntry.html", "11"],
			["Result OF Appeal Medical Board Entry", "source/MBP_RAMedical_BoardEntry.html", "11"]
		],
		["Complaint Monitoring System", "source/MainComplaintMonitoringSystem.html", "1",
			["Complaint Type Master", "source/CMS_complinettypemaster.html", "11"],
			["Complaints Register", "source/CMS_complinetregister.html", "11"],
			["Work Completion Details", "source/CMS_workcompletiondetails.html", "11"],
			["Work Not Completed With In 3 Days", "source/CMS_wornotkcompletion3days.html", "11"]
		],
		["Medical Claim", "source/MainMedicalClaim.html", "1",
			["Sanction Authority Master", "source/MClaim_Sanction_Authority_Master.html", "11"],
			["Request for Special Investigation Entry", "source/MClaim_Request_for_Special_Investigation_Entry.html", "11"],
			["Update Special Investigation Entry", "source/MClaim_Update_Request_for_Special_Investigation_Entry.html", "11"],
			["Contingent Bill For Reimbursement For Medical", "source/MClaim_Contingent_Bill_Reimbursement_Medical_BillEntry.html", "11"],
			["Update Contingent Bill For Reimbursement For Medical", "source/MClaim_update_Contingent_Bill_Reimbursement_Medical_BillEntry.html", "11"],
			["Covering Letters to Unit", "source/MClaim_Covering_Letters_Unit.html", "11"],
			["General Claim Covering letter Amount", "source/MClaim_General_Claim_Covering_letter.html", "11"],
			["General Claim Tracking", "source/MClaim_General_Claim_Tracking.html", "11"],
			["Cardiac Claim for Advance, Undertaking & Willingness", "source/MClaim_Cardiacclaim_Advance_Undertaking_Willingness.html", "11"],
			["Update Cardiac claim for Advance, Undertaking & Willingness", "source/MClaim_update_Cardiacclaim_Advance_Undertaking_Willingness.html", "11"],
			["Cardiac Claim Contingent Bill for Reimbursement", "source/MClaim_Cardiac_claim_Contingent_Bill_Reimbursement.html", "11"],
			["Update Cardiac Claim Contingent Bill for Reimbursement", "source/MClaim_Update_Cardiac_claim_Contingent_Bill_Reimbursement.html", "11"],
			["Contingent Bill Movement Entry", "source/MClaim_Contingent_bill_movement_entry.html", "11"],
			["Cardiac Claim Tracking", "source/MClaim_Cardiac_Claim_Tracking.html", "11"]
		],
		["Pension", "source/MainPension.html", "1",
			["Designation Master", "source/Pension_Designation_Master.html", "11"],
			["Group Master", "source/Pension_Group_Master.html", "11"],
			["Commutation Weightage Master", "source/Pension_Weightage_Master.html", "11"],
			["Personal Entry Details", "source/Pension_Personnel_Entry_Master.html", "11"],
			["Update Personal Entry Details", "source/Pension_update_Personnel_Entry_Master.html", "11"],
			["Calculation Sheet", "source/Pension_Calculation_Sheet.html", "11"],
			["Update Calculation Sheet", "source/Pension_Update_Calculation_Sheet.html", "11"],
			["Data Sheet", "source/Pension_data_Sheet.html", "11"],
			["Update Data Sheet", "source/Pension_Update_data_Sheet.html", "11"],
			["Form 7 Entry", "source/Pension_Form7_Entry.html", "11"],
			["Update Form 7 Entry", "source/Pension_Form7_Entry_update.html", "11"],
			["Form 8 Entry", "source/Pension_Form8_Entry.html", "11"],
			["Update Form 8 Entry", "source/Pension_Form8_Entry_update.html", "11"],
			["Form 356 Retirement Entry", "source/Pension_Form356_Retirement_Entry.html", "11"],
			["Update Form 356 Retirement Entry", "source/Pension_Form356_Retirement_Entry_update.html", "11"]
		],
		["Work Services", "source/MainWorkServices.html", "1",
			["Work Category", "source/ws_workcategory.html", "11"],
			["Work Type", "source/ws_worktype.html", "11"],
			["Minor Work Proposal", "source/ws_minorworkproposal.html", "11"],
		    ["Minor Work Proposal Cancellation ", "source/ws_cancelminorworkapproval.html", "11"],
			["Minor Work Details", "source/MainSubWS_MINORWORKDETAILS.html", "1",
			    ["Minor Work Details Approval", "source/ws_approvalminorworkdetails.html", "11"],
			    ["Minor Work Detail", "source/ws_minorworkdetails.html", "11"],
			    ["Minor Work Detail Search", "source/ws_minorworkdetailsearch.html", "11"],
				["Minor Work Detail Search For Completion Work", "source/ws_minorworkdetailscompleti.html", "11"]
			],
		    ["Minor Work User Comments", "source/ws_usercommentsminorworkdetails.html", "11"],
			["Major Work Details", "source/MainSubWS_MAJORWORKDETAIL.html", "1",
			    ["Major Work Detail", "source/ws_majorworkdetails.html", "11"],
				["Major Work Detail Search/Completion", "source/ws_majorworkdetailsearch.html", "11"]
			]
		],
		["Marriage Accommodation", "source/MainMarriageAccommodation.html", "1",
			["Pool Category", "source/ma_poolcategory.html", "11"],
			["Pool Master", "source/ma_poolmaster.html", "11"],
			["Location Master", "source/ma_locationmaster.html", "11"],
			["SMQ Master", "source/ma_smqmaster.html", "11"],
			["Car Garage Master", "source/ma_cargaragemaster.html", "11"],
			["Accommodation Registration for Airmen", "source/ma_accomodationregister.html", "11"],
			["Allotment of married Accomodation for Airmen", "source/ma_allotmentmarriageaccomod.html", "11"],
			["Cancellation of Allotment Order for Airmen", "source/ma_cancel_all_airmen.html", "11"],
			["SMQ Vacation for Airmen", "source/ma_smqvacationforarmymen.html", "11"],
			["Allotment/Vacation Of SMQ for Airmen", "source/ma_all_vac_SMQ_airman.html", "11"],
			["Occupancy / Vacation Return for Airmen", "source/ma_OccupancyVacationReturnAirmen.html", "11"],
			["Accomodation registration for Officer", "source/ma_accomodationregisterforo.html", "11"],
			["Issue of Willingness Certificate", "source/ma_willingnesscertificateofficers.html", "11"],
			["Allotment Of SMQs/Garages Officers", "source/ma_allotmentofsmqgarriageof.html", "11"],
			["Cancellation of Allotment Order for Officer", "source/ma_cancel_all_Officer.html", "11"],
			["SMQ Vacation for Officer", "source/ma_smqvacationforOfficer.html", "11"],
			["Relegation Process", "source/ma_Regulationprocess.html", "11"],
			["Allotment/Vacation Of SMQ for Officer", "source/ma_all_vac_SMQ_officer.html", "11"],
			["Occupancy / Vacation Return for Officer", "source/ma_OccupancyVacationReturnOfficer.html", "11"],
			["Non Availability Certificate (NAC)", "source/ma_NAC_Officer.html", "11"]
	    ]
		]
];

var gInitURL = "source/MainHMS.html"