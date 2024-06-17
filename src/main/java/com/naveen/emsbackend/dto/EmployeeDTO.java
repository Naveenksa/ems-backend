package com.naveen.emsbackend.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder(toBuilder = true)
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
