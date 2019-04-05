package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_donation_entry_detail table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_donation_entry_detail"
 */

public abstract class BaseBloodDonationEntryDetail  implements Serializable {

	public static String REF = "BloodDonationEntryDetail";
	public static String PROP_QTY = "Qty";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_BLOOD_BAG_NO = "BloodBagNo";
	public static String PROP_DONATION = "Donation";
	public static String PROP_ID = "Id";
	public static String PROP_SAMPLE_SCREENING_TEST = "SampleScreeningTest";
	public static String PROP_COMPONENT = "Component";

	// constructors
	public BaseBloodDonationEntryDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodDonationEntryDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bloodBagNo;
	private java.lang.Integer qty;
	private java.lang.String sampleScreeningTest;
	private java.util.Date expiryDate;

	// many to one
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.BloodDonationEntryHeader donation;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningHeader> bloodDonorSampleScreeningHeaders;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="detail_id"
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
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: sample_screening_test
	 */
	public java.lang.String getSampleScreeningTest() {
		return sampleScreeningTest;
	}

	/**
	 * Set the value related to the column: sample_screening_test
	 * 
	 * @param sampleScreeningTest
	 *            the sample_screening_test value
	 */
	public void setSampleScreeningTest(java.lang.String sampleScreeningTest) {
		this.sampleScreeningTest = sampleScreeningTest;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getComponent() {
		return component;
	}

	/**
	 * Set the value related to the column: component_id
	 * 
	 * @param component
	 * @param component the component_id value
	 */
	public void setComponent (jkt.hms.masters.business.BloodMasComponent component) {
		this.component = component;
	}



	/**
	 * Return the value associated with the column: donation_id
	 */
	public jkt.hms.masters.business.BloodDonationEntryHeader getDonation () {
		return donation;
	}

	/**
	 * Set the value related to the column: donation_id
	 * @param donation the donation_id value
	 */
	public void setDonation (jkt.hms.masters.business.BloodDonationEntryHeader donation) {
		this.donation = donation;
	}



	/**
	 * Return the value associated with the column: BloodDonorSampleScreeningHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningHeader> getBloodDonorSampleScreeningHeaders () {
		return bloodDonorSampleScreeningHeaders;
	}

	/**
	 * Set the value related to the column: BloodDonorSampleScreeningHeaders
	 * @param bloodDonorSampleScreeningHeaders the BloodDonorSampleScreeningHeaders value
	 */
	public void setBloodDonorSampleScreeningHeaders (java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningHeader> bloodDonorSampleScreeningHeaders) {
		this.bloodDonorSampleScreeningHeaders = bloodDonorSampleScreeningHeaders;
	}

	public void addToBloodDonorSampleScreeningHeaders(
			jkt.hms.masters.business.BloodDonorSampleScreeningHeader bloodDonorSampleScreeningHeader) {
		if (null == getBloodDonorSampleScreeningHeaders())
			setBloodDonorSampleScreeningHeaders(new java.util.TreeSet<jkt.hms.masters.business.BloodDonorSampleScreeningHeader>());
		getBloodDonorSampleScreeningHeaders().add(
				bloodDonorSampleScreeningHeader);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodDonationEntryDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodDonationEntryDetail bloodDonationEntryDetail = (jkt.hms.masters.business.BloodDonationEntryDetail) obj;
			if (null == this.getId()
					|| null == bloodDonationEntryDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodDonationEntryDetail.getId()));
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