package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.MasApplication;

public class MasApplicationComparator implements Serializable,
		Comparator<MasApplication> {

	public int compare(MasApplication m1, MasApplication m2) {
		Integer int1 = Integer.valueOf(m1.getId().substring(1));
		Integer int2 = Integer.valueOf(m2.getId().substring(1));
		return int1.compareTo(int2);
	}

	public static TreeSet<MasApplication> getApplicationTreeSet() {
		return new TreeSet<MasApplication>(new MasApplicationComparator());
	}
}