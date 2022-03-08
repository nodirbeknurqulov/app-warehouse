package uz.pdp.appwarehouse.repository;
// Nurkulov Nodirbek 3/8/2022  3:18 PM

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
