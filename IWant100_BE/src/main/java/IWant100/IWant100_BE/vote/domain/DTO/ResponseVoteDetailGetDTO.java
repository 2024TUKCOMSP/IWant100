package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseVoteDetailGetDTO {
    UUID voteId;
    String voteIntro;
    String voteItemContent;
    LocalDateTime endAt;
    List<ResponseVoteGetDTO> voteItemList;
}
