package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Modulo;
import modelo.ModuloTierra;
import modelo.RecursosMision;

public class VistaConsola{
    private Scanner scanner;

    public VistaConsola(){
        scanner = new Scanner(System.in);
    }

    public void menu(){
        System.out.println();
        System.out.println("------Defensa de torres------");
        System.out.println("1. Listar todos los modulos");
        System.out.println("2. buscar modulo por ID o nombre");
        System.out.println("3. Catalogo por costo");
        System.out.println("4. Avanzar un ciclo");
        System.out.println("5. Resumen de comunicaciones");
        System.out.println("6. salir");
    }

    public int leerEntero(String mensaje){
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String leerTexto(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarModulos(String titulo, ArrayList<Modulo> lista){
        System.out.println();
        System.out.println("---" + titulo + "----");
        if(lista.isEmpty()){
            System.out.println("No hay nigun modulo");
        }
        for(Modulo m : lista){
            System.out.println(m);
            System.out.println();
        }
    }

    public void  mostrarModulo(Modulo m){
        System.out.println();
        System.out.println(m);
    }

    public void mostrarResultadoCiclo(int numeroCiclo, ArrayList<String> resultados, RecursosMision recursos){
        System.out.println();
        System.out.println("----Resultado del ciclo" + numeroCiclo + "------");
        for(String r : resultados){
            System.out.println(r);
        }
        System.out.println();
        System.out.println("Estados de los recursos:" + recursos);
    }

    public void mostrarResumen(int totalTierra, int activos, int capacidad, int totalHistorico, ArrayList<ModuloTierra> mejores){
        System.out.println();
        System.out.println("-----Resumen de comunicaciones-----");
        System.out.println("Modulos de tierra:" + totalTierra + "[Acitvos:" + activos + "]");
        System.out.println("Capacidad total de descarga por ciclo:" + capacidad);
        System.out.println("Total historico descargado:" + totalHistorico);
        System.out.println("Modulo con mayor descarga:");
        for(ModuloTierra t : mejores){
            System.out.println(t.getNombre() + "| ID:" + t.getId() + "| Estacion:" + t.getEstacion() + "| Descargado:" + t.getTotalDescargado() + "MB");
        }

    }
}