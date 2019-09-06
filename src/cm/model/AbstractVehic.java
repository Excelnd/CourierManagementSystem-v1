package cm.model;

import cm.model.interfaces.Vehic;

public abstract class AbstractVehic implements Vehic
{
    private String make;
    private String model;
    private double odomtr = 0.0;
    private String regNo;
    private int year;

    public AbstractVehic(String regNo, String make, String model, int year)
    {
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake()
    {
        return make;
    }

    @Override
    public double getOdomtr()
    {
       return odomtr;
    }

    @Override
    public String getRegNo()
    {
        return regNo;
    }

    @Override
    public int getYear()
    {
        return year;
    }

    @Override
    public String toString()
    {
        return String.format("RegNo: %s, Make: %s, Model: %s, Year: %s",
            regNo, make, model, year);
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof AbstractVehic))
            return false;

        AbstractVehic toCompare = (AbstractVehic) o;
        return regNo.equals(toCompare.getRegNo()) &&
                year == toCompare.getYear() &&
                make.equals(toCompare.getMake());
    }

}
