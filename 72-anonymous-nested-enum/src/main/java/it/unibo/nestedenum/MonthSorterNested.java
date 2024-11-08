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
        JENUARY("january", 31),
        FEBRUARY("february", 28),
        MARCH("march", 31),
        APRIL("april", 30),
        MAY("may", 31),
        JUNE("june", 31),
        JULY("july", 30),
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
        public Month fromString(String text){
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
            for(MonthSorterNested.Month month: MonthSorterNested.Month.values()){
                if(month.fromString(o1) instanceof MonthSorterNested.Month){
                    return -1;
                }else if(month.fromString(o2) instanceof MonthSorterNested.Month){
                    return 1;
                }
            }
            throw new IllegalArgumentException("It's impossibile to compare");
        }
        
    }
    private class SortByDate implements Comparator<String> {
        
        @Override
        public int compare(String o1, String o2) {
            int numb1 = 0;
            int numb2 = 0;
            for(MonthSorterNested.Month month: MonthSorterNested.Month.values()){
                if(month.getName().equals(o1)){
                    numb1 = month.getDays();
                }else if(month.getName().equals(o2)){
                    numb2 = month.getDays();
                }
            }
            if(numb1 == 0 || numb2 == 0){
                throw new IllegalArgumentException("impossible to compare" + o1);
            }
            if(numb1 < numb2){
                return -1;
            }else if(numb1 > numb2){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
