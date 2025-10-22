package me.edsondiaz.unabshop

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun NavigationAPP() {
    val mynavController = rememberNavController()
    var mystartDestination: String = "Login"

    val auth = Firebase.auth
    val currentUser = auth.currentUser

    if (currentUser != null) {
        mystartDestination = "home"
    } else {
        mystartDestination = "login"
    }
    NavHost(
        navController=mynavController,
        startDestination = mystartDestination
    ) {
        composable(route = "Login") {
            LoginScreen(onClickRegister ={
                mynavController.navigate("Register")
            }, onSuccesfulLogin ={
                mynavController.navigate("home"){
                    popUpTo("Login"){inclusive=true}
                }
            } )
        }
        composable(route = "Register") {
            RegisterScreen(onClickBack = {
                mynavController.popBackStack()
            }, onSuccesfulRegister = {
                mynavController.navigate("home"){
                    popUpTo(0)
                }
            })
        }
        composable(route = "Home") {
            HomeScreen(onClickLogout ={
                mynavController.navigate("login"){
                    popUpTo(0)
                }
            } )
        }


    }
}