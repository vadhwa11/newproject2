package jkt.hms.masters.business.base;

import java.util.Comparator;

public class AppSetupComparator implements Comparator<Object> {

	public int compare(Object obj1, Object obj2) {
		Integer dayOfWeek1 = ((jkt.hms.masters.business.AppSetup) obj1)
				.getDayOfWeek();
		Integer dayOfWeek2 = ((jkt.hms.masters.business.AppSetup) obj2)
				.getDayOfWeek();
		if (dayOfWeek1 == null || dayOfWeek2 == null) {
			return -1;
		}
		return dayOfWeek1.compareTo(dayOfWeek2);
	}

}