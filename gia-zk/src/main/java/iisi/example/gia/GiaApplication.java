package iisi.example.gia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class GiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiaApplication.class, args);
    }

}
