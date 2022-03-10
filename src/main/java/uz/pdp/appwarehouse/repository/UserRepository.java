package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class UserRepository {
    final private Map<String, User> users = new ConcurrentHashMap<>();

    public User findUserByUsername(String username) {
        return users.get(username);
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }
}
