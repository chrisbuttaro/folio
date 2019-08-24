package folio

import org.example.User

class Profile {

    byte [] profilePic
    String firstName
    String lastName
    String aboutMe

    static belongsTo = [user: User]

    static constraints = {
        firstName(nullable: false)
        lastName(nullable: false)
        profilePic(nullable: true)
        aboutMe(nullable: true)

    }
}
