package com.dev4abyss.csvreader.controller;

import com.dev4abyss.csvreader.dto.PersonDTO;
import com.dev4abyss.csvreader.service.CSVReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/reader")
@RestController
public class CSVReaderController {

    private final CSVReaderService csvReaderService;

    @PostMapping("/csv")
    public ResponseEntity<List<PersonDTO>> readCSVFile(@RequestParam MultipartFile file) {
        return ResponseEntity.ok(csvReaderService.readCSVFile(file));
    }
}

