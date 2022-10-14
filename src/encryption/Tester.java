package encryption;

import java.text.NumberFormat;
import util.FileAsStringReader;

public class Tester {

	private enum solutionOptions { simpleText, dataFile };
	
	public static void workTheExample(String input, solutionOptions option) {
	
        String encryptedMessage;
        String decryptedMessage;
        double encryptedMessageLength = 0;
        double  decryptedMessageLength = 0;
        double percentageEncryptedOverhead = 0;
        AES aes;
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        
        try {
            aes = new AES();
            aes.init();
			switch(option) {
				case simpleText:
					System.out.println("Simple Text Encryption Example...");
					System.out.println("Test text: " + input);

					encryptedMessage = aes.encrypt(input);
		            decryptedMessage = aes.decrypt(encryptedMessage);
		            
		            encryptedMessageLength = encryptedMessage.length();
		            decryptedMessageLength = decryptedMessage.length();
		            percentageEncryptedOverhead = (float) ((encryptedMessageLength - decryptedMessageLength)/encryptedMessageLength);

		            System.out.println("Encrypted Message: " + encryptedMessage);
		            System.out.println("Encrypted Message - number of bytes: " + encryptedMessageLength);
		            System.out.println("Decrypted Message: " + decryptedMessage);
		            System.out.println("Decrypted Message - number of bytes: " + decryptedMessageLength);
		            
		    		defaultFormat.setMinimumFractionDigits(2);
		            System.out.println("Encryption Overhead Percentage: " + defaultFormat.format(percentageEncryptedOverhead));

					break;
				case dataFile:
					System.out.println("Text File Encryption Example...");
					System.out.println("Test Input file: " + input);

					encryptedMessage = aes.encrypt(FileAsStringReader.readFileAsString(input));
		            decryptedMessage = aes.decrypt(encryptedMessage);
		            
		            encryptedMessageLength = encryptedMessage.length();
		            decryptedMessageLength = decryptedMessage.length();
		            percentageEncryptedOverhead = (float) ((encryptedMessageLength - decryptedMessageLength)/encryptedMessageLength);

		            System.out.println("Encrypted Message - number of bytes: " + encryptedMessage.length());
		            System.out.println("Decrypted Message - number of bytes: " + decryptedMessage.length());
		            
		    		defaultFormat.setMinimumFractionDigits(2);
		            System.out.println("Encryption Overhead Percentage: " + defaultFormat.format(percentageEncryptedOverhead));

					break;
				default:
					System.out.println("Valid Solution Not Specified");
					return;
			}
        } catch (Exception ignored) {
        }
	}

	public static void main(String[] args) {
    	//workTheExample("Test StringTest StringTest StringTest StringTest String", solutionOptions.simpleText);
    	//workTheExample("C:\\Users\\dsnyder\\git\\JavaNotions\\src\\encryption\\sample-2mb-text-file.txt", solutionOptions.simpleText);
    	workTheExample("C:\\Users\\dsnyder\\git\\JavaNotions\\src\\encryption\\PU Device DT Chat Setup V1.mp4", solutionOptions.dataFile);
    }
}
