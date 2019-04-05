package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseProposalDepartment;

public class ProposalDepartment extends BaseProposalDepartment {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public ProposalDepartment() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ProposalDepartment(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ProposalDepartment(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasMinorWorkProposal proposalType) {

		super(id, department, proposalType);
	}

	/* [CONSTRUCTOR MARKER END] */

}