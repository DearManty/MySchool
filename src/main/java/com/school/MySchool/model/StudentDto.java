package com.school.MySchool.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentDto {

    private String studentName;

    private String studentAddress;

    private Double studentFee;

    private String subject;
}
