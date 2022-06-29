package com.ttaa.framework.controls.api;

import com.ttaa.framework.controls.internals.ControlBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This annotation interface will be used to tell the compiler which class has implemented an interface.
// eg it will tell TextBox interface that TextBoxBase class has implemented it.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
    Class<?> value() default ControlBase.class;

}
