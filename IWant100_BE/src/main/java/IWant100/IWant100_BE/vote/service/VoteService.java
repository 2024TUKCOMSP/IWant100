package IWant100.IWant100_BE.vote.service;

import IWant100.IWant100_BE.vote.bean.DeleteVoteBean;
import IWant100.IWant100_BE.vote.bean.SaveVoteBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteDeleteDTO;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteService {
    SaveVoteBean saveVoteBean;
    DeleteVoteBean deleteVoteBean;

    @Autowired
    public VoteService(SaveVoteBean saveVoteBean, DeleteVoteBean deleteVoteBean) {
        this.saveVoteBean = saveVoteBean;
        this.deleteVoteBean = deleteVoteBean;
    }

    // 투표 생성
    public UUID exec(RequestVoteSaveDTO requestVoteSaveDTO) {
        return saveVoteBean.exec(requestVoteSaveDTO);
    }

    // 투표 삭제
    public Boolean exec(RequestVoteDeleteDTO requestVoteDeleteDTO) {
        return deleteVoteBean.exec(requestVoteDeleteDTO);
    }
}
