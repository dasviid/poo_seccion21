package david.barre.poointerfaces.repositorios.lista;

import david.barre.poointerfaces.modelo.Cliente;
import david.barre.poointerfaces.repositorios.AbstractListRepositorio;
import david.barre.poointerfaces.repositorios.Direccion;
import david.barre.poointerfaces.repositorios.excepciones.LecturaAccesoDatoExcepcion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoExcepcion {
        Cliente c = this.porId(cliente.getId());
        c.setApellido(cliente.getApellido());
        c.setNombre(cliente.getNombre());
    }


    @Override
    public List<Cliente> listar(String campo, Direccion direccio) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado = 0;
                if (direccio == Direccion.ASC) {
                    resultado = ordenar(a, b, campo);
                }
                if (direccio == Direccion.DESC) {
                    resultado = ordenar(b, a, campo);
                }
                return resultado;
            }
        });
        return listaOrdenada;
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
}
