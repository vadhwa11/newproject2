package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mis_bed_stats table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mis_bed_stats"
 */

public abstract class BaseMisBedStats implements Serializable {

	public static String REF = "MisBedStats";
	public static String PROP_ORS_ARMY = "OrsArmy";
	public static String PROP_CUR_TIME = "CurTime";
	public static String PROP_OFFICER_AF = "OfficerAf";
	public static String PROP_OFFFAMILY_ARMY = "OfffamilyArmy";
	public static String PROP_REMD = "Remd";
	public static String PROP_OFFFAMILY_AF = "OfffamilyAf";
	public static String PROP_NAVY = "Navy";
	public static String PROP_OFFICER_ARMY = "OfficerArmy";
	public static String PROP_ORS_NAVY = "OrsNavy";
	public static String PROP_NE = "Ne";
	public static String PROP_ORSF_AF = "OrsfAf";
	public static String PROP_OFFFAMILY_NAVY = "OfffamilyNavy";
	public static String PROP_FORG = "Forg";
	public static String PROP_DIS = "Dis";
	public static String PROP_ORS_AF = "OrsAf";
	public static String PROP_OFFICER_NAVY = "OfficerNavy";
	public static String PROP_ORSF_ARMY = "OrsfArmy";
	public static String PROP_DEATH = "Death";
	public static String PROP_ARMY = "Army";
	public static String PROP_CE = "Ce";
	public static String PROP_ORSF_NAVY = "OrsfNavy";
	public static String PROP_ADM = "Adm";
	public static String PROP_ID = "Id";
	public static String PROP_AF = "Af";

	// constructors
	public BaseMisBedStats() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisBedStats(java.util.Date id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.util.Date id;

	// fields
	private java.util.Date curTime;
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
	private java.lang.Integer af;
	private java.lang.Integer army;
	private java.lang.Integer navy;
	private java.lang.Integer ce;
	private java.lang.Integer ne;
	private java.lang.Integer forg;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="CUR_DATE"
	 */
	public java.util.Date getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.util.Date id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: CUR_TIME
	 */
	public java.util.Date getCurTime() {
		return curTime;
	}

	/**
	 * Set the value related to the column: CUR_TIME
	 * 
	 * @param curTime
	 *            the CUR_TIME value
	 */
	public void setCurTime(java.util.Date curTime) {
		this.curTime = curTime;
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

	/**
	 * Return the value associated with the column: AF
	 */
	public java.lang.Integer getAf() {
		return af;
	}

	/**
	 * Set the value related to the column: AF
	 * 
	 * @param af
	 *            the AF value
	 */
	public void setAf(java.lang.Integer af) {
		this.af = af;
	}

	/**
	 * Return the value associated with the column: ARMY
	 */
	public java.lang.Integer getArmy() {
		return army;
	}

	/**
	 * Set the value related to the column: ARMY
	 * 
	 * @param army
	 *            the ARMY value
	 */
	public void setArmy(java.lang.Integer army) {
		this.army = army;
	}

	/**
	 * Return the value associated with the column: NAVY
	 */
	public java.lang.Integer getNavy() {
		return navy;
	}

	/**
	 * Set the value related to the column: NAVY
	 * 
	 * @param navy
	 *            the NAVY value
	 */
	public void setNavy(java.lang.Integer navy) {
		this.navy = navy;
	}

	/**
	 * Return the value associated with the column: CE
	 */
	public java.lang.Integer getCe() {
		return ce;
	}

	/**
	 * Set the value related to the column: CE
	 * 
	 * @param ce
	 *            the CE value
	 */
	public void setCe(java.lang.Integer ce) {
		this.ce = ce;
	}

	/**
	 * Return the value associated with the column: NE
	 */
	public java.lang.Integer getNe() {
		return ne;
	}

	/**
	 * Set the value related to the column: NE
	 * 
	 * @param ne
	 *            the NE value
	 */
	public void setNe(java.lang.Integer ne) {
		this.ne = ne;
	}

	/**
	 * Return the value associated with the column: FORG
	 */
	public java.lang.Integer getForg() {
		return forg;
	}

	/**
	 * Set the value related to the column: FORG
	 * 
	 * @param forg
	 *            the FORG value
	 */
	public void setForg(java.lang.Integer forg) {
		this.forg = forg;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MisBedStats))
			return false;
		else {
			jkt.hms.masters.business.MisBedStats misBedStats = (jkt.hms.masters.business.MisBedStats) obj;
			if (null == this.getId() || null == misBedStats.getId())
				return false;
			else
				return (this.getId().equals(misBedStats.getId()));
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