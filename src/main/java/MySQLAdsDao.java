import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class MySQLAdsDao implements Ads {

    private Connection connection;


    public MySQLAdsDao(Config configuration ) throws Exception{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        this.connection=DriverManager.getConnection(configuration.getUrl(),
                configuration.getUser(),configuration.getPassword());
    }

    @Override
    public List<Ad> all() {
        List<Ad> adsList = new ArrayList<>();

        long id;
        long idUser;
        String title;
        String description;
        String selectQuery="SELECT * FROM ads";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while(rs.next()) {
                id = rs.getInt("id");
                idUser=rs.getInt("user_id");
                title = rs.getString("title");
                System.out.println(title);
                description = rs.getString("description");
                Ad ad = new Ad(id,idUser,title, description);
                adsList.add(ad);
            }
        }catch (SQLException a){
            System.out.println(a);

        }
        return adsList;
        }


    @Override
    public Long insert(Ad ad)
    {
        long id=ad.getUserId();
        String title=ad.getTitle();
        String description=ad.getDescription();
        String insertQuery="INSERT INTO ads(user_id,title, description) VALUES ("+id+','+title+','+description+")";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery(insertQuery);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
