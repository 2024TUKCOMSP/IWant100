package IWant100.IWant100_BE.vote.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vote {
    @Id
    UUID voteId;

    UUID userId;
    String voteIntro;
    Integer voteCount;
    LocalDateTime createAt;
    LocalDateTime endAt;
    Boolean isDuplication;
    Boolean isDeleted;
}