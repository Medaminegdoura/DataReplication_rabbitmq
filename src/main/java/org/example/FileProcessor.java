package org.example;

import java.io.*;

public class FileProcessor {
    public  static String FILE_PATH  ;
    public FileProcessor(String filePath) {
        FILE_PATH =filePath  ;
    }

    public void writeToFile(String data) throws Exception {
        OutputStream os  = null;
        try {
            String lastLine = readLastLine() ;
            os = new FileOutputStream(new File(FILE_PATH), true);
            if(lastLine==null || lastLine.isEmpty()){
                os.write("0 ".getBytes());

            }else{

                char firstChar = lastLine.charAt(0);
                int number = Character.getNumericValue(firstChar) + 1;
                String result = number + " ";
                os.write(result.getBytes());

            }

            os.write(data.getBytes());
            os.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String readLastLine() {
        String lastLine="" ;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }
}
