package com.github.hrworker.config;

import com.github.hrworker.dto.WorkerDto;
import com.github.hrworker.entities.Worker;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper model = new ModelMapper();
        model.addMappings(new PropertyMap<WorkerDto, Worker>() {
            @Override
            protected void configure() {}
        });
        model.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return model;
    }
}
