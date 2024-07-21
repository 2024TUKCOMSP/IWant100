package IWant100.IWant100_BE.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDAO {
    @Id
    UUID userId;

    String nickName;
    String oauthId;
    String accessToken;
    String userImage;
}
