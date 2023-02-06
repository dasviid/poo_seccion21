package david.barre.poointerfaces.repositorios.lista;

import david.barre.poointerfaces.modelo.Producto;
import david.barre.poointerfaces.repositorios.AbstractListRepositorio;
import david.barre.poointerfaces.repositorios.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion direccio) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto a, Producto b) {
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
    private int ordenar(Producto a, Producto b, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }

}
