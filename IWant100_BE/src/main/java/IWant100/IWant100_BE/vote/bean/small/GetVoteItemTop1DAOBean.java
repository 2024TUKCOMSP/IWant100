package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import IWant100.IWant100_BE.vote.repository.VoteItemRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetVoteItemTop1DAOBean {
    VoteItemRepositoryJPA voteItemRepositoryJPA;

    @Autowired
    public GetVoteItemTop1DAOBean(VoteItemRepositoryJPA voteItemRepositoryJPA) {
        this.voteItemRepositoryJPA = voteItemRepositoryJPA;
    }

    // voteId를 통해 원하는 투표항목들 찾고 그 중 제일 많은 투표 수 조회
    public VoteItem exec(UUID voteId) {
        return voteItemRepositoryJPA.findTop1ByVoteIdOrderByVoteItemCountDesc(voteId);
    }
}
