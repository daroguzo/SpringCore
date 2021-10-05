package study.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
