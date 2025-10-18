package com.greenhelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class HealthService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getApplicationStatus() {
        return "OK";
    }

    public LocalDateTime getApplicationTime() {
        return LocalDateTime.now();
    }

    public String getDatabaseStatus() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "OK";
        } catch (Exception e) {
            return "DB_ERROR: " + e.getMessage();
        }
    }

    @SuppressWarnings("null")
    public LocalDateTime getDatabaseTime() {
        try {
            Timestamp ts = jdbcTemplate.queryForObject("SELECT NOW()", Timestamp.class);
            return ts.toLocalDateTime();
        } catch (Exception e) {
            return null;
        }
    }
}
