import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class addadmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passf;
	private JTextField userf;
	int x, y;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addadmin frame = new addadmin();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public addadmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(addadmin.class.getResource("/img/stationery.png")));
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 200, 396, 500);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JLabel lblAddAdmin = new JLabel("Add Admin");
		lblAddAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddAdmin.setForeground(Color.WHITE);
		lblAddAdmin.setFont(new Font("Ubuntu Mono", Font.BOLD, 19));
		lblAddAdmin.setBounds(10, 0, 161, 20);
		contentPane.add(lblAddAdmin);
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(0, 0, 396, 20);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("X");
		lblNewLabel_6.setBounds(375, 0, 19, 20);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				mainframe f = new mainframe();
				f.setVisible(true);
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(addadmin.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(355, 0, 15, 17);
		panel.add(label_1);

		JLabel lblNewLabel = new JLabel("Add Admin");
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(116, 194, 152, 37);
		contentPane.add(lblNewLabel);

		passf = new JPasswordField();
		passf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passf.setOpaque(false);
		passf.setBounds(174, 342, 138, 20);
		contentPane.add(passf);

		userf = new JTextField();
		userf.setOpaque(false);
		userf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		userf.setBounds(174, 290, 138, 20);
		contentPane.add(userf);
		userf.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(addadmin.class.getResource("/img/user.png")));
		lblNewLabel_1.setBounds(59, 289, 105, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Submit");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Ubuntu Mono", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(162, 408, 73, 29);
		contentPane.add(lblNewLabel_4);

		JLabel exitlabel = new JLabel("");
		exitlabel.setIcon(new ImageIcon(addadmin.class.getResource("/img/roundbtn.png")));
		exitlabel.setBounds(115, 408, 168, 29);
		exitlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (userf.getText().equals("") || passf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Username and Password", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						String user = userf.getText();
						String pass = passf.getText();

						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang",
								"root", "");
						PreparedStatement pst = con.prepareStatement("insert into user (uname,password) values (?,?)");
						pst.setString(1, user);
						pst.setString(2, pass);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Submit Successfully");
						userf.setText("");
						passf.setText("");
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		});
		exitlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		exitlabel.setForeground(new Color(255, 0, 0));
		exitlabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(exitlabel);

		JLabel lblNewLabel_1_1 = new JLabel(" Password : ");
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setIcon(new ImageIcon(addadmin.class.getResource("/img/lock.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(59, 341, 105, 20);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(addadmin.class.getResource("/img/user100.png")));
		lblNewLabel_3.setBounds(141, 91, 105, 92);
		contentPane.add(lblNewLabel_3);

		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(0, 0, 396, 500);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		lblNewLabel_2.setIcon(img);
		contentPane.add(lblNewLabel_2);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
