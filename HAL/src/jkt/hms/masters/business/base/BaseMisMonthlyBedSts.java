package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mis_monthly_bed_sts
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mis_monthly_bed_sts"
 */

public abstract class BaseMisMonthlyBedSts implements Serializable {

	public static String REF = "MisMonthlyBedSts";
	public static String PROP_UPTODATE_DIS_NAVY = "UptodateDisNavy";
	public static String PROP_UPTODATE_ADM_OFF_FAM_ARMY = "UptodateAdmOffFamArmy";
	public static String PROP_UPTODATE_ADM_OFF_AF = "UptodateAdmOffAf";
	public static String PROP_OFF_AF = "OffAf";
	public static String PROP_OFF_AF_ADM = "OffAfAdm";
	public static String PROP_OFF_TOT = "OffTot";
	public static String PROP_TOT_NAV = "TotNav";
	public static String PROP_REMD = "Remd";
	public static String PROP_TOTAL_ARMY_DEATH_ORS_FAMILY = "TotalArmyDeathOrsFamily";
	public static String PROP_TOTAL_NAVY_DEATH_OFF = "TotalNavyDeathOff";
	public static String PROP_TOTAL_CENE_DIS = "TotalCeneDis";
	public static String PROP_TOTAL_ARMY_DEATH_ORS = "TotalArmyDeathOrs";
	public static String PROP_TOT_ARM = "TotArm";
	public static String PROP_TODAY_TOTAL = "TodayTotal";
	public static String PROP_OFF_FAM_AF = "OffFamAf";
	public static String PROP_TODAYS_TOTAL_ORS_AF = "TodaysTotalOrsAf";
	public static String PROP_REMD_CENE = "RemdCene";
	public static String PROP_REMD_ARMY = "RemdArmy";
	public static String PROP_ORS_FAM_ARM = "OrsFamArm";
	public static String PROP_TOTAL_NAVY_DIS_ORS_FAMILY = "TotalNavyDisOrsFamily";
	public static String PROP_REMD_OFF_ARMY = "RemdOffArmy";
	public static String PROP_TODAYS_TOTAL_OFF_FAM_NAVY = "TodaysTotalOffFamNavy";
	public static String PROP_OFF_FAM_NAV = "OffFamNav";
	public static String PROP_TOTAL_AF_ADM = "TotalAfAdm";
	public static String PROP_TOTAL_AF_ADM_ORS = "TotalAfAdmOrs";
	public static String PROP_TOTAL_NAVY_DIS_ORS = "TotalNavyDisOrs";
	public static String PROP_UPTODATE_DIS_OFF_FAM_AF = "UptodateDisOffFamAf";
	public static String PROP_TOTAL_CENE_ADM = "TotalCeneAdm";
	public static String PROP_OFF_FAM_TOT = "OffFamTot";
	public static String PROP_UPTODATE_ADM_CENE = "UptodateAdmCene";
	public static String PROP_ORS_NAV = "OrsNav";
	public static String PROP_TOTAL_AF_DIS = "TotalAfDis";
	public static String PROP_OFF_ARM = "OffArm";
	public static String PROP_TOT = "Tot";
	public static String PROP_TOTAL_ARMY_ADM_OFF = "TotalArmyAdmOff";
	public static String PROP_REMD_AF = "RemdAf";
	public static String PROP_TOTAL_TO_DATE = "TotalToDate";
	public static String PROP_UPTODATE_ADM_ORS_AF = "UptodateAdmOrsAf";
	public static String PROP_UPTODATE_ADM_OFF_FAM_AF = "UptodateAdmOffFamAf";
	public static String PROP_TOTAL_AF_DIS_ORS_FAMILY = "TotalAfDisOrsFamily";
	public static String PROP_TOTAL_NAVY_ADM = "TotalNavyAdm";
	public static String PROP_REMD_ORS_AF = "RemdOrsAf";
	public static String PROP_TOTAL_NAVY_ADM_OFF = "TotalNavyAdmOff";
	public static String PROP_DEATH = "Death";
	public static String PROP_TOTAL_AF_DEATH_ORS_FAMILY = "TotalAfDeathOrsFamily";
	public static String PROP_TOTAL_AF_DIS_OFF = "TotalAfDisOff";
	public static String PROP_UPTODATE_DIS_CENE = "UptodateDisCene";
	public static String PROP_TOTAL_ARMY_DEATH_OFF_FAMILY = "TotalArmyDeathOffFamily";
	public static String PROP_UPTODATE_DIS = "UptodateDis";
	public static String PROP_UPTODATE_ADM_OFF_FAM_NAVY = "UptodateAdmOffFamNavy";
	public static String PROP_TOTAL_ARMY_DIS = "TotalArmyDis";
	public static String PROP_TOTAL_AF_ADM_ORS_FAMILY = "TotalAfAdmOrsFamily";
	public static String PROP_ORS_FAM_TOT = "OrsFamTot";
	public static String PROP_TODAY_TOTAL_ARMY = "TodayTotalArmy";
	public static String PROP_TOTAL_ARMY_DIS_ORS = "TotalArmyDisOrs";
	public static String PROP_UPTODATE_ADM_OFF_ARMY = "UptodateAdmOffArmy";
	public static String PROP_UPTODATE_DIS_ARMY = "UptodateDisArmy";
	public static String PROP_TODAYS_TOTAL_ORS_ARMY = "TodaysTotalOrsArmy";
	public static String PROP_TODAYS_TOTAL_OFF_FAM_ARMY = "TodaysTotalOffFamArmy";
	public static String PROP_TOTAL_NAVY_ADM_ORS = "TotalNavyAdmOrs";
	public static String PROP_TODAYS_TOTAL_CENE = "TodaysTotalCene";
	public static String PROP_TOTAL_AF_DEATH_ORS = "TotalAfDeathOrs";
	public static String PROP_TODAYS_TOTAL_ORS_FAM_NAVY = "TodaysTotalOrsFamNavy";
	public static String PROP_M_DATE = "MDate";
	public static String PROP_OFF_NAV = "OffNav";
	public static String PROP_REMD_OFF_AF = "RemdOffAf";
	public static String PROP_TOTAL_AF_DEATH = "TotalAfDeath";
	public static String PROP_TODAYS_TOTAL_OFF_ARMY = "TodaysTotalOffArmy";
	public static String PROP_TOTAL_ARMY_ADM = "TotalArmyAdm";
	public static String PROP_UPTODATE_ADM_FORE = "UptodateAdmFore";
	public static String PROP_TOTAL_NAVY_DIS_OFF = "TotalNavyDisOff";
	public static String PROP_TODAYS_TOTAL_ORS_FAM_AF = "TodaysTotalOrsFamAf";
	public static String PROP_ORS_FAM_NAV = "OrsFamNav";
	public static String PROP_TOTAL_ARMY_ADM_OFF_FAMILY = "TotalArmyAdmOffFamily";
	public static String PROP_UPTODATE_DIS_ORS_FAM_AF = "UptodateDisOrsFamAf";
	public static String PROP_TOTAL = "Total";
	public static String PROP_TOTAL_AF_DEATH_OFF = "TotalAfDeathOff";
	public static String PROP_TOTAL_AF_ADM_OFF = "TotalAfAdmOff";
	public static String PROP_UPTODATE_DIS_ORS_ARMY = "UptodateDisOrsArmy";
	public static String PROP_UPTODATE_DIS_OFF_FAM_ARMY = "UptodateDisOffFamArmy";
	public static String PROP_UPTODATE_ADM_ORS_FAM_AF = "UptodateAdmOrsFamAf";
	public static String PROP_ORS_AF = "OrsAf";
	public static String PROP_ADM = "Adm";
	public static String PROP_UPTODATE_ADM_ORS_FAM_NAVY = "UptodateAdmOrsFamNavy";
	public static String PROP_UPTODATE_ADM_ARMY = "UptodateAdmArmy";
	public static String PROP_TOTAL_ARMY_DEATH_OFF = "TotalArmyDeathOff";
	public static String PROP_UPTODATE_DIS_OFF_ARMY = "UptodateDisOffArmy";
	public static String PROP_TODAYS_TOTAL_OFF_AF = "TodaysTotalOffAf";
	public static String PROP_UPTODATE_DIS_OFF_NAVY = "UptodateDisOffNavy";
	public static String PROP_TOTAL_ARMY_DIS_OFF_FAMILY = "TotalArmyDisOffFamily";
	public static String PROP_TODAY_TOTAL_AF = "TodayTotalAf";
	public static String PROP_TODAYS_TOTAL_ORS_NAVY = "TodaysTotalOrsNavy";
	public static String PROP_UPTODATE_DIS_ORS_FAM_ARMY = "UptodateDisOrsFamArmy";
	public static String PROP_DIS = "Dis";
	public static String PROP_REMD_OFF_FAM_NAVY = "RemdOffFamNavy";
	public static String PROP_TOTAL_NAVY_DEATH_OFF_FAMILY = "TotalNavyDeathOffFamily";
	public static String PROP_TOTAL_CENE_DEATH = "TotalCeneDeath";
	public static String PROP_ORS_TOT = "OrsTot";
	public static String PROP_TOTAL_NAVY_DEATH_ORS_FAMILY = "TotalNavyDeathOrsFamily";
	public static String PROP_TOT_CENE = "TotCene";
	public static String PROP_UPTODATE_DIS_OFF_FAM_NAVY = "UptodateDisOffFamNavy";
	public static String PROP_TOTAL_NAVY_DEATH_ORS = "TotalNavyDeathOrs";
	public static String PROP_UPTODATE_ADM_ORS_FAM_ARMY = "UptodateAdmOrsFamArmy";
	public static String PROP_TOTAL_FORG_ADM = "TotalForgAdm";
	public static String PROP_UPTODATE_DIS_ORS_AF = "UptodateDisOrsAf";
	public static String PROP_TODAYS_TOTAL_OFF_NAVY = "TodaysTotalOffNavy";
	public static String PROP_UPTODATE_DIS_OFF_AF = "UptodateDisOffAf";
	public static String PROP_TOTAL_FORG_DIS = "TotalForgDis";
	public static String PROP_ID = "Id";
	public static String PROP_UPTODATE_ADM_OFF_NAVY = "UptodateAdmOffNavy";
	public static String PROP_REMD_ORS_ARMY = "RemdOrsArmy";
	public static String PROP_TOTAL_AF_DEATH_OFF_FAMILY = "TotalAfDeathOffFamily";
	public static String PROP_TOT_AF = "TotAf";
	public static String PROP_UPTODATE_ADM = "UptodateAdm";
	public static String PROP_REMD_ORS_FAM_NAVY = "RemdOrsFamNavy";
	public static String PROP_TOTAL_ARMY_DIS_OFF = "TotalArmyDisOff";
	public static String PROP_TODAYS_TOTAL_FORE = "TodaysTotalFore";
	public static String PROP_UPTODATE_DIS_FORE = "UptodateDisFore";
	public static String PROP_ORS_ARM = "OrsArm";
	public static String PROP_TOTAL_ARMY_ADM_ORS = "TotalArmyAdmOrs";
	public static String PROP_ORS_FAM_AF = "OrsFamAf";
	public static String PROP_UPTODATE_ADM_ORS_ARMY = "UptodateAdmOrsArmy";
	public static String PROP_TOTAL_ARMY_DIS_ORS_FAMILY = "TotalArmyDisOrsFamily";
	public static String PROP_REMD_FORE = "RemdFore";
	public static String PROP_TOTAL_ARMY_ADM_ORS_FAMILY = "TotalArmyAdmOrsFamily";
	public static String PROP_TODAY_TOTAL_NAVY = "TodayTotalNavy";
	public static String PROP_UPTODATE_ADM_ORS_NAVY = "UptodateAdmOrsNavy";
	public static String PROP_TOTAL_FORG_DEATH = "TotalForgDeath";
	public static String PROP_TODAYS_TOTAL_ORS_FAM_ARMY = "TodaysTotalOrsFamArmy";
	public static String PROP_OFF_FAM_ARM = "OffFamArm";
	public static String PROP_REMD_OFF_FAM_AF = "RemdOffFamAf";
	public static String PROP_TOTAL_ARMY_DEATH = "TotalArmyDeath";
	public static String PROP_REMD_ORS_FAM_AF = "RemdOrsFamAf";
	public static String PROP_TODAYS_TOTAL_OFF_FAM_AF = "TodaysTotalOffFamAf";
	public static String PROP_UPTODATE_ADM_NAVY = "UptodateAdmNavy";
	public static String PROP_UPTODATE_ADM_AF = "UptodateAdmAf";
	public static String PROP_TOTAL_AF_DIS_OFF_FAMILY = "TotalAfDisOffFamily";
	public static String PROP_TOT_FOR = "TotFor";
	public static String PROP_REMD_OFF_NAVY = "RemdOffNavy";
	public static String PROP_TOTAL_AF_DIS_ORS = "TotalAfDisOrs";
	public static String PROP_REMD_OFF_FAM_ARMY = "RemdOffFamArmy";
	public static String PROP_REMD_NAVY = "RemdNavy";
	public static String PROP_UPTODATE_DIS_AF = "UptodateDisAf";
	public static String PROP_TOTAL_NAVY_ADM_ORS_FAMILY = "TotalNavyAdmOrsFamily";
	public static String PROP_TOTAL_NAVY_DIS = "TotalNavyDis";
	public static String PROP_TOTAL_AF_ADM_OFF_FAMILY = "TotalAfAdmOffFamily";
	public static String PROP_UPTODATE_DIS_ORS_FAM_NAVY = "UptodateDisOrsFamNavy";
	public static String PROP_TOTAL_NAVY_ADM_OFF_FAMILY = "TotalNavyAdmOffFamily";
	public static String PROP_UPTODATE_DIS_ORS_NAVY = "UptodateDisOrsNavy";
	public static String PROP_TOTAL_NAVY_DEATH = "TotalNavyDeath";
	public static String PROP_REMD_ORS_FAM_ARMY = "RemdOrsFamArmy";
	public static String PROP_REMD_ORS_NAVY = "RemdOrsNavy";
	public static String PROP_TOTAL_NAVY_DIS_OFF_FAMILY = "TotalNavyDisOffFamily";

	// constructors
	public BaseMisMonthlyBedSts() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisMonthlyBedSts(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMisMonthlyBedSts(java.lang.Integer id, java.util.Date mDate) {

		this.setId(id);
		this.setMDate(mDate);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date mDate;
	private java.lang.Integer remd;
	private java.lang.Integer adm;
	private java.lang.Integer dis;
	private java.lang.Integer death;
	private java.lang.Integer tot;
	private java.lang.Integer offAf;
	private java.lang.Integer offArm;
	private java.lang.Integer offNav;
	private java.lang.Integer offTot;
	private java.lang.Integer offFamAf;
	private java.lang.Integer offFamArm;
	private java.lang.Integer offFamNav;
	private java.lang.Integer offFamTot;
	private java.lang.Integer orsAf;
	private java.lang.Integer orsArm;
	private java.lang.Integer orsNav;
	private java.lang.Integer orsTot;
	private java.lang.Integer orsFamAf;
	private java.lang.Integer orsFamArm;
	private java.lang.Integer orsFamNav;
	private java.lang.Integer orsFamTot;
	private java.lang.Integer totAf;
	private java.lang.Integer totArm;
	private java.lang.Integer totNav;
	private java.lang.Integer totCene;
	private java.lang.Integer totFor;
	private java.lang.Integer total;
	private java.lang.Integer offAfAdm;
	private java.lang.Integer todayTotal;
	private java.lang.Integer todayTotalArmy;
	private java.lang.Integer todayTotalAf;
	private java.lang.Integer todayTotalNavy;
	private java.lang.Integer todaysTotalCene;
	private java.lang.Integer todaysTotalFore;
	private java.lang.Integer totalAfDis;
	private java.lang.Integer totalAfDisOff;
	private java.lang.Integer totalAfDisOffFamily;
	private java.lang.Integer totalAfDisOrs;
	private java.lang.Integer totalAfDisOrsFamily;
	private java.lang.Integer totalArmyDis;
	private java.lang.Integer totalArmyDisOff;
	private java.lang.Integer totalArmyDisOffFamily;
	private java.lang.Integer totalArmyDisOrs;
	private java.lang.Integer totalArmyDisOrsFamily;
	private java.lang.Integer totalNavyDis;
	private java.lang.Integer totalNavyDisOff;
	private java.lang.Integer totalNavyDisOffFamily;
	private java.lang.Integer totalNavyDisOrs;
	private java.lang.Integer totalNavyDisOrsFamily;
	private java.lang.Integer totalCeneDis;
	private java.lang.Integer totalForgDis;
	private java.lang.Integer totalAfAdm;
	private java.lang.Integer totalAfAdmOff;
	private java.lang.Integer totalAfAdmOffFamily;
	private java.lang.Integer totalAfAdmOrs;
	private java.lang.Integer totalAfAdmOrsFamily;
	private java.lang.Integer totalArmyAdm;
	private java.lang.Integer totalArmyAdmOff;
	private java.lang.Integer totalArmyAdmOffFamily;
	private java.lang.Integer totalArmyAdmOrs;
	private java.lang.Integer totalArmyAdmOrsFamily;
	private java.lang.Integer totalNavyAdm;
	private java.lang.Integer totalNavyAdmOff;
	private java.lang.Integer totalNavyAdmOffFamily;
	private java.lang.Integer totalNavyAdmOrs;
	private java.lang.Integer totalNavyAdmOrsFamily;
	private java.lang.Integer totalCeneAdm;
	private java.lang.Integer totalForgAdm;
	private java.lang.Integer totalAfDeath;
	private java.lang.Integer totalAfDeathOff;
	private java.lang.Integer totalAfDeathOffFamily;
	private java.lang.Integer totalAfDeathOrs;
	private java.lang.Integer totalAfDeathOrsFamily;
	private java.lang.Integer totalArmyDeath;
	private java.lang.Integer totalArmyDeathOff;
	private java.lang.Integer totalArmyDeathOffFamily;
	private java.lang.Integer totalArmyDeathOrs;
	private java.lang.Integer totalArmyDeathOrsFamily;
	private java.lang.Integer totalNavyDeath;
	private java.lang.Integer totalNavyDeathOff;
	private java.lang.Integer totalNavyDeathOffFamily;
	private java.lang.Integer totalNavyDeathOrs;
	private java.lang.Integer totalNavyDeathOrsFamily;
	private java.lang.Integer totalCeneDeath;
	private java.lang.Integer totalForgDeath;
	private java.lang.Integer totalToDate;
	private java.lang.Integer todaysTotalOffAf;
	private java.lang.Integer todaysTotalOffArmy;
	private java.lang.Integer todaysTotalOffNavy;
	private java.lang.Integer todaysTotalOffFamAf;
	private java.lang.Integer todaysTotalOffFamArmy;
	private java.lang.Integer todaysTotalOffFamNavy;
	private java.lang.Integer todaysTotalOrsAf;
	private java.lang.Integer todaysTotalOrsArmy;
	private java.lang.Integer todaysTotalOrsNavy;
	private java.lang.Integer todaysTotalOrsFamAf;
	private java.lang.Integer todaysTotalOrsFamArmy;
	private java.lang.Integer todaysTotalOrsFamNavy;
	private java.lang.Integer uptodateAdm;
	private java.lang.Integer uptodateAdmArmy;
	private java.lang.Integer uptodateAdmAf;
	private java.lang.Integer uptodateAdmNavy;
	private java.lang.Integer uptodateAdmCene;
	private java.lang.Integer uptodateAdmFore;
	private java.lang.Integer uptodateAdmOffAf;
	private java.lang.Integer uptodateAdmOffArmy;
	private java.lang.Integer uptodateAdmOffNavy;
	private java.lang.Integer uptodateAdmOffFamAf;
	private java.lang.Integer uptodateAdmOffFamArmy;
	private java.lang.Integer uptodateAdmOffFamNavy;
	private java.lang.Integer uptodateAdmOrsAf;
	private java.lang.Integer uptodateAdmOrsArmy;
	private java.lang.Integer uptodateAdmOrsNavy;
	private java.lang.Integer uptodateAdmOrsFamAf;
	private java.lang.Integer uptodateAdmOrsFamArmy;
	private java.lang.Integer uptodateAdmOrsFamNavy;
	private java.lang.Integer uptodateDis;
	private java.lang.Integer uptodateDisArmy;
	private java.lang.Integer uptodateDisAf;
	private java.lang.Integer uptodateDisNavy;
	private java.lang.Integer uptodateDisCene;
	private java.lang.Integer uptodateDisFore;
	private java.lang.Integer uptodateDisOffAf;
	private java.lang.Integer uptodateDisOffArmy;
	private java.lang.Integer uptodateDisOffNavy;
	private java.lang.Integer uptodateDisOffFamAf;
	private java.lang.Integer uptodateDisOffFamArmy;
	private java.lang.Integer uptodateDisOffFamNavy;
	private java.lang.Integer uptodateDisOrsAf;
	private java.lang.Integer uptodateDisOrsArmy;
	private java.lang.Integer uptodateDisOrsNavy;
	private java.lang.Integer uptodateDisOrsFamAf;
	private java.lang.Integer uptodateDisOrsFamArmy;
	private java.lang.Integer uptodateDisOrsFamNavy;
	private java.lang.Integer remdArmy;
	private java.lang.Integer remdAf;
	private java.lang.Integer remdNavy;
	private java.lang.Integer remdCene;
	private java.lang.Integer remdFore;
	private java.lang.Integer remdOffAf;
	private java.lang.Integer remdOffArmy;
	private java.lang.Integer remdOffNavy;
	private java.lang.Integer remdOffFamAf;
	private java.lang.Integer remdOffFamArmy;
	private java.lang.Integer remdOffFamNavy;
	private java.lang.Integer remdOrsAf;
	private java.lang.Integer remdOrsArmy;
	private java.lang.Integer remdOrsNavy;
	private java.lang.Integer remdOrsFamAf;
	private java.lang.Integer remdOrsFamArmy;
	private java.lang.Integer remdOrsFamNavy;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="mis_monthly_id"
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
	 * Return the value associated with the column: m_date
	 */
	public java.util.Date getMDate() {
		return mDate;
	}

	/**
	 * Set the value related to the column: m_date
	 * 
	 * @param mDate
	 *            the m_date value
	 */
	public void setMDate(java.util.Date mDate) {
		this.mDate = mDate;
	}

	/**
	 * Return the value associated with the column: remd
	 */
	public java.lang.Integer getRemd() {
		return remd;
	}

	/**
	 * Set the value related to the column: remd
	 * 
	 * @param remd
	 *            the remd value
	 */
	public void setRemd(java.lang.Integer remd) {
		this.remd = remd;
	}

	/**
	 * Return the value associated with the column: adm
	 */
	public java.lang.Integer getAdm() {
		return adm;
	}

	/**
	 * Set the value related to the column: adm
	 * 
	 * @param adm
	 *            the adm value
	 */
	public void setAdm(java.lang.Integer adm) {
		this.adm = adm;
	}

	/**
	 * Return the value associated with the column: dis
	 */
	public java.lang.Integer getDis() {
		return dis;
	}

	/**
	 * Set the value related to the column: dis
	 * 
	 * @param dis
	 *            the dis value
	 */
	public void setDis(java.lang.Integer dis) {
		this.dis = dis;
	}

	/**
	 * Return the value associated with the column: death
	 */
	public java.lang.Integer getDeath() {
		return death;
	}

	/**
	 * Set the value related to the column: death
	 * 
	 * @param death
	 *            the death value
	 */
	public void setDeath(java.lang.Integer death) {
		this.death = death;
	}

	/**
	 * Return the value associated with the column: tot
	 */
	public java.lang.Integer getTot() {
		return tot;
	}

	/**
	 * Set the value related to the column: tot
	 * 
	 * @param tot
	 *            the tot value
	 */
	public void setTot(java.lang.Integer tot) {
		this.tot = tot;
	}

	/**
	 * Return the value associated with the column: off_af
	 */
	public java.lang.Integer getOffAf() {
		return offAf;
	}

	/**
	 * Set the value related to the column: off_af
	 * 
	 * @param offAf
	 *            the off_af value
	 */
	public void setOffAf(java.lang.Integer offAf) {
		this.offAf = offAf;
	}

	/**
	 * Return the value associated with the column: off_arm
	 */
	public java.lang.Integer getOffArm() {
		return offArm;
	}

	/**
	 * Set the value related to the column: off_arm
	 * 
	 * @param offArm
	 *            the off_arm value
	 */
	public void setOffArm(java.lang.Integer offArm) {
		this.offArm = offArm;
	}

	/**
	 * Return the value associated with the column: off_nav
	 */
	public java.lang.Integer getOffNav() {
		return offNav;
	}

	/**
	 * Set the value related to the column: off_nav
	 * 
	 * @param offNav
	 *            the off_nav value
	 */
	public void setOffNav(java.lang.Integer offNav) {
		this.offNav = offNav;
	}

	/**
	 * Return the value associated with the column: off_tot
	 */
	public java.lang.Integer getOffTot() {
		return offTot;
	}

	/**
	 * Set the value related to the column: off_tot
	 * 
	 * @param offTot
	 *            the off_tot value
	 */
	public void setOffTot(java.lang.Integer offTot) {
		this.offTot = offTot;
	}

	/**
	 * Return the value associated with the column: off_fam_af
	 */
	public java.lang.Integer getOffFamAf() {
		return offFamAf;
	}

	/**
	 * Set the value related to the column: off_fam_af
	 * 
	 * @param offFamAf
	 *            the off_fam_af value
	 */
	public void setOffFamAf(java.lang.Integer offFamAf) {
		this.offFamAf = offFamAf;
	}

	/**
	 * Return the value associated with the column: off_fam_arm
	 */
	public java.lang.Integer getOffFamArm() {
		return offFamArm;
	}

	/**
	 * Set the value related to the column: off_fam_arm
	 * 
	 * @param offFamArm
	 *            the off_fam_arm value
	 */
	public void setOffFamArm(java.lang.Integer offFamArm) {
		this.offFamArm = offFamArm;
	}

	/**
	 * Return the value associated with the column: off_fam_nav
	 */
	public java.lang.Integer getOffFamNav() {
		return offFamNav;
	}

	/**
	 * Set the value related to the column: off_fam_nav
	 * 
	 * @param offFamNav
	 *            the off_fam_nav value
	 */
	public void setOffFamNav(java.lang.Integer offFamNav) {
		this.offFamNav = offFamNav;
	}

	/**
	 * Return the value associated with the column: off_fam_tot
	 */
	public java.lang.Integer getOffFamTot() {
		return offFamTot;
	}

	/**
	 * Set the value related to the column: off_fam_tot
	 * 
	 * @param offFamTot
	 *            the off_fam_tot value
	 */
	public void setOffFamTot(java.lang.Integer offFamTot) {
		this.offFamTot = offFamTot;
	}

	/**
	 * Return the value associated with the column: ors_af
	 */
	public java.lang.Integer getOrsAf() {
		return orsAf;
	}

	/**
	 * Set the value related to the column: ors_af
	 * 
	 * @param orsAf
	 *            the ors_af value
	 */
	public void setOrsAf(java.lang.Integer orsAf) {
		this.orsAf = orsAf;
	}

	/**
	 * Return the value associated with the column: ors_arm
	 */
	public java.lang.Integer getOrsArm() {
		return orsArm;
	}

	/**
	 * Set the value related to the column: ors_arm
	 * 
	 * @param orsArm
	 *            the ors_arm value
	 */
	public void setOrsArm(java.lang.Integer orsArm) {
		this.orsArm = orsArm;
	}

	/**
	 * Return the value associated with the column: ors_nav
	 */
	public java.lang.Integer getOrsNav() {
		return orsNav;
	}

	/**
	 * Set the value related to the column: ors_nav
	 * 
	 * @param orsNav
	 *            the ors_nav value
	 */
	public void setOrsNav(java.lang.Integer orsNav) {
		this.orsNav = orsNav;
	}

	/**
	 * Return the value associated with the column: ors_tot
	 */
	public java.lang.Integer getOrsTot() {
		return orsTot;
	}

	/**
	 * Set the value related to the column: ors_tot
	 * 
	 * @param orsTot
	 *            the ors_tot value
	 */
	public void setOrsTot(java.lang.Integer orsTot) {
		this.orsTot = orsTot;
	}

	/**
	 * Return the value associated with the column: ors_fam_af
	 */
	public java.lang.Integer getOrsFamAf() {
		return orsFamAf;
	}

	/**
	 * Set the value related to the column: ors_fam_af
	 * 
	 * @param orsFamAf
	 *            the ors_fam_af value
	 */
	public void setOrsFamAf(java.lang.Integer orsFamAf) {
		this.orsFamAf = orsFamAf;
	}

	/**
	 * Return the value associated with the column: ors_fam_arm
	 */
	public java.lang.Integer getOrsFamArm() {
		return orsFamArm;
	}

	/**
	 * Set the value related to the column: ors_fam_arm
	 * 
	 * @param orsFamArm
	 *            the ors_fam_arm value
	 */
	public void setOrsFamArm(java.lang.Integer orsFamArm) {
		this.orsFamArm = orsFamArm;
	}

	/**
	 * Return the value associated with the column: ors_fam_nav
	 */
	public java.lang.Integer getOrsFamNav() {
		return orsFamNav;
	}

	/**
	 * Set the value related to the column: ors_fam_nav
	 * 
	 * @param orsFamNav
	 *            the ors_fam_nav value
	 */
	public void setOrsFamNav(java.lang.Integer orsFamNav) {
		this.orsFamNav = orsFamNav;
	}

	/**
	 * Return the value associated with the column: ors_fam_tot
	 */
	public java.lang.Integer getOrsFamTot() {
		return orsFamTot;
	}

	/**
	 * Set the value related to the column: ors_fam_tot
	 * 
	 * @param orsFamTot
	 *            the ors_fam_tot value
	 */
	public void setOrsFamTot(java.lang.Integer orsFamTot) {
		this.orsFamTot = orsFamTot;
	}

	/**
	 * Return the value associated with the column: tot_af
	 */
	public java.lang.Integer getTotAf() {
		return totAf;
	}

	/**
	 * Set the value related to the column: tot_af
	 * 
	 * @param totAf
	 *            the tot_af value
	 */
	public void setTotAf(java.lang.Integer totAf) {
		this.totAf = totAf;
	}

	/**
	 * Return the value associated with the column: tot_arm
	 */
	public java.lang.Integer getTotArm() {
		return totArm;
	}

	/**
	 * Set the value related to the column: tot_arm
	 * 
	 * @param totArm
	 *            the tot_arm value
	 */
	public void setTotArm(java.lang.Integer totArm) {
		this.totArm = totArm;
	}

	/**
	 * Return the value associated with the column: tot_nav
	 */
	public java.lang.Integer getTotNav() {
		return totNav;
	}

	/**
	 * Set the value related to the column: tot_nav
	 * 
	 * @param totNav
	 *            the tot_nav value
	 */
	public void setTotNav(java.lang.Integer totNav) {
		this.totNav = totNav;
	}

	/**
	 * Return the value associated with the column: tot_cene
	 */
	public java.lang.Integer getTotCene() {
		return totCene;
	}

	/**
	 * Set the value related to the column: tot_cene
	 * 
	 * @param totCene
	 *            the tot_cene value
	 */
	public void setTotCene(java.lang.Integer totCene) {
		this.totCene = totCene;
	}

	/**
	 * Return the value associated with the column: tot_for
	 */
	public java.lang.Integer getTotFor() {
		return totFor;
	}

	/**
	 * Set the value related to the column: tot_for
	 * 
	 * @param totFor
	 *            the tot_for value
	 */
	public void setTotFor(java.lang.Integer totFor) {
		this.totFor = totFor;
	}

	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Integer getTotal() {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * 
	 * @param total
	 *            the total value
	 */
	public void setTotal(java.lang.Integer total) {
		this.total = total;
	}

	/**
	 * Return the value associated with the column: off_af_adm
	 */
	public java.lang.Integer getOffAfAdm() {
		return offAfAdm;
	}

	/**
	 * Set the value related to the column: off_af_adm
	 * 
	 * @param offAfAdm
	 *            the off_af_adm value
	 */
	public void setOffAfAdm(java.lang.Integer offAfAdm) {
		this.offAfAdm = offAfAdm;
	}

	/**
	 * Return the value associated with the column: today_total
	 */
	public java.lang.Integer getTodayTotal() {
		return todayTotal;
	}

	/**
	 * Set the value related to the column: today_total
	 * 
	 * @param todayTotal
	 *            the today_total value
	 */
	public void setTodayTotal(java.lang.Integer todayTotal) {
		this.todayTotal = todayTotal;
	}

	/**
	 * Return the value associated with the column: today_total_army
	 */
	public java.lang.Integer getTodayTotalArmy() {
		return todayTotalArmy;
	}

	/**
	 * Set the value related to the column: today_total_army
	 * 
	 * @param todayTotalArmy
	 *            the today_total_army value
	 */
	public void setTodayTotalArmy(java.lang.Integer todayTotalArmy) {
		this.todayTotalArmy = todayTotalArmy;
	}

	/**
	 * Return the value associated with the column: today_total_af
	 */
	public java.lang.Integer getTodayTotalAf() {
		return todayTotalAf;
	}

	/**
	 * Set the value related to the column: today_total_af
	 * 
	 * @param todayTotalAf
	 *            the today_total_af value
	 */
	public void setTodayTotalAf(java.lang.Integer todayTotalAf) {
		this.todayTotalAf = todayTotalAf;
	}

	/**
	 * Return the value associated with the column: today_total_navy
	 */
	public java.lang.Integer getTodayTotalNavy() {
		return todayTotalNavy;
	}

	/**
	 * Set the value related to the column: today_total_navy
	 * 
	 * @param todayTotalNavy
	 *            the today_total_navy value
	 */
	public void setTodayTotalNavy(java.lang.Integer todayTotalNavy) {
		this.todayTotalNavy = todayTotalNavy;
	}

	/**
	 * Return the value associated with the column: todays_total_cene
	 */
	public java.lang.Integer getTodaysTotalCene() {
		return todaysTotalCene;
	}

	/**
	 * Set the value related to the column: todays_total_cene
	 * 
	 * @param todaysTotalCene
	 *            the todays_total_cene value
	 */
	public void setTodaysTotalCene(java.lang.Integer todaysTotalCene) {
		this.todaysTotalCene = todaysTotalCene;
	}

	/**
	 * Return the value associated with the column: todays_total_fore
	 */
	public java.lang.Integer getTodaysTotalFore() {
		return todaysTotalFore;
	}

	/**
	 * Set the value related to the column: todays_total_fore
	 * 
	 * @param todaysTotalFore
	 *            the todays_total_fore value
	 */
	public void setTodaysTotalFore(java.lang.Integer todaysTotalFore) {
		this.todaysTotalFore = todaysTotalFore;
	}

	/**
	 * Return the value associated with the column: total_af_dis
	 */
	public java.lang.Integer getTotalAfDis() {
		return totalAfDis;
	}

	/**
	 * Set the value related to the column: total_af_dis
	 * 
	 * @param totalAfDis
	 *            the total_af_dis value
	 */
	public void setTotalAfDis(java.lang.Integer totalAfDis) {
		this.totalAfDis = totalAfDis;
	}

	/**
	 * Return the value associated with the column: total_af_dis_off
	 */
	public java.lang.Integer getTotalAfDisOff() {
		return totalAfDisOff;
	}

	/**
	 * Set the value related to the column: total_af_dis_off
	 * 
	 * @param totalAfDisOff
	 *            the total_af_dis_off value
	 */
	public void setTotalAfDisOff(java.lang.Integer totalAfDisOff) {
		this.totalAfDisOff = totalAfDisOff;
	}

	/**
	 * Return the value associated with the column: total_af_dis_off_family
	 */
	public java.lang.Integer getTotalAfDisOffFamily() {
		return totalAfDisOffFamily;
	}

	/**
	 * Set the value related to the column: total_af_dis_off_family
	 * 
	 * @param totalAfDisOffFamily
	 *            the total_af_dis_off_family value
	 */
	public void setTotalAfDisOffFamily(java.lang.Integer totalAfDisOffFamily) {
		this.totalAfDisOffFamily = totalAfDisOffFamily;
	}

	/**
	 * Return the value associated with the column: total_af_dis_ors
	 */
	public java.lang.Integer getTotalAfDisOrs() {
		return totalAfDisOrs;
	}

	/**
	 * Set the value related to the column: total_af_dis_ors
	 * 
	 * @param totalAfDisOrs
	 *            the total_af_dis_ors value
	 */
	public void setTotalAfDisOrs(java.lang.Integer totalAfDisOrs) {
		this.totalAfDisOrs = totalAfDisOrs;
	}

	/**
	 * Return the value associated with the column: total_af_dis_ors_family
	 */
	public java.lang.Integer getTotalAfDisOrsFamily() {
		return totalAfDisOrsFamily;
	}

	/**
	 * Set the value related to the column: total_af_dis_ors_family
	 * 
	 * @param totalAfDisOrsFamily
	 *            the total_af_dis_ors_family value
	 */
	public void setTotalAfDisOrsFamily(java.lang.Integer totalAfDisOrsFamily) {
		this.totalAfDisOrsFamily = totalAfDisOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_army_dis
	 */
	public java.lang.Integer getTotalArmyDis() {
		return totalArmyDis;
	}

	/**
	 * Set the value related to the column: total_army_dis
	 * 
	 * @param totalArmyDis
	 *            the total_army_dis value
	 */
	public void setTotalArmyDis(java.lang.Integer totalArmyDis) {
		this.totalArmyDis = totalArmyDis;
	}

	/**
	 * Return the value associated with the column: total_army_dis_off
	 */
	public java.lang.Integer getTotalArmyDisOff() {
		return totalArmyDisOff;
	}

	/**
	 * Set the value related to the column: total_army_dis_off
	 * 
	 * @param totalArmyDisOff
	 *            the total_army_dis_off value
	 */
	public void setTotalArmyDisOff(java.lang.Integer totalArmyDisOff) {
		this.totalArmyDisOff = totalArmyDisOff;
	}

	/**
	 * Return the value associated with the column: total_army_dis_off_family
	 */
	public java.lang.Integer getTotalArmyDisOffFamily() {
		return totalArmyDisOffFamily;
	}

	/**
	 * Set the value related to the column: total_army_dis_off_family
	 * 
	 * @param totalArmyDisOffFamily
	 *            the total_army_dis_off_family value
	 */
	public void setTotalArmyDisOffFamily(java.lang.Integer totalArmyDisOffFamily) {
		this.totalArmyDisOffFamily = totalArmyDisOffFamily;
	}

	/**
	 * Return the value associated with the column: total_army_dis_ors
	 */
	public java.lang.Integer getTotalArmyDisOrs() {
		return totalArmyDisOrs;
	}

	/**
	 * Set the value related to the column: total_army_dis_ors
	 * 
	 * @param totalArmyDisOrs
	 *            the total_army_dis_ors value
	 */
	public void setTotalArmyDisOrs(java.lang.Integer totalArmyDisOrs) {
		this.totalArmyDisOrs = totalArmyDisOrs;
	}

	/**
	 * Return the value associated with the column: total_army_dis_ors_family
	 */
	public java.lang.Integer getTotalArmyDisOrsFamily() {
		return totalArmyDisOrsFamily;
	}

	/**
	 * Set the value related to the column: total_army_dis_ors_family
	 * 
	 * @param totalArmyDisOrsFamily
	 *            the total_army_dis_ors_family value
	 */
	public void setTotalArmyDisOrsFamily(java.lang.Integer totalArmyDisOrsFamily) {
		this.totalArmyDisOrsFamily = totalArmyDisOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_dis
	 */
	public java.lang.Integer getTotalNavyDis() {
		return totalNavyDis;
	}

	/**
	 * Set the value related to the column: total_navy_dis
	 * 
	 * @param totalNavyDis
	 *            the total_navy_dis value
	 */
	public void setTotalNavyDis(java.lang.Integer totalNavyDis) {
		this.totalNavyDis = totalNavyDis;
	}

	/**
	 * Return the value associated with the column: total_navy_dis_off
	 */
	public java.lang.Integer getTotalNavyDisOff() {
		return totalNavyDisOff;
	}

	/**
	 * Set the value related to the column: total_navy_dis_off
	 * 
	 * @param totalNavyDisOff
	 *            the total_navy_dis_off value
	 */
	public void setTotalNavyDisOff(java.lang.Integer totalNavyDisOff) {
		this.totalNavyDisOff = totalNavyDisOff;
	}

	/**
	 * Return the value associated with the column: total_navy_dis_off_family
	 */
	public java.lang.Integer getTotalNavyDisOffFamily() {
		return totalNavyDisOffFamily;
	}

	/**
	 * Set the value related to the column: total_navy_dis_off_family
	 * 
	 * @param totalNavyDisOffFamily
	 *            the total_navy_dis_off_family value
	 */
	public void setTotalNavyDisOffFamily(java.lang.Integer totalNavyDisOffFamily) {
		this.totalNavyDisOffFamily = totalNavyDisOffFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_dis_ors
	 */
	public java.lang.Integer getTotalNavyDisOrs() {
		return totalNavyDisOrs;
	}

	/**
	 * Set the value related to the column: total_navy_dis_ors
	 * 
	 * @param totalNavyDisOrs
	 *            the total_navy_dis_ors value
	 */
	public void setTotalNavyDisOrs(java.lang.Integer totalNavyDisOrs) {
		this.totalNavyDisOrs = totalNavyDisOrs;
	}

	/**
	 * Return the value associated with the column: total_navy_dis_ors_family
	 */
	public java.lang.Integer getTotalNavyDisOrsFamily() {
		return totalNavyDisOrsFamily;
	}

	/**
	 * Set the value related to the column: total_navy_dis_ors_family
	 * 
	 * @param totalNavyDisOrsFamily
	 *            the total_navy_dis_ors_family value
	 */
	public void setTotalNavyDisOrsFamily(java.lang.Integer totalNavyDisOrsFamily) {
		this.totalNavyDisOrsFamily = totalNavyDisOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_cene_dis
	 */
	public java.lang.Integer getTotalCeneDis() {
		return totalCeneDis;
	}

	/**
	 * Set the value related to the column: total_cene_dis
	 * 
	 * @param totalCeneDis
	 *            the total_cene_dis value
	 */
	public void setTotalCeneDis(java.lang.Integer totalCeneDis) {
		this.totalCeneDis = totalCeneDis;
	}

	/**
	 * Return the value associated with the column: total_forg_dis
	 */
	public java.lang.Integer getTotalForgDis() {
		return totalForgDis;
	}

	/**
	 * Set the value related to the column: total_forg_dis
	 * 
	 * @param totalForgDis
	 *            the total_forg_dis value
	 */
	public void setTotalForgDis(java.lang.Integer totalForgDis) {
		this.totalForgDis = totalForgDis;
	}

	/**
	 * Return the value associated with the column: total_af_adm
	 */
	public java.lang.Integer getTotalAfAdm() {
		return totalAfAdm;
	}

	/**
	 * Set the value related to the column: total_af_adm
	 * 
	 * @param totalAfAdm
	 *            the total_af_adm value
	 */
	public void setTotalAfAdm(java.lang.Integer totalAfAdm) {
		this.totalAfAdm = totalAfAdm;
	}

	/**
	 * Return the value associated with the column: total_af_adm_off
	 */
	public java.lang.Integer getTotalAfAdmOff() {
		return totalAfAdmOff;
	}

	/**
	 * Set the value related to the column: total_af_adm_off
	 * 
	 * @param totalAfAdmOff
	 *            the total_af_adm_off value
	 */
	public void setTotalAfAdmOff(java.lang.Integer totalAfAdmOff) {
		this.totalAfAdmOff = totalAfAdmOff;
	}

	/**
	 * Return the value associated with the column: total_af_adm_off_family
	 */
	public java.lang.Integer getTotalAfAdmOffFamily() {
		return totalAfAdmOffFamily;
	}

	/**
	 * Set the value related to the column: total_af_adm_off_family
	 * 
	 * @param totalAfAdmOffFamily
	 *            the total_af_adm_off_family value
	 */
	public void setTotalAfAdmOffFamily(java.lang.Integer totalAfAdmOffFamily) {
		this.totalAfAdmOffFamily = totalAfAdmOffFamily;
	}

	/**
	 * Return the value associated with the column: total_af_adm_ors
	 */
	public java.lang.Integer getTotalAfAdmOrs() {
		return totalAfAdmOrs;
	}

	/**
	 * Set the value related to the column: total_af_adm_ors
	 * 
	 * @param totalAfAdmOrs
	 *            the total_af_adm_ors value
	 */
	public void setTotalAfAdmOrs(java.lang.Integer totalAfAdmOrs) {
		this.totalAfAdmOrs = totalAfAdmOrs;
	}

	/**
	 * Return the value associated with the column: total_af_adm_ors_family
	 */
	public java.lang.Integer getTotalAfAdmOrsFamily() {
		return totalAfAdmOrsFamily;
	}

	/**
	 * Set the value related to the column: total_af_adm_ors_family
	 * 
	 * @param totalAfAdmOrsFamily
	 *            the total_af_adm_ors_family value
	 */
	public void setTotalAfAdmOrsFamily(java.lang.Integer totalAfAdmOrsFamily) {
		this.totalAfAdmOrsFamily = totalAfAdmOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_army_adm
	 */
	public java.lang.Integer getTotalArmyAdm() {
		return totalArmyAdm;
	}

	/**
	 * Set the value related to the column: total_army_adm
	 * 
	 * @param totalArmyAdm
	 *            the total_army_adm value
	 */
	public void setTotalArmyAdm(java.lang.Integer totalArmyAdm) {
		this.totalArmyAdm = totalArmyAdm;
	}

	/**
	 * Return the value associated with the column: total_army_adm_off
	 */
	public java.lang.Integer getTotalArmyAdmOff() {
		return totalArmyAdmOff;
	}

	/**
	 * Set the value related to the column: total_army_adm_off
	 * 
	 * @param totalArmyAdmOff
	 *            the total_army_adm_off value
	 */
	public void setTotalArmyAdmOff(java.lang.Integer totalArmyAdmOff) {
		this.totalArmyAdmOff = totalArmyAdmOff;
	}

	/**
	 * Return the value associated with the column: total_army_adm_off_family
	 */
	public java.lang.Integer getTotalArmyAdmOffFamily() {
		return totalArmyAdmOffFamily;
	}

	/**
	 * Set the value related to the column: total_army_adm_off_family
	 * 
	 * @param totalArmyAdmOffFamily
	 *            the total_army_adm_off_family value
	 */
	public void setTotalArmyAdmOffFamily(java.lang.Integer totalArmyAdmOffFamily) {
		this.totalArmyAdmOffFamily = totalArmyAdmOffFamily;
	}

	/**
	 * Return the value associated with the column: total_army_adm_ors
	 */
	public java.lang.Integer getTotalArmyAdmOrs() {
		return totalArmyAdmOrs;
	}

	/**
	 * Set the value related to the column: total_army_adm_ors
	 * 
	 * @param totalArmyAdmOrs
	 *            the total_army_adm_ors value
	 */
	public void setTotalArmyAdmOrs(java.lang.Integer totalArmyAdmOrs) {
		this.totalArmyAdmOrs = totalArmyAdmOrs;
	}

	/**
	 * Return the value associated with the column: total_army_adm_ors_family
	 */
	public java.lang.Integer getTotalArmyAdmOrsFamily() {
		return totalArmyAdmOrsFamily;
	}

	/**
	 * Set the value related to the column: total_army_adm_ors_family
	 * 
	 * @param totalArmyAdmOrsFamily
	 *            the total_army_adm_ors_family value
	 */
	public void setTotalArmyAdmOrsFamily(java.lang.Integer totalArmyAdmOrsFamily) {
		this.totalArmyAdmOrsFamily = totalArmyAdmOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_adm
	 */
	public java.lang.Integer getTotalNavyAdm() {
		return totalNavyAdm;
	}

	/**
	 * Set the value related to the column: total_navy_adm
	 * 
	 * @param totalNavyAdm
	 *            the total_navy_adm value
	 */
	public void setTotalNavyAdm(java.lang.Integer totalNavyAdm) {
		this.totalNavyAdm = totalNavyAdm;
	}

	/**
	 * Return the value associated with the column: total_navy_adm_off
	 */
	public java.lang.Integer getTotalNavyAdmOff() {
		return totalNavyAdmOff;
	}

	/**
	 * Set the value related to the column: total_navy_adm_off
	 * 
	 * @param totalNavyAdmOff
	 *            the total_navy_adm_off value
	 */
	public void setTotalNavyAdmOff(java.lang.Integer totalNavyAdmOff) {
		this.totalNavyAdmOff = totalNavyAdmOff;
	}

	/**
	 * Return the value associated with the column: total_navy_adm_off_family
	 */
	public java.lang.Integer getTotalNavyAdmOffFamily() {
		return totalNavyAdmOffFamily;
	}

	/**
	 * Set the value related to the column: total_navy_adm_off_family
	 * 
	 * @param totalNavyAdmOffFamily
	 *            the total_navy_adm_off_family value
	 */
	public void setTotalNavyAdmOffFamily(java.lang.Integer totalNavyAdmOffFamily) {
		this.totalNavyAdmOffFamily = totalNavyAdmOffFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_adm_ors
	 */
	public java.lang.Integer getTotalNavyAdmOrs() {
		return totalNavyAdmOrs;
	}

	/**
	 * Set the value related to the column: total_navy_adm_ors
	 * 
	 * @param totalNavyAdmOrs
	 *            the total_navy_adm_ors value
	 */
	public void setTotalNavyAdmOrs(java.lang.Integer totalNavyAdmOrs) {
		this.totalNavyAdmOrs = totalNavyAdmOrs;
	}

	/**
	 * Return the value associated with the column: total_navy_adm_ors_family
	 */
	public java.lang.Integer getTotalNavyAdmOrsFamily() {
		return totalNavyAdmOrsFamily;
	}

	/**
	 * Set the value related to the column: total_navy_adm_ors_family
	 * 
	 * @param totalNavyAdmOrsFamily
	 *            the total_navy_adm_ors_family value
	 */
	public void setTotalNavyAdmOrsFamily(java.lang.Integer totalNavyAdmOrsFamily) {
		this.totalNavyAdmOrsFamily = totalNavyAdmOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_cene_adm
	 */
	public java.lang.Integer getTotalCeneAdm() {
		return totalCeneAdm;
	}

	/**
	 * Set the value related to the column: total_cene_adm
	 * 
	 * @param totalCeneAdm
	 *            the total_cene_adm value
	 */
	public void setTotalCeneAdm(java.lang.Integer totalCeneAdm) {
		this.totalCeneAdm = totalCeneAdm;
	}

	/**
	 * Return the value associated with the column: total_forg_adm
	 */
	public java.lang.Integer getTotalForgAdm() {
		return totalForgAdm;
	}

	/**
	 * Set the value related to the column: total_forg_adm
	 * 
	 * @param totalForgAdm
	 *            the total_forg_adm value
	 */
	public void setTotalForgAdm(java.lang.Integer totalForgAdm) {
		this.totalForgAdm = totalForgAdm;
	}

	/**
	 * Return the value associated with the column: total_af_death
	 */
	public java.lang.Integer getTotalAfDeath() {
		return totalAfDeath;
	}

	/**
	 * Set the value related to the column: total_af_death
	 * 
	 * @param totalAfDeath
	 *            the total_af_death value
	 */
	public void setTotalAfDeath(java.lang.Integer totalAfDeath) {
		this.totalAfDeath = totalAfDeath;
	}

	/**
	 * Return the value associated with the column: total_af_death_off
	 */
	public java.lang.Integer getTotalAfDeathOff() {
		return totalAfDeathOff;
	}

	/**
	 * Set the value related to the column: total_af_death_off
	 * 
	 * @param totalAfDeathOff
	 *            the total_af_death_off value
	 */
	public void setTotalAfDeathOff(java.lang.Integer totalAfDeathOff) {
		this.totalAfDeathOff = totalAfDeathOff;
	}

	/**
	 * Return the value associated with the column: total_af_death_off_family
	 */
	public java.lang.Integer getTotalAfDeathOffFamily() {
		return totalAfDeathOffFamily;
	}

	/**
	 * Set the value related to the column: total_af_death_off_family
	 * 
	 * @param totalAfDeathOffFamily
	 *            the total_af_death_off_family value
	 */
	public void setTotalAfDeathOffFamily(java.lang.Integer totalAfDeathOffFamily) {
		this.totalAfDeathOffFamily = totalAfDeathOffFamily;
	}

	/**
	 * Return the value associated with the column: total_af_death_ors
	 */
	public java.lang.Integer getTotalAfDeathOrs() {
		return totalAfDeathOrs;
	}

	/**
	 * Set the value related to the column: total_af_death_ors
	 * 
	 * @param totalAfDeathOrs
	 *            the total_af_death_ors value
	 */
	public void setTotalAfDeathOrs(java.lang.Integer totalAfDeathOrs) {
		this.totalAfDeathOrs = totalAfDeathOrs;
	}

	/**
	 * Return the value associated with the column: total_af_death_ors_family
	 */
	public java.lang.Integer getTotalAfDeathOrsFamily() {
		return totalAfDeathOrsFamily;
	}

	/**
	 * Set the value related to the column: total_af_death_ors_family
	 * 
	 * @param totalAfDeathOrsFamily
	 *            the total_af_death_ors_family value
	 */
	public void setTotalAfDeathOrsFamily(java.lang.Integer totalAfDeathOrsFamily) {
		this.totalAfDeathOrsFamily = totalAfDeathOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_army_death
	 */
	public java.lang.Integer getTotalArmyDeath() {
		return totalArmyDeath;
	}

	/**
	 * Set the value related to the column: total_army_death
	 * 
	 * @param totalArmyDeath
	 *            the total_army_death value
	 */
	public void setTotalArmyDeath(java.lang.Integer totalArmyDeath) {
		this.totalArmyDeath = totalArmyDeath;
	}

	/**
	 * Return the value associated with the column: total_army_death_off
	 */
	public java.lang.Integer getTotalArmyDeathOff() {
		return totalArmyDeathOff;
	}

	/**
	 * Set the value related to the column: total_army_death_off
	 * 
	 * @param totalArmyDeathOff
	 *            the total_army_death_off value
	 */
	public void setTotalArmyDeathOff(java.lang.Integer totalArmyDeathOff) {
		this.totalArmyDeathOff = totalArmyDeathOff;
	}

	/**
	 * Return the value associated with the column: total_army_death_off_family
	 */
	public java.lang.Integer getTotalArmyDeathOffFamily() {
		return totalArmyDeathOffFamily;
	}

	/**
	 * Set the value related to the column: total_army_death_off_family
	 * 
	 * @param totalArmyDeathOffFamily
	 *            the total_army_death_off_family value
	 */
	public void setTotalArmyDeathOffFamily(
			java.lang.Integer totalArmyDeathOffFamily) {
		this.totalArmyDeathOffFamily = totalArmyDeathOffFamily;
	}

	/**
	 * Return the value associated with the column: total_army_death_ors
	 */
	public java.lang.Integer getTotalArmyDeathOrs() {
		return totalArmyDeathOrs;
	}

	/**
	 * Set the value related to the column: total_army_death_ors
	 * 
	 * @param totalArmyDeathOrs
	 *            the total_army_death_ors value
	 */
	public void setTotalArmyDeathOrs(java.lang.Integer totalArmyDeathOrs) {
		this.totalArmyDeathOrs = totalArmyDeathOrs;
	}

	/**
	 * Return the value associated with the column: total_army_death_ors_family
	 */
	public java.lang.Integer getTotalArmyDeathOrsFamily() {
		return totalArmyDeathOrsFamily;
	}

	/**
	 * Set the value related to the column: total_army_death_ors_family
	 * 
	 * @param totalArmyDeathOrsFamily
	 *            the total_army_death_ors_family value
	 */
	public void setTotalArmyDeathOrsFamily(
			java.lang.Integer totalArmyDeathOrsFamily) {
		this.totalArmyDeathOrsFamily = totalArmyDeathOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_death
	 */
	public java.lang.Integer getTotalNavyDeath() {
		return totalNavyDeath;
	}

	/**
	 * Set the value related to the column: total_navy_death
	 * 
	 * @param totalNavyDeath
	 *            the total_navy_death value
	 */
	public void setTotalNavyDeath(java.lang.Integer totalNavyDeath) {
		this.totalNavyDeath = totalNavyDeath;
	}

	/**
	 * Return the value associated with the column: total_navy_death_off
	 */
	public java.lang.Integer getTotalNavyDeathOff() {
		return totalNavyDeathOff;
	}

	/**
	 * Set the value related to the column: total_navy_death_off
	 * 
	 * @param totalNavyDeathOff
	 *            the total_navy_death_off value
	 */
	public void setTotalNavyDeathOff(java.lang.Integer totalNavyDeathOff) {
		this.totalNavyDeathOff = totalNavyDeathOff;
	}

	/**
	 * Return the value associated with the column: total_navy_death_off_family
	 */
	public java.lang.Integer getTotalNavyDeathOffFamily() {
		return totalNavyDeathOffFamily;
	}

	/**
	 * Set the value related to the column: total_navy_death_off_family
	 * 
	 * @param totalNavyDeathOffFamily
	 *            the total_navy_death_off_family value
	 */
	public void setTotalNavyDeathOffFamily(
			java.lang.Integer totalNavyDeathOffFamily) {
		this.totalNavyDeathOffFamily = totalNavyDeathOffFamily;
	}

	/**
	 * Return the value associated with the column: total_navy_death_ors
	 */
	public java.lang.Integer getTotalNavyDeathOrs() {
		return totalNavyDeathOrs;
	}

	/**
	 * Set the value related to the column: total_navy_death_ors
	 * 
	 * @param totalNavyDeathOrs
	 *            the total_navy_death_ors value
	 */
	public void setTotalNavyDeathOrs(java.lang.Integer totalNavyDeathOrs) {
		this.totalNavyDeathOrs = totalNavyDeathOrs;
	}

	/**
	 * Return the value associated with the column: total_navy_death_ors_family
	 */
	public java.lang.Integer getTotalNavyDeathOrsFamily() {
		return totalNavyDeathOrsFamily;
	}

	/**
	 * Set the value related to the column: total_navy_death_ors_family
	 * 
	 * @param totalNavyDeathOrsFamily
	 *            the total_navy_death_ors_family value
	 */
	public void setTotalNavyDeathOrsFamily(
			java.lang.Integer totalNavyDeathOrsFamily) {
		this.totalNavyDeathOrsFamily = totalNavyDeathOrsFamily;
	}

	/**
	 * Return the value associated with the column: total_cene_death
	 */
	public java.lang.Integer getTotalCeneDeath() {
		return totalCeneDeath;
	}

	/**
	 * Set the value related to the column: total_cene_death
	 * 
	 * @param totalCeneDeath
	 *            the total_cene_death value
	 */
	public void setTotalCeneDeath(java.lang.Integer totalCeneDeath) {
		this.totalCeneDeath = totalCeneDeath;
	}

	/**
	 * Return the value associated with the column: total_forg_death
	 */
	public java.lang.Integer getTotalForgDeath() {
		return totalForgDeath;
	}

	/**
	 * Set the value related to the column: total_forg_death
	 * 
	 * @param totalForgDeath
	 *            the total_forg_death value
	 */
	public void setTotalForgDeath(java.lang.Integer totalForgDeath) {
		this.totalForgDeath = totalForgDeath;
	}

	/**
	 * Return the value associated with the column: total_to_date
	 */
	public java.lang.Integer getTotalToDate() {
		return totalToDate;
	}

	/**
	 * Set the value related to the column: total_to_date
	 * 
	 * @param totalToDate
	 *            the total_to_date value
	 */
	public void setTotalToDate(java.lang.Integer totalToDate) {
		this.totalToDate = totalToDate;
	}

	/**
	 * Return the value associated with the column: todays_total_off_af
	 */
	public java.lang.Integer getTodaysTotalOffAf() {
		return todaysTotalOffAf;
	}

	/**
	 * Set the value related to the column: todays_total_off_af
	 * 
	 * @param todaysTotalOffAf
	 *            the todays_total_off_af value
	 */
	public void setTodaysTotalOffAf(java.lang.Integer todaysTotalOffAf) {
		this.todaysTotalOffAf = todaysTotalOffAf;
	}

	/**
	 * Return the value associated with the column: todays_total_off_army
	 */
	public java.lang.Integer getTodaysTotalOffArmy() {
		return todaysTotalOffArmy;
	}

	/**
	 * Set the value related to the column: todays_total_off_army
	 * 
	 * @param todaysTotalOffArmy
	 *            the todays_total_off_army value
	 */
	public void setTodaysTotalOffArmy(java.lang.Integer todaysTotalOffArmy) {
		this.todaysTotalOffArmy = todaysTotalOffArmy;
	}

	/**
	 * Return the value associated with the column: todays_total_off_navy
	 */
	public java.lang.Integer getTodaysTotalOffNavy() {
		return todaysTotalOffNavy;
	}

	/**
	 * Set the value related to the column: todays_total_off_navy
	 * 
	 * @param todaysTotalOffNavy
	 *            the todays_total_off_navy value
	 */
	public void setTodaysTotalOffNavy(java.lang.Integer todaysTotalOffNavy) {
		this.todaysTotalOffNavy = todaysTotalOffNavy;
	}

	/**
	 * Return the value associated with the column: todays_total_off_fam_af
	 */
	public java.lang.Integer getTodaysTotalOffFamAf() {
		return todaysTotalOffFamAf;
	}

	/**
	 * Set the value related to the column: todays_total_off_fam_af
	 * 
	 * @param todaysTotalOffFamAf
	 *            the todays_total_off_fam_af value
	 */
	public void setTodaysTotalOffFamAf(java.lang.Integer todaysTotalOffFamAf) {
		this.todaysTotalOffFamAf = todaysTotalOffFamAf;
	}

	/**
	 * Return the value associated with the column: todays_total_off_fam_army
	 */
	public java.lang.Integer getTodaysTotalOffFamArmy() {
		return todaysTotalOffFamArmy;
	}

	/**
	 * Set the value related to the column: todays_total_off_fam_army
	 * 
	 * @param todaysTotalOffFamArmy
	 *            the todays_total_off_fam_army value
	 */
	public void setTodaysTotalOffFamArmy(java.lang.Integer todaysTotalOffFamArmy) {
		this.todaysTotalOffFamArmy = todaysTotalOffFamArmy;
	}

	/**
	 * Return the value associated with the column: todays_total_off_fam_navy
	 */
	public java.lang.Integer getTodaysTotalOffFamNavy() {
		return todaysTotalOffFamNavy;
	}

	/**
	 * Set the value related to the column: todays_total_off_fam_navy
	 * 
	 * @param todaysTotalOffFamNavy
	 *            the todays_total_off_fam_navy value
	 */
	public void setTodaysTotalOffFamNavy(java.lang.Integer todaysTotalOffFamNavy) {
		this.todaysTotalOffFamNavy = todaysTotalOffFamNavy;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_af
	 */
	public java.lang.Integer getTodaysTotalOrsAf() {
		return todaysTotalOrsAf;
	}

	/**
	 * Set the value related to the column: todays_total_ors_af
	 * 
	 * @param todaysTotalOrsAf
	 *            the todays_total_ors_af value
	 */
	public void setTodaysTotalOrsAf(java.lang.Integer todaysTotalOrsAf) {
		this.todaysTotalOrsAf = todaysTotalOrsAf;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_army
	 */
	public java.lang.Integer getTodaysTotalOrsArmy() {
		return todaysTotalOrsArmy;
	}

	/**
	 * Set the value related to the column: todays_total_ors_army
	 * 
	 * @param todaysTotalOrsArmy
	 *            the todays_total_ors_army value
	 */
	public void setTodaysTotalOrsArmy(java.lang.Integer todaysTotalOrsArmy) {
		this.todaysTotalOrsArmy = todaysTotalOrsArmy;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_navy
	 */
	public java.lang.Integer getTodaysTotalOrsNavy() {
		return todaysTotalOrsNavy;
	}

	/**
	 * Set the value related to the column: todays_total_ors_navy
	 * 
	 * @param todaysTotalOrsNavy
	 *            the todays_total_ors_navy value
	 */
	public void setTodaysTotalOrsNavy(java.lang.Integer todaysTotalOrsNavy) {
		this.todaysTotalOrsNavy = todaysTotalOrsNavy;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_fam_af
	 */
	public java.lang.Integer getTodaysTotalOrsFamAf() {
		return todaysTotalOrsFamAf;
	}

	/**
	 * Set the value related to the column: todays_total_ors_fam_af
	 * 
	 * @param todaysTotalOrsFamAf
	 *            the todays_total_ors_fam_af value
	 */
	public void setTodaysTotalOrsFamAf(java.lang.Integer todaysTotalOrsFamAf) {
		this.todaysTotalOrsFamAf = todaysTotalOrsFamAf;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_fam_army
	 */
	public java.lang.Integer getTodaysTotalOrsFamArmy() {
		return todaysTotalOrsFamArmy;
	}

	/**
	 * Set the value related to the column: todays_total_ors_fam_army
	 * 
	 * @param todaysTotalOrsFamArmy
	 *            the todays_total_ors_fam_army value
	 */
	public void setTodaysTotalOrsFamArmy(java.lang.Integer todaysTotalOrsFamArmy) {
		this.todaysTotalOrsFamArmy = todaysTotalOrsFamArmy;
	}

	/**
	 * Return the value associated with the column: todays_total_ors_fam_navy
	 */
	public java.lang.Integer getTodaysTotalOrsFamNavy() {
		return todaysTotalOrsFamNavy;
	}

	/**
	 * Set the value related to the column: todays_total_ors_fam_navy
	 * 
	 * @param todaysTotalOrsFamNavy
	 *            the todays_total_ors_fam_navy value
	 */
	public void setTodaysTotalOrsFamNavy(java.lang.Integer todaysTotalOrsFamNavy) {
		this.todaysTotalOrsFamNavy = todaysTotalOrsFamNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm
	 */
	public java.lang.Integer getUptodateAdm() {
		return uptodateAdm;
	}

	/**
	 * Set the value related to the column: uptodate_adm
	 * 
	 * @param uptodateAdm
	 *            the uptodate_adm value
	 */
	public void setUptodateAdm(java.lang.Integer uptodateAdm) {
		this.uptodateAdm = uptodateAdm;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_army
	 */
	public java.lang.Integer getUptodateAdmArmy() {
		return uptodateAdmArmy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_army
	 * 
	 * @param uptodateAdmArmy
	 *            the uptodate_adm_army value
	 */
	public void setUptodateAdmArmy(java.lang.Integer uptodateAdmArmy) {
		this.uptodateAdmArmy = uptodateAdmArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_af
	 */
	public java.lang.Integer getUptodateAdmAf() {
		return uptodateAdmAf;
	}

	/**
	 * Set the value related to the column: uptodate_adm_af
	 * 
	 * @param uptodateAdmAf
	 *            the uptodate_adm_af value
	 */
	public void setUptodateAdmAf(java.lang.Integer uptodateAdmAf) {
		this.uptodateAdmAf = uptodateAdmAf;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_navy
	 */
	public java.lang.Integer getUptodateAdmNavy() {
		return uptodateAdmNavy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_navy
	 * 
	 * @param uptodateAdmNavy
	 *            the uptodate_adm_navy value
	 */
	public void setUptodateAdmNavy(java.lang.Integer uptodateAdmNavy) {
		this.uptodateAdmNavy = uptodateAdmNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_cene
	 */
	public java.lang.Integer getUptodateAdmCene() {
		return uptodateAdmCene;
	}

	/**
	 * Set the value related to the column: uptodate_adm_cene
	 * 
	 * @param uptodateAdmCene
	 *            the uptodate_adm_cene value
	 */
	public void setUptodateAdmCene(java.lang.Integer uptodateAdmCene) {
		this.uptodateAdmCene = uptodateAdmCene;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_fore
	 */
	public java.lang.Integer getUptodateAdmFore() {
		return uptodateAdmFore;
	}

	/**
	 * Set the value related to the column: uptodate_adm_fore
	 * 
	 * @param uptodateAdmFore
	 *            the uptodate_adm_fore value
	 */
	public void setUptodateAdmFore(java.lang.Integer uptodateAdmFore) {
		this.uptodateAdmFore = uptodateAdmFore;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_af
	 */
	public java.lang.Integer getUptodateAdmOffAf() {
		return uptodateAdmOffAf;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_af
	 * 
	 * @param uptodateAdmOffAf
	 *            the uptodate_adm_off_af value
	 */
	public void setUptodateAdmOffAf(java.lang.Integer uptodateAdmOffAf) {
		this.uptodateAdmOffAf = uptodateAdmOffAf;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_army
	 */
	public java.lang.Integer getUptodateAdmOffArmy() {
		return uptodateAdmOffArmy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_army
	 * 
	 * @param uptodateAdmOffArmy
	 *            the uptodate_adm_off_army value
	 */
	public void setUptodateAdmOffArmy(java.lang.Integer uptodateAdmOffArmy) {
		this.uptodateAdmOffArmy = uptodateAdmOffArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_navy
	 */
	public java.lang.Integer getUptodateAdmOffNavy() {
		return uptodateAdmOffNavy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_navy
	 * 
	 * @param uptodateAdmOffNavy
	 *            the uptodate_adm_off_navy value
	 */
	public void setUptodateAdmOffNavy(java.lang.Integer uptodateAdmOffNavy) {
		this.uptodateAdmOffNavy = uptodateAdmOffNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_fam_af
	 */
	public java.lang.Integer getUptodateAdmOffFamAf() {
		return uptodateAdmOffFamAf;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_fam_af
	 * 
	 * @param uptodateAdmOffFamAf
	 *            the uptodate_adm_off_fam_af value
	 */
	public void setUptodateAdmOffFamAf(java.lang.Integer uptodateAdmOffFamAf) {
		this.uptodateAdmOffFamAf = uptodateAdmOffFamAf;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_fam_army
	 */
	public java.lang.Integer getUptodateAdmOffFamArmy() {
		return uptodateAdmOffFamArmy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_fam_army
	 * 
	 * @param uptodateAdmOffFamArmy
	 *            the uptodate_adm_off_fam_army value
	 */
	public void setUptodateAdmOffFamArmy(java.lang.Integer uptodateAdmOffFamArmy) {
		this.uptodateAdmOffFamArmy = uptodateAdmOffFamArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_off_fam_navy
	 */
	public java.lang.Integer getUptodateAdmOffFamNavy() {
		return uptodateAdmOffFamNavy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_off_fam_navy
	 * 
	 * @param uptodateAdmOffFamNavy
	 *            the uptodate_adm_off_fam_navy value
	 */
	public void setUptodateAdmOffFamNavy(java.lang.Integer uptodateAdmOffFamNavy) {
		this.uptodateAdmOffFamNavy = uptodateAdmOffFamNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_af
	 */
	public java.lang.Integer getUptodateAdmOrsAf() {
		return uptodateAdmOrsAf;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_af
	 * 
	 * @param uptodateAdmOrsAf
	 *            the uptodate_adm_ors_af value
	 */
	public void setUptodateAdmOrsAf(java.lang.Integer uptodateAdmOrsAf) {
		this.uptodateAdmOrsAf = uptodateAdmOrsAf;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_army
	 */
	public java.lang.Integer getUptodateAdmOrsArmy() {
		return uptodateAdmOrsArmy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_army
	 * 
	 * @param uptodateAdmOrsArmy
	 *            the uptodate_adm_ors_army value
	 */
	public void setUptodateAdmOrsArmy(java.lang.Integer uptodateAdmOrsArmy) {
		this.uptodateAdmOrsArmy = uptodateAdmOrsArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_navy
	 */
	public java.lang.Integer getUptodateAdmOrsNavy() {
		return uptodateAdmOrsNavy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_navy
	 * 
	 * @param uptodateAdmOrsNavy
	 *            the uptodate_adm_ors_navy value
	 */
	public void setUptodateAdmOrsNavy(java.lang.Integer uptodateAdmOrsNavy) {
		this.uptodateAdmOrsNavy = uptodateAdmOrsNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_fam_af
	 */
	public java.lang.Integer getUptodateAdmOrsFamAf() {
		return uptodateAdmOrsFamAf;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_fam_af
	 * 
	 * @param uptodateAdmOrsFamAf
	 *            the uptodate_adm_ors_fam_af value
	 */
	public void setUptodateAdmOrsFamAf(java.lang.Integer uptodateAdmOrsFamAf) {
		this.uptodateAdmOrsFamAf = uptodateAdmOrsFamAf;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_fam_army
	 */
	public java.lang.Integer getUptodateAdmOrsFamArmy() {
		return uptodateAdmOrsFamArmy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_fam_army
	 * 
	 * @param uptodateAdmOrsFamArmy
	 *            the uptodate_adm_ors_fam_army value
	 */
	public void setUptodateAdmOrsFamArmy(java.lang.Integer uptodateAdmOrsFamArmy) {
		this.uptodateAdmOrsFamArmy = uptodateAdmOrsFamArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_adm_ors_fam_navy
	 */
	public java.lang.Integer getUptodateAdmOrsFamNavy() {
		return uptodateAdmOrsFamNavy;
	}

	/**
	 * Set the value related to the column: uptodate_adm_ors_fam_navy
	 * 
	 * @param uptodateAdmOrsFamNavy
	 *            the uptodate_adm_ors_fam_navy value
	 */
	public void setUptodateAdmOrsFamNavy(java.lang.Integer uptodateAdmOrsFamNavy) {
		this.uptodateAdmOrsFamNavy = uptodateAdmOrsFamNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis
	 */
	public java.lang.Integer getUptodateDis() {
		return uptodateDis;
	}

	/**
	 * Set the value related to the column: uptodate_dis
	 * 
	 * @param uptodateDis
	 *            the uptodate_dis value
	 */
	public void setUptodateDis(java.lang.Integer uptodateDis) {
		this.uptodateDis = uptodateDis;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_army
	 */
	public java.lang.Integer getUptodateDisArmy() {
		return uptodateDisArmy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_army
	 * 
	 * @param uptodateDisArmy
	 *            the uptodate_dis_army value
	 */
	public void setUptodateDisArmy(java.lang.Integer uptodateDisArmy) {
		this.uptodateDisArmy = uptodateDisArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_af
	 */
	public java.lang.Integer getUptodateDisAf() {
		return uptodateDisAf;
	}

	/**
	 * Set the value related to the column: uptodate_dis_af
	 * 
	 * @param uptodateDisAf
	 *            the uptodate_dis_af value
	 */
	public void setUptodateDisAf(java.lang.Integer uptodateDisAf) {
		this.uptodateDisAf = uptodateDisAf;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_navy
	 */
	public java.lang.Integer getUptodateDisNavy() {
		return uptodateDisNavy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_navy
	 * 
	 * @param uptodateDisNavy
	 *            the uptodate_dis_navy value
	 */
	public void setUptodateDisNavy(java.lang.Integer uptodateDisNavy) {
		this.uptodateDisNavy = uptodateDisNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_cene
	 */
	public java.lang.Integer getUptodateDisCene() {
		return uptodateDisCene;
	}

	/**
	 * Set the value related to the column: uptodate_dis_cene
	 * 
	 * @param uptodateDisCene
	 *            the uptodate_dis_cene value
	 */
	public void setUptodateDisCene(java.lang.Integer uptodateDisCene) {
		this.uptodateDisCene = uptodateDisCene;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_fore
	 */
	public java.lang.Integer getUptodateDisFore() {
		return uptodateDisFore;
	}

	/**
	 * Set the value related to the column: uptodate_dis_fore
	 * 
	 * @param uptodateDisFore
	 *            the uptodate_dis_fore value
	 */
	public void setUptodateDisFore(java.lang.Integer uptodateDisFore) {
		this.uptodateDisFore = uptodateDisFore;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_af
	 */
	public java.lang.Integer getUptodateDisOffAf() {
		return uptodateDisOffAf;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_af
	 * 
	 * @param uptodateDisOffAf
	 *            the uptodate_dis_off_af value
	 */
	public void setUptodateDisOffAf(java.lang.Integer uptodateDisOffAf) {
		this.uptodateDisOffAf = uptodateDisOffAf;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_army
	 */
	public java.lang.Integer getUptodateDisOffArmy() {
		return uptodateDisOffArmy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_army
	 * 
	 * @param uptodateDisOffArmy
	 *            the uptodate_dis_off_army value
	 */
	public void setUptodateDisOffArmy(java.lang.Integer uptodateDisOffArmy) {
		this.uptodateDisOffArmy = uptodateDisOffArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_navy
	 */
	public java.lang.Integer getUptodateDisOffNavy() {
		return uptodateDisOffNavy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_navy
	 * 
	 * @param uptodateDisOffNavy
	 *            the uptodate_dis_off_navy value
	 */
	public void setUptodateDisOffNavy(java.lang.Integer uptodateDisOffNavy) {
		this.uptodateDisOffNavy = uptodateDisOffNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_fam_af
	 */
	public java.lang.Integer getUptodateDisOffFamAf() {
		return uptodateDisOffFamAf;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_fam_af
	 * 
	 * @param uptodateDisOffFamAf
	 *            the uptodate_dis_off_fam_af value
	 */
	public void setUptodateDisOffFamAf(java.lang.Integer uptodateDisOffFamAf) {
		this.uptodateDisOffFamAf = uptodateDisOffFamAf;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_fam_army
	 */
	public java.lang.Integer getUptodateDisOffFamArmy() {
		return uptodateDisOffFamArmy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_fam_army
	 * 
	 * @param uptodateDisOffFamArmy
	 *            the uptodate_dis_off_fam_army value
	 */
	public void setUptodateDisOffFamArmy(java.lang.Integer uptodateDisOffFamArmy) {
		this.uptodateDisOffFamArmy = uptodateDisOffFamArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_off_fam_navy
	 */
	public java.lang.Integer getUptodateDisOffFamNavy() {
		return uptodateDisOffFamNavy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_off_fam_navy
	 * 
	 * @param uptodateDisOffFamNavy
	 *            the uptodate_dis_off_fam_navy value
	 */
	public void setUptodateDisOffFamNavy(java.lang.Integer uptodateDisOffFamNavy) {
		this.uptodateDisOffFamNavy = uptodateDisOffFamNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_af
	 */
	public java.lang.Integer getUptodateDisOrsAf() {
		return uptodateDisOrsAf;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_af
	 * 
	 * @param uptodateDisOrsAf
	 *            the uptodate_dis_ors_af value
	 */
	public void setUptodateDisOrsAf(java.lang.Integer uptodateDisOrsAf) {
		this.uptodateDisOrsAf = uptodateDisOrsAf;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_army
	 */
	public java.lang.Integer getUptodateDisOrsArmy() {
		return uptodateDisOrsArmy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_army
	 * 
	 * @param uptodateDisOrsArmy
	 *            the uptodate_dis_ors_army value
	 */
	public void setUptodateDisOrsArmy(java.lang.Integer uptodateDisOrsArmy) {
		this.uptodateDisOrsArmy = uptodateDisOrsArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_navy
	 */
	public java.lang.Integer getUptodateDisOrsNavy() {
		return uptodateDisOrsNavy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_navy
	 * 
	 * @param uptodateDisOrsNavy
	 *            the uptodate_dis_ors_navy value
	 */
	public void setUptodateDisOrsNavy(java.lang.Integer uptodateDisOrsNavy) {
		this.uptodateDisOrsNavy = uptodateDisOrsNavy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_fam_af
	 */
	public java.lang.Integer getUptodateDisOrsFamAf() {
		return uptodateDisOrsFamAf;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_fam_af
	 * 
	 * @param uptodateDisOrsFamAf
	 *            the uptodate_dis_ors_fam_af value
	 */
	public void setUptodateDisOrsFamAf(java.lang.Integer uptodateDisOrsFamAf) {
		this.uptodateDisOrsFamAf = uptodateDisOrsFamAf;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_fam_army
	 */
	public java.lang.Integer getUptodateDisOrsFamArmy() {
		return uptodateDisOrsFamArmy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_fam_army
	 * 
	 * @param uptodateDisOrsFamArmy
	 *            the uptodate_dis_ors_fam_army value
	 */
	public void setUptodateDisOrsFamArmy(java.lang.Integer uptodateDisOrsFamArmy) {
		this.uptodateDisOrsFamArmy = uptodateDisOrsFamArmy;
	}

	/**
	 * Return the value associated with the column: uptodate_dis_ors_fam_navy
	 */
	public java.lang.Integer getUptodateDisOrsFamNavy() {
		return uptodateDisOrsFamNavy;
	}

	/**
	 * Set the value related to the column: uptodate_dis_ors_fam_navy
	 * 
	 * @param uptodateDisOrsFamNavy
	 *            the uptodate_dis_ors_fam_navy value
	 */
	public void setUptodateDisOrsFamNavy(java.lang.Integer uptodateDisOrsFamNavy) {
		this.uptodateDisOrsFamNavy = uptodateDisOrsFamNavy;
	}

	/**
	 * Return the value associated with the column: remd_army
	 */
	public java.lang.Integer getRemdArmy() {
		return remdArmy;
	}

	/**
	 * Set the value related to the column: remd_army
	 * 
	 * @param remdArmy
	 *            the remd_army value
	 */
	public void setRemdArmy(java.lang.Integer remdArmy) {
		this.remdArmy = remdArmy;
	}

	/**
	 * Return the value associated with the column: remd_af
	 */
	public java.lang.Integer getRemdAf() {
		return remdAf;
	}

	/**
	 * Set the value related to the column: remd_af
	 * 
	 * @param remdAf
	 *            the remd_af value
	 */
	public void setRemdAf(java.lang.Integer remdAf) {
		this.remdAf = remdAf;
	}

	/**
	 * Return the value associated with the column: remd_navy
	 */
	public java.lang.Integer getRemdNavy() {
		return remdNavy;
	}

	/**
	 * Set the value related to the column: remd_navy
	 * 
	 * @param remdNavy
	 *            the remd_navy value
	 */
	public void setRemdNavy(java.lang.Integer remdNavy) {
		this.remdNavy = remdNavy;
	}

	/**
	 * Return the value associated with the column: remd_cene
	 */
	public java.lang.Integer getRemdCene() {
		return remdCene;
	}

	/**
	 * Set the value related to the column: remd_cene
	 * 
	 * @param remdCene
	 *            the remd_cene value
	 */
	public void setRemdCene(java.lang.Integer remdCene) {
		this.remdCene = remdCene;
	}

	/**
	 * Return the value associated with the column: remd_fore
	 */
	public java.lang.Integer getRemdFore() {
		return remdFore;
	}

	/**
	 * Set the value related to the column: remd_fore
	 * 
	 * @param remdFore
	 *            the remd_fore value
	 */
	public void setRemdFore(java.lang.Integer remdFore) {
		this.remdFore = remdFore;
	}

	/**
	 * Return the value associated with the column: remd_off_af
	 */
	public java.lang.Integer getRemdOffAf() {
		return remdOffAf;
	}

	/**
	 * Set the value related to the column: remd_off_af
	 * 
	 * @param remdOffAf
	 *            the remd_off_af value
	 */
	public void setRemdOffAf(java.lang.Integer remdOffAf) {
		this.remdOffAf = remdOffAf;
	}

	/**
	 * Return the value associated with the column: remd_off_army
	 */
	public java.lang.Integer getRemdOffArmy() {
		return remdOffArmy;
	}

	/**
	 * Set the value related to the column: remd_off_army
	 * 
	 * @param remdOffArmy
	 *            the remd_off_army value
	 */
	public void setRemdOffArmy(java.lang.Integer remdOffArmy) {
		this.remdOffArmy = remdOffArmy;
	}

	/**
	 * Return the value associated with the column: remd_off_navy
	 */
	public java.lang.Integer getRemdOffNavy() {
		return remdOffNavy;
	}

	/**
	 * Set the value related to the column: remd_off_navy
	 * 
	 * @param remdOffNavy
	 *            the remd_off_navy value
	 */
	public void setRemdOffNavy(java.lang.Integer remdOffNavy) {
		this.remdOffNavy = remdOffNavy;
	}

	/**
	 * Return the value associated with the column: remd_off_fam_af
	 */
	public java.lang.Integer getRemdOffFamAf() {
		return remdOffFamAf;
	}

	/**
	 * Set the value related to the column: remd_off_fam_af
	 * 
	 * @param remdOffFamAf
	 *            the remd_off_fam_af value
	 */
	public void setRemdOffFamAf(java.lang.Integer remdOffFamAf) {
		this.remdOffFamAf = remdOffFamAf;
	}

	/**
	 * Return the value associated with the column: remd_off_fam_army
	 */
	public java.lang.Integer getRemdOffFamArmy() {
		return remdOffFamArmy;
	}

	/**
	 * Set the value related to the column: remd_off_fam_army
	 * 
	 * @param remdOffFamArmy
	 *            the remd_off_fam_army value
	 */
	public void setRemdOffFamArmy(java.lang.Integer remdOffFamArmy) {
		this.remdOffFamArmy = remdOffFamArmy;
	}

	/**
	 * Return the value associated with the column: remd_off_fam_navy
	 */
	public java.lang.Integer getRemdOffFamNavy() {
		return remdOffFamNavy;
	}

	/**
	 * Set the value related to the column: remd_off_fam_navy
	 * 
	 * @param remdOffFamNavy
	 *            the remd_off_fam_navy value
	 */
	public void setRemdOffFamNavy(java.lang.Integer remdOffFamNavy) {
		this.remdOffFamNavy = remdOffFamNavy;
	}

	/**
	 * Return the value associated with the column: remd_ors_af
	 */
	public java.lang.Integer getRemdOrsAf() {
		return remdOrsAf;
	}

	/**
	 * Set the value related to the column: remd_ors_af
	 * 
	 * @param remdOrsAf
	 *            the remd_ors_af value
	 */
	public void setRemdOrsAf(java.lang.Integer remdOrsAf) {
		this.remdOrsAf = remdOrsAf;
	}

	/**
	 * Return the value associated with the column: remd_ors_army
	 */
	public java.lang.Integer getRemdOrsArmy() {
		return remdOrsArmy;
	}

	/**
	 * Set the value related to the column: remd_ors_army
	 * 
	 * @param remdOrsArmy
	 *            the remd_ors_army value
	 */
	public void setRemdOrsArmy(java.lang.Integer remdOrsArmy) {
		this.remdOrsArmy = remdOrsArmy;
	}

	/**
	 * Return the value associated with the column: remd_ors_navy
	 */
	public java.lang.Integer getRemdOrsNavy() {
		return remdOrsNavy;
	}

	/**
	 * Set the value related to the column: remd_ors_navy
	 * 
	 * @param remdOrsNavy
	 *            the remd_ors_navy value
	 */
	public void setRemdOrsNavy(java.lang.Integer remdOrsNavy) {
		this.remdOrsNavy = remdOrsNavy;
	}

	/**
	 * Return the value associated with the column: remd_ors_fam_af
	 */
	public java.lang.Integer getRemdOrsFamAf() {
		return remdOrsFamAf;
	}

	/**
	 * Set the value related to the column: remd_ors_fam_af
	 * 
	 * @param remdOrsFamAf
	 *            the remd_ors_fam_af value
	 */
	public void setRemdOrsFamAf(java.lang.Integer remdOrsFamAf) {
		this.remdOrsFamAf = remdOrsFamAf;
	}

	/**
	 * Return the value associated with the column: remd_ors_fam_army
	 */
	public java.lang.Integer getRemdOrsFamArmy() {
		return remdOrsFamArmy;
	}

	/**
	 * Set the value related to the column: remd_ors_fam_army
	 * 
	 * @param remdOrsFamArmy
	 *            the remd_ors_fam_army value
	 */
	public void setRemdOrsFamArmy(java.lang.Integer remdOrsFamArmy) {
		this.remdOrsFamArmy = remdOrsFamArmy;
	}

	/**
	 * Return the value associated with the column: remd_ors_fam_navy
	 */
	public java.lang.Integer getRemdOrsFamNavy() {
		return remdOrsFamNavy;
	}

	/**
	 * Set the value related to the column: remd_ors_fam_navy
	 * 
	 * @param remdOrsFamNavy
	 *            the remd_ors_fam_navy value
	 */
	public void setRemdOrsFamNavy(java.lang.Integer remdOrsFamNavy) {
		this.remdOrsFamNavy = remdOrsFamNavy;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MisMonthlyBedSts))
			return false;
		else {
			jkt.hms.masters.business.MisMonthlyBedSts misMonthlyBedSts = (jkt.hms.masters.business.MisMonthlyBedSts) obj;
			if (null == this.getId() || null == misMonthlyBedSts.getId())
				return false;
			else
				return (this.getId().equals(misMonthlyBedSts.getId()));
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