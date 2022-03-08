package uz.pdp.appwarehouse.entity;

import lombok.*;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

import javax.persistence.*;

// Nurkulov Nodirbek 3/8/2022  8:25 AM

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends AbsEntity {

    @ManyToOne
    private Category parentCategory;
}
