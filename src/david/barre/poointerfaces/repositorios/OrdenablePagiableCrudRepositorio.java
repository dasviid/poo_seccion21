package david.barre.poointerfaces.repositorios;

public interface OrdenablePagiableCrudRepositorio<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
