package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CreateVotesDTOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVotesDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetVotesBean {
    GetVotesDAOBean getVotesDAOBean;
    CreateVotesDTOBean createVotesDTOBean;

    @Autowired
    public GetVotesBean(GetVotesDAOBean getVotesDAOBean, CreateVotesDTOBean createVotesDTOBean) {
        this.getVotesDAOBean = getVotesDAOBean;
        this.createVotesDTOBean = createVotesDTOBean;
    }

    // 투표 전체 조회
    public List<ResponseVoteGetDTO> exec() {
        // 투표 전체 DAO 찾기
        List<Vote> voteList = getVotesDAOBean.exec();
        if(voteList.isEmpty()) return new ArrayList<>();

        // 찾은 DAO를 DTO로 바꿔서 반환
        return createVotesDTOBean.exec(voteList);
    }
}
