package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }

    public enum Month {
        JANUARY("january", 31),
        FEBRUARY("february", 28),
        MARCH("march", 31),
        APRIL("april", 30),
        MAY("may", 31),
        JUNE("june", 30),
        JULY("july", 31),
        AUGUST("august", 31),
        SEPTEMBER("september", 30),
        OCTOBER("october", 31),
        NOVEMBER("november", 30),
        DECEMBER("december", 31);

        private final String name;
        private final int days;

        private Month(final String name, final int days){
            this.name = name;
            this.days = days;
        };  

        public String getName() {
            return this.name;
        }
        public int getDays() {
            return this.days;
        }
        public static Month fromString(String text){
            int cont = 0;
            Month result = null;
            for(Month month: Month.values()){
                if(month.getName().startsWith(text.toLowerCase())){
                    result = month;
                    cont ++;
                }
            }
            if(cont == 1){
                return result;
            }else{
                throw new IllegalArgumentException("Month not found or empty field" + text);
            }
        }
    }
    private class SortByMonthOrder implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            int numb1 = MonthSorterNested.Month.fromString(o1).ordinal();
            int numb2 = MonthSorterNested.Month.fromString(o2).ordinal();
            return Integer.compare(numb1, numb2);
        }
        
    }
    private class SortByDate implements Comparator<String> {
        
        @Override
        public int compare(String o1, String o2) {
            int numb1 = MonthSorterNested.Month.fromString(o1).getDays();
            int numb2 = MonthSorterNested.Month.fromString(o2).getDays();
            return Integer.compare(numb1, numb2);
        }
    }
}
