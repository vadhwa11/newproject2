package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_reaction_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_reaction_entry"
 */

public abstract class BaseBloodReactionEntry implements Serializable {

	public static String REF = "BloodReactionEntry";
	public static String PROP_TRANSFUSSION = "Transfussion";
	public static String PROP_CROSS_MATCHED_BY = "CrossMatchedBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME_COMPLETED = "TimeCompleted";
	public static String PROP_ISSUED_TO = "IssuedTo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CHEST = "Chest";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ISSUED_TIME = "IssuedTime";
	public static String PROP_URTICARLA = "Urticarla";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_BLOOD_BAG_NO = "BloodBagNo";
	public static String PROP_RACTION_DATE = "RactionDate";
	public static String PROP_ISSUED_DATE = "IssuedDate";
	public static String PROP_UNTOWARD_REACTION = "UntowardReaction";
	public static String PROP_SCREENING = "Screening";
	public static String PROP_WD_NO = "WdNo";
	public static String PROP_PAIN_BACK = "PainBack";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ANAPHYLAXIA = "Anaphylaxia";
	public static String PROP_ISSUED_BY = "IssuedBy";
	public static String PROP_RIGOR = "Rigor";
	public static String PROP_PYREXIA = "Pyrexia";
	public static String PROP_ANURIA = "Anuria";
	public static String PROP_ELSE_WEHERE = "ElseWehere";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ITCHING = "Itching";
	public static String PROP_HIN = "Hin";
	public static String PROP_HEAD = "Head";
	public static String PROP_DONOR_NAME = "DonorName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_TIME_STARTED = "TimeStarted";
	public static String PROP_HAEMOGLOBINURIA = "Haemoglobinuria";
	public static String PROP_RISE_TEMP = "RiseTemp";
	public static String PROP_FALL_OF_BP = "FallOfBp";
	public static String PROP_ID = "Id";
	public static String PROP_JAUNDICE = "Jaundice";
	public static String PROP_DATE_TRANSFUSSION = "DateTransfussion";

	// constructors
	public BaseBloodReactionEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodReactionEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date ractionDate;
	private java.lang.String bloodBagNo;
	private java.util.Date issuedDate;
	private java.lang.String issuedTime;
	private java.lang.String donorName;
	private java.lang.String issuedTo;
	private java.lang.String wdNo;
	private java.lang.String transfussion;
	private java.util.Date dateTransfussion;
	private java.lang.String timeStarted;
	private java.lang.String timeCompleted;
	private java.lang.String pyrexia;
	private java.lang.String fallOfBp;
	private java.lang.String itching;
	private java.lang.String urticarla;
	private java.lang.String painBack;
	private java.lang.String head;
	private java.lang.String chest;
	private java.lang.String elseWehere;
	private java.lang.String jaundice;
	private java.lang.String anuria;
	private java.lang.String untowardReaction;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String anaphylaxia;
	private java.lang.String haemoglobinuria;
	private java.lang.String rigor;
	private java.lang.String riseTemp;
	private java.lang.String screening;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmployee issuedBy;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee crossMatchedBy;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: raction_date
	 */
	public java.util.Date getRactionDate() {
		return ractionDate;
	}

	/**
	 * Set the value related to the column: raction_date
	 * 
	 * @param ractionDate
	 *            the raction_date value
	 */
	public void setRactionDate(java.util.Date ractionDate) {
		this.ractionDate = ractionDate;
	}

	/**
	 * Return the value associated with the column: blood_bag_no
	 */
	public java.lang.String getBloodBagNo() {
		return bloodBagNo;
	}

	/**
	 * Set the value related to the column: blood_bag_no
	 * 
	 * @param bloodBagNo
	 *            the blood_bag_no value
	 */
	public void setBloodBagNo(java.lang.String bloodBagNo) {
		this.bloodBagNo = bloodBagNo;
	}

	/**
	 * Return the value associated with the column: issued_date
	 */
	public java.util.Date getIssuedDate() {
		return issuedDate;
	}

	/**
	 * Set the value related to the column: issued_date
	 * 
	 * @param issuedDate
	 *            the issued_date value
	 */
	public void setIssuedDate(java.util.Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	/**
	 * Return the value associated with the column: issued_time
	 */
	public java.lang.String getIssuedTime() {
		return issuedTime;
	}

	/**
	 * Set the value related to the column: issued_time
	 * 
	 * @param issuedTime
	 *            the issued_time value
	 */
	public void setIssuedTime(java.lang.String issuedTime) {
		this.issuedTime = issuedTime;
	}

	/**
	 * Return the value associated with the column: donor_name
	 */
	public java.lang.String getDonorName() {
		return donorName;
	}

	/**
	 * Set the value related to the column: donor_name
	 * 
	 * @param donorName
	 *            the donor_name value
	 */
	public void setDonorName(java.lang.String donorName) {
		this.donorName = donorName;
	}

	/**
	 * Return the value associated with the column: issued_to
	 */
	public java.lang.String getIssuedTo() {
		return issuedTo;
	}

	/**
	 * Set the value related to the column: issued_to
	 * 
	 * @param issuedTo
	 *            the issued_to value
	 */
	public void setIssuedTo(java.lang.String issuedTo) {
		this.issuedTo = issuedTo;
	}

	/**
	 * Return the value associated with the column: wd_no
	 */
	public java.lang.String getWdNo() {
		return wdNo;
	}

	/**
	 * Set the value related to the column: wd_no
	 * 
	 * @param wdNo
	 *            the wd_no value
	 */
	public void setWdNo(java.lang.String wdNo) {
		this.wdNo = wdNo;
	}

	/**
	 * Return the value associated with the column: transfussion
	 */
	public java.lang.String getTransfussion() {
		return transfussion;
	}

	/**
	 * Set the value related to the column: transfussion
	 * 
	 * @param transfussion
	 *            the transfussion value
	 */
	public void setTransfussion(java.lang.String transfussion) {
		this.transfussion = transfussion;
	}

	/**
	 * Return the value associated with the column: date_transfussion
	 */
	public java.util.Date getDateTransfussion() {
		return dateTransfussion;
	}

	/**
	 * Set the value related to the column: date_transfussion
	 * 
	 * @param dateTransfussion
	 *            the date_transfussion value
	 */
	public void setDateTransfussion(java.util.Date dateTransfussion) {
		this.dateTransfussion = dateTransfussion;
	}

	/**
	 * Return the value associated with the column: time_started
	 */
	public java.lang.String getTimeStarted() {
		return timeStarted;
	}

	/**
	 * Set the value related to the column: time_started
	 * 
	 * @param timeStarted
	 *            the time_started value
	 */
	public void setTimeStarted(java.lang.String timeStarted) {
		this.timeStarted = timeStarted;
	}

	/**
	 * Return the value associated with the column: time_completed
	 */
	public java.lang.String getTimeCompleted() {
		return timeCompleted;
	}

	/**
	 * Set the value related to the column: time_completed
	 * 
	 * @param timeCompleted
	 *            the time_completed value
	 */
	public void setTimeCompleted(java.lang.String timeCompleted) {
		this.timeCompleted = timeCompleted;
	}

	/**
	 * Return the value associated with the column: pyrexia
	 */
	public java.lang.String getPyrexia() {
		return pyrexia;
	}

	/**
	 * Set the value related to the column: pyrexia
	 * 
	 * @param pyrexia
	 *            the pyrexia value
	 */
	public void setPyrexia(java.lang.String pyrexia) {
		this.pyrexia = pyrexia;
	}

	/**
	 * Return the value associated with the column: fall_of_bp
	 */
	public java.lang.String getFallOfBp() {
		return fallOfBp;
	}

	/**
	 * Set the value related to the column: fall_of_bp
	 * 
	 * @param fallOfBp
	 *            the fall_of_bp value
	 */
	public void setFallOfBp(java.lang.String fallOfBp) {
		this.fallOfBp = fallOfBp;
	}

	/**
	 * Return the value associated with the column: itching
	 */
	public java.lang.String getItching() {
		return itching;
	}

	/**
	 * Set the value related to the column: itching
	 * 
	 * @param itching
	 *            the itching value
	 */
	public void setItching(java.lang.String itching) {
		this.itching = itching;
	}

	/**
	 * Return the value associated with the column: urticarla
	 */
	public java.lang.String getUrticarla() {
		return urticarla;
	}

	/**
	 * Set the value related to the column: urticarla
	 * 
	 * @param urticarla
	 *            the urticarla value
	 */
	public void setUrticarla(java.lang.String urticarla) {
		this.urticarla = urticarla;
	}

	/**
	 * Return the value associated with the column: pain_back
	 */
	public java.lang.String getPainBack() {
		return painBack;
	}

	/**
	 * Set the value related to the column: pain_back
	 * 
	 * @param painBack
	 *            the pain_back value
	 */
	public void setPainBack(java.lang.String painBack) {
		this.painBack = painBack;
	}

	/**
	 * Return the value associated with the column: head
	 */
	public java.lang.String getHead() {
		return head;
	}

	/**
	 * Set the value related to the column: head
	 * 
	 * @param head
	 *            the head value
	 */
	public void setHead(java.lang.String head) {
		this.head = head;
	}

	/**
	 * Return the value associated with the column: chest
	 */
	public java.lang.String getChest() {
		return chest;
	}

	/**
	 * Set the value related to the column: chest
	 * 
	 * @param chest
	 *            the chest value
	 */
	public void setChest(java.lang.String chest) {
		this.chest = chest;
	}

	/**
	 * Return the value associated with the column: else_wehere
	 */
	public java.lang.String getElseWehere() {
		return elseWehere;
	}

	/**
	 * Set the value related to the column: else_wehere
	 * 
	 * @param elseWehere
	 *            the else_wehere value
	 */
	public void setElseWehere(java.lang.String elseWehere) {
		this.elseWehere = elseWehere;
	}

	/**
	 * Return the value associated with the column: jaundice
	 */
	public java.lang.String getJaundice() {
		return jaundice;
	}

	/**
	 * Set the value related to the column: jaundice
	 * 
	 * @param jaundice
	 *            the jaundice value
	 */
	public void setJaundice(java.lang.String jaundice) {
		this.jaundice = jaundice;
	}

	/**
	 * Return the value associated with the column: anuria
	 */
	public java.lang.String getAnuria() {
		return anuria;
	}

	/**
	 * Set the value related to the column: anuria
	 * 
	 * @param anuria
	 *            the anuria value
	 */
	public void setAnuria(java.lang.String anuria) {
		this.anuria = anuria;
	}

	/**
	 * Return the value associated with the column: untoward_reaction
	 */
	public java.lang.String getUntowardReaction() {
		return untowardReaction;
	}

	/**
	 * Set the value related to the column: untoward_reaction
	 * 
	 * @param untowardReaction
	 *            the untoward_reaction value
	 */
	public void setUntowardReaction(java.lang.String untowardReaction) {
		this.untowardReaction = untowardReaction;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: anaphylaxia
	 */
	public java.lang.String getAnaphylaxia() {
		return anaphylaxia;
	}

	/**
	 * Set the value related to the column: anaphylaxia
	 * 
	 * @param anaphylaxia
	 *            the anaphylaxia value
	 */
	public void setAnaphylaxia(java.lang.String anaphylaxia) {
		this.anaphylaxia = anaphylaxia;
	}

	/**
	 * Return the value associated with the column: haemoglobinuria
	 */
	public java.lang.String getHaemoglobinuria() {
		return haemoglobinuria;
	}

	/**
	 * Set the value related to the column: haemoglobinuria
	 * 
	 * @param haemoglobinuria
	 *            the haemoglobinuria value
	 */
	public void setHaemoglobinuria(java.lang.String haemoglobinuria) {
		this.haemoglobinuria = haemoglobinuria;
	}

	/**
	 * Return the value associated with the column: rigor
	 */
	public java.lang.String getRigor() {
		return rigor;
	}

	/**
	 * Set the value related to the column: rigor
	 * 
	 * @param rigor
	 *            the rigor value
	 */
	public void setRigor(java.lang.String rigor) {
		this.rigor = rigor;
	}

	/**
	 * Return the value associated with the column: rise_temp
	 */
	public java.lang.String getRiseTemp() {
		return riseTemp;
	}

	/**
	 * Set the value related to the column: rise_temp
	 * 
	 * @param riseTemp
	 *            the rise_temp value
	 */
	public void setRiseTemp(java.lang.String riseTemp) {
		this.riseTemp = riseTemp;
	}

	/**
	 * Return the value associated with the column: screening
	 */
	public java.lang.String getScreening() {
		return screening;
	}

	/**
	 * Set the value related to the column: screening
	 * 
	 * @param screening
	 *            the screening value
	 */
	public void setScreening(java.lang.String screening) {
		this.screening = screening;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * 
	 * @param bloodGroup
	 *            the blood_group_id value
	 */
	public void setBloodGroup(jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedBy() {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * 
	 * @param issuedBy
	 *            the issued_by value
	 */
	public void setIssuedBy(jkt.hms.masters.business.MasEmployee issuedBy) {
		this.issuedBy = issuedBy;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: cross_matched_by
	 */
	public jkt.hms.masters.business.MasEmployee getCrossMatchedBy() {
		return crossMatchedBy;
	}

	/**
	 * Set the value related to the column: cross_matched_by
	 * 
	 * @param crossMatchedBy
	 *            the cross_matched_by value
	 */
	public void setCrossMatchedBy(
			jkt.hms.masters.business.MasEmployee crossMatchedBy) {
		this.crossMatchedBy = crossMatchedBy;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodReactionEntry))
			return false;
		else {
			jkt.hms.masters.business.BloodReactionEntry bloodReactionEntry = (jkt.hms.masters.business.BloodReactionEntry) obj;
			if (null == this.getId() || null == bloodReactionEntry.getId())
				return false;
			else
				return (this.getId().equals(bloodReactionEntry.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}