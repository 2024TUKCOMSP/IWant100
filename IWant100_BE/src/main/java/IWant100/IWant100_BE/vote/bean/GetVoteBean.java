package IWant100.IWant100_BE.vote.bean;

import IWant100.IWant100_BE.vote.bean.small.CheckVoteEndAtDAOBean;
import IWant100.IWant100_BE.vote.bean.small.CreateVoteDTOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVoteTop1DAOBean;
import IWant100.IWant100_BE.vote.bean.small.GetVotesDAOBean;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetVoteBean {
    GetVoteTop1DAOBean getVoteTop1DAOBean;
    GetVotesDAOBean getVotesDAOBean;
    CreateVoteDTOBean createVoteDTOBean;
    CheckVoteEndAtDAOBean checkVoteEndAtDAOBean;

    @Autowired
    public GetVoteBean(GetVoteTop1DAOBean getVoteTop1DAOBean, GetVotesDAOBean getVotesDAOBean, CreateVoteDTOBean createVoteDTOBean, CheckVoteEndAtDAOBean checkVoteEndAtDAOBean) {
        this.getVoteTop1DAOBean = getVoteTop1DAOBean;
        this.getVotesDAOBean = getVotesDAOBean;
        this.createVoteDTOBean = createVoteDTOBean;
        this.checkVoteEndAtDAOBean = checkVoteEndAtDAOBean;
    }

    // 메인화면 인기투표 조회
    public ResponseVoteGetDTO exec() {
        // 기간이 안지난 투표들 endAt과 현재 시간 비교해 기간이 끝났는지 확인
        List<Vote> voteList = getVotesDAOBean.exec(false);
        if(voteList.isEmpty()) return null;

        checkVoteEndAtDAOBean.exec(voteList);

        // 제일 많은 투표수를 가진 vote 객체 찾기
        Vote vote = getVoteTop1DAOBean.exec();
        if (vote == null) return null;

        // 찾은 객체(DAO)를 DTO로 변환해서 반환
        return createVoteDTOBean.exec(vote);
    }
}
