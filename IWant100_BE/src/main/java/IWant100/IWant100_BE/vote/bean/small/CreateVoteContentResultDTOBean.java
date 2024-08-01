package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentResultGetDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteItemResultGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateVoteContentResultDTOBean {

    // DTO 생성해서 반환
    public ResponseVoteContentResultGetDTO exec(List<VoteItem> voteItemList, Vote vote) {
        // DTO 리스트
        List<ResponseVoteItemResultGetDTO> responseVoteItemResultGetDTOList = new ArrayList<>();

        // for문을 통해 투표 객체 하나씩 꺼내 DTO 에 넣기
        for(VoteItem voteItem : voteItemList) {
            ResponseVoteItemResultGetDTO responseVoteItemGetDto = ResponseVoteItemResultGetDTO.builder()
                    .voteItemId(voteItem.getVoteItemId())
                    .voteItemCount(voteItem.getVoteItemCount())
                    .voteItemContent(voteItem.getVoteItemContent())
                    .build();

            responseVoteItemResultGetDTOList.add(responseVoteItemGetDto);
        }

        return ResponseVoteContentResultGetDTO.builder()
                .voteId(vote.getVoteId())
                .voteIntro(vote.getVoteIntro())
                .voteCount(vote.getVoteCount())
                .endAt(vote.getEndAt())
                .voteItemList(responseVoteItemResultGetDTOList)
                .build();
    }
}