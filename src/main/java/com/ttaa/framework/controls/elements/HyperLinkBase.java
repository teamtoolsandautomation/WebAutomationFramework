package com.ttaa.framework.controls.elements;

import com.ttaa.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class HyperLinkBase extends ControlBase implements HyperLink {
    public HyperLinkBase(WebElement element) {
        super(element);
    }
}
