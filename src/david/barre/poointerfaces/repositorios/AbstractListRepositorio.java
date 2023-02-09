package david.barre.poointerfaces.repositorios;

import david.barre.poointerfaces.modelo.BaseEntity;
import david.barre.poointerfaces.modelo.Cliente;
import david.barre.poointerfaces.repositorios.excepciones.*;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractListRepositorio<T extends BaseEntity> implements OrdenablePagiableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }


    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoExcepcion {
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoExcepcion("Id invalido debe ser > 0 ");
        }
        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if (resultado == null){
            throw new LecturaAccesoDatoExcepcion("No existe el registro con el id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoExcepcion {
        if (t == null){
                throw  new EscrituraAccesoDatoExcepcion("Error al ingresar un objeto nulo");
        }
        if (this.dataSource.contains(t)){
            throw new RegisroDuplicadoAccesoDatoExcepcion("Error el objeto con id "
            + t.getId() + " existe en el repositorio");
        }
        this.dataSource.add(t);

    }


    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoExcepcion {
        this.dataSource.remove(this.porId(id));

    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    private int ordenar(Cliente a, Cliente b, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
