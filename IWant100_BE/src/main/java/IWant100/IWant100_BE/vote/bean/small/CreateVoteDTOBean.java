package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateVoteDTOBean {
    GetVoteItemTop1DAOBean getVoteItemTop1DAOBean;

    @Autowired
    public CreateVoteDTOBean(GetVoteItemTop1DAOBean getVoteItemTop1DAOBean) {
        this.getVoteItemTop1DAOBean = getVoteItemTop1DAOBean;
    }

    // DTO를 생성해서 반환
    public ResponseVoteGetDTO exec(Vote vote) {

        // voteId를 통해 가장 많은 투표의 항목들 중 가장 많은 투표 수를 가진 항목 찾기
        VoteItem voteItem = getVoteItemTop1DAOBean.exec(vote.getVoteId());

        return ResponseVoteGetDTO.builder()
                .voteId(vote.getVoteId())
                .voteCount(vote.getVoteCount())
                .voteIntro(vote.getVoteIntro())
                .endAt(vote.getEndAt())
                .voteItemCount(voteItem.getVoteItemCount())
                .voteItemContent(voteItem.getVoteItemContent())
                .build();
    }
}
