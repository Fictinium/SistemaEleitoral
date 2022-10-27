/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEGUI;

import SECode.Eleicao;
import SECode.Eleitor;
import SECode.Candidato;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static SECode.SecurityConsole.createAssimKeys;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }
    
    
    boolean loggedIn = false;
    Eleitor loggedEleitor;
    ArrayList<Eleitor> eleitores = new ArrayList<>();
    ArrayList<Eleicao> listaEleicao = new ArrayList<>(); //Array de Eleições
    ArrayList<Candidato> candidatos = new ArrayList<>(); //Array de Candidato

    
    //TESTE: Adiciona dois elementos às ao ArrayList<Eleicao>
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
    
    
    //Adiciona à jList (listEleicoes) o nome das eleições presentes no ArrayList<Eleicao>
    public void addLista(){
        addToArraylistaEleicoes();
        DefaultListModel listModel = new DefaultListModel();
        //listEleicoes.setModel(new DefaultComboBoxModel<>(list.get(0).getNome()));
        for (int i = 0; i < listaEleicao.size(); i++){
            listModel.addElement(listaEleicao.get(i).getNome());
        }
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
        jPanelResultados = new javax.swing.JPanel();
        comboBoxEleicoes = new javax.swing.JComboBox<>();
        txtTituloEleicao = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanelEleicoesLayout = new javax.swing.GroupLayout(jPanelEleicoes);
        jPanelEleicoes.setLayout(jPanelEleicoesLayout);
        jPanelEleicoesLayout.setHorizontalGroup(
            jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEleicoesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtFieldNome)
                        .addComponent(txtFieldEmail)
                        .addComponent(txtFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword)
                    .addComponent(txtEmail)
                    .addComponent(txtNome)
                    .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelEleicoesLayout.setVerticalGroup(
            jPanelEleicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEleicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelEleicoesLayout.createSequentialGroup()
                .addGap(51, 51, 51)
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        menuTabs.addTab("Lista de Eleiçõoes", jPanelEleicoes);

        comboBoxEleicoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(txtTituloEleicao)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTituloEleicao))
                .addContainerGap(383, Short.MAX_VALUE))
        );

        menuTabs.addTab("Resultados", jPanelResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuTabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        menuTabs.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean autenticado = false;
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String email = txtFieldEmail.getText();
        String password = txtFieldPassword.getSelectedText();
        for(Eleitor eleitor: eleitores){
            if(email.equals(eleitor.getEmail())){
                try {
                    byte[] encryptedPass = Files.readAllBytes(Paths.get(email + "EncryptedPassword"));
                    byte[] decryptedPass = SecurityUtils.decrypt(encryptedPass, eleitor.getPrivateKey());
                    if(decryptedPass.equals((email + password).getBytes(Charset.forName("UTF-8")))){
                        loggedEleitor = eleitor;
                        loggedIn = true;
                        break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtFieldNome.setText("");
        txtFieldEmail.setText("");
        txtFieldPassword.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

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
        } else if(autenticado){
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
    }//GEN-LAST:event_listEleicoesMouseClicked

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        try {
            String nome = txtFieldNome.getText();
            String email = txtFieldEmail.getText();
            String password = txtFieldPassword.getSelectedText();
            Eleitor eleitor = new Eleitor(nome, email, password);
            createAssimKeys(eleitor);
            eleitores.add(eleitor);
        } catch (Exception ex) {
            Logger.getLogger(SEGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistarActionPerformed
    
    // Adiciona RadioButtons a um grupo e ao JPanel
        public void addRadioOption(JPanel p, ButtonGroup g, String t) {
            JRadioButton b = new JRadioButton(t);
            b.setActionCommand(t);
            p.add(b);
            g.add(b);
         }
    
         // Variavel global grupo e boolean votação
        ButtonGroup grupo = null;
        boolean votacao = false;


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
        
        // Proocura index da Tab/aba com o nome "Votar" e fecha-a
        for (i=0; i < tabCount; i++) {
          String tabTitle = menuTabs.getTitleAt(i);
          if(tabTitle.equals("Votar")){
            menuTabs.remove(i);
            votacao = false;
          };
        }
        menuTabs.setSelectedIndex(0);
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
    private javax.swing.JComboBox<String> comboBoxEleicoes;
    private javax.swing.JPanel jPanelEleicoes;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listEleicoes;
    private javax.swing.JTabbedPane menuTabs;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldNome;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPassword;
    private javax.swing.JLabel txtTituloEleicao;
    // End of variables declaration//GEN-END:variables
}
