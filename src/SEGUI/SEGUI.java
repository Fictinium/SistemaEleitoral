/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEGUI;

import SECode.Eleicao;
import SECode.Eleitor;
import SECode.Candidato;
import SECode.Candidato;
import SECode.Eleicao;
import SECode.Eleitor;

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
import SECode.Voto;
import blockChain.miner.Miner;
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

import blockChain.chain.Block;
import blockChain.miner.Miner;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;
import myUtils.GuiUtils;
import myUtils.RMI;
import blockChain.p2p.miner.ObjectRemoteMiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import blockChain.p2p.miner.InterfaceRemoteMiner;
import blockChain.p2p.miner.ListenerRemoteMiner;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

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
        atualizarEleicoesComboBox();
        menuTabs.remove(1);
    }
    
    public JPanel getPainelVotacoes(){
        return jPanelVotacoes;
    }
    
    //variável para verificar de existe um utilizador autenticado
    boolean loggedIn = false;
    //variável para tratar do utilizador autenticado
    Eleitor loggedEleitor;
    //variável para tratar da eleição escolhida
    Eleicao eleicaoSelecionada;
    //lista de eleitores totais
    ArrayList<Eleitor> eleitores = new ArrayList<>();
    //lista de eleições totais
    ArrayList<Eleicao> listaEleicoes = new ArrayList<>();
    //lista de candidatos totais
    ArrayList<Candidato> candidatos = new ArrayList<>();
    //lista de armazenamento de votações
    ArrayList<Voto> votosStack = new ArrayList<>();
    // Variavel global grupo e boolean votação
    ButtonGroup grupo = null;
    boolean votacao = false;
    //scanner para o sistema login
    Scanner scanner = new Scanner(System.in);
    
    //objeto remoto (para minar)
    InterfaceRemoteMiner miner;
    
    //TESTE: Adiciona três elementos às ao ArrayList<Eleicao>
    public void addToArraylistaEleicoes(){
        Eleicao default1 = new Eleicao("Associação de Estudantes", null, null, new ArrayList<Candidato>());
        default1.addCandidato(new Candidato("Zé"));
        default1.addCandidato(new Candidato("Maria"));
        Eleicao default2 = new Eleicao("Nucleo de Estudantes", null, null, new ArrayList<Candidato>());
        default2.addCandidato(new Candidato("Gertrudes"));
        default2.addCandidato(new Candidato("Diana"));
        Eleicao default3 = new Eleicao("Presidencia", null, null, new ArrayList<Candidato>());
        default3.addCandidato(new Candidato("Laura"));
        default3.addCandidato(new Candidato("Diogo"));
 
        listaEleicoes.add(default1);
        listaEleicoes.add(default2);
        listaEleicoes.add(default3);
    }
    
    //TESTE: Adiciona dois elementos às ao ArrayList<Candidatos>
    public void addToArrayCandidatos(){
        Candidato candidato1 = new Candidato("Candidato 1");
        Candidato candidato2 = new Candidato("Candidato 2");
 
        candidatos.add(candidato1);
        candidatos.add(candidato2);
    }
    
    //TESTE: Adiciona as eleições à lista dropdown dos resultados
    public void atualizarEleicoesComboBox(){
        comboBoxEleicoes.removeAllItems();
        for(Eleicao eleicao: listaEleicoes){
            comboBoxEleicoes.addItem(eleicao.getNome());
        }
    }
    
    //Adiciona à jList (jListEleicoes) o nome das eleições presentes no ArrayList<Eleicao>
    public void addLista(){
        addToArraylistaEleicoes();
        atualizarListaEleicoes(jListEleicoes, listaEleicoes);
    }

    public void atualizarListaEleicoes(JList jList, ArrayList<Eleicao> arrayList){
        DefaultListModel listModel = new DefaultListModel();
        for(Eleicao i: arrayList){
            listModel.addElement(i.getNome());
        }
        //adiciona todas as eleições ao painel "jListEleicoes" (parte da UI)
        jList.setModel(listModel);
    }
    
    public void atualizarListaCandidatosVoto(JList jList, ArrayList<Candidato> arrayList){
        DefaultListModel listModel = new DefaultListModel();
        for(Candidato i: arrayList){
            listModel.addElement(i.getNome());
        }
        //adiciona todas as eleições ao painel "jListEleicoes" (parte da UI)
        jList.setModel(listModel);
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
        jListEleicoes = new javax.swing.JList<>();
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
        jPanelVotacoes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListVotacao = new javax.swing.JList<>();
        jButtonVotar = new javax.swing.JButton();
        jPanelResultados = new javax.swing.JPanel();
        comboBoxEleicoes = new javax.swing.JComboBox<>();
        txtTituloEleicao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        votacoesTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        candidatosTextArea = new javax.swing.JTextArea();
        jPanelMinerar = new javax.swing.JPanel();
        jButtonConectar = new javax.swing.JButton();
        jTextFieldEnderecoServidor = new javax.swing.JTextField();
        jButtonMinerar = new javax.swing.JButton();
        jSpinnerZeros = new javax.swing.JSpinner();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPaneLogs = new javax.swing.JTextPane();
        jTextFieldNonce = new javax.swing.JTextField();
        jTextFieldHash = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaMensagem = new javax.swing.JTextArea();
        jPanelAdmin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdicionarEleicao = new javax.swing.JButton();
        jLabelAdminElei = new javax.swing.JLabel();
        jLabelAdminCandidatos = new javax.swing.JLabel();
        jTextFieldAdminElei = new javax.swing.JTextField();
        jTextFieldAdminCandidatos = new javax.swing.JTextField();
        jButtonAdicionarCandidato = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaAdminCandidatos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuTabs.setToolTipText("");

        jListEleicoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListEleicoes.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jListEleicoes.setToolTipText("");
        jListEleicoes.setName(""); // NOI18N
        jListEleicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEleicoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListEleicoes);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
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

        jScrollPane5.setViewportView(jListVotacao);

        jButtonVotar.setText("Votar");
        jButtonVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVotarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVotacoesLayout = new javax.swing.GroupLayout(jPanelVotacoes);
        jPanelVotacoes.setLayout(jPanelVotacoesLayout);
        jPanelVotacoesLayout.setHorizontalGroup(
            jPanelVotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVotacoesLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButtonVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanelVotacoesLayout.setVerticalGroup(
            jPanelVotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVotacoesLayout.createSequentialGroup()
                .addGroup(jPanelVotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVotacoesLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButtonVotar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVotacoesLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        menuTabs.addTab("Votação", jPanelVotacoes);

        comboBoxEleicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEleicoesActionPerformed(evt);
            }
        });

        votacoesTextArea.setEditable(false);
        votacoesTextArea.setColumns(20);
        votacoesTextArea.setRows(5);
        jScrollPane2.setViewportView(votacoesTextArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Candidatos");

        candidatosTextArea.setEditable(false);
        candidatosTextArea.setColumns(10);
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
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(comboBoxEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(txtTituloEleicao)))
                .addContainerGap(55, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );

        menuTabs.addTab("Resultados", jPanelResultados);

        jButtonConectar.setText("Conectar");
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jTextFieldEnderecoServidor.setText("//192.168.161.15:10010/miner");
        jTextFieldEnderecoServidor.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço do servidor"));

        jButtonMinerar.setText("Minerar");
        jButtonMinerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinerarActionPerformed(evt);
            }
        });

        jSpinnerZeros.setBorder(javax.swing.BorderFactory.createTitledBorder("Zeros"));

        jTextPaneLogs.setBackground(new java.awt.Color(0, 0, 0));
        jTextPaneLogs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane6.setViewportView(jTextPaneLogs);

        jTextFieldNonce.setEditable(false);
        jTextFieldNonce.setText("0");
        jTextFieldNonce.setToolTipText("");
        jTextFieldNonce.setBorder(javax.swing.BorderFactory.createTitledBorder("Nonce"));

        jTextFieldHash.setEditable(false);
        jTextFieldHash.setText("0");
        jTextFieldHash.setBorder(javax.swing.BorderFactory.createTitledBorder("Hash"));
        jTextFieldHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHashActionPerformed(evt);
            }
        });

        jTextAreaMensagem.setColumns(20);
        jTextAreaMensagem.setRows(5);
        jScrollPane7.setViewportView(jTextAreaMensagem);

        javax.swing.GroupLayout jPanelMinerarLayout = new javax.swing.GroupLayout(jPanelMinerar);
        jPanelMinerar.setLayout(jPanelMinerarLayout);
        jPanelMinerarLayout.setHorizontalGroup(
            jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinerarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMinerarLayout.createSequentialGroup()
                        .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEnderecoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMinerarLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinnerZeros)
                            .addComponent(jButtonMinerar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMinerarLayout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMinerarLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMinerarLayout.createSequentialGroup()
                                .addComponent(jTextFieldNonce, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))
                    .addComponent(jTextFieldHash)))
        );
        jPanelMinerarLayout.setVerticalGroup(
            jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinerarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMinerar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMinerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerZeros)
                    .addComponent(jTextFieldEnderecoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(jPanelMinerarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jTextFieldNonce, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextFieldHash, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        menuTabs.addTab("Minerar", jPanelMinerar);

        jButtonAdicionarEleicao.setText("Adicionar Eleição");
        jButtonAdicionarEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarEleicaoActionPerformed(evt);
            }
        });

        jLabelAdminElei.setText("Nome Elei.");

        jLabelAdminCandidatos.setText("Candidatos");

        jButtonAdicionarCandidato.setText("+");
        jButtonAdicionarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCandidatoActionPerformed(evt);
            }
        });

        jTextAreaAdminCandidatos.setEditable(false);
        jTextAreaAdminCandidatos.setColumns(5);
        jTextAreaAdminCandidatos.setRows(3);
        jScrollPane8.setViewportView(jTextAreaAdminCandidatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelAdminElei)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdminElei, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelAdminCandidatos)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAdminCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarCandidato))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonAdicionarEleicao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdminElei)
                    .addComponent(jTextFieldAdminElei, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jButtonAdicionarEleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdminCandidatos)
                    .addComponent(jTextFieldAdminCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarCandidato))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        menuTabs.addTab("Admin", jPanelAdmin);

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
                    //ficheiro para registar os dados inseridos
                    /*FileOutputStream fos = new FileOutputStream(email, true);
                    byte[] infoBytes = (nome + email + password).getBytes();
                    fos.write(infoBytes);
                    fos.close();*/
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
    private void jListEleicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEleicoesMouseClicked
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
            //menuTabs.addTab("Votar", panel);
            
            for(Eleicao eleicao: listaEleicoes){
                if(eleicao.getNome().equals(jListEleicoes.getSelectedValue())){
                    eleicaoSelecionada = eleicao;
                    break;
                }
            }
            menuTabs.add(jPanelVotacoes, "Votação", 1);
            
            atualizarListaCandidatosVoto(jListVotacao, eleicaoSelecionada.getListaCandidatos());
            
            menuTabs.setSelectedIndex(1);
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
    }//GEN-LAST:event_jListEleicoesMouseClicked

    private void comboBoxEleicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEleicoesActionPerformed
        candidatosTextArea.setText(null);
        votacoesTextArea.setText(null);
        //obter o nome da eleição selecionada
        String nomeEleicao = comboBoxEleicoes.getItemAt(comboBoxEleicoes.getSelectedIndex());
        //variáveis que vão armazenar a eleição selecionada e a respetiva lista de candidatos
        Eleicao eleicao = null;
        ArrayList<Candidato> candidatosEleicao = null;
        //loop for each que encontra e seleciona a eleição pretendida
        for(Eleicao eleicaoi: listaEleicoes){
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

    //função do botão para se conectar a um servidor (PROFESSOR)
    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        try {
            miner = (InterfaceRemoteMiner) RMI.getRemote(jTextFieldEnderecoServidor.getText());
            GuiUtils.insertText(jTextPaneLogs, "Connected ", miner.getAdress(), Color.GREEN, Color.MAGENTA);
        } catch (Exception ex) {
            onException("Start Remote", ex);
        }
    }//GEN-LAST:event_jButtonConectarActionPerformed

    //função do botão para começar a minerar (PROFESSOR)
    private void jButtonMinerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinerarActionPerformed
        try {
            if (miner.isMining()) {
                miner.stopMining(9999);
                GuiUtils.insertText(jTextPaneLogs, "Stop Mining", miner.getAdress());
            } else {
                new Thread(() -> {
                    try {
                        GuiUtils.insertText(jTextPaneLogs, "Start Mining", miner.getAdress(), Color.GREEN, Color.WHITE);

                        SwingUtilities.invokeLater(() -> {
                            jTextFieldNonce.setText("");
                            jTextFieldHash.setText("");
                            jButtonMinerar.setText("Stop");
                        });
                        int nonce = miner.mine(jTextAreaMensagem.getText(), (int) jSpinnerZeros.getValue());
                        SwingUtilities.invokeLater(() -> {
                            jTextFieldNonce.setText(nonce + "");
                            jTextFieldHash.setText(Miner.getHash(jTextAreaMensagem.getText(), nonce));
                            jButtonMinerar.setText("Start");
                        });
                    } catch (Exception ex) {
                        onException("Mining", ex);
                    }
                }).start();
            }
        } catch (Exception ex) {
            onException("Mining", ex);
        }
    }//GEN-LAST:event_jButtonMinerarActionPerformed

    private void jTextFieldHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHashActionPerformed

    private void jButtonVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVotarActionPerformed
        if(jListVotacao.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um candidato primeiro", "Aviso!",JOptionPane.WARNING_MESSAGE);
        }else{
            for(Candidato candidato: candidatos){
                if(candidato.getNome().equals(jListVotacao.getSelectedValue())){
                    Voto voto = new Voto(loggedEleitor, candidato);
                    votosStack.add(voto);
                    loggedEleitor.addVotacao(candidato);
                    eleicaoSelecionada.addEleitor(loggedEleitor);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Votação completa", "Informação",JOptionPane.WARNING_MESSAGE);
            menuTabs.remove(1);
        }
    }//GEN-LAST:event_jButtonVotarActionPerformed

    private void jButtonAdicionarEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarEleicaoActionPerformed
        if(jTextFieldAdminElei.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Falta preencher o nome da eleição", "Aviso!",JOptionPane.WARNING_MESSAGE);
        }else{
            if(jTextAreaAdminCandidatos.getText().isBlank()){
                JOptionPane.showMessageDialog(null, "Falta adicionar os candidatos", "Aviso!",JOptionPane.WARNING_MESSAGE);
            }else{
                String[] listaTextoCandidatos = jTextAreaAdminCandidatos.getText().split("\\s");
                if(jTextAreaAdminCandidatos.getText().strip().length() <= listaTextoCandidatos[0].length()){
                    JOptionPane.showMessageDialog(null, "Sem candidatos suficientes", "Aviso!",JOptionPane.WARNING_MESSAGE);
                }else{
                    String nomeElei = jTextFieldAdminElei.getText();
                    ArrayList<Candidato> listacandidatos = new ArrayList();
                    for(String candidato: listaTextoCandidatos){
                        listacandidatos.add(new Candidato(candidato));
                    }
                    Eleicao eleicao = new Eleicao(nomeElei, null, null, listacandidatos);
                    listaEleicoes.add(eleicao);
                    atualizarListaEleicoes(jListEleicoes, listaEleicoes);
                    atualizarEleicoesComboBox();
                    jTextFieldAdminElei.setText(null);
                    jTextFieldAdminCandidatos.setText(null);
                    jTextAreaAdminCandidatos.setText(null);
                    JOptionPane.showMessageDialog(null, "Eleição criada", "Informação",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonAdicionarEleicaoActionPerformed

    private void jButtonAdicionarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCandidatoActionPerformed
        String candidato = jTextFieldAdminCandidatos.getText();
        jTextAreaAdminCandidatos.append(candidato + "\n");
        jTextFieldAdminCandidatos.setText(null);
    }//GEN-LAST:event_jButtonAdicionarCandidatoActionPerformed

    public void onException(String title, Exception ex) {
        GuiUtils.insertText(jTextPaneLogs, title, ex.getMessage(), Color.RED, Color.MAGENTA);
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
    private javax.swing.JTextArea candidatosTextArea;
    private javax.swing.JComboBox<String> comboBoxEleicoes;
    private javax.swing.JButton jButtonAdicionarCandidato;
    private javax.swing.JButton jButtonAdicionarEleicao;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonMinerar;
    private javax.swing.JButton jButtonVotar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdminCandidatos;
    private javax.swing.JLabel jLabelAdminElei;
    private javax.swing.JList<String> jListEleicoes;
    private javax.swing.JList<String> jListVotacao;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelEleicoes;
    private javax.swing.JPanel jPanelMinerar;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JPanel jPanelVotacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinnerZeros;
    private javax.swing.JTextArea jTextAreaAdminCandidatos;
    private javax.swing.JTextArea jTextAreaMensagem;
    private javax.swing.JTextField jTextFieldAdminCandidatos;
    private javax.swing.JTextField jTextFieldAdminElei;
    private javax.swing.JTextField jTextFieldEnderecoServidor;
    private javax.swing.JTextField jTextFieldHash;
    private javax.swing.JTextField jTextFieldNonce;
    private javax.swing.JTextPane jTextPaneLogs;
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
