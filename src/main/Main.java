package main;

import controlador.ControladorMision;
import modelo.Mision;
import vista.VistaConsola;

public class Main{
    public static void main(String[] args) {
        Mision mision = new Mision();
        VistaConsola vista = new VistaConsola();
        ControladorMision controlador = new ControladorMision(mision, vista);
        controlador.iniciar();
    }
}