package IWant100.IWant100_BE.vote.service;

import IWant100.IWant100_BE.vote.bean.GetVoteContentBean;
import IWant100.IWant100_BE.vote.bean.SaveVoteContentBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteContentService {
    SaveVoteContentBean saveVoteContentBean;
    GetVoteContentBean getVoteContentBean;

    @Autowired
    public VoteContentService(SaveVoteContentBean saveVoteContentBean, GetVoteContentBean getVoteContentBean) {
        this.saveVoteContentBean = saveVoteContentBean;
        this.getVoteContentBean = getVoteContentBean;
    }

    // 투표하기
    public UUID saveVoteContent(RequestVoteContentSaveDTO requestVoteContentSaveDTO) {
        return saveVoteContentBean.exec(requestVoteContentSaveDTO);
    }

    // 투표 세부 조회
    public ResponseVoteContentGetDTO getVoteContent(UUID voteId, UUID userId) {
        return getVoteContentBean.exec(voteId, userId);
    }
}
