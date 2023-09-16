/**
 *  This is the Equity class. It is a subclass of Asset. It has a symbol, a current price, and a number of shares.
 * @param symbol - the symbol of the equity
 * @param currentPrice - the current price of the equity
 * @param numberShares - the number of shares of the equity
 * 
 */
 


public class Equity extends Asset{
    protected char symbol;
    private double numberShares;

    public Equity(String nameOfEquity, char symbol, double currentPrice){
        super(nameOfEquity, 0.0);
        this.symbol = symbol;
        setCurrentPrice(currentPrice);
    }

    /**
    * Returns the number of shares this account has. This is an integer between 0 and #getNumberOfShares
    */
    public double getNumberShares(){
        return numberShares;
    }

    /**
    * Sets the number of shares to be associated with this account. Note that this is a property not a property of a user
    * 
    * @param numberShares - the number of shares to be associated with this
    */
    public void setNumberShares(double numberShares){
        this.numberShares = numberShares;
    }

    /**
    * Returns the symbol associated with this token. This method is used by Parser to determine if a token is part of a parse tree
    */
    public char getSymbol(){
        return symbol;
    }


}
