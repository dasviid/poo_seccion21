package david.barre.genericclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Camion<T> implements Iterable<T> {

    private List<T> objetos;
    private int max;

    public Camion( int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void addObjetos(T objeto){
       if (this.objetos.size() <= max){
        this.objetos.add(objeto);
       } else {
           throw new RuntimeException("No hay mas espacio en el camion");
       }
    }

    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
