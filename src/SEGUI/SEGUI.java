/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEGUI;

import SECode.Eleicao;
import SECode.Eleitor;
import SECode.Candidato;

import static SECode.SecurityConsole.createAssimKeys;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import static SECode.SecurityConsole.createAssimKeys;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import security.integrity.Integrity;
import utils.SecurityUtils;
import utils.SecurityUtils;

/**
 *
 * @author Utilizador
 */
public class SEGUI extends javax.swing.JFrame {

    /**
     * Creates new form SEGUI
     */
    public SEGUI() {
        initComponents();
        addLista();
        addToArrayCandidatos();
        addToComboBox();
    }
    
    //variável para verificar de existe um utilizador autenticado
    boolean loggedIn = false;
    //variável para tratar do utilizador autenticado
    Eleitor loggedEleitor;
    //lista de eleitores totais
    ArrayList<Eleitor> eleitores = new ArrayList<>();
    //lista de eleições totais
    ArrayList<Eleicao> listaEleicao = new ArrayList<>();
    //lista de candidatos totais
    ArrayList<Candidato> candidatos = new ArrayList<>();
    // Variavel global grupo e boolean votação
    ButtonGroup grupo = null;
    boolean votacao = false;

    
    //TESTE: Adiciona três elementos às ao ArrayList<Eleicao>
    public void addToArraylistaEleicoes(){
        Eleicao default1 = new Eleicao("Associação de Estudantes", null, null);
        Eleicao default2 = new Eleicao("Nucleo de Estudantes", null, null);
        Eleicao default3 = new Eleicao("Presidencia", null, null);
 
        listaEleicao.add(default1);
        listaEleicao.add(default2);
        listaEleicao.add(default3);
    }
    
    //TESTE: Adiciona dois elementos às ao ArrayList<Candidatos>
    public void addToArrayCandidatos(){
        Candidato candidato1 = new Candidato("Candidato 1");
        Candidato candidato2 = new Candidato("Candidato 2");
 
        candidatos.add(candidato1);
        candidatos.add(candidato2);
    }
    
    //TESTE: Adiciona as eleições à lista dropdown dos resultados
    public void addToComboBox(){
        for(Eleicao eleicao: listaEleicao){
            comboBoxEleicoes.addItem(eleicao.getNome());
        }
    }
    
    //Adiciona à jList (listEleicoes) o nome das eleições presentes no ArrayList<Eleicao>
    public void addLista(){
        addToArraylistaEleicoes();
        DefaultListModel listModel = new DefaultListModel();
        //listEleicoes.setModel(new DefaultComboBoxModel<>(list.get(0).getNome()));
        for (int i = 0; i < listaEleicao.size(); i++){
            listModel.addElement(listaEleicao.get(i).getNome());
        }
        //adiciona todas as eleições ao painel "listEleicoes" (parte da UI)
        listEleicoes.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabs = new javax.swing.JTabbedPane();
        jPanelEleicoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEleicoes = new javax.swing.JList<>();
        txtFieldNome = new javax.swing.JTextField();
        txtFieldEmail = new javax.swing.JTextField();
        txtFieldPassword = new javax.swing.JPasswordField();
        btnLimpar = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        btnRegistar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAlert = new javax.swing.JTextPane();
        jPanelResultados = new javax.swing.JPanel();
        comboBoxEleicoes = new javax.swing.JComboBox<>();
        txtTituloEleicao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        votacoesTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        candidatosTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuTabs.setToolTipText("");

        listEleicoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listEleicoes.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        listEleicoes.setToolTipText("");
        listEleicoes.setName(""); // NOI18N
        listEleicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listEleicoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listEleicoes);

        txtFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNomeActionPerformed(evt);
            }
        });

        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });

        txtFieldPassword.setToolTipText("");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtPassword.setText("Password");

        txtEmail.setText("Email");

        txtNome.setText("Nome");

        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        txtAlert.setEditable(false);
        txtAlert.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtAlert.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtAlert.setOpaque(false);
        jScrollPane4.setViewportView(txtAlert);

        javax.swing.GroupLayout jPanelEleicoesLayout = new javax.swing.GroupLayout(jPanelEleicoes);
        jPanelEleicoes.setLayout(jPanelEleicoesLayout);
        jPanelEleicoesLayout.setHorizontalGroup(
            jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEleicoesLayout.createSequentialGroup()
                .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtFieldNome)
                                .addComponent(txtFieldEmail)
                                .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegistar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtPassword)
                            .addComponent(txtEmail)
                            .addComponent(txtNome)))
                    .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEleicoesLayout.setVerticalGroup(
            jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        menuTabs.addTab("Lista de Eleiçõoes", jPanelEleicoes);

        comboBoxEleicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEleicoesActionPerformed(evt);
            }
        });

        votacoesTextArea.setColumns(20);
        votacoesTextArea.setRows(5);
        jScrollPane2.setViewportView(votacoesTextArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Candidatos");

        candidatosTextArea.setColumns(20);
        candidatosTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        candidatosTextArea.setRows(5);
        jScrollPane3.setViewportView(candidatosTextArea);

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(comboBoxEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(txtTituloEleicao)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTituloEleicao))
                .addGap(31, 31, 31)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );

        menuTabs.addTab("Resultados", jPanelResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        menuTabs.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //código para um cliente se autenticar quando se clica no botão "btnEntrar"
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        //email (string) inserido na caixa de texto "txtFieldEmail"
        String email = txtFieldEmail.getText();
        //password (string) inserida na caixa de texto "txtFieldPassword"
        String password = String.valueOf(txtFieldPassword.getPassword());
        //loop "for each" que verifica se o email inserido existe na BD
        for(Eleitor eleitor: eleitores){
            //if statement que compara o email inserido com o email da BD
            if(email.equals(eleitor.getEmail())){
                try {
                    //processo de decriptação (processo de encriptação no ficheiro SecurityConsole.java inverso)
                    byte[] encryptedPass = Files.readAllBytes(Paths.get(email + "EncryptedPassword"));
                    byte[] decryptedPass = SecurityUtils.decrypt(encryptedPass, eleitor.getPrivateKey());
                    String passHashString = Arrays.toString(Integrity.getHash(password.getBytes("UTF-8"), "SHA-256"));
                    //verificação da palavra-passe (se estiver correta, entra)
                    if(Arrays.equals(decryptedPass, (email + passHashString).getBytes(Charset.forName("UTF-8")))){
                        //alterar o utilizador autenticado
                        loggedEleitor = eleitor;
                        //sinal de que alguém está eutenticado
                        loggedIn = true;
                        //caixa de texto que confirma que o login foi bem sucedido
                        txtAlert.setText("Successfully logged in!");
                        //limpa os dados das caixas de texto
                        txtFieldNome.setText("");
                        txtFieldEmail.setText("");
                        txtFieldPassword.setText("");
                        break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }                                         

    //função para limpar os espaços de texto
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtFieldNome.setText("");
        txtFieldEmail.setText("");
        txtFieldPassword.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed
    
    //função para registar um novo utilizador
    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        try {
            //if statement para verificar se alguma caixa de texto foi deixada em branco
            if(txtFieldNome.getText().isBlank() || txtFieldEmail.getText().isBlank() || String.valueOf(txtFieldPassword.getPassword()).isBlank()){
                String auxTxt = "";
                //se o nome não foi preenchido, avisa
                if(txtFieldNome.getText().isBlank()){
                    auxTxt += "Name is missing.";
                    auxTxt += "\n";
                }
                //se o email não foi preenchido, avisa
                if(txtFieldEmail.getText().isBlank()){
                    auxTxt += "E-mail is missing.";
                    auxTxt += "\n";
                }
                //sea password não foi preenchida, avisa
                if(String.valueOf(txtFieldPassword.getPassword()).isBlank()){
                    auxTxt += "Password is missing.";
                }
                txtAlert.setText(auxTxt);
            }else{
                //variável auxiliar
                boolean match = false;
                //email inserido
                String email = txtFieldEmail.getText();
                //loop for que verifica se já existe um utilizador com este email
                for(Eleitor eleitor: eleitores){
                    if(eleitor.getEmail().equals(email)) match = true; break;
                }
                //se o email ainda não estiver registado, regista o novo utilizador
                if(!match){
                    //criação do eleitor com o dados inseridos
                    String nome = txtFieldNome.getText();
                    String password = String.valueOf(txtFieldPassword.getPassword());
                    Eleitor eleitor = new Eleitor(nome, email, password);
                    //criação das chaves assimétricas do utilizador
                    createAssimKeys(eleitor);
                    //adição do utilizador à BD
                    eleitores.add(eleitor);
                    //caixa de texto que confirma que o registo foi bem sucedido
                    txtAlert.setText("Account successfully registered!");
                    //limpa os dados das caixas de texto
                    txtFieldNome.setText("");
                    txtFieldEmail.setText("");
                    txtFieldPassword.setText("");
                }else{
                    //se o email já existir, mostra uma caixa de texto para avisar
                    txtAlert.setText("This user already exists!");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistarActionPerformed

    // Após selecionar uma eleição da lista, cria uma nova tab com todos os candidatos
    private void listEleicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEleicoesMouseClicked
        if(votacao){
            String[] buttons = { "Fechar votação ativa", "Ok" };
            int aviso = JOptionPane.showOptionDialog(null, "Já se encontra com uma votação ativa, feche-a ou proceda ao voto", "Aviso!",JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
            if (aviso == JOptionPane.NO_OPTION) {
                System.out.println("Não apagar");
            } else if (aviso == JOptionPane.YES_OPTION) {
                fechaAbaVotar();
            } else if (aviso == JOptionPane.CLOSED_OPTION) {
                System.out.println("Aviso fechado");
            }
        }else if(loggedIn){
            votacao = true;
            // Recebe texto do elemento escolhido na lista
            JList target = (JList)evt.getSource();
            int index = target.locationToIndex(evt.getPoint());
            Object item = target.getModel().getElementAt(index);
            
            //Imprime na consola o item selecionado da listaEleicoes
            System.out.println(item.toString());

            JPanel panel = new JPanel();
            JPanel panelRadioButtons = new JPanel();
            JPanel panelButtons = new JPanel();
            JLabel nomeEleicao = new JLabel();
            JPanel teste = new JPanel();
            
            teste.setLayout(new GridBagLayout());

            
            //Centra todo o conteudo do JPanel principal
            panel.setLayout(new GridBagLayout());
            panel.add(panelRadioButtons);
            //Coloca os elementos jRadioButtons criados na vertical
            panelRadioButtons.setLayout(new BoxLayout(panelRadioButtons, BoxLayout.Y_AXIS));
            
            nomeEleicao.setText(item.toString());
            
            Font font=new Font("ARIAL",Font.CENTER_BASELINE,20);
            nomeEleicao.setFont(font);
            //nomeEleicao.setBounds(100,50,100,100);


            teste.add(nomeEleicao);

            // Cria botão votar e botão cancelar
            JButton btn = new JButton("Votar");
            JButton btnCancelar = new JButton("Cancelar");
            grupo = new ButtonGroup();

            // Adiciona RadioButtons ao grupo e ao JPanel com o nome de todos os candidatos na ArrayList Candidatos
            for (int i = 0; i < candidatos.size(); i++){
                addRadioOption(panelRadioButtons,grupo,candidatos.get(i).getNome());
            }

            // Adiciona evento ao clicar no botão "btn" e adiciona-o ao JPanel
            btn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {btnVotarActionPerformed(e);}
            });

            // Botão cancelar, apaga tudo e fecha a Tab
            btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e){
                    panel.removeAll();
                    grupo.clearSelection();
                    fechaAbaVotar();
                }
            });

            panelButtons.add(btn);
            panelButtons.add(btnCancelar);
            panelRadioButtons.add(panelButtons);
            teste.add(panel);
            // Cria nova tab na interface do programa com o nome votar
            menuTabs.addTab("Votar", panel);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os seus dados primeiro", "Aviso!",JOptionPane.WARNING_MESSAGE);
        }
    }                                         
    
    // Adiciona RadioButtons a um grupo e ao JPanel
    public void addRadioOption(JPanel p, ButtonGroup g, String t) {
        JRadioButton b = new JRadioButton(t);
        b.setActionCommand(t);
        p.add(b);
        g.add(b);
    }

    // Ação do botão votar, este adquire o texto do RadioButton selecionado e imprime-o no terminal
    public void btnVotarActionPerformed(ActionEvent e) {
        ButtonModel b = grupo.getSelection();
        String t = "Voto em Branco";
        if (b!=null){
            t = b.getActionCommand();
        }
        System.out.println(t);
        fechaAbaVotar();
    }
    
    public void fechaAbaVotar(){
        Component selected = menuTabs.getSelectedComponent();
        int tabCount = menuTabs.getTabCount(), i;
        // Procura index da Tab/aba com o nome "Votar" e fecha-a
        for (i=0; i < tabCount; i++) {
          String tabTitle = menuTabs.getTitleAt(i);
          if(tabTitle.equals("Votar")){
            menuTabs.remove(i);
            votacao = false;
          };
        }
        menuTabs.setSelectedIndex(0);
    }//GEN-LAST:event_listEleicoesMouseClicked

    private void comboBoxEleicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEleicoesActionPerformed
        //obter o nome da eleição selecionada
        String nomeEleicao = comboBoxEleicoes.getItemAt(comboBoxEleicoes.getSelectedIndex());
        //variáveis que vão armazenar a eleição selecionada e a respetiva lista de candidatos
        Eleicao eleicao = null;
        ArrayList<Candidato> candidatosEleicao = null;
        //loop for each que encontra e seleciona a eleição pretendida
        for(Eleicao eleicaoi: listaEleicao){
            if(eleicaoi.getNome().equals(nomeEleicao)){
                eleicao = eleicaoi;
                candidatosEleicao = eleicao.getListaCandidatos();
                break;
            }
        }
        //insere os noomes dos candidatos da eleição escolhida na caixa de texto "candidatosTextArea", para visualização
        for(Candidato candidato: candidatosEleicao){
            candidatosTextArea.append(candidato.getNome() + "\n");
        }
        //loop for each para mostrar todas as votações da eleição escolhida (for each the cada eleitor)
        for(Eleitor eleitor: eleicao.getListaEleitores()){
            //insere a parte inicial da caixa de texto "votacoesTextArea" (nome de um eleitor)
            votacoesTextArea.append(eleitor.getNome() + " -------> ");
            //lista de candidatos em que o eleitor votou
            ArrayList<Candidato> candidatosVotados = eleitor.getListaVotacoes();
            //dois loops for each para encontrar o candidato em que o eleitor votou, relevante para a eleição selecionada
            for(Candidato candidatoVotado: candidatosVotados){
                for(Candidato candidato: candidatosEleicao){
                    if(candidatoVotado.getId() == candidato.getId()){
                        //quando encontra o candidato, insere o seu nome na caixa de texto "votacoesTextArea"
                        votacoesTextArea.append(candidato.getNome() + "\n");
                    }
                }
            }
        }
    }//GEN-LAST:event_comboBoxEleicoesActionPerformed

    private void txtFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNomeActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SEGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JTextArea candidatosTextArea;
    private javax.swing.JComboBox<String> comboBoxEleicoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelEleicoes;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listEleicoes;
    private javax.swing.JTabbedPane menuTabs;
    private javax.swing.JTextPane txtAlert;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldNome;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPassword;
    private javax.swing.JLabel txtTituloEleicao;
    private javax.swing.JTextArea votacoesTextArea;
    // End of variables declaration//GEN-END:variables
}
