package com.jmiddleway.log;

/* Author  : Aravinda
* Description :Defining annotation for logger to be autowired
* Company :  
*/

/**
* Indicates InjectLogger of appropriate type to
* be supplied at runtime to the annotated field.
*
* The injected logger is an appropriate implementation
* of org.slf4j.Logger.
*/
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface InjectLogger {
}
