package david.barre.poointerfaces;

import david.barre.poointerfaces.modelo.*;
import david.barre.poointerfaces.repositorios.*;

import java.util.List;

public class EjemploRepositorios {
    public static void main(String[] args) {

        OrdenablePagiableCrudRepositorio repositorio = new ClienteListRepositorio();
        repositorio.crear(new Cliente("Jano", "Perez"));
        repositorio.crear(new Cliente("Bea", "Rodriguez"));
        repositorio.crear(new Cliente("Luci", "Martinez"));
        repositorio.crear(new Cliente("David", "Barreneche"));

        List<Cliente> clientes = repositorio.listar();
        clientes.forEach(System.out::println);

        System.out.println("========== paginable ==========");
        List<Cliente> paginable = repositorio.listar(0, 4);
        paginable.forEach(System.out::println);

        System.out.println("========== ordenar ==========");
        List<Cliente> clietesOrdenAsc = repositorio.listar("id", Direccion.DESC);
        clietesOrdenAsc.forEach(System.out::println);

        System.out.println("========== editar ==========");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repositorio.editar(beaActualizar);
        Cliente bea = repositorio.porId(2);
        repositorio.listar("nombre", Direccion.ASC).forEach(System.out::println);

        System.out.println("========== eliminar ==========");
        repositorio.eliminar(2);
        repositorio.listar().forEach(System.out::println);
        System.out.println("========== eliminar ==========");
        System.out.println("Total registros: " + repositorio.total());

    }
}
