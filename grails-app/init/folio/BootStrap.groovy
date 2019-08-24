package folio
import org.example.User
class BootStrap {

    def init = { servletContext ->

       // new rewards.Product(name: "Morning Blend", sku: "MB01", price: 14.95).save()

        User user = new User(username:"chris", password:"a", email:"chris@gmail.com")
        user.save()
    }
    def destroy = {
    }
}
