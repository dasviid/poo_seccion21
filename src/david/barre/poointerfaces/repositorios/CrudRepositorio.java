package david.barre.poointerfaces.repositorios;

import david.barre.poointerfaces.repositorios.excepciones.AccesoDatoExcepcion;
import david.barre.poointerfaces.repositorios.excepciones.LecturaAccesoDatoExcepcion;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id) throws AccesoDatoExcepcion;

    void crear(T t) throws AccesoDatoExcepcion;

    void editar(T t) throws AccesoDatoExcepcion;

    void eliminar(Integer id) throws AccesoDatoExcepcion;

}
