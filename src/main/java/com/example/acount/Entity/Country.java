package com.example.acount.Entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Embeddable
public class Country {
    private String countryName;
    private String cityName;

}
