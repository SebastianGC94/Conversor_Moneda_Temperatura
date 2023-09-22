import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConversorTemperatura {

	private JFrame frame;
	private JTextField textInputValor;
	private JComboBox comboBox;
	private JButton btnConvertir;
	private JButton btnCambiar;
	private JLabel lblRes;

	// ENUM son un tipo de listado específico
	public enum Temperatura {
		celsius_fahrenheit, 
		celsius_kelvin, 
		celsius_rankine, 
		fahrenheit_celsius, 
		fahrenheit_kelvin, 
		fahrenheit_rankine,
		kelvin_celsius, 
		kelvin_fahrenheit, 
		kelvin_rankine, 
		rankine_celsius, 
		rankine_fahrenheit, 
		rankine_kelvin,
	}

	// variables de los valores
	public double celFar = 00.0;
	public double celKel = 00.0;
	public double celRan = 00.0;
	public double farCel = 00.0;
	public double farKel = 00.0;
	public double farRan = 00.0;
	public double kelCel = 00.0;
	public double kelFar = 00.0;
	public double kelRan = 00.0;
	public double ranCel = 00.0;
	public double ranFar = 00.0;
	public double ranKel = 00.0;

	// variable del valor del label resultado
	public double textInput = 0.00;
	/*
	 * private JLabel lblNewLabel_1; private JLabel lblNewLabel_2;
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura window = new ConversorTemperatura();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
					// window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConversorTemperatura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(ConversorTemperatura.class.getResource("/images/logoAluraBlanco.png")));
		lblNewLabel.setBounds(10, 36, 190, 158);
		panel.add(lblNewLabel);

		textInputValor = new JTextField();
		textInputValor.setBounds(220, 48, 204, 20);
		textInputValor.setHorizontalAlignment(SwingConstants.CENTER);
		textInputValor.setColumns(10);
		textInputValor.setAlignmentX(0.5f);
		panel.add(textInputValor);

		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBackground(new Color(0, 255, 64));
		btnConvertir.setBounds(269, 129, 119, 20);
		btnConvertir.setAlignmentX(0.5f);
		panel.add(btnConvertir);

		lblRes = new JLabel("0.00");
		lblRes.setBounds(220, 178, 204, 14);
		lblRes.setHorizontalAlignment(SwingConstants.LEFT);
		lblRes.setAlignmentX(0.5f);
		panel.add(lblRes);

		JLabel lblNewLabel_1 = new JLabel("Cambiar a conversor de moneda");
		lblNewLabel_1.setBounds(10, 227, 258, 23);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_1.setBackground(Color.BLACK);
		panel.add(lblNewLabel_1);

		btnCambiar = new JButton("CAMBIAR");
		btnCambiar.setBackground(new Color(0, 255, 255));
		btnCambiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorMoneda conversorMoneda = new ConversorMoneda();
				conversorMoneda.mostrarVentana();
			}
		});
		btnCambiar.setBounds(256, 228, 99, 22);
		panel.add(btnCambiar);

		JLabel lblNewLabel_2 = new JLabel("CONVERSOR DE TEMPERATURA");
		lblNewLabel_2.setBounds(10, 11, 414, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		panel.add(lblNewLabel_2);

		JButton btnCambiar = new JButton("CAMBIAR");
		btnCambiar.setBounds(258, 228, 97, 22);
		panel.add(btnCambiar);
		
		

		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});

		// Declarar el tipo (Temperatura)
		comboBox = new JComboBox<Temperatura>();
		comboBox.setBounds(220, 88, 204, 20);
		comboBox.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(Temperatura.values()));
	}

	 public void mostrarVentana() {
	        frame.setVisible(true);
	    }
	 
	public void Convertir() {
		if (Validar(textInputValor.getText())) {
			// para obtener el elemento seleccionado en el campo del combo box
			Temperatura temperatura = (Temperatura) comboBox.getSelectedItem();
			// para elegir entre los elementos del comboBox
			switch (temperatura) {

			case celsius_fahrenheit:
				celsiusAFahrenheit(celFar);
				break;
			case celsius_kelvin:
				celsiusAKelvin(celKel);
				break;
			case celsius_rankine:
				celsiusARankine(celRan);
				break;
			case fahrenheit_celsius:
				fahrenheitACelsius(farCel);
				break;
			case fahrenheit_rankine:
				fahrenheitARankine(farRan);
				break;
			case fahrenheit_kelvin:
				fahrenheitAKelvin(farKel);
				break;
			case kelvin_fahrenheit:
				kelvinAFahrenheit(kelFar);
				break;
			case kelvin_celsius:
				kelvinACelsius(kelCel);
				break;
			case kelvin_rankine:
				kelvinARankine(kelRan);
				break;
			case rankine_fahrenheit:
				rankineAFahrenheit(ranFar);
				break;
			case rankine_kelvin:
				rankineAKelvin(ranKel);
				break;
			case rankine_celsius:
				rankineACelsius(ranCel);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + temperatura);
			}
		}

	}

	public void celsiusAFahrenheit(double temperatura) {
		double res = (textInput * 9 / 5) + 32;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "celsius_fahrenheit":
			texto = "Grados Fahrenheit";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void celsiusARankine(double temperatura) {
		double res = (textInput * 9 / 5) + 491.67;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "celsius_rankine":
			texto = "Grados Rankine";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void celsiusAKelvin(double temperatura) {
		double res = (textInput + 273.15);
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "celsius_kelvin":
			texto = "Grados Kelvin";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void fahrenheitACelsius(double temperatura) {
		double res = (textInput - 32) * 5 / 9;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "fahrenheit_celsius":
			texto = "Grados Celsius";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void fahrenheitAKelvin(double temperatura) {
		double res = (textInput - 32) * 5 / 9 + 273.15;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "fahrenheit_kelvin":
			texto = "Grados Kelvin";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void fahrenheitARankine(double temperatura) {
		double res = (textInput + 459.67);
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "fahrenheit_rankine":
			texto = "Grados Rankine";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void kelvinACelsius(double temperatura) {
		double res = (textInput - 273.15);
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "kelvin_celsius":
			texto = "Grados Celsius";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void kelvinAFahrenheit(double temperatura) {
		double res = (textInput - 273.15) * 9 / 5 + 32;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "kelvin_fahrenheit":
			texto = "Grados Fahrenheit";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void kelvinARankine(double temperatura) {
		double res = (textInput * 1.8);
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "kelvin_rankine":
			texto = "Grados Rankine";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void rankineAFahrenheit(double temperatura) {
		double res = (textInput - 459.67);
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "rankine_fahrenheit":
			texto = "Grados Fahrenheit";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void rankineACelsius(double temperatura) {
		double res = (textInput - 491.67) * 5 / 9;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "rankine_celsius":
			texto = "Grados Celsius";
			break;
		}
		// acá se añade el resultado al campo lblRes
		lblRes.setText(Redondear(res) + " " + (texto));
	}

	public void rankineAKelvin(double temperatura) {
		double res = textInput * 5 / 9;
		String tipoTemperatura = comboBox.getSelectedItem().toString();
		String texto = "";
		switch (tipoTemperatura) {
		case "rankine_kelvin":
			texto = "Grados Kelvin";
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
			textInput = x;
			return true;
		} catch (NumberFormatException e) {
			lblRes.setText("¡Debe ingresar números!");
			return false;
		}
	}

}
