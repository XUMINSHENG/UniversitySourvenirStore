package sg.edu.nus.iss.usstore.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.security.KeyStore;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import sg.edu.nus.iss.usstore.domain.*;

/*
 * Main Window with CardLayout and MenuBar
 * 
 * Register Panel here
 * 
 * For example:
 * ProductListPanel productListPanel = new ProductListPanel(manager);
 * cards.add(productListPanel,"cardName");
 * 
 * When call the panel, using changeCard(cardName) method
 * 
 * @ XIE JIABAO 
 */
public class StoreWindow extends JFrame{

	private StoreApplication manager;
	private JMenuBar menuBar;
	private JPanel cards;
	private ProductsListPanel productListPanel;
	private CheckInventoryPanel checkInventoryPanel;
	//private LoginPanel loginPanel;
	//private CheckOutScreen checkOutScreen;
	//private MemberListScreen memberListScreen;
	//private ProductListScreen productListScreen;
	//private CategoryListScreen categoryListScreen;
	
	public StoreWindow(StoreApplication manager){
		super("University Store System");
		this.manager = manager;
		
		setJMenuBar(createMenu());
		this.cards = new JPanel(new CardLayout());
		this.productListPanel = new ProductsListPanel(manager);
		this.checkInventoryPanel = new CheckInventoryPanel(manager);
		
		cards.add(createMainPanel(),"mainScreen");
		cards.add(productListPanel,"productList");
		cards.add(checkInventoryPanel,"checkInventory");
		setContentPane(cards);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,500));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	//menuBar
	private JMenuBar createMenu(){
		JMenu menu;
		JMenuItem menuItem;
		menuBar = new JMenuBar();
		//main menu
		menu = new JMenu("Main");
		menu.setMnemonic(KeyEvent.VK_M);
		menuItem = new JMenuItem("Main Screen",KeyEvent.VK_M);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeCard("mainScreen");
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Exit",KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		//product menu
		menu = new JMenu("Product");
		menu.setMnemonic(KeyEvent.VK_P);
		menuItem = new JMenuItem("Product List",KeyEvent.VK_L);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("product list");
				//manager.callProductsListScreen();
				changeCard("productList");
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Add Product",KeyEvent.VK_A);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddProductDialog d = new AddProductDialog(manager);
				d.setVisible(true);
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Check Inventory",KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
		menu.add(menuItem);
		menuBar.add(menu);
		
		return menuBar;
	}
	
	//main screen
	//cardName: mainScreen
	private Container createMainPanel(){
		JPanel mainCard;
		JButton button;
		
		mainCard = new JPanel(new FlowLayout());
		mainCard.setBorder(BorderFactory.createTitledBorder("ProductFactory"));
		
		button = new JButton("Product List");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("product list");
				//manager.callProductsListScreen();
				changeCard("productList");
			}
		});
		mainCard.add(button);
		button = new JButton("Add Product");
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed (ActionEvent e) {
				System.out.println("product window");
				AddProductDialog dialog = new AddProductDialog(manager);
				dialog.setVisible(true);
			}
		});
		mainCard.add(button);
		button = new JButton("Check Inventory");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("check inventory");
				changeCard("checkInventory");
			}
		});
		mainCard.add(button);

		return mainCard;
	}
	
	public void changeCard(String cardName){
		CardLayout cl =  (CardLayout)cards.getLayout();
		cl.show(cards, cardName);
	}
	
	public void exit(){
		//dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
		System.exit(EXIT_ON_CLOSE);
	}

	public JPanel getCards() {
		return cards;
	}

	public ProductsListPanel getProductListPanel() {
		return productListPanel;
	}
	
	
}
