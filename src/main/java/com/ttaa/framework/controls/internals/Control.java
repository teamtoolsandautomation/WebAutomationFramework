package com.ttaa.framework.controls.internals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;

public interface Control extends WebElement, WrapsElement, Locatable {
}
