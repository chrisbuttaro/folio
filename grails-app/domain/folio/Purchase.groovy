package folio

import org.example.User

class Purchase {

    Date created
    String email

    static hasOne = [item: PurchaseItem, address: Address]

    static belongsTo = [user: User]

    static constraints = {
        user(nullable: true)
        address(nullable: false)
        email(nullable: false)
    }
}
