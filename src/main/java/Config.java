public class Config {


        private String user="root";
        private String password="codeup";
        private String url="jdbc:mysql://localhost:3306/adlister_db?serverTimezone=UTC";

        public String getUser() {

            return user;
        }

        public String getPassword() {

            return password;
        }

        public String getUrl() {

            return url;
        }
    }

