package model;

import java.util.List;

public class Personaje {

    private String nombre;
    private List<String> pistasFaciles;
    private List<String> pistasDificiles;

    public Personaje(String nombre, List<String> pistasFaciles, List<String> pistasDificiles) {
        this.nombre = nombre;
        this.pistasFaciles = pistasFaciles;
        this.pistasDificiles = pistasDificiles;
    }

   public String getNombre(){
        return nombre;
   }

   public List<String> getPistas(boolean dificil){
        return dificil ? pistasDificiles : pistasFaciles;
   }
}
