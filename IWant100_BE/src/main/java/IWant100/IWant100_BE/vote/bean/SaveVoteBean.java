package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CreateVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.CreateVoteItemDAOBean;
import IWant100.IWant100_BE.vote.bean.small.SaveVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.SaveVoteItemsDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SaveVoteBean {
    CreateVoteDAOBean createVoteDAOBean;
    CreateVoteItemDAOBean createVoteItemDAOBean;
    SaveVoteDAOBean saveVoteDAOBean;
    SaveVoteItemsDAOBean saveVoteItemsDAOBean;

    @Autowired
    public SaveVoteBean(CreateVoteDAOBean createVoteDAOBean, CreateVoteItemDAOBean createVoteItemDAOBean, SaveVoteDAOBean saveVoteDAOBean, SaveVoteItemsDAOBean saveVoteItemsDAOBean) {
        this.createVoteDAOBean = createVoteDAOBean;
        this.createVoteItemDAOBean = createVoteItemDAOBean;
        this.saveVoteDAOBean = saveVoteDAOBean;
        this.saveVoteItemsDAOBean = saveVoteItemsDAOBean;
    }

    // 투표 생성
    public UUID exec(RequestVoteSaveDTO requestVoteSaveDTO) {
        // 투표 DAO 생성
        Vote vote = createVoteDAOBean.exec(requestVoteSaveDTO);
        if(vote == null) return null;

        // 투표 항목 DAO 생성
        List<VoteItem> voteItemList = createVoteItemDAOBean.exec(requestVoteSaveDTO, vote);
        if(voteItemList.isEmpty()) return null;


        // 생성한 투표 DAO 저장
        saveVoteDAOBean.exec(vote);

        // 생성한 투표 항목들 DAO 저장
        saveVoteItemsDAOBean.exec(voteItemList);

        // 생성한 투표 키값 반환
        return vote.getVoteId();
    }
}
