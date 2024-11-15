package iisi.example.gia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestLogController {

    @GetMapping("log")
    public String testLog(){
        log.debug("這是 DEBUG 日誌");
        log.info("這是 INFO 日誌");
        log.warn("這是 WARN 日誌");
        log.error("這是 ERROR 日誌");

        try{
            int result = 1 / 0;
        }catch(Exception e){
            log.error("發生異常!", e);
        }

        return "日誌測試完成";
    }
}
