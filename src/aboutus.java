import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class aboutus extends JFrame {
	private JPanel contentPane;
	int x, y;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aboutus frame = new aboutus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public aboutus() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(aboutus.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 320);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel backg = new JLabel("");

		backg.setBackground(Color.LIGHT_GRAY);
		backg.setBounds(0, 0, 520, 320);
		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		Image i = img.getImage();
		Image ni = i.getScaledInstance(backg.getWidth(), backg.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		backg.setIcon(img);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 259, 477, 9);
		contentPane.add(separator_1);
		
		JLabel lblSagarBhoi = new JLabel("Sagar Bhoi & Vaishnavi Sharma");
		lblSagarBhoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSagarBhoi.setForeground(Color.WHITE);
		lblSagarBhoi.setFont(new Font("Source Sans Pro Light", Font.BOLD, 13));
		lblSagarBhoi.setBounds(45, 214, 430, 23);
		contentPane.add(lblSagarBhoi);
		
		JLabel lblDevelopedBy = new JLabel("Developed by");
		lblDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedBy.setForeground(Color.WHITE);
		lblDevelopedBy.setFont(new Font("Source Sans Pro Light", Font.BOLD, 13));
		lblDevelopedBy.setBounds(45, 186, 430, 23);
		contentPane.add(lblDevelopedBy);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 126, 477, 9);
		contentPane.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Stationery Management");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Cooper Black", Font.BOLD, 25));
		lblNewLabel_2.setBounds(86, 47, 350, 43);
		contentPane.add(lblNewLabel_2);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(aboutus.class.getResource("/img/stationery.png")));
		label.setBounds(10, 38, 81, 77);
		contentPane.add(label);

		JLabel lblForCollege = new JLabel("For College");
		lblForCollege.setHorizontalAlignment(SwingConstants.CENTER);
		lblForCollege.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblForCollege.setBounds(86, 87, 117, 14);
		contentPane.add(lblForCollege);

		JLabel lbl = new JLabel("Stationery Managment For College ");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Source Sans Pro Light", Font.BOLD, 13));
		lbl.setBounds(45, 164, 430, 23);
		contentPane.add(lbl);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainframe f = new mainframe();
				f.setVisible(true);
				dispose();
			}
		});
		btnOk.setBounds(421, 286, 89, 23);
		contentPane.add(btnOk);

		JLabel lblAddAdmin = new JLabel("About Us");
		lblAddAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddAdmin.setForeground(Color.WHITE);
		lblAddAdmin.setFont(new Font("Ubuntu Mono", Font.BOLD, 19));
		lblAddAdmin.setBounds(10, 0, 161, 20);
		contentPane.add(lblAddAdmin);

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx - x, yy - y);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(0, 0, 520, 20);
		contentPane.add(panel);

		JLabel lblNewLabel_6 = new JLabel("X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainframe f = new mainframe();
				f.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(491, 0, 19, 20);
		panel.add(lblNewLabel_6);

		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(aboutus.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(471, 0, 15, 17);
		panel.add(label_1);
		contentPane.add(backg);
	}
}
