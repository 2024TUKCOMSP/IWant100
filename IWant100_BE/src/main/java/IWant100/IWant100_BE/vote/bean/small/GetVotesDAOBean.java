package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetVotesDAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public GetVotesDAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    // 투표 전체 DAO 찾기
    public List<Vote> exec() {
        return voteRepositoryJPA.findAllByOrderByEndAtAsc();
    }
}
