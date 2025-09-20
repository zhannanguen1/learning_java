package net.xonich.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoHomeWorkStream {

    public enum Month {

        JANUARY("JANUARY", "Январь"),
        FEBRUARY("FEBRUARY", "Февраль"),
        MARCH("MARCH", "Март"),
        APRIL("APRIL", "Апрель"),
        MAY("MAY", "Май"),
        JUNE("JUNE", "Июнь"),
        JULY("JULY", "Июль"),
        AUGUST("AUGUST", "Август"),
        SEPTEMBER("SEPTEMBER", "Сентябрь"),
        OCTOBER("OCTOBER", "Октябрь"),
        NOVEMBER("NOVEMBER", "Ноябрь"),
        DECEMBER("DECEMBER", "Декабрь");

        private String en;
        private String russ;

        Month(String en, String russ) {

            this.en = en;
            this.russ = russ;
        }

        public String getRuss() {
            return russ;
        }

        public static Month fromEnglish(String englishName) {
            for (Month month : values()) {
                if (month.en.equals(englishName)) {
                    return month;
                }
            }
            throw new IllegalArgumentException("Unknown month: " + englishName);
        }
    }

//    public static String translate(Month monthEn) {
//        Map<String, String> month = Map.of(
//                "January", "Январь",
//                "February", "Февраль",
//                "March", "Март",
//                "April", "Апрель",
//                "May", "Май",
//                "June", "Июнь",
//                "July", "Июль",
//                "August", "Август",
//                "September", "Сентябрь",
//                "October", "Октябрь",
//                "November", "Ноябрь"
//        );
//        month.put("kk", "fdf");
//        return monthRuss;
//    }

    public static void main1(String[] args) {

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.now());
        dates.add(LocalDate.now().plusDays(10));
        dates.add(LocalDate.now().minusMonths(4));
        dates.add(LocalDate.now().minusMonths(4));
        dates.add(LocalDate.now().minusMonths(7));
        dates.add(LocalDate.now().minusMonths(1));

        System.out.println(dates);

        List<String> monthList = dates.stream()
                .map(LocalDate::getMonth)
                .distinct()
                .map(m -> Month.fromEnglish(String.valueOf(m)).getRuss())
                .toList();

        System.out.println(monthList);
    }

    public static void main(String[] args) {
        Random random = new Random();

        int sum = random
                .ints(0, 1_000_00)
                .limit(100)
                .sum();
        System.out.println(sum);
    }
}
