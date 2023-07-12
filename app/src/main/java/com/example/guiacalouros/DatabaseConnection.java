package com.example.guiacalouros;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String TAG = "DatabaseConnection";
    private static final String DB_URL = "jdbc:mysql://aws.connect.psdb.cloud/midivide?sslMode=VERIFY_IDENTITY";
    private static final String USERNAME = "j26yw3dl8bl933lcd9lr";
    private static final String PASSWORD = "pscale_pw_CoXM8dPxXzrfF2IL1QlbpMEf1JTnfkgk6IwrJrPEyym";

    public void connect() {
        Connection connection = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Error loading JDBC driver", e);
        } catch (SQLException e) {
            Log.e(TAG, "Error connecting to the database", e);
        }

    }
}