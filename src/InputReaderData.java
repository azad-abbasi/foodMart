import java.io.*;

/**
 * Created by azada on 5/8/14.
 */
//-------------------------------------------------------------
//  class name : IputReaderData
//  Purpose    : generate proper file structure for apriorProcess
//-------------------------------------------------------------
public class InputReaderData {
    String path ;
    String [] items ;
    String [][] itemValues;
    String [][] orderValues;
    int numberOfLines;
    int numberOfRows;

    public InputReaderData(String path){
        this.path = path;
        readItems();

        numberOfLines = 0 ;
        try {
            numberOfLines = countLines(path);
        }
        catch (IOException e){
            System.out.println(e);
        }

        this.numberOfRows = items.length;
        this.itemValues = new String[numberOfRows][numberOfLines-1];
        this.orderValues = new String[numberOfLines-1][numberOfRows];
        readItemValues();
        readOrderValues();
    }

    private void readItems(){
        String csvFile = this.path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();

                // use comma as separator
                this.items = line.split(cvsSplitBy);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private void readItemValues(){
        String csvFile = this.path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        try {
            br = new BufferedReader(new FileReader(csvFile));
            int j = 0 ;
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] thisLine = line.split(cvsSplitBy);
                for (int i = 0 ; i<thisLine.length ; i++){
//
                    this.itemValues[i][j] = thisLine[i];
                }
                j++;

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void readOrderValues(){
        String csvFile = this.path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        try {
            br = new BufferedReader(new FileReader(csvFile));
            int j = 0 ;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] thisLine = line.split(cvsSplitBy);
                for (int i = 0 ; i<thisLine.length ; i++){
//
                    this.orderValues[j][i] = thisLine[i];
                }
                j++;

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int countLines(String path) throws IOException {
        LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(path)));
        lnr.skip(Long.MAX_VALUE);
        int lines = lnr.getLineNumber();
        lnr.close();
        return lines+1;

    }

    public String[][] getItemValues(){
        return this.itemValues;
    }
    public String[] getItems(){
        return this.items;
    }
    public int getNumberOfLines(){
        return numberOfLines;
    }
    public int getNumberOfRows(){
        return numberOfRows;
    }
    public String[][] getOrderValues(){
        return orderValues;
    }
    public String[][] getsOrderValues(){
        return orderValues;
    }


}
