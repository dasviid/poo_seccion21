package david.barre.poointerfaces.repositorios;

import david.barre.poointerfaces.modelo.BaseEntity;
import david.barre.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractListRepositorio<T extends BaseEntity> implements OrdenablePagiableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {this.dataSource = new ArrayList<>();}


    @Override
    public List<T> listar() {
        return this.dataSource;
    }

   @Override
    public T porId(Integer id) {
        T resultado = null;
        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);

    }


    @Override
    public void eliminar(Integer id) {
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
