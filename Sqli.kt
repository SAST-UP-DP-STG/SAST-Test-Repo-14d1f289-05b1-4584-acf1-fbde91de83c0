package fixture

import java.sql.DriverManager
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// CWE-89 - SQL Injection. Attacker-controlled id is concatenated into the query.
class SqliServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val userId = request.getParameter("id")

        val connection = DriverManager.getConnection(System.getenv("DB_URL"))
        val statement = connection.createStatement()

        val query = "SELECT id, name, email FROM users WHERE id = " + userId
        val result = statement.executeQuery(query)

        while (result.next()) {
            response.writer.println(result.getString("name"))
        }
    }
}
