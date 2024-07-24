package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.*;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import IWant100.IWant100_BE.vote.domain.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SaveVoteContentBean {
    CreateVoteContentDAOBean createVoteContentDAOBean;
    GetVoteDAOBean getVoteDAOBean;
    GetVoteItemsDAOBean getVoteItemsDAOBean;
    SaveVoteDAOBean saveVoteDAOBean;
    SaveVoteItemsDAOBean saveVoteItemsDAOBean;
    SaveVoterDAOBean saveVoterDAOBean;

    @Autowired
    public SaveVoteContentBean(CreateVoteContentDAOBean createVoteContentDAOBean, GetVoteDAOBean getVoteDAOBean, GetVoteItemsDAOBean getVoteItemsDAOBean, SaveVoteDAOBean saveVoteDAOBean, SaveVoteItemsDAOBean saveVoteItemsDAOBean, SaveVoterDAOBean saveVoterDAOBean) {
        this.createVoteContentDAOBean = createVoteContentDAOBean;
        this.getVoteDAOBean = getVoteDAOBean;
        this.getVoteItemsDAOBean = getVoteItemsDAOBean;
        this.saveVoteDAOBean = saveVoteDAOBean;
        this.saveVoteItemsDAOBean = saveVoteItemsDAOBean;
        this.saveVoterDAOBean = saveVoterDAOBean;
    }

    // 투표하기
    public UUID exec(RequestVoteContentSaveDTO requestVoteContentSaveDTO) {
        // 투표하기 DAO 생성
        Voter voter = createVoteContentDAOBean.exec(requestVoteContentSaveDTO);
        if(voter == null) return  null;

        Vote vote = getVoteDAOBean.exec(requestVoteContentSaveDTO.getVoteId(), requestVoteContentSaveDTO.getUserId());
        if(vote == null) return null;

        List<VoteItem> voteItemList = getVoteItemsDAOBean.exec(requestVoteContentSaveDTO.getVoteId());
        if(voteItemList.isEmpty()) return  null;

        for(VoteItem voteItem : voteItemList) {
            if(voter.getVoteItemList().contains(voteItem.getVoteItemId()))
                voteItem.setVoteItemCount(voteItem.getVoteItemCount()+1);
        }

        vote.setVoteCount(vote.getVoteCount()+1);

        // 바꾼 것들 저장
        saveVoterDAOBean.exec(voter);
        saveVoteDAOBean.exec(vote);
        saveVoteItemsDAOBean.exec(voteItemList);

        // 키값 반환
        return voter.getUserId();
    }
}
