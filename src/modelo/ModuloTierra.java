package modelo;

public class ModuloTierra extends Modulo{
    private String estacion;
    private int capacidadDescarga;
    private int energiaPorDescarga;
    private int totalDescargado;

    public ModuloTierra(int id, String nombre, int salud, boolean activo, double costoConstruccion, String estacion, int capacidadDescarga, int energiaPorDescarga, int totalDescargado){
        super(id, nombre, salud, activo, costoConstruccion);
        this.estacion = estacion;
        this.capacidadDescarga = capacidadDescarga;
        this.energiaPorDescarga = energiaPorDescarga;
        this.totalDescargado = totalDescargado;
    }

    public String getEstacion(){
        return estacion;
    }

    public int getCapacidadDescarga(){
        return capacidadDescarga;
    }

    public int getEnergiaPorDescarga(){
        return energiaPorDescarga;
    }

    public int getTotalDescargado(){
        return totalDescargado;
    }

    @Override
    public String procesarCiclo(RecursosMision recursos){
        if(!isActivo()){
            return "Tierra" + getNombre() + "no descraga por que es invalido";
        }
        if(recursos.getEnergiaDisponible() < energiaPorDescarga){
            return "tierra" + getNombre() + "no descraga porque energis es baja necesita:" + energiaPorDescarga + "y solo hay :" + recursos.getEnergiaDisponible();
        }
        if(recursos.getDatosEnOrbita() <= 0){
            return "tierra" + getNombre() + " no hay decarga porque no hay datos pendientes";
        }
        int cantidad = Math.min(capacidadDescarga, recursos.getDatosEnOrbita());
        recursos.consumirEnergia(energiaPorDescarga);
        recursos.registrarDescarga(cantidad);
        totalDescargado += cantidad;
        return " tierra" + getNombre() + "Consume " + energiaPorDescarga + "unidades y descarga" + cantidad + "MB";
    }

    @Override
    public String toString(){
        return "Modulo tierra:" + super.toString() + "| estacion:" + estacion + "|capacidad de descarga:" + capacidadDescarga + "| energia por descarga:" + energiaPorDescarga + "| total descargado:" + totalDescargado;
    }
}