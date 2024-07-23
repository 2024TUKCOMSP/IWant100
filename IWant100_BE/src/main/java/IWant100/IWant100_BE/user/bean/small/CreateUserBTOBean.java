package IWant100.IWant100_BE.user.bean.small;

import IWant100.IWant100_BE.user.domain.DTO.ResponseUserGetDTO;
import IWant100.IWant100_BE.user.domain.UserDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserBTOBean {

    // DTO 생성해서 반환
    public ResponseUserGetDTO exec(UserDAO userDAO) {
        return ResponseUserGetDTO.builder()
                .userId(userDAO.getUserId())
                .userImage(userDAO.getUserImage())
                .nickName(userDAO.getNickName())
                .build();
    }
}
