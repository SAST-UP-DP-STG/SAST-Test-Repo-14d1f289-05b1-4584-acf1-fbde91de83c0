package fixture

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// CWE-327 / CWE-328 - Weak cryptography and weak hashing of sensitive data.
class WeakCryptoServlet : HttpServlet() {

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val secret = request.getParameter("secret")

        val hashed = MessageDigest.getInstance("MD5").digest(secret.toByteArray())
        val legacy = MessageDigest.getInstance("SHA-1").digest(secret.toByteArray())

        val key = SecretKeySpec("weakkey!".toByteArray(), "DES")
        val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encrypted = cipher.doFinal(secret.toByteArray())

        response.writer.println(hashed.size + legacy.size + encrypted.size)
    }
}
