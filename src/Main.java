import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        JavaBasicScanner basicScanner = new JavaBasicScanner();

        JavaBasicParser basicParser = new JavaBasicParser();

        ArrayList<String> basicFile = basicScanner.scannerBasic("C:\\Users\\Admin\\Desktop\\ScannerForConceptsProject\\src\\basicTest.bas");

   // int i=0;
       // String[] hold=new String[500];
       // try {
         //   Scanner scanner = new Scanner(new File("C:\\Users\\kyson\\Downloads\\ScannerForConceptsProject\\src\\basicTest.bas"));
         //   while (scanner.hasNextLine()) {

           //    String x= scanner.nextLine();

           //    hold=x.split(" ");


            //    System.out.println(scanner.nextLine());
   // i++;

       //    }
       //     scanner.close();
      //  } catch (FileNotFoundException e) {

      //  }




        basicParser.syntaxMap(basicFile);
     //   for(int i = 0; i < basicFile.size(); i++){
        //    System.out.print(basicFile.get(i));

       // }

    }
}
