package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;

public class PetActions {

    public static void listUserPets(int idOwner, ObjectOutputStream output) throws IOException {
        ArrayList<Pet> userPets = new ArrayList<>();

        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM pets WHERE idUser = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Parâmetros para a consulta
                preparedStatement.setInt(1, idOwner);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Pet pet = new Pet();
                        pet.setIdPet(resultSet.getInt("idPet"));
                        pet.setNome(resultSet.getString("nome"));
                        pet.setLinkFoto(resultSet.getString("linkFoto"));
                        pet.setEspecie(resultSet.getString("especie"));
                        pet.setRaca(resultSet.getString("raca"));
                        pet.setIdade(resultSet.getInt("idade"));
                        pet.setCor(resultSet.getString("cor"));
                        pet.setPeso(resultSet.getFloat("peso"));
                        pet.setIdUser(resultSet.getInt("idUser"));

                        userPets.add(pet);
                    }

                    output.writeObject(userPets);
                }
            }
        } catch (SQLException e) {
            output.writeBytes("Falha ao buscar sua lista de pets, tente novamente.");
            e.printStackTrace();
        }
    }

    public static void createPet (Pet pet, ObjectOutputStream output) throws IOException {
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

                    output.writeBytes("Pet cadastrado com sucesso!");
                }
        } catch (SQLException e) {
            output.writeBytes("Falha ao cadastrar pet, tente novamente.");
            e.printStackTrace();
        }
    }

    public static void editPet (Pet pet, ObjectOutputStream output) throws IOException {
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
                output.writeBytes("Pet edtado com sucesso!");
            }
        } catch (SQLException e) {
            output.writeBytes("Falha ao editar pet, tente novamente.");
            e.printStackTrace();
        }
    }

    public static void deletePet (Pet pet, ObjectOutputStream output) throws IOException {
        try (Connection connection = Database.getConnection()) {
            String query = "DELETE FROM pets WHERE id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, pet.getIdPet());
                preparedStatement.executeUpdate();

                output.writeBytes("Pet deletado com sucesso!");
            }
        } catch (SQLException e) {
            output.writeBytes("Falha ao deletar pet, tente novamente.");
            e.printStackTrace();
        }
    }

    private static ArrayList<Pet> listAllPets() throws IOException {
        ArrayList<Pet> allPets = new ArrayList<>();

        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM pets";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Pet pet = new Pet();
                        pet.setIdPet(resultSet.getInt("id"));
                        pet.setNome(resultSet.getString("nome"));
                        pet.setLinkFoto(resultSet.getString("linkFoto"));
                        pet.setEspecie(resultSet.getString("especie"));
                        pet.setRaca(resultSet.getString("raca"));
                        pet.setIdade(resultSet.getInt("idade"));
                        pet.setCor(resultSet.getString("cor"));
                        pet.setPeso(resultSet.getFloat("peso"));
                        pet.setIdUser(resultSet.getInt("idUser"));

                        allPets.add(pet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPets;
    }
}