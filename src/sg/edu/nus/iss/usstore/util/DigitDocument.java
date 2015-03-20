package sg.edu.nus.iss.usstore.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
 * digit input limited for JTextField
 * or with limited length of input
 * 
 * For example:
 * JTextField jtf = new JTextField(new DigitDocument());
 * or limits assigned length using int parameter,
 * jtf = new JTextField(new DigitDocument(4));
 * 
 * @ XIE JIABAO
 */

public class DigitDocument extends PlainDocument{
	
	private int limitedLength;
	
	public DigitDocument(){
		super();
	}
	
	public DigitDocument(int length){
		super();
		this.limitedLength = length;
	}
	
	@Override
	public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
		if(str == null){
			return;
		}
		if(limitedLength<=0){
			char[] upper = str.toCharArray();  
            int length = 0;  
            for (int i = 0; i < upper.length; i++)
            {  
                if (Character.isDigit(upper[i]))
                {  
                    upper[length++] = upper[i];  
                }  
            }  
            super.insertString(offset, new String(upper,0,length),a);
		}else{
			if(this.getLength()+str.length()<=limitedLength){
				char[] upper = str.toCharArray();  
				int length = 0;  
				Character dot = new Character('.');
				for (int i = 0; i < upper.length; i++)
				{  
					if (Character.isDigit(upper[i])||dot.equals(upper[i]))
					{  
						upper[length++] = upper[i];  
					}  
				}  
				super.insertString(offset, new String(upper,0,length),a);
			}
		}
	}

	public int getLimitedLength() {
		return limitedLength;
	}
}
