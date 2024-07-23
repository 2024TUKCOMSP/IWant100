package IWant100.IWant100_BE.user.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserGetDTO {
    UUID userId;
    String userImage;
    String nickName;
}
