/**
  * Created by anton.skovorodko on 04/25/2016.
  */
import java.sql.DriverManager
import java.sql.Connection

class SqlConnection() {

  def connectViaJDBC() = {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:sql://localhost/SQLINSTANCE"
    val username = "root"
    val password = "root"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT host, user FROM user")
      while ( resultSet.next() ) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }

  def run() = {
    //connectViaJDBC()
  }
}
