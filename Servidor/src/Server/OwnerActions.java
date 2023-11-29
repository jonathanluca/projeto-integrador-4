package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerActions {

    public static void authValidate(String email, String password, ObjectOutputStream output) throws IOException {

        boolean auth = false;

        try (Connection connection = Database.getConnection()) {
            String query = "SELECT senha FROM usuarios WHERE email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("senha");

                        auth = password.equals(storedPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        output.writeBoolean(auth);
    }
}
