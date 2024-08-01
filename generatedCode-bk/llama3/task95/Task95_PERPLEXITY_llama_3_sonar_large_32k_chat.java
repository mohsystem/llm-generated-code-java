package llama3.task95;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Task95_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        long uptime = bean.getUptime();
        System.out.println("Current processor time in seconds: " + uptime / 1000);
    }
}