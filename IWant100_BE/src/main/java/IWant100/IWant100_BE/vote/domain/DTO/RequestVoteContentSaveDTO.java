package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RequestVoteContentSaveDTO {
    UUID userId;
    UUID voteId;
    List<UUID> voteItemList;
}
