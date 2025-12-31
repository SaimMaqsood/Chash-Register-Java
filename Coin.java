public class Coin
{
    /**
     Constructs a coin.
     @param aValue the monetary value of the coin.
     @param aName the name of the coin
    */
    public Coin(double aValue, String aName)
    {
        value = aValue;
        name = aName;
    }

    /**
     Gets the coin value.
     @return the value
    */
    public double getValue()
    {
        return value;
    }

    /**
     Gets the coin name.
     @return the name
    */
    public String getName()
    {
        return name;
    }

    // Added for nicer printing
    @Override
    public String toString()
    {
        return String.format("%s ($%.2f)", name, value);
    }

    private double value;
    private String name;
}
