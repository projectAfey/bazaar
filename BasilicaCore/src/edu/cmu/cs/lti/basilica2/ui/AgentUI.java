/*
 *  Copyright (c), 2009 Carnegie Mellon University.
 *  All rights reserved.
 *  
 *  Use in source and binary forms, with or without modifications, are permitted
 *  provided that that following conditions are met:
 *  
 *  1. Source code must retain the above copyright notice, this list of
 *  conditions and the following disclaimer.
 *  
 *  2. Binary form must reproduce the above copyright notice, this list of
 *  conditions and the following disclaimer in the documentation and/or
 *  other materials provided with the distribution.
 *  
 *  Permission to redistribute source and binary forms, with or without
 *  modifications, for any purpose must be obtained from the authors.
 *  Contact Rohit Kumar (rohitk@cs.cmu.edu) for such permission.
 *  
 *  THIS SOFTWARE IS PROVIDED BY CARNEGIE MELLON UNIVERSITY ``AS IS'' AND
 *  ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL CARNEGIE MELLON UNIVERSITY
 *  NOR ITS EMPLOYEES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 */

/*
 * AgentUI.java
 *
 * Created on May 21, 2009, 4:26:14 PM
 */
package edu.cmu.cs.lti.basilica2.ui;

import edu.cmu.cs.lti.basilica2.core.Agent;
import edu.cmu.cs.lti.basilica2.core.Component;
import edu.cmu.cs.lti.basilica2.core.Connection;
import edu.cmu.cs.lti.basilica2.ui.graph.AgentGraph;
import edu.cmu.cs.lti.basilica2.ui.graph.AgentGraphUser;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author rohitk
 */
public class AgentUI extends javax.swing.JFrame implements AgentGraphUser {

    Agent myAgent;
    AgentGraph myAgentGraph;
    Map<String, JPanel> tabsTable;

    /** Creates new form AgentUI */
    public AgentUI(Agent a) {
        super(a.getName());

        System.setProperty("sun.java2d.d3d", "false");
        tabsTable = new HashMap<String, JPanel>();

        myAgent = a;
        myAgentGraph = new AgentGraph(a, this);
        String[] comList = myAgent.getAllComponents().keySet().toArray(new String[0]);
        for (int i = 0; i < comList.length; i++) {
            ComponentPanel cPanel = new ComponentPanel(myAgent.getComponent(comList[i]));
            tabsTable.put(comList[i], cPanel);
        }

        List<Connection> conList = myAgent.getAllConnections();
        for (int i = 0; i < conList.size(); i++) {
            ConnectionPanel cPanel = new ConnectionPanel(conList.get(i));
            tabsTable.put(conList.get(i).getReadableId(), cPanel);
        }

        initComponents();
        //graphTools.setVisible(false);
        //this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        mainSplitPanel = new javax.swing.JSplitPane();
        componentsSplitPane = new javax.swing.JSplitPane();
        componentsPanel = new javax.swing.JPanel();
        componentsTitleLabel = new javax.swing.JLabel();
        componentsListScroller = new javax.swing.JScrollPane();
        componentList = new javax.swing.JList();
        connectionsPanel = new javax.swing.JPanel();
        connectionsTitleLabel = new javax.swing.JLabel();
        connectionListScroller = new javax.swing.JScrollPane();
        connectionList = new javax.swing.JList();
        graphPanel = new javax.swing.JPanel();
        graphTools = new javax.swing.JToolBar();
        saveViewButton = new javax.swing.JButton();
        separator1 = new javax.swing.JToolBar.Separator();
        disposeAgentButton = new javax.swing.JButton();
        graphScroller = new javax.swing.JScrollPane(myAgentGraph);
        bottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 620));
        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setDividerLocation(200);

        componentsSplitPane.setDividerLocation(300);
        componentsSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        componentsPanel.setLayout(new java.awt.BorderLayout());

        componentsTitleLabel.setText("Components");
        componentsPanel.add(componentsTitleLabel, java.awt.BorderLayout.PAGE_START);

        componentList.setModel(new ComponentListModel(myAgent.getAllComponents()));
        componentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        componentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                componentListMouseClicked(evt);
            }
        });
        componentsListScroller.setViewportView(componentList);

        componentsPanel.add(componentsListScroller, java.awt.BorderLayout.CENTER);

        componentsSplitPane.setTopComponent(componentsPanel);

        connectionsPanel.setLayout(new java.awt.BorderLayout());

        connectionsTitleLabel.setText("Connections");
        connectionsPanel.add(connectionsTitleLabel, java.awt.BorderLayout.PAGE_START);

        connectionList.setModel(new ConnectionListModel(myAgent.getAllConnections()));
        connectionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        connectionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectionListMouseClicked(evt);
            }
        });
        connectionListScroller.setViewportView(connectionList);

        connectionsPanel.add(connectionListScroller, java.awt.BorderLayout.CENTER);

        componentsSplitPane.setBottomComponent(connectionsPanel);

        mainSplitPanel.setLeftComponent(componentsSplitPane);

        graphPanel.setLayout(new java.awt.BorderLayout());

        graphTools.setRollover(true);

        saveViewButton.setText("Save View");
        saveViewButton.setFocusable(false);
        saveViewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveViewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveViewButtonActionPerformed(evt);
            }
        });
        graphTools.add(saveViewButton);
        graphTools.add(separator1);

        disposeAgentButton.setText("Dispose Agent");
        disposeAgentButton.setFocusable(false);
        disposeAgentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        disposeAgentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        disposeAgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeAgentButtonActionPerformed(evt);
            }
        });
        graphTools.add(disposeAgentButton);

        graphPanel.add(graphTools, java.awt.BorderLayout.NORTH);
        graphPanel.add(graphScroller, java.awt.BorderLayout.CENTER);

        mainSplitPanel.setRightComponent(graphPanel);

        mainTabbedPane.addTab("Agent Overview", mainSplitPanel);

        getContentPane().add(mainTabbedPane, java.awt.BorderLayout.CENTER);
        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void componentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_componentListMouseClicked
        if (evt.getClickCount() >= 2) {
            int i = this.componentList.locationToIndex(evt.getPoint());
            Object o = this.componentList.getModel().getElementAt(i);
            if (o instanceof Component) {
                Component com = (Component) o;
                showTab(com.getName());
            }
        }
    }//GEN-LAST:event_componentListMouseClicked

    private void connectionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectionListMouseClicked
        if (evt.getClickCount() >= 2) {
            int i = this.connectionList.locationToIndex(evt.getPoint());
            Object o = this.connectionList.getModel().getElementAt(i);
            if (o instanceof Connection) {
                Connection con = (Connection) o;
                showTab(con.getReadableId());
            }
        }
    }//GEN-LAST:event_connectionListMouseClicked

    private void saveViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveViewButtonActionPerformed
        myAgentGraph.writeAgentView();
    }//GEN-LAST:event_saveViewButtonActionPerformed

    private void disposeAgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeAgentButtonActionPerformed
        this.dispose();
        myAgent.dispose();
    }//GEN-LAST:event_disposeAgentButtonActionPerformed

    private void showTab(String name) {
        for (int i = 0; i < this.mainTabbedPane.getTabCount(); i++) {
            if (this.mainTabbedPane.getTitleAt(i).trim().equalsIgnoreCase(name.trim())) {
                this.mainTabbedPane.setSelectedIndex(i);
                return;
            }
        }

        JPanel panel = tabsTable.get(name);
        if (panel == null) {
            return;
        } else {
            mainTabbedPane.add(name, panel);
            mainTabbedPane.setTabComponentAt(mainTabbedPane.indexOfComponent(panel), createTabComponent(panel, name));
            //this.mainTabbedPane.addTab(name, panel);
            this.mainTabbedPane.setSelectedComponent(panel);
        }
    }

    private JComponent createTabComponent(final java.awt.Component comp, String title) {
        JButton btn = new JButton("x");
        btn.setForeground(Color.RED);
        btn.setMargin(new Insets(0, 2, 0, 1));
        btn.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        mainTabbedPane.remove(comp);
                    }
                });

        JComponent tabComp = Box.createHorizontalBox();
        tabComp.add(new JLabel(title));
        tabComp.add(Box.createHorizontalStrut(6));
        tabComp.add(btn);

        return tabComp;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JList componentList;
    private javax.swing.JScrollPane componentsListScroller;
    private javax.swing.JPanel componentsPanel;
    private javax.swing.JSplitPane componentsSplitPane;
    private javax.swing.JLabel componentsTitleLabel;
    private javax.swing.JList connectionList;
    private javax.swing.JScrollPane connectionListScroller;
    private javax.swing.JPanel connectionsPanel;
    private javax.swing.JLabel connectionsTitleLabel;
    private javax.swing.JButton disposeAgentButton;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JScrollPane graphScroller;
    private javax.swing.JToolBar graphTools;
    private javax.swing.JSplitPane mainSplitPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JButton saveViewButton;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    public void ComponentSelected(Component com) {
        this.showTab(com.getName());
    }

    public void ConnectionSelected(Connection con) {
        this.showTab(con.getReadableId());
    }
}
