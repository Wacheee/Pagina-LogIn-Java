
package Wache;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPasswordField;
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
    private JPanel panelPass = new JPanel();
    private JLabel titulo = new JLabel("Sistema de LogIn", SwingConstants.CENTER);
    boolean passVacio = true; //BOOLEANO PARA el WaterMark
    boolean nomVacio = true;
   
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
        
        //TextBox y Label Usuario
        JTextField txtNombre = new JTextField("Ingrese usuario");
        txtNombre.setMaximumSize(new Dimension(250,300));
        txtNombre.setMinimumSize(new Dimension(250,0));
        txtNombre.setPreferredSize(new Dimension(250,20));
        txtNombre.setFont(new Font("verdana", Font.PLAIN, 12));
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
        txtNombre.setAlignmentX(panelNom.CENTER_ALIGNMENT);
        
        JLabel nombre = new JLabel("Usuario:");

        
        panelNom.setLayout(new BoxLayout(panelNom, BoxLayout.LINE_AXIS));
        
        panelNom.add(Box.createRigidArea(new Dimension(30,0)));
        panelNom.setOpaque(false);
        panelNom.add(nombre);
       // panelNom.add(Box.createRigidArea(new Dimension(20,0)));
        panelNom.add(Box.createHorizontalGlue());
        panelNom.add(txtNombre);
        panelNom.add(Box.createRigidArea(new Dimension(30,0)));
        
        
        
        //TextBox y Label Apellido
        JPasswordField txtPass = new JPasswordField("Ingrese contraseña");
        txtPass.setMaximumSize(new Dimension(250,300));
        txtPass.setEchoChar((char)0);
        txtPass.setMinimumSize(new Dimension(250,0));
        txtPass.setPreferredSize(new Dimension(250,20));
        txtPass.setFont(new Font("verdana", Font.ITALIC, 12));
        txtPass.setForeground(Color.GRAY);
        txtPass.setBorder(BorderFactory.createLineBorder(Color.gray, 1, false));
        txtPass.putClientProperty("JPasswordField.cutCopyAllowed",true); //PERMITIR COPIAR EL PASS
        
        txtPass.setAlignmentX(panelPass.CENTER_ALIGNMENT);
        
        JLabel pass = new JLabel("Contraseña:");

        
        panelPass.setLayout(new BoxLayout(panelPass, BoxLayout.LINE_AXIS));
        
        panelPass.add(Box.createRigidArea(new Dimension(30,0)));
        panelPass.setOpaque(false);
        panelPass.add(pass);
        panelPass.add(Box.createHorizontalGlue());
        //panelPass.add(Box.createRigidArea(new Dimension(20,0)));
        panelPass.add(txtPass);
        panelPass.add(Box.createRigidArea(new Dimension(30,0)));
        
        
        
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
        panel1.add(panelPass, BorderLayout.CENTER);
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
        txtPass.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) { //Si hay focus y sale "Ingrese Apellido", dejamos el curso en 0.
              /*  METODO ORIGINAL
                if(txtApellido.getText().equals("Ingrese su apellido")){
                txtApellido.setText("Ingrese su apellido");
                txtApellido.setCaretPosition(0); //CARET ES LA POSICIÓN DEL CURSO DEL TEXTO
                vacio = true; //BOOLEANO PARA CORROBORAR SI esta vacío
                txtApellido.setFont(new Font("verdana", Font.ITALIC, 12));
                txtApellido.setForeground(Color.GRAY);
                }
                    */
              
              passVacio = WTconFocus(e, txtPass, "Ingrese contraseña", passVacio);
                if(passVacio == true){      //Para volver VISIBLE si es que NO se ha ingreado (para mostar WT)
                txtPass.setEchoChar((char)0);
            }

            }

    
            public void focusLost(FocusEvent e) { //Si no se escribe nada y se va del texto
            /* METODO ORINGIAL
                if(txtApellido.getText().equals("")){
                 txtApellido.setText("Ingrese su apellido");
                 txtApellido.setFont(new Font("verdana", Font.ITALIC, 12));
                 vacio = true;
                 txtApellido.setForeground(Color.GRAY);
            }
                */
            passVacio = WTsinFocus(e, txtPass, "Ingrese contraseña", passVacio);
                         
            if(passVacio == true){      //Para volver VISIBLE la contraseña si NO se ha ingreado constaseña (para mostar WT)
                txtPass.setEchoChar((char)0);
            }
            }
        });
        
        //EVENTO QUE ESCUCHA LO QUE ESCRIBE EL USUARIO.
        txtPass.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {

                 passVacio =WTcorroborar(txtPass, "Ingrese contraseña", passVacio); 
                 if(passVacio == false){ //Para volver INVISIBLE la contraseña si se ha ingreado constaseña
                 txtPass.setEchoChar('\u2022');
              }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                passVacio = WTcorroborar(txtPass, "Ingrese contraseña", passVacio); 
                    if(passVacio == false){ //Para volver INVISIBLE la contraseña si se ha ingreado constaseña
                 txtPass.setEchoChar('\u2022');
              }         
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                 passVacio = WTcorroborar(txtPass, "Ingrese contraseña", passVacio); 
                   if(passVacio == false){ //Para volver INVISIBLE la contraseña si se ha ingreado constaseña
                 txtPass.setEchoChar('\u2022');
              }
            }
            
            /* METODO ANTIGUO
            private void corroborar(){ //PARA QUE FICNOE BUEN HAY Q HACER EL invokeLater.
                Runnable doHighlight = new Runnable() {
                    
                    @Override
                    public void run() {
                        if(!txtApellido.getText().equals("Ingrese contraseña") && vacio == true){
                            vacio = false;
                            String texto = txtApellido.getText();
                            texto = texto.replace("Ingrese contraseña", "");
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
            */
        });
        
        
        //EVENTO PARA CONTROLAR EL CARET (El cursor de texto), si esta el WaterMark, no puede mover el cursor
        txtPass.getCaret().addChangeListener(new ChangeListener(){     //Seams to work!

            @Override
            public void stateChanged(ChangeEvent e) {

                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run() {

                         if(txtPass.getCaretPosition() != 0 && passVacio == true){
                   txtPass.setCaretPosition(0);
               }

                    }
                });
            }
        });

        
        
        
        
        //Linstener y Eveentos caja nombre
        txtNombre.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) { //Si hay focus y sale "Ingrese Apellido", dejamos el curso en 0.            
              nomVacio = WTconFocus(e, txtNombre, "Ingrese usuario", nomVacio);
            }

    
            public void focusLost(FocusEvent e) { //Si no se escribe nada y se va del texto
            nomVacio = WTsinFocus(e, txtNombre, "Ingrese usuario", nomVacio);
            
            }
        });
        
        //EVENTO QUE ESCUCHA LO QUE ESCRIBE EL USUARIO.
        txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                 nomVacio =WTcorroborar(txtNombre, "Ingrese usuario", nomVacio);   
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                nomVacio = WTcorroborar(txtNombre, "Ingrese usuario", nomVacio);   
                          
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                 nomVacio = WTcorroborar(txtNombre, "Ingrese usuario", nomVacio);   
                
            }
            
          
        });
        
        
        //EVENTO PARA CONTROLAR EL CARET (El cursor de texto), si esta el WaterMark, no puede mover el cursor
        
        txtNombre.getCaret().addChangeListener(new ChangeListener(){     //Seams to work!

            @Override
            public void stateChanged(ChangeEvent e) {

                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run() {

                         if(txtNombre.getCaretPosition() != 0 && nomVacio == true){
                   txtNombre.setCaretPosition(0);
               }

                    }
                });
            }
        });
        
        
       

    }

    
    //METODOS DEL WT:
            private boolean WTconFocus(FocusEvent e, JTextField t, String wm, boolean a) { //Si hay focus y sale "Ingrese Apellido", dejamos el curso en 0.
                if(t.getText().equals(wm)){
                t.setText(wm);
                t.setCaretPosition(0); //CARET ES LA POSICIÓN DEL CURSO DEL TEXTO
                //passVacio = true; //BOOLEANO PARA CORROBORAR SI esta vacío
                t.setFont(new Font("verdana", Font.ITALIC, 12));
                t.setForeground(Color.GRAY);
                return true;
                }
                else{
                    return a;
                }
        
            }
            
            
            
            private boolean WTsinFocus(FocusEvent e, JTextField t, String wm, boolean a){
                if(t.getText().equals("")){    
                    t.setText(wm);
                    t.setFont(new Font("verdana", Font.ITALIC, 12));
                    // passVacio = true;  
                    t.setForeground(Color.GRAY); 
                    return true;
                }
             else{
                 return a;
             }
            }
            
            
            private boolean WTcorroborar(JTextField t, String wm, boolean a){ //PARA QUE FICNOE BUEN HAY Q HACER EL invokeLater.
                Runnable doHighlight = new Runnable() {
                    
                    @Override
                    public void run() {
                        if(!t.getText().equals(wm) && a == true){
                            String texto = t.getText();
                            texto = texto.replace(wm, "");
                            t.setText(texto);
                            t.setFont(new Font("verdana", Font.PLAIN, 12)); 
                            t.setForeground(Color.BLACK);
 
                        }
                    }
                };
                
                
                 
                if(!t.getText().equals(wm) && a == true){       
                    SwingUtilities.invokeLater(doHighlight);
                    return false;         
                }
                  
                  else{
                    SwingUtilities.invokeLater(doHighlight);
                      return a;
                  }
                  
            }
            
            
    
    
}
