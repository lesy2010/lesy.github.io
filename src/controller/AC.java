package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import view.View;
import model.Model;
public class AC implements ActionListener{
	private View view;
	private Model model;
	
	public AC(View view) {
		this.view = view;
		model = new Model();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		view.Ebg = view.bg.getElements();
		while(view.Ebg.hasMoreElements()) {
			JRadioButton b = (JRadioButton) view.Ebg.nextElement();
			if(b.isSelected()){
				b.setForeground(Color.blue);
				int i = b.getText().indexOf("    ");
				model.setMonChinh(b.getText().substring(0, i));
			}else if(!b.isSelected()) {	
				b.setForeground(Color.black);
			}
		}
		for (JCheckBox b:view.listPhu) {
			if(b.isSelected()) {
				b.setForeground(Color.green);
			}
			else if(!b.isSelected()) {
				b.setForeground(Color.black);
			}
		}
		if(command.equals("Thanh toán")) {
			view.MonChinhValue.setText(model.getMonChinh());
			for(JCheckBox b:view.listPhu) {
				if(b.isSelected()) {
					int i = b.getText().indexOf("    ");
					model.setMonPhu(model.getMonPhu()+", "+b.getText().substring(0,i));
					//model.getMonPhu().s
				}
			}
			//Xu li chuoi
			view.MonPhuValue.setText(model.getMonPhu().substring(2));
			TongTien();
		}
		
	}
	void xulichuoi() {
		
		//model.ge
	}
	void TongTien() {
		if (model.getMonChinh().equals("Tôm chiên giòn")) {
			model.setTongtien(1000);
		}else if (model.getMonChinh().equals("Gà hấp lá chanh")) {
			model.setTongtien(2000);
		}else if (model.getMonChinh().equals("Bò bít tết")) {
			model.setTongtien(3000);
		}else if (model.getMonChinh().equals("Nem rán")) {
			model.setTongtien(4000);
		}
		
		StringTokenizer stk = new StringTokenizer(view.MonPhuValue.getText(), ",");
		while(stk.hasMoreElements()) {
			String monPhu = stk.nextToken().trim();
			System.out.println(monPhu);
			if(monPhu.equals("Trà")) {
				model.setTongtien(model.getTongtien()+5000);
			}else if(monPhu.equals("Coca cola")) {
				model.setTongtien(model.getTongtien()+6000);
			}else if(monPhu.equals("Pudding")) {
				model.setTongtien(model.getTongtien()+7000);
			}else if(monPhu.equals("Bánh kem")) {
				model.setTongtien(model.getTongtien()+8000);
			}
		}
		view.TongtienValue.setText(String.valueOf((int)model.getTongtien())+" VND");
	}
}
