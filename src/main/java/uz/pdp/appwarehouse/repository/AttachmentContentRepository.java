package uz.pdp.appwarehouse.repository;
// Nurkulov Nodirbek 3/8/2022  3:23 PM

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
}
