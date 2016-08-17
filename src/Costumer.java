public class Costumer {
    // initialization of variables
    int costumerCash, costumerCost, costumerWrappers, costumerMilk, costumerDark, costumerWhite, costumerSugarFree;
    String costumerType;

    public Costumer(int costumerNum) {
        //System.out.println("Costumer number: " + costumerNum);
    }

    public void setCash(int cash) {
        costumerCash = cash;
    }

    public void setCost(int cost) {
        costumerCost = cost;
    }

    public void setWrappers(int wrappers) {
        costumerWrappers = wrappers;
    }

    public void setType(String type) {
        costumerType = type;
    }

    public void setMilk(int milk) {
        costumerMilk = milk;
    }

    public void setDark(int dark) {
        costumerDark = dark;
    }

    public void setWhite(int white) {
        costumerWhite = white;
    }

    public void setSugarFree(int sugarFree) {
        costumerSugarFree = sugarFree;
    }

    public int getCash( ) {
        return costumerCash;
    }

    public int getCost( ) {
        return costumerCost;
    }

    public int getWrappers( ) {
        return costumerWrappers;
    }

    public String getType( ) {
        return costumerType;
    }

    public int getMilk( ) {
        return costumerMilk;
    }

    public int getDark( ) {
        return costumerDark;
    }

    public int getWhite( ) {
        return costumerWhite;
    }

    public int getSugarFree( ) {
        return costumerSugarFree;
    }


}
