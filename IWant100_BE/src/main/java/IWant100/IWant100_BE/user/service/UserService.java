package IWant100.IWant100_BE.user.service;

import IWant100.IWant100_BE.user.bean.SaveUserBean;
import IWant100.IWant100_BE.user.domain.DTO.RequestUserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean) {
        this.saveUserBean = saveUserBean;
    }

    // 유저 등록
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }
}
