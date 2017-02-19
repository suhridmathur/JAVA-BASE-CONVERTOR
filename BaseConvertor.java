import java.awt.*;
import java.awt.event.*;

public class BaseConvertor extends Frame implements ActionListener,ItemListener
{
	Label baseConvertor,base1,base2,enterNumber,dev;
	Font baseConvertorFont,baseFont,dev1;
	Choice c1,c2;
	int i;
	TextField query,answer;
	String query1,answer1;
	Button convert,exit;
	
	int input,output=0,baseInput=0,baseOutput=0,base10=0;

	public BaseConvertor()
	{
		
		super("Base Conversion");
		setLayout(null);

		exit=new Button("E  X  I  T");
		exit.setBounds(190,420,150,50);
		
		this.setBackground(Color.GRAY);
		
		baseConvertorFont=new Font("Lucida Sans",Font.BOLD,24);
		baseFont = new Font("Lucida Sans",Font.BOLD,15);	
		
		dev=new Label("DEVELOPED BY SUHRID MATHUR");
		dev.setBounds(270,460,220,50);
		dev.setFont(dev1);

		dev1=new Font("Tahoma",Font.ITALIC,3);

		baseConvertor=new Label("Base Convertor");
		baseConvertor.setBounds(150,50,200,70);
		baseConvertor.setFont(baseConvertorFont);

		base1=new Label("Select  Base :");
		base2=new Label("Select  Base :");

		enterNumber=new Label("Input Number :");
		enterNumber.setBounds(40,180,130,50);
		enterNumber.setFont(baseFont);
		
		base1.setBounds(40,120,100,50);
		base1.setFont(baseFont);	

		base2.setBounds(40,280,100,50);
		base2.setFont(baseFont);	

		c1=new Choice(); c1.addItem("Select:");
		c2=new Choice(); c2.addItem("Select:");
		

		for(i=2;i<=20;i++)
		{
			c1.addItem(""+i);
			c2.addItem(""+i);
		}

		c1.setBounds(190,135,100,50);
		c2.setBounds(190,295,100,50);
		c1.addItemListener(this);
		c2.addItemListener(this);

		query=new TextField(10);
		query.setBounds(190,193,120,23);

		answer=new TextField(10);
		answer.setBounds(190,350,120,23);
		answer.setEditable(false);

		
		
		convert=new Button("CONVERT");
		convert.setBounds(190,230,100,50);
		convert.addActionListener(this);
		exit.addActionListener(this);

		add(query);
		add(baseConvertor);
		add(base1);
		add(enterNumber);
		add(base2);	
		add(c1);
		add(c2);
		add(answer);
		add(exit);
		add(convert);		
		add(dev);

		/* addWindowListener(new WindowAdapter()
		{
  			public void windowClosing(WindowEvent we)
  			{
  				System.exit(0);
  			}
 		});*/

		this.setLocation(350,150);
		this.setResizable(false);
		setSize(500,500);
		setVisible(true);	
	}	

	public void actionPerformed(ActionEvent ae)
	{
	
		if(ae.getSource()==exit)
		{
			this.dispose();
		}
		
		else
		{
	
			if(baseInput==0 || baseOutput==0 || c1.getSelectedItem()=="Select:" ||c2.getSelectedItem()=="Select:")
			{	
				answer.setText("Invalid Input");
			}
			
			else
			{	

				query1=query.getText();
				boolean flag=true;
				
				if(baseInput>10)
				{
					for(i=0;i<query1.length();i++)
					{
						int ascii = (int) query1.charAt(i);
						if(ascii<48 || ((ascii-48)>=baseInput && ascii <57 ) || ascii > 65+(baseInput-10))
						{
							answer.setText("Invalid Input");
							flag=false;
							break;
						}
		
												
						

					}
				}
				
				else
				{				
					for(i=0;i<query1.length();i++)
					{
						int ascii = (int) query1.charAt(i);
						if(ascii<48 || ascii >57 || ((ascii-48)>=baseInput))
						{
						answer.setText("Invalid Input");	
							flag=false;
							break;
						}
					}
				}
		
				if(flag)
				{
					//System.out.println(query1);	

					answer.setText(" ");
					//input=Integer.parseInt(query.getText());
					//System.out.println("Number="+input);
					int x=0;
					int l;
					if(baseInput>10)
					{
						for(i=query1.length()-1;i>=0;i--)
						{
							int ascii=(int)query1.charAt(i);
							if(ascii>64)
							{
								l=ascii-55;
							}
							else
							{
								l=(ascii-48);
							}
							base10+=l*Math.pow(baseInput,x);
							x++;
						}
					}

					else
					{
						for(i=query1.length()-1;i>=0;i--)
						{
							int ascii=(int)query1.charAt(i);
							l=(ascii-48);
							base10+=l*Math.pow(baseInput,x);
							x++;
						}
					}
				
					//System.out.println(base10);
					answer1="";
					
					while(base10!=0)
					{
						int remainder=base10%baseOutput;
						if(remainder>9)
						{
							int n=remainder-9+64;
							char m=(char)n;
							answer1=""+m+answer1;
						}

						else
						{
							answer1=""+remainder+answer1;
						}

						base10=base10/baseOutput;
								
					}
				
					answer.setText(answer1);
					base10=0;
					answer1="";
					
					
					
				}

			}	
		}
		
	}

	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==c1)
		{
			baseInput=Integer.parseInt(c1.getSelectedItem());
		//	System.out.println("base Input = "+baseInput);
		}
		
		if(ie.getSource()==c2)
		{
			baseOutput=Integer.parseInt(c2.getSelectedItem());
		//	//System.out.println("base Output = "+baseOutput);		
		}
	}

	public static void main(String args[])
	{
		BaseConvertor object=new BaseConvertor();
	}
}