package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CreateVoteContentResultDTOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteItemsDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentResultGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetVoteContentResultBean {
    GetVoteDAOBean getVoteDAOBean;
    GetVoteItemsDAOBean getVoteItemsDAOBean;
    CreateVoteContentResultDTOBean createVoteContentResultDTOBean;

    @Autowired
    public GetVoteContentResultBean(GetVoteDAOBean getVoteDAOBean, GetVoteItemsDAOBean getVoteItemsDAOBean, CreateVoteContentResultDTOBean createVoteContentResultDTOBean) {
        this.getVoteDAOBean = getVoteDAOBean;
        this.getVoteItemsDAOBean = getVoteItemsDAOBean;
        this.createVoteContentResultDTOBean = createVoteContentResultDTOBean;
    }

    // 투표 결과 조회
    public ResponseVoteContentResultGetDTO exec(UUID voteId) {
        // voteId를 통해 원하는 투표 찾기
        Vote vote = getVoteDAOBean.exec(voteId);
        if(vote == null) return  null;

        // voteId를 통해 원하는 투표 항목들 찾기
        List<VoteItem> voteItemList = getVoteItemsDAOBean.exec(voteId);
        if(voteItemList.isEmpty()) return  null;

        // DTO 생성후 반환
        return createVoteContentResultDTOBean.exec(voteItemList, vote);
    }
}