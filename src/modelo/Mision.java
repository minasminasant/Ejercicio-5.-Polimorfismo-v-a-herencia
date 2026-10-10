package modelo;
import java.util.ArrayList;
import java.util.Collections;

public class Mision{
    private ArrayList<Modulo> modulos;
    private RecursosMision recursos;
    private int cicloActual;


    public Mision(){
        modulos = new ArrayList<Modulo>();
        recursos = new RecursosMision(25, 40, 120);
        cicloActual = 0;
        cargaInicial();
    }

    public void cargaInicial(){
        modulos.add(new ModuloEnergia(1, "Panel solar alfa", 95, true, 15000, 20, 12));
        modulos.add(new ModuloEnergia(2, "Panel solar beta", 80, true, 12000, 15, 10));
        modulos.add(new ModuloEnergia(3, "Panel solar delta", 40, false, 9000, 10, 4));

        modulos.add(new ModuloVuelo(4, "Camara", 90, true, 30000,TipoInstrumento.CAMARA, 15, 8, 9));
        modulos.add(new ModuloVuelo(5, "Sensor solar", 85, true, 22000,TipoInstrumento.SENSOR, 12, 6, 8));
        modulos.add(new ModuloVuelo(6, "Sensor radiacion", 60, false, 25000,TipoInstrumento.SENSOR, 10, 7, 3));
        modulos.add(new ModuloVuelo(7, "Camara infrarroja", 70, true, 45000,TipoInstrumento.CAMARA, 20, 30, 5));

        modulos.add(new ModuloTierra(8, "Antena principal", 100, true, 50000,"Campus principal", 25, 5, 60));
        modulos.add(new ModuloTierra(9, "Antena de respaldo", 75, true, 35000,"Campus respaldo", 15, 4, 60));
        modulos.add(new ModuloTierra(10, "Antena movil", 50, false, 18000,"Estacion", 10, 3, 20));
        modulos.add(new ModuloTierra(11, "Antena norte", 88, true, 40000,"Estacion Peten", 20, 6, 30));
        modulos.add(new ModuloTierra(12, "Antena costa", 65, true, 28000,"Estacion Pacifico", 12, 3, 10));

    }

    public ArrayList<Modulo> getModulos(){
        return modulos;
    }

    public RecursosMision getRecursos(){
        return recursos;
    }

    public int getCicloActual(){
        return cicloActual;
    }

    public Modulo buscarPorId(int id){
        for(Modulo m : modulos){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public ArrayList<Modulo> buscarPorNombre(String texto){
        ArrayList<Modulo> encontrados = new ArrayList<Modulo>();
        for(Modulo m : modulos){
            if(m.getNombre().toLowerCase().contains(texto.toLowerCase())){
                encontrados.add(m);
            }
        }
        return encontrados;
    }

    public ArrayList<Modulo> getCatalogoPorCosto(){
        ArrayList<Modulo> copia = new ArrayList<Modulo>(modulos);
        Collections.sort(copia);
        return copia;
    }

    public ArrayList<String> avanzarCiclo(){
        ArrayList<String> resultados = new ArrayList<String>();
        cicloActual++;
        for(Modulo m : modulos){
            resultados.add(m.procesarCiclo(recursos));
        }
        return resultados;
    }

    public ArrayList<ModuloTierra> getModulosTierra(){
        ArrayList<ModuloTierra> lista = new ArrayList<ModuloTierra>();
        for(Modulo m : modulos){
            if(m instanceof ModuloTierra){
                lista.add((ModuloTierra) m);
            }
        }
        return lista;
    }

    public int contarModulosTierra(){
        int contador = 0;
        for(ModuloTierra t : getModulosTierra()){
            if(t.isActivo()){
                contador++;
            }
        }
        return contador;
    }

    public int getCapacidadTotalTierra(){
        int total = 0;
        for(ModuloTierra t : getModulosTierra()){
            if(t.isActivo()){
                total += t.getCapacidadDescarga();
            }
        }
        return total;
    }

    public int getTotalDescargado(){
        int total = 0;
        for(ModuloTierra t : getModulosTierra()){
            total += t.getTotalDescargado();
        }
        return total;
    }

    public ArrayList<ModuloTierra> getTierraMayorDescarga(){
        ArrayList<ModuloTierra> mejores = new ArrayList<ModuloTierra>();
        int maximo = -1;
        for(ModuloTierra t : getModulosTierra()){
            if(t.getTotalDescargado() > maximo){
                maximo = t.getTotalDescargado();
                mejores.clear();
                mejores.add(t);
            }
            else if(t.getTotalDescargado() == maximo){
                mejores.add(t);
            }
        }
        return mejores;
    }
}
