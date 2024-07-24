package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CreateVoteContentDTOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteItemsDAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoterDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import IWant100.IWant100_BE.vote.domain.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetVoteContentBean {
    GetVoteDAOBean getVoteDAOBean;
    GetVoterDAOBean getVoterDAOBean;
    GetVoteItemsDAOBean getVoteItemsDAOBean;
    CreateVoteContentDTOBean createVoteContentDTOBean;

    @Autowired
    public GetVoteContentBean(GetVoteDAOBean getVoteDAOBean, GetVoterDAOBean getVoterDAOBean, GetVoteItemsDAOBean getVoteItemsDAOBean, CreateVoteContentDTOBean createVoteContentDTOBean) {
        this.getVoteDAOBean = getVoteDAOBean;
        this.getVoterDAOBean = getVoterDAOBean;
        this.getVoteItemsDAOBean = getVoteItemsDAOBean;
        this.createVoteContentDTOBean = createVoteContentDTOBean;
    }

    // 투표 세부조회
    public ResponseVoteContentGetDTO exec(UUID voteId, UUID userId) {

        // userId를 통해 이미 그 vote 에 투표했으면 null 값 반환
        Voter voter = getVoterDAOBean.exec(voteId, userId);
        if(voter != null) return null;

        // voteId를 통해 원하는 투표 찾기
        Vote vote = getVoteDAOBean.exec(voteId);
        if(vote == null) return  null;

        // voteId를 통해 원하는 투표항목들 찾기
        List<VoteItem> voteItemList = getVoteItemsDAOBean.exec(voteId);
        if(voteItemList.isEmpty()) return  null;

        // DTO 생성해서 반환
        return createVoteContentDTOBean.exec(voteItemList, vote);
    }
}
