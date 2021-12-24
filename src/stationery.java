import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class stationery extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static JComboBox cbsem, cbyear, cbbranch;
	static JCheckBox subch1, subch2, subch3, subch4, subch5, subch6, subch7;
	static JLabel fntxt, lntxt, enrtxt;
	String s1 = "---", s2 = "---", s3 = "---", s4 = "---", s5 = "---", s6 = "---", s7 = "---", s8 = "---", man = "---",
			unif = "---", file = "---", Pages = "---";
	int x, y;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stationery frame = new stationery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public stationery() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(stationery.class.getResource("/img/stationery.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 637);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_top = new JPanel();
		panel_top.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx - x, yy - y);
			}
		});
		panel_top.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		panel_top.setBackground(new Color(153, 51, 204));
		panel_top.setBounds(0, 0, 965, 29);
		contentPane.add(panel_top);
		panel_top.setLayout(null);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(stationery.class.getResource("/img/stationery~1.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 0, 37, 29);
		panel_top.add(label_5);

		JLabel label_1 = new JLabel("-");
		label_1.setBounds(917, 2, 15, 23);
		panel_top.add(label_1);
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(stationery.ICONIFIED);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel exitlabel = new JLabel("\u00D7");
		exitlabel.setBounds(940, 0, 15, 29);
		panel_top.add(exitlabel);
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

		JLabel lblStationery = new JLabel("Stationery");
		lblStationery.setHorizontalAlignment(SwingConstants.LEFT);
		lblStationery.setForeground(Color.WHITE);
		lblStationery.setFont(new Font("Ubuntu Mono", Font.BOLD, 24));
		lblStationery.setBounds(47, 2, 161, 23);
		panel_top.add(lblStationery);

		JCheckBox chckbxSelectAll_1 = new JCheckBox("Select All");
		chckbxSelectAll_1.setOpaque(false);
		chckbxSelectAll_1.setForeground(Color.WHITE);
		chckbxSelectAll_1.setBounds(65, 376, 97, 23);
		contentPane.add(chckbxSelectAll_1);

		JCheckBox chckbxSelectAll = new JCheckBox("Select All");
		chckbxSelectAll.setForeground(Color.WHITE);
		chckbxSelectAll.setOpaque(false);
		chckbxSelectAll.setBounds(65, 307, 97, 23);
		contentPane.add(chckbxSelectAll);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(stationery.class.getResource("/img/insert.png")));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBounds(169, 590, 153, 23);
		contentPane.add(btnSubmit);

		JTextArea ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.BOLD, 11));
		ta.setBorder(new TitledBorder(null, "Print Preview", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ta.setEditable(false);
		ta.setBounds(530, 138, 396, 448);
		contentPane.add(ta);

		JLabel lblStudentDetails = new JLabel("Student Details :");
		lblStudentDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentDetails.setBounds(52, 97, 136, 22);
		contentPane.add(lblStudentDetails);

		JLabel lblSelectSubject = new JLabel("Select Subject :");
		lblSelectSubject.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectSubject.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectSubject.setBounds(52, 347, 122, 22);
		contentPane.add(lblSelectSubject);

		subch5 = new JCheckBox("");
		subch5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch5.isSelected()) {
					s5 = subch5.getLabel();
				} else {
					s5 = "---";
				}
			}
		});
		subch5.setForeground(Color.WHITE);
		subch5.setOpaque(false);
		subch5.setBounds(189, 482, 182, 23);
		contentPane.add(subch5);
		subch5.setBackground(Color.LIGHT_GRAY);

		subch6 = new JCheckBox("");
		subch6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch6.isSelected()) {
					s6 = subch6.getLabel();
				} else {
					s6 = "---";
				}
			}
		});
		subch6.setForeground(Color.WHITE);
		subch6.setOpaque(false);
		subch6.setBounds(189, 508, 182, 23);
		contentPane.add(subch6);
		subch6.setBackground(Color.LIGHT_GRAY);

		subch3 = new JCheckBox("");
		subch3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch3.isSelected()) {
					s3 = subch3.getLabel();
				} else {
					s3 = "---";
				}
			}
		});
		subch3.setForeground(Color.WHITE);
		subch3.setOpaque(false);
		subch3.setBounds(189, 430, 182, 23);
		contentPane.add(subch3);
		subch3.setBackground(Color.LIGHT_GRAY);

		subch4 = new JCheckBox("");
		subch4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch4.isSelected()) {
					s4 = subch4.getLabel();
				} else {
					s4 = "---";
				}
			}
		});
		subch4.setForeground(Color.WHITE);
		subch4.setOpaque(false);
		subch4.setBounds(189, 456, 182, 23);
		contentPane.add(subch4);
		subch4.setBackground(Color.LIGHT_GRAY);

		subch1 = new JCheckBox("");
		subch1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch1.isSelected()) {
					s1 = subch1.getLabel();
				} else {
					s1 = "---";
				}
			}
		});
		subch1.setForeground(Color.WHITE);
		subch1.setOpaque(false);
		subch1.setBounds(189, 378, 182, 23);
		contentPane.add(subch1);
		subch1.setBackground(Color.LIGHT_GRAY);

		subch7 = new JCheckBox("");
		subch7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch7.isSelected()) {
					s7 = subch7.getLabel();
				} else {
					s7 = "---";
				}
			}
		});
		subch7.setForeground(Color.WHITE);
		subch7.setOpaque(false);
		subch7.setBounds(189, 534, 182, 23);
		contentPane.add(subch7);
		subch7.setBackground(Color.LIGHT_GRAY);

		subch2 = new JCheckBox("");
		subch2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (subch2.isSelected()) {
					s2 = subch2.getLabel();
				} else {
					s2 = "---";
				}
			}
		});
		subch2.setForeground(Color.WHITE);
		subch2.setOpaque(false);
		subch2.setBounds(189, 404, 182, 23);
		contentPane.add(subch2);
		subch2.setBackground(Color.LIGHT_GRAY);

		JLabel lblSelectStationery = new JLabel("Select Stationery :");
		lblSelectStationery.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectStationery.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectStationery.setBounds(52, 265, 136, 22);
		contentPane.add(lblSelectStationery);

		JPanel panel_search = new JPanel();
		panel_search.setBounds(102, 40, 787, 36);
		panel_search.setBackground(Color.CYAN);
		contentPane.add(panel_search);
		panel_search.setLayout(null);

		JLabel lblEnterEnrollNo = new JLabel("Enter Enroll No  :");
		lblEnterEnrollNo.setFont(new Font("Ubuntu Mono", Font.BOLD, 14));
		lblEnterEnrollNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterEnrollNo.setBounds(115, 0, 144, 32);
		panel_search.add(lblEnterEnrollNo);

		textField = new JTextField();
		textField.setBounds(287, 7, 189, 20);
		panel_search.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setIcon(new ImageIcon(stationery.class.getResource("/img/search.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(514, 6, 122, 23);
		panel_search.add(btnSearch);

		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setBounds(52, 130, 79, 14);
		lblNewLabel_1.setForeground(new Color(0, 0, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Last Name :");
		lblNewLabel_1_2.setBounds(307, 133, 79, 14);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 204));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Enroll No : ");
		lblNewLabel_1_1.setBounds(52, 173, 79, 14);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Branch :");
		lblNewLabel_1_1_1.setBounds(307, 213, 79, 14);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 204));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Semester :");
		lblNewLabel_1_1_1_1.setBounds(52, 215, 79, 14);
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 204));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Year :");
		lblNewLabel_1_1_1_2.setBounds(307, 171, 79, 14);
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 0, 204));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1_2);

		cbsem = new JComboBox();
		cbsem.setEnabled(false);
		cbsem.setModel(new DefaultComboBoxModel(
				new String[] { "None", "1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem" }));
		cbsem.setBounds(152, 209, 86, 22);
		cbsem.setForeground(Color.BLACK);
		cbsem.setBackground(Color.WHITE);
		contentPane.add(cbsem);

		cbyear = new JComboBox();
		cbyear.setEnabled(false);
		cbyear.setModel(new DefaultComboBoxModel(new String[] { "None", "1st Year", "2nd Year", "3rd Year" }));
		cbyear.setBounds(407, 165, 86, 22);
		cbyear.setForeground(Color.BLACK);
		cbyear.setBackground(Color.WHITE);
		contentPane.add(cbyear);

		cbbranch = new JComboBox();
		cbbranch.setEnabled(false);
		cbbranch.setBounds(407, 207, 86, 22);
		cbbranch.setModel(new DefaultComboBoxModel(new String[] { "None", "CM", "EE", "ME", "CE", "E&TC" }));
		cbbranch.setForeground(Color.BLACK);
		cbbranch.setBackground(Color.WHITE);
		contentPane.add(cbbranch);

		fntxt = new JLabel("");
		fntxt.setBounds(152, 130, 79, 14);
		fntxt.setForeground(Color.WHITE);
		fntxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(fntxt);

		enrtxt = new JLabel("");
		enrtxt.setBounds(152, 173, 79, 14);
		enrtxt.setForeground(Color.WHITE);
		enrtxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(enrtxt);

		lntxt = new JLabel("");
		lntxt.setBounds(407, 133, 79, 14);
		lntxt.setForeground(Color.WHITE);
		lntxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lntxt);

		subch1.setEnabled(false);
		subch2.setEnabled(false);
		subch3.setEnabled(false);
		subch4.setEnabled(false);
		subch5.setEnabled(false);
		subch6.setEnabled(false);
		subch7.setEnabled(false);
		chckbxSelectAll_1.setEnabled(false);

		JCheckBox cbmanuals = new JCheckBox("Manuals");
		cbmanuals.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbmanuals.isSelected()) {
					man = cbmanuals.getLabel();
				} else {
					man = "---";
				}

				if (cbmanuals.isSelected() == false) {
					subch1.setEnabled(false);
					subch2.setEnabled(false);
					subch3.setEnabled(false);
					subch4.setEnabled(false);
					subch5.setEnabled(false);
					subch6.setEnabled(false);
					subch7.setEnabled(false);
					chckbxSelectAll_1.setEnabled(false);
				} else {
					subch1.setEnabled(true);
					subch2.setEnabled(true);
					subch3.setEnabled(true);
					subch4.setEnabled(true);
					subch5.setEnabled(true);
					subch6.setEnabled(true);
					subch7.setEnabled(true);
					chckbxSelectAll_1.setEnabled(true);
				}
			}
		});
		cbmanuals.setForeground(Color.WHITE);
		cbmanuals.setOpaque(false);
		cbmanuals.setBackground(Color.WHITE);
		cbmanuals.setBounds(189, 307, 85, 23);
		contentPane.add(cbmanuals);

		JCheckBox cbunf = new JCheckBox("Uniform");
		cbunf.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbunf.isSelected()) {
					unif = cbunf.getLabel();
				} else {
					unif = "---";
				}
			}
		});
		cbunf.setForeground(Color.WHITE);
		cbunf.setOpaque(false);
		cbunf.setBackground(Color.WHITE);
		cbunf.setBounds(279, 307, 78, 23);
		contentPane.add(cbunf);

		JCheckBox cbfile = new JCheckBox("File");
		cbfile.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbfile.isSelected()) {
					file = cbfile.getLabel();
				} else {
					file = "---";
				}
			}
		});
		cbfile.setForeground(Color.WHITE);
		cbfile.setOpaque(false);
		cbfile.setBackground(Color.WHITE);
		cbfile.setBounds(358, 307, 60, 23);
		contentPane.add(cbfile);

		JCheckBox cbpages = new JCheckBox("Pages");
		cbpages.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbpages.isSelected()) {
					Pages = cbpages.getLabel();
				} else {
					Pages = "---";
				}
			}
		});
		cbpages.setForeground(Color.WHITE);
		cbpages.setOpaque(false);
		cbpages.setBackground(Color.WHITE);
		cbpages.setBounds(415, 307, 78, 23);
		contentPane.add(cbpages);

		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		label.setBounds(0, 0, 965, 637);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		label.setIcon(img);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(374, 594, 79, 14);
		contentPane.add(lblNewLabel);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Details");
				} else {
					String subj = "                    " + s1 + "\n" + "                    " + s2 + "\n"
							+ "                    " + s3 + "\n" + "                    " + s4 + "\n"
							+ "                    " + s5 + "\n" + "                    " + s6 + "\n"
							+ "                    " + s7 + "\n" + "                    " + s8;

					ta.setText("*******************************************************\n");
					ta.setText(ta.getText() + "              *   Stationery Receipt   *       \n");
					ta.setText(ta.getText() + "*******************************************************\n");

					ta.setText(ta.getText() + "   Date : " + splashscreenz.dt + "\n\n");
					ta.setText(ta.getText() + "   Name : " + fntxt.getText() + " " + lntxt.getText() + "\n\n");
					ta.setText(ta.getText() + "   Enroll No : " + enrtxt.getText());
					ta.setText(ta.getText() + "             Semster : " + cbsem.getSelectedItem() + "\n\n");
					ta.setText(ta.getText() + "   Year : " + cbyear.getSelectedItem());
					ta.setText(ta.getText() + "             Branch : " + cbbranch.getSelectedItem() + "\n\n");
					ta.setText(ta.getText() + "   Selected Items : \n");
					ta.setText(ta.getText() + "                    " + unif + "\n");
					ta.setText(ta.getText() + "                    " + file + "\n");
					ta.setText(ta.getText() + "                    " + Pages + "\n");
					ta.setText(ta.getText() + "                    " + man + " : " + "\n");
					ta.setText(ta.getText() + subj + "\n\n");
					ta.setText(ta.getText() + "                                         Signature \n");

					String name = fntxt.getText() + " " + lntxt.getText();
					String enrll = enrtxt.getText();
					String sem = (String) cbsem.getSelectedItem();
					String year = (String) cbyear.getSelectedItem();
					String branch = (String) cbbranch.getSelectedItem();

					try {
						String dupq = "select * from stationery_records where enrollno ='" + enrll + "' or semester ='"
								+ sem + "'";
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang",
								"root", "");
						Statement stat = con.createStatement();
						ResultSet rs = stat.executeQuery(dupq);
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Record Already Inserted...");
						} else {
							Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang",
									"root", "");
							String q = "insert into stationery_records(name,enrollno,year,semester,branch,uniform,file,pages,manuals,subjects,date) values(?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement pst = con1.prepareStatement(q);

							pst.setString(1, name);
							pst.setString(2, enrll);
							pst.setString(3, sem);
							pst.setString(4, year);
							pst.setString(5, branch);
							pst.setString(6, unif);
							pst.setString(7, file);
							pst.setString(8, Pages);
							pst.setString(9, man);
							pst.setString(10, subj);
							pst.setString(11, splashscreenz.dt);
							pst.executeUpdate();

							JOptionPane.showMessageDialog(null, "Submit Successfull");
							ta.print();
							chckbxSelectAll.setSelected(false);
							chckbxSelectAll_1.setSelected(false);
							fntxt.setText("");
							lntxt.setText("");
							enrtxt.setText("");
							cbyear.setSelectedItem("None");
							cbsem.setSelectedItem("None");
							cbbranch.setSelectedItem("None");
							cbmanuals.setSelected(false);
							cbunf.setSelected(false);
							cbfile.setSelected(false);
							cbpages.setSelected(false);
							subch1.setSelected(false);
							subch2.setSelected(false);
							subch3.setSelected(false);
							subch4.setSelected(false);
							subch5.setSelected(false);
							subch6.setSelected(false);
							subch7.setSelected(false);
							ta.setText("");
							subch1.setText("");
							subch2.setText("");
							subch3.setText("");
							subch4.setText("");
							subch5.setText("");
							subch6.setText("");
							subch7.setText("");
							textField.setText("");
						}

					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});

		chckbxSelectAll.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxSelectAll.isSelected() == true) {
					cbmanuals.setSelected(true);
					cbunf.setSelected(true);
					cbfile.setSelected(true);
					cbpages.setSelected(true);
				} else {
					cbmanuals.setSelected(false);
					cbunf.setSelected(false);
					cbfile.setSelected(false);
					cbpages.setSelected(false);
				}

			}
		});

		chckbxSelectAll_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxSelectAll_1.isSelected() == true) {
					subch1.setSelected(true);
					subch2.setSelected(true);
					subch3.setSelected(true);
					subch4.setSelected(true);
					subch5.setSelected(true);
					subch6.setSelected(true);
					subch7.setSelected(true);
				} else {
					subch1.setSelected(false);
					subch2.setSelected(false);
					subch3.setSelected(false);
					subch4.setSelected(false);
					subch5.setSelected(false);
					subch6.setSelected(false);
					subch7.setSelected(false);
				}

			}
		});

		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					search();
			}
		});
	}

	public void search() {
		if (textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Enrollment No");
		} else {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root", "");
				PreparedStatement pst = con.prepareStatement("select * from studdata where enrollno = ?");
				pst.setString(1, textField.getText());

				ResultSet r = pst.executeQuery();

				if (r.next()) {

					String fn = r.getString(1);
					String fn2 = r.getString(2);
					String fn3 = r.getString(3);
					String fn4 = r.getString(4);
					String fn5 = r.getString(5);
					String fn6 = r.getString(6);
					String fn7 = r.getString(7);

					fntxt.setText(fn2);
					lntxt.setText(fn3);
					enrtxt.setText(fn4);
					cbbranch.setSelectedItem(fn5);
					cbsem.setSelectedItem(fn6);
					cbyear.setSelectedItem(fn7);

					if ((String) cbsem.getSelectedItem() == "1st Sem") {
						if ((String) cbbranch.getSelectedItem() == "CM") {
							subch1.setText("Fundamental of ICT 22001");
							subch2.setText("Engineering Graphics 22003");
							subch3.setText("Workshop Practice 22006");
							subch4.setText("English 22101");
							subch5.setText("Basic Science (Physics & Chemistry) 22102");
							subch6.setText("Mathematics 22103");
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("Fundamental of ICT 22001");
							subch2.setText("Engineering Graphics 22003");
							subch3.setText("Workshop Practice 22006");
							subch4.setText("English 22101");
							subch5.setText("Basic Science (Physics & Chemistry) 22102");
							subch6.setText("Mathematics 22103");
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("Fundamental of ICT 22001");
							subch2.setText("Engineering Graphics 22003");
							subch3.setText("Workshop Practice 22006");
							subch4.setText("English 22101");
							subch5.setText("Basic Science (Physics & Chemistry) 22102");
							subch6.setText("Mathematics 22103");
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "ME") {
							subch1.setText("Fundamental of ICT 22001");
							subch2.setText("Engineering Graphics 22003");
							subch3.setText("Workshop Practice 22006");
							subch4.setText("English 22101");
							subch5.setText("Basic Science (Physics & Chemistry) 22102");
							subch6.setText("Mathematics 22103");
							subch7.setVisible(false);
						} else {
							subch1.setText("Fundamental of ICT 22001");
							subch2.setText("Engineering Graphics 22003");
							subch3.setText("Workshop Practice 22006");
							subch4.setText("English 22101");
							subch5.setText("Basic Science (Physics & Chemistry) 22102");
							subch6.setText("Mathematics 22103");
							subch7.setVisible(false);
						}
					} else if ((String) cbsem.getSelectedItem() == "2nd Sem") {
						if ((String) cbbranch.getSelectedItem() == "CM") {
							subch1.setText("EEC 22215");
							subch2.setText("AMI 22224");
							subch3.setText("BEC 22225");
							subch4.setText("PCI 22226");
							subch5.setText("BCC 22009");
							subch6.setText("CPH 22013");
							subch7.setText("WPD 22014");
						} else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("AME 22210");
							subch2.setText("ASE 22211");
							subch3.setText("FEE 22212");
							subch4.setText("EOE 22213");
							subch5.setText("BME 22214");
							subch6.setText("BCC 22009");
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("AMS 22201");
							subch2.setText("ASM 22202");
							subch3.setText("AME 22203");
							subch4.setText("CMA 22204");
							subch5.setText("BSU 22205");
							subch6.setText("CEW 22008");
							subch7.setText("BCC 22009");
						} else if ((String) cbbranch.getSelectedItem() == "ME") {

							subch1.setText("ASM 22202");
							subch2.setText("AME 22203");
							subch3.setText("AMP 22206");
							subch4.setText("EDR 22207");
							subch5.setText("BCC 22009");
							subch6.setText("MEW 22010");
							subch7.setVisible(false);
						} else {

							subch1.setText("AME 22210");
							subch2.setText("EEC 22215");
							subch3.setText("BEL 22216");
							subch4.setText("EEM 22217");
							subch5.setText("CPR 22218");
							subch6.setText("BCC 22009");
							subch7.setVisible(false);
						}
					} else if ((String) cbsem.getSelectedItem() == "3rd Sem") {
						if ((String) cbbranch.getSelectedItem() == "CM") {

							subch1.setText("OOP 22316");
							subch2.setText("DSU 22317");
							subch3.setText("CGR 22318");
							subch4.setText("DMS 22319 ");
							subch5.setText("DTE 22320");
							subch6.setVisible(false);
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("ECI 22324");
							subch2.setText("EEM 22325");
							subch3.setText("FPE 22326");
							subch4.setText("EPG 22327");
							subch5.setText("EMW 22328");
							subch6.setVisible(false);
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("ASU 22301");
							subch2.setText("HEN 22302");
							subch3.setText("MOS 22303");
							subch4.setText("BCO 22304");
							subch5.setText("CTE 22305");
							subch6.setText("CAD 22022");
							subch7.setVisible(false);
						} else if ((String) cbbranch.getSelectedItem() == "ME") {
							subch1.setText("SOM 22306");
							subch2.setText("BEE 22310");
							subch3.setText("TEN 22337");
							subch4.setText("MWM 22341");
							subch5.setText("EME 22342");
							subch6.setText("MEM 22343");
							subch7.setVisible(false);
						}

						else {
							subch1.setText("DTE 22320");
							subch2.setText("AEL 22329");
							subch3.setText("ECN 22330");
							subch4.setText("EMI 22333");
							subch5.setText("PEC 22334");
							subch6.setVisible(false);
							subch7.setVisible(false);
						}

					} else if ((String) cbsem.getSelectedItem() == "4th Sem") {

						if ((String) cbbranch.getSelectedItem() == "CM") {
							subch1.setText("JPR 22412");
							subch2.setText("SEN 22413");
							subch3.setText("DCC 22414");
							subch4.setText("MIC 22415");
							subch5.setText("GAD 22034");
							subch6.setVisible(false);
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("CNE 22418");
							subch2.setText("EPT 22419");
							subch3.setText("IME 22420");
							subch4.setText("DEM 22421");
							subch5.setText("EDC 22033");
							subch6.setVisible(false);
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("HRY 22401");
							subch2.setText("TOS 22402");
							subch3.setText("RBE 22403");
							subch4.setText("GTE 22404");
							subch5.setText("BPD 22405");
							subch6.setText("EST 22447");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "ME") {
							subch1.setText("TOM 22438");
							subch2.setText("MEM 22443");
							subch3.setText("FMM 22445");
							subch4.setText("MPR 22446");
							subch5.setText("EST 22447");
							subch6.setText("CAD 22042");
							subch7.setText("FOM 22048");
						}

						else {
							subch1.setText("LIC 22423");
							subch2.setText("CEL 22425");
							subch3.setText("MAA 22426");
							subch4.setText("BPE 22427");
							subch5.setText("DCS 22428");
							subch6.setText("MET 22036");
							subch7.setVisible(false);
						}

					} else if ((String) cbsem.getSelectedItem() == "5th Sem") {

						if ((String) cbbranch.getSelectedItem() == "CM") {
							subch1.setText("EST 22447");
							subch2.setText("OSY 22516");
							subch3.setText("AJP 22517");
							subch4.setText("STE 22518");
							subch5.setText("ACN 22520");
							subch6.setVisible(false);
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("MAN 22509");
							subch2.setText("IAM 22523");
							subch3.setText("SAP 22524");
							subch4.setText("ECA 22525");
							subch5.setText("ELA 22526");
							subch6.setText("WPT 22528");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("WRE 22501");
							subch2.setText("DSR 22502");
							subch3.setText("EAC 22503");
							subch4.setText("PHE 22504");
							subch5.setText("RDE 22505");
							subch6.setText("ECG 22506");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "ME") {
							subch1.setText("MAN 22509");
							subch2.setText("PER 22562");
							subch3.setText("AMP 22563");
							subch4.setText("EMD 22564");
							subch5.setText("PPE 22566");
							subch6.setText("SMA 22053");
							subch7.setVisible(false);
						}

						else {

							subch1.setText("EST 22447");
							subch2.setText("CSP 22531");
							subch3.setText("ESY 22532");
							subch4.setText("MWC 22533");
							subch5.setText("LAU 22534");
							subch6.setText("MAR 22535");
							subch7.setVisible(false);
						}

					}

					else {

						if ((String) cbbranch.getSelectedItem() == "CM") {
							subch1.setText("MGT 22509");
							subch2.setText("PWP 22616");
							subch3.setText("MAD 22617");
							subch4.setText("ETI 22618");
							subch5.setText("NIS 22620");
							subch6.setText("DWM 22621");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "EE") {
							subch1.setText("MEE 22625");
							subch2.setText("UEE 22626");
							subch3.setText("EEC 22627");
							subch4.setText("ETE 22628");
							subch5.setText("IDC 22629");
							subch6.setText("PSO 22632");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "CE") {
							subch1.setText("MAN 22509");
							subch2.setText("CAA 22601");
							subch3.setText("MRS 22602");
							subch4.setText("ETC 22603");
							subch5.setText("BSE 22604");
							subch6.setText("SWM 22605");
							subch7.setVisible(false);
						}

						else if ((String) cbbranch.getSelectedItem() == "ME") {
							subch1.setText("ETM 22652");
							subch2.setText("IHP 22655");
							subch3.setText("AEN 22656");
							subch4.setText("IEQ 22657");
							subch5.setText("CIM 22658");
							subch6.setText("RAC 22660");
							subch7.setVisible(false);
						}

						else {
							subch1.setText("MAN 22509");
							subch2.setText("CND 22634");
							subch3.setText("ETE 22636");
							subch4.setText("MEC 22643");
							subch5.setText("ONS 22647");
							subch6.setText("EDE 22032");
							subch7.setVisible(false);
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, "Not Found...", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
}
