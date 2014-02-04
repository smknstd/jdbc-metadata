import java.sql.*;

public class JdbcGetMetadata {

  public static void main(String args[]) {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    final String url = "jdbc:oracle:thin:@serveur:port/sid";
    final String driver = "oracle.jdbc.OracleDriver";
    final String user = "user";
    final String pass = "password";

    try {

      Class.forName(driver);
      con = DriverManager.getConnection(url, user, pass);
      st = con.createStatement();

      String sql = "select RAWTOHEX (UTL_RAW.cast_to_raw (DBMS_OBFUSCATION_TOOLKIT.md5(input_string =>  BUSINESS_UNIT||'|'|| 	PRODUCTION_ID||'|'||OP_SEQUENCE||'|'||to_char(DT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS')||'|'||CE_SEQ_NBR||'|'||COST_ELEMENT||'|'||CE_CODE))) as id from STGPIV.PS_CE_ACTUAL_COST";

      rs = st.executeQuery(sql);
      ResultSetMetaData metaData = rs.getMetaData();

      System.out.print(metaData.getColumnName(1) + " | " + metaData.getColumnTypeName(1) + "(" + metaData.getColumnDisplaySize(1) + ")");
      
    } catch (Exception e) {

      System.out.println(e);

    }
  }
}  
