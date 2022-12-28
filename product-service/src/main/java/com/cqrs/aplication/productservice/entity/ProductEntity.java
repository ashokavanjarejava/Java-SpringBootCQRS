package com.cqrs.aplication.productservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="products")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = -227264951080660124L;

    @Id
    @Column(unique=true)
    private String productId;

    @Column(unique=true)
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
