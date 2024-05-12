package in.lld.parking.sys;

public class ParkingSearchFactory 
{
    public static ParkingSearch getSearch(ParkingSearchType type)
    {
        return new ParkingSearch();
    }
}
