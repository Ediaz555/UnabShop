package me.edsondiaz.unabshop.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import me.edsondiaz.unabshop.data.ProductoRepository
import me.edsondiaz.unabshop.model.Producto

class ProductoViewModel : ViewModel() {

    private val repository = ProductoRepository()

    var listaProductos = mutableStateOf<List<Producto>>(emptyList())
        private set

    var cargando = mutableStateOf(false)
        private set

    fun cargarProductos() {
        cargando.value = true
        repository.obtenerProductos {
            listaProductos.value = it
            cargando.value = false
        }
    }

    fun agregarProducto(nombre: String, descripcion: String, precio: Double) {
        val producto = Producto(nombre = nombre, descripcion = descripcion, precio = precio)
        repository.agregarProducto(producto) { exito ->
            if (exito) cargarProductos()
        }
    }

    fun eliminarProducto(id: String) {
        repository.eliminarProducto(id) { exito ->
            if (exito) cargarProductos()
        }
    }
}