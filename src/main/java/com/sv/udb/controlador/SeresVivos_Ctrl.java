/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.recursos.Conexion;
import java.sql.*;
import com.sv.udb.modelo.SeresVivos;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class SeresVivos_Ctrl {

    private final Connection conn;

    public SeresVivos_Ctrl() {
        this.conn = new Conexion().getCon();
    }

    public boolean guardarSerVivo(String nombre, String descripcion, SeresVivos codigoReferencia) {
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO `seresvivos` VALUES (null,?, ?, ?)");
            cmd.setString(1, nombre);
            cmd.setString(2, descripcion);
            cmd.setInt(3, codigoReferencia.getCodigo());
            cmd.executeUpdate();
            resp = true;
        } catch (SQLException e) {
            System.err.println("Error al guardar el ser vivo " + e.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return resp;
    }
    public boolean updateSerVivo(String nombre, String descripcion, SeresVivos codigoReferencia,int codigoModi) {
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE `seresvivos` SET  `nomb_sere` = ?, `desc_sere` = ?, `codi_refe_sere` = ? WHERE `seresvivos`.`codi_sere` = ?  ");
            cmd.setString(1, nombre);
            cmd.setString(2, descripcion);
            cmd.setInt(3, codigoReferencia.getCodigo());
            cmd.setInt(4, codigoModi);
            cmd.executeUpdate();
            resp = true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el ser vivo " + e.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion " + e.getMessage());
            }
        }
        return resp;
    }

    public List<SeresVivos> consTodo() {
        List<SeresVivos> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT  s.codi_sere,s.nomb_sere,s.desc_sere,s.codi_refe_sere,v.*  FROM `seresvivos`s ,seresvivos v where s.codi_refe_sere=v.codi_sere ");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new SeresVivos(rs.getInt(1), rs.getString(2), rs.getString(3), new SeresVivos(rs.getInt(5), rs.getString(6), rs.getString(7), null)));
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar el ser vivo: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }

    public boolean del(int codigo) {
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("delete  from seresvivos WHERE codi_sere=?");
            cmd.setInt(1, codigo);
            cmd.executeUpdate();
            resp = true;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar  ser vivo: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
}
