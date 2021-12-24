import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class splashscreenz extends JFrame {
	private JPanel contentPane;
	static Connection con;
	static String sta, dt;

	public static void main(String[] args) {
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		dt = d.format(now);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashscreenz frame = new splashscreenz();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root", "");
			if (con.isClosed()) {
				System.out.println("Closed......");
			} else {
				sta = "Server Status : ON";
			}

		} catch (Exception e) {
			sta = "Server Status : OFF";
		}

		Splashz splash = new Splashz();
		splash.setVisible(true);
		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(20);
				Splashz.lblNewLabel.setText(i + "%");
				Splashz.progressBar.setValue(i);
				if (i == 100) {
					login log = new login();
					splash.setVisible(false);
					log.setVisible(true);
				}
			}
		} catch (Exception e) {
		}
	}

	public splashscreenz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(splashscreenz.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
