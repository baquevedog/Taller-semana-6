public class Paquete implements Comparable<Paquete> {
    private int ntrack;
    private double peso;
    private static int tpaquete;
    private String ciudadRecep;
    private String cedulaRecep;
    private String Receptado;
    private String Enviado;
    private String Entregado;

    public Paquete(double peso, String ciudadRecep, String cedulaRecep,
                   String receptado, String enviado, String entregado) {
        this.peso = peso;
        this.ciudadRecep = ciudadRecep;
        this.cedulaRecep = cedulaRecep;
        Receptado = receptado;
        Enviado = enviado;
        Entregado = entregado;
        this.ntrack = ++tpaquete;
    }

    public int getNtrack() {
        return ntrack;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public static int getNpaquete() {
        return tpaquete;
    }

    public String getCiudadRecep() {
        return ciudadRecep;
    }

    public void setCiudadRecep(String ciudadRecep) {
        this.ciudadRecep = ciudadRecep;
    }

    public String getCedulaRecep() {
        return cedulaRecep;
    }

    public void setCedulaRecep(String cedulaRecep) {
        this.cedulaRecep = cedulaRecep;
    }

    public String getReceptado() {
        return Receptado;
    }

    public void setReceptado(String receptado) {
        Receptado = receptado;
    }

    public String getEnviado() {
        return Enviado;
    }

    public void setEnviado(String enviado) {
        Enviado = enviado;
    }

    public String getEntregado() {
        return Entregado;
    }

    public void setEntregado(String entregado) {
        Entregado = entregado;
    }

    @Override
    public String toString() {
        return " Total Paquete" + "\n" +
                "numero track: " + ntrack + "\n" +
                "peso: " + peso + "\n" +
                "ciudad recepcion: " + ciudadRecep + "\n" +
                "Cedula Receptor: " + cedulaRecep + "\n" +
                "Receptado: " + Receptado + "\n" +
                "Enviado: " + Enviado + "\n" +
                "Entregado: " + Entregado + "\n\n";
    }

    @Override
    public int compareTo(Paquete o) {
        return Double.compare(this.peso, o.peso);
    }
}
