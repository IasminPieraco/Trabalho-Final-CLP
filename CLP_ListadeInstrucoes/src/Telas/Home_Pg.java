/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import compiladorinstructionlist.edit.Colors;
import compiladorinstructionlist.edit.Language;
import javax.swing.ImageIcon;
import compiladorinstructionlist.interpreter.Interpreter;
import compiladorinstructionlist.input.InputActions;
import compiladorinstructionlist.memoryvariable.MemoryVariable;
import compiladorinstructionlist.output.OutputActions;
import compiladorinstructionlist.uppercasedocumentfilter.UpperCaseDocumentFilter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author vinic
 */
public final class Home_Pg extends javax.swing.JFrame {


     // Cria variáveis
    static Map<String, Integer> inputsType;
    static Map<String, Boolean> inputs;
    static Map<String, Boolean> outputs;
    static Map<String, MemoryVariable> memoryVariables = new HashMap<>();
    static Integer mode = 1;
    static Integer color = 1;
    private final JTextArea Lista_de_variaveis;
    Lista_de_variaveis_Pg tela2 = new Lista_de_variaveis_Pg();

    @SuppressWarnings("unchecked")
    public Home_Pg() {
        initComponents();
        Lista_de_variaveis = tela2.getListaDeVariaveis();
        //setando informaçoes iniciais
        ImageIcon icon = new ImageIcon("src/Assets/led_desligado.png");
        icon.setImage( icon.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Saida_1.setIcon(icon);
        Saida_2.setIcon(icon);
        Saida_3.setIcon(icon);
        Saida_4.setIcon(icon);
        Saida_5.setIcon(icon);
        Saida_6.setIcon(icon);
        Saida_7.setIcon(icon);
        Saida_8.setIcon(icon);
        ImageIcon icon1 = new ImageIcon("src/Assets/chave_aberta.png");
        icon1.setImage( icon1.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Entrada_1.setIcon(icon1);
        Entrada_2.setIcon(icon1);
        Entrada_3.setIcon(icon1);
        Entrada_4.setIcon(icon1);
        Entrada_5.setIcon(icon1);
        Entrada_6.setIcon(icon1);
        Entrada_7.setIcon(icon1);
        Entrada_8.setIcon(icon1);
        ImageIcon iconplay = new ImageIcon("src/Assets/start.png");
        iconplay.setImage( iconplay.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
        Run_BT.setIcon(iconplay);
        ImageIcon iconpause = new ImageIcon("src/Assets/pause.png");
        iconpause.setImage( iconpause.getImage().getScaledInstance(Pause_BT.getWidth(), Pause_BT.getHeight(),1));
        Pause_BT.setIcon(iconpause);
        
        
        ImageIcon iconBarra = new ImageIcon("src/Assets/Barra_Lateral.png");
        iconBarra.setImage( iconBarra.getImage().getScaledInstance(Variaveis_BT.getWidth(),Variaveis_BT.getHeight(),1));
        Variaveis_BT.setIcon(iconBarra);
        
        
        
        ImageIcon iconCampo = new ImageIcon("src/Assets/bloco_notas.png");
        iconCampo.setImage( iconCampo.getImage().getScaledInstance(Codigo_Camp.getWidth(),Codigo_Camp.getHeight(),1));
        Image_Camp.setIcon(iconCampo);
        
        
        Codigo_Camp.setOpaque(false);
        
        
        AbstractDocument doc = (AbstractDocument) Codigo_Camp.getDocument();
        doc.setDocumentFilter(new UpperCaseDocumentFilter());
        //Inicializa entradas e saídas
        inputsType = new HashMap<>();
        inputs = new HashMap<>();
        outputs = new HashMap<>();
        inputsType = InputActions.createType(inputsType);
        inputs = InputActions.create(inputs);
        System.out.println("HashMap de entradas criado:" + inputs);
        outputs = OutputActions.create(outputs);
        // System.out.println("assaa");
        System.out.println("HashMap de saídas criado:" + outputs);
        // Atualiza entradas e saídas na tela
        updateScreen();
        
    }
    
    public void setColor(Boolean value, JLabel label) {
        if (value) {
            label.setForeground(Color.green);
        } else {
            label.setForeground(Color.red);
        }
    }

    // Atualiza entradas e saídas na tela
    public void updateScreen() {
        ImageIcon icon1 = new ImageIcon("src/Assets/chave_aberta.png");
        icon1.setImage( icon1.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        ImageIcon icon2 = new ImageIcon("src/Assets/chave_fechada.png");
        icon2.setImage( icon2.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        ImageIcon icon3 = new ImageIcon("src/Assets/buttom.png");
        icon3.setImage( icon3.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        ImageIcon icon4 = new ImageIcon("src/Assets/buttom_pi.png");
        icon4.setImage( icon4.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Entrada_1.setIcon(inputsType.get("I1") == 0?inputs.get("I1")?icon2:icon1:inputsType.get("I1") == 1?icon3:icon4);
        Entrada_2.setIcon(inputsType.get("I2") == 0?inputs.get("I2")?icon2:icon1:inputsType.get("I2") == 1?icon3:icon4);
        Entrada_3.setIcon(inputsType.get("I3") == 0?inputs.get("I3")?icon2:icon1:inputsType.get("I3") == 1?icon3:icon4);
        Entrada_4.setIcon(inputsType.get("I4") == 0?inputs.get("I4")?icon2:icon1:inputsType.get("I4") == 1?icon3:icon4);
        Entrada_5.setIcon(inputsType.get("I5") == 0?inputs.get("I5")?icon2:icon1:inputsType.get("I5") == 1?icon3:icon4);
        Entrada_6.setIcon(inputsType.get("I6") == 0?inputs.get("I6")?icon2:icon1:inputsType.get("I6") == 1?icon3:icon4);
        Entrada_7.setIcon(inputsType.get("I7") == 0?inputs.get("I7")?icon2:icon1:inputsType.get("I7") == 1?icon3:icon4);
        Entrada_8.setIcon(inputsType.get("I8") == 0?inputs.get("I8")?icon2:icon1:inputsType.get("I8") == 1?icon3:icon4);
        
        icon3 = new ImageIcon("src/Assets/led_desligado.png");
        icon3.setImage( icon3.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        icon4 = new ImageIcon("src/Assets/led_ligado.png");
        icon4.setImage( icon4.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Saida_1.setIcon(outputs.get("Q1")?icon4:icon3);
        Saida_2.setIcon(outputs.get("Q2")?icon4:icon3);
        Saida_3.setIcon(outputs.get("Q3")?icon4:icon3);
        Saida_4.setIcon(outputs.get("Q4")?icon4:icon3);
        Saida_5.setIcon(outputs.get("Q5")?icon4:icon3);
        Saida_6.setIcon(outputs.get("Q6")?icon4:icon3);
        Saida_7.setIcon(outputs.get("Q7")?icon4:icon3);
        Saida_8.setIcon(outputs.get("Q8")?icon4:icon3);
    }

    // Atualiza o modo atual na tela
    public void updateMode() {
        System.out.println("Modo atual: " + mode);
        if (null == mode) {
            Codigo_Camp.setEditable(false);
            ImageIcon icon1 = new ImageIcon("src/Assets/start_verde.png");
            icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
            Run_BT.setIcon(icon1);
        } else switch (mode) {
            case 1 ->                 {
                    Codigo_Camp.setEditable(true);
                    ImageIcon icon1 = new ImageIcon("src/Assets/start.png");
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                //jSpinner1.setEditable(true);
                }
            case 2 ->                 {
                    Codigo_Camp.setEditable(false);
                    ImageIcon icon1 = new ImageIcon("src/Assets/start.png");
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                }
            default ->                 {
                    Codigo_Camp.setEditable(false);
                    ImageIcon icon1 = new ImageIcon("src/Assets/start_verde.png");
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                }
        }
    }

    // Atualiza as variáveis de memória na tela
    public void updateMemoryVariables() {
        StringBuilder textBuilder = new StringBuilder();
    
        for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
            String line = "";
            switch (variable.getKey().charAt(0)) {
                case 'M' -> line = variable.getKey() + " = " + variable.getValue().currentValue + "\n";
                case 'T' -> line = variable.getKey() + " = " + variable.getValue().currentValue + ", " + variable.getValue().counter + ", " + variable.getValue().maxTimer + ", " + variable.getValue().endTimer + "\n";
                case 'C' -> line = variable.getKey() + " = " + variable.getValue().counter + ", " + variable.getValue().maxTimer + ", " + variable.getValue().endTimer + "\n";
                default -> {
                }
            }
            textBuilder.append(line);
        }
        
        String textToSet = textBuilder.toString();
        System.out.println("Setting text to JTextArea: " + textToSet);
    
        SwingUtilities.invokeLater(() -> {
            Lista_de_variaveis.setText(textToSet);
            System.out.println("Text set in JTextArea.");
        });
    }

    // Mostra mensagem de erro na tela
    public static void showErrorMessage(String message) {
        mode = 1;
        JOptionPane.showMessageDialog(null, message);
    }
    
    
    private List<String> saveLines(List<String> lineList) {
        int quant = Codigo_Camp.getLineCount();

        for (int i = 0; i < quant; i++) {
            try {
                Integer start = Codigo_Camp.getLineStartOffset(i);
                Integer end = Codigo_Camp.getLineEndOffset(i);
                String line = Codigo_Camp.getText(start, end - start);
                lineList.add(line);
            } catch (BadLocationException ex) {
                Logger.getLogger(Home_Pg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Lista de linhas: " + lineList);
        return lineList;
    }
    
    @SuppressWarnings("rawtypes")
    public Map setaBit(Map<String,Boolean> inputs){
        Boolean input = inputs.get("I1");
        inputs.clear();
        inputs.put("I1", !input);
        inputs.put("I2", !input);
        inputs.put("I3", !input);
        inputs.put("I4", !input);
        inputs.put("I5", !input);
        inputs.put("I6", !input);
        inputs.put("I7", !input);
        inputs.put("I8", !input);
        return inputs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Simulacoes = new javax.swing.JComboBox<>();
        Run_BT = new javax.swing.JButton();
        Arquivar_BT = new javax.swing.JComboBox<>();
        Editar_BT = new javax.swing.JComboBox<>();
        Help_BT = new javax.swing.JButton();
        Sobre_BT = new javax.swing.JButton();
        Pause_BT = new javax.swing.JButton();
        Variaveis_BT = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Label_Delay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Saida_1 = new javax.swing.JLabel();
        Saida_2 = new javax.swing.JLabel();
        Saida_4 = new javax.swing.JLabel();
        Saida_3 = new javax.swing.JLabel();
        Saida_5 = new javax.swing.JLabel();
        Saida_6 = new javax.swing.JLabel();
        Saida_7 = new javax.swing.JLabel();
        Saida_8 = new javax.swing.JLabel();
        Label_Entradas = new javax.swing.JLabel();
        Label_Saidas = new javax.swing.JLabel();
        Entrada_5 = new javax.swing.JLabel();
        Entrada_1 = new javax.swing.JLabel();
        Entrada_6 = new javax.swing.JLabel();
        Entrada_2 = new javax.swing.JLabel();
        Entrada_8 = new javax.swing.JLabel();
        Entrada_4 = new javax.swing.JLabel();
        Entrada_7 = new javax.swing.JLabel();
        Entrada_3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Color_Camp = new javax.swing.JPanel();
        Codigo_Camp = new javax.swing.JTextArea();
        Image_Camp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Instruçoes CLP");
        setBackground(new java.awt.Color(255, 255, 255));

        Simulacoes.setBackground(new java.awt.Color(8, 94, 131));
        Simulacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Painel", "Simulação 1", "Simulação 2", "Simulação 3" }));
        Simulacoes.addActionListener(this::SimulacoesActionPerformed);

        Run_BT.setFont(new java.awt.Font("Segoe UI", 0, 5)); // NOI18N
        Run_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/start.png"))); // NOI18N
        Run_BT.setToolTipText("");
        Run_BT.setAlignmentY(0.0F);
        Run_BT.setAutoscrolls(true);
        Run_BT.setBorder(null);
        Run_BT.setDisabledIcon(null);
        Run_BT.setIconTextGap(0);
        Run_BT.setMaximumSize(new java.awt.Dimension(50, 50));
        Run_BT.setMinimumSize(new java.awt.Dimension(50, 50));
        Run_BT.addActionListener(this::Run_BTBT_Run_Pressionado);

        Arquivar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquivar", "Salvar", "Item 3", "Item 4" }));

        Editar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Editar", "Tema", "Idioma" }));
<<<<<<< Updated upstream
=======
        Editar_BT.addActionListener(this::Editar_BTActionPerformed);
>>>>>>> Stashed changes

        Help_BT.setText("Help");

        Sobre_BT.setText("Sobre");
        Sobre_BT.addActionListener(this::Sobre_BTActionPerformed);

        Pause_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pause.png"))); // NOI18N
        Pause_BT.setOpaque(true);
        Pause_BT.addActionListener(this::Pause_BTActionPerformed);

<<<<<<< Updated upstream
=======
        Variaveis_BT.addActionListener(this::Variaveis_BTA);

>>>>>>> Stashed changes
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Label_Delay.setText("Tempo de Delay em ms:");

        jPanel1.setBackground(new java.awt.Color(142, 177, 199));

        Saida_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Label_Entradas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Entradas.setText("Entradas");

        Label_Saidas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Saidas.setText("Saidas");

        Entrada_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_5MousePressed(evt);
            }
        });

        Entrada_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_1MousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_1MouseReleased(evt);
            }
        });

        Entrada_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_6MousePressed(evt);
            }
        });

        Entrada_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_2MousePressed(evt);
            }
        });

        Entrada_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_8.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_8MousePressed(evt);
            }
        });

        Entrada_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_4MousePressed(evt);
            }
        });

        Entrada_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_7MousePressed(evt);
            }
        });

        Entrada_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saida_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saida_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(Label_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Saida_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Saida_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Saida_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entrada_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entrada_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Saida_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Saida_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Saida_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Saida_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(Saida_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(Label_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(8, 94, 131));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        Color_Camp.setBackground(new java.awt.Color(0, 102, 204));
        Color_Camp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Codigo_Camp.setBackground(new java.awt.Color(255, 255, 255));
        Codigo_Camp.setColumns(20);
        Codigo_Camp.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        Codigo_Camp.setForeground(new java.awt.Color(255, 255, 255));
        Codigo_Camp.setRows(5);
        Codigo_Camp.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Codigo_Camp.setDragEnabled(true);
        Codigo_Camp.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        Codigo_Camp.setSelectionColor(new java.awt.Color(204, 204, 204));
        Color_Camp.add(Codigo_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 630));

        Image_Camp.setForeground(new java.awt.Color(0, 0, 0));
        Color_Camp.add(Image_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 370, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Color_Camp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Help_BT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sobre_BT)
                                .addGap(102, 102, 102))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Delay))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sobre_BT)
                            .addComponent(Help_BT)
                            .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Delay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Color_Camp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SimulacoesActionPerformed
    @SuppressWarnings("unchecked")
    private void Run_BTBT_Run_Pressionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Run_BTBT_Run_Pressionado
        if(mode != 3){
            System.out.println("\nBotão run clicado!");
            mode = 3;
            // Verificando tempo de delay
            String stringTime = jSpinner1.getValue().toString();
            Integer time = 0;

            if (!stringTime.equals("")) {
                try {
                    time = Integer.valueOf(stringTime);
                } catch (NumberFormatException e) {
                    mode = 1;
                    updateMode();
                    showErrorMessage("Tempo de delay inválido! Insira um número inteiro.");
                }

                System.out.println("Tempo de delay: " + time + "\n");
            }

            // Executa o laço corretamente sem travar a tela 
            Timer timer = new Timer(time, (ActionEvent evt1) -> {
                // Salva linhas da área de texto
                List<String> lineList = new ArrayList<>();
                lineList = saveLines(lineList);
                if (mode == 3) {
                    //inputs = InputActions.dummyRead(inputs);
                    inputs = InputActions.read(inputs);
                    outputs = OutputActions.setAllFalse(outputs);
                    outputs = Interpreter.receiveLines(lineList, inputs, outputs, memoryVariables);
                    for(Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()){
                        if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("ON") && variable.getValue().currentValue == true)
                            variable.getValue().timer.start();
                        else if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("ON") && variable.getValue().currentValue == false){
                            variable.getValue().timer.stop();
                            variable.getValue().counter = 0;
                            variable.getValue().endTimer = false;
                        }
                        if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("OFF") && variable.getValue().currentValue == true){
                            variable.getValue().timer.stop();
                            variable.getValue().counter = 0;
                            variable.getValue().endTimer = true;
                        }else if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("OFF") && variable.getValue().currentValue == false){
                            variable.getValue().timer.start();
                        }
                    }
                    //outputs = OutputActions.dummyWrite(outputs);
                    outputs = OutputActions.write(outputs);
                    updateMode();
                    updateScreen();
                    updateMemoryVariables();
                } else {
                    ((Timer) evt1.getSource()).stop();
                }
            });

            timer.setInitialDelay(0); // começa sem atraso
            timer.start();
        }else{
            System.out.println("\nBotão stop clicado!");
            mode = 2;
            for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
                if(variable.getKey().charAt(0) == 'T'){
                    variable.getValue().timer.stop();
                }
            }
            updateMemoryVariables();
            updateMode();
        }
    }//GEN-LAST:event_Run_BTBT_Run_Pressionado
<<<<<<< Updated upstream

=======
    private void Variaveis_BTA(java.awt.event.ActionEvent evt){
        tela2.setVisible(true);
        tela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela2.setLocation(1100,0);
    }
>>>>>>> Stashed changes
    private void Pause_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pause_BTActionPerformed
        System.out.println("\nBotão program clicado!");
        mode = 1;
        for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
            if(variable.getKey().charAt(0) == 'T'){
                variable.getValue().counter = 0;
                variable.getValue().timer.stop();
            }
        }
        updateMemoryVariables();
        updateMode();
    }//GEN-LAST:event_Pause_BTActionPerformed

    private void Sobre_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sobre_BTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sobre_BTActionPerformed

    private void Entrada_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_1MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I1") == 0)
                inputs.put("I1", !inputs.get("I1"));
            if(inputsType.get("I1") == 1)
                inputs.put("I1", true);
            if(inputsType.get("I1") == 2)
                inputs.put("I1", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I1");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I1", val);
            if(val == 0 || val == 1){
                inputs.put("I1", false);
            }else{
                inputs.put("I1", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_1MousePressed

    private void Entrada_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_2MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I2") == 0)
                inputs.put("I2", !inputs.get("I2"));
            if(inputsType.get("I2") == 1)
                inputs.put("I2", true);
            if(inputsType.get("I2") == 2)
                inputs.put("I2", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I2");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I2", val);
            if(val == 0 || val == 1){
                inputs.put("I2", false);
            }else{
                inputs.put("I2", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_2MousePressed

    private void Entrada_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_3MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I3") == 0)
                inputs.put("I3", !inputs.get("I3"));
            if(inputsType.get("I3") == 1)
                inputs.put("I3", true);
            if(inputsType.get("I3") == 2)
                inputs.put("I3", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I3");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I3", val);
            if(val == 0 || val == 1){
                inputs.put("I3", false);
            }else{
                inputs.put("I3", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_3MousePressed

    private void Entrada_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_4MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I4") == 0)
                inputs.put("I4", !inputs.get("I4"));
            if(inputsType.get("I4") == 1)
                inputs.put("I4", true);
            if(inputsType.get("I4") == 2)
                inputs.put("I4", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I4");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I4", val);
            if(val == 0 || val == 1){
                inputs.put("I4", false);
            }else{
                inputs.put("I4", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_4MousePressed

    private void Entrada_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_5MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I5") == 0)
                inputs.put("I5", !inputs.get("I5"));
            if(inputsType.get("I5") == 1)
                inputs.put("I5", true);
            if(inputsType.get("I5") == 2)
                inputs.put("I5", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I5");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I5", val);
            if(val == 0 || val == 1){
                inputs.put("I5", false);
            }else{
                inputs.put("I5", true);
            }
            updateScreen();
        } 
    }//GEN-LAST:event_Entrada_5MousePressed

    private void Entrada_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_6MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I6") == 0)
                inputs.put("I6", !inputs.get("I6"));
            if(inputsType.get("I6") == 1)
                inputs.put("I6", true);
            if(inputsType.get("I6") == 2)
                inputs.put("I6", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I6");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I6", val);
            if(val == 0 || val == 1){
                inputs.put("I6", false);
            }else{
                inputs.put("I6", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_6MousePressed

    private void Entrada_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_7MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I7") == 0)
                inputs.put("I7", !inputs.get("I7"));
            if(inputsType.get("I7") == 1)
                inputs.put("I7", true);
            if(inputsType.get("I7") == 2)
                inputs.put("I7", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I7");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I7", val);
            if(val == 0 || val == 1){
                inputs.put("I7", false);
            }else{
                inputs.put("I7", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_7MousePressed

    private void Entrada_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_8MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I8") == 0)
                inputs.put("I8", !inputs.get("I8"));
            if(inputsType.get("I8") == 1)
                inputs.put("I8", true);
            if(inputsType.get("I8") == 2)
                inputs.put("I8", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I8");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I8", val);
            if(val == 0 || val == 1){
                inputs.put("I8", false);
            }else{
                inputs.put("I8", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_8MousePressed

    private void Editar_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_BTActionPerformed
        if("Tema".equals(Editar_BT.getSelectedItem().toString())){
            Editar_BT.setSelectedIndex(0);
            color++;
            if(color >= 5){
                color = 1;
            }
            setaCores();
        }
        if("Idioma".equals(Editar_BT.getSelectedItem().toString())){
            Editar_BT.setSelectedIndex(0);
            Language.setLingua();
            setaLanguage();
        }
    }//GEN-LAST:event_Editar_BTActionPerformed

    private void Entrada_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_1MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I1") == 1)
                inputs.put("I1", false);
            if(inputsType.get("I1") == 2)
                inputs.put("I1", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_1MouseReleased
    
    private void setaCores(){
        Simulacoes.setBackground(Colors.firstColor(color));
        jPanel2.setBackground(Colors.firstColor(color));
        jPanel1.setBackground(Colors.secondColor(color));
        Codigo_Camp.setBackground(Colors.thirdColor(color));
    }
    
    private void setaLanguage(){
        @SuppressWarnings("rawtypes")
        JComboBox aux = Language.getArquivar();
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.insertItemAt(aux.getItemAt(0).toString(), 0);
        Arquivar_BT.insertItemAt(aux.getItemAt(1).toString(), 1);
        Arquivar_BT.insertItemAt(aux.getItemAt(2).toString(), 2);
        Arquivar_BT.insertItemAt(aux.getItemAt(3).toString(), 3);
        Arquivar_BT.setSelectedIndex(0);
        
        aux = Language.getEditar();
        Editar_BT.removeItemAt(0);
        Editar_BT.removeItemAt(0);
        Editar_BT.removeItemAt(0);
        Editar_BT.insertItemAt(aux.getItemAt(0).toString(), 0);
        Editar_BT.insertItemAt(aux.getItemAt(1).toString(), 1);
        Editar_BT.insertItemAt(aux.getItemAt(2).toString(), 2);
        Editar_BT.setSelectedIndex(0);
        
        aux = Language.getSimulação();
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.insertItemAt(aux.getItemAt(0).toString(), 0);
        Simulacoes.insertItemAt(aux.getItemAt(1).toString(), 1);
        Simulacoes.insertItemAt(aux.getItemAt(2).toString(), 2);
        Simulacoes.insertItemAt(aux.getItemAt(3).toString(), 3);
        Simulacoes.setSelectedIndex(0);
        
        Help_BT.setText(Language.getAjudar());
        Sobre_BT.setText(Language.getSobre());
        Label_Entradas.setText(Language.getEntradas());
        Label_Saidas.setText(Language.getSaidas());
        Label_Delay.setText(Language.getDelay());
    }
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home_Pg().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Arquivar_BT;
    private javax.swing.JTextArea Codigo_Camp;
    private javax.swing.JPanel Color_Camp;
    private javax.swing.JComboBox<String> Editar_BT;
    private javax.swing.JLabel Entrada_1;
    private javax.swing.JLabel Entrada_2;
    private javax.swing.JLabel Entrada_3;
    private javax.swing.JLabel Entrada_4;
    private javax.swing.JLabel Entrada_5;
    private javax.swing.JLabel Entrada_6;
    private javax.swing.JLabel Entrada_7;
    private javax.swing.JLabel Entrada_8;
    private javax.swing.JButton Help_BT;
    private javax.swing.JLabel Image_Camp;
    private javax.swing.JLabel Label_Delay;
    private javax.swing.JLabel Label_Entradas;
    private javax.swing.JLabel Label_Saidas;
    private javax.swing.JButton Pause_BT;
    private javax.swing.JButton Run_BT;
    private javax.swing.JLabel Saida_1;
    private javax.swing.JLabel Saida_2;
    private javax.swing.JLabel Saida_3;
    private javax.swing.JLabel Saida_4;
    private javax.swing.JLabel Saida_5;
    private javax.swing.JLabel Saida_6;
    private javax.swing.JLabel Saida_7;
    private javax.swing.JLabel Saida_8;
    private javax.swing.JComboBox<String> Simulacoes;
    private javax.swing.JButton Sobre_BT;
    private javax.swing.JButton Variaveis_BT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
