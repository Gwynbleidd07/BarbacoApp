/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cargo;
import Modelo.PersonalDAO;
import Modelo.Personas;
import Vista.Menu;
import Vista.Personal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Personal implements ActionListener {

    PersonalDAO modeloPer = new PersonalDAO();
    Personal vistaPer = new Personal();
    Menu vistaMe = new Menu();

    Controlador_Personal(Personal vistaPersonal, PersonalDAO modeloPersonal) {
        this.modeloPer = modeloPersonal;
        this.vistaPer = vistaPersonal;
        vistaPersonal.btn_Ejecutar.addActionListener(this);
        vistaPersonal.btn_Ejecutar1.addActionListener(this);
        vistaPersonal.btn_Ejecutar2.addActionListener(this);
        vistaPersonal.btn_Limpiar.addActionListener(this);
        vistaPersonal.btn_Limpiar1.addActionListener(this);
        vistaPersonal.btn_Limpiar2.addActionListener(this);
//        vistaPersonal.btn_Excel1.addActionListener(this);
        vistaPersonal.btn_Buscar.addActionListener(this);
        vistaPersonal.btn_Actualizar.addActionListener(this);
        vistaPersonal.btn_Volver.addActionListener(this);
        vistaPersonal.Jt_BuscarPersonal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busquedaPersonal(vistaPer.Jt_BuscarPersonal.getText(), vistaPer.jTable_Empleado);
            }

            private void busquedaPersonal(String busqueda, JTable jTable_Empleado) {
                ArrayList<Personas> personas = new ArrayList<>();
                personas = modeloPer.buscarPersonal(busqueda);
                if (personas.size() != 0) {
                    String[] titulos = {"Cedula", "Nombre", "Apellido", "Celular", "Fecha", "Edad", "Comentarios", "Calificación"};
                    String[] registro = new String[8];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Empleado.setModel(modeltabla);
                    int registros = personas.size();
                    for (int i = 0; i < registros; i++) {
                        registro[0] = personas.get(i).getId();
                        registro[1] = personas.get(i).getNombre();
                        registro[2] = personas.get(i).getApellido();
                        registro[3] = personas.get(i).getCelular();
                        registro[4] = personas.get(i).getFecha_Nacimiento();
                        registro[5] = String.valueOf(personas.get(i).getEdad());
                        registro[6] = personas.get(i).getComentarios();
                        registro[7] = String.valueOf(personas.get(i).getCalificacion());
                        modeltabla.addRow(registro);
                    }
                    jTable_Empleado.setModel(modeltabla);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay empleados registrados con el dato ingresado");
                }
            }
        });
        vistaPer.jT_BuscarCargo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busquedaCargo(vistaPer.jT_BuscarCargo.getText(), vistaPer.jTable_Cargo);
            }

            private void busquedaCargo(String busqueda, JTable jTable_Cargo) {
                ArrayList<Cargo> cargos = new ArrayList<>();
                cargos = modeloPer.buscarCargo(busqueda);
                if (cargos.size() != 0) {
                    String[] titulos = {"Codigo", "Nombre", "Valor hora"};
                    String[] registro = new String[3];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Cargo.setModel(modeltabla);
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    int registros = cargos.size();
                    for (int i = 0; i < registros; i++) {
                        registro[0] = cargos.get(i).getCodigo();
                        registro[1] = cargos.get(i).getNombre();
                        registro[2] = formato.format(cargos.get(i).getValor());
                        modeltabla.addRow(registro);
                    }
                    jTable_Cargo.setModel(modeltabla);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay barrios registrados con el dato ingresado");
                }
            }
        });
        vistaPer.jTable_Empleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaPer.jTable_Empleado.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaPersonal.jT_Cedula.setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 0)));
                    vistaPersonal.jT_Nombre.setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 1)));
                    vistaPersonal.jT_Apellido.setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 2)));
                    vistaPersonal.jT_Celular.setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 3)));
                    ((JTextField) vistaPersonal.jDate_Fecha.getDateEditor().getUiComponent()).setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 4)));
                    vistaPersonal.jT_Comentario.setText(String.valueOf(vistaPer.jTable_Empleado.getValueAt(seleccionado, 6)));
                    vistaPersonal.jT_Calificacion.setText(String.valueOf(vistaPer.jTable_Empleado.getValueAt(seleccionado, 7)));
                }
            }
        });
        vistaPer.jTable_Empleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaPer.jTable_Empleado.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaPersonal.jT_Cedula1.setText(String.valueOf(vistaPersonal.jTable_Empleado.getValueAt(seleccionado, 0)));
                }
            }
        });
        vistaPersonal.jTable_TurnoEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaPer.jTable_TurnoEmpleado.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaPersonal.jT_Cedula1.setText(String.valueOf(vistaPersonal.jTable_TurnoEmpleado.getValueAt(seleccionado, 0)));
                }
            }
        });
        vistaPersonal.jTable_Cargo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaPer.jTable_Cargo.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaPersonal.jT_Cod_Cargo1.setText(String.valueOf(vistaPersonal.jTable_Cargo.getValueAt(seleccionado, 0)));
                }
            }
        });
        cargarTabla(vistaPersonal.jTable_Empleado);
        cargarTabla1(vistaPersonal.jTable_TurnoEmpleado);
        cargarTabla2(vistaPersonal.jTable_Cargo);
    }

    private void busquedaPersonalCargo(String busqueda, String busqueda1, String busqueda2, String busqueda3, String busqueda4, String valueOf, JTable jTable_TurnoEmpleado) {
        ArrayList<Personas> personas = new ArrayList<>();
        personas = modeloPer.buscarPersonalCargo(busqueda, busqueda1, busqueda2, busqueda3, busqueda4);
        if (personas.size() != 0) {
            String[] titulos = {"Cedula", "Nombres", "Apellido", "Fecha", "Cargo", "Horas", "Valor"};
            String[] registro = new String[7];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_TurnoEmpleado.setModel(modeltabla);
            int registros = personas.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = personas.get(i).getId();
                registro[1] = personas.get(i).getNombre();
                registro[2] = personas.get(i).getApellido();
                registro[3] = personas.get(i).getFecha();
                registro[4] = personas.get(i).getCargo();
                registro[5] = String.valueOf(personas.get(i).getN_Horas());
                registro[6] = formato.format(personas.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable_TurnoEmpleado.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos registrados con lo ingresado");
        }
    }

    private void busquedaTotal(String busqueda, String busqueda1, String busqueda2, String busqueda3, JLabel labelValor) {
        ArrayList<Personas> personas = modeloPer.buscarTotal(busqueda, busqueda1, busqueda2, busqueda3);

        if (!personas.isEmpty()) {
            int valorTotal = personas.get(0).getValor(); // Obtener el valor total

            // Formatear el número antes de establecerlo como texto en el JLabel
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(0); // Define el número máximo de dígitos fraccionarios
            String valorFormateado = nf.format(valorTotal); // Formatea el número

            // Actualizar el texto del JLabel con el valor total formateado
            labelValor.setText("Valor Total: " + valorFormateado);
        }
    }

    private void cargarTabla(JTable jTable_Empleado) {
        String[] titulos = {"Cedula", "Nombres", "Apellido", "Celular", "Fecha", "Edad", "Comentarios", "Calificación"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[8];
        jTable_Empleado.setModel(modelotabla);
        int registros = modeloPer.listaDePersonas().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPer.listaDePersonas().get(i).getId();
            registro[1] = modeloPer.listaDePersonas().get(i).getNombre();
            registro[2] = modeloPer.listaDePersonas().get(i).getApellido();
            registro[3] = modeloPer.listaDePersonas().get(i).getCelular();
            registro[4] = modeloPer.listaDePersonas().get(i).getFecha_Nacimiento();
            registro[5] = String.valueOf(modeloPer.listaDePersonas().get(i).getEdad());
            registro[6] = modeloPer.listaDePersonas().get(i).getComentarios();
            registro[7] = String.valueOf(modeloPer.listaDePersonas().get(i).getCalificacion());
            modelotabla.addRow(registro);
        }
        jTable_Empleado.setModel(modelotabla);
    }

    private void cargarTabla1(JTable jTable_TurnoEmpleado) {
        String[] titulos = {"Cedula", "Nombres", "Apellidos", "Fecha", "Cargo", "Horas", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[7];
        jTable_TurnoEmpleado.setModel(modelotabla);
        int registros = modeloPer.listadePersonaCargo().size();

        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado

        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPer.listadePersonaCargo().get(i).getId();
            registro[1] = modeloPer.listadePersonaCargo().get(i).getNombre();
            registro[2] = modeloPer.listadePersonaCargo().get(i).getApellido();
            registro[3] = modeloPer.listadePersonaCargo().get(i).getFecha();
            registro[4] = modeloPer.listadePersonaCargo().get(i).getCargo();
            registro[5] = String.valueOf(modeloPer.listadePersonaCargo().get(i).getN_Horas());
            // Formatear el valor antes de agregarlo al registro
            registro[6] = formato.format(modeloPer.listadePersonaCargo().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_TurnoEmpleado.setModel(modelotabla);
    }

    private void cargarTabla2(JTable jTable_Cargo) {
        String[] titulos = {"Codigo", "Nombre", "Valor hora"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable_Cargo.setModel(modelotabla);
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        int registros = modeloPer.listaCargo().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPer.listaDeCargos().get(i).getCodigo();
            registro[1] = modeloPer.listaDeCargos().get(i).getNombre();
            registro[2] = formato.format(modeloPer.listaDeCargos().get(i).getValor());
            modelotabla.addRow(registro);

        }
        jTable_Cargo.setModel(modelotabla);
    }

    public boolean validarPersona() {
        boolean existe = false;
        int tamano = modeloPer.listaPersona().size();

        for (int i = 0; i < tamano; i++) {
            String cedula = modeloPer.listaPersona().get(i).getId();
            if (vistaPer.jT_Cedula.getText().equals(cedula)) {
                existe = true;
                i = tamano;
                JOptionPane.showMessageDialog(null, "Ya existe una Persona con datos similares");
            }
        }
        return existe;
    }

    public boolean validarCargo() {
        boolean existe = false;
        int tamano = modeloPer.listaCargo().size();

        for (int i = 0; i < tamano; i++) {
            String codigo = modeloPer.listaCargo().get(i).getCodigo();
            if (vistaPer.jT_Codigo.getText().equals(codigo)) {
                existe = true;
                i = tamano;
                JOptionPane.showMessageDialog(null, "Ya existe una cargo con datos similares");
            }
        }
        return existe;
    }

    private boolean Vacio() {
        boolean vacio = false;
        if (vistaPer.jT_Cedula.getText().length() == 0) {
//                || vistaPer.jT_Nombre.getText().length() == 0 || vistaPer.jT_Apellido.getText().length() == 0
//                || vistaPer.jT_Celular.getText().length() == 0 || vistaPer.jDate_Fecha.getToolTipText().length() == 0
//                || vistaPer.jT_Comentario.getText().length() == 0 || vistaPer.jT_Calificacion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public boolean Vacio1() {
        boolean vacio = false;
        if (vistaPer.jT_Cedula1.getText().length() == 0) {
//                || vistaPer.jDate_Fecha1.getToolTipText().length() == 0) {
//                || vistaPer.jT_Horas.getText().length() == 0 || vistaPer.jCombo_Cargo.getToolTipText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public boolean Vacio2() {
        boolean vacio = false;
        if (vistaPer.jT_Codigo.getText().length() == 0 || vistaPer.jT_NombreCargo.getText().length() == 0
                || vistaPer.jT_Valor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    private void limpiarEntrada() {
        vistaPer.jT_Cedula.setText(null);
        vistaPer.jT_Nombre.setText(null);
        vistaPer.jT_Apellido.setText(null);
        vistaPer.jT_Celular.setText(null);
        vistaPer.jDate_Fecha.setDate(null);
        vistaPer.jT_Comentario.setText(null);
        vistaPer.jT_Calificacion.setText(null);
    }

    private void limpiarEntrada1() {
        vistaPer.jT_Cedula1.setText(null);
        vistaPer.jDate_Fecha1.setDate(null);
        vistaPer.jT_Cod_Cargo1.setText(null);
        vistaPer.jT_Cod_Cargo1.setText(null);
    }

    private void limpiarEntrada2() {
        vistaPer.jT_Codigo.setText(null);
        vistaPer.jT_NombreCargo.setText(null);
        vistaPer.jT_Valor.setText(null);
    }

    private void exportarAExcel(JTable jTable_TurnoEmpleado) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Datos");
                hoja.setDisplayGridlines(false);

                // Crear estilo de borde
                CellStyle bordeCellStyle = libro.createCellStyle();
                bordeCellStyle.setBorderTop((short) 1);
                bordeCellStyle.setBorderBottom((short) 1);
                bordeCellStyle.setBorderLeft((short) 1);
                bordeCellStyle.setBorderRight((short) 1);

                for (int f = 0; f < jTable_TurnoEmpleado.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < jTable_TurnoEmpleado.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(jTable_TurnoEmpleado.getColumnName(c));
                        }
                        celda.setCellStyle(bordeCellStyle); // Aplicar estilo de borde
                    }
                }

                int filaInicio = 1;
                for (int f = 0; f < jTable_TurnoEmpleado.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < jTable_TurnoEmpleado.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (jTable_TurnoEmpleado.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(jTable_TurnoEmpleado.getValueAt(f, c).toString()));
                        } else if (jTable_TurnoEmpleado.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) jTable_TurnoEmpleado.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(jTable_TurnoEmpleado.getValueAt(f, c)));
                        }
                        celda.setCellStyle(bordeCellStyle); // Aplicar estilo de borde
                    }
                }

                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPer.btn_Limpiar) {
            limpiarEntrada();
        }
        if (e.getSource() == vistaPer.btn_Limpiar1) {
            limpiarEntrada1();
        }
        if (e.getSource() == vistaPer.btn_Limpiar2) {
            limpiarEntrada2();
        }
        if (e.getSource() == vistaPer.btn_Ejecutar) {
            String Cedula = vistaPer.jT_Cedula.getText();
            String Nombre = vistaPer.jT_Nombre.getText();
            String Apellido = vistaPer.jT_Apellido.getText();
            String Celular = vistaPer.jT_Celular.getText();
            String Fecha = ((JTextField) vistaPer.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Comentario = vistaPer.jT_Comentario.getText();
            double Calificacion = Double.parseDouble(vistaPer.jT_Calificacion.getText());
            if (Vacio() == false) {
                if (validarPersona() == false) {
                    Personas mipersona = new Personas(Cedula, Nombre, Apellido, Celular, Fecha, Comentario, Calificacion);
                    modeloPer.registrarEmpleado(mipersona);
                    limpiarEntrada();
                    cargarTabla(vistaPer.jTable_Empleado);
                }
            }
        }
        if (e.getSource() == vistaPer.btn_Ejecutar1) {
            String Cedula = vistaPer.jT_Cedula1.getText();
            String CodigoCargo = vistaPer.jT_Cod_Cargo1.getText();
            String Fecha1 = ((JTextField) vistaPer.jDate_Fecha1.getDateEditor().getUiComponent()).getText();
            int Horas = Integer.parseInt(vistaPer.jT_Cod_Cargo1.getText());
            if (Vacio1() == false) {
                if (CodigoCargo.equals("Seleccione un cargo")) {
                    JOptionPane.showMessageDialog(null, "Seleccione un cargo");
                } else {
                    Personas mipersona = new Personas(Cedula, Fecha1, Horas, CodigoCargo);
                    modeloPer.registrarPersonaCargo(mipersona);
                    cargarTabla1(vistaPer.jTable_TurnoEmpleado);
                    limpiarEntrada1();
                }
            }
        }
        if (e.getSource() == vistaPer.btn_Ejecutar2) {
            String Codigo = vistaPer.jT_Codigo.getText();
            String NombreCargo = vistaPer.jT_NombreCargo.getText();
            int Valor = Integer.parseInt(vistaPer.jT_Valor.getText());
            if (Vacio2() == false) {
                if (validarCargo() == false) {
                    Cargo miCargo = new Cargo(Codigo, NombreCargo, Valor);
                    modeloPer.registrarCargo(miCargo);
                    cargarTabla2(vistaPer.jTable_Cargo);
                    limpiarEntrada2();
                }
            }
        }
        if (e.getSource() == vistaPer.btn_Buscar) {
            busquedaPersonalCargo(vistaPer.jT_Cedula1.getText(), vistaPer.jT_Nombre.getText(), vistaPer.jT_Apellido.getText(), ((JTextField) vistaPer.jDate_Fecha1.getDateEditor().getUiComponent()).getText(),
                    vistaPer.jT_Cod_Cargo1.getText(), vistaPer.jT_Cod_Cargo1.getText(), vistaPer.jTable_TurnoEmpleado);
            busquedaTotal(vistaPer.jT_Nombre.getText(), vistaPer.jT_Apellido.getText(),
                    ((JTextField) vistaPer.jDate_Fecha1.getDateEditor().getUiComponent()).getText(),
                    vistaPer.jT_Cod_Cargo1.getText(), vistaPer.Total);
        }
        if (e.getSource() == vistaPer.btn_Actualizar) {
            String Nombre = vistaPer.jT_Nombre.getText();
            String Apellido = vistaPer.jT_Apellido.getText();
            String Celular = vistaPer.jT_Celular.getText();
            String Fecha_N = ((JTextField) vistaPer.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Comentario = vistaPer.jT_Comentario.getText();
            double Calificacion = Double.parseDouble(vistaPer.jT_Calificacion.getText());
            String Id = vistaPer.jT_Cedula.getText();
            Personas persona = new Personas(Id, Nombre, Apellido, Celular, Fecha_N, Comentario, Calificacion);
            if (modeloPer.ActualizarEmpleado(persona) == true) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos del empleado");
                limpiarEntrada();
                cargarTabla(vistaPer.jTable_Empleado);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos del Usuario");
            }
        }
//        if (e.getSource() == vistaPer.btn_Excel1) {
//            try {
//                exportarAExcel(vistaPer.jTable_TurnoEmpleado);
//            } catch (IOException ex) {
//                Logger.getLogger(Controlador_Personal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        if (e.getSource() == vistaPer.btn_Volver) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaPer.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
    }
}
