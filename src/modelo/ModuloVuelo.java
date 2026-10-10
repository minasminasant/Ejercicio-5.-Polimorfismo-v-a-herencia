package modelo;

public class ModuloVuelo extends Modulo{
    private TipoInstrumento tipoInstrumento;
    private int datosPorCiclo;
    private int consumoEnergia;
    private int ciclosAcumulados;
    private int totalRecolectado;

    public ModuloVuelo(int id, String nombre, int salud, boolean activo, double costoConstruccion, TipoInstrumento tipoInstrumento, int datosPorCiclo, int consumoEnergia, int ciclosAcumulados){
        super(id, nombre, salud, activo, costoConstruccion);
        this.tipoInstrumento = tipoInstrumento;
        this.datosPorCiclo = datosPorCiclo;
        this.consumoEnergia = consumoEnergia;
        this.ciclosAcumulados = ciclosAcumulados;
        this.totalRecolectado = ciclosAcumulados * datosPorCiclo;
    }

    public TipoInstrumento getTipoInstrumento(){
        return tipoInstrumento;
    }

    public int getDatosPorCiclo(){
        return datosPorCiclo;
    }

    public int getConsumoEnergia(){
        return consumoEnergia;
    }

    public int getCiclosAcumulados(){
        return ciclosAcumulados;
    }

    public int getTotalRecolectado(){
        return totalRecolectado;
    }

    @Override
    public String procesarCiclo(RecursosMision recursos){
        if(!isActivo()){
            return "Vuelo" + getNombre() + " No re coleta datos porque esta inactvio";
        }
        if(recursos.getEnergiaDisponible() < consumoEnergia){
            return "vuelo" + getNombre() + "no recolecata datos por energis baja" + consumoEnergia + "hay : " + recursos.getEnergiaDisponible(); 
        }
        recursos.consumirEnergia(consumoEnergia);
        recursos.agregarEnergia(datosPorCiclo);
        ciclosAcumulados++;
        totalRecolectado += datosPorCiclo;
        return " vuelo" + getNombre() + "consume" + consumoEnergia + "unidades" + datosPorCiclo;
    }

    @Override
    public String toString(){
        return "modulo de vuelo:" + super.toString() + "|Instrumento:" + tipoInstrumento + "|datos por ciclo:" + datosPorCiclo + "|consumo:" + consumoEnergia + "|ciclos acumualados:" + ciclosAcumulados + "|total recolectado:" + totalRecolectado;
    }
}
