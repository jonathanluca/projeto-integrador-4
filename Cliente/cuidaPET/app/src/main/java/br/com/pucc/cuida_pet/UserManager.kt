package br.com.pucc.cuida_pet

import android.content.Context
import android.content.SharedPreferences

class UserManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Método para registrar um novo usuário
    fun registerUser(username: String, email: String, phone: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("email", email)
        editor.putString("phone", phone)
        editor.putString("password", password) // Armazenar a senha diretamente (não recomendado na prática real)
        editor.apply()
    }

    // Método para verificar as credenciais do usuário durante o login
    fun loginUser(email: String, password: String): Boolean {
        val storedEmail = sharedPreferences.getString("email", "")
        val storedPassword = sharedPreferences.getString("password", "")

        return email == storedEmail && password == storedPassword
    }

    // Método para verificar se o usuário está logado
    fun isLoggedIn(): Boolean {
        return sharedPreferences.contains("email") && sharedPreferences.contains("password")
    }

    // Método para deslogar o usuário
    fun logoutUser() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    // Métodos para obter informações do usuário após o login
    fun getUsername(): String {
        return sharedPreferences.getString("username", "") ?: ""
    }

    fun getEmail(): String {
        return sharedPreferences.getString("email", "") ?: ""
    }

    fun getPhone(): String {
        return sharedPreferences.getString("phone", "") ?: ""
    }
}
