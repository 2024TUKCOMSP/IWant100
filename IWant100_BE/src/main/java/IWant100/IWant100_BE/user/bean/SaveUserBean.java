package IWant100.IWant100_BE.user.bean;

import IWant100.IWant100_BE.user.bean.small.CreateUserDAOBean;
import IWant100.IWant100_BE.user.bean.small.SaveUserDAOBean;
import IWant100.IWant100_BE.user.domain.DTO.RequestUserSaveDTO;
import IWant100.IWant100_BE.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserBean(CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 등록
    public UUID exec(RequestUserSaveDTO requestUserSaveDTO) {
        // 유저 객체(DAO) 생성
        UserDAO userDAO = createUserDAOBean.exec(requestUserSaveDTO);
        if (userDAO == null) return null;

        // 생성한 객체(DAO)를 DB에 저장
        saveUserDAOBean.exec(userDAO);

        // 생성한 객체 키값 반환
        return  userDAO.getUserId();
    }
}
