package com.java.robin.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class Student implements Serializable {

  private String stdName;
  private Integer stdStd;
  private Long stdRollNumber;
  private List<String> subjects;
  private Address address;

}
