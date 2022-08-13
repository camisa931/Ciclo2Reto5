package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.model.dao.AsesorPorCiudadDao;
import co.edu.utp.misiontic2022.c2.model.dao.CompraPorProveedorDao;
import co.edu.utp.misiontic2022.c2.model.dao.ProyectoCasaCampestreDao;
import co.edu.utp.misiontic2022.c2.model.vo.AsesorPorCiudadVo;
import co.edu.utp.misiontic2022.c2.model.vo.CompraPorProveedorVo;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoCasaCampestre;

public class RequerimientoController {
    private final AsesorPorCiudadDao asesorPorCiudadDao;// primera consulta
    private final ProyectoCasaCampestreDao proyectoCasaCampestreDao; //segunda consulta
    private final CompraPorProveedorDao compraPorProveedorDao;

    public RequerimientoController(){
        asesorPorCiudadDao = new AsesorPorCiudadDao(); //primera consulta
        proyectoCasaCampestreDao = new ProyectoCasaCampestreDao(); // segunda consulta
        compraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<AsesorPorCiudadVo> consultPorCiudad() throws SQLException{
        return asesorPorCiudadDao.listar();
    }

    public ArrayList<ProyectoCasaCampestre> consulProyectoCasaCampestre() throws SQLException{
        return proyectoCasaCampestreDao.listar();
    }

    public ArrayList<CompraPorProveedorVo> compraPorProveedor() throws SQLException{
        return compraPorProveedorDao.listar();
    }
}
