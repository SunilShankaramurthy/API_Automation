package apiConfigs;

public class APIPath {
    public static final class apiPath{
        //GET
        public static final String GET_PROMOTION_DATA="/popcorn-api-rs-7.9.10/v1/promotions?apikey=GDMSTGExy0sVDlZMzNDdUyZ";

        //GET : Negative Test : Invalid APIKey
        public static final String INVALID_APIKEY="/popcorn-api-rs-7.9.10/v1/promotions?apikey=INVALID";
    }
}
