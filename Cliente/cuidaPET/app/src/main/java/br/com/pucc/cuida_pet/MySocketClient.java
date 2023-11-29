package br.com.pucc.cuida_pet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import br.com.pucc.cuida_pet.data.Pet;

public class MySocketClient {
    Socket conexao;

    public MySocketClient() throws IOException {
    }

    private void openConection() throws IOException {
        conexao = new Socket("IP DO PC", 3000); // IP e porta que o programa tá rodando
    }
    private void closeConection() throws IOException {
        conexao.close();
    }
    public ArrayList<Pet> getAllPets(int userId) throws IOException, ClassNotFoundException {
        openConection();
        // Recebedor
        ObjectInputStream resposta = new ObjectInputStream(conexao.getInputStream());

        ArrayList<Pet> listaDePet;
        listaDePet = (ArrayList<Pet>) resposta.readObject();
        resposta.close();

        closeConection();
        return listaDePet;
    }
    public Boolean login(String email, String senha) {
        openConection();
        // Enviador
        ObjectOutputStream envio = new ObjectOutputStream(conexao.getOutputStream());
        envio.writeBytes("verificar-login | " + email + " | " + senha);
        envio.flush();
        
        // Recebedor
        ObjectInputStream resposta = new ObjectInputStream(conexao.getInputStream());

        envio.close();
        closeConection();
        resposta.close();

        return resposta;

    }
    public boolean updatePet(Pet pet) throws IOException {
        openConection();
        ObjectOutputStream envio = new ObjectOutputStream(conexao.getOutputStream());
        envio.writeObject(pet);
        envio.flush();

        envio.close();
        closeConection();


        return true;
    }
    public void deletePet(String nome) throws IOException {
        openConection();
        ObjectOutputStream envio = new ObjectOutputStream(conexao.getOutputStream());
        envio.writeObject(nome);
        envio.flush();

        envio.close();
        closeConection();
    }
}
