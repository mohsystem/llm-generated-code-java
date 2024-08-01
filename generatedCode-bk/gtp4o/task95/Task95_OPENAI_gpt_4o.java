package gtp4o.task95;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Task95_OPENAI_gpt_4o {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long cpuTime = ((com.sun.management.OperatingSystemMXBean) osBean).getProcessCpuTime();
        double cpuTimeInSeconds = cpuTime / 1_000_000_000.0;
        System.out.println("CPU time in seconds (Java): " + cpuTimeInSeconds);
    }
}