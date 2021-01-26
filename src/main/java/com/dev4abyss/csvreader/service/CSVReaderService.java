package com.dev4abyss.csvreader.service;

import com.dev4abyss.csvreader.dto.PersonDTO;
import com.dev4abyss.csvreader.exceptions.FileProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {

    public List<PersonDTO> readCSVFile(MultipartFile file, String separator) {
        List<PersonDTO> persons = new ArrayList<>();
        separator = separator == null || separator.equals(" ") ? "," : separator;
        try {
            String line;
            BufferedReader conteudoCSV = new BufferedReader(new InputStreamReader(file.getInputStream()));

            while ((line = conteudoCSV.readLine()) != null) {
                String[] data = line.split(separator);
                persons.add(PersonDTO.builder()
                        .name(data[0] != null ? data[0] : "")
                        .phone(data[1] != null ? data[1] : "")
                        .city(data[2] != null ? data[2] : "")
                        .country(data[3] != null ? data[3] : "")
                        .build()
                );
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            throw new FileProcessingException("Error processing file: " + e.getMessage());
        }

        return persons;
    }
}
