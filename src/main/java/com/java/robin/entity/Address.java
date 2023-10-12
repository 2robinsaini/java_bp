package com.java.robin.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Address implements Serializable {

    private Long addressId;
    private Integer houseFlatNum;
    private Integer floorNumber;
    private String streetOrSociety;
    private String sector;
    private String city;
    private String state;
    private Long pin;

}
