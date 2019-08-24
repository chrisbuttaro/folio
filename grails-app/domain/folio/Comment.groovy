package folio

import org.example.User

class Comment {
    String text
    int stars
    static hasOne = [folio: Portfolio, gallery: Gallery, image: Image]
    static belongsTo = [user: User]

    static constraints = {
        folio(nullable: true)
        gallery(nullable: true)
        image(nullable: true)
        user(nullable: false)

    }
}
