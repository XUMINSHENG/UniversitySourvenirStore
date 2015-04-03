package sg.edu.nus.iss.usstore.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.KeyStore;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StoreApplication manager;
	private JMenuBar menuBar;
	private JPanel cards;
	private ProductsListPanel productListPanel;
	private CheckInventoryPanel checkInventoryPanel;
	//private LoginPanel loginPanel;
	private CheckOutPanel checkOutPanel;
	private MemberListPanel memberListPanel;
	//private ProductListPanel productListPanel;
	private CategoryListPanel categoryListPanel;
	private final Dimension size = new Dimension(150, 100);
	private final Dimension space = new Dimension(20, 0);
	
	//private ReportPanel reportPanel;
	
	public StoreWindow(StoreApplication manager){
		super("University Store System");
		this.manager = manager;
		
		setJMenuBar(createMenu());
		this.cards = new JPanel(new CardLayout());
		this.checkOutPanel = new CheckOutPanel(manager);
		this.productListPanel = new ProductsListPanel(manager);
		this.checkInventoryPanel = new CheckInventoryPanel(manager);
		this.categoryListPanel = new CategoryListPanel(manager);
		this.memberListPanel = new MemberListPanel(manager);
		
		
		//register cards with cardName
		cards.add(createMainPanel(),"mainScreen");
		cards.add(checkOutPanel,"checkOut");
		cards.add(productListPanel,"productList");
		cards.add(checkInventoryPanel,"checkInventory");
		cards.add(categoryListPanel,"categoryList");
		cards.add(memberListPanel,"memberList");
		setContentPane(cards);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(windorListener);
		
		setPreferredSize(new Dimension(800,600));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private WindowListener windorListener = new WindowAdapter (){
		public void windowClosing (WindowEvent e) {
			exit();
        }
	};
	private JMenuItem menuItem_1;
	
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
		
		//member menu
		menu = new JMenu("Member");
		menuItem = new JMenuItem("Member List",KeyEvent.VK_M);
		menu.add(menuItem);
		menuBar.add(menu);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				changeCard("memberList");
				
			}
		});
		
		//product menu
		menu = new JMenu("Product");
		//menu.setMnemonic(KeyEvent.VK_P);
		menuItem = new JMenuItem("Product List",KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
				ProductDialog d = new ProductDialog(manager,"Add Product");
				d.setVisible(true);
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Check Inventory",KeyEvent.VK_C);
		//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				changeCard("checkInventory");
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		
		//Category menu
		menu = new JMenu("Category");
		//menu.setMnemonic(KeyEvent.VK_C);
		menuItem = new JMenuItem("Category List",KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				changeCard("categoryList");
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Add Category",KeyEvent.VK_A);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("add category");
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		
		menu = new JMenu("Discount");
		menuItem_1 = new JMenuItem("Discount List",KeyEvent.VK_D);
		menuItem_1.setSelected(true);
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.ALT_MASK));
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Discount List");
			}
		});
		menu.add(menuItem_1);
		menuItem = new JMenuItem("Add Discount",KeyEvent.VK_A);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Add Discount");
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		
		return menuBar;
	}
	
	//main screen
	//cardName: mainScreen
	private Container createMainPanel(){
		JPanel mainCard;
		
		mainCard = new JPanel();
		//mainCard.setLayout(new BoxLayout(mainCard, BoxLayout.X_AXIS));
		GridBagLayout layout = new GridBagLayout();
		mainCard.setLayout(layout);
		
		JPanel transaction = createTransactionFactory();
		JPanel member = createMemberFactory();
		JPanel discount = createDiscountFactory();
		JPanel category = createCategoryFactory();
		JPanel product = createProductFactory();
		JPanel report = createReportFactory();
		mainCard.add(transaction);
		mainCard.add(category);
		mainCard.add(member);
		mainCard.add(discount);
		mainCard.add(product);
		mainCard.add(report);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridwidth = 1;
		layout.setConstraints(transaction, c);
		c.gridwidth = 0;
		layout.setConstraints(category, c);
		c.gridwidth = 1;
		layout.setConstraints(member, c);
		c.gridwidth = 0;
		layout.setConstraints(discount, c);
		c.gridwidth = 0;
		layout.setConstraints(product, c);
		c.gridwidth = 0;
		layout.setConstraints(report, c);

		//JScrollPane m = new JScrollPane(mainCard);
		
		return mainCard;
	}
	
	private JPanel createTransactionFactory(){
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("TransactionFactory"));
		ImageIcon icon = new ImageIcon("images\\checkout.png");
		JButton button = new JButton("Check Out",icon);
		button.setFocusPainted(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setIconTextGap(2);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("checkout");
				checkOutPanel.setTransaction(manager.checkOut());
				changeCard("checkOut");
				
			}
		});
		p.add(button);
		return p;
	
	}

	private JPanel createProductFactory(){
		//GridLayout layout = new GridLayout(1,3,50,10);
		JPanel p = new JPanel(new FlowLayout());
		p.setBorder(BorderFactory.createTitledBorder("ProductFactory"));
		
		ImageIcon icon = new ImageIcon("images\\product.png");
		JButton button = new JButton("Product List",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeCard("productList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\addProduct.png");
		button = new JButton("Add Product",icon);
		button.setIconTextGap(2);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed (ActionEvent e) {
				ProductDialog dialog = new ProductDialog(manager,"Add Product");
				dialog.setVisible(true);
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\checkInventory.png");
		button = new JButton("Stocktaking",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				changeCard("checkInventory");
			}
		});
		p.add(button);
		
		return p;
	}
	
	
	private JPanel createMemberFactory(){
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("MemberFactory"));
		ImageIcon icon = new ImageIcon("images\\member.png");
		JButton button = new JButton("Member List",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("member list");
				changeCard("memberList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\addMember.png");
		button = new JButton("Add Member",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDialog memDialog = new MemberDialog(manager, "Add Member");
				memDialog.setVisible(true);
				System.out.println("add member");
				//changeCard("memberList");
			}
		});
		p.add(button);
		return p;
	}
	
	private JPanel createDiscountFactory(){
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("DiscountFactory"));
		ImageIcon icon = new ImageIcon("images\\discount.png");
		JButton button = new JButton("Discount List",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("discount list");
				//changeCard("discountList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\addDiscount.png");
		button = new JButton("Add Discount",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("add discount");
				//changeCard("discountList");
			}
		});
		p.add(button);
		return p;
	
	}
	
	
	private JPanel createCategoryFactory(){
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("CategoryFactory"));
		ImageIcon icon = new ImageIcon("images\\category.png");
		JButton button = new JButton("Category List",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeCard("categoryList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\addCategory.png");
		button = new JButton("Add Category",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("add category");
				//changeCard("memberList");
			}
		});
		p.add(button);
		return p;
	
	}
	
	private JPanel createReportFactory(){
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("ReportFactory"));
		ImageIcon icon = new ImageIcon("images\\categoryReport.png");
		JButton button = new JButton("Category Report",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Category Report");
				CategoryReport catReport = new CategoryReport(manager);
				catReport.show(true);
				catReport.setVisible(true);
				//changeCard("discountList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\productReport.png");
		button = new JButton("Product Report",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Product Report");
				ProductReport prodReport = new ProductReport(manager);
				prodReport.show(true);
				prodReport.setVisible(true);
				//changeCard("discountList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\transactionReport.png");
		button = new JButton("Transaction Report",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Report list");
				TransactionReport transactionReport = new TransactionReport(manager);
				transactionReport.show(true);
				transactionReport.setVisible(true);
				//changeCard("discountList");
			}
		});
		p.add(button);
		p.add(Box.createRigidArea(space));
		icon = new ImageIcon("images\\memberReport.png");
		button = new JButton("Member Report",icon);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Report list");
				MemberReport memReport = new MemberReport(manager);
				memReport.show(true);
				memReport.setVisible(true);
				//changeCard("discountList");
			}
		});
		p.add(button);
		return p;
	
	}
	
	public void changeCard(String cardName){
		CardLayout cl =  (CardLayout)cards.getLayout();
		cl.show(cards, cardName);
	}
	
	public void exit(){
		//dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
		//System.exit(EXIT_ON_CLOSE);
		manager.shutdown();
		
	}

	public JPanel getCards() {
		return cards;
	}

	public ProductsListPanel getProductListPanel() {
		return productListPanel;
	}
	
	public MemberListPanel getMemberPanel(){
		return memberListPanel;
	}
	
	
}
