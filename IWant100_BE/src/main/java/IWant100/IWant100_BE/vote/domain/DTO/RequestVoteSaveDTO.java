package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class RequestVoteSaveDTO {
    UUID userId;
    String voteIntro;
    Boolean isDuplication;
    Boolean isAnonymous;
    LocalDateTime endAt;
    List<String> VoteItemList;
}
