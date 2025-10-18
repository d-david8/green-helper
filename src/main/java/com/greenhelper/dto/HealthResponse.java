package com.greenhelper.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HealthResponse {

    private String applicationStatus;
    private LocalDateTime applicationTimestamp;
    private String databaseStatus;
    private LocalDateTime databaseTimestamp;
}
