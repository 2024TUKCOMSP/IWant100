package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CreateVotesDTOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVotesDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetMyVotesBean {
    GetVotesDAOBean getVotesDAOBean;
    CreateVotesDTOBean createVotesDTOBean;

    @Autowired
    public GetMyVotesBean(GetVotesDAOBean getVotesDAOBean, CreateVotesDTOBean createVotesDTOBean) {
        this.getVotesDAOBean = getVotesDAOBean;
        this.createVotesDTOBean = createVotesDTOBean;
    }

    // 내가 만든 투표 전체조회
    public List<ResponseVoteGetDTO> exec(UUID userId) {
        // userId를 통해 원하는 투표 찾기
        List<Vote> voteList = getVotesDAOBean.exec(userId);
        if(voteList.isEmpty()) return new ArrayList<>();

        // 찾는 투표를 통해 DTO 생성 후 반환
        return createVotesDTOBean.exec(voteList);
    }
}
