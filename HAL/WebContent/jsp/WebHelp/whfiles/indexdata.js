var IndexItems = [
["Home", "source/MainHMS.html"],
[" Enquiry", "source/MainEnquiry.html"],
["  Patient Enquiry", "source/enq_inpatientenquiry.html"],
["  Doctor Enquiry", "source/enq_doctorenquiry.html"],
["  Patient Enquiry Details", "source/enq_patientdetails.html"],
[" Admission Discharge And Transfer", "source/MainADT.html"],
["  Patient Registration", "source/MainSubADT_PATIENTREGISTATION.html"],
["   Update Patient Registration", "source/adt_UpdatePatientRegistrati.html"],
["   Patient Registration", "source/adt_PatientRegistration.html"],
["  Patient Visit", "source/MainSubADT_PATIENTVISIT.html"],
["   Patient Visit Search", "source/adt_PatientVisitSearch.html"],
["   Patient Visit Details", "source/adt_PatientVisitDetails.html"],
["   IP Admission", "source/MainSubADT_IPADDMISSION.html"],
["    IP Admission Search", "source/adt_ipaddmissionsearch.html"],
["   IP Admission Details", "source/adt_ipaddmissiondetails.html"],
["  IP Admission Transfer", "source/MainSubADT_IPADMISSIONTRANSFER.html"],
["   IP Admission Transfer Search", "source/adt_PatientTransferSearch.html"],
["    IP Admission Transfer Details", "source/adt_PatientTransferDetails.html"],
["   IP Admission Discharge", "source/MainSubADT_IpadmissionDischarge.html"],
["   IP Admission Discharge Search", "source/adt_PatientDischargeSearch.html"],
["   IP Admission Discharge Details", "source/adt_PatientDischargeDetails.html"],
["   Final Discharge", "source/adt_finalDischarge.html"],
["  Expiry Details", "source/adt_PatientDischargeExpiry.html"],
["  Daily Bed Status", "source/adt_dailybedstatus.html"],
["  OP MLC Case", "source/adt_OpmlcCase.html"],
[" Appointment", "source/MainAppointment.html"],
["  Appointment Setup", "source/app_appointmentsetup.html"],
["  Patient Appointments", "source/app_opdpatientappointment.html"],
["  Investigation Appointments Setup", "source/app_investigationappointmen.html"],
["  Investigation Appointments", "source/app_opdinvestigationappoint.html"],
["  Cancel Patient Appointments", "source/app_cancellationforpatienta.html"],
["  Cancel Investigation Appointments", "source/app_cancellationforinvestig.html"],
[" Out Patient Department", "source/MainOPD.html"],
["  OPD Waiting List", "source/opd_waitingpatientlist.html"],
["  OPD Cardiology", "source/opd_Cardiology.html"],
["  OPD ENT", "source/opd_ent.html"],
["  OPD Onco Surgery Case Sheet", "source/opd_oncosurgerycasesheet.html"],
["  OPD Ophthalmology", "source/opd_Opthomology.html"],
["  OPD Ophthalmology Follow Up", "source/opd_Opthomology_floowup.html"],
["  OPD Retinal Laser Proforma", "source/opd_Opthomology_retinal.html"],
["  OPD Pediatric Case Sheet", "source/opd_Paediatrics.html"],
["  OPD Urology Case Sheet", "source/opd_urologycasesheet.html"],
["   OPD -Main (AFMSF-7A 2002) View ", "source/opd_patientpreviousvisits.html"],
["  OPD- Main (AFMSF- 7A 2002)", "source/opd_main_afmsf7casesheet.html"],
["  In Patient Surgery Requisition Form", "source/OT_surgeryrequesitions.html"],
["  OPD Patient Info", "source/MainSubOPD_PATIENTINFO.html"],
["   OPD Search Patient Previous Visit", "source/opd_searchpatientpreviousvi.html"],
["   OPD Patient Details Update", "source/opd_patientvisitupdate.html"],
[" Laboratory", "source/MainLaboratory.html"],
["  Diagnostic Master", "source/Lab_Diagnosticmaster.html"],
["  Order Booking", "source/MainSubLAB_ORDERBOOKING.html"],
["   Order Booking", "source/Lab_orderbooking.html"],
["   Order Booking Search", "source/Lab_orderbookingIPDSearch.html"],
["   Cancel Order Booking", "source/Lab_cancelorderbooking.html"],
["   Confidential Order Booking Request", "source/Lab_Confidentialorderreq.html"],
["  Pending For Sample Validation", "source/MainSubLAB_PENDINGFORSAMPLEVALIDATION.html"],
["   Pending For Sample Validation Search", "source/Lab_samplevalidationsearch.html"],
["   Pending For Sample Validation Details", "source/Lab_samplevalidationdetail.html"],
["  Pending For Result Entry", "source/MainSubLAB_PENDINGFORRESULTENTRY.html"],
["   Pending For Result Entry Search", "source/Lab_resultentrysearch.html"],
["   Pending For Result Entry Details", "source/Lab_resultentrydetail.html"],
["  Pending For Result Validation", "source/MainSubLAB_PENDINGFORRESULTVALIDATION.html"],
["   Pending For Result Validation Search", "source/Lab_resultvalidationsearch.html"],
["   Pending For Result Validation Details", "source/Lab_resultvalidationdetail.html"],
["  Result Delivery", "source/MainSubLAB_REPORTDELIVERY.html"],
["   Result Delivery Search", "source/Lab_reportdeliverysearch.html"],
["    Result Delivery Details", "source/Lab_reportdeliverydetail.html"],
["  Result Printing", "source/Lab_resultprinting.html"],
["  Result Modification", "source/MainSubLAB_RESULTMODIFICATION.html"],
["   Result Modification Search", "source/Lab_resultentrymodifysearch.html"],
["   Result Modification Details", "source/Lab_resultentrymodifydetail.html"],
[" Radiology", "source/MainRadiology.html"],
["  Diagnostic Master", "source/Rad_diagnosticmaster.html"],
["  Order Booking", "source/MainSubRAD_ORDERBOOKING.html"],
["   Radiology Order Booking", "source/Rad_orderbooking.html"],
["   Radiology Cancel Order Booking", "source/Rad_cancelOBsearch.html"],
["   Radiology Confidential Order Booking Request", "source/Rad_Confidentialorderreq.html"],
["  Radiology Acceptance For Investigations", "source/MainSubRAD_PENDINGFORSAMPLEVALIDATION.html"],
["   Radiology Acceptance For Investigations Search", "source/Rad_AcceptanceforRadiologicalInvestigationsSearch.html"],
["   Radiology Acceptance For Investigations Details", "source/Rad_AcceptanceforRadiologicalInvestigations.html"],
["  Pending For Report Entry", "source/MainSubRAD_PENDINGFORRESULTENTRY.html"],
["   Radiology Pending For Report Entry Search", "source/Rad_pendingreportentrysearch.html"],
["   Radiology Pending For Report Entry Details", "source/Rad_pendingreportentryDetails.html"],
["  Pending For Report Validation", "source/MainSubRAD_PENDINGFORRESULTVALIDATION.html"],
["   Radiology Pending For Report Validation Search", "source/Rad_resultvalidsearch.html"],
["   Radiology Pending For Report Validation Details", "source/Rad_reportvalidationdetail.html"],
["  Film Entry", "source/Rad_filmentry.html"],
["  Report Delivery", "source/MainSubRAD_REPORTDELIVERY.html"],
["   Radiology Report Delivery Search", "source/Rad_reportdeliverysearch.html"],
["   Radiology Report Delivery Details", "source/Rad_reportdeliverydetail.html"],
["  Result Printing", "source/Rad_reportprinting.html"],
[" Ward Management", "source/MainIPD.html"],
["  Nursing Station", "source/IPD_patientsearch.html"],
["  Clinical Setup", "source/IPD_clinicalsetup.html"],
["  Nursing Entry", "source/IPD_nursingentry.html"],
["  Clinical Chart", "source/IPD_clinicalchart.html"],
["  Intake/Output", "source/IPD_intakeandouttake.html"],
["  Discharge Sum General", "source/IPD_dischargesumgeneral.html"],
["   Discharge Sum O & G", "source/IPD_dischargesumOG.html"],
["  Discharge Sum Paediatrice", "source/IPD_dischargesumPaediatrice.html"],
["  Discharge Sum NABH", "source/IPD_dischargesumNABH.html"],
["  Ward Consumption", "source/IPD_wardconsumption.html"],
["  Food Tasting", "source/IPD_foodtasting.html"],
["  Patient Issue", "source/IPD_patientissue.html"],
["  Department Indent", "source/IPD_departmentindent.html"],
["  Patient Diagnosis", "source/IPD_patientdiagnosis.html"],
["  SILDIL", "source/IPD_sildil.html"],
["  Patient Transfer", "source/IPD_patienttransfer.html"],
["  Patient Discharge", "source/IPD_patientdischarge.html"],
["  Daily Remarks", "source/IPD_dailyremarks.html"],
["  Patient Remarks", "source/IPD_patientremark.html"],
["  Order Booking", "source/IPD_orderbooking.html"],
["  Order Status", "source/IPD_orderstatus.html"],
[" Operation Theatre", "source/MainOT.html"],
["  PAC Clearance List", "source/OT_pacClearanceList.html"],
["  OT Booking List", "source/OT_bookingList.html"],
["  OT List Change", "source/OT_Changelist.html"],
["  Post OP Notes Anaesthesia Search", "source/OT_PostOPNotesAnaesthesiaSearch.html"],
["  Post OP Notes Anaesthesia Details", "source/OT_PostOPNotesAnaesthesia.html"],
["  Post OP Notes Surgery Search", "source/OT_PostOPNotesSurgerySearch.html"],
["  Post OP Notes Surgery Details", "source/OT_PostOPNotesSurgery.html"],
["  Specimen Dispatch Entry Search", "source/OT_SpecimenDispatchEntrySearch.html"],
["  Specimen Dispatch Entry Details", "source/OT_SpecimenDispatchEntry.html"],
["  Human Body Parts Disposal Search", "source/OT_HumanBodyPartsDisposalSearch.html"],
["  Human Body Parts Disposal Details", "source/OT_HumanBodyDisposalEntry.html"],
["  Surgery Enquiry", "source/OT_SurgeryEnquiry.html"],
["  Actual Surgery Perform", "source/OT_Actualsurgeryperform.html"],
["  Surgery Requesitions", "source/OT_surgeryrequesitions.html"],
[" Blood Bank", ""],
["  Blood Component Master", "source/BLD_component_Master.html"],
["  Consent for Blood Transfusion Entry", "source/BLD_Consent_Blood_Transfusion.html"],
["  Blood Request Entry", "source/BLD_Blood_Request_Entry.html"],
["  Pending For Blood Grouping & Cross Matching", "source/BLD_Pending_For_Blood_Grouping_Cross_Matching.html"],
["  Blood Issue Entry", "source/BLD_Pending_Blood_Issue.html"],
["  Blood Donation Entry", "source/BLD_blood_donation_entry.html"],
["  Update Blood Donation Entry", "source/BLD_update_blood_donation_entry.html"],
["  Donor Blood Pending For Sample Screering", "source/BLD_Donor_Blood_Pending_For_Sample_Screening.html"],
["  Blood Reaction Form Entry", "source/BLD_Blood_Reaction_Form_Entry.html"],
["  Update Blood Reaction", "source/BLD_Update_Blood_Reaction_Form_Entry.html"],
["  Investigation Pending For Transfusion Reaction", "source/BLD_Investigation_Pending_Transfusion_Reaction.html"],
["  Blood Test Entry", "source/BLD_blood_test_entry.html"],
["  Update Blood Test Entry", "source/BLD_update_blood_test_entry.html"],
["  Blood Component Separation", "source/BLD_Blood_Component_Separation.html"],
["  Pending Blood Discard Entry", "source/BLD_pending_blood_discard_entry.html"],
["  Blood Stock Opening Balance Entry", "source/BLD_Blood_Stock_Opening_Balance_Entry.html"],
["  Pending for Sample Receipt Entry", "source/BLD_Pending_for_Sample_Receipt_Entry.html"],
["  Pending Sample Validation", "source/BLD_pending_sample_validation.html"],
[" Diet", "source/MainDiet.html"],
["  Patient Diet Change", "source/Diet_patientdietchange.html"],
["  Daily Diet & Extra Requisition", "source/Diet_dailydietextrareq.html"],
["  Extra Items Formula", "source/Diet_extraitem.html"],
["  Menu Item Formula", "source/Diet_menuitem.html"],
["  Indent Item Formula", "source/Diet_dietindent.html"],
["  Internal Demand & Issue Voucher", "source/Diet_internaldemand.html"],
["  Breakfast Distribution", "source/Diet_breakfast.html"],
[" MIS", "source/MainMIS.html"],
["   ED Returns", "source/mis_edreturn.html"],
["  Fatal Document Tracking", "source/mis_fataldocumenttracking.html"],
["  FRW Requisition", "source/mis_requisitionforissueofrw.html"],
["  Birth Certificate", "source/mis_birthcertificate.html"],
["  Death Certificate", "source/mis_deathcertificate.html"],
["  Update Birth Certificate", "source/mis_updatebirthcertificate.html"],
["  Update Death Certificate", "source/mis_updatedeathcertificate.html"],
["  Annual Medical Examination", "source/mis_annuvalmedicalexamination.html"],
[" Tender Process", "source/MainProcurement.html"],
["  Tender Creation", "source/pro_tendercreation.html"],
["  Invitation for Tender", "source/pro_inviationtender.html"],
["  Tender Document", "source/pro_tenderdocument.html"],
["  Export Tender Data", "source/Pro_export.html"],
["  Import Tender Data", "source/Pro_import.html"],
["  Technical Bid", "source/pro_TechnicalBid.html"],
["  Board Recommendations", "source/pro_CommercialBid.html"],
["  Tender PNC", "source/pro_Tender_PNC.html"],
["  Tender LPO Note", "source/pro_Tender_LPONote.html"],
["  Tender Proposal", "source/Pro_tenderproposal.html"],
["  Tender SO FOR L1", "source/pro_Tender_SO_L1.html"],
["  Tender RE SO For Cancelled", "source/pro_Tender_SO_Cancel.html"],
["  Re Tender Proposal", "source/pro_RE_Tender_PRO.html"],
["  Re Tender SO For L1", "source/pro_RE_Tender_SOL1.html"],
["  Re Tender RE SO For Cancelled", "source/pro_RE_Tender_SOCancel.html"],
["  Prevuious Tender Items", "source/pro_Pre_TenderItems.html"],
[" Expendable Items & Dispensary Store ", "source/MainStoresConsumable.html"],
["  MMF Projections To DGAFMS", "source/ST_MMFProjectionToDGAFMS.html"],
["   Indent To Depot", "source/ST_indenttodepot.html"],
["  SOC Indent", "source/ST_indentSOC.html"],
["  SOC Tracker", "source/ST_indentSOCtracker.html"],
["  Local Supply Order", "source/ST_LocalSupplyOrder.html"],
["  Store CRV", "source/ST_crv.html"],
["  LoanIn", "source/ST_loanin.html"],
["  Issue CIV IAFF(Q) 429 ", "source/ST_IssueCIV.html"],
["  Loan Out", "source/ST_LoanOut.html"],
["  Issue To Other Than Airforce Units", "source/ST_issueotherairforce.html"],
["  Department Return", "source/ST_departmentreturn.html"],
["  Vendor Return", "source/ST_Vender_Return.html"],
["  AT/Supply Order Entry", "source/ST_ATSupplyOrder.html"],
["  Opening Balance Entry", "source/ST_OpeningBalanceEntry.html"],
["  Certificate of Stock Taking", "source/ST_certiofStocktaking.html"],
["  Defective Drugs Entry", "source/ST_DefectiveDurgsEntry.html"],
["  Issues To Other Units", "source/ST_IssueOtherUnitsCIV.html"],
["  ACK", "source/ST_ACKForm.html"],
["  MMF Department Approval", "source/ST_MMFDeptApproval.html"],
["  CRV Ledger Action", "source/ST_CRVListPendingLed.html"],
["  MMF Entry", "source/ST_mmfdeptentry.html"],
[" Non Expendable Stores ", "source/MainStoresAssets.html"],
["  Non Expendable - LoanIn", "source/NES_Loan_in.html"],
["  NonExpendable-CRV", "source/NES_CRV.html"],
["  AMC Maintenance", "source/NES_AMC_Maintenance.html"],
["  ME ScaleEquipment", "source/NES_ME_Scale.html"],
["  Indent to DGAFMS (SOC)", "source/NES_Indent_to_DGAFMS(SOC).html"],
["  Work Order", "source/NES_Work_Order.html"],
["  AMC Repair", "source/NES_AMC_repair.html"],
["  SOC Tracker", "source/NES_SOC_Tracker.html"],
["  Issue CIVAFF(Q) 429", "source/NES_Department_Issue.html"],
["  Condemnation Entry", "source/NES_Condemnation_Entry.html"],
["  Board of Survey", "source/NES_board_of_survey.html"],
[" Laundry", "source/MainLaundry.html"],
["  Laundry Machine Master", "source/LDR_Machine_master.html"],
["  Linen Weight Master", "source/LDR_linen_weight.html"],
["  Machine Activity Entry", "source/LDR_machine_activity_entry.html"],
["  Drivers Car Diary Entry", "source/LDR_driver_car_dairy_entry.html"],
["  Daily WorkLoad Entry", "source/LDR_daily_workload_entry.html"],
[" CSSD", "source/MainCSSD.html"],
["  Instrument Master", "source/CSSD_Instrument_Master.html"],
["  Material Stock Entry", "source/CSSD_Material_Stock_Entry.html"],
["  Autoclave Request", "source/CSSD_Autoclave_Request_Entry.html"],
["  Autoclave Entry", "source/CSSD_Autoclave_Entry.html"],
["  Material Master", "source/CSSD_Material_Master.html"],
["  Autoclave Material Recipt", "source/CSSD_Autoclave_Material_Receipt_Entry.html"],
["  Sterilize Recall", "source/CSSD_Sterilize_Recall_List.html"],
[" Library", "source/MainLibrary.html"],
["  Library Master", "source/MainSubLIB_LIBMASTER.html"],
["   Book Master", "source/LIB_Book_Master.html"],
["   Book Category Master", "source/LIB_Book_Category.html"],
["   Book Class Master", "source/LIB_Book_Class.html"],
["   Book Sub Class Master", "source/LIB_book_sub_class.html"],
["   Vendor Master", "source/LIB_vendor_master.html"],
["   Publisher Master", "source/LIB_publisher_master.html"],
["  Supply Order Entry", "source/LIB_supply_order_entry.html"],
["  Update Supply Order Entry", "source/LIB_update_supply_order_entry.html"],
["  CRV Entry", "source/LIB_CRV_entry.html"],
["  Update CRV Entry", "source/LIB_Update_CRV_entry.html"],
["  Journal Receipt Register", "source/LIB_Journal_Receipt_Entry.html"],
["  Update Journal Receipt Entry", "source/LIB_Update_Journal_Receipt_Entry.html"],
["  Book/Journal Issue Entry", "source/LIB_Books_Journal_Issue_Entry.html"],
["  Update Book/Journal Issue Entry", "source/LIB_Update_Books_Journal_Issue_Entry.html"],
["  Book/Journal Return Entry", "source/LIB_Books_Journal_Return_Entry.html"],
["  Update Book/Journal Return Entry", "source/LIB_update_Books_Journal_Return_Entry.html"],
["  Book Stock Taking Entry", "source/LIB_Books_stock_Taking_Entry.html"],
["  Update Book Stock Taking Entry", "source/LIB_update_book_stock_taking.html"],
[" HR", "source/MainHR.html"],
["  Leave Maintenance", "source/HR_Leave_Maintenance.html"],
["  Night Duty Entry", "source/HR_Night_duty_entry_Medical_Assistant.html"],
["  Guard Duty Entry", "source/HR_Guard_duty_entry.html"],
["  Ward Duty Entry", "source/HR_Ward_duty_entry.html"],
["  Orderly SGT Duty Entry", "source/HR_Orderly_SGT_duty_entry.html"],
["  Range Firing Duty Entry", "source/HR_Range_firing_duty_entry.html"],
["   Duty Display For Service Personnel", "source/HR_Duty_display_service_personnel.html"],
["  Duty Exemption Entry", "source/HR_Duty_exemption_entry.html"],
["  Detailing Of Daily Routine, Scott & Sick Transfer Duty Entry", "source/HR_Detailing_daily_routine_Scottsick_transferduty_entry.html"],
["  Update Arrival Service Personnel Details", "source/HR_Update_arrival_service_personnel_details.html"],
[" Masters", "source/MainMasters.html"],
["  Laboratory Related", "source/MainSubMST_LABRELATED.html"],
["   Sample Container Master", "source/mst_SampleContainerMaster.html"],
["   Investigation UOM", "source/mst_InvestigationUOM.html"],
["   Collection Center", "source/mst_CollectionCenter.html"],
["   Organism Group", "source/mst_OrganismGroup.html"],
["   Organism", "source/mst_Organism.html"],
["   Sensitivity", "source/mst_Sensitivity.html"],
["   Parameter Master", "source/mst_ParameterMaster.html"],
["   Organism Group Detail", "source/mst_OrganismGroupDetails.html"],
["   Organism Detail", "source/mst_OrganismDetails.html"],
["   Biopsy", "source/mst_BiopsyLabMaster.html"],
["   Sample", "source/mst_SampleMaster.html"],
["  Blood Bank", "source/MainSubMST_BlOODBANK.html"],
["   Blood Bank Status", "source/mst_bloodbankstatus.html"],
["   Blood Donation", "source/mst_blooddonation.html"],
["   Blood Group", "source/mst_bloodgroup.html"],
["  Registration Related", "source/MainSubMST_REGISTRATIONRELATED.html"],
["   Document", "source/mst_DocumentMaster.html"],
["   Admission Type", "source/mst_AdmissionTypeMaster.html"],
["   Administrative Sex", "source/mst_AdministrativeSex.html"],
["   Title", "source/mst_TitalMaster.html"],
["   Marital Status", "source/mst_MaritalStatusMaster.html"],
["   Occupation", "source/mst_OccupationMaster.html"],
["   Caste", "source/mst_CasteMaster.html"],
["   Religion", "source/mst_ReligionMaster.html"],
["   Relation", "source/mst_RelationMaster.html"],
["   Reference", "source/mst_ReferenceMaster.html"],
["   Disposal", "source/mst_DisposalMaster.html"],
["  OT Masters", "source/MainSubMST_OTMASTERS.html"],
["   OT Entry", "source/mst_OTMaster.html"],
["   OT Distribution", "source/mst_OTDistribution.html"],
["   Anesthesia", "source/mst_Anesthesia.html"],
["  OPD Master", "source/MainSubMST_OPD.html"],
["   OPD Holiday", "source/mst_OPDHoliday.html"],
["   OPD Treatment Template", "source/mst_OPDTeratmentTemplate.html"],
["   OPD Instruction Treatment", "source/mst_OPDInstructionTreatment.html"],
["   OPD Template Investigation", "source/mst_OPdTemplateInvestigation.html"],
["   Opd Vaccinating", "source/mst_OPDVaccinating.html"],
["   OPD Equipment", "source/mst_OPDEquipment.html"],
["   OPD Frequency", "source/mst_OPDFrequency.html"],
["   OPD Physiotherapy Treatment", "source/mst_OPDPhysiotherapy.html"],
["  Diet", "source/MainSubMST_CANTEEN.html"],
["   Diet", "source/mst_DietMaster.html"],
["   Diet Menu Item", "source/mst_DietMenuItem.html"],
["   Diet Combination", "source/mst_DietCombination.html"],
["   Diet Indent Item", "source/mst_DietIndentItemMaster.html"],
["   Diet Type", "source/mst_DiteType.html"],
["   Diet Items", "source/mst_DietItem.html"],
["  General Master", "source/MainSubMST_GENERAL.html"],
["   Country", "source/mst_Country.html"],
["   Currency", "source/mst_Currency.html"],
["   State", "source/mst_state.html"],
["   District", "source/mst_District.html"],
["   Block", "source/mst_Block.html"],
["   Post Code", "source/mst_PostCode.html"],
["  System Related", "source/MainSubMST_SYSTEMRELATEd.html"],
["   Department Type", "source/mst_DepartmentType.html"],
["   Transaction Type", "source/mst_TranscctionType.html"],
["   Frequency", "source/mst_frequencyMaster.html"],
["   Department Master", "source/mst_DepartmentMaster.html"],
["  Personnel", "source/MainSubMST_PERSONNEL.html"],
["   Rank Category", "source/mst_RankCategoryMaster.html"],
["   Employee Status", "source/mst_EmployeeStatusMaster.html"],
["   Employee Dependent", "source/mst_employeeDependentMaster.html"],
["   Referral Doctor", "source/mst_ReferralDoctorMaster.html"],
["   Employee", "source/mst_employeeMaster.html"],
["   Rank", "source/mst_RankMaster.html"],
["   Formation", "source/mst_FormationMaster.html"],
["   Unit", "source/mst_unitMaster.html"],
["   Trade", "source/mst_TradeMaster.html"],
["   Record Office Address", "source/mst_RecordOfficeAddressMast.html"],
["  HR Related", "source/MainSubMST_HRHRELATED.html"],
["   Speciality Master", "source/mst_SpecialityMaster.html"],
["   Medical Course Master", "source/mst_MedicalCourceMaster.html"],
["   Leave Type Master", "source/mst_LeaveTypeMaster.html"],
["   Duty Time Master", "source/mst_DutyTimeMaster.html"],
["   Class Master", "source/mst_classmaster.html"],
["   Duty Master", "source/mst_dutymaster.html"],
["   Establishment Master for Medical Assistant", "source/mst_EstablishmentMasterForM.html"],
["  Hospital Related", "source/MainSubMST_HOSPITALRELATED.html"],
["   Nursing Care", "source/mst_NursingCareMaster.html"],
["   Case Type", "source/mst_CaseTypeMaster.html"],
["   Cause Of Death", "source/mst_DeathCauseMaster.html"],
["   Main Type", "source/mst_MainChargeMaster.html"],
["   Sub Type", "source/mst_SubChargeCode.html"],
["   Cost Centre", "source/mst_CostCenterMaster.html"],
["   Complaint Code", "source/mst_ComplaintMaster.html"],
["   Complications", "source/mst_ComplicationMaster.html"],
["   Authorizer", "source/mst_AuthorizerMaster.html"],
["   Bed Master", "source/mst_Bedmaster.html"],
["   Bed Status Master", "source/mst_BedStatusMaster.html"],
["   Test Master", "source/mst_testmaster.html"],
["   Room Master", "source/mst_RoomMaster.html"],
["   ICD Cause Group", "source/mst_ICDCauseGroup.html"],
["   ICD Sub Category", "source/mst_ICDSubCategoryMaster.html"],
["   ICD Main Category", "source/mst_ICDMainCategory.html"],
["   ICD Master", "source/mst_ICDMaster.html"],
["   Service Type", "source/mst_serviceType.html"],
["   Service Status", "source/mst_serviceType.html"],
["  IN-Patient Related", "source/MainSubMST_INPATIENTRELATED.html"],
["   Disposed To", "source/mst_DisposedToMaster.html"],
["   Care Type", "source/mst_CareType.html"],
["   Discharge Status", "source/mst_DischargeStatusMaster.html"],
["   Discharge Items", "source/mst_DischargeItems.html"],
["   Injury Nature", "source/mst_InjuryNatureMaster.html"],
["   Bed Status", "source/mst_BedStatusMaster.html"],
["   Baby Status", "source/mst_BabyStatusMaster.html"],
["   Delivery Type", "source/mst_DeliveryMaster.html"],
["  Marriage Accomodation", "source/MainSubMST_MARR_ACC.html"],
["   Pool Category Master", "source/mst_PoolCategory.html"],
["   Pool Master", "source/mst_Pool.html"],
["   Location Master", "source/mst_Location.html"],
["   SMQ Master", "source/mst_SMQ.html"],
["   Car Garage Master", "source/mst_cargarage.html"],
["  Stores", "source/MainSubMST_STORES.html"],
["   PVMS/NIV", "source/mst_PVMSNIVMaster.html"],
["   PVMS/NIV Section", "source/mst_PVMSNIVSectionMaster.html"],
["   PVMS/NIV Sub Section", "source/mst_PVMSNIVSubSection.html"],
["   PVMS/NIV Groups", "source/mst_PVMSNIVGroupMaster.html"],
["   Financial", "source/mst_FinancialMaster.html"],
["   Accounting Unit(A/U) Conversion", "source/mst_AccountingUnitConversion.html"],
["   Item Unit", "source/mst_ItemUnitMaster.html"],
["   Item Type", "source/mst_ItemTypeMaster.html"],
["   Budget Master", "source/mst_BudgetMaster.html"],
["   AirForce Unit Depot", "source/mst_AirforceUnitDepotMaster.html"],
["   ME Scale", "source/mst_MeScaleMaster.html"],
["   Supply Order Delivery/Payment Terms", "source/mst_SupplyOrderDeliveryPayment.html"],
["   Manufacturer", "source/mst_ManufactureMaster.html"],
["   Supplier Type", "source/mst_SupplierTypeMaster.html"],
["   Vendor Master", "source/mst_VenderMaster.html"],
["   Pharma Index", "source/mst_PharmaIndexMaster.html"],
[" Security", "source/MainSecurity.html"],
["  Module Management ", "source/MainSubSEC_MODULEMANAG.html"],
["   Hospital Master", "source/sec_hospitalmaster.html"],
["   Application Group", "source/sec_usergroupmaster.html"],
["   Employee Group", "source/sec_employeegroup.html"],
["   Add Form/Reports", "source/sec_addformreport.html"],
["   Edit Form/Reports", "source/sec_editformreport.html"],
["   User Creation", "source/sec_user.html"],
["   User Management", "source/sec_usermanagement.html"],
["   User Management Details", "source/sec_usermanagementdetails.html"],
["   User Group Hospital", "source/sec_usergrouphospital.html"],
["   User Hospital Maintenace", "source/sec_userhospitalmaintainenc.html"],
["   User Department", "source/sec_department.html"],
["   Button Details", "source/sec_buttondetilamaster.html"],
["   Remove Button Rights", "source/sec_removebuttonrights.html"],
["   View/Remove User Rights", "source/sec_viewremovebuttonrights.html"],
["   Change Order", "source/sec_changeorderapplication.html"],
["  Change word/Department", "source/sec_changedepartment.html"],
["  Change Pasword", "source/sec_changepassword.html"],
["  Assign Button Rights to Employee Groups", "source/sec_assignbuttonrightsemployeegroup.html"],
["  Assign Application Rights to User", "source/sec_applicationtoemployeegroup.html"],
["  Assign Module Rights to Employee Groups", "source/sec_assignmoduletoemployygroup.html"],
[" Agenda Points", "source/MainAgendaPoints.html"],
["   Agenda Points For Work Services", "source/ag_workservices.html"],
["  Agenda Point Search", "source/ag_agendapointsearch.html"],
["  Priority for Agenda Points", "source/ag_priorityforagendapoints.html"],
["  MOM Details Against Agenda", "source/ag_momdetailsagendasearch.html"],
[" HR Orderly Room", "source/MainHROrderlyRoom.html"],
["  Leave Details", "source/MainSubOHR_LEAVEDETAILS.html"],
["   Leave Application", "source/OHR_Leave_Application.html"],
["   Leave Application Update", "source/OHR_Update_Leave_Application.html"],
["   Leave Application Pending For Approval", "source/OHR_Pending_leave_application.html"],
["   Leave Restriction", "source/OHR_Leave_Restriction_entry.html"],
["  Employee Arrival Form", "source/OHR_Employee_Arrival_Form.html"],
["  Employee Update Form", "source/OHR_Update_Employee_Arrival_Form.html"],
["  Clearence From", "source/OHR_clearance_from.html"],
[" Medical Board Proceedings", "source/MainMedicalBoardProceedings.html"],
["  Type Of Entry Master", "source/MBP_TypeEntryMaster.html"],
["  Medical Board Proceedings Search", "source/MBP_MMBPSearch.html"],
["  Medical Examination Report On Entry", "source/MBP_MEReport.html"],
["  Candidate Found Unfit By Board", "source/MBP_ICFUSpecial_MB.html"],
["  Certificate By The Candidate", "source/MBP_CByTheCandEntry.html"],
["  Result OF Appeal Medical Board Entry", "source/MBP_RAMedical_BoardEntry.html"],
[" Complaint Monitoring System", "source/MainComplaintMonitoringSystem.html"],
["  Complaint Type Master", "source/CMS_complinettypemaster.html"],
["  Complaints Register", "source/CMS_complinetregister.html"],
["  Work Completion Details", "source/CMS_workcompletiondetails.html"],
["  Work Not Completed With In 3 Days", "source/CMS_wornotkcompletion3days.html"],
[" Medical Claim", "source/MainMedicalClaim.html"],
["  Sanction Authority Master", "source/MClaim_Sanction_Authority_Master.html"],
["  Request for Special Investigation Entry", "source/MClaim_Request_for_Special_Investigation_Entry.html"],
["  Update Special Investigation Entry", "source/MClaim_Update_Request_for_Special_Investigation_Entry.html"],
["  Contingent Bill For Reimbursement For Medical", "source/MClaim_Contingent_Bill_Reimbursement_Medical_BillEntry.html"],
["  Update Contingent Bill For Reimbursement For Medical", "source/MClaim_update_Contingent_Bill_Reimbursement_Medical_BillEntry.html"],
["  Covering Letters to Unit", "source/MClaim_Covering_Letters_Unit.html"],
["  General Claim Covering letter Amount", "source/MClaim_General_Claim_Covering_letter.html"],
["  General Claim Tracking", "source/MClaim_General_Claim_Tracking.html"],
["  Cardiac Claim for Advance, Undertaking & Willingness", "source/MClaim_Cardiacclaim_Advance_Undertaking_Willingness.html"],
["  Update Cardiac claim for Advance, Undertaking & Willingness", "source/MClaim_update_Cardiacclaim_Advance_Undertaking_Willingness.html"],
["  Cardiac Claim Contingent Bill for Reimbursement", "source/MClaim_Cardiac_claim_Contingent_Bill_Reimbursement.html"],
["  Update Cardiac Claim Contingent Bill for Reimbursement", "source/MClaim_Update_Cardiac_claim_Contingent_Bill_Reimbursement.html"],
["  Contingent Bill Movement Entry", "source/MClaim_Contingent_bill_movement_entry.html"],
["  Cardiac Claim Tracking", "source/MClaim_Cardiac_Claim_Tracking.html"],
[" Pension", "source/MainPension.html"],
["  Designation Master", "source/Pension_Designation_Master.html"],
["  Group Master", "source/Pension_Group_Master.html"],
["  Commutation Weightage Master", "source/Pension_Weightage_Master.html"],
["  Personal Entry Details", "source/Pension_Personnel_Entry_Master.html"],
["  Update Personal Entry Details", "source/Pension_update_Personnel_Entry_Master.html"],
["  Calculation Sheet", "source/Pension_Calculation_Sheet.html"],
["  Update Calculation Sheet", "source/Pension_Update_Calculation_Sheet.html"],
["  Data Sheet", "source/Pension_data_Sheet.html"],
["  Update Data Sheet", "source/Pension_Update_data_Sheet.html"],
["  Form 7 Entry", "source/Pension_Form7_Entry.html"],
["  Update Form 7 Entry", "source/Pension_Form7_Entry_update.html"],
["  Form 8 Entry", "source/Pension_Form8_Entry.html"],
["  Update Form 8 Entry", "source/Pension_Form8_Entry_update.html"],
["  Form 356 Retirement Entry", "source/Pension_Form356_Retirement_Entry.html"],
["  Update Form 356 Retirement Entry", "source/Pension_Form356_Retirement_Entry_update.html"],
[" Work Services", "source/MainWorkServices.html"],
["  Work Category", "source/ws_workcategory.html"],
["  Work Type", "source/ws_worktype.html"],
["  Minor Work Proposal", "source/ws_minorworkproposal.html"],
["  Minor Work Proposal Cancellation ", "source/ws_cancelminorworkapproval.html"],
["  Minor Work Details", "source/MainSubWS_MINORWORKDETAILS.html"],
["   Minor Work Details Approval", "source/ws_approvalminorworkdetails.html"],
["   Minor Work Detail", "source/ws_minorworkdetails.html"],
["   Minor Work Detail Search", "source/ws_minorworkdetailsearch.html"],
["   Minor Work Detail Search For Completion Work", "source/ws_minorworkdetailscompleti.html"],
["  Minor Work User Comments", "source/ws_usercommentsminorworkdetails.html"],
["  Major Work Details", "source/MainSubWS_MAJORWORKDETAIL.html"],
["   Major Work Detail", "source/ws_majorworkdetails.html"],
["   Major Work Detail Search/Completion", "source/ws_majorworkdetailsearch.html"],
[" Marriage Accommodation", "source/MainMarriageAccommodation.html"],
["  Pool Category", "source/ma_poolcategory.html"],
["  Pool Master", "source/ma_poolmaster.html"],
["  Location Master", "source/ma_locationmaster.html"],
["  SMQ Master", "source/ma_locationmaster.html"],
["  Car Garage Master", "source/ma_cargaragemaster.html"],
["  Accommodation Registration for Airmen", "source/ma_accomodationregister.html"],
["  Allotment of married Accomodation for Airmen", "source/ma_allotmentmarriageaccomod.html"],
["  Cancellation of Allotment Order for Airmen", "source/ma_cancel_all_airmen.html"],
["  SMQ Vacation for Airmen", "source/ma_smqvacationforarmymen.html"],
["  Allotment/Vacation Of SMQ for Airmen", "source/ma_all_vac_SMQ_airman.html"],
["  Occupancy / Vacation Return for Airmen", "source/ma_OccupancyVacationReturnAirmen.html"],
["  Accomodation registration for Officer", "source/ma_accomodationregisterforo.html"],
["  Issue of Willingness Certificate", "source/ma_willingnesscertificateofficers.html"],
["  Allotment Of SMQs/Garages Officers", "source/ma_allotmentofsmqgarriageof.html"],
["  Cancellation of Allotment Order for Officer", "source/ma_cancel_all_Officer.html"],
["  SMQ Vacation for Officer", "source/ma_smqvacationforOfficer.html"],
["  Relegation Process", "source/ma_Regulationprocess.html"],
["  Allotment/Vacation Of SMQ for Officer", "source/ma_all_vac_SMQ_officer.html"],
["  Occupancy / Vacation Return for Officer", "source/ma_OccupancyVacationReturnOfficer.html"],
["  Non Availability Certificate (NAC)", "source/ma_NAC_Officer.html"]];

