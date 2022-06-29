package com.ttaa.framework.controls.elements;

import com.ttaa.framework.controls.api.ImplementedBy;
import com.ttaa.framework.controls.internals.Control;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void EnterText(String text);
    String GetTextValue();
}
