package david.barre.genericos;

import david.barre.poointerfaces.modelo.Cliente;
import david.barre.poointerfaces.modelo.ClientePremium;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList();
        clientes.add(new Cliente("David","Barre"));

        Cliente david =clientes.get(0);

        Cliente[] clientesArreglo = { new Cliente("David","Barre"),
                new Cliente("Fran","Barre")};

        Integer[] enterosArreglo ={1,2,3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> integersList  = fromArrayToList(enterosArreglo);


        List<String > nombres = fromArrayToList(new String[]{"Andres","Pepe","Luci"},enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumsList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco","Fernandez")});

        imprimirClientes(clientes);
        System.out.println("=========");
        imprimirClientes(clientesLista);
        System.out.println("=========");
        imprimirClientes(clientePremiumsList);

        System.out.println("Maximo de 1, 9  y 4 es: " + maximo(1,9,4));
        System.out.println("Maximo de 3.9, 9.6  y 12,35 es: " + maximo(3.9,9.6 ,12.35));
        System.out.println("Maximo de a, b  y c es: " + maximo("David","hBautista","Colo"));
    }

    public static <T>List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Number>List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Cliente & Comparable<T>>List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T,G>List<T> fromArrayToList(T[] c, G[] x){
        for (G elemento : x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static  void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends  Comparable<T>>T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        }

        if (c.compareTo(max) > 0){
            max = c;
        }
     return max;
    }
}
