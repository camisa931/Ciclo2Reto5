package co.edu.utp.misiontic2022.c2.model.dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.undo.StateEdit;

import co.edu.utp.misiontic2022.c2.model.vo.ProyectoCasaCampestre;
import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

public class ProyectoCasaCampestreDao {
    public ArrayList<ProyectoCasaCampestre> listar() throws SQLException{
        ArrayList<ProyectoCasaCampestre> resultado = new ArrayList<ProyectoCasaCampestre>();
        Connection conn = JDBCUtilities.gConnection();
        try{
            String sql = " SELECT ID_Proyecto, Constructora,Numero_Habitaciones, Ciudad " +
                         " FROM Proyecto " +
                         " WHERE Ciudad IN ('Santa Marta','Cartagena','Barranquilla') " + 
                         " AND Clasificacion = 'Casa Campestre'; ";
           // Statement stmt = conn.createStatement();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               // ProyectoCasaCampestre casa = new ProyectoCasaCampestre(rs.getInt("ID_Proyecto"), rs.getString("Constructora"), rs.getString("Numero_Habitaciones"), rs.getString("Ciudad"));
               ProyectoCasaCampestre casa = new ProyectoCasaCampestre(
                rs.getInt("ID_Proyecto"), 
                rs.getString("Constructora"), 
                rs.getDouble("Numero_Habitaciones"), 
                rs.getString("Ciudad")
            ); 
               resultado.add(casa);
            }
            rs.close();
            stmt.close();
        } finally{
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }
}
