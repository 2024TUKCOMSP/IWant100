package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseVoteItemCountGetDTO {
    UUID voteItemId;
    Integer voteItemCount;
}