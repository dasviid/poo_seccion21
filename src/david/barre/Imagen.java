package david.barre;

public class Imagen<T extends Nombrable>{
    private T t;

    public Imagen(T t) {
        this.t = t;
    }

    public String getUrl(){

        return "www.googledrive.com/" + this.t.nombre;
    }
}
