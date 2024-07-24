package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentGetDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteItemGetDto;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateVoteContentDTOBean {
    // DTO 생성해서 반환
    public ResponseVoteContentGetDTO exec(List<VoteItem> voteItemList, Vote vote) {
        // DTO 생성
        List<ResponseVoteItemGetDto> responseVoteItemGetDtoList = new ArrayList<>();

        // for문을 통해 투표 객체 하나씩 꺼내 DTO 에 넣기
        for(VoteItem voteItem : voteItemList) {
            ResponseVoteItemGetDto responseVoteItemGetDto = ResponseVoteItemGetDto.builder()
                    .voteItemId(voteItem.getVoteItemId())
                    .voteItemContent(voteItem.getVoteItemContent())
                    .build();

            responseVoteItemGetDtoList.add(responseVoteItemGetDto);
        }

        return ResponseVoteContentGetDTO.builder()
                .voteId(vote.getVoteId())
                .voteIntro(vote.getVoteIntro())
                .isDuplication(vote.getIsDuplication())
                .endAt(vote.getEndAt())
                .voteItemList(responseVoteItemGetDtoList)
                .build();
    }
}
