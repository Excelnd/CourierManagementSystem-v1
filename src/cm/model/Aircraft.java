package cm.model;

public class Aircraft extends AirVehic
{
    public static final int WEAR_AND_TEAR_FLAGFALL = 29800;
    private final double WEAR_AND_TEAR_RATE = 5;

    public Aircraft(String regNo, String make, String model, int year,
                    double avgSpeed, int SFlightCountInterval,
                    double SFlightHoursInterval)
    {
        super(regNo, make, model, year, avgSpeed, SFlightCountInterval,
                SFlightHoursInterval);
    }

    @Override
    public double calculateWearAndTear(double distance)
    {
        return WEAR_AND_TEAR_FLAGFALL + (WEAR_AND_TEAR_RATE * distance);
    }

}