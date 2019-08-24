package folio

import org.example.User
import org.springframework.validation.ObjectError

class UserController {

    def springSecurityService

    static scaffold = User

    def register() {
        def urc = new UserRegisterCommand()
        render view: "register", model: [urc: urc]
    }

    def login() {
        def ulc = new UserLoginCommand()
        render view: "login", model: [ulc: ulc]
    }

    def loginUser(UserLoginCommand ulc) {
        User user = User.findByUsername(ulc.username)
        if (user && ulc.password && user.password == ulc.password) {
            session.setAttribute("user", user)
            redirect controller: "portfolio", action: "folio",
                    params: [id: "$user.username"], model:[galleries:user.galleries]

        } else {
            ulc.errors.reject("Incorrect Login or Password")
            render view: "login", model: [ulc: ulc]
        }

    }


    def registerUser(UserRegisterCommand urc) {
        if (urc.password != urc.secondPassword) {
            urc.errors.reject("Passwords do not match")
        }
        if (urc.hasErrors()) {
            render view: "register", model: [urc: urc]
        } else {
            def user = new User(urc.properties)
            //user.password = springSecurityService.encodePassword(urc.password)
            session.setAttribute("user", user)
            user.profile = new Profile(urc.properties)
            user.profile.user = user
            if (user.validate() && user.save() && urc.password == urc.secondPassword) {
                flash.message = "Welcome aboard, ${urc.firstName ?: urc.username}"
                redirect controller: "portfolio", action: "folio",
                        params: [id: "$user.username"], model:[galleries:user.galleries]
            } else {
                render view: "register", model: [urc: urc, user:user]
            }
        }
    }

    def getUserByUserName(String username) {
        User user = User.findByUsername(username)
        return user
    }

}


class UserRegisterCommand {
    String username
    String password
    String email
    String firstName
    String lastName
    String secondPassword

    static constraints = {
        importFrom User
        importFrom Profile

    }
}

class UserLoginCommand {
    String username
    String password
}