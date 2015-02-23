package com.github.bfsmith.geotimezone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TimezoneFileReader {
  private static final int LineLength = 8;
  private static final int LineEndLength = 1;
  
  private List<String> tzData;

  private List<String> getTzData()
  {
    if(tzData == null) {
      try {
        tzData = new ArrayList<String>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("TZ.dat").getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          tzData.add(line);
        }
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    }
    return tzData;
  }

  public int getCount()
  {
    return getTzData().size();
  }

  public String getLine(int line)
  {
    String tzData = getTzData().get(line);
    return tzData;
  }
}
