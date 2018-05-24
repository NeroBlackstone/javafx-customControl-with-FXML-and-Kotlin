package sample

import javafx.beans.property.StringProperty
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import kotlin.system.exitProcess

//create controller extend VBox as a custom control
class CustomControl : VBox() {
    //this custom control has a property named "text" so we can use "text" attribute in FXML file
    //<CustomControl text="Hello World"/>
    var text: String
        get() = textProperty().get()
        set(value) = textProperty().set(value)
    @FXML
    private lateinit var textField: TextField
    @FXML
    fun doSomething()= println("The button was clicked!")
    init {
        //load FXML file, and set CustomControl as root and controller
        FXMLLoader(javaClass.getResource("custom_control.fxml")).apply {
            //"this" point to FXMLLoader,but we need set CustomControl as root and controller,so,use this@CustomControl
            setRoot(this@CustomControl)
            setController(this@CustomControl)
            load()
        }
    }
    //get textProperty of textField
    private fun textProperty(): StringProperty =textField.textProperty()
}
