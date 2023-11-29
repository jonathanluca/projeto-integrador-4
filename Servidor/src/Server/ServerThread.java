package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

class ServerThread extends Thread {
    private Socket socket;

    private ArrayList<Pet> petsList;
    private ArrayList<DonoPet> donoPetList;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream((socket.getOutputStream()));
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                if (bytesRead == -1) {
                    break;
                }
                Generic generic = (Generic) input.readObject();
                DonoPet donoPet = null;
                Pet pet = null;

                String[] params = input.readUTF().split("|");

                for (int i = 0; i < params.length; i++) {
                    params[i] = params[i].trim();
                }

//                if (generic.objectType.equals("DonoPet")) {
//                    donoPet = (DonoPet) generic.object;
//                } else if (generic.objectType.equals("Pet")) {
//                    pet = (Pet) generic.object;
//                } else {
//                    break;
//                }

                switch (params[0]) {
//                    case "listar-pets":
//                        PetActions.listUserPets(pet.getIdUser(), output);
//                        break;
//                    case "criar-pet":
//                        PetActions.createPet(pet, output);
//                        break;
//                    case "editar-pet":
//                        PetActions.editPet(pet, output);
//                        break;
//                    case "deletar-pet":
//                        PetActions.deletePet(pet, output);
//                        break;
                    case "verificar-login":
                        OwnerActions.authValidate(params[1], params[2], output);
                        break;
                }

            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}