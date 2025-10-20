package com.greenhelper.service;

import com.greenhelper.dto.HolidayDto;

import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class HolidayService {

    public List<HolidayDto> getHolidays(Integer year) {
        if (year == null) {
            year = LocalDate.now().getYear();
        }

        List<HolidayDto> holidays = new ArrayList<>();

        holidays.add(new HolidayDto("Anul Nou", LocalDate.of(year, 1, 1)));
        holidays.add(new HolidayDto("A doua zi de Anul Nou", LocalDate.of(year, 1, 2)));
        holidays.add(new HolidayDto("Ziua Unirii Principatelor Române", LocalDate.of(year, 1, 24)));
        holidays.add(new HolidayDto("Vinerea Mare", calculateGoodFriday(year)));
        holidays.add(new HolidayDto("Paștele", calculateEaster(year)));
        holidays.add(new HolidayDto("A doua zi de Paște", calculateEaster(year).plusDays(1)));
        holidays.add(new HolidayDto("Rusalii", calculateEaster(year).plusDays(49)));
        holidays.add(new HolidayDto("A doua zi de Rusalii", calculateEaster(year).plusDays(50)));
        holidays.add(new HolidayDto("Ziua Muncii", LocalDate.of(year, 5, 1)));
        holidays.add(new HolidayDto("Ziua Copilului", LocalDate.of(year, 6, 1)));
        holidays.add(new HolidayDto("Adormirea Maicii Domnului", LocalDate.of(year, 8, 15)));
        holidays.add(new HolidayDto("Sfântul Andrei", LocalDate.of(year, 11, 30)));
        holidays.add(new HolidayDto("Ziua Națională a României", LocalDate.of(year, 12, 1)));
        holidays.add(new HolidayDto("Crăciunul", LocalDate.of(year, 12, 25)));
        holidays.add(new HolidayDto("A doua zi de Crăciun", LocalDate.of(year, 12, 26)));

        holidays.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

        return holidays;
    }

    // Exemplu simplificat: calcul Easter
    private LocalDate calculateEaster(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }

    private LocalDate calculateGoodFriday(int year) {
        return calculateEaster(year).minusDays(2);
    }
}
