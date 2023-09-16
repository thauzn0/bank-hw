/**
 * The MutualFund class extends the Equity class and includes methods for buying and selling mutual
 * funds with a load fee.
 * @param name - the name of the mutual fund
 * @param symbol - the symbol of the mutual fund
 * @param currentPrice - the current price of the mutual fund
 * @param load - the load of the mutual fund
 * @param numberShares - the number of shares of the mutual fund
 * 
 */


public class MutualFund extends Equity {
    private double load;
    
    public MutualFund(String name, double currentPrice, char symbol) {
        super(name, symbol, currentPrice);
        this.symbol = symbol;
        this.load = 0.0;
    }
    
    /**
    * Returns the load of the network. This is used to determine how much the network is loaded in terms of the number of neurons
    */
    public double getLoad() {
        return load;
    }

    /**
    * Sets the load of the particle. It is used to determine the position of the particle in the particle list.
    * 
    * @param load - the load of the particle in the particle list
    */
    public void setLoad(double load) {
        this.load = load;
    }

    /**
    * Buy shares. This is called by the buy button. If you don't want to buy a lot of shares you can call this instead
    * 
    * @param amount - Amount of shares to
    */
    public double buy(double amount) {
        // Returns the amount of the amount to be returned.
        if(amount < 0)
          return 0;
          double sharesPurchased = amount * (1 - getLoad() / 100) / getCurrentPrice();
          
          setNumberShares(getNumberShares() + sharesPurchased);
          setCostBasis(getCostBasis() + amount);
          
          return amount;
    }
    
    /**
    * Sells a number of shares. This is the same as buying a share but with a different costBasis and capitalGains
    * 
    * @param amount - the amount of shares to
    */
    public double sell(double amount) {
        // Returns 0 if the amount is less than 0 or greater than the current price.
        if (amount <= 0 ||  amount >  (getCurrentPrice() * getNumberShares())) {
            return 0;
        }
        double sharesSold = amount / getCurrentPrice();
        setNumberShares(getNumberShares() - sharesSold);
        double costBasisBeforeSale = getCostBasis() * (getNumberShares() + sharesSold) / getNumberShares();
        double capitalGains = amount - (costBasisBeforeSale - getCostBasis());
        setCostBasis(costBasisBeforeSale);
        setCapitalGains(getCapitalGains() + capitalGains);

        return amount;
    }
}
