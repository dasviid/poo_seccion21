package david.barre.poointerfaces;

import david.barre.poointerfaces.modelo.*;
import david.barre.poointerfaces.repositorios.*;
import david.barre.poointerfaces.repositorios.excepciones.AccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.excepciones.EscrituraAccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.excepciones.LecturaAccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.excepciones.RegisroDuplicadoAccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorios {
    public static void main(String[] args) {

        try {
            OrdenablePagiableCrudRepositorio<Cliente> repositorio = new ClienteListRepositorio();
            repositorio.crear(new Cliente("Jano", "Perez"));
            repositorio.crear(new Cliente("Bea", "Rodriguez"));
            repositorio.crear(new Cliente("Luci", "Martinez"));
            Cliente yo = new Cliente("David", "Barreneche");
            repositorio.crear(yo);
            repositorio.crear(yo);

            //repositorio.crear(null);

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
            repositorio.eliminar(1);
            repositorio.listar().forEach(System.out::println);
            System.out.println("========== eliminar ==========");
            System.out.println("Total registros: " + repositorio.total());
        } catch (RegisroDuplicadoAccesoDatoExcepcion e) {
        System.err.println("Duplicado: " +e.getMessage());
        e.printStackTrace();
    }
        catch (LecturaAccesoDatoExcepcion e) {
            System.err.println("Lectura: " +e.getMessage());
            e.printStackTrace();
        }catch (EscrituraAccesoDatoExcepcion e) {
            System.err.println("Escritura: " +e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoExcepcion e) {
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
