package org.example.chapter05.extra;

import java.sql.*;

public class ExtraWrapper {

    @FunctionalInterface
    interface Transaction {
        void execute(Connection conn) throws Exception;
    }

    // Wrapper
    static void runInTransaction(Transaction transaction) {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
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

    static void transfer(int fromId, int toId, double amount) { // тестовый метод
        runInTransaction(conn -> {
            // SELECT
            double balance;
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT balance FROM accounts WHERE id = ?")) {
                ps.setInt(1, fromId);
                ResultSet rs = ps.executeQuery();
                rs.next();
                balance = rs.getDouble("balance");
            }

            System.out.println("Баланс до перевода: " + balance);

            if (balance < amount) {
                throw new IllegalStateException("Недостаточно средств");
            }

            // INSERT
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO log (from_id, to_id, amount) VALUES (?, ?, ?)")) {
                ps.setInt(1, fromId);
                ps.setInt(2, toId);
                ps.setDouble(3, amount);
                ps.executeUpdate();
            }

            // UPDATE
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?")) {
                ps.setDouble(1, amount);
                ps.setInt(2, fromId);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                ps.setDouble(1, amount);
                ps.setInt(2, toId);
                ps.executeUpdate();
            }
        });
    }

    static void main() throws SQLException {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE accounts (id INT PRIMARY KEY, balance DOUBLE)");
            st.execute("CREATE TABLE log (id IDENTITY, from_id INT, to_id INT, amount DOUBLE)");
            st.execute("INSERT INTO accounts VALUES (1, 1000), (2, 500)");
        }

        transfer(1, 2, 200);
        System.out.println("------");
        transfer(2, 1, 10000);
        System.out.println("------");
        transfer(2, 1, 10000);
        System.out.println("------");
        transfer(2, 1, 200);
        System.out.println("------");
        transfer(2, 1, 10000);
    }
}