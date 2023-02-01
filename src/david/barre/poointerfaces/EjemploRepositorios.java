package david.barre.poointerfaces;

import david.barre.poointerfaces.modelo.*;
import david.barre.poointerfaces.repositorios.*;

import java.util.List;

public class EjemploRepositorios {
    public static void main(String[] args) {

        CrudRepositorio repositorio = new ClienteListRepositorio();
        repositorio.crear(new Cliente("Jano","Perez"));
        repositorio.crear(new Cliente("Bea","Rodriguez"));
        repositorio.crear(new Cliente("Luci","Martinez"));
        repositorio.crear(new Cliente("David","Barreneche"));

        List<Cliente> clientes = repositorio.listar();
        clientes.forEach(System.out::println);

        System.out.println("========== paginable ==========");
        List<Cliente> paginable = ((ClienteListRepositorio)repositorio).listar(0, 4);
        paginable.forEach(System.out::println);

        System.out.println("========== ordenar ==========");
        List<Cliente> clietesOrdenAsc = ((OrdenableRepositorio)repositorio).listar("id",Direccion.DESC);
        clietesOrdenAsc.forEach(System.out::println);

        System.out.println("========== editar ==========");
        Cliente beaActualizar  = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repositorio.editar(beaActualizar);
        Cliente bea = repositorio.porId(2);
        ((ClienteListRepositorio)repositorio)
                .listar("nombre",Direccion.ASC).forEach(System.out::println);

        System.out.println("========== eliminar ==========");
      //  repositorio.eliminar(2);
        repositorio.listar().forEach(System.out::println);
    }
}
