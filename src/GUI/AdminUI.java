package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.*;
import business.MenuItem;

public class AdminUI extends JFrame{
	RestaurantProcessing restaurant;
	Font font = new Font("", 1, 14);
	
	private JTextField addNameProd=new JTextField("Denumire"); 
	private JTextField addPretProd=new JTextField("Price_product"); 
	private JTextField addCompositProd=new JTextField("Composite_product"); 
	private JTextField editID=new JTextField("idEdit"); 
	private JTextField deleteID=new JTextField("idDelete");
	
	private JButton butonAdaugaBP=new JButton("ADD BASE PRODUCT");
	private JButton butonAdaugaCP=new JButton("ADD COMPOSITE PRODUCT");
	private JButton butonEditProd=new JButton("EDIT PRODUCT");
	private JButton butonStergeProd=new JButton("REMOVE PRODUCT");
	
	private JTable meniu=new JTable();
	
	private JPanel admin= new JPanel();
	private JPanel dateMeniu=new JPanel();
	private JPanel butoane=new JPanel();
	private JFrame frame=new JFrame();
	private JLabel txtId,txt;
	
	public AdminUI(RestaurantProcessing r) {
		
		frame = new JFrame("Administrator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,500);
		
		this.restaurant=r;
		
		addNameProd.setMaximumSize(new Dimension(200, 20));
		addPretProd.setMaximumSize(new Dimension(200, 20));
		addCompositProd.setMaximumSize(new Dimension(200, 20));
		editID.setMaximumSize(new Dimension(200, 20));
		deleteID.setMaximumSize(new Dimension(200, 20));
		
		admin.setLayout(new BoxLayout(admin, BoxLayout.Y_AXIS));
		dateMeniu.setLayout(new BoxLayout(dateMeniu, BoxLayout.X_AXIS));
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.X_AXIS));
		
		butonAdaugaBP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg) {
				AdminUI.this.restaurant.addBaseProduct(addNameProd.getText(),Float.parseFloat(addPretProd.getText()));
				completeazaMeniu();
			}
		});

		butonAdaugaCP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg) {
				AdminUI.this.restaurant.addCompositeProduct(addNameProd.getText(),addCompositProd.getText(),Float.parseFloat(addPretProd.getText()));
				completeazaMeniu();
			}
		});
		
		butonStergeProd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg) {
				
				AdminUI.this.restaurant.deleteMenuItem(Integer.parseInt(deleteID.getText()));
				completeazaMeniu();			
			}
		});
		
		butonEditProd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg) {
				
				AdminUI.this.restaurant.editMenuItem(Integer.parseInt(editID.getText()),addNameProd.getText(),Float.parseFloat(addPretProd.getText()),addCompositProd.getText());
				completeazaMeniu();
				
			}
		});
		
		txt=new JLabel("\n\n");
		txtId = new JLabel("IdProd                      Denumire                              Pret                          Ingrediente");
		dateMeniu.add(addNameProd);
		dateMeniu.add(addPretProd);
		dateMeniu.add(addCompositProd);
		dateMeniu.add(editID);
		dateMeniu.add(deleteID);
		butoane.add(butonAdaugaBP);
		butoane.add(butonAdaugaCP);
		butoane.add(butonEditProd);
		butoane.add(butonStergeProd);
		
		admin.add(dateMeniu);
		admin.add(butoane);
		admin.add(txt);
		admin.add(txtId);
		admin.add(meniu);
		frame.add(admin);
		
		completeazaMeniu();
		frame.setVisible(true);
		
	}
	
	private void completeazaMeniu() {

		DefaultTableModel model = new DefaultTableModel();
		String[] columns = { "IdProd", "Denumire", "Pret", "Ingediente" };
		model.setColumnIdentifiers(columns);
		meniu.setModel(model);

		for (MenuItem mI : restaurant.getMeniu()) {
			model.addRow(mI.toStringDate());
		}

		meniu.setFont(font);
		meniu.setRowHeight(30);

		this.repaint();
		this.revalidate();

	}
	
}
