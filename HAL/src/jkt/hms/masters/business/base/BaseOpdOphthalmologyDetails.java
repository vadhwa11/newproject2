package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_ophthalmology_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_ophthalmology_details"
 */

public abstract class BaseOpdOphthalmologyDetails  implements Serializable {

	public static String REF = "OpdOphthalmologyDetails";
	public static String PROP_LE_LIMBUS = "LeLimbus";
	public static String PROP_RE_PUPILS = "RePupils";
	public static String PROP_DIST_R_UNCORRECTED = "DistRUncorrected";
	public static String PROP_LE_FORNIX = "LeFornix";
	public static String PROP_LE_FOVEA = "LeFovea";
	public static String PROP_NEAR_L_SPH = "NearLSph";
	public static String PROP_NEAR_L_UNCORRECTED = "NearLUncorrected";
	public static String PROP_LE_CORNEA = "LeCornea";
	public static String PROP_RE_ANTERIOR = "ReAnterior";
	public static String PROP_NEAR_R_UNCORRECTED = "NearRUncorrected";
	public static String PROP_EYE_IPD = "EyeIpd";
	public static String PROP_RE_EYELID = "ReEyelid";
	public static String PROP_LE_FIELD_VN = "LeFieldVn";
	public static String PROP_LE_OPTIC_DISC = "LeOpticDisc";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_RE_COLOUR_VISION = "ReColourVision";
	public static String PROP_LE_LENS = "LeLens";
	public static String PROP_RE_CORNEA = "ReCornea";
	public static String PROP_RE_VITREOUS_ANTERIOR = "ReVitreousAnterior";
	public static String PROP_RETINA_LE = "RetinaLe";
	public static String PROP_RETINOSCOPY_LE_AXIS = "RetinoscopyLeAxis";
	public static String PROP_NEAR_R_BEST_CORRECTED = "NearRBestCorrected";
	public static String PROP_LE_PACHYMETRY = "LePachymetry";
	public static String PROP_CONSULTATION_TIME = "ConsultationTime";
	public static String PROP_RE_FOVEA = "ReFovea";
	public static String PROP_DIST_L_AXIS = "DistLAxis";
	public static String PROP_VISION_IPD = "VisionIpd";
	public static String PROP_LE_BLOOD_VESSELS = "LeBloodVessels";
	public static String PROP_LE_ANTERIOR = "LeAnterior";
	public static String PROP_LE_CONJUNCTION = "LeConjunction";
	public static String PROP_LE_IRIS = "LeIris";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LE_COLOUR_VISION = "LeColourVision";
	public static String PROP_DIST_L_BEST_CORRECTED = "DistLBestCorrected";
	public static String PROP_RE_FIELD_VN = "ReFieldVn";
	public static String PROP_DIST_R_AXIS = "DistRAxis";
	public static String PROP_RE_OPTIC_DISC = "ReOpticDisc";
	public static String PROP_DIST_L_CYL = "DistLCyl";
	public static String PROP_ID = "Id";
	public static String PROP_LE_EYEBROW = "LeEyebrow";
	public static String PROP_RE_KERATOMETRY = "ReKeratometry";
	public static String PROP_RETINOSCOPY_RE_V = "RetinoscopyReV";
	public static String PROP_LE_ANTERIOR_CHAMBER = "LeAnteriorChamber";
	public static String PROP_CONSULTATION_DATE = "ConsultationDate";
	public static String PROP_LENS_TYPE = "LensType";
	public static String PROP_NEAR_L_CYL = "NearLCyl";
	public static String PROP_NEAR_L_BEST_CORRECTED = "NearLBestCorrected";
	public static String PROP_RE_CONJUNCTION = "ReConjunction";
	public static String PROP_RE_BLOOD_VESSELS = "ReBloodVessels";
	public static String PROP_LE_EYELID = "LeEyelid";
	public static String PROP_DIST_R_SPH = "DistRSph";
	public static String PROP_DIST_L_SPH = "DistLSph";
	public static String PROP_RETINOSCOPY_RE_H = "RetinoscopyReH";
	public static String PROP_NEAR_L_AXIS = "NearLAxis";
	public static String PROP_LE_NON_CONTACT_TONOMETRY = "LeNonContactTonometry";
	public static String PROP_RETINA_RE = "RetinaRe";
	public static String PROP_RE_LENS = "ReLens";
	public static String PROP_EYE_USE = "EyeUse";
	public static String PROP_RETINOSCOPY_LE_V = "RetinoscopyLeV";
	public static String PROP_LE_VITREOUS_ANTERIOR = "LeVitreousAnterior";
	public static String PROP_IOL_RE = "IolRe";
	public static String PROP_DIST_L_UNCORRECTED = "DistLUncorrected";
	public static String PROP_RE_NON_CONTACT_TONOMETRY = "ReNonContactTonometry";
	public static String PROP_RETINOSCOPY_LE_H = "RetinoscopyLeH";
	public static String PROP_NEAR_R_CYL = "NearRCyl";
	public static String PROP_LE_SCLERA = "LeSclera";
	public static String PROP_NEAR_L_PINHOLE = "NearLPinhole";
	public static String PROP_NEAR_R_PINHOLE = "NearRPinhole";
	public static String PROP_RE_FORNIX = "ReFornix";
	public static String PROP_NEAR_R_SPH = "NearRSph";
	public static String PROP_RE_EYEBROW = "ReEyebrow";
	public static String PROP_RETINOSCOPY_RE_AXIS = "RetinoscopyReAxis";
	public static String PROP_DIST_R_CYL = "DistRCyl";
	public static String PROP_RE_VITREOUS_POSTERIOR = "ReVitreousPosterior";
	public static String PROP_RE_LIMBUS = "ReLimbus";
	public static String PROP_LE_KERATOMETRY = "LeKeratometry";
	public static String PROP_LE_VITREOUS_POSTERIOR = "LeVitreousPosterior";
	public static String PROP_DIST_L_PINHOLE = "DistLPinhole";
	public static String PROP_VISION_FUNDUS = "VisionFundus";
	public static String PROP_LE_PUPILS = "LePupils";
	public static String PROP_DIST_R_BEST_CORRECTED = "DistRBestCorrected";
	public static String PROP_IOL_LE = "IolLe";
	public static String PROP_NEAR_R_AXIS = "NearRAxis";
	public static String PROP_RE_IRIS = "ReIris";
	public static String PROP_DIST_R_PINHOLE = "DistRPinhole";
	public static String PROP_RE_PACHYMETRY = "RePachymetry";
	public static String PROP_RE_ANTERIOR_CHAMBER = "ReAnteriorChamber";
	public static String PROP_RE_SCLERA = "ReSclera";


	// constructors
	public BaseOpdOphthalmologyDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphthalmologyDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String distRSph;
	private java.lang.String distRCyl;
	private java.lang.String distRAxis;
	private java.lang.String distLSph;
	private java.lang.String distLCyl;
	private java.lang.String distLAxis;
	private java.lang.String nearRSph;
	private java.lang.String nearRCyl;
	private java.lang.String nearRAxis;
	private java.lang.String nearLSph;
	private java.lang.String nearLCyl;
	private java.lang.String nearLAxis;
	private java.lang.Integer eyeIpd;
	private java.lang.String eyeUse;
	private java.lang.String lensType;
	private java.lang.String distRUncorrected;
	private java.lang.String distRPinhole;
	private java.lang.String distRBestCorrected;
	private java.lang.String distLUncorrected;
	private java.lang.String distLPinhole;
	private java.lang.String distLBestCorrected;
	private java.lang.String nearRUncorrected;
	private java.lang.String nearRPinhole;
	private java.lang.String nearRBestCorrected;
	private java.lang.String nearLUncorrected;
	private java.lang.String nearLPinhole;
	private java.lang.String nearLBestCorrected;
	private java.lang.String visionIpd;
	private java.lang.String visionFundus;
	private java.lang.String retinoscopyReV;
	private java.lang.String retinoscopyReAxis;
	private java.lang.String retinoscopyLeV;
	private java.lang.String retinoscopyLeAxis;
	private java.lang.String reKeratometry;
	private java.lang.String rePachymetry;
	private java.lang.String reNonContactTonometry;
	private java.lang.String reFieldVn;
	private java.lang.String leKeratometry;
	private java.lang.String lePachymetry;
	private java.lang.String leNonContactTonometry;
	private java.lang.String leFieldVn;
	private java.lang.String reEyebrow;
	private java.lang.String reEyelid;
	private java.lang.String reCornea;
	private java.lang.String reConjunction;
	private java.lang.String reAnteriorChamber;
	private java.lang.String reIris;
	private java.lang.String rePupils;
	private java.lang.String reLens;
	private java.lang.String reAnterior;
	private java.lang.String reVitreousAnterior;
	private java.lang.String reFornix;
	private java.lang.String reLimbus;
	private java.lang.String reSclera;
	private java.lang.String leEyebrow;
	private java.lang.String leEyelid;
	private java.lang.String leCornea;
	private java.lang.String leConjunction;
	private java.lang.String leAnteriorChamber;
	private java.lang.String leIris;
	private java.lang.String lePupils;
	private java.lang.String leLens;
	private java.lang.String leAnterior;
	private java.lang.String leVitreousAnterior;
	private java.lang.String leFornix;
	private java.lang.String leLimbus;
	private java.lang.String leSclera;
	private java.lang.String reOpticDisc;
	private java.lang.String reFovea;
	private java.lang.String reVitreousPosterior;
	private java.lang.String reBloodVessels;
	private java.lang.String leOpticDisc;
	private java.lang.String leFovea;
	private java.lang.String leVitreousPosterior;
	private java.lang.String leBloodVessels;
	private java.lang.String reColourVision;
	private java.lang.String leColourVision;
	private java.util.Date consultationDate;
	private java.lang.String consultationTime;
	private java.lang.String retinoscopyReH;
	private java.lang.String retinoscopyLeH;
	private java.lang.String retinaRe;
	private java.lang.String retinaLe;
	private java.lang.String iolRe;
	private java.lang.String iolLe;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: dist_r_sph
	 */
	public java.lang.String getDistRSph () {
		return distRSph;
	}

	/**
	 * Set the value related to the column: dist_r_sph
	 * @param distRSph the dist_r_sph value
	 */
	public void setDistRSph (java.lang.String distRSph) {
		this.distRSph = distRSph;
	}



	/**
	 * Return the value associated with the column: dist_r_cyl
	 */
	public java.lang.String getDistRCyl () {
		return distRCyl;
	}

	/**
	 * Set the value related to the column: dist_r_cyl
	 * @param distRCyl the dist_r_cyl value
	 */
	public void setDistRCyl (java.lang.String distRCyl) {
		this.distRCyl = distRCyl;
	}



	/**
	 * Return the value associated with the column: dist_r_axis
	 */
	public java.lang.String getDistRAxis () {
		return distRAxis;
	}

	/**
	 * Set the value related to the column: dist_r_axis
	 * @param distRAxis the dist_r_axis value
	 */
	public void setDistRAxis (java.lang.String distRAxis) {
		this.distRAxis = distRAxis;
	}



	/**
	 * Return the value associated with the column: dist_l_sph
	 */
	public java.lang.String getDistLSph () {
		return distLSph;
	}

	/**
	 * Set the value related to the column: dist_l_sph
	 * @param distLSph the dist_l_sph value
	 */
	public void setDistLSph (java.lang.String distLSph) {
		this.distLSph = distLSph;
	}



	/**
	 * Return the value associated with the column: dist_l_cyl
	 */
	public java.lang.String getDistLCyl () {
		return distLCyl;
	}

	/**
	 * Set the value related to the column: dist_l_cyl
	 * @param distLCyl the dist_l_cyl value
	 */
	public void setDistLCyl (java.lang.String distLCyl) {
		this.distLCyl = distLCyl;
	}



	/**
	 * Return the value associated with the column: dist_l_axis
	 */
	public java.lang.String getDistLAxis () {
		return distLAxis;
	}

	/**
	 * Set the value related to the column: dist_l_axis
	 * @param distLAxis the dist_l_axis value
	 */
	public void setDistLAxis (java.lang.String distLAxis) {
		this.distLAxis = distLAxis;
	}



	/**
	 * Return the value associated with the column: near_r_sph
	 */
	public java.lang.String getNearRSph () {
		return nearRSph;
	}

	/**
	 * Set the value related to the column: near_r_sph
	 * @param nearRSph the near_r_sph value
	 */
	public void setNearRSph (java.lang.String nearRSph) {
		this.nearRSph = nearRSph;
	}



	/**
	 * Return the value associated with the column: near_r_cyl
	 */
	public java.lang.String getNearRCyl () {
		return nearRCyl;
	}

	/**
	 * Set the value related to the column: near_r_cyl
	 * @param nearRCyl the near_r_cyl value
	 */
	public void setNearRCyl (java.lang.String nearRCyl) {
		this.nearRCyl = nearRCyl;
	}



	/**
	 * Return the value associated with the column: near_r_axis
	 */
	public java.lang.String getNearRAxis () {
		return nearRAxis;
	}

	/**
	 * Set the value related to the column: near_r_axis
	 * @param nearRAxis the near_r_axis value
	 */
	public void setNearRAxis (java.lang.String nearRAxis) {
		this.nearRAxis = nearRAxis;
	}



	/**
	 * Return the value associated with the column: near_l_sph
	 */
	public java.lang.String getNearLSph () {
		return nearLSph;
	}

	/**
	 * Set the value related to the column: near_l_sph
	 * @param nearLSph the near_l_sph value
	 */
	public void setNearLSph (java.lang.String nearLSph) {
		this.nearLSph = nearLSph;
	}



	/**
	 * Return the value associated with the column: near_l_cyl
	 */
	public java.lang.String getNearLCyl () {
		return nearLCyl;
	}

	/**
	 * Set the value related to the column: near_l_cyl
	 * @param nearLCyl the near_l_cyl value
	 */
	public void setNearLCyl (java.lang.String nearLCyl) {
		this.nearLCyl = nearLCyl;
	}



	/**
	 * Return the value associated with the column: near_l_axis
	 */
	public java.lang.String getNearLAxis () {
		return nearLAxis;
	}

	/**
	 * Set the value related to the column: near_l_axis
	 * @param nearLAxis the near_l_axis value
	 */
	public void setNearLAxis (java.lang.String nearLAxis) {
		this.nearLAxis = nearLAxis;
	}



	/**
	 * Return the value associated with the column: eye_ipd
	 */
	public java.lang.Integer getEyeIpd () {
		return eyeIpd;
	}

	/**
	 * Set the value related to the column: eye_ipd
	 * @param eyeIpd the eye_ipd value
	 */
	public void setEyeIpd (java.lang.Integer eyeIpd) {
		this.eyeIpd = eyeIpd;
	}



	/**
	 * Return the value associated with the column: eye_use
	 */
	public java.lang.String getEyeUse () {
		return eyeUse;
	}

	/**
	 * Set the value related to the column: eye_use
	 * @param eyeUse the eye_use value
	 */
	public void setEyeUse (java.lang.String eyeUse) {
		this.eyeUse = eyeUse;
	}



	/**
	 * Return the value associated with the column: lens_type
	 */
	public java.lang.String getLensType () {
		return lensType;
	}

	/**
	 * Set the value related to the column: lens_type
	 * @param lensType the lens_type value
	 */
	public void setLensType (java.lang.String lensType) {
		this.lensType = lensType;
	}



	/**
	 * Return the value associated with the column: dist_r_uncorrected
	 */
	public java.lang.String getDistRUncorrected () {
		return distRUncorrected;
	}

	/**
	 * Set the value related to the column: dist_r_uncorrected
	 * @param distRUncorrected the dist_r_uncorrected value
	 */
	public void setDistRUncorrected (java.lang.String distRUncorrected) {
		this.distRUncorrected = distRUncorrected;
	}



	/**
	 * Return the value associated with the column: dist_r_pinhole
	 */
	public java.lang.String getDistRPinhole () {
		return distRPinhole;
	}

	/**
	 * Set the value related to the column: dist_r_pinhole
	 * @param distRPinhole the dist_r_pinhole value
	 */
	public void setDistRPinhole (java.lang.String distRPinhole) {
		this.distRPinhole = distRPinhole;
	}



	/**
	 * Return the value associated with the column: dist_r_best_corrected
	 */
	public java.lang.String getDistRBestCorrected () {
		return distRBestCorrected;
	}

	/**
	 * Set the value related to the column: dist_r_best_corrected
	 * @param distRBestCorrected the dist_r_best_corrected value
	 */
	public void setDistRBestCorrected (java.lang.String distRBestCorrected) {
		this.distRBestCorrected = distRBestCorrected;
	}



	/**
	 * Return the value associated with the column: dist_l_uncorrected
	 */
	public java.lang.String getDistLUncorrected () {
		return distLUncorrected;
	}

	/**
	 * Set the value related to the column: dist_l_uncorrected
	 * @param distLUncorrected the dist_l_uncorrected value
	 */
	public void setDistLUncorrected (java.lang.String distLUncorrected) {
		this.distLUncorrected = distLUncorrected;
	}



	/**
	 * Return the value associated with the column: dist_l_pinhole
	 */
	public java.lang.String getDistLPinhole () {
		return distLPinhole;
	}

	/**
	 * Set the value related to the column: dist_l_pinhole
	 * @param distLPinhole the dist_l_pinhole value
	 */
	public void setDistLPinhole (java.lang.String distLPinhole) {
		this.distLPinhole = distLPinhole;
	}



	/**
	 * Return the value associated with the column: dist_l_best_corrected
	 */
	public java.lang.String getDistLBestCorrected () {
		return distLBestCorrected;
	}

	/**
	 * Set the value related to the column: dist_l_best_corrected
	 * @param distLBestCorrected the dist_l_best_corrected value
	 */
	public void setDistLBestCorrected (java.lang.String distLBestCorrected) {
		this.distLBestCorrected = distLBestCorrected;
	}



	/**
	 * Return the value associated with the column: near_r_uncorrected
	 */
	public java.lang.String getNearRUncorrected () {
		return nearRUncorrected;
	}

	/**
	 * Set the value related to the column: near_r_uncorrected
	 * @param nearRUncorrected the near_r_uncorrected value
	 */
	public void setNearRUncorrected (java.lang.String nearRUncorrected) {
		this.nearRUncorrected = nearRUncorrected;
	}



	/**
	 * Return the value associated with the column: near_r_pinhole
	 */
	public java.lang.String getNearRPinhole () {
		return nearRPinhole;
	}

	/**
	 * Set the value related to the column: near_r_pinhole
	 * @param nearRPinhole the near_r_pinhole value
	 */
	public void setNearRPinhole (java.lang.String nearRPinhole) {
		this.nearRPinhole = nearRPinhole;
	}



	/**
	 * Return the value associated with the column: near_r_best_corrected
	 */
	public java.lang.String getNearRBestCorrected () {
		return nearRBestCorrected;
	}

	/**
	 * Set the value related to the column: near_r_best_corrected
	 * @param nearRBestCorrected the near_r_best_corrected value
	 */
	public void setNearRBestCorrected (java.lang.String nearRBestCorrected) {
		this.nearRBestCorrected = nearRBestCorrected;
	}



	/**
	 * Return the value associated with the column: near_l_uncorrected
	 */
	public java.lang.String getNearLUncorrected () {
		return nearLUncorrected;
	}

	/**
	 * Set the value related to the column: near_l_uncorrected
	 * @param nearLUncorrected the near_l_uncorrected value
	 */
	public void setNearLUncorrected (java.lang.String nearLUncorrected) {
		this.nearLUncorrected = nearLUncorrected;
	}



	/**
	 * Return the value associated with the column: near_l_pinhole
	 */
	public java.lang.String getNearLPinhole () {
		return nearLPinhole;
	}

	/**
	 * Set the value related to the column: near_l_pinhole
	 * @param nearLPinhole the near_l_pinhole value
	 */
	public void setNearLPinhole (java.lang.String nearLPinhole) {
		this.nearLPinhole = nearLPinhole;
	}



	/**
	 * Return the value associated with the column: near_l_best_corrected
	 */
	public java.lang.String getNearLBestCorrected () {
		return nearLBestCorrected;
	}

	/**
	 * Set the value related to the column: near_l_best_corrected
	 * @param nearLBestCorrected the near_l_best_corrected value
	 */
	public void setNearLBestCorrected (java.lang.String nearLBestCorrected) {
		this.nearLBestCorrected = nearLBestCorrected;
	}



	/**
	 * Return the value associated with the column: vision_ipd
	 */
	public java.lang.String getVisionIpd () {
		return visionIpd;
	}

	/**
	 * Set the value related to the column: vision_ipd
	 * @param visionIpd the vision_ipd value
	 */
	public void setVisionIpd (java.lang.String visionIpd) {
		this.visionIpd = visionIpd;
	}



	/**
	 * Return the value associated with the column: vision_fundus
	 */
	public java.lang.String getVisionFundus () {
		return visionFundus;
	}

	/**
	 * Set the value related to the column: vision_fundus
	 * @param visionFundus the vision_fundus value
	 */
	public void setVisionFundus (java.lang.String visionFundus) {
		this.visionFundus = visionFundus;
	}



	/**
	 * Return the value associated with the column: retinoscopy_re_v
	 */
	public java.lang.String getRetinoscopyReV () {
		return retinoscopyReV;
	}

	/**
	 * Set the value related to the column: retinoscopy_re_v
	 * @param retinoscopyReV the retinoscopy_re_v value
	 */
	public void setRetinoscopyReV (java.lang.String retinoscopyReV) {
		this.retinoscopyReV = retinoscopyReV;
	}



	/**
	 * Return the value associated with the column: retinoscopy_re_axis
	 */
	public java.lang.String getRetinoscopyReAxis () {
		return retinoscopyReAxis;
	}

	/**
	 * Set the value related to the column: retinoscopy_re_axis
	 * @param retinoscopyReAxis the retinoscopy_re_axis value
	 */
	public void setRetinoscopyReAxis (java.lang.String retinoscopyReAxis) {
		this.retinoscopyReAxis = retinoscopyReAxis;
	}



	/**
	 * Return the value associated with the column: retinoscopy_le_v
	 */
	public java.lang.String getRetinoscopyLeV () {
		return retinoscopyLeV;
	}

	/**
	 * Set the value related to the column: retinoscopy_le_v
	 * @param retinoscopyLeV the retinoscopy_le_v value
	 */
	public void setRetinoscopyLeV (java.lang.String retinoscopyLeV) {
		this.retinoscopyLeV = retinoscopyLeV;
	}



	/**
	 * Return the value associated with the column: retinoscopy_le_axis
	 */
	public java.lang.String getRetinoscopyLeAxis () {
		return retinoscopyLeAxis;
	}

	/**
	 * Set the value related to the column: retinoscopy_le_axis
	 * @param retinoscopyLeAxis the retinoscopy_le_axis value
	 */
	public void setRetinoscopyLeAxis (java.lang.String retinoscopyLeAxis) {
		this.retinoscopyLeAxis = retinoscopyLeAxis;
	}



	/**
	 * Return the value associated with the column: re_keratometry
	 */
	public java.lang.String getReKeratometry () {
		return reKeratometry;
	}

	/**
	 * Set the value related to the column: re_keratometry
	 * @param reKeratometry the re_keratometry value
	 */
	public void setReKeratometry (java.lang.String reKeratometry) {
		this.reKeratometry = reKeratometry;
	}



	/**
	 * Return the value associated with the column: re_pachymetry
	 */
	public java.lang.String getRePachymetry () {
		return rePachymetry;
	}

	/**
	 * Set the value related to the column: re_pachymetry
	 * @param rePachymetry the re_pachymetry value
	 */
	public void setRePachymetry (java.lang.String rePachymetry) {
		this.rePachymetry = rePachymetry;
	}



	/**
	 * Return the value associated with the column: re_Non_contact_tonometry
	 */
	public java.lang.String getReNonContactTonometry () {
		return reNonContactTonometry;
	}

	/**
	 * Set the value related to the column: re_Non_contact_tonometry
	 * @param reNonContactTonometry the re_Non_contact_tonometry value
	 */
	public void setReNonContactTonometry (java.lang.String reNonContactTonometry) {
		this.reNonContactTonometry = reNonContactTonometry;
	}



	/**
	 * Return the value associated with the column: re_field_vn
	 */
	public java.lang.String getReFieldVn () {
		return reFieldVn;
	}

	/**
	 * Set the value related to the column: re_field_vn
	 * @param reFieldVn the re_field_vn value
	 */
	public void setReFieldVn (java.lang.String reFieldVn) {
		this.reFieldVn = reFieldVn;
	}



	/**
	 * Return the value associated with the column: le_keratometry
	 */
	public java.lang.String getLeKeratometry () {
		return leKeratometry;
	}

	/**
	 * Set the value related to the column: le_keratometry
	 * @param leKeratometry the le_keratometry value
	 */
	public void setLeKeratometry (java.lang.String leKeratometry) {
		this.leKeratometry = leKeratometry;
	}



	/**
	 * Return the value associated with the column: le_pachymetry
	 */
	public java.lang.String getLePachymetry () {
		return lePachymetry;
	}

	/**
	 * Set the value related to the column: le_pachymetry
	 * @param lePachymetry the le_pachymetry value
	 */
	public void setLePachymetry (java.lang.String lePachymetry) {
		this.lePachymetry = lePachymetry;
	}



	/**
	 * Return the value associated with the column: le_Non_contact_tonometry
	 */
	public java.lang.String getLeNonContactTonometry () {
		return leNonContactTonometry;
	}

	/**
	 * Set the value related to the column: le_Non_contact_tonometry
	 * @param leNonContactTonometry the le_Non_contact_tonometry value
	 */
	public void setLeNonContactTonometry (java.lang.String leNonContactTonometry) {
		this.leNonContactTonometry = leNonContactTonometry;
	}



	/**
	 * Return the value associated with the column: le_field_vn
	 */
	public java.lang.String getLeFieldVn () {
		return leFieldVn;
	}

	/**
	 * Set the value related to the column: le_field_vn
	 * @param leFieldVn the le_field_vn value
	 */
	public void setLeFieldVn (java.lang.String leFieldVn) {
		this.leFieldVn = leFieldVn;
	}



	/**
	 * Return the value associated with the column: re_eyebrow
	 */
	public java.lang.String getReEyebrow () {
		return reEyebrow;
	}

	/**
	 * Set the value related to the column: re_eyebrow
	 * @param reEyebrow the re_eyebrow value
	 */
	public void setReEyebrow (java.lang.String reEyebrow) {
		this.reEyebrow = reEyebrow;
	}



	/**
	 * Return the value associated with the column: re_eyelid
	 */
	public java.lang.String getReEyelid () {
		return reEyelid;
	}

	/**
	 * Set the value related to the column: re_eyelid
	 * @param reEyelid the re_eyelid value
	 */
	public void setReEyelid (java.lang.String reEyelid) {
		this.reEyelid = reEyelid;
	}



	/**
	 * Return the value associated with the column: re_cornea
	 */
	public java.lang.String getReCornea () {
		return reCornea;
	}

	/**
	 * Set the value related to the column: re_cornea
	 * @param reCornea the re_cornea value
	 */
	public void setReCornea (java.lang.String reCornea) {
		this.reCornea = reCornea;
	}



	/**
	 * Return the value associated with the column: re_conjunction
	 */
	public java.lang.String getReConjunction () {
		return reConjunction;
	}

	/**
	 * Set the value related to the column: re_conjunction
	 * @param reConjunction the re_conjunction value
	 */
	public void setReConjunction (java.lang.String reConjunction) {
		this.reConjunction = reConjunction;
	}



	/**
	 * Return the value associated with the column: re_anterior_chamber
	 */
	public java.lang.String getReAnteriorChamber () {
		return reAnteriorChamber;
	}

	/**
	 * Set the value related to the column: re_anterior_chamber
	 * @param reAnteriorChamber the re_anterior_chamber value
	 */
	public void setReAnteriorChamber (java.lang.String reAnteriorChamber) {
		this.reAnteriorChamber = reAnteriorChamber;
	}



	/**
	 * Return the value associated with the column: re_iris
	 */
	public java.lang.String getReIris () {
		return reIris;
	}

	/**
	 * Set the value related to the column: re_iris
	 * @param reIris the re_iris value
	 */
	public void setReIris (java.lang.String reIris) {
		this.reIris = reIris;
	}



	/**
	 * Return the value associated with the column: re_pupils
	 */
	public java.lang.String getRePupils () {
		return rePupils;
	}

	/**
	 * Set the value related to the column: re_pupils
	 * @param rePupils the re_pupils value
	 */
	public void setRePupils (java.lang.String rePupils) {
		this.rePupils = rePupils;
	}



	/**
	 * Return the value associated with the column: re_Lens
	 */
	public java.lang.String getReLens () {
		return reLens;
	}

	/**
	 * Set the value related to the column: re_Lens
	 * @param reLens the re_Lens value
	 */
	public void setReLens (java.lang.String reLens) {
		this.reLens = reLens;
	}



	/**
	 * Return the value associated with the column: re_anterior
	 */
	public java.lang.String getReAnterior () {
		return reAnterior;
	}

	/**
	 * Set the value related to the column: re_anterior
	 * @param reAnterior the re_anterior value
	 */
	public void setReAnterior (java.lang.String reAnterior) {
		this.reAnterior = reAnterior;
	}



	/**
	 * Return the value associated with the column: re_vitreous_anterior
	 */
	public java.lang.String getReVitreousAnterior () {
		return reVitreousAnterior;
	}

	/**
	 * Set the value related to the column: re_vitreous_anterior
	 * @param reVitreousAnterior the re_vitreous_anterior value
	 */
	public void setReVitreousAnterior (java.lang.String reVitreousAnterior) {
		this.reVitreousAnterior = reVitreousAnterior;
	}



	/**
	 * Return the value associated with the column: re_fornix
	 */
	public java.lang.String getReFornix () {
		return reFornix;
	}

	/**
	 * Set the value related to the column: re_fornix
	 * @param reFornix the re_fornix value
	 */
	public void setReFornix (java.lang.String reFornix) {
		this.reFornix = reFornix;
	}



	/**
	 * Return the value associated with the column: re_limbus
	 */
	public java.lang.String getReLimbus () {
		return reLimbus;
	}

	/**
	 * Set the value related to the column: re_limbus
	 * @param reLimbus the re_limbus value
	 */
	public void setReLimbus (java.lang.String reLimbus) {
		this.reLimbus = reLimbus;
	}



	/**
	 * Return the value associated with the column: re_sclera
	 */
	public java.lang.String getReSclera () {
		return reSclera;
	}

	/**
	 * Set the value related to the column: re_sclera
	 * @param reSclera the re_sclera value
	 */
	public void setReSclera (java.lang.String reSclera) {
		this.reSclera = reSclera;
	}



	/**
	 * Return the value associated with the column: le_eyebrow
	 */
	public java.lang.String getLeEyebrow () {
		return leEyebrow;
	}

	/**
	 * Set the value related to the column: le_eyebrow
	 * @param leEyebrow the le_eyebrow value
	 */
	public void setLeEyebrow (java.lang.String leEyebrow) {
		this.leEyebrow = leEyebrow;
	}



	/**
	 * Return the value associated with the column: le_eyelid
	 */
	public java.lang.String getLeEyelid () {
		return leEyelid;
	}

	/**
	 * Set the value related to the column: le_eyelid
	 * @param leEyelid the le_eyelid value
	 */
	public void setLeEyelid (java.lang.String leEyelid) {
		this.leEyelid = leEyelid;
	}



	/**
	 * Return the value associated with the column: le_cornea
	 */
	public java.lang.String getLeCornea () {
		return leCornea;
	}

	/**
	 * Set the value related to the column: le_cornea
	 * @param leCornea the le_cornea value
	 */
	public void setLeCornea (java.lang.String leCornea) {
		this.leCornea = leCornea;
	}



	/**
	 * Return the value associated with the column: le_conjunction
	 */
	public java.lang.String getLeConjunction () {
		return leConjunction;
	}

	/**
	 * Set the value related to the column: le_conjunction
	 * @param leConjunction the le_conjunction value
	 */
	public void setLeConjunction (java.lang.String leConjunction) {
		this.leConjunction = leConjunction;
	}



	/**
	 * Return the value associated with the column: le_anterior_chamber
	 */
	public java.lang.String getLeAnteriorChamber () {
		return leAnteriorChamber;
	}

	/**
	 * Set the value related to the column: le_anterior_chamber
	 * @param leAnteriorChamber the le_anterior_chamber value
	 */
	public void setLeAnteriorChamber (java.lang.String leAnteriorChamber) {
		this.leAnteriorChamber = leAnteriorChamber;
	}



	/**
	 * Return the value associated with the column: le_iris
	 */
	public java.lang.String getLeIris () {
		return leIris;
	}

	/**
	 * Set the value related to the column: le_iris
	 * @param leIris the le_iris value
	 */
	public void setLeIris (java.lang.String leIris) {
		this.leIris = leIris;
	}



	/**
	 * Return the value associated with the column: le_pupils
	 */
	public java.lang.String getLePupils () {
		return lePupils;
	}

	/**
	 * Set the value related to the column: le_pupils
	 * @param lePupils the le_pupils value
	 */
	public void setLePupils (java.lang.String lePupils) {
		this.lePupils = lePupils;
	}



	/**
	 * Return the value associated with the column: le_Lens
	 */
	public java.lang.String getLeLens () {
		return leLens;
	}

	/**
	 * Set the value related to the column: le_Lens
	 * @param leLens the le_Lens value
	 */
	public void setLeLens (java.lang.String leLens) {
		this.leLens = leLens;
	}



	/**
	 * Return the value associated with the column: le_anterior
	 */
	public java.lang.String getLeAnterior () {
		return leAnterior;
	}

	/**
	 * Set the value related to the column: le_anterior
	 * @param leAnterior the le_anterior value
	 */
	public void setLeAnterior (java.lang.String leAnterior) {
		this.leAnterior = leAnterior;
	}



	/**
	 * Return the value associated with the column: le_vitreous_anterior
	 */
	public java.lang.String getLeVitreousAnterior () {
		return leVitreousAnterior;
	}

	/**
	 * Set the value related to the column: le_vitreous_anterior
	 * @param leVitreousAnterior the le_vitreous_anterior value
	 */
	public void setLeVitreousAnterior (java.lang.String leVitreousAnterior) {
		this.leVitreousAnterior = leVitreousAnterior;
	}



	/**
	 * Return the value associated with the column: le_fornix
	 */
	public java.lang.String getLeFornix () {
		return leFornix;
	}

	/**
	 * Set the value related to the column: le_fornix
	 * @param leFornix the le_fornix value
	 */
	public void setLeFornix (java.lang.String leFornix) {
		this.leFornix = leFornix;
	}



	/**
	 * Return the value associated with the column: le_limbus
	 */
	public java.lang.String getLeLimbus () {
		return leLimbus;
	}

	/**
	 * Set the value related to the column: le_limbus
	 * @param leLimbus the le_limbus value
	 */
	public void setLeLimbus (java.lang.String leLimbus) {
		this.leLimbus = leLimbus;
	}



	/**
	 * Return the value associated with the column: le_sclera
	 */
	public java.lang.String getLeSclera () {
		return leSclera;
	}

	/**
	 * Set the value related to the column: le_sclera
	 * @param leSclera the le_sclera value
	 */
	public void setLeSclera (java.lang.String leSclera) {
		this.leSclera = leSclera;
	}



	/**
	 * Return the value associated with the column: re_optic_disc
	 */
	public java.lang.String getReOpticDisc () {
		return reOpticDisc;
	}

	/**
	 * Set the value related to the column: re_optic_disc
	 * @param reOpticDisc the re_optic_disc value
	 */
	public void setReOpticDisc (java.lang.String reOpticDisc) {
		this.reOpticDisc = reOpticDisc;
	}



	/**
	 * Return the value associated with the column: re_fovea
	 */
	public java.lang.String getReFovea () {
		return reFovea;
	}

	/**
	 * Set the value related to the column: re_fovea
	 * @param reFovea the re_fovea value
	 */
	public void setReFovea (java.lang.String reFovea) {
		this.reFovea = reFovea;
	}



	/**
	 * Return the value associated with the column: re_vitreous_posterior
	 */
	public java.lang.String getReVitreousPosterior () {
		return reVitreousPosterior;
	}

	/**
	 * Set the value related to the column: re_vitreous_posterior
	 * @param reVitreousPosterior the re_vitreous_posterior value
	 */
	public void setReVitreousPosterior (java.lang.String reVitreousPosterior) {
		this.reVitreousPosterior = reVitreousPosterior;
	}



	/**
	 * Return the value associated with the column: re_blood_vessels
	 */
	public java.lang.String getReBloodVessels () {
		return reBloodVessels;
	}

	/**
	 * Set the value related to the column: re_blood_vessels
	 * @param reBloodVessels the re_blood_vessels value
	 */
	public void setReBloodVessels (java.lang.String reBloodVessels) {
		this.reBloodVessels = reBloodVessels;
	}



	/**
	 * Return the value associated with the column: le_optic_disc
	 */
	public java.lang.String getLeOpticDisc () {
		return leOpticDisc;
	}

	/**
	 * Set the value related to the column: le_optic_disc
	 * @param leOpticDisc the le_optic_disc value
	 */
	public void setLeOpticDisc (java.lang.String leOpticDisc) {
		this.leOpticDisc = leOpticDisc;
	}



	/**
	 * Return the value associated with the column: le_fovea
	 */
	public java.lang.String getLeFovea () {
		return leFovea;
	}

	/**
	 * Set the value related to the column: le_fovea
	 * @param leFovea the le_fovea value
	 */
	public void setLeFovea (java.lang.String leFovea) {
		this.leFovea = leFovea;
	}



	/**
	 * Return the value associated with the column: le_vitreous_posterior
	 */
	public java.lang.String getLeVitreousPosterior () {
		return leVitreousPosterior;
	}

	/**
	 * Set the value related to the column: le_vitreous_posterior
	 * @param leVitreousPosterior the le_vitreous_posterior value
	 */
	public void setLeVitreousPosterior (java.lang.String leVitreousPosterior) {
		this.leVitreousPosterior = leVitreousPosterior;
	}



	/**
	 * Return the value associated with the column: le_blood_vessels
	 */
	public java.lang.String getLeBloodVessels () {
		return leBloodVessels;
	}

	/**
	 * Set the value related to the column: le_blood_vessels
	 * @param leBloodVessels the le_blood_vessels value
	 */
	public void setLeBloodVessels (java.lang.String leBloodVessels) {
		this.leBloodVessels = leBloodVessels;
	}



	/**
	 * Return the value associated with the column: re_colour_vision
	 */
	public java.lang.String getReColourVision () {
		return reColourVision;
	}

	/**
	 * Set the value related to the column: re_colour_vision
	 * @param reColourVision the re_colour_vision value
	 */
	public void setReColourVision (java.lang.String reColourVision) {
		this.reColourVision = reColourVision;
	}



	/**
	 * Return the value associated with the column: le_colour_vision
	 */
	public java.lang.String getLeColourVision () {
		return leColourVision;
	}

	/**
	 * Set the value related to the column: le_colour_vision
	 * @param leColourVision the le_colour_vision value
	 */
	public void setLeColourVision (java.lang.String leColourVision) {
		this.leColourVision = leColourVision;
	}



	/**
	 * Return the value associated with the column: consultation_date
	 */
	public java.util.Date getConsultationDate () {
		return consultationDate;
	}

	/**
	 * Set the value related to the column: consultation_date
	 * @param consultationDate the consultation_date value
	 */
	public void setConsultationDate (java.util.Date consultationDate) {
		this.consultationDate = consultationDate;
	}



	/**
	 * Return the value associated with the column: consultation_time
	 */
	public java.lang.String getConsultationTime () {
		return consultationTime;
	}

	/**
	 * Set the value related to the column: consultation_time
	 * @param consultationTime the consultation_time value
	 */
	public void setConsultationTime (java.lang.String consultationTime) {
		this.consultationTime = consultationTime;
	}



	/**
	 * Return the value associated with the column: retinoscopy_re_h
	 */
	public java.lang.String getRetinoscopyReH () {
		return retinoscopyReH;
	}

	/**
	 * Set the value related to the column: retinoscopy_re_h
	 * @param retinoscopyReH the retinoscopy_re_h value
	 */
	public void setRetinoscopyReH (java.lang.String retinoscopyReH) {
		this.retinoscopyReH = retinoscopyReH;
	}



	/**
	 * Return the value associated with the column: retinoscopy_le_h
	 */
	public java.lang.String getRetinoscopyLeH () {
		return retinoscopyLeH;
	}

	/**
	 * Set the value related to the column: retinoscopy_le_h
	 * @param retinoscopyLeH the retinoscopy_le_h value
	 */
	public void setRetinoscopyLeH (java.lang.String retinoscopyLeH) {
		this.retinoscopyLeH = retinoscopyLeH;
	}



	/**
	 * Return the value associated with the column: retina_re
	 */
	public java.lang.String getRetinaRe () {
		return retinaRe;
	}

	/**
	 * Set the value related to the column: retina_re
	 * @param retinaRe the retina_re value
	 */
	public void setRetinaRe (java.lang.String retinaRe) {
		this.retinaRe = retinaRe;
	}



	/**
	 * Return the value associated with the column: retina_le
	 */
	public java.lang.String getRetinaLe () {
		return retinaLe;
	}

	/**
	 * Set the value related to the column: retina_le
	 * @param retinaLe the retina_le value
	 */
	public void setRetinaLe (java.lang.String retinaLe) {
		this.retinaLe = retinaLe;
	}



	/**
	 * Return the value associated with the column: iol_re
	 */
	public java.lang.String getIolRe () {
		return iolRe;
	}

	/**
	 * Set the value related to the column: iol_re
	 * @param iolRe the iol_re value
	 */
	public void setIolRe (java.lang.String iolRe) {
		this.iolRe = iolRe;
	}



	/**
	 * Return the value associated with the column: iol_le
	 */
	public java.lang.String getIolLe () {
		return iolLe;
	}

	/**
	 * Set the value related to the column: iol_le
	 * @param iolLe the iol_le value
	 */
	public void setIolLe (java.lang.String iolLe) {
		this.iolLe = iolLe;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphthalmologyDetails)) return false;
		else {
			jkt.hms.masters.business.OpdOphthalmologyDetails opdOphthalmologyDetails = (jkt.hms.masters.business.OpdOphthalmologyDetails) obj;
			if (null == this.getId() || null == opdOphthalmologyDetails.getId()) return false;
			else return (this.getId().equals(opdOphthalmologyDetails.getId()));
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