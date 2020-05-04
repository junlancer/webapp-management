package performanceMonitoring.service;

import performanceMonitoring.po.Status;

import java.util.List;
import java.util.Map;


public interface IMonitor {
    List<Map<String, Object>> getStatus();
}
