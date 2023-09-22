import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Font;

public class ConversorMoneda {

	JFrame frame;
	private JTextField txtInputValor;
	private JLabel lblRes;
	private JComboBox cmbMonedas;
	private JButton btnConvertir;

	// ENUM son un tipo de listado específico
	public enum Moneda {
		pesoCol_dolar, 
		pesoCol_euro, 
		pesoCol_libraEsterlina, 
		pesoCol_yenJapones, 
		pesoCol_wonSurcoreano, 
		dolar_pesoCol,
		euro_pesoCol, 
		libraEsterlina_pesoCol, 
		yenJapones_pesoCol, 
		wonSurcoreano_pesoCol,
	}

	// variables de los valores
	public double dolar = 0.00025;
	public double euro = 0.00024;
	public double libraEsterlina = 0.00021;
	public double yenJapones = 0.038;
	public double wonSurcoreano = 0.34;
	
	// variable del valor del label resultado
	public double txtInput = 0.00;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMoneda window = new ConversorMoneda();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_VERT);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public ConversorMoneda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setVisible(true);
		//resizeComponents(frame, txtInputValor, cmbMonedas, btnConvertir, lblRes);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 30, 200, 169);
		lblNewLabel.setIcon(new ImageIcon(ConversorMoneda.class.getResource("/images/alura.jpg")));
		panel.add(lblNewLabel);
		
		
		
		
		

		txtInputValor = new JTextField();
		txtInputValor.setBackground(new Color(255, 255, 255));
		txtInputValor.setForeground(new Color(0, 0, 0));
		txtInputValor.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		txtInputValor.setBounds(231, 57, 193, 20);
		panel.add(txtInputValor);
		txtInputValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtInputValor.setColumns(10);

		// declarar el tipo (Moneda)
		cmbMonedas = new JComboBox<Moneda>();
		cmbMonedas.setBounds(231, 88, 193, 20);
		cmbMonedas.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panel.add(cmbMonedas);
		cmbMonedas.setModel(new DefaultComboBoxModel<>(Moneda.values()));

		// EVENTO DEL BOTÓN CONVERTIR
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setForeground(new Color(0, 0, 0));
		btnConvertir.setBackground(new Color(0, 255, 64));
		btnConvertir.setBounds(269, 138, 112, 20);
		btnConvertir.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panel.add(btnConvertir);

		lblRes = new JLabel("0.00");
		lblRes.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		lblRes.setBounds(220, 185, 204, 14);
		panel.add(lblRes);
		lblRes.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel_1 = new JLabel("Cambiar a conversor de temperatura");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 227, 258, 23);
		panel.add(lblNewLabel_1);
		
		JButton btnCambiar = new JButton("CAMBIAR");
		btnCambiar.setBackground(new Color(0, 255, 255));
		btnCambiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
		        conversorTemperatura.mostrarVentana();
			}
		});
		btnCambiar.setBounds(258, 228, 97, 22);
		panel.add(btnCambiar);
		
		lblNewLabel_2 = new JLabel("CONVERSOR DE MONEDA");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 5, 414, 14);
		panel.add(lblNewLabel_2);
		
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		
		frame.addComponentListener(new ComponentListener() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	            resizeComponents(frame, txtInputValor, cmbMonedas, btnConvertir, lblRes);
	        }

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });

	    frame.setVisible(true);
	}

	// Método para ajustar los componentes al cambio de tamaño de la ventana
	private static void resizeComponents(JFrame frame, JTextField txtInputValor, JComboBox cmbMonedas, JButton btnConvertir, JLabel lblRes) {
	    int width = frame.getContentPane().getWidth();
	    int height = frame.getContentPane().getHeight();

	    // Ajustar el tamaño y la alineación de los componentes
	    txtInputValor.setPreferredSize(new Dimension(width - 40, txtInputValor.getHeight()));
	    cmbMonedas.setPreferredSize(new Dimension(width - 40, cmbMonedas.getHeight()));
	    btnConvertir.setPreferredSize(new Dimension(width - 40, btnConvertir.getHeight()));
	    lblRes.setPreferredSize(new Dimension(width - 40, lblRes.getHeight()));

	    // Volver a aplicar la alineación
	    txtInputValor.setAlignmentX(Component.CENTER_ALIGNMENT);
	    cmbMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnConvertir.setAlignmentX(Component.CENTER_ALIGNMENT);
	    lblRes.setAlignmentX(Component.CENTER_ALIGNMENT);

	    // Repintar el panel para actualizar los cambios
	    frame.getContentPane().repaint();
	}

	

	public void Convertir() {
		if (Validar(txtInputValor.getText())) {
			// para obtener el elemento seleccionado en el campo del combo box
			Moneda moneda = (Moneda) cmbMonedas.getSelectedItem();

			// para elegir entre los elementos del comboBox
			switch (moneda) {

			case pesoCol_dolar:
				PesoAMoneda(dolar);
				break;
			case pesoCol_euro:
				PesoAMoneda(euro);
				break;
			case pesoCol_libraEsterlina:
				PesoAMoneda(libraEsterlina);
				break;
			case pesoCol_yenJapones:
				PesoAMoneda(yenJapones);
				break;
			case pesoCol_wonSurcoreano:
				PesoAMoneda(wonSurcoreano);
				break;
			case dolar_pesoCol:
				MonedaAPeso(dolar);
				break;
			case euro_pesoCol:
				MonedaAPeso(euro);
				break;
			case libraEsterlina_pesoCol:
				MonedaAPeso(libraEsterlina);
				break;
			case yenJapones_pesoCol:
				MonedaAPeso(yenJapones);
				break;
			case wonSurcoreano_pesoCol:
				MonedaAPeso(wonSurcoreano);
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			}
		}

	}

	public void PesoAMoneda(double moneda) {
		double res = txtInput * moneda;
		String tipoMoneda = cmbMonedas.getSelectedItem().toString();
		String texto = "";
		switch (tipoMoneda) {
		case "pesoCol_dolar":
			texto = "Dólar (es)";
			break;
		case "pesoCol_euro":
			texto = "Euro (s)";
			break;
		case "pesoCol_libraEsterlina":
			texto = "Libra(s) Esterlina(s)";
			break;
		case "pesoCol_yenJapones":
			texto = "Yen(es) Japones(es)";
			break;
		case "pesoCol_wonSurcoreano":
			texto = "Won(es) Surcoreano(s)";
			break;
		}

		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void MonedaAPeso(double moneda) {
		double res = txtInput / moneda;
		String tipoMoneda = cmbMonedas.getSelectedItem().toString();
		String texto = "";
		switch (tipoMoneda) {

		case "dolar_pesoCol":
			texto = "Pesos Colombianos";
			break;
		case "euro_pesoCol":
			texto = "Pesos Colombianos";
			break;
		case "libraEsterlina_pesoCol":
			texto = "Pesos Colombianos";
			break;
		case "yenJapones_pesoCol":
			texto = "Pesos Colombianos";
			break;
		case "wonSurcoreano_pesoCol":
			texto = "Pesos Colombianos";
			break;
		}

		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				;
			txtInput = x;
			return true;
		} catch (NumberFormatException e) {
			lblRes.setText("¡Debe ingresar números!");
			return false;
		}
	}


	public void mostrarVentana() {
		frame.setVisible(true);
		
	}

}
