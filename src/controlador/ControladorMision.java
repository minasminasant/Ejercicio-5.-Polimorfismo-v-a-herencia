package controlador;
import java.util.ArrayList;
import modelo.Mision;
import modelo.Modulo;
import modelo.ModuloTierra;
import vista.VistaConsola;

public class ControladorMision{
    private Mision mision;
    private VistaConsola vista;

    public ControladorMision(Mision mision, VistaConsola vista){
        this.mision = mision;
        this.vista = vista;
    }

    public void iniciar(){
        int opcion = -1;
        while(opcion != 6){
            vista.menu();
            opcion = vista.leerEntero("Elije una opcion:");
            switch(opcion){
                case 1:
                    vista.mostrarModulos("Todos los modulos", mision.getModulos());
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    vista.mostrarModulos("Catalogo ordenado por costo", mision.getCatalogoPorCosto());
                    break;
                case 4:
                    ArrayList<String> resultados = mision.avanzarCiclo();
                    vista.mostrarResultadoCiclo(mision.getCicloActual(), resultados, mision.getRecursos());
                    break;
                case 5:
                    resumen();
                    break;
                case 6:
                    vista.mostrarMensaje("Fin de la simulacion");
                    break;
                default:
                    vista.mostrarMensaje("opcion no es valida");
            }
        }
    }

    private void buscar(){
        int tipo = vista.leerEntero("buscar por |1. ID | 2. Nombre:");
        if(tipo == 1){
            int id = vista.leerEntero("Ingresa el ID");
            Modulo m = mision.buscarPorId(id);
            if(m == null){
                vista.mostrarMensaje("no existe");
            }
            else{
                vista.mostrarModulo(m);
            }
        }
        else if(tipo == 2){
            String nombre = vista.leerTexto("Ingresar el nombre:");
            vista.mostrarModulos("resultado de busqueda", mision.buscarPorNombre(nombre));
        }
        else{
            vista.mostrarMensaje("opcion de busqueda no es valida");
        }
    }

    private void resumen(){
        ArrayList<ModuloTierra> tierra = mision.getModulosTierra();
        vista.mostrarResumen(tierra.size(), mision.contarModulosTierra(), mision.getCapacidadTotalTierra(), mision.getTotalDescargado(), mision.getTierraMayorDescarga());
    }
}