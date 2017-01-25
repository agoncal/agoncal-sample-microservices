package org.agoncal.sample.microservice.consul;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Auditable {
}
