package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Voter;
import IWant100.IWant100_BE.vote.repository.VoterRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveVoterDAOBean {
    VoterRepositoryJPA voterRepositoryJPA;

    @Autowired
    public SaveVoterDAOBean(VoterRepositoryJPA voterRepositoryJPA) {
        this.voterRepositoryJPA = voterRepositoryJPA;
    }

    // 투표자 DAO를 DB에 저장
    public void exec(Voter voter) {
        voterRepositoryJPA.save(voter);
    }
}
