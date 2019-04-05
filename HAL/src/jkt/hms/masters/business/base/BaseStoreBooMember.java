package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_boo_member table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_boo_member"
 */

public abstract class BaseStoreBooMember implements Serializable {

	public static String REF = "StoreBooMember";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_MEMBER_RANK = "MemberRank";
	public static String PROP_MEMBER = "Member";
	public static String PROP_ID = "Id";
	public static String PROP_BOO = "Boo";

	// constructors
	public BaseStoreBooMember() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBooMember(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreBooMember(java.lang.Integer id,
			jkt.hms.masters.business.StoreBoo boo) {

		this.setId(id);
		this.setBoo(boo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;

	// many to one
	private jkt.hms.masters.business.StoreBoo boo;
	private jkt.hms.masters.business.MasEmployee member;
	private jkt.hms.masters.business.MasRank memberRank;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="boo_member_id"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: boo_id
	 */
	public jkt.hms.masters.business.StoreBoo getBoo() {
		return boo;
	}

	/**
	 * Set the value related to the column: boo_id
	 * 
	 * @param boo
	 *            the boo_id value
	 */
	public void setBoo(jkt.hms.masters.business.StoreBoo boo) {
		this.boo = boo;
	}

	/**
	 * Return the value associated with the column: member_id
	 */
	public jkt.hms.masters.business.MasEmployee getMember() {
		return member;
	}

	/**
	 * Set the value related to the column: member_id
	 * 
	 * @param member
	 *            the member_id value
	 */
	public void setMember(jkt.hms.masters.business.MasEmployee member) {
		this.member = member;
	}

	/**
	 * Return the value associated with the column: member_rank
	 */
	public jkt.hms.masters.business.MasRank getMemberRank() {
		return memberRank;
	}

	/**
	 * Set the value related to the column: member_rank
	 * 
	 * @param memberRank
	 *            the member_rank value
	 */
	public void setMemberRank(jkt.hms.masters.business.MasRank memberRank) {
		this.memberRank = memberRank;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBooMember))
			return false;
		else {
			jkt.hms.masters.business.StoreBooMember storeBooMember = (jkt.hms.masters.business.StoreBooMember) obj;
			if (null == this.getId() || null == storeBooMember.getId())
				return false;
			else
				return (this.getId().equals(storeBooMember.getId()));
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