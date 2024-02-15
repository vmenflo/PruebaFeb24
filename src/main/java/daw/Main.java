/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author
 */
public class Main {

    public static void main(String[] args) {

        //Probar Método uno
        List<Viaje> uno = getListaViajes();
        uno.toString();
        Map<String, Integer> listaViajes = numeroViajes(uno);
        System.out.println(listaViajes.toString());
        
        //Probar Método dos
        Set<String> listadoDestino = destinosDiferentes(uno);
        System.out.println("Mostrar Set Destinos: ");
        System.out.println(listadoDestino.toString());
        
        //Probar Método tres
        Map<String,Integer> listadoViajeros = numeroViajeros(uno);
        System.out.println(listadoViajeros.toString());
        
        System.out.println("Recorrido del set con un iterador -----------------");
        // Se puede recorrer el set con un iterador
        //En proceso

    }
    //----------------------------------------
    // ABRE EL ARCHIVO POM.XML, MODIFICA EL CONTENIDO QUE HAY ENTRE LAS ETIQUETAS
    // <artifactId>PruebaFeb24</artifactId> PARA QUE SEA <artifactId>PruebaFeb24+TUNOMBRE</artifactId>

    // CREA UN REPOSITORIO LOCAL GIT, AÑADE EN UN PRIMER COMMIT LOS ARCHIVOS NECESARIOS
    // DEL PROYECTO. EL REPOSITORIO, AL FINALIZAR LA PRUEBA, DEBE CONTENER CUATRO COMMITS, UNO POR CADA
    // APARTADO. AL CREAR EL ZIP, INCLUYE LA CARPETA .GIT. SI NO HAY CONTROL DE VERSIONES CORRECTO
    // NO SE CORRIGE EL RESTO
    //---------------------------------------
    // A.- Crea un método que reciba la lista y devuelva una estructura de datos/colección
    // / con el número de viajes que salen de cada ciudad de origen. Usa el método en el main
    // e imprime el resultado usando un foreach
    
    //Devolveré un Map porque así controlo que no se repitan
    
    public static Map<String, Integer> numeroViajes(List<Viaje> lista) {
        Map<String, Integer> listaViajes = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {//Recorro la lista
            //Si exite ya, le añade una cantidad más
            if (listaViajes.containsKey(lista.get(i).origen())) {
                listaViajes.replace(lista.get(i).origen(),
                        listaViajes.get(lista.get(i).origen()) + 1);
            } else { //Si no existe la añade
                listaViajes.put(lista.get(i).origen(), 1);
            }
        }
        return listaViajes;
    }

    // B.- Crea un método que reciba la lista y devuelva una estructura de datos/colección 
    // con todos los destinos diferentes. Usa el método en el main
    // e imprime el resultado usando un iterador
    
    //Lo haré con un Set, así solo tengo que añadir sin preocuparme de si se 
    //repiten o no, esta estructura lo hace sola
    public static Set<String> destinosDiferentes(List<Viaje> listado){
        Set<String> lista = new HashSet<>(); //Creo el Set
            for(int i=0;i<listado.size();i++){//Buvle para recorrer el listado
                lista.add(listado.get(i).destino());//añado todo
            }
        return lista; //Devuelve todo sin repetir
    }
    // C.- Crea un método que reciba la lista y devuelva una estructura de datos/colección
    // para saber por cada ciudad destino el número total de viajeros que llegan ese día
    // Usa el método en el main, obten las claves de la estructura devuelta e iterando por ellas imprime 
    // el número de viajeros por ciudad
    
    public static Map<String, Integer> numeroViajeros(List<Viaje> lista) {
        Map<String, Integer> listaViajeros = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {//Recorro la lista
            //Si exite ya, le añade una cantidad más
            if (listaViajeros.containsKey(lista.get(i).destino())) {
                listaViajeros.replace(lista.get(i).destino(),
                        listaViajeros.get(lista.get(i).destino())
                                +lista.get(i).numeroPasajeros());
            } else { //Si no existe la añade
                listaViajeros.put(lista.get(i).destino(),lista.get(i).numeroPasajeros());
            }
        }
        return listaViajeros;
    }
    
    // D.- Crea un método que reciba la lista y la ordene por destino y si hay
    // destinos iguales se ordenan por número de viajeros. Usa el método en el main
    // e imprime el resultado usando foreach con expresión lambda, para obtener
    // una salida como esta por cada elemento: "Destino: Estepona Viajeros: 35" 
    //---------------------------------------
    private static ArrayList<Viaje> getListaViajes() {
        ArrayList<Viaje> listaViajes = new ArrayList();
        // Origen - destino - número de pasajeros
        listaViajes.add(new Viaje("Estepona", "Málaga", 120));
        listaViajes.add(new Viaje("Estepona", "Granada", 45));
        listaViajes.add(new Viaje("Estepona", "Algeciras", 100));
        listaViajes.add(new Viaje("Algeciras", "Málaga", 20));
        listaViajes.add(new Viaje("Algeciras", "Granada", 50));
        listaViajes.add(new Viaje("Granada", "Estepona", 35));
        listaViajes.add(new Viaje("Casares", "Málaga", 12));
        listaViajes.add(new Viaje("Marbella", "Málaga", 120));

        return listaViajes;
    }
}
