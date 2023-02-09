package david.barre.poointerfaces;


import david.barre.poointerfaces.modelo.Producto;
import david.barre.poointerfaces.repositorios.Direccion;
import david.barre.poointerfaces.repositorios.OrdenablePagiableCrudRepositorio;
import david.barre.poointerfaces.repositorios.excepciones.AccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.excepciones.LecturaAccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositoriosProductos {
    public static void main(String[] args) {

        try {


            OrdenablePagiableCrudRepositorio<Producto> repositorio = new ProductoListRepositorio();
            repositorio.crear(new Producto("Mesa", 100d));
            repositorio.crear(new Producto("Silla", 50.0));
            repositorio.crear(new Producto("Lampara", 20.0));
            repositorio.crear(new Producto("Tele", 200d));

            List<Producto> clientes = repositorio.listar();
            clientes.forEach(System.out::println);

            System.out.println("========== paginable ==========");
            List<Producto> paginable = repositorio.listar(0, 4);
            paginable.forEach(System.out::println);

            System.out.println("========== ordenar ==========");
            List<Producto> productoList = repositorio.listar("id", Direccion.DESC);
            productoList.forEach(System.out::println);

            System.out.println("========== editar ==========");
            Producto pelotaActualizar = new Producto("Pelota", 20d);
            pelotaActualizar.setId(2);
            repositorio.editar(pelotaActualizar);
            Producto bea = repositorio.porId(2);
            repositorio.listar("precio", Direccion.ASC).forEach(System.out::println);

            System.out.println("========== eliminar ==========");
            repositorio.eliminar(2);
            repositorio.listar().forEach(System.out::println);
            System.out.println("========== eliminar ==========");
            System.out.println("Total registros: " + repositorio.total());
        } catch (LecturaAccesoDatoExcepcion e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoExcepcion ae) {
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        }
    }
}
