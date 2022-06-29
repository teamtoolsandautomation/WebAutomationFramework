package com.ttaa.framework.controls.elements;

import com.ttaa.framework.controls.api.ImplementedBy;
import com.ttaa.framework.controls.internals.Control;

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void PerformClick();
    String GetButtonText();
    void PerformSubmit();
}
