package GUI;

import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import business.MenuItem;

public class ChefUI extends JFrame implements Observer{
	ArrayList<MenuItem> produse=new ArrayList<MenuItem>();
	Font font = new Font("", 1, 14);
	
	private JTable comenziChef=new JTable();
	private JFrame frame;
	private JPanel chef=new JPanel();
	private JLabel txtId = new JLabel("      Id                    Name                 Price         ");
	
	public ChefUI() {
		frame=new JFrame("Bucatar");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		
		chef.setLayout(new BoxLayout(chef, BoxLayout.Y_AXIS));
		chef.add(txtId);
		chef.add(comenziChef);
		frame.add(chef);
		
		completeazaComenziBucatar();
		
		frame.setVisible(true);
	}
		
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		produse.addAll((ArrayList<MenuItem>) arg1);
		completeazaComenziBucatar();
		
	}
	private void completeazaComenziBucatar() {
		DefaultTableModel model = new DefaultTableModel();
		String[] columns = { " ID ", " NAME", "PRICE" };
		model.setColumnIdentifiers(columns);

		comenziChef.setModel(model);

		for (MenuItem menuItem : produse) {
			model.addRow(menuItem.toStringDateChef());
		}

		comenziChef.setFont(font);
		comenziChef.setRowHeight(30);

		this.repaint();
		this.revalidate();
	}
}
