package david.barre;

import java.util.Arrays;

public class Lista<T> {
    private Object[] objetos;
    private int i;

    public Lista(){
        this.i = 0;
        this.objetos = new Object[3];
    }

    public void add(T elemento){
        if (this.i  == this.objetos.length){
            Object[] aux = new Object[this.objetos.length + 3];

            for (int i = 0; i < this.objetos.length; i++){
                aux[i] = this.objetos[i];
            }
            this.objetos = aux;
        }
        this.objetos[this.i] = elemento;
        this.i++;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.objetos);
    }

    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();
        lista.add("Dato 1");
        lista.add("Dato 2");
        lista.add("Dato 3");
        lista.add("Dato 4");

        System.out.println(lista);

        Lista<Integer> lista2 = new Lista<>();
        lista2.add(100);
        lista2.add(23);
        lista2.add(52);
        lista2.add(123);

        System.out.println(lista2);
    }

}

