package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteVoteDAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public DeleteVoteDAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    // 투표 삭제
    public void exec(Vote vote) {
        voteRepositoryJPA.delete(vote);
    }
}
