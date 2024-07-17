package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateVoteDAOBean {
    // 투표 DAO 생성
    public Vote exec(RequestVoteSaveDTO requestVoteSaveDTO) {
        return Vote.builder()
                .voteId(UUID.randomUUID())
                .userId(requestVoteSaveDTO.getUserId())
                .voteIntro(requestVoteSaveDTO.getVoteIntro())
                .isAnonymous(requestVoteSaveDTO.getIsAnonymous())
                .isDuplication(requestVoteSaveDTO.getIsDuplication())
                .createAt(LocalDateTime.now())
                .endAt(requestVoteSaveDTO.getEndAt())
                .voteCount(0)
                .build();
    }
}
