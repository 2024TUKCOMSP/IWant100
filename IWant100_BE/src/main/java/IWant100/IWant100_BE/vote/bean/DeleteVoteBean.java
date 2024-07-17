package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.DeleteVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.DeleteVoteItemsDAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteDAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteItemsDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteDeleteDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteVoteBean {
    GetVoteDAOBean getVoteDAOBean;
    GetVoteItemsDAOBean getVoteItemsDAOBean;
    DeleteVoteDAOBean deleteVoteDAOBean;
    DeleteVoteItemsDAOBean deleteVoteItemsDAOBean;

    @Autowired
    public DeleteVoteBean(GetVoteDAOBean getVoteDAOBean, GetVoteItemsDAOBean getVoteItemsDAOBean, DeleteVoteDAOBean deleteVoteDAOBean, DeleteVoteItemsDAOBean deleteVoteItemsDAOBean) {
        this.getVoteDAOBean = getVoteDAOBean;
        this.getVoteItemsDAOBean = getVoteItemsDAOBean;
        this.deleteVoteDAOBean = deleteVoteDAOBean;
        this.deleteVoteItemsDAOBean = deleteVoteItemsDAOBean;
    }


    // 투표 삭제
    public Boolean exec(RequestVoteDeleteDTO requestVoteDeleteDTO) {
        // userId와 voteId를 통해 원하는 객체 찾기
        Vote vote = getVoteDAOBean.exec(requestVoteDeleteDTO.getVoteId(), requestVoteDeleteDTO.getUserId());
        if (vote == null) return false;

        // vote 객체가 있으면 voteItem 항목들도 찾기
        List<VoteItem> voteItemList = getVoteItemsDAOBean.exec(requestVoteDeleteDTO.getVoteId());
        if (voteItemList.isEmpty()) return false;

        // 투표 삭제
        deleteVoteDAOBean.exec(vote);

        // 투표 항목들 삭제
        deleteVoteItemsDAOBean.exec(voteItemList);

        // 성공 시 true 반환
        return true;
    }
}
