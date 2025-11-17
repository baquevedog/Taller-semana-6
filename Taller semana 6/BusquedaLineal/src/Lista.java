import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
    private List<Paquete> lista;
    private BusquedaPaquete buscador;

    public Lista() {
        // Por defecto usamos búsqueda lineal
        this.lista = new ArrayList<>();
        this.buscador = new BusquedaLinealPaquete();
    }

    public Lista(BusquedaPaquete buscador) {
        this.lista = new ArrayList<>();
        this.buscador = buscador;
    }

    public void setBuscador(BusquedaPaquete buscador) {
        this.buscador = buscador;
    }

    public void add(Paquete p) {
        lista.add(p);
    }

    public Paquete buscarPorNtrack(int ntrack) {
        if (buscador == null) return null;
        return buscador.buscar(lista, ntrack);
    }

    public boolean eliminarPorNtrack(int ntrack) {
        Paquete p = buscarPorNtrack(ntrack);
        if (p != null) {
            lista.remove(p);
            return true;
        }
        return false;
    }

    public void ordenarPorPesoAsc() {
        // Usa compareTo de Paquete (por peso)
        Collections.sort(lista);
    }

    public List<Paquete> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LISTA DE PAQUETES\n\n");
        for (Paquete p : lista) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
