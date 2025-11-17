import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BusquedaBinariaPaquete implements BusquedaPaquete {

    @Override
    public Paquete buscar(List<Paquete> datos, int ntrack) {
        if (datos == null || datos.isEmpty()) {
            return null;
        }

        // Importante: la búsqueda binaria requiere que la lista esté ORDENADA
        // por el campo sobre el que buscamos (ntrack).
        // Para no alterar el orden original, trabajamos con una copia.
        List<Paquete> copiaOrdenada = new ArrayList<>(datos);
        copiaOrdenada.sort(Comparator.comparingInt(Paquete::getNtrack));

        int izquierda = 0;
        int derecha = copiaOrdenada.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            Paquete actual = copiaOrdenada.get(medio);

            if (actual.getNtrack() == ntrack) {
                // OJO: el objeto es el mismo (misma referencia) que en la lista original
                return actual;
            } else if (actual.getNtrack() < ntrack) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null; // no encontrado
    }
}
