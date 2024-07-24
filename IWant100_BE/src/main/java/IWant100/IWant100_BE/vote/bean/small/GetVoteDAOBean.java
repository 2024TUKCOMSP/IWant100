package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetVoteDAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public GetVoteDAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    // userId와 voteId를 통해 원하는 객체 찾기
    public Vote exec(UUID voteId, UUID userId) {
        return voteRepositoryJPA.findByVoteIdAndUserId(voteId, userId);
    }

    // voteId를 통해 원하는 객체 찾기
    public Vote exec(UUID voteId) {
        return voteRepositoryJPA.findById(voteId).orElse(null);
    }
}
