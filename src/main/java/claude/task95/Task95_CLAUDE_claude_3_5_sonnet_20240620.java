package claude.task95;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Task95_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long cpuTime = threadMXBean.getCurrentThreadCpuTime();
        double seconds = cpuTime / 1_000_000_000.0;
        System.out.printf("Current processor time: %.9f seconds%n", seconds);
    }
}
