package com.dev4abyss.csvreader.controller;

import com.dev4abyss.csvreader.dto.PersonDTO;
import com.dev4abyss.csvreader.service.CSVReaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "Reader")
@RestController
public class CSVReaderController {

    private final CSVReaderService csvReaderService;

    @PostMapping("/csv")
    public ResponseEntity<List<PersonDTO>> readCSVFile(

            @RequestParam
            @ApiParam(
                    value = "Any file with data separated by symbols like a comma (CSV files) or any text file that uses a symbol as a separation pattern",
                    required = true)
                    MultipartFile file,

            @RequestParam(value = "separator")
            @ApiParam(value = "Default is comma.")
                    String separator) {
        return ResponseEntity.ok(csvReaderService.readCSVFile(file,separator));
    }
}

