package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mis_fatal_tracking table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mis_fatal_tracking"
 */

public abstract class BaseMisFatalTracking  implements Serializable {

	public static String REF = "MisFatalTracking";
	public static String PROP_DATEOF_POST_REC_REM = "DateofPostRecRem";
	public static String PROP_DATEOF_POST_REC = "DateofPostRec";
	public static String PROP_SENIOR_ADVISOR3_REM = "SeniorAdvisor3Rem";
	public static String PROP_POSTMORTEM = "Postmortem";
	public static String PROP_FATAL_DOCUMENT_HEADER = "FatalDocumentHeader";
	public static String PROP_LATEST_STATUS = "LatestStatus";
	public static String PROP_STATAS_WARD = "StatasWard";
	public static String PROP_LATEST_STATUS_DATE = "LatestStatusDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DESPATCH_COMMANDANT = "DespatchCommandant";
	public static String PROP_REC_SPL_OP_REM = "RecSplOpRem";
	public static String PROP_DATEOF_DEATH = "DateofDeath";
	public static String PROP_COMMAN_REMARKS = "CommanRemarks";
	public static String PROP_HOD_PERUSAL = "HodPerusal";
	public static String PROP_PATOLOGY_HEAD_REM = "PatologyHeadRem";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SENIOR_ADVISOR2_REM = "SeniorAdvisor2Rem";
	public static String PROP_COMMAN_REMARKS_REM = "CommanRemarksRem";
	public static String PROP_DATEOF_DEATH_REM = "DateofDeathRem";
	public static String PROP_MOIC_WARD_REM = "MoicWardRem";
	public static String PROP_MOIC_WARD = "MoicWard";
	public static String PROP_LATEST_STATUS_REMARKS = "LatestStatusRemarks";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PATOLOGY_HEAD = "PatologyHead";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SENIOR_ADVISOR1_REM = "SeniorAdvisor1Rem";
	public static String PROP_SENIOR_ADVISOR4 = "SeniorAdvisor4";
	public static String PROP_WARD_MASTER_REM = "WardMasterRem";
	public static String PROP_HO_SPLCONCE_REM = "HoSplconceRem";
	public static String PROP_SENIOR_ADVISOR1 = "SeniorAdvisor1";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_SENIOR_ADVISOR3 = "SeniorAdvisor3";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SENIOR_ADVISOR4_REM = "SeniorAdvisor4Rem";
	public static String PROP_SENIOR_ADVISOR2 = "SeniorAdvisor2";
	public static String PROP_DESPATCH_COMMANDANT_REM = "DespatchCommandantRem";
	public static String PROP_HOD_PERUSAL_REM = "HodPerusalRem";
	public static String PROP_WARD_MASTER = "WardMaster";
	public static String PROP_REC_SPL_OP_DATE = "RecSplOpDate";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_HO_SPLCONCE_DATE = "HoSplconceDate";
	public static String PROP_STATAS_WARD_REM = "StatasWardRem";
	public static String PROP_POSTMORTEM_REM = "PostmortemRem";


	// constructors
	public BaseMisFatalTracking () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisFatalTracking (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateofDeath;
	private java.lang.String dateofDeathRem;
	private java.lang.String postmortem;
	private java.lang.String postmortemRem;
	private java.util.Date dateofPostRec;
	private java.lang.String dateofPostRecRem;
	private java.util.Date hoSplconceDate;
	private java.lang.String hoSplconceRem;
	private java.util.Date recSplOpDate;
	private java.lang.String recSplOpRem;
	private java.util.Date wardMaster;
	private java.lang.String wardMasterRem;
	private java.util.Date moicWard;
	private java.lang.String moicWardRem;
	private java.util.Date hodPerusal;
	private java.lang.String hodPerusalRem;
	private java.util.Date statasWard;
	private java.lang.String statasWardRem;
	private java.util.Date commanRemarks;
	private java.lang.String commanRemarksRem;
	private java.util.Date patologyHead;
	private java.lang.String patologyHeadRem;
	private java.util.Date seniorAdvisor1;
	private java.lang.String seniorAdvisor1Rem;
	private java.util.Date seniorAdvisor2;
	private java.lang.String seniorAdvisor2Rem;
	private java.util.Date seniorAdvisor3;
	private java.lang.String seniorAdvisor3Rem;
	private java.util.Date seniorAdvisor4;
	private java.lang.String seniorAdvisor4Rem;
	private java.util.Date despatchCommandant;
	private java.lang.String despatchCommandantRem;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String latestStatus;
	private java.util.Date latestStatusDate;
	private java.lang.String latestStatusRemarks;
	private java.lang.String serviceNo;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.FatalDocumentHeader fatalDocumentHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mis_fatal_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: dateof_death
	 */
	public java.util.Date getDateofDeath () {
		return dateofDeath;
	}

	/**
	 * Set the value related to the column: dateof_death
	 * @param dateofDeath the dateof_death value
	 */
	public void setDateofDeath (java.util.Date dateofDeath) {
		this.dateofDeath = dateofDeath;
	}



	/**
	 * Return the value associated with the column: dateof_death_rem
	 */
	public java.lang.String getDateofDeathRem () {
		return dateofDeathRem;
	}

	/**
	 * Set the value related to the column: dateof_death_rem
	 * @param dateofDeathRem the dateof_death_rem value
	 */
	public void setDateofDeathRem (java.lang.String dateofDeathRem) {
		this.dateofDeathRem = dateofDeathRem;
	}



	/**
	 * Return the value associated with the column: postmortem
	 */
	public java.lang.String getPostmortem () {
		return postmortem;
	}

	/**
	 * Set the value related to the column: postmortem
	 * @param postmortem the postmortem value
	 */
	public void setPostmortem (java.lang.String postmortem) {
		this.postmortem = postmortem;
	}



	/**
	 * Return the value associated with the column: postmortem_rem
	 */
	public java.lang.String getPostmortemRem () {
		return postmortemRem;
	}

	/**
	 * Set the value related to the column: postmortem_rem
	 * @param postmortemRem the postmortem_rem value
	 */
	public void setPostmortemRem (java.lang.String postmortemRem) {
		this.postmortemRem = postmortemRem;
	}



	/**
	 * Return the value associated with the column: dateof_post_rec
	 */
	public java.util.Date getDateofPostRec () {
		return dateofPostRec;
	}

	/**
	 * Set the value related to the column: dateof_post_rec
	 * @param dateofPostRec the dateof_post_rec value
	 */
	public void setDateofPostRec (java.util.Date dateofPostRec) {
		this.dateofPostRec = dateofPostRec;
	}



	/**
	 * Return the value associated with the column: dateof_post_rec_rem
	 */
	public java.lang.String getDateofPostRecRem () {
		return dateofPostRecRem;
	}

	/**
	 * Set the value related to the column: dateof_post_rec_rem
	 * @param dateofPostRecRem the dateof_post_rec_rem value
	 */
	public void setDateofPostRecRem (java.lang.String dateofPostRecRem) {
		this.dateofPostRecRem = dateofPostRecRem;
	}



	/**
	 * Return the value associated with the column: ho_splconce_date
	 */
	public java.util.Date getHoSplconceDate () {
		return hoSplconceDate;
	}

	/**
	 * Set the value related to the column: ho_splconce_date
	 * @param hoSplconceDate the ho_splconce_date value
	 */
	public void setHoSplconceDate (java.util.Date hoSplconceDate) {
		this.hoSplconceDate = hoSplconceDate;
	}



	/**
	 * Return the value associated with the column: ho_splconce_rem
	 */
	public java.lang.String getHoSplconceRem () {
		return hoSplconceRem;
	}

	/**
	 * Set the value related to the column: ho_splconce_rem
	 * @param hoSplconceRem the ho_splconce_rem value
	 */
	public void setHoSplconceRem (java.lang.String hoSplconceRem) {
		this.hoSplconceRem = hoSplconceRem;
	}



	/**
	 * Return the value associated with the column: rec_spl_op_date
	 */
	public java.util.Date getRecSplOpDate () {
		return recSplOpDate;
	}

	/**
	 * Set the value related to the column: rec_spl_op_date
	 * @param recSplOpDate the rec_spl_op_date value
	 */
	public void setRecSplOpDate (java.util.Date recSplOpDate) {
		this.recSplOpDate = recSplOpDate;
	}



	/**
	 * Return the value associated with the column: rec_spl_op_rem
	 */
	public java.lang.String getRecSplOpRem () {
		return recSplOpRem;
	}

	/**
	 * Set the value related to the column: rec_spl_op_rem
	 * @param recSplOpRem the rec_spl_op_rem value
	 */
	public void setRecSplOpRem (java.lang.String recSplOpRem) {
		this.recSplOpRem = recSplOpRem;
	}



	/**
	 * Return the value associated with the column: ward_master
	 */
	public java.util.Date getWardMaster () {
		return wardMaster;
	}

	/**
	 * Set the value related to the column: ward_master
	 * @param wardMaster the ward_master value
	 */
	public void setWardMaster (java.util.Date wardMaster) {
		this.wardMaster = wardMaster;
	}



	/**
	 * Return the value associated with the column: ward_master_rem
	 */
	public java.lang.String getWardMasterRem () {
		return wardMasterRem;
	}

	/**
	 * Set the value related to the column: ward_master_rem
	 * @param wardMasterRem the ward_master_rem value
	 */
	public void setWardMasterRem (java.lang.String wardMasterRem) {
		this.wardMasterRem = wardMasterRem;
	}



	/**
	 * Return the value associated with the column: moic_ward
	 */
	public java.util.Date getMoicWard () {
		return moicWard;
	}

	/**
	 * Set the value related to the column: moic_ward
	 * @param moicWard the moic_ward value
	 */
	public void setMoicWard (java.util.Date moicWard) {
		this.moicWard = moicWard;
	}



	/**
	 * Return the value associated with the column: moic_ward_rem
	 */
	public java.lang.String getMoicWardRem () {
		return moicWardRem;
	}

	/**
	 * Set the value related to the column: moic_ward_rem
	 * @param moicWardRem the moic_ward_rem value
	 */
	public void setMoicWardRem (java.lang.String moicWardRem) {
		this.moicWardRem = moicWardRem;
	}



	/**
	 * Return the value associated with the column: hod_perusal
	 */
	public java.util.Date getHodPerusal () {
		return hodPerusal;
	}

	/**
	 * Set the value related to the column: hod_perusal
	 * @param hodPerusal the hod_perusal value
	 */
	public void setHodPerusal (java.util.Date hodPerusal) {
		this.hodPerusal = hodPerusal;
	}



	/**
	 * Return the value associated with the column: hod_perusal_rem
	 */
	public java.lang.String getHodPerusalRem () {
		return hodPerusalRem;
	}

	/**
	 * Set the value related to the column: hod_perusal_rem
	 * @param hodPerusalRem the hod_perusal_rem value
	 */
	public void setHodPerusalRem (java.lang.String hodPerusalRem) {
		this.hodPerusalRem = hodPerusalRem;
	}



	/**
	 * Return the value associated with the column: statas_ward
	 */
	public java.util.Date getStatasWard () {
		return statasWard;
	}

	/**
	 * Set the value related to the column: statas_ward
	 * @param statasWard the statas_ward value
	 */
	public void setStatasWard (java.util.Date statasWard) {
		this.statasWard = statasWard;
	}



	/**
	 * Return the value associated with the column: statas_ward_rem
	 */
	public java.lang.String getStatasWardRem () {
		return statasWardRem;
	}

	/**
	 * Set the value related to the column: statas_ward_rem
	 * @param statasWardRem the statas_ward_rem value
	 */
	public void setStatasWardRem (java.lang.String statasWardRem) {
		this.statasWardRem = statasWardRem;
	}



	/**
	 * Return the value associated with the column: comman_remarks
	 */
	public java.util.Date getCommanRemarks () {
		return commanRemarks;
	}

	/**
	 * Set the value related to the column: comman_remarks
	 * @param commanRemarks the comman_remarks value
	 */
	public void setCommanRemarks (java.util.Date commanRemarks) {
		this.commanRemarks = commanRemarks;
	}



	/**
	 * Return the value associated with the column: comman_remarks_rem
	 */
	public java.lang.String getCommanRemarksRem () {
		return commanRemarksRem;
	}

	/**
	 * Set the value related to the column: comman_remarks_rem
	 * @param commanRemarksRem the comman_remarks_rem value
	 */
	public void setCommanRemarksRem (java.lang.String commanRemarksRem) {
		this.commanRemarksRem = commanRemarksRem;
	}



	/**
	 * Return the value associated with the column: patology_head
	 */
	public java.util.Date getPatologyHead () {
		return patologyHead;
	}

	/**
	 * Set the value related to the column: patology_head
	 * @param patologyHead the patology_head value
	 */
	public void setPatologyHead (java.util.Date patologyHead) {
		this.patologyHead = patologyHead;
	}



	/**
	 * Return the value associated with the column: patology_head_rem
	 */
	public java.lang.String getPatologyHeadRem () {
		return patologyHeadRem;
	}

	/**
	 * Set the value related to the column: patology_head_rem
	 * @param patologyHeadRem the patology_head_rem value
	 */
	public void setPatologyHeadRem (java.lang.String patologyHeadRem) {
		this.patologyHeadRem = patologyHeadRem;
	}



	/**
	 * Return the value associated with the column: senior_advisor1
	 */
	public java.util.Date getSeniorAdvisor1 () {
		return seniorAdvisor1;
	}

	/**
	 * Set the value related to the column: senior_advisor1
	 * @param seniorAdvisor1 the senior_advisor1 value
	 */
	public void setSeniorAdvisor1 (java.util.Date seniorAdvisor1) {
		this.seniorAdvisor1 = seniorAdvisor1;
	}



	/**
	 * Return the value associated with the column: senior_advisor1_rem
	 */
	public java.lang.String getSeniorAdvisor1Rem () {
		return seniorAdvisor1Rem;
	}

	/**
	 * Set the value related to the column: senior_advisor1_rem
	 * @param seniorAdvisor1Rem the senior_advisor1_rem value
	 */
	public void setSeniorAdvisor1Rem (java.lang.String seniorAdvisor1Rem) {
		this.seniorAdvisor1Rem = seniorAdvisor1Rem;
	}



	/**
	 * Return the value associated with the column: senior_advisor2
	 */
	public java.util.Date getSeniorAdvisor2 () {
		return seniorAdvisor2;
	}

	/**
	 * Set the value related to the column: senior_advisor2
	 * @param seniorAdvisor2 the senior_advisor2 value
	 */
	public void setSeniorAdvisor2 (java.util.Date seniorAdvisor2) {
		this.seniorAdvisor2 = seniorAdvisor2;
	}



	/**
	 * Return the value associated with the column: senior_advisor2_rem
	 */
	public java.lang.String getSeniorAdvisor2Rem () {
		return seniorAdvisor2Rem;
	}

	/**
	 * Set the value related to the column: senior_advisor2_rem
	 * @param seniorAdvisor2Rem the senior_advisor2_rem value
	 */
	public void setSeniorAdvisor2Rem (java.lang.String seniorAdvisor2Rem) {
		this.seniorAdvisor2Rem = seniorAdvisor2Rem;
	}



	/**
	 * Return the value associated with the column: senior_advisor3
	 */
	public java.util.Date getSeniorAdvisor3 () {
		return seniorAdvisor3;
	}

	/**
	 * Set the value related to the column: senior_advisor3
	 * @param seniorAdvisor3 the senior_advisor3 value
	 */
	public void setSeniorAdvisor3 (java.util.Date seniorAdvisor3) {
		this.seniorAdvisor3 = seniorAdvisor3;
	}



	/**
	 * Return the value associated with the column: senior_advisor3_rem
	 */
	public java.lang.String getSeniorAdvisor3Rem () {
		return seniorAdvisor3Rem;
	}

	/**
	 * Set the value related to the column: senior_advisor3_rem
	 * @param seniorAdvisor3Rem the senior_advisor3_rem value
	 */
	public void setSeniorAdvisor3Rem (java.lang.String seniorAdvisor3Rem) {
		this.seniorAdvisor3Rem = seniorAdvisor3Rem;
	}



	/**
	 * Return the value associated with the column: senior_advisor4
	 */
	public java.util.Date getSeniorAdvisor4 () {
		return seniorAdvisor4;
	}

	/**
	 * Set the value related to the column: senior_advisor4
	 * @param seniorAdvisor4 the senior_advisor4 value
	 */
	public void setSeniorAdvisor4 (java.util.Date seniorAdvisor4) {
		this.seniorAdvisor4 = seniorAdvisor4;
	}



	/**
	 * Return the value associated with the column: senior_advisor4_rem
	 */
	public java.lang.String getSeniorAdvisor4Rem () {
		return seniorAdvisor4Rem;
	}

	/**
	 * Set the value related to the column: senior_advisor4_rem
	 * @param seniorAdvisor4Rem the senior_advisor4_rem value
	 */
	public void setSeniorAdvisor4Rem (java.lang.String seniorAdvisor4Rem) {
		this.seniorAdvisor4Rem = seniorAdvisor4Rem;
	}



	/**
	 * Return the value associated with the column: despatch_commandant
	 */
	public java.util.Date getDespatchCommandant () {
		return despatchCommandant;
	}

	/**
	 * Set the value related to the column: despatch_commandant
	 * @param despatchCommandant the despatch_commandant value
	 */
	public void setDespatchCommandant (java.util.Date despatchCommandant) {
		this.despatchCommandant = despatchCommandant;
	}



	/**
	 * Return the value associated with the column: despatch_commandant_rem
	 */
	public java.lang.String getDespatchCommandantRem () {
		return despatchCommandantRem;
	}

	/**
	 * Set the value related to the column: despatch_commandant_rem
	 * @param despatchCommandantRem the despatch_commandant_rem value
	 */
	public void setDespatchCommandantRem (java.lang.String despatchCommandantRem) {
		this.despatchCommandantRem = despatchCommandantRem;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: latest_status
	 */
	public java.lang.String getLatestStatus () {
		return latestStatus;
	}

	/**
	 * Set the value related to the column: latest_status
	 * @param latestStatus the latest_status value
	 */
	public void setLatestStatus (java.lang.String latestStatus) {
		this.latestStatus = latestStatus;
	}



	/**
	 * Return the value associated with the column: latest_status_date
	 */
	public java.util.Date getLatestStatusDate () {
		return latestStatusDate;
	}

	/**
	 * Set the value related to the column: latest_status_date
	 * @param latestStatusDate the latest_status_date value
	 */
	public void setLatestStatusDate (java.util.Date latestStatusDate) {
		this.latestStatusDate = latestStatusDate;
	}



	/**
	 * Return the value associated with the column: latest_status_remarks
	 */
	public java.lang.String getLatestStatusRemarks () {
		return latestStatusRemarks;
	}

	/**
	 * Set the value related to the column: latest_status_remarks
	 * @param latestStatusRemarks the latest_status_remarks value
	 */
	public void setLatestStatusRemarks (java.lang.String latestStatusRemarks) {
		this.latestStatusRemarks = latestStatusRemarks;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: fatal_document_id
	 */
	public jkt.hms.masters.business.FatalDocumentHeader getFatalDocumentHeader () {
		return fatalDocumentHeader;
	}

	/**
	 * Set the value related to the column: fatal_document_id
	 * @param fatalDocumentHeader the fatal_document_id value
	 */
	public void setFatalDocumentHeader (jkt.hms.masters.business.FatalDocumentHeader fatalDocumentHeader) {
		this.fatalDocumentHeader = fatalDocumentHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisFatalTracking)) return false;
		else {
			jkt.hms.masters.business.MisFatalTracking misFatalTracking = (jkt.hms.masters.business.MisFatalTracking) obj;
			if (null == this.getId() || null == misFatalTracking.getId()) return false;
			else return (this.getId().equals(misFatalTracking.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}