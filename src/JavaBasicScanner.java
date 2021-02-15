import java.io.File;
import java.io.FileReader;
import java.util.*;
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

        convert.put('a',"Letter");
        convert.put('A',"Letter");
        convert.put('b',"Letter");
        convert.put('B',"Letter");
        convert.put('c',"Letter");
        convert.put('C',"Letter");
        convert.put('d',"Letter");
        convert.put('D',"Letter");
        convert.put('e',"Letter");
        convert.put('E',"Letter");
        convert.put('f',"Letter");
        convert.put('F',"Letter");
        convert.put('G',"Letter");
        convert.put('g',"Letter");
        convert.put('H',"Letter");
        convert.put('h',"Letter");
        convert.put('i',"Letter");
        convert.put('I',"Letter");
        convert.put('j',"Letter");
        convert.put('J',"Letter");
        convert.put('k',"Letter");
        convert.put('K',"Letter");
        convert.put('l',"Letter");
        convert.put('L',"Letter");
        convert.put('m',"Letter");
        convert.put('M',"Letter");
        convert.put('n',"Letter");
        convert.put('N',"Letter");
        convert.put('o',"Letter");
        convert.put('O',"Letter");
        convert.put('p',"Letter");
        convert.put('P',"Letter");
        convert.put('q',"Letter");
        convert.put('Q',"Letter");
        convert.put('r',"Letter");
        convert.put('R',"Letter");
        convert.put('s',"Letter");
        convert.put('S',"Letter");
        convert.put('t',"Letter");
        convert.put('T',"Letter");
        convert.put('u',"Letter");
        convert.put('U',"Letter");
        convert.put('r',"Letter");
        convert.put('R',"Letter");
        convert.put('s',"Letter");
        convert.put('S',"Letter");
        convert.put('t',"Letter");
        convert.put('T',"Letter");
        convert.put('u',"Letter");
        convert.put('U',"Letter");
        convert.put('v',"Letter");
        convert.put('V',"Letter");
        convert.put('w',"Letter");
        convert.put('W',"Letter");
        convert.put('x',"Letter");
        convert.put('X',"Letter");
        convert.put('y',"Letter");
        convert.put('Y',"Letter");
        convert.put('z',"Letter");
        convert.put('Z',"Letter");


        convert.put('(',"Operator");
        convert.put(')',"Operator");
        convert.put('+',"Operator");
        convert.put('-',"Operator");
        convert.put('*',"Operator");
        convert.put('%',"Operator");
        convert.put('/',"Operator");
        convert.put('=',"Operator");
        convert.put('<',"Operator");
        convert.put('>',"Operator");
        convert.put('^',"Operator");

        convert.put('0',"Integer");
        convert.put('1',"Integer");
        convert.put('2',"Integer");
        convert.put('3',"Integer");
        convert.put('4',"Integer");
        convert.put('5',"Integer");
        convert.put('6',"Integer");
        convert.put('7',"Integer");
        convert.put('8',"Integer");
        convert.put('9',"Integer");

        convert.put('!',"Symbols");
        convert.put('@',"Symbols");
        convert.put('#',"Symbols");
        convert.put('$',"Symbols");
        convert.put(',',"Symbols");
        convert.put('.',"Symbols");
        convert.put(';',"Symbols");
        convert.put(':',"Symbols");
        convert.put('"',"Symbols");
        convert.put('&',"Symbols");
        convert.put('_',"Symbols");
        convert.put('-',"Symbols");
        convert.put('}',"Symbols");
        convert.put('{',"Symbols");
        convert.put(']',"Symbols");
        convert.put('[',"Symbols");
        convert.put('|',"Symbols");
        convert.put('\'',"Symbols");
        convert.put('?',"Symbols");
        convert.put(' ', "NULL");

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
        }
        catch (Exception e) {
            System.out.println("File Error: " + e.getMessage());

            return basicScannedContent;
        }
    }
}


