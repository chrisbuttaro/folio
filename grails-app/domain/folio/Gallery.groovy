package folio

import org.example.User

class Gallery {

    String name
    int likes
    byte [] coverImage
    static hasMany = [images: Image, comments: Comment]
    static belongsTo = [user: User]

    static constraints = {
        coverImage(nullable:true, size: 1..100000)
        images(nullable: true)
        comments(nullable: true)
        likes(nullable: true)
        user(nullable: false)
        name(nullable: false)
    }
}
