package IWant100.IWant100_BE.vote.service;

import IWant100.IWant100_BE.vote.bean.DeleteVoteBean;
import IWant100.IWant100_BE.vote.bean.GetVoteBean;
import IWant100.IWant100_BE.vote.bean.GetVotesBean;
import IWant100.IWant100_BE.vote.bean.SaveVoteBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteDeleteDTO;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteService {
    SaveVoteBean saveVoteBean;
    DeleteVoteBean deleteVoteBean;
    GetVotesBean getVotesBean;
    GetVoteBean getVoteBean;

    @Autowired
    public VoteService(SaveVoteBean saveVoteBean, DeleteVoteBean deleteVoteBean, GetVotesBean getVotesBean, GetVoteBean getVoteBean) {
        this.saveVoteBean = saveVoteBean;
        this.deleteVoteBean = deleteVoteBean;
        this.getVotesBean = getVotesBean;
        this.getVoteBean = getVoteBean;
    }

    // 투표 생성
    public UUID exec(RequestVoteSaveDTO requestVoteSaveDTO) {
        return saveVoteBean.exec(requestVoteSaveDTO);
    }

    // 투표 삭제
    public Boolean exec(RequestVoteDeleteDTO requestVoteDeleteDTO) {
        return deleteVoteBean.exec(requestVoteDeleteDTO);
    }

    // 투표 전체 조회
    public List<ResponseVoteGetDTO> getVoteAll() {
        return getVotesBean.exec();
    }

    // 메인화면 인기투표 조회
    public ResponseVoteGetDTO getVote() {
        return getVoteBean.exec();
    }
}
