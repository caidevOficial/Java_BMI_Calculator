/*
 * Copyright (C) 2020 <FacuFalcone - CaidevOficial>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.Main;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Imc_gui extends JFrame {

    private JPanel contentPane;
    private JTextField txtHeight;
    private JTextField txtWeight;

    public static void ErrorMessage(String paneTitle, String errorMessage) {
	// ===================================================================
	JOptionPane alerta = new JOptionPane(errorMessage);
	alerta.setMessageType(JOptionPane.ERROR_MESSAGE);
	// por defecto tiene un solo boton y toma el idioma del sistema.
	JDialog dialogo = alerta.createDialog(paneTitle);
	dialogo.setVisible(true);
	dialogo.setAlwaysOnTop(true);
	// ===================================================================
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Imc_gui frame = new Imc_gui();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Imc_gui() {
    	setResizable(false);
	setForeground(Color.WHITE);
	setTitle("IMC Calculator - FacuFalcone");
	setBackground(Color.DARK_GRAY);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 639, 339);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(Color.DARK_GRAY);
	contentPane.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);

	JPanel panel_1 = new JPanel();
	panel_1.setBackground(Color.GRAY);
	panel_1.setBounds(12, 28, 292, 141);
	panel.add(panel_1);
	panel_1.setLayout(null);

	txtHeight = new JTextField();
	txtHeight.setFont(new Font("Noto Sans CJK JP Black", Font.BOLD, 18));
	txtHeight.setBounds(74, 62, 146, 37);
	panel_1.add(txtHeight);
	txtHeight.setColumns(10);

	JLabel lblYourHeight = new JLabel("Your Height");
	lblYourHeight.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblYourHeight.setBounds(74, 12, 146, 37);
	panel_1.add(lblYourHeight);
	
	JLabel lblMts = new JLabel("Mts");
	lblMts.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblMts.setBounds(226, 62, 54, 37);
	panel_1.add(lblMts);

	JPanel panel_1_1 = new JPanel();
	panel_1_1.setBackground(Color.GRAY);
	panel_1_1.setBounds(317, 28, 292, 141);
	panel.add(panel_1_1);
	panel_1_1.setLayout(null);

	txtWeight = new JTextField();
	txtWeight.setFont(new Font("Noto Sans CJK JP Black", Font.BOLD, 18));
	txtWeight.setColumns(10);
	txtWeight.setBounds(67, 63, 146, 37);
	panel_1_1.add(txtWeight);

	JLabel lblYourWeight = new JLabel("Your Weight");
	lblYourWeight.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblYourWeight.setBounds(67, 12, 146, 37);
	panel_1_1.add(lblYourWeight);
	
	JLabel lblKgs = new JLabel("Kgs");
	lblKgs.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblKgs.setBounds(226, 62, 54, 37);
	panel_1_1.add(lblKgs);

	JPanel panel_1_2 = new JPanel();
	panel_1_2.setBackground(Color.GRAY);
	panel_1_2.setBounds(12, 181, 292, 59);
	panel.add(panel_1_2);
	panel_1_2.setLayout(null);

	JLabel lblYourImcIs = new JLabel("Your IMC is:");
	lblYourImcIs.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblYourImcIs.setBounds(12, 12, 146, 37);
	panel_1_2.add(lblYourImcIs);
	
	JLabel lblImc = new JLabel("");
	lblImc.setFont(new Font("Noto Sans CJK JP Black", Font.BOLD, 18));
	lblImc.setBounds(141, 12, 111, 35);
	panel_1_2.add(lblImc);

	JButton btnNewButton = new JButton("Calculate My IMC!");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		if (txtHeight.getText().isEmpty() || txtWeight.getText().isEmpty()) {
		    ErrorMessage("Error - Empty Field", "At least one field is empty, check that!");

		} else if (txtHeight.getText().equals("0") || txtWeight.getText().equals("0")) {
		    ErrorMessage("Error - Zero Field", "0 ? really? ._.");
		} else {
		    
		    
		    double height = Double.parseDouble(Main.CheckSpace(txtHeight.getText()));
		    double weight = Double.parseDouble(Main.CheckSpace(txtWeight.getText()));

		    lblImc.setText(Double.toString(Main.calculateIMC(height, weight)));
		}
	    }
	});
	btnNewButton.setBounds(317, 181, 292, 59);
	panel.add(btnNewButton);

	JLabel lblImcCalculator = new JLabel("IMC Calculator - By FacuFalcone [CaidevOficial]");
	lblImcCalculator.setForeground(Color.GREEN);
	lblImcCalculator.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 20));
	lblImcCalculator.setBounds(81, 252, 498, 37);
	panel.add(lblImcCalculator);
    }
}
