package com.github.hrworker.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class WorkerNotFoundException extends RuntimeException {
    private String message;
    private Long idWorker;
}
