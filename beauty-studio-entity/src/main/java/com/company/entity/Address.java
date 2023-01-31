package com.company.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Column(name = "zipCode", unique = true, nullable = false)
    private Integer zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "house", nullable = false)
    private Integer house;

    @Column(name = "apartment")
    private Integer apartment;

}
