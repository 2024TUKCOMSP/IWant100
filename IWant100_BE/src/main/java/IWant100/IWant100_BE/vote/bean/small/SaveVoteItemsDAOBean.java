package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import IWant100.IWant100_BE.vote.repository.VoteItemRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveVoteItemsDAOBean {
    VoteItemRepositoryJPA voteItemRepositoryJPA;

    @Autowired
    public SaveVoteItemsDAOBean(VoteItemRepositoryJPA voteItemRepositoryJPA) {
        this.voteItemRepositoryJPA = voteItemRepositoryJPA;
    }

    // 투표 항목들 저장
    public void exec(List<VoteItem> voteItemList) {
        voteItemRepositoryJPA.saveAll(voteItemList);
    }
}
