
package Wache;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ventana{
    //Recomiendan tambien crear los componentes fuera de metodos ¿?
    JFrame miVentana = new JFrame("Autenticación"); //Recomiendan hacerlo privado, pero lo dejare public para jugar con sus metodos
    private JPanel panel1 = new JPanel();
    private JPanel panelNom = new JPanel();
    private JPanel panelApe = new JPanel();
    private JLabel titulo = new JLabel("Sistema de LogIn", SwingConstants.CENTER);
    boolean vacio = true; //BOOLEANO PARA el WaterMark
   
    public Ventana(){ //Algunos dicen que en vez del constructor, dejarlo en un metodo
        miVentana.setTitle("Autenticación");
        miVentana.setSize(400, 590);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setMinimumSize(new Dimension(420, 630));
        miVentana.getContentPane().setBackground(new Color(25, 50, 60));
        iniciarComponentes();
  
    }
    
    public void mostarVentana(){
        miVentana.setVisible(true);
    }
    
    public void iniciarComponentes(){
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS)); //Page_Axis Permite arriba y abajo, Line_Axis hacia al lado, es mejor pq es mejor ubicar componentes
       // panel1.add(Box.createVerticalGlue());
        panel1.setMaximumSize(new Dimension (390, 580));
        panel1.setPreferredSize(new Dimension (390, 580));
        panel1.setMinimumSize(new Dimension (390, 580));
        
        panel1.setBackground(new Color(243, 247, 240));
        
        
        
        //BOX PARA PODER mantener centrado LOGIN
        Box cajaContenedora = new Box(BoxLayout.PAGE_AXIS);
        
        cajaContenedora.add(Box.createVerticalGlue());
        cajaContenedora.add(panel1);     
        cajaContenedora.add(Box.createVerticalGlue());
        
        //Agrego cosas 
        //Texto
        //titulo.setLocation(0, 0);
        titulo.setAlignmentX(panel1.CENTER_ALIGNMENT);
        titulo.setFont(new Font("verdana", Font.PLAIN, 30));
        //titulo.setAlignmentY(panel1.CENTER_ALIGNMENT);
        
        //TextBox y Label Nombre
        JTextField txtNombre = new JTextField("Ingrese su nombre");
        txtNombre.setMaximumSize(new Dimension(250,300));
        txtNombre.setMinimumSize(new Dimension(250,0));
        txtNombre.setPreferredSize(new Dimension(250,20));
        txtNombre.setFont(new Font("verdana", Font.PLAIN, 12));
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
        txtNombre.setAlignmentX(panelNom.CENTER_ALIGNMENT);
        
        JLabel nombre = new JLabel("Nombre:");

        
        panelNom.setLayout(new BoxLayout(panelNom, BoxLayout.LINE_AXIS));
        
        panelNom.add(Box.createHorizontalGlue());
        panelNom.setOpaque(false);
        panelNom.add(nombre);
        panelNom.add(Box.createHorizontalGlue());
        panelNom.add(txtNombre);
        panelNom.add(Box.createHorizontalGlue());
        
        
        
        //TextBox y Label Apellido
        JTextField txtApellido = new JTextField("Ingrese su apellido");
        txtApellido.setMaximumSize(new Dimension(250,300));
        txtApellido.setMinimumSize(new Dimension(250,0));
        txtApellido.setPreferredSize(new Dimension(250,20));
        txtApellido.setFont(new Font("verdana", Font.ITALIC, 12));
        txtApellido.setForeground(Color.GRAY);
        txtApellido.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
        
        txtApellido.setAlignmentX(panelApe.CENTER_ALIGNMENT);
        
        JLabel apellido = new JLabel("Apellido:");

        
        panelApe.setLayout(new BoxLayout(panelApe, BoxLayout.LINE_AXIS));
        
        panelApe.add(Box.createHorizontalGlue());
        panelApe.setOpaque(false);
        panelApe.add(apellido);
        panelApe.add(Box.createHorizontalGlue());
        panelApe.add(txtApellido);
        panelApe.add(Box.createHorizontalGlue());
        
        
        
        //Botón
        JButton boton = new JButton("Aceptar");
        boton.setLocation(0,0);
        boton.setAlignmentX(panel1.CENTER_ALIGNMENT);
        boton.setBackground(new Color(140, 94, 88));
        boton.setForeground(new Color(243, 247, 240));
        //boton.setAlignmentY(panel1.CENTER_ALIGNMENT);
        
        //panel1.add(Box.createRigidArea(new Dimension(0,40))); //Para separar componentes
        //panel1.setBorder(BorderFactory.createLineBorder(Color.black, 5, false));
        //panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        
        //Logo

        ImageIcon logo = new ImageIcon("Logo-1.png");
        JLabel imagen = new JLabel();
        imagen.setSize(124, 141);
        imagen.setAlignmentX(panel1.CENTER_ALIGNMENT);
        
        
        imagen.setIcon(new ImageIcon(logo.getImage().getScaledInstance(124, 141, Image.SCALE_SMOOTH))); //cON ESTE METODO puedo REESCALAR LA IMAGEN
        
        
        
        panel1.add(Box.createRigidArea(new Dimension(0,40))); //Para separar componentes
        panel1.add(titulo, BorderLayout.CENTER);
        panel1.add(Box.createVerticalGlue());
        panel1.add(imagen, BorderLayout.PAGE_START);
        panel1.add(Box.createVerticalGlue());
        panel1.add(panelNom, BorderLayout.CENTER);
        panel1.add(Box.createRigidArea(new Dimension(0,20)));
        panel1.add(panelApe, BorderLayout.CENTER);
        panel1.add(Box.createVerticalGlue());
        panel1.add(boton, BorderLayout.CENTER);
        panel1.add(Box.createRigidArea(new Dimension(0,40)));
        panel1.setMaximumSize(new Dimension (390, 580));
        panel1.setPreferredSize(new Dimension (390, 580));
        panel1.setMinimumSize(new Dimension (390, 580));
        miVentana.setSize(panel1.getSize());
        miVentana.add(cajaContenedora);
        //miVentana.pack();
        
        
        
           //WATERMARK CASERO!     --> El problema, al momento de Pegar, solo copia la primera letra       
           //EVENTO FOCUS
        txtApellido.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(txtApellido.getText().equals("Ingrese su apellido")){
                txtApellido.setText("Ingrese su apellido");
                txtApellido.setCaretPosition(0); //CARET ES LA POSICIÓN DEL CURSO DEL TEXTO
                vacio = true; //BOOLEANO PARA CORROBORAR SI esta vacío
                txtApellido.setFont(new Font("verdana", Font.ITALIC, 12));
                txtApellido.setForeground(Color.GRAY);
                }
            }

    
            public void focusLost(FocusEvent e) {
            if(txtApellido.getText().equals("")){
                 txtApellido.setText("Ingrese su apellido");
                 txtApellido.setFont(new Font("verdana", Font.ITALIC, 12));
                 vacio = true;
                 txtApellido.setForeground(Color.GRAY);
            }
            
            }
        });
        
        //EVENTO QUE ESCUCHA LO QUE ESCRIBE EL USUARIO.
        txtApellido.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                corroborar();                
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                corroborar();
                          
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                corroborar();
                
            }
            
            
            private void corroborar(){ //PARA QUE FICNOE BUEN HAY Q HACER EL invokeLater.
                Runnable doHighlight = new Runnable() {
                    
                    @Override
                    public void run() {
                        if(!txtApellido.getText().equals("Ingrese su apellido") && vacio == true){
                            vacio = false;
                            String texto = txtApellido.getText();
                            texto = texto.replace("Ingrese su apellido", "");
                            //char letra = texto.charAt(0);
                            //txtApellido.setText(String.valueOf(letra));  
                            txtApellido.setText(texto);
                            txtApellido.setFont(new Font("verdana", Font.PLAIN, 12)); 
                            txtApellido.setForeground(Color.BLACK);
                        }
                    }
                };       
                SwingUtilities.invokeLater(doHighlight);
            }
        });
        
        
        //EVENTO PARA CONTROLAR EL CARET (El cursor de texto), si esta el WaterMark, no puede mover el cursor
        txtApellido.getCaret().addChangeListener(new ChangeListener(){     //Seams to work!

            @Override
            public void stateChanged(ChangeEvent e) {

                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run() {

                         if(txtApellido.getCaretPosition() != 0 && vacio == true){
                   txtApellido.setCaretPosition(0);
               }

                    }
                });
            }
        });
        
       

    }
    
    
}
