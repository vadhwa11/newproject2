package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.MasApplication;

public class MasApplicationComparatorByOrderId implements Serializable,
		Comparator<MasApplication> {

	public int compare(MasApplication m1, MasApplication m2) {
		Integer int1 = m1.getOrderNo();
		Integer int2 = m2.getOrderNo();

		return int1.compareTo(int2);
	}

	public static TreeSet<MasApplication> getApplicationTreeSet() {
		return new TreeSet<MasApplication>(
				new MasApplicationComparatorByOrderId());
	}
}