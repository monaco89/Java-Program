/*
* There is a chocolate store that sells white, dark, milk and sugar free chocolate bars.
* When a shopper places an order for chocolate, store staff specify the price of the chocolate and the number
* of wrappers that must be returned in order to receive free chocolates.
* The price of the chocolate and the number of wrappers required to receive a free chocolate changes
* with every order as the shop is still experimenting with how the promotion should work.
*
*  To run program: use any java IDE to run Main.java
*
*  Variable Dir:
*  costumersList: list of Object Customer
*  filename = name of csv file tha is read in
*  costumerNum: number of costumers
*  lineNumber: number of lines in csv file
*  pieces: number of chocolate pieces a customer can buy
*  free: number of chocolate pieces they can get for free from wrappers
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* initialization of customer list and Object costumer */
        List<Costumer> costumersList = new ArrayList<Costumer>();
        Costumer costumer = null;

        /* Read order file and write to redemptions.csv file */
        readFile(costumersList, costumer);
        createOrders(costumersList, costumer);
        writeToFile(costumersList, costumer);
    }

    public static void readFile (List<Costumer> costumersList, Costumer costumer) {
        // read order from csv file
        int costumerNum = 1;
        String fileName = "./input/orders.csv";
        try {
            BufferedReader br = new BufferedReader( new FileReader(fileName));
            int lineNumber = 0;

            while((fileName = br.readLine()) != null) {
                lineNumber++;
                String[] result = fileName.split(",");

                if(lineNumber > 2) {
                    /* create costumer object & add to costumer list */
                    costumer = new Costumer(costumerNum);
                    costumersList.add(costumer);

                    /* set cash */
                    // convert string into integer
                    int cash = Integer.parseInt(result[0]);
                    costumer.setCash(cash);

                    /* set cost */
                    // remove whitespaces
                    String costString = result[1].replaceAll("\\s+","");
                    // convert string into integer
                    int cost = Integer.parseInt(costString);
                    costumer.setCost(cost);

                    /* set wrappers needed */
                    // remove whitespaces
                    String wrapperString = result[2].replaceAll("\\s+","");
                    // convert string into integer
                    int wrappers = Integer.parseInt(wrapperString);
                    costumer.setWrappers(wrappers);

                    /* set type of chocolate */
                    String type = result[3];
                    // remove quotes
                    type = type.replaceAll("\'","");
                    // remove whitespaces
                    type = type.replaceAll("\\s+","");
                    costumer.setType(type);


                    costumerNum++;

                    //System.out.println("line number: " + lineNumber + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createOrders(List<Costumer> costumersList, Costumer costumer) {
        int i = 0;

        /* Loop through each costumer in list */
        while (i < costumersList.size()) {

            /* initialize chocolate variables */
            int milk = 0, dark = 0, white = 0, sugarFree = 0;
            /* get costumer */
            costumer = costumersList.get(i);

            /* check how many pieces the customer can buy */
            int pieces = costumer.getCash() / costumer.getCost();
            switch (costumer.getType()) {
                case "milk":
                    milk = +pieces;
                    break;
                case "dark":
                    dark = +pieces;
                    break;
                case "white":
                    white = +pieces;
                    break;
                case "sugarfree":
                    sugarFree = +pieces;
                    break;
                default:
                    break;
            }

            /* check how many free pieces */
            int free = pieces / costumer.getWrappers();
            if (free > 0) {
                switch (costumer.getType()) {
                    case "milk":
                        milk += free;
                        sugarFree += free;
                        break;
                    case "dark":
                        dark += free;
                        break;
                    case "white":
                        white += free;
                        sugarFree += free;
                        break;
                    case "sugarfree":
                        sugarFree += free;
                        dark += free;
                        break;
                    default:
                        break;
                }
            }

            /* write data to costumer object */
            costumer.setMilk(milk);
            costumer.setDark(dark);
            costumer.setWhite(white);
            costumer.setSugarFree(sugarFree);

            i++;
        }
    }

    public static void writeToFile(List<Costumer> costumersList, Costumer costumer) {
        int i = 0;

        /* Loop through each costumer in list */
        while (i < costumersList.size()) {

            /* get costumer */
            costumer = costumersList.get(i);

            /* initialize chocolate variables */
            int milk = costumer.getMilk(), dark = costumer.getDark(), white = costumer.getWhite(), sugarFree = costumer.getSugarFree();

            //System.out.println("milk: " + milk + " dark: " + dark + " white: " + white + " sugar free: " + sugarFree + "\n");

            /* write output file "output/redemptions.csv" (milk N, dark N, white N, sugar free N) */
            String outFile = "./output/redemptions.csv";
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outFile), true));
                pw.append("milk " + milk + ", dark " + dark + ", white " + white + ", sugar free " + sugarFree + "\n");
                pw.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            i++;
        }
    }
}
