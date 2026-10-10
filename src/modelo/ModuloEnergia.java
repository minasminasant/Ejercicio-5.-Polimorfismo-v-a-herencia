package modelo;

public class ModuloEnergia extends Modulo{
    private int energiaPorCiclo;
    private int ciclosAcumulados;
    private int totalGenerado;

    public ModuloEnergia(int id, String nombre, int salud, boolean activo, double costoConstruccion, int energiaPorCiclo, int ciclosAcumulados){
        super(id, nombre, salud, activo, costoConstruccion);
        this.energiaPorCiclo = energiaPorCiclo;
        this.ciclosAcumulados = ciclosAcumulados;
        this.totalGenerado = ciclosAcumulados * energiaPorCiclo;
    }

    public int getEnergiaPorCiclo(){
        return energiaPorCiclo;
    }

    public int getCiclosAcumulados(){
        return ciclosAcumulados;
    }

    public int getTotalGenerado(){
        return totalGenerado;
    }

    @Override
    public String procesarCiclo(RecursosMision recursos){
        if(!isActivo()){
            return "Energia" + getNombre() + ": no produce energia puesto que esta inactico";
        }
        recursos.agregarEnergia(energiaPorCiclo);
        ciclosAcumulados++;
        totalGenerado += energiaPorCiclo;
        return "Energia" + getNombre() + ": genra " + energiaPorCiclo + "Unidades de energia";
    }

    @Override
    public String toString(){
        return "modulo de energis:" + super.toString() + "| energia por ciclo:" + energiaPorCiclo + "| ciclos acumulados:" + ciclosAcumulados + "| total generado:" + totalGenerado;
    }
}