package IWant100.IWant100_BE.user.bean;

import IWant100.IWant100_BE.user.bean.small.CreateUserBTOBean;
import IWant100.IWant100_BE.user.bean.small.GetUserDAOBean;
import IWant100.IWant100_BE.user.domain.DTO.ResponseUserGetDTO;
import IWant100.IWant100_BE.user.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserBean {
    CreateUserBTOBean createUserBTOBean;
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetUserBean(CreateUserBTOBean createUserBTOBean, GetUserDAOBean getUserDAOBean) {
        this.createUserBTOBean = createUserBTOBean;
        this.getUserDAOBean = getUserDAOBean;
    }

    // 유저 조회
    public ResponseUserGetDTO exec(UUID userId) {
        // userId를 통해 원하는 유저 찾기
        UserDAO userDAO = getUserDAOBean.exec(userId);
        if(userDAO == null) return null;

        // 찾은 유저를 통해 DTO 생성하고 반환
        return createUserBTOBean.exec(userDAO);
    }
}
