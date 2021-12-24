import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Splashz extends JFrame {
	public static JLabel lblNewLabel;
	public static JProgressBar progressBar;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	static Connection con;
	private JLabel label_1;
	private JLabel lblForCollege;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splashz frame = new Splashz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Splashz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Splashz.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 415);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Splashz.class.getResource("/img/stationery.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(24, 11, 84, 82);
		contentPane.add(label_1);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 338, 602, 77);
		contentPane.add(panel);
		panel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(148, 0, 211));
		progressBar.setBounds(10, 58, 576, 8);
		panel.add(progressBar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(538, 19, 38, 28);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Loading...");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 19, 64, 28);
		panel.add(lblNewLabel_1);

		lblForCollege = new JLabel("For College");
		lblForCollege.setHorizontalAlignment(SwingConstants.CENTER);
		lblForCollege.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblForCollege.setBounds(110, 62, 117, 14);
		contentPane.add(lblForCollege);

		JLabel lblNewLabel_2 = new JLabel("Stationery Management");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Cooper Black", Font.BOLD, 25));
		lblNewLabel_2.setBounds(110, 22, 350, 43);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Splashz.class.getResource("/img/loader.gif")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(170, 121, 245, 206);
		contentPane.add(lblNewLabel_3);

		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		JLabel label = new JLabel("");
		label.setFont(new Font("Cooper Black", Font.BOLD, 12));
		label.setBounds(0, 0, 602, 338);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		label.setIcon(img);
		contentPane.add(label);
	}
}