package fixture

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// CWE-79 - Cross-Site Scripting. User input is written into the response unencoded.
class XssServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val name = request.getParameter("name")

        response.contentType = "text/html"
        response.writer.write("<div class='greeting'>Hello, " + name + "</div>")
    }
}
