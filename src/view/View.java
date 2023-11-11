package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.AC;
public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Enumeration<AbstractButton> Ebg;
	public ButtonGroup bg;
	public ArrayList<JCheckBox> listPhu;
	public JTextField MonChinhValue;
	public JTextField MonPhuValue;
	public JTextField TongtienValue;
	
	public View() {
		setTitle("Thực đơn");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,370);
		setLocationRelativeTo(null);
		init();
		setVisible(true);
	}
	void init(){
		//Cai dat duong vien
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		
		//Cai dat ActionListener
		AC ac = new AC(this);
		
		//Cai dat font
		Font font = new Font("Arial", Font.BOLD, 20);
		
		//Cai dat icon
		ImageIcon iconTom = createImageIcon("icons/tom.png");
		ImageIcon iconGa = createImageIcon("icons/ga.png");
		ImageIcon iconBo = createImageIcon("icons/bo.png");
		ImageIcon iconNem = createImageIcon("icons/nem.png");
		ImageIcon iconTra = createImageIcon("icons/tea.png");
		ImageIcon iconCoca = createImageIcon("icons/coca.png");
		ImageIcon iconBanh = createImageIcon("icons/banh.png");
		ImageIcon iconPudding = createImageIcon("icons/pudding.png");
		
		//Cai dat panel chon mon
		JPanel panelMon = new JPanel(new GridLayout(1,2));
		
		//Cai dat panelMonChinh
		JPanel panelMonChinh = new JPanel(new GridLayout(5,1));
		panelMonChinh.setBackground(Color.blue);
		JLabel lbChinh = new JLabel("Các món chính", JLabel.CENTER);
		lbChinh.setFont(font);
		panelMonChinh.add(lbChinh);
		JRadioButton tom = new JRadioButton("Tôm chiên giòn    1000 VND", iconTom);
		JRadioButton ga = new JRadioButton("Gà hấp lá chanh    2000 VND", iconGa);
		JRadioButton bo = new JRadioButton("Bò bít tết    3000 VND", iconBo);
		JRadioButton nem = new JRadioButton("Nem rán    4000 VND",iconNem);
		 bg = new ButtonGroup();
		bg.add(tom);
		bg.add(ga);
		bg.add(bo);
		bg.add(nem);
		Ebg = bg.getElements();
		while (Ebg.hasMoreElements()) {
			JRadioButton b= (JRadioButton) Ebg.nextElement();
			panelMonChinh.add(b);
			b.addActionListener(ac);
		}
		
		//Cai dat panel mon phu
		JPanel panelMonPhu = new JPanel(new GridLayout(5,1));
		panelMonPhu.setBackground(Color.green);
		JLabel lbPhu = new JLabel("Các món phụ", JLabel.CENTER);
		lbPhu.setFont(font);
		JCheckBox cbTra = new JCheckBox("Trà    5000 VND");
		cbTra.setIcon(iconTra);
		JCheckBox cbCoca = new JCheckBox("Coca cola    6000 VND");
		cbCoca.setIcon(iconCoca);
		JCheckBox cbPudding = new JCheckBox("Pudding    7000 VND");
		cbPudding.setIcon(iconPudding);
		JCheckBox cbBanh = new JCheckBox("Bánh kem    8000 VND");
		cbBanh.setIcon(iconBanh);
		
		panelMonPhu.add(lbPhu);
		listPhu = new ArrayList<JCheckBox>();
		listPhu.add(cbTra);
		listPhu.add(cbCoca);
		listPhu.add(cbBanh);
		listPhu.add(cbPudding);
		for (JCheckBox b:listPhu) {
			panelMonPhu.add(b);
			b.addActionListener(ac);
		}
		
		
		
		
		panelMon.add(panelMonChinh);
		panelMon.add(panelMonPhu);
		
		//Cai dat panel cac mon da chon
		JPanel panelSelected = new JPanel(new GridLayout(6,1));
		
		JLabel lbMonChinh = new JLabel("Món chính đã chọn");
		lbMonChinh.setForeground(Color.blue);
		 MonChinhValue = new JTextField();
		MonChinhValue.setEditable(false);
		 
		JLabel lbMonPhu = new JLabel("Món phụ đã chọn");
		lbMonPhu.setForeground(Color.green);
		 MonPhuValue = new JTextField();
		 MonPhuValue.setEditable(false);
		
		JLabel lbTongtien = new JLabel("Tổng tiền");
		lbTongtien.setForeground(Color.MAGENTA);
		 TongtienValue = new JTextField();
		 TongtienValue.setEditable(false);
		
		panelSelected.add(lbMonChinh);
		panelSelected.add(MonChinhValue);
		panelSelected.add(lbMonPhu);
		panelSelected.add(MonPhuValue);
		panelSelected.add(lbTongtien);
		panelSelected.add(TongtienValue);
		panelSelected.setBorder(border);
		
		//Cai dat panel thanh toan
		JPanel panelThanhtoan = new JPanel(new GridLayout(1,1));
		JButton bt = new JButton("Thanh toán");
		bt.addActionListener(ac);
		panelThanhtoan.add(bt);	
			
		//add vao JFrame
		add(panelMon, BorderLayout.NORTH);
		add(panelSelected, BorderLayout.CENTER);
		add(panelThanhtoan, BorderLayout.SOUTH);
	}
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = View.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
