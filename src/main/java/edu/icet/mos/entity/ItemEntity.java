package edu.icet.mos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Item name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    @Column(nullable = false)
    @NotBlank(message = "Image is required")
    private String image;
}
