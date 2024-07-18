package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVoteTop1DAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public GetVoteTop1DAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    // 제일 많은 투표 수를 가진 투표 객체 찾기
    public Vote exec() {
        return voteRepositoryJPA.findTop1ByOrderByVoteCountDesc();
    }
}
