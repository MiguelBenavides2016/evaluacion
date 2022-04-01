package cl.evaluation.repository;

import cl.evaluation.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);
}
