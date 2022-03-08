package uz.pdp.appwarehouse.payload;

import lombok.Data;

// Nurkulov Nodirbek 3/8/2022  3:43 PM
@Data
public class ProductDto {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;
}