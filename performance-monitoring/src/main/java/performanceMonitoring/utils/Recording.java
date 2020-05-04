package performanceMonitoring.utils;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.*;

@Component
public class Recording {
    @Autowired
    private RedisUtil redisUtil;


    public void record() throws InterruptedException {
        //得用redis去缓存
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        List<Map<String, Object>> maps = new LinkedList<>();
        int index = 0;
        while (true) {
            for (int i = 0; i < 10; i++) {
                HashMap<String, Object> objectHashMap = new HashMap<>();
                objectHashMap.put("totalRam", (int) (mem.getTotalPhysicalMemorySize() / 1024 / 1024));
                objectHashMap.put("availableRam", (int) (mem.getFreePhysicalMemorySize() / 1024 / 1024));
                objectHashMap.put("systemCpuLoad", (int) (mem.getSystemCpuLoad() * 100));
                objectHashMap.put("processCpuLoad", (int) (mem.getProcessCpuLoad() * 100));
                objectHashMap.put("timestamp", System.currentTimeMillis());
                maps.add(objectHashMap);
                Thread.sleep(1000);
            }
            redisUtil.del("status");
            redisUtil.lSet("status", maps, 20);
            //System.out.println("map: "+maps);
            maps = new LinkedList<>();
        }


    }
}
