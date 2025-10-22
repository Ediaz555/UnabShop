package me.edsondiaz.unabshop

import android.R
import android.util.Patterns

//retornar un true si es valido y un false si  no es valido
//tambien retornar una cadena que me diga que paso si no es valido
fun validateEmail(email: String): Pair<Boolean, String>{
    return when{
        email.isEmpty()-> Pair(false, "el correo es requerido")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches()-> Pair(false, "el correo es invalido")
        !email.endsWith("@test.com")-> Pair(false, "ese email no es corporativo")
        else->{
            Pair(true,"")
        }
    }
}
fun validatePassword(password: String):Pair<Boolean, String>{
    return when{
        password.isEmpty()-> Pair(false, "el contraseña es requerida")
        password.length < 6 -> Pair(false, "la contrasseña debe tener al menos 6 caracteres")
        !password.any{it.isDigit()}-> Pair(false, "la contraseña debe tener al menos un digito")
        else-> Pair (true, "")
    }

}
fun validateName (name: String):Pair<Boolean, String>{
    return when{
        name.isEmpty()-> Pair(false, "el nombre es requerido")
        name.length < 6 -> Pair(false, "el nombre debe tener al menos 6 caracteres")
        else-> Pair (true, "")
    }
}

fun validateConfirmPassword(password: String,confirmPassword: String):Pair<Boolean, String> {
    return when {
        confirmPassword.isEmpty() -> Pair(false, "el contraseña es requerida")
        confirmPassword != password -> Pair(false, "las contraseñas no coinciden")
        else -> Pair(true, "")
    }
}