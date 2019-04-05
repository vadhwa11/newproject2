var pageid=""; 
var searchquery=""; 
var indexquery=""; 
var pagenum=0;
var qs = location.search.substr(1); 
var A  = qs.split("&");
var B  = null; 
var F  = gInitURL;
for(var i=0;i<A.length;i++)
{ 
B=A[i].split("="); 
A[i]=[B[0],B[1]]; 
}
for(var j=0;j<A.length;j++)
{ 
if(A[j][0]=="page")
{ 
	F=A[j][1]; 
	break; 
}
}

try {
    var Str = window.location.href;
    var t = Str.substring(Str.indexOf('=') + 1);
    if (t == 'adt_ipaddmissiondetails.html') {
        F = 'source/adt_ipaddmissiondetails.html';
    }
    else if (t == 'adt_ipaddmissionsearch.html') {
    F = 'source/adt_ipaddmissionsearch.html';
    }
    else if (t == 'adt_dailybedstatus.html') {
    F = 'source/adt_dailybedstatus.html';
    }
    else if (t == 'adt_finalDischarge.html') {
    F = 'source/adt_finalDischarge.html';
    }
    else if (t == 'adt_OpmlcCase.html') {
    F = 'source/adt_OpmlcCase.html';
    }
    else if (t == 'adt_PatientDischargeDetails.html') {
    F = 'source/adt_PatientDischargeDetails.html';
    }
    else if (t == 'adt_PatientDischargeSearch.html') {
    F = 'source/adt_PatientDischargeSearch.html';
    }
    else if (t == 'adt_PatientRegistration.html') {
        F = 'source/adt_PatientRegistration.html';
    }
    else if (t == 'adt_PatientTransferDetails.html') {
        F = 'source/adt_PatientTransferDetails.html';
    }
    else if (t == 'adt_PatientTransferSearch.html') {
        F = 'source/adt_PatientTransferSearch.html';
    }
    else if (t == 'adt_PatientVisitDetails.html') {
        F = 'source/adt_PatientVisitDetails.html';
    }
    else if (t == 'adt_PatientDischargeExpiry.html') {
        F = 'source/adt_PatientDischargeExpiry.html';
    }
    else if (t == 'adt_PatientVisitSearch.html') {
        F = 'source/adt_PatientVisitSearch.html';
    }
    else if (t == 'adt_UpdatePatientRegistrati.html') {
        F = 'source/adt_UpdatePatientRegistrati.html';
    }
    else if (t == 'ag_agendapointsearch.html') {
    F = 'source/ag_agendapointsearch.html';
    }
    else if (t == 'ag_momdetailsagendasearch.html') {
    F = 'source/ag_momdetailsagendasearch.html';
    }
    else if (t == 'ag_workservices.html') {
    F = 'source/ag_workservices.html';
    }
    else if (t == 'ag_priorityforagendapoints.html') {
    F = 'source/ag_priorityforagendapoints.html';
    }          
    else if (t == 'app_appointmentsetup.html') {
    F = 'source/app_appointmentsetup.html';
    }
    else if (t == 'app_cancellationforinvestig.html') {
    F = 'source/app_cancellationforinvestig.html';
    }
    else if (t == 'app_cancellationforpatienta.html') {
    F = 'source/app_cancellationforpatienta.html';
    }
    else if (t == 'app_investigationappointmen.html') {
    F = 'source/app_investigationappointmen.html';
    }
    else if (t == 'app_opdinvestigationappoint.html') {
    F = 'source/app_opdinvestigationappoint.html';
    }
    else if (t == 'app_opdpatientappointment.html') {
    F = 'source/app_opdpatientappointment.html';
    }
    else if (t == 'BLD_Blood_Component_Separation.html') {
    F = 'source/BLD_Blood_Component_Separation.html';
    }
        else if (t == 'BLD_pending_blood_discard_entry.html') {
    F = 'source/BLD_pending_blood_discard_entry.html';
    }
        else if (t == 'BLD_pending_sample_validation.html') {
    F = 'source/BLD_pending_sample_validation.html';
    }
    else if (t == 'BLD_blood_donation_entry.html') {
    F = 'source/BLD_blood_donation_entry.html';
    }
    else if (t == 'BLD_Blood_Reaction_Form_Entry.html') {
    F = 'source/BLD_Blood_Reaction_Form_Entry.html';
    }
    else if (t == 'BLD_Blood_Request_Entry.html') {
    F = 'source/BLD_Blood_Request_Entry.html';
    }
    else if (t == 'BLD_Blood_Stock_Opening_Balance_Entry.html') {
    F = 'source/BLD_Blood_Stock_Opening_Balance_Entry.html';
    }
    else if (t == 'BLD_blood_test_entry.html') {
    F = 'source/BLD_blood_test_entry.html';
}
else if (t == 'BLD_component_Master.html') {
F = 'source/BLD_component_Master.html';
}
else if (t == 'BLD_Consent_Blood_Transfusion.html') {
F = 'source/BLD_Consent_Blood_Transfusion.html';
}
else if (t == 'BLD_Donor_Blood_Pending_For_Sample_Screening.html') {
F = 'source/BLD_Donor_Blood_Pending_For_Sample_Screening.html';
}
else if (t == 'BLD_Investigation_Pending_Transfusion_Reaction.html') {
F = 'source/BLD_Investigation_Pending_Transfusion_Reaction.html';
}
else if (t == 'BLD_Pending_Blood_Issue.html') {
F = 'source/BLD_Pending_Blood_Issue.html';
}
else if (t == 'BLD_Pending_For_Blood_Grouping_Cross_Matching.html') {
F = 'source/BLD_Pending_For_Blood_Grouping_Cross_Matching.html';
}
else if (t == 'BLD_Pending_for_Sample_Receipt_Entry.html') {
F = 'source/BLD_Pending_for_Sample_Receipt_Entry.html';
}
else if (t == 'BLD_update_blood_donation_entry.html') {
F = 'source/BLD_update_blood_donation_entry.html';
}
else if (t == 'BLD_Update_Blood_Reaction_Form_Entry.html') {
F = 'source/BLD_Update_Blood_Reaction_Form_Entry.html';
}
else if (t == 'BLD_update_blood_test_entry.html') {
F = 'source/BLD_update_blood_test_entry.html';
}
    else if (t == 'bill_ipbilling.html') {
    F = 'source/bill_ipbilling.html';
    }
    else if (t == 'bill_patientfinalsettlement.html') {
    F = 'source/bill_patientfinalsettlement.html';
    }
    else if (t == 'bill_patientsearchdetailsadvance.html') {
    F = 'source/bill_patientsearchdetailsadvance.html';
    }
    else if (t == 'bill_searchpatientadvance.html') {
    F = 'source/bill_searchpatientadvance.html';
    }
    else if (t == 'Diet_breakfast.html') {
    F = 'source/Diet_breakfast.html';
    }
    else if (t == 'Diet_patientdietchange.html') {
    F = 'source/Diet_patientdietchange.html';
    }
    else if (t == 'Diet_dailydietextrareq.html') {
    F = 'source/Diet_dailydietextrareq.html';
    }
    else if (t == 'Diet_dietindent.html') {
    F = 'source/Diet_dietindent.html';
    }
    else if (t == 'Diet_extraitem.html') {
    F = 'source/Diet_extraitem.html';
    }
    else if (t == 'Diet_internaldemand.html') {
    F = 'source/Diet_internaldemand.html';
    }
    else if (t == 'Diet_menuitem.html') {
    F = 'source/Diet_menuitem.html';
    }
    else if (t == 'enq_doctorenquiry.html') {
    F = 'source/enq_doctorenquiry.html';
    }
    else if (t == 'enq_inpatientenquiry.html') {
    F = 'source/enq_inpatientenquiry.html';
    }
    else if (t == 'enq_patientdetails.html') {
    F = 'source/enq_patientdetails.html';
    }
    else if (t == 'enq_patientsearch.html') {
    F = 'source/enq_patientsearch.html';
    }
    else if (t == 'ErrorPage.html') {
    F = 'source/ErrorPage.html';
    }
    else if (t == 'hr_hroentry.html') {
    F = 'source/hr_hroentry.html';
    }
    else if (t == 'hr_leaveapplicationentry.html') {
    F = 'source/hr_leaveapplicationentry.html';
    }
    else if (t == 'hr_movementinentry.html') {
    F = 'source/hr_movementinentry.html';
    }
    else if (t == 'hr_movementoutentry.html') {
    F = 'source/hr_movementoutentry.html';
    }
    else if (t == 'hr_pendingproposalforhrentr.html') {
    F = 'source/hr_pendingproposalforhrentr.html';
    }
    else if (t == 'hr_porprogrammaster.html') {
    F = 'source/hr_porprogrammaster.html';
    }
    else if (t == 'hr_postedoutentry.html') {
    F = 'source/hr_postedoutentry.html';
    }
    else if (t == 'hr_proposalforhrentry.html') {
    F = 'source/hr_proposalforhrentry.html';
    }
    else if (t == 'IPD_clinicalchart.html') {
    F = 'source/IPD_clinicalchart.html';
    }
    else if (t == 'IPD_dischargesumNABH.html') {
    F = 'source/IPD_dischargesumNABH.html';
    }
    else if (t == 'IPD_intakeandouttake.html') {
    F = 'source/IPD_intakeandouttake.html';
    }
    else if (t == 'IPD_orderstatus.html') {
    F = 'source/IPD_orderstatus.html';
    }
    else if (t == 'IPD_clinicalsetup.html') {
    F = 'source/IPD_clinicalsetup.html';
    }
    else if (t == 'IPD_dailyremarks.html') {
    F = 'source/IPD_dailyremarks.html';
    }
    else if (t == 'IPD_departmentindent.html') {
    F = 'source/IPD_departmentindent.html';
    }
    else if (t == 'IPD_dischargesumgeneral.html') {
    F = 'source/IPD_dischargesumgeneral.html';
    }
    else if (t == 'IPD_dischargesumOG.html') {
    F = 'source/IPD_dischargesumOG.html';
    }
    else if (t == 'IPD_dischargesumPaediatrice.html') {
    F = 'source/IPD_dischargesumPaediatrice.html';
    }
    else if (t == 'IPD_foodtasting.html') {
    F = 'source/IPD_foodtasting.html';
    }
    else if (t == 'IPD_nursingentry.html') {
    F = 'source/IPD_nursingentry.html';
    }
    else if (t == 'IPD_orderbooking.html') {
    F = 'source/IPD_orderbooking.html';
    }
    else if (t == 'IPD_patientdiagnosis.html') {
    F = 'source/IPD_patientdiagnosis.html';
    }
    else if (t == 'IPD_patientdischarge.html') {
    F = 'source/IPD_patientdischarge.html';
    }
    else if (t == 'IPD_patientissue.html') {
    F = 'source/IPD_patientissue.html';
    }
    else if (t == 'IPD_patientremark.html') {
    F = 'source/IPD_patientremark.html';
    }
    else if (t == 'IPD_patientsearch.html') {
    F = 'source/IPD_patientsearch.html';
    }
    else if (t == 'IPD_patienttransfer.html') {
    F = 'source/IPD_patienttransfer.html';
    }
    else if (t == 'IPD_sildil.html') {
    F = 'source/IPD_sildil.html';
    }
    else if (t == 'IPD_wardconsumption.html') {
    F = 'source/IPD_wardconsumption.html';
    }
    else if (t == 'Lab_cancelorderbooking.html') {
    F = 'source/Lab_cancelorderbooking.html';
    }
    else if (t == 'Lab_Confidentialorderreq.html') {
    F = 'source/Lab_Confidentialorderreq.html';
    }
    else if (t == 'Lab_Confidentialorderreqdetail.html') {
    F = 'source/Lab_Confidentialorderreqdetail.html';
    }
    else if (t == 'Lab_Diagnosticmaster.html') {
    F = 'source/Lab_Diagnosticmaster.html';
    }
    else if (t == 'Lab_orderbooking.html') {
    F = 'source/Lab_orderbooking.html';
    }
    else if (t == 'Lab_orderbookingIPDSearch.html') {
    F = 'source/Lab_orderbookingIPDSearch.html';
    }
    else if (t == 'Lab_reportdeliverydetail.html') {
    F = 'source/Lab_reportdeliverydetail.html';
    }
    else if (t == 'Lab_reportdeliverysearch.html') {
    F = 'source/Lab_reportdeliverysearch.html';
    }
    else if (t == 'Lab_resultentrydetail.html') {
    F = 'source/Lab_resultentrydetail.html';
    }
    else if (t == 'Lab_resultentrymodifydetail.html') {
    F = 'source/Lab_resultentrymodifydetail.html';
    }
    else if (t == 'Lab_resultentrymodifysearch.html') {
    F = 'source/Lab_resultentrymodifysearch.html';
    }
    else if (t == 'Lab_resultentrysearch.html') {
    F = 'source/Lab_resultentrysearch.html';
    }
    else if (t == 'Lab_resultprinting.html') {
    F = 'source/Lab_resultprinting.html';
    }
    else if (t == 'Lab_resultvalidationdetail.html') {
    F = 'source/Lab_resultvalidationdetail.html';
    }
    else if (t == 'Lab_resultvalidationsearch.html') {
    F = 'source/Lab_resultvalidationsearch.html';
    }
    else if (t == 'Lab_samplevalidationdetail.html') {
    F = 'source/Lab_samplevalidationdetail.html';
    }
    else if (t == 'Lab_samplevalidationsearch.html') {
    F = 'source/Lab_samplevalidationsearch.html';
    }
    else if (t == 'ma_cargaragemaster.html') {
    F = 'source/ma_cargaragemaster.html';
    }
    else if (t == 'ma_locationmaster.html') {
    F = 'source/ma_locationmaster.html';
    }
    else if (t == 'ma_poolcategory.html') {
    F = 'source/ma_poolcategory.html';
    }
    else if (t == 'ma_poolmaster.html') {
    F = 'source/ma_poolmaster.html';
    }
    else if (t == 'ma_Regulationprocess.html') {
    F = 'source/ma_Regulationprocess.html';
    }
    else if (t == 'ma_smqmaster.html') {
    F = 'source/ma_smqmaster.html';
    }
    else if (t == 'ma_accomodationregister.html') {
    F = 'source/ma_accomodationregister.html';
    }
    else if (t == 'ma_accomodationregisterforo.html') {
    F = 'source/ma_accomodationregisterforo.html';
    }
    else if (t == 'ma_all_vac_SMQ_airman.html') {
    F = 'source/ma_all_vac_SMQ_airman.html';
    }
    else if (t == 'ma_all_vac_SMQ_officer.html') {
    F = 'source/ma_all_vac_SMQ_officer.html';
    }
    else if (t == 'ma_allotmentmarriageaccomod.html') {
    F = 'source/ma_allotmentmarriageaccomod.html';
    }
    else if (t == 'ma_allotmentofsmqgarriageof.html') {
    F = 'source/ma_allotmentofsmqgarriageof.html';
    }
    else if (t == 'ma_cancel_all_airmen.html') {
    F = 'source/ma_cancel_all_airmen.html';
    }
    else if (t == 'ma_cancel_all_Officer.html') {
    F = 'source/ma_cancel_all_Officer.html';
    }
    else if (t == 'ma_NAC_Officer.html') {
    F = 'source/ma_NAC_Officer.html';
    }
    else if (t == 'ma_OccupancyVacationReturnAirmen.html') {
    F = 'source/ma_OccupancyVacationReturnAirmen.html';
    }
    else if (t == 'ma_OccupancyVacationReturnOfficer.html') {
    F = 'source/ma_OccupancyVacationReturnOfficer.html';
    }
    else if (t == 'ma_smqvacationforarmymen.html') {
    F = 'source/ma_smqvacationforarmymen.html';
    }
    else if (t == 'ma_smqvacationforOfficer.html') {
    F = 'source/ma_smqvacationforOfficer.html';
    }
    else if (t == 'ma_willingnesscertificateofficers.html') {
    F = 'source/ma_willingnesscertificateofficers.html';
    }
    else if (t == 'adt_PatientDischargeSearch.html') {
    F = 'source/adt_PatientDischargeSearch.html';
    }
    else if (t == 'MainADT.html') {
    F = 'source/MainADT.html';
    }
    else if (t == 'MainAgendaPoints.html') {
    F = 'source/MainAgendaPoints.html';
    }
    else if (t == 'MainAppointment.html') {
    F = 'source/MainAppointment.html';
    }
    else if (t == 'MainBilling.html') {
    F = 'source/MainBilling.html';
    }
    else if (t == 'MainBloodBank.html') {
    F = 'source/MainBloodBank.html';
    }
    else if (t == 'MainComplaintMonitoringSystem.html') {
    F = 'source/MainComplaintMonitoringSystem.html';
    }
    else if (t == 'MainCSSD.html') {
    F = 'source/MainCSSD.html';
    }
    else if (t == 'MainDiet.html') {
    F = 'source/MainDiet.html';
    }
    else if (t == 'MainEnquiry.html') {
    F = 'source/MainEnquiry.html';
    }
    else if (t == 'MainHMS.html') {
    F = 'source/MainHMS.html';
    }
    else if (t == 'MainHR.html') {
    F = 'source/MainHR.html';
    }
    else if (t == 'MainHROrderlyRoom.html') {
    F = 'source/MainHROrderlyRoom.html';
    }
    else if (t == 'MainIPD.html') {
    F = 'source/MainIPD.html';
    }
    else if (t == 'MainLaboratory.html') {
    F = 'source/MainLaboratory.html';
    }
    else if (t == 'MainLaundry.html') {
    F = 'source/MainLaundry.html';
    }
    else if (t == 'MainLibrary.html') {
    F = 'source/MainLibrary.html';
    }
    else if (t == 'MainMarriageAccommodation.html') {
    F = 'source/MainMarriageAccommodation.html';
    }
    else if (t == 'MainMasters.html') {
    F = 'source/MainMasters.html';
    }

    else if (t == 'MainMedicalBoardProceedings.html') {
    F = 'source/MainMedicalBoardProceedings.html';
    }
    else if (t == 'MainMedicalClaim.html') {
    F = 'source/MainMedicalClaim.html';
    }
    else if (t == 'MainMIS.html') {
    F = 'source/MainMIS.html';
    }
    else if (t == 'MainMRD.html') {
    F = 'source/MainMRD.html';
    }
    else if (t == 'MainOPD.html') {
    F = 'source/MainOPD.html';
    }
    else if (t == 'MainOT.html') {
    F = 'source/MainOT.html';
    }
    else if (t == 'MainPension.html') {
    F = 'source/MainPension.html';
    }
    else if (t == 'MainProcurement.html') {
    F = 'source/MainProcurement.html';
    }
    else if (t == 'MainRadiology.html') {
    F = 'source/MainRadiology.html';
    }
    else if (t == 'MainSecurity.html') {
    F = 'source/MainSecurity.html';
    }
    else if (t == 'MainStoresAssets.html') {
    F = 'source/MainStoresAssets.html';
    }
    else if (t == 'MainStoresConsumable.html') {
    F = 'source/MainStoresConsumable.html';
    }
    else if (t == 'MainSubADT_IPADDMISSION.html') {
    F = 'source/MainSubADT_IPADDMISSION.html';
    }
    else if (t == 'MainSubADT_IpadmissionDischarge.html') {
    F = 'source/MainSubADT_IpadmissionDischarge.html';
    }
    else if (t == 'MainSubADT_IPADMISSIONTRANSFER.html') {
    F = 'source/MainSubADT_IPADMISSIONTRANSFER.html';
    }
    else if (t == 'MainSubADT_PATIENTREGISTATION.html') {
    F = 'source/MainSubADT_PATIENTREGISTATION.html';
    }
    else if (t == 'MainSubADT_PATIENTVISIT.html') {
    F = 'source/MainSubADT_PATIENTVISIT.html';
    }
    else if (t == 'MainSubLAB_PENDINGFORRESULTENTRY.html') {
    F = 'source/MainSubLAB_PENDINGFORRESULTENTRY.html';
    }

    else if (t == 'MainSubLAB_PENDINGFORRESULTVALIDATION.html') {
    F = 'source/MainSubLAB_PENDINGFORRESULTVALIDATION.html';
    }
    else if (t == 'MainSubLAB_PENDINGFORSAMPLEVALIDATION.html') {
    F = 'source/MainSubLAB_PENDINGFORSAMPLEVALIDATION.html';
    }
    else if (t == 'MainSubLAB_REPORTDELIVERY.html') {
    F = 'source/MainSubLAB_REPORTDELIVERY.html';
    }
    else if (t == 'MainSubLAB_RESULTMODIFICATION.html') {
    F = 'source/MainSubLAB_RESULTMODIFICATION.html';
    }
    else if (t == 'MainSubMST_BILLINGRELATED.html') {
    F = 'source/MainSubMST_BILLINGRELATED.html';
    }
    else if (t == 'MainSubMST_BlOODBANK.html') {
    F = 'source/MainSubMST_BlOODBANK.html';
    }
    else if (t == 'MainSubMST_CANTEEN.html') {
    F = 'source/MainSubMST_CANTEEN.html';
    }
    else if (t == 'MainSubMST_GENERAL.html') {
    F = 'source/MainSubMST_GENERAL.html';
    }
    else if (t == 'MainSubMST_HOSPITALRELATED.html') {
    F = 'source/MainSubMST_HOSPITALRELATED.html';
    }
    else if (t == 'MainSubMST_HRHRELATED.html') {
    F = 'source/MainSubMST_HRHRELATED.html';
    }
    else if (t == 'MainSubMST_INPATIENTRELATED.html') {
    F = 'source/MainSubMST_INPATIENTRELATED.html';
    }
    else if (t == 'MainSubMST_LABRELATED.html') {
    F = 'source/MainSubMST_LABRELATED.html';
    }
    else if (t == 'MainSubMST_OPD.html') {
    F = 'source/MainSubMST_OPD.html';
    }
    else if (t == 'MainSubMST_OTMASTERS.html') {
    F = 'source/MainSubMST_OTMASTERS.html';
    }
    else if (t == 'MainSubMST_PERSONNEL.html') {
    F = 'source/MainSubMST_PERSONNEL.html';
    }
    else if (t == 'MainSubMST_REGISTRATIONRELATED.html') {
    F = 'source/MainSubMST_REGISTRATIONRELATED.html';
    }
    else if (t == 'MainSubMST_STORES.html') {
    F = 'source/MainSubMST_STORES.html';
    }
    else if (t == 'MainSubMST_SYSTEMRELATEd.html') {
    F = 'source/MainSubMST_SYSTEMRELATEd.html';
    }
    else if (t == 'MainSubOPD_PATIENTINFO.html') {
    F = 'source/MainSubOPD_PATIENTINFO.html';
    }
    else if (t == 'MainSubRAD_ORDERBOOKING.html') {
    F = 'source/MainSubRAD_ORDERBOOKING.html';
    }
    else if (t == 'MainSubRAD_PENDINGFORRESULTENTRY.html') {
    F = 'source/MainSubRAD_PENDINGFORRESULTENTRY.html';
    }
    else if (t == 'MainSubRAD_PENDINGFORRESULTVALIDATION.html') {
    F = 'source/MainSubRAD_PENDINGFORRESULTVALIDATION.html';
    }
    else if (t == 'MainSubRAD_PENDINGFORSAMPLEVALIDATION.html') {
    F = 'source/MainSubRAD_PENDINGFORSAMPLEVALIDATION.html';
    }
    else if (t == 'MainSubRAD_REPORTDELIVERY.html') {
    F = 'source/MainSubRAD_REPORTDELIVERY.html';
    }
    else if (t == 'MainSubRAD_RESULTMODIFICATION.html') {
    F = 'source/MainSubRAD_RESULTMODIFICATION.html';
    }
    else if (t == 'MainSubWS_MAJORWORKDETAIL.html') {
    F = 'source/MainSubWS_MAJORWORKDETAIL.html';
    }
    else if (t == 'MainSubWS_MINORWORKDETAILS.html') {
    F = 'source/MainSubWS_MINORWORKDETAILS.html';
    }
    else if (t == 'MainWorkServices.html') {
    F = 'source/MainWorkServices.html';
    }
    else if (t == 'MBP_TypeEntryMaster.html') {
    F = 'source/MBP_TypeEntryMaster.html';
    }
    else if (t == 'MainMedicalBoardProceedings.html') {
    F = 'source/MainMedicalBoardProceedings.html';
    }
    else if (t == 'MBP_MMBPSearch.html') {
    F = 'source/MBP_MMBPSearch.html';
    }
    else if (t == 'MBP_MEReport.html') {
    F = 'source/MBP_MEReport.html';
    }
    else if (t == 'MBP_ICFUSpecial_MB.html') {
    F = 'source/MBP_ICFUSpecial_MB.html';
    }
    else if (t == 'MBP_CByTheCandEntry.html') {
    F = 'source/MBP_CByTheCandEntry.html';
    }
    else if (t == 'MBP_RAMedical_BoardEntry.html') {
    F = 'source/MBP_RAMedical_BoardEntry.html';
    }
    else if (t == 'mis_birthcertificate.html') {
    F = 'source/mis_birthcertificate.html';
    }
    else if (t == 'mis_deathcertificate.html') {
    F = 'source/mis_deathcertificate.html';
    }
    else if (t == 'mis_edreturn.html') {
    F = 'source/mis_edreturn.html';
    }
    else if (t == 'mis_fataldocumenttracking.html') {
    F = 'source/mis_fataldocumenttracking.html';
    }
    else if (t == 'mis_requisitionforissueofrw.html') {
    F = 'source/mis_requisitionforissueofrw.html';
    }
    else if (t == 'mis_updatedeathcertificate.html') {
    F = 'source/mis_deathcertificate.html';
    }
    else if (t == 'mis_annuvalmedicalexamination.html') {
    F = 'source/mis_annuvalmedicalexamination.html';
    }
    else if (t == 'mis_updatebirthcertificate.html') {
    F = 'source/mis_updatebirthcertificate.html';
    }
    else if (t == 'mst_AccountingUnitConversion.html') {
    F = 'source/mst_AccountingUnitConversion.html';
    }
    else if (t == 'mst_AccountType.html') {
    F = 'source/mst_AccountType.html';
    }
    else if (t == 'mst_AdministrativeSex.html') {
    F = 'source/mst_AdministrativeSex.html';
    }

    else if (t == 'mst_AdmissionTypeMaster.html') {
    F = 'source/mst_AdmissionTypeMaster.html';
    }
    else if (t == 'mst_AirforceUnitDepotMaster.html') {
    F = 'source/mst_AirforceUnitDepotMaster.html';
    }
    else if (t == 'mst_Anesthesia.html') {
    F = 'source/mst_Anesthesia.html';
    }
    else if (t == 'mst_AuthorizerMaster.html') {
    F = 'source/mst_AuthorizerMaster.html';
    }
    else if (t == 'mst_BabyStatusMaster.html') {
    F = 'source/mst_BabyStatusMaster.html';
    }
    else if (t == 'mst_BankMaster.html') {
    F = 'source/mst_BankMaster.html';
    }
    else if (t == 'mst_BedStatusMaster.html') {
    F = 'source/mst_BedStatusMaster.html';
    }
    else if (t == 'mst_BillType.html') {
    F = 'source/mst_BillType.html';
    }
    else if (t == 'mst_BiopsyLabMaster.html') {
    F = 'source/mst_BiopsyLabMaster.html';
    }
    else if (t == 'mst_Block.html') {
    F = 'source/mst_Block.html';
    }
    else if (t == 'mst_BudgetMaster.html') {
    F = 'source/mst_BudgetMaster.html';
    }
    else if (t == 'mst_CareType.html') {
    F = 'source/mst_CareType.html';
    }
    else if (t == 'mst_CaseTypeMaster.html') {
    F = 'source/mst_CaseTypeMaster.html';
    }
    else if (t == 'mst_CasteMaster.html') {
    F = 'source/mst_CasteMaster.html';
    }
    else if (t == 'mst_ChargeType.html') {
    F = 'source/mst_ChargeType.html';
    }
    else if (t == 'mst_CollectionCenter.html') {
    F = 'source/mst_CollectionCenter.html';
    }
    else if (t == 'mst_ComplaintMaster.html') {
    F = 'source/mst_ComplaintMaster.html';
    }
    else if (t == 'mst_ComplicationMaster.html') {
    F = 'source/mst_ComplicationMaster.html';
    }
    else if (t == 'mst_CostCenterMaster.html') {
    F = 'source/mst_CostCenterMaster.html';
    }
    else if (t == 'mst_Country.html') {
    F = 'source/mst_Country.html';
    }
    else if (t == 'mst_Currency.html') {
    F = 'source/mst_Currency.html';
    }
    else if (t == 'mst_DeathCauseMaster.html') {
    F = 'source/mst_DeathCauseMaster.html';
    }
    else if (t == 'mst_DeliveryMaster.html') {
    F = 'source/mst_DeliveryMaster.html';
    }
    else if (t == 'mst_DepartmentMaster.html') {
    F = 'source/mst_DepartmentMaster.html';
    }
    else if (t == 'mst_DepartmentType.html') {
    F = 'source/mst_DepartmentType.html';
    }
    else if (t == 'mst_DiagnosisConclusion.html') {
    F = 'source/mst_DiagnosisConclusion.html';
    }
    else if (t == 'mst_DiagnosticParameter.html') {
    F = 'source/mst_DiagnosticParameter.html';
    }
    else if (t == 'mst_DietCombination.html') {
    F = 'source/mst_DietCombination.html';
    }
    else if (t == 'mst_DietIndentItemMaster.html') {
    F = 'source/mst_DietIndentItemMaster.html';
    }
    else if (t == 'mst_DietItem.html') {
    F = 'source/mst_DietItem.html';
    }
    else if (t == 'mst_DietMaster.html') {
    F = 'source/mst_DietMaster.html';
    }
    else if (t == 'mst_DietMenuItem.html') {
    F = 'source/mst_DietMenuItem.html';
    }
    else if (t == 'mst_DischargeItems.html') {
    F = 'source/mst_DischargeItems.html';
    }
    else if (t == 'mst_DischargeStatusMaster.html') {
    F = 'source/mst_DischargeStatusMaster.html';
    }
    else if (t == 'mst_DisposalMaster.html') {
    F = 'source/mst_DisposalMaster.html';
    }
    else if (t == 'mst_DisposedToMaster.html') {
    F = 'source/mst_DisposedToMaster.html';
    }
    else if (t == 'mst_District.html') {
    F = 'source/mst_District.html';
    }
    else if (t == 'mst_DiteType.html') {
    F = 'source/mst_DiteType.html';
    }
    else if (t == 'mst_DocumentMaster.html') {
    F = 'source/mst_DocumentMaster.html';
    }
    else if (t == 'mst_DutyTimeMaster.html') {
    F = 'source/mst_DutyTimeMaster.html';
    }
    else if (t == 'mst_employeeDependentMaster.html') {
    F = 'source/mst_employeeDependentMaster.html';
    }
    else if (t == 'mst_employeeMaster.html') {
    F = 'source/mst_employeeMaster.html';
    }
    else if (t == 'mst_EmployeeStatusMaster.html') {
    F = 'source/mst_EmployeeStatusMaster.html';
    }
    else if (t == 'mst_EstablishmentMasterForM.html') {
    F = 'source/mst_EstablishmentMasterForM.html';
    }
    else if (t == 'mst_FinancialMaster.html') {
    F = 'source/mst_FinancialMaster.html';
    }
    else if (t == 'mst_FormationMaster.html') {
    F = 'source/mst_FormationMaster.html';
    }
    else if (t == 'mst_frequencyMaster.html') {
    F = 'source/mst_frequencyMaster.html';
    }
    else if (t == 'mst_GerericMaster.html') {
    F = 'source/mst_GerericMaster.html';
    }
    else if (t == 'mst_ICDCauseGroup.html') {
    F = 'source/mst_ICDCauseGroup.html';
    }
    else if (t == 'mst_ICDMainCategory.html') {
    F = 'source/mst_ICDMainCategory.html';
    }
    else if (t == 'mst_ICDMaster.html') {
    F = 'source/mst_ICDMaster.html';
    }
    else if (t == 'mst_ICDSubCategoryMaster.html') {
    F = 'source/mst_ICDSubCategoryMaster.html';
    }
    else if (t == 'mst_InjuryNatureMaster.html') {
    F = 'source/mst_InjuryNatureMaster.html';
    }
    else if (t == 'mst_InvestigationUOM.html') {
    F = 'source/mst_InvestigationUOM.html';
    }
    else if (t == 'mst_ItemTypeMaster.html') {
    F = 'source/mst_ItemTypeMaster.html';
    }
    else if (t == 'mst_ItemUnitMaster.html') {
    F = 'source/mst_ItemUnitMaster.html';
    }
    else if (t == 'mst_LeaveTypeMaster.html') {
    F = 'source/mst_LeaveTypeMaster.html';
    }
    else if (t == 'mst_MainChargeMaster.html') {
    F = 'source/mst_MainChargeMaster.html';
    }
    else if (t == 'mst_ManufactureMaster.html') {
    F = 'source/mst_ManufactureMaster.html';
    }
    else if (t == 'mst_MaritalStatusMaster.html') {
    F = 'source/mst_MaritalStatusMaster.html';
    }
    else if (t == 'mst_MedicalCourceMaster.html') {
    F = 'source/mst_MedicalCourceMaster.html';
    }
    else if (t == 'mst_MeScaleMaster.html') {
    F = 'source/mst_MeScaleMaster.html';
    }
    else if (t == 'mst_NursingCareMaster.html') {
    F = 'source/mst_NursingCareMaster.html';
    }
    else if (t == 'mst_OccupationMaster.html') {
    F = 'source/mst_OccupationMaster.html';
    }
    else if (t == 'mst_OPDEquipment.html') {
    F = 'source/mst_OPDEquipment.html';
    }
    else if (t == 'mst_OPDFrequency.html') {
    F = 'source/mst_OPDFrequency.html';
    }
    else if (t == 'mst_OPDHoliday.html') {
    F = 'source/mst_OPDHoliday.html';
    }
    else if (t == 'mst_OPDInstructionTreatment.html') {
    F = 'source/mst_OPDInstructionTreatment.html';
    }
    else if (t == 'mst_OPdTemplateInvestigation.html') {
    F = 'source/mst_OPdTemplateInvestigation.html';
    }
    else if (t == 'mst_OPDPhysiotherapy.html') {
    F = 'source/mst_OPDPhysiotherapy.html';
    }
    else if (t == 'mst_OPDTeratmentTemplate.html') {
    F = 'source/mst_OPDTeratmentTemplate.html';
    }
    else if (t == 'mst_OPDVaccinating.html') {
    F = 'source/mst_OPDVaccinating.html';
    }
    else if (t == 'mst_Organism.html') {
    F = 'source/mst_Organism.html';
    }
    else if (t == 'mst_OrganismDetails.html') {
    F = 'source/mst_OrganismDetails.html';
    }
    else if (t == 'mst_OrganismGroup.html') {
    F = 'source/mst_OrganismGroup.html';
    }
    else if (t == 'mst_OrganismGroupDetails.html') {
    F = 'source/mst_OrganismGroupDetails.html';
    }
    else if (t == 'mst_OTChargeDetails.html') {
    F = 'source/mst_OTChargeDetails.html';
    }
    else if (t == 'mst_OTDistribution.html') {
    F = 'source/mst_OTDistribution.html';
    }
    else if (t == 'mst_OTMaster.html') {
    F = 'source/mst_OTMaster.html';
    }
    else if (t == 'mst_ParameterMaster.html') {
    F = 'source/mst_ParameterMaster.html';
    }
    else if (t == 'mst_PatientTYpe.html') {
    F = 'source/mst_PatientTYpe.html';
    }

    else if (t == 'mst_PharmaIndexMaster.html') {
    F = 'source/mst_PharmaIndexMaster.html';
    }
    else if (t == 'mst_PostCode.html') {
    F = 'source/mst_PostCode.html';
    }
    else if (t == 'mst_PVMSNIVGroupMaster.html') {
    F = 'source/mst_PVMSNIVGroupMaster.html';
    }
    else if (t == 'mst_PVMSNIVMaster.html') {
    F = 'source/mst_PVMSNIVMaster.html';
    }
    else if (t == 'mst_PVMSNIVSectionMaster.html') {
    F = 'source/mst_PVMSNIVSectionMaster.html';
    }
    else if (t == 'mst_PVMSNIVSubSection.html') {
    F = 'source/mst_PVMSNIVSubSection.html';
    }
    else if (t == 'mst_RankCategoryMaster.html') {
    F = 'source/mst_RankCategoryMaster.html';
    }
    else if (t == 'mst_RankMaster.html') {
    F = 'source/mst_RankMaster.html';
    }
    else if (t == 'mst_RecordOfficeAddressMast.html') {
    F = 'source/mst_RecordOfficeAddressMast.html';
    }
    else if (t == 'mst_ReferenceMaster.html') {
    F = 'source/mst_ReferenceMaster.html';
    }
    else if (t == 'mst_ReferralDoctorMaster.html') {
    F = 'source/mst_ReferralDoctorMaster.html';
    }
    else if (t == 'mst_RelationMaster.html') {
    F = 'source/mst_RelationMaster.html';
    }
    else if (t == 'mst_ReligionMaster.html') {
    F = 'source/mst_ReligionMaster.html';
    }
    else if (t == 'mst_RoomMaster.html') {
    F = 'source/mst_RoomMaster.html';
    }
    else if (t == 'mst_SalesType.html') {
    F = 'source/mst_SalesType.html';
    }
    else if (t == 'mst_SampleContainerMaster.html') {
    F = 'source/mst_SampleContainerMaster.html';
    }
    else if (t == 'mst_SampleMaster.html') {
    F = 'source/mst_SampleMaster.html';
    }
    else if (t == 'mst_Sensitivity.html') {
    F = 'source/mst_Sensitivity.html';
    }
    else if (t == 'mst_serviceStatus.html') {
    F = 'source/mst_serviceStatus.html';
    }
    else if (t == 'mst_serviceType.html') {
    F = 'source/mst_serviceType.html';
    }
    else if (t == 'mst_SpecialityMaster.html') {
    F = 'source/mst_SpecialityMaster.html';
    }
    else if (t == 'mst_state.html') {
    F = 'source/mst_state.html';
    }
    else if (t == 'mst_SubChargeCode.html') {
    F = 'source/mst_SubChargeCode.html';
    }
    else if (t == 'mst_SupplierTypeMaster.html') {
    F = 'source/mst_SupplierTypeMaster.html';
    }
    else if (t == 'mst_SupplyOrderDeliveryPayment.html') {
    F = 'source/mst_SupplyOrderDeliveryPayment.html';
    }
    else if (t == 'mst_TitalMaster.html') {
    F = 'source/mst_TitalMaster.html';
    }
    else if (t == 'mst_TradeMaster.html') {
    F = 'source/mst_TradeMaster.html';
    }
    else if (t == 'mst_TranscctionType.html') {
    F = 'source/mst_TranscctionType.html';
    }
    else if (t == 'mst_unitMaster.html') {
    F = 'source/mst_unitMaster.html';
    }
    else if (t == 'mst_UnitofMeasurement.html') {
    F = 'source/mst_UnitofMeasurement.html';
    }
    else if (t == 'mst_VenderMaster.html') {
    F = 'source/mst_VenderMaster.html';
    }
    else if (t == 'MainOPD.html') {
    F = 'source/MainOPD.html';
    }
    else if (t == 'opd_waitingpatientlist.html') {
    F = 'source/opd_waitingpatientlist.html';
    }
    else if (t == 'opd_patientpreviousvisits.html') {
    F = 'source/opd_patientpreviousvisits.html';
    }
    else if (t == 'opd_main_afmsf7casesheet.html') {
    F = 'source/opd_main_afmsf7casesheet.html';
    }
    else if (t == 'OT_surgeryrequesitions.html') {
    F = 'source/OT_surgeryrequesitions.html';
    }
    else if (t == 'MainSubOPD_PATIENTINFO.html') {
    F = 'source/MainSubOPD_PATIENTINFO.html';
    }
    else if (t == 'opd_patientvisitupdate.html') {
    F = 'source/opd_patientvisitupdate.html';
    }
    else if (t == 'opd_Cardiology.html') {
    F = 'source/opd_Cardiology.html';
    }
    else if (t == 'opd_ent.html') {
    F = 'source/opd_ent.html';
    }
    else if (t == 'opd_oncosurgerycasesheet.html') {
    F = 'source/opd_oncosurgerycasesheet.html';
    }
    else if (t == 'opd_Opthomology.html') {
    F = 'source/opd_Opthomology.html';
    }
    else if (t == 'opd_Opthomology_floowup.html') {
    F = 'source/opd_Opthomology_floowup.html';
    }
     else if (t == 'opd_Opthomology_retinal.html') {
    F = 'source/opd_Opthomology_retinal.html';
    }
     else if (t == 'opd_Paediatrics.html') {
    F = 'source/opd_Paediatrics.html';
    }
     else if (t == 'opd_urologycasesheet.html') {
    F = 'source/opd_urologycasesheet.html';
    }
    else if (t == 'pro_tendercreation.html') {
    F = 'source/pro_tendercreation.html';
    }
    else if (t == 'pro_inviationtender.html') {
    F = 'source/pro_inviationtender.html';
    }
    else if (t == 'pro_tenderdocument.html') {
    F = 'source/pro_tenderdocument.html';
    }
    else if (t == 'Pro_export.html') {
    F = 'source/Pro_export.html';
    }
    else if (t == 'Pro_import.html') {
    F = 'source/Pro_import.html';
   }
    else if (t == 'pro_TechnicalBid.html') {
    F = 'source/pro_TechnicalBid.html';
   }
   else if (t == 'pro_CommercialBid.html') {
    F = 'source/pro_CommercialBid.html';
   }
   else if (t == 'pro_Tender_PNC.html') {
    F = 'source/pro_Tender_PNC.html';
   }
   else if (t == 'pro_Tender_LPONote.html') {
    F = 'source/pro_Tender_LPONote.html';
   }
   else if (t == 'Pro_tenderproposal.html') {
    F = 'source/Pro_tenderproposal.html';
   }
   else if (t == 'pro_Tender_SO_L1.html') {
    F = 'source/pro_Tender_SO_L1.html';
   }
   else if (t == 'pro_Tender_SO_Cancel.html') {
    F = 'source/pro_Tender_SO_Cancel.html';
   }
   else if (t == 'pro_RE_Tender_PRO.html') {
    F = 'source/pro_RE_Tender_PRO.html';
   }
   else if (t == 'pro_RE_Tender_SOL1.html') {
    F = 'source/pro_RE_Tender_SOL1.html';
   }
   else if (t == 'pro_RE_Tender_SOCancel.html') {
    F = 'source/pro_RE_Tender_SOCancel.html';
   }
   else if (t == 'pro_Pre_TenderItems.html') {
    F = 'source/pro_Pre_TenderItems.html';
   }
   else if (t == 'Rad_cancelOBsearch.html') {
    F = 'source/Rad_cancelOBsearch.html';
    }
    else if (t == 'Rad_Confidentialorderreq.html') {
    F = 'source/Rad_Confidentialorderreq.html';
    }
    else if (t == 'Rad_ConfidentialORdetail.html') {
    F = 'source/Rad_ConfidentialORdetail.html';
    }
    else if (t == 'Rad_diagnosticmaster.html') {
    F = 'source/Rad_diagnosticmaster.html';
    }
    else if (t == 'Rad_orderbooking.html') {
    F = 'source/Rad_orderbooking.html';
    }
    else if (t == 'Rad_pendingrepsearch.html') {
    F = 'source/Rad_pendingrepsearch.html';
    }
    else if (t == 'Rad_reportdeliverydetail.html') {
    F = 'source/Rad_reportdeliverydetail.html';
    }
    else if (t == 'Rad_reportdeliverysearch.html') {
    F = 'source/Rad_reportdeliverysearch.html';
    }
    else if (t == 'Rad_resultvalidsearch.html') {
    F = 'source/Rad_resultvalidsearch.html';
    }
    else if (t == 'Rad_AcceptanceforRadiologicalInvestigations.html') {
    F = 'source/Rad_AcceptanceforRadiologicalInvestigations.html';
    }
    else if (t == 'Rad_filmentry.html') {
    F = 'source/Rad_filmentry.html';
    
    }
    else if (t == 'Rad_reportprinting.html') {
    F = 'source/Rad_reportprinting.html';
    
    }
    else if (t == 'Rad_reportvalidationdetail.html') {
    F = 'source/Rad_resultvalidsearch';
    
    }
    else if (t == 'Rad_AcceptanceforRadiologicalInvestigationsSearch.html') {
    F = 'source/Rad_AcceptanceforRadiologicalInvestigationsSearch.html';

    }
    else if (t == 'Rad_reportvalidationdetail.html') {
    F = 'source/Rad_reportvalidationdetail.html';
    
    }
    else if (t == 'Rad_pendingreportentrysearch.html') {
    F = 'source/Rad_pendingreportentrysearch.html';
    
    }
    else if (t == 'Rad_pendingreportentryDetails.html') {
    F = 'source/Rad_pendingreportentryDetails.html';
               
    }
    else if (t == 'sec_addformreport.html') {
    F = 'source/sec_addformreport.html';
    }
    else if (t == 'sec_assignmoduletoemployygroup.html') {
    F = 'source/sec_assignmoduletoemployygroup.html';
    }
    else if (t == 'sec_applicationtoemployeegroup.html') {
    F = 'source/sec_applicationtoemployeegroup.html';
    }

    else if (t == 'sec_assignbuttonrightsemployeegroup.html') {
    F = 'source/sec_assignbuttonrightsemployeegroup.html';
    }
    else if (t == 'sec_buttondetilamaster.html') {
    F = 'source/sec_buttondetilamaster.html';
    }
    else if (t == 'sec_changedepartment.html') {
    F = 'source/sec_changedepartment.html';
    }
    else if (t == 'sec_changeorderapplication.html') {
    F = 'source/sec_changeorderapplication.html';
    }
    else if (t == 'sec_changepassword.html') {
    F = 'source/sec_changepassword.html';
    }
    else if (t == 'sec_department.html') {
    F = 'source/sec_department.html';
    }
    else if (t == 'sec_editformreport.html') {
    F = 'source/sec_editformreport.html';
    }
    else if (t == 'sec_employeegroup.html') {
    F = 'source/sec_employeegroup.html';
    }
    else if (t == 'sec_hospitalmaster.html') {
    F = 'source/sec_hospitalmaster.html';
    }
    else if (t == 'sec_removebuttonrights.html') {
    F = 'source/sec_removebuttonrights.html';
    }
    else if (t == 'sec_user.html') {
    F = 'source/sec_user.html';
    }
    else if (t == 'sec_usergrouphospital.html') {
    F = 'source/sec_usergrouphospital.html';
    }
    else if (t == 'sec_usergroupmaster.html') {
    F = 'source/sec_usergroupmaster.html';
    }
    else if (t == 'sec_userhospitalmaintainenc.html') {
    F = 'source/sec_userhospitalmaintainenc.html';
    }
    else if (t == 'sec_usermanagement.html') {
    F = 'source/sec_usermanagement.html';
    }
    else if (t == 'sec_usermanagementdetails.html') {
    F = 'source/sec_usermanagementdetails.html';
    }
    else if (t == 'sec_viewremovebuttonrights.html') {
    F = 'source/sec_viewremovebuttonrights.html';
    }
    else if (t == 'ST_MMFProjectionToDGAFMS.html') {
    F = 'source/ST_MMFProjectionToDGAFMS.html';
    }
    else if (t == 'ST_indenttodepot.html') {
    F = 'source/ST_indenttodepot.html';
    }
    else if (t == 'ST_indentSOC.html') {
    F = 'source/ST_indentSOC.html';
    }
    else if (t == 'ST_indentSOCtracker.html') {
    F = 'source/ST_indentSOCtracker.html';
    }
    else if (t == 'ST_LocalSupplyOrder.html') {
    F = 'source/ST_LocalSupplyOrder.html';
    }
    else if (t == 'ST_IssueCIV.html') {
    F = 'source/ST_IssueCIV.html';
    }
    else if (t == 'ST_crv.html') {
    F = 'source/ST_crv.html';
    }
    else if (t == 'ST_loanin.html') {
    F = 'source/ST_loanin.html';
    }
    else if (t == 'ST_LoanOut.html') {
    F = 'source/ST_LoanOut.html';
    }
    else if (t == 'ST_issueotherairforce.html') {
    F = 'source/ST_issueotherairforce.html';
    }
    else if (t == 'ST_departmentreturn.html') {
    F = 'source/ST_departmentreturn.html';
    }
    else if (t == 'ST_Vender_Return.html') {
    F = 'source/ST_Vender_Return.html';
    }
    else if (t == 'ST_ATSupplyOrder.html') {
    F = 'source/ST_ATSupplyOrder.html';
    }
    else if (t == 'ST_OpeningBalanceEntry.html') {
    F = 'source/ST_OpeningBalanceEntry.html';
    }
    else if (t == 'ST_certiofStocktaking.html') {
    F = 'source/ST_certiofStocktaking.html';
    }
    else if (t == 'ST_DefectiveDurgsEntry.html') {
    F = 'source/ST_DefectiveDurgsEntry.html';
    }
    else if (t == 'ST_IssueOtherUnitsCIV.html') {
    F = 'source/ST_IssueOtherUnitsCIV.html';
    }
    else if (t == 'ST_MMFDeptApproval.html') {
    F = 'source/ST_MMFDeptApproval.html';
    }
    else if (t == 'ST_CRVListPendingLed.html') {
    F = 'source/ST_CRVListPendingLed.html';
    }
    else if (t == 'ST_ACKForm.html') {
    F = 'source/ST_ACKForm.html';
    }
    else if (t == 'ST_mmfdeptentry.html') {
    F = 'source/ST_mmfdeptentry.html';
    }
    else if (t == 'ST_Vender-Return.html') {
    F = 'source/ST_Vender-Return.html';
    }
    else if (t == 'ws_approvalminorworkdetails.html') {
    F = 'source/ws_approvalminorworkdetails.html';
    }
    else if (t == 'ws_majorworkdetails.html') {
    F = 'source/ws_majorworkdetails.html';
    }
    else if (t == 'ws_majorworkdetailsearch.html') {
    F = 'source/ws_majorworkdetailsearch.html';
    }
    else if (t == 'ws_minorworkdetailscompleti.html') {
    F = 'source/ws_minorworkdetailscompleti.html';
    }
    else if (t == 'ws_minorworkdetailsearch.html') {
    F = 'source/ws_minorworkdetailsearch.html';
    }
    else if (t == 'ws_minorworkproposal.html') {
    F = 'source/ws_minorworkproposal.html';
    }
    else if (t == 'ws_cancelminorworkapproval.html') {
    F = 'source/ws_cancelminorworkapproval.html';
    }
    else if (t == 'ws_usercommentsminorworkdetails.html') {
    F = 'source/ws_workcategory.html';
    }
    else if (t == 'ws_minorworkdetails.html') {
    F = 'source/ws_minorworkdetails.html';
    }
    else if (t == 'ws_workcategory.html') {
    F = 'source/ws_workcategory.html';
    }
    else if (t == 'ws_worktype.html') {
    F = 'source/ws_worktype.html';
    }
    else if (t == 'CMS_complinetregister.html') {
    F = 'source/CMS_complinetregister.html';
    }
    else if (t == 'CMS_complinettypemaster.html') {
    F = 'source/CMS_complinettypemaster.html';
    }
    else if (t == 'CMS_workcompletiondetails.html') {
    F = 'source/CMS_workcompletiondetails.html';
    }
    else if (t == 'CMS_wornotkcompletion3days.html') {
    F = 'source/CMS_wornotkcompletion3days.html';
    }
    else if (t == 'OT_pacClearanceList.html') {
    F = 'source/OT_pacClearanceList.html';
    }
    else if (t == 'OT_bookingList.html') {
    F = 'source/OT_bookingList.html';
    }
    else if (t == 'OT_Changelist.html') {
    F = 'source/OT_Changelist.html';
    }
    else if (t == 'OT_PostOPNotesAnaesthesiaSearch.html') {
    F = 'source/OT_PostOPNotesAnaesthesiaSearch.html';
    }
    else if (t == 'OT_PostOPNotesAnaesthesia.html') {
    F = 'source/OT_PostOPNotesAnaesthesia.html';
    }
    else if (t == 'OT_PostOPNotesSurgerySearch.html') {
    F = 'source/OT_PostOPNotesSurgerySearch.html';
    }
    else if (t == 'OT_PostOPNotesSurgery.html') {
    F = 'source/OT_PostOPNotesSurgery.html';
    }
    else if (t == 'OT_SpecimenDispatchEntrySearch.html') {
    F = 'source/OT_SpecimenDispatchEntrySearch.html';
    }
    else if (t == 'OT_SpecimenDispatchEntry.html') {
    F = 'source/OT_SpecimenDispatchEntry.html';
    }
    else if (t == 'OT_HumanBodyDisposalEntry.html') {
    F = 'source/OT_HumanBodyDisposalEntry.html';
    }
    else if (t == 'OT_HumanBodyPartsDisposalSearch.html') {
    F = 'source/OT_HumanBodyPartsDisposalSearch.html';
    }
    else if (t == 'OT_Actualsurgeryperform.html') {
    F = 'source/OT_Actualsurgeryperform.html';
    }
    else if (t == 'OT_surgeryrequesitions.html') {
    F = 'source/OT_surgeryrequesitions.html';
    }
    else if (t == 'OT_SurgeryEnquiry.html') {
    F = 'source/OT_SurgeryEnquiry.html';
    }
    else if (t == 'LDR_Machine_master.html') {
    F = 'source/LDR_Machine_master.html';
    }
    else if (t == 'LDR_linen_weight.html') {
    F = 'source/LDR_linen_weight.html';
    }
    else if (t == 'LDR_machine_activity_entry.html') {
    F = 'source/LDR_machine_activity_entry.html';
    }
    else if (t == 'LDR_driver_car_dairy_entry.html') {
    F = 'source/LDR_driver_car_dairy_entry.html';
    }
    else if (t == 'LDR_daily_workload_entry.html') {
    F = 'source/LDR_daily_workload_entry.html';
    }
    else if (t == 'mst_bloodbankstatus.html') {
    F = 'source/mst_bloodbankstatus.html';
    }
    else if (t == 'mst_blooddonation.html') {
    F = 'source/mst_blooddonation.html';
    }
    else if (t == 'mst_bloodgroup.html') {
    F = 'source/mst_bloodgroup.html';
    }
    else if (t == 'mst_classmaster.html') {
    F = 'source/mst_classmaster.html';
    }
    else if (t == 'mst_dutymaster.html') {
    F = 'source/mst_dutymaster.html';
    }
    else if (t == 'mst_testmaster.html') {
    F = 'source/mst_testmaster.html';
    }
    else if (t == 'MainSubLIB_LIBMASTER.html') {
    F = 'source/MainSubLIB_LIBMASTER.html';
    }
    else if (t == 'LIB_Update_Books_Journal_Issue_Entry.html') {
    F = 'source/LIB_Update_Books_Journal_Issue_Entry.html';
    }
    else if (t == 'LIB_Book_Master.html') {
    F = 'source/LIB_Book_Master.html';
    }
    else if (t == 'LIB_Book_Category.html') {
    F = 'source/LIB_Book_Category.html';
    }
    else if (t == 'LIB_Book_Class.html') {
    F = 'source/LIB_Book_Class.html';
    }
    else if (t == 'LIB_book_sub_class.html') {
    F = 'source/LIB_book_sub_class.html';
    }
    else if (t == 'LIB_vendor_master.html') {
    F = 'source/LIB_vendor_master.html';
    }
    else if (t == 'LIB_publisher_master.html') {
    F = 'source/LIB_publisher_master.html';
    }
    else if (t == 'LIB_supply_order_entry.html') {
    F = 'source/LIB_supply_order_entry.html';
    }
    else if (t == 'LIB_update_supply_order_entry.html') {
    F = 'source/LIB_update_supply_order_entry.html';
    }
    else if (t == 'LIB_CRV_entry.html') {
    F = 'source/LIB_CRV_entry.html';
    }
    else if (t == 'LIB_Update_CRV_entry.html') {
    F = 'source/LIB_Update_CRV_entry.html';
    }
    else if (t == 'LIB_Journal_Receipt_Entry.html') {
    F = 'source/LIB_Journal_Receipt_Entry.html';
    }
    else if (t == 'LIB_Update_Journal_Receipt_Entry.html') {
    F = 'source/LIB_Update_Journal_Receipt_Entry.html';
    }
    else if (t == 'LIB_Books_Journal_Issue_Entry.html') {
    F = 'source/LIB_Books_Journal_Issue_Entry.html';
    }
    else if (t == 'LIB_Books_Journal_Return_Entry.html') {
    F = 'source/LIB_Books_Journal_Return_Entry.html';
    }
    else if (t == 'LIB_update_Books_Journal_Return_Entry.html') {
    F = 'source/LIB_update_Books_Journal_Return_Entry.html';
    }
    else if (t == 'LIB_Books_stock_Taking_Entry.html') {
    F = 'source/LIB_Books_stock_Taking_Entry.html';
    }
    else if (t == 'LIB_update_book_stock_taking.html') {
    F = 'source/LIB_update_book_stock_taking.html';
    }
    else if (t == 'MainSubMST_MARR_ACC.html') {
    F = 'source/MainSubMST_MARR_ACC.html';
    }
    else if (t == 'mst_PoolCategory.html') {
    F = 'source/mst_PoolCategory.html';
    }
    else if (t == 'mst_Pool.html') {
    F = 'source/mst_Pool.html';
    }
    else if (t == 'mst_Location.html') {
    F = 'source/mst_Location.html';
    }
    else if (t == 'mst_SMQ.html') {
    F = 'source/mst_SMQ.html';
    }
    else if (t == 'mst_cargarage.html') {
    F = 'source/mst_cargarage.html';
}
else if (t == 'CSSD_Instrument_Master.html') {
F = 'source/CSSD_Instrument_Master.html';
}
else if (t == 'CSSD_Material_Stock_Entry.html') {
F = 'source/CSSD_Material_Stock_Entry.html';
}
else if (t == 'CSSD_Autoclave_Request_Entry.html') {
F = 'source/CSSD_Autoclave_Request_Entry.html';
}
else if (t == 'CSSD_Autoclave_Entry.html') {
F = 'source/CSSD_Autoclave_Entry.html';
}
else if (t == 'CSSD_Material_Master.html') {
F = 'source/CSSD_Material_Master.html';
}
else if (t == 'CSSD_Autoclave_Material_Receipt_Entry.html') {
F = 'source/CSSD_Autoclave_Material_Receipt_Entry.html';
}
else if (t == 'CSSD_Sterilize_Recall_List.html') {
F = 'source/CSSD_Sterilize_Recall_List.html';
}
else if (t == 'MClaim_Sanction_Authority_Master.html') {
F = 'source/MClaim_Sanction_Authority_Master.html';
}
else if (t == 'MClaim_Request_for_Special_Investigation_Entry.html') {
F = 'source/MClaim_Request_for_Special_Investigation_Entry.html';
}
else if (t == 'MClaim_Update_Request_for_Special_Investigation_Entry.html') {
F = 'source/MClaim_Update_Request_for_Special_Investigation_Entry.html';
}
else if (t == 'MClaim_Contingent_Bill_Reimbursement_Medical_BillEntry.html') {
F = 'source/MClaim_Contingent_Bill_Reimbursement_Medical_BillEntry.html';
}
else if (t == 'MClaim_update_Contingent_Bill_Reimbursement_Medical_BillEntry.html') {
F = 'source/MClaim_update_Contingent_Bill_Reimbursement_Medical_BillEntry.html';
}
else if (t == 'MClaim_Covering_Letters_Unit.html') {
F = 'source/MClaim_Covering_Letters_Unit.html';
}
else if (t == 'MClaim_General_Claim_Covering_letter.html') {
F = 'source/MClaim_General_Claim_Covering_letter.html';
}
else if (t == 'MClaim_General_Claim_Tracking.html') {
F = 'source/MClaim_General_Claim_Tracking.html';
}
else if (t == 'MClaim_Cardiacclaim_Advance_Undertaking_Willingness.html') {
F = 'source/MClaim_Cardiacclaim_Advance_Undertaking_Willingness.html';
}
else if (t == 'MClaim_update_Cardiacclaim_Advance_Undertaking_Willingness.html') {
F = 'source/MClaim_update_Cardiacclaim_Advance_Undertaking_Willingness.html';
}
else if (t == 'MClaim_Cardiac_claim_Contingent_Bill_Reimbursement.html') {
F = 'source/MClaim_Cardiac_claim_Contingent_Bill_Reimbursement.html';
}
else if (t == 'MClaim_Update_Cardiac_claim_Contingent_Bill_Reimbursement.html') {
F = 'source/MClaim_Update_Cardiac_claim_Contingent_Bill_Reimbursement.html';
}
else if (t == 'MClaim_Contingent_bill_movement_entry.html') {
F = 'source/MClaim_Contingent_bill_movement_entry.html';
}
else if (t == 'MClaim_Cardiac_Claim_Tracking.html') {
F = 'source/MClaim_Cardiac_Claim_Tracking.html';
}
else if (t == 'HR_Detailing_daily_routine_Scottsick_transferduty_entry.html') {
    F = 'source/HR_Detailing_daily_routine_Scottsick_transferduty_entry.html';
}
else if (t == 'HR_Duty_display_service_personnel.html') {
    F = 'source/HR_Duty_display_service_personnel.html';
}
else if (t == 'HR_Duty_exemption_entry.html') {
    F = 'source/HR_Duty_exemption_entry.html';
}
else if (t == 'HR_Guard_duty_entry.html') {
    F = 'source/HR_Guard_duty_entry.html';
}
else if (t == 'HR_Leave_Application_Pending_Recommenation.html') {
    F = 'source/HR_Leave_Application_Pending_Recommenation.html';
}
else if (t == 'HR_Leave_Maintenance.html') {
F = 'source/HR_Leave_Maintenance.html';
}
else if (t == 'HR_Night_duty_entry_Medical_Assistant.html') {
F = 'source/HR_Night_duty_entry_Medical_Assistant.html';
}
else if (t == 'HR_Orderly_SGT_duty_entry.html') {
F = 'source/HR_Orderly_SGT_duty_entry.html';
}
else if (t == 'HR_Range_firing_duty_entry.html') {
F = 'source/HR_Range_firing_duty_entry.html';
}
else if (t == 'HR_Update_arrival_service_personnel_details.html') {
F = 'source/HR_Update_arrival_service_personnel_details.html';
}
else if (t == 'HR_Ward_duty_entry.html') {
F = 'source/HR_Ward_duty_entry.html';
}		
else if (t == 'NES_AMC_Maintenance.html') {
F = 'source/NES_AMC_Maintenance.html';
}
else if (t == 'NES_AMC_repair.html') {
F = 'source/NES_AMC_repair.html';
}
else if (t == 'NES_board_of_survey.html') {
F = 'source/NES_board_of_survey.html';
}
else if (t == 'NES_Condemnation_Entry.html') {
F = 'source/NES_Condemnation_Entry.html';
}
else if (t == 'NES_CRV.html') {
F = 'source/NES_CRV.html';
}
else if (t == 'NES_Department_Issue.html') {
F = 'source/NES_Department_Issue.html';
}
else if (t == 'NES_Indent_to_DGAFMS(SOC).html') {
F = 'source/NES_Indent_to_DGAFMS(SOC).html';
}
else if (t == 'NES_Loan_in.html') {
F = 'source/NES_Loan_in.html';
}
else if (t == 'NES_ME_Scale.html') {
F = 'source/NES_ME_Scale.html';
}
else if (t == 'NES_SOC_Tracker.html') {
F = 'source/NES_SOC_Tracker.html';
}
else if (t == 'NES_Work_Order.html') {
F = 'source/NES_Work_Order.html';
}
else if (t == 'OHR_clearance_from.html') {
F = 'source/OHR_clearance_from.html';
} 
else if (t == 'OHR_Employee_Arrival_Form.html') {
F = 'source/OHR_Employee_Arrival_Form.html';
} 
else if (t == 'OHR_Leave_Application.html') {
F = 'source/OHR_Leave_Application.html';
} 
else if (t == 'OHR_Leave_Restriction_entry.html') {
F = 'source/OHR_Leave_Restriction_entry.html';
} 
else if (t == 'OHR_Pending_leave_application.html') {
F = 'source/OHR_Pending_leave_application.html';
} 
else if (t == 'OHR_Update_Leave_Application.html') {
F = 'source/OHR_Update_Leave_Application.html';
} 
else if (t == 'OHR_Update_Employee_Arrival_Form.html') {
F = 'source/OHR_Update_Employee_Arrival_Form.html';
} 
else if (t == 'Pension_Calculation_Sheet.html') {
F = 'source/Pension_Calculation_Sheet.html';
} 
else if (t == 'Pension_data_Sheet.html') {
F = 'source/Pension_data_Sheet.html';
}
else if (t == 'Pension_Designation_Master.html') {
F = 'source/Pension_Designation_Master.html';
}
else if (t == 'Pension_Form7_Entry.html') {
F = 'source/Pension_Form7_Entry.html';
}
else if (t == 'Pension_Form7_Entry_update.html') {
F = 'source/Pension_Form7_Entry_update.html';
}
else if (t == 'Pension_Form8_Entry.html') {
F = 'source/Pension_Form8_Entry.html';
}
else if (t == 'Pension_Form8_Entry_update.html') {
F = 'source/Pension_Form8_Entry_update.html';
}
else if (t == 'Pension_Form356_Retirement_Entry.html') {
F = 'source/Pension_Form356_Retirement_Entry.html';
}
else if (t == 'Pension_Form356_Retirement_Entry_update.html') {
F = 'source/Pension_Form356_Retirement_Entry_update.html';
}
else if (t == 'Pension_Group_Master.html') {
F = 'source/Pension_Group_Master.html';
}
else if (t == 'Pension_Personnel_Entry_Master.html') {
F = 'source/Pension_Personnel_Entry_Master.html';
}
else if (t == 'Pension_Update_Calculation_Sheet.html') {
F = 'source/Pension_Update_Calculation_Sheet.html';
}
else if (t == 'Pension_Update_data_Sheet.html') {
F = 'source/Pension_Update_data_Sheet.html';
}
else if (t == 'Pension_update_Personnel_Entry_Master.html') {
F = 'source/Pension_update_Personnel_Entry_Master.html';
}
else if (t == 'Pension_Weightage_Master.html') {
F = 'source/Pension_Weightage_Master.html';
}

}
catch (e) { }

F = unescape(F); 
webhelptop.whtopframe = window;
webhelptop.whtopframe.pageid = F;
var doc = webhelptop.whtopframe.document;
doc.gbShow=true;
doc.gstrFrameLastSetting = "";

