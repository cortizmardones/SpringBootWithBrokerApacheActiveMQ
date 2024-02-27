package com.example.demo.test;

import org.jasypt.util.text.AES256TextEncryptor;

public class UtilsEncriptacionTest {

	public static void main(String[] args) {

		String input_a_encriptar = "admin";

		String textoEncriptado = encriptar(input_a_encriptar);
		desencriptar(textoEncriptado);
	}

	private static String encriptar(String input) {
		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		textEncryptor.setPassword("PALABRA_SECRETA#");
		System.out.println("Texto Encriptado :" + textEncryptor.encrypt(input));
		return textEncryptor.encrypt(input);
	}

	private static String desencriptar(String input) {

		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		textEncryptor.setPassword("PALABRA_SECRETA#");
		System.out.println("Texto Desencriptado: " + textEncryptor.decrypt(input));
		return textEncryptor.decrypt(input);

	}

}
