package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseVoteGetDTO {
    UUID voteId;
    String voteIntro;
    Integer voteCount;
    Integer voteItemCount;
    String voteItemContent;
    LocalDateTime endAt;
    Boolean isDeleted;
}
