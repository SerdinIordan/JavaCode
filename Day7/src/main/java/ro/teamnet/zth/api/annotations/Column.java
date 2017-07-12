package ro.teamnet.zth.api.annotations;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
public @interface Column {

    String name() default "";
}
