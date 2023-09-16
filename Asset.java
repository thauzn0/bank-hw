/**
 * The Asset class contains information about assets such as their name, description, cost basis,
 * current price, and capital gains.
 * @param assetName - the name of the
 * @param assetDescription - the description of the asset to be used
 * @param costBasis - the cost basis to
 * @param currentPrice - the current price of the asset
 * @param capitalGains - the capital gains of the asset
 * @param numberOwned - the number of shares owned by the user
 * 
 */
/**
* This is a Asset class that contains of assets
* @Author: Taha uzun
*/
public class Asset {
    protected String assetName;
    protected String assetDescription;
    protected double costBasis;
    protected double currentPrice;
    protected double capitalGains;
    //private int numberOwned;
    
    public Asset(String assetName, double costBasis) {
        this.assetName = assetName;
        this.costBasis = costBasis;
        this.capitalGains = 0.0;

    }


    /**
    * Returns the name of the asset. This is used to distinguish assets from other assets that are in the same package.
    * 
    * 
    * @return the name of the asset or null if there is
    */

    public String getName(){
      return assetName;
      
    }
    

    /**
    * Sets the name of the asset. This can be used to retrieve the asset by name from the file system
    * 
    * @param assetName - the name of the
    */

    public void setName(String assetName){
      this.assetName = assetName;
      
    }
    

    /**
    * Returns the description of the asset. This is used to determine the type of asset that is being used for the purposes of rendering a web page.
    * 
    * 
    * @return the description of the asset or null if there is
    */
    public String getDescription(){
      return assetDescription;
    }
    
    /**
    * Sets the description of the asset. This can be used to provide a human - readable description of the asset such as the type of asset etc.
    * 
    * @param assetDescription - the description of the asset to be used
    */
    public void setDescription(String assetDescription){
      this.assetDescription = assetDescription;
    }
    
    /**
    * Returns the cost basis of this node. Note that this is a non - linear
    */
    public double getCostBasis(){
      return costBasis;
    }
    
    /**
    * Sets the cost basis. Note that this is a property and should not be changed in future releases
    * 
    * @param costBasis - the cost basis to
    */
    public void setCostBasis(double costBasis){
      this.costBasis = costBasis;
    }
    /**
    * Returns the current price of the shopping cart. This is used to determine the price of the current item
    */
    public double getCurrentPrice(){
      return currentPrice;
    }
    /**
    * Sets the current price of the shop. Note that you can't change the price of the shop after this is called
    * 
    * @param currentPrice - the current price of the
    */
    public void setCurrentPrice(double currentPrice){
      this.currentPrice = currentPrice;
    }
    /**
    * Returns the capital gains of the melody. This is equal to the number of gains that the melody is capital
    */
    public double getCapitalGains(){
      return capitalGains;
    }
    /**
    * Sets the capital gains of the line. This is used to determine how much a line is capitaled by the algorithm
    * 
    * @param capitalGains - the amount of capital
    */
    public void setCapitalGains(double capitalGains){
      this.capitalGains = capitalGains;
    }

}