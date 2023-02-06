package david.barre.poointerfaces.repositorios;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion direccio);
}
