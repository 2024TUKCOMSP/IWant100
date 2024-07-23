package IWant100.IWant100_BE.user.bean.small;

import IWant100.IWant100_BE.user.domain.UserDAO;
import IWant100.IWant100_BE.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // userId를 통해 원하는 유저 찾기
    public UserDAO exec(UUID userId) {
        return userRepositoryJPA.findById(userId).orElse(null);
    }
}
