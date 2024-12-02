package com.stdevsec.microservicios_usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AlumnoDto {

    private Long id; // Include this if you want the DTO to support updates

    @NotEmpty
    @NotBlank(message = "The name must not be blank.")
    private String nombre;

    @NotEmpty
    @NotBlank(message = "The last name must not be blank.")
    private String apellido;

    @NotEmpty
    @NotBlank(message = "The email must not be blank.")
    @Email(message = "The email format is invalid.")
    private String email;
}
