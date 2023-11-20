package com.perez.simpledemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    private Integer id;

    private LocalDate dateBill;

    private Integer userId;

    private Float value;

    private Integer type;

    private String observation;
}
