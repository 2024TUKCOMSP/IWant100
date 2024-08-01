package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateVotesDTOBean {
    GetVoteItemTop1DAOBean getVoteItemTop1DAOBean;

    @Autowired
    public CreateVotesDTOBean(GetVoteItemTop1DAOBean getVoteItemTop1DAOBean) {
        this.getVoteItemTop1DAOBean = getVoteItemTop1DAOBean;
    }

    // 투표 DTO 리스트 생성해서 반환
    public List<ResponseVoteGetDTO> exec(List<Vote> voteList) {
        // DTO 리스트 생성
        List<ResponseVoteGetDTO> responseVoteGetDTOList = new ArrayList<>();

        // for문을 이용해 DAO 객체 하나씩 꺼내 DTO 생성 후 DTO 리스트에 추가
        for(Vote vote : voteList) {

            // voteId를 통해 투표 항목들 중 제일 많은 투표수를 받은 항목 조회
            VoteItem voteItem = getVoteItemTop1DAOBean.exec(vote.getVoteId());

            // DTO 생성
            ResponseVoteGetDTO responseVoteGetDTO = ResponseVoteGetDTO.builder()
                    .voteId(vote.getVoteId())
                    .voteCount(vote.getVoteCount())
                    .voteIntro(vote.getVoteIntro())
                    .endAt(vote.getEndAt())
                    .voteItemCount(voteItem.getVoteItemCount())
                    .voteItemContent(voteItem.getVoteItemContent())
                    .isDeleted(vote.getIsDeleted())
                    .build();

            responseVoteGetDTOList.add(responseVoteGetDTO);
        }

        // DTO 리스트 반환
        return responseVoteGetDTOList;
    }
}
