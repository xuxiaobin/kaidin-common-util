package com.kaidin.common.util.log;

import com.kaidin.common.util.random.RandomUtil;
import org.slf4j.MDC;

/**
 * @author xiaobin
 * @date 2020-10-05 21:23
 */
public abstract class TraceUtil {
    public static final String TRACE_ID = "traceId";

    /**
     * 给请求的线程都加上trace
     */
    public static void genernateTraceId() {
        MDC.put(TRACE_ID, RandomUtil.nextBase64Code());
    }

    /**
     * 给请求的线程都删除trace
     */
    public static void removeTraceId() {
        MDC.remove(TRACE_ID);
    }

    /**
     * 获取调用链路traceId
     * @return
     */
    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }
}
