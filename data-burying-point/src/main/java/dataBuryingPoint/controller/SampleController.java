package dataBuryingPoint.controller;

import dataBuryingPoint.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

/**
 * @Description SampleController
 * @Author Administrator
 * @Date 2019/9/10 15:14
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "dataBuryingPoint",method = RequestMethod.POST)
public class SampleController {
    @RequestMapping(value = "index")
    @ResponseBody
    public User index(User user) {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Total RAM：" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
        System.out.println("Available　RAM：" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
        System.out.println("SystemCpuLoad：" + (int)(mem.getSystemCpuLoad()*100)+"%");
        System.out.println("ProcessCpuLoad：" + (int)(mem.getProcessCpuLoad()*100)+"%");
        return user;
    }
}
