package modelo;

public abstract class Modulo implements Comparable<Modulo>{
    private int id;
    private String nombre;
    private int salud;
    private boolean activo;
    private double costoConstruccion;


    public Modulo(int id, String nombre, int salud, boolean activo, double costoConstruccion){
        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.activo = activo;
        this.costoConstruccion = costoConstruccion;
    }

    public abstract String procesarCiclo(RecursosMision recursos);

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getSalud(){
        return salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public double getCostoConstruccion(){
        return costoConstruccion;
    }

    public void setCostoConstruccion(double costoConstruccion){
        this.costoConstruccion = costoConstruccion;
    }

    @Override
    public int compareTo(Modulo otro){
        return Double.compare(this.costoConstruccion, otro.costoConstruccion);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Modulo otro = (Modulo) obj;
        return this.id == otro.id;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    @Override
    public String toString(){
        String estado;
        if(activo){
            estado = "activo";
        }
        else{
            estado = "inactivo";
        }
        return "ID" + id + "| Nombre:" + nombre + "| Salud:" + salud + "| Estado:" + estado + "| Costo:" + costoConstruccion;
    }

}