/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class SeresVivos {

    private int codigo;
    private String nombre;
    private String descripcion;
    private SeresVivos codigoReferencia;

    public SeresVivos() {
    }

    public SeresVivos(int codigo, String nombre, String descripcion, SeresVivos codigoReferencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoReferencia = codigoReferencia;
    }

  

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SeresVivos getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(SeresVivos codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
