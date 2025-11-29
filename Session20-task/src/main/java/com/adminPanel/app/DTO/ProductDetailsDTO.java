package com.adminPanel.app.DTO;

import com.adminPanel.app.model.ProductDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ProductDetailsDTO {

        private int id;
        private String name;
        private Date expirationDate;
        private String manufacturer;
        private Double price;
        private boolean available;
        private int productId; 

        public ProductDetailsDTO(ProductDetails pd) {
            this.id = pd.getId();
            this.name = pd.getName();
            this.expirationDate = pd.getExpirationDate();
            this.manufacturer = pd.getManufacturer();
            this.price = pd.getPrice();
            this.available = pd.isAvailable();
            this.productId = pd.getProduct().getId(); // تجنب الرجوع لكامل الـ Product
        }
    }


