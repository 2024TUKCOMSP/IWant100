package IWant100.IWant100_BE.vote.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestVoteDeleteDTO {
    UUID voteId;
    UUID userId;
}
