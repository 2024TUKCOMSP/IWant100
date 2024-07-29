package IWant100.IWant100_BE.user.repository;

import IWant100.IWant100_BE.user.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, UUID> {
    UserDAO findByOauthId(String oauthId);
}
