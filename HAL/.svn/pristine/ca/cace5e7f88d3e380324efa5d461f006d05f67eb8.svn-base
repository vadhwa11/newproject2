package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_tender_technical_bid_t table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_technical_bid_t"
 */

public abstract class BaseStoreTenderTechnicalBidT implements Serializable {

	public static String REF = "StoreTenderTechnicalBidT";
	public static String PROP_TECH_BID_M = "TechBidM";
	public static String PROP_DISP_TYPE = "DispType";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CERTIFICATE_TO_MARKET_PRODUCT = "CertificateToMarketProduct";
	public static String PROP_NO_OF_ITEM_SUBMITTED = "NoOfItemSubmitted";
	public static String PROP_QUALIFIED = "Qualified";
	public static String PROP_MANUFACTURER_NAME = "ManufacturerName";
	public static String PROP_ITEM = "Item";
	public static String PROP_MDQ_VALUE = "MdqValue";
	public static String PROP_ID = "Id";
	public static String PROP_BRAND_NAME = "BrandName";
	public static String PROP_COMPOSITION = "Composition";
	public static String PROP_MANUFACTURER_LICENCE = "ManufacturerLicence";

	// constructors
	public BaseStoreTenderTechnicalBidT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderTechnicalBidT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTenderTechnicalBidT(java.lang.Integer id,
			jkt.hms.masters.business.MasStoreItem item,
			jkt.hms.masters.business.StoreTenderTechnicalBidM techBidM,
			java.math.BigDecimal mdqValue, java.lang.Integer noOfItemSubmitted,
			java.lang.String manufacturerLicence,
			java.lang.String certificateToMarketProduct,
			java.lang.String remarks, java.lang.String qualified,
			java.lang.String dispType) {

		this.setId(id);
		this.setItem(item);
		this.setTechBidM(techBidM);
		this.setMdqValue(mdqValue);
		this.setNoOfItemSubmitted(noOfItemSubmitted);
		this.setManufacturerLicence(manufacturerLicence);
		this.setCertificateToMarketProduct(certificateToMarketProduct);
		this.setRemarks(remarks);
		this.setQualified(qualified);
		this.setDispType(dispType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String brandName;
	private java.lang.String manufacturerName;
	private java.math.BigDecimal mdqValue;
	private java.lang.Integer noOfItemSubmitted;
	private java.lang.String manufacturerLicence;
	private java.lang.String certificateToMarketProduct;
	private java.lang.String remarks;
	private java.lang.String qualified;
	private java.lang.String dispType;
	private java.lang.String composition;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreTenderTechnicalBidM techBidM;

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
	 * Return the value associated with the column: brand_name
	 */
	public java.lang.String getBrandName() {
		return brandName;
	}

	/**
	 * Set the value related to the column: brand_name
	 * 
	 * @param brandName
	 *            the brand_name value
	 */
	public void setBrandName(java.lang.String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Return the value associated with the column: manufacturer_name
	 */
	public java.lang.String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Set the value related to the column: manufacturer_name
	 * 
	 * @param manufacturerName
	 *            the manufacturer_name value
	 */
	public void setManufacturerName(java.lang.String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Return the value associated with the column: mdq_value
	 */
	public java.math.BigDecimal getMdqValue() {
		return mdqValue;
	}

	/**
	 * Set the value related to the column: mdq_value
	 * 
	 * @param mdqValue
	 *            the mdq_value value
	 */
	public void setMdqValue(java.math.BigDecimal mdqValue) {
		this.mdqValue = mdqValue;
	}

	/**
	 * Return the value associated with the column: no_of_item_submitted
	 */
	public java.lang.Integer getNoOfItemSubmitted() {
		return noOfItemSubmitted;
	}

	/**
	 * Set the value related to the column: no_of_item_submitted
	 * 
	 * @param noOfItemSubmitted
	 *            the no_of_item_submitted value
	 */
	public void setNoOfItemSubmitted(java.lang.Integer noOfItemSubmitted) {
		this.noOfItemSubmitted = noOfItemSubmitted;
	}

	/**
	 * Return the value associated with the column: manufacturer_licence
	 */
	public java.lang.String getManufacturerLicence() {
		return manufacturerLicence;
	}

	/**
	 * Set the value related to the column: manufacturer_licence
	 * 
	 * @param manufacturerLicence
	 *            the manufacturer_licence value
	 */
	public void setManufacturerLicence(java.lang.String manufacturerLicence) {
		this.manufacturerLicence = manufacturerLicence;
	}

	/**
	 * Return the value associated with the column:
	 * certificate_to_market_product
	 */
	public java.lang.String getCertificateToMarketProduct() {
		return certificateToMarketProduct;
	}

	/**
	 * Set the value related to the column: certificate_to_market_product
	 * 
	 * @param certificateToMarketProduct
	 *            the certificate_to_market_product value
	 */
	public void setCertificateToMarketProduct(
			java.lang.String certificateToMarketProduct) {
		this.certificateToMarketProduct = certificateToMarketProduct;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: qualified
	 */
	public java.lang.String getQualified() {
		return qualified;
	}

	/**
	 * Set the value related to the column: qualified
	 * 
	 * @param qualified
	 *            the qualified value
	 */
	public void setQualified(java.lang.String qualified) {
		this.qualified = qualified;
	}

	/**
	 * Return the value associated with the column: disp_type
	 */
	public java.lang.String getDispType() {
		return dispType;
	}

	/**
	 * Set the value related to the column: disp_type
	 * 
	 * @param dispType
	 *            the disp_type value
	 */
	public void setDispType(java.lang.String dispType) {
		this.dispType = dispType;
	}

	/**
	 * Return the value associated with the column: composition
	 */
	public java.lang.String getComposition() {
		return composition;
	}

	/**
	 * Set the value related to the column: composition
	 * 
	 * @param composition
	 *            the composition value
	 */
	public void setComposition(java.lang.String composition) {
		this.composition = composition;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	/**
	 * Return the value associated with the column: tech_bid_m_id
	 */
	public jkt.hms.masters.business.StoreTenderTechnicalBidM getTechBidM() {
		return techBidM;
	}

	/**
	 * Set the value related to the column: tech_bid_m_id
	 * 
	 * @param techBidM
	 *            the tech_bid_m_id value
	 */
	public void setTechBidM(
			jkt.hms.masters.business.StoreTenderTechnicalBidM techBidM) {
		this.techBidM = techBidM;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderTechnicalBidT))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderTechnicalBidT storeTenderTechnicalBidT = (jkt.hms.masters.business.StoreTenderTechnicalBidT) obj;
			if (null == this.getId()
					|| null == storeTenderTechnicalBidT.getId())
				return false;
			else
				return (this.getId().equals(storeTenderTechnicalBidT.getId()));
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