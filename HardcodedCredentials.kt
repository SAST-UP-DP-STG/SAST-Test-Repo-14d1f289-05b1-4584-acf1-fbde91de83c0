package fixture

import java.sql.DriverManager

// CWE-798 - Hard-Coded Credentials. Literal password assigned then used to connect.
object HardcodedCredentials {

    private const val DB_HOST = "jdbc:mysql://db.internal.example/app"
    private const val DB_USER = "app_service"
    private const val DB_PASSWORD = "S3cr3t-Pa55w0rd!"

    private const val API_KEY = "AKIAIOSFODNN7EXAMPLE"

    fun connect() {
        val connection = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)
        connection.close()
    }
}
