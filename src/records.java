import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class records extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int x, y;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					records frame = new records();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 618);
		setLocationRelativeTo(null);
		setUndecorated(true);
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

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(records.class.getResource("/img/print.png")));
		btnPrint.setBounds(551, 580, 89, 23);
		contentPane.add(btnPrint);

		JPanel panel_search = new JPanel();
		panel_search.setLayout(null);
		panel_search.setBackground(Color.CYAN);
		panel_search.setBounds(201, 56, 787, 50);
		contentPane.add(panel_search);

		JLabel lblEnterEnrollNo = new JLabel("Enter Name  :");
		lblEnterEnrollNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterEnrollNo.setFont(new Font("Ubuntu Mono", Font.BOLD, 14));
		lblEnterEnrollNo.setBounds(115, 0, 144, 32);
		panel_search.add(lblEnterEnrollNo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(287, 7, 189, 20);
		panel_search.add(textField);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setIcon(new ImageIcon(records.class.getResource("/img/search.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(514, 6, 122, 23);
		panel_search.add(btnSearch);

		JLabel lblyouSearchEverything = new JLabel("(You Search Everything , Eg.Name , Enroll No , Branch  )");
		lblyouSearchEverything.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblyouSearchEverything.setForeground(new Color(128, 0, 0));
		lblyouSearchEverything.setHorizontalAlignment(SwingConstants.CENTER);
		lblyouSearchEverything.setBounds(245, 33, 307, 14);
		panel_search.add(lblyouSearchEverything);
		panel_top.setLayout(null);
		panel_top.setBackground(new Color(153, 51, 204));
		panel_top.setBounds(0, 0, 1199, 29);
		contentPane.add(panel_top);

		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(records.ICONIFIED);
			}
		});

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(records.class.getResource("/img/stationery~1.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 0, 37, 27);
		panel_top.add(label_5);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(1151, 4, 15, 23);
		panel_top.add(label_1);

		JLabel exitlabel = new JLabel("\u00D7");
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
		exitlabel.setBounds(1174, 2, 15, 29);
		panel_top.add(exitlabel);

		JLabel lblStationeryRecords = new JLabel("Stationery Records");
		lblStationeryRecords.setHorizontalAlignment(SwingConstants.LEFT);
		lblStationeryRecords.setForeground(Color.WHITE);
		lblStationeryRecords.setFont(new Font("Ubuntu Mono", Font.BOLD, 24));
		lblStationeryRecords.setBounds(45, 4, 252, 23);
		panel_top.add(lblStationeryRecords);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 138, 1118, 419);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowHeight(100);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Enroll No", "Name", "Year", "Semester",
				"Branch", "Uniform", "File", "Pages", "Manuals", "Date" }));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		TableColumn col = table.getColumnModel().getColumn(8);
		col.setPreferredWidth(315);
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(50);

		TableColumn col1 = table.getColumnModel().getColumn(1);
		col1.setPreferredWidth(200);
		col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(50);

		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon("src/img/Background.jpg");
		label.setBounds(0, 0, 1199, 618);
		Image i = img.getImage();
		Image ni = i.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		img.setImage(ni);
		label.setIcon(img);
		contentPane.add(label);

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stationery_mang", "root", "");
			PreparedStatement pst = con.prepareStatement("select * from stationery_records");
			ResultSet r = pst.executeQuery();

			while (r.next()) {

				String fn1 = r.getString(2);
				String fn2 = r.getString(3);
				String fn3 = r.getString(4);
				String fn4 = r.getString(5);
				String fn5 = r.getString(6);
				String fn6 = r.getString(7);
				String fn7 = r.getString(8);
				String fn8 = r.getString(9);
				String fn10 = r.getString(11);
				String fn11 = r.getString(12);

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { fn2, fn1, fn4, fn3, fn5, fn6, fn7, fn8, "<html>" + fn10 + "</html>", fn11 });

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));

			}
		});

		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Stationery Records Data");
				MessageFormat footer = new MessageFormat("Stationery Management System");
				try {
					//table.print();
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
	}
}
