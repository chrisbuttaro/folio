package folio

import org.example.User

class Image {
    String name
    boolean featured
    Date createdOn
    byte[] src
    int likes


static hasMany = [comments: Comment, items:PurchaseItem, galleries: Gallery]
static belongsTo = [user: User]


    static constraints = {
        createdOn(nullable: false)
        name(nullable: false)
        src(nullable: false)
        likes(nullable: true)
        comments(nullable: true)
        items(nullable: true)
        galleries(nullable: true)
        user(nullable: false)
    }
}
