package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CheckVoteEndAtDAOBean;
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
    CheckVoteEndAtDAOBean checkVoteEndAtDAOBean;

    @Autowired
    public GetMyVotesBean(GetVotesDAOBean getVotesDAOBean, CreateVotesDTOBean createVotesDTOBean, CheckVoteEndAtDAOBean checkVoteEndAtDAOBean) {
        this.getVotesDAOBean = getVotesDAOBean;
        this.createVotesDTOBean = createVotesDTOBean;
        this.checkVoteEndAtDAOBean = checkVoteEndAtDAOBean;
    }

    // 내가 만든 투표 전체조회
    public List<ResponseVoteGetDTO> exec(UUID userId) {
        // 기간이 안지난 투표들 endAt과 현재 시간 비교해 기간이 끝났는지 확인
        checkVoteEndAtDAOBean.exec();

        // userId를 통해 원하는 투표 찾기
        List<Vote> voteList = getVotesDAOBean.exec(userId);
        if(voteList.isEmpty()) return new ArrayList<>();

        // 찾는 투표를 통해 DTO 생성 후 반환
        return createVotesDTOBean.exec(voteList);
    }
}
