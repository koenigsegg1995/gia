package iisi.example.gia;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 假設所有人的初始密碼都是他們的 ename
        String[] names = {"king", "blake", "clark", "jones", "martin",
                "allen", "turner", "james", "ward", "ford",
                "smith", "scott", "adams", "miller"};

        System.out.println("-- 執行以下 SQL 來插入數據 --");
        System.out.println("INSERT INTO user_auth (empno, username, password, role) VALUES");

        for (String name : names) {
            String encodedPassword = encoder.encode(name);
            System.out.println(String.format("-- %s's encoded password: %s", name, encodedPassword));
        }
    }
}
