package cm.model;

public class Van extends LandVehic
{
    public static final double WEAR_AND_TEAR_RATE = .7;

    public Van(String regNo, String make, String model, int year,
               double serviceInterval)
    {
        super(regNo, make, model, year, serviceInterval);
    }

    @Override
    public double calculateWearAndTear(double distance)
    {
        return WEAR_AND_TEAR_RATE * distance;
    }

    @Override
    public String toString()
    {
        return "Type| van, " + super.toString();
    }


}