package performanceMonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.management.OperatingSystemMXBean;
import performanceMonitoring.po.Status;
import performanceMonitoring.service.IMonitor;
import performanceMonitoring.utils.Recording;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;

/**
 * @Description SampleController
 * @Author Administrator
 * @Date 2019/9/10 15:14
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "performanceMonitoring", method = RequestMethod.POST)
public class GetStatusController {
    @Autowired
    private IMonitor monitor;

    @Autowired
    private Recording recording;

    @RequestMapping(value = "index")
    @ResponseBody
    public List<Map<String, Object>> index(HttpServletRequest httpRequest) {
        System.out.println(httpRequest.getLocalAddr());
        //不能放在这边
        new Thread(() -> {
            try {
                recording.record();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return monitor.getStatus();
    }
}
