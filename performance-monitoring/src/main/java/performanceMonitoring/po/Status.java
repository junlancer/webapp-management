package performanceMonitoring.po;

import org.springframework.stereotype.Repository;

@Repository
public class Status {
    //总ram
    private int totalRam;

    //可用ram
    private int availableRam;

    //cpu总占用
    private int systemCpuLoad;

    //当前程序的cpu占用
    private int processCpuLoad;

    //时间戳
    private long timestamp;

    public int getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(int totalRam) {
        this.totalRam = totalRam;
    }

    public int getAvailableRam() {
        return availableRam;
    }

    public void setAvailableRam(int availableRam) {
        this.availableRam = availableRam;
    }

    public int getSystemCpuLoad() {
        return systemCpuLoad;
    }

    public void setSystemCpuLoad(int systemCpuLoad) {
        this.systemCpuLoad = systemCpuLoad;
    }

    public int getProcessCpuLoad() {
        return processCpuLoad;
    }

    public void setProcessCpuLoad(int processCpuLoad) {
        this.processCpuLoad = processCpuLoad;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
