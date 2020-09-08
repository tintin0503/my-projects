package quan.bui.util;

import java.io.*;

public class ReadAndWriteFile {
    private final static String INPUT_FILE = "C:\\Users\\admin\\Desktop\\Main.log.2020-09-02";
    private final static String OUT_FILE = "C:\\Users\\admin\\Desktop\\Main_filter_2020-09-02.log";

    private static final String TEXT_FILTER = "label=";
    private static final String LINE_BREAK = "\n";

    public static void main(String[] args) {
        filterFileLogWithSpecialText(INPUT_FILE, OUT_FILE);

    }


    private static void filterFileLogWithSpecialText(String inputPath, String outputPath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            String textInALine;

            fw = new FileWriter(outputPath, true);
            bw = new BufferedWriter(fw);

            while ((textInALine = br.readLine()) != null) {
                System.out.println(textInALine);
                textInALine = br.readLine();

                if ( textInALine != null && textInALine.contains(TEXT_FILTER)) {
                    bw.write(textInALine + LINE_BREAK);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
