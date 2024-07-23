package IWant100.IWant100_BE.user.service;

import IWant100.IWant100_BE.user.bean.GetUserBean;
import IWant100.IWant100_BE.user.bean.SaveUserBean;
import IWant100.IWant100_BE.user.domain.DTO.RequestUserSaveDTO;
import IWant100.IWant100_BE.user.domain.DTO.ResponseUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    SaveUserBean saveUserBean;
    GetUserBean getUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean, GetUserBean getUserBean) {
        this.saveUserBean = saveUserBean;
        this.getUserBean = getUserBean;
    }

    // 유저 등록
    public UUID saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        return saveUserBean.exec(requestUserSaveDTO);
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(UUID userId) {
        return getUserBean.exec(userId);
    }
}
