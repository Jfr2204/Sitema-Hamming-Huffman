package Main;

import FuncionesAuxiliares.FuncionesAuxiliares;
import Hamming.Hamming;
import Huffman.Huffman;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class mainFrame extends javax.swing.JFrame {
    
    public static File archivoACodificar;
    public static File archivoADecodificar;
    public static File archivoAComprimir;
    public static File archivoADescomprimir;
    public static File salida;
    public static File codigosHuffman;
    public Huffman huffman;
    public static int longitud = 0;
    public static ArrayList<int[]> indicesComboBoxesCod;
    public static ArrayList<Integer> indicesComboBoxErroresDecod;
    
    public mainFrame() {
        initComponents();
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        panelHamming.setVisible(false);
        panelHuffman.setVisible(false);
        
        indicesComboBoxesCod = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonHamming = new javax.swing.JButton();
        botonHuffman = new javax.swing.JButton();
        panelHamming = new javax.swing.JTabbedPane();
        panelCodificacion = new javax.swing.JPanel();
        panelCodificacion_BotonSeleccionarArchivo = new javax.swing.JButton();
        etiquetaTipo = new javax.swing.JLabel();
        comboBoxCodificacion = new javax.swing.JComboBox<>();
        panelCodificacion_EtiquetaErrores = new javax.swing.JLabel();
        panelCodificacion_ComboBoxErrores = new javax.swing.JComboBox<>();
        panelCodificacion_TextFieldUbicacionOriginal = new javax.swing.JTextField();
        panelCodificacion_TextFieldUbicacionFinal = new javax.swing.JTextField();
        panelCodificacion_ScrollPane1 = new javax.swing.JScrollPane();
        panelCodificacion_TextPaneArchivoOriginal = new javax.swing.JTextPane();
        panelCodificacion_ScrollPane2 = new javax.swing.JScrollPane();
        panelCodificacion_TextPaneArchivoFinal = new javax.swing.JTextPane();
        botonCodificar = new javax.swing.JButton();
        panelCodificacion_BotonRegresar = new javax.swing.JButton();
        panelDecodificación = new javax.swing.JPanel();
        paneDecodificacion_BotonSeleccionarArchivo = new javax.swing.JButton();
        panelDecodificacion_EtiquetaErrores = new javax.swing.JLabel();
        panelDecodificacion_ComboBoxErrores = new javax.swing.JComboBox<>();
        panelDecodificacion_TextFieldUbicacionOriginal = new javax.swing.JTextField();
        panelDecodificacion_TextFieldUbicacionFinal = new javax.swing.JTextField();
        panelDecodificacion_ScrollPane1 = new javax.swing.JScrollPane();
        panelDecodificacion_TextPaneArchivoOriginal = new javax.swing.JTextPane();
        panelDecodificacion_ScrollPane2 = new javax.swing.JScrollPane();
        panelDecodificacion_TextPaneArchivoFinal = new javax.swing.JTextPane();
        botonDecodificar = new javax.swing.JButton();
        panelDecodificacion_BotonRegresar = new javax.swing.JButton();
        panelHuffman = new javax.swing.JTabbedPane();
        panelCompresion = new javax.swing.JPanel();
        panelCompresion_BotonSeleccionarArchivo = new javax.swing.JButton();
        botonComprimir = new javax.swing.JButton();
        panelCompresion_TextFieldUbicacionOriginal = new javax.swing.JTextField();
        panelCompresion_TextFieldUbicacionFinal = new javax.swing.JTextField();
        panelCompresion_ScrollPane1 = new javax.swing.JScrollPane();
        panelCompresion_TextPaneArchivoOriginal = new javax.swing.JTextPane();
        panelCompresion_ScrollPane2 = new javax.swing.JScrollPane();
        panelCompresion_TextPaneArchivoFinal = new javax.swing.JTextPane();
        panelCompresion_BotonRegresar = new javax.swing.JToggleButton();
        panelDescompresion = new javax.swing.JPanel();
        panelDescompresion_BotonSeleccionarArchivo = new javax.swing.JButton();
        botonDescomprimir = new javax.swing.JButton();
        panelDescompresion_TextFieldUbicacionOriginal = new javax.swing.JTextField();
        panelDescompresion_TextFieldUbicacionFinal = new javax.swing.JTextField();
        panelDescompresion_ScrollPane1 = new javax.swing.JScrollPane();
        panelDescompresion_TextPaneArchivoOriginal = new javax.swing.JTextPane();
        panelDescompresion_ScrollPane2 = new javax.swing.JScrollPane();
        panelDescompresion_TextPaneArchivoFinal = new javax.swing.JTextPane();
        panelDescompresion_BotonRegresar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setMinimumSize(new java.awt.Dimension(400, 300));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Proyecto Hamming - Huffman");

        botonHamming.setText("Codificación / Decodificación");
        botonHamming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHammingActionPerformed(evt);
            }
        });

        botonHuffman.setText("Compresión / Descompresión");
        botonHuffman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHuffmanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonHuffman, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(botonHamming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(83, 83, 83))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonHamming)
                .addGap(55, 55, 55)
                .addComponent(botonHuffman))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        panelHamming.setMinimumSize(new java.awt.Dimension(1000, 600));
        panelHamming.setPreferredSize(new java.awt.Dimension(1000, 600));

        panelCodificacion_BotonSeleccionarArchivo.setText("Seleccionar archivo");
        panelCodificacion_BotonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCodificacion_BotonSeleccionarArchivoActionPerformed(evt);
            }
        });

        etiquetaTipo.setText("Tipo de codificación: ");

        comboBoxCodificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8 bits", "256 bits", "8192 bits", "262144 bits" }));
        comboBoxCodificacion.setToolTipText("");
        comboBoxCodificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCodificacionActionPerformed(evt);
            }
        });

        panelCodificacion_EtiquetaErrores.setText("¿Generación de errores?");

        panelCodificacion_ComboBoxErrores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "si" }));
        panelCodificacion_ComboBoxErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCodificacion_ComboBoxErroresActionPerformed(evt);
            }
        });

        panelCodificacion_TextFieldUbicacionOriginal.setEditable(false);
        panelCodificacion_TextFieldUbicacionOriginal.setText("Archivo original");

        panelCodificacion_TextFieldUbicacionFinal.setEditable(false);
        panelCodificacion_TextFieldUbicacionFinal.setText("Archivo codificado");

        panelCodificacion_ScrollPane1.setMinimumSize(new java.awt.Dimension(350, 370));
        panelCodificacion_ScrollPane1.setPreferredSize(new java.awt.Dimension(350, 370));

        panelCodificacion_TextPaneArchivoOriginal.setEditable(false);
        panelCodificacion_ScrollPane1.setViewportView(panelCodificacion_TextPaneArchivoOriginal);

        panelCodificacion_ScrollPane2.setMinimumSize(new java.awt.Dimension(350, 370));
        panelCodificacion_ScrollPane2.setPreferredSize(new java.awt.Dimension(350, 370));

        panelCodificacion_TextPaneArchivoFinal.setEditable(false);
        panelCodificacion_ScrollPane2.setViewportView(panelCodificacion_TextPaneArchivoFinal);

        botonCodificar.setText("Codificar archivo");
        botonCodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCodificarActionPerformed(evt);
            }
        });

        panelCodificacion_BotonRegresar.setText("Regresar al menú principal");
        panelCodificacion_BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCodificacion_BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodificacionLayout = new javax.swing.GroupLayout(panelCodificacion);
        panelCodificacion.setLayout(panelCodificacionLayout);
        panelCodificacionLayout.setHorizontalGroup(
            panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodificacionLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCodificacionLayout.createSequentialGroup()
                        .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCodificacion_ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCodificacion_ScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCodificacion_BotonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCodificacionLayout.createSequentialGroup()
                        .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCodificacion_TextFieldUbicacionOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCodificacion_BotonSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCodificacionLayout.createSequentialGroup()
                                .addComponent(etiquetaTipo)
                                .addGap(50, 50, 50)
                                .addComponent(comboBoxCodificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCodificacionLayout.createSequentialGroup()
                                .addComponent(panelCodificacion_EtiquetaErrores)
                                .addGap(33, 33, 33)
                                .addComponent(panelCodificacion_ComboBoxErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelCodificacion_TextFieldUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
        );
        panelCodificacionLayout.setVerticalGroup(
            panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodificacionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCodificacion_BotonSeleccionarArchivo)
                    .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaTipo)
                        .addComponent(comboBoxCodificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelCodificacion_ComboBoxErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCodificacion_EtiquetaErrores))
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCodificacionLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelCodificacion_TextFieldUbicacionOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCodificacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCodificacion_TextFieldUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCodificacion_ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCodificacion_ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCodificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelCodificacion_BotonRegresar)
                    .addComponent(botonCodificar)))
        );

        panelHamming.addTab("Codificación", panelCodificacion);

        paneDecodificacion_BotonSeleccionarArchivo.setText("Seleccionar archivo");
        paneDecodificacion_BotonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paneDecodificacion_BotonSeleccionarArchivoActionPerformed(evt);
            }
        });

        panelDecodificacion_EtiquetaErrores.setText("¿Corrección de errores?");

        panelDecodificacion_ComboBoxErrores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        panelDecodificacion_ComboBoxErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelDecodificacion_ComboBoxErroresActionPerformed(evt);
            }
        });

        panelDecodificacion_TextFieldUbicacionOriginal.setEditable(false);
        panelDecodificacion_TextFieldUbicacionOriginal.setText("Archivo original");

        panelDecodificacion_TextFieldUbicacionFinal.setEditable(false);
        panelDecodificacion_TextFieldUbicacionFinal.setText("Archivo decodificado");

        panelDecodificacion_ScrollPane1.setMinimumSize(new java.awt.Dimension(350, 370));
        panelDecodificacion_ScrollPane1.setPreferredSize(new java.awt.Dimension(350, 370));

        panelDecodificacion_TextPaneArchivoOriginal.setEditable(false);
        panelDecodificacion_ScrollPane1.setViewportView(panelDecodificacion_TextPaneArchivoOriginal);

        panelDecodificacion_ScrollPane2.setMinimumSize(new java.awt.Dimension(350, 370));
        panelDecodificacion_ScrollPane2.setPreferredSize(new java.awt.Dimension(350, 370));

        panelDecodificacion_TextPaneArchivoFinal.setEditable(false);
        panelDecodificacion_ScrollPane2.setViewportView(panelDecodificacion_TextPaneArchivoFinal);

        botonDecodificar.setText("Decodificar archivo");
        botonDecodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDecodificarActionPerformed(evt);
            }
        });

        panelDecodificacion_BotonRegresar.setText("Regresar al menú principal");
        panelDecodificacion_BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelDecodificacion_BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDecodificaciónLayout = new javax.swing.GroupLayout(panelDecodificación);
        panelDecodificación.setLayout(panelDecodificaciónLayout);
        panelDecodificaciónLayout.setHorizontalGroup(
            panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDecodificaciónLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonDecodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDecodificacion_ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDecodificacion_TextFieldUbicacionOriginal)
                    .addComponent(paneDecodificacion_BotonSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDecodificacion_ComboBoxErrores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelDecodificacion_EtiquetaErrores)
                        .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelDecodificacion_TextFieldUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDecodificacion_ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDecodificacion_BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
        );
        panelDecodificaciónLayout.setVerticalGroup(
            panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDecodificaciónLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paneDecodificacion_BotonSeleccionarArchivo)
                    .addComponent(panelDecodificacion_EtiquetaErrores)
                    .addComponent(panelDecodificacion_ComboBoxErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelDecodificacion_TextFieldUbicacionOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDecodificacion_TextFieldUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDecodificacion_ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDecodificacion_ScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDecodificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelDecodificacion_BotonRegresar)
                    .addComponent(botonDecodificar))
                .addGap(16, 16, 16))
        );

        panelHamming.addTab("Decodificación", panelDecodificación);

        getContentPane().add(panelHamming, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelHuffman.setMinimumSize(new java.awt.Dimension(1000, 600));
        panelHuffman.setPreferredSize(new java.awt.Dimension(1000, 600));

        panelCompresion_BotonSeleccionarArchivo.setText("Seleccionar archivo");
        panelCompresion_BotonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCompresion_BotonSeleccionarArchivoActionPerformed(evt);
            }
        });

        botonComprimir.setText("Comprimir archivo");
        botonComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprimirActionPerformed(evt);
            }
        });

        panelCompresion_TextFieldUbicacionOriginal.setEditable(false);
        panelCompresion_TextFieldUbicacionOriginal.setText("Archivo original");

        panelCompresion_TextFieldUbicacionFinal.setEditable(false);
        panelCompresion_TextFieldUbicacionFinal.setText("Archivo comprimido");

        panelCompresion_ScrollPane1.setMinimumSize(new java.awt.Dimension(350, 370));
        panelCompresion_ScrollPane1.setPreferredSize(new java.awt.Dimension(350, 370));

        panelCompresion_TextPaneArchivoOriginal.setEditable(false);
        panelCompresion_ScrollPane1.setViewportView(panelCompresion_TextPaneArchivoOriginal);

        panelCompresion_ScrollPane2.setMinimumSize(new java.awt.Dimension(350, 370));
        panelCompresion_ScrollPane2.setPreferredSize(new java.awt.Dimension(350, 370));

        panelCompresion_TextPaneArchivoFinal.setEditable(false);
        panelCompresion_ScrollPane2.setViewportView(panelCompresion_TextPaneArchivoFinal);

        panelCompresion_BotonRegresar.setText("Regresar al menú principal");
        panelCompresion_BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCompresion_BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCompresionLayout = new javax.swing.GroupLayout(panelCompresion);
        panelCompresion.setLayout(panelCompresionLayout);
        panelCompresionLayout.setHorizontalGroup(
            panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompresionLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCompresion_TextFieldUbicacionOriginal)
                    .addComponent(panelCompresion_BotonSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCompresion_ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCompresion_ScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCompresion_TextFieldUbicacionFinal)
                    .addComponent(botonComprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompresionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCompresion_BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        panelCompresionLayout.setVerticalGroup(
            panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompresionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelCompresion_BotonSeleccionarArchivo)
                    .addComponent(botonComprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCompresion_TextFieldUbicacionFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(panelCompresion_TextFieldUbicacionOriginal))
                .addGap(18, 18, 18)
                .addGroup(panelCompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCompresion_ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCompresion_ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelCompresion_BotonRegresar)
                .addGap(16, 16, 16))
        );

        panelHuffman.addTab("Compresión", panelCompresion);

        panelDescompresion_BotonSeleccionarArchivo.setText("Seleccionar archivo");
        panelDescompresion_BotonSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelDescompresion_BotonSeleccionarArchivoActionPerformed(evt);
            }
        });

        botonDescomprimir.setText("Descomprimir archivo");
        botonDescomprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescomprimirActionPerformed(evt);
            }
        });

        panelDescompresion_TextFieldUbicacionOriginal.setEditable(false);
        panelDescompresion_TextFieldUbicacionOriginal.setText("Archivo original");

        panelDescompresion_TextFieldUbicacionFinal.setEditable(false);
        panelDescompresion_TextFieldUbicacionFinal.setText("Archivo descomprimido");

        panelDescompresion_ScrollPane1.setMinimumSize(new java.awt.Dimension(350, 370));
        panelDescompresion_ScrollPane1.setPreferredSize(new java.awt.Dimension(350, 370));

        panelDescompresion_TextPaneArchivoOriginal.setEditable(false);
        panelDescompresion_ScrollPane1.setViewportView(panelDescompresion_TextPaneArchivoOriginal);

        panelDescompresion_ScrollPane2.setMinimumSize(new java.awt.Dimension(350, 370));
        panelDescompresion_ScrollPane2.setPreferredSize(new java.awt.Dimension(350, 370));

        panelDescompresion_TextPaneArchivoFinal.setEditable(false);
        panelDescompresion_ScrollPane2.setViewportView(panelDescompresion_TextPaneArchivoFinal);

        panelDescompresion_BotonRegresar.setText("Regresar al menú principal");
        panelDescompresion_BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelDescompresion_BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDescompresionLayout = new javax.swing.GroupLayout(panelDescompresion);
        panelDescompresion.setLayout(panelDescompresionLayout);
        panelDescompresionLayout.setHorizontalGroup(
            panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescompresionLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDescompresion_TextFieldUbicacionOriginal)
                    .addComponent(panelDescompresion_BotonSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDescompresion_ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDescompresion_ScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDescompresion_TextFieldUbicacionFinal)
                    .addComponent(botonDescomprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDescompresionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDescompresion_BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        panelDescompresionLayout.setVerticalGroup(
            panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDescompresionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelDescompresion_BotonSeleccionarArchivo)
                    .addComponent(botonDescomprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDescompresion_TextFieldUbicacionFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(panelDescompresion_TextFieldUbicacionOriginal))
                .addGap(18, 18, 18)
                .addGroup(panelDescompresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDescompresion_ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDescompresion_ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelDescompresion_BotonRegresar)
                .addGap(16, 16, 16))
        );

        panelHuffman.addTab("Descompresión", panelDescompresion);

        getContentPane().add(panelHuffman, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonHammingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHammingActionPerformed
        this.setSize(1000, 630);
        this.setLocationRelativeTo(null);
        panelPrincipal.setVisible(false);
        panelHamming.setVisible(true);
    }//GEN-LAST:event_botonHammingActionPerformed

    private void botonHuffmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHuffmanActionPerformed
        this.setSize(1000, 630);
        this.setLocationRelativeTo(null);
        panelPrincipal.setVisible(false);
        panelHuffman.setVisible(true);
    }//GEN-LAST:event_botonHuffmanActionPerformed
    
    private void panelCodificacion_BotonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCodificacion_BotonSeleccionarArchivoActionPerformed
        limpiarPanelCodificacion();
        botonCodificar.setEnabled(true);
        indicesComboBoxesCod = new ArrayList<>();
        
        //Selección del archivo.
        archivoACodificar = FuncionesAuxiliares.seleccionarArchivo();
        
        if(archivoACodificar != null){
            
            //Se muestra en el textField la dirección del archivo.
            panelCodificacion_TextFieldUbicacionOriginal.setText(archivoACodificar.getAbsolutePath());
            
            try {
                
                //Se muestra en el textPane el contenido del archivo.
                panelCodificacion_TextPaneArchivoOriginal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(archivoACodificar.getAbsolutePath()));
            
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_panelCodificacion_BotonSeleccionarArchivoActionPerformed

    private void limpiarPanelCodificacion(){
        panelCodificacion_TextFieldUbicacionOriginal.setText("Archivo Original");
        panelCodificacion_TextPaneArchivoOriginal.setText("");
        panelCodificacion_TextFieldUbicacionFinal.setText("Archivo Final");
        panelCodificacion_TextPaneArchivoFinal.setText("");
        comboBoxCodificacion.setSelectedIndex(0);
        panelCodificacion_ComboBoxErrores.setSelectedIndex(0);
    }
       
    private void botonCodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCodificarActionPerformed
        if(archivoACodificar != null){
            Hamming.reiniciarVariables();
            int numeroHamming = 0;
            boolean error;
            switch(comboBoxCodificacion.getSelectedIndex()){
                case 0 -> {numeroHamming = 8;}
                case 1 -> {numeroHamming = 256;}
                case 2 -> {numeroHamming = 8192;}
                case 3 -> {numeroHamming = 262144;}
            }
            if(panelCodificacion_ComboBoxErrores.getSelectedIndex() == 0){
                
                //Creación del archivo con formato 'HA'.
                salida = FuncionesAuxiliares.crearArchivoHamming(archivoACodificar, 0, numeroHamming);
                error = false;
            }
            else{
                
                //Creación del archivo con formato 'HE'.
                salida = FuncionesAuxiliares.crearArchivoHamming(archivoACodificar, 1, numeroHamming);
                error = true;
            }
            try {
                
                //Codificación del archivo.
                Hamming.generarBloques(archivoACodificar, salida, numeroHamming, error);
                
                //Se muestra en el textField la dirección del archivo.
                panelCodificacion_TextFieldUbicacionFinal.setText(salida.getAbsolutePath());
                
                //Se muestra en el textPane el contenido del archivo.
                panelCodificacion_TextPaneArchivoFinal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(salida.getAbsolutePath()));
                
                //Se añade a una ArrayList el par formado por los índices de los JComboBoxes.
                int par[] = {comboBoxCodificacion.getSelectedIndex(), panelCodificacion_ComboBoxErrores.getSelectedIndex()};
                indicesComboBoxesCod.add(par);
                
                botonCodificar.setEnabled(false);
                mostrarEstadisticasHamming();
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione un archivo", "Archivo no seleccionado", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_botonCodificarActionPerformed

    private void mostrarEstadisticasHamming(){
        long tamañoArchivoOriginal = archivoACodificar.length();
        long tamañoArchivoCodificado = salida.length();
        double porcentajeIncremento = ((double) tamañoArchivoCodificado / (double) tamañoArchivoOriginal) * 100;
        
        //Variable de tipo DecimalFormat para mostrar solo dos decimales de una variable double.
        DecimalFormat df = new DecimalFormat("#.00");
        JOptionPane.showMessageDialog(null,
                
                "¡Se ha codificado el archivo!\n" +
                "\nTamaño del archivo original: " + tamañoArchivoOriginal + " bytes" +
                "\nTamaño del archivo codificado: " + tamañoArchivoCodificado + " bytes" +
                "\nTamaño del archivo codificado respecto del original = " + df.format(porcentajeIncremento) + "%" +
                "\nCantidad de bloques: " + Hamming.cantidadBloques +
                "\nCantidad de bits de informacion: " + tamañoArchivoOriginal * 8 + " bits" + 
                "\nCantidad de errores introducidos: " + Hamming.cantidadErrores +
                "\nCantidad de bits agregados: " + Hamming.cantidadBitsAgregados,
                
                "Codificación exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void panelCodificacion_BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCodificacion_BotonRegresarActionPerformed
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        panelHamming.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_panelCodificacion_BotonRegresarActionPerformed

    private void paneDecodificacion_BotonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paneDecodificacion_BotonSeleccionarArchivoActionPerformed
        limpiarPanelDecodificacion();
        longitud = 0;
        botonDecodificar.setEnabled(true);
        indicesComboBoxErroresDecod = new ArrayList<>();

        //Selección del archivo.
        archivoADecodificar = FuncionesAuxiliares.seleccionarArchivo();
        
        if(archivoADecodificar != null){
            
            //La extensión es correcta.
            if(FuncionesAuxiliares.controlarExtensionHamming(archivoADecodificar.getName())) {
                
                //Se muestra en el textField la dirección del archivo.
                panelDecodificacion_TextFieldUbicacionOriginal.setText(archivoADecodificar.getAbsolutePath());
                try {

                    //Se muestra en el textPane el contenido del archivo.
                    panelDecodificacion_TextPaneArchivoOriginal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(archivoADecodificar.getAbsolutePath()));
                } catch (IOException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //La extensión no es correcta.
            else{
                
                //Creación de un JOptionPane que le pregunta al usuario si desea realizar la codificación de todos modos.
                String[] opciones = new String[] {"Si", "No"};
                int respuesta = JOptionPane.showOptionDialog(null, "Las extensiones válidas son 'HA8', 'HA256', 'HA8144', 'HA262144', 'HE8', 'HE256', 'HE8144' y 'HE262144'.\n\n¿Desea decodificar el archivo de todos modos?", "Extensión inválida", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);
               
                if (respuesta == JOptionPane.YES_OPTION){ 

                    /*  Creación de un JOptionPane donde el usuario selecciona la longitud de los códigos. Como el archivo seleccionado
                        no tiene extensión del tipo 'HE256' por ejemplo, es necesario seleccionar la longitud de los códigos de manera manual. */
                    String bloque = (String) JOptionPane.showInputDialog(null, "Seleccione la longitud de código. Para obtener el mensaje original,\nla longitud elegida debe ser la misma que la que se usó para la codificación.", 
                                                                "Longitud de código", JOptionPane.INFORMATION_MESSAGE, null, new Object [] {"8 bits", "256 bits", "8192 bits", "262144 bits"}, "");

                    if(bloque == null){
                        bloque = "";
                    }
                                                             
                    //Selección de la longitud de los códigos.
                    switch(bloque){
                        case "8 bits" -> {longitud = 8;}
                        case "256 bits" -> {longitud = 256;}
                        case "8192 bits" -> {longitud = 8192;}
                        case "262144 bits" -> {longitud = 262144;}
                        default -> {archivoADecodificar = null; return;}
                    }
                    
                    //Se muestra en el textField la dirección del archivo.
                    panelDecodificacion_TextFieldUbicacionOriginal.setText(archivoADecodificar.getAbsolutePath());
                    try {

                        //Se muestra en el textPane el contenido del archivo.
                        panelDecodificacion_TextPaneArchivoOriginal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(archivoADecodificar.getAbsolutePath()));
                    } catch (IOException ex) {
                        Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                } else 
                    archivoADecodificar = null;
            }
        }
    }//GEN-LAST:event_paneDecodificacion_BotonSeleccionarArchivoActionPerformed

    private void limpiarPanelDecodificacion(){
        panelDecodificacion_TextFieldUbicacionOriginal.setText("Archivo Original");
        panelDecodificacion_TextPaneArchivoOriginal.setText("");
        panelDecodificacion_TextFieldUbicacionFinal.setText("Archivo Final");
        panelDecodificacion_TextPaneArchivoFinal.setText("");
        panelDecodificacion_ComboBoxErrores.setSelectedIndex(0);
    }
    
    private void botonDecodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDecodificarActionPerformed
        if(archivoADecodificar != null){
            int numeroHamming;
            if(longitud != 0)
                numeroHamming = longitud;
            else
                numeroHamming = FuncionesAuxiliares.devolverExtensionHamming(archivoADecodificar.getName());
            boolean errores;
            String mensaje;
            if(panelDecodificacion_ComboBoxErrores.getSelectedIndex() == 0){
                
                //Creación del archivo con formato 'DC'.
                salida = FuncionesAuxiliares.crearArchivoHamming(archivoADecodificar, 3, numeroHamming);
                errores = true;
            }
            else{
                
                //Creación del archivo con formato 'DE'.
                salida = FuncionesAuxiliares.crearArchivoHamming(archivoADecodificar, 2, numeroHamming);
                errores = false;
            }
            try {
                
                //Decodificación del archivo.
                Hamming.obtenerBloques(archivoADecodificar, salida, numeroHamming, errores);
                
                //Se muestra en el textField la dirección del archivo.
                panelDecodificacion_TextFieldUbicacionFinal.setText(salida.getAbsolutePath());
                
                //Se muestra en el textPane el contenido del archivo.
                panelDecodificacion_TextPaneArchivoFinal.setText(FuncionesAuxiliares.lecturaArchivoSalida(salida.getAbsolutePath()));
            
                //Se añade el índice del JComboBox al ArrayList.
                indicesComboBoxErroresDecod.add(panelDecodificacion_ComboBoxErrores.getSelectedIndex());
                
                botonDecodificar.setEnabled(false);
                if(errores)
                    mensaje = "¡Se ha decodificado el archivo!\n\nSe han corregido " + Hamming.erroresCorregidos + " errores.";
                else
                    mensaje = "¡Se ha decodificado el archivo!";
                JOptionPane.showMessageDialog(null, mensaje, "Decodificación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione un archivo.", "Archivo no seleccionado", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_botonDecodificarActionPerformed

    private void panelDecodificacion_BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelDecodificacion_BotonRegresarActionPerformed
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        panelHamming.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_panelDecodificacion_BotonRegresarActionPerformed

    private void panelCompresion_BotonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCompresion_BotonSeleccionarArchivoActionPerformed
        limpiarPanelCompresion();
        botonComprimir.setEnabled(true);

        //Selección del archivo.
        archivoAComprimir = FuncionesAuxiliares.seleccionarArchivo();
        
        if(archivoAComprimir != null){
            
            //Se muestra en el textField la dirección del archivo.
            panelCompresion_TextFieldUbicacionOriginal.setText(archivoAComprimir.getAbsolutePath());
            try {
                
                //Se muestra en el textPane el contenido del archivo.
                panelCompresion_TextPaneArchivoOriginal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(archivoAComprimir.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_panelCompresion_BotonSeleccionarArchivoActionPerformed

    private void limpiarPanelCompresion(){
        panelCompresion_TextFieldUbicacionOriginal.setText("Archivo Original");
        panelCompresion_TextPaneArchivoOriginal.setText("");
        panelCompresion_TextFieldUbicacionFinal.setText("Archivo Final");
        panelCompresion_TextPaneArchivoFinal.setText("");
    }
    
    private void botonComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprimirActionPerformed
        if(archivoAComprimir != null){
            
            //Creación del archivo con formato 'huf'.
            salida = FuncionesAuxiliares.crearArchivoHuffman(archivoAComprimir, "huf");
            
            //Creación del archivo con formato 'txt' (Códigos de Huffman).
            codigosHuffman = FuncionesAuxiliares.crearArchivoHuffman(archivoAComprimir, "txt");
            
            //Declaración de un ArrayList de tipo byte que contendrá los bytes del archivo.
            ArrayList <Byte> bytes;
            try {
                bytes = FuncionesAuxiliares.lecturaArchivoEnBytes(archivoAComprimir);
                huffman = new Huffman(bytes);
                
                //Compresión del archivo.
                huffman.comprimir(salida);
                
                //Se muestra en el textField la dirección del archivo.
                panelCompresion_TextFieldUbicacionFinal.setText(salida.getAbsolutePath());
                
                //Se muestra en el textPane el contenido del archivo.
                panelCompresion_TextPaneArchivoFinal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(salida.getAbsolutePath()));
                
                //Se escriben los códigos de Huffman en un archivo.
                huffman.escribirCodigosEnArchivo(codigosHuffman);
                
                mostrarEstadisticasHuffman();
                botonComprimir.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione un archivo", "Archivo no seleccionado", JOptionPane.WARNING_MESSAGE);            
    }//GEN-LAST:event_botonComprimirActionPerformed

    private void mostrarEstadisticasHuffman(){
        long tamañoArchivoOriginal = archivoAComprimir.length();
        long tamañoArchivoComprimido = salida.length();
        long cantCaracteresDistintos = FuncionesAuxiliares.contarCantidadCaracteresDistintos(panelCompresion_TextPaneArchivoOriginal.getText());
        double porcentajeDecremento = ((double) tamañoArchivoComprimido / (double) tamañoArchivoOriginal) * 100;
        
        //Variable de tipo DecimalFormat para mostrar solo dos decimales de una variable double.
        DecimalFormat df = new DecimalFormat("#.00");
        JOptionPane.showMessageDialog(null,
                
                "¡Se ha comprimido el archivo!\n" +
                "\nTamaño del archivo original: " + tamañoArchivoOriginal + " bytes" +
                "\nCantidad de caracteres distintos: " + cantCaracteresDistintos + " caracteres" +
                "\nTamaño del archivo comprimido: " + tamañoArchivoComprimido + " bytes" +
                "\nTamaño del archivo comprimido respecto del original = " + df.format(porcentajeDecremento) + "%",
                
                "Compresión exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void panelCompresion_BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCompresion_BotonRegresarActionPerformed
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        panelHuffman.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_panelCompresion_BotonRegresarActionPerformed

    private void panelDescompresion_BotonSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelDescompresion_BotonSeleccionarArchivoActionPerformed
        limpiarPanelDescompresion();
        botonDescomprimir.setEnabled(true);
        
        //Selección del archivo.
        archivoADescomprimir = FuncionesAuxiliares.seleccionarArchivo();
        
        if(archivoADescomprimir != null){
            if(FuncionesAuxiliares.controlarExtensionHuffman(archivoADescomprimir.getName())) {
                
                //Se muestra en el textField la dirección del archivo.
                panelDescompresion_TextFieldUbicacionOriginal.setText(archivoADescomprimir.getAbsolutePath());
                try {

                    //Se muestra en el textPane el contenido del archivo.
                    panelDescompresion_TextPaneArchivoOriginal.setText(FuncionesAuxiliares.lecturaArchivoEntrada(archivoADescomprimir.getAbsolutePath()));
                } catch (IOException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "La extensión del archivo debe ser 'huf'", "Extensión inválida", JOptionPane.WARNING_MESSAGE);
                archivoADescomprimir = null;
            }
        }
    }//GEN-LAST:event_panelDescompresion_BotonSeleccionarArchivoActionPerformed

    private void limpiarPanelDescompresion(){
        panelDescompresion_TextFieldUbicacionOriginal.setText("Archivo Original");
        panelDescompresion_TextPaneArchivoOriginal.setText("");
        panelDescompresion_TextFieldUbicacionFinal.setText("Archivo Final");
        panelDescompresion_TextPaneArchivoFinal.setText("");
    }
    
    private void botonDescomprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescomprimirActionPerformed
        if(archivoADescomprimir != null){
            JOptionPane.showMessageDialog(null, "Seleccione a continuación el archivo que contenga los códigos para descomprimir el archivo", "Selección de códigos", JOptionPane.INFORMATION_MESSAGE);
            
            //Selección de los códigos de Huffman.
            codigosHuffman = FuncionesAuxiliares.seleccionarArchivo();
            
            //Creación del archivo con formato 'dhu'.
            salida = FuncionesAuxiliares.crearArchivoHuffman(archivoADescomprimir, "dhu");
            
            if(codigosHuffman != null){
                if(FuncionesAuxiliares.controlarExtensionCodigos(codigosHuffman.getName())) {
                    try {
                        huffman = new Huffman();
                        
                        //Se guardan los códigos en un mapa de la forma <caracter, código>.
                        huffman.obtenerCodigosDeHuffman(codigosHuffman);
                        
                        //Descompresión del archivo usando los códigos.
                        huffman.descomprimirConTabla(archivoADescomprimir, salida);
                        
                        //Se muestra en el textField la dirección del archivo.
                        panelDescompresion_TextFieldUbicacionFinal.setText(salida.getAbsolutePath());
                
                        //Se muestra en el textPane el contenido del archivo.
                        panelDescompresion_TextPaneArchivoFinal.setText(FuncionesAuxiliares.lecturaArchivoSalida(salida.getAbsolutePath()));
                        
                        JOptionPane.showMessageDialog(null, "¡Se ha descomprimido el archivo!", "Decodificación exitosa", JOptionPane.INFORMATION_MESSAGE);
                        botonDescomprimir.setEnabled(false);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "La extensión de los códigos debe ser 'txt'", "Extensión inválida", JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "No se han seleccionado los códigos", "Selección de códigos", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un archivo", "Archivo no seleccionado", JOptionPane.WARNING_MESSAGE);     
        }
    }//GEN-LAST:event_botonDescomprimirActionPerformed

    private void panelDescompresion_BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelDescompresion_BotonRegresarActionPerformed
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        panelHuffman.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_panelDescompresion_BotonRegresarActionPerformed

    /*  Función que habilita el botón de codificar si la codificación seleccionada no fue usada para el archivo actual o lo
        desabilita en caso contrario. */
    private void comboBoxCodificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCodificacionActionPerformed
        if(!"".equals(panelCodificacion_TextPaneArchivoFinal.getText())){
            int indices[];
            for(int i = 0; i < indicesComboBoxesCod.size(); i++){
                indices = indicesComboBoxesCod.get(i);
                if(indices[0] == comboBoxCodificacion.getSelectedIndex() && indices[1] == panelCodificacion_ComboBoxErrores.getSelectedIndex()){
                    botonCodificar.setEnabled(false);
                    return;
                }
            }
            botonCodificar.setEnabled(true);
        }
    }//GEN-LAST:event_comboBoxCodificacionActionPerformed

    private void panelCodificacion_ComboBoxErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCodificacion_ComboBoxErroresActionPerformed
        if(!"".equals(panelCodificacion_TextPaneArchivoFinal.getText())){
            int indices[];
            for(int i = 0; i < indicesComboBoxesCod.size(); i++){
                indices = indicesComboBoxesCod.get(i);
                if(indices[0] == comboBoxCodificacion.getSelectedIndex() && indices[1] == panelCodificacion_ComboBoxErrores.getSelectedIndex()){
                    botonCodificar.setEnabled(false);
                    return;
                }
            }
            botonCodificar.setEnabled(true);
        }
    }//GEN-LAST:event_panelCodificacion_ComboBoxErroresActionPerformed

    private void panelDecodificacion_ComboBoxErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelDecodificacion_ComboBoxErroresActionPerformed
        if(!"".equals(panelDecodificacion_TextPaneArchivoFinal.getText())){
            for(int i = 0; i < indicesComboBoxErroresDecod.size(); i++){
                if(panelDecodificacion_ComboBoxErrores.getSelectedIndex() == indicesComboBoxErroresDecod.get(i)){
                   botonDecodificar.setEnabled(false);
                   return;
                }
            }
            botonDecodificar.setEnabled(true);
        }
    }//GEN-LAST:event_panelDecodificacion_ComboBoxErroresActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCodificar;
    private javax.swing.JButton botonComprimir;
    private javax.swing.JButton botonDecodificar;
    private javax.swing.JButton botonDescomprimir;
    private javax.swing.JButton botonHamming;
    private javax.swing.JButton botonHuffman;
    private javax.swing.JComboBox<String> comboBoxCodificacion;
    private javax.swing.JLabel etiquetaTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton paneDecodificacion_BotonSeleccionarArchivo;
    private javax.swing.JPanel panelCodificacion;
    private javax.swing.JButton panelCodificacion_BotonRegresar;
    private javax.swing.JButton panelCodificacion_BotonSeleccionarArchivo;
    private javax.swing.JComboBox<String> panelCodificacion_ComboBoxErrores;
    private javax.swing.JLabel panelCodificacion_EtiquetaErrores;
    private javax.swing.JScrollPane panelCodificacion_ScrollPane1;
    private javax.swing.JScrollPane panelCodificacion_ScrollPane2;
    private javax.swing.JTextField panelCodificacion_TextFieldUbicacionFinal;
    private javax.swing.JTextField panelCodificacion_TextFieldUbicacionOriginal;
    private javax.swing.JTextPane panelCodificacion_TextPaneArchivoFinal;
    private javax.swing.JTextPane panelCodificacion_TextPaneArchivoOriginal;
    private javax.swing.JPanel panelCompresion;
    private javax.swing.JToggleButton panelCompresion_BotonRegresar;
    private javax.swing.JButton panelCompresion_BotonSeleccionarArchivo;
    private javax.swing.JScrollPane panelCompresion_ScrollPane1;
    private javax.swing.JScrollPane panelCompresion_ScrollPane2;
    private javax.swing.JTextField panelCompresion_TextFieldUbicacionFinal;
    private javax.swing.JTextField panelCompresion_TextFieldUbicacionOriginal;
    private javax.swing.JTextPane panelCompresion_TextPaneArchivoFinal;
    private javax.swing.JTextPane panelCompresion_TextPaneArchivoOriginal;
    private javax.swing.JButton panelDecodificacion_BotonRegresar;
    private javax.swing.JComboBox<String> panelDecodificacion_ComboBoxErrores;
    private javax.swing.JLabel panelDecodificacion_EtiquetaErrores;
    private javax.swing.JScrollPane panelDecodificacion_ScrollPane1;
    private javax.swing.JScrollPane panelDecodificacion_ScrollPane2;
    private javax.swing.JTextField panelDecodificacion_TextFieldUbicacionFinal;
    private javax.swing.JTextField panelDecodificacion_TextFieldUbicacionOriginal;
    private javax.swing.JTextPane panelDecodificacion_TextPaneArchivoFinal;
    private javax.swing.JTextPane panelDecodificacion_TextPaneArchivoOriginal;
    private javax.swing.JPanel panelDecodificación;
    private javax.swing.JPanel panelDescompresion;
    private javax.swing.JToggleButton panelDescompresion_BotonRegresar;
    private javax.swing.JButton panelDescompresion_BotonSeleccionarArchivo;
    private javax.swing.JScrollPane panelDescompresion_ScrollPane1;
    private javax.swing.JScrollPane panelDescompresion_ScrollPane2;
    private javax.swing.JTextField panelDescompresion_TextFieldUbicacionFinal;
    private javax.swing.JTextField panelDescompresion_TextFieldUbicacionOriginal;
    private javax.swing.JTextPane panelDescompresion_TextPaneArchivoFinal;
    private javax.swing.JTextPane panelDescompresion_TextPaneArchivoOriginal;
    private javax.swing.JTabbedPane panelHamming;
    private javax.swing.JTabbedPane panelHuffman;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
