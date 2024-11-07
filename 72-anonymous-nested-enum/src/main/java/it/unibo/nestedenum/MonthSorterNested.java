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
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    public enum Month {
        JENUARY("Jenuary", 31),
        FEBRUARY("Fabruary", 28),
        MARCH("March", 31),
        APRIL("April", 30),
        JUNE("June", 31),
        JULY("July", 30),
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
            return name;
        }
        public int getDays() {
            return days;
        }
        public Month fromString(String text){
            int cont = 0;
            Month result = null;
            for(Month month: Month.values()){
                if(month.getName().startsWith(text)){
                    result = month;
                    cont ++;
                }
            }
            if(cont == 1){
                return result;
            }else{
                throw new IllegalArgumentException("Month not found or empty field");
            }
        }
    }
}
