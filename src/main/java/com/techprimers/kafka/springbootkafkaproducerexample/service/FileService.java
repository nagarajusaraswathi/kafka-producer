package com.techprimers.kafka.springbootkafkaproducerexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileService {
    Logger logger = LoggerFactory.getLogger(FileService.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${file.input.folder}")
    private String fileInputLocation;
    @Value("${kafka.topic}")
    private String TOPIC ;
    public void readFilesFromDir() throws IOException {
        logger.info("input folder::"+fileInputLocation);
        logger.info("TOPIC ::"+TOPIC);
        File folder = new File(fileInputLocation);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                byte[] bytes = Files.readAllBytes(file.toPath());
                String content =  new String(bytes,"UTF-8");
                kafkaTemplate.send(TOPIC, content);
            }
        }
    }
}
