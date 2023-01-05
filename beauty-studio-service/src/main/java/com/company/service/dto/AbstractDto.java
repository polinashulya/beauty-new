package com.company.service.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class AbstractDto {
    private Long id;
}
