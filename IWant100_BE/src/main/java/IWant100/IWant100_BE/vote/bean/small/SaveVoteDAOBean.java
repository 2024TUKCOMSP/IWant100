package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveVoteDAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public SaveVoteDAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    // 투표 DAO를 DB에 저장
    public void exec(Vote vote) {
        voteRepositoryJPA.save(vote);
    }
}
