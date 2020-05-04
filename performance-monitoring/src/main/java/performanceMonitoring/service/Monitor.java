package performanceMonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sun.management.OperatingSystemMXBean;
import performanceMonitoring.po.Status;
import performanceMonitoring.utils.RedisUtil;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Monitor implements IMonitor {


    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Map<String, Object>> getStatus() {
        //得用redis去缓存
        List<Object> maps = redisUtil.lGet("status", 0, -1);
        List<Map<String, Object>> maps1 = new ArrayList<>();
        for (Object status : (List)maps.get(0)) {
            maps1.add((Map<String, Object>) status);
        }
        //System.out.println(maps);
        return maps1;
    }
}
