import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.text.*;

public class adddata extends JFrame {

	private JPanel contentPane;
	private JTextField ent;
	private JTextField fnt;
	private JTextField lnt;
	private JTextField addt;
	private JTextField mnpt;
	private JTextField mns;
	static private JTable table;
	static int id, x, y;
	static JDateChooser date;
	static String fnamel, d;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adddata frame = new adddata();
					frame.setVisible(true);

					Class.forName("com.mysql.jdbc.Driver");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public adddata() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(adddata.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 465);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon(adddata.class.getResource("/img/refresh.png")));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showtable();
			}
		});

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(adddata.class.getResource("/img/print.png")));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Students Data");
				MessageFormat footer = new MessageFormat("Stationery Management System");
				try {
					boolean print = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);

					if (!print) {
						JOptionPane.showMessageDialog(null, "Unable to Print !!....");
					} else {
						JOptionPane.showMessageDialog(null, "Print Successfully");
					}

				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});

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
		top_panel.setBackground(new Color(153, 50, 204));
		top_panel.setBounds(0, 0, 1354, 29);
		contentPane.add(top_panel);
		top_panel.setLayout(null);

		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(adddata.ICONIFIED);
			}
		});

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(adddata.class.getResource("/img/stationery~1.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 0, 37, 27);
		top_panel.add(label_5);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(1306, 4, 15, 23);
		top_panel.add(label);

		JLabel lblAddStudentDetails = new JLabel("Student Details");
		lblAddStudentDetails.setBounds(47, 0, 287, 27);
		top_panel.add(lblAddStudentDetails);
		lblAddStudentDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddStudentDetails.setForeground(Color.WHITE);
		lblAddStudentDetails.setFont(new Font("Ubuntu Mono", Font.BOLD, 24));

		JLabel exitlabel = new JLabel("\u00D7");
		exitlabel.setBounds(1329, 2, 15, 29);
		top_panel.add(exitlabel);
		exitlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				mainframe f = new mainframe();
				f.setVisible(true);
			}
		});
		exitlabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitlabel.setForeground(Color.WHITE);
		exitlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(1111, 399, 122, 23);
		contentPane.add(btnPrint);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(adddata.class.getResource("/img/delete.png")));
		btnDelete.setBounds(948, 399, 122, 23);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(adddata.class.getResource("/img/update.png")));
		btnUpdate.setBounds(786, 399, 122, 23);
		contentPane.add(btnUpdate);
		btnRefresh.setBounds(625, 399, 122, 23);
		contentPane.add(btnRefresh);

		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(adddata.class.getResource("/img/reset.png")));
		btnReset.setBounds(302, 399, 114, 23);
		contentPane.add(btnReset);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder());
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(554, 78, 775, 298);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "First Name", "Last Name", "Enroll No",
				"Branch", "Semester", "Year", "Address", "Mob No(P)", "Mob No(S)", "DOB", "Gender" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Year :");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(312, 164, 79, 14);
		contentPane.add(lblNewLabel_1_1_1_2);

		JComboBox yearjcm = new JComboBox();
		yearjcm.setBackground(Color.WHITE);
		yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None" }));
		yearjcm.setBounds(412, 158, 86, 22);
		contentPane.add(yearjcm);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Semester :");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(57, 166, 79, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JComboBox semjcm = new JComboBox();
		semjcm.setBackground(Color.WHITE);
		semjcm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ((String) semjcm.getSelectedItem() == "1st Sem") {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "1st Year" }));
				} else if ((String) semjcm.getSelectedItem() == "2nd Sem") {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "1st Year" }));
				} else if ((String) semjcm.getSelectedItem() == "3rd Sem") {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "2nd Year" }));
				} else if ((String) semjcm.getSelectedItem() == "4th Sem") {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "2nd Year" }));
				} else if ((String) semjcm.getSelectedItem() == "5th Sem") {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "3rd Year" }));
				} else {
					yearjcm.setModel(new DefaultComboBoxModel(new String[] { "None", "3rd Year" }));
				}
			}
		});
		semjcm.setModel(new DefaultComboBoxModel(
				new String[] { "None", "1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem" }));
		semjcm.setBounds(157, 160, 86, 22);
		contentPane.add(semjcm);

		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(57, 81, 79, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Enroll No : ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(57, 124, 79, 14);
		contentPane.add(lblNewLabel_1_1);

		ent = new JTextField();
		ent.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					ent.setEditable(false);
					JOptionPane.showMessageDialog(null, "Please Enter Only Number");
				} else {
					ent.setEditable(true);
				}
			}
		});
		ent.setColumns(10);
		ent.setBounds(157, 121, 86, 20);
		contentPane.add(ent);

		fnt = new JTextField();
		fnt.setColumns(10);
		fnt.setBounds(157, 78, 86, 20);
		contentPane.add(fnt);

		JLabel lblNewLabel_1_2 = new JLabel("Last Name :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(312, 84, 79, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Branch :");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(312, 127, 79, 14);
		contentPane.add(lblNewLabel_1_1_1);

		lnt = new JTextField();
		lnt.setColumns(10);
		lnt.setBounds(412, 81, 86, 20);
		contentPane.add(lnt);

		JComboBox brcombo = new JComboBox();
		brcombo.setBackground(Color.WHITE);
		brcombo.setBounds(412, 121, 86, 22);
		String[] list = new String[] { "None", "CM", "EE", "ME" };
		ComboBoxModel cbm = new DefaultComboBoxModel<>(list);
		brcombo.setModel(new DefaultComboBoxModel(new String[] { "None", "CM", "EE", "ME", "CE", "E&TC" }));
		contentPane.add(brcombo);

		JLabel addl = new JLabel("Address :");
		addl.setForeground(Color.WHITE);
		addl.setFont(new Font("Tahoma", Font.BOLD, 12));
		addl.setBounds(57, 214, 79, 14);
		contentPane.add(addl);

		addt = new JTextField();
		addt.setColumns(10);
		addt.setBounds(157, 211, 341, 20);
		contentPane.add(addt);

		JLabel lblNewLabel_1_1_3 = new JLabel("Mobile No(Parents) :");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(57, 258, 141, 14);
		contentPane.add(lblNewLabel_1_1_3);

		mnpt = new JTextField();
		mnpt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					mnpt.setEditable(false);
					JOptionPane.showMessageDialog(null, "Please Enter Only Number");
				} else {
					mnpt.setEditable(true);
				}

				String pn = mnpt.getText();
				int length = pn.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					if (length < 10) {
						mnpt.setEditable(true);
					} else {
						mnpt.setEditable(false);
					}

				} else {
					if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						mnpt.setEditable(true);
					} else {
						mnpt.setEditable(false);
					}
				}
			}
		});
		mnpt.setColumns(10);
		mnpt.setBounds(187, 256, 86, 20);
		contentPane.add(mnpt);

		mns = new JTextField();
		mns.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					mns.setEditable(false);
					JOptionPane.showMessageDialog(null, "Please Enter Only Number");
				} else {
					mns.setEditable(true);
				}

				String pn = mns.getText();
				int length = pn.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					if (length < 10) {
						mns.setEditable(true);
					} else {
						mns.setEditable(false);
					}

				} else {
					if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						mns.setEditable(true);
					} else {
						mns.setEditable(false);
					}
				}
			}
		});
		mns.setColumns(10);
		mns.setBounds(412, 256, 86, 20);
		contentPane.add(mns);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Mobile No(Self) :");
		lblNewLabel_1_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_3_1.setBounds(300, 258, 116, 14);
		contentPane.add(lblNewLabel_1_1_3_1);

		JLabel lblNewLabel_1_3 = new JLabel("Date Of Birth :");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(57, 296, 104, 14);
		contentPane.add(lblNewLabel_1_3);

		date = new JDateChooser();
		date.setBounds(157, 293, 114, 22);
		contentPane.add(date);

		JLabel lblNewLabel_1_1_4 = new JLabel("Gender :");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_4.setBounds(57, 336, 79, 14);
		contentPane.add(lblNewLabel_1_1_4);

		JRadioButton rmale = new JRadioButton("Male");
		rmale.setForeground(Color.WHITE);
		rmale.setOpaque(false);
		JRadioButton rfemale = new JRadioButton("Female");
		rfemale.setForeground(Color.WHITE);
		rfemale.setOpaque(false);
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(136, 333, 52, 23);
		contentPane.add(rmale);

		rfemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rfemale.isSelected()) {
					rmale.setSelected(false);
				}
			}
		});

		rmale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rmale.isSelected()) {
					rfemale.setSelected(false);
				}
			}
		});

		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(205, 333, 66, 23);
		contentPane.add(rfemale);

		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setIcon(new ImageIcon(adddata.class.getResource("/img/insert.png")));
		btnNewButton.setBounds(124, 399, 114, 22);
		contentPane.add(btnNewButton);

		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		JLabel hla = new JLabel();
		hla.setBounds(0, 0, 1354, 465);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(hla.getWidth(), hla.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		hla.setIcon(img);
		contentPane.add(hla);

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root", "");
			PreparedStatement pst = con.prepareStatement("select * from studdata");
			ResultSet r = pst.executeQuery();

			while (r.next()) {

				String fn = r.getString(1);
				String fn1 = r.getString(2);
				String fn2 = r.getString(3);
				String fn3 = r.getString(4);
				String fn4 = r.getString(5);
				String fn5 = r.getString(6);
				String fn6 = r.getString(7);
				String fn7 = r.getString(8);
				String fn8 = r.getString(9);
				String fn9 = r.getString(10);
				String fn10 = r.getString(11);
				String fn11 = r.getString(12);

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { fn1, fn2, fn3, fn4, fn5, fn6, fn7, fn8, fn9, fn10, fn11 });

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (fnt.getText().equals("") || lnt.getText().equals("") || ent.getText().equals("")
						|| brcombo.getSelectedItem().equals("None") || semjcm.getSelectedItem().equals("None")
						|| addt.getText().equals("") || mnpt.getText().equals("") || mns.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter All Details");
				} else {

					String fn = fnt.getText();
					String ln = lnt.getText();
					String enroll = ent.getText();
					String branch = (String) brcombo.getSelectedItem();
					String sem = (String) semjcm.getSelectedItem();
					String year = (String) yearjcm.getSelectedItem();
					String address = addt.getText();
					String mobnp = mnpt.getText();
					String mobns = mns.getText();
					String g = null;
					try {
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						d = df.format(date.getDate());
					} catch (Exception ez) {
					}

					if (rmale.isSelected()) {
						g = "Male";
					}
					if (rfemale.isSelected()) {
						g = "Female";
					}

					try {

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang",
								"root", "");
						String q = "insert into studdata(fname,lname,enrollno,branch,semester,year,address,mobnp,mobns,dob,gender) values(?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(q);

						pst.setString(1, fn);
						pst.setString(2, ln);
						pst.setString(3, enroll);
						pst.setString(4, branch);
						pst.setString(5, sem);
						pst.setString(6, year);
						pst.setString(7, address);
						pst.setString(8, mobnp);
						pst.setString(9, mobns);
						pst.setString(10, d);
						pst.setString(11, g);
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Successful");
						showtable();

						fnt.setText("");
						lnt.setText("");
						ent.setText("");
						brcombo.setSelectedItem("None");
						semjcm.setSelectedItem("None");
						yearjcm.setSelectedItem("None");
						addt.setText("");
						mnpt.setText("");
						mns.setText("");
						date.setDate(null);
						rmale.setSelected(false);
						rfemale.setSelected(false);

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "Warning", JOptionPane.WARNING_MESSAGE);
						// JOptionPane.showMessageDialog(null, "Please Enter All Details");
					}
				}

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn = fnt.getText();
				String ln = lnt.getText();
				String enroll = ent.getText();
				String branch = (String) brcombo.getSelectedItem();
				String sem = (String) semjcm.getSelectedItem();
				String year = (String) yearjcm.getSelectedItem();
				String address = addt.getText();
				String mobnp = mnpt.getText();
				String mobns = mns.getText();
				String g = null;
				if (rmale.isSelected()) {
					g = "Male";
				}
				if (rfemale.isSelected()) {
					g = "Female";
				}

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String d = df.format(date.getDate());

				try {

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root",
							"");
					String up = "UPDATE studdata SET lname=?,enrollno=?,branch=?,semester=?,year=?,address=?,mobnp=?,mobns=?,dob=?,fname=?,gender=? WHERE fname=?";
					int row = table.getSelectedRow();
					String cell = table.getModel().getValueAt(row, 0).toString();
					PreparedStatement pst = con.prepareStatement(up);

					pst.setString(1, ln);
					pst.setString(2, enroll);
					pst.setString(3, branch);
					pst.setString(4, sem);
					pst.setString(5, year);
					pst.setString(6, address);
					pst.setString(7, mobnp);
					pst.setString(8, mobns);
					pst.setString(9, d);
					pst.setString(10, fn);
					pst.setString(11, g);
					pst.setString(12, cell);
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Update Successful");
					fnt.setText("");
					lnt.setText("");
					ent.setText("");
					brcombo.setSelectedItem("None");
					semjcm.setSelectedItem("None");
					yearjcm.setSelectedItem("None");
					addt.setText("");
					mnpt.setText("");
					mns.setText("");
					date.setDate(null);
					rmale.setSelected(false);
					rfemale.setSelected(false);
					showtable();

				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();

				fnt.setText(model.getValueAt(row, 0).toString());
				lnt.setText(model.getValueAt(row, 1).toString());
				ent.setText(model.getValueAt(row, 2).toString());
				brcombo.setSelectedItem(model.getValueAt(row, 3).toString());
				semjcm.setSelectedItem(model.getValueAt(row, 4).toString());
				yearjcm.setSelectedItem(model.getValueAt(row, 5).toString());
				addt.setText(model.getValueAt(row, 6).toString());
				mnpt.setText(model.getValueAt(row, 7).toString());
				mns.setText(model.getValueAt(row, 8).toString());
				String gen = model.getValueAt(row, 10).toString();
				try {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 9).toString());
					date.setDate(date1);

					if (gen.equals("Male")) {
						rmale.setSelected(true);
						rfemale.setSelected(false);
					} else {
						rfemale.setSelected(true);
						rmale.setSelected(false);
					}

				} catch (Exception e2) {
				}
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnt.setText("");
				lnt.setText("");
				ent.setText("");
				brcombo.setSelectedItem("None");
				semjcm.setSelectedItem("None");
				yearjcm.setSelectedItem("None");
				addt.setText("");
				mnpt.setText("");
				mns.setText("");
				date.setDate(null);
				rmale.setSelected(false);
				rfemale.setSelected(false);
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Are You Sure", "Delete", JOptionPane.YES_NO_OPTION);
				if (a == 0) {
					int row = table.getSelectedRow();
					String cell = table.getModel().getValueAt(row, 0).toString();
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang",
								"root", "");
						PreparedStatement pst = con.prepareStatement("delete from studdata where fname =?");
						pst.setString(1, cell);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Deleted");
						fnt.setText("");
						lnt.setText("");
						ent.setText("");
						brcombo.setSelectedItem("None");
						semjcm.setSelectedItem("None");
						yearjcm.setSelectedItem("None");
						addt.setText("");
						mnpt.setText("");
						mns.setText("");
						date.setDate(null);
						rmale.setSelected(false);
						rfemale.setSelected(false);
						showtable();
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});
	}

	public void showtable() {

		table.setModel(new DefaultTableModel(null, new String[] { "First Name", "Last Name", "Enroll No", "Branch",
				"Semester", "Year", "Address", "Mob No(P)", "Mob No(S)", "DOB", "Gender" }));
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root", "");
			PreparedStatement pst = con.prepareStatement("select * from studdata");
			ResultSet r = pst.executeQuery();

			while (r.next()) {

				String fn = r.getString(1);
				String fn1 = r.getString(2);
				String fn2 = r.getString(3);
				String fn3 = r.getString(4);
				String fn4 = r.getString(5);
				String fn5 = r.getString(6);
				String fn6 = r.getString(7);
				String fn7 = r.getString(8);
				String fn8 = r.getString(9);
				String fn9 = r.getString(10);
				String fn10 = r.getString(11);
				String fn11 = r.getString(12);

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { fn1, fn2, fn3, fn4, fn5, fn6, fn7, fn8, fn9, fn10, fn11 });
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
