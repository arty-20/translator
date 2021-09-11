package com.fullstack.streamutils.services;

import lombok.Getter;

/**
 * @author arturo
 */
@Getter
public class PalabraConteo implements Comparable<PalabraConteo> {
    private String palabra;
    private Integer cantidad;

    public PalabraConteo(String palabra, Integer cantidad) {
        this.palabra = palabra;
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(PalabraConteo palabraConteo) {
        return palabraConteo.getCantidad().compareTo(cantidad);
    }

    public String toString(){
        return palabra + "  :  " + cantidad;
    }
}
