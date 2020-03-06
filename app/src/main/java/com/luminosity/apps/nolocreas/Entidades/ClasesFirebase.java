package com.luminosity.apps.nolocreas.Entidades;

public class ClasesFirebase {

    String seccion, campo;

    public ClasesFirebase(String seccion, String campo) {

        this.seccion = seccion;
        this.campo = campo;

    }

    public String getSeccion() {
        return seccion;
    }

    public String getCampo() {
        return campo;
    }
}
