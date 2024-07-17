package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CreateVoteItemDAOBean {
    public List<VoteItem> exec(RequestVoteSaveDTO requestVoteSaveDTO, Vote vote) {

        List<VoteItem> voteItemList = new ArrayList<>();

        for(String voteItemContent : requestVoteSaveDTO.getVoteItemList()) {
            VoteItem voteItem = VoteItem.builder()
                    .voteItemId(UUID.randomUUID())
                    .voteId(vote.getVoteId())
                    .voteItemContent(voteItemContent)
                    .voteItemCount(0)
                    .build();

            voteItemList.add(voteItem);
        }
        return voteItemList;
    }
}
