package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgResultEntryDetail;

public class DgResultEntryComparatorByOrderNo implements Serializable,
		Comparator<DgResultEntryDetail> {

	public int compare(DgResultEntryDetail m1, DgResultEntryDetail m2) {
		Integer int1 =0;
		Integer int2=0;
		if(m1.getSubInvestigation()!=null)
		 int1 = m1.getSubInvestigation().getOrderNo();
		if(m2.getSubInvestigation()!=null)
		 int2 = m2.getSubInvestigation().getOrderNo();

		return int1.compareTo(int2);
	}

	public static TreeSet<DgResultEntryDetail> getApplicationTreeSet() {
		return new TreeSet<DgResultEntryDetail>(
				new DgResultEntryComparatorByOrderNo());
	}
}