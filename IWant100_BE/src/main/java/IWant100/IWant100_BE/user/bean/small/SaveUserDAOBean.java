package IWant100.IWant100_BE.user.bean.small;

import IWant100.IWant100_BE.user.domain.UserDAO;
import IWant100.IWant100_BE.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDAOBean {
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public SaveUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // 유저 DAO를 DB에 저장
    public void exec(UserDAO userDAO) {
        userRepositoryJPA.save(userDAO);
    }
}
