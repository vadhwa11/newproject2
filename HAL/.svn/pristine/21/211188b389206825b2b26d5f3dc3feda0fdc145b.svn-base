package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_account table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_account"
 */

public abstract class BaseFaMasAccount  implements Serializable {

	public static String REF = "FaMasAccount";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUB_LEDGER = "SubLedger";
	public static String PROP_BANK = "Bank";
	public static String PROP_OP_BALANCE_CR = "OpBalanceCr";
	public static String PROP_PARENT = "Parent";
	public static String PROP_OP_BALANCE_DR = "OpBalanceDr";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_ACCOUNT_SUB_GROUP_CODE = "AccountSubGroupCode";
	public static String PROP_YTD_AMOUNT_DR = "YtdAmountDr";
	public static String PROP_ACC_DESC = "AccDesc";
	public static String PROP_CL_BALANCE_DR = "ClBalanceDr";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CL_BALANCE_CR = "ClBalanceCr";
	public static String PROP_ACCOUNT_RIGHT = "AccountRight";
	public static String PROP_PARTY_ID = "PartyId";
	public static String PROP_ACC_CODE = "AccCode";
	public static String PROP_YTD_AMOUNT_CR = "YtdAmountCr";
	public static String PROP_SCHEDULE = "Schedule";
	public static String PROP_PARENT_STATUS = "ParentStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ACCOUNT_SUB_GROUP = "AccountSubGroup";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseFaMasAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasAccount (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accCode;
	private java.lang.String accDesc;
	private java.lang.Integer accountSubGroupCode;
	private java.math.BigDecimal ytdAmountDr;
	private java.lang.String status;
	private java.lang.String accountRight;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal ytdAmountCr;
	private java.math.BigDecimal opBalanceDr;
	private java.math.BigDecimal opBalanceCr;
	private java.math.BigDecimal clBalanceDr;
	private java.math.BigDecimal clBalanceCr;
	private java.lang.Integer partyId;
	private java.lang.String parentStatus;
	private java.lang.String subLedger;
	private java.lang.Integer schedule;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.FaMasAccountSubGroup accountSubGroup;
	private jkt.hms.masters.business.FaMasAccount parent;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails;
	private java.util.Set<jkt.hms.masters.business.FaMasSubLed> faMasSubLeds;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="acc_id"
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
	 * Return the value associated with the column: acc_code
	 */
	public java.lang.Integer getAccCode () {
		return accCode;
	}

	/**
	 * Set the value related to the column: acc_code
	 * @param accCode the acc_code value
	 */
	public void setAccCode (java.lang.Integer accCode) {
		this.accCode = accCode;
	}



	/**
	 * Return the value associated with the column: acc_desc
	 */
	public java.lang.String getAccDesc () {
		return accDesc;
	}

	/**
	 * Set the value related to the column: acc_desc
	 * @param accDesc the acc_desc value
	 */
	public void setAccDesc (java.lang.String accDesc) {
		this.accDesc = accDesc;
	}



	/**
	 * Return the value associated with the column: account_sub_group_code
	 */
	public java.lang.Integer getAccountSubGroupCode () {
		return accountSubGroupCode;
	}

	/**
	 * Set the value related to the column: account_sub_group_code
	 * @param accountSubGroupCode the account_sub_group_code value
	 */
	public void setAccountSubGroupCode (java.lang.Integer accountSubGroupCode) {
		this.accountSubGroupCode = accountSubGroupCode;
	}



	/**
	 * Return the value associated with the column: ytd_amount_dr
	 */
	public java.math.BigDecimal getYtdAmountDr () {
		return ytdAmountDr;
	}

	/**
	 * Set the value related to the column: ytd_amount_dr
	 * @param ytdAmountDr the ytd_amount_dr value
	 */
	public void setYtdAmountDr (java.math.BigDecimal ytdAmountDr) {
		this.ytdAmountDr = ytdAmountDr;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: account_right
	 */
	public java.lang.String getAccountRight () {
		return accountRight;
	}

	/**
	 * Set the value related to the column: account_right
	 * @param accountRight the account_right value
	 */
	public void setAccountRight (java.lang.String accountRight) {
		this.accountRight = accountRight;
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
	 * Return the value associated with the column: ytd_amount_cr
	 */
	public java.math.BigDecimal getYtdAmountCr () {
		return ytdAmountCr;
	}

	/**
	 * Set the value related to the column: ytd_amount_cr
	 * @param ytdAmountCr the ytd_amount_cr value
	 */
	public void setYtdAmountCr (java.math.BigDecimal ytdAmountCr) {
		this.ytdAmountCr = ytdAmountCr;
	}



	/**
	 * Return the value associated with the column: op_balance_dr
	 */
	public java.math.BigDecimal getOpBalanceDr () {
		return opBalanceDr;
	}

	/**
	 * Set the value related to the column: op_balance_dr
	 * @param opBalanceDr the op_balance_dr value
	 */
	public void setOpBalanceDr (java.math.BigDecimal opBalanceDr) {
		this.opBalanceDr = opBalanceDr;
	}



	/**
	 * Return the value associated with the column: op_balance_cr
	 */
	public java.math.BigDecimal getOpBalanceCr () {
		return opBalanceCr;
	}

	/**
	 * Set the value related to the column: op_balance_cr
	 * @param opBalanceCr the op_balance_cr value
	 */
	public void setOpBalanceCr (java.math.BigDecimal opBalanceCr) {
		this.opBalanceCr = opBalanceCr;
	}



	/**
	 * Return the value associated with the column: cl_balance_dr
	 */
	public java.math.BigDecimal getClBalanceDr () {
		return clBalanceDr;
	}

	/**
	 * Set the value related to the column: cl_balance_dr
	 * @param clBalanceDr the cl_balance_dr value
	 */
	public void setClBalanceDr (java.math.BigDecimal clBalanceDr) {
		this.clBalanceDr = clBalanceDr;
	}



	/**
	 * Return the value associated with the column: cl_balance_cr
	 */
	public java.math.BigDecimal getClBalanceCr () {
		return clBalanceCr;
	}

	/**
	 * Set the value related to the column: cl_balance_cr
	 * @param clBalanceCr the cl_balance_cr value
	 */
	public void setClBalanceCr (java.math.BigDecimal clBalanceCr) {
		this.clBalanceCr = clBalanceCr;
	}



	/**
	 * Return the value associated with the column: party_id
	 */
	public java.lang.Integer getPartyId () {
		return partyId;
	}

	/**
	 * Set the value related to the column: party_id
	 * @param partyId the party_id value
	 */
	public void setPartyId (java.lang.Integer partyId) {
		this.partyId = partyId;
	}



	/**
	 * Return the value associated with the column: parent_status
	 */
	public java.lang.String getParentStatus () {
		return parentStatus;
	}

	/**
	 * Set the value related to the column: parent_status
	 * @param parentStatus the parent_status value
	 */
	public void setParentStatus (java.lang.String parentStatus) {
		this.parentStatus = parentStatus;
	}



	/**
	 * Return the value associated with the column: sub_ledger
	 */
	public java.lang.String getSubLedger () {
		return subLedger;
	}

	/**
	 * Set the value related to the column: sub_ledger
	 * @param subLedger the sub_ledger value
	 */
	public void setSubLedger (java.lang.String subLedger) {
		this.subLedger = subLedger;
	}



	/**
	 * Return the value associated with the column: schedule
	 */
	public java.lang.Integer getSchedule () {
		return schedule;
	}

	/**
	 * Set the value related to the column: schedule
	 * @param schedule the schedule value
	 */
	public void setSchedule (java.lang.Integer schedule) {
		this.schedule = schedule;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param fYear the f_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: account_sub_group_id
	 */
	public jkt.hms.masters.business.FaMasAccountSubGroup getAccountSubGroup () {
		return accountSubGroup;
	}

	/**
	 * Set the value related to the column: account_sub_group_id
	 * @param accountSubGroup the account_sub_group_id value
	 */
	public void setAccountSubGroup (jkt.hms.masters.business.FaMasAccountSubGroup accountSubGroup) {
		this.accountSubGroup = accountSubGroup;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public jkt.hms.masters.business.FaMasAccount getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parent the parent_id value
	 */
	public void setParent (jkt.hms.masters.business.FaMasAccount parent) {
		this.parent = parent;
	}



	/**
	 * Return the value associated with the column: FaVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherDetails> getFaVoucherDetails () {
		return faVoucherDetails;
	}

	/**
	 * Set the value related to the column: FaVoucherDetails
	 * @param faVoucherDetails the FaVoucherDetails value
	 */
	public void setFaVoucherDetails (java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails) {
		this.faVoucherDetails = faVoucherDetails;
	}

	public void addToFaVoucherDetails (jkt.hms.masters.business.FaVoucherDetails faVoucherDetails) {
		if (null == getFaVoucherDetails()) setFaVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherDetails>());
		getFaVoucherDetails().add(faVoucherDetails);
	}



	/**
	 * Return the value associated with the column: FaMasSubLeds
	 */
	public java.util.Set<jkt.hms.masters.business.FaMasSubLed> getFaMasSubLeds () {
		return faMasSubLeds;
	}

	/**
	 * Set the value related to the column: FaMasSubLeds
	 * @param faMasSubLeds the FaMasSubLeds value
	 */
	public void setFaMasSubLeds (java.util.Set<jkt.hms.masters.business.FaMasSubLed> faMasSubLeds) {
		this.faMasSubLeds = faMasSubLeds;
	}

	public void addToFaMasSubLeds (jkt.hms.masters.business.FaMasSubLed faMasSubLed) {
		if (null == getFaMasSubLeds()) setFaMasSubLeds(new java.util.TreeSet<jkt.hms.masters.business.FaMasSubLed>());
		getFaMasSubLeds().add(faMasSubLed);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasAccount)) return false;
		else {
			jkt.hms.masters.business.FaMasAccount faMasAccount = (jkt.hms.masters.business.FaMasAccount) obj;
			if (null == this.getId() || null == faMasAccount.getId()) return false;
			else return (this.getId().equals(faMasAccount.getId()));
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