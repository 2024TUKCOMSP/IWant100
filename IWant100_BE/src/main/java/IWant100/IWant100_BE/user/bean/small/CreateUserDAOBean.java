package IWant100.IWant100_BE.user.bean.small;

import IWant100.IWant100_BE.user.domain.DTO.RequestUserSaveDTO;
import IWant100.IWant100_BE.user.domain.UserDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {

    // 유저 DAO 생성
    public UserDAO exec(RequestUserSaveDTO requestUserSaveDTO) {
        return UserDAO.builder()
                .userId(UUID.randomUUID())
                .userImage(requestUserSaveDTO.getUserImage())
                .nickName(requestUserSaveDTO.getNickName())
                .accessToken(requestUserSaveDTO.getAccessToken())
                .oauthId(requestUserSaveDTO.getOauthId())
                .build();
    }
}
