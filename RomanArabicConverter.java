import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author janlothar
 *
 */
@SuppressWarnings("unused")
public class RomanArabicConverter {

	private JFrame frame;
	private JTextField txtFldRoman;
	private JTextField txtFldArabic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RomanArabicConverter window = new RomanArabicConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RomanArabicConverter() {
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
		
		txtFldRoman = new JTextField();
		txtFldRoman.setBounds(30, 60, 176, 43);
		frame.getContentPane().add(txtFldRoman);
		txtFldRoman.setColumns(10);
		
		txtFldArabic = new JTextField();
		txtFldArabic.setColumns(10);
		txtFldArabic.setBounds(30, 158, 176, 43);
		frame.getContentPane().add(txtFldArabic);
		
		JButton btnRoman = new JButton("Roman");
		btnRoman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//Convert number from arabic txtFld through arabicToRoman() then place result in roman txtFld
					txtFldRoman.setText(arabicToRoman(Integer.parseInt(txtFldArabic.getText())));
				}catch (NumberFormatException notANumber){
					if (!txtFldArabic.getText().equals("N/A"))
					txtFldRoman.setText("Can't convert");
				}
			}
		});
		btnRoman.setBounds(267, 70, 121, 23);
		frame.getContentPane().add(btnRoman);
		
		JButton btnArabic = new JButton("Arabic");
		btnArabic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//For implementing romanToArabic()
				txtFldArabic.setText("N/A");
			}
		});
		btnArabic.setBounds(267, 168, 121, 23);
		frame.getContentPane().add(btnArabic);
		
		JLabel lblConvertTo = new JLabel("Convert to:");
		lblConvertTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertTo.setBounds(267, 26, 121, 14);
		frame.getContentPane().add(lblConvertTo);
	}
	
	/**
	 * @param arabic number to convert to roman
	 * @return roman numeral as string
	 */
	public String arabicToRoman(int arabic){
		String roman = "";
		while (arabic > 0){
			if (arabic >= 1000){
				roman+="M";
				arabic+=-1000;
			}
			else if (arabic >= 900){
				roman+="CM";
				arabic+=-900;
			}
			else if (arabic >= 500){
				roman+="D";
				arabic+=-500;
			}
			else if (arabic >= 400){
				roman+="CD";
				arabic+=-400;
			}
			else if (arabic >= 100){
				roman+="C";
				arabic+=-100;
			}
			else if (arabic >= 50){
				roman+="L";
				arabic+=-50;
			}
			else if (arabic >= 10){
				roman+="X";
				arabic+=-10;
			}
			else if (arabic >= 9){
				roman+="IX";
				arabic+=-9;
			}
			else if (arabic >= 5){
				roman+="V";
				arabic+=-5;
			}
			else if (arabic >= 4){
				roman+="IV";
				arabic+=-4;
			}
			else if (arabic >= 1){
				roman+="I";
				arabic+=-1;
			}
			System.out.println(arabic);
		}
		return roman;
	}
}
