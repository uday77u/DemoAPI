package com.api.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {

    public static String saveResponseToFile(String responseBody) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "target/extent-report/responses/response_" + timestamp + ".txt";

        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // create dirs if not exists

            FileWriter writer = new FileWriter(file);
            writer.write(responseBody);
            writer.close();

            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
