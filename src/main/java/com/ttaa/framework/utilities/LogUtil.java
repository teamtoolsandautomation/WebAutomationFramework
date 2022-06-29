package com.ttaa.framework.utilities;

import com.ttaa.framework.config.Settings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHSS");
    String fileNameFormat = date.format(formatter);

    private BufferedWriter bufferedWriter = null;

    public void CreateLogFile() {
        try{
            File dir = new File(Settings.LogPath);
            if (!dir.exists())
                dir.mkdir();

            File logFile = new File(dir + "/" + fileNameFormat + ".log");

            FileWriter fileWriter = new FileWriter(logFile.getAbsolutePath());
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Write(String message){
        try{
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("[" + dateFormat + "]: " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

