import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.io.LineNumberReader;
import java.io.LineNumberReader;

public class JavaBasicScanner {

    //scanner initialization
    private Scanner bscan;

    //file closing method
    public void fileClose()
    {
        bscan.close();;
    }

    //file reading section
    public void openFile(String basicFile){
        try
        {
            //initializes
            bscan = new Scanner(new File(basicFile));
            LineNumberReader numlines = new LineNumberReader(new FileReader(basicFile));
            numlines.skip(Long.MAX_VALUE);
            numlines.close();
        }
        catch(Exception e){
            System.out.println("File error" + e.getMessage());
        }
    }



    public ArrayList<String> readFile(String basicFile){
        openFile(basicFile);
        ArrayList<String> basicFileContents = new ArrayList<>();
        while(bscan.hasNext())
            basicFileContents.add(bscan.nextLine());
        fileClose();
        return basicFileContents;
    }

    public String hashMap(char c) {
        String basicToken;
        HashMap<Character, String> convert;
        convert = new HashMap<>();

        /* ADD LETTERS, SYMBOLS, INTEGERS, OPERATORS FOR BASIC. */

        basicToken = convert.get(c);
        return basicToken;
    }

    public ArrayList<String> scannerBasic(String fileName) {
        ArrayList<String> basicFileContents = readFile(fileName);
        ArrayList<String> basicScannedContent = new ArrayList<>();
        Stack<String> fileItems = new Stack<>();
        char[] stackTop;
        String hash;
        try {
            for (int i = 0; i < basicFileContents.size(); i++) {
                fileItems.push(basicFileContents.get(i));
                stackTop = new char[fileItems.peek().toCharArray().length];
                stackTop = fileItems.peek().toCharArray();

                for (int j = 0; j < stackTop.length; j++) {
                    if (j == 0)
                        basicScannedContent.add("\n");
                    hash = hashMap(stackTop[j]);

                    if (hash.equals("PLUS")) {
                        basicScannedContent.add(hash + "\n");
                    }
                    if (hash.equals("MINUS")) {
                        basicScannedContent.add(hash + "\n");
                    }
                    if (hash.equals("MULTIPLY")) {
                        basicScannedContent.add(hash + "\n");
                    }
                    if (hash.equals("DIVIDE")) {
                        basicScannedContent.add(hash + "\n");
                    } else if (hash.equals("NULL")) {

                    } else
                        basicScannedContent.add(hash + " " + stackTop[j] + "\n");
                }
            }
            while (!fileItems.empty())
                fileItems.pop();
            return basicScannedContent;
        } catch (Exception e) {
            System.out.println("File Error: " + e.getMessage());

            return basicScannedContent;
        }
    }
}


