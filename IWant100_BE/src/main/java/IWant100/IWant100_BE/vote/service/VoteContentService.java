package IWant100.IWant100_BE.vote.service;

import IWant100.IWant100_BE.vote.bean.GetVoteContentBean;
import IWant100.IWant100_BE.vote.bean.GetVoteContentResultBean;
import IWant100.IWant100_BE.vote.bean.SaveVoteContentBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentGetDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentResultGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteContentService {
    SaveVoteContentBean saveVoteContentBean;
    GetVoteContentBean getVoteContentBean;
    GetVoteContentResultBean getVoteContentResultBean;

    @Autowired
    public VoteContentService(SaveVoteContentBean saveVoteContentBean, GetVoteContentBean getVoteContentBean, GetVoteContentResultBean getVoteContentResultBean) {
        this.saveVoteContentBean = saveVoteContentBean;
        this.getVoteContentBean = getVoteContentBean;
        this.getVoteContentResultBean = getVoteContentResultBean;
    }

    // 투표하기
    public UUID saveVoteContent(RequestVoteContentSaveDTO requestVoteContentSaveDTO) {
        return saveVoteContentBean.exec(requestVoteContentSaveDTO);
    }

    // 투표 세부 조회
    public ResponseVoteContentGetDTO getVoteContent(UUID voteId, UUID userId) {
        return getVoteContentBean.exec(voteId, userId);
    }

    // 투표 결과 조회
    public ResponseVoteContentResultGetDTO getVoteContentResult(UUID voteId) {
        return getVoteContentResultBean.exec(voteId);
    }
}
