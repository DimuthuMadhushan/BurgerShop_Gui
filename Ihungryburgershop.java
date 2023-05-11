import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class AddCustormer{
	private String custormerId;
	private String custormerName;
	public AddCustormer(){
	}
	public AddCustormer(String custormerId, String custormerName){
	this.custormerId=custormerId;
	this.custormerName=custormerName;
	}
	public boolean equals(String custormerId){
		return custormerId.equals(this.custormerId);
	}
	public String getCustormerName(){
		return custormerName;
	}
}
class Order{
	private String orderId;
	private String custormerId;
	private int quantity; 
	private int status;
	public static final int CANCEL=0;
	public static final int PPREPARING=1;
	public static final int DELIVERED=2;
	 
	public Order(String orderId,String custormerId,int quantity,int status){
		this.orderId=orderId;
		this.custormerId=custormerId;
		this.quantity=quantity;
		this.status=status;
	}
	public String getOrderId(){
		return orderId;
	}
	public String getCustormerId(){
		return custormerId;
	}
	public int getQuantity(){
		return quantity;
	}
	public int getStatus(){
		return status;
	}
	public boolean equals(String orderId){
		return orderId.equals(this.orderId);
	}
	public boolean equalsci(String custormerId){
		return custormerId.equals(this.custormerId);
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public void setStatus(int status){
		this.status=status;
	}
}

class Ihungryburgershop{
	public static AddCustormer[] custormerArray=new AddCustormer[0];
	public static Order [] orderArray=new Order[0];
	public final static double BURGERPRICE=500;
	public static void main(String args []){
		Scanner input=new Scanner(System.in); 
		new HomePage().setVisible(true);
		
		
	}
	public static boolean checkId(String custormerId){
		if(custormerId.length()==10&&custormerId.charAt(0)=='0'){
			String lastDigits=custormerId.substring(1);
			char[] lastDigitsArray=lastDigits.toCharArray();
			for(char ch: lastDigitsArray){
				if(!(ch<=58&&ch>=48)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public static int searchCustormerId(String custormerId){
		for(int i=0;i<custormerArray.length;i++){
			if(custormerArray[i].equals(custormerId)){
				return i;
			}
		}
		return -1;
	}
	public static String generateOrderId(){
		if(orderArray.length==0){
				return "B0001";
		}else{
		String lastOrderId=orderArray[orderArray.length-1].getOrderId();
		String lastDigits=lastOrderId.substring(1);
		int lastOrderIdNumber=Integer.parseInt(lastDigits);
		lastOrderIdNumber++;
		String nextOrderId=String.format("B%04d",lastOrderIdNumber);
		return nextOrderId;
		}
	}
	public static int searchOrderId(String orderId){
		for(int i=0;i<orderArray.length;i++){
			if(orderArray[i].equals(orderId)){
				return i;
			}
		}
		return -1;
	}
}
class HomePage extends JFrame{
	private JButton adCustormer;
	private JButton placeOrder;
	private JButton updateOrder;
	private JButton viewOrder;
	private JButton exit;
	
	private JLabel homePage;
	private JLabel home;
	private JLabel nothing;
	private JLabel none;
	private JLabel ht;
	
	private JPanel buttonPanel;
		
	HomePage(){
		setSize(600,645);
		setTitle("iHungry Burger Shop");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\dimut\\OneDrive\\Desktop\\BurgerShopGUI\\bg.png"));

        add(background);
        
        background.setLayout(new GridLayout(1,2));
        
        home=new JLabel(); 
        background.add(home);
         
        homePage=new JLabel();
        
        homePage.setLayout(new BorderLayout());
        ht =new JLabel("HOME PAGE"); 
        ht.setFont(new Font("Serif",1,40));
        ht.setForeground(Color.yellow);
        homePage.add("North",ht);
        
        buttonPanel=new JPanel();
        buttonPanel.setBackground(new Color(38,35,32));
        buttonPanel.setLayout(new GridLayout(6,1,80,80));
        
        none=new JLabel();
        buttonPanel.add(none);
        adCustormer=new JButton("Add Custormer");
        adCustormer.setFont(new Font("",1,20));
        adCustormer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				AddNewCustormer c=new AddNewCustormer();
				c.setVisible(true);
					
			}
		});
		
        buttonPanel.add(adCustormer);
        
        placeOrder=new JButton("Place Order");
        placeOrder.setFont(new Font("",1,20));
        placeOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new PlaceOrder().setVisible(true);
					
			}
		});
        buttonPanel.add(placeOrder);
        
        updateOrder=new JButton("Update Order");
		updateOrder.setFont(new Font("",1,20));
		
		updateOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new UpdateOrder().setVisible(true);
					
			}
		});
        buttonPanel.add(updateOrder);
        
        viewOrder=new JButton("View Order");
        viewOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new ViewOrder().setVisible(true);
					
			}
		});
        viewOrder.setFont(new Font("",1,20));
        buttonPanel.add(viewOrder);
        
        exit=new JButton("Exit");
		exit.setFont(new Font("",1,20));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("You pressed yes button");
				System.exit(0);
			}
		});
		buttonPanel.add(exit);
        
        
		homePage.add("Center",buttonPanel);
		nothing=new JLabel(); 
        homePage.add("South",nothing);
		
		
        background.add(homePage);
        
      
        
        
	}
}
class AddNewCustormer extends JFrame{
	private JLabel topic;
	private JLabel adId;
	private JLabel id;
	private JLabel text;
	
	private JButton cancelButton;
	 
	private JLabel idLabel; 
	private JLabel nameLabel; 
	
	private JTextField idText;
	private JTextField nameText;
	
	private JLabel oId;
	private JLabel idSide;
	private JLabel textSide;
	private JLabel order;
	private JLabel qty;
	private JLabel value;
	private JLabel none;
	private JLabel btn;
	private JLabel empty;
	private JPanel buttonPanel;
	
	private JButton placeOrderButton;
	private JButton backButton;
	
	private JTextField qtyText;
	private JTextField valueText;
	private int quantity;
	private int status;
	private String custormerId;
	private String custormerName;
	private double price;
	private String sPrice;
	AddNewCustormer(){
		setSize(600,645);
		setTitle("Add New Custormer");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,1));
		
		topic=new JLabel("ADD NEW CUSTORMER");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add(topic);
        
        adId=new JLabel();
        
        adId.setLayout(new GridLayout(1,2));
        
        id=new JLabel();
        id.setLayout(new GridLayout(2,1,10,10));
        
        idLabel=new JLabel("Custormer ID");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setFont(new Font("",1,20));
        idLabel.setForeground(Color.white);
        id.add(idLabel);
        
        nameLabel=new JLabel("Custormer Name ");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("",1,20));
        nameLabel.setForeground(Color.white);
        id.add(nameLabel);
        
        adId.add(id);
        
        text=new JLabel();
        text.setLayout(new GridLayout(2,1,80,80));
        
        idText=new JTextField(10);
        idText.setLayout(new GridLayout());
        idText.setFont(new Font("",1,20)); 
        
        idText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				custormerId=idText.getText();
				if(!(Ihungryburgershop.checkId(custormerId))){
					new InvalidNumber().setVisible(true);
				}else{
					if(Ihungryburgershop.searchCustormerId(custormerId)!=-1){
						new AllreadyExist().setVisible(true);
					}
					
				}
			}
		}); 
        text.add(idText);
        
        nameText=new JTextField(10);
        nameText.setLayout(new FlowLayout());
        nameText.setFont(new Font("",1,20));
        nameText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				custormerName=nameText.getText();	
			
			}
		}); 
        text.add(nameText);
        
        
        adId.add(text); 
        add(adId);
        
        oId=new JLabel();
        oId.setLayout(new GridLayout(1,2));
        
        idSide=new JLabel();
        
        
        idSide.setLayout(new GridLayout(3,1));
		String nextOrderId= Ihungryburgershop.generateOrderId();
        order=new JLabel("Order Id "+nextOrderId);
        order.setHorizontalAlignment(JLabel.LEFT);
        order.setFont(new Font("",1,30));
        order.setForeground(Color.yellow);
        idSide.add(order);
        
        qty=new JLabel("Burger Quantity");
        qty.setHorizontalAlignment(JLabel.CENTER);
        qty.setFont(new Font("",1,20));
        qty.setForeground(Color.white);
        idSide.add(qty);
        
        value=new JLabel("Bill Value");
        value.setHorizontalAlignment(JLabel.CENTER);
        value.setFont(new Font("",1,20));
        value.setForeground(Color.white);
        idSide.add(value);
        
        oId.add(idSide);
        
        textSide=new JLabel();
        textSide.setLayout(new GridLayout(3,1,20,20));
        
        none=new JLabel();
        textSide.add(none);
        qtyText=new JTextField(10);
        qtyText.setLayout(new FlowLayout());
        qtyText.setFont(new Font("",1,20));
        qtyText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String sqty=qtyText.getText();	
				quantity=Integer.parseInt(sqty);
				 price=(double)quantity*Ihungryburgershop.BURGERPRICE;
				String sPrice=String.valueOf(price);
				valueText.setText(sPrice);
			}
		}); 
        textSide.add(qtyText);
       
        valueText=new JTextField(10);
        valueText.setLayout(new FlowLayout());
        valueText.setFont(new Font("",1,20));
        valueText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			valueText.setText(sPrice);
			}
		});  
        textSide.add(valueText);
        oId.add(textSide);
         
        add(oId);
        
        btn=new JLabel();
        btn.setLayout(new GridLayout(1,2));
        
        empty=new JLabel();
        btn.add(empty);
        
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new java.awt.Color(38,35,32));
        
        placeOrderButton=new JButton("Place Order");
        placeOrderButton.setFont(new Font("",1,20));
        placeOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddCustormer[] temp=new AddCustormer[Ihungryburgershop.custormerArray.length+1];
					for(int i=0;i<Ihungryburgershop.custormerArray.length;i++){
						temp[i]=Ihungryburgershop.custormerArray[i];
					}
					Ihungryburgershop.custormerArray=temp;
					AddCustormer addcustormer=new AddCustormer(custormerId,custormerName);
					Ihungryburgershop.custormerArray[Ihungryburgershop.custormerArray.length-1]=addcustormer;
					
					Order[] temp2=new Order[Ihungryburgershop.orderArray.length+1];
							for(int j=0;j<Ihungryburgershop.orderArray.length;j++){
							temp2[j]=Ihungryburgershop.orderArray[j];
						}
						Ihungryburgershop.orderArray=temp2;
						Order order=new Order(nextOrderId,custormerId,quantity,0);
						Ihungryburgershop.orderArray[Ihungryburgershop.orderArray.length-1]=order;
						new SuccessfullyAdded().setVisible(true);
						return;
			}
		});  
        buttonPanel.add(placeOrderButton);
        
        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,20));
         cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			setVisible(false);
			new HomePage().setVisible(true);
			}
		}); 
        buttonPanel.add(cancelButton);
        
        backButton=new JButton("Back To Home");
        backButton.setFont(new Font("",1,20));
       backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
        buttonPanel.add(backButton);
        
        btn.add(buttonPanel);
        
        add(btn); 
        
        
		
		
	}
}
class InvalidNumber extends JFrame{
	private JLabel invalid;
	private JButton okButton;
		InvalidNumber(){
			setSize(200,100);
			setTitle("Error");	
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			invalid=new JLabel("Invalid Custormer Id...");
			add("North",invalid);
			
			okButton=new JButton("ok");
			okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			}
		});
			add("South",okButton);
		}
}
class SuccessfullyAdded extends JFrame{
	private JLabel invalid;
	private JButton okButton;
		SuccessfullyAdded(){
			setSize(200,100);
			setTitle("Error");	
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			invalid=new JLabel("Succesfully added custormer...");
			add("North",invalid);
			
			okButton=new JButton("ok");
			okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new AddNewCustormer().setVisible(false);
				new HomePage().setVisible(true);
			}
		});
			add("South",okButton);
		}
}
class SuccessfullyUpdated extends JFrame{
	private JLabel invalid;
	private JButton okButton;
		SuccessfullyUpdated(){
			setSize(200,100);
			setTitle("Error");	
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			invalid=new JLabel("Succesfully Updated...");
			add("North",invalid);
			
			okButton=new JButton("ok");
			okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				new UpdateOrder().setVisible(false);
				new HomePage().setVisible(true);
			}
		});
			add("South",okButton);
		}
}
class AllreadyExist extends JFrame{
	private JLabel invalid;
	private JButton okButton;
		AllreadyExist(){
			setSize(200,100);
			setTitle("Error");	
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			invalid=new JLabel("Custormer Id Already Exist...");
			add("North",invalid);
			
			okButton=new JButton("ok");
			okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			}
		});
			add("South",okButton);
		}
}
class NotExist extends JFrame{
	private JLabel invalid;
	private JButton okButton;
		NotExist(){
			setSize(200,100);
			setTitle("Error");	
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			
			invalid=new JLabel("Custormer Id Not Exist...");
			add("North",invalid);
			
			okButton=new JButton("ok");
			okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			}
		});
			add("South",okButton);
		}
}
class PlaceOrder extends JFrame{
	private JLabel topic;
	private JLabel adId;
	private JLabel id;
	private JLabel text;
	
	private JButton cancelButton;
	 
	private JLabel idLabel; 
	private JLabel nameLabel; 
	
	private JTextField idText;
	private JTextField nameText;

	private JLabel order;
	private JLabel qty;
	private JLabel value;
	private JLabel none;
	private JLabel btn;
	private JLabel empty;
	private JPanel buttonPanel;
	
	private JButton placeOrderButton;
	private JButton backButton;
	
	private JTextField qtyText;
	private JTextField valueText;
	
	
	private int quantity;
	private int status;
	private String custormerId;
	private String custormerName;
	private double price;
	private String sPrice;
	
	PlaceOrder(){
		setSize(600,645);
		setTitle("Place Order");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		
		topic=new JLabel("PLACE ORDER");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add(topic);
        
        adId=new JLabel();
        
        adId.setLayout(new GridLayout(1,2));
        
        id=new JLabel();
        id.setLayout(new GridLayout(5,1));
        String nextOrderId= Ihungryburgershop.generateOrderId();
        order=new JLabel("Order Id-"+nextOrderId);
        order.setHorizontalAlignment(JLabel.LEFT);
        order.setFont(new Font("",1,30));
        order.setForeground(Color.yellow);
        id.add(order);
       
        idLabel=new JLabel("Custormer ID");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setFont(new Font("",1,20));
        idLabel.setForeground(Color.white);
        id.add(idLabel);
        
        nameLabel=new JLabel("Custormer Name ");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("",1,20));
        nameLabel.setForeground(Color.white);
        id.add(nameLabel);
        
        qty=new JLabel("Burger Quantity");
        qty.setHorizontalAlignment(JLabel.CENTER);
        qty.setFont(new Font("",1,20));
        qty.setForeground(Color.white);
        id.add(qty);
        
        value=new JLabel("Bill Value");
        value.setHorizontalAlignment(JLabel.CENTER);
        value.setFont(new Font("",1,20));
        value.setForeground(Color.white);
        id.add(value);
        
         adId.add(id);
        
        text=new JLabel();
        text.setLayout(new GridLayout(5,1,10,10));
        
        none=new JLabel();
        text.add(none);
        
        idText=new JTextField(10);
        idText.setLayout(new FlowLayout());
        idText.setFont(new Font("",1,20)); 
        idText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String custormerId=idText.getText();
				if(!(Ihungryburgershop.checkId(custormerId))){
					new InvalidNumber().setVisible(true);
				}else{
					if(Ihungryburgershop.searchCustormerId(custormerId)==-1){
						new NotExist().setVisible(true);
					}
				}
			}
		});
        text.add(idText);
        
        nameText=new JTextField(10);
        nameText.setLayout(new FlowLayout());
        nameText.setFont(new Font("",1,20)); 
         nameText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String custormerName=nameText.getText();	
			
			}
		}); 
        text.add(nameText);
        
        qtyText=new JTextField(10);
        qtyText.setLayout(new FlowLayout());
        qtyText.setFont(new Font("",1,20));
        qtyText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String sqty=qtyText.getText();	
				int quantity=Integer.parseInt(sqty);
				 double price=(double)quantity*Ihungryburgershop.BURGERPRICE;
				String sPrice=String.valueOf(price);
				valueText.setText(sPrice);
			}
		}); 
        text.add(qtyText);
        
        valueText=new JTextField(10);
        valueText.setLayout(new FlowLayout());
        valueText.setFont(new Font("",1,20)); 
        text.add(valueText);
         
        adId.add(text);
        
        add(adId);
        
         btn=new JLabel();
        btn.setLayout(new GridLayout(1,2));
        
        empty=new JLabel();
        btn.add(empty);
        
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new java.awt.Color(38,35,32));
        
        placeOrderButton=new JButton("Place Order");
        placeOrderButton.setFont(new Font("",1,20)); 
        placeOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){	
					Order[] temp2=new Order[Ihungryburgershop.orderArray.length+1];
							for(int j=0;j<Ihungryburgershop.orderArray.length;j++){
							temp2[j]=Ihungryburgershop.orderArray[j];
						}
						Ihungryburgershop.orderArray=temp2;
						Order order=new Order(nextOrderId,custormerId,quantity,0);
						Ihungryburgershop.orderArray[Ihungryburgershop.orderArray.length-1]=order;
						new SuccessfullyAdded().setVisible(true);
			}
		});
        buttonPanel.add(placeOrderButton);
        
        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,20)); 
        cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			setVisible(false);
			new HomePage().setVisible(true);
			}
		}); 
        buttonPanel.add(cancelButton);
        
        backButton=new JButton("Back To Home");
        backButton.setFont(new Font("",1,20));
        
        backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
			
        buttonPanel.add(backButton);
        
        btn.add(buttonPanel);
        
        add(btn);
	}
}
class UpdateOrder extends JFrame{
	private JLabel topic;
	private JLabel adId;
	private JLabel id;
	private JLabel text;
	
	private JButton cancelButton;
	 
	private JLabel idLabel; 
	private JLabel nameLabel; 
	
	private JTextField idText;
	private JTextField nameText;

	private JLabel order;
	private JLabel qty;
	private JLabel value;
	private JLabel none;
	private JLabel btn;
	private JLabel empty;
	private JLabel status;
	private JPanel buttonPanel;
	
	private JButton placeOrderButton;
	private JButton backButton;
	
	private JTextField qtyText;
	private JTextField valueText;
	
	private JComboBox statusComboBox;
	private JComboBox orderIdComboBox;
	
	UpdateOrder(){
		setSize(600,645);
		setTitle("Update Order");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		
		topic=new JLabel("UPDATE ORDER");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add(topic);
        
        adId=new JLabel();
        
        adId.setLayout(new GridLayout(1,2));
        
        id=new JLabel();
        id.setLayout(new GridLayout(6,1));
        
        order=new JLabel("Order Id");
        order.setHorizontalAlignment(JLabel.CENTER);
        order.setFont(new Font("",1,20));
        order.setForeground(Color.white);
        id.add(order);
        
        idLabel=new JLabel("Custormer ID");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setFont(new Font("",1,20));
        idLabel.setForeground(Color.white);
        id.add(idLabel);
        
        nameLabel=new JLabel("Custormer Name ");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("",1,20));
        nameLabel.setForeground(Color.white);
        id.add(nameLabel);
        
        qty=new JLabel("Burger Quantity");
        qty.setHorizontalAlignment(JLabel.CENTER);
        qty.setFont(new Font("",1,20));
        qty.setForeground(Color.white);
        id.add(qty);
        
        value=new JLabel("Bill Value");
        value.setHorizontalAlignment(JLabel.CENTER);
        value.setFont(new Font("",1,20));
        value.setForeground(Color.white);
        id.add(value);
        
        status=new JLabel("Order Status");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(new Font("",1,20));
        status.setForeground(Color.white);
        id.add(status);
        
         adId.add(id);
        
        text=new JLabel();
        text.setLayout(new GridLayout(6,1,10,10));
        
        String nextOrderId= Ihungryburgershop.generateOrderId();
        orderIdComboBox=new JComboBox();
        
        for (int i = 0; i < Ihungryburgershop.orderArray.length; i++)
		{
			orderIdComboBox.addItem(Ihungryburgershop.orderArray[i].getOrderId());
		}
		orderIdComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String orderId=(String)orderIdComboBox.getSelectedItem();
				if(Ihungryburgershop.searchOrderId(orderId)!=-1){
					int j=Ihungryburgershop.searchOrderId(orderId);
					idText.setText(Ihungryburgershop.orderArray[j].getCustormerId());
					int k=Ihungryburgershop.searchCustormerId(Ihungryburgershop.orderArray[j].getCustormerId());
					nameText.setText(Ihungryburgershop.custormerArray[k].getCustormerName());
					int quantity=Ihungryburgershop.orderArray[j].getQuantity();
					String s=Integer.toString(quantity);
					qtyText.setText(s);
					double price=(double)quantity*Ihungryburgershop.BURGERPRICE;
					String sPrice=String.valueOf(price);
					valueText.setText(sPrice);
				}
				
			}
		});
        
        text.add(orderIdComboBox);
        
        idText=new JTextField(10);
        idText.setLayout(new FlowLayout());
        idText.setFont(new Font("",1,20)); 
        text.add(idText);
        
        nameText=new JTextField(10);
        nameText.setLayout(new FlowLayout());
        nameText.setFont(new Font("",1,20)); 
        text.add(nameText);
        
        qtyText=new JTextField(10);
        qtyText.setLayout(new FlowLayout());
        qtyText.setFont(new Font("",1,20)); 
        text.add(qtyText);
        
        valueText=new JTextField(10);
        valueText.setLayout(new FlowLayout());
        valueText.setFont(new Font("",1,20)); 
        text.add(valueText);
        
        statusComboBox=new JComboBox();
		statusComboBox.addItem("Preparing");
		statusComboBox.addItem("Delivered");
		statusComboBox.addItem("Cancelled");
		statusComboBox.setFont(new Font("",1,15)); 
		
		text.add(statusComboBox);
         
        adId.add(text);
        
        add(adId);
        
         btn=new JLabel();
        btn.setLayout(new GridLayout(1,2));
        
        empty=new JLabel();
        btn.add(empty);
        
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new java.awt.Color(38,35,32));
        
        placeOrderButton=new JButton("Update Order");
        placeOrderButton.setFont(new Font("",1,20));
        placeOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String status=(String)statusComboBox.getSelectedItem();
				String orderId=(String)orderIdComboBox.getSelectedItem();
				int j=Ihungryburgershop.searchOrderId(orderId);
				if(status.equals("Preparing")){
					Ihungryburgershop.orderArray[j].setStatus(1);
				}else if(status.equals("Delivered")){
					Ihungryburgershop.orderArray[j].setStatus(2);
				}else{
					Ihungryburgershop.orderArray[j].setStatus(0);
				}
				new SuccessfullyUpdated().setVisible(true);
			}
		}); 
        buttonPanel.add(placeOrderButton);
        
        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,20));
        cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			setVisible(false);
			new HomePage().setVisible(true);
			}
		}); 
        buttonPanel.add(cancelButton);
        
        backButton=new JButton("Back To Home");
        backButton.setFont(new Font("",1,20));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
        buttonPanel.add(backButton);
        
        btn.add(buttonPanel);
        
        add(btn);
	}
}
class ViewOrder extends JFrame{
	private JLabel topic;
	private JPanel buttonPanel;
	
	private JLabel none;
	private JLabel cancel;
	private JButton viewAllOrder;
	private JButton viewCustormer;
	private JButton viewOrder;
	private JButton cancelButton;
	ViewOrder(){
		setSize(600,645);
		setTitle("View Order");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		topic=new JLabel("VIEW ORDER");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add("North",topic);
        
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(5,1,80,80));
        buttonPanel.setBackground(new java.awt.Color(38,35,32));
        
        none=new JLabel();
        buttonPanel.add(none);
        
        viewAllOrder=new JButton("View All Orders");
        viewAllOrder.setFont(new Font("",1,20));
        viewAllOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new ViewAllOrder().setVisible(true);
			}
		});
        viewAllOrder.setPreferredSize(new Dimension(40, 40));
        buttonPanel.add(viewAllOrder);
        
        viewCustormer=new JButton("View All Custormers");
        viewCustormer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new ViewAllCustormer().setVisible(true);
			}
		});
        viewCustormer.setFont(new Font("",1,20));
        buttonPanel.add(viewCustormer);
        
        viewOrder=new JButton("View Order");
        viewOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new ViewOrderDetail().setVisible(true);
			}
		});
        viewOrder.setFont(new Font("",1,20));
        buttonPanel.add(viewOrder);
        
        none=new JLabel();
        buttonPanel.add(none);
        
        add("Center",buttonPanel);
        
        none=new JLabel("                                 ");
        add("West",none);
        
        none=new JLabel("                                 ");
        add("East",none);
       
        
        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,20));
        add("South",cancelButton);
        
        
	}
}
class ViewAllCustormer extends JFrame{
	
	private JLabel topic;
	private JPanel buttonPanel;
	private JLabel custIdLabel;
	private JLabel cuxtNameLabel;
	private JLabel totalValueLabel;
	
	private JLabel none;
	private JLabel cancel;
	private JTable orderTable;
	private DefaultTableModel dtm;
	private JButton cancelButton;
	ViewAllCustormer(){
		setSize(600,645);
		setTitle("View All Custormers");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		topic=new JLabel("VIEW ALL CUSTORMERS");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add("North",topic);
        
        String[] columnName={"CustId", "CustName","Total Value"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		orderTable=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(orderTable);
		add("Center",tablePane);
        
        
        none=new JLabel("                                 ");
        add("West",none);
        
        none=new JLabel("                                 ");
        add("East",none);
       
        
        cancelButton=new JButton("Back To Home");
        cancelButton.setFont(new Font("",1,20));
        cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
        add("South",cancelButton);
		}
}
class ViewAllOrder extends JFrame{
	
	private JLabel topic;
	private JPanel buttonPanel;
	private JLabel custIdLabel;
	private JLabel orderIdLabel;
	private JLabel qtyLabel;
	private JLabel statusLabel;
	
	private JLabel none;
	private JLabel cancel;
	private JTable orderTable;
	private DefaultTableModel dtm;
	private JButton cancelButton;
	ViewAllOrder(){
		setSize(600,645);
		setTitle("View All Orders");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		topic=new JLabel("VIEW ALL ORDERS");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add("North",topic);
        
        String[] columnName={"OrderId", "CustId","Qty","Status"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		orderTable=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(orderTable);
		add("Center",tablePane);
        
        
        none=new JLabel("                                 ");
        add("West",none);
        
        none=new JLabel("                                 ");
        add("East",none);
       
        
        cancelButton=new JButton("Back To Home");
        cancelButton.setFont(new Font("",1,20));
        cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
        add("South",cancelButton);
		}
}
class ViewOrderDetail extends JFrame{
	private JLabel topic;
	private JLabel adId;
	private JLabel id;
	private JLabel text;
	private JLabel status;
	
	private JButton cancelButton;
	 
	private JLabel idLabel; 
	private JLabel nameLabel; 
	private JLabel statusText;
	
	private JLabel idText;
	private JLabel nameText;

	private JLabel order;
	private JLabel qty;
	private JLabel value;
	private JLabel none;
	private JLabel lrow;
	
	private JButton placeOrderButton;
	private JButton backButton;
	
	private JLabel qtyText;
	private JLabel valueText;
	private JComboBox orderIdComboBox;
	
	ViewOrderDetail(){
		setSize(600,645);
		setTitle("View Order Detail");	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1,50,50));
		
		topic=new JLabel("VIEW ORDER DETAIL");
		topic.setHorizontalAlignment(JLabel.CENTER);
        topic.setFont(new Font("Serif",1,40));
        topic.setForeground(Color.yellow);
        getContentPane().setBackground(new java.awt.Color(38,35,32));
        add(topic);
        
        adId=new JLabel();
        
        adId.setLayout(new GridLayout(1,2));
        
        id=new JLabel();
        id.setLayout(new GridLayout(6,1));
        order=new JLabel("Order Id");
        order.setHorizontalAlignment(JLabel.LEFT);
        order.setFont(new Font("",1,30));
        order.setForeground(Color.yellow);
        id.add(order);
       
        idLabel=new JLabel("Custormer ID");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setFont(new Font("",1,20));
        idLabel.setForeground(Color.white);
        id.add(idLabel);
        
        nameLabel=new JLabel("Custormer Name ");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("",1,20));
        nameLabel.setForeground(Color.white);
        id.add(nameLabel);
        
        qty=new JLabel("Burger Quantity");
        qty.setHorizontalAlignment(JLabel.CENTER);
        qty.setFont(new Font("",1,20));
        qty.setForeground(Color.white);
        id.add(qty);
        
        value=new JLabel("Bill Value");
        value.setHorizontalAlignment(JLabel.CENTER);
        value.setFont(new Font("",1,20));
        value.setForeground(Color.white);
        id.add(value);
        
        status=new JLabel("Status");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(new Font("",1,20));
        status.setForeground(Color.white);
        id.add(status);
        
         adId.add(id);
        
        text=new JLabel();
        text.setLayout(new GridLayout(6,1,10,10));
        
        orderIdComboBox=new JComboBox();
        orderIdComboBox.addItem("B0001");
        text.add(orderIdComboBox);
        
        idText=new JLabel("adc");
        idText.setFont(new Font("",1,20));
        idText.setForeground(Color.white); 
        text.add(idText);
        
        nameText=new JLabel("vugj");
        nameText.setFont(new Font("",1,20));
        nameText.setForeground(Color.white); 
        text.add(nameText);
        
        qtyText=new JLabel("biihih");
        qtyText.setFont(new Font("",1,20));
        qtyText.setForeground(Color.white); 
        text.add(qtyText);
        
        valueText=new JLabel("nnk");
        valueText.setFont(new Font("",1,20));
        valueText.setForeground(Color.white); 
        text.add(valueText);
         
        statusText=new JLabel("nnk");
        statusText.setFont(new Font("",1,20)); 
        statusText.setForeground(Color.white);
        text.add(statusText);
        
        adId.add(text);
        
        add(adId);
        
        lrow=new JLabel();
        lrow.setLayout(new GridLayout(2,1,50,50));
        
        none=new JLabel();
        lrow.add(none);
        
        backButton=new JButton("Back To Home");
        backButton.setFont(new Font("",1,20));
        
        backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
			new HomePage().setVisible(true);
			}
		});
			
        lrow.add(backButton);
        
        add(lrow);
 
        
       
	}
}

