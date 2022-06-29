package com.ttaa.framework.config;

import com.ttaa.framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.FileAttribute;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {
        Properties p = new Properties();
        InputStream inputStream = new FileInputStream("src/main/java/com/ttaa/framework/config/GlobalConfig.properties");
        p.load(inputStream);

        Settings.AUTConnectionString = p.getProperty("AUTConnectionString");
        Settings.LogPath = p.getProperty("LogPath");
        Settings.DriverType = p.getProperty("DriverType");
        Settings.ExcelSheetPath = p.getProperty("ExcelSheetPath");
        Settings.AUT = p.getProperty("AUT");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("AUTConnectionString"));
        Settings.SeleniumGridHub = p.getProperty("SeleniumGridHub");



    }
}
