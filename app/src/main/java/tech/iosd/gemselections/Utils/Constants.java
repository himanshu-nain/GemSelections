package tech.iosd.gemselections.Utils;

/**
 * Created by anubhavmalik on 23/03/18.
 */

public class Constants {

    /**
     * < ------------------------------------------------------------PAYTM_CONSTANTS---------------------------------------------------------------- >
     */

    public static final String M_ID = "Khanna50414130495132"; //Paytm Merchant Id we got it in paytm credentials

    //    public static final String M_ID ="Anubha67600253601899";
    public static final String CHANNEL_ID = "WAP"; //Paytm Channel Id, got it in paytm credentials
    public static final String INDUSTRY_TYPE_ID = "Retail"; //Paytm industry type got it in paytm credential

    public static final String WEBSITE = "APP_STAGING";
    //    public static final String CALLBACK_URL = "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=";//
    public static final String CALLBACK_URL = /*"https://pguat.paytm.com/oltp-web/processTransaction";http://aa4961f4.ngrok.io/verify_checksum" ;*/"https://checksumpaytm.herokuapp.com/verify_checksum";
//    public static final String CHECKSUM_HASH = "w2QDRMgp1/BNdEnJEAPCIOmNgQvsi+BhpqijfM9KvFfRiPmGSt3Ddzw+oTaGCLneJwxFFq5mqTMwJXdQE2EzK4px2xruDqKZjHupz9yXev4=";


    /**
     * < ------------------------------------------------------------FRAGMENT_CONSTANTS---------------------------------------------------------------- >
     */
    public static final String PRIMARY_NAME = "PRIMARY_NAME";

    public static final String SECONDARY_NAME = "SECONDARY_NAME";

    public static final String PRIMARY_DATE = "PRIMARY_DATE";

    public static final String SECONDARY_DATE = "SECONDARY_DATE";

    public static final String PRIMARY_DAY = "PRIMARY_DAY";

    public static final String SECONDARY_DAY = "SECONDARY_DAY";

    public static final String PRIMARY_MONTH = "PRIMARY_MONTH";

    public static final String SECONDARY_MONTH = "SECONDARY_MONTH";

    public static final String PRIMARY_YEAR = "PRIMARY_YEAR";

    public static final String SECONDARY_YEAR = "SECONDARY_YEAR";

    public static final String PRIMARY_HOUR = "PRIMARY_HOUR";

    public static final String SECONDARY_HOUR = "SECONDARY_HOUR";

    public static final String PRIMARY_MIN = "PRIMARY_MIN";

    public static final String SECONDARY_MIN = "SECONDARY_MIN";

    public static final float PRIMARY_LAT = (float) 28.7041;

    public static final float SECONDARY_LAT = (float) 28.7041;

    public static final float PRIMARY_LNG = (float) 77.1025;

    public static final float SECONDARY_LNG = (float) 77.1025; //28.7041° N, 77.1025° E

    public static final float TIMEZONE = (float) 5.5;

    public static final String PRIMARY_ZODIAC = "PRIMARY_ZODIAC";

    public static final String SECONDARY_ZODIAC = "SECONDARY_ZODIAC";

    public static final String PRIMARY_RISING_SUN = "PRIMARY_RISING_SUN";

    public static final String SECONDARY_RISING_SUN = "SECONDARY_RISING_SUN";

    /**
     * < ----------------------------------------------------------------BUNDLE_CONSTANTS--------------------------------------------------------------- >
     */

    public static final String FRAGMENT_ID = "FRAGMENT_ID";

    public static final String FRAGMENT_STATUS = "FRAGMENT_STATUS";


}
