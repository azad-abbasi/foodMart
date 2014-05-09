import java.io.IOException;
import java.util.Vector;

/**
 * Created by azada on 5/9/14.
 */
//-------------------------------------------------------------
//  Class Name : MainClass
//  Purpose    : main program class
//-------------------------------------------------------------
public class MainClass {
    public static void main(String[] args) throws IOException {
//        InputHandler.handler(args);
        InputReaderData input = new InputReaderData(args[0]);
        String[] data = input.getItems();
        aprioriProcess process1 = new aprioriProcess();
        Vector<Vector<String>> output = process1.getResultVector();

        Vector<Vector<String>> outputItems = new Vector<Vector<String>>();
        String finalOutput="";

        for (int i = 0 ; i<output.size(); i++){
            outputItems.add(new Vector<String>());
            for (int j=0 ; j<output.get(i).size();j++){
                String temp="";
                for (int k=0 ; k<splitString(output.get(i).get(j)).length; k++) {
                    if(k>0){
                        temp += "-";
                    }
                    temp += data[Integer.valueOf(splitString(output.get(i).get(j))[k])-1];
                }
                outputItems.get(i).add(temp);
            }
        }
        for (int i=0 ; i<outputItems.size() ; i++){
            finalOutput+="Frequent "+(i+1)+"-itemsets:\n";
            finalOutput+=String.valueOf(outputItems.get(i))+"\n";
            System.out.println(outputItems.get(i));
        }
        InputReader.printToFile("out.txt",finalOutput);



        System.exit(0);
    }



    public static String[] splitString(String input){
        return input.split(" ");
    }


}
//        for (int i = 0 ; i<output.size(); i++){
//            outputItems.add(new Vector<String>());
//            for (int j=0 ; j<output.get(i).size()){
//                outputItems.get(i).add()
//            }
//        }