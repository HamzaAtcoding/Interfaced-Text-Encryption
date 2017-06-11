package pkg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPage extends JFrame {
	public static String plainmsg="";
	public static String ciphermsg="";
	public MainPage() {
		
		// TODO Auto-generated constructor stub
		setTitle("Welcome to the Cipher Machine");
		setSize(800, 400);
		setLayout(new GridLayout(5, 0));
		
		JPanel one=new JPanel();
		one.setLayout(new GridLayout(0, 2));
		
		
		
		
		JLabel select_methods=new JLabel("Select Method");
		String[] techniques = new String[] {"","Caesar Cipher","Hill Cipher","Row Transpose Cipher"
				,"DES", "AES","RSA", "MD5","SHA-512"};
		JComboBox<String> methods = new JComboBox<>(techniques);
		
		
		
		
		one.add(select_methods);
		one.add(methods);
		
		
		
		JPanel two=new JPanel();
		two.setLayout(new GridLayout(0, 2));
		
		
		JLabel plain=new JLabel("Enter the plain text");
		JTextField plain_texfield=new JTextField();
		two.add(plain);
		two.add(plain_texfield);
		
		
		JPanel three=new JPanel();
		three.setLayout(new BorderLayout());
		
		
		JButton process=new JButton("Process");
		three.add(process);
		
		
		
		
		
		JPanel four=new JPanel();
		four.setLayout(new GridLayout(0, 2));
		
		JLabel cipher=new JLabel("Generated Cipher Text/Hash is ");
		JTextField cipher_texfield=new JTextField();
		four.add(cipher);
		four.add(cipher_texfield);
		
		
		JPanel five=new JPanel();
		five.setLayout(new GridLayout(0, 2));
		
		JLabel plain1=new JLabel("Generated Cipher Text/Hash is ");
		JTextField plain1_texfield=new JTextField();
		five.add(plain1);
		five.add(plain1_texfield);
		
		
		//JTextField plain=new JTextField();
		//JTextField cipher=new JTextField();
		//add(cipher);
		//add(plain);
		//add(methods);
		
		
process.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("The method you selected is " + methods.getSelectedItem());
				
						if(methods.getSelectedItem()=="Caesar Cipher")
						{
							CaesarCipher c=new CaesarCipher();
							//System.out.println("Caesar Cipher");
							String cipher=c.encode(plain_texfield.getText(), 12 );
							cipher_texfield.setText(cipher);
							plain1_texfield.setText(c.decode(cipher, 12));
							
						}
						if(methods.getSelectedItem()=="Hill Cipher")
						{
							System.out.println("Hill Cipher");
						}
						if(methods.getSelectedItem()=="Row Transpose Cipher")
						{
							System.out.println("Row Transpose Cipher");
							TranspositionCipher t=new TranspositionCipher();
							String encrypt=t.findTranspositionCipher(plain_texfield.getText());
							cipher_texfield.setText(encrypt);
							plain1_texfield.setText(t.DecryptTranspositionCipher(encrypt));
							
						}
						if(methods.getSelectedItem()=="DES")
						{
							//System.out.println("DES");
							//DES d;
							encrypt encryption;
							encryption= new encrypt(plain_texfield.getText(),"kWmHe8xIsDpfzK4d");
							
							try {
								encryption.DoEncryption();
								cipher_texfield.setText(encryption.getEncryption());
								encryption.DoDecryption(); 
								plain1_texfield.setText(encryption.getDecryption());
								//d = new DES();
								//d.start(plain_texfield.getText());
								//cipher_texfield.setText(ciphermsg);
								//plain1_texfield.setText(plainmsg);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						if(methods.getSelectedItem()=="AES")
						{
							String cipher="";
							//System.out.println("AES");
							AES a=new AES();
							try {
								a.setKey("kWmHe8xIsDpfzK4d");
								cipher=a.Encrypt(plain_texfield.getText());
								cipher_texfield.setText(cipher);
								plain1_texfield.setText(a.Decrypt(cipher));
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println(plainmsg + ciphermsg);
						}
						if(methods.getSelectedItem()=="RSA")
						{
							//System.out.println("RSA");
							//RSA r = new RSA();
							RSA r=new RSA();
							byte[] encrypted;
							byte[] decrypted;
							try {
								encrypted = r.encrypt(plain_texfield.getText().getBytes());
								cipher_texfield.setText(new String(encrypted));
								decrypted = r.decrypt(encrypted);
								plain1_texfield.setText(new String(decrypted));
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						if(methods.getSelectedItem()=="MD5")
						{
							//System.out.println("MD5");
							MD5 m=new MD5();
							cipher_texfield.setText(m.getMD5(plain_texfield.getText()));
							plain1_texfield.setText("");
							
							
						}
						if(methods.getSelectedItem()=="SHA-512")
						{
							String shaencrypt="";
							SHA512 s=new SHA512();
							try {
								//cipher_texfield.setText(s.GenerateHash(plain_texfield.getText()));
								//System.out.println("fdfdfd" + s.GenerateHash(plain_texfield.getText()));
								//plain1_texfield.setText("");
								
								shaencrypt = s.getSHAhash(plain_texfield.getText());
								cipher_texfield.setText(new String(shaencrypt));
								//shadecrypt=sha_plain_textPane.getText();
							} catch (NoSuchAlgorithmException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				});
				
				
		
		
		
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		setVisible(true);
		
		
		
		
	}
	public static void set(String p,String c)
	{
		plainmsg=p;
		ciphermsg=c;
	}
	
	public static void main(String [] agrs)
	{
		new MainPage();
	}

}
