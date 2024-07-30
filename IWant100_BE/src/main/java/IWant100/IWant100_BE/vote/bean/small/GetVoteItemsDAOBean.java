package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import IWant100.IWant100_BE.vote.repository.VoteItemRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetVoteItemsDAOBean {
    VoteItemRepositoryJPA voteItemRepositoryJPA;

    @Autowired
    public GetVoteItemsDAOBean(VoteItemRepositoryJPA voteItemRepositoryJPA) {
        this.voteItemRepositoryJPA = voteItemRepositoryJPA;
    }

    // voteId를 통해 원하는 객체들 찾기
    public List<VoteItem> exec(UUID voteId) {
        return voteItemRepositoryJPA.findAllByVoteIdOrderByVoteItemIndexAsc(voteId);
    }
}
