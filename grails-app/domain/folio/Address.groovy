package folio

import org.example.User

class Address {
    String firstName
    String lastName
    String country
    String city
    String state
    int zip

    static hasOne = [purchase: Purchase, user: User]

    static constraints = {
        firstName(nullable: false)
        lastName(nullable: false)
        country(nullable: false)
        city(nullable: false)
        state(nullable: false)
        firstName(nullable: false)
        purchase(nullable: true)
        user(nullable: true)
    }
}