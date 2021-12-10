import java.sql.*;

public class JdbcDemo {

    public static String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    public static String USER = "root";

    public static String PASS = "root2021";

    public static void main(String[] args) throws SQLException {
        Connection conn = connect();
        delete();
        insert(conn);
        update();
        read();
    }

    public static void read() {
        String sql = "select * from person;";
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("ID");
                String name = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");

                // do something with the extracted data...
                System.out.println("----------------");
                System.out.println(id + " " + name + " " + lastName);
            }
        } catch (SQLException e) {
            // handle the exception
        }
    }

    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }


    public static void insert(Connection conn) {
        String sql = "INSERT INTO person VALUES (?, ?, ?)";
        try (
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            // 使用事务
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Inserting records into the table...");
            ps.setInt(1, 100);
            ps.setString(2, "Zara");
            ps.setString(3, "Ali");
            ps.addBatch();

            ps.setInt(1, 101);
            ps.setString(2, "Mahnaz");
            ps.setString(3, "Fatma");
            ps.addBatch();

            ps.setInt(1, 102);
            ps.setString(2, "Zaid1");
            ps.setString(3, "Khan1");
            ps.addBatch();

            ps.executeBatch();
            conn.commit();
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {

            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        }
    }

    public static void update() {
        String sql = "UPDATE person set FIRST_NAME = ? WHERE id=100;";

        // 这里使用Hikari以连接池方式获取建数据库连接
        try (Connection conn = DataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, "test");
            ps.addBatch();

            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        // 这里使用Hikari以连接池方式获取建数据库连接
        try (Connection conn = DataSource.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Deleting records in the table...");
            String sql = "DELETE FROM person WHERE 1;";
            stmt.executeUpdate(sql);
            System.out.println("Deleted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
