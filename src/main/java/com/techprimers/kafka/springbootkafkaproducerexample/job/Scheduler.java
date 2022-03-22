package com.techprimers.kafka.springbootkafkaproducerexample.job;

import com.techprimers.kafka.springbootkafkaproducerexample.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Scheduler {
    @Autowired
    private FileService fileService;
    @Scheduled(fixedRate = 1000)
    public void fixedRateSch() throws IOException {
        fileService.readFilesFromDir();
    }
}
