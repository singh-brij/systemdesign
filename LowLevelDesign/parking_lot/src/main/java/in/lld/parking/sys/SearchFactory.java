package in.lld.parking.sys;

public class SearchFactory 
{
    public ParkingSearch getStrategy(ParkingSearchType type)
    {
        return new ParkingSearch();
    }
}
