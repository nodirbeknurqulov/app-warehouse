package uz.pdp.appwarehouse.payload;

import lombok.Data;

// Nurkulov Nodirbek 3/8/2022  2:43 PM

@Data
public class CategoryDto {
    private String name;
    private Integer parentCategoryId;
}
