package iisi.example.gia.userauth.dao;

import iisi.example.gia.userauth.entity.UserAuthDO;

public interface UserAuthDAO {

    // 使用 username 查詢用戶 (登入時使用)
    UserAuthDO findByUsername(String Username);

}
