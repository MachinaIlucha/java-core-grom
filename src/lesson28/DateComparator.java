package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
          if (!o1.getDateCreated().equals(o2))
            return o1.getDateCreated().compareTo(o2.getDateCreated());
        return 0;
    }
}
