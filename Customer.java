/**
 *  This is the Customer class. It is a subclass of Person. It has a first name, a last name, a total cash, a bond, and a mutual fund.
 * @param bond - the bond of the customer
 * @param mutualFund - the mutual fund of the customer
 * @param totalCash - the total cash of the customer
 * @param firstName - the first name of the customer
 * @param lastName - the last name of the customer
 *  
 */

public class Customer{
    
    private Bond bond;
    private MutualFund mutualFund;
    private double totalCash;
    private String firstName;
    private String lastName;


    public Customer(Bond bond, MutualFund mutualFund, String firstName, String lastName, double totalCash){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalCash = totalCash;
        this.bond = bond;
        this.mutualFund = mutualFund;
    }

    /**
    * Returns the first name of the person. This is the person's first name if it has one.
    * 
    * 
    * @return the person's first name or null if there is no first name to be returned by this method
    */
    public String getFirstName(){
        return firstName;
    }

    /**
    * Sets the first name of the person. Note that this will be ignored if the person is a person group
    * 
    * @param firstName - the person's first
    */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
    * Returns the last name of the person. This is used to check if the person is indeed a person and if so return it.
    * 
    * 
    * @return the last name of the person or null if there is no last name ( in which case it is an empty string
    */
    public String getLastName(){
        return lastName;
    }
    
    /**
    * Sets the last name of the person. Note that this will be ignored if the person is a member of the org. bukkit. PersonGroup.
    * 
    * @param lastName - the person's last name to set
    */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
    * Returns the total cash of the shopping cart. This is calculated by summing the cash and the amount
    */
    public double getTotalCash(){
        return totalCash;
    }

    /**
    * Sets the total cash. This is used to calculate the amount of funds that have been charged to the customer
    * 
    * @param totalCash - the amount of cash to
    */
    public void setTotalCash(double totalCash){
        this.totalCash = totalCash;
    }

    /**
    * Returns the bond associated with this entity. Note that this does not include the entity itself but is used to determine the type of entity that is contained in the Bond.
    * 
    * 
    * @return the bond associated with this entity or null if there is no such entity ( for example if this entity is a bond
    */
    public Bond getBond(){
        return bond;
    }

    /**
    * Sets the bond to use for this atom. This is a convenience method for setting the bond to use for this atom.
    * 
    * @param bond - the bond to use for this atom ( null not permitted
    */
    public void setBond(Bond bond){
        this.bond = bond;
    }

    /**
    * Gets the MutualFund associated with this Order. If there is no associated MutualFund null is returned.
    * 
    * 
    * @return the MutualFund associated with this Order or null if there is no associated MutualFund
    */
    public MutualFund getMutualFund(){
        return mutualFund;
    }

    /**
    * Sets the mutual fund. Note that this will be set in the order of the payment and not in the order of the customer
    * 
    * @param mutualFund - the value to set
    */
    public void setMutualFund(MutualFund mutualFund){
        this.mutualFund = mutualFund;
    }

    /**
    * Returns the current value of the molecular fund. It is based on the number of bonds owned and the number of shares
    */
    public double currentValue(){
        return (bond.getCurrentPrice() * bond.getNumberOfBondsOwned()) + (mutualFund.getNumberShares() * mutualFund.getCurrentPrice());

    }

    /**
    * Get the gains of the bond. This is used to determine the fund strength of the bond
    */
    public double getCapitalGains(){
        // Returns the number of capital gains of the bond.
        if(bond.getCapitalGains() > 0 && mutualFund.getCapitalGains() > 0)
            return bond.getCapitalGains() + mutualFund.getCapitalGains();
        // Returns the capital gains of the bond.
        else if(bond.getCapitalGains() > 0 && mutualFund.getCapitalGains() < 0)
            return bond.getCapitalGains();
        // Returns the capital gains of the mutual fund.
        else if(mutualFund.getCapitalGains() > 0 && bond.getCapitalGains() < 0 )
            return mutualFund.getCapitalGains();
        else
            return 0;

    }
    /**
    * Sells the bond and increases cash by the price of the bond. Does not update the bond
    */
    public void sellBond(){
        bond.sellBond();
        totalCash += bond.getCurrentPrice();

    }

    /**
    * Buy bond if it's worth it return false if it's over the price limit return
    */
    public boolean buyBond(){
        // Buy the bond if the current price is greater than the totalCash
        if(bond.getCurrentPrice() > totalCash)
            return false;
        else{
            bond.buyBond();
            totalCash -= bond.getCurrentPrice();
            return true;
        }

    }

    /**
    * Withdraws money from mutual fund. Does not update cash. This is useful for withdrawing money from an investment that is incurred while money is being selled.
    * 
    * @param withdrawAmount - Amount to withdraw from mutual f
    */
    public void withdrawMutualFund(double withdrawAmount){
        mutualFund.sell(withdrawAmount);
        totalCash += mutualFund.getCurrentPrice();

    }

    /**
    * Buy mutual fund if possible. Returns false if cash is over. Does not update balance
    * 
    * @param buyAmount - Amount to buy ( negative is unchallenged
    */
    public boolean buyMutualFund(double buyAmount){
        // Buy the buy amount.
        if(buyAmount > totalCash)
            return false;
        else{
            mutualFund.buy(buyAmount);
            totalCash -= buyAmount;
            return true;
        }

    }





}