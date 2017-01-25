package org.agoncal.sample.microservice.consul;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;

@Auditable
@Interceptor
public class AuditInterceptor implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    // @Inject
    // private Logger logger;
    public static final Logger LOG = Logger.getLogger(AuditInterceptor.class.getName());


    // ======================================
    // =          Business methods          =
    // ======================================

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            LOG.info("Executing " + ic.getMethod().getDeclaringClass().getSimpleName() + "::" + ic.getMethod().getName() + " took " + (System.currentTimeMillis() - begin) + "ms");
        }
    }
}
