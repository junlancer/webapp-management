package performanceMonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import performanceMonitoring.utils.Recording;

/**
 * @Description app start
 * @Author Administrator
 * @Date 2019/9/10 15:06
 * @Version 1.0
 **/
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}
