package iisi.example.gia.userauth.service;

import iisi.example.gia.userauth.dao.UserAuthDAO;
import iisi.example.gia.userauth.dto.UserAuthDTO;
import iisi.example.gia.userauth.entity.UserAuthDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    private UserAuthDAO userAuthDAO;

    public UserAuthDTO findByUsername(String username) {
        UserAuthDO userAuthDO = userAuthDAO.findByUsername(username);

        UserAuthDTO userAuthDTO = new UserAuthDTO();
        userAuthDTO.setEmpno(userAuthDO.getEmpno());
        userAuthDTO.setUsername(userAuthDO.getUsername());
        userAuthDTO.setPassword(userAuthDO.getPassword());
        userAuthDTO.setRole(userAuthDO.getRole());

        return userAuthDTO;
    }

}
