package com.github.hrworker.resources;

import com.github.hrworker.dto.WorkerDto;
import com.github.hrworker.services.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/workers")
@CrossOrigin(origins = "*")
@Api(value = "hr-worker")
public class WorkerResource {

    @Autowired
    private WorkerService workerService;

    @ApiOperation(value = "return all workers")
    @GetMapping
    public ResponseEntity<List<WorkerDto>> findAll() {
        log.info("[WorkerResource] - Consulting all workers");
        return ResponseEntity.ok(workerService.findAll());
    }

    @ApiOperation(value = "Return worker by Id")
    @GetMapping(value = "{id}")
    public ResponseEntity<WorkerDto> findById(@PathVariable Long id) {
        log.info("[WorkerResource] - Consulting workers from id = {}", id);
        return ResponseEntity.ok(workerService.findById(id));
    }
}
