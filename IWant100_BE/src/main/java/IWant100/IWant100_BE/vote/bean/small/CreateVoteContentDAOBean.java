package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.Voter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateVoteContentDAOBean {
    // 투표하기 DAO 생성
    public Voter exec(RequestVoteContentSaveDTO requestVoteContentSaveDTO) {
        return Voter.builder()
                .voterId(UUID.randomUUID())
                .voteItemList(requestVoteContentSaveDTO.getVoteItemList())
                .voteId(requestVoteContentSaveDTO.getVoteId())
                .userId(requestVoteContentSaveDTO.getUserId())
                .build();
    }
}
