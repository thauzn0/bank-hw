/**
 * The Bond class extends the Asset class and includes methods for buying and selling bonds.
 * @param nameOfBond - the name of the bond
 * @param principal - the principal of the bond
 * @param interestRate - the interest rate of the bond
 * @param numberOfBondsOwned - the number of bonds owned by the user
 * @param currentPrice - the current price of the bond
 * @param capitalGains - the capital gains of the bond
 * @param numberOwned - the number of bonds owned by the user 
 * 
 */

/**
 *  This is a Bond class that contains of bonds
 *  
 */
public class Bond extends Asset {
  private String nameOfBond;
  private double interestRate;
  private int numberOfBondsOwned;
  private double principal;
  
  public Bond(String nameOfBond, double principal, double interestRate) {
    super(nameOfBond, principal);
    this.numberOfBondsOwned = 0;
    this.interestRate = interestRate;
    setCurrentPrice(principal);
    this.nameOfBond = nameOfBond;
  }
  
  /**
  * Returns the principal associated with this request. This is used to determine the amount of time that the user has logged
  */
  public double getPrincipal() {
    return principal;
  }
  
  /**
  * Returns the number of bonds owned by this bond group. This is used to determine how many bonds are associated with a bond group
  */
  public int getNumberOfBondsOwned() {
    return numberOfBondsOwned;
  }
  
  /**
  * Set the number of bonds owned by this bond. Note that this is a property of Bond.
  * 
  * @param numberOfBondsOwned - the number of bonds owned by this
  */
  public void setNumberOfBondsOwned(int numberOfBondsOwned) {
    this.numberOfBondsOwned = numberOfBondsOwned;
  }
  
  /**
  * Returns the interest rate of this object. This is used to determine how much time has passed since the last call to this method
  */
  public double getInterestRate() {
    return interestRate;
  }
  
  /**
  * Sets the interest rate. This is used to determine how much the player has flided to the game
  * 
  * @param interestRate - The amount of interest
  */
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  /**
  * Returns the interest payed by this accounting. This is based on the principal's interest rate
  */
  public double payInterest() {
    return interestRate * principal;
  }
  
  /**
  * Buy bond and return current price. Cost basis is added to current price and number of bonds owned
  */
  public double buyBond() {
    setCostBasis(getCostBasis() + getCurrentPrice());
    setNumberOfBondsOwned(getNumberOfBondsOwned() + 1);
    return getCurrentPrice();
  }
  
  /**
  * Removes one bond from the bond list and returns the costBasis and capitalGains of the removed
  */
  public double sellBond() {
    // Returns the number of bonds owned by this bond.
    if (getNumberOfBondsOwned() == 0)
      return 0;
    
    setCostBasis(getCostBasis() - (getCostBasis() / getNumberOfBondsOwned()));
    setCapitalGains((getCurrentPrice() - (getCostBasis() / getNumberOfBondsOwned())) * getNumberOfBondsOwned());
    setNumberOfBondsOwned(getNumberOfBondsOwned() - 1);
    return getCurrentPrice();
  }
}
