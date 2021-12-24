import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EtchedBorder;

public class mainframe extends JFrame {
	private JPanel contentPane;
	int x, y;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainframe.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 278);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel top_panel = new JPanel();
		top_panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx - x, yy - y);
			}
		});
		top_panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		JPanel btn5 = new JPanel();
		btn5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				aboutus f = new aboutus();
				f.setVisible(true);
				dispose();
			}
		});
		btn5.setLayout(null);
		btn5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn5.setBackground(new Color(152, 251, 152));
		btn5.setBounds(657, 111, 102, 89);
		contentPane.add(btn5);

		JLabel lblStudent_4 = new JLabel("About Us");
		lblStudent_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudent_4.setBounds(18, 68, 62, 14);
		btn5.add(lblStudent_4);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(mainframe.class.getResource("/img/aboutus.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 11, 82, 54);
		btn5.add(label_4);

		JPanel btn4 = new JPanel();
		btn4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addadmin f = new addadmin();
				f.setVisible(true);
				dispose();
			}
		});
		btn4.setLayout(null);
		btn4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn4.setBackground(new Color(152, 251, 152));
		btn4.setBounds(516, 111, 102, 89);
		contentPane.add(btn4);

		JLabel lblStudent_3 = new JLabel("Add Admin");
		lblStudent_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudent_3.setBounds(17, 68, 72, 14);
		btn4.add(lblStudent_3);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(mainframe.class.getResource("/img/adduser.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 11, 82, 54);
		btn4.add(label_3);

		JPanel btn3 = new JPanel();
		btn3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				records f = new records();
				f.setVisible(true);
				dispose();
			}
		});
		btn3.setLayout(null);
		btn3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn3.setBackground(new Color(152, 251, 152));
		btn3.setBounds(378, 111, 102, 89);
		contentPane.add(btn3);

		JLabel lblStudent_2 = new JLabel("Records");
		lblStudent_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudent_2.setBounds(30, 68, 46, 14);
		btn3.add(lblStudent_2);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(mainframe.class.getResource("/img/records.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 11, 82, 54);
		btn3.add(label_2);

		JPanel btn2 = new JPanel();
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				stationery f = new stationery();
				f.setVisible(true);
				dispose();
			}
		});
		btn2.setLayout(null);
		btn2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn2.setBackground(new Color(152, 251, 152));
		btn2.setBounds(237, 111, 102, 89);
		contentPane.add(btn2);

		JLabel lblStationery = new JLabel("Stationery");
		lblStationery.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationery.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStationery.setBounds(24, 68, 62, 14);
		btn2.add(lblStationery);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(mainframe.class.getResource("/img/book.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 11, 82, 54);
		btn2.add(label_1);

		JPanel btn1 = new JPanel();
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				adddata f = new adddata();
				f.setVisible(true);
				dispose();
			}
		});
		btn1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn1.setBackground(new Color(152, 251, 152));
		btn1.setBounds(98, 111, 102, 89);
		contentPane.add(btn1);
		btn1.setLayout(null);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setBounds(30, 68, 46, 14);
		btn1.add(lblStudent);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(mainframe.class.getResource("/img/20200921_171308.png")));
		label.setBounds(10, 11, 82, 54);
		btn1.add(label);
		top_panel.setBackground(new Color(0, 0, 255));
		top_panel.setBounds(0, 0, 849, 33);
		contentPane.add(top_panel);
		top_panel.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setBounds(829, 0, 20, 32);
		top_panel.add(lblX);
		lblX.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblX_1 = new JLabel("-");
		lblX_1.setForeground(Color.WHITE);
		lblX_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(mainframe.ICONIFIED);
			}
		});
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setBounds(799, 0, 20, 32);
		top_panel.add(lblX_1);

		JLabel lblStationeryManagement = new JLabel("Stationery Management For College");
		lblStationeryManagement.setHorizontalAlignment(SwingConstants.LEFT);
		lblStationeryManagement.setForeground(Color.WHITE);
		lblStationeryManagement.setBounds(41, 0, 348, 32);
		top_panel.add(lblStationeryManagement);
		lblStationeryManagement.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setIcon(new ImageIcon(mainframe.class.getResource("/img/stationery~1.png")));
		label_5.setBounds(0, 0, 37, 32);
		top_panel.add(label_5);

		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		JLabel backg = new JLabel("");
		backg.setBounds(0, 0, 849, 278);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(backg.getWidth(), backg.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		backg.setIcon(img);
		contentPane.add(backg);
	}
}
