package com.greenhelper.controller;

import com.greenhelper.dto.HolidayDto;
import com.greenhelper.service.HolidayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/api/holidays")
    public List<HolidayDto> getHolidays(@RequestParam(required = false) Integer year) {
        return holidayService.getHolidays(year);
    }
}