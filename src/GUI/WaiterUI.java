package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.RestaurantProcessing;

public class WaiterUI extends JFrame {
	RestaurantProcessing restaurant;
	Font font = new Font("", 1, 14);
	
	private JTextField adaugaNrMasa=new JTextField("Numar masa");
	private JTextField adaugaData=new JTextField("Data comanda");
	private JTextField adaugaProdus=new JTextField("ProduseComandate");
	private JTextField idComanda=new JTextField("idComanda");
	
	private JButton butonAdaugaComanda=new JButton("ADD ORDER");
	private JButton genereazaNotaPlata=new JButton("GENERATE BILL");
	private JTable comanda=new JTable();
	
	private JPanel chelner=new JPanel();
	private JPanel butoane=new JPanel();
	private JPanel dateComanda=new JPanel();
	private JFrame frame=new JFrame();

	public WaiterUI(RestaurantProcessing r) {
		this.restaurant=r;
		
		frame = new JFrame("Chelner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,500);
			
		adaugaNrMasa.setMaximumSize(new Dimension(200, 20));
		adaugaData.setMaximumSize(new Dimension(200, 20));
		adaugaProdus.setMaximumSize(new Dimension(200, 20));
		idComanda.setMaximumSize(new Dimension(200, 20));
		
		chelner.setLayout(new BoxLayout(chelner, BoxLayout.Y_AXIS));
		dateComanda.setLayout(new BoxLayout(dateComanda, BoxLayout.X_AXIS));
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.X_AXIS));
		
		butonAdaugaComanda.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				WaiterUI.this.restaurant.createNewOrder(Integer.parseInt(adaugaNrMasa.getText()), adaugaData.getText(),adaugaProdus.getText());
				completeazaComanda();
			}
		});

		/*genereazaNotaPlata.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				WaiterUI.this.restaurant.generateBill(Integer.parseInt(idComanda.getText()));
				completeazaComanda();
			}
		});*/
		
		dateComanda.add(adaugaNrMasa);
		dateComanda.add(adaugaData);
		dateComanda.add(adaugaProdus);
		dateComanda.add(idComanda);
		butoane.add(butonAdaugaComanda);
		butoane.add(genereazaNotaPlata);
		chelner.add(dateComanda);
		chelner.add(butoane);
		chelner.add(comanda);
		frame.add(chelner);
		
		completeazaComanda();
		frame.setVisible(true);
	}
	
	public void completeazaComanda() {

		DefaultTableModel model = new DefaultTableModel();
		String[] coloane = { "IdComanda", "nrMasa", "Produs", "PretComanda"};
		model.setColumnIdentifiers(coloane);

	   comanda.setModel(model);

		for (String[] data : restaurant.getDataOrder()) {
				model.addRow(data);
		}

		comanda.setFont(font);
		comanda.setRowHeight(30);

		this.repaint();
		this.revalidate();

	}

}
