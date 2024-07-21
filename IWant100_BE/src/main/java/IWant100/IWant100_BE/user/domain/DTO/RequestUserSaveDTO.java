package IWant100.IWant100_BE.user.domain.DTO;

import lombok.Data;

@Data
public class RequestUserSaveDTO {
    String nickName;
    String oauthId;
    String accessToken;
    String userImage;
}
