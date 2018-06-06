public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
//            adsDao = new ListAdsDao();
            Config confi=new Config();
            try {
                Ads esta = new MySQLAdsDao(confi);
                adsDao=esta;
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return adsDao;
    }
}
