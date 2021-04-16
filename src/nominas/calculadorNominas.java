package nominas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadorNominas extends JFrame {

	private JPanel contentPane;
	private JTextField textApellidos;
	private JTextField textNif;
	private JTextField textNss;
	private JTextField textTarifa;
	private JTextField textHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadorNominas frame = new calculadorNominas();
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
	public calculadorNominas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Nomina del trabajador");
		lblTitulo.setBounds(10, 11, 162, 14);
		contentPane.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 51, 87, 14);
		contentPane.add(lblNombre);

		JTextField textNombre = new JTextField();
		textNombre.setBounds(121, 48, 106, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(346, 48, 106, 20);
		contentPane.add(textApellidos);
		
		JLabel lblNApellidos = new JLabel("Apellidos:");
		lblNApellidos.setBounds(248, 51, 88, 14);
		contentPane.add(lblNApellidos);
		
		textNif = new JTextField();
		textNif.setColumns(10);
		textNif.setBounds(121, 79, 106, 20);
		contentPane.add(textNif);
		
		textNss = new JTextField();
		textNss.setColumns(10);
		textNss.setBounds(346, 79, 106, 20);
		contentPane.add(textNss);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setBounds(24, 82, 92, 14);
		contentPane.add(lblNif);
		
		JLabel lblNss = new JLabel("NSS:");
		lblNss.setBounds(248, 82, 88, 14);
		contentPane.add(lblNss);
		
		textTarifa = new JTextField();
		textTarifa.setColumns(10);
		textTarifa.setBounds(86, 131, 56, 20);
		contentPane.add(textTarifa);
		
		textHoras = new JTextField();
		textHoras.setColumns(10);
		textHoras.setBounds(86, 162, 56, 20);
		contentPane.add(textHoras);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setBounds(24, 134, 46, 14);
		contentPane.add(lblTarifa);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(24, 165, 46, 14);
		contentPane.add(lblHoras);
		
		JTextArea textRes = new JTextArea();
		textRes.setBounds(183, 129, 302, 198);
		contentPane.add(textRes);
		
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMostrar) {
					do_presionar(e);
				}
			}

			private void do_presionar(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				String nif = textNif.getText();
				String nss = textNss.getText();
				int horas = Integer.parseInt(textHoras.getText());
				double tarifa = Integer.parseInt(textTarifa.getText());
				
				double salarioBase = horas * tarifa;
				
				double bonificacion = 0;
				
				if(horas>=1 || horas<=10) {
					bonificacion = (salarioBase*5)/100;
				}
				if(horas>=11|| horas<=20) {
					bonificacion = (salarioBase*10)/100;
				}
				if(horas>20) {
					bonificacion = (salarioBase*30)/100;
				}
				double salarioBruto = salarioBase+bonificacion;
				double retenciones = (salarioBruto*15)/100;
				double salarioNeto = salarioBruto-retenciones;
				

				textRes.append("Nomina calculada segun datos del usuario");
				textRes.append("Trabajador: " + nombre + " " + apellidos + "\n");
				textRes.append("NIF: " + nif + "\n");
				textRes.append("NSS: " + nss + "\n");
				textRes.append("Tarifa en horas: " + tarifa + "\n");
				textRes.append("Horas que trabaja: " + horas + "\n");
				textRes.append("Salario base: " + salarioBase + "\n");
				textRes.append("Bonificacion: " + bonificacion + "\n");
				textRes.append("Salario Bruto: " + salarioBruto + "\n");
				textRes.append("Retenciones: " + retenciones + "\n");
				textRes.append("Salario Neto: " + salarioNeto + "\n");

				
			}
		});
		btnMostrar.setBounds(53, 239, 89, 23);
		contentPane.add(btnMostrar);
		
	}

}
