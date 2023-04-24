package fe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import contrac.Person;
import dal.PersonDAL;
import helper.Helper;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelefonRehberiFE extends JFrame {

	private JPanel contentPane;
	private JTable tblRehber;
	private JTextField txtAra;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextArea txtAdres;
	private DefaultTableModel personModel;

	private Object[] personData;
	PersonDAL personDal = new PersonDAL();
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelefonRehberiFE frame = new TelefonRehberiFE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelefonRehberiFE() {

		personModel = new DefaultTableModel();
		Object[] colPerson = new Object[6];
		colPerson[0] = "ID";
		colPerson[1] = "Ad";
		colPerson[2] = "Soyad";
		colPerson[3] = "Tel";
		colPerson[4] = "Email";
		colPerson[5] = "Adres";
		personModel.setColumnIdentifiers(colPerson);
		ListAll();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 451);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tblRehber = new JTable(personModel);

		tblRehber.setBounds(166, 275, 169, 94);
//		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 331, 163);
		scrollPane.setViewportView(tblRehber);
		contentPane.add(scrollPane);

		txtAra = new JTextField();
		
		txtAra.setBounds(10, 28, 265, 20);
		contentPane.add(txtAra);
		txtAra.setColumns(10);

		JLabel lblArama = new JLabel("Arama");
		lblArama.setBackground(new Color(0, 255, 255));
		lblArama.setBounds(291, 28, 62, 20);
		contentPane.add(lblArama);

		JLabel lblAd = new JLabel("Ad");
		lblAd.setBounds(414, 28, 46, 20);
		contentPane.add(lblAd);

		txtAd = new JTextField();
		txtAd.setBounds(496, 28, 187, 20);
		contentPane.add(txtAd);
		txtAd.setColumns(10);

		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(414, 60, 46, 20);
		contentPane.add(lblSoyad);

		txtSoyad = new JTextField();
		txtSoyad.setBounds(496, 57, 187, 20);
		contentPane.add(txtSoyad);
		txtSoyad.setColumns(10);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(496, 88, 187, 20);
		contentPane.add(txtTel);

		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(414, 91, 46, 20);
		contentPane.add(lblTel);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(496, 119, 187, 20);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(414, 122, 46, 20);
		contentPane.add(lblEmail);

		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setBounds(414, 153, 46, 20);
		contentPane.add(lblAdres);

		txtAdres = new JTextArea();
		txtAdres.setBounds(496, 156, 187, 116);
		contentPane.add(txtAdres);

		JButton btnEkle = new JButton("Ekle");

		btnEkle.setBounds(310, 302, 89, 43);
		contentPane.add(btnEkle);

		JButton btnSil = new JButton("Sil");

		btnSil.setBounds(435, 302, 89, 43);
		contentPane.add(btnSil);

		JButton btnGuncelle = new JButton("Güncelle");

		btnGuncelle.setBounds(561, 302, 89, 43);
		contentPane.add(btnGuncelle);

		JButton btnTemizle = new JButton("Temizle");

		btnTemizle.setBounds(698, 302, 89, 43);
		contentPane.add(btnTemizle);

		txtID = new JTextField();
		txtID.setBounds(463, 370, 104, 31);
		txtID.setVisible(false);
		contentPane.add(txtID);
		txtID.setColumns(10);

		
		
		
		txtAra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				List<Person> personList;
				
				String ara=txtAra.getText();
				if (!ara.equals("")) {
					try {
						personList=personDal.getBySearch(ara);
						personModel.setRowCount(0);
						personData=new Object[6];
						for (int i = 0; i < personList.size(); i++) {
							personData[0]=personList.get(i).getId();
							personData[1]=personList.get(i).getAd();
	                        personData[2]=personList.get(i).getSoyad();
	                        personData[3]=personList.get(i).getTel();
	                        personData[4]=personList.get(i).getEmail();
	                        personData[5]=personList.get(i).getAdres();
	                        personModel.addRow(personData);
									
						}
					} catch (Exception e2) {
						 e2.printStackTrace();
					}
				}
				
				
			}
		});
		
		
		
		
		
		
		
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtID.getText().isEmpty()) {
					int id = Integer.parseInt(txtID.getText());
					Person person = new Person(id, txtAd.getText(), txtSoyad.getText(),
							txtTel.getText(),
							txtEmail.getText(), txtAdres.getText());

                    try {
                        boolean control=personDal.update(person);
                        if (control) {
                            Helper.showWsg("success");
                            ListAll();
                            temizle();
                        } else {
                            Helper.showWsg("error");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    Helper.showWsg("Lutfen bir kisi seciniz");
                }

            }
        });

		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
					if (!txtID.getText().isEmpty()) {
						int id = Integer.parseInt(txtID.getText());
						try {
							boolean control = personDal.delete(id);
							if (control) {
								Helper.showWsg("success");
								ListAll();
								temizle();
							} else {
								Helper.showWsg("error");
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					} else {
						Helper.showWsg("Lutfen bir kisi seçiniz");
					}

				}

			}
		});

		tblRehber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtID.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 0).toString());
				txtAd.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 1).toString());
				txtSoyad.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 2).toString());
				txtTel.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 3).toString());
				txtEmail.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 4).toString());
				txtAdres.setText(personModel.getValueAt(tblRehber.getSelectedRow(), 5).toString());
			}

		});

		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temizle();

			}
		});

		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = new Person(txtAd.getText(), txtSoyad.getText(), txtTel.getText(), txtEmail.getText(),
						txtAdres.getText());
				try {
					boolean control = personDal.insert(person);
					if (control) {
						Helper.showWsg("success");
						ListAll();
						temizle();
					} else {
						Helper.showWsg("error");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	private void ListAll() {
		personModel.setRowCount(0);
		personData = new Object[6];

		try {
			for (int i = 0; i < personDal.getAll().size(); i++) {
				personData[0] = personDal.getAll().get(i).getId();
				personData[1] = personDal.getAll().get(i).getAd();
				personData[2] = personDal.getAll().get(i).getSoyad();
				personData[3] = personDal.getAll().get(i).getTel();
				personData[4] = personDal.getAll().get(i).getEmail();
				personData[5] = personDal.getAll().get(i).getAdres();
				personModel.addRow(personData);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void temizle() {
		txtAd.setText("");
		txtSoyad.setText("");
		txtTel.setText("");
		txtEmail.setText("");
		txtAdres.setText("");

	}
}
