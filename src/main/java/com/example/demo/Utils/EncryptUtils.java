package com.example.demo.Utils;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtils {

	public static String encriptar(String input) {
		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		//ESTA CLAVE ESTA COMO VARIABLE DE ENTORNO EN EL IDE (POR MOTIVOS DE SEGURIDAD)
		String encryptionKey = System.getenv("ENCRYPTION_KEY");
		textEncryptor.setPassword(encryptionKey);
		return textEncryptor.encrypt(input);
	}

	public static String desencriptar(String input) {
		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		//ESTA CLAVE ESTA COMO VARIABLE DE ENTORNO EN EL IDE (POR MOTIVOS DE SEGURIDAD)
		String encryptionKey = System.getenv("ENCRYPTION_KEY");
		textEncryptor.setPassword(encryptionKey);
		return textEncryptor.decrypt(input);
	}

}
