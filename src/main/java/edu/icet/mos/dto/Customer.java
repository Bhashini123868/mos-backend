package edu.icet.mos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class Customer {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be betwee  2 and 50 characters")
    private String name;

    @NotBlank(message = "Contact is mandatory")
    @Size(min = 10, max = 15, message = "Contact must be between 10 and 15 characters")
    private String contact;

    @NotBlank(message = "Addressbis mandatory")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;
}
