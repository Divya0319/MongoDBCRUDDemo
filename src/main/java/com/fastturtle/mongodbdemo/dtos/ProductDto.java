package com.fastturtle.mongodbdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private String desc;

    private String imageUrl;

    private Double price;

    private CategoryDto category;

}
