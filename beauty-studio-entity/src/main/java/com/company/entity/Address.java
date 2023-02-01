package com.company.entity;


import com.company.entity.core.AbstractBaseBean;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractBaseBean {

    @Column(name = "zipCode", unique = true)
    private Integer zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private Integer house;

    @Column(name = "apartment")
    private Integer apartment;

}
