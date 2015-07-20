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
 * WrenchTalkerOperationUI.java
 *
 * Created on May 29, 2009, 6:07:48 PM
 */
package basilica2.agents.operation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import edu.cmu.cs.lti.project911.utils.log.Logger;

/**
 * 
 * @author dadamson
 */
public class BaseAgentUI extends javax.swing.JFrame
{

	BaseAgentOperation myOperation;
	protected DefaultListModel myListModel = null;

	/** Creates new OperationUI */

	public BaseAgentUI(BaseAgentOperation o)
	{
		this(o, "Test1");
	}

	public BaseAgentUI(BaseAgentOperation o, String roomName)
	{
		myOperation = o;
		initComponents(roomName);
		myListModel = (DefaultListModel) agentList.getModel();
		this.addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent winEvt)
			{
				if (stopOperationButton.isEnabled())
				{
					stopOperationButton.doClick();
				}
			}
		});
		this.setSize(300, 150);
		this.setVisible(true);
	}

	public void tick()
	{

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * 
	 * @param roomName
	 */
	@SuppressWarnings("unchecked")
	protected void initComponents(String roomName)
	{

		launchPanel = new javax.swing.JPanel();
		roomLabel = new javax.swing.JLabel();
		roomNameTextField = new javax.swing.JTextField();
		launchButton = new javax.swing.JButton();
		agentControlPanel = new javax.swing.JPanel();
		agentListScroller = new javax.swing.JScrollPane();
		agentList = new javax.swing.JList();
		agentControlButtonsPanel = new javax.swing.JPanel();
		stopAgentButton = new javax.swing.JButton();
		wizardButton = new javax.swing.JButton("Wizard");
		bottomPanel = new javax.swing.JPanel();
		stopOperationButton = new javax.swing.JButton();
		roomPanel = new JPanel(new BorderLayout());
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Bazaar Agent");

		launchPanel.setLayout(new java.awt.BorderLayout(5,5));

		roomLabel.setText(" Room Name: ");
		roomPanel.add(roomLabel, java.awt.BorderLayout.WEST);

		roomNameTextField.setText(roomName);
		roomNameTextField.setMinimumSize(new java.awt.Dimension(100, 20));
		roomNameTextField.setPreferredSize(new java.awt.Dimension(150, 20));
		roomNameTextField.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				roomNameTextFieldActionPerformed(evt);
			}
		});
		roomPanel.add(roomNameTextField, java.awt.BorderLayout.CENTER);
		launchPanel.add(roomPanel, BorderLayout.CENTER);

		launchButton.setText("Start Agent");
		launchButton.setEnabled(false);
		launchButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				launchButtonActionPerformed(evt);
			}
		});
		launchPanel.add(launchButton, java.awt.BorderLayout.SOUTH);

		getContentPane().add(launchPanel, java.awt.BorderLayout.NORTH);

		agentControlPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(2, 1, 2, 1),
				javax.swing.BorderFactory.createEtchedBorder()));
		agentControlPanel.setLayout(new java.awt.BorderLayout());

		this.agentList.setModel(new DefaultListModel());
		agentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		agentListScroller.setViewportView(agentList);

		agentControlPanel.add(agentListScroller, java.awt.BorderLayout.CENTER);

		agentControlButtonsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
		agentControlButtonsPanel.setLayout(new java.awt.GridLayout(0, 1));

		stopAgentButton.setText("Stop Agent");
		stopAgentButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				stopAgentButtonActionPerformed(evt);
			}
		});
		
		wizardButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				showWizard();
			}
		});
		
		//agentControlButtonsPanel.add(stopAgentButton);
		agentControlButtonsPanel.add(wizardButton);

		agentControlPanel.add(agentControlButtonsPanel, java.awt.BorderLayout.EAST);

		getContentPane().add(agentControlPanel, java.awt.BorderLayout.CENTER);

		bottomPanel.setLayout(new java.awt.BorderLayout(5, 0));

		stopOperationButton.setText("Stop Operation & Quit");
		stopOperationButton.setEnabled(false);
		stopOperationButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				stopOperationButtonActionPerformed(evt);
			}
		});
		bottomPanel.add(stopOperationButton, java.awt.BorderLayout.CENTER);

		getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	protected void launchButtonActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_launchButtonActionPerformed
		String roomName = this.roomNameTextField.getText();
		setTitle(roomName + ": Basilica Agents");
		myOperation.launchAgent(roomName);
		//this.roomNameTextField.setText("");
		launchButton.setEnabled(false);

	}// GEN-LAST:event_launchButtonActionPerformed

	protected void stopAgentButtonActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_stopAgentButtonActionPerformed
		myOperation.stopAgent((String) this.agentList.getSelectedValue());
	}// GEN-LAST:event_stopAgentButtonActionPerformed

	protected void stopOperationButtonActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_stopOperationButtonActionPerformed
		this.launchButton.setEnabled(false);
		this.stopOperationButton.setEnabled(false);
		myOperation.stopOperation();
		System.exit(0);
	}// GEN-LAST:event_stopOperationButtonActionPerformed

	protected void roomNameTextFieldActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_roomNameTextFieldActionPerformed
	{// GEN-HEADEREND:event_roomNameTextFieldActionPerformed
		// TODO add your handling code here:
		launchButtonActionPerformed(evt);
	}// GEN-LAST:event_roomNameTextFieldActionPerformed

	public void agentLaunched(String agent_name)
	{
		myListModel.addElement(agent_name);
		agentList.setModel(myListModel);
		agentList.setSelectedIndex(0);
		this.enableAgentConfiguration(false);
	}

	public void agentStopped(String agent_name)
	{
		for (int i = 0; i < myListModel.getSize(); i++)
		{
			String item = (String) myListModel.get(i);
			if (item.equalsIgnoreCase(agent_name))
			{
				myListModel.remove(i);
				agentList.setModel(myListModel);
				break;
			}
		}

		widgets.get(agent_name).setVisible(false);
		if(myListModel.isEmpty())
			this.enableAgentConfiguration(true);
	}

	public void operationStarted()
	{
		this.enableAgentConfiguration(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	protected javax.swing.JPanel agentControlButtonsPanel;
	protected javax.swing.JPanel agentControlPanel;
	protected javax.swing.JList agentList;
	protected javax.swing.JScrollPane agentListScroller;
	protected javax.swing.JPanel bottomPanel;
	protected javax.swing.JButton launchButton;
	protected javax.swing.JPanel launchPanel;
	protected javax.swing.JPanel roomPanel;
	protected javax.swing.JLabel roomLabel;
	protected javax.swing.JTextField roomNameTextField;
	protected javax.swing.JButton stopAgentButton;
	protected javax.swing.JButton wizardButton;
	protected javax.swing.JButton stopOperationButton;
	// End of variables declaration//GEN-END:variables
	private Map<String, AgentWidget> widgets = new HashMap<String, AgentWidget>();

	public void addAgentWidget(String agentName, AgentWidget agentWidget)
	{
		widgets.put(agentName, agentWidget);
	}

	public void enableAgentConfiguration(boolean enabled)
	{
		launchButton.setEnabled(enabled);
		roomNameTextField.setEnabled(enabled);
		wizardButton.setEnabled(!enabled);
		stopAgentButton.setEnabled(!enabled);
		this.stopOperationButton.setEnabled(!enabled);
	}

	public void showWizard()
	{
		String agentName = (String) agentList.getSelectedValue();
		// Logger.commonLog(agentName, Logger.LOG_NORMAL, "selected!");
		if (widgets.containsKey(agentName))
		{
			Logger.commonLog(agentName + " Wizard", Logger.LOG_LOW, "displaying wizard UI for " + agentName);
			widgets.get(agentName).setVisible(true);
		}
	}

	public void setRoomName(String room)
	{
		this.roomNameTextField.setText(room);
		
	}
}