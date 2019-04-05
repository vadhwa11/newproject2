package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the proposal_department
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="proposal_department"
 */

public abstract class BaseProposalDepartment implements Serializable {

	public static String REF = "ProposalDepartment";
	public static String PROP_PROPOSAL_TYPE = "ProposalType";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";

	// constructors
	public BaseProposalDepartment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProposalDepartment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseProposalDepartment(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasMinorWorkProposal proposalType) {

		this.setId(id);
		this.setDepartment(department);
		this.setProposalType(proposalType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasMinorWorkProposal proposalType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="proposal_department_id"
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
	 * Return the value associated with the column: proposal_type_id
	 */
	public jkt.hms.masters.business.MasMinorWorkProposal getProposalType() {
		return proposalType;
	}

	/**
	 * Set the value related to the column: proposal_type_id
	 * 
	 * @param proposalType
	 *            the proposal_type_id value
	 */
	public void setProposalType(
			jkt.hms.masters.business.MasMinorWorkProposal proposalType) {
		this.proposalType = proposalType;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ProposalDepartment))
			return false;
		else {
			jkt.hms.masters.business.ProposalDepartment proposalDepartment = (jkt.hms.masters.business.ProposalDepartment) obj;
			if (null == this.getId() || null == proposalDepartment.getId())
				return false;
			else
				return (this.getId().equals(proposalDepartment.getId()));
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