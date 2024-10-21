package com.api.alunos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateStudentDTO {
    private String name;
    private String surname;
    private String email;
    private Integer cpf;
    private Integer rg;
}
