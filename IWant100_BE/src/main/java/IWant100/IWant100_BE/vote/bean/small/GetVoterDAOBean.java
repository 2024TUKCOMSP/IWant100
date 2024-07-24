package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Voter;
import IWant100.IWant100_BE.vote.repository.VoterRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetVoterDAOBean {
    VoterRepositoryJPA voterRepositoryJPA;

    @Autowired
    public GetVoterDAOBean(VoterRepositoryJPA voterRepositoryJPA) {
        this.voterRepositoryJPA = voterRepositoryJPA;
    }

    // voteId와 userId 투표한 사람 찾기
    public Voter exec(UUID voteId, UUID userId) {
        return voterRepositoryJPA.findByVoteIdAndUserId(voteId, userId);
    }

    public Voter exec(UUID voterId) {
        return voterRepositoryJPA.findById(voterId).orElse(null);
    }
}
