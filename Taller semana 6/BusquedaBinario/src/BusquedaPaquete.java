public interface BusquedaPaquete {
    /**
     * Busca un paquete por su número de tracking dentro de la lista.
     * @param datos lista de paquetes
     * @param ntrack número de tracking a buscar
     * @return el Paquete encontrado o null si no existe
     */
    Paquete buscar(java.util.List<Paquete> datos, int ntrack);
}
