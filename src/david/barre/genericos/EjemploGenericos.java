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

        clientesLista.forEach(System.out::println);
        integersList.forEach(System.out::println);


        List<String > nombres = fromArrayToList(new String[]{"Andres","Pepe","Luci"},enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumsList = fromArrayToList(
                new ClientePremium[]{
                        new ClientePremium("Paco","Fernandez")
                });
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
}
