package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bed_status table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="bed_status"
 */

public abstract class BaseBedStatus implements Serializable {

	public static String REF = "BedStatus";
	public static String PROP_ORS_ARMY = "OrsArmy";
	public static String PROP_OFFICER_AF = "OfficerAf";
	public static String PROP_OFFFAMILY_ARMY = "OfffamilyArmy";
	public static String PROP_REMD = "Remd";
	public static String PROP_OFFFAMILY_AF = "OfffamilyAf";
	public static String PROP_OFFICER_ARMY = "OfficerArmy";
	public static String PROP_ORS_NAVY = "OrsNavy";
	public static String PROP_ORSF_AF = "OrsfAf";
	public static String PROP_OFFFAMILY_NAVY = "OfffamilyNavy";
	public static String PROP_DIS = "Dis";
	public static String PROP_ORS_AF = "OrsAf";
	public static String PROP_OFFICER_NAVY = "OfficerNavy";
	public static String PROP_ORSF_ARMY = "OrsfArmy";
	public static String PROP_DEATH = "Death";
	public static String PROP_ORSF_NAVY = "OrsfNavy";
	public static String PROP_ADM = "Adm";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBedStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBedStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBedStatus(java.lang.Integer id, java.lang.Integer remd,
			java.lang.Integer adm) {

		this.setId(id);
		this.setRemd(remd);
		this.setAdm(adm);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer remd;
	private java.lang.Integer adm;
	private java.lang.Integer dis;
	private java.lang.Integer death;
	private java.lang.Integer officerAf;
	private java.lang.Integer officerArmy;
	private java.lang.Integer officerNavy;
	private java.lang.Integer offfamilyAf;
	private java.lang.Integer offfamilyArmy;
	private java.lang.Integer offfamilyNavy;
	private java.lang.Integer orsAf;
	private java.lang.Integer orsArmy;
	private java.lang.Integer orsNavy;
	private java.lang.Integer orsfAf;
	private java.lang.Integer orsfArmy;
	private java.lang.Integer orsfNavy;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="SR_NO"
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
	 * Return the value associated with the column: REMD
	 */
	public java.lang.Integer getRemd() {
		return remd;
	}

	/**
	 * Set the value related to the column: REMD
	 * 
	 * @param remd
	 *            the REMD value
	 */
	public void setRemd(java.lang.Integer remd) {
		this.remd = remd;
	}

	/**
	 * Return the value associated with the column: ADM
	 */
	public java.lang.Integer getAdm() {
		return adm;
	}

	/**
	 * Set the value related to the column: ADM
	 * 
	 * @param adm
	 *            the ADM value
	 */
	public void setAdm(java.lang.Integer adm) {
		this.adm = adm;
	}

	/**
	 * Return the value associated with the column: DIS
	 */
	public java.lang.Integer getDis() {
		return dis;
	}

	/**
	 * Set the value related to the column: DIS
	 * 
	 * @param dis
	 *            the DIS value
	 */
	public void setDis(java.lang.Integer dis) {
		this.dis = dis;
	}

	/**
	 * Return the value associated with the column: DEATH
	 */
	public java.lang.Integer getDeath() {
		return death;
	}

	/**
	 * Set the value related to the column: DEATH
	 * 
	 * @param death
	 *            the DEATH value
	 */
	public void setDeath(java.lang.Integer death) {
		this.death = death;
	}

	/**
	 * Return the value associated with the column: OFFICER_AF
	 */
	public java.lang.Integer getOfficerAf() {
		return officerAf;
	}

	/**
	 * Set the value related to the column: OFFICER_AF
	 * 
	 * @param officerAf
	 *            the OFFICER_AF value
	 */
	public void setOfficerAf(java.lang.Integer officerAf) {
		this.officerAf = officerAf;
	}

	/**
	 * Return the value associated with the column: OFFICER_ARMY
	 */
	public java.lang.Integer getOfficerArmy() {
		return officerArmy;
	}

	/**
	 * Set the value related to the column: OFFICER_ARMY
	 * 
	 * @param officerArmy
	 *            the OFFICER_ARMY value
	 */
	public void setOfficerArmy(java.lang.Integer officerArmy) {
		this.officerArmy = officerArmy;
	}

	/**
	 * Return the value associated with the column: OFFICER_NAVY
	 */
	public java.lang.Integer getOfficerNavy() {
		return officerNavy;
	}

	/**
	 * Set the value related to the column: OFFICER_NAVY
	 * 
	 * @param officerNavy
	 *            the OFFICER_NAVY value
	 */
	public void setOfficerNavy(java.lang.Integer officerNavy) {
		this.officerNavy = officerNavy;
	}

	/**
	 * Return the value associated with the column: OFFFAMILY_AF
	 */
	public java.lang.Integer getOfffamilyAf() {
		return offfamilyAf;
	}

	/**
	 * Set the value related to the column: OFFFAMILY_AF
	 * 
	 * @param offfamilyAf
	 *            the OFFFAMILY_AF value
	 */
	public void setOfffamilyAf(java.lang.Integer offfamilyAf) {
		this.offfamilyAf = offfamilyAf;
	}

	/**
	 * Return the value associated with the column: OFFFAMILY_ARMY
	 */
	public java.lang.Integer getOfffamilyArmy() {
		return offfamilyArmy;
	}

	/**
	 * Set the value related to the column: OFFFAMILY_ARMY
	 * 
	 * @param offfamilyArmy
	 *            the OFFFAMILY_ARMY value
	 */
	public void setOfffamilyArmy(java.lang.Integer offfamilyArmy) {
		this.offfamilyArmy = offfamilyArmy;
	}

	/**
	 * Return the value associated with the column: OFFFAMILY_NAVY
	 */
	public java.lang.Integer getOfffamilyNavy() {
		return offfamilyNavy;
	}

	/**
	 * Set the value related to the column: OFFFAMILY_NAVY
	 * 
	 * @param offfamilyNavy
	 *            the OFFFAMILY_NAVY value
	 */
	public void setOfffamilyNavy(java.lang.Integer offfamilyNavy) {
		this.offfamilyNavy = offfamilyNavy;
	}

	/**
	 * Return the value associated with the column: ORS_AF
	 */
	public java.lang.Integer getOrsAf() {
		return orsAf;
	}

	/**
	 * Set the value related to the column: ORS_AF
	 * 
	 * @param orsAf
	 *            the ORS_AF value
	 */
	public void setOrsAf(java.lang.Integer orsAf) {
		this.orsAf = orsAf;
	}

	/**
	 * Return the value associated with the column: ORS_ARMY
	 */
	public java.lang.Integer getOrsArmy() {
		return orsArmy;
	}

	/**
	 * Set the value related to the column: ORS_ARMY
	 * 
	 * @param orsArmy
	 *            the ORS_ARMY value
	 */
	public void setOrsArmy(java.lang.Integer orsArmy) {
		this.orsArmy = orsArmy;
	}

	/**
	 * Return the value associated with the column: ORS_NAVY
	 */
	public java.lang.Integer getOrsNavy() {
		return orsNavy;
	}

	/**
	 * Set the value related to the column: ORS_NAVY
	 * 
	 * @param orsNavy
	 *            the ORS_NAVY value
	 */
	public void setOrsNavy(java.lang.Integer orsNavy) {
		this.orsNavy = orsNavy;
	}

	/**
	 * Return the value associated with the column: ORSF_AF
	 */
	public java.lang.Integer getOrsfAf() {
		return orsfAf;
	}

	/**
	 * Set the value related to the column: ORSF_AF
	 * 
	 * @param orsfAf
	 *            the ORSF_AF value
	 */
	public void setOrsfAf(java.lang.Integer orsfAf) {
		this.orsfAf = orsfAf;
	}

	/**
	 * Return the value associated with the column: ORSF_ARMY
	 */
	public java.lang.Integer getOrsfArmy() {
		return orsfArmy;
	}

	/**
	 * Set the value related to the column: ORSF_ARMY
	 * 
	 * @param orsfArmy
	 *            the ORSF_ARMY value
	 */
	public void setOrsfArmy(java.lang.Integer orsfArmy) {
		this.orsfArmy = orsfArmy;
	}

	/**
	 * Return the value associated with the column: ORSF_NAVY
	 */
	public java.lang.Integer getOrsfNavy() {
		return orsfNavy;
	}

	/**
	 * Set the value related to the column: ORSF_NAVY
	 * 
	 * @param orsfNavy
	 *            the ORSF_NAVY value
	 */
	public void setOrsfNavy(java.lang.Integer orsfNavy) {
		this.orsfNavy = orsfNavy;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BedStatus))
			return false;
		else {
			jkt.hms.masters.business.BedStatus bedStatus = (jkt.hms.masters.business.BedStatus) obj;
			if (null == this.getId() || null == bedStatus.getId())
				return false;
			else
				return (this.getId().equals(bedStatus.getId()));
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