package com.api.lista1;

public class Validacao {
    private static boolean isValidCPF(String cpf) {
        return cpf.matches("");
    }
    
    private static boolean isValidPhone(String phone) {
        return phone.matches("");
    }
    
    private static boolean isValidEmail(String email) {
        return email.matches("");
    }
    do {
        System.out.print("Digite o CPF: ");
        cpf = scanner.nextLine();
    } while (!isValidCPF(cpf));
    
    do {
        System.out.print("Digite o telefone: ");
        telefone = scanner.nextLine();
    } while (!isValidPhone(telefone));
    
    do {
        System.out.print("Digite o email: ");
        email = scanner.nextLine();
    } while (!isValidEmail(email));

}
