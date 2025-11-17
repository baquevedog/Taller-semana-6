import java.util.List;

public class BusquedaLinealPaquete implements BusquedaPaquete {

    @Override
    public Paquete buscar(List<Paquete> datos, int ntrack) {
        if (datos == null || datos.isEmpty()) {
            return null;
        }

        for (Paquete p : datos) {
            if (p.getNtrack() == ntrack) {
                return p;
            }
        }
        return null; // no encontrado
    }
}
