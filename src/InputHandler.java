

/**
 * Created by azada on 5/8/14.
 */
public class InputHandler {
    public static void main(String[] args) {
        InputReaderData reader = new InputReaderData(args[0]);
        String itemData[] = reader.getItems();
        String orderData[][] = reader.getOrderValues();
        String OrderData[][] = reader.getOrderValues();

        String finalData = "" ;
        int NumRows = reader.getNumberOfRows();
        int NumLine = reader.getNumberOfLines()-1;
        for (int i = 0 ; i< NumLine ; i++){
            for (int j=0 ; j<NumRows; j++){
                finalData += orderData[i][j];
                if(j != NumRows-1)
                    finalData += " ";
            }
            if(i != NumLine-1)
                finalData+="\n";
        }
        String NumberOfItems = String.valueOf(NumRows);
        String NumberOfTransactions = String.valueOf(NumLine);
        String MinimumSupport = args[1];
        String SizeOfDICstep = args[2];

        String config = NumberOfItems + "\n" + NumberOfTransactions +"\n"+MinimumSupport+"\n"+SizeOfDICstep;


        InputReader.printToFile("transa2.txt",finalData);
        InputReader.printToFile("config.txt",config);



    }

}
