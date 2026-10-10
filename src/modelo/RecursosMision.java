package modelo;

public class RecursosMision{
    private int energiaDisponible;
    private int datosEnOrbita;
    private int datosDescargados;

    public RecursosMision(int energiaDisponible, int datosEnOrbita, int datosDescargados){
        this.energiaDisponible = energiaDisponible;
        this.datosEnOrbita = datosEnOrbita;
        this.datosDescargados = datosDescargados;
    }

    public int getEnergiaDisponible(){
        return energiaDisponible;
    }

    public int getDatosEnOrbita(){
        return datosEnOrbita;
    }

    public int getDatosDescargados(){
        return datosDescargados;
    }

    public void agregarEnergia(int cantidad){
        energiaDisponible += cantidad;
    }

    public void consumirEnergia( int cantidad){
        energiaDisponible -= cantidad;
    }

    public void agregarDatosOrbita(int cantidad){
        datosEnOrbita += cantidad;
    }

    public void registrarDescarga(int cantidad){
        datosEnOrbita -= cantidad;
        datosDescargados += cantidad;
    }

    @Override
    public String toString(){
        return "energia disponible:" + energiaDisponible + "unidades |" + "datos en orbita" + datosEnOrbita + "MB | " + " Datos descargados:" + datosDescargados;
    }
}