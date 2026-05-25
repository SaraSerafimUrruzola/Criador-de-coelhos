package GUI;

import DAO.CoelhosDAO;
import DAO.ProprietariosDAO;
import Classes.Proprietarios;
import Classes.Coelhos;
import Classes.VendasCC;
import DAO.ErpDAOException;
import DAO.VendasCCDAO;
import DAO.VendasDAO;
import GUI.AlteraVendas;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExcluirVendas extends javax.swing.JFrame {

    public ExcluirVendas() {
        initComponents();
    }

    private static ArrayList<Coelhos> coelhor = new ArrayList<Coelhos>();
    private static ArrayList<Proprietarios> prop = new ArrayList<Proprietarios>();
    private static DefaultListModel Valores = new DefaultListModel();
    private static ArrayList<VendasCC> vendar = new ArrayList<VendasCC>();

    private static int posicao = 0;
    private static int cod = 0;

    private Coelhos P = new Coelhos();
    int codigo = 0;

    public void excluirConsulta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();
        CB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        sair = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exclusão de Consultas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Lista de Vendas");

        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        CB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Coelho:");

        sair.setText("Sair");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        jLabel3.setText("- Duplo clique - Altera");

        jLabel4.setText("- Clique direito - Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(202, 202, 202))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sair)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBItemStateChanged
        posicao = CB.getSelectedIndex();
        if (posicao >= 0 && posicao < coelhor.size()) {
            cod = coelhor.get(posicao).getID_coelho();
            carregaLista();
        }
    }//GEN-LAST:event_CBItemStateChanged

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked
        int index, codigo, resp;
        String aux;
        index = Lista.getSelectedIndex();
        if ((evt.getModifiers() & evt.BUTTON3_MASK) != 0) { // Clique Direito 
            if (index != -1) {
                codigo = vendar.get(index).getID_venda();
                resp = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir a consulta: " + vendar.get(index).getID_venda(), "Confirmar edição", 0);
                if (resp == 0) {
                    VendasDAO cDAO = new VendasDAO();
                    cDAO.excluir(codigo);
                    carregaLista();
                }
            }
        }

        if (evt.getClickCount() == 2) { // duplo clique 
            if (index != -1) {
                codigo = vendar.get(index).getID_venda();
                JOptionPane.showMessageDialog(null, codigo);
                JFrame ac = new AlteraVendas(codigo);
                ac.setLocationRelativeTo(rootPane);
                ac.setVisible(true);
                carregaLista();

            }
        }
    }//GEN-LAST:event_ListaMouseClicked
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregaCoelhos();
        carregaLista();
    }//GEN-LAST:event_formWindowOpened

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        dispose();
    }//GEN-LAST:event_sairMouseClicked

    public static void carregaLista() {
        Valores.clear();
        Lista.setModel(Valores);
        if (posicao != -1) {
            VendasCCDAO PCDAO = new VendasCCDAO();
            vendar = PCDAO.listarvendas(cod);

            for (int i = 0; i < vendar.size(); i++) {
                System.out.println("Venda: " + vendar.get(i).getID_venda());
                Valores.addElement("Codigo da venda: " + vendar.get(i).getID_venda()
                        + " -- Id do comprador: " + vendar.get(i).getID_comprador()
                        + " -- Id do coelho: " + vendar.get(i).getID_coelho()
                        + " -- Data: " + vendar.get(i).getData_venda()
                        + " -- Preço: " + vendar.get(i).getPreco());
            }
        }
    }

    public static void carregaCoelhos() {
        CB.removeAllItems();
        CoelhosDAO PDAO = new CoelhosDAO();
        coelhor = PDAO.listar();

        for (int i = 0; i < coelhor.size(); i++) {
            CB.addItem(coelhor.get(i).getNome());
        }

        if (!coelhor.isEmpty()) {
            posicao = CB.getSelectedIndex();
            if (posicao != -1) {
                cod = coelhor.get(posicao).getID_coelho();
                carregaLista();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> CB;
    private static javax.swing.JList<String> Lista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton sair;
    // End of variables declaration//GEN-END:variables
}
