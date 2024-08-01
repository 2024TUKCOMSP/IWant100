package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckVoteEndAtDAOBean {
    GetVotesDAOBean getVotesDAOBean;
    SaveVotesDAOBean saveVotesDAOBean;
    SaveVoteDAOBean saveVoteDAOBean;

    @Autowired
    public CheckVoteEndAtDAOBean(GetVotesDAOBean getVotesDAOBean, SaveVotesDAOBean saveVotesDAOBean, SaveVoteDAOBean saveVoteDAOBean) {
        this.getVotesDAOBean = getVotesDAOBean;
        this.saveVotesDAOBean = saveVotesDAOBean;
        this.saveVoteDAOBean = saveVoteDAOBean;
    }

    // 현재 시간이랑 비교해 끝난 투표인지 확인
    public void exec() {
        List<Vote> voteList = getVotesDAOBean.exec(false);

        List<Vote> isDeletedList = new ArrayList<>();

        for(Vote vote : voteList) {
            LocalDateTime endAt = vote.getEndAt();
            LocalDateTime now = LocalDateTime.now();

            if(endAt.isBefore(now)) {
                vote.setIsDeleted(true);
            }

            isDeletedList.add(vote);
        }
        saveVotesDAOBean.exec(isDeletedList);
    }
}
