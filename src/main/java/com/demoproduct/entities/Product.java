package com.demoproduct.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id ;
    @NotEmpty @Size(min = 2, max = 30)
    private String name;
    @Min(0)
    private double price;
    @Min(2)
    private int quantity;
    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;
}
