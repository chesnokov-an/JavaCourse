package org.example.chapter05.extra;

import java.sql.*;

public class ExtraRollback {

    @FunctionalInterface
    interface Transaction {
        void execute(Connection conn) throws Exception;
    }

    // Wrapper
    static void runInTransaction(Transaction transaction) {
        String url = "jdbc:h2:tcp://localhost//home/sasha/JavaCourse/transaction_demo";
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);
            try {
                transaction.execute(conn);
                conn.commit();
                System.out.println("Транзакция зафиксирована");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Откат: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Ошибка соединения: " + e.getMessage());
        }
    }

    static void test() {
        runInTransaction(conn -> {
            // Первый INSERT
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO log (from_id, to_id, amount) VALUES (?, ?, ?)")) {
                ps.setInt(1, 1);
                ps.setInt(2, 2);
                ps.setDouble(3, 100);
                ps.executeUpdate();
                System.out.println("Первый INSERT выполнен");
            }
            // Второй INSERT
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO log (from_id, to_id, amount) VALUES (?, ?, ?)")) {
                ps.setInt(1, 2);
                ps.setInt(2, 1);
                ps.setDouble(3, 200);
                ps.executeUpdate();
                System.out.println("Второй INSERT выполнен");
            }
            throw new IllegalStateException("Тестовая ошибка");
        });
    }

    static void main() throws SQLException {
        String url = "jdbc:h2:tcp://localhost//home/sasha/JavaCourse/transaction_demo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS log");
            st.execute("CREATE TABLE log (id IDENTITY, from_id INT, to_id INT, amount DOUBLE)");
        }
        test();
    }
}

// SET SESSION CHARACTERISTICS AS TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
// SELECT * FROM log;