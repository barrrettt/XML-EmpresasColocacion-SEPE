
package empresacolocacionxmlgenerator;

import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;


public class FrmPrincipal extends javax.swing.JFrame {
    public DatoXml mes = new DatoXml();
    public int indexAccion = -1;
    
    //lista de datos de meses validos
    private ArrayList<String> nombresArchivos = new ArrayList<>();//nombres archivo para lista.
    public ArrayList<ResumenXml> resumenesMensuales = new ArrayList<>();
    public DatoXml año = new DatoXml(); //datos finales
    private File lastArchivePath;
    

    public FrmPrincipal() {
        initComponents();
        //icono form
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/xmlempresascolocacion/recursos/corazon.png"));
        setIconImage(icon);
        
        //edades label
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/xmlempresascolocacion/recursos/logoedadescompostela.png")); 
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lblImagenEdades.setIcon(iconoEscalado);
        
        //listener de lista de acciones
        listAcciones.addListSelectionListener((ListSelectionEvent arg0) -> {
            if (!arg0.getValueIsAdjusting()) {
                indexAccion = listAcciones.getSelectedIndex();
                if (indexAccion!= -1)accionToform();
            }
        });
        
        //listener de lista de archivos
        listArchivosMensuales.addListSelectionListener((ListSelectionEvent arg0) -> {
            if (!arg0.getValueIsAdjusting()) {
                indexAccion = listAcciones.getSelectedIndex();
                if (indexAccion!= -1)changeListaArchivos();
            }
        });
        
        //pop up copiar-pegar en todos los JTextFields
        new JMenuItem (new DefaultEditorKit.CopyAction());
        installContextMenu(this);
        
        //limpiar formulario mes.
        nuevoMes();
        setEnablePanelAccion(false);
        log("Programa iniciado.");
        
        //limpiar año
        nuevoAño();
    }
    
    //add popUpMenuToTextFields aux
    private void installContextMenu(Container comp) {
    for (Component c : comp.getComponents()) {
        if (c instanceof JTextComponent) {
            c.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(final MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        final JTextComponent component = (JTextComponent)e.getComponent();
                        if (!component.isEnabled())return;
                        final JPopupMenu menu = new JPopupMenu();
                        JMenuItem item;
                        item = new JMenuItem(new DefaultEditorKit.CopyAction());
                        item.setText("Copiar");
                        item.setEnabled(component.getSelectionStart() != component.getSelectionEnd());
                        menu.add(item);
                        item = new JMenuItem(new DefaultEditorKit.CutAction());
                        item.setText("Cortar");
                        item.setEnabled(component.isEditable() && component.getSelectionStart() != component.getSelectionEnd());
                        menu.add(item);
                        item = new JMenuItem(new DefaultEditorKit.PasteAction());
                        item.setText("Pegar");
                        item.setEnabled(component.isEditable());
                        menu.add(item);
                        menu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            });
        } else if (c instanceof Container)
            installContextMenu((Container) c);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        tabPanel = new javax.swing.JTabbedPane();
        panelMes = new javax.swing.JPanel();
        panelAccion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelColocacion = new javax.swing.JPanel();
        cbTipoContrato = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIDcontratante = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNombreContratante = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFechaColocacionDia = new javax.swing.JTextField();
        txtFechaColocacionMes = new javax.swing.JTextField();
        txtFechaColocacionYear = new javax.swing.JTextField();
        panelTrabajador = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdTrabajador = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreTrabajador = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido1Trabajador = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido2Trabajador = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        rbMujer = new javax.swing.JRadioButton();
        rbHombre = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        cbNivelFormativo = new javax.swing.JComboBox<>();
        ckDiscapacitado = new javax.swing.JCheckBox();
        ckInmigrante = new javax.swing.JCheckBox();
        ckColocacion = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtNacimientoDia = new javax.swing.JTextField();
        txtNacimientoMes = new javax.swing.JTextField();
        txtNacimientoYear = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lblImageValidAction = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPersonasTotal = new javax.swing.JFormattedTextField();
        txtPersonasPrestacion = new javax.swing.JFormattedTextField();
        txtPersonasInsercion = new javax.swing.JFormattedTextField();
        txtPersonasNuevas = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtOfertasTotales = new javax.swing.JFormattedTextField();
        txtOfertasCubiertas = new javax.swing.JFormattedTextField();
        txtOfertasEnviadas = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtPuestosCubiertos = new javax.swing.JFormattedTextField();
        txtPuestosTotales = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtContratosTotales = new javax.swing.JFormattedTextField();
        txtContratosIndefinidos = new javax.swing.JFormattedTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtPersonasColocadas = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAcciones = new javax.swing.JList<>();
        buNuevaAccion = new javax.swing.JButton();
        buBorrarAccion = new javax.swing.JButton();
        panelAño = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listArchivosMensuales = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        buAddArchivo = new javax.swing.JButton();
        buQuitarArchivo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtPersonasTotalYear = new javax.swing.JFormattedTextField();
        txtPersonasPrestacionYear = new javax.swing.JFormattedTextField();
        txtPersonasInsercionYear = new javax.swing.JFormattedTextField();
        txtPersonasNuevasYear = new javax.swing.JFormattedTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtOfertasTotalesYear = new javax.swing.JFormattedTextField();
        txtOfertasCubiertasYear = new javax.swing.JFormattedTextField();
        txtOfertasEnviadasYear = new javax.swing.JFormattedTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txtPuestosCubiertosYear = new javax.swing.JFormattedTextField();
        txtPuestosTotalesYear = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtContratosTotalesYear = new javax.swing.JFormattedTextField();
        txtContratosIndefinidosYear = new javax.swing.JFormattedTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtPersonasColocadasYear = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        lblImagenEdades = new javax.swing.JLabel();
        buExportar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        txtIdAgencia = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtFechaEnvioYear = new javax.swing.JFormattedTextField();
        txtFechaEnvioMes = new javax.swing.JFormattedTextField();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuCargar = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generador de xml para empresas de colocacion del SEPE");
        setIconImage(getIconImage());
        setIconImages(null);
        setName("frame"); // NOI18N
        setResizable(false);

        tabPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelMes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("DETALLES DE LA ACCION");

        panelColocacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbTipoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indefinido completo", "Indefinido parcial", "determinado completo", "determinado parcial" }));
        cbTipoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        jLabel10.setText("Tipo contrato");

        jLabel11.setText("CIF - NIF Contratante");

        txtIDcontratante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        jLabel13.setText("Razon social de contratante");

        txtNombreContratante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        jLabel9.setText("Fecha colocacion DD MM YYYY");
        jLabel9.setToolTipText("Fecha de colocacion = fecha de inicio de contrato. + Dentro del mes de este documento.");

        txtFechaColocacionDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        txtFechaColocacionMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        txtFechaColocacionYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        javax.swing.GroupLayout panelColocacionLayout = new javax.swing.GroupLayout(panelColocacion);
        panelColocacion.setLayout(panelColocacionLayout);
        panelColocacionLayout.setHorizontalGroup(
            panelColocacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColocacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelColocacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbTipoContrato, 0, 180, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreContratante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIDcontratante)
                    .addComponent(jLabel11)
                    .addGroup(panelColocacionLayout.createSequentialGroup()
                        .addComponent(txtFechaColocacionDia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaColocacionMes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaColocacionYear))
                    .addComponent(jLabel9))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelColocacionLayout.setVerticalGroup(
            panelColocacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColocacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreContratante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDcontratante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColocacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaColocacionDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaColocacionMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaColocacionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTrabajador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("DATOS TRABAJADOR");
        jLabel3.setToolTipText("DNI: 9 numeros + letra control \nNIE: letra + numeros");

        jLabel8.setText("nombre");
        jLabel8.setToolTipText("Longitud max: 15");

        txtNombreTrabajador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        jLabel4.setText("apellido 1");
        jLabel4.setToolTipText("Longitud Max 20");

        txtApellido1Trabajador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        jLabel5.setText("apellido 2");
        jLabel5.setToolTipText("Longitud Max 20");

        txtApellido2Trabajador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        jLabel6.setText("fecha nacimiento DD MM YYYY");

        bgSexo.add(rbMujer);
        rbMujer.setSelected(true);
        rbMujer.setText("Mujer");
        rbMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        bgSexo.add(rbHombre);
        rbHombre.setText("Hombre");
        rbHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        jLabel7.setText("nivel formativo");

        cbNivelFormativo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin estudios", "Nivel Basico", "Estudios Secundarios", "Estudios post-secundarios" }));
        cbNivelFormativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        ckDiscapacitado.setText("Discapacidad");
        ckDiscapacitado.setToolTipText("Porcentaje >= a 33%");
        ckDiscapacitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        ckInmigrante.setText("Inmigrante");
        ckInmigrante.setToolTipText("Por nacionalidad no pertenece a algún país del Espacion Económico Europeo. (UE + Islandia + Liechtenstein + Noruega).");
        ckInmigrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formToData(evt);
            }
        });

        ckColocacion.setForeground(new java.awt.Color(255, 0, 255));
        ckColocacion.setText("COLOCACION");
        ckColocacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckColocacionActionPerformed(evt);
            }
        });

        jLabel12.setText("NIF o NIE");
        jLabel12.setToolTipText("DNI: 9 numeros + letra control \nNIE: letra + numeros");

        txtNacimientoDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        txtNacimientoMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        txtNacimientoYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccionNombreLostFocus(evt);
            }
        });

        javax.swing.GroupLayout panelTrabajadorLayout = new javax.swing.GroupLayout(panelTrabajador);
        panelTrabajador.setLayout(panelTrabajadorLayout);
        panelTrabajadorLayout.setHorizontalGroup(
            panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(cbNivelFormativo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addGroup(panelTrabajadorLayout.createSequentialGroup()
                            .addComponent(ckDiscapacitado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ckInmigrante, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel12))
                    .addComponent(ckColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTrabajadorLayout.createSequentialGroup()
                        .addComponent(rbMujer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbHombre))
                    .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtIdTrabajador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtApellido1Trabajador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtApellido2Trabajador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTrabajadorLayout.createSequentialGroup()
                            .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNacimientoYear, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTrabajadorLayout.setVerticalGroup(
            panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido1Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido2Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacimientoYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbHombre)
                    .addComponent(rbMujer))
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(cbNivelFormativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckDiscapacitado)
                    .addComponent(ckInmigrante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckColocacion)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImageValidAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageValidActionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageValidAction, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageValidAction, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAccionLayout = new javax.swing.GroupLayout(panelAccion);
        panelAccion.setLayout(panelAccionLayout);
        panelAccionLayout.setHorizontalGroup(
            panelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAccionLayout.createSequentialGroup()
                        .addComponent(panelTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAccionLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAccionLayout.setVerticalGroup(
            panelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAccionLayout.createSequentialGroup()
                        .addComponent(panelColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("DATOS AGREGADOS MES (ver web, instrucciones, apartado 6 y 7)");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Total personas atendidas");
        jLabel17.setToolTipText("Personas atendidas = registradas + colocadas.");

        jLabel19.setText("perceptoras de prestacion por desempleo");
        jLabel19.setToolTipText("Persona atendida y beneficiaria de prestaciones o subsidios por desempleo (incluido RAI).");

        jLabel20.setText("pertenecen al colectivo de insercion");
        jLabel20.setToolTipText("De las atendidas. Definicion en las leyes, ver apartado conceptos en la descripción del servicio).");

        jLabel18.setForeground(new java.awt.Color(0, 0, 255));
        jLabel18.setText("Nuevos registros de personas");
        jLabel18.setToolTipText("Necesita 1 accion SIN colocacion.");

        txtPersonasTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasTotal.setText("0");
        txtPersonasTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtPersonasPrestacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasPrestacion.setText("0");
        txtPersonasPrestacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtPersonasInsercion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasInsercion.setText("0");
        txtPersonasInsercion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtPersonasNuevas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasNuevas.setText("0");
        txtPersonasNuevas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasNuevas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasPrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtPersonasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtPersonasNuevas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPersonasPrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPersonasInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.getAccessibleContext().setAccessibleDescription("Personas atendidas = registradas + colocadas. Maximo 1 por persona y mes.");
        jLabel19.getAccessibleContext().setAccessibleDescription("De las atendidas: beneficiaria de prestaciones o subsidios por desempleo (incluido RAI).");

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setText("Total ofertas de trabajo captadas");

        jLabel22.setText("Ofertas cubiertas con personas atendidas");

        jLabel28.setText("Personas enviadas a ofertas");

        txtOfertasTotales.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasTotales.setText("0");
        txtOfertasTotales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtOfertasCubiertas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasCubiertas.setText("0");
        txtOfertasCubiertas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtOfertasEnviadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasEnviadas.setText("0");
        txtOfertasEnviadas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOfertasEnviadas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOfertasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOfertasCubiertas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtOfertasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtOfertasCubiertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtOfertasEnviadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setText("Puestos cubiertos por personas atendidas");

        txtPuestosCubiertos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPuestosCubiertos.setText("0");
        txtPuestosCubiertos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtPuestosTotales.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPuestosTotales.setText("0");
        txtPuestosTotales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        jLabel23.setText("Puestos de trabajo captados");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuestosCubiertos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuestosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtPuestosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtPuestosCubiertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setForeground(new java.awt.Color(255, 0, 255));
        jLabel24.setText("Total contratos suscritos por personas atendidas");
        jLabel24.setToolTipText("Necesita 1 registro con colocacion.");

        jLabel26.setText("Contratos Indefinidos");

        txtContratosTotales.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtContratosTotales.setText("0");
        txtContratosTotales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        txtContratosIndefinidos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtContratosIndefinidos.setText("0");
        txtContratosIndefinidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContratosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContratosIndefinidos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtContratosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtContratosIndefinidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setText("Personas colocadas");

        txtPersonasColocadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasColocadas.setText("0");
        txtPersonasColocadas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modificadoDatosResumen(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersonasColocadas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersonasColocadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("LISTA ACCIONES MES");

        listAcciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Accion 1", "Accion 2", "Accion 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listAcciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listAcciones);

        buNuevaAccion.setText("Nueva accion");
        buNuevaAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buNuevaAccionActionPerformed(evt);
            }
        });

        buBorrarAccion.setText("Borrar");
        buBorrarAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buBorrarAccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buNuevaAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buBorrarAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buNuevaAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buBorrarAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout panelMesLayout = new javax.swing.GroupLayout(panelMes);
        panelMes.setLayout(panelMesLayout);
        panelMesLayout.setHorizontalGroup(
            panelMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        panelMesLayout.setVerticalGroup(
            panelMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
        );

        tabPanel.addTab("Xml mes", panelMes);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listArchivosMensuales.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listArchivosMensuales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listArchivosMensuales.setToolTipText("");
        jScrollPane2.setViewportView(listArchivosMensuales);

        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("XML mensuales");

        buAddArchivo.setText("Añadir Xml");
        buAddArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAddArchivoActionPerformed(evt);
            }
        });

        buQuitarArchivo.setText("Quitar");
        buQuitarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buQuitarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(buAddArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(buQuitarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buQuitarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buAddArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("XML ANUAL");

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel32.setText("Total personas atendidas");

        jLabel33.setText("perceptoras de prestacion por desempleo");

        jLabel34.setText("pertenecen al colectivo de insercion");

        jLabel35.setText("Nuevos registros de personas");

        txtPersonasTotalYear.setEditable(false);
        txtPersonasTotalYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasTotalYear.setText("0");

        txtPersonasPrestacionYear.setEditable(false);
        txtPersonasPrestacionYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasPrestacionYear.setText("0");

        txtPersonasInsercionYear.setEditable(false);
        txtPersonasInsercionYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasInsercionYear.setText("0");

        txtPersonasNuevasYear.setEditable(false);
        txtPersonasNuevasYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasNuevasYear.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasTotalYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasInsercionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasNuevasYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPersonasPrestacionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtPersonasTotalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtPersonasNuevasYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtPersonasPrestacionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtPersonasInsercionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel36.setText("Total ofertas de trabajo captadas");

        jLabel37.setText("Ofertas cubiertas con personas atendidas");

        jLabel38.setText("Personas enviadas a ofertas");

        txtOfertasTotalesYear.setEditable(false);
        txtOfertasTotalesYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasTotalesYear.setText("0");

        txtOfertasCubiertasYear.setEditable(false);
        txtOfertasCubiertasYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasCubiertasYear.setText("0");

        txtOfertasEnviadasYear.setEditable(false);
        txtOfertasEnviadasYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtOfertasEnviadasYear.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOfertasEnviadasYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOfertasTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOfertasCubiertasYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtOfertasTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtOfertasCubiertasYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtOfertasEnviadasYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setText("Puestos cubiertos por personas atendidas");

        txtPuestosCubiertosYear.setEditable(false);
        txtPuestosCubiertosYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPuestosCubiertosYear.setText("0");

        txtPuestosTotalesYear.setEditable(false);
        txtPuestosTotalesYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPuestosTotalesYear.setText("0");

        jLabel40.setText("Puestos de trabajo captados");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuestosCubiertosYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuestosTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtPuestosTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtPuestosCubiertosYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel41.setText("Total contratos suscritos por personas atendidas");

        jLabel42.setText("Contratos Indefinidos");

        txtContratosTotalesYear.setEditable(false);
        txtContratosTotalesYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtContratosTotalesYear.setText("0");

        txtContratosIndefinidosYear.setEditable(false);
        txtContratosIndefinidosYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtContratosIndefinidosYear.setText("0");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContratosTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContratosIndefinidosYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtContratosTotalesYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtContratosIndefinidosYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel43.setText("Personas colocadas");

        txtPersonasColocadasYear.setEditable(false);
        txtPersonasColocadasYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPersonasColocadasYear.setText("0");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(txtPersonasColocadasYear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersonasColocadasYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAñoLayout = new javax.swing.GroupLayout(panelAño);
        panelAño.setLayout(panelAñoLayout);
        panelAñoLayout.setHorizontalGroup(
            panelAñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAñoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAñoLayout.setVerticalGroup(
            panelAñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAñoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabPanel.addTab("Xml anual", panelAño);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane3.setViewportView(txtLog);

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImagenEdades.setForeground(new java.awt.Color(255, 255, 255));
        lblImagenEdades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenEdadesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenEdades, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenEdades, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        buExportar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buExportar.setForeground(new java.awt.Color(255, 0, 0));
        buExportar.setText("GENERAR");
        buExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExportarActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtIdAgencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                datosGeneralesModificados(evt);
            }
        });

        jLabel29.setText("CODIGO AGENCIA COLOCACION");

        jLabel30.setText("FECHA ENVIO (MMYYYY)");
        jLabel30.setToolTipText("Plazo de envio 1 al 25. ");

        try {
            txtFechaEnvioYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaEnvioYear.setText("");
        txtFechaEnvioYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                datosGeneralesModificados(evt);
            }
        });

        try {
            txtFechaEnvioMes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaEnvioMes.setText("");
        txtFechaEnvioMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                datosGeneralesModificados(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(txtIdAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                            .addComponent(txtFechaEnvioMes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaEnvioYear))
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaEnvioYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaEnvioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuArchivo.setMargin(new java.awt.Insets(2, 2, 2, 2));

        menuNuevo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuNuevo.setText("Limpiar datos");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuNuevo);
        menuArchivo.add(jSeparator2);

        menuCargar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuCargar.setText("Importar xml mensual");
        menuCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuCargar);

        menuGuardar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuGuardar.setText("Exportar xml mensual");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuGuardar);
        menuArchivo.add(jSeparator1);

        menuSalir.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        barraMenu.add(menuArchivo);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buNuevaAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buNuevaAccionActionPerformed
        
        AccionXml accNueva = new AccionXml();
        mes.acciones.add(accNueva);
        actualizarListaAcciones();
    }//GEN-LAST:event_buNuevaAccionActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Salir!", JOptionPane.YES_NO_OPTION);
        if (resp==0){
            log("salir");
            System.exit(0);
        }
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Borrar!", JOptionPane.YES_NO_OPTION);
        if (resp==0){
            mes = new DatoXml();
            nuevoMes();
            log("Crear nuevo mes");
        }
    }//GEN-LAST:event_menuNuevoActionPerformed

    private void ckColocacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckColocacionActionPerformed
        formToAccion();
        setEnablePanelColocacion(ckColocacion.isSelected());   
    }//GEN-LAST:event_ckColocacionActionPerformed

    private void formToData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formToData
        formToAccion();
    }//GEN-LAST:event_formToData

    private void txtAccionNombreLostFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccionNombreLostFocus
        formToAccion();        
    }//GEN-LAST:event_txtAccionNombreLostFocus

    private void buBorrarAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buBorrarAccionActionPerformed
        limpiarAccionActual();
        
        int index = listAcciones.getSelectedIndex();
        if (index != -1){
            mes.acciones.remove(index);
            actualizarListaAcciones();
            listAcciones.setSelectedIndex(-1);
            indexAccion = -1;
        }
    }//GEN-LAST:event_buBorrarAccionActionPerformed

    private void buExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExportarActionPerformed
        int index = tabPanel.getSelectedIndex();
        if (index == 0){
            exportarMesActual();
        }else{
            generarAñoXml();
        }
        
    }//GEN-LAST:event_buExportarActionPerformed

    private void modificadoDatosResumen(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_modificadoDatosResumen
        formToResumen();
    }//GEN-LAST:event_modificadoDatosResumen

    private void datosGeneralesModificados(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_datosGeneralesModificados
        formToGeneral();
    }//GEN-LAST:event_datosGeneralesModificados

    private void lblImageValidActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageValidActionMouseClicked
        formToAccion();
    }//GEN-LAST:event_lblImageValidActionMouseClicked

    private void lblImagenEdadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenEdadesMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.sistemanacionalempleo.es/et_comun.html"));
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_lblImagenEdadesMouseClicked

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        int index = tabPanel.getSelectedIndex();
        if (index == 0){
            exportarMesActual();
        }else{
            generarAñoXml();
        }
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void menuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargarActionPerformed
        log("funcion no disponible aun");
    }//GEN-LAST:event_menuCargarActionPerformed

    private void buAddArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAddArchivoActionPerformed
        addArchivo();
    }//GEN-LAST:event_buAddArchivoActionPerformed

    private void buQuitarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buQuitarArchivoActionPerformed
        delArchivo();
    }//GEN-LAST:event_buQuitarArchivoActionPerformed

    
    
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton buAddArchivo;
    private javax.swing.JButton buBorrarAccion;
    private javax.swing.JButton buExportar;
    private javax.swing.JButton buNuevaAccion;
    private javax.swing.JButton buQuitarArchivo;
    private javax.swing.JComboBox<String> cbNivelFormativo;
    private javax.swing.JComboBox<String> cbTipoContrato;
    private javax.swing.JCheckBox ckColocacion;
    private javax.swing.JCheckBox ckDiscapacitado;
    private javax.swing.JCheckBox ckInmigrante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblImageValidAction;
    private javax.swing.JLabel lblImagenEdades;
    private javax.swing.JList<String> listAcciones;
    private javax.swing.JList<String> listArchivosMensuales;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuCargar;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelAccion;
    private javax.swing.JPanel panelAño;
    private javax.swing.JPanel panelColocacion;
    private javax.swing.JPanel panelMes;
    private javax.swing.JPanel panelTrabajador;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JFormattedTextField txtApellido1Trabajador;
    private javax.swing.JFormattedTextField txtApellido2Trabajador;
    private javax.swing.JFormattedTextField txtContratosIndefinidos;
    private javax.swing.JFormattedTextField txtContratosIndefinidosYear;
    private javax.swing.JFormattedTextField txtContratosTotales;
    private javax.swing.JFormattedTextField txtContratosTotalesYear;
    private javax.swing.JTextField txtFechaColocacionDia;
    private javax.swing.JTextField txtFechaColocacionMes;
    private javax.swing.JTextField txtFechaColocacionYear;
    private javax.swing.JFormattedTextField txtFechaEnvioMes;
    private javax.swing.JFormattedTextField txtFechaEnvioYear;
    private javax.swing.JFormattedTextField txtIDcontratante;
    private javax.swing.JTextField txtIdAgencia;
    private javax.swing.JFormattedTextField txtIdTrabajador;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtNacimientoDia;
    private javax.swing.JTextField txtNacimientoMes;
    private javax.swing.JTextField txtNacimientoYear;
    private javax.swing.JFormattedTextField txtNombreContratante;
    private javax.swing.JFormattedTextField txtNombreTrabajador;
    private javax.swing.JFormattedTextField txtOfertasCubiertas;
    private javax.swing.JFormattedTextField txtOfertasCubiertasYear;
    private javax.swing.JFormattedTextField txtOfertasEnviadas;
    private javax.swing.JFormattedTextField txtOfertasEnviadasYear;
    private javax.swing.JFormattedTextField txtOfertasTotales;
    private javax.swing.JFormattedTextField txtOfertasTotalesYear;
    private javax.swing.JFormattedTextField txtPersonasColocadas;
    private javax.swing.JFormattedTextField txtPersonasColocadasYear;
    private javax.swing.JFormattedTextField txtPersonasInsercion;
    private javax.swing.JFormattedTextField txtPersonasInsercionYear;
    private javax.swing.JFormattedTextField txtPersonasNuevas;
    private javax.swing.JFormattedTextField txtPersonasNuevasYear;
    private javax.swing.JFormattedTextField txtPersonasPrestacion;
    private javax.swing.JFormattedTextField txtPersonasPrestacionYear;
    private javax.swing.JFormattedTextField txtPersonasTotal;
    private javax.swing.JFormattedTextField txtPersonasTotalYear;
    private javax.swing.JFormattedTextField txtPuestosCubiertos;
    private javax.swing.JFormattedTextField txtPuestosCubiertosYear;
    private javax.swing.JFormattedTextField txtPuestosTotales;
    private javax.swing.JFormattedTextField txtPuestosTotalesYear;
    // End of variables declaration//GEN-END:variables


    //MES y Acciones
    private void nuevoMes() {
        listAcciones.setSelectedIndex(-1);
        indexAccion = -1;
        
        this.mes.acciones.clear();
        this.mes.resumen = new ResumenXml();
        
        actualizarListaAcciones();
        
        txtPersonasTotal.setText("");
        txtPersonasPrestacion.setText("");
        txtPersonasInsercion.setText("");
        txtPersonasNuevas.setText("");
        
        txtOfertasTotales.setText("");
        txtOfertasEnviadas.setText("");
        txtOfertasCubiertas.setText("");
        
        txtPuestosTotales.setText("");
        txtPuestosCubiertos.setText("");
        
        txtContratosTotales.setText("");
        txtContratosIndefinidos.setText("");
        txtPersonasColocadas.setText("");
    }

    private void actualizarListaAcciones() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i=0;i<this.mes.acciones.size();i++){
            listModel.addElement("Accion " + i);
        }
        
        listAcciones.setModel(listModel);
        indexAccion =  listAcciones.getSelectedIndex();
        setEnablePanelAccion(false);
    }
    
    private void limpiarAccionActual() {
        tabPanel.setSelectedIndex(0);
        txtNombreTrabajador.setText("");
        txtApellido1Trabajador.setText("");
        txtApellido2Trabajador.setText("");
        txtIdTrabajador.setText("");
        
        txtNacimientoDia.setText("");
        txtNacimientoMes.setText("");
        txtNacimientoYear.setText("");
        
        rbHombre.setSelected(false);
        rbMujer.setSelected(true);
        
        cbNivelFormativo.setSelectedIndex(0);
        ckDiscapacitado.setSelected(false);
        ckInmigrante.setSelected(false);
        ckColocacion.setSelected(false);
        
        setEnablePanelColocacion(false);
        txtIDcontratante.setText("");
        txtNombreContratante.setText("");
        txtFechaColocacionDia.setText("");
        txtFechaColocacionMes.setText("");
        txtFechaColocacionYear.setText("");
        cbTipoContrato.setSelectedIndex(0);
    }
    
    private void setEnablePanelAccion (boolean enable){
        //desactiva panel trabajador
        Component[] cHijos = panelTrabajador.getComponents();
        for (int i = 0;i<cHijos.length;i++){
            Component cHijo = panelTrabajador.getComponent(i);
            cHijo.setEnabled(enable);
        }
        if (enable){
            setEnablePanelColocacion(mes.acciones.get(indexAccion).isColocacion());
        }else{
            setEnablePanelColocacion(false);
        }
        
    }
    
    private void setEnablePanelColocacion(boolean enable) {
        //desactiva panel colocacion
        Component[] cHijos = panelColocacion.getComponents();
        for (int i = 0;i<cHijos.length;i++){
            Component cHijo = panelColocacion.getComponent(i);
            cHijo.setEnabled(enable);
        }
    }

    private void log(String info){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String strDate = dateFormat.format(date)+ " ";
        txtLog.setText(strDate + info + "\n");
    }
    
    //FORMULARIO <-> ACCION
    
    public void formToAccion(){
        
        log("guardando en  " + indexAccion );
        
        //id + nombre + nacimiento
        String id = txtIdTrabajador.getText();
        String nombre = txtNombreTrabajador.getText();
        String apell1 = txtApellido1Trabajador.getText();
        String apell2 = txtApellido2Trabajador.getText();
        
        String fnDia = txtNacimientoDia.getText();
        String fnMes = txtNacimientoMes.getText();
        String fnYear = txtNacimientoYear.getText();

        String strNacimiento = fnDia + fnMes + fnYear;
        
        //sexo
        String sexo = "1";
        if (rbMujer.isSelected()) sexo = "2";
        
        //nivel formativo
        String nivelFormativo = "00";
        int index = cbNivelFormativo.getSelectedIndex();
        switch (index){
            case 0: nivelFormativo = "00"; break;
            case 1: nivelFormativo = "10"; break;
            case 2: nivelFormativo = "20"; break;
            case 3: nivelFormativo = "30"; break;
        }
        
        //discapacidad
        String discapacidad = "N";
        if (ckDiscapacitado.isSelected()) discapacidad = "S";
        
        //inmigrante 
        String inmigrante = "N";
        if (ckInmigrante.isSelected()) inmigrante = "S";
        
        //█ COLOCACION
        String colocacion = "N";
        if (ckColocacion.isSelected()) {
            colocacion = "S";
        }
        
        //fecha contrato
        String fcYear = txtFechaColocacionYear.getText();
        String fcMes = txtFechaColocacionMes.getText();
        String fcDia = txtFechaColocacionDia.getText();

        String fechaContrato = fcDia + fcMes + fcYear;

        //tipo contrato
        String tipoContrato = "001";
        index = cbTipoContrato.getSelectedIndex();
        switch (index){
            case 0: tipoContrato = "001"; break;
            case 1: tipoContrato = "003"; break;
            case 2: tipoContrato = "401"; break;
            case 3: tipoContrato = "501"; break;
        }

        //ID contratante
        String iDContratante = txtIDcontratante.getText();

        //nombre contratante
        String nombreContratante = txtNombreContratante.getText();
        
        // █ CREAR CLASE JAVA Y VALIDAR DATOS:
        AccionXml nuevaAccion = new AccionXml();
        String informe;
        if (ckColocacion.isSelected()) {
            informe = nuevaAccion.setData(id,nombre,apell1,apell2,strNacimiento,sexo,nivelFormativo,discapacidad,inmigrante,
                    colocacion,iDContratante,nombreContratante,tipoContrato,fechaContrato);
        }else{
            
            informe = nuevaAccion.setData(id,nombre,apell1,apell2,strNacimiento,sexo,nivelFormativo,discapacidad,inmigrante);
        }
        
        
        if ("".equals(informe)){
            log( "ACCION: "+indexAccion +" OK!");
            mes.acciones.set(indexAccion, nuevaAccion);
            actualizarImagenAccionValidez(true);
        }else{
            log( "ACCION: "+indexAccion +"\n"+ informe);
            actualizarImagenAccionValidez(false);
        }
    }
    
    public void accionToform(){
        setEnablePanelAccion(true);
        AccionXml accion = mes.acciones.get(indexAccion);
        
        txtIdTrabajador.setText(accion.getId());
        txtNombreTrabajador.setText(accion.getName());
        txtApellido1Trabajador.setText(accion.getApell1());
        txtApellido2Trabajador.setText(accion.getApell2());
        
        txtNacimientoDia.setText(String.valueOf(accion.getFnDia()));
        txtNacimientoMes.setText(String.valueOf(accion.getFnMes()));
        txtNacimientoYear.setText(String.valueOf(accion.getFnYear()));
        
        rbHombre.setSelected(accion.isHombre());
        rbMujer.setSelected(!accion.isHombre());
        
        cbNivelFormativo.setSelectedIndex(accion.getNivelFormativo());
        
        ckDiscapacitado.setSelected(accion.isDiscapacitado());
        ckInmigrante.setSelected(accion.isInmigrante());
        
        ColocacionXml c = accion.getColocacionXml();
        if (c!= null || accion.isColocacion()){
            ckColocacion.setSelected(true);
            setEnablePanelColocacion(true);
            
            txtFechaColocacionDia.setText(String.valueOf(c.getFcDia()));
            txtFechaColocacionMes.setText(String.valueOf(c.getFcMes()));
            txtFechaColocacionYear.setText(String.valueOf(c.getFcYear()));
            
            txtNombreContratante.setText(c.getName());
            txtIDcontratante.setText(c.getId());
            
            cbTipoContrato.setSelectedIndex(c.getTipoContrato());
        }else{
            ckColocacion.setSelected(false);
            setEnablePanelColocacion(false);
            txtIDcontratante.setText("");
            txtNombreContratante.setText("");
            txtFechaColocacionDia.setText("");
            txtFechaColocacionMes.setText("");
            txtFechaColocacionYear.setText("");
            cbTipoContrato.setSelectedIndex(0);
        }
        
        actualizarImagenAccionValidez(accion.valido);
    }
    
    //FORMULARIO -> GENERAL
    
    public void formToGeneral(){
        String idColocacion = txtIdAgencia.getText();
        
        String strFeYear = txtFechaEnvioYear.getText();
        String strFeMes = txtFechaEnvioMes.getText();
        
        String fechaEnvio =  strFeMes + strFeYear;
        
     
        //insercion datos:
        String resultado = mes.setDataGeneral(idColocacion, fechaEnvio);
        
        if ("".equals(resultado)){
            log( "DATOS GENERALES: OK!");
            
        }else{
            log( "DATOS GENERALES:\n"+ resultado);
        }
    }
    
    //FORMULARIO -> RESUMEN
    
    public void formToResumen (){
    
        String personasTotal = txtPersonasTotal.getText();
        String personasPrestacion = txtPersonasPrestacion.getText();
        String personasInsercion = txtPersonasInsercion.getText();
        String personasNuevas= txtPersonasNuevas.getText();
        
        String ofertasTotales= txtOfertasTotales.getText();
        String ofertasEnviadas= txtOfertasEnviadas.getText();
        String ofertasCubiertas= txtOfertasCubiertas.getText();
        
        String puestosTotales= txtPuestosTotales.getText();
        String puestosCubiertos= txtPuestosCubiertos.getText();
        
        String contratosTotales = txtContratosTotales.getText();
        String contratosIndefinidos = txtContratosIndefinidos.getText();
        
        String personasColocadas = txtPersonasColocadas.getText();
        
        //insercion datos:
        String resultado = mes.setDataResumen(personasTotal, personasPrestacion, personasInsercion, personasNuevas, 
                ofertasTotales, ofertasEnviadas, ofertasCubiertas,
                puestosTotales,puestosCubiertos,
                contratosTotales,contratosIndefinidos,
                personasColocadas);
        
        if ("".equals(resultado)){
            log( "DATOS RESUMEN: OK!");
            
        }else{
            log( "DATOS RESUMEN:\n"+ resultado);
        }
    }
    
    
    
    //Imgen validacion accion

    private void actualizarImagenAccionValidez(boolean valido) {
        //imagenes
        String strRes = "/empresacolocacionxmlgenerator/recursos/yes.png";
        if (!valido) strRes = "/empresacolocacionxmlgenerator/recursos/no.png";
        
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource(strRes)); 
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        lblImageValidAction.setIcon(iconoEscalado);
    }


//█ to XML.
    private void exportarMesActual() {
        formToGeneral();
        formToResumen();   
        if(!mes.isValid()){
            log("FALLOS ENCONTRADOS!\nrevise acciones, datos resumen y datos generales");
            JOptionPane.showMessageDialog(null, "Documento: FALLO!" );
            return;
        }
        
        //validar
        String strXml = mes.getXml();
        
        //mostrar en dialogo el xml final:
        JTextArea textArea = new JTextArea(40, 40);
        textArea.setText(strXml);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane,"Xml generado",JOptionPane.INFORMATION_MESSAGE);
        
        //file choser
        try{
            JFileChooser fchoser = new JFileChooser();
            if (this.lastArchivePath!= null) fchoser.setCurrentDirectory(lastArchivePath);//ultima ruta
            FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos xml (*.xml)", "xml");//filtro
            fchoser.setFileFilter(filter);
            fchoser.addChoosableFileFilter(filter);
            
            fchoser.showSaveDialog(this);//mostrar

            //getDatos
            File file = fchoser.getSelectedFile();
            
            //gravacion mes
            if(file != null){
                this.lastArchivePath = file.getParentFile();//ultima ruta.
                //a iso 8859-1
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file+".xml"), "8859_1"));
                out.write(strXml);
                out.close();
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente",
                         "Información",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,
                 "Su archivo no se ha guardado",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }

    
    // █████████████████████ PANEL AÑO  █████████████████
    private void changeListaArchivos() {
        
    }

    private void nuevoAño() {
        //datos
        resumenesMensuales = new ArrayList<ResumenXml>();
        nombresArchivos = new ArrayList<String>();
        año = new DatoXml();
        
        //lista visual
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listArchivosMensuales.setModel(listModel);
        
        //textos vacios
        txtPersonasTotalYear.setText("0");
        txtPersonasPrestacionYear.setText("0");
        txtPersonasInsercionYear.setText("0");
        txtPersonasNuevasYear.setText("0");
        
        txtOfertasTotalesYear.setText("0");
        txtOfertasEnviadasYear.setText("0");
        txtOfertasCubiertasYear.setText("0");
        
        txtPuestosTotalesYear.setText("0");
        txtPuestosCubiertosYear.setText("0");
        
        txtContratosTotalesYear.setText("0");
        txtContratosIndefinidosYear.setText("0");
        txtPersonasColocadasYear.setText("0");
    }

    private void addArchivo() {
        String fileName = "";
        String aux = "";   
        String strXml = "";
        try{
         /**preparar filechoser*/
        JFileChooser fchoser = new JFileChooser();
        if (this.lastArchivePath!= null) fchoser.setCurrentDirectory(lastArchivePath);//ultima ruta
        fchoser.setFileFilter(new FileNameExtensionFilter("Archivos XML", "xml"));//filtro *.xml
        
        if (fchoser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION)return;//abrir
        
        //coger datos del filechoser.
        File file = fchoser.getSelectedFile();
        this.lastArchivePath = file.getParentFile();
        fileName = fchoser.getName(file);
        
        //leer el archivo iso8859 1
        if(file != null ){     
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "8859_1"));
            while((aux = br.readLine())!=null){
                strXml+= aux+ "\n";
            }
            br.close();
            }    
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex+"" +
            "\nError lectura!",
            "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
            
        }
        
        //Analizar los datos del xml
        JOptionPane.showMessageDialog(null,strXml,"CONTENIDO ARCHIVO:",JOptionPane.INFORMATION_MESSAGE);
        ResumenXml resumen = ResumenXml.xmlToResumen(strXml);
        
        //validacion
        if (resumen == null){
            JOptionPane.showMessageDialog(null,"Error en el formato del XML!", "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //añadir a lista de datos si valido:
        this.resumenesMensuales.add(resumen);
        this.nombresArchivos.add(fileName);
        
        //añadir dato a lista visual
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i=0;i<this.nombresArchivos.size();i++){
            fileName = nombresArchivos.get(i);
            listModel.addElement(i + ". " + fileName);
        }
        listArchivosMensuales.setModel(listModel);
        
        //construir año
        construirAño();
    }
    
    private void construirAño() {
        año = new DatoXml();
        
        for (ResumenXml r : resumenesMensuales){
            año.resumen.personasTotal += r.personasTotal;
            año.resumen.personasPerceptoras += r.personasPerceptoras;
            año.resumen.personasInsercion += r.personasInsercion;
            año.resumen.personasNuevas += r.personasNuevas;
            
            año.resumen.ofertasTotal += r.ofertasTotal;
            año.resumen.ofertasEnviadas += r.ofertasEnviadas;
            año.resumen.ofertasCubiertas += r.ofertasCubiertas;
            
            año.resumen.puestosTotal += r.puestosTotal;
            año.resumen.puestosCubiertos += r.puestosCubiertos;
            
            año.resumen.contratosTotal += r.contratosTotal;
            año.resumen.contratosIndefinidos += r.contratosIndefinidos;
            año.resumen.personasColocadas += r.personasColocadas;
        }
        
        //mostrar
        
        txtPersonasTotalYear.setText(String.valueOf(año.resumen.personasTotal));
        txtPersonasPrestacionYear.setText(String.valueOf(año.resumen.personasPerceptoras));
        txtPersonasInsercionYear.setText(String.valueOf(año.resumen.personasInsercion));
        txtPersonasNuevasYear.setText(String.valueOf(año.resumen.personasNuevas));
        
        txtOfertasTotalesYear.setText(String.valueOf(año.resumen.ofertasTotal));
        txtOfertasEnviadasYear.setText(String.valueOf(año.resumen.ofertasEnviadas));
        txtOfertasCubiertasYear.setText(String.valueOf(año.resumen.ofertasCubiertas));
        
        txtPuestosTotalesYear.setText(String.valueOf(año.resumen.puestosTotal));
        txtPuestosCubiertosYear.setText(String.valueOf(año.resumen.puestosCubiertos));
        
        txtContratosTotalesYear.setText(String.valueOf(año.resumen.contratosTotal));
        txtContratosIndefinidosYear.setText(String.valueOf(año.resumen.contratosIndefinidos));
        txtPersonasColocadasYear.setText(String.valueOf(año.resumen.personasColocadas));
    }
    
    private void delArchivo() {
        int index = listArchivosMensuales.getSelectedIndex();
        if (index == -1) return;
        
        //borrado de datos
        nombresArchivos.remove(index);
        resumenesMensuales.remove(index);
        
        //actualizar vista de nombre de archivos.
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i=0;i<this.nombresArchivos.size();i++){
            listModel.addElement(i + ". " + nombresArchivos.get(i));
        }
        listArchivosMensuales.setModel(listModel);
        
        //calcular datos resumen año.
        construirAño();
    }

    private void generarAñoXml() {
        //get datos generales que faltan
        String idAgencia = txtIdAgencia.getText();
        String feYear = txtFechaEnvioYear.getText();
        
        String result = año.setDataGeneral(idAgencia, "99"+feYear);
        if (result != ""){
            JOptionPane.showMessageDialog(null, "Xml anual: FALLO EN DATOS FECHA O CODIGO!" );
            return;
        }                
        //get XML (no es necesario validar el resto de datos.)
        
        String strXml = año.getXml();
        
        //mostrar antes de guardar:
        JTextArea textArea = new JTextArea(30, 30);
        textArea.setText(strXml);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane,"Xml anual generado",JOptionPane.INFORMATION_MESSAGE);
        
        //file choser
        try{
            JFileChooser fchoser = new JFileChooser();
            if (this.lastArchivePath!= null) fchoser.setCurrentDirectory(lastArchivePath);//ultima ruta
            FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos xml (*.xml)", "xml");//filtro
            fchoser.setFileFilter(filter);            
            fchoser.addChoosableFileFilter(filter);
            
            fchoser.showSaveDialog(this);//mostrar

            //getDatos
            File file = fchoser.getSelectedFile();
            

            if(file !=null){
                this.lastArchivePath = file.getParentFile();//para recordar rutas visitadas.

                //a iso 8859-1
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file+".xml"), "8859_1"));
                out.write(strXml);
                out.close();
                
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente",
                         "Información",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,
                 "Su archivo no se ha guardado",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

    
    
}//fin form
