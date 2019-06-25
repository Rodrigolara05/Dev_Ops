package com.codigo.core.util;

import java.util.ResourceBundle;


public final class UtilCore {

    private UtilCore(){
    }
    
    /**
     * Metodo utilizado para obtener un texto del archivo propiedades.properties
     * @param clave La clave del valor que deseamos obtener
     * @return Un String con el valor de la clave que se encuentra en el archivo propiedades.properties
     */
    public static String obtenerPropiedad(String clave){
        ResourceBundle rb = ResourceBundle.getBundle("propiedades");
        return rb.getString(clave);
    }
}
