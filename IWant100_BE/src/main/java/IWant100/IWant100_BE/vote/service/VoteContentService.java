package IWant100.IWant100_BE.vote.service;

import IWant100.IWant100_BE.vote.bean.SaveVoteContentBean;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteContentService {
    SaveVoteContentBean saveVoteContentBean;

    @Autowired
    public VoteContentService(SaveVoteContentBean saveVoteContentBean) {
        this.saveVoteContentBean = saveVoteContentBean;
    }

    // 투표하기
    public UUID saveVoteContent(RequestVoteContentSaveDTO requestVoteContentSaveDTO) {
        return saveVoteContentBean.exec(requestVoteContentSaveDTO);
    }
}
