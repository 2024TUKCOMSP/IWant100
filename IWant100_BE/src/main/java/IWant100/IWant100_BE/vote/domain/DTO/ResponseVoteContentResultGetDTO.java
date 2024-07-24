package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseVoteContentResultGetDTO {
    UUID voteId;
    String voteIntro;
    LocalDateTime endAt;
    Integer voteCount;
    List<ResponseVoteItemCountGetDTO> voteItemList;
}