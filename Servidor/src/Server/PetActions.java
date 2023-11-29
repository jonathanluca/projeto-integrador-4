package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetActions {
    public static ArrayList<Pet> listPets(String username, ObjectOutputStream output) throws IOException {
        ArrayList<Pet> pets = new ArrayList<>();

        output.writeObject(pets);
        return pets;
    }

    public static Pet createPet (Pet pet, ObjectOutputStream output) throws IOException {
        try (Connection connection = Database.getConnection()) {
                String query = "INSERT INTO pets (nome, linkFoto, especie, raca, idade, cor, peso, idUser) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ((PreparedStatement) preparedStatement).setString(1, pet.getNome());
                    preparedStatement.setString(2, pet.getLinkFoto());
                    preparedStatement.setString(3, pet.getEspecie());
                    preparedStatement.setString(4, pet.getRaca());
                    preparedStatement.setInt(5, pet.getIdade());
                    preparedStatement.setString(6, pet.getCor());
                    preparedStatement.setFloat(7, pet.getPeso());
                    preparedStatement.setInt(8, pet.getIdUser());

                    preparedStatement.executeUpdate();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        output.writeObject(pet);
        return pet;
    }

    public static Pet editPet (Pet pet, ObjectOutputStream output) throws IOException {
        try (Connection connection = Database.getConnection()) {
            String query = "UPDATE pets SET nome=?, linkFoto=?, especie=?, raca=?, idade=?, cor=?, peso=? WHERE id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, pet.getNome());
                preparedStatement.setString(2, pet.getLinkFoto());
                preparedStatement.setString(3, pet.getEspecie());
                preparedStatement.setString(4, pet.getRaca());
                preparedStatement.setInt(5, pet.getIdade());
                preparedStatement.setString(6, pet.getCor());
                preparedStatement.setFloat(7, pet.getPeso());
                preparedStatement.setInt(8, pet.getIdPet());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        output.writeObject(pet);
        return pet;
    }

    public static Pet deletePet (Pet pet, ObjectOutputStream output) throws IOException {
        try (Connection connection = Database.getConnection()) {
            String query = "DELETE FROM pets WHERE id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, pet.getIdPet());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        output.writeObject(pet);
        return pet;
    }
}