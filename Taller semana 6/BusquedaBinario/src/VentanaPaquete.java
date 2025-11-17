import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPaquete {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtCIcliente;
    private JSpinner spinPeso;
    private JTextField txtciuReci;
    private JTextField txttipo;
    private JTextField txtNtrack;
    private JTextField txtciuEntre;
    private JButton btnguardar;
    private JTextField txtbuscarNtrack;
    private JButton btnBuscar;
    private JTextArea txtMostrarBusqueda;
    private JButton BtnELIMINAR;
    private JButton btnOrdenarpeso;

    // Nuestra estructura de datos
    private Lista listaPaquetes;

    public VentanaPaquete() {

        listaPaquetes = new Lista(); // usa BusquedaLinealPaquete por defecto
        txtMostrarBusqueda.setLineWrap(true);
        txtMostrarBusqueda.setWrapStyleWord(true);
        btnguardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CIcliente = txtCIcliente.getText();
                double peso = ((Number) spinPeso.getValue()).doubleValue();
                String ciuReci = txtciuReci.getText();
                String tipo = txttipo.getText();
                String ciuEntre = txtciuEntre.getText();

                try {
                    // Aquí interpreto "tipo" como el estado "Receptado"
                    String receptado = "Tipo: " + tipo;
                    String enviado = "Enviado a " + ciuReci;
                    String entregado = "Entregado desde " + ciuEntre;

                    Paquete p = new Paquete(peso, ciuReci, CIcliente,
                            receptado, enviado, entregado);

                    listaPaquetes.add(p);

                    // Mostramos el número de tracking generado automáticamente
                    txtNtrack.setText(String.valueOf(p.getNtrack()));

                    txtMostrarBusqueda.setText("PAQUETE GUARDADO:\n\n" + p.toString());
                    limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Error al guardar el paquete: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ntrack = Integer.parseInt(txtbuscarNtrack.getText().trim());
                    Paquete encontrado = listaPaquetes.buscarPorNtrack(ntrack);

                    if (encontrado != null) {
                        txtMostrarBusqueda.setText("PAQUETE ENCONTRADO:\n\n" + encontrado.toString());
                    } else {
                        txtMostrarBusqueda.setText("No se encontró ningún paquete con ntrack = " + ntrack);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Ingrese un número de tracking válido.",
                            "Dato incorrecto",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Error al buscar: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnOrdenarpeso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listaPaquetes.ordenarPorPesoAsc();
                    txtMostrarBusqueda.setText("PAQUETES ORDENADOS POR PESO (ASCENDENTE):\n\n"
                            + listaPaquetes.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Error al ordenar: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        BtnELIMINAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ntrack = Integer.parseInt(txtbuscarNtrack.getText().trim());
                    boolean eliminado = listaPaquetes.eliminarPorNtrack(ntrack);

                    if (eliminado) {
                        txtMostrarBusqueda.setText("Se eliminó el paquete con ntrack = " + ntrack + "\n\n"
                                + "Estado actual de la lista:\n\n"
                                + listaPaquetes.toString());
                    } else {
                        txtMostrarBusqueda.setText("No existe un paquete con ntrack = " + ntrack);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Ingrese un número de tracking válido para eliminar.",
                            "Dato incorrecto",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Ventana,
                            "Error al eliminar: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPaquete");
        frame.setContentPane(new VentanaPaquete().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }
    private void limpiarCampos() {
        txtCIcliente.setText("");
        spinPeso.setValue(0);
        txtciuReci.setText("");
        txttipo.setText("");
        txtciuEntre.setText("");
        txtNtrack.setText("");
    }

}
