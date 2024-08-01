package IWant100.IWant100_BE.vote.bean.small;

import IWant100.IWant100_BE.vote.domain.Vote;
import IWant100.IWant100_BE.vote.repository.VoteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveVotesDAOBean {
    VoteRepositoryJPA voteRepositoryJPA;

    @Autowired
    public SaveVotesDAOBean(VoteRepositoryJPA voteRepositoryJPA) {
        this.voteRepositoryJPA = voteRepositoryJPA;
    }

    public void exec(List<Vote> voteList) {
        voteRepositoryJPA.saveAll(voteList);
    }
}
