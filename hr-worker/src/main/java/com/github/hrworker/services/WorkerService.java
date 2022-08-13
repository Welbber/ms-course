package com.github.hrworker.services;

import com.github.hrworker.dto.WorkerDto;
import com.github.hrworker.entities.Worker;
import com.github.hrworker.exception.WorkerNotFoundException;
import com.github.hrworker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ModelMapper model;

    @Transactional(readOnly = true)
    public List<WorkerDto> findAll() {
        List<Worker> result = workerRepository.findAll();
        log.info("[WorkerService] - Mapping list worker to workerDto");
        return result.stream().map(worker -> model.map(worker, WorkerDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public WorkerDto findById(Long id) {

        Optional<Worker> result = workerRepository.findById(id);

        if (result.isPresent()) {
            log.info("[WorkerService] - Mapping list worker to workerDto");
            return model.map(result.get(), WorkerDto.class);
        }
        throw new WorkerNotFoundException("Não foi possivel consultar trabalhador informado", id);
    }
}