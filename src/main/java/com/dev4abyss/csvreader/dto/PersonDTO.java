package com.dev4abyss.csvreader.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {

    private String name;
    private String phone;
    private String city;
    private String country;
}
