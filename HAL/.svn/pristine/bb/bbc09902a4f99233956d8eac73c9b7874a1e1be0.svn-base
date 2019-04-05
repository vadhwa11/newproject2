package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgSubMasInvestigation;

public class DgSubMasInvestigationComparatorByOrderNo implements Serializable,
		Comparator<DgSubMasInvestigation> {

	public int compare(DgSubMasInvestigation m1, DgSubMasInvestigation m2) {
		Integer int1 = m1.getOrderNo();
		Integer int2 = m2.getOrderNo();

		return int1.compareTo(int2);
	}

	public static TreeSet<DgSubMasInvestigation> getApplicationTreeSet() {
		return new TreeSet<DgSubMasInvestigation>(
				new DgSubMasInvestigationComparatorByOrderNo());
	}
}