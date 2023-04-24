package helper;

import javax.swing.JOptionPane;

public class Helper {

	public static void showWsg(String msg) {
		
		
		switch (msg) {
		case "error": {
			msg="Islem tamamlanamadı Hat Olustu";
			JOptionPane.showMessageDialog(null, msg,"Mesaj",JOptionPane.ERROR_MESSAGE);
		break;
		}
		case "success": {
			msg="Islem basari ile gerceklesti";
			JOptionPane.showMessageDialog(null, msg,"Mesaj",JOptionPane.INFORMATION_MESSAGE);
		break;
		}
		default:
			JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	
	
	public static boolean confirm(String msg) {
		
		switch (msg) {
		case "sure":
			msg="Bu islemi gerceklestirmek istiyormusunuz ??";
			 
			break;

		default:
			break;
		}
		
	int res=	JOptionPane.showConfirmDialog(null, msg,"DİKKAT",JOptionPane.YES_NO_CANCEL_OPTION);
		if(res==0) {
			return true;
			
		}else {

			return false;
		}
		
	}
	                                           
	
	
	
	
	
	
	
	
	
	
	
	
}
