package folio

import org.example.User

class PurchaseItem {

    String type
    double price
    double averageStars
    boolean inStock
    int unitsAvailable

    static belongsTo = [user: User]
    static hasMany = [images: Image, purchases: Purchase]

    static constraints = {
        user(nullable: false)
        purchases(nullable: true)
        images(nullable: true)

    }
}
