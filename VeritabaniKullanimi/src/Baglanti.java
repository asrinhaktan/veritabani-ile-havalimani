import java.sql.*;

public class Baglanti {
    private String kullAdi = "root";
    private String parola = "";
    private String db_ismi = "Odev2";
    private String host = "localhost";
    private int port = 3306;

    public Statement statement = null;
    public Connection con = null;
    public Baglanti(){
        String url = "jdbc:mysql://"+host+ ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            System.out.println("driver bulunamadı....");
        }

        try {
            con = DriverManager.getConnection(url,kullAdi,parola);
            System.out.println("SQL bağlantisi başarılı");
        }catch (SQLException ex){
            System.out.println("bağlantı başarısız..");
        }
    }
}
