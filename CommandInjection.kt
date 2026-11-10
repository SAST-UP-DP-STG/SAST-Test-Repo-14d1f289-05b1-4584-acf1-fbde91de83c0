package fixture

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// CWE-78 - OS Command Injection. User input reaches a shell command.
class CommandInjectionServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val host = request.getParameter("host")

        val command = "ping -c 1 " + host
        Runtime.getRuntime().exec(command)

        val target = request.getParameter("target")
        ProcessBuilder("sh", "-c", "nslookup " + target).start()
    }
}
