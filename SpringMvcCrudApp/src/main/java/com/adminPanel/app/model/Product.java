package com.adminPanel.app.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name="name",nullable = false)
    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)

    private ProductDetails productDetails;
}
