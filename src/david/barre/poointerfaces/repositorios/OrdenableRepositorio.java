package david.barre.poointerfaces.repositorios;

import david.barre.poointerfaces.modelo.Cliente;

import java.util.Date;
import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion direccio);
}
