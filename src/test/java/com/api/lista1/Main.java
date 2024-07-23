package com.api.lista1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();

        String endereco = getEnderecoByCep(cep);
        if (endereco == null) {
            System.out.println("CEP inválido ou não encontrado.");
            return;
        }
System.out.println("Endereço encontrado: " + endereco);
        System.out.print("Você confirma este endereço? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (!confirmacao.equalsIgnoreCase("s")) {
            System.out.println("Operação cancelada.");
            return;
        }

        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String enderecoCompleto = endereco + ", " + numero + ", " + complemento;

        System.out.println("\nDados fornecidos:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Endereço: " + enderecoCompleto);
    }

    private static String getEnderecoByCep(String cep) {
        Request request = new Request.Builder()
                .url("https://viacep.com.br/ws/" + cep + "/json/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;

            JSONObject json = new JSONObject(response.body().string());
            if (json.has("erro")) return null;
return json.getString("logradouro") + ", " + json.getString("bairro") + ", " + json.getString("localidade") + ", " + json.getString("uf");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}