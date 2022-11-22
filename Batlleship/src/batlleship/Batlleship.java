package batlleship;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class Batlleship extends JFrame {
    
   //primera parte
   private JButton jbJugar, jbSalir;
   private Boolean frame1=true;
   Border border = BorderFactory.createLineBorder(Color.black, 1);
   JPanel jpanel = (JPanel) this.getContentPane();  
   JPanel panel=new JPanel();
   private Color colorxd;
        
    
    // segunda parte
    private Boolean frame2=false;
    private JLabel etiNombre, etiEdad;
    private JTextField jtNombre, jtEdad;
    private JButton jbPlay;
    
    // tercera parte
    private Boolean frame3=false;
    private JLabel jlBienvenida,jlExplicacion;
    private JButton jbAceptar;
    private JLabel[][] jlTablero = new JLabel[10][10];
    private JLabel []filas=new JLabel[10];
    private JLabel []columnas=new JLabel[10];
    private JLabel jlxy;
    private JLabel jlIntentos,jlNumerosint,jlBarco,jlDamecor,jlx,jly;
    private JTextField jtCoordenadasX,jtCoordenadasY;
    private JButton jbUndir;
    private  int [][]tables=new int[10][10];
    private int [][]barcoCompara=new int [10][10];
    private  int data=1,contaTur=10,barcosUndidos=0;
   private JLabel jlLediste,jlNolediste,jlUndistebarco;
    private Barcos []bk=new Barcos[10];
    private Barcos []b=new Barcos[10];   
    
    //fin del juego    
    private JButton jbContinuar;
    //ganador
    private JLabel jlFelicidades;   
    //perdedor
    private JLabel jlPerdiste;
    private JLabel jlPosicion;
    private JLabel [][]jlTab= new JLabel[10][10];
    //score
    private JLabel jlScores;
    private JLabel jlPuntuaciones;
    private JScrollPane jspScore; 
    private JButton jbcontinuar2,jbSalirs;
    private ArrayList <Score>score;
    private JTextArea jtxt;
    
    
    
    Batlleship()            
    {
        setSize(900,600);
        setTitle("Batlleship");
        this.setResizable(false);
        MisComponentes();
    }
    
   private void MisComponentes()
   {
       //primera parte declaraciones y posiciones
       jbJugar=new JButton(" JUGAR");
       jbSalir= new JButton("Salir");
       
       jbJugar.setBounds(400-10, 225+10, 100, 25);
       jbSalir.setBounds(400-10,275+10,100,25);
       jpanel.setLayout(null);
       colorxd=new Color(133, 193, 233);
       jpanel.setBackground(colorxd);
       //jpanel.setBackground(Color.);
       add(jbJugar);     
       add(jbSalir);
       
       //segunda parte declaraciones y posiciones
       etiNombre= new JLabel("Nombre: ");
       etiEdad= new JLabel("Edad: ");
       setJtNombre(new JTextField());
       setJtEdad(new JTextField());
       jbPlay= new JButton("Play!");
       setLayout(null);
       etiNombre.setBounds(350, 150+50, 80, 30);
       getJtNombre().setBounds(430, 150+50, 100, 25);
       
       etiEdad.setBounds(350, 200+50, 50, 25);
       getJtEdad().setBounds(430, 200+50, 50, 25);       
       jbPlay.setBounds(400, 250+50, 80, 25);
       add(etiNombre);
       add(etiEdad);
       add(getJtNombre());
       add(getJtEdad());
       add(jbPlay);
       etiNombre.setVisible(false);
       etiEdad.setVisible(false);
       getJtNombre().setVisible(false);
       getJtEdad().setVisible(false);
       jbPlay.setVisible(false);
       
       //Tercera Parte posiciones
       jlBienvenida=new JLabel("Bienvenido al juego BeatleShip");
       jlExplicacion=new JLabel("Tienes 10 intentos para hundir \n los 10 barcos que hay en el\n" +"tablero y ganar el juego…");
       jlBienvenida.setBounds(25, 50,200, 50);
       jlExplicacion.setBounds(25, 100,500, 50);
       jlxy=new JLabel("Y/X");
       jlxy.setBounds(150+20, 0, 50, 50);
       
       
       for(int i=0; i<10;i++)
        {
            for(int j=0; j<10;j++)
            {
                jlTablero[i][j]= new JLabel("-");
                jlTablero[i][j].setBounds(((i*70)+190), ((j*50)+50), 70, 50);
                jlTablero[i][j].setBorder(border);
                add(jlTablero[i][j]);
                jlTablero[i][j].setVisible(false);
            }
        }       
        for(int i=0;i<10;i++)
        {
            filas[i]=new JLabel(i+"");
            columnas[i]=new JLabel(i+"");
            filas[i].setBounds(((i*70)+225), 0, 70, 50);
            columnas[i].setBounds(150+20, ((i*50)+50), 70, 50);
            add(columnas[i]);
            add(filas[i]);
            columnas[i].setVisible(false);
            filas[i].setVisible(false);
        }                  
       
       //Tercera Parte
       jlIntentos =new JLabel("Turnos: ");
       jlIntentos.setBounds(15, 150, 55, 25);
       
       jlNumerosint=new JLabel("10");
       jlNumerosint.setBounds(80, 150, 50, 25);
       
       jlDamecor= new JLabel("Coordenadas:");
       jlDamecor.setBounds(15, 200,100, 25);
       
       
       jlx=new JLabel("Lineas :");
       jlx.setBounds(15, 250, 50, 25);
       setJtCoordenadasX(new JTextField(""));
       getJtCoordenadasX().setBounds(100, 250, 30, 25);
       
       jly=new JLabel("Columnas:");
       jly.setBounds(15, 300, 75, 25);
       setJtCoordenadasY(new JTextField(""));
       getJtCoordenadasY().setBounds(100, 300, 30, 25);
       
       jbUndir=new JButton("UNDIR!");
       jbUndir.setBounds(15,350,100,25);   
       
       jlLediste=new JLabel("Muy Bien... tiro en el blanco");
       jlLediste.setBounds(0, 400, 160, 25);
       jlUndistebarco= new JLabel("BARCO HUNDIDO!!!");
       jlUndistebarco.setBounds(15, 450, 150, 25);
       
       jlNolediste=new JLabel("En"+"("+jtCoordenadasX.getText()+jtCoordenadasY.getText()+")  no hay barco");
       jlNolediste.setBounds(15, 400, 150, 25);
       add(jlIntentos);
       add(jlNumerosint);
       add(jlDamecor);
       add(jlx);
       add(getJtCoordenadasX());
       add(jly);
       add(getJtCoordenadasY());
       add(jbUndir); 
       jlIntentos.setVisible(false);
       jlNumerosint.setVisible(false);
       jlDamecor.setVisible(false);
       jlx.setVisible(false);
       getJtCoordenadasX().setVisible(false);
       jly.setVisible(false);
       getJtCoordenadasY().setVisible(false);
       jbUndir.setVisible(false);
       
       //cuarta fase
       jbContinuar= new JButton("Continuar");
       //Score
       score=new ArrayList<Score>();
       jtxt=new JTextArea();
       jspScore= new JScrollPane();
       jspScore.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jspScore.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       jspScore.setBounds(100,150,700,400);
       jspScore.setViewportView(jtxt);
       jtxt.setColumns(3);
       jlScores=new JLabel("Tabla de puntuaciones");
       jlScores.setBounds(300, 25, 300, 50);
       jlScores.setFont(jlScores.getFont().deriveFont(22f));
       add(jlScores);
       
       jbSalirs=new JButton("SALIR");
       jbSalirs.setBounds(450,100,100,25);
       add(jbSalirs);
       jbcontinuar2=new JButton("Volver a Jugar");
       jbcontinuar2.setBounds(250, 100, 150, 25);
       add(jbcontinuar2);
       jbSalirs.setVisible(false);
       jlScores.setVisible(false);
       jbcontinuar2.setVisible(false);
       
       
       // primera parte add
            
        getJtNombre().setText("");         
       
       //Primera Parte eventos
       jbJugar.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               frame1=false;
               jbJugar.setVisible(false);
               jbSalir.setVisible(false);
               
               etiNombre.setVisible(true);
               etiEdad.setVisible(true);
               getJtNombre().setVisible(true);
               getJtEdad().setVisible(true);
               jbPlay.setVisible(true);
               //jbJugar.repaint();               
               
                 
             repaint();               
           }
       });       
       jbSalir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}});
       
       // segunda parte eventos
       jbPlay.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evt) 
           {
               int h=0;
               //caso en que no ponga el nombre
               
               //verificar edad
                int data;
                try{
                data=Integer.parseInt(getJtEdad().getText());
                if(data<18)
                {
                    JOptionPane.showMessageDialog(null, "No puedes jugar porque eres menor de edad");
                        getJtEdad().setText("");
                        getJtNombre().setText("");
                    h=1;
                }
                if(getJtNombre().getText().length()==0  )
                {
                    JOptionPane.showMessageDialog(null,"Ingresa tu nombre");     
                    h=1;
                }
                }catch(NumberFormatException e){
                    if(h==1)
                        JOptionPane.showMessageDialog(null, "Debes ingresar tu edad y tu nombre para poder continuar");
                        
                        else
                    {
                        h=1;
                        JOptionPane.showMessageDialog(null, "Debes ingresar tu edad para poder continuar");}
                    }
                if(h==0)
                {
                    frame2=false;
                    etiNombre.setVisible(false);
                    etiEdad.setVisible(false);
                    getJtNombre().setVisible(false);
                    getJtEdad().setVisible(false);
                    jbPlay.setVisible(false); 
                    jlIntentos.setVisible(true);
                    jlNumerosint.setVisible(true);
                    jlDamecor.setVisible(true);
                    jlx.setVisible(true);
                    getJtCoordenadasX().setVisible(true);
                    jly.setVisible(true);
                    getJtCoordenadasY().setVisible(true);
                    jbUndir.setVisible(true);
                    
                                       
                    for(int i=0;i<10;i++)
                    {
                        for(int j=0;j<10;j++)
                        {                                   
                            jlTablero[i][j].setVisible(true);
                        }
                    }
                    for(int i=0;i<10;i++)
                    {
                       columnas[i].setVisible(true);
                       filas[i].setVisible(true);
                    }
                    add(jlxy);
                     barco();
                     repaint();
                   try {
                       LeerArch();
                   } catch (IOException ex) {
                       Logger.getLogger(Batlleship.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(Batlleship.class.getName()).log(Level.SEVERE, null, ex);
                   }                   
                    JOptionPane.showMessageDialog(null,"Bienvenido al Juego BeatlesShip"+"\n"+"Tienes 10 intentos para hundir los 10 barcos que hay en el\n" +"tablero y ganar el juego…");
                }   
           }
        });       
        getJtNombre().addKeyListener(new KeyAdapter() 
       {
            public void keyReleased(KeyEvent evt) 
            {
                if ((!jtNombre.getText().matches("^[A-z- ]*$")))
                {
                    JOptionPane.showMessageDialog(null,"Ingresa solo letras");
                    getJtNombre().setText("");
                    getJtNombre().requestFocus();
                }
            }
        });       
        getJtEdad().addKeyListener(new KeyAdapter() 
       {
            public void keyReleased(KeyEvent evt) 
            {
                if ((!jtEdad.getText().matches("^[0-9]*$")))
                {
                    JOptionPane.showMessageDialog(null,"Ingresa solo Numeros");
                    getJtEdad().setText("");
                    getJtEdad().requestFocus();
                }
            }
        });
        
       //Eventos tercera parte
       
       // solo ingrese numeros en coordenadas
        getJtCoordenadasX().addKeyListener(new KeyAdapter() 
       {
           public void keyReleased(KeyEvent evt) 
            {
                if ((!jtCoordenadasX.getText().matches("^[0-9]*$")))
                {
                    JOptionPane.showMessageDialog(null,"Ingresa solo Numeros");
                    getJtCoordenadasX().setText("");
                    getJtCoordenadasX().requestFocus();
                }
            }
        });
        
        getJtCoordenadasY().addKeyListener(new KeyAdapter() 
       {
            public void keyReleased(KeyEvent evt) 
            {
                if ((!jtCoordenadasY.getText().matches("^[0-9]*$")))
                {
                    JOptionPane.showMessageDialog(null,"Ingresa solo Numeros");
                    getJtCoordenadasY().setText("");
                    getJtCoordenadasY().requestFocus();
                }
            }
         });
        
       jbUndir.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evt) 
           {
              /*if(data==1)
              {
                  barco();
                  data=0;
              }*/
              UndirBarco();
             //jlContaTurnos=(""+contaTur);
              jlNumerosint.setText(""+contaTur);             
              repaint();
              if((contaTur==0)||(barcosUndidos==10))
                {
                  try {
                      CrearArchivoScore();
                  } catch (IOException ex) {
                      Logger.getLogger(Batlleship.class.getName()).log(Level.SEVERE, null, ex);
                  }
                   System.out.println("Fin de  juego");
                   jlIntentos.setVisible(false);
                   jlNumerosint.setVisible(false);
                   jlDamecor.setVisible(false);
                   jlx.setVisible(false);
                   jly.setVisible(false);
                   getJtCoordenadasX().setVisible(false);
                   getJtCoordenadasY().setVisible(false);
                   jbUndir.setVisible(false);
                   jlxy.setVisible(false);     
                   jlNolediste.setVisible(false);
                   jlLediste.setVisible(false);
                   jlUndistebarco.setVisible(false);
                    for(int i=0;i<10;i++)
                    {
                        for(int j=0;j<10;j++)
                        {
                             jlTablero[i][j].setVisible(false);                            
                        }
                    }
                    for(int i=0;i<10;i++)
                    {
                        columnas[i].setVisible(false);
                        filas[i].setVisible(false);                        
                    }
                    
                    if(contaTur==0)
                    {
                        //perdedor
                        jlPerdiste=new JLabel("Lo siento...    has perdido el juego.\n"+"        Sólo lograste hundir:   "+barcosUndidos +"  barcos...");
                        jlPerdiste.setFont(jlScores.getFont().deriveFont(15f));
                        jlPerdiste.setBounds(250, 15, 550, 25);
                        jbContinuar.setBounds(15, 300, 100, 25);
                        
                        jlPosicion=new JLabel("Posicion de los barcos");
                        jlPosicion.setBounds(15, 200, 200, 25);
                        jlPerdiste.setFont(jlScores.getFont().deriveFont(15f));
                        add(jlPosicion);
                        add(jlPerdiste);
                        add(jbContinuar);
                        jlPerdiste.setVisible(true);
                        jbContinuar.setVisible(true);
                        jlPosicion.setVisible(true);
                        for(int i=0; i<10;i++)
                        {
                            for(int j=0; j<10;j++)
                            {   
                                
                                if(getTables()[j][i]==1){jlTab[i][j]= new JLabel("\t ⛴");}
                                else if(getTables()[j][i]==2){jlTab[i][j]= new JLabel("\t💥");}                                
                                else if((getTables()[j][i]==3)&&(getBarcoCompara()[j][i]==1)){jlTab[i][j]= new JLabel("\t💥");}                                
                                else if(getTables()[j][i]==4){jlTab[i][j]= new JLabel("\t💥");} 
                                else{jlTab[i][j]= new JLabel(" ");}           
                                
                                jlTab[i][j].setBounds(((i*70)+190), ((j*50)+50), 70, 50);
                                jlTab[i][j].setFont(jlTab[i][j].getFont().deriveFont(22f));
                                jlTab[i][j].setBorder(border);
                                add(jlTab[i][j]);      
                                jlTab[i][j].setVisible(true);
                            }
                        } 
                    }
                    else
                    {
                        jlFelicidades= new JLabel("\tFelicidades  "+jtNombre.getText() +"   Has ganado el juego" );
                        jlFelicidades.setFont(jlScores.getFont().deriveFont(15f));
                        jlFelicidades.setBounds(300, 150, 550, 25);
                        jbContinuar.setBounds(350, 250, 100, 25);                        
                        add(jlFelicidades);
                        add(jbContinuar);
                        jlFelicidades.setVisible(true);
                        jbContinuar.setVisible(true);
                    }
                 }
             }           
         });
       // frame de perdedor
        jbContinuar.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evt) 
           {
               
               if(contaTur==0)
               {
               jlPerdiste.setVisible(false);
               jbContinuar.setVisible(false);  
               jlPosicion.setVisible(false);
               for(int i=0; i<10;i++){for(int j=0; j<10;j++){jlTab[i][j].setVisible(false);}}
               }
               else
               { 
                   jlFelicidades.setVisible(false);
                   jbContinuar.setVisible(false);
               }
               try {
                   LeerArchivoScore();
               } 
               catch (EOFException ex) {;} catch (IOException ex) {
                   Logger.getLogger(Batlleship.class.getName()).log(Level.SEVERE, null, ex);
               }
               
              //jtxt.setFont(jtxt.getFont().deriveFont(22f));
           
              jbSalirs.setVisible(true);
              jlScores.setVisible(true);
              jbcontinuar2.setVisible(true);
               jtxt.setVisible(true);
              JLabel Nombre= new JLabel("Nombre:");
              Nombre.setBounds(0,0,300,50);
              Nombre.setFont(Nombre.getFont().deriveFont(22f));
              Nombre.setBorder(border);
              jtxt.add(Nombre);
              JLabel Edad= new JLabel("Edad:");
              Edad.setBounds(300,0,150,50);
              Edad.setFont(Nombre.getFont().deriveFont(22f));
              Edad.setBorder(border);
              jtxt.add(Edad);
              JLabel Puntuacion= new JLabel("Puntuacion:");
              Puntuacion.setBounds(450,0,250,50);
              Puntuacion.setFont(Nombre.getFont().deriveFont(22f));
              Puntuacion.setBorder(border);
              jtxt.add(Puntuacion);
              JLabel []nom=new JLabel[score.size()];
              JLabel []edad=new JLabel[score.size()];
              JLabel []puntuaciones=new JLabel[score.size()];
              jtxt.setFont(Nombre.getFont().deriveFont(19f));              
              jtxt.setText("\n\n");
              jtxt.setEditable(false);
              System.out.print(score.size());
              for(int i=0;i<score.size();i++)
              {                  
                  //NOMBRE
                  nom[i]=new JLabel(score.get(i).getNombre());
                  nom[i].setBounds(0, (50*i)+50, 300, 50);
                  nom[i].setFont(Nombre.getFont().deriveFont(22f));
                  jtxt.add(nom[i]); 
                  jtxt.append("\n\n"); 
                  //EDAD
                  edad[i]=new JLabel(score.get(i).getEdad()+" años");
                  edad[i].setBounds(300, (50*i)+50, 150, 50);
                  edad[i].setFont(Nombre.getFont().deriveFont(22f));
                  jtxt.add(edad[i]); 
                  //Puntuaciones
                  if(score.get(i).getBu()==10)
                  {
                  puntuaciones[i]=new JLabel("GANADOR!!");
                  puntuaciones[i].setBounds(450, (50*i)+50, 250, 50);
                  puntuaciones[i].setFont(Nombre.getFont().deriveFont(22f));
                  }
                  else
                  {
                    puntuaciones[i]=new JLabel(score.get(i).getBu()+" Barcos hundidos");
                    puntuaciones[i].setBounds(450, (50*i)+50, 250, 50);
                    puntuaciones[i].setFont(Nombre.getFont().deriveFont(22f));
                  }
                  jtxt.add(puntuaciones[i]);
              }
              jtxt.repaint();
               add(jspScore);
               jspScore.setVisible(true);
               repaint();               
           }           
         });
        
        //eventos finales
        jbSalirs.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){System.exit(0);}});
        
        jbcontinuar2.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evt) 
           {
               getJtEdad().setText("");
               getJtNombre().setText("");
               getJtCoordenadasX().setText("");
               getJtCoordenadasY().setText("");
               
               jtxt.setVisible(false);
               jspScore.setVisible(false);
               jbSalirs.setVisible(false);
               jlScores.setVisible(false);
               jbcontinuar2.setVisible(false);              
               jbJugar.setVisible(true);
               jbSalir.setVisible(true);                
               contaTur=10;
               barcosUndidos=0;
               repaint();
           }           
         });
   } 
   //algoritmo  del juego
   private void UndirBarco()
   {
       int cordex,cordey,con;       
         try{
                cordex=Integer.parseInt(getJtCoordenadasX().getText());
                cordey=Integer.parseInt(getJtCoordenadasY().getText());  
               if(getTables()[cordex][cordey]==1)
               {
                   jlNolediste.setVisible(false);
                   jlUndistebarco.setVisible(false);
                   System.out.println("Le diste en el blanco"); 
                   jlLediste.setVisible(true);
                   add(jlLediste);
                   getTables()[cordex][cordey]=4;                   
                  // System.out.println(cordex+","+cordey+", "+getTables()[cordex][cordey]);
                  jlTablero[cordey][cordex].setFont(jlTablero[cordey][cordex].getFont().deriveFont(22f));
                   jlTablero[cordey][cordex].setText("\t  💥");
                   
                   
                   for(int i=0;i<getBarcoCompara().length;i++)
                    {           
                        int h=i;
                        if(b[h].getLinea()==cordex)
                        {
                            if((b[h].getCol()==cordey)||(b[h].getCol()+1==cordey)||(b[h].getCol()+2==cordey))
                            {
                                if((getTables()[cordex][b[h].getCol()]==4)&&(getTables()[cordex][b[h].getCol()+1]==4)&&(getTables()[cordex][b[h].getCol()+2]==4))
                                    {                                     
                                       barcosUndidos++;
                                       jlUndistebarco.setVisible(true);
                                       add(jlUndistebarco);
                                       getTables()[cordex][b[h].getCol()]=2;
                                       getTables()[cordex][b[h].getCol()+1]=2;
                                       getTables()[cordex][b[h].getCol()+2]=2;
                                    }                                
                            }                            
                        } 
                    }    
               }
               else
               {
                   System.out.println("fallaste");
                   jlTablero[cordey][cordex].setFont(jlTablero[cordey][cordex].getFont().deriveFont(22f));                   
                   jlTablero[cordey][cordex].setText("\t✘");
                   if(getTables()[cordex][cordey]==4){getTables()[cordex][cordey]=4;}
                   //else  if(getTables()[cordex][cordey]==2){getTables()[cordex][cordey]=2;}
                   else getTables()[cordex][cordey]=3;  
                   contaTur--;
                   jlLediste.setVisible(false);
                   jlUndistebarco.setVisible(false);
                   jlNolediste.setVisible(true);
                   jlNolediste.setText("En "+" ("+jtCoordenadasX.getText()+" , "+jtCoordenadasY.getText()+") no hay barco");
                   add(jlNolediste);
               }
             }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Debes ingresar  cordenadas para poder undir el barco");}
              catch(ArrayIndexOutOfBoundsException e){JOptionPane.showMessageDialog(null, "Rango fuera del tablero"); contaTur--;}
   }
   //creacion de tablero
   private void barco()
   {
        int cordex,cordey;
        try{
            for(int i=1;i<=10;i++)
            {
                for (int j=1;j<=10;j++)
                {
                    getTables()[i][j+1]=0;
                    getBarcoCompara()[i][j+1]=0;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
   }  
   //creacion de los barco
    public  void  coordendasDeM(int linea,int columna)
   {
        getTables()[linea][columna]=1;
        getTables()[linea][columna+1]=1;
        getTables()[linea][columna+2]=1;
        
        getBarcoCompara()[linea][columna]=1;
        getBarcoCompara()[linea][columna+1]=1;
        getBarcoCompara()[linea][columna+2]=1;
        
    }
    
   //lecturas de archivos 
    public  void LeerArch()throws IOException, EOFException,ClassNotFoundException
   {
       int lin,col,num;       
       String nomarch;
       
       num=(int) ((Math.random())*(9)+1);
       nomarch="Tablero"+num+".dat";
       //nomarch="Tablero2.dat";
       DataInputStream f=new DataInputStream(new FileInputStream(nomarch));
       for(int i=0;i<10;i++)
        {
            lin=f.readInt();
            col=f.readInt();
            coordendasDeM(lin,col);
            try{
                b[i]=new Barcos(lin,col);
                bk[i]=new Barcos(lin,col);
            }catch(ArrayIndexOutOfBoundsException e){}
        }
        f.close();
   }
   
    public void CrearArchivoScore()throws IOException,EOFException 
    {
        //String nombre;
       /// int barcosUndidos;
        boolean append=true;
        DataOutputStream fp= new DataOutputStream(new FileOutputStream("Score.dat",append));
        fp.writeUTF(jtNombre.getText());
        fp.writeInt(Integer.parseInt(jtEdad.getText()));
        fp.writeInt(barcosUndidos);
    }
    
    public void LeerArchivoScore()throws IOException
    {
        String nombres;
        int barcosUs,edad;
        DataInputStream arch= new DataInputStream(new FileInputStream("Score.dat"));
          while(true)
            {
                nombres=arch.readUTF(); 
                edad=arch.readInt();
                barcosUs=arch.readInt();
                Score s= new Score(nombres,edad,barcosUs); 
                score.add(s);                
            }        
    }  
  
   
    public static void main(String[] args){
        Batlleship fr= new Batlleship();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public JTextField getJtNombre(){return jtNombre;}
    
    public void setJtNombre(JTextField jtNombre){this.jtNombre = jtNombre;}

    public JTextField getJtEdad(){return jtEdad;}
    
    public void setJtEdad(JTextField jtEdad){this.jtEdad = jtEdad;}

    public JTextField getJtCoordenadasX(){return jtCoordenadasX;}
    
    public void setJtCoordenadasX(JTextField jtCoordenadasX){this.jtCoordenadasX = jtCoordenadasX;}
    
    public JTextField getJtCoordenadasY(){return jtCoordenadasY;}
    
    public void setJtCoordenadasY(JTextField jtCoordenadasY){this.jtCoordenadasY = jtCoordenadasY;}
    
    public int[][] getTables(){return tables;}
    
    public void setTables(int[][] tables){this.tables = tables;}
    
    public int[][] getBarcoCompara(){return barcoCompara;}
    
    public void setBarcoCompara(int[][] barcoCompara){this.barcoCompara = barcoCompara;}   
    
}