package uz.pdp.appwarehouse.entity;
// Nurkulov Nodirbek 3/8/2022  11:56 AM

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client extends AbsEntity {
    @Column(unique = true,nullable = true)
    private String phoneNumber;
}
