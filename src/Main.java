import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        JavaBasicScanner basicScanner = new JavaBasicScanner();

        ArrayList<String> basicFile = basicScanner.scannerBasic("C:\\Users\\Admin\\Documents\\basicTest.bas");

        for(int i = 0; i < basicFile.size(); i++){
            System.out.print(basicFile.get(i));
        }
    }
}
